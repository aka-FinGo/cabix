package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import uz.FonRo.pos.data.net.LenientDouble;

/* compiled from: Auth.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001b\u0002\b&¢\u0006\u0002\b%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\t0\u0015¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012Ê\u0001\u0002\b\u0013Ê\u0001\f\b*\u0012\b\b+\u0012\u0004\b\u0003\u0010\u0002¨\u0006)"}, d2 = {"Luz/FonRo/pos/data/model/Coupon;", "", "code", "", "percent", "", "<init>", "(Ljava/lang/String;D)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;DLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()Ljava/lang/String;", "getPercent$annotations", "()V", "getPercent", "()D", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientDouble;", "component1", "component2", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class Coupon {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String code;
    private final double percent;

    public Coupon() {
        this((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Coupon copy$default(Coupon coupon, String str, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = coupon.code;
        }
        if ((i & 2) != 0) {
            d = coupon.percent;
        }
        return coupon.copy(str, d);
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getPercent$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final double getPercent() {
        return this.percent;
    }

    public final Coupon copy(String code, double percent) {
        Intrinsics.checkNotNullParameter(code, "code");
        return new Coupon(code, percent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Coupon)) {
            return false;
        }
        Coupon coupon = (Coupon) other;
        return Intrinsics.areEqual(this.code, coupon.code) && Double.compare(this.percent, coupon.percent) == 0;
    }

    public int hashCode() {
        return (this.code.hashCode() * 31) + Double.hashCode(this.percent);
    }

    public String toString() {
        return "Coupon(code=" + this.code + ", percent=" + this.percent + ")";
    }

    /* compiled from: Auth.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/Coupon$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/Coupon;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Coupon> serializer() {
            return Coupon$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Coupon(int i, String str, double d, SerializationConstructorMarker serializationConstructorMarker) {
        this.code = (i & 1) == 0 ? "" : str;
        if ((i & 2) == 0) {
            this.percent = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.percent = d;
        }
    }

    public Coupon(String code, double d) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.code = code;
        this.percent = d;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(Coupon self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.code, "")) {
            output.encodeStringElement(serialDesc, 0, self.code);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && Double.compare(self.percent, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 1, LenientDouble.INSTANCE, Double.valueOf(self.percent));
    }

    public /* synthetic */ Coupon(String str, double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : d);
    }

    public final String getCode() {
        return this.code;
    }

    public final double getPercent() {
        return this.percent;
    }
}
