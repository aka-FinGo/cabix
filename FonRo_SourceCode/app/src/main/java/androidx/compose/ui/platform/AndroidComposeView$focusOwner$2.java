package androidx.compose.ui.platform;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.geometry.Rect;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidComposeView.android.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public /* synthetic */ class AndroidComposeView$focusOwner$2 extends FunctionReferenceImpl implements Function2<FocusDirection, Rect, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidComposeView$focusOwner$2(Object obj) {
        super(2, obj, AndroidComposeView.class, "onRequestFocusForOwner", "onRequestFocusForOwner-7o62pno(Landroidx/compose/ui/focus/FocusDirection;Landroidx/compose/ui/geometry/Rect;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke-7o62pno, reason: not valid java name and merged with bridge method [inline-methods] */
    public final Boolean invoke(FocusDirection focusDirection, Rect rect) {
        boolean m6100onRequestFocusForOwner7o62pno;
        m6100onRequestFocusForOwner7o62pno = ((AndroidComposeView) this.receiver).m6100onRequestFocusForOwner7o62pno(focusDirection, rect);
        return Boolean.valueOf(m6100onRequestFocusForOwner7o62pno);
    }
}
