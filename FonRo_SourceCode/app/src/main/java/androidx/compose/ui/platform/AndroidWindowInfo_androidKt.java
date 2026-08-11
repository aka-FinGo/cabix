package androidx.compose.ui.platform;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Display;
import android.view.DisplayCutout;
import androidx.compose.ui.text.android.Paint29$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import uz.FonRo.pos.BuildConfig;

/* compiled from: AndroidWindowInfo.android.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0003\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0010*\u00020\fH\u0082\u0010¨\u0006\u0014"}, d2 = {"calculateWindowSize", "Landroidx/compose/ui/unit/IntSize;", "androidComposeView", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)J", "getCutoutForDisplay", "Landroid/view/DisplayCutout;", "display", "Landroid/view/Display;", "getNavigationBarHeight", "", "context", "Landroid/content/Context;", "getRectSizeFromDisplay", "", "activity", "Landroid/app/Activity;", "bounds", "Landroid/graphics/Rect;", "findActivity", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class AndroidWindowInfo_androidKt {
    public static final /* synthetic */ DisplayCutout access$getCutoutForDisplay(Display display) {
        return getCutoutForDisplay(display);
    }

    public static final /* synthetic */ int access$getNavigationBarHeight(Context context) {
        return getNavigationBarHeight(context);
    }

    public static final /* synthetic */ void access$getRectSizeFromDisplay(Activity activity, Rect rect) {
        getRectSizeFromDisplay(activity, rect);
    }

    public static final long calculateWindowSize(AndroidComposeView androidComposeView) {
        Context context = androidComposeView.getContext();
        Activity findActivity = findActivity(context);
        if (findActivity != null) {
            Rect currentWindowBounds = BoundsHelper.INSTANCE.getInstance().currentWindowBounds(findActivity);
            return IntSize.m7155constructorimpl((currentWindowBounds.height() & 4294967295L) | (currentWindowBounds.width() << 32));
        }
        Configuration configuration = context.getResources().getConfiguration();
        return IntSize.m7155constructorimpl((Math.round(configuration.screenHeightDp * r7) & 4294967295L) | (Math.round(configuration.screenWidthDp * context.getResources().getDisplayMetrics().density) << 32));
    }

    private static final Activity findActivity(Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (Activity) context;
    }

    public static final int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", BuildConfig.API_CLIENT);
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static final void getRectSizeFromDisplay(Activity activity, Rect rect) {
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
    }

    public static final DisplayCutout getCutoutForDisplay(Display display) {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(null);
            constructor.setAccessible(true);
            Object newInstance = constructor.newInstance(null);
            Method declaredMethod = display.getClass().getDeclaredMethod("getDisplayInfo", newInstance.getClass());
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(display, newInstance);
            Field declaredField = newInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(newInstance);
            if (Paint29$$ExternalSyntheticApiModelOutline0.m6491m(obj)) {
                return Paint29$$ExternalSyntheticApiModelOutline0.m6483m(obj);
            }
        } catch (Exception e) {
            if (!(e instanceof ClassNotFoundException ? true : e instanceof NoSuchMethodException ? true : e instanceof NoSuchFieldException ? true : e instanceof IllegalAccessException ? true : e instanceof InvocationTargetException ? true : e instanceof InstantiationException)) {
                throw e;
            }
        }
        return null;
    }
}
