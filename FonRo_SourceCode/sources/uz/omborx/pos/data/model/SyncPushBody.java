package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
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
import uz.FonRo.pos.ui.nav.Routes;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002:;BW\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\u0004\b\r\u0010\u000eBk\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003JY\u0010*\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0001J\u0014\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010.\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010/\u001a\u000200HÖ\u0081\u0004J)\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001b\u0002\b9¢\u0006\u0002\b8R0\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R0\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001d¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00038\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(!¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017R0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00038\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b($¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010\u0017Ê\u0001\u0002\b=Ê\u0001\f\b>\u0012\b\b?\u0012\u0004\b\u0003\u0010\u0002¨\u0006<"}, d2 = {"Luz/FonRo/pos/data/model/SyncPushBody;", "", "stockIn", "", "Luz/FonRo/pos/data/model/StockInPush;", "inventoryAudits", "Luz/FonRo/pos/data/model/AuditPush;", Routes.SUPPLIERS, "Luz/FonRo/pos/data/model/SupplierPush;", "supplierReturns", "Luz/FonRo/pos/data/model/SupplierReturnPush;", "writeOffs", "Luz/FonRo/pos/data/model/WriteOffPush;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStockIn$annotations", "()V", "getStockIn", "()Ljava/util/List;", "Lkotlinx/serialization/SerialName;", "value", "stock_in", "getInventoryAudits$annotations", "getInventoryAudits", "inventory_audits", "getSuppliers", "getSupplierReturns$annotations", "getSupplierReturns", Routes.SUPPLIER_RETURNS, "getWriteOffs$annotations", "getWriteOffs", "write_offs", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class SyncPushBody {
    public static final int $stable = 0;
    private final List<AuditPush> inventoryAudits;
    private final List<StockInPush> stockIn;
    private final List<SupplierReturnPush> supplierReturns;
    private final List<SupplierPush> suppliers;
    private final List<WriteOffPush> writeOffs;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.SyncPushBody$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = SyncPushBody._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.SyncPushBody$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = SyncPushBody._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.SyncPushBody$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = SyncPushBody._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.SyncPushBody$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$2;
            _childSerializers$_anonymous_$2 = SyncPushBody._childSerializers$_anonymous_$2();
            return _childSerializers$_anonymous_$2;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.SyncPushBody$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$3;
            _childSerializers$_anonymous_$3 = SyncPushBody._childSerializers$_anonymous_$3();
            return _childSerializers$_anonymous_$3;
        }
    })};

    public SyncPushBody() {
        this((List) null, (List) null, (List) null, (List) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StockInPush$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(AuditPush$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(SupplierPush$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(SupplierReturnPush$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        return new ArrayListSerializer(WriteOffPush$$serializer.INSTANCE);
    }

    public static /* synthetic */ SyncPushBody copy$default(SyncPushBody syncPushBody, List list, List list2, List list3, List list4, List list5, int i, Object obj) {
        if ((i & 1) != 0) {
            list = syncPushBody.stockIn;
        }
        if ((i & 2) != 0) {
            list2 = syncPushBody.inventoryAudits;
        }
        if ((i & 4) != 0) {
            list3 = syncPushBody.suppliers;
        }
        if ((i & 8) != 0) {
            list4 = syncPushBody.supplierReturns;
        }
        if ((i & 16) != 0) {
            list5 = syncPushBody.writeOffs;
        }
        List list6 = list5;
        List list7 = list3;
        return syncPushBody.copy(list, list2, list7, list4, list6);
    }

    @SerialName("inventory_audits")
    public static /* synthetic */ void getInventoryAudits$annotations() {
    }

    @SerialName("stock_in")
    public static /* synthetic */ void getStockIn$annotations() {
    }

    @SerialName(Routes.SUPPLIER_RETURNS)
    public static /* synthetic */ void getSupplierReturns$annotations() {
    }

    @SerialName("write_offs")
    public static /* synthetic */ void getWriteOffs$annotations() {
    }

    public final List<StockInPush> component1() {
        return this.stockIn;
    }

    public final List<AuditPush> component2() {
        return this.inventoryAudits;
    }

    public final List<SupplierPush> component3() {
        return this.suppliers;
    }

    public final List<SupplierReturnPush> component4() {
        return this.supplierReturns;
    }

    public final List<WriteOffPush> component5() {
        return this.writeOffs;
    }

    public final SyncPushBody copy(List<StockInPush> stockIn, List<AuditPush> inventoryAudits, List<SupplierPush> suppliers, List<SupplierReturnPush> supplierReturns, List<WriteOffPush> writeOffs) {
        Intrinsics.checkNotNullParameter(stockIn, "stockIn");
        Intrinsics.checkNotNullParameter(inventoryAudits, "inventoryAudits");
        Intrinsics.checkNotNullParameter(suppliers, "suppliers");
        Intrinsics.checkNotNullParameter(supplierReturns, "supplierReturns");
        Intrinsics.checkNotNullParameter(writeOffs, "writeOffs");
        return new SyncPushBody(stockIn, inventoryAudits, suppliers, supplierReturns, writeOffs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncPushBody)) {
            return false;
        }
        SyncPushBody syncPushBody = (SyncPushBody) other;
        return Intrinsics.areEqual(this.stockIn, syncPushBody.stockIn) && Intrinsics.areEqual(this.inventoryAudits, syncPushBody.inventoryAudits) && Intrinsics.areEqual(this.suppliers, syncPushBody.suppliers) && Intrinsics.areEqual(this.supplierReturns, syncPushBody.supplierReturns) && Intrinsics.areEqual(this.writeOffs, syncPushBody.writeOffs);
    }

    public int hashCode() {
        return (((((((this.stockIn.hashCode() * 31) + this.inventoryAudits.hashCode()) * 31) + this.suppliers.hashCode()) * 31) + this.supplierReturns.hashCode()) * 31) + this.writeOffs.hashCode();
    }

    public String toString() {
        return "SyncPushBody(stockIn=" + this.stockIn + ", inventoryAudits=" + this.inventoryAudits + ", suppliers=" + this.suppliers + ", supplierReturns=" + this.supplierReturns + ", writeOffs=" + this.writeOffs + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/SyncPushBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/SyncPushBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SyncPushBody> serializer() {
            return SyncPushBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SyncPushBody(int i, List list, List list2, List list3, List list4, List list5, SerializationConstructorMarker serializationConstructorMarker) {
        this.stockIn = (i & 1) == 0 ? CollectionsKt.emptyList() : list;
        if ((i & 2) == 0) {
            this.inventoryAudits = CollectionsKt.emptyList();
        } else {
            this.inventoryAudits = list2;
        }
        if ((i & 4) == 0) {
            this.suppliers = CollectionsKt.emptyList();
        } else {
            this.suppliers = list3;
        }
        if ((i & 8) == 0) {
            this.supplierReturns = CollectionsKt.emptyList();
        } else {
            this.supplierReturns = list4;
        }
        if ((i & 16) == 0) {
            this.writeOffs = CollectionsKt.emptyList();
        } else {
            this.writeOffs = list5;
        }
    }

    public SyncPushBody(List<StockInPush> stockIn, List<AuditPush> inventoryAudits, List<SupplierPush> suppliers, List<SupplierReturnPush> supplierReturns, List<WriteOffPush> writeOffs) {
        Intrinsics.checkNotNullParameter(stockIn, "stockIn");
        Intrinsics.checkNotNullParameter(inventoryAudits, "inventoryAudits");
        Intrinsics.checkNotNullParameter(suppliers, "suppliers");
        Intrinsics.checkNotNullParameter(supplierReturns, "supplierReturns");
        Intrinsics.checkNotNullParameter(writeOffs, "writeOffs");
        this.stockIn = stockIn;
        this.inventoryAudits = inventoryAudits;
        this.suppliers = suppliers;
        this.supplierReturns = supplierReturns;
        this.writeOffs = writeOffs;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(SyncPushBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.stockIn, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.stockIn);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.inventoryAudits, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.inventoryAudits);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.suppliers, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.suppliers);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.supplierReturns, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.supplierReturns);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && Intrinsics.areEqual(self.writeOffs, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.writeOffs);
    }

    public /* synthetic */ SyncPushBody(List list, List list2, List list3, List list4, List list5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3, (i & 8) != 0 ? CollectionsKt.emptyList() : list4, (i & 16) != 0 ? CollectionsKt.emptyList() : list5);
    }

    public final List<StockInPush> getStockIn() {
        return this.stockIn;
    }

    public final List<AuditPush> getInventoryAudits() {
        return this.inventoryAudits;
    }

    public final List<SupplierPush> getSuppliers() {
        return this.suppliers;
    }

    public final List<SupplierReturnPush> getSupplierReturns() {
        return this.supplierReturns;
    }

    public final List<WriteOffPush> getWriteOffs() {
        return this.writeOffs;
    }
}
