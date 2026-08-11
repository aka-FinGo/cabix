package uz.FonRo.pos.ui.sale;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: SaleState.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001b\u0002\b#¢\u0006\u0002\b\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013Ê\u0001\u0002\b'Ê\u0001\f\b(\u0012\b\b)\u0012\u0004\b\u0003\u0010\u0002¨\u0006&"}, d2 = {"Luz/FonRo/pos/ui/sale/CartDiscount;", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "value", "", "<init>", "(Ljava/lang/String;D)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;DLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType", "()Ljava/lang/String;", "getValue", "()D", "isPercent", "", "()Z", "component1", "component2", "copy", "equals", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class CartDiscount {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String type;
    private final double value;

    public CartDiscount() {
        this((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CartDiscount copy$default(CartDiscount cartDiscount, String str, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cartDiscount.type;
        }
        if ((i & 2) != 0) {
            d = cartDiscount.value;
        }
        return cartDiscount.copy(str, d);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final double getValue() {
        return this.value;
    }

    public final CartDiscount copy(String type, double value) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new CartDiscount(type, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CartDiscount)) {
            return false;
        }
        CartDiscount cartDiscount = (CartDiscount) other;
        return Intrinsics.areEqual(this.type, cartDiscount.type) && Double.compare(this.value, cartDiscount.value) == 0;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + Double.hashCode(this.value);
    }

    public String toString() {
        return "CartDiscount(type=" + this.type + ", value=" + this.value + ")";
    }

    /* compiled from: SaleState.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/ui/sale/CartDiscount$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/ui/sale/CartDiscount;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CartDiscount> serializer() {
            return CartDiscount$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CartDiscount(int i, String str, double d, SerializationConstructorMarker serializationConstructorMarker) {
        this.type = (i & 1) == 0 ? "amount" : str;
        if ((i & 2) == 0) {
            this.value = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.value = d;
        }
    }

    public CartDiscount(String type, double d) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.value = d;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(CartDiscount self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.type, "amount")) {
            output.encodeStringElement(serialDesc, 0, self.type);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && Double.compare(self.value, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) {
            return;
        }
        output.encodeDoubleElement(serialDesc, 1, self.value);
    }

    public /* synthetic */ CartDiscount(String str, double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "amount" : str, (i & 2) != 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : d);
    }

    public final String getType() {
        return this.type;
    }

    public final double getValue() {
        return this.value;
    }

    public final boolean isPercent() {
        return Intrinsics.areEqual(this.type, "percent");
    }
}
