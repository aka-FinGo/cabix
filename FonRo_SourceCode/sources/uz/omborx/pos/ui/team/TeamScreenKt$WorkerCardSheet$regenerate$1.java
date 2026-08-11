package uz.FonRo.pos.ui.team;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.data.model.Worker;
import uz.FonRo.pos.data.model.WorkerDevice;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TeamScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.team.TeamScreenKt$WorkerCardSheet$regenerate$1", f = "TeamScreen.kt", i = {0, 1, 1}, l = {385, 388}, m = "invokeSuspend", n = {"body", "body", "updated"}, nl = {386, 392}, s = {"L$0", "L$0", "L$1"}, v = 2)
/* loaded from: classes7.dex */
public final class TeamScreenKt$WorkerCardSheet$regenerate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FonRoApp $app;
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ MutableState<List<WorkerDevice>> $devices$delegate;
    final /* synthetic */ MutableState<Boolean> $devicesLoading$delegate;
    final /* synthetic */ boolean $isOwner;
    final /* synthetic */ Function1<Worker, Unit> $onWorkerChanged;
    final /* synthetic */ Worker $worker;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TeamScreenKt$WorkerCardSheet$regenerate$1(Worker worker, Function1<? super Worker, Unit> function1, boolean z, MutableState<Boolean> mutableState, FonRoApp FonRoApp, MutableState<List<WorkerDevice>> mutableState2, MutableState<Boolean> mutableState3, Continuation<? super TeamScreenKt$WorkerCardSheet$regenerate$1> continuation) {
        super(2, continuation);
        this.$worker = worker;
        this.$onWorkerChanged = function1;
        this.$isOwner = z;
        this.$devicesLoading$delegate = mutableState;
        this.$app = FonRoApp;
        this.$devices$delegate = mutableState2;
        this.$busy$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TeamScreenKt$WorkerCardSheet$regenerate$1(this.$worker, this.$onWorkerChanged, this.$isOwner, this.$devicesLoading$delegate, this.$app, this.$devices$delegate, this.$busy$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TeamScreenKt$WorkerCardSheet$regenerate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00c2, code lost:
    
        if (r15 == r0) goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 1
            r3 = 2
            r4 = 0
            if (r1 == 0) goto L30
            if (r1 == r2) goto L24
            if (r1 != r3) goto L1c
            java.lang.Object r0 = r14.L$1
            uz.FonRo.pos.data.model.Worker r0 = (uz.FonRo.pos.data.model.Worker) r0
            java.lang.Object r0 = r14.L$0
            uz.FonRo.pos.data.model.WorkerBody r0 = (uz.FonRo.pos.data.model.WorkerBody) r0
            kotlin.ResultKt.throwOnFailure(r15)     // Catch: java.lang.Throwable -> Lcb
            goto Lc5
        L1c:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L24:
            java.lang.Object r1 = r14.L$1
            uz.FonRo.pos.data.net.ApiClient r1 = (uz.FonRo.pos.data.net.ApiClient) r1
            java.lang.Object r2 = r14.L$0
            uz.FonRo.pos.data.model.WorkerBody r2 = (uz.FonRo.pos.data.model.WorkerBody) r2
            kotlin.ResultKt.throwOnFailure(r15)     // Catch: java.lang.Throwable -> Lcb
            goto L84
        L30:
            kotlin.ResultKt.throwOnFailure(r15)
            uz.FonRo.pos.data.model.WorkerBody r5 = new uz.FonRo.pos.data.model.WorkerBody     // Catch: java.lang.Throwable -> Lcb
            uz.FonRo.pos.data.model.Worker r15 = r14.$worker     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r6 = r15.getFullName()     // Catch: java.lang.Throwable -> Lcb
            uz.FonRo.pos.data.model.Worker r15 = r14.$worker     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r15 = r15.getPhone()     // Catch: java.lang.Throwable -> Lcb
            if (r15 != 0) goto L45
            java.lang.String r15 = ""
        L45:
            r7 = r15
            uz.FonRo.pos.data.model.Worker r15 = r14.$worker     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r8 = r15.getRole()     // Catch: java.lang.Throwable -> Lcb
            uz.FonRo.pos.data.model.Worker r15 = r14.$worker     // Catch: java.lang.Throwable -> Lcb
            boolean r9 = r15.isActive()     // Catch: java.lang.Throwable -> Lcb
            uz.FonRo.pos.data.model.Worker r15 = r14.$worker     // Catch: java.lang.Throwable -> Lcb
            java.util.Map r10 = r15.getPermissions()     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r11 = "regenerate_key"
            uz.FonRo.pos.data.model.Worker r15 = r14.$worker     // Catch: java.lang.Throwable -> Lcb
            long r12 = r15.getId()     // Catch: java.lang.Throwable -> Lcb
            java.lang.Long r12 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r12)     // Catch: java.lang.Throwable -> Lcb
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> Lcb
            uz.FonRo.pos.data.net.ApiClient r1 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> Lcb
            uz.FonRo.pos.data.net.ApiClient r15 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> Lcb
            uz.FonRo.pos.data.net.ApiService r15 = r15.api()     // Catch: java.lang.Throwable -> Lcb
            r6 = r14
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Throwable -> Lcb
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)     // Catch: java.lang.Throwable -> Lcb
            r14.L$0 = r7     // Catch: java.lang.Throwable -> Lcb
            r14.L$1 = r1     // Catch: java.lang.Throwable -> Lcb
            r14.label = r2     // Catch: java.lang.Throwable -> Lcb
            java.lang.Object r15 = r15.workerRegenerateKey(r5, r6)     // Catch: java.lang.Throwable -> Lcb
            if (r15 != r0) goto L83
            goto Lc4
        L83:
            r2 = r5
        L84:
            retrofit2.Response r15 = (retrofit2.Response) r15     // Catch: java.lang.Throwable -> Lcb
            r5 = 0
            java.lang.Object r15 = uz.FonRo.pos.data.net.ApiClient.unwrap$default(r1, r15, r4, r3, r5)     // Catch: java.lang.Throwable -> Lcb
            uz.FonRo.pos.data.model.WorkerResponse r15 = (uz.FonRo.pos.data.model.WorkerResponse) r15     // Catch: java.lang.Throwable -> Lcb
            uz.FonRo.pos.data.model.Worker r15 = r15.getWorker()     // Catch: java.lang.Throwable -> Lcb
            uz.FonRo.pos.ui.Toaster r1 = uz.FonRo.pos.ui.Toaster.INSTANCE     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r5 = "Новый ключ выпущен — передайте его сотруднику"
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r5 = uz.FonRo.pos.core.LangKt.tx(r5, r6)     // Catch: java.lang.Throwable -> Lcb
            r1.ok(r5)     // Catch: java.lang.Throwable -> Lcb
            kotlin.jvm.functions.Function1<uz.FonRo.pos.data.model.Worker, kotlin.Unit> r1 = r14.$onWorkerChanged     // Catch: java.lang.Throwable -> Lcb
            r1.invoke(r15)     // Catch: java.lang.Throwable -> Lcb
            boolean r5 = r14.$isOwner     // Catch: java.lang.Throwable -> Lcb
            androidx.compose.runtime.MutableState<java.lang.Boolean> r6 = r14.$devicesLoading$delegate     // Catch: java.lang.Throwable -> Lcb
            uz.FonRo.pos.FonRoApp r7 = r14.$app     // Catch: java.lang.Throwable -> Lcb
            uz.FonRo.pos.data.model.Worker r8 = r14.$worker     // Catch: java.lang.Throwable -> Lcb
            androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.WorkerDevice>> r9 = r14.$devices$delegate     // Catch: java.lang.Throwable -> Lcb
            r10 = r14
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch: java.lang.Throwable -> Lcb
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)     // Catch: java.lang.Throwable -> Lcb
            r14.L$0 = r1     // Catch: java.lang.Throwable -> Lcb
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)     // Catch: java.lang.Throwable -> Lcb
            r14.L$1 = r15     // Catch: java.lang.Throwable -> Lcb
            r14.label = r3     // Catch: java.lang.Throwable -> Lcb
            java.lang.Object r15 = uz.FonRo.pos.ui.team.TeamScreenKt.access$WorkerCardSheet$loadDevices(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lcb
            if (r15 != r0) goto Lc5
        Lc4:
            return r0
        Lc5:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r14 = r14.$busy$delegate
            uz.FonRo.pos.ui.team.TeamScreenKt.access$WorkerCardSheet$lambda$14(r14, r4)
            goto Ld3
        Lcb:
            r0 = move-exception
            r15 = r0
            uz.FonRo.pos.ui.Toaster r0 = uz.FonRo.pos.ui.Toaster.INSTANCE     // Catch: java.lang.Throwable -> Ld6
            r0.error(r15)     // Catch: java.lang.Throwable -> Ld6
            goto Lc5
        Ld3:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        Ld6:
            r0 = move-exception
            r15 = r0
            androidx.compose.runtime.MutableState<java.lang.Boolean> r14 = r14.$busy$delegate
            uz.FonRo.pos.ui.team.TeamScreenKt.access$WorkerCardSheet$lambda$14(r14, r4)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.team.TeamScreenKt$WorkerCardSheet$regenerate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
