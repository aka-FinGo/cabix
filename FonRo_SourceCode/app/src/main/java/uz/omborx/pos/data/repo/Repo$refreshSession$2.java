package uz.FonRo.pos.data.repo;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import retrofit2.Response;
import uz.FonRo.pos.data.model.Session;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.net.ApiService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Repo.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Luz/FonRo/pos/data/model/Session;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.data.repo.Repo$refreshSession$2", f = "Repo.kt", i = {}, l = {258}, m = "invokeSuspend", n = {}, nl = {259}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class Repo$refreshSession$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Session>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ Repo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Repo$refreshSession$2(Repo repo, Continuation<? super Repo$refreshSession$2> continuation) {
        super(2, continuation);
        this.this$0 = repo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Repo$refreshSession$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Session> continuation) {
        return ((Repo$refreshSession$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ApiService api;
        ApiClient apiClient;
        MutableStateFlow mutableStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ApiClient apiClient2 = ApiClient.INSTANCE;
            api = this.this$0.getApi();
            this.L$0 = apiClient2;
            this.label = 1;
            Object session = api.session(this);
            if (session == coroutine_suspended) {
                return coroutine_suspended;
            }
            apiClient = apiClient2;
            obj = session;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            apiClient = (ApiClient) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Session session2 = (Session) apiClient.unwrap((Response) obj, true);
        this.this$0.applySession(session2);
        mutableStateFlow = this.this$0._online;
        mutableStateFlow.setValue(Boxing.boxBoolean(true));
        return session2;
    }
}
