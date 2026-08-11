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
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import uz.FonRo.pos.data.model.RegisterBody;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.net.ApiService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AuthRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.data.repo.AuthRepository$register$2", f = "AuthRepository.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, nl = {57}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class AuthRepository$register$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $email;
    final /* synthetic */ String $fullName;
    final /* synthetic */ String $password;
    final /* synthetic */ String $phone;
    final /* synthetic */ String $storeName;
    Object L$0;
    int label;
    final /* synthetic */ AuthRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthRepository$register$2(AuthRepository authRepository, String str, String str2, String str3, String str4, String str5, Continuation<? super AuthRepository$register$2> continuation) {
        super(2, continuation);
        this.this$0 = authRepository;
        this.$fullName = str;
        this.$storeName = str2;
        this.$phone = str3;
        this.$email = str4;
        this.$password = str5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthRepository$register$2(this.this$0, this.$fullName, this.$storeName, this.$phone, this.$email, this.$password, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuthRepository$register$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Object register = api.register(new RegisterBody(this.$fullName, this.$storeName, this.$phone, this.$email, this.$password), this);
            if (register == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = register;
            apiClient = apiClient2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            apiClient = (ApiClient) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        apiClient.unwrapVoid((Response) obj, true);
        return Unit.INSTANCE;
    }
}
