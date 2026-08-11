package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: BasicTextField.kt */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÛ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u001728\b\u0002\u0010\u0018\u001a2\u0012\u0004\u0012\u00020\u001a\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019¢\u0006\u0002\b 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010(\u001a\u00020)H\u0007¢\u0006\u0002\u0010*\u001añ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u001728\b\u0002\u0010\u0018\u001a2\u0012\u0004\u0012\u00020\u001a\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019¢\u0006\u0002\b 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010-\u001a\u00020\fH\u0001¢\u0006\u0002\u0010.\u001aâ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\f2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$23\b\u0002\u0010:\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\b;¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u000602¢\u0006\u0002\b;H\u0007¢\u0006\u0002\u0010=\u001aî\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\f2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010>\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$23\b\u0002\u0010:\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\b;¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u000602¢\u0006\u0002\b;H\u0007¢\u0006\u0002\u0010?\u001aâ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020@2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\f2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$23\b\u0002\u0010:\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\b;¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u000602¢\u0006\u0002\b;H\u0007¢\u0006\u0002\u0010A\u001aî\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020@2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\f2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010>\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$23\b\u0002\u0010:\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\b;¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u000602¢\u0006\u0002\b;H\u0007¢\u0006\u0002\u0010B\u001a\u0015\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020EH\u0001¢\u0006\u0002\u0010F\u001a\u0015\u0010G\u001a\u00020\u00062\u0006\u0010D\u001a\u00020EH\u0001¢\u0006\u0002\u0010F\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006H²\u0006\n\u0010I\u001a\u00020JX\u008a\u0084\u0002²\u0006\n\u0010K\u001a\u00020JX\u008a\u0084\u0002²\u0006\n\u0010L\u001a\u00020JX\u008a\u0084\u0002²\u0006\n\u0010M\u001a\u000200X\u008a\u008e\u0002²\u0006\n\u0010N\u001a\u00020@X\u008a\u008e\u0002"}, d2 = {"DefaultTextFieldDecorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "MinTouchTargetSizeForHandles", "Landroidx/compose/ui/unit/DpSize;", "J", "BasicTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "decorator", "scrollState", "Landroidx/compose/foundation/ScrollState;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "isPassword", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/runtime/Composer;III)V", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "decorationBox", "Landroidx/compose/runtime/Composable;", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "TextFieldCursorHandle", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/runtime/Composer;I)V", "TextFieldSelectionHandles", "foundation_release", "cursorHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "startHandleState", "endHandleState", "textFieldValueState", "lastTextValue"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BasicTextFieldKt {
    private static final TextFieldDecorator DefaultTextFieldDecorator = new TextFieldDecorator() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$DefaultTextFieldDecorator$1
        @Override // androidx.compose.foundation.text.input.TextFieldDecorator
        public final void Decoration(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
            composer.startReplaceGroup(-1669748801);
            ComposerKt.sourceInformation(composer, "C(Decoration)582@28932L4:BasicTextField.kt#423gt5");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1669748801, i, -1, "androidx.compose.foundation.text.DefaultTextFieldDecorator.<no name provided>.Decoration (BasicTextField.kt:582)");
            }
            function2.invoke(composer, Integer.valueOf(i & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
        }
    };
    private static final long MinTouchTargetSizeForHandles = DpKt.m7011DpSizeYgX7TsA(Dp.m6989constructorimpl(40.0f), Dp.m6989constructorimpl(40.0f));

    /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BasicTextField(final androidx.compose.foundation.text.input.TextFieldState r36, androidx.compose.ui.Modifier r37, boolean r38, boolean r39, androidx.compose.foundation.text.input.InputTransformation r40, androidx.compose.ui.text.TextStyle r41, androidx.compose.foundation.text.KeyboardOptions r42, androidx.compose.foundation.text.input.KeyboardActionHandler r43, androidx.compose.foundation.text.input.TextFieldLineLimits r44, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit> r45, androidx.compose.foundation.interaction.MutableInteractionSource r46, androidx.compose.ui.graphics.Brush r47, androidx.compose.foundation.text.input.OutputTransformation r48, androidx.compose.foundation.text.input.TextFieldDecorator r49, androidx.compose.foundation.ScrollState r50, androidx.compose.runtime.Composer r51, final int r52, final int r53, final int r54) {
        /*
            Method dump skipped, instructions count: 859
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.foundation.text.input.TextFieldState, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.foundation.text.input.InputTransformation, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.input.KeyboardActionHandler, androidx.compose.foundation.text.input.TextFieldLineLimits, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, androidx.compose.foundation.text.input.OutputTransformation, androidx.compose.foundation.text.input.TextFieldDecorator, androidx.compose.foundation.ScrollState, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0851  */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x082c  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x025d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BasicTextField(final androidx.compose.foundation.text.input.TextFieldState r54, androidx.compose.ui.Modifier r55, boolean r56, boolean r57, androidx.compose.foundation.text.input.InputTransformation r58, androidx.compose.ui.text.TextStyle r59, androidx.compose.foundation.text.KeyboardOptions r60, androidx.compose.foundation.text.input.KeyboardActionHandler r61, androidx.compose.foundation.text.input.TextFieldLineLimits r62, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit> r63, androidx.compose.foundation.interaction.MutableInteractionSource r64, androidx.compose.ui.graphics.Brush r65, androidx.compose.foundation.text.input.internal.CodepointTransformation r66, androidx.compose.foundation.text.input.OutputTransformation r67, androidx.compose.foundation.text.input.TextFieldDecorator r68, androidx.compose.foundation.ScrollState r69, boolean r70, androidx.compose.runtime.Composer r71, final int r72, final int r73, final int r74) {
        /*
            Method dump skipped, instructions count: 2153
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.foundation.text.input.TextFieldState, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.foundation.text.input.InputTransformation, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.input.KeyboardActionHandler, androidx.compose.foundation.text.input.TextFieldLineLimits, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, androidx.compose.foundation.text.input.internal.CodepointTransformation, androidx.compose.foundation.text.input.OutputTransformation, androidx.compose.foundation.text.input.TextFieldDecorator, androidx.compose.foundation.ScrollState, boolean, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionState textFieldSelectionState, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1991581797);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldCursorHandle)504@26102L128:BasicTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(textFieldSelectionState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1991581797, i2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (BasicTextField.kt:501)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -425706716, "CC(remember):BasicTextField.kt#9igjgp");
            boolean changed = startRestartGroup.changed(textFieldSelectionState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldCursorHandle$cursorHandleState$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TextFieldHandleState invoke() {
                        return TextFieldSelectionState.this.getCursorHandleState$foundation_release(false);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (TextFieldCursorHandle$lambda$12((State) rememberedValue).getVisible()) {
                startRestartGroup.startReplaceGroup(-311835217);
                ComposerKt.sourceInformation(startRestartGroup, "509@26319L100,513@26498L87,508@26276L383");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -425699800, "CC(remember):BasicTextField.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(textFieldSelectionState);
                OffsetProvider rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldCursorHandle$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* renamed from: provide-F1C5BW0, reason: not valid java name */
                        public final long mo1351provideF1C5BW0() {
                            return TextFieldSelectionState.this.getCursorHandleState$foundation_release(true).m1664getPositionF1C5BW0();
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                OffsetProvider offsetProvider = (OffsetProvider) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -425694085, "CC(remember):BasicTextField.kt#9igjgp");
                boolean changedInstance2 = startRestartGroup.changedInstance(textFieldSelectionState);
                PointerInputEventHandler rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldCursorHandle$2$1
                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object cursorHandleGestures = TextFieldSelectionState.this.cursorHandleGestures(pointerInputScope, continuation);
                            return cursorHandleGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? cursorHandleGestures : Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                AndroidCursorHandle_androidKt.m1345CursorHandleUSBMPiE(offsetProvider, SuspendingPointerInputFilterKt.pointerInput(companion, textFieldSelectionState, (PointerInputEventHandler) rememberedValue3), MinTouchTargetSizeForHandles, startRestartGroup, 384, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-311451778);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldCursorHandle$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    BasicTextFieldKt.TextFieldCursorHandle(TextFieldSelectionState.this, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void TextFieldSelectionHandles(final TextFieldSelectionState textFieldSelectionState, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(2025287684);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldSelectionHandles)525@26865L239,554@27919L240:BasicTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(textFieldSelectionState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2025287684, i2, -1, "androidx.compose.foundation.text.TextFieldSelectionHandles (BasicTextField.kt:522)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1983177036, "CC(remember):BasicTextField.kt#9igjgp");
            boolean changed = startRestartGroup.changed(textFieldSelectionState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$startHandleState$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TextFieldHandleState invoke() {
                        return TextFieldSelectionState.this.getSelectionHandleState$foundation_release(true, false);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            State state = (State) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (TextFieldSelectionHandles$lambda$16(state).getVisible()) {
                startRestartGroup.startReplaceGroup(-1348660553);
                ComposerKt.sourceInformation(startRestartGroup, "535@27195L167,544@27589L94,534@27149L662");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1983166548, "CC(remember):BasicTextField.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(textFieldSelectionState);
                OffsetProvider rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* renamed from: provide-F1C5BW0 */
                        public final long mo1351provideF1C5BW0() {
                            return TextFieldSelectionState.this.getSelectionHandleState$foundation_release(true, true).m1664getPositionF1C5BW0();
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                OffsetProvider offsetProvider = (OffsetProvider) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ResolvedTextDirection direction = TextFieldSelectionHandles$lambda$16(state).getDirection();
                boolean handlesCrossed = TextFieldSelectionHandles$lambda$16(state).getHandlesCrossed();
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1983154013, "CC(remember):BasicTextField.kt#9igjgp");
                boolean changedInstance2 = startRestartGroup.changedInstance(textFieldSelectionState);
                PointerInputEventHandler rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$2$1
                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object selectionHandleGestures = TextFieldSelectionState.this.selectionHandleGestures(pointerInputScope, true, continuation);
                            return selectionHandleGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? selectionHandleGestures : Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                AndroidSelectionHandles_androidKt.m1752SelectionHandlewLIcFTc(offsetProvider, true, direction, handlesCrossed, MinTouchTargetSizeForHandles, TextFieldSelectionHandles$lambda$16(state).getLineHeight(), SuspendingPointerInputFilterKt.pointerInput(companion, textFieldSelectionState, (PointerInputEventHandler) rememberedValue3), startRestartGroup, 24624, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1348008995);
                startRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1983143307, "CC(remember):BasicTextField.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(textFieldSelectionState);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$endHandleState$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TextFieldHandleState invoke() {
                        return TextFieldSelectionState.this.getSelectionHandleState$foundation_release(false, false);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            State state2 = (State) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (TextFieldSelectionHandles$lambda$20(state2).getVisible()) {
                startRestartGroup.startReplaceGroup(-1347616070);
                ComposerKt.sourceInformation(startRestartGroup, "564@28248L168,573@28640L95,563@28202L659");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1983132851, "CC(remember):BasicTextField.kt#9igjgp");
                boolean changedInstance3 = startRestartGroup.changedInstance(textFieldSelectionState);
                OffsetProvider rememberedValue5 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = new OffsetProvider() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$3$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* renamed from: provide-F1C5BW0 */
                        public final long mo1351provideF1C5BW0() {
                            return TextFieldSelectionState.this.getSelectionHandleState$foundation_release(false, true).m1664getPositionF1C5BW0();
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                OffsetProvider offsetProvider2 = (OffsetProvider) rememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ResolvedTextDirection direction2 = TextFieldSelectionHandles$lambda$20(state2).getDirection();
                boolean handlesCrossed2 = TextFieldSelectionHandles$lambda$20(state2).getHandlesCrossed();
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1983120380, "CC(remember):BasicTextField.kt#9igjgp");
                boolean changedInstance4 = startRestartGroup.changedInstance(textFieldSelectionState);
                PointerInputEventHandler rememberedValue6 = startRestartGroup.rememberedValue();
                if (changedInstance4 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue6 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$4$1
                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object selectionHandleGestures = TextFieldSelectionState.this.selectionHandleGestures(pointerInputScope, false, continuation);
                            return selectionHandleGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? selectionHandleGestures : Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                AndroidSelectionHandles_androidKt.m1752SelectionHandlewLIcFTc(offsetProvider2, false, direction2, handlesCrossed2, MinTouchTargetSizeForHandles, TextFieldSelectionHandles$lambda$20(state2).getLineHeight(), SuspendingPointerInputFilterKt.pointerInput(companion2, textFieldSelectionState, (PointerInputEventHandler) rememberedValue6), startRestartGroup, 24624, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1346967395);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    BasicTextFieldKt.TextFieldSelectionHandles(TextFieldSelectionState.this, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x03ac, code lost:
    
        if (r4 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L245;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0498  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0235  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BasicTextField(final java.lang.String r36, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r37, androidx.compose.ui.Modifier r38, boolean r39, boolean r40, androidx.compose.ui.text.TextStyle r41, androidx.compose.foundation.text.KeyboardOptions r42, androidx.compose.foundation.text.KeyboardActions r43, boolean r44, int r45, int r46, androidx.compose.ui.text.input.VisualTransformation r47, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r48, androidx.compose.foundation.interaction.MutableInteractionSource r49, androidx.compose.ui.graphics.Brush r50, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.runtime.Composer r52, final int r53, final int r54, final int r55) {
        /*
            Method dump skipped, instructions count: 1235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue BasicTextField$lambda$24(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String BasicTextField$lambda$28(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0420  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BasicTextField(final androidx.compose.ui.text.input.TextFieldValue r37, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r38, androidx.compose.ui.Modifier r39, boolean r40, boolean r41, androidx.compose.ui.text.TextStyle r42, androidx.compose.foundation.text.KeyboardOptions r43, androidx.compose.foundation.text.KeyboardActions r44, boolean r45, int r46, int r47, androidx.compose.ui.text.input.VisualTransformation r48, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r49, androidx.compose.foundation.interaction.MutableInteractionSource r50, androidx.compose.ui.graphics.Brush r51, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, androidx.compose.runtime.Composer r53, final int r54, final int r55, final int r56) {
        /*
            Method dump skipped, instructions count: 1082
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void BasicTextField(final java.lang.String r36, final kotlin.jvm.functions.Function1 r37, androidx.compose.ui.Modifier r38, boolean r39, boolean r40, androidx.compose.ui.text.TextStyle r41, androidx.compose.foundation.text.KeyboardOptions r42, androidx.compose.foundation.text.KeyboardActions r43, boolean r44, int r45, androidx.compose.ui.text.input.VisualTransformation r46, kotlin.jvm.functions.Function1 r47, androidx.compose.foundation.interaction.MutableInteractionSource r48, androidx.compose.ui.graphics.Brush r49, kotlin.jvm.functions.Function3 r50, androidx.compose.runtime.Composer r51, final int r52, final int r53, final int r54) {
        /*
            Method dump skipped, instructions count: 864
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void BasicTextField(final androidx.compose.ui.text.input.TextFieldValue r36, final kotlin.jvm.functions.Function1 r37, androidx.compose.ui.Modifier r38, boolean r39, boolean r40, androidx.compose.ui.text.TextStyle r41, androidx.compose.foundation.text.KeyboardOptions r42, androidx.compose.foundation.text.KeyboardActions r43, boolean r44, int r45, androidx.compose.ui.text.input.VisualTransformation r46, kotlin.jvm.functions.Function1 r47, androidx.compose.foundation.interaction.MutableInteractionSource r48, androidx.compose.ui.graphics.Brush r49, kotlin.jvm.functions.Function3 r50, androidx.compose.runtime.Composer r51, final int r52, final int r53, final int r54) {
        /*
            Method dump skipped, instructions count: 864
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final TextFieldHandleState TextFieldCursorHandle$lambda$12(State<TextFieldHandleState> state) {
        return state.getValue();
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$16(State<TextFieldHandleState> state) {
        return state.getValue();
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$20(State<TextFieldHandleState> state) {
        return state.getValue();
    }
}
