package uz.FonRo.pos.data.repo;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
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
import uz.FonRo.pos.data.model.WorkerDevice;
import uz.FonRo.pos.data.model.WorkerDevicesResponse;
import uz.FonRo.pos.data.model.WorkerKeyBody;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.net.ApiService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AuthRepository.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Luz/FonRo/pos/data/model/WorkerDevice;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.data.repo.AuthRepository$myDevices$2", f = "AuthRepository.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class AuthRepository$myDevices$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends WorkerDevice>>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ AuthRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthRepository$myDevices$2(AuthRepository authRepository, Continuation<? super AuthRepository$myDevices$2> continuation) {
        super(2, continuation);
        this.this$0 = authRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthRepository$myDevices$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends WorkerDevice>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<WorkerDevice>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<WorkerDevice>> continuation) {
        return ((AuthRepository$myDevices$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ApiService api;
        ApiClient apiClient;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ApiClient apiClient2 = ApiClient.INSTANCE;
            api = this.this$0.getApi();
            this.L$0 = apiClient2;
            this.label = 1;
            Object workerKeyDevices = api.workerKeyDevices(new WorkerKeyBody((String) null, (String) null, (String) null, "my_devices", (Long) null, (Long) null, 55, (DefaultConstructorMarker) null), this);
            if (workerKeyDevices == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = workerKeyDevices;
            apiClient = apiClient2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            apiClient = (ApiClient) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return ((WorkerDevicesResponse) ApiClient.unwrap$default(apiClient, (Response) obj, false, 2, null)).getDevices();
    }
}
