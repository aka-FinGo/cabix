package androidx.work.impl.workers;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConstraintTrackingWorker.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Landroidx/work/impl/constraints/ConstraintsState;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2", f = "ConstraintTrackingWorker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2 extends SuspendLambda implements Function2<ConstraintsState, Continuation<? super Unit>, Object> {
    final /* synthetic */ WorkSpec $workSpec;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2(WorkSpec workSpec, Continuation<? super ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2> continuation) {
        super(2, continuation);
        this.$workSpec = workSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2(this.$workSpec, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ConstraintsState constraintsState, Continuation<? super Unit> continuation) {
        return ((ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2) create(constraintsState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        str = ConstraintTrackingWorkerKt.TAG;
        WorkSpec workSpec = this.$workSpec;
        Logger.get().debug(str, "Constraints changed for " + workSpec);
        return Unit.INSTANCE;
    }
}
