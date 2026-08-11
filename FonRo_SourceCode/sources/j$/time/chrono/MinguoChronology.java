package j$.time.chrono;

import j$.time.Clock;
import j$.time.Duration$DurationUnits$0;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.format.ResolverStyle;
import j$.time.temporal.ChronoField;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.ValueRange;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class MinguoChronology extends AbstractChronology implements Serializable {
    public static final MinguoChronology INSTANCE = new MinguoChronology();
    private static final long serialVersionUID = 1039765215346859963L;

    private MinguoChronology() {
    }

    @Override // j$.time.chrono.Chronology
    public String getId() {
        return "Minguo";
    }

    @Override // j$.time.chrono.Chronology
    public String getCalendarType() {
        return "roc";
    }

    @Override // j$.time.chrono.Chronology
    public MinguoDate date(int i, int i2, int i3) {
        return new MinguoDate(LocalDate.of(i + 1911, i2, i3));
    }

    @Override // j$.time.chrono.Chronology
    public MinguoDate dateYearDay(int i, int i2) {
        return new MinguoDate(LocalDate.ofYearDay(i + 1911, i2));
    }

    @Override // j$.time.chrono.Chronology
    public MinguoDate dateEpochDay(long j) {
        return new MinguoDate(LocalDate.ofEpochDay(j));
    }

    @Override // j$.time.chrono.Chronology
    public MinguoDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    public MinguoDate dateNow(Clock clock) {
        return date((TemporalAccessor) LocalDate.now(clock));
    }

    @Override // j$.time.chrono.Chronology
    public MinguoDate date(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof MinguoDate) {
            return (MinguoDate) temporalAccessor;
        }
        return new MinguoDate(LocalDate.from(temporalAccessor));
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
        return IsoChronology.INSTANCE.isLeapYear(j + 1911);
    }

    @Override // j$.time.chrono.Chronology
    public int prolepticYear(Era era, int i) {
        if (era instanceof MinguoEra) {
            return era == MinguoEra.ROC ? i : 1 - i;
        }
        throw new ClassCastException("Era must be MinguoEra");
    }

    @Override // j$.time.chrono.Chronology
    public MinguoEra eraOf(int i) {
        return MinguoEra.of(i);
    }

    @Override // j$.time.chrono.Chronology
    public List eras() {
        return Duration$DurationUnits$0.m(MinguoEra.values());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.time.chrono.MinguoChronology$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoField;

        static {
            int[] iArr = new int[ChronoField.values().length];
            $SwitchMap$java$time$temporal$ChronoField = iArr;
            try {
                iArr[ChronoField.PROLEPTIC_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // j$.time.chrono.Chronology
    public ValueRange range(ChronoField chronoField) {
        int i = AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[chronoField.ordinal()];
        if (i == 1) {
            ValueRange range = ChronoField.PROLEPTIC_MONTH.range();
            return ValueRange.of(range.getMinimum() - 22932, range.getMaximum() - 22932);
        }
        if (i == 2) {
            ValueRange range2 = ChronoField.YEAR.range();
            return ValueRange.of(1L, range2.getMaximum() - 1911, (-range2.getMinimum()) + 1912);
        }
        if (i == 3) {
            ValueRange range3 = ChronoField.YEAR.range();
            return ValueRange.of(range3.getMinimum() - 1911, range3.getMaximum() - 1911);
        }
        return chronoField.range();
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public MinguoDate resolveDate(Map map, ResolverStyle resolverStyle) {
        return (MinguoDate) super.resolveDate(map, resolverStyle);
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
