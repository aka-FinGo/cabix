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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0002>?BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eBY\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JK\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0014\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00103\u001a\u00020\u0010HÖ\u0081\u0004J\n\u00104\u001a\u00020\u0003HÖ\u0081\u0004J)\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001b\u0002\b=¢\u0006\u0002\b<R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u001dR*\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(!¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R*\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(&¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010%R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(Ê\u0001\u0002\bAÊ\u0001\f\bB\u0012\b\bC\u0012\u0004\b\u0003\u0010\u0000¨\u0006@"}, d2 = {"Luz/FonRo/pos/data/model/StockInPush;", "", "clientId", "", "supplierId", "", "invoiceNumber", "note", "paidAmount", "", FirebaseAnalytics.Param.ITEMS, "", "Luz/FonRo/pos/data/model/StockInPushItem;", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;DLjava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;DLjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getClientId$annotations", "()V", "getClientId", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "client_id", "getSupplierId$annotations", "getSupplierId", "()J", "supplier_id", "getInvoiceNumber$annotations", "getInvoiceNumber", "invoice_number", "getNote", "getPaidAmount$annotations", "getPaidAmount", "()D", "paid_amount", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class StockInPush {
    private final String clientId;
    private final String invoiceNumber;
    private final List<StockInPushItem> items;
    private final String note;
    private final double paidAmount;
    private final long supplierId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.StockInPush$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = StockInPush._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StockInPushItem$$serializer.INSTANCE);
    }

    public static /* synthetic */ StockInPush copy$default(StockInPush stockInPush, String str, long j, String str2, String str3, double d, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stockInPush.clientId;
        }
        if ((i & 2) != 0) {
            j = stockInPush.supplierId;
        }
        if ((i & 4) != 0) {
            str2 = stockInPush.invoiceNumber;
        }
        if ((i & 8) != 0) {
            str3 = stockInPush.note;
        }
        if ((i & 16) != 0) {
            d = stockInPush.paidAmount;
        }
        if ((i & 32) != 0) {
            list = stockInPush.items;
        }
        List list2 = list;
        return stockInPush.copy(str, j, str2, str3, d, list2);
    }

    @SerialName("client_id")
    public static /* synthetic */ void getClientId$annotations() {
    }

    @SerialName("invoice_number")
    public static /* synthetic */ void getInvoiceNumber$annotations() {
    }

    @SerialName("paid_amount")
    public static /* synthetic */ void getPaidAmount$annotations() {
    }

    @SerialName("supplier_id")
    public static /* synthetic */ void getSupplierId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSupplierId() {
        return this.supplierId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    /* renamed from: component4, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    /* renamed from: component5, reason: from getter */
    public final double getPaidAmount() {
        return this.paidAmount;
    }

    public final List<StockInPushItem> component6() {
        return this.items;
    }

    public final StockInPush copy(String clientId, long supplierId, String invoiceNumber, String note, double paidAmount, List<StockInPushItem> items) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(invoiceNumber, "invoiceNumber");
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(items, "items");
        return new StockInPush(clientId, supplierId, invoiceNumber, note, paidAmount, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StockInPush)) {
            return false;
        }
        StockInPush stockInPush = (StockInPush) other;
        return Intrinsics.areEqual(this.clientId, stockInPush.clientId) && this.supplierId == stockInPush.supplierId && Intrinsics.areEqual(this.invoiceNumber, stockInPush.invoiceNumber) && Intrinsics.areEqual(this.note, stockInPush.note) && Double.compare(this.paidAmount, stockInPush.paidAmount) == 0 && Intrinsics.areEqual(this.items, stockInPush.items);
    }

    public int hashCode() {
        return (((((((((this.clientId.hashCode() * 31) + Long.hashCode(this.supplierId)) * 31) + this.invoiceNumber.hashCode()) * 31) + this.note.hashCode()) * 31) + Double.hashCode(this.paidAmount)) * 31) + this.items.hashCode();
    }

    public String toString() {
        return "StockInPush(clientId=" + this.clientId + ", supplierId=" + this.supplierId + ", invoiceNumber=" + this.invoiceNumber + ", note=" + this.note + ", paidAmount=" + this.paidAmount + ", items=" + this.items + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/StockInPush$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/StockInPush;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StockInPush> serializer() {
            return StockInPush$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ StockInPush(int i, String str, long j, String str2, String str3, double d, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, StockInPush$$serializer.INSTANCE.getDescriptor());
        }
        this.clientId = str;
        if ((i & 2) == 0) {
            this.supplierId = 0L;
        } else {
            this.supplierId = j;
        }
        if ((i & 4) == 0) {
            this.invoiceNumber = "";
        } else {
            this.invoiceNumber = str2;
        }
        if ((i & 8) == 0) {
            this.note = "";
        } else {
            this.note = str3;
        }
        if ((i & 16) == 0) {
            this.paidAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.paidAmount = d;
        }
        if ((i & 32) == 0) {
            this.items = CollectionsKt.emptyList();
        } else {
            this.items = list;
        }
    }

    public StockInPush(String clientId, long j, String invoiceNumber, String note, double d, List<StockInPushItem> items) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(invoiceNumber, "invoiceNumber");
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(items, "items");
        this.clientId = clientId;
        this.supplierId = j;
        this.invoiceNumber = invoiceNumber;
        this.note = note;
        this.paidAmount = d;
        this.items = items;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(StockInPush self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.clientId);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.supplierId != 0) {
            output.encodeLongElement(serialDesc, 1, self.supplierId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.invoiceNumber, "")) {
            output.encodeStringElement(serialDesc, 2, self.invoiceNumber);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.note, "")) {
            output.encodeStringElement(serialDesc, 3, self.note);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || Double.compare(self.paidAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeDoubleElement(serialDesc, 4, self.paidAmount);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && Intrinsics.areEqual(self.items, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.items);
    }

    public /* synthetic */ StockInPush(String str, long j, String str2, String str3, double d, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? "" : str2, (i & 8) == 0 ? str3 : "", (i & 16) != 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : d, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final long getSupplierId() {
        return this.supplierId;
    }

    public final String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    public final String getNote() {
        return this.note;
    }

    public final double getPaidAmount() {
        return this.paidAmount;
    }

    public final List<StockInPushItem> getItems() {
        return this.items;
    }
}
