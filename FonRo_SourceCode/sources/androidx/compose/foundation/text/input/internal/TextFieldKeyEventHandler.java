package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.compose.foundation.text.DeadKeyCombiner;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyEventHelpers_androidKt;
import androidx.compose.foundation.text.KeyMapping;
import androidx.compose.foundation.text.KeyMapping_androidKt;
import androidx.compose.foundation.text.StringHelpers_jvmKt;
import androidx.compose.foundation.text.TextFieldKeyInput_androidKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.TextRange;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: TextFieldKeyEventHandler.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JX\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ:\u0010\u001e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\b#\u0010$J:\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\f2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001b0)¢\u0006\u0002\b+H\u0082\bJP\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\f\u0010/\u001a\u000200*\u00020\u0012H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "", "()V", "currentlyConsumedDownKeys", "Landroidx/collection/MutableLongSet;", "deadKeyCombiner", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "keyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "preparedSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "onKeyEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "clipboardKeyCommandsHandler", "Landroidx/compose/foundation/text/input/internal/ClipboardKeyCommandsHandler;", "editable", "singleLine", "onSubmit", "Lkotlin/Function0;", "", "onKeyEvent-CJ9ybgU", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function1;ZZLkotlin/jvm/functions/Function0;)Z", "onPreKeyEvent", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "preparedSelectionContext", "state", "isFromSoftKeyboard", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelection;", "Lkotlin/ExtensionFunctionType;", "processKeyDownEvent", "processKeyDownEvent-ZcWbMB8", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Lkotlin/jvm/functions/Function1;ZZLkotlin/jvm/functions/Function0;)Z", "getVisibleTextLayoutHeight", "", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class TextFieldKeyEventHandler {
    public static final int $stable = 8;
    private MutableLongSet currentlyConsumedDownKeys;
    private final TextFieldPreparedSelectionState preparedSelectionState = new TextFieldPreparedSelectionState();
    private final DeadKeyCombiner deadKeyCombiner = new DeadKeyCombiner();
    private final KeyMapping keyMapping = KeyMapping_androidKt.getPlatformDefaultKeyMapping();

    /* compiled from: TextFieldKeyEventHandler.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KeyCommand.values().length];
            try {
                iArr[KeyCommand.COPY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KeyCommand.PASTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KeyCommand.CUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KeyCommand.LEFT_CHAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[KeyCommand.RIGHT_CHAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[KeyCommand.LEFT_WORD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[KeyCommand.RIGHT_WORD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[KeyCommand.PREV_PARAGRAPH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[KeyCommand.NEXT_PARAGRAPH.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[KeyCommand.UP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[KeyCommand.DOWN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[KeyCommand.PAGE_UP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[KeyCommand.PAGE_DOWN.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[KeyCommand.LINE_START.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[KeyCommand.LINE_END.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[KeyCommand.LINE_LEFT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[KeyCommand.LINE_RIGHT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[KeyCommand.HOME.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[KeyCommand.END.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[KeyCommand.DELETE_PREV_CHAR.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[KeyCommand.DELETE_NEXT_CHAR.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[KeyCommand.DELETE_PREV_WORD.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[KeyCommand.DELETE_NEXT_WORD.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[KeyCommand.DELETE_FROM_LINE_START.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[KeyCommand.DELETE_TO_LINE_END.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[KeyCommand.NEW_LINE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[KeyCommand.TAB.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[KeyCommand.SELECT_ALL.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[KeyCommand.SELECT_LEFT_CHAR.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[KeyCommand.SELECT_RIGHT_CHAR.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[KeyCommand.SELECT_LEFT_WORD.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[KeyCommand.SELECT_RIGHT_WORD.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[KeyCommand.SELECT_PREV_PARAGRAPH.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[KeyCommand.SELECT_NEXT_PARAGRAPH.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_START.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_END.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_LEFT.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_RIGHT.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[KeyCommand.SELECT_UP.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[KeyCommand.SELECT_DOWN.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[KeyCommand.SELECT_PAGE_UP.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[KeyCommand.SELECT_PAGE_DOWN.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[KeyCommand.SELECT_HOME.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[KeyCommand.SELECT_END.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[KeyCommand.DESELECT.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[KeyCommand.UNDO.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr[KeyCommand.REDO.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr[KeyCommand.CHARACTER_PALETTE.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: onPreKeyEvent-MyFupTE */
    public boolean mo1539onPreKeyEventMyFupTE(KeyEvent event, TransformedTextFieldState textFieldState, TextFieldSelectionState textFieldSelectionState, FocusManager focusManager, SoftwareKeyboardController keyboardController) {
        if (TextRange.m6429getCollapsedimpl(textFieldState.getVisualText().getSelection()) || !KeyEventHelpers_androidKt.m1374cancelsTextSelectionZmokQxo(event)) {
            return false;
        }
        textFieldSelectionState.deselect();
        return true;
    }

    /* renamed from: onKeyEvent-CJ9ybgU */
    public boolean mo1538onKeyEventCJ9ybgU(KeyEvent event, TransformedTextFieldState textFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, Function1<? super KeyCommand, ? extends Unit> clipboardKeyCommandsHandler, boolean editable, boolean singleLine, Function0<Unit> onSubmit) {
        long m5463getKeyZmokQxo = KeyEvent_androidKt.m5463getKeyZmokQxo(event);
        if (KeyEventType.m5456equalsimpl0(KeyEvent_androidKt.m5464getTypeZmokQxo(event), KeyEventType.INSTANCE.m5461getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet = this.currentlyConsumedDownKeys;
            if (mutableLongSet == null || !mutableLongSet.contains(m5463getKeyZmokQxo)) {
                return false;
            }
            MutableLongSet mutableLongSet2 = this.currentlyConsumedDownKeys;
            if (mutableLongSet2 != null) {
                mutableLongSet2.remove(m5463getKeyZmokQxo);
            }
            return true;
        }
        if (KeyEventType.m5456equalsimpl0(KeyEvent_androidKt.m5464getTypeZmokQxo(event), KeyEventType.INSTANCE.m5462getUnknownCS__XNY()) && !TextFieldKeyInput_androidKt.m1476isTypedEventZmokQxo(event)) {
            return false;
        }
        boolean m1610processKeyDownEventZcWbMB8 = m1610processKeyDownEventZcWbMB8(event, textFieldState, textLayoutState, clipboardKeyCommandsHandler, editable, singleLine, onSubmit);
        if (m1610processKeyDownEventZcWbMB8) {
            MutableLongSet mutableLongSet3 = this.currentlyConsumedDownKeys;
            if (mutableLongSet3 == null) {
                mutableLongSet3 = new MutableLongSet(3);
                this.currentlyConsumedDownKeys = mutableLongSet3;
            }
            mutableLongSet3.plusAssign(m5463getKeyZmokQxo);
        }
        return m1610processKeyDownEventZcWbMB8;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: processKeyDownEvent-ZcWbMB8, reason: not valid java name */
    private final boolean m1610processKeyDownEventZcWbMB8(KeyEvent event, TransformedTextFieldState textFieldState, TextLayoutState textLayoutState, Function1<? super KeyCommand, ? extends Unit> clipboardKeyCommandsHandler, boolean editable, boolean singleLine, Function0<Unit> onSubmit) {
        WedgeAffinity wedgeAffinity;
        Integer m1373consumeZmokQxo;
        boolean z = false;
        if (TextFieldKeyInput_androidKt.m1476isTypedEventZmokQxo(event) && (m1373consumeZmokQxo = this.deadKeyCombiner.m1373consumeZmokQxo(event)) != null) {
            String sb = StringHelpers_jvmKt.appendCodePointX(new StringBuilder(2), m1373consumeZmokQxo.intValue()).toString();
            if (!editable) {
                return false;
            }
            TransformedTextFieldState.replaceSelectedText$default(textFieldState, sb, true, null, !TextFieldKeyEventHandler_androidKt.m1612isFromSoftKeyboardZmokQxo(event), 4, null);
            this.preparedSelectionState.resetCachedX();
            return true;
        }
        KeyCommand mo1375mapZmokQxo = this.keyMapping.mo1375mapZmokQxo(event);
        if (mo1375mapZmokQxo != null && (!mo1375mapZmokQxo.getEditsText() || editable)) {
            TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(textFieldState, textLayoutState.getLayoutResult(), TextFieldKeyEventHandler_androidKt.m1612isFromSoftKeyboardZmokQxo(event), getVisibleTextLayoutHeight(textLayoutState), this.preparedSelectionState);
            switch (WhenMappings.$EnumSwitchMapping$0[mo1375mapZmokQxo.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    clipboardKeyCommandsHandler.invoke(mo1375mapZmokQxo);
                    z = true;
                    break;
                case 4:
                    textFieldPreparedSelection.collapseLeftOr(new Function1<TextFieldPreparedSelection, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler$processKeyDownEvent$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                            invoke2(textFieldPreparedSelection2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldPreparedSelection textFieldPreparedSelection2) {
                            textFieldPreparedSelection2.moveCursorLeftByChar();
                        }
                    });
                    z = true;
                    break;
                case 5:
                    textFieldPreparedSelection.collapseRightOr(new Function1<TextFieldPreparedSelection, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler$processKeyDownEvent$1$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                            invoke2(textFieldPreparedSelection2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldPreparedSelection textFieldPreparedSelection2) {
                            textFieldPreparedSelection2.moveCursorRightByChar();
                        }
                    });
                    z = true;
                    break;
                case 6:
                    textFieldPreparedSelection.moveCursorLeftByWord();
                    z = true;
                    break;
                case 7:
                    textFieldPreparedSelection.moveCursorRightByWord();
                    z = true;
                    break;
                case 8:
                    textFieldPreparedSelection.moveCursorPrevByParagraph();
                    z = true;
                    break;
                case 9:
                    textFieldPreparedSelection.moveCursorNextByParagraph();
                    z = true;
                    break;
                case 10:
                    textFieldPreparedSelection.moveCursorUpByLine();
                    z = true;
                    break;
                case 11:
                    textFieldPreparedSelection.moveCursorDownByLine();
                    z = true;
                    break;
                case 12:
                    textFieldPreparedSelection.moveCursorUpByPage();
                    z = true;
                    break;
                case 13:
                    textFieldPreparedSelection.moveCursorDownByPage();
                    z = true;
                    break;
                case 14:
                    textFieldPreparedSelection.moveCursorToLineStart();
                    z = true;
                    break;
                case 15:
                    textFieldPreparedSelection.moveCursorToLineEnd();
                    z = true;
                    break;
                case 16:
                    textFieldPreparedSelection.moveCursorToLineLeftSide();
                    z = true;
                    break;
                case 17:
                    textFieldPreparedSelection.moveCursorToLineRightSide();
                    z = true;
                    break;
                case 18:
                    textFieldPreparedSelection.moveCursorToHome();
                    z = true;
                    break;
                case 19:
                    textFieldPreparedSelection.moveCursorToEnd();
                    z = true;
                    break;
                case 20:
                    textFieldPreparedSelection.moveCursorPrevByChar().deleteMovement();
                    z = true;
                    break;
                case 21:
                    textFieldPreparedSelection.moveCursorNextByChar().deleteMovement();
                    z = true;
                    break;
                case 22:
                    textFieldPreparedSelection.moveCursorPrevByWord().deleteMovement();
                    z = true;
                    break;
                case 23:
                    textFieldPreparedSelection.moveCursorNextByWord().deleteMovement();
                    z = true;
                    break;
                case 24:
                    textFieldPreparedSelection.moveCursorToLineStart().deleteMovement();
                    z = true;
                    break;
                case 25:
                    textFieldPreparedSelection.moveCursorToLineEnd().deleteMovement();
                    z = true;
                    break;
                case 26:
                    if (!singleLine) {
                        TransformedTextFieldState.replaceSelectedText$default(textFieldState, "\n", true, null, !TextFieldKeyEventHandler_androidKt.m1612isFromSoftKeyboardZmokQxo(event), 4, null);
                    } else {
                        onSubmit.invoke();
                    }
                    z = true;
                    break;
                case 27:
                    if (!singleLine) {
                        TransformedTextFieldState.replaceSelectedText$default(textFieldState, "\t", true, null, !TextFieldKeyEventHandler_androidKt.m1612isFromSoftKeyboardZmokQxo(event), 4, null);
                        z = true;
                        break;
                    }
                    break;
                case 28:
                    textFieldPreparedSelection.selectAll();
                    z = true;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                    textFieldPreparedSelection.moveCursorLeftByChar().selectMovement();
                    z = true;
                    break;
                case 30:
                    textFieldPreparedSelection.moveCursorRightByChar().selectMovement();
                    z = true;
                    break;
                case 31:
                    textFieldPreparedSelection.moveCursorLeftByWord().selectMovement();
                    z = true;
                    break;
                case 32:
                    textFieldPreparedSelection.moveCursorRightByWord().selectMovement();
                    z = true;
                    break;
                case 33:
                    textFieldPreparedSelection.moveCursorPrevByParagraph().selectMovement();
                    z = true;
                    break;
                case 34:
                    textFieldPreparedSelection.moveCursorNextByParagraph().selectMovement();
                    z = true;
                    break;
                case 35:
                    textFieldPreparedSelection.moveCursorToLineStart().selectMovement();
                    z = true;
                    break;
                case 36:
                    textFieldPreparedSelection.moveCursorToLineEnd().selectMovement();
                    z = true;
                    break;
                case 37:
                    textFieldPreparedSelection.moveCursorToLineLeftSide().selectMovement();
                    z = true;
                    break;
                case 38:
                    textFieldPreparedSelection.moveCursorToLineRightSide().selectMovement();
                    z = true;
                    break;
                case 39:
                    textFieldPreparedSelection.moveCursorUpByLine().selectMovement();
                    z = true;
                    break;
                case 40:
                    textFieldPreparedSelection.moveCursorDownByLine().selectMovement();
                    z = true;
                    break;
                case 41:
                    textFieldPreparedSelection.moveCursorUpByPage().selectMovement();
                    z = true;
                    break;
                case 42:
                    textFieldPreparedSelection.moveCursorDownByPage().selectMovement();
                    z = true;
                    break;
                case 43:
                    textFieldPreparedSelection.moveCursorToHome().selectMovement();
                    z = true;
                    break;
                case 44:
                    textFieldPreparedSelection.moveCursorToEnd().selectMovement();
                    z = true;
                    break;
                case 45:
                    textFieldPreparedSelection.deselect();
                    z = true;
                    break;
                case 46:
                    textFieldState.undo();
                    z = true;
                    break;
                case 47:
                    textFieldState.redo();
                    z = true;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    KeyEventHelpers_androidKt.showCharacterPalette();
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            if (!TextRange.m6428equalsimpl0(textFieldPreparedSelection.getSelection(), textFieldPreparedSelection.getInitialValue().getSelection())) {
                textFieldState.m1640selectCharsIn5zctL8(textFieldPreparedSelection.getSelection());
            }
            if (textFieldPreparedSelection.getWedgeAffinity() != null && (wedgeAffinity = textFieldPreparedSelection.getWedgeAffinity()) != null) {
                if (TextRange.m6429getCollapsedimpl(textFieldState.getUntransformedText().getSelection())) {
                    textFieldState.setSelectionWedgeAffinity(new SelectionWedgeAffinity(wedgeAffinity));
                    return z;
                }
                textFieldState.setSelectionWedgeAffinity(SelectionWedgeAffinity.copy$default(textFieldPreparedSelection.getInitialWedgeAffinity(), null, wedgeAffinity, 1, null));
            }
        }
        return z;
    }

    private final void preparedSelectionContext(TransformedTextFieldState state, TextLayoutState textLayoutState, boolean isFromSoftKeyboard, Function1<? super TextFieldPreparedSelection, Unit> block) {
        WedgeAffinity wedgeAffinity;
        TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(state, textLayoutState.getLayoutResult(), isFromSoftKeyboard, getVisibleTextLayoutHeight(textLayoutState), this.preparedSelectionState);
        block.invoke(textFieldPreparedSelection);
        if (!TextRange.m6428equalsimpl0(textFieldPreparedSelection.getSelection(), textFieldPreparedSelection.getInitialValue().getSelection())) {
            state.m1640selectCharsIn5zctL8(textFieldPreparedSelection.getSelection());
        }
        if (textFieldPreparedSelection.getWedgeAffinity() == null || (wedgeAffinity = textFieldPreparedSelection.getWedgeAffinity()) == null) {
            return;
        }
        if (TextRange.m6429getCollapsedimpl(state.getUntransformedText().getSelection())) {
            state.setSelectionWedgeAffinity(new SelectionWedgeAffinity(wedgeAffinity));
        } else {
            state.setSelectionWedgeAffinity(SelectionWedgeAffinity.copy$default(textFieldPreparedSelection.getInitialWedgeAffinity(), null, wedgeAffinity, 1, null));
        }
    }

    private final float getVisibleTextLayoutHeight(TextLayoutState textLayoutState) {
        LayoutCoordinates textLayoutNodeCoordinates = textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates == null) {
            return Float.NaN;
        }
        Rect rect = null;
        if (!textLayoutNodeCoordinates.isAttached()) {
            textLayoutNodeCoordinates = null;
        }
        if (textLayoutNodeCoordinates == null) {
            return Float.NaN;
        }
        LayoutCoordinates decoratorNodeCoordinates = textLayoutState.getDecoratorNodeCoordinates();
        if (decoratorNodeCoordinates != null) {
            if (!decoratorNodeCoordinates.isAttached()) {
                decoratorNodeCoordinates = null;
            }
            if (decoratorNodeCoordinates != null) {
                rect = LayoutCoordinates.localBoundingBoxOf$default(decoratorNodeCoordinates, textLayoutNodeCoordinates, false, 2, null);
            }
        }
        if (rect != null) {
            return Float.intBitsToFloat((int) (rect.m4158getSizeNHjbRc() & 4294967295L));
        }
        return Float.NaN;
    }
}
