package uz.FonRo.pos.ui.team;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.data.model.Worker;
import uz.FonRo.pos.data.model.WorkerDevice;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TeamScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.team.TeamScreenKt$WorkerCardSheet$revoke$1", f = "TeamScreen.kt", i = {}, l = {400, TypedValues.CycleType.TYPE_VISIBILITY}, m = "invokeSuspend", n = {}, nl = {TypedValues.CycleType.TYPE_CURVE_FIT, TypedValues.CycleType.TYPE_ALPHA}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class TeamScreenKt$WorkerCardSheet$revoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FonRoApp $app;
    final /* synthetic */ WorkerDevice $device;
    final /* synthetic */ MutableState<List<WorkerDevice>> $devices$delegate;
    final /* synthetic */ MutableState<Boolean> $devicesLoading$delegate;
    final /* synthetic */ boolean $isOwner;
    final /* synthetic */ Worker $worker;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TeamScreenKt$WorkerCardSheet$revoke$1(FonRoApp FonRoApp, WorkerDevice workerDevice, boolean z, MutableState<Boolean> mutableState, Worker worker, MutableState<List<WorkerDevice>> mutableState2, Continuation<? super TeamScreenKt$WorkerCardSheet$revoke$1> continuation) {
        super(2, continuation);
        this.$app = FonRoApp;
        this.$device = workerDevice;
        this.$isOwner = z;
        this.$devicesLoading$delegate = mutableState;
        this.$worker = worker;
        this.$devices$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TeamScreenKt$WorkerCardSheet$revoke$1(this.$app, this.$device, this.$isOwner, this.$devicesLoading$delegate, this.$worker, this.$devices$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TeamScreenKt$WorkerCardSheet$revoke$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
    
        if (r9 == r0) goto L18;
     */
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L5d
            goto L64
        L12:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L1a:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L5d
            goto L39
        L1e:
            kotlin.ResultKt.throwOnFailure(r10)
            uz.FonRo.pos.FonRoApp r10 = r9.$app     // Catch: java.lang.Throwable -> L5d
            uz.FonRo.pos.data.repo.AuthRepository r10 = r10.getAuth()     // Catch: java.lang.Throwable -> L5d
            uz.FonRo.pos.data.model.WorkerDevice r1 = r9.$device     // Catch: java.lang.Throwable -> L5d
            long r4 = r1.getId()     // Catch: java.lang.Throwable -> L5d
            r1 = r9
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Throwable -> L5d
            r9.label = r3     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r10 = r10.revokeDevice(r4, r1)     // Catch: java.lang.Throwable -> L5d
            if (r10 != r0) goto L39
            goto L5c
        L39:
            uz.FonRo.pos.ui.Toaster r10 = uz.FonRo.pos.ui.Toaster.INSTANCE     // Catch: java.lang.Throwable -> L5d
            java.lang.String r1 = "Устройство отвязано"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L5d
            java.lang.String r1 = uz.FonRo.pos.core.LangKt.tx(r1, r3)     // Catch: java.lang.Throwable -> L5d
            r10.ok(r1)     // Catch: java.lang.Throwable -> L5d
            boolean r3 = r9.$isOwner     // Catch: java.lang.Throwable -> L5d
            androidx.compose.runtime.MutableState<java.lang.Boolean> r4 = r9.$devicesLoading$delegate     // Catch: java.lang.Throwable -> L5d
            uz.FonRo.pos.FonRoApp r5 = r9.$app     // Catch: java.lang.Throwable -> L5d
            uz.FonRo.pos.data.model.Worker r6 = r9.$worker     // Catch: java.lang.Throwable -> L5d
            androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.WorkerDevice>> r7 = r9.$devices$delegate     // Catch: java.lang.Throwable -> L5d
            r8 = r9
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch: java.lang.Throwable -> L5d
            r9.label = r2     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r9 = uz.FonRo.pos.ui.team.TeamScreenKt.access$WorkerCardSheet$loadDevices(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L5d
            if (r9 != r0) goto L64
        L5c:
            return r0
        L5d:
            r0 = move-exception
            r9 = r0
            uz.FonRo.pos.ui.Toaster r10 = uz.FonRo.pos.ui.Toaster.INSTANCE
            r10.error(r9)
        L64:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.team.TeamScreenKt$WorkerCardSheet$revoke$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
