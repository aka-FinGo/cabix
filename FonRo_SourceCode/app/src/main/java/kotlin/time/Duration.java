package kotlin.time;

import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: Duration.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087@\u0018\u0000 \u0090\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0090\u0001B+\bA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\b\t\u0012\u0006\b\n0\n8\u000b¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0012\u001a\u00020\u0013H\u0082\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0013H\u0082\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0015J\u0011\u0010\u001c\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b\u001d\u0010\u0005J\u0019\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b \u0010!J!\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0082\u0080\u0004¢\u0006\u0004\b%\u0010&J\u0019\u0010'\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b(\u0010!J\u0019\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u000fH\u0086\u0082\u0004¢\u0006\u0004\b+\u0010,J\u0019\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020-H\u0086\u0082\u0004¢\u0006\u0004\b+\u0010.J\u0019\u0010/\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u000fH\u0086\u0082\u0004¢\u0006\u0004\b0\u0010,J\u0019\u0010/\u001a\u00020\u00002\u0006\u0010*\u001a\u00020-H\u0086\u0082\u0004¢\u0006\u0004\b0\u0010.J\u0019\u0010/\u001a\u00020-2\u0006\u0010\u001f\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b1\u00102J\u0019\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0019H\u0080\u0080\u0004¢\u0006\u0004\b5\u00106J\u0011\u00107\u001a\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\b8\u0010\u0015J\u0011\u00109\u001a\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\b:\u0010\u0015J\u0011\u0010;\u001a\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\b<\u0010\u0015J\u0011\u0010=\u001a\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\b>\u0010\u0015J\u0019\u0010A\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0000H\u0096\u0082\u0004¢\u0006\u0004\bB\u0010CJ\u009e\u0001\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2u\u0010F\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0GH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010PJ\u0089\u0001\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2`\u0010F\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0QH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010RJt\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2K\u0010F\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0SH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010TJ_\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E26\u0010F\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0UH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010VJ\u0019\u0010e\u001a\u00020-2\u0006\u00104\u001a\u00020\u0019H\u0086\u0080\u0004¢\u0006\u0004\bf\u0010gJ\u0019\u0010h\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0019H\u0086\u0080\u0004¢\u0006\u0004\bi\u00106J\u0019\u0010j\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u0019H\u0086\u0080\u0004¢\u0006\u0004\bk\u0010lJ\u0011\u0010{\u001a\u00020|H\u0096\u0080\u0004¢\u0006\u0004\b}\u0010~JJ\u0010\u007f\u001a\u00030\u0080\u0001*\b0\u0081\u0001j\u0003`\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u000f2\u0007\u0010\u0084\u0001\u001a\u00020\u000f2\u0007\u0010\u0085\u0001\u001a\u00020\u000f2\u0006\u00104\u001a\u00020|2\u0007\u0010\u0086\u0001\u001a\u00020\u0013H\u0082\u0080\u0004¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J%\u0010{\u001a\u00020|2\u0006\u00104\u001a\u00020\u00192\t\b\u0002\u0010\u0089\u0001\u001a\u00020\u000fH\u0086\u0080\u0004¢\u0006\u0005\b}\u0010\u008a\u0001J\u0013\u0010\u008b\u0001\u001a\u00020|H\u0086\u0080\u0004¢\u0006\u0005\b\u008c\u0001\u0010~J\u0016\u0010\u008d\u0001\u001a\u00020\u00132\t\u0010\u001f\u001a\u0005\u0018\u00010\u008e\u0001HÖ\u0083\u0004J\u000b\u0010\u008f\u0001\u001a\u00020\u000fHÖ\u0081\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\f\u001a\u00020\u00038BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0016\u0010\u000e\u001a\u00020\u000f8Â\u0002X\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010?\u001a\u00020\u00008FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b@\u0010\u0005R\u001f\u0010W\u001a\u00020\u000f8@X\u0081\u0084\br\u0002\b[¢\u0006\f\u0012\u0004\bX\u0010Y\u001a\u0004\bZ\u0010\u0011R\u001f\u0010\\\u001a\u00020\u000f8@X\u0081\u0084\br\u0002\b[¢\u0006\f\u0012\u0004\b]\u0010Y\u001a\u0004\b^\u0010\u0011R\u001f\u0010_\u001a\u00020\u000f8@X\u0081\u0084\br\u0002\b[¢\u0006\f\u0012\u0004\b`\u0010Y\u001a\u0004\ba\u0010\u0011R\u001f\u0010b\u001a\u00020\u000f8@X\u0081\u0084\br\u0002\b[¢\u0006\f\u0012\u0004\bc\u0010Y\u001a\u0004\bd\u0010\u0011R\u0015\u0010m\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bn\u0010\u0005R\u0015\u0010o\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bp\u0010\u0005R\u0015\u0010q\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\br\u0010\u0005R\u0015\u0010s\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bt\u0010\u0005R\u0015\u0010u\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bv\u0010\u0005R\u0015\u0010w\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bx\u0010\u0005R\u0015\u0010y\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bz\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003Ê\u0001\u000f\b\u0092\u0001\u0012\n\b\u0093\u0001\u0012\u0005\b\b(\u0094\u0001Ê\u0001\u0003\b\u0095\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0091\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "Lkotlin/Deprecated;", "message", "Don't call this constructor directly.", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "ERROR", "value", "getValue-impl", "unitDiscriminator", "", "getUnitDiscriminator-impl", "(J)I", "isInNanos", "", "isInNanos-impl", "(J)Z", "isInMillis", "isInMillis-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unaryMinus", "unaryMinus-UwyO8pc", "plus", WriteOffReason.OTHER, "plus-LRDsOJo", "(JJ)J", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "minus", "minus-LRDsOJo", "times", "scale", "times-UwyO8pc", "(JI)J", "", "(JD)J", "div", "div-UwyO8pc", "div-LRDsOJo", "(JJ)D", "truncateTo", "unit", "truncateTo-UwyO8pc$kotlin_stdlib", "(JLkotlin/time/DurationUnit;)J", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "isInfinite", "isInfinite-impl", "isFinite", "isFinite-impl", "absoluteValue", "getAbsoluteValue-UwyO8pc", "compareTo", "compareTo-LRDsOJo", "(JJ)I", "toComponents", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "hoursComponent", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "Lkotlin/PublishedApi;", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "toDouble", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toLong", "toLong-impl", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeSeconds", "getInWholeSeconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "toIsoString", "toIsoString-impl", "equals", "", "hashCode", "Companion", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.6", "Lkotlin/jvm/JvmInline;"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes6.dex */
public final class Duration implements Comparable<Duration> {
    private final long rawValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long ZERO = m9284constructorimpl(0);
    private static final long INFINITE = DurationKt.access$durationOfMillis(4611686018427387903L);
    private static final long NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);
    public static final long INVALID_RAW_VALUE = 9223372036854759646L;
    private static final long INVALID = m9284constructorimpl(INVALID_RAW_VALUE);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m9282boximpl(long j) {
        return new Duration(j);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Don't call this constructor directly.")
    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m9284constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m9288equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).getRawValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m9289equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* renamed from: getUnitDiscriminator-impl, reason: not valid java name */
    private static final int m9303getUnitDiscriminatorimpl(long j) {
        return ((int) j) & 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getValue-impl, reason: not valid java name */
    public static final long m9304getValueimpl(long j) {
        return j >> 1;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m9305hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m9307isInMillisimpl(long j) {
        return (((int) j) & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isInNanos-impl, reason: not valid java name */
    public static final boolean m9308isInNanosimpl(long j) {
        return (((int) j) & 1) == 0;
    }

    /* renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m9310isNegativeimpl(long j) {
        return j < 0;
    }

    /* renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m9311isPositiveimpl(long j) {
        return j > 0;
    }

    public boolean equals(Object other) {
        return m9288equalsimpl(this.rawValue, other);
    }

    public int hashCode() {
        return m9305hashCodeimpl(this.rawValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getRawValue() {
        return this.rawValue;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m9329compareToLRDsOJo(duration.getRawValue());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Don't call this constructor directly.")
    private /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    /* renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final DurationUnit m9302getStorageUnitimpl(long j) {
        return m9308isInNanosimpl(j) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    /* compiled from: Duration.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\u0080\u0004¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0087\u0080\u0004b\u0002\b\u001dJ\u0019\u0010:\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020;H\u0086\u0080\u0004¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020;H\u0086\u0080\u0004¢\u0006\u0004\b?\u0010=J\u0019\u0010@\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020;H\u0086\u0080\u0004¢\u0006\u0002\bAJ\u0019\u0010B\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020;H\u0086\u0080\u0004¢\u0006\u0002\bCR\u001d\u0010\n\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0011\u001a\u00020\u0005X\u0080\u0084\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u000f\u0010\u0013\u001a\u00020\u0007X\u0080Ô\b¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u00020\u0005X\u0080\u0084\b¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\rR$\u0010\u001e\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#R$\u0010\u001e\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b \u0010%\u001a\u0004\b\"\u0010\tR$\u0010\u001e\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b \u0010&\u001a\u0004\b\"\u0010'R$\u0010(\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b)\u0010!\u001a\u0004\b*\u0010#R$\u0010(\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b)\u0010%\u001a\u0004\b*\u0010\tR$\u0010(\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b)\u0010&\u001a\u0004\b*\u0010'R$\u0010+\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b,\u0010!\u001a\u0004\b-\u0010#R$\u0010+\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b,\u0010%\u001a\u0004\b-\u0010\tR$\u0010+\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b,\u0010&\u001a\u0004\b-\u0010'R$\u0010.\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b/\u0010!\u001a\u0004\b0\u0010#R$\u0010.\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b/\u0010%\u001a\u0004\b0\u0010\tR$\u0010.\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b/\u0010&\u001a\u0004\b0\u0010'R$\u00101\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b2\u0010!\u001a\u0004\b3\u0010#R$\u00101\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b2\u0010%\u001a\u0004\b3\u0010\tR$\u00101\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b2\u0010&\u001a\u0004\b3\u0010'R$\u00104\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b5\u0010!\u001a\u0004\b6\u0010#R$\u00104\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b5\u0010%\u001a\u0004\b6\u0010\tR$\u00104\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b5\u0010&\u001a\u0004\b6\u0010'R$\u00107\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b8\u0010!\u001a\u0004\b9\u0010#R$\u00107\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b8\u0010%\u001a\u0004\b9\u0010\tR$\u00107\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b8\u0010&\u001a\u0004\b9\u0010'¨\u0006D"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "<init>", "()V", "fromRawValue", "Lkotlin/time/Duration;", "rawValue", "", "fromRawValue-UwyO8pc$kotlin_stdlib", "(J)J", "ZERO", "getZERO-UwyO8pc$annotations", "getZERO-UwyO8pc", "()J", "J", "INFINITE", "getINFINITE-UwyO8pc", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "INVALID_RAW_VALUE", "INVALID", "getINVALID-UwyO8pc$kotlin_stdlib$annotations", "getINVALID-UwyO8pc$kotlin_stdlib", "convert", "", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "Lkotlin/time/ExperimentalTime;", "nanoseconds", "", "getNanoseconds-UwyO8pc$annotations", "(I)V", "getNanoseconds-UwyO8pc", "(I)J", "Lkotlin/internal/InlineOnly;", "(J)V", "(D)V", "(D)J", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "days", "getDays-UwyO8pc$annotations", "getDays-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseOrNull", "parseOrNull-FghU774", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9334getDaysUwyO8pc$annotations(double d) {
        }

        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9335getDaysUwyO8pc$annotations(int i) {
        }

        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9336getDaysUwyO8pc$annotations(long j) {
        }

        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9340getHoursUwyO8pc$annotations(double d) {
        }

        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9341getHoursUwyO8pc$annotations(int i) {
        }

        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9342getHoursUwyO8pc$annotations(long j) {
        }

        /* renamed from: getINVALID-UwyO8pc$kotlin_stdlib$annotations, reason: not valid java name */
        public static /* synthetic */ void m9343getINVALIDUwyO8pc$kotlin_stdlib$annotations() {
        }

        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9347getMicrosecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9348getMicrosecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9349getMicrosecondsUwyO8pc$annotations(long j) {
        }

        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9353getMillisecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9354getMillisecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9355getMillisecondsUwyO8pc$annotations(long j) {
        }

        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9359getMinutesUwyO8pc$annotations(double d) {
        }

        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9360getMinutesUwyO8pc$annotations(int i) {
        }

        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9361getMinutesUwyO8pc$annotations(long j) {
        }

        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9365getNanosecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9366getNanosecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9367getNanosecondsUwyO8pc$annotations(long j) {
        }

        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9371getSecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9372getSecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9373getSecondsUwyO8pc$annotations(long j) {
        }

        /* renamed from: getZERO-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m9374getZEROUwyO8pc$annotations() {
        }

        private Companion() {
        }

        /* renamed from: fromRawValue-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m9375fromRawValueUwyO8pc$kotlin_stdlib(long rawValue) {
            long m9284constructorimpl = Duration.m9284constructorimpl(rawValue);
            if (DurationJvmKt.getDurationAssertionsEnabled()) {
                if (Duration.m9308isInNanosimpl(m9284constructorimpl)) {
                    long m9304getValueimpl = Duration.m9304getValueimpl(m9284constructorimpl);
                    if (-4611686018426999999L <= m9304getValueimpl && m9304getValueimpl < 4611686018427000000L) {
                        return m9284constructorimpl;
                    }
                    throw new AssertionError(Duration.m9304getValueimpl(m9284constructorimpl) + " ns is out of nanoseconds range");
                }
                long m9304getValueimpl2 = Duration.m9304getValueimpl(m9284constructorimpl);
                if (-4611686018427387903L >= m9304getValueimpl2 || m9304getValueimpl2 >= 4611686018427387903L) {
                    long m9304getValueimpl3 = Duration.m9304getValueimpl(m9284constructorimpl);
                    if (m9304getValueimpl3 != 4611686018427387903L && m9304getValueimpl3 != -4611686018427387903L) {
                        throw new AssertionError(Duration.m9304getValueimpl(m9284constructorimpl) + " ms is out of milliseconds range");
                    }
                }
                long m9304getValueimpl4 = Duration.m9304getValueimpl(m9284constructorimpl);
                if (-4611686018426L > m9304getValueimpl4 || m9304getValueimpl4 >= 4611686018427L) {
                    return m9284constructorimpl;
                }
                throw new AssertionError(Duration.m9304getValueimpl(m9284constructorimpl) + " ms is denormalized");
            }
            return m9284constructorimpl;
        }

        /* renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m9379getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        /* renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m9376getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m9378getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        /* renamed from: getINVALID-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m9377getINVALIDUwyO8pc$kotlin_stdlib() {
            return Duration.INVALID;
        }

        public final double convert(double value, DurationUnit sourceUnit, DurationUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return DurationUnitKt.convertDurationUnit(value, sourceUnit, targetUnit);
        }

        /* renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m9363getNanosecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.NANOSECONDS);
        }

        /* renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m9364getNanosecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.NANOSECONDS);
        }

        /* renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m9362getNanosecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.NANOSECONDS);
        }

        /* renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m9345getMicrosecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MICROSECONDS);
        }

        /* renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m9346getMicrosecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MICROSECONDS);
        }

        /* renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m9344getMicrosecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MICROSECONDS);
        }

        /* renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m9351getMillisecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MILLISECONDS);
        }

        /* renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m9352getMillisecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MILLISECONDS);
        }

        /* renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m9350getMillisecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MILLISECONDS);
        }

        /* renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m9369getSecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.SECONDS);
        }

        /* renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m9370getSecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.SECONDS);
        }

        /* renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m9368getSecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.SECONDS);
        }

        /* renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m9357getMinutesUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MINUTES);
        }

        /* renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m9358getMinutesUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MINUTES);
        }

        /* renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m9356getMinutesUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MINUTES);
        }

        /* renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m9338getHoursUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.HOURS);
        }

        /* renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m9339getHoursUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.HOURS);
        }

        /* renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m9337getHoursUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.HOURS);
        }

        /* renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m9332getDaysUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.DAYS);
        }

        /* renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m9333getDaysUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.DAYS);
        }

        /* renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m9331getDaysUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.DAYS);
        }

        /* renamed from: parse-UwyO8pc, reason: not valid java name */
        public final long m9380parseUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                long parseDuration$default = DurationKt.parseDuration$default(value, false, false, 4, null);
                if (Duration.m9289equalsimpl0(parseDuration$default, Duration.INSTANCE.m9377getINVALIDUwyO8pc$kotlin_stdlib())) {
                    throw new IllegalStateException("invariant failed".toString());
                }
                return parseDuration$default;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e);
            }
        }

        /* renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m9381parseIsoStringUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                long parseDuration$default = DurationKt.parseDuration$default(value, true, false, 4, null);
                if (Duration.m9289equalsimpl0(parseDuration$default, Duration.INSTANCE.m9377getINVALIDUwyO8pc$kotlin_stdlib())) {
                    throw new IllegalStateException("invariant failed".toString());
                }
                return parseDuration$default;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }

        /* renamed from: parseOrNull-FghU774, reason: not valid java name */
        public final Duration m9383parseOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            long access$parseDuration = DurationKt.access$parseDuration(value, false, false);
            if (Duration.m9289equalsimpl0(access$parseDuration, Duration.INSTANCE.m9377getINVALIDUwyO8pc$kotlin_stdlib())) {
                return null;
            }
            return Duration.m9282boximpl(access$parseDuration);
        }

        /* renamed from: parseIsoStringOrNull-FghU774, reason: not valid java name */
        public final Duration m9382parseIsoStringOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            long access$parseDuration = DurationKt.access$parseDuration(value, true, false);
            if (Duration.m9289equalsimpl0(access$parseDuration, Duration.INSTANCE.m9377getINVALIDUwyO8pc$kotlin_stdlib())) {
                return null;
            }
            return Duration.m9282boximpl(access$parseDuration);
        }
    }

    /* renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m9328unaryMinusUwyO8pc(long j) {
        return DurationKt.access$durationOf(-m9304getValueimpl(j), ((int) j) & 1);
    }

    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m9313plusLRDsOJo(long j, long j2) {
        if ((((int) j) & 1) != (((int) j2) & 1)) {
            return m9307isInMillisimpl(j) ? m9280addValuesMixedRangesUwyO8pc(j, m9304getValueimpl(j), m9304getValueimpl(j2)) : m9280addValuesMixedRangesUwyO8pc(j, m9304getValueimpl(j2), m9304getValueimpl(j));
        }
        if (m9308isInNanosimpl(j)) {
            return DurationKt.access$durationOfNanosNormalized(m9304getValueimpl(j) + m9304getValueimpl(j2));
        }
        long access$addMillisWithoutOverflow = DurationKt.access$addMillisWithoutOverflow(m9304getValueimpl(j), m9304getValueimpl(j2));
        if (access$addMillisWithoutOverflow == INVALID_RAW_VALUE) {
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (access$addMillisWithoutOverflow == 4611686018427387903L || access$addMillisWithoutOverflow == -4611686018427387903L) {
            return DurationKt.access$durationOfMillis(access$addMillisWithoutOverflow);
        }
        return DurationKt.access$durationOfMillisNormalized(access$addMillisWithoutOverflow);
    }

    /* renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    private static final long m9280addValuesMixedRangesUwyO8pc(long j, long j2, long j3) {
        long access$nanosToMillis = DurationKt.access$nanosToMillis(j3);
        long access$addMillisWithoutOverflow = DurationKt.access$addMillisWithoutOverflow(j2, access$nanosToMillis);
        if (-4611686018426L <= access$addMillisWithoutOverflow && access$addMillisWithoutOverflow < 4611686018427L) {
            return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(access$addMillisWithoutOverflow) + (j3 - DurationKt.access$millisToNanos(access$nanosToMillis)));
        }
        return DurationKt.access$durationOfMillis(access$addMillisWithoutOverflow);
    }

    /* renamed from: minus-LRDsOJo, reason: not valid java name */
    public static final long m9312minusLRDsOJo(long j, long j2) {
        return m9313plusLRDsOJo(j, m9328unaryMinusUwyO8pc(j2));
    }

    /* renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m9315timesUwyO8pc(long j, int i) {
        if (m9309isInfiniteimpl(j)) {
            if (i != 0) {
                return i > 0 ? j : m9328unaryMinusUwyO8pc(j);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i == 0) {
            return ZERO;
        }
        long m9304getValueimpl = m9304getValueimpl(j);
        long j2 = i;
        long j3 = m9304getValueimpl * j2;
        if (!m9308isInNanosimpl(j)) {
            if (j3 / j2 == m9304getValueimpl) {
                return DurationKt.access$durationOfMillis(RangesKt.coerceIn(j3, new LongRange(-4611686018427387903L, 4611686018427387903L)));
            }
            return MathKt.getSign(m9304getValueimpl) * MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
        }
        if (-2147483647L <= m9304getValueimpl && m9304getValueimpl < 2147483648L) {
            return DurationKt.access$durationOfNanos(j3);
        }
        if (j3 / j2 == m9304getValueimpl) {
            return DurationKt.access$durationOfNanosNormalized(j3);
        }
        long access$nanosToMillis = DurationKt.access$nanosToMillis(m9304getValueimpl);
        long j4 = access$nanosToMillis * j2;
        long access$nanosToMillis2 = DurationKt.access$nanosToMillis((m9304getValueimpl - DurationKt.access$millisToNanos(access$nanosToMillis)) * j2) + j4;
        if (j4 / j2 != access$nanosToMillis || (access$nanosToMillis2 ^ j4) < 0) {
            return MathKt.getSign(m9304getValueimpl) * MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
        }
        return DurationKt.access$durationOfMillis(RangesKt.coerceIn(access$nanosToMillis2, new LongRange(-4611686018427387903L, 4611686018427387903L)));
    }

    /* renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m9314timesUwyO8pc(long j, double d) {
        int roundToInt = MathKt.roundToInt(d);
        if (roundToInt == d) {
            return m9315timesUwyO8pc(j, roundToInt);
        }
        DurationUnit m9302getStorageUnitimpl = m9302getStorageUnitimpl(j);
        return DurationKt.toDuration(m9320toDoubleimpl(j, m9302getStorageUnitimpl) * d, m9302getStorageUnitimpl);
    }

    /* renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m9287divUwyO8pc(long j, int i) {
        if (i == 0) {
            if (m9311isPositiveimpl(j)) {
                return INFINITE;
            }
            if (m9310isNegativeimpl(j)) {
                return NEG_INFINITE;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if (m9308isInNanosimpl(j)) {
            return DurationKt.access$durationOfNanos(m9304getValueimpl(j) / i);
        }
        if (m9309isInfiniteimpl(j)) {
            return m9315timesUwyO8pc(j, MathKt.getSign(i));
        }
        long j2 = i;
        long m9304getValueimpl = m9304getValueimpl(j) / j2;
        if (-4611686018426L <= m9304getValueimpl && m9304getValueimpl < 4611686018427L) {
            return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(m9304getValueimpl) + (DurationKt.access$millisToNanos(m9304getValueimpl(j) - (m9304getValueimpl * j2)) / j2));
        }
        return DurationKt.access$durationOfMillis(m9304getValueimpl);
    }

    /* renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m9286divUwyO8pc(long j, double d) {
        int roundToInt = MathKt.roundToInt(d);
        if (roundToInt == d && roundToInt != 0) {
            return m9287divUwyO8pc(j, roundToInt);
        }
        DurationUnit m9302getStorageUnitimpl = m9302getStorageUnitimpl(j);
        return DurationKt.toDuration(m9320toDoubleimpl(j, m9302getStorageUnitimpl) / d, m9302getStorageUnitimpl);
    }

    /* renamed from: div-LRDsOJo, reason: not valid java name */
    public static final double m9285divLRDsOJo(long j, long j2) {
        DurationUnit durationUnit = (DurationUnit) ComparisonsKt.maxOf(m9302getStorageUnitimpl(j), m9302getStorageUnitimpl(j2));
        return m9320toDoubleimpl(j, durationUnit) / m9320toDoubleimpl(j2, durationUnit);
    }

    /* renamed from: truncateTo-UwyO8pc$kotlin_stdlib, reason: not valid java name */
    public static final long m9327truncateToUwyO8pc$kotlin_stdlib(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit m9302getStorageUnitimpl = m9302getStorageUnitimpl(j);
        if (unit.compareTo(m9302getStorageUnitimpl) <= 0 || m9309isInfiniteimpl(j)) {
            return j;
        }
        return DurationKt.toDuration(m9304getValueimpl(j) - (m9304getValueimpl(j) % DurationUnitKt.convertDurationUnit(1L, unit, m9302getStorageUnitimpl)), m9302getStorageUnitimpl);
    }

    /* renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m9309isInfiniteimpl(long j) {
        return j == INFINITE || j == NEG_INFINITE;
    }

    /* renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m9306isFiniteimpl(long j) {
        return !m9309isInfiniteimpl(j);
    }

    /* renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m9290getAbsoluteValueUwyO8pc(long j) {
        return m9310isNegativeimpl(j) ? m9328unaryMinusUwyO8pc(j) : j;
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m9329compareToLRDsOJo(long j) {
        return m9283compareToLRDsOJo(this.rawValue, j);
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m9283compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return Intrinsics.compare(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m9310isNegativeimpl(j) ? -i : i;
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m9319toComponentsimpl(long j, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m9292getInWholeDaysimpl(j)), Integer.valueOf(m9291getHoursComponentimpl(j)), Integer.valueOf(m9299getMinutesComponentimpl(j)), Integer.valueOf(m9301getSecondsComponentimpl(j)), Integer.valueOf(m9300getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m9318toComponentsimpl(long j, Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m9293getInWholeHoursimpl(j)), Integer.valueOf(m9299getMinutesComponentimpl(j)), Integer.valueOf(m9301getSecondsComponentimpl(j)), Integer.valueOf(m9300getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m9317toComponentsimpl(long j, Function3<? super Long, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m9296getInWholeMinutesimpl(j)), Integer.valueOf(m9301getSecondsComponentimpl(j)), Integer.valueOf(m9300getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m9316toComponentsimpl(long j, Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m9298getInWholeSecondsimpl(j)), Integer.valueOf(m9300getNanosecondsComponentimpl(j)));
    }

    /* renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m9291getHoursComponentimpl(long j) {
        if (m9309isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m9293getInWholeHoursimpl(j) % 24);
    }

    /* renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m9299getMinutesComponentimpl(long j) {
        if (m9309isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m9296getInWholeMinutesimpl(j) % 60);
    }

    /* renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m9301getSecondsComponentimpl(long j) {
        if (m9309isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m9298getInWholeSecondsimpl(j) % 60);
    }

    /* renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m9300getNanosecondsComponentimpl(long j) {
        if (m9309isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m9307isInMillisimpl(j) ? DurationKt.access$millisToNanos(m9304getValueimpl(j) % 1000) : m9304getValueimpl(j) % 1000000000);
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    public static final double m9320toDoubleimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt.convertDurationUnit(m9304getValueimpl(j), m9302getStorageUnitimpl(j), unit);
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    public static final long m9323toLongimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt.convertDurationUnit(m9304getValueimpl(j), m9302getStorageUnitimpl(j), unit);
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    public static final int m9321toIntimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (int) RangesKt.coerceIn(m9323toLongimpl(j, unit), SieveCacheKt.NodeMetaAndPreviousMask, SieveCacheKt.NodeLinkMask);
    }

    /* renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m9292getInWholeDaysimpl(long j) {
        return m9323toLongimpl(j, DurationUnit.DAYS);
    }

    /* renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m9293getInWholeHoursimpl(long j) {
        return m9323toLongimpl(j, DurationUnit.HOURS);
    }

    /* renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m9296getInWholeMinutesimpl(long j) {
        return m9323toLongimpl(j, DurationUnit.MINUTES);
    }

    /* renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m9298getInWholeSecondsimpl(long j) {
        return m9323toLongimpl(j, DurationUnit.SECONDS);
    }

    /* renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m9295getInWholeMillisecondsimpl(long j) {
        return (m9307isInMillisimpl(j) && m9306isFiniteimpl(j)) ? m9304getValueimpl(j) : m9323toLongimpl(j, DurationUnit.MILLISECONDS);
    }

    /* renamed from: getInWholeMicroseconds-impl, reason: not valid java name */
    public static final long m9294getInWholeMicrosecondsimpl(long j) {
        return m9323toLongimpl(j, DurationUnit.MICROSECONDS);
    }

    /* renamed from: getInWholeNanoseconds-impl, reason: not valid java name */
    public static final long m9297getInWholeNanosecondsimpl(long j) {
        long m9304getValueimpl = m9304getValueimpl(j);
        if (m9308isInNanosimpl(j)) {
            return m9304getValueimpl;
        }
        if (m9304getValueimpl > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (m9304getValueimpl < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return DurationKt.access$millisToNanos(m9304getValueimpl);
    }

    public String toString() {
        return m9324toStringimpl(this.rawValue);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m9324toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == INFINITE) {
            return "Infinity";
        }
        if (j == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean m9310isNegativeimpl = m9310isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (m9310isNegativeimpl) {
            sb.append('-');
        }
        long m9290getAbsoluteValueUwyO8pc = m9290getAbsoluteValueUwyO8pc(j);
        long m9292getInWholeDaysimpl = m9292getInWholeDaysimpl(m9290getAbsoluteValueUwyO8pc);
        int m9291getHoursComponentimpl = m9291getHoursComponentimpl(m9290getAbsoluteValueUwyO8pc);
        int m9299getMinutesComponentimpl = m9299getMinutesComponentimpl(m9290getAbsoluteValueUwyO8pc);
        int m9301getSecondsComponentimpl = m9301getSecondsComponentimpl(m9290getAbsoluteValueUwyO8pc);
        int m9300getNanosecondsComponentimpl = m9300getNanosecondsComponentimpl(m9290getAbsoluteValueUwyO8pc);
        int i = 0;
        boolean z = m9292getInWholeDaysimpl != 0;
        boolean z2 = m9291getHoursComponentimpl != 0;
        boolean z3 = m9299getMinutesComponentimpl != 0;
        boolean z4 = (m9301getSecondsComponentimpl == 0 && m9300getNanosecondsComponentimpl == 0) ? false : true;
        if (z) {
            sb.append(m9292getInWholeDaysimpl);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(m9291getHoursComponentimpl);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(m9299getMinutesComponentimpl);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (m9301getSecondsComponentimpl != 0 || z || z2 || z3) {
                m9281appendFractionalimpl(j, sb, m9301getSecondsComponentimpl, m9300getNanosecondsComponentimpl, 9, "s", false);
            } else if (m9300getNanosecondsComponentimpl >= 1000000) {
                m9281appendFractionalimpl(j, sb, m9300getNanosecondsComponentimpl / DurationKt.NANOS_IN_MILLIS, m9300getNanosecondsComponentimpl % DurationKt.NANOS_IN_MILLIS, 6, "ms", false);
            } else if (m9300getNanosecondsComponentimpl >= 1000) {
                m9281appendFractionalimpl(j, sb, m9300getNanosecondsComponentimpl / 1000, m9300getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb.append(m9300getNanosecondsComponentimpl);
                sb.append("ns");
            }
            i = i4;
        }
        if (m9310isNegativeimpl && i > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    /* renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m9281appendFractionalimpl(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String padStart = StringsKt.padStart(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = padStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (padStart.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (!z && i6 < 3) {
                sb.append((CharSequence) padStart, 0, i6);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            } else {
                sb.append((CharSequence) padStart, 0, ((i4 + 3) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    /* renamed from: toString-impl$default, reason: not valid java name */
    public static /* synthetic */ String m9326toStringimpl$default(long j, DurationUnit durationUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m9325toStringimpl(j, durationUnit, i);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static final String m9325toStringimpl(long j, DurationUnit unit, int i) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (i < 0) {
            throw new IllegalArgumentException(("decimals must be not negative, but was " + i).toString());
        }
        double m9320toDoubleimpl = m9320toDoubleimpl(j, unit);
        if (Double.isInfinite(m9320toDoubleimpl)) {
            return String.valueOf(m9320toDoubleimpl);
        }
        return DurationJvmKt.formatToExactDecimals(m9320toDoubleimpl, RangesKt.coerceAtMost(i, 12)) + DurationUnitKt.shortName(unit);
    }

    /* renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m9322toIsoStringimpl(long j) {
        StringBuilder sb = new StringBuilder();
        if (m9310isNegativeimpl(j)) {
            sb.append('-');
        }
        sb.append("PT");
        long m9290getAbsoluteValueUwyO8pc = m9290getAbsoluteValueUwyO8pc(j);
        long m9293getInWholeHoursimpl = m9293getInWholeHoursimpl(m9290getAbsoluteValueUwyO8pc);
        int m9299getMinutesComponentimpl = m9299getMinutesComponentimpl(m9290getAbsoluteValueUwyO8pc);
        int m9301getSecondsComponentimpl = m9301getSecondsComponentimpl(m9290getAbsoluteValueUwyO8pc);
        int m9300getNanosecondsComponentimpl = m9300getNanosecondsComponentimpl(m9290getAbsoluteValueUwyO8pc);
        long j2 = m9309isInfiniteimpl(j) ? 9999999999999L : m9293getInWholeHoursimpl;
        boolean z = true;
        boolean z2 = j2 != 0;
        boolean z3 = (m9301getSecondsComponentimpl == 0 && m9300getNanosecondsComponentimpl == 0) ? false : true;
        if (m9299getMinutesComponentimpl == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(j2);
            sb.append('H');
        }
        if (z) {
            sb.append(m9299getMinutesComponentimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            m9281appendFractionalimpl(j, sb, m9301getSecondsComponentimpl, m9300getNanosecondsComponentimpl, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        return sb.toString();
    }
}
