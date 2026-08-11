package uz.FonRo.pos.work;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.ListenableWorker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OutboxWorker.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00070\u0001¢\u0006\u0002\b\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Landroidx/work/ListenableWorker$Result;", "Lkotlin/jvm/internal/EnhancedNullability;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.work.OutboxWorker$doWork$2", f = "OutboxWorker.kt", i = {0, 0}, l = {33}, m = "invokeSuspend", n = {"app", "repo"}, nl = {34}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes7.dex */
public final class OutboxWorker$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ OutboxWorker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutboxWorker$doWork$2(OutboxWorker outboxWorker, Continuation<? super OutboxWorker$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = outboxWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OutboxWorker$doWork$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListenableWorker.Result> continuation) {
        return ((OutboxWorker$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Repo repo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Context applicationContext = this.this$0.getApplicationContext();
                Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type uz.FonRo.pos.FonRoApp");
                FonRoApp FonRoApp = (FonRoApp) applicationContext;
                Repo repo2 = FonRoApp.getRepo();
                if (repo2.isLoggedIn() && repo2.getOutbox().getSize() != 0) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(FonRoApp);
                    this.L$1 = repo2;
                    this.label = 1;
                    obj = FonRoApp.getSales().flushOutbox(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    repo = repo2;
                }
                return ListenableWorker.Result.success();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            repo = (Repo) this.L$1;
            ResultKt.throwOnFailure(obj);
            int intValue = ((Number) obj).intValue();
            if (intValue > 0) {
                Notifier notifier = Notifier.INSTANCE;
                Context applicationContext2 = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                Notifier.show$default(notifier, applicationContext2, "sync", Notifier.ID_SYNC, LangKt.tx("Отложенные чеки отправлены", new Object[0]), LangKt.tx("Ушло на сервер: ", new Object[0]) + Fmt.INSTANCE.plural(intValue, LangKt.tx("чек", new Object[0]), LangKt.tx("чека", new Object[0]), LangKt.tx("чеков", new Object[0])), false, null, 96, null);
            }
            return repo.getOutbox().getSize() == 0 ? ListenableWorker.Result.success() : (repo.getOnline().getValue().booleanValue() && ApiClient.INSTANCE.isOnline()) ? ListenableWorker.Result.success() : ListenableWorker.Result.retry();
        } catch (Throwable th) {
            return ApiClient.INSTANCE.asApiError(th).getOffline() ? ListenableWorker.Result.retry() : ListenableWorker.Result.success();
        }
    }
}
