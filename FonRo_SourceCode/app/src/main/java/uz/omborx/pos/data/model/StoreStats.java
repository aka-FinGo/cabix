package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
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
import uz.FonRo.pos.data.local.CacheStore;
import uz.FonRo.pos.ui.nav.Routes;

/* compiled from: Stats.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 \\2\u00020\u0001:\u0002[\\B£\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e¢\u0006\u0004\b\u0019\u0010\u001aB·\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000e\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000e\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u0019\u0010\u001fJ\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0007HÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\t\u0010C\u001a\u00020\nHÆ\u0003J\t\u0010D\u001a\u00020\fHÆ\u0003J\u000f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\u000f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eHÆ\u0003J\u000f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eHÆ\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eHÆ\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eHÆ\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00180\u000eHÆ\u0003J¥\u0001\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000eHÆ\u0001J\u0014\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010O\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010P\u001a\u00020QHÖ\u0081\u0004J)\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XH\u0001b\u0002\bZ¢\u0006\u0002\bYR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R*\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b)\u0012\b\b*\u0012\u0004\b\b(+¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010%R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R*\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004r\f\b)\u0012\b\b*\u0012\u0004\b\b(1¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010'\u001a\u0004\b/\u00100R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e8\u0006X\u0087\u0004r\f\b)\u0012\b\b*\u0012\u0004\b\b(6¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010'\u001a\u0004\b5\u00103R0\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8\u0006X\u0087\u0004r\f\b)\u0012\b\b*\u0012\u0004\b\b(9¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010'\u001a\u0004\b8\u00103R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u00103R0\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e8\u0006X\u0087\u0004r\f\b)\u0012\b\b*\u0012\u0004\b\b(=¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010'\u001a\u0004\b<\u00103R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u00103Ê\u0001\u0002\b^Ê\u0001\f\b_\u0012\b\b`\u0012\u0004\b\u0003\u0010\u0002¨\u0006]"}, d2 = {"Luz/FonRo/pos/data/model/StoreStats;", "", "sales", "Luz/FonRo/pos/data/model/StatsSales;", Routes.RETURNS, "Luz/FonRo/pos/data/model/StatsReturns;", Routes.EXPENSES, "Luz/FonRo/pos/data/model/StatsAmount;", "debtReceived", "inventory", "Luz/FonRo/pos/data/model/StatsInventory;", "stockIn", "Luz/FonRo/pos/data/model/StatsStockIn;", "days", "", "Luz/FonRo/pos/data/model/StatsDay;", "returnDays", "Luz/FonRo/pos/data/model/StatsReturnDay;", "expenseDays", CacheStore.CATEGORIES, "Luz/FonRo/pos/data/model/StatsCategory;", "topProducts", "Luz/FonRo/pos/data/model/StatsProduct;", "employees", "Luz/FonRo/pos/data/model/StatsEmployee;", "<init>", "(Luz/FonRo/pos/data/model/StatsSales;Luz/FonRo/pos/data/model/StatsReturns;Luz/FonRo/pos/data/model/StatsAmount;Luz/FonRo/pos/data/model/StatsAmount;Luz/FonRo/pos/data/model/StatsInventory;Luz/FonRo/pos/data/model/StatsStockIn;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILuz/FonRo/pos/data/model/StatsSales;Luz/FonRo/pos/data/model/StatsReturns;Luz/FonRo/pos/data/model/StatsAmount;Luz/FonRo/pos/data/model/StatsAmount;Luz/FonRo/pos/data/model/StatsInventory;Luz/FonRo/pos/data/model/StatsStockIn;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSales", "()Luz/FonRo/pos/data/model/StatsSales;", "getReturns", "()Luz/FonRo/pos/data/model/StatsReturns;", "getExpenses", "()Luz/FonRo/pos/data/model/StatsAmount;", "getDebtReceived$annotations", "()V", "getDebtReceived", "Lkotlinx/serialization/SerialName;", "value", "debt_received", "getInventory", "()Luz/FonRo/pos/data/model/StatsInventory;", "getStockIn$annotations", "getStockIn", "()Luz/FonRo/pos/data/model/StatsStockIn;", "stock_in", "getDays", "()Ljava/util/List;", "getReturnDays$annotations", "getReturnDays", "return_days", "getExpenseDays$annotations", "getExpenseDays", "expense_days", "getCategories", "getTopProducts$annotations", "getTopProducts", "top_products", "getEmployees", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class StoreStats {
    public static final int $stable = 0;
    private final List<StatsCategory> categories;
    private final List<StatsDay> days;
    private final StatsAmount debtReceived;
    private final List<StatsEmployee> employees;
    private final List<StatsAmount> expenseDays;
    private final StatsAmount expenses;
    private final StatsInventory inventory;
    private final List<StatsReturnDay> returnDays;
    private final StatsReturns returns;
    private final StatsSales sales;
    private final StatsStockIn stockIn;
    private final List<StatsProduct> topProducts;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.StoreStats$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = StoreStats._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.StoreStats$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = StoreStats._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.StoreStats$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = StoreStats._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.StoreStats$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$2;
            _childSerializers$_anonymous_$2 = StoreStats._childSerializers$_anonymous_$2();
            return _childSerializers$_anonymous_$2;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.StoreStats$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$3;
            _childSerializers$_anonymous_$3 = StoreStats._childSerializers$_anonymous_$3();
            return _childSerializers$_anonymous_$3;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.StoreStats$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$4;
            _childSerializers$_anonymous_$4 = StoreStats._childSerializers$_anonymous_$4();
            return _childSerializers$_anonymous_$4;
        }
    })};

    public StoreStats() {
        this((StatsSales) null, (StatsReturns) null, (StatsAmount) null, (StatsAmount) null, (StatsInventory) null, (StatsStockIn) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, 4095, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StatsDay$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(StatsReturnDay$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(StatsAmount$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(StatsCategory$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        return new ArrayListSerializer(StatsProduct$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
        return new ArrayListSerializer(StatsEmployee$$serializer.INSTANCE);
    }

    public static /* synthetic */ StoreStats copy$default(StoreStats storeStats, StatsSales statsSales, StatsReturns statsReturns, StatsAmount statsAmount, StatsAmount statsAmount2, StatsInventory statsInventory, StatsStockIn statsStockIn, List list, List list2, List list3, List list4, List list5, List list6, int i, Object obj) {
        if ((i & 1) != 0) {
            statsSales = storeStats.sales;
        }
        if ((i & 2) != 0) {
            statsReturns = storeStats.returns;
        }
        if ((i & 4) != 0) {
            statsAmount = storeStats.expenses;
        }
        if ((i & 8) != 0) {
            statsAmount2 = storeStats.debtReceived;
        }
        if ((i & 16) != 0) {
            statsInventory = storeStats.inventory;
        }
        if ((i & 32) != 0) {
            statsStockIn = storeStats.stockIn;
        }
        if ((i & 64) != 0) {
            list = storeStats.days;
        }
        if ((i & 128) != 0) {
            list2 = storeStats.returnDays;
        }
        if ((i & 256) != 0) {
            list3 = storeStats.expenseDays;
        }
        if ((i & 512) != 0) {
            list4 = storeStats.categories;
        }
        if ((i & 1024) != 0) {
            list5 = storeStats.topProducts;
        }
        if ((i & 2048) != 0) {
            list6 = storeStats.employees;
        }
        List list7 = list5;
        List list8 = list6;
        List list9 = list3;
        List list10 = list4;
        List list11 = list;
        List list12 = list2;
        StatsInventory statsInventory2 = statsInventory;
        StatsStockIn statsStockIn2 = statsStockIn;
        return storeStats.copy(statsSales, statsReturns, statsAmount, statsAmount2, statsInventory2, statsStockIn2, list11, list12, list9, list10, list7, list8);
    }

    @SerialName("debt_received")
    public static /* synthetic */ void getDebtReceived$annotations() {
    }

    @SerialName("expense_days")
    public static /* synthetic */ void getExpenseDays$annotations() {
    }

    @SerialName("return_days")
    public static /* synthetic */ void getReturnDays$annotations() {
    }

    @SerialName("stock_in")
    public static /* synthetic */ void getStockIn$annotations() {
    }

    @SerialName("top_products")
    public static /* synthetic */ void getTopProducts$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final StatsSales getSales() {
        return this.sales;
    }

    public final List<StatsCategory> component10() {
        return this.categories;
    }

    public final List<StatsProduct> component11() {
        return this.topProducts;
    }

    public final List<StatsEmployee> component12() {
        return this.employees;
    }

    /* renamed from: component2, reason: from getter */
    public final StatsReturns getReturns() {
        return this.returns;
    }

    /* renamed from: component3, reason: from getter */
    public final StatsAmount getExpenses() {
        return this.expenses;
    }

    /* renamed from: component4, reason: from getter */
    public final StatsAmount getDebtReceived() {
        return this.debtReceived;
    }

    /* renamed from: component5, reason: from getter */
    public final StatsInventory getInventory() {
        return this.inventory;
    }

    /* renamed from: component6, reason: from getter */
    public final StatsStockIn getStockIn() {
        return this.stockIn;
    }

    public final List<StatsDay> component7() {
        return this.days;
    }

    public final List<StatsReturnDay> component8() {
        return this.returnDays;
    }

    public final List<StatsAmount> component9() {
        return this.expenseDays;
    }

    public final StoreStats copy(StatsSales sales, StatsReturns returns, StatsAmount expenses, StatsAmount debtReceived, StatsInventory inventory, StatsStockIn stockIn, List<StatsDay> days, List<StatsReturnDay> returnDays, List<StatsAmount> expenseDays, List<StatsCategory> categories, List<StatsProduct> topProducts, List<StatsEmployee> employees) {
        Intrinsics.checkNotNullParameter(sales, "sales");
        Intrinsics.checkNotNullParameter(returns, "returns");
        Intrinsics.checkNotNullParameter(expenses, "expenses");
        Intrinsics.checkNotNullParameter(debtReceived, "debtReceived");
        Intrinsics.checkNotNullParameter(inventory, "inventory");
        Intrinsics.checkNotNullParameter(stockIn, "stockIn");
        Intrinsics.checkNotNullParameter(days, "days");
        Intrinsics.checkNotNullParameter(returnDays, "returnDays");
        Intrinsics.checkNotNullParameter(expenseDays, "expenseDays");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(topProducts, "topProducts");
        Intrinsics.checkNotNullParameter(employees, "employees");
        return new StoreStats(sales, returns, expenses, debtReceived, inventory, stockIn, days, returnDays, expenseDays, categories, topProducts, employees);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreStats)) {
            return false;
        }
        StoreStats storeStats = (StoreStats) other;
        return Intrinsics.areEqual(this.sales, storeStats.sales) && Intrinsics.areEqual(this.returns, storeStats.returns) && Intrinsics.areEqual(this.expenses, storeStats.expenses) && Intrinsics.areEqual(this.debtReceived, storeStats.debtReceived) && Intrinsics.areEqual(this.inventory, storeStats.inventory) && Intrinsics.areEqual(this.stockIn, storeStats.stockIn) && Intrinsics.areEqual(this.days, storeStats.days) && Intrinsics.areEqual(this.returnDays, storeStats.returnDays) && Intrinsics.areEqual(this.expenseDays, storeStats.expenseDays) && Intrinsics.areEqual(this.categories, storeStats.categories) && Intrinsics.areEqual(this.topProducts, storeStats.topProducts) && Intrinsics.areEqual(this.employees, storeStats.employees);
    }

    public int hashCode() {
        return (((((((((((((((((((((this.sales.hashCode() * 31) + this.returns.hashCode()) * 31) + this.expenses.hashCode()) * 31) + this.debtReceived.hashCode()) * 31) + this.inventory.hashCode()) * 31) + this.stockIn.hashCode()) * 31) + this.days.hashCode()) * 31) + this.returnDays.hashCode()) * 31) + this.expenseDays.hashCode()) * 31) + this.categories.hashCode()) * 31) + this.topProducts.hashCode()) * 31) + this.employees.hashCode();
    }

    public String toString() {
        return "StoreStats(sales=" + this.sales + ", returns=" + this.returns + ", expenses=" + this.expenses + ", debtReceived=" + this.debtReceived + ", inventory=" + this.inventory + ", stockIn=" + this.stockIn + ", days=" + this.days + ", returnDays=" + this.returnDays + ", expenseDays=" + this.expenseDays + ", categories=" + this.categories + ", topProducts=" + this.topProducts + ", employees=" + this.employees + ")";
    }

    /* compiled from: Stats.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/StoreStats$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/StoreStats;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StoreStats> serializer() {
            return StoreStats$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ StoreStats(int i, StatsSales statsSales, StatsReturns statsReturns, StatsAmount statsAmount, StatsAmount statsAmount2, StatsInventory statsInventory, StatsStockIn statsStockIn, List list, List list2, List list3, List list4, List list5, List list6, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.sales = new StatsSales(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0, 7, (DefaultConstructorMarker) null);
        } else {
            this.sales = statsSales;
        }
        if ((i & 2) == 0) {
            this.returns = new StatsReturns(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0, 7, (DefaultConstructorMarker) null);
        } else {
            this.returns = statsReturns;
        }
        if ((i & 4) == 0) {
            this.expenses = new StatsAmount((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 7, (DefaultConstructorMarker) null);
        } else {
            this.expenses = statsAmount;
        }
        if ((i & 8) == 0) {
            this.debtReceived = new StatsAmount((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 7, (DefaultConstructorMarker) null);
        } else {
            this.debtReceived = statsAmount2;
        }
        if ((i & 16) == 0) {
            this.inventory = new StatsInventory(0, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 7, (DefaultConstructorMarker) null);
        } else {
            this.inventory = statsInventory;
        }
        if ((i & 32) == 0) {
            this.stockIn = new StatsStockIn(0, AudioStats.AUDIO_AMPLITUDE_NONE, 3, (DefaultConstructorMarker) null);
        } else {
            this.stockIn = statsStockIn;
        }
        this.days = (i & 64) == 0 ? CollectionsKt.emptyList() : list;
        this.returnDays = (i & 128) == 0 ? CollectionsKt.emptyList() : list2;
        this.expenseDays = (i & 256) == 0 ? CollectionsKt.emptyList() : list3;
        this.categories = (i & 512) == 0 ? CollectionsKt.emptyList() : list4;
        this.topProducts = (i & 1024) == 0 ? CollectionsKt.emptyList() : list5;
        this.employees = (i & 2048) == 0 ? CollectionsKt.emptyList() : list6;
    }

    public StoreStats(StatsSales sales, StatsReturns returns, StatsAmount expenses, StatsAmount debtReceived, StatsInventory inventory, StatsStockIn stockIn, List<StatsDay> days, List<StatsReturnDay> returnDays, List<StatsAmount> expenseDays, List<StatsCategory> categories, List<StatsProduct> topProducts, List<StatsEmployee> employees) {
        Intrinsics.checkNotNullParameter(sales, "sales");
        Intrinsics.checkNotNullParameter(returns, "returns");
        Intrinsics.checkNotNullParameter(expenses, "expenses");
        Intrinsics.checkNotNullParameter(debtReceived, "debtReceived");
        Intrinsics.checkNotNullParameter(inventory, "inventory");
        Intrinsics.checkNotNullParameter(stockIn, "stockIn");
        Intrinsics.checkNotNullParameter(days, "days");
        Intrinsics.checkNotNullParameter(returnDays, "returnDays");
        Intrinsics.checkNotNullParameter(expenseDays, "expenseDays");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(topProducts, "topProducts");
        Intrinsics.checkNotNullParameter(employees, "employees");
        this.sales = sales;
        this.returns = returns;
        this.expenses = expenses;
        this.debtReceived = debtReceived;
        this.inventory = inventory;
        this.stockIn = stockIn;
        this.days = days;
        this.returnDays = returnDays;
        this.expenseDays = expenseDays;
        this.categories = categories;
        this.topProducts = topProducts;
        this.employees = employees;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(StoreStats self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.sales, new StatsSales(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0, 7, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 0, StatsSales$$serializer.INSTANCE, self.sales);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.returns, new StatsReturns(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0, 7, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 1, StatsReturns$$serializer.INSTANCE, self.returns);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.expenses, new StatsAmount((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 7, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 2, StatsAmount$$serializer.INSTANCE, self.expenses);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.debtReceived, new StatsAmount((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 7, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 3, StatsAmount$$serializer.INSTANCE, self.debtReceived);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.inventory, new StatsInventory(0, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 7, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 4, StatsInventory$$serializer.INSTANCE, self.inventory);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.stockIn, new StatsStockIn(0, AudioStats.AUDIO_AMPLITUDE_NONE, 3, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 5, StatsStockIn$$serializer.INSTANCE, self.stockIn);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.days, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 6, lazyArr[6].getValue(), self.days);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.returnDays, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.returnDays);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.expenseDays, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 8, lazyArr[8].getValue(), self.expenseDays);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.categories, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 9, lazyArr[9].getValue(), self.categories);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || !Intrinsics.areEqual(self.topProducts, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 10, lazyArr[10].getValue(), self.topProducts);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 11) && Intrinsics.areEqual(self.employees, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 11, lazyArr[11].getValue(), self.employees);
    }

    public /* synthetic */ StoreStats(StatsSales statsSales, StatsReturns statsReturns, StatsAmount statsAmount, StatsAmount statsAmount2, StatsInventory statsInventory, StatsStockIn statsStockIn, List list, List list2, List list3, List list4, List list5, List list6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new StatsSales(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0, 7, (DefaultConstructorMarker) null) : statsSales, (i & 2) != 0 ? new StatsReturns(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0, 7, (DefaultConstructorMarker) null) : statsReturns, (i & 4) != 0 ? new StatsAmount((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 7, (DefaultConstructorMarker) null) : statsAmount, (i & 8) != 0 ? new StatsAmount((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 7, (DefaultConstructorMarker) null) : statsAmount2, (i & 16) != 0 ? new StatsInventory(0, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 7, (DefaultConstructorMarker) null) : statsInventory, (i & 32) != 0 ? new StatsStockIn(0, AudioStats.AUDIO_AMPLITUDE_NONE, 3, (DefaultConstructorMarker) null) : statsStockIn, (i & 64) != 0 ? CollectionsKt.emptyList() : list, (i & 128) != 0 ? CollectionsKt.emptyList() : list2, (i & 256) != 0 ? CollectionsKt.emptyList() : list3, (i & 512) != 0 ? CollectionsKt.emptyList() : list4, (i & 1024) != 0 ? CollectionsKt.emptyList() : list5, (i & 2048) != 0 ? CollectionsKt.emptyList() : list6);
    }

    public final StatsSales getSales() {
        return this.sales;
    }

    public final StatsReturns getReturns() {
        return this.returns;
    }

    public final StatsAmount getExpenses() {
        return this.expenses;
    }

    public final StatsAmount getDebtReceived() {
        return this.debtReceived;
    }

    public final StatsInventory getInventory() {
        return this.inventory;
    }

    public final StatsStockIn getStockIn() {
        return this.stockIn;
    }

    public final List<StatsDay> getDays() {
        return this.days;
    }

    public final List<StatsReturnDay> getReturnDays() {
        return this.returnDays;
    }

    public final List<StatsAmount> getExpenseDays() {
        return this.expenseDays;
    }

    public final List<StatsCategory> getCategories() {
        return this.categories;
    }

    public final List<StatsProduct> getTopProducts() {
        return this.topProducts;
    }

    public final List<StatsEmployee> getEmployees() {
        return this.employees;
    }
}
