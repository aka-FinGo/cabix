package uz.FonRo.pos.ui.more;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoreScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.more.MoreScreenKt$MoreScreen$14$1$1$1$1$1$1", f = "MoreScreen.kt", i = {}, l = {737, 741}, m = "invokeSuspend", n = {}, nl = {736, 742}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class MoreScreenKt$MoreScreen$14$1$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $code;
    final /* synthetic */ Repo $repo;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreScreenKt$MoreScreen$14$1$1$1$1$1$1(String str, Repo repo, Continuation<? super MoreScreenKt$MoreScreen$14$1$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$code = str;
        this.$repo = repo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MoreScreenKt$MoreScreen$14$1$1$1$1$1$1(this.$code, this.$repo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MoreScreenKt$MoreScreen$14$1$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
    
        if (r7.$repo.refreshSession(r7) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 0
            r3 = 1
            r4 = 2
            if (r1 == 0) goto L23
            if (r1 == r3) goto L1b
            if (r1 != r4) goto L13
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L67
            goto L59
        L13:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1b:
            java.lang.Object r1 = r7.L$0
            uz.FonRo.pos.data.net.ApiClient r1 = (uz.FonRo.pos.data.net.ApiClient) r1
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L67
            goto L43
        L23:
            kotlin.ResultKt.throwOnFailure(r8)
            uz.FonRo.pos.data.net.ApiClient r1 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L67
            uz.FonRo.pos.data.net.ApiClient r8 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L67
            uz.FonRo.pos.data.net.ApiService r8 = r8.api()     // Catch: java.lang.Throwable -> L67
            uz.FonRo.pos.data.model.CurrencyBody r5 = new uz.FonRo.pos.data.model.CurrencyBody     // Catch: java.lang.Throwable -> L67
            java.lang.String r6 = r7.$code     // Catch: java.lang.Throwable -> L67
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L67
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Throwable -> L67
            r7.L$0 = r1     // Catch: java.lang.Throwable -> L67
            r7.label = r3     // Catch: java.lang.Throwable -> L67
            java.lang.Object r8 = r8.updatePosCurrency(r5, r6)     // Catch: java.lang.Throwable -> L67
            if (r8 != r0) goto L43
            goto L58
        L43:
            retrofit2.Response r8 = (retrofit2.Response) r8     // Catch: java.lang.Throwable -> L67
            r3 = 0
            uz.FonRo.pos.data.net.ApiClient.unwrapVoid$default(r1, r8, r2, r4, r3)     // Catch: java.lang.Throwable -> L67
            uz.FonRo.pos.data.repo.Repo r8 = r7.$repo     // Catch: java.lang.Throwable -> L67
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Throwable -> L67
            r7.L$0 = r3     // Catch: java.lang.Throwable -> L67
            r7.label = r4     // Catch: java.lang.Throwable -> L67
            java.lang.Object r7 = r8.refreshSession(r1)     // Catch: java.lang.Throwable -> L67
            if (r7 != r0) goto L59
        L58:
            return r0
        L59:
            uz.FonRo.pos.ui.Toaster r7 = uz.FonRo.pos.ui.Toaster.INSTANCE     // Catch: java.lang.Throwable -> L67
            java.lang.String r8 = "Валюта сохранена"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L67
            java.lang.String r8 = uz.FonRo.pos.core.LangKt.tx(r8, r0)     // Catch: java.lang.Throwable -> L67
            r7.ok(r8)     // Catch: java.lang.Throwable -> L67
            goto L6d
        L67:
            r7 = move-exception
            uz.FonRo.pos.ui.Toaster r8 = uz.FonRo.pos.ui.Toaster.INSTANCE
            r8.error(r7)
        L6d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.more.MoreScreenKt$MoreScreen$14$1$1$1$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
