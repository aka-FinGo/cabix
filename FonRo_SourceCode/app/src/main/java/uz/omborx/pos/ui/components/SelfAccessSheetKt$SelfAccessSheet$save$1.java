package uz.FonRo.pos.ui.components;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.model.SelfLimitsBody;
import uz.FonRo.pos.data.model.SelfLimitsResponse;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SelfAccessSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.components.SelfAccessSheetKt$SelfAccessSheet$save$1", f = "SelfAccessSheet.kt", i = {0}, l = {75}, m = "invokeSuspend", n = {"body"}, nl = {78}, s = {"L$0"}, v = 2)
/* loaded from: classes7.dex */
public final class SelfAccessSheetKt$SelfAccessSheet$save$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ Repo $repo;
    final /* synthetic */ SnapshotStateMap<String, Boolean> $state;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelfAccessSheetKt$SelfAccessSheet$save$1(SnapshotStateMap<String, Boolean> snapshotStateMap, Repo repo, Function0<Unit> function0, MutableState<Boolean> mutableState, Continuation<? super SelfAccessSheetKt$SelfAccessSheet$save$1> continuation) {
        super(2, continuation);
        this.$state = snapshotStateMap;
        this.$repo = repo;
        this.$onDismiss = function0;
        this.$busy$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SelfAccessSheetKt$SelfAccessSheet$save$1(this.$state, this.$repo, this.$onDismiss, this.$busy$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SelfAccessSheetKt$SelfAccessSheet$save$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ApiClient apiClient;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SnapshotStateMap<String, Boolean> snapshotStateMap = this.$state;
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(snapshotStateMap.size()));
                for (Object obj2 : snapshotStateMap.entrySet()) {
                    linkedHashMap.put(((Map.Entry) obj2).getKey(), Boxing.boxInt(((Boolean) ((Map.Entry) obj2).getValue()).booleanValue() ? 1 : 0));
                }
                SelfLimitsBody selfLimitsBody = new SelfLimitsBody(linkedHashMap);
                ApiClient apiClient2 = ApiClient.INSTANCE;
                this.L$0 = SpillingKt.nullOutSpilledVariable(selfLimitsBody);
                this.L$1 = apiClient2;
                this.label = 1;
                obj = ApiClient.INSTANCE.api().saveSelfLimits(selfLimitsBody, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiClient = apiClient2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                apiClient = (ApiClient) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            Map<String, Integer> selfLimits = ((SelfLimitsResponse) ApiClient.unwrap$default(apiClient, (Response) obj, false, 2, null)).getSelfLimits();
            this.$repo.updateSelfLimits(selfLimits);
            this.$onDismiss.invoke();
            Toaster.INSTANCE.ok(selfLimits.isEmpty() ? LangKt.tx("Доступ открыт полностью", new Object[0]) : LangKt.tx("Скрыто разделов: %s", Boxing.boxInt(selfLimits.size())));
        } finally {
            try {
                SelfAccessSheetKt.SelfAccessSheet$lambda$2(this.$busy$delegate, false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
            }
        }
        SelfAccessSheetKt.SelfAccessSheet$lambda$2(this.$busy$delegate, false);
        return Unit.INSTANCE;
    }
}
