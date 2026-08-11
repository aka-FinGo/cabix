package uz.FonRo.pos.ui;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppRoot.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.AppRootKt$AppRoot$1$1", f = "AppRoot.kt", i = {0, 0, 1, 1}, l = {49, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "$this$invokeSuspend_u24lambda_u240", "$this$LaunchedEffect", "$this$invokeSuspend_u24lambda_u241"}, nl = {49, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 2)
/* loaded from: classes7.dex */
public final class AppRootKt$AppRoot$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FonRoApp $app;
    final /* synthetic */ MutableState<Boolean> $booting$delegate;
    final /* synthetic */ Repo $repo;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppRootKt$AppRoot$1$1(Repo repo, MutableState<Boolean> mutableState, FonRoApp FonRoApp, Continuation<? super AppRootKt$AppRoot$1$1> continuation) {
        super(2, continuation);
        this.$repo = repo;
        this.$booting$delegate = mutableState;
        this.$app = FonRoApp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AppRootKt$AppRoot$1$1 appRootKt$AppRoot$1$1 = new AppRootKt$AppRoot$1$1(this.$repo, this.$booting$delegate, this.$app, continuation);
        appRootKt$AppRoot$1$1.L$0 = obj;
        return appRootKt$AppRoot$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppRootKt$AppRoot$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0089, code lost:
    
        if (r7 == r1) goto L30;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r6.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L2d
            if (r2 == r5) goto L23
            if (r2 != r3) goto L1b
            java.lang.Object r6 = r6.L$1
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L9a
            goto L8c
        L1b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L23:
            java.lang.Object r2 = r6.L$1
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L2b
            goto L55
        L2b:
            r7 = move-exception
            goto L5b
        L2d:
            kotlin.ResultKt.throwOnFailure(r7)
            uz.FonRo.pos.data.repo.Repo r7 = r6.$repo
            boolean r7 = r7.isLoggedIn()
            if (r7 != 0) goto L40
            androidx.compose.runtime.MutableState<java.lang.Boolean> r6 = r6.$booting$delegate
            uz.FonRo.pos.ui.AppRootKt.access$AppRoot$lambda$3(r6, r4)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L40:
            uz.FonRo.pos.data.repo.Repo r7 = r6.$repo
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2b
            r6.L$0 = r0     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Throwable -> L2b
            r6.L$1 = r2     // Catch: java.lang.Throwable -> L2b
            r6.label = r5     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r7 = r7.refreshSession(r6)     // Catch: java.lang.Throwable -> L2b
            if (r7 != r1) goto L55
            goto L8b
        L55:
            uz.FonRo.pos.data.model.Session r7 = (uz.FonRo.pos.data.model.Session) r7     // Catch: java.lang.Throwable -> L2b
            kotlin.Result.m7870constructorimpl(r7)     // Catch: java.lang.Throwable -> L2b
            goto L64
        L5b:
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            kotlin.Result.m7870constructorimpl(r7)
        L64:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r7 = r6.$booting$delegate
            uz.FonRo.pos.ui.AppRootKt.access$AppRoot$lambda$3(r7, r4)
            uz.FonRo.pos.data.repo.Repo r7 = r6.$repo
            r2 = 0
            uz.FonRo.pos.data.repo.Repo.refreshInBackground$default(r7, r4, r5, r2)
            uz.FonRo.pos.FonRoApp r7 = r6.$app
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L9a
            uz.FonRo.pos.data.repo.SaleRepository r7 = r7.getSales()     // Catch: java.lang.Throwable -> L9a
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Throwable -> L9a
            r6.L$0 = r2     // Catch: java.lang.Throwable -> L9a
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Throwable -> L9a
            r6.L$1 = r0     // Catch: java.lang.Throwable -> L9a
            r6.label = r3     // Catch: java.lang.Throwable -> L9a
            java.lang.Object r7 = r7.flushOutbox(r6)     // Catch: java.lang.Throwable -> L9a
            if (r7 != r1) goto L8c
        L8b:
            return r1
        L8c:
            java.lang.Number r7 = (java.lang.Number) r7     // Catch: java.lang.Throwable -> L9a
            int r6 = r7.intValue()     // Catch: java.lang.Throwable -> L9a
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)     // Catch: java.lang.Throwable -> L9a
            kotlin.Result.m7870constructorimpl(r6)     // Catch: java.lang.Throwable -> L9a
            goto La4
        L9a:
            r6 = move-exception
            kotlin.Result$Companion r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            kotlin.Result.m7870constructorimpl(r6)
        La4:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.AppRootKt$AppRoot$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
