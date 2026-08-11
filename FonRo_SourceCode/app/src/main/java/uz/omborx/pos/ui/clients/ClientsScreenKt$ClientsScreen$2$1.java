package uz.FonRo.pos.ui.clients;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.DebtSale;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClientsScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.clients.ClientsScreenKt$ClientsScreen$2$1", f = "ClientsScreen.kt", i = {0, 0, 1, 1}, l = {127, 129}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "$this$invokeSuspend_u24lambda_u240", "$this$LaunchedEffect", "$this$invokeSuspend_u24lambda_u242"}, nl = {127, 129}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 2)
/* loaded from: classes7.dex */
public final class ClientsScreenKt$ClientsScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $canDebt;
    final /* synthetic */ MutableState<List<DebtSale>> $debtSales$delegate;
    final /* synthetic */ Repo $repo;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientsScreenKt$ClientsScreen$2$1(boolean z, Repo repo, MutableState<List<DebtSale>> mutableState, Continuation<? super ClientsScreenKt$ClientsScreen$2$1> continuation) {
        super(2, continuation);
        this.$canDebt = z;
        this.$repo = repo;
        this.$debtSales$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClientsScreenKt$ClientsScreen$2$1 clientsScreenKt$ClientsScreen$2$1 = new ClientsScreenKt$ClientsScreen$2$1(this.$canDebt, this.$repo, this.$debtSales$delegate, continuation);
        clientsScreenKt$ClientsScreen$2$1.L$0 = obj;
        return clientsScreenKt$ClientsScreen$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClientsScreenKt$ClientsScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r8.label
            r3 = 0
            r4 = 0
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L34
            if (r2 == r6) goto L2c
            if (r2 != r5) goto L24
            java.lang.Object r0 = r8.L$2
            uz.FonRo.pos.data.net.ApiClient r0 = (uz.FonRo.pos.data.net.ApiClient) r0
            java.lang.Object r1 = r8.L$1
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L21
            goto L91
        L21:
            r9 = move-exception
            goto L9e
        L24:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L2c:
            java.lang.Object r2 = r8.L$1
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L53
            goto L4c
        L34:
            kotlin.ResultKt.throwOnFailure(r9)
            uz.FonRo.pos.data.repo.Repo r9 = r8.$repo
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L53
            r8.L$0 = r0     // Catch: java.lang.Throwable -> L53
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Throwable -> L53
            r8.L$1 = r2     // Catch: java.lang.Throwable -> L53
            r8.label = r6     // Catch: java.lang.Throwable -> L53
            java.lang.Object r9 = uz.FonRo.pos.data.repo.Repo.loadDirectory$default(r9, r4, r8, r6, r3)     // Catch: java.lang.Throwable -> L53
            if (r9 != r1) goto L4c
            goto L8d
        L4c:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L53
            java.lang.Object r9 = kotlin.Result.m7870constructorimpl(r9)     // Catch: java.lang.Throwable -> L53
            goto L5e
        L53:
            r9 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m7870constructorimpl(r9)
        L5e:
            java.lang.Throwable r9 = kotlin.Result.m7873exceptionOrNullimpl(r9)
            if (r9 == 0) goto L69
            uz.FonRo.pos.ui.Toaster r2 = uz.FonRo.pos.ui.Toaster.INSTANCE
            r2.error(r9)
        L69:
            boolean r9 = r8.$canDebt
            if (r9 == 0) goto Lcd
            kotlin.Result$Companion r9 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L21
            uz.FonRo.pos.data.net.ApiClient r9 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L21
            uz.FonRo.pos.data.net.ApiClient r2 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L21
            uz.FonRo.pos.data.net.ApiService r2 = r2.api()     // Catch: java.lang.Throwable -> L21
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Throwable -> L21
            r8.L$0 = r6     // Catch: java.lang.Throwable -> L21
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Throwable -> L21
            r8.L$1 = r0     // Catch: java.lang.Throwable -> L21
            r8.L$2 = r9     // Catch: java.lang.Throwable -> L21
            r8.label = r5     // Catch: java.lang.Throwable -> L21
            java.lang.Object r0 = r2.debts(r8)     // Catch: java.lang.Throwable -> L21
            if (r0 != r1) goto L8e
        L8d:
            return r1
        L8e:
            r7 = r0
            r0 = r9
            r9 = r7
        L91:
            retrofit2.Response r9 = (retrofit2.Response) r9     // Catch: java.lang.Throwable -> L21
            java.lang.Object r9 = uz.FonRo.pos.data.net.ApiClient.unwrap$default(r0, r9, r4, r5, r3)     // Catch: java.lang.Throwable -> L21
            uz.FonRo.pos.data.model.DebtsResponse r9 = (uz.FonRo.pos.data.model.DebtsResponse) r9     // Catch: java.lang.Throwable -> L21
            java.lang.Object r9 = kotlin.Result.m7870constructorimpl(r9)     // Catch: java.lang.Throwable -> L21
            goto La8
        L9e:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m7870constructorimpl(r9)
        La8:
            androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.DebtSale>> r8 = r8.$debtSales$delegate
            boolean r0 = kotlin.Result.m7877isSuccessimpl(r9)
            if (r0 == 0) goto Lba
            r0 = r9
            uz.FonRo.pos.data.model.DebtsResponse r0 = (uz.FonRo.pos.data.model.DebtsResponse) r0
            java.util.List r0 = r0.getSales()
            uz.FonRo.pos.ui.clients.ClientsScreenKt.access$ClientsScreen$lambda$10(r8, r0)
        Lba:
            java.lang.Throwable r8 = kotlin.Result.m7873exceptionOrNullimpl(r9)
            if (r8 == 0) goto Lcd
            uz.FonRo.pos.ui.Toaster r8 = uz.FonRo.pos.ui.Toaster.INSTANCE
            java.lang.String r9 = "Долги клиентов не загрузились — список показан без них"
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r9 = uz.FonRo.pos.core.LangKt.tx(r9, r0)
            r8.error(r9)
        Lcd:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.clients.ClientsScreenKt$ClientsScreen$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
