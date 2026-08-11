package uz.FonRo.pos.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Perm.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR5\u0010 \u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\"0!0\"0!8F¢\u0006\u0006\u001a\u0004\b#\u0010$R2\u0010%\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\"0!0\"0!X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b)\u0012\b\b*\u0012\u0004\b\u0003\u0010\u0002¨\u0006("}, d2 = {"Luz/FonRo/pos/core/Perm;", "", "<init>", "()V", "SELL", "", "SELL_DEBT", "ONLINE_SHOP", "MANAGE_RETURNS", "ADD_PRODUCT", "EDIT_PRODUCT", "DELETE_PRODUCT", "MANAGE_CATEGORIES", "STOCK_IN", "INVENTORY", "VIEW_PURCHASE_PRICE", "MANAGE_CUSTOMERS", "MANAGE_EXPENSES", "VIEW_HISTORY", "VIEW_PROFIT", "VIEW_STATISTICS", "VIEW_CASH_SALES", "VIEW_CARD_SALES", "MANAGE_SETTINGS", "MANAGE_USERS", "HIDDEN_DEFAULTS", "", "", "getHIDDEN_DEFAULTS", "()Ljava/util/Map;", "NEW_WORKER_DEFAULTS", "getNEW_WORKER_DEFAULTS", "GROUPS", "", "Lkotlin/Pair;", "getGROUPS", "()Ljava/util/List;", "RAW_GROUPS", "roleName", "role", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class Perm {
    public static final int $stable = 0;
    public static final Perm INSTANCE = new Perm();
    public static final String SELL = "can_sell";
    public static final String MANAGE_USERS = "can_manage_users";
    private static final Map<String, Integer> HIDDEN_DEFAULTS = MapsKt.mapOf(TuplesKt.to(SELL, 1), TuplesKt.to("can_manage_products", 0), TuplesKt.to("can_manage_sales", 0), TuplesKt.to(MANAGE_USERS, 0));
    public static final String SELL_DEBT = "can_sell_debt";
    public static final String MANAGE_CUSTOMERS = "can_manage_customers";
    public static final String ONLINE_SHOP = "can_online_shop";
    private static final Map<String, Integer> NEW_WORKER_DEFAULTS = MapsKt.mapOf(TuplesKt.to(SELL_DEBT, 1), TuplesKt.to(MANAGE_CUSTOMERS, 1), TuplesKt.to(ONLINE_SHOP, 1));
    public static final String MANAGE_RETURNS = "can_manage_returns";
    public static final String ADD_PRODUCT = "can_add_product";
    public static final String EDIT_PRODUCT = "can_edit_product";
    public static final String DELETE_PRODUCT = "can_delete_product";
    public static final String MANAGE_CATEGORIES = "can_manage_categories";
    public static final String STOCK_IN = "can_stock_in";
    public static final String INVENTORY = "can_inventory";
    public static final String VIEW_PURCHASE_PRICE = "can_view_purchase_price";
    public static final String MANAGE_EXPENSES = "can_manage_expenses";
    public static final String VIEW_HISTORY = "can_view_history";
    public static final String VIEW_PROFIT = "can_view_profit";
    public static final String VIEW_STATISTICS = "can_view_statistics";
    public static final String VIEW_CASH_SALES = "can_view_cash_sales";
    public static final String VIEW_CARD_SALES = "can_view_card_sales";
    public static final String MANAGE_SETTINGS = "can_manage_settings";
    private static final List<Pair<String, List<Pair<String, String>>>> RAW_GROUPS = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("Касса", CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(SELL_DEBT, "Продажа в долг"), TuplesKt.to(ONLINE_SHOP, "Заказы онлайн-витрины"), TuplesKt.to(MANAGE_RETURNS, "Приём возвратов")})), TuplesKt.to("Склад", CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(ADD_PRODUCT, "Создание товаров"), TuplesKt.to(EDIT_PRODUCT, "Изменение товаров и цен"), TuplesKt.to(DELETE_PRODUCT, "Архивирование товаров"), TuplesKt.to(MANAGE_CATEGORIES, "Категории"), TuplesKt.to(STOCK_IN, "Приход"), TuplesKt.to(INVENTORY, "Аудит"), TuplesKt.to(VIEW_PURCHASE_PRICE, "Видит закупочные цены")})), TuplesKt.to("Прочее", CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(MANAGE_CUSTOMERS, "Клиенты"), TuplesKt.to(MANAGE_EXPENSES, "Расходы"), TuplesKt.to(VIEW_HISTORY, "История продаж"), TuplesKt.to(VIEW_PROFIT, "Видит прибыль"), TuplesKt.to(VIEW_STATISTICS, "Статистика"), TuplesKt.to(VIEW_CASH_SALES, "Видит наличные продажи"), TuplesKt.to(VIEW_CARD_SALES, "Видит продажи по карте"), TuplesKt.to(MANAGE_SETTINGS, "Настройки магазина")}))});

    private Perm() {
    }

    public final Map<String, Integer> getHIDDEN_DEFAULTS() {
        return HIDDEN_DEFAULTS;
    }

    public final Map<String, Integer> getNEW_WORKER_DEFAULTS() {
        return NEW_WORKER_DEFAULTS;
    }

    public final List<Pair<String, List<Pair<String, String>>>> getGROUPS() {
        List<Pair<String, List<Pair<String, String>>>> list = RAW_GROUPS;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            String str = (String) pair.component1();
            List list2 = (List) pair.component2();
            String tx = LangKt.tx(str, new Object[0]);
            List<Pair> list3 = list2;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (Pair pair2 : list3) {
                arrayList2.add(TuplesKt.to(pair2.getFirst(), LangKt.tx((String) pair2.getSecond(), new Object[0])));
            }
            arrayList.add(TuplesKt.to(tx, arrayList2));
        }
        return arrayList;
    }

    public final String roleName(String role) {
        String str;
        if (role != null) {
            str = role.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
        } else {
            str = null;
        }
        if (str != null) {
            switch (str.hashCode()) {
                case 92668751:
                    if (str.equals("admin")) {
                        return LangKt.tx("админ", new Object[0]);
                    }
                    break;
                case 106164915:
                    if (str.equals("owner")) {
                        return LangKt.tx("владелец", new Object[0]);
                    }
                    break;
                case 554986179:
                    if (str.equals("cashier")) {
                        return LangKt.tx("кассир", new Object[0]);
                    }
                    break;
                case 835260333:
                    if (str.equals("manager")) {
                        return LangKt.tx("менеджер", new Object[0]);
                    }
                    break;
            }
        }
        return role == null ? "" : role;
    }
}
