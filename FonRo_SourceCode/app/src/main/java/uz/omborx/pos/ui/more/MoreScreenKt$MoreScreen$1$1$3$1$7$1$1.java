package uz.FonRo.pos.ui.more;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.json.JsonElement;
import retrofit2.Response;
import uz.FonRo.pos.data.net.ApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoreScreen.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lkotlinx/serialization/json/JsonElement;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.more.MoreScreenKt$MoreScreen$1$1$3$1$7$1$1", f = "MoreScreen.kt", i = {}, l = {301}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class MoreScreenKt$MoreScreen$1$1$3$1$7$1$1 extends SuspendLambda implements Function1<Continuation<? super JsonElement>, Object> {
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MoreScreenKt$MoreScreen$1$1$3$1$7$1$1(Continuation<? super MoreScreenKt$MoreScreen$1$1$3$1$7$1$1> continuation) {
        super(1, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new MoreScreenKt$MoreScreen$1$1$3$1$7$1$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super JsonElement> continuation) {
        return ((MoreScreenKt$MoreScreen$1$1$3$1$7$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ApiClient apiClient;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ApiClient apiClient2 = ApiClient.INSTANCE;
            this.L$0 = apiClient2;
            this.label = 1;
            Object resumeSubscription = ApiClient.INSTANCE.api().resumeSubscription(this);
            if (resumeSubscription == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = resumeSubscription;
            apiClient = apiClient2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            apiClient = (ApiClient) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return ApiClient.unwrapRaw$default(apiClient, (Response) obj, false, 2, null);
    }
}
