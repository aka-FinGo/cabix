package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tBA\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J1\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010'\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001b\u0002\b0¢\u0006\u0002\b/R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\t0\u0015¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R*\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0017Ê\u0001\u0002\b\u0013Ê\u0001\f\b4\u0012\b\b5\u0012\u0004\b\u0003\u0010\u0002¨\u00063"}, d2 = {"Luz/FonRo/pos/data/model/SupportMessage;", "", "id", "", "sender", "", "message", "createdAt", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getSender", "()Ljava/lang/String;", "getMessage", "getCreatedAt$annotations", "getCreatedAt", "Lkotlinx/serialization/SerialName;", "value", "created_at", "component1", "component2", "component3", "component4", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class SupportMessage {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String createdAt;
    private final long id;
    private final String message;
    private final String sender;

    public SupportMessage() {
        this(0L, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SupportMessage copy$default(SupportMessage supportMessage, long j, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = supportMessage.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = supportMessage.sender;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = supportMessage.message;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = supportMessage.createdAt;
        }
        return supportMessage.copy(j2, str4, str5, str3);
    }

    @SerialName("created_at")
    public static /* synthetic */ void getCreatedAt$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSender() {
        return this.sender;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final SupportMessage copy(long id, String sender, String message, String createdAt) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        return new SupportMessage(id, sender, message, createdAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SupportMessage)) {
            return false;
        }
        SupportMessage supportMessage = (SupportMessage) other;
        return this.id == supportMessage.id && Intrinsics.areEqual(this.sender, supportMessage.sender) && Intrinsics.areEqual(this.message, supportMessage.message) && Intrinsics.areEqual(this.createdAt, supportMessage.createdAt);
    }

    public int hashCode() {
        return (((((Long.hashCode(this.id) * 31) + this.sender.hashCode()) * 31) + this.message.hashCode()) * 31) + this.createdAt.hashCode();
    }

    public String toString() {
        return "SupportMessage(id=" + this.id + ", sender=" + this.sender + ", message=" + this.message + ", createdAt=" + this.createdAt + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/SupportMessage$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/SupportMessage;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SupportMessage> serializer() {
            return SupportMessage$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SupportMessage(int i, long j, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        this.id = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.sender = "";
        } else {
            this.sender = str;
        }
        if ((i & 4) == 0) {
            this.message = "";
        } else {
            this.message = str2;
        }
        if ((i & 8) == 0) {
            this.createdAt = "";
        } else {
            this.createdAt = str3;
        }
    }

    public SupportMessage(long j, String sender, String message, String createdAt) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        this.id = j;
        this.sender = sender;
        this.message = message;
        this.createdAt = createdAt;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(SupportMessage self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.sender, "")) {
            output.encodeStringElement(serialDesc, 1, self.sender);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.message, "")) {
            output.encodeStringElement(serialDesc, 2, self.message);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && Intrinsics.areEqual(self.createdAt, "")) {
            return;
        }
        output.encodeStringElement(serialDesc, 3, self.createdAt);
    }

    public /* synthetic */ SupportMessage(long j, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3);
    }

    public final long getId() {
        return this.id;
    }

    public final String getSender() {
        return this.sender;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }
}
