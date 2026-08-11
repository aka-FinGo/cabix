package uz.FonRo.pos.ui.money;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.DebtsResponse;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DebtsScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.money.DebtsScreenKt$DebtsScreen$1$1", f = "DebtsScreen.kt", i = {0, 1, 1}, l = {118, 125}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "$this$LaunchedEffect", "$this$invokeSuspend_u24lambda_u240"}, nl = {119, 125}, s = {"L$0", "L$0", "L$1"}, v = 2)
/* loaded from: classes7.dex */
public final class DebtsScreenKt$DebtsScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<DebtsResponse> $data$delegate;
    final /* synthetic */ MutableState<String> $error$delegate;
    final /* synthetic */ Repo $repo;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebtsScreenKt$DebtsScreen$1$1(MutableState<DebtsResponse> mutableState, MutableState<String> mutableState2, Repo repo, Continuation<? super DebtsScreenKt$DebtsScreen$1$1> continuation) {
        super(2, continuation);
        this.$data$delegate = mutableState;
        this.$error$delegate = mutableState2;
        this.$repo = repo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DebtsScreenKt$DebtsScreen$1$1 debtsScreenKt$DebtsScreen$1$1 = new DebtsScreenKt$DebtsScreen$1$1(this.$data$delegate, this.$error$delegate, this.$repo, continuation);
        debtsScreenKt$DebtsScreen$1$1.L$0 = obj;
        return debtsScreenKt$DebtsScreen$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebtsScreenKt$DebtsScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0093, code lost:
    
        if (uz.FonRo.pos.data.repo.Repo.loadDirectory$default(r10, false, r9, 1, null) == r1) goto L25;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r9.label
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L31
            if (r2 == r5) goto L25
            if (r2 != r4) goto L1d
            java.lang.Object r9 = r9.L$1
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L9c
            goto L96
        L1d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L25:
            java.lang.Object r2 = r9.L$2
            uz.FonRo.pos.data.net.ApiClient r2 = (uz.FonRo.pos.data.net.ApiClient) r2
            java.lang.Object r7 = r9.L$1
            androidx.compose.runtime.MutableState r7 = (androidx.compose.runtime.MutableState) r7
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L66
            goto L5a
        L31:
            kotlin.ResultKt.throwOnFailure(r10)
            androidx.compose.runtime.MutableState<uz.FonRo.pos.data.model.DebtsResponse> r10 = r9.$data$delegate
            uz.FonRo.pos.ui.money.DebtsScreenKt.access$DebtsScreen$lambda$4(r10, r6)
            androidx.compose.runtime.MutableState<java.lang.String> r10 = r9.$error$delegate
            uz.FonRo.pos.ui.money.DebtsScreenKt.access$DebtsScreen$lambda$7(r10, r6)
            androidx.compose.runtime.MutableState<uz.FonRo.pos.data.model.DebtsResponse> r7 = r9.$data$delegate     // Catch: java.lang.Throwable -> L66
            uz.FonRo.pos.data.net.ApiClient r2 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L66
            uz.FonRo.pos.data.net.ApiClient r10 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L66
            uz.FonRo.pos.data.net.ApiService r10 = r10.api()     // Catch: java.lang.Throwable -> L66
            r8 = r9
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch: java.lang.Throwable -> L66
            r9.L$0 = r0     // Catch: java.lang.Throwable -> L66
            r9.L$1 = r7     // Catch: java.lang.Throwable -> L66
            r9.L$2 = r2     // Catch: java.lang.Throwable -> L66
            r9.label = r5     // Catch: java.lang.Throwable -> L66
            java.lang.Object r10 = r10.debts(r8)     // Catch: java.lang.Throwable -> L66
            if (r10 != r1) goto L5a
            goto L95
        L5a:
            retrofit2.Response r10 = (retrofit2.Response) r10     // Catch: java.lang.Throwable -> L66
            java.lang.Object r10 = uz.FonRo.pos.data.net.ApiClient.unwrap$default(r2, r10, r3, r4, r6)     // Catch: java.lang.Throwable -> L66
            uz.FonRo.pos.data.model.DebtsResponse r10 = (uz.FonRo.pos.data.model.DebtsResponse) r10     // Catch: java.lang.Throwable -> L66
            uz.FonRo.pos.ui.money.DebtsScreenKt.access$DebtsScreen$lambda$4(r7, r10)     // Catch: java.lang.Throwable -> L66
            goto L7b
        L66:
            r10 = move-exception
            androidx.compose.runtime.MutableState<java.lang.String> r2 = r9.$error$delegate
            uz.FonRo.pos.data.net.ApiClient r7 = uz.FonRo.pos.data.net.ApiClient.INSTANCE
            uz.FonRo.pos.data.net.ApiException r7 = r7.asApiError(r10)
            java.lang.String r7 = r7.getMessage()
            uz.FonRo.pos.ui.money.DebtsScreenKt.access$DebtsScreen$lambda$7(r2, r7)
            uz.FonRo.pos.ui.Toaster r2 = uz.FonRo.pos.ui.Toaster.INSTANCE
            r2.error(r10)
        L7b:
            uz.FonRo.pos.data.repo.Repo r10 = r9.$repo
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Throwable -> L9c
            r9.L$0 = r2     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Throwable -> L9c
            r9.L$1 = r0     // Catch: java.lang.Throwable -> L9c
            r9.L$2 = r6     // Catch: java.lang.Throwable -> L9c
            r9.label = r4     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r9 = uz.FonRo.pos.data.repo.Repo.loadDirectory$default(r10, r3, r9, r5, r6)     // Catch: java.lang.Throwable -> L9c
            if (r9 != r1) goto L96
        L95:
            return r1
        L96:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L9c
            kotlin.Result.m7870constructorimpl(r9)     // Catch: java.lang.Throwable -> L9c
            goto La6
        L9c:
            r9 = move-exception
            kotlin.Result$Companion r10 = kotlin.Result.INSTANCE
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            kotlin.Result.m7870constructorimpl(r9)
        La6:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.money.DebtsScreenKt$DebtsScreen$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
