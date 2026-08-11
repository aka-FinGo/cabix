package uz.FonRo.pos.ui.team;

import androidx.compose.runtime.MutableState;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.data.model.Worker;
import uz.FonRo.pos.data.model.WorkerBody;
import uz.FonRo.pos.data.model.WorkerResponse;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.ui.Toaster;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TeamScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.team.TeamScreenKt$WorkerFormSheet$save$1", f = "TeamScreen.kt", i = {0, 0, 0, 1, 1, 1}, l = {741, 743}, m = "invokeSuspend", n = {"existing", "hidden", "body", "existing", "hidden", "body"}, nl = {743, 740}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
/* loaded from: classes7.dex */
public final class TeamScreenKt$WorkerFormSheet$save$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $active$delegate;
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ String $fullName;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ Function1<Worker, Unit> $onSaved;
    final /* synthetic */ MutableState<Map<String, Integer>> $perms$delegate;
    final /* synthetic */ MutableState<String> $phone$delegate;
    final /* synthetic */ String $role;
    final /* synthetic */ Worker $worker;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TeamScreenKt$WorkerFormSheet$save$1(Worker worker, String str, String str2, Function1<? super Worker, Unit> function1, Function0<Unit> function0, MutableState<String> mutableState, MutableState<Boolean> mutableState2, MutableState<Map<String, Integer>> mutableState3, MutableState<Boolean> mutableState4, Continuation<? super TeamScreenKt$WorkerFormSheet$save$1> continuation) {
        super(2, continuation);
        this.$worker = worker;
        this.$fullName = str;
        this.$role = str2;
        this.$onSaved = function1;
        this.$onDismiss = function0;
        this.$phone$delegate = mutableState;
        this.$active$delegate = mutableState2;
        this.$perms$delegate = mutableState3;
        this.$busy$delegate = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TeamScreenKt$WorkerFormSheet$save$1(this.$worker, this.$fullName, this.$role, this.$onSaved, this.$onDismiss, this.$phone$delegate, this.$active$delegate, this.$perms$delegate, this.$busy$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TeamScreenKt$WorkerFormSheet$save$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String WorkerFormSheet$lambda$4;
        boolean WorkerFormSheet$lambda$8;
        Map WorkerFormSheet$lambda$14;
        Object workerUpdate;
        ApiClient apiClient;
        Object workerCreate;
        ApiClient apiClient2;
        Worker worker;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Worker worker2 = this.$worker;
                Map<String, Integer> permissions = worker2 != null ? worker2.getPermissions() : null;
                if (permissions == null) {
                    permissions = MapsKt.emptyMap();
                }
                Map<String, Integer> hidden_defaults = Perm.INSTANCE.getHIDDEN_DEFAULTS();
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(hidden_defaults.size()));
                for (Object obj2 : hidden_defaults.entrySet()) {
                    Object key = ((Map.Entry) obj2).getKey();
                    Map.Entry entry = (Map.Entry) obj2;
                    String str = (String) entry.getKey();
                    int intValue = ((Number) entry.getValue()).intValue();
                    Integer num = permissions.get(str);
                    if (num != null) {
                        intValue = num.intValue();
                    }
                    linkedHashMap.put(key, Boxing.boxInt(intValue));
                }
                String str2 = this.$fullName;
                WorkerFormSheet$lambda$4 = TeamScreenKt.WorkerFormSheet$lambda$4(this.$phone$delegate);
                String obj3 = StringsKt.trim((CharSequence) WorkerFormSheet$lambda$4).toString();
                String str3 = this.$role;
                WorkerFormSheet$lambda$8 = TeamScreenKt.WorkerFormSheet$lambda$8(this.$active$delegate);
                WorkerFormSheet$lambda$14 = TeamScreenKt.WorkerFormSheet$lambda$14(this.$perms$delegate);
                WorkerBody workerBody = new WorkerBody(str2, obj3, str3, WorkerFormSheet$lambda$8 ? 1 : 0, MapsKt.plus(linkedHashMap, WorkerFormSheet$lambda$14), (String) null, (Long) null, 96, (DefaultConstructorMarker) null);
                if (this.$worker == null) {
                    ApiClient apiClient3 = ApiClient.INSTANCE;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(permissions);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(workerBody);
                    this.L$3 = apiClient3;
                    this.label = 1;
                    workerCreate = ApiClient.INSTANCE.api().workerCreate(workerBody, this);
                    if (workerCreate != coroutine_suspended) {
                        apiClient2 = apiClient3;
                        worker = ((WorkerResponse) ApiClient.unwrap$default(apiClient2, (Response) workerCreate, false, 2, null)).getWorker();
                    }
                } else {
                    ApiClient apiClient4 = ApiClient.INSTANCE;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(permissions);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(workerBody);
                    this.L$3 = apiClient4;
                    this.label = 2;
                    workerUpdate = ApiClient.INSTANCE.api().workerUpdate(this.$worker.getId(), workerBody, this);
                    if (workerUpdate != coroutine_suspended) {
                        apiClient = apiClient4;
                        worker = ((WorkerResponse) ApiClient.unwrap$default(apiClient, (Response) workerUpdate, false, 2, null)).getWorker();
                    }
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                apiClient2 = (ApiClient) this.L$3;
                ResultKt.throwOnFailure(obj);
                workerCreate = obj;
                worker = ((WorkerResponse) ApiClient.unwrap$default(apiClient2, (Response) workerCreate, false, 2, null)).getWorker();
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                apiClient = (ApiClient) this.L$3;
                ResultKt.throwOnFailure(obj);
                workerUpdate = obj;
                worker = ((WorkerResponse) ApiClient.unwrap$default(apiClient, (Response) workerUpdate, false, 2, null)).getWorker();
            }
            Toaster.INSTANCE.ok(this.$worker == null ? LangKt.tx("Сотрудник создан", new Object[0]) : LangKt.tx("Права обновлены", new Object[0]));
            this.$onSaved.invoke(worker);
            this.$onDismiss.invoke();
        } finally {
            try {
                TeamScreenKt.WorkerFormSheet$lambda$12(this.$busy$delegate, false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
            }
        }
        TeamScreenKt.WorkerFormSheet$lambda$12(this.$busy$delegate, false);
        return Unit.INSTANCE;
    }
}
