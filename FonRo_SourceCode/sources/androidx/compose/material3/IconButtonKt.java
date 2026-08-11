package androidx.compose.material3;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* compiled from: IconButton.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ab\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ap\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00152\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0016\u001ab\u0010\u0017\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ap\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00152\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0016\u001aX\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u001a\u001af\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00152\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u001c\u001an\u0010\u001d\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010 \u001a|\u0010!\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00152\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"FilledIconButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/IconButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FilledIconToggleButton", "checked", "onCheckedChange", "Lkotlin/Function1;", "Landroidx/compose/material3/IconToggleButtonColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FilledTonalIconButton", "FilledTonalIconToggleButton", "IconButton", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconToggleButton", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OutlinedIconButton", "border", "Landroidx/compose/foundation/BorderStroke;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OutlinedIconToggleButton", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class IconButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void IconButton(final kotlin.jvm.functions.Function0<kotlin.Unit> r22, androidx.compose.ui.Modifier r23, boolean r24, androidx.compose.material3.IconButtonColors r25, androidx.compose.foundation.interaction.MutableInteractionSource r26, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.IconButtonKt.IconButton(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.IconButtonColors, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void IconToggleButton(final boolean r23, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r24, androidx.compose.ui.Modifier r25, boolean r26, androidx.compose.material3.IconToggleButtonColors r27, androidx.compose.foundation.interaction.MutableInteractionSource r28, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 689
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.IconButtonKt.IconToggleButton(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.IconToggleButtonColors, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FilledIconButton(final kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.ui.Modifier r27, boolean r28, androidx.compose.ui.graphics.Shape r29, androidx.compose.material3.IconButtonColors r30, androidx.compose.foundation.interaction.MutableInteractionSource r31, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.IconButtonKt.FilledIconButton(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.material3.IconButtonColors, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FilledTonalIconButton(final kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.ui.Modifier r27, boolean r28, androidx.compose.ui.graphics.Shape r29, androidx.compose.material3.IconButtonColors r30, androidx.compose.foundation.interaction.MutableInteractionSource r31, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.IconButtonKt.FilledTonalIconButton(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.material3.IconButtonColors, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FilledIconToggleButton(final boolean r23, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r24, androidx.compose.ui.Modifier r25, boolean r26, androidx.compose.ui.graphics.Shape r27, androidx.compose.material3.IconToggleButtonColors r28, androidx.compose.foundation.interaction.MutableInteractionSource r29, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 517
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.IconButtonKt.FilledIconToggleButton(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.material3.IconToggleButtonColors, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FilledTonalIconToggleButton(final boolean r23, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r24, androidx.compose.ui.Modifier r25, boolean r26, androidx.compose.ui.graphics.Shape r27, androidx.compose.material3.IconToggleButtonColors r28, androidx.compose.foundation.interaction.MutableInteractionSource r29, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 517
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.IconButtonKt.FilledTonalIconToggleButton(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.material3.IconToggleButtonColors, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OutlinedIconButton(final kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.Modifier r29, boolean r30, androidx.compose.ui.graphics.Shape r31, androidx.compose.material3.IconButtonColors r32, androidx.compose.foundation.BorderStroke r33, androidx.compose.foundation.interaction.MutableInteractionSource r34, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.IconButtonKt.OutlinedIconButton(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.material3.IconButtonColors, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OutlinedIconToggleButton(final boolean r22, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r23, androidx.compose.ui.Modifier r24, boolean r25, androidx.compose.ui.graphics.Shape r26, androidx.compose.material3.IconToggleButtonColors r27, androidx.compose.foundation.BorderStroke r28, androidx.compose.foundation.interaction.MutableInteractionSource r29, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 589
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.IconButtonKt.OutlinedIconToggleButton(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.material3.IconToggleButtonColors, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
