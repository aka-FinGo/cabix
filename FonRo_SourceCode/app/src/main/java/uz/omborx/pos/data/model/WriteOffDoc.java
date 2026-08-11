package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientBool;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientInt;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 _2\u00020\u0001:\u0002^_B\u008b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\u008d\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0015\u0010\u001aJ\t\u0010D\u001a\u00020\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0007HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u000bHÆ\u0003J\t\u0010J\u001a\u00020\u000bHÆ\u0003J\t\u0010K\u001a\u00020\u000eHÆ\u0003J\t\u0010L\u001a\u00020\u000eHÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J\u008d\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0001J\u0014\u0010Q\u001a\u00020\u000e2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010S\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010T\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u00002\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0001b\u0002\b]¢\u0006\u0002\b\\R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u001f\u0012\b\b \u0012\u0004\b\t0!¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR,\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b%\u0012\b\b&\u0012\u0004\b\b('¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010$R8\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b%\u0012\b\b&\u0012\u0004\b\b(+r\f\b\u001f\u0012\b\b \u0012\u0004\b\t0,¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010*R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010$R*\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004r\f\b\u001f\u0012\b\b \u0012\u0004\b\t02¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u001c\u001a\u0004\b0\u00101R*\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004r\f\b\u001f\u0012\b\b \u0012\u0004\b\t02¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u001c\u001a\u0004\b4\u00101R8\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004r\f\b%\u0012\b\b&\u0012\u0004\b\b(7r\f\b\u001f\u0012\b\b \u0012\u0004\b\t08¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u001c\u001a\u0004\b\r\u00106R8\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004r\f\b%\u0012\b\b&\u0012\u0004\b\b(;r\f\b\u001f\u0012\b\b \u0012\u0004\b\t08¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010\u001c\u001a\u0004\b:\u00106R*\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b%\u0012\b\b&\u0012\u0004\b\b(>¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\u001c\u001a\u0004\b=\u0010$R,\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b%\u0012\b\b&\u0012\u0004\b\b(A¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010\u001c\u001a\u0004\b@\u0010$R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CÊ\u0001\u0002\b\u001fÊ\u0001\f\ba\u0012\b\bb\u0012\u0004\b\u0003\u0010\u0000¨\u0006`"}, d2 = {"Luz/FonRo/pos/data/model/WriteOffDoc;", "", "id", "", "clientId", "", "docNumber", "", "reason", "note", "amount", "", FirebaseAnalytics.Param.QUANTITY, "isCanceled", "", "canCancel", "createdAt", "createdByName", FirebaseAnalytics.Param.ITEMS, "", "Luz/FonRo/pos/data/model/WriteOffItem;", "<init>", "(JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;DDZZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;DDZZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getClientId$annotations", "getClientId", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "client_id", "getDocNumber$annotations", "getDocNumber", "()I", "doc_number", "Luz/FonRo/pos/data/net/LenientInt;", "getReason", "getNote", "getAmount$annotations", "getAmount", "()D", "Luz/FonRo/pos/data/net/LenientDouble;", "getQuantity$annotations", "getQuantity", "isCanceled$annotations", "()Z", "is_canceled", "Luz/FonRo/pos/data/net/LenientBool;", "getCanCancel$annotations", "getCanCancel", "can_cancel", "getCreatedAt$annotations", "getCreatedAt", "created_at", "getCreatedByName$annotations", "getCreatedByName", "created_by_name", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class WriteOffDoc {
    private final double amount;
    private final boolean canCancel;
    private final String clientId;
    private final String createdAt;
    private final String createdByName;
    private final int docNumber;
    private final long id;
    private final boolean isCanceled;
    private final List<WriteOffItem> items;
    private final String note;
    private final double quantity;
    private final String reason;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.WriteOffDoc$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = WriteOffDoc._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public WriteOffDoc() {
        this(0L, (String) null, 0, (String) null, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, false, false, (String) null, (String) null, (List) null, 4095, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(WriteOffItem$$serializer.INSTANCE);
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getAmount$annotations() {
    }

    @SerialName("can_cancel")
    @Serializable(with = LenientBool.class)
    public static /* synthetic */ void getCanCancel$annotations() {
    }

    @SerialName("client_id")
    public static /* synthetic */ void getClientId$annotations() {
    }

    @SerialName("created_at")
    public static /* synthetic */ void getCreatedAt$annotations() {
    }

    @SerialName("created_by_name")
    public static /* synthetic */ void getCreatedByName$annotations() {
    }

    @SerialName("doc_number")
    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getDocNumber$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getQuantity$annotations() {
    }

    @SerialName("is_canceled")
    @Serializable(with = LenientBool.class)
    public static /* synthetic */ void isCanceled$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component11, reason: from getter */
    public final String getCreatedByName() {
        return this.createdByName;
    }

    public final List<WriteOffItem> component12() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDocNumber() {
        return this.docNumber;
    }

    /* renamed from: component4, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component5, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    /* renamed from: component6, reason: from getter */
    public final double getAmount() {
        return this.amount;
    }

    /* renamed from: component7, reason: from getter */
    public final double getQuantity() {
        return this.quantity;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsCanceled() {
        return this.isCanceled;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getCanCancel() {
        return this.canCancel;
    }

    public final WriteOffDoc copy(long id, String clientId, int docNumber, String reason, String note, double amount, double quantity, boolean isCanceled, boolean canCancel, String createdAt, String createdByName, List<WriteOffItem> items) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(items, "items");
        return new WriteOffDoc(id, clientId, docNumber, reason, note, amount, quantity, isCanceled, canCancel, createdAt, createdByName, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WriteOffDoc)) {
            return false;
        }
        WriteOffDoc writeOffDoc = (WriteOffDoc) other;
        return this.id == writeOffDoc.id && Intrinsics.areEqual(this.clientId, writeOffDoc.clientId) && this.docNumber == writeOffDoc.docNumber && Intrinsics.areEqual(this.reason, writeOffDoc.reason) && Intrinsics.areEqual(this.note, writeOffDoc.note) && Double.compare(this.amount, writeOffDoc.amount) == 0 && Double.compare(this.quantity, writeOffDoc.quantity) == 0 && this.isCanceled == writeOffDoc.isCanceled && this.canCancel == writeOffDoc.canCancel && Intrinsics.areEqual(this.createdAt, writeOffDoc.createdAt) && Intrinsics.areEqual(this.createdByName, writeOffDoc.createdByName) && Intrinsics.areEqual(this.items, writeOffDoc.items);
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.id) * 31;
        String str = this.clientId;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.docNumber)) * 31) + this.reason.hashCode()) * 31;
        String str2 = this.note;
        int hashCode3 = (((((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Double.hashCode(this.amount)) * 31) + Double.hashCode(this.quantity)) * 31) + Boolean.hashCode(this.isCanceled)) * 31) + Boolean.hashCode(this.canCancel)) * 31) + this.createdAt.hashCode()) * 31;
        String str3 = this.createdByName;
        return ((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.items.hashCode();
    }

    public String toString() {
        return "WriteOffDoc(id=" + this.id + ", clientId=" + this.clientId + ", docNumber=" + this.docNumber + ", reason=" + this.reason + ", note=" + this.note + ", amount=" + this.amount + ", quantity=" + this.quantity + ", isCanceled=" + this.isCanceled + ", canCancel=" + this.canCancel + ", createdAt=" + this.createdAt + ", createdByName=" + this.createdByName + ", items=" + this.items + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/WriteOffDoc$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/WriteOffDoc;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<WriteOffDoc> serializer() {
            return WriteOffDoc$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ WriteOffDoc(int i, long j, String str, int i2, String str2, String str3, double d, double d2, boolean z, boolean z2, String str4, String str5, List list, SerializationConstructorMarker serializationConstructorMarker) {
        this.id = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.clientId = null;
        } else {
            this.clientId = str;
        }
        if ((i & 4) == 0) {
            this.docNumber = 0;
        } else {
            this.docNumber = i2;
        }
        if ((i & 8) == 0) {
            this.reason = WriteOffReason.OTHER;
        } else {
            this.reason = str2;
        }
        if ((i & 16) == 0) {
            this.note = null;
        } else {
            this.note = str3;
        }
        if ((i & 32) == 0) {
            this.amount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.amount = d;
        }
        if ((i & 64) == 0) {
            this.quantity = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.quantity = d2;
        }
        if ((i & 128) == 0) {
            this.isCanceled = false;
        } else {
            this.isCanceled = z;
        }
        if ((i & 256) == 0) {
            this.canCancel = false;
        } else {
            this.canCancel = z2;
        }
        this.createdAt = (i & 512) == 0 ? "" : str4;
        if ((i & 1024) == 0) {
            this.createdByName = null;
        } else {
            this.createdByName = str5;
        }
        this.items = (i & 2048) == 0 ? CollectionsKt.emptyList() : list;
    }

    public WriteOffDoc(long j, String str, int i, String reason, String str2, double d, double d2, boolean z, boolean z2, String createdAt, String str3, List<WriteOffItem> items) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(items, "items");
        this.id = j;
        this.clientId = str;
        this.docNumber = i;
        this.reason = reason;
        this.note = str2;
        this.amount = d;
        this.quantity = d2;
        this.isCanceled = z;
        this.canCancel = z2;
        this.createdAt = createdAt;
        this.createdByName = str3;
        this.items = items;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(WriteOffDoc self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.clientId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.clientId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.docNumber != 0) {
            output.encodeSerializableElement(serialDesc, 2, LenientInt.INSTANCE, Integer.valueOf(self.docNumber));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.reason, WriteOffReason.OTHER)) {
            output.encodeStringElement(serialDesc, 3, self.reason);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.note != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.note);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || Double.compare(self.amount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 5, LenientDouble.INSTANCE, Double.valueOf(self.amount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || Double.compare(self.quantity, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 6, LenientDouble.INSTANCE, Double.valueOf(self.quantity));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.isCanceled) {
            output.encodeSerializableElement(serialDesc, 7, LenientBool.INSTANCE, Boolean.valueOf(self.isCanceled));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.canCancel) {
            output.encodeSerializableElement(serialDesc, 8, LenientBool.INSTANCE, Boolean.valueOf(self.canCancel));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.createdAt, "")) {
            output.encodeStringElement(serialDesc, 9, self.createdAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.createdByName != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.createdByName);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 11) && Intrinsics.areEqual(self.items, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 11, lazyArr[11].getValue(), self.items);
    }

    public final long getId() {
        return this.id;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final int getDocNumber() {
        return this.docNumber;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ WriteOffDoc(long r17, java.lang.String r19, int r20, java.lang.String r21, java.lang.String r22, double r23, double r25, boolean r27, boolean r28, java.lang.String r29, java.lang.String r30, java.util.List r31, int r32, kotlin.jvm.internal.DefaultConstructorMarker r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            if (r1 == 0) goto L9
            r1 = 0
            goto Lb
        L9:
            r1 = r17
        Lb:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L12
            r3 = r4
            goto L14
        L12:
            r3 = r19
        L14:
            r5 = r0 & 4
            r6 = 0
            if (r5 == 0) goto L1b
            r5 = r6
            goto L1d
        L1b:
            r5 = r20
        L1d:
            r7 = r0 & 8
            if (r7 == 0) goto L24
            java.lang.String r7 = "other"
            goto L26
        L24:
            r7 = r21
        L26:
            r8 = r0 & 16
            if (r8 == 0) goto L2c
            r8 = r4
            goto L2e
        L2c:
            r8 = r22
        L2e:
            r9 = r0 & 32
            r10 = 0
            if (r9 == 0) goto L36
            r12 = r10
            goto L38
        L36:
            r12 = r23
        L38:
            r9 = r0 & 64
            if (r9 == 0) goto L3d
            goto L3f
        L3d:
            r10 = r25
        L3f:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L45
            r9 = r6
            goto L47
        L45:
            r9 = r27
        L47:
            r14 = r0 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L4c
            goto L4e
        L4c:
            r6 = r28
        L4e:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L55
            java.lang.String r14 = ""
            goto L57
        L55:
            r14 = r29
        L57:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L5c
            goto L5e
        L5c:
            r4 = r30
        L5e:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L69
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r32 = r0
            goto L6b
        L69:
            r32 = r31
        L6b:
            r17 = r16
            r18 = r1
            r20 = r3
            r31 = r4
            r21 = r5
            r29 = r6
            r22 = r7
            r23 = r8
            r28 = r9
            r26 = r10
            r24 = r12
            r30 = r14
            r17.<init>(r18, r20, r21, r22, r23, r24, r26, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.data.model.WriteOffDoc.<init>(long, java.lang.String, int, java.lang.String, java.lang.String, double, double, boolean, boolean, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getNote() {
        return this.note;
    }

    public final double getAmount() {
        return this.amount;
    }

    public final double getQuantity() {
        return this.quantity;
    }

    public final boolean isCanceled() {
        return this.isCanceled;
    }

    public final boolean getCanCancel() {
        return this.canCancel;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getCreatedByName() {
        return this.createdByName;
    }

    public final List<WriteOffItem> getItems() {
        return this.items;
    }
}
