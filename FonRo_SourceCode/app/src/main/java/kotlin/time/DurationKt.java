package kotlin.time;

import androidx.compose.animation.core.AnimationKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: Duration.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b-\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0005\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\n\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\f\u001a/\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0001H\u0087\u008a\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0011¢\u0006\u0004\b\u000f\u0010\u0010\u001a/\u0010\r\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0001H\u0087\u008a\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0011¢\u0006\u0004\b\u0012\u0010\u0013\u001a)\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0082\u0080\u0004¢\u0006\u0002\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0082\u0080\u0004¢\u0006\u0002\u0010\u001d\u001a/\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0082\u0080\u0004¢\u0006\u0002\u0010 \u001a\u0016\u0010!\u001a\u00020\t*\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0082\u0080\u0004\u001a\u0012\u0010#\u001a\u00020\u0018*\u00020\tH\u0083\u0088\u0004b\u0002\b\u0011\u001a\u0012\u0010$\u001a\u00020\u0018*\u00020\tH\u0083\u0088\u0004b\u0002\b\u0011\u001a\u001e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0083\u0088\u0004b\u0002\b\u0011\u001a&\u0010(\u001a\u00020\t*\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\u0080\u0004\u001a\u0016\u0010*\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\u0080\u0004\u001a%\u0010+\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010,\u001a\u00020\u0016H\u0083\u0088\u0004b\u0002\b\u0011¢\u0006\u0002\u0010-\u001a'\u0010.\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000100H\u0082\u0088\u0004¢\u0006\u0004\b1\u00102\u001a\u0018\u00103\u001a\u0004\u0018\u00010\u0004*\u00020\u00162\u0006\u00104\u001a\u00020\u0002H\u0082\u0080\u0004\u001a\u0018\u00105\u001a\u0004\u0018\u00010\u0004*\u00020\u00162\u0006\u00104\u001a\u00020\u0002H\u0082\u0080\u0004\u001a\u0012\u0010A\u001a\u00020\t*\u00020\tH\u0083\u0088\u0004b\u0002\b\u0011\u001a\u0012\u0010A\u001a\u00020\u0002*\u00020\u0002H\u0083\u0088\u0004b\u0002\b\u0011\u001a\u0012\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\tH\u0082\u0080\u0004\u001a\u0012\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\tH\u0082\u0080\u0004\u001a\u0017\u0010R\u001a\u00020\u00012\u0006\u0010S\u001a\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010T\u001a\u0017\u0010U\u001a\u00020\u00012\u0006\u0010V\u001a\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010T\u001a\u001f\u0010W\u001a\u00020\u00012\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\u0002H\u0082\u0080\u0004¢\u0006\u0002\u0010Z\u001a\u0017\u0010[\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010T\u001a\u0017\u0010\\\u001a\u00020\u00012\u0006\u0010Q\u001a\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010T\"\u001f\u00106\u001a\u00020\u000b*\u00020\u00048BX\u0082\u0084\b¢\u0006\f\u0012\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0019\u0010;\u001a\u00020\t*\u00020\u00048BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b<\u0010=\"\u0019\u0010>\u001a\u00020\u0002*\u00020\u00048BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b?\u0010@\"\u000f\u0010B\u001a\u00020\u0002X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010C\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010D\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010E\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010F\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010G\u001a\u00020\tX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010H\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010I\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010J\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010K\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010L\u001a\u00020\u0016X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010M\u001a\u00020\u0002X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"toDuration", "Lkotlin/time/Duration;", "", "unit", "Lkotlin/time/DurationUnit;", "(ILkotlin/time/DurationUnit;)J", "Lkotlin/SinceKotlin;", "version", "1.6", "", "(JLkotlin/time/DurationUnit;)J", "", "(DLkotlin/time/DurationUnit;)J", "times", TypedValues.TransitionType.S_DURATION, "times-mvk6XK0", "(IJ)J", "Lkotlin/internal/InlineOnly;", "times-kIfJnKk", "(DJ)J", "parseDuration", "value", "", "strictIso", "", "throwException", "(Ljava/lang/String;ZZ)J", "parseIsoStringFormat", "startIndex", "(Ljava/lang/String;IZ)J", "parseDefaultStringFormat", "hasSign", "(Ljava/lang/String;IZZ)J", "addMillisWithoutOverflow", WriteOffReason.OTHER, "isInfiniteMillis", "isFiniteMillis", "sameSign", "a", "b", "parseFractionFallback", "endIndex", "fractionDigitsToNanos", "handleError", "message", "(ZLjava/lang/String;)J", "onInvalid", "block", "Lkotlin/Function0;", "onInvalid-ge6A_vg", "(JLkotlin/jvm/functions/Function0;)Lkotlin/time/Duration;", "defaultDurationUnitByShortNameOrNull", "start", "isoDurationUnitByShortNameOrNull", "fractionMultiplier", "getFractionMultiplier$annotations", "(Lkotlin/time/DurationUnit;)V", "getFractionMultiplier", "(Lkotlin/time/DurationUnit;)D", "fallbackFractionMultiplier", "getFallbackFractionMultiplier", "(Lkotlin/time/DurationUnit;)J", "shortNameLength", "getShortNameLength", "(Lkotlin/time/DurationUnit;)I", "multiplyBy10", "NANOS_IN_MILLIS", "MICROS_IN_MILLIS", "NANOS_IN_MICROS", "MAX_NANOS", "MAX_MILLIS", "MAX_NANOS_IN_MILLIS", "MILLIS_IN_SECOND", "MILLIS_IN_MINUTE", "MILLIS_IN_HOUR", "MILLIS_IN_DAY", "INFINITY_STRING", "FRACTION_LIMIT", "nanosToMillis", "nanos", "millisToNanos", "millis", "durationOfNanos", "normalNanos", "(J)J", "durationOfMillis", "normalMillis", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfNanosNormalized", "durationOfMillisNormalized", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes6.dex */
public final class DurationKt {
    private static final int FRACTION_LIMIT = 15;
    private static final String INFINITY_STRING = "Infinity";
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final long MICROS_IN_MILLIS = 1000;
    public static final long MILLIS_IN_DAY = 86400000;
    public static final long MILLIS_IN_HOUR = 3600000;
    public static final long MILLIS_IN_MINUTE = 60000;
    public static final long MILLIS_IN_SECOND = 1000;
    public static final long NANOS_IN_MICROS = 1000;
    public static final int NANOS_IN_MILLIS = 1000000;

    /* compiled from: Duration.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DurationUnit.values().length];
            try {
                iArr[DurationUnit.MICROSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DurationUnit.NANOSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DurationUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DurationUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DurationUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DurationUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DurationUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static /* synthetic */ void getFractionMultiplier$annotations(DurationUnit durationUnit) {
    }

    private static final boolean isFiniteMillis(long j) {
        return -4611686018427387903L < j && j < 4611686018427387903L;
    }

    private static final boolean isInfiniteMillis(long j) {
        return j == 4611686018427387903L || j == -4611686018427387903L;
    }

    public static final long millisToNanos(long j) {
        return j * AnimationKt.MillisToNanos;
    }

    private static final int multiplyBy10(int i) {
        return (i << 3) + (i << 1);
    }

    private static final long multiplyBy10(long j) {
        return (j << 3) + (j << 1);
    }

    private static final boolean sameSign(long j, long j2) {
        return (j ^ j2) >= 0;
    }

    public static final long toDuration(int i, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit.compareTo(DurationUnit.SECONDS) <= 0) {
            return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(i, unit, DurationUnit.NANOSECONDS));
        }
        return toDuration(i, unit);
    }

    public static final long toDuration(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long convertDurationUnitOverflow = DurationUnitKt.convertDurationUnitOverflow(MAX_NANOS, DurationUnit.NANOSECONDS, unit);
        if ((-convertDurationUnitOverflow) <= j && j <= convertDurationUnitOverflow) {
            return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(j, unit, DurationUnit.NANOSECONDS));
        }
        if (unit.compareTo(DurationUnit.MILLISECONDS) >= 0) {
            return durationOfMillis(MathKt.getSign(j) * DurationUnitKt.convertDurationUnitToMilliseconds(Math.abs(RangesKt.coerceAtLeast(j, -9223372036854775807L)), unit));
        }
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt.convertDurationUnit(j, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
    }

    public static final long toDuration(double d, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        double convertDurationUnit = DurationUnitKt.convertDurationUnit(d, unit, DurationUnit.NANOSECONDS);
        if (Double.isNaN(convertDurationUnit)) {
            throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
        }
        long roundToLong = MathKt.roundToLong(convertDurationUnit);
        if (-4611686018426999999L <= roundToLong && roundToLong < 4611686018427000000L) {
            return durationOfNanos(roundToLong);
        }
        return durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt.convertDurationUnit(d, unit, DurationUnit.MILLISECONDS)));
    }

    /* renamed from: times-mvk6XK0 */
    private static final long m9386timesmvk6XK0(int i, long j) {
        return Duration.m9315timesUwyO8pc(j, i);
    }

    /* renamed from: times-kIfJnKk */
    private static final long m9385timeskIfJnKk(double d, long j) {
        return Duration.m9314timesUwyO8pc(j, d);
    }

    public static /* synthetic */ long parseDuration$default(String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        return parseDuration(str, z, z2);
    }

    public static final long parseDuration(String str, boolean z, boolean z2) {
        int i;
        int i2;
        long parseDefaultStringFormat;
        if (str.length() == 0) {
            if (z2) {
                throw new IllegalArgumentException("The string is empty");
            }
            return Duration.INSTANCE.m9377getINVALIDUwyO8pc$kotlin_stdlib();
        }
        char charAt = str.charAt(0);
        if (charAt != '+') {
            i = charAt != '-' ? 0 : 1;
            i2 = i;
        } else {
            i = 0;
            i2 = 1;
        }
        boolean z3 = i2 > 0;
        if (str.length() <= i2) {
            if (z2) {
                throw new IllegalArgumentException("No components");
            }
            return Duration.INSTANCE.m9377getINVALIDUwyO8pc$kotlin_stdlib();
        }
        if (str.charAt(i2) == 'P') {
            parseDefaultStringFormat = parseIsoStringFormat(str, i2 + 1, z2);
        } else {
            if (z) {
                if (z2) {
                    throw new IllegalArgumentException("");
                }
                return Duration.INSTANCE.m9377getINVALIDUwyO8pc$kotlin_stdlib();
            }
            if (StringsKt.regionMatches(str, i2, INFINITY_STRING, 0, Math.max(str.length() - i2, 8), true)) {
                parseDefaultStringFormat = Duration.INSTANCE.m9376getINFINITEUwyO8pc();
            } else {
                parseDefaultStringFormat = parseDefaultStringFormat(str, i2, z3, z2);
            }
        }
        return (i == 0 || Duration.m9289equalsimpl0(parseDefaultStringFormat, Duration.INSTANCE.m9377getINVALIDUwyO8pc$kotlin_stdlib())) ? parseDefaultStringFormat : Duration.m9328unaryMinusUwyO8pc(parseDefaultStringFormat);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01d1, code lost:
    
        r9 = r15 * fractionDigitsToNanos((r10 * 1000000000) + r13, kotlin.time.DurationUnit.SECONDS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01c6, code lost:
    
        if (r5 == r23.length()) goto L417;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01ce, code lost:
    
        if (r23.charAt(r5) == 'S') goto L352;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0101 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x028c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0082 A[ADDED_TO_REGION, EDGE_INSN: B:198:0x0082->B:28:0x0082 BREAK  A[LOOP:1: B:22:0x006f->B:26:0x007d], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final long parseIsoStringFormat(java.lang.String r23, int r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 684
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.DurationKt.parseIsoStringFormat(java.lang.String, int, boolean):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0193, code lost:
    
        if (r10 != r1) goto L304;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0196, code lost:
    
        r2 = (r14 * 1000000000) + r12;
        r4 = r13;
        r13 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d0, code lost:
    
        if (r13 >= r25.length()) goto L385;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d2, code lost:
    
        r1 = r25.charAt(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d8, code lost:
    
        if ('0' > r1) goto L386;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00da, code lost:
    
        if (r1 >= ':') goto L387;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00dc, code lost:
    
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00df, code lost:
    
        if (r28 != false) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e7, code lost:
    
        return kotlin.time.Duration.INSTANCE.m9377getINVALIDUwyO8pc$kotlin_stdlib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ed, code lost:
    
        throw new java.lang.IllegalArgumentException("");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final long parseDefaultStringFormat(java.lang.String r25, int r26, boolean r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 672
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.DurationKt.parseDefaultStringFormat(java.lang.String, int, boolean, boolean):long");
    }

    public static final long addMillisWithoutOverflow(long j, long j2) {
        return (j == 4611686018427387903L || j == -4611686018427387903L) ? ((-4611686018427387903L >= j2 || j2 >= 4611686018427387903L) && (j2 ^ j) < 0) ? Duration.INVALID_RAW_VALUE : j : (j2 == 4611686018427387903L || j2 == -4611686018427387903L) ? j2 : RangesKt.coerceIn(j + j2, -4611686018427387903L, 4611686018427387903L);
    }

    private static final long parseFractionFallback(String str, int i, int i2, DurationUnit durationUnit) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return MathKt.roundToLong(Double.parseDouble(substring) * getFallbackFractionMultiplier(durationUnit));
    }

    private static final long fractionDigitsToNanos(long j, DurationUnit durationUnit) {
        return MathKt.roundToLong(j * getFractionMultiplier(durationUnit));
    }

    static /* synthetic */ long handleError$default(boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        if (z) {
            throw new IllegalArgumentException(str);
        }
        return Duration.INSTANCE.m9377getINVALIDUwyO8pc$kotlin_stdlib();
    }

    private static final long handleError(boolean z, String str) {
        if (z) {
            throw new IllegalArgumentException(str);
        }
        return Duration.INSTANCE.m9377getINVALIDUwyO8pc$kotlin_stdlib();
    }

    /* renamed from: onInvalid-ge6A_vg */
    private static final Duration m9384onInvalidge6A_vg(long j, Function0<Duration> function0) {
        return Duration.m9289equalsimpl0(j, Duration.INSTANCE.m9377getINVALIDUwyO8pc$kotlin_stdlib()) ? function0.invoke() : Duration.m9282boximpl(j);
    }

    private static final DurationUnit defaultDurationUnitByShortNameOrNull(String str, int i) {
        char charAt = str.charAt(i);
        char charAt2 = i < StringsKt.getLastIndex(str) ? str.charAt(i + 1) : (char) 0;
        if (charAt == 'd') {
            return DurationUnit.DAYS;
        }
        if (charAt == 'h') {
            return DurationUnit.HOURS;
        }
        if (charAt == 's') {
            return DurationUnit.SECONDS;
        }
        if (charAt == 'u') {
            if (charAt2 == 's') {
                return DurationUnit.MICROSECONDS;
            }
            return null;
        }
        if (charAt == 'm') {
            return charAt2 == 's' ? DurationUnit.MILLISECONDS : DurationUnit.MINUTES;
        }
        if (charAt == 'n' && charAt2 == 's') {
            return DurationUnit.NANOSECONDS;
        }
        return null;
    }

    private static final DurationUnit isoDurationUnitByShortNameOrNull(String str, int i) {
        char charAt = str.charAt(i);
        if (charAt == 'D') {
            return DurationUnit.DAYS;
        }
        if (charAt == 'H') {
            return DurationUnit.HOURS;
        }
        if (charAt == 'M') {
            return DurationUnit.MINUTES;
        }
        if (charAt != 'S') {
            return null;
        }
        return DurationUnit.SECONDS;
    }

    private static final double getFractionMultiplier(DurationUnit durationUnit) {
        switch (WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()]) {
            case 1:
                return 1.0E-12d;
            case 2:
                return 1.0E-15d;
            case 3:
                return 1.0E-9d;
            case 4:
                return 1.0E-6d;
            case 5:
                return 6.0E-5d;
            case 6:
                return 0.0036d;
            case 7:
                return 0.0864d;
            default:
                throw new IllegalStateException(("Unknown unit: " + durationUnit).toString());
        }
    }

    private static final long getFallbackFractionMultiplier(DurationUnit durationUnit) {
        int i = WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()];
        if (i == 5) {
            return 60000000000L;
        }
        if (i == 6) {
            return 3600000000000L;
        }
        if (i == 7) {
            return 86400000000000L;
        }
        throw new IllegalStateException(("Invalid unit: " + durationUnit + " for fallback fraction multiplier").toString());
    }

    private static final int getShortNameLength(DurationUnit durationUnit) {
        int i = WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()];
        return (i == 1 || i == 2 || i == 3) ? 2 : 1;
    }

    public static final long nanosToMillis(long j) {
        return j / AnimationKt.MillisToNanos;
    }

    public static final long durationOfNanos(long j) {
        return Duration.INSTANCE.m9375fromRawValueUwyO8pc$kotlin_stdlib(j << 1);
    }

    public static final long durationOfMillis(long j) {
        return Duration.INSTANCE.m9375fromRawValueUwyO8pc$kotlin_stdlib((j << 1) + 1);
    }

    public static final long durationOf(long j, int i) {
        return Duration.INSTANCE.m9375fromRawValueUwyO8pc$kotlin_stdlib((j << 1) + i);
    }

    public static final long durationOfNanosNormalized(long j) {
        if (-4611686018426999999L <= j && j < 4611686018427000000L) {
            return durationOfNanos(j);
        }
        return durationOfMillis(nanosToMillis(j));
    }

    public static final long durationOfMillisNormalized(long j) {
        if (-4611686018426L <= j && j < 4611686018427L) {
            return durationOfNanos(millisToNanos(j));
        }
        return durationOfMillis(RangesKt.coerceIn(j, -4611686018427387903L, 4611686018427387903L));
    }
}
