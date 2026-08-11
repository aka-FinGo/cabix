package uz.FonRo.pos.ui.components;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.rounded.CloseKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxShape;

/* compiled from: Fields.kt */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u001aÉ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0007b\u0002\b\u001bb\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\u0004\b\u0019\u0010\u001a\u001a×\u0001\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\u0015\b\u0002\u0010 \u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f¢\u0006\u0002\b\u001bH\u0007b\u0002\b\u001bb\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\u0004\b\"\u0010#\u001aa\u0010'\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0007b\u0002\b\u001bb\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\u0002\u0010(\u001a_\u0010)\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003H\u0007b\u0002\b\u001bb\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\u0004\b.\u0010/\u001ae\u00100\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0007b\u0002\b\u001bb\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\u0004\b1\u00102¨\u00063²\u0006\n\u00104\u001a\u00020\u0011X\u008a\u008e\u0002"}, d2 = {"OxField", "", "label", "", "value", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "placeholder", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "onImeAction", "Lkotlin/Function0;", HintConstants.AUTOFILL_HINT_PASSWORD, "", "singleLine", "enabled", "monospace", "centered", "maxLength", "", "hint", "OxField-DfS-PO0", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Ljava/lang/String;IILkotlin/jvm/functions/Function0;ZZZZZLjava/lang/Integer;Ljava/lang/String;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "OxInput", "leading", "trailing", "OxInput-WwzLCwM", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Ljava/lang/String;IILkotlin/jvm/functions/Function0;ZZZZZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/runtime/ComposableInferredTarget;", "scheme", "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]", "OxSearchBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "OxValueButton", "onClick", "valueColor", "Landroidx/compose/ui/graphics/Color;", "leadingText", "OxValueButton-FHprtrg", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLjava/lang/String;Landroidx/compose/runtime/Composer;II)V", "OxSolidInput", "OxSolidInput-YxU46PI", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Ljava/lang/String;IZLandroidx/compose/runtime/Composer;II)V", "app", "focused"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class FieldsKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxField_DfS_PO0$lambda$1(String str, String str2, Function1 function1, Modifier modifier, String str3, int i, int i2, Function0 function0, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, Integer num, String str4, int i3, int i4, int i5, Composer composer, int i6) {
        m9846OxFieldDfSPO0(str, str2, function1, modifier, str3, i, i2, function0, z, z2, z3, z4, z5, num, str4, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxInput_WwzLCwM$lambda$1(String str, Function1 function1, Modifier modifier, String str2, int i, int i2, Function0 function0, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, Function2 function2, Function2 function22, int i3, int i4, int i5, Composer composer, int i6) {
        m9847OxInputWwzLCwM(str, function1, modifier, str2, i, i2, function0, z, z2, z3, z4, z5, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxSearchBox$lambda$1(String str, Function1 function1, Modifier modifier, String str2, Function0 function0, int i, int i2, Composer composer, int i3) {
        OxSearchBox(str, function1, modifier, str2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxSolidInput_YxU46PI$lambda$4(String str, Function1 function1, Modifier modifier, String str2, int i, boolean z, int i2, int i3, Composer composer, int i4) {
        m9848OxSolidInputYxU46PI(str, function1, modifier, str2, i, z, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxValueButton_FHprtrg$lambda$1(String str, String str2, Function0 function0, Modifier modifier, long j, String str3, int i, int i2, Composer composer, int i3) {
        m9849OxValueButtonFHprtrg(str, str2, function0, modifier, j, str3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x020f  */
    /* renamed from: OxField-DfS-PO0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m9846OxFieldDfSPO0(final java.lang.String r47, final java.lang.String r48, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r49, androidx.compose.ui.Modifier r50, java.lang.String r51, int r52, int r53, kotlin.jvm.functions.Function0<kotlin.Unit> r54, boolean r55, boolean r56, boolean r57, boolean r58, boolean r59, java.lang.Integer r60, java.lang.String r61, androidx.compose.runtime.Composer r62, final int r63, final int r64, final int r65) {
        /*
            Method dump skipped, instructions count: 1322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.FieldsKt.m9846OxFieldDfSPO0(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, java.lang.String, int, int, kotlin.jvm.functions.Function0, boolean, boolean, boolean, boolean, boolean, java.lang.Integer, java.lang.String, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxField_DfS_PO0$lambda$0$0$0(Function1 function1, Integer num, String raw) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        if (num != null) {
            raw = StringsKt.take(raw, num.intValue());
        }
        function1.invoke(raw);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x0788  */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x076a  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01f4  */
    /* renamed from: OxInput-WwzLCwM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m9847OxInputWwzLCwM(final java.lang.String r91, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r92, androidx.compose.ui.Modifier r93, java.lang.String r94, int r95, int r96, kotlin.jvm.functions.Function0<kotlin.Unit> r97, boolean r98, boolean r99, boolean r100, boolean r101, boolean r102, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r103, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r104, androidx.compose.runtime.Composer r105, final int r106, final int r107, final int r108) {
        /*
            Method dump skipped, instructions count: 1952
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.FieldsKt.m9847OxInputWwzLCwM(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, java.lang.String, int, int, kotlin.jvm.functions.Function0, boolean, boolean, boolean, boolean, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxInput_WwzLCwM$lambda$0$0$0$0(Function0 function0, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxInput_WwzLCwM$lambda$0$0$1$0(Function0 function0, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxInput_WwzLCwM$lambda$0$0$3$0(Function0 function0, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxInput_WwzLCwM$lambda$0$0$2$0(Function0 function0, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OxSearchBox(final java.lang.String r18, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r19, androidx.compose.ui.Modifier r20, java.lang.String r21, kotlin.jvm.functions.Function0<kotlin.Unit> r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.FieldsKt.OxSearchBox(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxSearchBox$lambda$0(String str, final Function1 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:Fields.kt#r5y9fm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1760880609, i, -1, "uz.FonRo.pos.ui.components.OxSearchBox.<anonymous> (Fields.kt:193)");
            }
            if (str.length() > 0) {
                composer.startReplaceGroup(-336277551);
                ComposerKt.sourceInformation(composer, "198@7073L21,198@7067L27,194@6927L464");
                Modifier clip = ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(34.0f)), OxShape.INSTANCE.getPill());
                ComposerKt.sourceInformationMarkerStart(composer, -10842890, "CC(remember):Fields.kt#9igjgp");
                boolean changed = composer.changed(function1);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.components.FieldsKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit OxSearchBox$lambda$0$0$0;
                            OxSearchBox$lambda$0$0$0 = FieldsKt.OxSearchBox$lambda$0$0$0(Function1.this);
                            return OxSearchBox$lambda$0$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier oxTap = ModifiersKt.oxTap(clip, false, (Function0) rememberedValue, composer, 0, 1);
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, oxTap);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer m3808constructorimpl = Updater.m3808constructorimpl(composer);
                Updater.m3815setimpl(m3808constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1781865522, "C201@7192L181:Fields.kt#r5y9fm");
                IconKt.m2255Iconww6aTOc(CloseKt.getClose(Icons.Rounded.INSTANCE), LangKt.tx("Очистить", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(18.0f)), Ox.INSTANCE.m10200getDim20d7_KjU(), composer, 384, 0);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-335800895);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxSearchBox$lambda$0$0$0(Function1 function1) {
        function1.invoke("");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0092  */
    /* renamed from: OxValueButton-FHprtrg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m9849OxValueButtonFHprtrg(final java.lang.String r52, final java.lang.String r53, final kotlin.jvm.functions.Function0<kotlin.Unit> r54, androidx.compose.ui.Modifier r55, long r56, java.lang.String r58, androidx.compose.runtime.Composer r59, final int r60, final int r61) {
        /*
            Method dump skipped, instructions count: 893
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.FieldsKt.m9849OxValueButtonFHprtrg(java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x007f  */
    /* renamed from: OxSolidInput-YxU46PI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m9848OxSolidInputYxU46PI(final java.lang.String r67, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r68, androidx.compose.ui.Modifier r69, java.lang.String r70, int r71, boolean r72, androidx.compose.runtime.Composer r73, final int r74, final int r75) {
        /*
            Method dump skipped, instructions count: 1041
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.FieldsKt.m9848OxSolidInputYxU46PI(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, java.lang.String, int, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean OxSolidInput_YxU46PI$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void OxSolidInput_YxU46PI$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxSolidInput_YxU46PI$lambda$3$0$0(MutableState mutableState, FocusState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        OxSolidInput_YxU46PI$lambda$2(mutableState, it.isFocused());
        return Unit.INSTANCE;
    }
}
