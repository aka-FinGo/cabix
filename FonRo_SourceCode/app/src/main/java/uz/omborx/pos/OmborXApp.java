package uz.FonRo.pos;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.Lang;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.repo.AuthRepository;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.data.repo.SaleRepository;
import uz.FonRo.pos.work.BackgroundWork;

/* compiled from: FonRoApp.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0002R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010Ê\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0015"}, d2 = {"Luz/FonRo/pos/FonRoApp;", "Landroid/app/Application;", "<init>", "()V", "value", "Luz/FonRo/pos/data/repo/Repo;", "repo", "getRepo", "()Luz/FonRo/pos/data/repo/Repo;", "Luz/FonRo/pos/data/repo/AuthRepository;", "auth", "getAuth", "()Luz/FonRo/pos/data/repo/AuthRepository;", "Luz/FonRo/pos/data/repo/SaleRepository;", "sales", "getSales", "()Luz/FonRo/pos/data/repo/SaleRepository;", "onCreate", "", "createNotificationChannels", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class FonRoApp extends Application {
    public static final String CHANNEL_ORDERS = "orders";
    public static final String CHANNEL_SUPPORT = "support";
    public static final String CHANNEL_SYNC = "sync";
    private static FonRoApp instance;
    private AuthRepository auth;
    private Repo repo;
    private SaleRepository sales;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public final Repo getRepo() {
        Repo repo = this.repo;
        if (repo != null) {
            return repo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("repo");
        return null;
    }

    public final AuthRepository getAuth() {
        AuthRepository authRepository = this.auth;
        if (authRepository != null) {
            return authRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("auth");
        return null;
    }

    public final SaleRepository getSales() {
        SaleRepository saleRepository = this.sales;
        if (saleRepository != null) {
            return saleRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sales");
        return null;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        instance = this;
        FonRoApp FonRoApp = this;
        this.repo = new Repo(FonRoApp);
        Lang.INSTANCE.load(FonRoApp, getRepo().getPrefs());
        ApiClient.INSTANCE.init(FonRoApp, getRepo().getPrefs());
        this.auth = new AuthRepository(getRepo());
        this.sales = new SaleRepository(getRepo());
        ApiClient.INSTANCE.setOnUnauthorized(new Function0() { // from class: uz.FonRo.pos.FonRoApp$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FonRoApp.onCreate$lambda$0(FonRoApp.this);
            }
        });
        getRepo().restoreFromCache();
        createNotificationChannels();
        if (getRepo().isLoggedIn()) {
            BackgroundWork.INSTANCE.scheduleOutboxFlush(FonRoApp);
            BackgroundWork.INSTANCE.schedulePolling(FonRoApp);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$0(FonRoApp FonRoApp) {
        FonRoApp.getRepo().clearLocal();
        return Unit.INSTANCE;
    }

    private final void createNotificationChannels() {
        NotificationManager notificationManager;
        if (Build.VERSION.SDK_INT >= 26 && (notificationManager = (NotificationManager) getSystemService(NotificationManager.class)) != null) {
            FonRoApp$$ExternalSyntheticApiModelOutline0.m();
            NotificationChannel m = FonRoApp$$ExternalSyntheticApiModelOutline0.m("orders", getString(R.string.notif_channel_orders), 4);
            FonRoApp$$ExternalSyntheticApiModelOutline0.m(m, LangKt.tx("Новые заказы с онлайн-витрины", new Object[0]));
            FonRoApp$$ExternalSyntheticApiModelOutline0.m(notificationManager, m);
            FonRoApp$$ExternalSyntheticApiModelOutline0.m();
            NotificationChannel m2 = FonRoApp$$ExternalSyntheticApiModelOutline0.m("support", getString(R.string.notif_channel_support), 3);
            FonRoApp$$ExternalSyntheticApiModelOutline0.m(m2, LangKt.tx("Ответы службы поддержки", new Object[0]));
            FonRoApp$$ExternalSyntheticApiModelOutline0.m(notificationManager, m2);
            FonRoApp$$ExternalSyntheticApiModelOutline0.m();
            NotificationChannel m3 = FonRoApp$$ExternalSyntheticApiModelOutline0.m("sync", getString(R.string.notif_channel_sync), 2);
            FonRoApp$$ExternalSyntheticApiModelOutline0.m(m3, LangKt.tx("Отправка отложенных чеков", new Object[0]));
            FonRoApp$$ExternalSyntheticApiModelOutline0.m(notificationManager, m3);
        }
    }

    /* compiled from: FonRoApp.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Luz/FonRo/pos/FonRoApp$Companion;", "", "<init>", "()V", "CHANNEL_ORDERS", "", "CHANNEL_SUPPORT", "CHANNEL_SYNC", "value", "Luz/FonRo/pos/FonRoApp;", "instance", "getInstance", "()Luz/FonRo/pos/FonRoApp;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FonRoApp getInstance() {
            FonRoApp FonRoApp = FonRoApp.instance;
            if (FonRoApp != null) {
                return FonRoApp;
            }
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            return null;
        }
    }
}
