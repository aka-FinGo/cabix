package androidx.work.impl.workers;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.ListenableWorker;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ConstraintTrackingWorker.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Landroidx/work/ListenableWorker$Result;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2", f = "ConstraintTrackingWorker.kt", i = {0, 0, 0}, l = {134}, m = "invokeSuspend", n = {"atomicReason", "future", "constraintTrackingJob"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes5.dex */
final class ConstraintTrackingWorker$runWorker$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {
    final /* synthetic */ ListenableWorker $delegate;
    final /* synthetic */ WorkConstraintsTracker $workConstraintsTracker;
    final /* synthetic */ WorkSpec $workSpec;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker$runWorker$2(ListenableWorker listenableWorker, WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, Continuation<? super ConstraintTrackingWorker$runWorker$2> continuation) {
        super(2, continuation);
        this.$delegate = listenableWorker;
        this.$workConstraintsTracker = workConstraintsTracker;
        this.$workSpec = workSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ConstraintTrackingWorker$runWorker$2 constraintTrackingWorker$runWorker$2 = new ConstraintTrackingWorker$runWorker$2(this.$delegate, this.$workConstraintsTracker, this.$workSpec, continuation);
        constraintTrackingWorker$runWorker$2.L$0 = obj;
        return constraintTrackingWorker$runWorker$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListenableWorker.Result> continuation) {
        return ((ConstraintTrackingWorker$runWorker$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e8 A[Catch: all -> 0x00e9, TRY_LEAVE, TryCatch #1 {all -> 0x00e9, blocks: (B:27:0x0080, B:28:0x00a2, B:14:0x00a7, B:17:0x00d6, B:20:0x00de, B:21:0x00e7, B:23:0x00e8), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d5  */
    /* JADX WARN: Type inference failed for: r1v0, types: [kotlinx.coroutines.Job, int] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
