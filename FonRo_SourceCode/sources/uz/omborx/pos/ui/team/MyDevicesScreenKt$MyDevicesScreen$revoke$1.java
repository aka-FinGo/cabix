package uz.FonRo.pos.ui.team;

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
import uz.FonRo.pos.data.model.WorkerDevice;
import uz.FonRo.pos.data.repo.AuthRepository;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MyDevicesScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.team.MyDevicesScreenKt$MyDevicesScreen$revoke$1", f = "MyDevicesScreen.kt", i = {}, l = {74, 76}, m = "invokeSuspend", n = {}, nl = {75, 77}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class MyDevicesScreenKt$MyDevicesScreen$revoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AuthRepository $auth;
    final /* synthetic */ WorkerDevice $device;
    final /* synthetic */ MutableState<List<WorkerDevice>> $devices$delegate;
    final /* synthetic */ MutableState<Boolean> $failed$delegate;
    final /* synthetic */ MutableState<Boolean> $loading$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyDevicesScreenKt$MyDevicesScreen$revoke$1(AuthRepository authRepository, WorkerDevice workerDevice, MutableState<Boolean> mutableState, MutableState<List<WorkerDevice>> mutableState2, MutableState<Boolean> mutableState3, Continuation<? super MyDevicesScreenKt$MyDevicesScreen$revoke$1> continuation) {
        super(2, continuation);
        this.$auth = authRepository;
        this.$device = workerDevice;
        this.$loading$delegate = mutableState;
        this.$devices$delegate = mutableState2;
        this.$failed$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MyDevicesScreenKt$MyDevicesScreen$revoke$1(this.$auth, this.$device, this.$loading$delegate, this.$devices$delegate, this.$failed$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MyDevicesScreenKt$MyDevicesScreen$revoke$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:
    
        if (r6 == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L57
            goto L5d
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1a:
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L57
            goto L35
        L1e:
            kotlin.ResultKt.throwOnFailure(r7)
            uz.FonRo.pos.data.repo.AuthRepository r7 = r6.$auth     // Catch: java.lang.Throwable -> L57
            uz.FonRo.pos.data.model.WorkerDevice r1 = r6.$device     // Catch: java.lang.Throwable -> L57
            long r4 = r1.getId()     // Catch: java.lang.Throwable -> L57
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Throwable -> L57
            r6.label = r3     // Catch: java.lang.Throwable -> L57
            java.lang.Object r7 = r7.revokeDevice(r4, r1)     // Catch: java.lang.Throwable -> L57
            if (r7 != r0) goto L35
            goto L56
        L35:
            uz.FonRo.pos.ui.Toaster r7 = uz.FonRo.pos.ui.Toaster.INSTANCE     // Catch: java.lang.Throwable -> L57
            java.lang.String r1 = "Устройство отвязано"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L57
            java.lang.String r1 = uz.FonRo.pos.core.LangKt.tx(r1, r3)     // Catch: java.lang.Throwable -> L57
            r7.ok(r1)     // Catch: java.lang.Throwable -> L57
            androidx.compose.runtime.MutableState<java.lang.Boolean> r7 = r6.$loading$delegate     // Catch: java.lang.Throwable -> L57
            uz.FonRo.pos.data.repo.AuthRepository r1 = r6.$auth     // Catch: java.lang.Throwable -> L57
            androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.WorkerDevice>> r3 = r6.$devices$delegate     // Catch: java.lang.Throwable -> L57
            androidx.compose.runtime.MutableState<java.lang.Boolean> r4 = r6.$failed$delegate     // Catch: java.lang.Throwable -> L57
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Throwable -> L57
            r6.label = r2     // Catch: java.lang.Throwable -> L57
            java.lang.Object r6 = uz.FonRo.pos.ui.team.MyDevicesScreenKt.access$MyDevicesScreen$load(r7, r1, r3, r4, r5)     // Catch: java.lang.Throwable -> L57
            if (r6 != r0) goto L5d
        L56:
            return r0
        L57:
            r6 = move-exception
            uz.FonRo.pos.ui.Toaster r7 = uz.FonRo.pos.ui.Toaster.INSTANCE
            r7.error(r6)
        L5d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.team.MyDevicesScreenKt$MyDevicesScreen$revoke$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
