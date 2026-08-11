package androidx.compose.foundation.contextmenu;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContextMenuGestures.android.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt", f = "ContextMenuGestures.android.kt", i = {0}, l = {71}, m = "awaitFirstRightClickDown", n = {"$this$awaitFirstRightClickDown"}, s = {"L$0"})
/* loaded from: classes.dex */
public final class ContextMenuGestures_androidKt$awaitFirstRightClickDown$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContextMenuGestures_androidKt$awaitFirstRightClickDown$1(Continuation<? super ContextMenuGestures_androidKt$awaitFirstRightClickDown$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object awaitFirstRightClickDown;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        awaitFirstRightClickDown = ContextMenuGestures_androidKt.awaitFirstRightClickDown(null, this);
        return awaitFirstRightClickDown;
    }
}
