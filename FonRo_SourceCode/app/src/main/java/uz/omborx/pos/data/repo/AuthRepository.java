package uz.FonRo.pos.data.repo;

import android.os.Build;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.disk.DiskLruCache;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;
import uz.FonRo.pos.data.model.Session;
import uz.FonRo.pos.data.model.WorkerDevice;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.net.ApiException;
import uz.FonRo.pos.data.net.ApiService;

/* compiled from: AuthRepository.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0002J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0013J6\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0010J&\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010#\u001a\u00020$J\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0086@¢\u0006\u0002\u0010(J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010*\u001a\u00020+H\u0086@¢\u0006\u0002\u0010,J\u0016\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020+H\u0086@¢\u0006\u0002\u0010,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tÊ\u0001\f\b0\u0012\b\b1\u0012\u0004\b\u0003\u0010\u0000¨\u0006/"}, d2 = {"Luz/FonRo/pos/data/repo/AuthRepository;", "", "repo", "Luz/FonRo/pos/data/repo/Repo;", "<init>", "(Luz/FonRo/pos/data/repo/Repo;)V", "api", "Luz/FonRo/pos/data/net/ApiService;", "getApi", "()Luz/FonRo/pos/data/net/ApiService;", "deviceName", "", FirebaseAnalytics.Event.LOGIN, "Luz/FonRo/pos/data/model/Session;", "email", HintConstants.AUTOFILL_HINT_PASSWORD, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginWithKey", "accessKey", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "", "fullName", "storeName", HintConstants.AUTOFILL_HINT_PHONE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyEmail", "code", "resendCode", "resetRequest", "resetVerify", "resetComplete", HintConstants.AUTOFILL_HINT_NEW_PASSWORD, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verificationRequired", "e", "Luz/FonRo/pos/data/net/ApiException;", "myDevices", "", "Luz/FonRo/pos/data/model/WorkerDevice;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "workerDevices", "workerId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revokeDevice", "deviceRowId", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class AuthRepository {
    public static final int $stable = Repo.$stable;
    private final Repo repo;

    public AuthRepository(Repo repo) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        this.repo = repo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApiService getApi() {
        return ApiClient.INSTANCE.api();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String deviceName() {
        String str = Build.MANUFACTURER;
        if (str == null) {
            str = null;
        } else if (str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            String valueOf = String.valueOf(str.charAt(0));
            Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = valueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            sb.append((Object) upperCase);
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            sb.append(substring);
            str = sb.toString();
        }
        if (str == null) {
            str = "";
        }
        String str2 = Build.MODEL;
        List listOf = CollectionsKt.listOf((Object[]) new String[]{str, str2 != null ? str2 : ""});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listOf) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        String joinToString$default = CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null);
        if (StringsKt.isBlank(joinToString$default)) {
            joinToString$default = "Android";
        }
        return ((Object) joinToString$default) + " · Android " + Build.VERSION.RELEASE;
    }

    public final Object login(String str, String str2, Continuation<? super Session> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AuthRepository$login$2(this, str, str2, null), continuation);
    }

    public final Object loginWithKey(String str, Continuation<? super Session> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AuthRepository$loginWithKey$2(this, str, null), continuation);
    }

    public final Object register(String str, String str2, String str3, String str4, String str5, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AuthRepository$register$2(this, str, str2, str3, str4, str5, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object verifyEmail(String str, String str2, Continuation<? super Session> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AuthRepository$verifyEmail$2(this, str, str2, null), continuation);
    }

    public final Object resendCode(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AuthRepository$resendCode$2(this, str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object resetRequest(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AuthRepository$resetRequest$2(this, str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object resetVerify(String str, String str2, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AuthRepository$resetVerify$2(this, str, str2, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object resetComplete(String str, String str2, String str3, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AuthRepository$resetComplete$2(this, str, str2, str3, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final String verificationRequired(ApiException e) {
        Object m7870constructorimpl;
        Object m7870constructorimpl2;
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter(e, "e");
        JsonElement field = ApiClient.INSTANCE.field(e.getPayload(), "verification_required");
        if (field == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            AuthRepository authRepository = this;
            m7870constructorimpl = Result.m7870constructorimpl(JsonElementKt.getJsonPrimitive(field).getContent());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7876isFailureimpl(m7870constructorimpl)) {
            m7870constructorimpl = null;
        }
        String str = (String) m7870constructorimpl;
        if (!Intrinsics.areEqual(str, DiskLruCache.VERSION) && !Intrinsics.areEqual(str, "true")) {
            return null;
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            AuthRepository authRepository2 = this;
            JsonElement field2 = ApiClient.INSTANCE.field(e.getPayload(), "email");
            m7870constructorimpl2 = Result.m7870constructorimpl((field2 == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(field2)) == null) ? null : jsonPrimitive.getContent());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            m7870constructorimpl2 = Result.m7870constructorimpl(ResultKt.createFailure(th2));
        }
        String str2 = (String) (Result.m7876isFailureimpl(m7870constructorimpl2) ? null : m7870constructorimpl2);
        return str2 == null ? "" : str2;
    }

    public final Object myDevices(Continuation<? super List<WorkerDevice>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AuthRepository$myDevices$2(this, null), continuation);
    }

    public final Object workerDevices(long j, Continuation<? super List<WorkerDevice>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AuthRepository$workerDevices$2(this, j, null), continuation);
    }

    public final Object revokeDevice(long j, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AuthRepository$revokeDevice$2(this, j, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
