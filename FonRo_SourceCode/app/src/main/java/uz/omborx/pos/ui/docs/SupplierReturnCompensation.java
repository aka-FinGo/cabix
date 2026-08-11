package uz.FonRo.pos.ui.docs;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.LangKt;

/* compiled from: SupplierReturnsScreen.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R#\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b0\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Luz/FonRo/pos/ui/docs/SupplierReturnCompensation;", "", "<init>", "()V", "REDUCE_DEBT", "", "CASH_REFUND", "SUPPLIER_CREDIT", "EXCHANGE", "ALL", "", "Lkotlin/Pair;", "getALL", "()Ljava/util/List;", "RAW", "title", "code", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class SupplierReturnCompensation {
    public static final int $stable = 0;
    public static final SupplierReturnCompensation INSTANCE = new SupplierReturnCompensation();
    public static final String REDUCE_DEBT = "reduce_debt";
    public static final String CASH_REFUND = "cash_refund";
    public static final String SUPPLIER_CREDIT = "supplier_credit";
    public static final String EXCHANGE = "exchange";
    private static final List<Pair<String, String>> RAW = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(REDUCE_DEBT, "Уменьшить долг"), TuplesKt.to(CASH_REFUND, "Поставщик вернул деньги"), TuplesKt.to(SUPPLIER_CREDIT, "Оставить как кредит"), TuplesKt.to(EXCHANGE, "Обмен товара")});

    private SupplierReturnCompensation() {
    }

    public final List<Pair<String, String>> getALL() {
        List<Pair<String, String>> list = RAW;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList.add(TuplesKt.to(pair.getFirst(), LangKt.tx((String) pair.getSecond(), new Object[0])));
        }
        return arrayList;
    }

    public final String title(String code) {
        Object obj;
        String str;
        String tx;
        Iterator<T> it = RAW.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Pair) obj).getFirst(), code)) {
                break;
            }
        }
        Pair pair = (Pair) obj;
        return (pair == null || (str = (String) pair.getSecond()) == null || (tx = LangKt.tx(str, new Object[0])) == null) ? LangKt.tx("Уменьшить долг", new Object[0]) : tx;
    }
}
