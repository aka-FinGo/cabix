package uz.FonRo.pos.ui.nav;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.TabItem;

/* compiled from: Routes.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020\u0005J\u000e\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 8F¢\u0006\u0006\u001a\u0004\b\"\u0010#Ê\u0001\f\b(\u0012\b\b)\u0012\u0004\b\u0003\u0010\u0002¨\u0006'"}, d2 = {"Luz/FonRo/pos/ui/nav/Routes;", "", "<init>", "()V", "HOME", "", "STOCK_IN", "CATALOG", "SALE", "STATS", "AUDIT", "STOCK_IN_NEW", "HISTORY", "LOG", "DEBTS", "EXPENSES", "ORDERS", "RETURNS", "WRITEOFF", "CLIENTS", "TEAM", "MY_DEVICES", "MENU", "SUPPLIERS", "SUPPLIER_RETURNS", "SUPPORT", "PRINT", "EXCEL", "CATSHOP", "OUTBOX", "PRINTER_SETUP", "TABS", "", "Luz/FonRo/pos/ui/components/TabItem;", "getTABS", "()Ljava/util/List;", "permissionOf", "route", "titleOf", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class Routes {
    public static final int $stable = 0;
    public static final String AUDIT = "audit";
    public static final String CATALOG = "catalog";
    public static final String CATSHOP = "catshop";
    public static final String CLIENTS = "clients";
    public static final String DEBTS = "debts";
    public static final String EXCEL = "excel";
    public static final String EXPENSES = "expenses";
    public static final String HISTORY = "history";
    public static final String HOME = "home";
    public static final Routes INSTANCE = new Routes();
    public static final String LOG = "log";
    public static final String MENU = "menu";
    public static final String MY_DEVICES = "mydevices";
    public static final String ORDERS = "orders";
    public static final String OUTBOX = "outbox";
    public static final String PRINT = "print";
    public static final String PRINTER_SETUP = "printer";
    public static final String RETURNS = "returns";
    public static final String SALE = "sale";
    public static final String STATS = "stats";
    public static final String STOCK_IN = "stockin";
    public static final String STOCK_IN_NEW = "stockin_new";
    public static final String SUPPLIERS = "suppliers";
    public static final String SUPPLIER_RETURNS = "supplier_returns";
    public static final String SUPPORT = "support";
    public static final String TEAM = "team";
    public static final String WRITEOFF = "writeoff";

    private Routes() {
    }

    public final List<TabItem> getTABS() {
        return CollectionsKt.listOf((Object[]) new TabItem[]{new TabItem(STOCK_IN, LangKt.tx("Приход", new Object[0]), OxIcons.INSTANCE.getInbox(), Perm.STOCK_IN), new TabItem(CATALOG, LangKt.tx("Товары", new Object[0]), OxIcons.INSTANCE.getBox(), null), new TabItem(SALE, LangKt.tx("Продажа", new Object[0]), OxIcons.INSTANCE.getCart(), Perm.SELL), new TabItem(STATS, LangKt.tx("Стат", new Object[0]), OxIcons.INSTANCE.getChart(), Perm.VIEW_STATISTICS), new TabItem(AUDIT, LangKt.tx("Аудит", new Object[0]), OxIcons.INSTANCE.getClipboard(), Perm.INVENTORY)});
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d4 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String permissionOf(java.lang.String r2) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.nav.Routes.permissionOf(java.lang.String):java.lang.String");
    }

    public final String titleOf(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        switch (route.hashCode()) {
            case -1935391973:
                return !route.equals(EXPENSES) ? "" : LangKt.tx("Расходы", new Object[0]);
            case -1884711237:
                return !route.equals(STOCK_IN) ? "" : LangKt.tx("Приход", new Object[0]);
            case -1854767153:
                return !route.equals("support") ? "" : LangKt.tx("Поддержка", new Object[0]);
            case -1846454992:
                return !route.equals(WRITEOFF) ? "" : LangKt.tx("Списание", new Object[0]);
            case -1752554063:
                return !route.equals(MY_DEVICES) ? "" : LangKt.tx("Мои устройства", new Object[0]);
            case -1008770331:
                return !route.equals("orders") ? "" : LangKt.tx("Заказы онлайн", new Object[0]);
            case -1005526083:
                return !route.equals(OUTBOX) ? "" : LangKt.tx("Отложенная отправка", new Object[0]);
            case -546924004:
                return !route.equals(STOCK_IN_NEW) ? "" : LangKt.tx("Новый приход", new Object[0]);
            case -314718182:
                return !route.equals(PRINTER_SETUP) ? "" : LangKt.tx("Принтер чеков", new Object[0]);
            case -22855641:
                return !route.equals(SUPPLIERS) ? "" : LangKt.tx("Поставщики", new Object[0]);
            case 107332:
                return !route.equals(LOG) ? "" : LangKt.tx("Журнал", new Object[0]);
            case 3347807:
                return !route.equals(MENU) ? "" : LangKt.tx("Ещё", new Object[0]);
            case 3522631:
                return !route.equals(SALE) ? "" : LangKt.tx("Продажа", new Object[0]);
            case 3555933:
                return !route.equals(TEAM) ? "" : LangKt.tx("Сотрудники", new Object[0]);
            case 93166555:
                return !route.equals(AUDIT) ? "" : LangKt.tx("Аудит", new Object[0]);
            case 95458880:
                return !route.equals(DEBTS) ? "" : LangKt.tx("Долги", new Object[0]);
            case 96948919:
                return !route.equals(EXCEL) ? "" : LangKt.tx("Товары из Excel", new Object[0]);
            case 106934957:
                return !route.equals(PRINT) ? "" : LangKt.tx("Печать штрихкодов", new Object[0]);
            case 109757599:
                return !route.equals(STATS) ? "" : LangKt.tx("Статистика", new Object[0]);
            case 375684560:
                return !route.equals(SUPPLIER_RETURNS) ? "" : LangKt.tx("Возврат поставщику", new Object[0]);
            case 555704345:
                return !route.equals(CATALOG) ? "" : LangKt.tx("Товары", new Object[0]);
            case 556236748:
                return !route.equals(CATSHOP) ? "" : LangKt.tx("Каталог FonRo", new Object[0]);
            case 860587528:
                return !route.equals(CLIENTS) ? "" : LangKt.tx("Клиенты", new Object[0]);
            case 926934164:
                return !route.equals(HISTORY) ? "" : LangKt.tx("Все чеки", new Object[0]);
            case 1098475843:
                return !route.equals(RETURNS) ? "" : LangKt.tx("Возвраты", new Object[0]);
            default:
                return "";
        }
    }
}
