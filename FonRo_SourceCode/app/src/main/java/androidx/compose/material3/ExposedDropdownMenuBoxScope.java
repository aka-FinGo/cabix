package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ExposedDropdownMenu.android.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002JU\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u0016J\u0098\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J¢\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010#\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u0016\u0010&\u001a\u00020\u000e*\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\nH&J\f\u0010'\u001a\u00020\u000e*\u00020\u000eH\u0007J(\u0010'\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\nH&ø\u0001\u0000¢\u0006\u0004\b*\u0010+R\u0018\u0010\u0003\u001a\u00020\u0004X \u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001,\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "", "()V", "anchorType", "Landroidx/compose/material3/MenuAnchorType;", "getAnchorType-Mg6Rgbw$material3_release", "()Ljava/lang/String;", "ExposedDropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "matchTextFieldWidth", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "border", "Landroidx/compose/foundation/BorderStroke;", "ExposedDropdownMenu-vNxi1II", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "focusable", "ExposedDropdownMenu-kbRbctU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "exposedDropdownSize", "menuAnchor", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "enabled", "menuAnchor-fsE2BvY", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Z)Landroidx/compose/ui/Modifier;", "Landroidx/compose/material3/ExposedDropdownMenuBoxScopeImpl;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public abstract class ExposedDropdownMenuBoxScope {
    public static final int $stable = 0;

    public /* synthetic */ ExposedDropdownMenuBoxScope(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Modifier exposedDropdownSize(Modifier modifier, boolean z);

    /* renamed from: getAnchorType-Mg6Rgbw$material3_release, reason: not valid java name */
    public abstract String mo2187getAnchorTypeMg6Rgbw$material3_release();

    /* renamed from: menuAnchor-fsE2BvY, reason: not valid java name */
    public abstract Modifier mo2188menuAnchorfsE2BvY(Modifier modifier, String str, boolean z);

    private ExposedDropdownMenuBoxScope() {
    }

    /* renamed from: menuAnchor-fsE2BvY$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2184menuAnchorfsE2BvY$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: menuAnchor-fsE2BvY");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return exposedDropdownMenuBoxScope.mo2188menuAnchorfsE2BvY(modifier, str, z);
    }

    public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02c6  */
    /* renamed from: ExposedDropdownMenu-vNxi1II, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2186ExposedDropdownMenuvNxi1II(final boolean r37, final kotlin.jvm.functions.Function0<kotlin.Unit> r38, androidx.compose.ui.Modifier r39, androidx.compose.foundation.ScrollState r40, boolean r41, androidx.compose.ui.graphics.Shape r42, long r43, float r45, float r46, androidx.compose.foundation.BorderStroke r47, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, androidx.compose.runtime.Composer r49, final int r50, final int r51, final int r52) {
        /*
            Method dump skipped, instructions count: 1061
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuBoxScope.m2186ExposedDropdownMenuvNxi1II(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, boolean, androidx.compose.ui.graphics.Shape, long, float, float, androidx.compose.foundation.BorderStroke, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use overload that takes MenuAnchorType and enabled parameters", replaceWith = @ReplaceWith(expression = "menuAnchor(type, enabled)", imports = {}))
    public final Modifier menuAnchor(Modifier modifier) {
        return m2184menuAnchorfsE2BvY$default(this, modifier, MenuAnchorType.INSTANCE.m2330getPrimaryNotEditableMg6Rgbw(), false, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0209  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "The `focusable` parameter is unused. Pass the proper MenuAnchorType to Modifier.menuAnchor instead, which will handle focusability automatically.")
    /* renamed from: ExposedDropdownMenu-kbRbctU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2185ExposedDropdownMenukbRbctU(final boolean r35, final kotlin.jvm.functions.Function0<kotlin.Unit> r36, androidx.compose.ui.Modifier r37, androidx.compose.foundation.ScrollState r38, boolean r39, boolean r40, androidx.compose.ui.graphics.Shape r41, long r42, float r44, float r45, androidx.compose.foundation.BorderStroke r46, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, final int r49, final int r50, final int r51) {
        /*
            Method dump skipped, instructions count: 736
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuBoxScope.m2185ExposedDropdownMenukbRbctU(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, boolean, boolean, androidx.compose.ui.graphics.Shape, long, float, float, androidx.compose.foundation.BorderStroke, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x007b  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with customization options parameters.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void ExposedDropdownMenu(final boolean r26, final kotlin.jvm.functions.Function0 r27, androidx.compose.ui.Modifier r28, androidx.compose.foundation.ScrollState r29, final kotlin.jvm.functions.Function3 r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
