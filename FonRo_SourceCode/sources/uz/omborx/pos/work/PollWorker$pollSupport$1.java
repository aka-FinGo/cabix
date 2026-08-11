package uz.FonRo.pos.work;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PollWorker.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.work.PollWorker", f = "PollWorker.kt", i = {0, 0, 0}, l = {118}, m = "pollSupport", n = {"app", "repo", "seen"}, nl = {119}, s = {"L$0", "L$1", "J$0"}, v = 2)
/* loaded from: classes7.dex */
public final class PollWorker$pollSupport$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PollWorker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PollWorker$pollSupport$1(PollWorker pollWorker, Continuation<? super PollWorker$pollSupport$1> continuation) {
        super(continuation);
        this.this$0 = pollWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object pollSupport;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        pollSupport = this.this$0.pollSupport(null, this);
        return pollSupport;
    }
}
