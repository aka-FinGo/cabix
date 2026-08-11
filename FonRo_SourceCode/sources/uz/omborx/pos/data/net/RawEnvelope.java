package uz.FonRo.pos.data.net;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: ApiEnvelope.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0007HÖ\u0081\u0004J)\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001b\u0002\b%¢\u0006\u0002\b$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0002\b)Ê\u0001\f\b*\u0012\b\b+\u0012\u0004\b\u0003\u0010\u0000¨\u0006("}, d2 = {"Luz/FonRo/pos/data/net/RawEnvelope;", "", FirebaseAnalytics.Param.SUCCESS, "", "data", "Lkotlinx/serialization/json/JsonElement;", "message", "", "<init>", "(ZLkotlinx/serialization/json/JsonElement;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLkotlinx/serialization/json/JsonElement;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSuccess", "()Z", "getData", "()Lkotlinx/serialization/json/JsonElement;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class RawEnvelope {
    private final JsonElement data;
    private final String message;
    private final boolean success;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public RawEnvelope() {
        this(false, (JsonElement) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RawEnvelope copy$default(RawEnvelope rawEnvelope, boolean z, JsonElement jsonElement, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = rawEnvelope.success;
        }
        if ((i & 2) != 0) {
            jsonElement = rawEnvelope.data;
        }
        if ((i & 4) != 0) {
            str = rawEnvelope.message;
        }
        return rawEnvelope.copy(z, jsonElement, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final JsonElement getData() {
        return this.data;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final RawEnvelope copy(boolean success, JsonElement data, String message) {
        return new RawEnvelope(success, data, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RawEnvelope)) {
            return false;
        }
        RawEnvelope rawEnvelope = (RawEnvelope) other;
        return this.success == rawEnvelope.success && Intrinsics.areEqual(this.data, rawEnvelope.data) && Intrinsics.areEqual(this.message, rawEnvelope.message);
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.success) * 31;
        JsonElement jsonElement = this.data;
        int hashCode2 = (hashCode + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        String str = this.message;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "RawEnvelope(success=" + this.success + ", data=" + this.data + ", message=" + this.message + ")";
    }

    /* compiled from: ApiEnvelope.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/net/RawEnvelope$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/net/RawEnvelope;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RawEnvelope> serializer() {
            return RawEnvelope$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ RawEnvelope(int i, boolean z, JsonElement jsonElement, String str, SerializationConstructorMarker serializationConstructorMarker) {
        this.success = (i & 1) == 0 ? false : z;
        if ((i & 2) == 0) {
            this.data = null;
        } else {
            this.data = jsonElement;
        }
        if ((i & 4) == 0) {
            this.message = null;
        } else {
            this.message = str;
        }
    }

    public RawEnvelope(boolean z, JsonElement jsonElement, String str) {
        this.success = z;
        this.data = jsonElement;
        this.message = str;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(RawEnvelope self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.success) {
            output.encodeBooleanElement(serialDesc, 0, self.success);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.data != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, JsonElementSerializer.INSTANCE, self.data);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.message == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.message);
    }

    public /* synthetic */ RawEnvelope(boolean z, JsonElement jsonElement, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : jsonElement, (i & 4) != 0 ? null : str);
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final JsonElement getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }
}
