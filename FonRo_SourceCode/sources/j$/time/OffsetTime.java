package j$.time;

import androidx.compose.animation.core.AnimationKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.time.Year;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.ValueRange;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class OffsetTime implements Temporal, TemporalAdjuster, Comparable, Serializable {
    private static final long serialVersionUID = 7264499704384272492L;
    private final ZoneOffset offset;
    private final LocalTime time;
    public static final OffsetTime MIN = LocalTime.MIN.atOffset(ZoneOffset.MAX);
    public static final OffsetTime MAX = LocalTime.MAX.atOffset(ZoneOffset.MIN);

    public static OffsetTime of(LocalTime localTime, ZoneOffset zoneOffset) {
        return new OffsetTime(localTime, zoneOffset);
    }

    public static OffsetTime from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof OffsetTime) {
            return (OffsetTime) temporalAccessor;
        }
        try {
            return new OffsetTime(LocalTime.from(temporalAccessor), ZoneOffset.from(temporalAccessor));
        } catch (DateTimeException e) {
            Year.AnonymousClass4.m("Unable to obtain OffsetTime from TemporalAccessor: ", temporalAccessor, temporalAccessor.getClass().getName(), e);
            return null;
        }
    }

    private OffsetTime(LocalTime localTime, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localTime, "time");
        this.time = localTime;
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        this.offset = zoneOffset;
    }

    private OffsetTime with(LocalTime localTime, ZoneOffset zoneOffset) {
        return (this.time == localTime && this.offset.equals(zoneOffset)) ? this : new OffsetTime(localTime, zoneOffset);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() || temporalField == ChronoField.OFFSET_SECONDS : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (temporalField == ChronoField.OFFSET_SECONDS) {
                return temporalField.range();
            }
            return this.time.range(temporalField);
        }
        return temporalField.rangeRefinedBy(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return super.get(temporalField);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (temporalField == ChronoField.OFFSET_SECONDS) {
                return this.offset.getTotalSeconds();
            }
            return this.time.getLong(temporalField);
        }
        return temporalField.getFrom(this);
    }

    @Override // j$.time.temporal.Temporal
    public OffsetTime with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalTime) {
            return with((LocalTime) temporalAdjuster, this.offset);
        }
        if (temporalAdjuster instanceof ZoneOffset) {
            return with(this.time, (ZoneOffset) temporalAdjuster);
        }
        if (temporalAdjuster instanceof OffsetTime) {
            return (OffsetTime) temporalAdjuster;
        }
        return (OffsetTime) temporalAdjuster.adjustInto(this);
    }

    @Override // j$.time.temporal.Temporal
    public OffsetTime with(TemporalField temporalField, long j) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = ChronoField.OFFSET_SECONDS;
            LocalTime localTime = this.time;
            if (temporalField == chronoField) {
                return with(localTime, ZoneOffset.ofTotalSeconds(((ChronoField) temporalField).checkValidIntValue(j)));
            }
            return with(localTime.with(temporalField, j), this.offset);
        }
        return (OffsetTime) temporalField.adjustInto(this, j);
    }

    @Override // j$.time.temporal.Temporal
    public OffsetTime plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return with(this.time.plus(j, temporalUnit), this.offset);
        }
        return (OffsetTime) temporalUnit.addTo(this, j);
    }

    @Override // j$.time.temporal.Temporal
    public OffsetTime minus(long j, TemporalUnit temporalUnit) {
        long j2;
        if (j == Long.MIN_VALUE) {
            this = plus(Long.MAX_VALUE, temporalUnit);
            j2 = 1;
        } else {
            j2 = -j;
        }
        return this.plus(j2, temporalUnit);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public Object query(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.zone()) {
            return this.offset;
        }
        if (((temporalQuery == TemporalQueries.zoneId()) || (temporalQuery == TemporalQueries.chronology())) || temporalQuery == TemporalQueries.localDate()) {
            return null;
        }
        if (temporalQuery == TemporalQueries.localTime()) {
            return this.time;
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return ChronoUnit.NANOS;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.NANO_OF_DAY, this.time.toNanoOfDay()).with(ChronoField.OFFSET_SECONDS, this.offset.getTotalSeconds());
    }

    @Override // j$.time.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        OffsetTime from = from(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            long epochNano = from.toEpochNano() - toEpochNano();
            switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return epochNano;
                case 2:
                    return epochNano / 1000;
                case 3:
                    return epochNano / AnimationKt.MillisToNanos;
                case 4:
                    return epochNano / 1000000000;
                case 5:
                    return epochNano / 60000000000L;
                case 6:
                    return epochNano / 3600000000000L;
                case 7:
                    return epochNano / 43200000000000L;
                default:
                    Year.AnonymousClass2.m("Unsupported unit: ", temporalUnit);
                    return 0L;
            }
        }
        return temporalUnit.between(this, from);
    }

    /* renamed from: j$.time.OffsetTime$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoUnit;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            $SwitchMap$java$time$temporal$ChronoUnit = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private long toEpochNano() {
        return this.time.toNanoOfDay() - (this.offset.getTotalSeconds() * 1000000000);
    }

    @Override // java.lang.Comparable
    public int compareTo(OffsetTime offsetTime) {
        if (this.offset.equals(offsetTime.offset)) {
            return this.time.compareTo(offsetTime.time);
        }
        int compare = Long.compare(toEpochNano(), offsetTime.toEpochNano());
        return compare == 0 ? this.time.compareTo(offsetTime.time) : compare;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetTime) {
            OffsetTime offsetTime = (OffsetTime) obj;
            if (this.time.equals(offsetTime.time) && this.offset.equals(offsetTime.offset)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.offset.hashCode() ^ this.time.hashCode();
    }

    public String toString() {
        return this.time.toString() + this.offset.toString();
    }

    private Object writeReplace() {
        return new Ser((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(ObjectOutput objectOutput) {
        this.time.writeExternal(objectOutput);
        this.offset.writeExternal(objectOutput);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OffsetTime readExternal(ObjectInput objectInput) {
        return of(LocalTime.readExternal(objectInput), ZoneOffset.readExternal(objectInput));
    }
}
