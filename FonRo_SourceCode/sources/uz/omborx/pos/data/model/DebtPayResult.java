package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import uz.FonRo.pos.data.net.LenientDouble;

/* compiled from: Money.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J)\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001b\u0002\b%¢\u0006\u0002\b$R8\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\t0\u0014¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eÊ\u0001\u0002\b\u0012Ê\u0001\f\b)\u0012\b\b*\u0012\u0004\b\u0003\u0010\u0002¨\u0006("}, d2 = {"Luz/FonRo/pos/data/model/DebtPayResult;", "", "debtAmount", "", "<init>", "(D)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDebtAmount$annotations", "()V", "getDebtAmount", "()D", "Lkotlinx/serialization/SerialName;", "value", "debt_amount", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientDouble;", "component1", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class DebtPayResult {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double debtAmount;

    public DebtPayResult() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DebtPayResult copy$default(DebtPayResult debtPayResult, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            d = debtPayResult.debtAmount;
        }
        return debtPayResult.copy(d);
    }

    @SerialName("debt_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getDebtAmount$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final double getDebtAmount() {
        return this.debtAmount;
    }

    public final DebtPayResult copy(double debtAmount) {
        return new DebtPayResult(debtAmount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DebtPayResult) && Double.compare(this.debtAmount, ((DebtPayResult) other).debtAmount) == 0;
    }

    public int hashCode() {
        return Double.hashCode(this.debtAmount);
    }

    public String toString() {
        return "DebtPayResult(debtAmount=" + this.debtAmount + ")";
    }

    /* compiled from: Money.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/DebtPayResult$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/DebtPayResult;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DebtPayResult> serializer() {
            return DebtPayResult$$serializer.INSTANCE;
        }
    }

    public DebtPayResult(double d) {
        this.debtAmount = d;
    }

    public /* synthetic */ DebtPayResult(int i, double d, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.debtAmount = -1.0d;
        } else {
            this.debtAmount = d;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(DebtPayResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (!output.shouldEncodeElementDefault(serialDesc, 0) && Double.compare(self.debtAmount, -1.0d) == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 0, LenientDouble.INSTANCE, Double.valueOf(self.debtAmount));
    }

    public /* synthetic */ DebtPayResult(double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? -1.0d : d);
    }

    public final double getDebtAmount() {
        return this.debtAmount;
    }
}
