package j$.time.temporal;

import j$.time.DayOfWeek;
import j$.time.Duration;
import j$.time.LocalDate;
import j$.time.Year;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.Chronology;
import j$.time.chrono.IsoChronology;
import j$.time.format.ResolverStyle;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class IsoFields {
    public static final TemporalField DAY_OF_QUARTER = Field.DAY_OF_QUARTER;
    public static final TemporalField QUARTER_OF_YEAR = Field.QUARTER_OF_YEAR;
    public static final TemporalField WEEK_OF_WEEK_BASED_YEAR = Field.WEEK_OF_WEEK_BASED_YEAR;
    public static final TemporalField WEEK_BASED_YEAR = Field.WEEK_BASED_YEAR;
    public static final TemporalUnit WEEK_BASED_YEARS = Unit.WEEK_BASED_YEARS;
    public static final TemporalUnit QUARTER_YEARS = Unit.QUARTER_YEARS;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes3.dex */
    public static abstract class Field implements TemporalField {
        private static final /* synthetic */ Field[] $VALUES;
        public static final Field DAY_OF_QUARTER;
        private static final int[] QUARTER_DAYS;
        public static final Field QUARTER_OF_YEAR;
        public static final Field WEEK_BASED_YEAR;
        public static final Field WEEK_OF_WEEK_BASED_YEAR;

        @Override // j$.time.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // j$.time.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        /* renamed from: j$.time.temporal.IsoFields$Field$1, reason: invalid class name */
        /* loaded from: classes3.dex */
        enum AnonymousClass1 extends Field {
            private AnonymousClass1(String str, int i) {
                super(str, i);
            }

            @Override // j$.time.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1L, 90L, 92L);
            }

            @Override // j$.time.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.DAY_OF_YEAR) && temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR) && temporalAccessor.isSupported(ChronoField.YEAR) && IsoFields.isIso(temporalAccessor);
            }

            @Override // j$.time.temporal.IsoFields.Field, j$.time.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (!isSupportedBy(temporalAccessor)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                long j = temporalAccessor.getLong(Field.QUARTER_OF_YEAR);
                if (j == 1) {
                    return IsoChronology.INSTANCE.isLeapYear(temporalAccessor.getLong(ChronoField.YEAR)) ? ValueRange.of(1L, 91L) : ValueRange.of(1L, 90L);
                }
                if (j == 2) {
                    return ValueRange.of(1L, 91L);
                }
                if (j == 3 || j == 4) {
                    return ValueRange.of(1L, 92L);
                }
                return range();
            }

            @Override // j$.time.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (!isSupportedBy(temporalAccessor)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                return temporalAccessor.get(ChronoField.DAY_OF_YEAR) - Field.QUARTER_DAYS[((temporalAccessor.get(ChronoField.MONTH_OF_YEAR) - 1) / 3) + (IsoChronology.INSTANCE.isLeapYear(temporalAccessor.getLong(ChronoField.YEAR)) ? 4 : 0)];
            }

            @Override // j$.time.temporal.TemporalField
            public Temporal adjustInto(Temporal temporal, long j) {
                long from = getFrom(temporal);
                range().checkValidValue(j, this);
                ChronoField chronoField = ChronoField.DAY_OF_YEAR;
                return temporal.with(chronoField, temporal.getLong(chronoField) + (j - from));
            }

            @Override // j$.time.temporal.TemporalField
            public ChronoLocalDate resolve(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                LocalDate of;
                long j;
                ChronoField chronoField = ChronoField.YEAR;
                Long l = (Long) map.get(chronoField);
                TemporalField temporalField = Field.QUARTER_OF_YEAR;
                Long l2 = (Long) map.get(temporalField);
                if (l == null || l2 == null) {
                    return null;
                }
                int checkValidIntValue = chronoField.checkValidIntValue(l.longValue());
                long longValue = ((Long) map.get(Field.DAY_OF_QUARTER)).longValue();
                Field.ensureIso(temporalAccessor);
                if (resolverStyle == ResolverStyle.LENIENT) {
                    of = LocalDate.of(checkValidIntValue, 1, 1).plusMonths(Duration.AnonymousClass0.m(Math.subtractExact(l2.longValue(), 1L), 3));
                    j = Math.subtractExact(longValue, 1L);
                } else {
                    of = LocalDate.of(checkValidIntValue, ((temporalField.range().checkValidIntValue(l2.longValue(), temporalField) - 1) * 3) + 1, 1);
                    if (longValue < 1 || longValue > 90) {
                        if (resolverStyle == ResolverStyle.STRICT) {
                            rangeRefinedBy(of).checkValidValue(longValue, this);
                        } else {
                            range().checkValidValue(longValue, this);
                        }
                    }
                    j = longValue - 1;
                }
                map.remove(this);
                map.remove(chronoField);
                map.remove(temporalField);
                return of.plusDays(j);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "DayOfQuarter";
            }
        }

        private Field(String str, int i) {
        }

        public static Field valueOf(String str) {
            return (Field) Enum.valueOf(Field.class, str);
        }

        public static Field[] values() {
            return (Field[]) $VALUES.clone();
        }

        static {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1("DAY_OF_QUARTER", 0);
            DAY_OF_QUARTER = anonymousClass1;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2("QUARTER_OF_YEAR", 1);
            QUARTER_OF_YEAR = anonymousClass2;
            AnonymousClass3 anonymousClass3 = new AnonymousClass3("WEEK_OF_WEEK_BASED_YEAR", 2);
            WEEK_OF_WEEK_BASED_YEAR = anonymousClass3;
            AnonymousClass4 anonymousClass4 = new AnonymousClass4("WEEK_BASED_YEAR", 3);
            WEEK_BASED_YEAR = anonymousClass4;
            $VALUES = new Field[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4};
            QUARTER_DAYS = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
        }

        /* renamed from: j$.time.temporal.IsoFields$Field$2, reason: invalid class name */
        /* loaded from: classes3.dex */
        enum AnonymousClass2 extends Field {
            private AnonymousClass2(String str, int i) {
                super(str, i);
            }

            @Override // j$.time.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1L, 4L);
            }

            @Override // j$.time.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR) && IsoFields.isIso(temporalAccessor);
            }

            @Override // j$.time.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (!isSupportedBy(temporalAccessor)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
                }
                return (temporalAccessor.getLong(ChronoField.MONTH_OF_YEAR) + 2) / 3;
            }

            @Override // j$.time.temporal.IsoFields.Field, j$.time.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (!isSupportedBy(temporalAccessor)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
                }
                return super.rangeRefinedBy(temporalAccessor);
            }

            @Override // j$.time.temporal.TemporalField
            public Temporal adjustInto(Temporal temporal, long j) {
                long from = getFrom(temporal);
                range().checkValidValue(j, this);
                ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
                return temporal.with(chronoField, temporal.getLong(chronoField) + ((j - from) * 3));
            }

            @Override // java.lang.Enum
            public String toString() {
                return "QuarterOfYear";
            }
        }

        /* renamed from: j$.time.temporal.IsoFields$Field$3, reason: invalid class name */
        /* loaded from: classes3.dex */
        enum AnonymousClass3 extends Field {
            private AnonymousClass3(String str, int i) {
                super(str, i);
            }

            @Override // j$.time.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1L, 52L, 53L);
            }

            @Override // j$.time.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY) && IsoFields.isIso(temporalAccessor);
            }

            @Override // j$.time.temporal.IsoFields.Field, j$.time.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (!isSupportedBy(temporalAccessor)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
                }
                return Field.getWeekRange(LocalDate.from(temporalAccessor));
            }

            @Override // j$.time.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (!isSupportedBy(temporalAccessor)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
                }
                return Field.getWeek(LocalDate.from(temporalAccessor));
            }

            @Override // j$.time.temporal.TemporalField
            public Temporal adjustInto(Temporal temporal, long j) {
                range().checkValidValue(j, this);
                return temporal.plus(Math.subtractExact(j, getFrom(temporal)), ChronoUnit.WEEKS);
            }

            @Override // j$.time.temporal.TemporalField
            public ChronoLocalDate resolve(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                LocalDate with;
                long j;
                long j2;
                TemporalField temporalField = Field.WEEK_BASED_YEAR;
                Long l = (Long) map.get(temporalField);
                ChronoField chronoField = ChronoField.DAY_OF_WEEK;
                Long l2 = (Long) map.get(chronoField);
                if (l == null || l2 == null) {
                    return null;
                }
                int checkValidIntValue = temporalField.range().checkValidIntValue(l.longValue(), temporalField);
                long longValue = ((Long) map.get(Field.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                Field.ensureIso(temporalAccessor);
                LocalDate of = LocalDate.of(checkValidIntValue, 1, 4);
                if (resolverStyle == ResolverStyle.LENIENT) {
                    long longValue2 = l2.longValue();
                    if (longValue2 > 7) {
                        long j3 = longValue2 - 1;
                        j = 1;
                        of = of.plusWeeks(j3 / 7);
                        j2 = j3 % 7;
                    } else {
                        j = 1;
                        if (longValue2 < 1) {
                            of = of.plusWeeks(Math.subtractExact(longValue2, 7L) / 7);
                            j2 = (longValue2 + 6) % 7;
                        }
                        with = of.plusWeeks(Math.subtractExact(longValue, j)).with((TemporalField) chronoField, longValue2);
                    }
                    longValue2 = j2 + j;
                    with = of.plusWeeks(Math.subtractExact(longValue, j)).with((TemporalField) chronoField, longValue2);
                } else {
                    int checkValidIntValue2 = chronoField.checkValidIntValue(l2.longValue());
                    if (longValue < 1 || longValue > 52) {
                        if (resolverStyle == ResolverStyle.STRICT) {
                            Field.getWeekRange(of).checkValidValue(longValue, this);
                        } else {
                            range().checkValidValue(longValue, this);
                        }
                    }
                    with = of.plusWeeks(longValue - 1).with((TemporalField) chronoField, checkValidIntValue2);
                }
                map.remove(this);
                map.remove(temporalField);
                map.remove(chronoField);
                return with;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        }

        /* renamed from: j$.time.temporal.IsoFields$Field$4, reason: invalid class name */
        /* loaded from: classes3.dex */
        enum AnonymousClass4 extends Field {
            private AnonymousClass4(String str, int i) {
                super(str, i);
            }

            @Override // j$.time.temporal.TemporalField
            public ValueRange range() {
                return ChronoField.YEAR.range();
            }

            @Override // j$.time.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY) && IsoFields.isIso(temporalAccessor);
            }

            @Override // j$.time.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (!isSupportedBy(temporalAccessor)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
                }
                return Field.getWeekBasedYear(LocalDate.from(temporalAccessor));
            }

            @Override // j$.time.temporal.IsoFields.Field, j$.time.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (!isSupportedBy(temporalAccessor)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
                }
                return super.rangeRefinedBy(temporalAccessor);
            }

            @Override // j$.time.temporal.TemporalField
            public Temporal adjustInto(Temporal temporal, long j) {
                if (!isSupportedBy(temporal)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
                }
                int checkValidIntValue = range().checkValidIntValue(j, Field.WEEK_BASED_YEAR);
                LocalDate from = LocalDate.from(temporal);
                int i = from.get(ChronoField.DAY_OF_WEEK);
                int week = Field.getWeek(from);
                if (week == 53 && Field.getWeekRange(checkValidIntValue) == 52) {
                    week = 52;
                }
                return temporal.with(LocalDate.of(checkValidIntValue, 1, 4).plusDays((i - r3.get(r6)) + ((week - 1) * 7)));
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekBasedYear";
            }
        }

        @Override // j$.time.temporal.TemporalField
        public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
            return range();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void ensureIso(TemporalAccessor temporalAccessor) {
            if (IsoFields.isIso(temporalAccessor)) {
                return;
            }
            Year.AnonymousClass3.m("Resolve requires IsoChronology");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ValueRange getWeekRange(LocalDate localDate) {
            return ValueRange.of(1L, getWeekRange(getWeekBasedYear(localDate)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeekRange(int i) {
            LocalDate of = LocalDate.of(i, 1, 1);
            if (of.getDayOfWeek() != DayOfWeek.THURSDAY) {
                return (of.getDayOfWeek() == DayOfWeek.WEDNESDAY && of.isLeapYear()) ? 53 : 52;
            }
            return 53;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeek(LocalDate localDate) {
            int ordinal = localDate.getDayOfWeek().ordinal();
            int dayOfYear = localDate.getDayOfYear() - 1;
            int i = (3 - ordinal) + dayOfYear;
            int i2 = i - ((i / 7) * 7);
            int i3 = i2 - 3;
            if (i3 < -3) {
                i3 = i2 + 4;
            }
            if (dayOfYear < i3) {
                return (int) getWeekRange(localDate.withDayOfYear(180).minusYears(1L)).getMaximum();
            }
            int i4 = ((dayOfYear - i3) / 7) + 1;
            if (i4 != 53 || i3 == -3 || (i3 == -2 && localDate.isLeapYear())) {
                return i4;
            }
            return 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeekBasedYear(LocalDate localDate) {
            int year = localDate.getYear();
            int dayOfYear = localDate.getDayOfYear();
            if (dayOfYear <= 3) {
                return dayOfYear - localDate.getDayOfWeek().ordinal() < -2 ? year - 1 : year;
            }
            if (dayOfYear >= 363) {
                return ((dayOfYear - 363) - (localDate.isLeapYear() ? 1 : 0)) - localDate.getDayOfWeek().ordinal() >= 0 ? year + 1 : year;
            }
            return year;
        }
    }

    /* loaded from: classes3.dex */
    private enum Unit implements TemporalUnit {
        WEEK_BASED_YEARS("WeekBasedYears", Duration.ofSeconds(31556952)),
        QUARTER_YEARS("QuarterYears", Duration.ofSeconds(7889238));

        private final Duration duration;
        private final String name;

        @Override // j$.time.temporal.TemporalUnit
        public boolean isDateBased() {
            return true;
        }

        @Override // j$.time.temporal.TemporalUnit
        public boolean isTimeBased() {
            return false;
        }

        Unit(String str, Duration duration) {
            this.name = str;
            this.duration = duration;
        }

        @Override // j$.time.temporal.TemporalUnit
        public Temporal addTo(Temporal temporal, long j) {
            int i = AnonymousClass1.$SwitchMap$java$time$temporal$IsoFields$Unit[ordinal()];
            if (i == 1) {
                return temporal.with(IsoFields.WEEK_BASED_YEAR, Math.addExact(temporal.get(r4), j));
            }
            if (i == 2) {
                return temporal.plus(j / 4, ChronoUnit.YEARS).plus((j % 4) * 3, ChronoUnit.MONTHS);
            }
            throw new IllegalStateException("Unreachable");
        }

        @Override // j$.time.temporal.TemporalUnit
        public long between(Temporal temporal, Temporal temporal2) {
            if (temporal.getClass() != temporal2.getClass()) {
                return temporal.until(temporal2, this);
            }
            int i = AnonymousClass1.$SwitchMap$java$time$temporal$IsoFields$Unit[ordinal()];
            if (i == 1) {
                TemporalField temporalField = IsoFields.WEEK_BASED_YEAR;
                return Math.subtractExact(temporal2.getLong(temporalField), temporal.getLong(temporalField));
            }
            if (i == 2) {
                return temporal.until(temporal2, ChronoUnit.MONTHS) / 3;
            }
            throw new IllegalStateException("Unreachable");
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    /* renamed from: j$.time.temporal.IsoFields$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$IsoFields$Unit;

        static {
            int[] iArr = new int[Unit.values().length];
            $SwitchMap$java$time$temporal$IsoFields$Unit = iArr;
            try {
                iArr[Unit.WEEK_BASED_YEARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$time$temporal$IsoFields$Unit[Unit.QUARTER_YEARS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static boolean isIso(TemporalAccessor temporalAccessor) {
        return Chronology.from(temporalAccessor).equals(IsoChronology.INSTANCE);
    }
}
