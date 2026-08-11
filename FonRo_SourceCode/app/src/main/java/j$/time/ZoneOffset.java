package j$.time;

import j$.time.LocalDate;
import j$.time.Year;
import j$.time.ZoneId;
import j$.time.temporal.ChronoField;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.ValueRange;
import j$.time.zone.ZoneRules;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
public final class ZoneOffset extends ZoneId implements TemporalAccessor, TemporalAdjuster, Comparable<ZoneOffset>, Serializable {
    private static final long serialVersionUID = 2357656521762053153L;
    private final transient String id;
    private final int totalSeconds;
    private static final ConcurrentMap SECONDS_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    private static final ConcurrentMap ID_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = ofTotalSeconds(0);
    public static final ZoneOffset MIN = ofTotalSeconds(-64800);
    public static final ZoneOffset MAX = ofTotalSeconds(64800);

    /* renamed from: j$.time.ZoneOffset$0, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final /* synthetic */ class AnonymousClass0 {
        public static /* synthetic */ void m(String str, Object obj) {
            throw new DateTimeException(str + obj);
        }
    }

    private static int totalSeconds(int i, int i2, int i3) {
        return (i * 3600) + (i2 * 60) + i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x008e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j$.time.ZoneOffset of(java.lang.String r8) {
        /*
            java.lang.String r0 = "offsetId"
            java.util.Objects.requireNonNull(r8, r0)
            java.util.concurrent.ConcurrentMap r0 = j$.time.ZoneOffset.ID_CACHE
            java.lang.Object r0 = r0.get(r8)
            j$.time.ZoneOffset r0 = (j$.time.ZoneOffset) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            int r0 = r8.length()
            r1 = 2
            r2 = 0
            r3 = 1
            r4 = 0
            if (r0 == r1) goto L62
            r1 = 3
            if (r0 == r1) goto L7e
            r5 = 5
            if (r0 == r5) goto L59
            r6 = 6
            r7 = 4
            if (r0 == r6) goto L4f
            r6 = 7
            if (r0 == r6) goto L42
            r1 = 9
            if (r0 != r1) goto L38
            int r0 = parseNumber(r8, r3, r4)
            int r1 = parseNumber(r8, r7, r3)
            int r3 = parseNumber(r8, r6, r3)
            goto L84
        L38:
            java.lang.String r0 = "Invalid ID for ZoneOffset, invalid format: "
            java.lang.String r8 = r0.concat(r8)
            j$.time.Year.AnonymousClass3.m(r8)
            return r2
        L42:
            int r0 = parseNumber(r8, r3, r4)
            int r1 = parseNumber(r8, r1, r4)
            int r3 = parseNumber(r8, r5, r4)
            goto L84
        L4f:
            int r0 = parseNumber(r8, r3, r4)
            int r1 = parseNumber(r8, r7, r3)
        L57:
            r3 = r4
            goto L84
        L59:
            int r0 = parseNumber(r8, r3, r4)
            int r1 = parseNumber(r8, r1, r4)
            goto L57
        L62:
            char r0 = r8.charAt(r4)
            char r8 = r8.charAt(r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0"
            r1.append(r0)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
        L7e:
            int r0 = parseNumber(r8, r3, r4)
            r1 = r4
            r3 = r1
        L84:
            char r4 = r8.charAt(r4)
            r5 = 43
            r6 = 45
            if (r4 == r5) goto L9b
            if (r4 != r6) goto L91
            goto L9b
        L91:
            java.lang.String r0 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            java.lang.String r8 = r0.concat(r8)
            j$.time.Year.AnonymousClass3.m(r8)
            return r2
        L9b:
            if (r4 != r6) goto La5
            int r8 = -r0
            int r0 = -r1
            int r1 = -r3
            j$.time.ZoneOffset r8 = ofHoursMinutesSeconds(r8, r0, r1)
            return r8
        La5:
            j$.time.ZoneOffset r8 = ofHoursMinutesSeconds(r0, r1, r3)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.ZoneOffset.of(java.lang.String):j$.time.ZoneOffset");
    }

    private static int parseNumber(CharSequence charSequence, int i, boolean z) {
        if (z && charSequence.charAt(i - 1) != ':') {
            AnonymousClass0.m("Invalid ID for ZoneOffset, colon not found when expected: ", charSequence);
            return 0;
        }
        char charAt = charSequence.charAt(i);
        char charAt2 = charSequence.charAt(i + 1);
        if (charAt >= '0' && charAt <= '9' && charAt2 >= '0' && charAt2 <= '9') {
            return ((charAt - '0') * 10) + (charAt2 - '0');
        }
        AnonymousClass0.m("Invalid ID for ZoneOffset, non numeric characters found: ", charSequence);
        return 0;
    }

    public static ZoneOffset ofHours(int i) {
        return ofHoursMinutesSeconds(i, 0, 0);
    }

    public static ZoneOffset ofHoursMinutesSeconds(int i, int i2, int i3) {
        validate(i, i2, i3);
        return ofTotalSeconds(totalSeconds(i, i2, i3));
    }

    public static ZoneOffset from(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.query(TemporalQueries.offset());
        if (zoneOffset != null) {
            return zoneOffset;
        }
        ZoneId.AnonymousClass4.m("Unable to obtain ZoneOffset from TemporalAccessor: ", temporalAccessor, " of type ", temporalAccessor.getClass().getName());
        return null;
    }

    private static void validate(int i, int i2, int i3) {
        if (i < -18 || i > 18) {
            LocalDate.AnonymousClass4.m("Zone offset hours not in valid range: value ", i, " is not in the range -18 to 18");
            return;
        }
        if (i > 0) {
            if (i2 < 0 || i3 < 0) {
                Year.AnonymousClass3.m("Zone offset minutes and seconds must be positive because hours is positive");
                return;
            }
        } else if (i < 0) {
            if (i2 > 0 || i3 > 0) {
                Year.AnonymousClass3.m("Zone offset minutes and seconds must be negative because hours is negative");
                return;
            }
        } else if ((i2 > 0 && i3 < 0) || (i2 < 0 && i3 > 0)) {
            Year.AnonymousClass3.m("Zone offset minutes and seconds must have the same sign");
            return;
        }
        if (i2 < -59 || i2 > 59) {
            LocalDate.AnonymousClass4.m("Zone offset minutes not in valid range: value ", i2, " is not in the range -59 to 59");
            return;
        }
        if (i3 < -59 || i3 > 59) {
            LocalDate.AnonymousClass4.m("Zone offset seconds not in valid range: value ", i3, " is not in the range -59 to 59");
        } else {
            if (Math.abs(i) != 18 || (i2 | i3) == 0) {
                return;
            }
            Year.AnonymousClass3.m("Zone offset not in valid range: -18:00 to +18:00");
        }
    }

    public static ZoneOffset ofTotalSeconds(int i) {
        if (i < -64800 || i > 64800) {
            Year.AnonymousClass3.m("Zone offset not in valid range: -18:00 to +18:00");
            return null;
        }
        if (i % 900 == 0) {
            Integer valueOf = Integer.valueOf(i);
            ConcurrentMap concurrentMap = SECONDS_CACHE;
            ZoneOffset zoneOffset = (ZoneOffset) concurrentMap.get(valueOf);
            if (zoneOffset != null) {
                return zoneOffset;
            }
            concurrentMap.putIfAbsent(valueOf, new ZoneOffset(i));
            ZoneOffset zoneOffset2 = (ZoneOffset) concurrentMap.get(valueOf);
            ID_CACHE.putIfAbsent(zoneOffset2.getId(), zoneOffset2);
            return zoneOffset2;
        }
        return new ZoneOffset(i);
    }

    private ZoneOffset(int i) {
        this.totalSeconds = i;
        this.id = buildId(i);
    }

    private static String buildId(int i) {
        if (i == 0) {
            return "Z";
        }
        int abs = Math.abs(i);
        int i2 = abs / 3600;
        int i3 = (abs / 60) % 60;
        StringBuilder sb = new StringBuilder(i < 0 ? "-" : "+");
        sb.append(i2 < 10 ? "0" : "");
        sb.append(i2);
        sb.append(i3 < 10 ? ":0" : ":");
        sb.append(i3);
        int i4 = abs % 60;
        if (i4 != 0) {
            sb.append(i4 < 10 ? ":0" : ":");
            sb.append(i4);
        }
        return sb.toString();
    }

    public int getTotalSeconds() {
        return this.totalSeconds;
    }

    @Override // j$.time.ZoneId
    public String getId() {
        return this.id;
    }

    @Override // j$.time.ZoneId
    public ZoneRules getRules() {
        return ZoneRules.of(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.OFFSET_SECONDS : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return super.range(temporalField);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (temporalField instanceof ChronoField) {
            Year.AnonymousClass2.m("Unsupported field: ", temporalField);
            return 0;
        }
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (temporalField instanceof ChronoField) {
            Year.AnonymousClass2.m("Unsupported field: ", temporalField);
            return 0L;
        }
        return temporalField.getFrom(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public Object query(TemporalQuery temporalQuery) {
        return (temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.zone()) ? this : super.query(temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.OFFSET_SECONDS, this.totalSeconds);
    }

    @Override // java.lang.Comparable
    public int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.totalSeconds - this.totalSeconds;
    }

    @Override // j$.time.ZoneId
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.totalSeconds == ((ZoneOffset) obj).totalSeconds;
    }

    @Override // j$.time.ZoneId
    public int hashCode() {
        return this.totalSeconds;
    }

    @Override // j$.time.ZoneId
    public String toString() {
        return this.id;
    }

    private Object writeReplace() {
        return new Ser((byte) 8, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.time.ZoneId
    public void write(DataOutput dataOutput) {
        dataOutput.writeByte(8);
        writeExternal(dataOutput);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) {
        int i = this.totalSeconds;
        int i2 = i % 900 == 0 ? i / 900 : 127;
        dataOutput.writeByte(i2);
        if (i2 == 127) {
            dataOutput.writeInt(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneOffset readExternal(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? ofTotalSeconds(dataInput.readInt()) : ofTotalSeconds(readByte * 900);
    }
}
