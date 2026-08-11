package uz.FonRo.pos.data.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.net.HttpHeaders;
import com.jakewharton.retrofit2.converter.kotlinx.serialization.KotlinSerializationConverterFactory;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import uz.FonRo.pos.BuildConfig;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.UpdateGate;
import uz.FonRo.pos.data.prefs.AppPrefs;

/* compiled from: ApiClient.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u001a\u001a\u00020\u000bJ\b\u0010\u001b\u001a\u00020\u000bH\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ3\u0010\u001e\u001a\u0002H\u001f\"\b\b\u0000\u0010\u001f*\u00020\u00012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001f0\"0!2\b\b\u0002\u0010#\u001a\u00020\u001d¢\u0006\u0002\u0010$J$\u0010%\u001a\u00020\u00112\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\"0!2\b\b\u0002\u0010#\u001a\u00020\u001dJ&\u0010'\u001a\u0004\u0018\u00010&2\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\"0!2\b\b\u0002\u0010#\u001a\u00020\u001dJ\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/J\u001a\u00100\u001a\u0004\u0018\u00010&2\b\u00101\u001a\u0004\u0018\u00010&2\u0006\u00102\u001a\u00020)R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019Ê\u0001\f\b4\u0012\b\b5\u0012\u0004\b\u0003\u0010\u0002¨\u00063"}, d2 = {"Luz/FonRo/pos/data/net/ApiClient;", "", "<init>", "()V", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "TIMEOUT_SECONDS", "", NotificationCompat.CATEGORY_SERVICE, "Luz/FonRo/pos/data/net/ApiService;", "appContext", "Landroid/content/Context;", "prefs", "Luz/FonRo/pos/data/prefs/AppPrefs;", "init", "", "context", "appPrefs", "onUnauthorized", "Lkotlin/Function0;", "getOnUnauthorized", "()Lkotlin/jvm/functions/Function0;", "setOnUnauthorized", "(Lkotlin/jvm/functions/Function0;)V", "api", "build", "isOnline", "", "unwrap", ExifInterface.GPS_DIRECTION_TRUE, "response", "Lretrofit2/Response;", "Luz/FonRo/pos/data/net/ApiEnvelope;", "silent401", "(Lretrofit2/Response;Z)Ljava/lang/Object;", "unwrapVoid", "Lkotlinx/serialization/json/JsonElement;", "unwrapRaw", "defaultMessage", "", "code", "", "asApiError", "Luz/FonRo/pos/data/net/ApiException;", "t", "", "field", "payload", "name", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes6.dex */
public final class ApiClient {
    public static final int $stable = 0;
    private static final long TIMEOUT_SECONDS = 25;
    private static volatile Context appContext;
    private static volatile Function0<Unit> onUnauthorized;
    private static volatile AppPrefs prefs;
    private static volatile ApiService service;
    public static final ApiClient INSTANCE = new ApiClient();
    private static final Json json = JsonKt.Json$default(null, new Function1() { // from class: uz.FonRo.pos.data.net.ApiClient$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return ApiClient.json$lambda$0((JsonBuilder) obj);
        }
    }, 1, null);

    private ApiClient() {
    }

    public final Json getJson() {
        return json;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit json$lambda$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        Json.setCoerceInputValues(true);
        Json.setLenient(true);
        Json.setExplicitNulls(false);
        Json.setEncodeDefaults(true);
        return Unit.INSTANCE;
    }

    public final void init(Context context, AppPrefs appPrefs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appPrefs, "appPrefs");
        appContext = context.getApplicationContext();
        prefs = appPrefs;
    }

    public final Function0<Unit> getOnUnauthorized() {
        return onUnauthorized;
    }

    public final void setOnUnauthorized(Function0<Unit> function0) {
        onUnauthorized = function0;
    }

    public final ApiService api() {
        ApiService apiService;
        ApiService apiService2 = service;
        if (apiService2 != null) {
            return apiService2;
        }
        synchronized (this) {
            apiService = service;
            if (apiService == null) {
                apiService = INSTANCE.build();
                service = apiService;
            }
        }
        return apiService;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ApiService build() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, 0 == true ? 1 : 0);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
        Object create = new Retrofit.Builder().baseUrl(StringsKt.trimEnd(BuildConfig.API_BASE, '/') + "/").client(new OkHttpClient.Builder().connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS).readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS).writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS).retryOnConnectionFailure(true).addInterceptor(new Interceptor() { // from class: uz.FonRo.pos.data.net.ApiClient$$ExternalSyntheticLambda0
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return ApiClient.build$lambda$1(chain);
            }
        }).addInterceptor(httpLoggingInterceptor).build()).addConverterFactory(KotlinSerializationConverterFactory.create(json, MediaType.INSTANCE.get("application/json"))).build().create(ApiService.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (ApiService) create;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Response build$lambda$1(Interceptor.Chain chain) {
        String token;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder header = chain.request().newBuilder().header(HttpHeaders.CONTENT_TYPE, "application/json").header(HttpHeaders.ACCEPT, "application/json").header("X-Client", BuildConfig.API_CLIENT).header("X-App-Version", BuildConfig.VERSION_NAME);
        AppPrefs appPrefs = prefs;
        if (appPrefs != null && (token = appPrefs.getToken()) != null) {
            if (StringsKt.isBlank(token)) {
                token = null;
            }
            if (token != null) {
                header.header("X-API-Token", token);
            }
        }
        Response proceed = chain.proceed(header.build());
        if (proceed.code() == 426) {
            UpdateGate.INSTANCE.require();
        }
        return proceed;
    }

    public final boolean isOnline() {
        NetworkCapabilities networkCapabilities;
        Context context = appContext;
        Object systemService = context != null ? context.getSystemService("connectivity") : null;
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            return true;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasCapability(12);
    }

    public static /* synthetic */ Object unwrap$default(ApiClient apiClient, retrofit2.Response response, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return apiClient.unwrap(response, z);
    }

    public final <T> T unwrap(retrofit2.Response<ApiEnvelope<T>> response, boolean silent401) {
        String defaultMessage;
        Function0<Unit> function0;
        Object m7870constructorimpl;
        RawEnvelope rawEnvelope;
        String defaultMessage2;
        Function0<Unit> function02;
        Intrinsics.checkNotNullParameter(response, "response");
        if (!response.isSuccessful()) {
            ResponseBody errorBody = response.errorBody();
            String string = errorBody != null ? errorBody.string() : null;
            if (string != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Json json2 = json;
                    json2.getSerializersModule();
                    m7870constructorimpl = Result.m7870constructorimpl((RawEnvelope) json2.decodeFromString(RawEnvelope.INSTANCE.serializer(), string));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m7876isFailureimpl(m7870constructorimpl)) {
                    m7870constructorimpl = null;
                }
                rawEnvelope = (RawEnvelope) m7870constructorimpl;
            } else {
                rawEnvelope = null;
            }
            if (response.code() == 401 && !silent401 && (function02 = onUnauthorized) != null) {
                function02.invoke();
            }
            int code = response.code();
            if (rawEnvelope == null || (defaultMessage2 = rawEnvelope.getMessage()) == null) {
                defaultMessage2 = defaultMessage(response.code());
            }
            throw new ApiException(code, defaultMessage2, rawEnvelope != null ? rawEnvelope.getData() : null, false, 8, null);
        }
        ApiEnvelope<T> body = response.body();
        if (body == null || !body.getSuccess()) {
            if (response.code() == 401 && !silent401 && (function0 = onUnauthorized) != null) {
                function0.invoke();
            }
            int code2 = response.code();
            if (body == null || (defaultMessage = body.getMessage()) == null) {
                defaultMessage = defaultMessage(response.code());
            }
            throw new ApiException(code2, defaultMessage, null, false, 12, null);
        }
        T data = body.getData();
        if (data != null) {
            return data;
        }
        throw new ApiException(response.code(), LangKt.tx("Пустой ответ сервера", new Object[0]), null, false, 12, null);
    }

    public static /* synthetic */ void unwrapVoid$default(ApiClient apiClient, retrofit2.Response response, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        apiClient.unwrapVoid(response, z);
    }

    public final void unwrapVoid(retrofit2.Response<ApiEnvelope<JsonElement>> response, boolean silent401) {
        String defaultMessage;
        Function0<Unit> function0;
        Object m7870constructorimpl;
        RawEnvelope rawEnvelope;
        String defaultMessage2;
        Function0<Unit> function02;
        Intrinsics.checkNotNullParameter(response, "response");
        if (!response.isSuccessful()) {
            ResponseBody errorBody = response.errorBody();
            String string = errorBody != null ? errorBody.string() : null;
            if (string != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Json json2 = json;
                    json2.getSerializersModule();
                    m7870constructorimpl = Result.m7870constructorimpl((RawEnvelope) json2.decodeFromString(RawEnvelope.INSTANCE.serializer(), string));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m7876isFailureimpl(m7870constructorimpl)) {
                    m7870constructorimpl = null;
                }
                rawEnvelope = (RawEnvelope) m7870constructorimpl;
            } else {
                rawEnvelope = null;
            }
            if (response.code() == 401 && !silent401 && (function02 = onUnauthorized) != null) {
                function02.invoke();
            }
            int code = response.code();
            if (rawEnvelope == null || (defaultMessage2 = rawEnvelope.getMessage()) == null) {
                defaultMessage2 = defaultMessage(response.code());
            }
            throw new ApiException(code, defaultMessage2, rawEnvelope != null ? rawEnvelope.getData() : null, false, 8, null);
        }
        ApiEnvelope<JsonElement> body = response.body();
        if (body == null || !body.getSuccess()) {
            if (response.code() == 401 && !silent401 && (function0 = onUnauthorized) != null) {
                function0.invoke();
            }
            int code2 = response.code();
            if (body == null || (defaultMessage = body.getMessage()) == null) {
                defaultMessage = defaultMessage(response.code());
            }
            throw new ApiException(code2, defaultMessage, null, false, 12, null);
        }
    }

    public static /* synthetic */ JsonElement unwrapRaw$default(ApiClient apiClient, retrofit2.Response response, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return apiClient.unwrapRaw(response, z);
    }

    public final JsonElement unwrapRaw(retrofit2.Response<ApiEnvelope<JsonElement>> response, boolean silent401) {
        String defaultMessage;
        Function0<Unit> function0;
        Object m7870constructorimpl;
        RawEnvelope rawEnvelope;
        String defaultMessage2;
        Function0<Unit> function02;
        Intrinsics.checkNotNullParameter(response, "response");
        if (!response.isSuccessful()) {
            ResponseBody errorBody = response.errorBody();
            String string = errorBody != null ? errorBody.string() : null;
            if (string != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Json json2 = json;
                    json2.getSerializersModule();
                    m7870constructorimpl = Result.m7870constructorimpl((RawEnvelope) json2.decodeFromString(RawEnvelope.INSTANCE.serializer(), string));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m7876isFailureimpl(m7870constructorimpl)) {
                    m7870constructorimpl = null;
                }
                rawEnvelope = (RawEnvelope) m7870constructorimpl;
            } else {
                rawEnvelope = null;
            }
            if (response.code() == 401 && !silent401 && (function02 = onUnauthorized) != null) {
                function02.invoke();
            }
            int code = response.code();
            if (rawEnvelope == null || (defaultMessage2 = rawEnvelope.getMessage()) == null) {
                defaultMessage2 = defaultMessage(response.code());
            }
            throw new ApiException(code, defaultMessage2, rawEnvelope != null ? rawEnvelope.getData() : null, false, 8, null);
        }
        ApiEnvelope<JsonElement> body = response.body();
        if (body == null || !body.getSuccess()) {
            if (response.code() == 401 && !silent401 && (function0 = onUnauthorized) != null) {
                function0.invoke();
            }
            int code2 = response.code();
            if (body == null || (defaultMessage = body.getMessage()) == null) {
                defaultMessage = defaultMessage(response.code());
            }
            throw new ApiException(code2, defaultMessage, null, false, 12, null);
        }
        return body.getData();
    }

    private final String defaultMessage(int code) {
        if (code == 401) {
            return LangKt.tx("Сессия истекла. Войдите заново.", new Object[0]);
        }
        if (code == 402) {
            return LangKt.tx("Требуется подписка.", new Object[0]);
        }
        if (code == 403) {
            return LangKt.tx("Нет доступа.", new Object[0]);
        }
        if (code == 404) {
            return LangKt.tx("Ничего не найдено.", new Object[0]);
        }
        if (500 <= code && code < 600) {
            return LangKt.tx("Сервер временно недоступен. Попробуйте ещё раз.", new Object[0]);
        }
        return LangKt.tx("Ошибка сервера (%s)", Integer.valueOf(code));
    }

    public final ApiException asApiError(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        if (t instanceof ApiException) {
            return (ApiException) t;
        }
        if (t instanceof SocketTimeoutException) {
            return new ApiException(0, LangKt.tx("Сервер не отвечает. Попробуйте ещё раз.", new Object[0]), null, true, 4, null);
        }
        if ((t instanceof UnknownHostException) || (t instanceof IOException)) {
            return new ApiException(0, LangKt.tx("Нет соединения с сервером. Проверьте интернет.", new Object[0]), null, true, 4, null);
        }
        String message = t.getMessage();
        if (message == null) {
            message = LangKt.tx("Неизвестная ошибка", new Object[0]);
        }
        return new ApiException(0, message, null, false, 12, null);
    }

    public final JsonElement field(JsonElement payload, String name) {
        Object m7870constructorimpl;
        JsonObject jsonObject;
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            Result.Companion companion = Result.INSTANCE;
            ApiClient apiClient = this;
            m7870constructorimpl = Result.m7870constructorimpl((payload == null || (jsonObject = JsonElementKt.getJsonObject(payload)) == null) ? null : (JsonElement) jsonObject.get((Object) name));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        return (JsonElement) (Result.m7876isFailureimpl(m7870constructorimpl) ? null : m7870constructorimpl);
    }
}
