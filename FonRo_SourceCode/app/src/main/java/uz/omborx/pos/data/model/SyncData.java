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
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 M2\u00020\u0001:\u0002LMB\u009b\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0003¢\u0006\u0004\b\u0015\u0010\u0016B«\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0003\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0003\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0015\u0010\u001bJ\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003HÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003HÆ\u0003J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0003HÆ\u0003J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0003HÆ\u0003J\u009d\u0001\u0010<\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00032\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0003HÆ\u0001J\u0014\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010@\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010A\u001a\u00020BHÖ\u0081\u0004J)\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0001b\u0002\bK¢\u0006\u0002\bJR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00038\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u001dR0\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00038\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b()¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\"\u001a\u0004\b(\u0010\u001dR0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00038\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(,¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\"\u001a\u0004\b+\u0010\u001dR2\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(/¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\"\u001a\u0004\b.\u0010\u001dR2\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(2¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\"\u001a\u0004\b1\u0010\u001dÊ\u0001\u0002\bOÊ\u0001\f\bP\u0012\b\bQ\u0012\u0004\b\u0003\u0010\u0002¨\u0006N"}, d2 = {"Luz/FonRo/pos/data/model/SyncData;", "", "customers", "", "Luz/FonRo/pos/data/model/Customer;", Routes.SUPPLIERS, "Luz/FonRo/pos/data/model/Supplier;", "sales", "Luz/FonRo/pos/data/model/SyncSale;", Routes.RETURNS, "Luz/FonRo/pos/data/model/ReturnDoc;", "debtPayments", "Luz/FonRo/pos/data/model/DebtPayment;", "stockIn", "Luz/FonRo/pos/data/model/StockInDoc;", "inventoryAudits", "Luz/FonRo/pos/data/model/AuditDoc;", "supplierReturns", "Luz/FonRo/pos/data/model/SupplierReturnDoc;", "writeOffs", "Luz/FonRo/pos/data/model/WriteOffDoc;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCustomers", "()Ljava/util/List;", "getSuppliers", "getSales", "getReturns", "getDebtPayments$annotations", "()V", "getDebtPayments", "Lkotlinx/serialization/SerialName;", "value", "debt_payments", "getStockIn$annotations", "getStockIn", "stock_in", "getInventoryAudits$annotations", "getInventoryAudits", "inventory_audits", "getSupplierReturns$annotations", "getSupplierReturns", Routes.SUPPLIER_RETURNS, "getWriteOffs$annotations", "getWriteOffs", "write_offs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class SyncData {
    public static final int $stable = 0;
    private final List<Customer> customers;
    private final List<DebtPayment> debtPayments;
    private final List<AuditDoc> inventoryAudits;
    private final List<ReturnDoc> returns;
    private final List<SyncSale> sales;
    private final List<StockInDoc> stockIn;
    private final List<SupplierReturnDoc> supplierReturns;
    private final List<Supplier> suppliers;
    private final List<WriteOffDoc> writeOffs;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.SyncData$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = SyncData._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.SyncData$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = SyncData._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.SyncData$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = SyncData._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.SyncData$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$2;
            _childSerializers$_anonymous_$2 = SyncData._childSerializers$_anonymous_$2();
            return _childSerializers$_anonymous_$2;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.SyncData$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$3;
            _childSerializers$_anonymous_$3 = SyncData._childSerializers$_anonymous_$3();
            return _childSerializers$_anonymous_$3;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.SyncData$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$4;
            _childSerializers$_anonymous_$4 = SyncData._childSerializers$_anonymous_$4();
            return _childSerializers$_anonymous_$4;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.SyncData$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$5;
            _childSerializers$_anonymous_$5 = SyncData._childSerializers$_anonymous_$5();
            return _childSerializers$_anonymous_$5;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.SyncData$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$6;
            _childSerializers$_anonymous_$6 = SyncData._childSerializers$_anonymous_$6();
            return _childSerializers$_anonymous_$6;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.SyncData$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$7;
            _childSerializers$_anonymous_$7 = SyncData._childSerializers$_anonymous_$7();
            return _childSerializers$_anonymous_$7;
        }
    })};

    public SyncData() {
        this((List) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, 511, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(Customer$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(Supplier$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(SyncSale$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(ReturnDoc$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        return new ArrayListSerializer(DebtPayment$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
        return new ArrayListSerializer(StockInDoc$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$5() {
        return new ArrayListSerializer(AuditDoc$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$6() {
        return new ArrayListSerializer(SupplierReturnDoc$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$7() {
        return new ArrayListSerializer(WriteOffDoc$$serializer.INSTANCE);
    }

    public static /* synthetic */ SyncData copy$default(SyncData syncData, List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, List list9, int i, Object obj) {
        if ((i & 1) != 0) {
            list = syncData.customers;
        }
        if ((i & 2) != 0) {
            list2 = syncData.suppliers;
        }
        if ((i & 4) != 0) {
            list3 = syncData.sales;
        }
        if ((i & 8) != 0) {
            list4 = syncData.returns;
        }
        if ((i & 16) != 0) {
            list5 = syncData.debtPayments;
        }
        if ((i & 32) != 0) {
            list6 = syncData.stockIn;
        }
        if ((i & 64) != 0) {
            list7 = syncData.inventoryAudits;
        }
        if ((i & 128) != 0) {
            list8 = syncData.supplierReturns;
        }
        if ((i & 256) != 0) {
            list9 = syncData.writeOffs;
        }
        List list10 = list8;
        List list11 = list9;
        List list12 = list6;
        List list13 = list7;
        List list14 = list5;
        List list15 = list3;
        return syncData.copy(list, list2, list15, list4, list14, list12, list13, list10, list11);
    }

    @SerialName("debt_payments")
    public static /* synthetic */ void getDebtPayments$annotations() {
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

    public final List<Customer> component1() {
        return this.customers;
    }

    public final List<Supplier> component2() {
        return this.suppliers;
    }

    public final List<SyncSale> component3() {
        return this.sales;
    }

    public final List<ReturnDoc> component4() {
        return this.returns;
    }

    public final List<DebtPayment> component5() {
        return this.debtPayments;
    }

    public final List<StockInDoc> component6() {
        return this.stockIn;
    }

    public final List<AuditDoc> component7() {
        return this.inventoryAudits;
    }

    public final List<SupplierReturnDoc> component8() {
        return this.supplierReturns;
    }

    public final List<WriteOffDoc> component9() {
        return this.writeOffs;
    }

    public final SyncData copy(List<Customer> customers, List<Supplier> suppliers, List<SyncSale> sales, List<ReturnDoc> returns, List<DebtPayment> debtPayments, List<StockInDoc> stockIn, List<AuditDoc> inventoryAudits, List<SupplierReturnDoc> supplierReturns, List<WriteOffDoc> writeOffs) {
        Intrinsics.checkNotNullParameter(customers, "customers");
        Intrinsics.checkNotNullParameter(suppliers, "suppliers");
        Intrinsics.checkNotNullParameter(sales, "sales");
        Intrinsics.checkNotNullParameter(returns, "returns");
        Intrinsics.checkNotNullParameter(debtPayments, "debtPayments");
        Intrinsics.checkNotNullParameter(stockIn, "stockIn");
        Intrinsics.checkNotNullParameter(inventoryAudits, "inventoryAudits");
        return new SyncData(customers, suppliers, sales, returns, debtPayments, stockIn, inventoryAudits, supplierReturns, writeOffs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncData)) {
            return false;
        }
        SyncData syncData = (SyncData) other;
        return Intrinsics.areEqual(this.customers, syncData.customers) && Intrinsics.areEqual(this.suppliers, syncData.suppliers) && Intrinsics.areEqual(this.sales, syncData.sales) && Intrinsics.areEqual(this.returns, syncData.returns) && Intrinsics.areEqual(this.debtPayments, syncData.debtPayments) && Intrinsics.areEqual(this.stockIn, syncData.stockIn) && Intrinsics.areEqual(this.inventoryAudits, syncData.inventoryAudits) && Intrinsics.areEqual(this.supplierReturns, syncData.supplierReturns) && Intrinsics.areEqual(this.writeOffs, syncData.writeOffs);
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.customers.hashCode() * 31) + this.suppliers.hashCode()) * 31) + this.sales.hashCode()) * 31) + this.returns.hashCode()) * 31) + this.debtPayments.hashCode()) * 31) + this.stockIn.hashCode()) * 31) + this.inventoryAudits.hashCode()) * 31;
        List<SupplierReturnDoc> list = this.supplierReturns;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<WriteOffDoc> list2 = this.writeOffs;
        return hashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "SyncData(customers=" + this.customers + ", suppliers=" + this.suppliers + ", sales=" + this.sales + ", returns=" + this.returns + ", debtPayments=" + this.debtPayments + ", stockIn=" + this.stockIn + ", inventoryAudits=" + this.inventoryAudits + ", supplierReturns=" + this.supplierReturns + ", writeOffs=" + this.writeOffs + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/SyncData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/SyncData;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SyncData> serializer() {
            return SyncData$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SyncData(int i, List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, List list9, SerializationConstructorMarker serializationConstructorMarker) {
        this.customers = (i & 1) == 0 ? CollectionsKt.emptyList() : list;
        if ((i & 2) == 0) {
            this.suppliers = CollectionsKt.emptyList();
        } else {
            this.suppliers = list2;
        }
        if ((i & 4) == 0) {
            this.sales = CollectionsKt.emptyList();
        } else {
            this.sales = list3;
        }
        if ((i & 8) == 0) {
            this.returns = CollectionsKt.emptyList();
        } else {
            this.returns = list4;
        }
        if ((i & 16) == 0) {
            this.debtPayments = CollectionsKt.emptyList();
        } else {
            this.debtPayments = list5;
        }
        if ((i & 32) == 0) {
            this.stockIn = CollectionsKt.emptyList();
        } else {
            this.stockIn = list6;
        }
        if ((i & 64) == 0) {
            this.inventoryAudits = CollectionsKt.emptyList();
        } else {
            this.inventoryAudits = list7;
        }
        if ((i & 128) == 0) {
            this.supplierReturns = null;
        } else {
            this.supplierReturns = list8;
        }
        if ((i & 256) == 0) {
            this.writeOffs = null;
        } else {
            this.writeOffs = list9;
        }
    }

    public SyncData(List<Customer> customers, List<Supplier> suppliers, List<SyncSale> sales, List<ReturnDoc> returns, List<DebtPayment> debtPayments, List<StockInDoc> stockIn, List<AuditDoc> inventoryAudits, List<SupplierReturnDoc> list, List<WriteOffDoc> list2) {
        Intrinsics.checkNotNullParameter(customers, "customers");
        Intrinsics.checkNotNullParameter(suppliers, "suppliers");
        Intrinsics.checkNotNullParameter(sales, "sales");
        Intrinsics.checkNotNullParameter(returns, "returns");
        Intrinsics.checkNotNullParameter(debtPayments, "debtPayments");
        Intrinsics.checkNotNullParameter(stockIn, "stockIn");
        Intrinsics.checkNotNullParameter(inventoryAudits, "inventoryAudits");
        this.customers = customers;
        this.suppliers = suppliers;
        this.sales = sales;
        this.returns = returns;
        this.debtPayments = debtPayments;
        this.stockIn = stockIn;
        this.inventoryAudits = inventoryAudits;
        this.supplierReturns = list;
        this.writeOffs = list2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(SyncData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.customers, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.customers);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.suppliers, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.suppliers);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.sales, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.sales);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.returns, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.returns);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.debtPayments, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.debtPayments);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.stockIn, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.stockIn);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.inventoryAudits, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 6, lazyArr[6].getValue(), self.inventoryAudits);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.supplierReturns != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.supplierReturns);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 8) && self.writeOffs == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 8, lazyArr[8].getValue(), self.writeOffs);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ SyncData(java.util.List r2, java.util.List r3, java.util.List r4, java.util.List r5, java.util.List r6, java.util.List r7, java.util.List r8, java.util.List r9, java.util.List r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r1 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L8
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L8:
            r12 = r11 & 2
            if (r12 == 0) goto L10
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
        L10:
            r12 = r11 & 4
            if (r12 == 0) goto L18
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
        L18:
            r12 = r11 & 8
            if (r12 == 0) goto L20
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        L20:
            r12 = r11 & 16
            if (r12 == 0) goto L28
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        L28:
            r12 = r11 & 32
            if (r12 == 0) goto L30
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
        L30:
            r12 = r11 & 64
            if (r12 == 0) goto L38
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
        L38:
            r12 = r11 & 128(0x80, float:1.794E-43)
            r0 = 0
            if (r12 == 0) goto L3e
            r9 = r0
        L3e:
            r11 = r11 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L4d
            r12 = r0
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L57
        L4d:
            r12 = r10
            r11 = r9
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L57:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.data.model.SyncData.<init>(java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<Customer> getCustomers() {
        return this.customers;
    }

    public final List<Supplier> getSuppliers() {
        return this.suppliers;
    }

    public final List<SyncSale> getSales() {
        return this.sales;
    }

    public final List<ReturnDoc> getReturns() {
        return this.returns;
    }

    public final List<DebtPayment> getDebtPayments() {
        return this.debtPayments;
    }

    public final List<StockInDoc> getStockIn() {
        return this.stockIn;
    }

    public final List<AuditDoc> getInventoryAudits() {
        return this.inventoryAudits;
    }

    public final List<SupplierReturnDoc> getSupplierReturns() {
        return this.supplierReturns;
    }

    public final List<WriteOffDoc> getWriteOffs() {
        return this.writeOffs;
    }
}
