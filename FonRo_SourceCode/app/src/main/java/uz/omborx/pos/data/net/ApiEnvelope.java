package uz.FonRo.pos.data.net;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: ApiEnvelope.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 +*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002*+B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J6\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0007HÖ\u0081\u0004JI\u0010\u001f\u001a\u00020 \"\n\b\u0001\u0010\u0001*\u0004\u0018\u00010\u00022\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00010'H\u0001b\u0002\b)¢\u0006\u0002\b(R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015Ê\u0001\u0002\b-Ê\u0001\f\b.\u0012\b\b/\u0012\u0004\b\u0003\u0010\u0002¨\u0006,"}, d2 = {"Luz/FonRo/pos/data/net/ApiEnvelope;", ExifInterface.GPS_DIRECTION_TRUE, "", FirebaseAnalytics.Param.SUCCESS, "", "data", "message", "", "<init>", "(ZLjava/lang/Object;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/Object;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSuccess", "()Z", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(ZLjava/lang/Object;Ljava/lang/String;)Luz/FonRo/pos/data/net/ApiEnvelope;", "equals", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ApiEnvelope<T> {
    private static final SerialDescriptor $cachedDescriptor;
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final T data;
    private final String message;
    private final boolean success;

    public ApiEnvelope() {
        this(false, (Object) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApiEnvelope copy$default(ApiEnvelope apiEnvelope, boolean z, Object obj, String str, int i, Object obj2) {
        if ((i & 1) != 0) {
            z = apiEnvelope.success;
        }
        if ((i & 2) != 0) {
            obj = apiEnvelope.data;
        }
        if ((i & 4) != 0) {
            str = apiEnvelope.message;
        }
        return apiEnvelope.copy(z, obj, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final T component2() {
        return this.data;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final ApiEnvelope<T> copy(boolean success, T data, String message) {
        return new ApiEnvelope<>(success, data, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiEnvelope)) {
            return false;
        }
        ApiEnvelope apiEnvelope = (ApiEnvelope) other;
        return this.success == apiEnvelope.success && Intrinsics.areEqual(this.data, apiEnvelope.data) && Intrinsics.areEqual(this.message, apiEnvelope.message);
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.success) * 31;
        T t = this.data;
        int hashCode2 = (hashCode + (t == null ? 0 : t.hashCode())) * 31;
        String str = this.message;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ApiEnvelope(success=" + this.success + ", data=" + this.data + ", message=" + this.message + ")";
    }

    /* compiled from: ApiEnvelope.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u0005\"\u0004\b\u0001\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005¨\u0006\t"}, d2 = {"Luz/FonRo/pos/data/net/ApiEnvelope$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/net/ApiEnvelope;", ExifInterface.GPS_DIRECTION_TRUE, "typeSerial0", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> KSerializer<ApiEnvelope<T>> serializer(KSerializer<T> typeSerial0) {
            Intrinsics.checkNotNullParameter(typeSerial0, "typeSerial0");
            return new ApiEnvelope$$serializer(typeSerial0);
        }
    }

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.net.ApiEnvelope", null, 3);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.SUCCESS, true);
        pluginGeneratedSerialDescriptor.addElement("data", true);
        pluginGeneratedSerialDescriptor.addElement("message", true);
        $cachedDescriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ApiEnvelope(int i, boolean z, Object obj, String str, SerializationConstructorMarker serializationConstructorMarker) {
        this.success = (i & 1) == 0 ? false : z;
        if ((i & 2) == 0) {
            this.data = null;
        } else {
            this.data = obj;
        }
        if ((i & 4) == 0) {
            this.message = null;
        } else {
            this.message = str;
        }
    }

    public ApiEnvelope(boolean z, T t, String str) {
        this.success = z;
        this.data = t;
        this.message = str;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ApiEnvelope self, CompositeEncoder output, SerialDescriptor serialDesc, KSerializer typeSerial0) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.success) {
            output.encodeBooleanElement(serialDesc, 0, self.success);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.data != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, typeSerial0, self.data);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.message == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.message);
    }

    public /* synthetic */ ApiEnvelope(boolean z, Object obj, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : str);
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final T getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }
}
