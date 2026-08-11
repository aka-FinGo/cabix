package j$.time.chrono;

import j$.time.Duration;
import j$.time.Year;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalUnit;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes3.dex */
public abstract class ChronoLocalDateImpl implements ChronoLocalDate, Temporal, TemporalAdjuster, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    /* renamed from: j$.time.chrono.ChronoLocalDateImpl$0 */
    /* loaded from: classes3.dex */
    public final /* synthetic */ class AnonymousClass0 {
        public static /* synthetic */ void m(String str, Object obj, Object obj2) {
            throw new ClassCastException(str + obj + ((Object) ", actual: ") + obj2);
        }
    }

    abstract ChronoLocalDate plusDays(long j);

    abstract ChronoLocalDate plusMonths(long j);

    abstract ChronoLocalDate plusYears(long j);

    public static ChronoLocalDate ensureValid(Chronology chronology, Temporal temporal) {
        ChronoLocalDate chronoLocalDate = (ChronoLocalDate) temporal;
        if (chronology.equals(chronoLocalDate.getChronology())) {
            return chronoLocalDate;
        }
        AnonymousClass0.m("Chronology mismatch, expected: ", chronology.getId(), chronoLocalDate.getChronology().getId());
        return null;
    }

    @Override // j$.time.temporal.Temporal
    public ChronoLocalDate with(TemporalAdjuster temporalAdjuster) {
        return super.with(temporalAdjuster);
    }

    @Override // j$.time.temporal.Temporal
    public ChronoLocalDate with(TemporalField temporalField, long j) {
        return super.with(temporalField, j);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public ChronoLocalDate plus(TemporalAmount temporalAmount) {
        return super.plus(temporalAmount);
    }

    @Override // j$.time.temporal.Temporal
    public ChronoLocalDate plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusDays(j);
                case 2:
                    return plusDays(Duration.AnonymousClass0.m(j, 7));
                case 3:
                    return plusMonths(j);
                case 4:
                    return plusYears(j);
                case 5:
                    return plusYears(Duration.AnonymousClass0.m(j, 10));
                case 6:
                    return plusYears(Duration.AnonymousClass0.m(j, 100));
                case 7:
                    return plusYears(Duration.AnonymousClass0.m(j, 1000));
                case 8:
                    ChronoField chronoField = ChronoField.ERA;
                    return with((TemporalField) chronoField, Math.addExact(getLong(chronoField), j));
                default:
                    Year.AnonymousClass2.m("Unsupported unit: ", temporalUnit);
                    return null;
            }
        }
        return super.plus(j, temporalUnit);
    }

    /* renamed from: j$.time.chrono.ChronoLocalDateImpl$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoUnit;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            $SwitchMap$java$time$temporal$ChronoUnit = iArr;
            try {
                iArr[ChronoUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.WEEKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MONTHS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.YEARS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.DECADES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.CENTURIES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MILLENNIA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.ERAS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // j$.time.temporal.Temporal
    public ChronoLocalDate minus(long j, TemporalUnit temporalUnit) {
        return super.minus(j, temporalUnit);
    }

    @Override // j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        Objects.requireNonNull(temporal, "endExclusive");
        ChronoLocalDate date = getChronology().date(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return daysUntil(date);
                case 2:
                    return daysUntil(date) / 7;
                case 3:
                    return monthsUntil(date);
                case 4:
                    return monthsUntil(date) / 12;
                case 5:
                    return monthsUntil(date) / 120;
                case 6:
                    return monthsUntil(date) / 1200;
                case 7:
                    return monthsUntil(date) / 12000;
                case 8:
                    ChronoField chronoField = ChronoField.ERA;
                    return date.getLong(chronoField) - getLong(chronoField);
                default:
                    Year.AnonymousClass2.m("Unsupported unit: ", temporalUnit);
                    return 0L;
            }
        }
        Objects.requireNonNull(temporalUnit, "unit");
        return temporalUnit.between(this, date);
    }

    private long daysUntil(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate.toEpochDay() - toEpochDay();
    }

    private long monthsUntil(ChronoLocalDate chronoLocalDate) {
        if (getChronology().range(ChronoField.MONTH_OF_YEAR).getMaximum() != 12) {
            throw new IllegalStateException("ChronoLocalDateImpl only supports Chronologies with 12 months per year");
        }
        ChronoField chronoField = ChronoField.PROLEPTIC_MONTH;
        long j = getLong(chronoField) * 32;
        ChronoField chronoField2 = ChronoField.DAY_OF_MONTH;
        return (((chronoLocalDate.getLong(chronoField) * 32) + chronoLocalDate.get(chronoField2)) - (j + get(chronoField2))) / 32;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoLocalDate) && compareTo((ChronoLocalDate) obj) == 0;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public int hashCode() {
        long epochDay = toEpochDay();
        return getChronology().hashCode() ^ ((int) (epochDay ^ (epochDay >>> 32)));
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public String toString() {
        long j = getLong(ChronoField.YEAR_OF_ERA);
        long j2 = getLong(ChronoField.MONTH_OF_YEAR);
        long j3 = getLong(ChronoField.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(getChronology().toString());
        sb.append(" ");
        sb.append(getEra());
        sb.append(" ");
        sb.append(j);
        sb.append(j2 < 10 ? "-0" : "-");
        sb.append(j2);
        sb.append(j3 < 10 ? "-0" : "-");
        sb.append(j3);
        return sb.toString();
    }
}
