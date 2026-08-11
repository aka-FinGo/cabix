package j$.time.chrono;

import j$.time.Clock;
import j$.time.DateTimeException;
import j$.time.Duration$DurationUnits$0;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.Month;
import j$.time.Year;
import j$.time.ZoneId;
import j$.time.format.ResolverStyle;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjusters;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.ValueRange;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class JapaneseChronology extends AbstractChronology implements Serializable {
    public static final JapaneseChronology INSTANCE = new JapaneseChronology();
    private static final long serialVersionUID = 459996390165777884L;

    private JapaneseChronology() {
    }

    @Override // j$.time.chrono.Chronology
    public String getId() {
        return "Japanese";
    }

    @Override // j$.time.chrono.Chronology
    public String getCalendarType() {
        return "japanese";
    }

    public JapaneseDate date(Era era, int i, int i2, int i3) {
        if (!(era instanceof JapaneseEra)) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        return JapaneseDate.of((JapaneseEra) era, i, i2, i3);
    }

    @Override // j$.time.chrono.Chronology
    public JapaneseDate date(int i, int i2, int i3) {
        return new JapaneseDate(LocalDate.of(i, i2, i3));
    }

    public JapaneseDate dateYearDay(Era era, int i, int i2) {
        return JapaneseDate.ofYearDay((JapaneseEra) era, i, i2);
    }

    @Override // j$.time.chrono.Chronology
    public JapaneseDate dateYearDay(int i, int i2) {
        return new JapaneseDate(LocalDate.ofYearDay(i, i2));
    }

    @Override // j$.time.chrono.Chronology
    public JapaneseDate dateEpochDay(long j) {
        return new JapaneseDate(LocalDate.ofEpochDay(j));
    }

    @Override // j$.time.chrono.Chronology
    public JapaneseDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    public JapaneseDate dateNow(Clock clock) {
        return date((TemporalAccessor) LocalDate.now(clock));
    }

    @Override // j$.time.chrono.Chronology
    public JapaneseDate date(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof JapaneseDate) {
            return (JapaneseDate) temporalAccessor;
        }
        return new JapaneseDate(LocalDate.from(temporalAccessor));
    }

    @Override // j$.time.chrono.Chronology
    public ChronoLocalDateTime localDateTime(TemporalAccessor temporalAccessor) {
        return super.localDateTime(temporalAccessor);
    }

    @Override // j$.time.chrono.Chronology
    public ChronoZonedDateTime zonedDateTime(TemporalAccessor temporalAccessor) {
        return super.zonedDateTime(temporalAccessor);
    }

    @Override // j$.time.chrono.Chronology
    public ChronoZonedDateTime zonedDateTime(Instant instant, ZoneId zoneId) {
        return super.zonedDateTime(instant, zoneId);
    }

    @Override // j$.time.chrono.Chronology
    public boolean isLeapYear(long j) {
        return IsoChronology.INSTANCE.isLeapYear(j);
    }

    @Override // j$.time.chrono.Chronology
    public int prolepticYear(Era era, int i) {
        if (!(era instanceof JapaneseEra)) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        JapaneseEra japaneseEra = (JapaneseEra) era;
        int year = (japaneseEra.getSince().getYear() + i) - 1;
        if (i == 1 || (year >= -999999999 && year <= 999999999 && year >= japaneseEra.getSince().getYear() && era == JapaneseEra.from(LocalDate.of(year, 1, 1)))) {
            return year;
        }
        Year.AnonymousClass3.m("Invalid yearOfEra value");
        return 0;
    }

    @Override // j$.time.chrono.Chronology
    public JapaneseEra eraOf(int i) {
        return JapaneseEra.of(i);
    }

    @Override // j$.time.chrono.Chronology
    public List eras() {
        return Duration$DurationUnits$0.m(JapaneseEra.values());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.time.chrono.JapaneseChronology$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoField;

        static {
            int[] iArr = new int[ChronoField.values().length];
            $SwitchMap$java$time$temporal$ChronoField = iArr;
            try {
                iArr[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.DAY_OF_YEAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ERA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // j$.time.chrono.Chronology
    public ValueRange range(ChronoField chronoField) {
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[chronoField.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                Year.AnonymousClass2.m("Unsupported field: ", chronoField);
                return null;
            case 5:
                return ValueRange.of(1L, JapaneseEra.shortestYearsOfEra(), 999999999 - JapaneseEra.getCurrentEra().getSince().getYear());
            case 6:
                return ValueRange.of(1L, JapaneseEra.shortestDaysOfYear(), ChronoField.DAY_OF_YEAR.range().getMaximum());
            case 7:
                return ValueRange.of(JapaneseDate.MEIJI_6_ISODATE.getYear(), 999999999L);
            case 8:
                return ValueRange.of(JapaneseEra.MEIJI.getValue(), JapaneseEra.getCurrentEra().getValue());
            default:
                return chronoField.range();
        }
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public JapaneseDate resolveDate(Map map, ResolverStyle resolverStyle) {
        return (JapaneseDate) super.resolveDate(map, resolverStyle);
    }

    @Override // j$.time.chrono.AbstractChronology
    ChronoLocalDate resolveYearOfEra(Map map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.ERA;
        Long l = (Long) map.get(chronoField);
        JapaneseEra eraOf = l != null ? eraOf(range(chronoField).checkValidIntValue(l.longValue(), chronoField)) : null;
        ChronoField chronoField2 = ChronoField.YEAR_OF_ERA;
        Long l2 = (Long) map.get(chronoField2);
        int checkValidIntValue = l2 != null ? range(chronoField2).checkValidIntValue(l2.longValue(), chronoField2) : 0;
        if (eraOf == null && l2 != null && !map.containsKey(ChronoField.YEAR) && resolverStyle != ResolverStyle.STRICT) {
            eraOf = JapaneseEra.values()[JapaneseEra.values().length - 1];
        }
        if (l2 != null && eraOf != null) {
            if (map.containsKey(ChronoField.MONTH_OF_YEAR) && map.containsKey(ChronoField.DAY_OF_MONTH)) {
                return resolveYMD(eraOf, checkValidIntValue, map, resolverStyle);
            }
            if (map.containsKey(ChronoField.DAY_OF_YEAR)) {
                return resolveYD(eraOf, checkValidIntValue, map, resolverStyle);
            }
        }
        return null;
    }

    private int prolepticYearLenient(JapaneseEra japaneseEra, int i) {
        return (japaneseEra.getSince().getYear() + i) - 1;
    }

    private ChronoLocalDate resolveYMD(JapaneseEra japaneseEra, int i, Map map, ResolverStyle resolverStyle) {
        JapaneseDate with;
        map.remove(ChronoField.ERA);
        map.remove(ChronoField.YEAR_OF_ERA);
        if (resolverStyle == ResolverStyle.LENIENT) {
            int prolepticYearLenient = prolepticYearLenient(japaneseEra, i);
            return date(prolepticYearLenient, 1, 1).plus(Math.subtractExact(((Long) map.remove(ChronoField.MONTH_OF_YEAR)).longValue(), 1L), (TemporalUnit) ChronoUnit.MONTHS).plus(Math.subtractExact(((Long) map.remove(ChronoField.DAY_OF_MONTH)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        int checkValidIntValue = range(chronoField).checkValidIntValue(((Long) map.remove(chronoField)).longValue(), chronoField);
        ChronoField chronoField2 = ChronoField.DAY_OF_MONTH;
        int checkValidIntValue2 = range(chronoField2).checkValidIntValue(((Long) map.remove(chronoField2)).longValue(), chronoField2);
        if (resolverStyle != ResolverStyle.SMART) {
            return date(japaneseEra, i, checkValidIntValue, checkValidIntValue2);
        }
        if (i < 1) {
            Month.AnonymousClass0.m("Invalid YearOfEra: ", i);
            return null;
        }
        int prolepticYearLenient2 = prolepticYearLenient(japaneseEra, i);
        try {
            with = date(prolepticYearLenient2, checkValidIntValue, checkValidIntValue2);
        } catch (DateTimeException unused) {
            with = this.date(prolepticYearLenient2, checkValidIntValue, 1).with(TemporalAdjusters.lastDayOfMonth());
        }
        if (with.getEra() == japaneseEra || with.get(ChronoField.YEAR_OF_ERA) <= 1 || i <= 1) {
            return with;
        }
        throw new DateTimeException("Invalid YearOfEra for Era: " + japaneseEra + " " + i);
    }

    private ChronoLocalDate resolveYD(JapaneseEra japaneseEra, int i, Map map, ResolverStyle resolverStyle) {
        map.remove(ChronoField.ERA);
        map.remove(ChronoField.YEAR_OF_ERA);
        if (resolverStyle == ResolverStyle.LENIENT) {
            int prolepticYearLenient = prolepticYearLenient(japaneseEra, i);
            return dateYearDay(prolepticYearLenient, 1).plus(Math.subtractExact(((Long) map.remove(ChronoField.DAY_OF_YEAR)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        ChronoField chronoField = ChronoField.DAY_OF_YEAR;
        return dateYearDay(japaneseEra, i, range(chronoField).checkValidIntValue(((Long) map.remove(chronoField)).longValue(), chronoField));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.time.chrono.AbstractChronology
    public Object writeReplace() {
        return super.writeReplace();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
