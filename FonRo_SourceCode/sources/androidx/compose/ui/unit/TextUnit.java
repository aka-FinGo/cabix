package androidx.compose.ui.unit;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: TextUnit.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 02\u00020\u0001:\u00010B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001dH\u0086\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0014H\u0086\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010 J\u001e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0086\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010!J\u001a\u0010\"\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001e\u0010(\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001dH\u0086\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010\u001fJ\u001e\u0010(\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0014H\u0086\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010 J\u001e\u0010(\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0086\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010!J\u000f\u0010*\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\u0086\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0005R\u0017\u0010\u0010\u001a\u00020\u00118Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0005R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00061"}, d2 = {"Landroidx/compose/ui/unit/TextUnit;", "", "packedValue", "", "constructor-impl", "(J)J", "isEm", "", "isEm-impl", "(J)Z", "isSp", "isSp-impl", "rawType", "getRawType$annotations", "()V", "getRawType-impl", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Landroidx/compose/ui/unit/TextUnitType;", "getType-UIouoOA", "value", "", "getValue-impl", "(J)F", "compareTo", "", WriteOffReason.OTHER, "compareTo--R2X_6o", "(JJ)I", "div", "", "div-kPz2Gy4", "(JD)J", "(JF)J", "(JI)J", "equals", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(J)I", "times", "times-kPz2Gy4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-XSAIIZE", "Companion", "ui-unit_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes4.dex */
public final class TextUnit {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TextUnitType[] TextUnitTypes = {TextUnitType.m7208boximpl(TextUnitType.INSTANCE.m7217getUnspecifiedUIouoOA()), TextUnitType.m7208boximpl(TextUnitType.INSTANCE.m7216getSpUIouoOA()), TextUnitType.m7208boximpl(TextUnitType.INSTANCE.m7215getEmUIouoOA())};
    private static final long Unspecified = TextUnitKt.pack(0, Float.NaN);
    private final long packedValue;

    /* renamed from: box-impl */
    public static final /* synthetic */ TextUnit m7173boximpl(long j) {
        return new TextUnit(j);
    }

    /* renamed from: constructor-impl */
    public static long m7175constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl */
    public static boolean m7179equalsimpl(long j, Object obj) {
        return (obj instanceof TextUnit) && j == ((TextUnit) obj).getPackedValue();
    }

    /* renamed from: equals-impl0 */
    public static final boolean m7180equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getRawType$annotations() {
    }

    /* renamed from: getRawType-impl */
    public static final long m7181getRawTypeimpl(long j) {
        return j & 1095216660480L;
    }

    /* renamed from: hashCode-impl */
    public static int m7184hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m7179equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m7184hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ TextUnit(long j) {
        this.packedValue = j;
    }

    /* renamed from: unaryMinus-XSAIIZE */
    public static final long m7191unaryMinusXSAIIZE(long j) {
        TextUnitKt.m7196checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m7181getRawTypeimpl(j), -m7183getValueimpl(j));
    }

    /* renamed from: div-kPz2Gy4 */
    public static final long m7177divkPz2Gy4(long j, float f) {
        TextUnitKt.m7196checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m7181getRawTypeimpl(j), m7183getValueimpl(j) / f);
    }

    /* renamed from: div-kPz2Gy4 */
    public static final long m7176divkPz2Gy4(long j, double d) {
        TextUnitKt.m7196checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m7181getRawTypeimpl(j), (float) (m7183getValueimpl(j) / d));
    }

    /* renamed from: div-kPz2Gy4 */
    public static final long m7178divkPz2Gy4(long j, int i) {
        TextUnitKt.m7196checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m7181getRawTypeimpl(j), m7183getValueimpl(j) / i);
    }

    /* renamed from: times-kPz2Gy4 */
    public static final long m7188timeskPz2Gy4(long j, float f) {
        TextUnitKt.m7196checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m7181getRawTypeimpl(j), m7183getValueimpl(j) * f);
    }

    /* renamed from: times-kPz2Gy4 */
    public static final long m7187timeskPz2Gy4(long j, double d) {
        TextUnitKt.m7196checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m7181getRawTypeimpl(j), (float) (m7183getValueimpl(j) * d));
    }

    /* renamed from: times-kPz2Gy4 */
    public static final long m7189timeskPz2Gy4(long j, int i) {
        TextUnitKt.m7196checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m7181getRawTypeimpl(j), m7183getValueimpl(j) * i);
    }

    /* renamed from: compareTo--R2X_6o */
    public static final int m7174compareToR2X_6o(long j, long j2) {
        TextUnitKt.m7197checkArithmeticNB67dxo(j, j2);
        return Float.compare(m7183getValueimpl(j), m7183getValueimpl(j2));
    }

    public String toString() {
        return m7190toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl */
    public static String m7190toStringimpl(long j) {
        long m7182getTypeUIouoOA = m7182getTypeUIouoOA(j);
        if (TextUnitType.m7211equalsimpl0(m7182getTypeUIouoOA, TextUnitType.INSTANCE.m7217getUnspecifiedUIouoOA())) {
            return "Unspecified";
        }
        if (TextUnitType.m7211equalsimpl0(m7182getTypeUIouoOA, TextUnitType.INSTANCE.m7216getSpUIouoOA())) {
            return m7183getValueimpl(j) + ".sp";
        }
        if (!TextUnitType.m7211equalsimpl0(m7182getTypeUIouoOA, TextUnitType.INSTANCE.m7215getEmUIouoOA())) {
            return "Invalid";
        }
        return m7183getValueimpl(j) + ".em";
    }

    /* compiled from: TextUnit.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/unit/TextUnit$Companion;", "", "()V", "TextUnitTypes", "", "Landroidx/compose/ui/unit/TextUnitType;", "getTextUnitTypes$ui_unit_release", "()[Landroidx/compose/ui/unit/TextUnitType;", "[Landroidx/compose/ui/unit/TextUnitType;", "Unspecified", "Landroidx/compose/ui/unit/TextUnit;", "getUnspecified-XSAIIZE$annotations", "getUnspecified-XSAIIZE", "()J", "J", "ui-unit_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-XSAIIZE$annotations */
        public static /* synthetic */ void m7193getUnspecifiedXSAIIZE$annotations() {
        }

        private Companion() {
        }

        public final TextUnitType[] getTextUnitTypes$ui_unit_release() {
            return TextUnit.TextUnitTypes;
        }

        /* renamed from: getUnspecified-XSAIIZE */
        public final long m7194getUnspecifiedXSAIIZE() {
            return TextUnit.Unspecified;
        }
    }

    /* renamed from: getType-UIouoOA */
    public static final long m7182getTypeUIouoOA(long j) {
        return TextUnitTypes[(int) (m7181getRawTypeimpl(j) >>> 32)].getType();
    }

    /* renamed from: isSp-impl */
    public static final boolean m7186isSpimpl(long j) {
        return m7181getRawTypeimpl(j) == 4294967296L;
    }

    /* renamed from: isEm-impl */
    public static final boolean m7185isEmimpl(long j) {
        return m7181getRawTypeimpl(j) == 8589934592L;
    }

    /* renamed from: getValue-impl */
    public static final float m7183getValueimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }
}
