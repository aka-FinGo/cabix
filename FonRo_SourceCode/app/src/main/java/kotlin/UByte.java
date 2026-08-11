package kotlin;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: UByte.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087@\u0018\u0000 |2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001|B\u0019\bA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006\u001a\u0002\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0000H\u0097\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001a\u0010\u000eJ!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001b\u0010\u0012J!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001c\u0010\u0015J!\u0010\u0019\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b \u0010\u000eJ!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b!\u0010\u0012J!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\"\u0010\u0015J!\u0010\u001f\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b#\u0010\u001eJ!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b%\u0010\u000eJ!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b&\u0010\u0012J!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b'\u0010\u0015J!\u0010$\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b(\u0010\u001eJ!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b*\u0010\u000eJ!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b+\u0010\u0012J!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b,\u0010\u0015J!\u0010)\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b-\u0010\u001eJ!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b/\u0010\u000eJ!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b0\u0010\u0012J!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b1\u0010\u0015J!\u0010.\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b2\u0010\u001eJ!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b4\u0010\u000eJ!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b5\u0010\u0012J!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b6\u0010\u0015J!\u00103\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b7\u0010\u001eJ!\u00108\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b9\u0010:J!\u00108\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b;\u0010<J!\u00108\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b=\u0010\u0015J!\u00108\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b>\u0010\u001eJ\u0015\u0010?\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\b@\u0010\u0005J\u0015\u0010A\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\bB\u0010\u0005J\u001d\u0010C\u001a\u00020D2\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\bE\u0010FJ=\u0010G\u001a\u00020D2\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\f\bI\u0012\b\bJ\u0012\u0004\b\b(Kb\u0010\bL\u0012\f\bM\u0012\b\b\fJ\u0004\b\t0Nb\u0002\b\u000f¢\u0006\u0004\bH\u0010FJ!\u0010O\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bP\u0010:J!\u0010Q\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bR\u0010:J!\u0010S\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bT\u0010:J\u0019\u0010U\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bV\u0010\u0005J\u0019\u0010W\u001a\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bX\u0010\u0005J\u0019\u0010Y\u001a\u00020ZH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b[\u0010\\J\u0019\u0010]\u001a\u00020\u000bH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b^\u0010_J\u0019\u0010`\u001a\u00020aH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bb\u0010cJ\u0019\u0010d\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\be\u0010\u0005J\u0019\u0010f\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bg\u0010\\J\u0019\u0010h\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bi\u0010_J\u0019\u0010j\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bk\u0010cJ\u0019\u0010l\u001a\u00020mH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bn\u0010oJ\u0019\u0010p\u001a\u00020qH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\br\u0010sJ\u0015\u0010t\u001a\u00020uH\u0097\u0080\u0004b\u0002\b\u0006¢\u0006\u0004\bv\u0010wJ\u0014\u0010x\u001a\u00020y2\b\u0010\f\u001a\u0004\u0018\u00010zHÖ\u0083\u0004J\n\u0010{\u001a\u00020\u000bHÖ\u0081\u0004R\u001b\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0084\br\u0002\b\u0007¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003Ê\u0001\f\bI\u0012\b\bJ\u0012\u0004\b\b(~Ê\u0001\u0002\b\u007f¨\u0006}"}, d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "Lkotlin/internal/IntrinsicConstEvaluation;", "Lkotlin/PublishedApi;", "getData$annotations", "()V", "compareTo", "", WriteOffReason.OTHER, "compareTo-7apg3OU", "(BB)I", "Lkotlin/internal/InlineOnly;", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(BJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(BB)B", "mod-xj2QHRw", "(BS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-w2LRezQ", "dec", "dec-w2LRezQ", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-7apg3OU", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/ExperimentalStdlibApi;", "and", "and-7apg3OU", "or", "or-7apg3OU", "xor", "xor-7apg3OU", "inv", "inv-w2LRezQ", "toByte", "toByte-impl", "toShort", "", "toShort-impl", "(B)S", "toInt", "toInt-impl", "(B)I", "toLong", "", "toLong-impl", "(B)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(B)F", "toDouble", "", "toDouble-impl", "(B)D", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib", "1.5", "Lkotlin/jvm/JvmInline;"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes6.dex */
public final class UByte implements Comparable<UByte> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UByte m7882boximpl(byte b) {
        return new UByte(b);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static byte m7888constructorimpl(byte b) {
        return b;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m7894equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).getData();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7895equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m7900hashCodeimpl(byte b) {
        return Byte.hashCode(b);
    }

    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m7926toByteimpl(byte b) {
        return b;
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m7929toIntimpl(byte b) {
        return b & 255;
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m7930toLongimpl(byte b) {
        return b & 255;
    }

    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m7931toShortimpl(byte b) {
        return (short) (b & 255);
    }

    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m7933toUBytew2LRezQ(byte b) {
        return b;
    }

    public boolean equals(Object other) {
        return m7894equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m7900hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ byte getData() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte uByte) {
        return Intrinsics.compare(getData() & 255, uByte.getData() & 255);
    }

    private /* synthetic */ UByte(byte b) {
        this.data = b;
    }

    /* compiled from: UByte.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u000f\u0010\b\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/UByte$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lkotlin/UByte;", "B", "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private int m7883compareTo7apg3OU(byte b) {
        return Intrinsics.compare(getData() & 255, b & 255);
    }

    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static int m7884compareTo7apg3OU(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255);
    }

    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m7887compareToxj2QHRw(byte b, short s) {
        return Intrinsics.compare(b & 255, s & UShort.MAX_VALUE);
    }

    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m7886compareToWZ4Q5Ns(byte b, int i) {
        int compare;
        compare = Integer.compare(UInt.m7970constructorimpl(b & 255) ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE);
        return compare;
    }

    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m7885compareToVKZWuLQ(byte b, long j) {
        int compare;
        compare = Long.compare(ULong.m8049constructorimpl(b & 255) ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        return compare;
    }

    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m7912plus7apg3OU(byte b, byte b2) {
        return UInt.m7970constructorimpl(UInt.m7970constructorimpl(b & 255) + UInt.m7970constructorimpl(b2 & 255));
    }

    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m7915plusxj2QHRw(byte b, short s) {
        return UInt.m7970constructorimpl(UInt.m7970constructorimpl(b & 255) + UInt.m7970constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m7914plusWZ4Q5Ns(byte b, int i) {
        return UInt.m7970constructorimpl(UInt.m7970constructorimpl(b & 255) + i);
    }

    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m7913plusVKZWuLQ(byte b, long j) {
        return ULong.m8049constructorimpl(ULong.m8049constructorimpl(b & 255) + j);
    }

    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m7903minus7apg3OU(byte b, byte b2) {
        return UInt.m7970constructorimpl(UInt.m7970constructorimpl(b & 255) - UInt.m7970constructorimpl(b2 & 255));
    }

    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m7906minusxj2QHRw(byte b, short s) {
        return UInt.m7970constructorimpl(UInt.m7970constructorimpl(b & 255) - UInt.m7970constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m7905minusWZ4Q5Ns(byte b, int i) {
        return UInt.m7970constructorimpl(UInt.m7970constructorimpl(b & 255) - i);
    }

    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m7904minusVKZWuLQ(byte b, long j) {
        return ULong.m8049constructorimpl(ULong.m8049constructorimpl(b & 255) - j);
    }

    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m7922times7apg3OU(byte b, byte b2) {
        return UInt.m7970constructorimpl(UInt.m7970constructorimpl(b & 255) * UInt.m7970constructorimpl(b2 & 255));
    }

    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m7925timesxj2QHRw(byte b, short s) {
        return UInt.m7970constructorimpl(UInt.m7970constructorimpl(b & 255) * UInt.m7970constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m7924timesWZ4Q5Ns(byte b, int i) {
        return UInt.m7970constructorimpl(UInt.m7970constructorimpl(b & 255) * i);
    }

    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m7923timesVKZWuLQ(byte b, long j) {
        return ULong.m8049constructorimpl(ULong.m8049constructorimpl(b & 255) * j);
    }

    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m7890div7apg3OU(byte b, byte b2) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m7970constructorimpl(b & 255), UInt.m7970constructorimpl(b2 & 255));
    }

    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m7893divxj2QHRw(byte b, short s) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m7970constructorimpl(b & 255), UInt.m7970constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m7892divWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m7970constructorimpl(b & 255), i);
    }

    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m7891divVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport0.m7939m(ULong.m8049constructorimpl(b & 255), j);
    }

    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m7918rem7apg3OU(byte b, byte b2) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m7970constructorimpl(b & 255), UInt.m7970constructorimpl(b2 & 255));
    }

    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m7921remxj2QHRw(byte b, short s) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m7970constructorimpl(b & 255), UInt.m7970constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m7920remWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m7970constructorimpl(b & 255), i);
    }

    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m7919remVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m8049constructorimpl(b & 255), j);
    }

    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m7896floorDiv7apg3OU(byte b, byte b2) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m7970constructorimpl(b & 255), UInt.m7970constructorimpl(b2 & 255));
    }

    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m7899floorDivxj2QHRw(byte b, short s) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m7970constructorimpl(b & 255), UInt.m7970constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m7898floorDivWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m7970constructorimpl(b & 255), i);
    }

    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m7897floorDivVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport0.m7939m(ULong.m8049constructorimpl(b & 255), j);
    }

    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m7907mod7apg3OU(byte b, byte b2) {
        return m7888constructorimpl((byte) UByte$$ExternalSyntheticBackport0.m$1(UInt.m7970constructorimpl(b & 255), UInt.m7970constructorimpl(b2 & 255)));
    }

    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m7910modxj2QHRw(byte b, short s) {
        return UShort.m8156constructorimpl((short) UByte$$ExternalSyntheticBackport0.m$1(UInt.m7970constructorimpl(b & 255), UInt.m7970constructorimpl(s & UShort.MAX_VALUE)));
    }

    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m7909modWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m7970constructorimpl(b & 255), i);
    }

    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m7908modVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m8049constructorimpl(b & 255), j);
    }

    /* renamed from: inc-w2LRezQ, reason: not valid java name */
    private static final byte m7901incw2LRezQ(byte b) {
        return m7888constructorimpl((byte) (b + 1));
    }

    /* renamed from: dec-w2LRezQ, reason: not valid java name */
    private static final byte m7889decw2LRezQ(byte b) {
        return m7888constructorimpl((byte) (b - 1));
    }

    /* renamed from: rangeTo-7apg3OU, reason: not valid java name */
    private static final UIntRange m7916rangeTo7apg3OU(byte b, byte b2) {
        return new UIntRange(UInt.m7970constructorimpl(b & 255), UInt.m7970constructorimpl(b2 & 255), null);
    }

    /* renamed from: rangeUntil-7apg3OU, reason: not valid java name */
    private static final UIntRange m7917rangeUntil7apg3OU(byte b, byte b2) {
        return URangesKt.m9216untilJ1ME1BU(UInt.m7970constructorimpl(b & 255), UInt.m7970constructorimpl(b2 & 255));
    }

    /* renamed from: and-7apg3OU, reason: not valid java name */
    private static final byte m7881and7apg3OU(byte b, byte b2) {
        return m7888constructorimpl((byte) (b & b2));
    }

    /* renamed from: or-7apg3OU, reason: not valid java name */
    private static final byte m7911or7apg3OU(byte b, byte b2) {
        return m7888constructorimpl((byte) (b | b2));
    }

    /* renamed from: xor-7apg3OU, reason: not valid java name */
    private static final byte m7937xor7apg3OU(byte b, byte b2) {
        return m7888constructorimpl((byte) (b ^ b2));
    }

    /* renamed from: inv-w2LRezQ, reason: not valid java name */
    private static final byte m7902invw2LRezQ(byte b) {
        return m7888constructorimpl((byte) (~b));
    }

    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m7936toUShortMh2AYeg(byte b) {
        return UShort.m8156constructorimpl((short) (b & 255));
    }

    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m7934toUIntpVg5ArA(byte b) {
        return UInt.m7970constructorimpl(b & 255);
    }

    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m7935toULongsVKNKU(byte b) {
        return ULong.m8049constructorimpl(b & 255);
    }

    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m7928toFloatimpl(byte b) {
        return (float) UnsignedKt.uintToDouble(b & 255);
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m7927toDoubleimpl(byte b) {
        return UnsignedKt.uintToDouble(b & 255);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m7932toStringimpl(byte b) {
        return String.valueOf(b & 255);
    }

    public String toString() {
        return m7932toStringimpl(this.data);
    }
}
