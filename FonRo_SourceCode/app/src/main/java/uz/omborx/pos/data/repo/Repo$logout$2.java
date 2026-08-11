package uz.FonRo.pos.data.repo;

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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import uz.FonRo.pos.data.model.WorkerKeyBody;
import uz.FonRo.pos.data.net.ApiService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Repo.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.data.repo.Repo$logout$2", f = "Repo.kt", i = {0, 0}, l = {271}, m = "invokeSuspend", n = {"$this$withContext", "$this$invokeSuspend_u24lambda_u240"}, nl = {270}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes5.dex */
public final class Repo$logout$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Repo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Repo$logout$2(Repo repo, Continuation<? super Repo$logout$2> continuation) {
        super(2, continuation);
        this.this$0 = repo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Repo$logout$2 repo$logout$2 = new Repo$logout$2(this.this$0, continuation);
        repo$logout$2.L$0 = obj;
        return repo$logout$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Repo$logout$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ApiService api;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Repo repo = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                api = repo.getApi();
                WorkerKeyBody workerKeyBody = new WorkerKeyBody((String) null, repo.getPrefs().getDeviceId(), (String) null, "logout", (Long) null, (Long) null, 53, (DefaultConstructorMarker) null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.label = 1;
                obj = api.workerKeyAction(workerKeyBody, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result.m7870constructorimpl((Response) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        this.this$0.clearLocal();
        return Unit.INSTANCE;
    }
}
