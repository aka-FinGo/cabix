package uz.FonRo.pos.data.repo;

import android.content.Context;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Num;
import uz.FonRo.pos.core.Units;
import uz.FonRo.pos.data.local.CacheStore;
import uz.FonRo.pos.data.local.SaleOutbox;
import uz.FonRo.pos.data.model.Category;
import uz.FonRo.pos.data.model.Customer;
import uz.FonRo.pos.data.model.Paywall;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.model.Session;
import uz.FonRo.pos.data.model.Store;
import uz.FonRo.pos.data.model.Supplier;
import uz.FonRo.pos.data.model.SyncData;
import uz.FonRo.pos.data.model.User;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.net.ApiService;
import uz.FonRo.pos.data.prefs.AppPrefs;
import uz.FonRo.pos.ui.nav.Routes;

/* compiled from: Repo.kt */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010L\u001a\u00020=2\u0006\u0010M\u001a\u000209J\u001a\u0010N\u001a\u00020O2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020A0QJ\u0006\u0010R\u001a\u00020=J\u0006\u0010S\u001a\u000209J\u0015\u0010T\u001a\u0002092\b\u0010U\u001a\u0004\u0018\u00010V¢\u0006\u0002\u0010WJ\u0006\u0010`\u001a\u00020OJ\u0006\u0010a\u001a\u00020OJ\u0018\u0010b\u001a\u00020O2\b\b\u0002\u0010c\u001a\u00020=H\u0086@¢\u0006\u0002\u0010dJ\u0018\u0010e\u001a\u00020O2\b\b\u0002\u0010c\u001a\u00020=H\u0086@¢\u0006\u0002\u0010dJ\u0010\u0010f\u001a\u00020O2\b\b\u0002\u0010g\u001a\u00020=J\u000e\u0010l\u001a\u00020OH\u0086@¢\u0006\u0002\u0010mJ\u000e\u0010n\u001a\u00020O2\u0006\u0010o\u001a\u00020pJ\u0010\u0010q\u001a\u00020O2\b\u0010r\u001a\u0004\u0018\u00010sJ\u000e\u0010t\u001a\u00020pH\u0086@¢\u0006\u0002\u0010mJ\u000e\u0010u\u001a\u00020OH\u0086@¢\u0006\u0002\u0010mJ\u0006\u0010v\u001a\u00020OJ\u000e\u0010w\u001a\u00020O2\u0006\u0010x\u001a\u00020%J\u000e\u0010y\u001a\u00020O2\u0006\u0010z\u001a\u00020YJ\u000e\u0010{\u001a\u00020O2\u0006\u0010|\u001a\u00020)J\u000e\u0010}\u001a\u00020O2\u0006\u0010z\u001a\u00020YJ\u000e\u0010~\u001a\u00020O2\u0006\u0010\u007f\u001a\u00020-J\u001c\u0010\u0080\u0001\u001a\u00020O2\u0013\u0010\u0081\u0001\u001a\u000e\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020V0QJ\u0011\u0010\u0082\u0001\u001a\u0004\u0018\u00010%2\u0006\u0010z\u001a\u00020YJ\u0012\u0010\u0083\u0001\u001a\u0004\u0018\u00010%2\u0007\u0010\u0084\u0001\u001a\u000209J\u000f\u0010\u0085\u0001\u001a\u0002092\u0006\u0010z\u001a\u00020YJ\u0007\u0010\u0086\u0001\u001a\u00020VJ\u000f\u0010\u0087\u0001\u001a\u00020O2\u0006\u0010U\u001a\u00020=J\u000f\u0010\u0088\u0001\u001a\u00020O2\u0006\u0010U\u001a\u00020AJ\u000f\u0010\u0089\u0001\u001a\u00020O2\u0006\u0010U\u001a\u00020AR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0\u001c¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u001a\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0$0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0$0\u001c¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u001a\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0$0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0$0\u001c¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u001a\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010$0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010$0\u001c¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001eR\u0016\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u001c¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001eR\u0016\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\u001c¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u001eR\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u001c¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u001eR\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020A0\u001c¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u001eR\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020A0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020A0\u001c¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u001eR\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020A0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020A0\u001c¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u001eR\u0011\u0010J\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u000e\u0010X\u001a\u00020YX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020YX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020YX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020^X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010i\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010V0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010j\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010V0\u001c¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\u001eÊ\u0001\u000e\b\u008b\u0001\u0012\t\b\u008c\u0001\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u008a\u0001"}, d2 = {"Luz/FonRo/pos/data/repo/Repo;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "prefs", "Luz/FonRo/pos/data/prefs/AppPrefs;", "getPrefs", "()Luz/FonRo/pos/data/prefs/AppPrefs;", "cache", "Luz/FonRo/pos/data/local/CacheStore;", "getCache", "()Luz/FonRo/pos/data/local/CacheStore;", Routes.OUTBOX, "Luz/FonRo/pos/data/local/SaleOutbox;", "getOutbox", "()Luz/FonRo/pos/data/local/SaleOutbox;", "api", "Luz/FonRo/pos/data/net/ApiService;", "getApi", "()Luz/FonRo/pos/data/net/ApiService;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "_user", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Luz/FonRo/pos/data/model/User;", "user", "Lkotlinx/coroutines/flow/StateFlow;", "getUser", "()Lkotlinx/coroutines/flow/StateFlow;", "_store", "Luz/FonRo/pos/data/model/Store;", "store", "getStore", "_products", "", "Luz/FonRo/pos/data/model/Product;", CacheStore.PRODUCTS, "getProducts", "_categories", "Luz/FonRo/pos/data/model/Category;", CacheStore.CATEGORIES, "getCategories", "_customers", "Luz/FonRo/pos/data/model/Customer;", "customers", "getCustomers", "_suppliers", "Luz/FonRo/pos/data/model/Supplier;", Routes.SUPPLIERS, "getSuppliers", "_sync", "Luz/FonRo/pos/data/model/SyncData;", "sync", "getSync", "_syncError", "", "syncError", "getSyncError", "_online", "", "online", "getOnline", "_dataVersion", "", "dataVersion", "getDataVersion", "_supportUnread", "supportUnread", "getSupportUnread", "_ordersNew", "ordersNew", "getOrdersNew", "isLoggedIn", "()Z", "can", "permission", "updateSelfLimits", "", "limits", "", "canBilling", FirebaseAnalytics.Param.CURRENCY, "money", "value", "", "(Ljava/lang/Double;)Ljava/lang/String;", "LOAD_TTL_MS", "", "catalogAt", "directoryAt", "generation", "catalogLock", "Lkotlinx/coroutines/sync/Mutex;", "directoryLock", "invalidate", "restoreFromCache", "loadCatalog", "force", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadDirectory", "refreshInBackground", "withCatalog", "debtTotalAt", "_debtTotal", "debtTotal", "getDebtTotal", "refreshDebtTotal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applySession", CacheStore.SESSION, "Luz/FonRo/pos/data/model/Session;", "updatePaywall", "paywall", "Luz/FonRo/pos/data/model/Paywall;", "refreshSession", "logout", "clearLocal", "upsertProduct", "product", "removeProduct", "id", "upsertCategory", "category", "removeCategory", "addCustomer", "customer", "applyStockDelta", "deltas", "productById", "findByBarcode", "code", "categoryName", "wholeStockUnits", "setOnline", "setSupportUnread", "setOrdersNew", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class Repo {
    public static final int $stable = 8;
    private final long LOAD_TTL_MS;
    private final MutableStateFlow<List<Category>> _categories;
    private final MutableStateFlow<List<Customer>> _customers;
    private final MutableStateFlow<Integer> _dataVersion;
    private final MutableStateFlow<Double> _debtTotal;
    private final MutableStateFlow<Boolean> _online;
    private final MutableStateFlow<Integer> _ordersNew;
    private final MutableStateFlow<List<Product>> _products;
    private final MutableStateFlow<Store> _store;
    private final MutableStateFlow<List<Supplier>> _suppliers;
    private final MutableStateFlow<Integer> _supportUnread;
    private final MutableStateFlow<SyncData> _sync;
    private final MutableStateFlow<String> _syncError;
    private final MutableStateFlow<User> _user;
    private final CacheStore cache;
    private long catalogAt;
    private final Mutex catalogLock;
    private final StateFlow<List<Category>> categories;
    private final Context context;
    private final StateFlow<List<Customer>> customers;
    private final StateFlow<Integer> dataVersion;
    private final StateFlow<Double> debtTotal;
    private long debtTotalAt;
    private long directoryAt;
    private final Mutex directoryLock;
    private int generation;
    private final StateFlow<Boolean> online;
    private final StateFlow<Integer> ordersNew;
    private final SaleOutbox outbox;
    private final AppPrefs prefs;
    private final StateFlow<List<Product>> products;
    private final CoroutineScope scope;
    private final StateFlow<Store> store;
    private final StateFlow<List<Supplier>> suppliers;
    private final StateFlow<Integer> supportUnread;
    private final StateFlow<SyncData> sync;
    private final StateFlow<String> syncError;
    private final StateFlow<User> user;

    public Repo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.prefs = new AppPrefs(context);
        this.cache = new CacheStore(context);
        this.outbox = new SaleOutbox(context);
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
        MutableStateFlow<User> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._user = MutableStateFlow;
        this.user = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<Store> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._store = MutableStateFlow2;
        this.store = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<List<Product>> MutableStateFlow3 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._products = MutableStateFlow3;
        this.products = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<List<Category>> MutableStateFlow4 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._categories = MutableStateFlow4;
        this.categories = FlowKt.asStateFlow(MutableStateFlow4);
        MutableStateFlow<List<Customer>> MutableStateFlow5 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._customers = MutableStateFlow5;
        this.customers = FlowKt.asStateFlow(MutableStateFlow5);
        MutableStateFlow<List<Supplier>> MutableStateFlow6 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._suppliers = MutableStateFlow6;
        this.suppliers = FlowKt.asStateFlow(MutableStateFlow6);
        MutableStateFlow<SyncData> MutableStateFlow7 = StateFlowKt.MutableStateFlow(null);
        this._sync = MutableStateFlow7;
        this.sync = FlowKt.asStateFlow(MutableStateFlow7);
        MutableStateFlow<String> MutableStateFlow8 = StateFlowKt.MutableStateFlow(null);
        this._syncError = MutableStateFlow8;
        this.syncError = FlowKt.asStateFlow(MutableStateFlow8);
        MutableStateFlow<Boolean> MutableStateFlow9 = StateFlowKt.MutableStateFlow(true);
        this._online = MutableStateFlow9;
        this.online = FlowKt.asStateFlow(MutableStateFlow9);
        MutableStateFlow<Integer> MutableStateFlow10 = StateFlowKt.MutableStateFlow(0);
        this._dataVersion = MutableStateFlow10;
        this.dataVersion = FlowKt.asStateFlow(MutableStateFlow10);
        MutableStateFlow<Integer> MutableStateFlow11 = StateFlowKt.MutableStateFlow(0);
        this._supportUnread = MutableStateFlow11;
        this.supportUnread = FlowKt.asStateFlow(MutableStateFlow11);
        MutableStateFlow<Integer> MutableStateFlow12 = StateFlowKt.MutableStateFlow(0);
        this._ordersNew = MutableStateFlow12;
        this.ordersNew = FlowKt.asStateFlow(MutableStateFlow12);
        this.LOAD_TTL_MS = 15000L;
        this.catalogLock = MutexKt.Mutex$default(false, 1, null);
        this.directoryLock = MutexKt.Mutex$default(false, 1, null);
        MutableStateFlow<Double> MutableStateFlow13 = StateFlowKt.MutableStateFlow(null);
        this._debtTotal = MutableStateFlow13;
        this.debtTotal = FlowKt.asStateFlow(MutableStateFlow13);
    }

    public final AppPrefs getPrefs() {
        return this.prefs;
    }

    public final CacheStore getCache() {
        return this.cache;
    }

    public final SaleOutbox getOutbox() {
        return this.outbox;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApiService getApi() {
        return ApiClient.INSTANCE.api();
    }

    public final StateFlow<User> getUser() {
        return this.user;
    }

    public final StateFlow<Store> getStore() {
        return this.store;
    }

    public final StateFlow<List<Product>> getProducts() {
        return this.products;
    }

    public final StateFlow<List<Category>> getCategories() {
        return this.categories;
    }

    public final StateFlow<List<Customer>> getCustomers() {
        return this.customers;
    }

    public final StateFlow<List<Supplier>> getSuppliers() {
        return this.suppliers;
    }

    public final StateFlow<SyncData> getSync() {
        return this.sync;
    }

    public final StateFlow<String> getSyncError() {
        return this.syncError;
    }

    public final StateFlow<Boolean> getOnline() {
        return this.online;
    }

    public final StateFlow<Integer> getDataVersion() {
        return this.dataVersion;
    }

    public final StateFlow<Integer> getSupportUnread() {
        return this.supportUnread;
    }

    public final StateFlow<Integer> getOrdersNew() {
        return this.ordersNew;
    }

    public final boolean isLoggedIn() {
        return !StringsKt.isBlank(this.prefs.getToken());
    }

    public final boolean can(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        User value = this._user.getValue();
        if (value == null) {
            return false;
        }
        if (value.isOwnerLike()) {
            return !value.selfLimited(permission);
        }
        Integer num = value.getPermissions().get(permission);
        return (num != null ? num.intValue() : 0) == 1;
    }

    public final void updateSelfLimits(Map<String, Integer> limits) {
        Intrinsics.checkNotNullParameter(limits, "limits");
        User value = this._user.getValue();
        if (value == null) {
            return;
        }
        User copy$default = User.copy$default(value, 0L, null, null, null, null, false, null, 0, limits, 255, null);
        this._user.setValue(copy$default);
        try {
            Result.Companion companion = Result.INSTANCE;
            Repo repo = this;
            this.cache.save(CacheStore.SESSION, Session.INSTANCE.serializer(), new Session(null, copy$default, this._store.getValue()));
            Result.m7870constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final boolean canBilling() {
        User value = this._user.getValue();
        return value != null && value.isOwnerLike();
    }

    public final String currency() {
        String activeCurrency;
        Store value = this._store.getValue();
        return (value == null || (activeCurrency = value.getActiveCurrency()) == null) ? "UZS" : activeCurrency;
    }

    public final String money(Double value) {
        return Fmt.INSTANCE.money(value, currency());
    }

    public final void invalidate() {
        Integer value;
        this.generation++;
        this.catalogAt = 0L;
        this.directoryAt = 0L;
        this.debtTotalAt = 0L;
        MutableStateFlow<Integer> mutableStateFlow = this._dataVersion;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, Integer.valueOf(value.intValue() + 1)));
    }

    public final void restoreFromCache() {
        Session session = (Session) this.cache.load(CacheStore.SESSION, Session.INSTANCE.serializer());
        if (session != null) {
            this._user.setValue(session.getUser());
            this._store.setValue(session.getStore());
        }
        List<Product> list = (List) this.cache.load(CacheStore.PRODUCTS, BuiltinSerializersKt.ListSerializer(Product.INSTANCE.serializer()));
        if (list != null) {
            this._products.setValue(list);
        }
        List<Category> list2 = (List) this.cache.load(CacheStore.CATEGORIES, BuiltinSerializersKt.ListSerializer(Category.INSTANCE.serializer()));
        if (list2 != null) {
            this._categories.setValue(list2);
        }
        SyncData syncData = (SyncData) this.cache.load("sync", SyncData.INSTANCE.serializer());
        if (syncData != null) {
            this._sync.setValue(syncData);
            this._customers.setValue(syncData.getCustomers());
            MutableStateFlow<List<Supplier>> mutableStateFlow = this._suppliers;
            List<Supplier> suppliers = syncData.getSuppliers();
            ArrayList arrayList = new ArrayList();
            for (Object obj : suppliers) {
                if (((Supplier) obj).isArchived() == 0) {
                    arrayList.add(obj);
                }
            }
            mutableStateFlow.setValue(arrayList);
        }
    }

    public static /* synthetic */ Object loadCatalog$default(Repo repo, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return repo.loadCatalog(z, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x007c, code lost:
    
        if (r15.lock(null, r0) == r1) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0116 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:13:0x003e, B:14:0x00de, B:16:0x0116, B:17:0x011c, B:18:0x0125), top: B:12:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadCatalog(boolean r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.data.repo.Repo.loadCatalog(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object loadDirectory$default(Repo repo, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return repo.loadDirectory(z, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0060, code lost:
    
        if (r13.lock(null, r0) == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d0 A[Catch: all -> 0x003b, TryCatch #3 {all -> 0x003b, blocks: (B:12:0x0037, B:13:0x00a1, B:14:0x00ca, B:16:0x00d0, B:19:0x00dd, B:24:0x00e1, B:26:0x00fc, B:27:0x0102), top: B:11:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fc A[Catch: all -> 0x003b, TryCatch #3 {all -> 0x003b, blocks: (B:12:0x0037, B:13:0x00a1, B:14:0x00ca, B:16:0x00d0, B:19:0x00dd, B:24:0x00e1, B:26:0x00fc, B:27:0x0102), top: B:11:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0129 A[Catch: all -> 0x0133, TryCatch #1 {all -> 0x0133, blocks: (B:40:0x0114, B:42:0x0129, B:43:0x0132), top: B:39:0x0114 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadDirectory(boolean r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.data.repo.Repo.loadDirectory(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void refreshInBackground$default(Repo repo, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        repo.refreshInBackground(z);
    }

    public final void refreshInBackground(boolean withCatalog) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new Repo$refreshInBackground$1(withCatalog, this, null), 3, null);
    }

    public final StateFlow<Double> getDebtTotal() {
        return this.debtTotal;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|7|(1:(2:10|11)(2:20|21))(3:22|(3:30|31|(1:33)(1:34))|29)|12|13|(1:15)|16|17))|37|6|7|(0)(0)|12|13|(0)|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0032, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008e, code lost:
    
        r0 = kotlin.Result.INSTANCE;
        r9 = kotlin.Result.m7870constructorimpl(kotlin.ResultKt.createFailure(r9));
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refreshDebtTotal(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof uz.FonRo.pos.data.repo.Repo$refreshDebtTotal$1
            if (r0 == 0) goto L14
            r0 = r9
            uz.FonRo.pos.data.repo.Repo$refreshDebtTotal$1 r0 = (uz.FonRo.pos.data.repo.Repo$refreshDebtTotal$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            uz.FonRo.pos.data.repo.Repo$refreshDebtTotal$1 r0 = new uz.FonRo.pos.data.repo.Repo$refreshDebtTotal$1
            r0.<init>(r8, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r1 = r0.L$1
            uz.FonRo.pos.data.net.ApiClient r1 = (uz.FonRo.pos.data.net.ApiClient) r1
            java.lang.Object r0 = r0.L$0
            uz.FonRo.pos.data.repo.Repo r0 = (uz.FonRo.pos.data.repo.Repo) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L32
            goto L7e
        L32:
            r9 = move-exception
            goto L8e
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.String r9 = "can_sell_debt"
            boolean r9 = r8.can(r9)
            if (r9 != 0) goto L4a
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L4a:
            long r4 = java.lang.System.currentTimeMillis()
            long r6 = r8.debtTotalAt
            long r4 = r4 - r6
            long r6 = r8.LOAD_TTL_MS
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 >= 0) goto L5a
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L5a:
            long r4 = java.lang.System.currentTimeMillis()
            r8.debtTotalAt = r4
            kotlin.Result$Companion r9 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            r9 = r8
            uz.FonRo.pos.data.repo.Repo r9 = (uz.FonRo.pos.data.repo.Repo) r9     // Catch: java.lang.Throwable -> L32
            uz.FonRo.pos.data.net.ApiClient r9 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L32
            uz.FonRo.pos.data.net.ApiService r2 = r8.getApi()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r9     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r0 = r2.debts(r0)     // Catch: java.lang.Throwable -> L32
            if (r0 != r1) goto L7c
            return r1
        L7c:
            r1 = r9
            r9 = r0
        L7e:
            retrofit2.Response r9 = (retrofit2.Response) r9     // Catch: java.lang.Throwable -> L32
            r0 = 2
            r2 = 0
            r3 = 0
            java.lang.Object r9 = uz.FonRo.pos.data.net.ApiClient.unwrap$default(r1, r9, r3, r0, r2)     // Catch: java.lang.Throwable -> L32
            uz.FonRo.pos.data.model.DebtsResponse r9 = (uz.FonRo.pos.data.model.DebtsResponse) r9     // Catch: java.lang.Throwable -> L32
            java.lang.Object r9 = kotlin.Result.m7870constructorimpl(r9)     // Catch: java.lang.Throwable -> L32
            goto L98
        L8e:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m7870constructorimpl(r9)
        L98:
            boolean r0 = kotlin.Result.m7877isSuccessimpl(r9)
            if (r0 == 0) goto Lb1
            uz.FonRo.pos.data.model.DebtsResponse r9 = (uz.FonRo.pos.data.model.DebtsResponse) r9
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Double> r8 = r8._debtTotal
            uz.FonRo.pos.data.model.DebtKpis r9 = r9.getKpis()
            double r0 = r9.getDebtTotal()
            java.lang.Double r9 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r0)
            r8.setValue(r9)
        Lb1:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.data.repo.Repo.refreshDebtTotal(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void applySession(Session session) {
        Intrinsics.checkNotNullParameter(session, "session");
        String apiToken = session.getApiToken();
        if (apiToken != null) {
            if (StringsKt.isBlank(apiToken)) {
                apiToken = null;
            }
            if (apiToken != null) {
                this.prefs.setToken(apiToken);
            }
        }
        User user = session.getUser();
        if (user != null) {
            this._user.setValue(user);
        }
        Store store = session.getStore();
        if (store != null) {
            this._store.setValue(store);
        }
        this.cache.save(CacheStore.SESSION, Session.INSTANCE.serializer(), new Session(null, this._user.getValue(), this._store.getValue()));
    }

    public final void updatePaywall(Paywall paywall) {
        if (paywall == null) {
            return;
        }
        MutableStateFlow<Store> mutableStateFlow = this._store;
        Store value = mutableStateFlow.getValue();
        mutableStateFlow.setValue(value != null ? Store.copy$default(value, 0L, null, null, null, null, null, null, paywall, 127, null) : null);
    }

    public final Object refreshSession(Continuation<? super Session> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new Repo$refreshSession$2(this, null), continuation);
    }

    public final Object logout(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new Repo$logout$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final void clearLocal() {
        this.prefs.clearSession();
        this.cache.clear();
        this.outbox.clear();
        this._user.setValue(null);
        this._store.setValue(null);
        this._products.setValue(CollectionsKt.emptyList());
        this._categories.setValue(CollectionsKt.emptyList());
        this._customers.setValue(CollectionsKt.emptyList());
        this._suppliers.setValue(CollectionsKt.emptyList());
        this._sync.setValue(null);
        this._debtTotal.setValue(null);
        this.catalogAt = 0L;
        this.directoryAt = 0L;
        this.debtTotalAt = 0L;
    }

    public final void upsertProduct(Product product) {
        Intrinsics.checkNotNullParameter(product, "product");
        List<Product> mutableList = CollectionsKt.toMutableList((Collection) this._products.getValue());
        Iterator<Product> it = mutableList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().getId() == product.getId()) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            mutableList.set(i, product);
        } else {
            mutableList.add(product);
        }
        this._products.setValue(mutableList);
        this.cache.save(CacheStore.PRODUCTS, BuiltinSerializersKt.ListSerializer(Product.INSTANCE.serializer()), mutableList);
    }

    public final void removeProduct(long id) {
        List<Product> value = this._products.getValue();
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            if (((Product) obj).getId() != id) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        this._products.setValue(arrayList2);
        this.cache.save(CacheStore.PRODUCTS, BuiltinSerializersKt.ListSerializer(Product.INSTANCE.serializer()), arrayList2);
    }

    public final void upsertCategory(Category category) {
        Intrinsics.checkNotNullParameter(category, "category");
        List<Category> mutableList = CollectionsKt.toMutableList((Collection) this._categories.getValue());
        Iterator<Category> it = mutableList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().getId() == category.getId()) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            mutableList.set(i, category);
        } else {
            mutableList.add(category);
        }
        this._categories.setValue(mutableList);
    }

    public final void removeCategory(long id) {
        MutableStateFlow<List<Category>> mutableStateFlow = this._categories;
        List<Category> value = mutableStateFlow.getValue();
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            if (((Category) obj).getId() != id) {
                arrayList.add(obj);
            }
        }
        mutableStateFlow.setValue(arrayList);
    }

    public final void addCustomer(Customer customer) {
        Intrinsics.checkNotNullParameter(customer, "customer");
        MutableStateFlow<List<Customer>> mutableStateFlow = this._customers;
        mutableStateFlow.setValue(CollectionsKt.plus((Collection<? extends Customer>) mutableStateFlow.getValue(), customer));
    }

    public final void applyStockDelta(Map<Long, Double> deltas) {
        Intrinsics.checkNotNullParameter(deltas, "deltas");
        if (deltas.isEmpty()) {
            return;
        }
        List<Product> value = this._products.getValue();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(value, 10));
        for (Product product : value) {
            Double d = deltas.get(Long.valueOf(product.getId()));
            if (d != null) {
                product = Product.copy$default(product, 0L, null, null, null, null, Num.INSTANCE.qty(product.getQuantity() - d.doubleValue()), null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0L, AudioStats.AUDIO_AMPLITUDE_NONE, null, null, null, null, 0, 65503, null);
            }
            arrayList.add(product);
        }
        ArrayList arrayList2 = arrayList;
        this._products.setValue(arrayList2);
        this.cache.save(CacheStore.PRODUCTS, BuiltinSerializersKt.ListSerializer(Product.INSTANCE.serializer()), arrayList2);
    }

    public final Product productById(long id) {
        Object obj;
        Iterator<T> it = this._products.getValue().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Product) obj).getId() == id) {
                break;
            }
        }
        return (Product) obj;
    }

    public final Product findByBarcode(String code) {
        Object obj;
        Intrinsics.checkNotNullParameter(code, "code");
        Iterator<T> it = this._products.getValue().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Product) obj).hasBarcode(code)) {
                break;
            }
        }
        return (Product) obj;
    }

    public final String categoryName(long id) {
        Object obj;
        String name;
        Iterator<T> it = this._categories.getValue().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Category) obj).getId() == id) {
                break;
            }
        }
        Category category = (Category) obj;
        return (category == null || (name = category.getName()) == null) ? LangKt.tx("Без категории", new Object[0]) : name;
    }

    public final double wholeStockUnits() {
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        for (Product product : this._products.getValue()) {
            d += Units.INSTANCE.stockUnits(product.getUnit(), product.getQuantity());
        }
        return d;
    }

    public final void setOnline(boolean value) {
        this._online.setValue(Boolean.valueOf(value));
    }

    public final void setSupportUnread(int value) {
        this._supportUnread.setValue(Integer.valueOf(value));
    }

    public final void setOrdersNew(int value) {
        this._ordersNew.setValue(Integer.valueOf(value));
    }
}
