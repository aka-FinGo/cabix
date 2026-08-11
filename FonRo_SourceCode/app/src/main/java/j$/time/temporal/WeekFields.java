package j$.time.temporal;

import j$.time.DayOfWeek;
import j$.time.Duration;
import j$.time.Year;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.Chronology;
import j$.time.format.ResolverStyle;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
public final class WeekFields implements Serializable {
    private static final ConcurrentMap CACHE = new ConcurrentHashMap(4, 0.75f, 2);
    public static final WeekFields ISO = new WeekFields(DayOfWeek.MONDAY, 4);
    public static final WeekFields SUNDAY_START = of(DayOfWeek.SUNDAY, 1);
    public static final TemporalUnit WEEK_BASED_YEARS = IsoFields.WEEK_BASED_YEARS;
    private static final long serialVersionUID = -1177360819670808121L;
    private final DayOfWeek firstDayOfWeek;
    private final int minimalDays;
    private final transient TemporalField dayOfWeek = ComputedDayOfField.ofDayOfWeekField(this);
    private final transient TemporalField weekOfMonth = ComputedDayOfField.ofWeekOfMonthField(this);
    private final transient TemporalField weekOfYear = ComputedDayOfField.ofWeekOfYearField(this);
    private final transient TemporalField weekOfWeekBasedYear = ComputedDayOfField.ofWeekOfWeekBasedYearField(this);
    private final transient TemporalField weekBasedYear = ComputedDayOfField.ofWeekBasedYearField(this);

    public static WeekFields of(Locale locale) {
        Objects.requireNonNull(locale, "locale");
        return of(DayOfWeek.SUNDAY.plus(r4.getFirstDayOfWeek() - 1), Calendar.getInstance(new Locale(locale.getLanguage(), locale.getCountry())).getMinimalDaysInFirstWeek());
    }

    public static WeekFields of(DayOfWeek dayOfWeek, int i) {
        String str = dayOfWeek.toString() + i;
        ConcurrentMap concurrentMap = CACHE;
        WeekFields weekFields = (WeekFields) concurrentMap.get(str);
        if (weekFields != null) {
            return weekFields;
        }
        concurrentMap.putIfAbsent(str, new WeekFields(dayOfWeek, i));
        return (WeekFields) concurrentMap.get(str);
    }

    private WeekFields(DayOfWeek dayOfWeek, int i) {
        Objects.requireNonNull(dayOfWeek, "firstDayOfWeek");
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.firstDayOfWeek = dayOfWeek;
        this.minimalDays = i;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        if (this.firstDayOfWeek == null) {
            throw new InvalidObjectException("firstDayOfWeek is null");
        }
        int i = this.minimalDays;
        if (i < 1 || i > 7) {
            throw new InvalidObjectException("Minimal number of days is invalid");
        }
    }

    private Object readResolve() {
        try {
            return of(this.firstDayOfWeek, this.minimalDays);
        } catch (IllegalArgumentException e) {
            throw new InvalidObjectException("Invalid serialized WeekFields: " + e.getMessage());
        }
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDays;
    }

    public TemporalField dayOfWeek() {
        return this.dayOfWeek;
    }

    public TemporalField weekOfMonth() {
        return this.weekOfMonth;
    }

    public TemporalField weekOfWeekBasedYear() {
        return this.weekOfWeekBasedYear;
    }

    public TemporalField weekBasedYear() {
        return this.weekBasedYear;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WeekFields) && hashCode() == obj.hashCode();
    }

    public int hashCode() {
        return (this.firstDayOfWeek.ordinal() * 7) + this.minimalDays;
    }

    public String toString() {
        return "WeekFields[" + this.firstDayOfWeek + "," + this.minimalDays + "]";
    }

    /* loaded from: classes3.dex */
    static class ComputedDayOfField implements TemporalField {
        private final TemporalUnit baseUnit;
        private final String name;
        private final ValueRange range;
        private final TemporalUnit rangeUnit;
        private final WeekFields weekDef;
        private static final ValueRange DAY_OF_WEEK_RANGE = ValueRange.of(1, 7);
        private static final ValueRange WEEK_OF_MONTH_RANGE = ValueRange.of(0, 1, 4, 6);
        private static final ValueRange WEEK_OF_YEAR_RANGE = ValueRange.of(0, 1, 52, 54);
        private static final ValueRange WEEK_OF_WEEK_BASED_YEAR_RANGE = ValueRange.of(1, 52, 53);

        @Override // j$.time.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // j$.time.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        static ComputedDayOfField ofDayOfWeekField(WeekFields weekFields) {
            return new ComputedDayOfField("DayOfWeek", weekFields, ChronoUnit.DAYS, ChronoUnit.WEEKS, DAY_OF_WEEK_RANGE);
        }

        static ComputedDayOfField ofWeekOfMonthField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfMonth", weekFields, ChronoUnit.WEEKS, ChronoUnit.MONTHS, WEEK_OF_MONTH_RANGE);
        }

        static ComputedDayOfField ofWeekOfYearField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfYear", weekFields, ChronoUnit.WEEKS, ChronoUnit.YEARS, WEEK_OF_YEAR_RANGE);
        }

        static ComputedDayOfField ofWeekOfWeekBasedYearField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfWeekBasedYear", weekFields, ChronoUnit.WEEKS, IsoFields.WEEK_BASED_YEARS, WEEK_OF_WEEK_BASED_YEAR_RANGE);
        }

        static ComputedDayOfField ofWeekBasedYearField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekBasedYear", weekFields, IsoFields.WEEK_BASED_YEARS, ChronoUnit.FOREVER, ChronoField.YEAR.range());
        }

        private ChronoLocalDate ofWeekBasedYear(Chronology chronology, int i, int i2, int i3) {
            ChronoLocalDate date = chronology.date(i, 1, 1);
            int startOfWeekOffset = startOfWeekOffset(1, localizedDayOfWeek(date));
            return date.plus((-startOfWeekOffset) + (i3 - 1) + ((Math.min(i2, computeWeek(startOfWeekOffset, date.lengthOfYear() + this.weekDef.getMinimalDaysInFirstWeek()) - 1) - 1) * 7), (TemporalUnit) ChronoUnit.DAYS);
        }

        private ComputedDayOfField(String str, WeekFields weekFields, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, ValueRange valueRange) {
            this.name = str;
            this.weekDef = weekFields;
            this.baseUnit = temporalUnit;
            this.rangeUnit = temporalUnit2;
            this.range = valueRange;
        }

        @Override // j$.time.temporal.TemporalField
        public long getFrom(TemporalAccessor temporalAccessor) {
            int localizedWeekBasedYear;
            TemporalUnit temporalUnit = this.rangeUnit;
            if (temporalUnit == ChronoUnit.WEEKS) {
                localizedWeekBasedYear = localizedDayOfWeek(temporalAccessor);
            } else {
                if (temporalUnit == ChronoUnit.MONTHS) {
                    return localizedWeekOfMonth(temporalAccessor);
                }
                if (temporalUnit == ChronoUnit.YEARS) {
                    return localizedWeekOfYear(temporalAccessor);
                }
                if (temporalUnit == WeekFields.WEEK_BASED_YEARS) {
                    localizedWeekBasedYear = localizedWeekOfWeekBasedYear(temporalAccessor);
                } else if (temporalUnit == ChronoUnit.FOREVER) {
                    localizedWeekBasedYear = localizedWeekBasedYear(temporalAccessor);
                } else {
                    throw new IllegalStateException("unreachable, rangeUnit: " + temporalUnit + ", this: " + this);
                }
            }
            return localizedWeekBasedYear;
        }

        private int localizedDayOfWeek(TemporalAccessor temporalAccessor) {
            return Math.floorMod(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
        }

        private int localizedDayOfWeek(int i) {
            return Math.floorMod(i - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
        }

        private long localizedWeekOfMonth(TemporalAccessor temporalAccessor) {
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            int i = temporalAccessor.get(ChronoField.DAY_OF_MONTH);
            return computeWeek(startOfWeekOffset(i, localizedDayOfWeek), i);
        }

        private long localizedWeekOfYear(TemporalAccessor temporalAccessor) {
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            int i = temporalAccessor.get(ChronoField.DAY_OF_YEAR);
            return computeWeek(startOfWeekOffset(i, localizedDayOfWeek), i);
        }

        private int localizedWeekBasedYear(TemporalAccessor temporalAccessor) {
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            int i = temporalAccessor.get(ChronoField.YEAR);
            ChronoField chronoField = ChronoField.DAY_OF_YEAR;
            int i2 = temporalAccessor.get(chronoField);
            int startOfWeekOffset = startOfWeekOffset(i2, localizedDayOfWeek);
            int computeWeek = computeWeek(startOfWeekOffset, i2);
            return computeWeek == 0 ? i - 1 : computeWeek >= computeWeek(startOfWeekOffset, ((int) temporalAccessor.range(chronoField).getMaximum()) + this.weekDef.getMinimalDaysInFirstWeek()) ? i + 1 : i;
        }

        private int localizedWeekOfWeekBasedYear(TemporalAccessor temporalAccessor) {
            int computeWeek;
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            ChronoField chronoField = ChronoField.DAY_OF_YEAR;
            int i = temporalAccessor.get(chronoField);
            int startOfWeekOffset = startOfWeekOffset(i, localizedDayOfWeek);
            int computeWeek2 = computeWeek(startOfWeekOffset, i);
            if (computeWeek2 == 0) {
                return localizedWeekOfWeekBasedYear(Chronology.from(temporalAccessor).date(temporalAccessor).minus(i, (TemporalUnit) ChronoUnit.DAYS));
            }
            return (computeWeek2 <= 50 || computeWeek2 < (computeWeek = computeWeek(startOfWeekOffset, ((int) temporalAccessor.range(chronoField).getMaximum()) + this.weekDef.getMinimalDaysInFirstWeek()))) ? computeWeek2 : (computeWeek2 - computeWeek) + 1;
        }

        private int startOfWeekOffset(int i, int i2) {
            int floorMod = Math.floorMod(i - i2, 7);
            return floorMod + 1 > this.weekDef.getMinimalDaysInFirstWeek() ? 7 - floorMod : -floorMod;
        }

        private int computeWeek(int i, int i2) {
            return ((i + 7) + (i2 - 1)) / 7;
        }

        @Override // j$.time.temporal.TemporalField
        public Temporal adjustInto(Temporal temporal, long j) {
            if (this.range.checkValidIntValue(j, this) == temporal.get(this)) {
                return temporal;
            }
            if (this.rangeUnit == ChronoUnit.FOREVER) {
                return ofWeekBasedYear(Chronology.from(temporal), (int) j, temporal.get(this.weekDef.weekOfWeekBasedYear), temporal.get(this.weekDef.dayOfWeek));
            }
            return temporal.plus(r0 - r1, this.baseUnit);
        }

        @Override // j$.time.temporal.TemporalField
        public ChronoLocalDate resolve(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            int intExact = Math.toIntExact(((Long) map.get(this)).longValue());
            if (this.rangeUnit == ChronoUnit.WEEKS) {
                long floorMod = Math.floorMod((this.weekDef.getFirstDayOfWeek().getValue() - 1) + (this.range.checkValidIntValue(r2, this) - 1), 7) + 1;
                map.remove(this);
                map.put(ChronoField.DAY_OF_WEEK, Long.valueOf(floorMod));
                return null;
            }
            ChronoField chronoField = ChronoField.DAY_OF_WEEK;
            if (!map.containsKey(chronoField)) {
                return null;
            }
            int localizedDayOfWeek = localizedDayOfWeek(chronoField.checkValidIntValue(((Long) map.get(chronoField)).longValue()));
            Chronology from = Chronology.from(temporalAccessor);
            ChronoField chronoField2 = ChronoField.YEAR;
            if (map.containsKey(chronoField2)) {
                int checkValidIntValue = chronoField2.checkValidIntValue(((Long) map.get(chronoField2)).longValue());
                if (this.rangeUnit == ChronoUnit.MONTHS) {
                    Object obj = ChronoField.MONTH_OF_YEAR;
                    if (map.containsKey(obj)) {
                        return resolveWoM(map, from, checkValidIntValue, ((Long) map.get(obj)).longValue(), intExact, localizedDayOfWeek, resolverStyle);
                    }
                }
                if (this.rangeUnit == ChronoUnit.YEARS) {
                    return resolveWoY(map, from, checkValidIntValue, intExact, localizedDayOfWeek, resolverStyle);
                }
            } else {
                TemporalUnit temporalUnit = this.rangeUnit;
                if ((temporalUnit == WeekFields.WEEK_BASED_YEARS || temporalUnit == ChronoUnit.FOREVER) && map.containsKey(this.weekDef.weekBasedYear) && map.containsKey(this.weekDef.weekOfWeekBasedYear)) {
                    return resolveWBY(map, from, localizedDayOfWeek, resolverStyle);
                }
            }
            return null;
        }

        private ChronoLocalDate resolveWoM(Map map, Chronology chronology, int i, long j, long j2, int i2, ResolverStyle resolverStyle) {
            ChronoLocalDate plus;
            if (resolverStyle == ResolverStyle.LENIENT) {
                ChronoLocalDate plus2 = chronology.date(i, 1, 1).plus(Math.subtractExact(j, 1L), (TemporalUnit) ChronoUnit.MONTHS);
                plus = plus2.plus(Math.addExact(Duration.AnonymousClass0.m(Math.subtractExact(j2, localizedWeekOfMonth(plus2)), 7), i2 - localizedDayOfWeek(plus2)), (TemporalUnit) ChronoUnit.DAYS);
            } else {
                ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
                plus = chronology.date(i, chronoField.checkValidIntValue(j), 1).plus((((int) (this.range.checkValidIntValue(j2, this) - localizedWeekOfMonth(r6))) * 7) + (i2 - localizedDayOfWeek(r6)), (TemporalUnit) ChronoUnit.DAYS);
                if (resolverStyle == ResolverStyle.STRICT && plus.getLong(chronoField) != j) {
                    Year.AnonymousClass3.m("Strict mode rejected resolved date as it is in a different month");
                    return null;
                }
            }
            map.remove(this);
            map.remove(ChronoField.YEAR);
            map.remove(ChronoField.MONTH_OF_YEAR);
            map.remove(ChronoField.DAY_OF_WEEK);
            return plus;
        }

        private ChronoLocalDate resolveWoY(Map map, Chronology chronology, int i, long j, int i2, ResolverStyle resolverStyle) {
            ChronoLocalDate plus;
            ChronoLocalDate date = chronology.date(i, 1, 1);
            if (resolverStyle == ResolverStyle.LENIENT) {
                plus = date.plus(Math.addExact(Duration.AnonymousClass0.m(Math.subtractExact(j, localizedWeekOfYear(date)), 7), i2 - localizedDayOfWeek(date)), (TemporalUnit) ChronoUnit.DAYS);
            } else {
                plus = date.plus((((int) (this.range.checkValidIntValue(j, this) - localizedWeekOfYear(date))) * 7) + (i2 - localizedDayOfWeek(date)), (TemporalUnit) ChronoUnit.DAYS);
                if (resolverStyle == ResolverStyle.STRICT && plus.getLong(ChronoField.YEAR) != i) {
                    Year.AnonymousClass3.m("Strict mode rejected resolved date as it is in a different year");
                    return null;
                }
            }
            map.remove(this);
            map.remove(ChronoField.YEAR);
            map.remove(ChronoField.DAY_OF_WEEK);
            return plus;
        }

        private ChronoLocalDate resolveWBY(Map map, Chronology chronology, int i, ResolverStyle resolverStyle) {
            ChronoLocalDate ofWeekBasedYear;
            int checkValidIntValue = this.weekDef.weekBasedYear.range().checkValidIntValue(((Long) map.get(this.weekDef.weekBasedYear)).longValue(), this.weekDef.weekBasedYear);
            if (resolverStyle == ResolverStyle.LENIENT) {
                ofWeekBasedYear = ofWeekBasedYear(chronology, checkValidIntValue, 1, i).plus(Math.subtractExact(((Long) map.get(this.weekDef.weekOfWeekBasedYear)).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS);
            } else {
                ofWeekBasedYear = ofWeekBasedYear(chronology, checkValidIntValue, this.weekDef.weekOfWeekBasedYear.range().checkValidIntValue(((Long) map.get(this.weekDef.weekOfWeekBasedYear)).longValue(), this.weekDef.weekOfWeekBasedYear), i);
                if (resolverStyle == ResolverStyle.STRICT && localizedWeekBasedYear(ofWeekBasedYear) != checkValidIntValue) {
                    Year.AnonymousClass3.m("Strict mode rejected resolved date as it is in a different week-based-year");
                    return null;
                }
            }
            map.remove(this);
            map.remove(this.weekDef.weekBasedYear);
            map.remove(this.weekDef.weekOfWeekBasedYear);
            map.remove(ChronoField.DAY_OF_WEEK);
            return ofWeekBasedYear;
        }

        @Override // j$.time.temporal.TemporalField
        public ValueRange range() {
            return this.range;
        }

        @Override // j$.time.temporal.TemporalField
        public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
            if (!temporalAccessor.isSupported(ChronoField.DAY_OF_WEEK)) {
                return false;
            }
            TemporalUnit temporalUnit = this.rangeUnit;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return true;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                return temporalAccessor.isSupported(ChronoField.DAY_OF_MONTH);
            }
            if (temporalUnit == ChronoUnit.YEARS) {
                return temporalAccessor.isSupported(ChronoField.DAY_OF_YEAR);
            }
            if (temporalUnit == WeekFields.WEEK_BASED_YEARS) {
                return temporalAccessor.isSupported(ChronoField.DAY_OF_YEAR);
            }
            if (temporalUnit == ChronoUnit.FOREVER) {
                return temporalAccessor.isSupported(ChronoField.YEAR);
            }
            return false;
        }

        @Override // j$.time.temporal.TemporalField
        public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
            TemporalUnit temporalUnit = this.rangeUnit;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return this.range;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                return rangeByWeek(temporalAccessor, ChronoField.DAY_OF_MONTH);
            }
            if (temporalUnit == ChronoUnit.YEARS) {
                return rangeByWeek(temporalAccessor, ChronoField.DAY_OF_YEAR);
            }
            if (temporalUnit == WeekFields.WEEK_BASED_YEARS) {
                return rangeWeekOfWeekBasedYear(temporalAccessor);
            }
            if (temporalUnit == ChronoUnit.FOREVER) {
                return ChronoField.YEAR.range();
            }
            throw new IllegalStateException("unreachable, rangeUnit: " + temporalUnit + ", this: " + this);
        }

        private ValueRange rangeByWeek(TemporalAccessor temporalAccessor, TemporalField temporalField) {
            int startOfWeekOffset = startOfWeekOffset(temporalAccessor.get(temporalField), localizedDayOfWeek(temporalAccessor));
            ValueRange range = temporalAccessor.range(temporalField);
            return ValueRange.of(computeWeek(startOfWeekOffset, (int) range.getMinimum()), computeWeek(startOfWeekOffset, (int) range.getMaximum()));
        }

        private ValueRange rangeWeekOfWeekBasedYear(TemporalAccessor temporalAccessor) {
            ChronoField chronoField = ChronoField.DAY_OF_YEAR;
            if (!temporalAccessor.isSupported(chronoField)) {
                return WEEK_OF_YEAR_RANGE;
            }
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            int i = temporalAccessor.get(chronoField);
            int startOfWeekOffset = startOfWeekOffset(i, localizedDayOfWeek);
            int computeWeek = computeWeek(startOfWeekOffset, i);
            if (computeWeek == 0) {
                return rangeWeekOfWeekBasedYear(Chronology.from(temporalAccessor).date(temporalAccessor).minus(i + 7, (TemporalUnit) ChronoUnit.DAYS));
            }
            if (computeWeek >= computeWeek(startOfWeekOffset, this.weekDef.getMinimalDaysInFirstWeek() + ((int) temporalAccessor.range(chronoField).getMaximum()))) {
                return rangeWeekOfWeekBasedYear(Chronology.from(temporalAccessor).date(temporalAccessor).plus((r0 - i) + 8, (TemporalUnit) ChronoUnit.DAYS));
            }
            return ValueRange.of(1L, r1 - 1);
        }

        public String toString() {
            return this.name + "[" + this.weekDef.toString() + "]";
        }
    }
}
