package uz.FonRo.pos.ui.docs;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReturnsScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.docs.ReturnsScreenKt$ReturnsScreen$1$1", f = "ReturnsScreen.kt", i = {0, 0}, l = {128}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "$this$invokeSuspend_u24lambda_u241"}, nl = {128}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes7.dex */
public final class ReturnsScreenKt$ReturnsScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $formOpen$delegate;
    final /* synthetic */ MutableState<String> $formTid$delegate;
    final /* synthetic */ Repo $repo;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReturnsScreenKt$ReturnsScreen$1$1(MutableState<String> mutableState, MutableState<Boolean> mutableState2, Repo repo, Continuation<? super ReturnsScreenKt$ReturnsScreen$1$1> continuation) {
        super(2, continuation);
        this.$formTid$delegate = mutableState;
        this.$formOpen$delegate = mutableState2;
        this.$repo = repo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ReturnsScreenKt$ReturnsScreen$1$1 returnsScreenKt$ReturnsScreen$1$1 = new ReturnsScreenKt$ReturnsScreen$1$1(this.$formTid$delegate, this.$formOpen$delegate, this.$repo, continuation);
        returnsScreenKt$ReturnsScreen$1$1.L$0 = obj;
        return returnsScreenKt$ReturnsScreen$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReturnsScreenKt$ReturnsScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String pendingTransactionId = ReturnsHandoff.INSTANCE.getPendingTransactionId();
                if (pendingTransactionId != null) {
                    MutableState<String> mutableState = this.$formTid$delegate;
                    MutableState<Boolean> mutableState2 = this.$formOpen$delegate;
                    ReturnsHandoff.INSTANCE.setPendingTransactionId(null);
                    mutableState.setValue(pendingTransactionId);
                    ReturnsScreenKt.ReturnsScreen$lambda$3(mutableState2, true);
                }
                Repo repo = this.$repo;
                Result.Companion companion = Result.INSTANCE;
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.label = 1;
                if (Repo.loadDirectory$default(repo, false, this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result.m7870constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        return Unit.INSTANCE;
    }
}
