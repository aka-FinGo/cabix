package uz.FonRo.pos.ui.docs;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.repo.Repo;

/* compiled from: SupplierReturnsScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$SupplierReturnsScreen$1$1", f = "SupplierReturnsScreen.kt", i = {0, 0, 1, 1}, l = {144, 145}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "$this$invokeSuspend_u24lambda_u240", "$this$LaunchedEffect", "$this$invokeSuspend_u24lambda_u241"}, nl = {144, 145}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 2)
/* loaded from: classes7.dex */
final class SupplierReturnsScreenKt$SupplierReturnsScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Repo $repo;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SupplierReturnsScreenKt$SupplierReturnsScreen$1$1(Repo repo, Continuation<? super SupplierReturnsScreenKt$SupplierReturnsScreen$1$1> continuation) {
        super(2, continuation);
        this.$repo = repo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SupplierReturnsScreenKt$SupplierReturnsScreen$1$1 supplierReturnsScreenKt$SupplierReturnsScreen$1$1 = new SupplierReturnsScreenKt$SupplierReturnsScreen$1$1(this.$repo, continuation);
        supplierReturnsScreenKt$SupplierReturnsScreen$1$1.L$0 = obj;
        return supplierReturnsScreenKt$SupplierReturnsScreen$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SupplierReturnsScreenKt$SupplierReturnsScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
    
        if (uz.FonRo.pos.data.repo.Repo.loadDirectory$default(r8, false, r7, 1, null) == r1) goto L25;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 0
            r4 = 0
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L2c
            if (r2 == r6) goto L24
            if (r2 != r5) goto L1c
            java.lang.Object r7 = r7.L$1
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L73
            goto L6d
        L1c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L24:
            java.lang.Object r2 = r7.L$1
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L4a
            goto L44
        L2c:
            kotlin.ResultKt.throwOnFailure(r8)
            uz.FonRo.pos.data.repo.Repo r8 = r7.$repo
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L4a
            r7.L$0 = r0     // Catch: java.lang.Throwable -> L4a
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Throwable -> L4a
            r7.L$1 = r2     // Catch: java.lang.Throwable -> L4a
            r7.label = r6     // Catch: java.lang.Throwable -> L4a
            java.lang.Object r8 = uz.FonRo.pos.data.repo.Repo.loadCatalog$default(r8, r4, r7, r6, r3)     // Catch: java.lang.Throwable -> L4a
            if (r8 != r1) goto L44
            goto L6c
        L44:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L4a
            kotlin.Result.m7870constructorimpl(r8)     // Catch: java.lang.Throwable -> L4a
            goto L54
        L4a:
            r8 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            kotlin.Result.m7870constructorimpl(r8)
        L54:
            uz.FonRo.pos.data.repo.Repo r8 = r7.$repo
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L73
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Throwable -> L73
            r7.L$0 = r2     // Catch: java.lang.Throwable -> L73
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Throwable -> L73
            r7.L$1 = r0     // Catch: java.lang.Throwable -> L73
            r7.label = r5     // Catch: java.lang.Throwable -> L73
            java.lang.Object r7 = uz.FonRo.pos.data.repo.Repo.loadDirectory$default(r8, r4, r7, r6, r3)     // Catch: java.lang.Throwable -> L73
            if (r7 != r1) goto L6d
        L6c:
            return r1
        L6d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L73
            kotlin.Result.m7870constructorimpl(r7)     // Catch: java.lang.Throwable -> L73
            goto L7d
        L73:
            r7 = move-exception
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            kotlin.Result.m7870constructorimpl(r7)
        L7d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$SupplierReturnsScreen$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
