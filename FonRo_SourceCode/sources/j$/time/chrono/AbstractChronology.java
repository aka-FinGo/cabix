package j$.time.chrono;

import androidx.exifinterface.media.ExifInterface;
import j$.time.DateTimeException;
import j$.time.DayOfWeek;
import j$.time.Year;
import j$.time.format.ResolverStyle;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalAdjusters;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalUnit;
import java.io.DataInput;
import java.io.DataOutput;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public abstract class AbstractChronology implements Chronology {
    private static final ConcurrentHashMap CHRONOS_BY_ID = new ConcurrentHashMap();
    private static final ConcurrentHashMap CHRONOS_BY_TYPE = new ConcurrentHashMap();
    private static final Locale JAPANESE_CALENDAR_LOCALE = new Locale("ja", "JP", "JP");

    static Chronology registerChrono(Chronology chronology) {
        return registerChrono(chronology, chronology.getId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Chronology registerChrono(Chronology chronology, String str) {
        String calendarType;
        Chronology chronology2 = (Chronology) CHRONOS_BY_ID.putIfAbsent(str, chronology);
        if (chronology2 == null && (calendarType = chronology.getCalendarType()) != null) {
            CHRONOS_BY_TYPE.putIfAbsent(calendarType, chronology);
        }
        return chronology2;
    }

    private static boolean initCache() {
        if (CHRONOS_BY_ID.get(ExifInterface.TAG_RW2_ISO) != null) {
            return false;
        }
        registerChrono(HijrahChronology.INSTANCE);
        registerChrono(JapaneseChronology.INSTANCE);
        registerChrono(MinguoChronology.INSTANCE);
        registerChrono(ThaiBuddhistChronology.INSTANCE);
        Iterator it = ServiceLoader.load(AbstractChronology.class, null).iterator();
        while (it.hasNext()) {
            AbstractChronology abstractChronology = (AbstractChronology) it.next();
            if (!abstractChronology.getId().equals(ExifInterface.TAG_RW2_ISO)) {
                registerChrono(abstractChronology);
            }
        }
        registerChrono(IsoChronology.INSTANCE);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Chronology ofLocale(Locale locale) {
        Objects.requireNonNull(locale, "locale");
        String calendarType = getCalendarType(locale);
        if (calendarType == null || "iso".equals(calendarType) || "iso8601".equals(calendarType)) {
            return IsoChronology.INSTANCE;
        }
        do {
            Chronology chronology = (Chronology) CHRONOS_BY_TYPE.get(calendarType);
            if (chronology != null) {
                return chronology;
            }
        } while (initCache());
        Iterator it = ServiceLoader.load(Chronology.class).iterator();
        while (it.hasNext()) {
            Chronology chronology2 = (Chronology) it.next();
            if (calendarType.equals(chronology2.getCalendarType())) {
                return chronology2;
            }
        }
        Year.AnonymousClass3.m("Unknown calendar system: ".concat(calendarType));
        return null;
    }

    private static String getCalendarType(Locale locale) {
        String unicodeLocaleType = locale.getUnicodeLocaleType("ca");
        if (unicodeLocaleType != null) {
            return unicodeLocaleType;
        }
        if (locale.equals(JAPANESE_CALENDAR_LOCALE)) {
            return "japanese";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Chronology of(String str) {
        Objects.requireNonNull(str, "id");
        do {
            Chronology of0 = of0(str);
            if (of0 != null) {
                return of0;
            }
        } while (initCache());
        Iterator it = ServiceLoader.load(Chronology.class).iterator();
        while (it.hasNext()) {
            Chronology chronology = (Chronology) it.next();
            if (str.equals(chronology.getId()) || str.equals(chronology.getCalendarType())) {
                return chronology;
            }
        }
        Year.AnonymousClass3.m("Unknown chronology: ".concat(str));
        return null;
    }

    private static Chronology of0(String str) {
        Chronology chronology = (Chronology) CHRONOS_BY_ID.get(str);
        return chronology == null ? (Chronology) CHRONOS_BY_TYPE.get(str) : chronology;
    }

    @Override // j$.time.chrono.Chronology
    public ChronoLocalDate resolveDate(Map map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (map.containsKey(chronoField)) {
            return dateEpochDay(((Long) map.remove(chronoField)).longValue());
        }
        resolveProlepticMonth(map, resolverStyle);
        ChronoLocalDate resolveYearOfEra = resolveYearOfEra(map, resolverStyle);
        if (resolveYearOfEra != null) {
            return resolveYearOfEra;
        }
        if (!map.containsKey(ChronoField.YEAR)) {
            return null;
        }
        if (map.containsKey(ChronoField.MONTH_OF_YEAR)) {
            if (map.containsKey(ChronoField.DAY_OF_MONTH)) {
                return resolveYMD(map, resolverStyle);
            }
            if (map.containsKey(ChronoField.ALIGNED_WEEK_OF_MONTH)) {
                if (map.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH)) {
                    return resolveYMAA(map, resolverStyle);
                }
                if (map.containsKey(ChronoField.DAY_OF_WEEK)) {
                    return resolveYMAD(map, resolverStyle);
                }
            }
        }
        if (map.containsKey(ChronoField.DAY_OF_YEAR)) {
            return resolveYD(map, resolverStyle);
        }
        if (!map.containsKey(ChronoField.ALIGNED_WEEK_OF_YEAR)) {
            return null;
        }
        if (map.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR)) {
            return resolveYAA(map, resolverStyle);
        }
        if (map.containsKey(ChronoField.DAY_OF_WEEK)) {
            return resolveYAD(map, resolverStyle);
        }
        return null;
    }

    void resolveProlepticMonth(Map map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.PROLEPTIC_MONTH;
        Long l = (Long) map.remove(chronoField);
        if (l != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                chronoField.checkValidValue(l.longValue());
            }
            ChronoLocalDate with = dateNow().with((TemporalField) ChronoField.DAY_OF_MONTH, 1L).with((TemporalField) chronoField, l.longValue());
            addFieldValue(map, ChronoField.MONTH_OF_YEAR, with.get(r0));
            addFieldValue(map, ChronoField.YEAR, with.get(r0));
        }
    }

    ChronoLocalDate resolveYearOfEra(Map map, ResolverStyle resolverStyle) {
        int intExact;
        ChronoField chronoField = ChronoField.YEAR_OF_ERA;
        Long l = (Long) map.remove(chronoField);
        if (l != null) {
            Long l2 = (Long) map.remove(ChronoField.ERA);
            if (resolverStyle != ResolverStyle.LENIENT) {
                intExact = range(chronoField).checkValidIntValue(l.longValue(), chronoField);
            } else {
                intExact = Math.toIntExact(l.longValue());
            }
            if (l2 != null) {
                addFieldValue(map, ChronoField.YEAR, prolepticYear(eraOf(range(r2).checkValidIntValue(l2.longValue(), r2)), intExact));
                return null;
            }
            ChronoField chronoField2 = ChronoField.YEAR;
            if (map.containsKey(chronoField2)) {
                addFieldValue(map, chronoField2, prolepticYear(dateYearDay(range(chronoField2).checkValidIntValue(((Long) map.get(chronoField2)).longValue(), chronoField2), 1).getEra(), intExact));
                return null;
            }
            if (resolverStyle == ResolverStyle.STRICT) {
                map.put(chronoField, l);
                return null;
            }
            if (eras().isEmpty()) {
                addFieldValue(map, chronoField2, intExact);
                return null;
            }
            addFieldValue(map, chronoField2, prolepticYear((Era) r9.get(r9.size() - 1), intExact));
            return null;
        }
        ChronoField chronoField3 = ChronoField.ERA;
        if (!map.containsKey(chronoField3)) {
            return null;
        }
        range(chronoField3).checkValidValue(((Long) map.get(chronoField3)).longValue(), chronoField3);
        return null;
    }

    ChronoLocalDate resolveYMD(Map map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.YEAR;
        int checkValidIntValue = range(chronoField).checkValidIntValue(((Long) map.remove(chronoField)).longValue(), chronoField);
        if (resolverStyle == ResolverStyle.LENIENT) {
            long subtractExact = Math.subtractExact(((Long) map.remove(ChronoField.MONTH_OF_YEAR)).longValue(), 1L);
            return date(checkValidIntValue, 1, 1).plus(subtractExact, (TemporalUnit) ChronoUnit.MONTHS).plus(Math.subtractExact(((Long) map.remove(ChronoField.DAY_OF_MONTH)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
        int checkValidIntValue2 = range(chronoField2).checkValidIntValue(((Long) map.remove(chronoField2)).longValue(), chronoField2);
        ChronoField chronoField3 = ChronoField.DAY_OF_MONTH;
        int checkValidIntValue3 = range(chronoField3).checkValidIntValue(((Long) map.remove(chronoField3)).longValue(), chronoField3);
        if (resolverStyle == ResolverStyle.SMART) {
            try {
                return date(checkValidIntValue, checkValidIntValue2, checkValidIntValue3);
            } catch (DateTimeException unused) {
                return this.date(checkValidIntValue, checkValidIntValue2, 1).with(TemporalAdjusters.lastDayOfMonth());
            }
        }
        return date(checkValidIntValue, checkValidIntValue2, checkValidIntValue3);
    }

    ChronoLocalDate resolveYD(Map map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.YEAR;
        int checkValidIntValue = range(chronoField).checkValidIntValue(((Long) map.remove(chronoField)).longValue(), chronoField);
        if (resolverStyle == ResolverStyle.LENIENT) {
            return dateYearDay(checkValidIntValue, 1).plus(Math.subtractExact(((Long) map.remove(ChronoField.DAY_OF_YEAR)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        ChronoField chronoField2 = ChronoField.DAY_OF_YEAR;
        return dateYearDay(checkValidIntValue, range(chronoField2).checkValidIntValue(((Long) map.remove(chronoField2)).longValue(), chronoField2));
    }

    ChronoLocalDate resolveYMAA(Map map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.YEAR;
        int checkValidIntValue = range(chronoField).checkValidIntValue(((Long) map.remove(chronoField)).longValue(), chronoField);
        if (resolverStyle == ResolverStyle.LENIENT) {
            long subtractExact = Math.subtractExact(((Long) map.remove(ChronoField.MONTH_OF_YEAR)).longValue(), 1L);
            return date(checkValidIntValue, 1, 1).plus(subtractExact, (TemporalUnit) ChronoUnit.MONTHS).plus(Math.subtractExact(((Long) map.remove(ChronoField.ALIGNED_WEEK_OF_MONTH)).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).plus(Math.subtractExact(((Long) map.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
        int checkValidIntValue2 = range(chronoField2).checkValidIntValue(((Long) map.remove(chronoField2)).longValue(), chronoField2);
        ChronoField chronoField3 = ChronoField.ALIGNED_WEEK_OF_MONTH;
        int checkValidIntValue3 = range(chronoField3).checkValidIntValue(((Long) map.remove(chronoField3)).longValue(), chronoField3);
        ChronoField chronoField4 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
        ChronoLocalDate plus = date(checkValidIntValue, checkValidIntValue2, 1).plus(((checkValidIntValue3 - 1) * 7) + (range(chronoField4).checkValidIntValue(((Long) map.remove(chronoField4)).longValue(), chronoField4) - 1), (TemporalUnit) ChronoUnit.DAYS);
        if (resolverStyle != ResolverStyle.STRICT || plus.get(chronoField2) == checkValidIntValue2) {
            return plus;
        }
        Year.AnonymousClass3.m("Strict mode rejected resolved date as it is in a different month");
        return null;
    }

    ChronoLocalDate resolveYMAD(Map map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.YEAR;
        int checkValidIntValue = range(chronoField).checkValidIntValue(((Long) map.remove(chronoField)).longValue(), chronoField);
        if (resolverStyle == ResolverStyle.LENIENT) {
            return resolveAligned(date(checkValidIntValue, 1, 1), Math.subtractExact(((Long) map.remove(ChronoField.MONTH_OF_YEAR)).longValue(), 1L), Math.subtractExact(((Long) map.remove(ChronoField.ALIGNED_WEEK_OF_MONTH)).longValue(), 1L), Math.subtractExact(((Long) map.remove(ChronoField.DAY_OF_WEEK)).longValue(), 1L));
        }
        ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
        int checkValidIntValue2 = range(chronoField2).checkValidIntValue(((Long) map.remove(chronoField2)).longValue(), chronoField2);
        ChronoField chronoField3 = ChronoField.ALIGNED_WEEK_OF_MONTH;
        int checkValidIntValue3 = range(chronoField3).checkValidIntValue(((Long) map.remove(chronoField3)).longValue(), chronoField3);
        ChronoField chronoField4 = ChronoField.DAY_OF_WEEK;
        ChronoLocalDate with = date(checkValidIntValue, checkValidIntValue2, 1).plus((checkValidIntValue3 - 1) * 7, (TemporalUnit) ChronoUnit.DAYS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(range(chronoField4).checkValidIntValue(((Long) map.remove(chronoField4)).longValue(), chronoField4))));
        if (resolverStyle != ResolverStyle.STRICT || with.get(chronoField2) == checkValidIntValue2) {
            return with;
        }
        Year.AnonymousClass3.m("Strict mode rejected resolved date as it is in a different month");
        return null;
    }

    ChronoLocalDate resolveYAA(Map map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.YEAR;
        int checkValidIntValue = range(chronoField).checkValidIntValue(((Long) map.remove(chronoField)).longValue(), chronoField);
        if (resolverStyle == ResolverStyle.LENIENT) {
            return dateYearDay(checkValidIntValue, 1).plus(Math.subtractExact(((Long) map.remove(ChronoField.ALIGNED_WEEK_OF_YEAR)).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).plus(Math.subtractExact(((Long) map.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        ChronoField chronoField2 = ChronoField.ALIGNED_WEEK_OF_YEAR;
        int checkValidIntValue2 = range(chronoField2).checkValidIntValue(((Long) map.remove(chronoField2)).longValue(), chronoField2);
        ChronoField chronoField3 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        ChronoLocalDate plus = dateYearDay(checkValidIntValue, 1).plus(((checkValidIntValue2 - 1) * 7) + (range(chronoField3).checkValidIntValue(((Long) map.remove(chronoField3)).longValue(), chronoField3) - 1), (TemporalUnit) ChronoUnit.DAYS);
        if (resolverStyle != ResolverStyle.STRICT || plus.get(chronoField) == checkValidIntValue) {
            return plus;
        }
        Year.AnonymousClass3.m("Strict mode rejected resolved date as it is in a different year");
        return null;
    }

    ChronoLocalDate resolveYAD(Map map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.YEAR;
        int checkValidIntValue = range(chronoField).checkValidIntValue(((Long) map.remove(chronoField)).longValue(), chronoField);
        if (resolverStyle == ResolverStyle.LENIENT) {
            return resolveAligned(dateYearDay(checkValidIntValue, 1), 0L, Math.subtractExact(((Long) map.remove(ChronoField.ALIGNED_WEEK_OF_YEAR)).longValue(), 1L), Math.subtractExact(((Long) map.remove(ChronoField.DAY_OF_WEEK)).longValue(), 1L));
        }
        ChronoField chronoField2 = ChronoField.ALIGNED_WEEK_OF_YEAR;
        int checkValidIntValue2 = range(chronoField2).checkValidIntValue(((Long) map.remove(chronoField2)).longValue(), chronoField2);
        ChronoField chronoField3 = ChronoField.DAY_OF_WEEK;
        ChronoLocalDate with = dateYearDay(checkValidIntValue, 1).plus((checkValidIntValue2 - 1) * 7, (TemporalUnit) ChronoUnit.DAYS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(range(chronoField3).checkValidIntValue(((Long) map.remove(chronoField3)).longValue(), chronoField3))));
        if (resolverStyle != ResolverStyle.STRICT || with.get(chronoField) == checkValidIntValue) {
            return with;
        }
        Year.AnonymousClass3.m("Strict mode rejected resolved date as it is in a different year");
        return null;
    }

    ChronoLocalDate resolveAligned(ChronoLocalDate chronoLocalDate, long j, long j2, long j3) {
        long j4;
        ChronoLocalDate plus = chronoLocalDate.plus(j, (TemporalUnit) ChronoUnit.MONTHS);
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        ChronoLocalDate plus2 = plus.plus(j2, (TemporalUnit) chronoUnit);
        if (j3 > 7) {
            long j5 = j3 - 1;
            plus2 = plus2.plus(j5 / 7, (TemporalUnit) chronoUnit);
            j4 = j5 % 7;
        } else {
            if (j3 < 1) {
                plus2 = plus2.plus(Math.subtractExact(j3, 7L) / 7, (TemporalUnit) chronoUnit);
                j4 = (j3 + 6) % 7;
            }
            return plus2.with(TemporalAdjusters.nextOrSame(DayOfWeek.of((int) j3)));
        }
        j3 = j4 + 1;
        return plus2.with(TemporalAdjusters.nextOrSame(DayOfWeek.of((int) j3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addFieldValue(Map map, ChronoField chronoField, long j) {
        Long l = (Long) map.get(chronoField);
        if (l != null && l.longValue() != j) {
            throw new DateTimeException("Conflict found: " + chronoField + " " + l + " differs from " + chronoField + " " + j);
        }
        map.put(chronoField, Long.valueOf(j));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // j$.time.chrono.Chronology, java.lang.Comparable
    public int compareTo(Chronology chronology) {
        return getId().compareTo(chronology.getId());
    }

    @Override // j$.time.chrono.Chronology
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbstractChronology) && compareTo((Chronology) obj) == 0;
    }

    @Override // j$.time.chrono.Chronology
    public int hashCode() {
        return getId().hashCode() ^ getClass().hashCode();
    }

    @Override // j$.time.chrono.Chronology
    public String toString() {
        return getId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) {
        dataOutput.writeUTF(getId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Chronology readExternal(DataInput dataInput) {
        return Chronology.of(dataInput.readUTF());
    }
}
