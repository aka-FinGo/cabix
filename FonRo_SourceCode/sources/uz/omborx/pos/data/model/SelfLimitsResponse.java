package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import uz.FonRo.pos.data.net.PermissionMapSerializer;

/* compiled from: Auth.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B\u001d\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007B1\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u0017\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0004HÖ\u0081\u0004J)\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001b\u0002\b%¢\u0006\u0002\b$RD\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006X\u0087\u0004r\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\t0\u0015¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fÊ\u0001\u0002\b\u0013Ê\u0001\f\b)\u0012\b\b*\u0012\u0004\b\u0003\u0010\u0000¨\u0006("}, d2 = {"Luz/FonRo/pos/data/model/SelfLimitsResponse;", "", "selfLimits", "", "", "", "<init>", "(Ljava/util/Map;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSelfLimits$annotations", "()V", "getSelfLimits", "()Ljava/util/Map;", "Lkotlinx/serialization/SerialName;", "value", "self_limits", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/PermissionMapSerializer;", "component1", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class SelfLimitsResponse {
    private final Map<String, Integer> selfLimits;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public SelfLimitsResponse() {
        this((Map) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SelfLimitsResponse copy$default(SelfLimitsResponse selfLimitsResponse, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = selfLimitsResponse.selfLimits;
        }
        return selfLimitsResponse.copy(map);
    }

    @SerialName("self_limits")
    @Serializable(with = PermissionMapSerializer.class)
    public static /* synthetic */ void getSelfLimits$annotations() {
    }

    public final Map<String, Integer> component1() {
        return this.selfLimits;
    }

    public final SelfLimitsResponse copy(Map<String, Integer> selfLimits) {
        Intrinsics.checkNotNullParameter(selfLimits, "selfLimits");
        return new SelfLimitsResponse(selfLimits);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SelfLimitsResponse) && Intrinsics.areEqual(this.selfLimits, ((SelfLimitsResponse) other).selfLimits);
    }

    public int hashCode() {
        return this.selfLimits.hashCode();
    }

    public String toString() {
        return "SelfLimitsResponse(selfLimits=" + this.selfLimits + ")";
    }

    /* compiled from: Auth.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/SelfLimitsResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/SelfLimitsResponse;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SelfLimitsResponse> serializer() {
            return SelfLimitsResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SelfLimitsResponse(int i, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.selfLimits = MapsKt.emptyMap();
        } else {
            this.selfLimits = map;
        }
    }

    public SelfLimitsResponse(Map<String, Integer> selfLimits) {
        Intrinsics.checkNotNullParameter(selfLimits, "selfLimits");
        this.selfLimits = selfLimits;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(SelfLimitsResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (!output.shouldEncodeElementDefault(serialDesc, 0) && Intrinsics.areEqual(self.selfLimits, MapsKt.emptyMap())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 0, PermissionMapSerializer.INSTANCE, self.selfLimits);
    }

    public /* synthetic */ SelfLimitsResponse(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, Integer> getSelfLimits() {
        return this.selfLimits;
    }
}
