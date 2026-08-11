package uz.FonRo.pos.print;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LabelSheet.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012Ê\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Luz/FonRo/pos/print/LabelLayouts;", "", "<init>", "()V", "A4_W", "", "A4_H", "a4", "", "Luz/FonRo/pos/print/LabelLayout;", "getA4", "()Ljava/util/List;", "rolls", "getRolls", "all", "getAll", "default", "getDefault", "()Luz/FonRo/pos/print/LabelLayout;", "byKey", "key", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class LabelLayouts {
    public static final int $stable = 0;
    public static final float A4_H = 297.0f;
    public static final float A4_W = 210.0f;
    public static final LabelLayouts INSTANCE = new LabelLayouts();
    private static final List<LabelLayout> a4;
    private static final List<LabelLayout> all;
    private static final List<LabelLayout> rolls;

    private LabelLayouts() {
    }

    public final List<LabelLayout> getA4() {
        return a4;
    }

    static {
        List<LabelLayout> listOf = CollectionsKt.listOf((Object[]) new LabelLayout[]{new LabelLayout("a4-65", "A4 · 65 шт", "38 × 21,2 мм", SheetKind.A4, 38.0f, 21.2f, 5, 13, 10.7f, 4.7f, 2.5f, 0.0f), new LabelLayout("a4-40", "A4 · 40 шт", "48,5 × 25,4 мм", SheetKind.A4, 48.5f, 25.4f, 4, 10, 21.5f, 8.0f, 0.0f, 0.0f), new LabelLayout("a4-24", "A4 · 24 шт", "64 × 33,9 мм", SheetKind.A4, 64.0f, 33.9f, 3, 8, 12.9f, 7.0f, 2.5f, 0.0f), new LabelLayout("a4-21", "A4 · 21 шт", "70 × 42,3 мм", SheetKind.A4, 70.0f, 42.3f, 3, 7, 0.0f, 0.0f, 0.0f, 0.0f), new LabelLayout("a4-14", "A4 · 14 шт", "105 × 42,3 мм", SheetKind.A4, 105.0f, 42.3f, 2, 7, 0.0f, 0.0f, 0.0f, 0.0f), new LabelLayout("a4-8", "A4 · 8 шт", "105 × 74 мм", SheetKind.A4, 105.0f, 74.0f, 2, 4, 0.0f, 0.0f, 0.0f, 0.0f)});
        a4 = listOf;
        List<LabelLayout> listOf2 = CollectionsKt.listOf((Object[]) new LabelLayout[]{new LabelLayout("r58x40", "58 × 40 мм", "Этикеточный принтер", SheetKind.ROLL, 58.0f, 40.0f, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 4032, null), new LabelLayout("r58x30", "58 × 30 мм", "Этикеточный принтер", SheetKind.ROLL, 58.0f, 30.0f, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 4032, null), new LabelLayout("r50x30", "50 × 30 мм", "Этикеточный принтер", SheetKind.ROLL, 50.0f, 30.0f, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 4032, null), new LabelLayout("r40x30", "40 × 30 мм", "Мелкий товар", SheetKind.ROLL, 40.0f, 30.0f, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 4032, null), new LabelLayout("r40x25", "40 × 25 мм", "Мелкий товар", SheetKind.ROLL, 40.0f, 25.0f, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 4032, null), new LabelLayout("r30x20", "30 × 20 мм", "Самая мелкая", SheetKind.ROLL, 30.0f, 20.0f, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 4032, null)});
        rolls = listOf2;
        all = CollectionsKt.plus((Collection) listOf, (Iterable) listOf2);
    }

    public final List<LabelLayout> getRolls() {
        return rolls;
    }

    public final List<LabelLayout> getAll() {
        return all;
    }

    public final LabelLayout getDefault() {
        return (LabelLayout) CollectionsKt.first((List) a4);
    }

    public final LabelLayout byKey(String key) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Iterator<T> it = all.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((LabelLayout) obj).getKey(), key)) {
                break;
            }
        }
        LabelLayout labelLayout = (LabelLayout) obj;
        return labelLayout == null ? getDefault() : labelLayout;
    }
}
