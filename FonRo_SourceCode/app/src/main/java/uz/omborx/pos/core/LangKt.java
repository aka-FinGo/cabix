package uz.FonRo.pos.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: Lang.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"tx", "", FirebaseAnalytics.Param.SOURCE, "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "app"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class LangKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final String tx(String source, Object... args) {
        String str;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(args, "args");
        String tr = Lang.INSTANCE.tr(source);
        if (args.length == 0) {
            return tr;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.ROOT;
            Object[] copyOf = Arrays.copyOf(args, args.length);
            String format = String.format(locale, tr, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            str = Result.m7870constructorimpl(format);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            str = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m7876isFailureimpl(str)) {
            tr = str;
        }
        return tr;
    }
}
