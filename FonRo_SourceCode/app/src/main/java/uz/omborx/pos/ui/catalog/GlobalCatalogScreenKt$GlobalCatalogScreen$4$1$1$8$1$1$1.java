package uz.FonRo.pos.ui.catalog;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.GlobalCatalogCategory;
import uz.FonRo.pos.data.model.GlobalCatalogProduct;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GlobalCatalogScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$GlobalCatalogScreen$4$1$1$8$1$1$1", f = "GlobalCatalogScreen.kt", i = {}, l = {329}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class GlobalCatalogScreenKt$GlobalCatalogScreen$4$1$1$8$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<List<GlobalCatalogCategory>> $categories$delegate;
    final /* synthetic */ MutableState<Long> $categoryId$delegate;
    final /* synthetic */ MutableState<Boolean> $didLoad$delegate;
    final /* synthetic */ MutableState<String> $error$delegate;
    final /* synthetic */ MutableState<Set<Long>> $importedIds$delegate;
    final /* synthetic */ MutableState<List<GlobalCatalogProduct>> $items$delegate;
    final /* synthetic */ MutableState<String> $lang$delegate;
    final /* synthetic */ MutableState<Boolean> $loading$delegate;
    final /* synthetic */ MutableState<String> $search$delegate;
    final /* synthetic */ MutableState<Integer> $total$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalCatalogScreenKt$GlobalCatalogScreen$4$1$1$8$1$1$1(MutableState<Boolean> mutableState, MutableState<String> mutableState2, MutableState<List<GlobalCatalogProduct>> mutableState3, MutableState<Integer> mutableState4, MutableState<String> mutableState5, MutableState<Long> mutableState6, MutableState<String> mutableState7, MutableState<List<GlobalCatalogCategory>> mutableState8, MutableState<Set<Long>> mutableState9, MutableState<Boolean> mutableState10, Continuation<? super GlobalCatalogScreenKt$GlobalCatalogScreen$4$1$1$8$1$1$1> continuation) {
        super(2, continuation);
        this.$loading$delegate = mutableState;
        this.$error$delegate = mutableState2;
        this.$items$delegate = mutableState3;
        this.$total$delegate = mutableState4;
        this.$lang$delegate = mutableState5;
        this.$categoryId$delegate = mutableState6;
        this.$search$delegate = mutableState7;
        this.$categories$delegate = mutableState8;
        this.$importedIds$delegate = mutableState9;
        this.$didLoad$delegate = mutableState10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalCatalogScreenKt$GlobalCatalogScreen$4$1$1$8$1$1$1(this.$loading$delegate, this.$error$delegate, this.$items$delegate, this.$total$delegate, this.$lang$delegate, this.$categoryId$delegate, this.$search$delegate, this.$categories$delegate, this.$importedIds$delegate, this.$didLoad$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GlobalCatalogScreenKt$GlobalCatalogScreen$4$1$1$8$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object GlobalCatalogScreen$load;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            GlobalCatalogScreen$load = GlobalCatalogScreenKt.GlobalCatalogScreen$load(this.$loading$delegate, this.$error$delegate, this.$items$delegate, this.$total$delegate, this.$lang$delegate, this.$categoryId$delegate, this.$search$delegate, this.$categories$delegate, this.$importedIds$delegate, this.$didLoad$delegate, false, this);
            if (GlobalCatalogScreen$load == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
