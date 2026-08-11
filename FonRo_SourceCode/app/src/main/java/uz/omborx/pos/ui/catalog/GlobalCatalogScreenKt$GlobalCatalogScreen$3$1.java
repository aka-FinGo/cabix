package uz.FonRo.pos.ui.catalog;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.GlobalCatalogCategory;
import uz.FonRo.pos.data.model.GlobalCatalogProduct;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GlobalCatalogScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$GlobalCatalogScreen$3$1", f = "GlobalCatalogScreen.kt", i = {}, l = {156, 157}, m = "invokeSuspend", n = {}, nl = {157, 158}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class GlobalCatalogScreenKt$GlobalCatalogScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
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
    public GlobalCatalogScreenKt$GlobalCatalogScreen$3$1(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, MutableState<String> mutableState3, MutableState<List<GlobalCatalogProduct>> mutableState4, MutableState<Integer> mutableState5, MutableState<String> mutableState6, MutableState<Long> mutableState7, MutableState<String> mutableState8, MutableState<List<GlobalCatalogCategory>> mutableState9, MutableState<Set<Long>> mutableState10, Continuation<? super GlobalCatalogScreenKt$GlobalCatalogScreen$3$1> continuation) {
        super(2, continuation);
        this.$didLoad$delegate = mutableState;
        this.$loading$delegate = mutableState2;
        this.$error$delegate = mutableState3;
        this.$items$delegate = mutableState4;
        this.$total$delegate = mutableState5;
        this.$lang$delegate = mutableState6;
        this.$categoryId$delegate = mutableState7;
        this.$search$delegate = mutableState8;
        this.$categories$delegate = mutableState9;
        this.$importedIds$delegate = mutableState10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalCatalogScreenKt$GlobalCatalogScreen$3$1(this.$didLoad$delegate, this.$loading$delegate, this.$error$delegate, this.$items$delegate, this.$total$delegate, this.$lang$delegate, this.$categoryId$delegate, this.$search$delegate, this.$categories$delegate, this.$importedIds$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GlobalCatalogScreenKt$GlobalCatalogScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0057, code lost:
    
        if (r0 == r1) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0059, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(250, r16) == r1) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L20
            if (r2 == r4) goto L1c
            if (r2 != r3) goto L14
            kotlin.ResultKt.throwOnFailure(r17)
            goto L5a
        L14:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L1c:
            kotlin.ResultKt.throwOnFailure(r17)
            goto L39
        L20:
            kotlin.ResultKt.throwOnFailure(r17)
            androidx.compose.runtime.MutableState<java.lang.Boolean> r2 = r0.$didLoad$delegate
            boolean r2 = uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt.access$GlobalCatalogScreen$lambda$31(r2)
            if (r2 == 0) goto L39
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r0.label = r4
            r4 = 250(0xfa, double:1.235E-321)
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.delay(r4, r2)
            if (r2 != r1) goto L39
            goto L59
        L39:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r4 = r0.$loading$delegate
            androidx.compose.runtime.MutableState<java.lang.String> r5 = r0.$error$delegate
            androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.GlobalCatalogProduct>> r6 = r0.$items$delegate
            androidx.compose.runtime.MutableState<java.lang.Integer> r7 = r0.$total$delegate
            androidx.compose.runtime.MutableState<java.lang.String> r8 = r0.$lang$delegate
            androidx.compose.runtime.MutableState<java.lang.Long> r9 = r0.$categoryId$delegate
            androidx.compose.runtime.MutableState<java.lang.String> r10 = r0.$search$delegate
            androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.GlobalCatalogCategory>> r11 = r0.$categories$delegate
            androidx.compose.runtime.MutableState<java.util.Set<java.lang.Long>> r12 = r0.$importedIds$delegate
            androidx.compose.runtime.MutableState<java.lang.Boolean> r13 = r0.$didLoad$delegate
            r15 = r0
            kotlin.coroutines.Continuation r15 = (kotlin.coroutines.Continuation) r15
            r0.label = r3
            r14 = 1
            java.lang.Object r0 = uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt.access$GlobalCatalogScreen$load(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            if (r0 != r1) goto L5a
        L59:
            return r1
        L5a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$GlobalCatalogScreen$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
