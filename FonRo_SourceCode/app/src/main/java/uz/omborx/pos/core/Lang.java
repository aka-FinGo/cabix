package uz.FonRo.pos.core;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import uz.FonRo.pos.data.prefs.AppPrefs;

/* compiled from: Lang.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005J\u001c\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00162\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR+\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0016X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b$\u0012\b\b%\u0012\u0004\b\u0003\u0010\u0002¨\u0006#"}, d2 = {"Luz/FonRo/pos/core/Lang;", "", "<init>", "()V", "DEFAULT", "", "LANGUAGES", "", "Luz/FonRo/pos/core/OxLanguage;", "getLANGUAGES", "()Ljava/util/List;", "<set-?>", "code", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "code$delegate", "Landroidx/compose/runtime/MutableState;", "appContext", "Landroid/content/Context;", "dict", "", "load", "", "context", "prefs", "Luz/FonRo/pos/data/prefs/AppPrefs;", "apply", "value", "titleOf", "tr", FirebaseAnalytics.Param.SOURCE, "read", "unescape", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class Lang {
    public static final int $stable = 0;
    private static Context appContext;

    /* renamed from: code$delegate, reason: from kotlin metadata */
    private static final MutableState code;
    private static volatile Map<String, String> dict;
    public static final Lang INSTANCE = new Lang();
    public static final String DEFAULT = "ru";
    private static final List<OxLanguage> LANGUAGES = CollectionsKt.listOf((Object[]) new OxLanguage[]{new OxLanguage(DEFAULT, "Русский", "Русский"), new OxLanguage("uz", "O‘zbekcha", "Узбекский"), new OxLanguage("en", "English", "Английский"), new OxLanguage("kk", "Қазақша", "Казахский"), new OxLanguage("ky", "Кыргызча", "Киргизский"), new OxLanguage("tg", "Тоҷикӣ", "Таджикский")});

    private Lang() {
    }

    public final List<OxLanguage> getLANGUAGES() {
        return LANGUAGES;
    }

    static {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DEFAULT, null, 2, null);
        code = mutableStateOf$default;
        dict = MapsKt.emptyMap();
    }

    private final void setCode(String str) {
        code.setValue(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getCode() {
        return (String) code.getValue();
    }

    public final void load(Context context, AppPrefs prefs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        appContext = context.getApplicationContext();
        String lang = prefs.getLang();
        List<OxLanguage> list = LANGUAGES;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((OxLanguage) it.next()).getCode(), lang)) {
                    break;
                }
            }
        }
        lang = DEFAULT;
        dict = read(lang);
        setCode(lang);
    }

    public final void apply(AppPrefs prefs, String value) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, getCode())) {
            return;
        }
        List<OxLanguage> list = LANGUAGES;
        if ((list instanceof Collection) && list.isEmpty()) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((OxLanguage) it.next()).getCode(), value)) {
                prefs.setLang(value);
                dict = read(value);
                setCode(value);
                return;
            }
        }
    }

    public final String titleOf(String value) {
        Object obj;
        String title;
        Intrinsics.checkNotNullParameter(value, "value");
        Iterator<T> it = LANGUAGES.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((OxLanguage) obj).getCode(), value)) {
                break;
            }
        }
        OxLanguage oxLanguage = (OxLanguage) obj;
        return (oxLanguage == null || (title = oxLanguage.getTitle()) == null) ? ((OxLanguage) CollectionsKt.first((List) LANGUAGES)).getTitle() : title;
    }

    public final String tr(String source) {
        String str;
        Intrinsics.checkNotNullParameter(source, "source");
        return (Intrinsics.areEqual(getCode(), DEFAULT) || (str = dict.get(source)) == null) ? source : str;
    }

    private final Map<String, String> read(String value) {
        Context context;
        Object m7870constructorimpl;
        if (!Intrinsics.areEqual(value, DEFAULT) && (context = appContext) != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Lang lang = this;
                HashMap hashMap = new HashMap(2048);
                InputStream open = context.getAssets().open("lang/" + value + ".txt");
                Intrinsics.checkNotNullExpressionValue(open, "open(...)");
                Reader inputStreamReader = new InputStreamReader(open, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                BufferedReader bufferedReader2 = bufferedReader instanceof BufferedReader ? bufferedReader : new BufferedReader(bufferedReader, 8192);
                try {
                    Iterator<String> it = TextStreamsKt.lineSequence(bufferedReader2).iterator();
                    while (it.hasNext()) {
                        String removeSuffix = StringsKt.removeSuffix(StringsKt.removePrefix(it.next(), (CharSequence) "\ufeff"), (CharSequence) "\r");
                        int indexOf$default = StringsKt.indexOf$default((CharSequence) removeSuffix, '\t', 0, false, 6, (Object) null);
                        if (indexOf$default > 0) {
                            String substring = removeSuffix.substring(indexOf$default + 1);
                            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                            if (substring.length() > 0) {
                                String substring2 = removeSuffix.substring(0, indexOf$default);
                                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                                hashMap.put(unescape(substring2), unescape(substring));
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedReader2, null);
                    m7870constructorimpl = Result.m7870constructorimpl(hashMap);
                } finally {
                }
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
            }
            Map emptyMap = MapsKt.emptyMap();
            if (Result.m7876isFailureimpl(m7870constructorimpl)) {
                m7870constructorimpl = emptyMap;
            }
            return (Map) m7870constructorimpl;
        }
        return MapsKt.emptyMap();
    }

    private final String unescape(String value) {
        int i;
        int i2 = 0;
        if (!StringsKt.contains$default((CharSequence) value, AbstractJsonLexerKt.STRING_ESC, false, 2, (Object) null)) {
            return value;
        }
        StringBuilder sb = new StringBuilder(value.length());
        while (i2 < value.length()) {
            char charAt = value.charAt(i2);
            if (charAt == '\\' && (i = i2 + 1) < value.length()) {
                char charAt2 = value.charAt(i);
                if (charAt2 == '\\') {
                    sb.append(AbstractJsonLexerKt.STRING_ESC);
                } else if (charAt2 == 'n') {
                    sb.append('\n');
                } else if (charAt2 == 't') {
                    sb.append('\t');
                } else {
                    sb.append(charAt);
                    i2 = i;
                }
                i2 += 2;
            } else {
                sb.append(charAt);
                i2++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
