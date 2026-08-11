package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;

/* compiled from: FocusRestorer.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0007\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a\u000e\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\nH\u0000\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\nH\u0000\u001a\f\u0010\r\u001a\u00020\f*\u00020\nH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"PrevFocusedChild", "", "focusRestorer", "Landroidx/compose/ui/Modifier;", "onRestoreFailed", "Lkotlin/Function0;", "Landroidx/compose/ui/focus/FocusRequester;", "fallback", "pinFocusedChild", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "Landroidx/compose/ui/focus/FocusTargetNode;", "restoreFocusedChild", "", "saveFocusedChild", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class FocusRestorerKt {
    private static final String PrevFocusedChild = "previouslyFocusedChildHash";

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0043, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean saveFocusedChild(final androidx.compose.ui.focus.FocusTargetNode r11) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusRestorerKt.saveFocusedChild(androidx.compose.ui.focus.FocusTargetNode):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0067, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean restoreFocusedChild(androidx.compose.ui.focus.FocusTargetNode r11) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusRestorerKt.restoreFocusedChild(androidx.compose.ui.focus.FocusTargetNode):boolean");
    }

    public static final PinnableContainer.PinnedHandle pinFocusedChild(FocusTargetNode focusTargetNode) {
        PinnableContainer pinnableContainer;
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusTargetNode);
        if (findActiveFocusNode == null || (pinnableContainer = (PinnableContainer) CompositionLocalConsumerModifierNodeKt.currentValueOf(findActiveFocusNode, PinnableContainerKt.getLocalPinnableContainer())) == null) {
            return null;
        }
        return pinnableContainer.pin();
    }

    public static /* synthetic */ Modifier focusRestorer$default(Modifier modifier, FocusRequester focusRequester, int i, Object obj) {
        if ((i & 1) != 0) {
            focusRequester = FocusRequester.INSTANCE.getDefault();
        }
        return focusRestorer(modifier, focusRequester);
    }

    public static final Modifier focusRestorer(Modifier modifier, FocusRequester focusRequester) {
        return modifier.then(new FocusRestorerElement(focusRequester));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use focusRestorer(FocusRequester) instead", replaceWith = @ReplaceWith(expression = "this.focusRestorer(onRestoreFailed())", imports = {}))
    public static final Modifier focusRestorer(Modifier modifier, Function0<FocusRequester> function0) {
        FocusRequester focusRequester;
        if (function0 == null || (focusRequester = function0.invoke()) == null) {
            focusRequester = FocusRequester.INSTANCE.getDefault();
        }
        return focusRestorer(modifier, focusRequester);
    }
}
