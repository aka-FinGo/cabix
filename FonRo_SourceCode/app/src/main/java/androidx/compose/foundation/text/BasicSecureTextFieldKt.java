package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.InputTransformationKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: BasicSecureTextField.kt */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÊ\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u001328\b\u0002\u0010\u0014\u001a2\u0012\u0004\u0012\u00020\u0016\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015¢\u0006\u0002\b\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001aÔ\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u001328\b\u0002\u0010\u0014\u001a2\u0012\u0004\u0012\u00020\u0016\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015¢\u0006\u0002\b\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a \u0010+\u001a\u00020\u00052\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00050\u0017¢\u0006\u0002\b-H\u0003¢\u0006\u0002\u0010.\u001a\u001a\u0010/\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\r2\b\u00100\u001a\u0004\u0018\u00010\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"DefaultObfuscationCharacter", "", "LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS", "", "BasicSecureTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "textObfuscationMode", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "textObfuscationCharacter", "BasicSecureTextField-Jb9bMDk", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "readOnly", "BasicSecureTextField-egD4TGM", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "DisableCutCopy", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "then", "next", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BasicSecureTextFieldKt {
    private static final char DefaultObfuscationCharacter = 8226;
    private static final long LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS = 1500;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ff  */
    /* renamed from: BasicSecureTextField-egD4TGM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1349BasicSecureTextFieldegD4TGM(final androidx.compose.foundation.text.input.TextFieldState r34, androidx.compose.ui.Modifier r35, boolean r36, boolean r37, androidx.compose.foundation.text.input.InputTransformation r38, androidx.compose.ui.text.TextStyle r39, androidx.compose.foundation.text.KeyboardOptions r40, androidx.compose.foundation.text.input.KeyboardActionHandler r41, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit> r42, androidx.compose.foundation.interaction.MutableInteractionSource r43, androidx.compose.ui.graphics.Brush r44, androidx.compose.foundation.text.input.TextFieldDecorator r45, int r46, char r47, androidx.compose.runtime.Composer r48, final int r49, final int r50, final int r51) {
        /*
            Method dump skipped, instructions count: 1023
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicSecureTextFieldKt.m1349BasicSecureTextFieldegD4TGM(androidx.compose.foundation.text.input.TextFieldState, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.foundation.text.input.InputTransformation, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.input.KeyboardActionHandler, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, androidx.compose.foundation.text.input.TextFieldDecorator, int, char, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InputTransformation then(InputTransformation inputTransformation, InputTransformation inputTransformation2) {
        return inputTransformation == null ? inputTransformation2 : inputTransformation2 == null ? inputTransformation : InputTransformationKt.then(inputTransformation, inputTransformation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DisableCutCopy(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1085555050);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisableCutCopy)306@14490L7,308@14536L875,329@15416L80:BasicSecureTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1085555050, i2, -1, "androidx.compose.foundation.text.DisableCutCopy (BasicSecureTextField.kt:305)");
            }
            ProvidableCompositionLocal<TextToolbar> localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localTextToolbar);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final TextToolbar textToolbar = (TextToolbar) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1202758015, "CC(remember):BasicSecureTextField.kt#9igjgp");
            boolean changed = startRestartGroup.changed(textToolbar);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new TextToolbar() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1
                    private final /* synthetic */ TextToolbar $$delegate_0;

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public TextToolbarStatus getStatus() {
                        return this.$$delegate_0.getStatus();
                    }

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public void hide() {
                        this.$$delegate_0.hide();
                    }

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public void showMenu(Rect rect, Function0<Unit> onCopyRequested, Function0<Unit> onPasteRequested, Function0<Unit> onCutRequested, Function0<Unit> onSelectAllRequested) {
                        this.$$delegate_0.showMenu(rect, onCopyRequested, onPasteRequested, onCutRequested, onSelectAllRequested);
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.$$delegate_0 = TextToolbar.this;
                    }

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public void showMenu(Rect rect, Function0<Unit> onCopyRequested, Function0<Unit> onPasteRequested, Function0<Unit> onCutRequested, Function0<Unit> onSelectAllRequested, Function0<Unit> onAutofillRequested) {
                        TextToolbar.this.showMenu(rect, null, onPasteRequested, null, onSelectAllRequested, onAutofillRequested);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalTextToolbar().provides((BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1) rememberedValue), function2, startRestartGroup, ((i2 << 3) & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$DisableCutCopy$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    BasicSecureTextFieldKt.DisableCutCopy(function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Please use the overload that takes in readOnly parameter.")
    /* renamed from: BasicSecureTextField-Jb9bMDk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m1348BasicSecureTextFieldJb9bMDk(final androidx.compose.foundation.text.input.TextFieldState r36, androidx.compose.ui.Modifier r37, boolean r38, androidx.compose.foundation.text.input.InputTransformation r39, androidx.compose.ui.text.TextStyle r40, androidx.compose.foundation.text.KeyboardOptions r41, androidx.compose.foundation.text.input.KeyboardActionHandler r42, kotlin.jvm.functions.Function2 r43, androidx.compose.foundation.interaction.MutableInteractionSource r44, androidx.compose.ui.graphics.Brush r45, androidx.compose.foundation.text.input.TextFieldDecorator r46, int r47, char r48, androidx.compose.runtime.Composer r49, final int r50, final int r51, final int r52) {
        /*
            Method dump skipped, instructions count: 773
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicSecureTextFieldKt.m1348BasicSecureTextFieldJb9bMDk(androidx.compose.foundation.text.input.TextFieldState, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.text.input.InputTransformation, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.input.KeyboardActionHandler, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, androidx.compose.foundation.text.input.TextFieldDecorator, int, char, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
