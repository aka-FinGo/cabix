package uz.FonRo.pos.ui.home;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import j$.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.nav.Routes;
import uz.FonRo.pos.ui.theme.Ox;

/* compiled from: NotifySheet.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0016\u0010\u0014\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005H\u0002Ê\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Luz/FonRo/pos/ui/home/NotifyCenter;", "", "<init>", "()V", FirebaseAnalytics.Param.ITEMS, "", "Luz/FonRo/pos/ui/home/NotifyItem;", "repo", "Luz/FonRo/pos/data/repo/Repo;", "ordersNew", "", "debtTotal", "", "(Luz/FonRo/pos/data/repo/Repo;ILjava/lang/Double;)Ljava/util/List;", "hasOther", "", "day", "", "product", "Luz/FonRo/pos/data/model/Product;", "names", "list", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class NotifyCenter {
    public static final int $stable = 0;
    public static final NotifyCenter INSTANCE = new NotifyCenter();

    private NotifyCenter() {
    }

    public final List<NotifyItem> items(Repo repo, int ordersNew, Double debtTotal) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        ArrayList arrayList = new ArrayList();
        List<Product> value = repo.getProducts().getValue();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : value) {
            if (((Product) obj).isArchived() == 0) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        int lowStock = repo.getPrefs().getLowStock();
        if (repo.can(Perm.ONLINE_SHOP)) {
            ArrayList arrayList4 = arrayList;
            String tx = LangKt.tx("Новые заказы", new Object[0]);
            String tx2 = ordersNew > 0 ? LangKt.tx("Ждут обработки", new Object[0]) : LangKt.tx("Новых заказов нет", new Object[0]);
            Ox ox = Ox.INSTANCE;
            arrayList4.add(new NotifyItem("🛍", tx, tx2, ordersNew, "orders", ordersNew > 0 ? ox.m10196getDanger0d7_KjU() : ox.m10200getDim20d7_KjU(), null));
        }
        ArrayList arrayList5 = arrayList3;
        ArrayList arrayList6 = new ArrayList();
        for (Object obj2 : arrayList5) {
            if (((Product) obj2).getQuantity() <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                arrayList6.add(obj2);
            }
        }
        ArrayList arrayList7 = arrayList6;
        if (!arrayList7.isEmpty()) {
            arrayList.add(new NotifyItem("📦", LangKt.tx("Нет в наличии", new Object[0]), names(arrayList7), arrayList7.size(), Routes.CATALOG, Ox.INSTANCE.m10196getDanger0d7_KjU(), null));
        }
        ArrayList arrayList8 = new ArrayList();
        for (Object obj3 : arrayList5) {
            Product product = (Product) obj3;
            if (product.getQuantity() > AudioStats.AUDIO_AMPLITUDE_NONE && product.getQuantity() <= lowStock) {
                arrayList8.add(obj3);
            }
        }
        ArrayList arrayList9 = arrayList8;
        if (!arrayList9.isEmpty()) {
            arrayList.add(new NotifyItem("⚠️", LangKt.tx("Товар заканчивается", new Object[0]), LangKt.tx("Остаток ≤ %s · ", Integer.valueOf(lowStock)) + names(arrayList9), arrayList9.size(), Routes.CATALOG, Ox.INSTANCE.m10213getOrange0d7_KjU(), null));
        }
        String str = Fmt.INSTANCE.todayISO();
        String localDate = LocalDate.now(Fmt.INSTANCE.getSTORE_ZONE()).plusDays(7L).toString();
        Intrinsics.checkNotNullExpressionValue(localDate, "toString(...)");
        ArrayList arrayList10 = new ArrayList();
        for (Object obj4 : arrayList5) {
            Product product2 = (Product) obj4;
            String expirationDate = product2.getExpirationDate();
            if (expirationDate != null && !StringsKt.isBlank(expirationDate) && product2.getQuantity() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                arrayList10.add(obj4);
            }
        }
        ArrayList arrayList11 = arrayList10;
        ArrayList arrayList12 = new ArrayList();
        for (Object obj5 : arrayList11) {
            if (INSTANCE.day((Product) obj5).compareTo(str) < 0) {
                arrayList12.add(obj5);
            }
        }
        ArrayList arrayList13 = arrayList12;
        if (!arrayList13.isEmpty()) {
            arrayList.add(new NotifyItem("🚫", LangKt.tx("Срок годности вышел", new Object[0]), names(arrayList13), arrayList13.size(), Routes.CATALOG, Ox.INSTANCE.m10196getDanger0d7_KjU(), null));
        }
        ArrayList arrayList14 = new ArrayList();
        for (Object obj6 : arrayList11) {
            String day = INSTANCE.day((Product) obj6);
            if (day.compareTo(str) >= 0 && day.compareTo(localDate) <= 0) {
                arrayList14.add(obj6);
            }
        }
        ArrayList arrayList15 = arrayList14;
        if (!arrayList15.isEmpty()) {
            arrayList.add(new NotifyItem("⏳", LangKt.tx("Скоро истекает срок", new Object[0]), LangKt.tx("В ближайшие дни: %s · ", 7L) + names(arrayList15), arrayList15.size(), Routes.CATALOG, Ox.INSTANCE.m10213getOrange0d7_KjU(), null));
        }
        double doubleValue = debtTotal != null ? debtTotal.doubleValue() : 0.0d;
        if (repo.can(Perm.SELL_DEBT) && doubleValue > AudioStats.AUDIO_AMPLITUDE_NONE) {
            arrayList.add(new NotifyItem("📒", LangKt.tx("Непогашенные долги", new Object[0]), LangKt.tx("На сумму ", new Object[0]) + repo.money(Double.valueOf(doubleValue)), 0, Routes.DEBTS, Ox.INSTANCE.m10213getOrange0d7_KjU(), null));
        }
        return arrayList;
    }

    public final boolean hasOther(List<NotifyItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        List<NotifyItem> list = items;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (NotifyItem notifyItem : list) {
            if (!Intrinsics.areEqual(notifyItem.getRoute(), "orders") && (notifyItem.getCount() > 0 || Intrinsics.areEqual(notifyItem.getRoute(), Routes.DEBTS))) {
                return true;
            }
        }
        return false;
    }

    private final String day(Product product) {
        String expirationDate = product.getExpirationDate();
        if (expirationDate == null) {
            expirationDate = "";
        }
        return StringsKt.take(expirationDate, 10);
    }

    private final String names(List<Product> list) {
        return CollectionsKt.joinToString$default(CollectionsKt.take(list, 3), ", ", null, null, 0, null, new Function1() { // from class: uz.FonRo.pos.ui.home.NotifyCenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NotifyCenter.names$lambda$0((Product) obj);
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence names$lambda$0(Product it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getName();
    }
}
