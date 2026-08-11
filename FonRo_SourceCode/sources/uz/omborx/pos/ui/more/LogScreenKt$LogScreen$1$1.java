package uz.FonRo.pos.ui.more;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import uz.FonRo.pos.data.model.ActivityEntry;
import uz.FonRo.pos.data.model.ActivityLogResponse;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.net.ApiService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LogScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.more.LogScreenKt$LogScreen$1$1", f = "LogScreen.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, nl = {89}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class LogScreenKt$LogScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $allowed;
    final /* synthetic */ MutableState<String> $date$delegate;
    final /* synthetic */ MutableState<List<ActivityEntry>> $entries$delegate;
    final /* synthetic */ MutableState<String> $error$delegate;
    final /* synthetic */ MutableState<Boolean> $loading$delegate;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogScreenKt$LogScreen$1$1(boolean z, MutableState<Boolean> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<List<ActivityEntry>> mutableState4, Continuation<? super LogScreenKt$LogScreen$1$1> continuation) {
        super(2, continuation);
        this.$allowed = z;
        this.$loading$delegate = mutableState;
        this.$error$delegate = mutableState2;
        this.$date$delegate = mutableState3;
        this.$entries$delegate = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LogScreenKt$LogScreen$1$1(this.$allowed, this.$loading$delegate, this.$error$delegate, this.$date$delegate, this.$entries$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LogScreenKt$LogScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableState<List<ActivityEntry>> mutableState;
        String LogScreen$lambda$3;
        ApiClient apiClient;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                boolean z = this.$allowed;
                MutableState<Boolean> mutableState2 = this.$loading$delegate;
                if (!z) {
                    LogScreenKt.LogScreen$lambda$10(mutableState2, false);
                    return Unit.INSTANCE;
                }
                LogScreenKt.LogScreen$lambda$10(mutableState2, true);
                this.$error$delegate.setValue(null);
                mutableState = this.$entries$delegate;
                ApiClient apiClient2 = ApiClient.INSTANCE;
                ApiService api = ApiClient.INSTANCE.api();
                LogScreen$lambda$3 = LogScreenKt.LogScreen$lambda$3(this.$date$delegate);
                this.L$0 = mutableState;
                this.L$1 = apiClient2;
                this.label = 1;
                Object activityLog = api.activityLog(LogScreen$lambda$3, this);
                if (activityLog == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiClient = apiClient2;
                obj = activityLog;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                apiClient = (ApiClient) this.L$1;
                mutableState = (MutableState) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            mutableState.setValue(((ActivityLogResponse) ApiClient.unwrap$default(apiClient, (Response) obj, false, 2, null)).getLogs());
        } catch (Throwable th) {
            this.$entries$delegate.setValue(CollectionsKt.emptyList());
            this.$error$delegate.setValue(ApiClient.INSTANCE.asApiError(th).getMessage());
        }
        LogScreenKt.LogScreen$lambda$10(this.$loading$delegate, false);
        return Unit.INSTANCE;
    }
}
