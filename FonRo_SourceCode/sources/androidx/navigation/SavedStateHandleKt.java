package androidx.navigation;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.SavedStateHandle;
import java.util.Map;
import kotlin.Metadata;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: SavedStateHandle.kt */
@Metadata(d1 = {"androidx/navigation/SavedStateHandleKt__SavedStateHandleKt"}, k = 4, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class SavedStateHandleKt {
    public static final /* synthetic */ <T> T toRoute(SavedStateHandle savedStateHandle, Map<KType, NavType<?>> map) {
        return (T) SavedStateHandleKt__SavedStateHandleKt.toRoute(savedStateHandle, map);
    }

    public static final <T> T toRoute(SavedStateHandle savedStateHandle, KClass<T> kClass, Map<KType, NavType<?>> map) {
        return (T) SavedStateHandleKt__SavedStateHandleKt.toRoute(savedStateHandle, kClass, map);
    }
}
