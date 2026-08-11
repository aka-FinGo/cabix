package uz.FonRo.pos.data.repo;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SaleRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.data.repo.SaleRepository$flushOutbox$2", f = "SaleRepository.kt", i = {0, 0}, l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m = "invokeSuspend", n = {"pending", "sent"}, nl = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY}, s = {"L$1", "I$0"}, v = 2)
/* loaded from: classes5.dex */
public final class SaleRepository$flushOutbox$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ SaleRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleRepository$flushOutbox$2(SaleRepository saleRepository, Continuation<? super SaleRepository$flushOutbox$2> continuation) {
        super(2, continuation);
        this.this$0 = saleRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SaleRepository$flushOutbox$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((SaleRepository$flushOutbox$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0070 -> B:7:0x0073). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L29
            if (r1 != r3) goto L21
            int r1 = r9.I$0
            java.lang.Object r4 = r9.L$2
            uz.FonRo.pos.data.net.ApiClient r4 = (uz.FonRo.pos.data.net.ApiClient) r4
            java.lang.Object r5 = r9.L$1
            uz.FonRo.pos.data.local.SaleOutbox$Pending r5 = (uz.FonRo.pos.data.local.SaleOutbox.Pending) r5
            java.lang.Object r6 = r9.L$0
            java.util.Iterator r6 = (java.util.Iterator) r6
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L1e
            goto L73
        L1e:
            r10 = move-exception
            goto La2
        L21:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L29:
            kotlin.ResultKt.throwOnFailure(r10)
            uz.FonRo.pos.data.repo.SaleRepository r10 = r9.this$0
            uz.FonRo.pos.data.repo.Repo r10 = uz.FonRo.pos.data.repo.SaleRepository.access$getRepo$p(r10)
            uz.FonRo.pos.data.local.SaleOutbox r10 = r10.getOutbox()
            kotlinx.coroutines.flow.StateFlow r10 = r10.getQueue()
            java.lang.Object r10 = r10.getValue()
            java.util.List r10 = (java.util.List) r10
            java.util.Iterator r10 = r10.iterator()
            r6 = r10
            r1 = r2
        L46:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto Lee
            java.lang.Object r10 = r6.next()
            r5 = r10
            uz.FonRo.pos.data.local.SaleOutbox$Pending r5 = (uz.FonRo.pos.data.local.SaleOutbox.Pending) r5
            uz.FonRo.pos.data.net.ApiClient r4 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L1e
            uz.FonRo.pos.data.repo.SaleRepository r10 = r9.this$0     // Catch: java.lang.Throwable -> L1e
            uz.FonRo.pos.data.net.ApiService r10 = uz.FonRo.pos.data.repo.SaleRepository.access$getApi(r10)     // Catch: java.lang.Throwable -> L1e
            uz.FonRo.pos.data.model.SaleBody r7 = r5.getBody()     // Catch: java.lang.Throwable -> L1e
            r8 = r9
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch: java.lang.Throwable -> L1e
            r9.L$0 = r6     // Catch: java.lang.Throwable -> L1e
            r9.L$1 = r5     // Catch: java.lang.Throwable -> L1e
            r9.L$2 = r4     // Catch: java.lang.Throwable -> L1e
            r9.I$0 = r1     // Catch: java.lang.Throwable -> L1e
            r9.label = r3     // Catch: java.lang.Throwable -> L1e
            java.lang.Object r10 = r10.saleComplete(r7, r8)     // Catch: java.lang.Throwable -> L1e
            if (r10 != r0) goto L73
            return r0
        L73:
            retrofit2.Response r10 = (retrofit2.Response) r10     // Catch: java.lang.Throwable -> L1e
            r7 = 2
            r8 = 0
            java.lang.Object r10 = uz.FonRo.pos.data.net.ApiClient.unwrap$default(r4, r10, r2, r7, r8)     // Catch: java.lang.Throwable -> L1e
            uz.FonRo.pos.data.model.SaleResult r10 = (uz.FonRo.pos.data.model.SaleResult) r10     // Catch: java.lang.Throwable -> L1e
            uz.FonRo.pos.data.repo.SaleRepository r4 = r9.this$0     // Catch: java.lang.Throwable -> L1e
            uz.FonRo.pos.data.repo.Repo r4 = uz.FonRo.pos.data.repo.SaleRepository.access$getRepo$p(r4)     // Catch: java.lang.Throwable -> L1e
            uz.FonRo.pos.data.local.SaleOutbox r4 = r4.getOutbox()     // Catch: java.lang.Throwable -> L1e
            uz.FonRo.pos.data.model.SaleBody r7 = r5.getBody()     // Catch: java.lang.Throwable -> L1e
            java.lang.String r7 = r7.getTransactionId()     // Catch: java.lang.Throwable -> L1e
            r4.remove(r7)     // Catch: java.lang.Throwable -> L1e
            uz.FonRo.pos.data.repo.SaleRepository r4 = r9.this$0     // Catch: java.lang.Throwable -> L1e
            uz.FonRo.pos.data.repo.Repo r4 = uz.FonRo.pos.data.repo.SaleRepository.access$getRepo$p(r4)     // Catch: java.lang.Throwable -> L1e
            uz.FonRo.pos.data.model.Paywall r10 = r10.getPaywall()     // Catch: java.lang.Throwable -> L1e
            r4.updatePaywall(r10)     // Catch: java.lang.Throwable -> L1e
            int r1 = r1 + 1
            goto L46
        La2:
            uz.FonRo.pos.data.net.ApiClient r4 = uz.FonRo.pos.data.net.ApiClient.INSTANCE
            uz.FonRo.pos.data.net.ApiException r10 = r4.asApiError(r10)
            boolean r4 = r10.getOffline()
            uz.FonRo.pos.data.repo.SaleRepository r7 = r9.this$0
            if (r4 == 0) goto Lb8
            uz.FonRo.pos.data.repo.Repo r10 = uz.FonRo.pos.data.repo.SaleRepository.access$getRepo$p(r7)
            r10.setOnline(r2)
            goto Lee
        Lb8:
            uz.FonRo.pos.data.repo.Repo r4 = uz.FonRo.pos.data.repo.SaleRepository.access$getRepo$p(r7)
            uz.FonRo.pos.data.local.SaleOutbox r4 = r4.getOutbox()
            uz.FonRo.pos.data.model.SaleBody r7 = r5.getBody()
            java.lang.String r7 = r7.getTransactionId()
            java.lang.String r10 = r10.getMessage()
            r4.markAttempt(r7, r10)
            int r10 = r5.getAttempts()
            int r10 = r10 + r3
            r4 = 5
            if (r10 < r4) goto L46
            uz.FonRo.pos.data.repo.SaleRepository r10 = r9.this$0
            uz.FonRo.pos.data.repo.Repo r10 = uz.FonRo.pos.data.repo.SaleRepository.access$getRepo$p(r10)
            uz.FonRo.pos.data.local.SaleOutbox r10 = r10.getOutbox()
            uz.FonRo.pos.data.model.SaleBody r4 = r5.getBody()
            java.lang.String r4 = r4.getTransactionId()
            r10.remove(r4)
            goto L46
        Lee:
            if (r1 <= 0) goto Lf9
            uz.FonRo.pos.data.repo.SaleRepository r9 = r9.this$0
            uz.FonRo.pos.data.repo.Repo r9 = uz.FonRo.pos.data.repo.SaleRepository.access$getRepo$p(r9)
            r9.invalidate()
        Lf9:
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.data.repo.SaleRepository$flushOutbox$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
