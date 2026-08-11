package uz.FonRo.pos.data.repo;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import uz.FonRo.pos.data.model.Session;
import uz.FonRo.pos.data.model.WorkerKeyBody;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.net.ApiService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AuthRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Luz/FonRo/pos/data/model/Session;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.data.repo.AuthRepository$loginWithKey$2", f = "AuthRepository.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, nl = {46}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class AuthRepository$loginWithKey$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Session>, Object> {
    final /* synthetic */ String $accessKey;
    Object L$0;
    int label;
    final /* synthetic */ AuthRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthRepository$loginWithKey$2(AuthRepository authRepository, String str, Continuation<? super AuthRepository$loginWithKey$2> continuation) {
        super(2, continuation);
        this.this$0 = authRepository;
        this.$accessKey = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthRepository$loginWithKey$2(this.this$0, this.$accessKey, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Session> continuation) {
        return ((AuthRepository$loginWithKey$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ApiService api;
        Repo repo;
        String deviceName;
        ApiClient apiClient;
        Repo repo2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ApiClient apiClient2 = ApiClient.INSTANCE;
            api = this.this$0.getApi();
            String str = this.$accessKey;
            repo = this.this$0.repo;
            String deviceId = repo.getPrefs().getDeviceId();
            deviceName = this.this$0.deviceName();
            this.L$0 = apiClient2;
            this.label = 1;
            Object workerKey = api.workerKey(new WorkerKeyBody(str, deviceId, deviceName, (String) null, (Long) null, (Long) null, 56, (DefaultConstructorMarker) null), this);
            if (workerKey == coroutine_suspended) {
                return coroutine_suspended;
            }
            apiClient = apiClient2;
            obj = workerKey;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            apiClient = (ApiClient) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Session session = (Session) apiClient.unwrap((Response) obj, true);
        repo2 = this.this$0.repo;
        repo2.applySession(session);
        return session;
    }
}
