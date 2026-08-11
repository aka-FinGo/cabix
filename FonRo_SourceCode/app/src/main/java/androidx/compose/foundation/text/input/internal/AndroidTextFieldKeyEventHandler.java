package androidx.compose.foundation.text.input.internal;

import android.view.InputDevice;
import android.view.KeyEvent;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: TextFieldKeyEventHandler.android.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JX\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J:\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/text/input/internal/AndroidTextFieldKeyEventHandler;", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "()V", "onKeyEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "clipboardKeyCommandsHandler", "Landroidx/compose/foundation/text/input/internal/ClipboardKeyCommandsHandler;", "editable", "singleLine", "onSubmit", "Lkotlin/Function0;", "", "onKeyEvent-CJ9ybgU", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function1;ZZLkotlin/jvm/functions/Function0;)Z", "onPreKeyEvent", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidTextFieldKeyEventHandler extends TextFieldKeyEventHandler {
    public static final int $stable = 0;

    @Override // androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler
    /* renamed from: onPreKeyEvent-MyFupTE, reason: not valid java name */
    public boolean mo1539onPreKeyEventMyFupTE(KeyEvent event, TransformedTextFieldState textFieldState, TextFieldSelectionState textFieldSelectionState, FocusManager focusManager, SoftwareKeyboardController keyboardController) {
        boolean m1613isKeyCodeYhN2O0w;
        boolean m1613isKeyCodeYhN2O0w2;
        boolean m1613isKeyCodeYhN2O0w3;
        boolean m1613isKeyCodeYhN2O0w4;
        boolean m1613isKeyCodeYhN2O0w5;
        if (super.mo1539onPreKeyEventMyFupTE(event, textFieldState, textFieldSelectionState, focusManager, keyboardController)) {
            return true;
        }
        InputDevice device = event.getDevice();
        if (device == null || !device.supportsSource(InputDeviceCompat.SOURCE_DPAD) || device.isVirtual() || !KeyEventType.m5456equalsimpl0(KeyEvent_androidKt.m5464getTypeZmokQxo(event), KeyEventType.INSTANCE.m5460getKeyDownCS__XNY()) || event.getSource() == 257) {
            return false;
        }
        m1613isKeyCodeYhN2O0w = TextFieldKeyEventHandler_androidKt.m1613isKeyCodeYhN2O0w(event, 19);
        if (m1613isKeyCodeYhN2O0w) {
            return focusManager.mo4022moveFocus3ESFkO8(FocusDirection.INSTANCE.m4020getUpdhqQ8s());
        }
        m1613isKeyCodeYhN2O0w2 = TextFieldKeyEventHandler_androidKt.m1613isKeyCodeYhN2O0w(event, 20);
        if (m1613isKeyCodeYhN2O0w2) {
            return focusManager.mo4022moveFocus3ESFkO8(FocusDirection.INSTANCE.m4013getDowndhqQ8s());
        }
        m1613isKeyCodeYhN2O0w3 = TextFieldKeyEventHandler_androidKt.m1613isKeyCodeYhN2O0w(event, 21);
        if (m1613isKeyCodeYhN2O0w3) {
            return focusManager.mo4022moveFocus3ESFkO8(FocusDirection.INSTANCE.m4016getLeftdhqQ8s());
        }
        m1613isKeyCodeYhN2O0w4 = TextFieldKeyEventHandler_androidKt.m1613isKeyCodeYhN2O0w(event, 22);
        if (m1613isKeyCodeYhN2O0w4) {
            return focusManager.mo4022moveFocus3ESFkO8(FocusDirection.INSTANCE.m4019getRightdhqQ8s());
        }
        m1613isKeyCodeYhN2O0w5 = TextFieldKeyEventHandler_androidKt.m1613isKeyCodeYhN2O0w(event, 23);
        if (!m1613isKeyCodeYhN2O0w5) {
            return false;
        }
        keyboardController.show();
        return true;
    }

    @Override // androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler
    /* renamed from: onKeyEvent-CJ9ybgU, reason: not valid java name */
    public boolean mo1538onKeyEventCJ9ybgU(KeyEvent event, TransformedTextFieldState textFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, Function1<? super KeyCommand, ? extends Unit> clipboardKeyCommandsHandler, boolean editable, boolean singleLine, Function0<Unit> onSubmit) {
        if (KeyEventType.m5456equalsimpl0(KeyEvent_androidKt.m5464getTypeZmokQxo(event), KeyEventType.INSTANCE.m5460getKeyDownCS__XNY()) && event.isFromSource(257) && !TextFieldKeyEventHandler_androidKt.m1612isFromSoftKeyboardZmokQxo(event)) {
            textFieldSelectionState.setInTouchMode(false);
        }
        return super.mo1538onKeyEventCJ9ybgU(event, textFieldState, textLayoutState, textFieldSelectionState, clipboardKeyCommandsHandler, editable, singleLine, onSubmit);
    }
}
