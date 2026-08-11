package uz.FonRo.pos.work;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.ListenableWorker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PollWorker.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00070\u0001¢\u0006\u0002\b\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Landroidx/work/ListenableWorker$Result;", "Lkotlin/jvm/internal/EnhancedNullability;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.work.PollWorker$doWork$2", f = "PollWorker.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {42, 44, 49}, m = "invokeSuspend", n = {"$this$withContext", "app", "repo", "offline", "$this$withContext", "app", "repo", "offline", "$this$withContext", "app", "repo", "$this$invokeSuspend_u24lambda_u240", "offline"}, nl = {44, 49, 49}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 2)
/* loaded from: classes7.dex */
public final class PollWorker$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PollWorker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PollWorker$doWork$2(PollWorker pollWorker, Continuation<? super PollWorker$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = pollWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PollWorker$doWork$2 pollWorker$doWork$2 = new PollWorker$doWork$2(this.this$0, continuation);
        pollWorker$doWork$2.L$0 = obj;
        return pollWorker$doWork$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListenableWorker.Result> continuation) {
        return ((PollWorker$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.work.PollWorker$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
