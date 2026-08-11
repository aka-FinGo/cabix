package uz.FonRo.pos.core;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import uz.FonRo.pos.data.prefs.AppPrefs;

/* compiled from: TextScale.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0006J\u0016\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R+\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eÊ\u0001\f\b \u0012\b\b!\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001f"}, d2 = {"Luz/FonRo/pos/core/TextScale;", "", "<init>", "()V", "STEPS", "", "", "getSTEPS", "()Ljava/util/List;", "DEFAULT", "", "<set-?>", "current", "getCurrent", "()F", "setCurrent", "(F)V", "current$delegate", "Landroidx/compose/runtime/MutableFloatState;", "value", "systemFontScale", "getSystemFontScale", "load", "", "prefs", "Luz/FonRo/pos/data/prefs/AppPrefs;", "systemScale", "indexOf", "apply", FirebaseAnalytics.Param.INDEX, "percent", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextScale {
    public static final int $stable = 0;
    public static final int DEFAULT = 4;
    public static final TextScale INSTANCE = new TextScale();
    private static final List<Float> STEPS;

    /* renamed from: current$delegate, reason: from kotlin metadata */
    private static final MutableFloatState current;
    private static float systemFontScale;

    private TextScale() {
    }

    static {
        List<Float> listOf = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(0.7f), Float.valueOf(0.775f), Float.valueOf(0.85f), Float.valueOf(0.925f), Float.valueOf(1.0f), Float.valueOf(1.075f), Float.valueOf(1.15f), Float.valueOf(1.225f), Float.valueOf(1.3f)});
        STEPS = listOf;
        current = PrimitiveSnapshotStateKt.mutableFloatStateOf(listOf.get(4).floatValue());
        systemFontScale = 1.0f;
    }

    public final List<Float> getSTEPS() {
        return STEPS;
    }

    private final void setCurrent(float f) {
        current.setFloatValue(f);
    }

    public final float getCurrent() {
        return current.getFloatValue();
    }

    public final float getSystemFontScale() {
        return systemFontScale;
    }

    public final void load(AppPrefs prefs, float systemScale) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        if (systemScale <= 0.0f) {
            systemScale = 1.0f;
        }
        systemFontScale = systemScale;
        setCurrent(STEPS.get(indexOf(prefs.getTextScale())).floatValue());
    }

    public final int indexOf(float value) {
        Iterator<Float> it = STEPS.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (Math.abs(it.next().floatValue() - value) < 1.0E-4f) {
                break;
            }
            i++;
        }
        if (i < 0) {
            return 4;
        }
        return i;
    }

    public final void apply(AppPrefs prefs, int index) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        List<Float> list = STEPS;
        int coerceIn = RangesKt.coerceIn(index, 0, CollectionsKt.getLastIndex(list));
        setCurrent(list.get(coerceIn).floatValue());
        prefs.setTextScale(list.get(coerceIn).floatValue());
    }

    public final int percent(float value) {
        return MathKt.roundToInt(value * 100.0f);
    }
}
