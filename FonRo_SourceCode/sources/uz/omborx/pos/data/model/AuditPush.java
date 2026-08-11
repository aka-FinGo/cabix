package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002./B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nBI\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\fHÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001b\u0002\b-¢\u0006\u0002\b,R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aÊ\u0001\u0002\b1Ê\u0001\f\b2\u0012\b\b3\u0012\u0004\b\u0003\u0010\u0000¨\u00060"}, d2 = {"Luz/FonRo/pos/data/model/AuditPush;", "", "clientId", "", "mode", "note", FirebaseAnalytics.Param.ITEMS, "", "Luz/FonRo/pos/data/model/AuditPushItem;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getClientId$annotations", "()V", "getClientId", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "client_id", "getMode", "getNote", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class AuditPush {
    private final String clientId;
    private final List<AuditPushItem> items;
    private final String mode;
    private final String note;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.AuditPush$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AuditPush._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(AuditPushItem$$serializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AuditPush copy$default(AuditPush auditPush, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = auditPush.clientId;
        }
        if ((i & 2) != 0) {
            str2 = auditPush.mode;
        }
        if ((i & 4) != 0) {
            str3 = auditPush.note;
        }
        if ((i & 8) != 0) {
            list = auditPush.items;
        }
        return auditPush.copy(str, str2, str3, list);
    }

    @SerialName("client_id")
    public static /* synthetic */ void getClientId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    public final List<AuditPushItem> component4() {
        return this.items;
    }

    public final AuditPush copy(String clientId, String mode, String note, List<AuditPushItem> items) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(items, "items");
        return new AuditPush(clientId, mode, note, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuditPush)) {
            return false;
        }
        AuditPush auditPush = (AuditPush) other;
        return Intrinsics.areEqual(this.clientId, auditPush.clientId) && Intrinsics.areEqual(this.mode, auditPush.mode) && Intrinsics.areEqual(this.note, auditPush.note) && Intrinsics.areEqual(this.items, auditPush.items);
    }

    public int hashCode() {
        return (((((this.clientId.hashCode() * 31) + this.mode.hashCode()) * 31) + this.note.hashCode()) * 31) + this.items.hashCode();
    }

    public String toString() {
        return "AuditPush(clientId=" + this.clientId + ", mode=" + this.mode + ", note=" + this.note + ", items=" + this.items + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/AuditPush$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/AuditPush;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AuditPush> serializer() {
            return AuditPush$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AuditPush(int i, String str, String str2, String str3, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, AuditPush$$serializer.INSTANCE.getDescriptor());
        }
        this.clientId = str;
        if ((i & 2) == 0) {
            this.mode = "apply";
        } else {
            this.mode = str2;
        }
        if ((i & 4) == 0) {
            this.note = "";
        } else {
            this.note = str3;
        }
        if ((i & 8) == 0) {
            this.items = CollectionsKt.emptyList();
        } else {
            this.items = list;
        }
    }

    public AuditPush(String clientId, String mode, String note, List<AuditPushItem> items) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(items, "items");
        this.clientId = clientId;
        this.mode = mode;
        this.note = note;
        this.items = items;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(AuditPush self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.clientId);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.mode, "apply")) {
            output.encodeStringElement(serialDesc, 1, self.mode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.note, "")) {
            output.encodeStringElement(serialDesc, 2, self.note);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && Intrinsics.areEqual(self.items, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.items);
    }

    public final String getClientId() {
        return this.clientId;
    }

    public /* synthetic */ AuditPush(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "apply" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getNote() {
        return this.note;
    }

    public final List<AuditPushItem> getItems() {
        return this.items;
    }
}
