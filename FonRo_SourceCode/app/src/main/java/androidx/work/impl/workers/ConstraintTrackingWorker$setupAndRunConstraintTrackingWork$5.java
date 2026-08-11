package androidx.work.impl.workers;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.ListenableWorker;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConstraintTrackingWorker.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroidx/work/ListenableWorker$Result;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$5", f = "ConstraintTrackingWorker.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {
    final /* synthetic */ ListenableWorker $delegate;
    final /* synthetic */ WorkConstraintsTracker $workConstraintsTracker;
    final /* synthetic */ WorkSpec $workSpec;
    int label;
    final /* synthetic */ ConstraintTrackingWorker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$5(ConstraintTrackingWorker constraintTrackingWorker, ListenableWorker listenableWorker, WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, Continuation<? super ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$5> continuation) {
        super(2, continuation);
        this.this$0 = constraintTrackingWorker;
        this.$delegate = listenableWorker;
        this.$workConstraintsTracker = workConstraintsTracker;
        this.$workSpec = workSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$5(this.this$0, this.$delegate, this.$workConstraintsTracker, this.$workSpec, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListenableWorker.Result> continuation) {
        return ((ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object runWorker;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        runWorker = this.this$0.runWorker(this.$delegate, this.$workConstraintsTracker, this.$workSpec, this);
        return runWorker == coroutine_suspended ? coroutine_suspended : runWorker;
    }
}
