package androidx.navigation;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: View.android.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"findNavController", "Landroidx/navigation/NavController;", "Landroid/view/View;", "navigation-runtime_release"}, k = 5, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE, xs = "androidx/navigation/ViewKt")
/* loaded from: classes5.dex */
final /* synthetic */ class ViewKt__View_androidKt {
    public static final NavController findNavController(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return Navigation.findNavController(view);
    }
}
