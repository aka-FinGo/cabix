package uz.FonRo.pos.ui.catalog;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GlobalCatalogScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt", f = "GlobalCatalogScreen.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {135}, m = "GlobalCatalogScreen$load", n = {"loading$delegate", "error$delegate", "items$delegate", "total$delegate", "lang$delegate", "categoryId$delegate", "search$delegate", "categories$delegate", "importedIds$delegate", "didLoad$delegate", "reset"}, nl = {134}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0"}, v = 2)
/* loaded from: classes7.dex */
public final class GlobalCatalogScreenKt$GlobalCatalogScreen$load$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GlobalCatalogScreenKt$GlobalCatalogScreen$load$1(Continuation<? super GlobalCatalogScreenKt$GlobalCatalogScreen$load$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object GlobalCatalogScreen$load;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        GlobalCatalogScreen$load = GlobalCatalogScreenKt.GlobalCatalogScreen$load(null, null, null, null, null, null, null, null, null, null, false, this);
        return GlobalCatalogScreen$load;
    }
}
