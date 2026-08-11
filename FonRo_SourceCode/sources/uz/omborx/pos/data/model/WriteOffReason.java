package uz.FonRo.pos.data.model;

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

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R#\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e0\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0014"}, d2 = {"Luz/FonRo/pos/data/model/WriteOffReason;", "", "<init>", "()V", "SPOILED", "", "EXPIRED", "BROKEN", "DEFECT", "OWN_USE", "SHORTAGE", "OTHER", "ALL", "", "Lkotlin/Pair;", "getALL", "()Ljava/util/List;", "RAW_ALL", "title", "code", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class WriteOffReason {
    public static final int $stable = 0;
    public static final WriteOffReason INSTANCE = new WriteOffReason();
    public static final String SPOILED = "spoiled";
    public static final String EXPIRED = "expired";
    public static final String BROKEN = "broken";
    public static final String DEFECT = "defect";
    public static final String OWN_USE = "own_use";
    public static final String SHORTAGE = "shortage";
    public static final String OTHER = "other";
    private static final List<Pair<String, String>> RAW_ALL = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(SPOILED, "Порча"), TuplesKt.to(EXPIRED, "Просрочка"), TuplesKt.to(BROKEN, "Бой"), TuplesKt.to(DEFECT, "Брак"), TuplesKt.to(OWN_USE, "Для себя"), TuplesKt.to(SHORTAGE, "Недостача"), TuplesKt.to(OTHER, "Другое")});

    private WriteOffReason() {
    }

    public final List<Pair<String, String>> getALL() {
        List<Pair<String, String>> list = RAW_ALL;
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
        Iterator<T> it = RAW_ALL.iterator();
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
        return (pair == null || (str = (String) pair.getSecond()) == null || (tx = LangKt.tx(str, new Object[0])) == null) ? LangKt.tx("Другое", new Object[0]) : tx;
    }
}
