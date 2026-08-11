package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* compiled from: Badge.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u001aR\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102 \b\u0002\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001aS\u0010\u0019\u001a\u00020\f2\u001c\u0010\u001a\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\r\u001a\u00020\u000e2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001c\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\n\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d²\u0006\n\u0010\u001e\u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u001fX\u008a\u008e\u0002"}, d2 = {"BadgeOffset", "Landroidx/compose/ui/unit/Dp;", "getBadgeOffset", "()F", "F", "BadgeWithContentHorizontalOffset", "getBadgeWithContentHorizontalOffset", "BadgeWithContentHorizontalPadding", "getBadgeWithContentHorizontalPadding", "BadgeWithContentVerticalOffset", "getBadgeWithContentVerticalOffset", "Badge", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Badge-eopBjH0", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BadgedBox", "badge", "Landroidx/compose/foundation/layout/BoxScope;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material3_release", "layoutAbsoluteLeft", "", "layoutAbsoluteTop", "greatGrandParentAbsoluteRight", "greatGrandParentAbsoluteTop"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class BadgeKt {
    private static final float BadgeWithContentHorizontalPadding = Dp.m6989constructorimpl(4.0f);
    private static final float BadgeWithContentHorizontalOffset = Dp.m6989constructorimpl(12.0f);
    private static final float BadgeWithContentVerticalOffset = Dp.m6989constructorimpl(14.0f);
    private static final float BadgeOffset = Dp.m6989constructorimpl(6.0f);

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BadgedBox(final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r17, androidx.compose.ui.Modifier r18, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instructions count: 903
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BadgeKt.BadgedBox(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BadgedBox$lambda$1(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BadgedBox$lambda$4(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BadgedBox$lambda$7(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BadgedBox$lambda$10(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00bc  */
    /* renamed from: Badge-eopBjH0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1893BadgeeopBjH0(androidx.compose.ui.Modifier r16, long r17, long r19, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instructions count: 625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BadgeKt.m1893BadgeeopBjH0(androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final float getBadgeWithContentHorizontalPadding() {
        return BadgeWithContentHorizontalPadding;
    }

    public static final float getBadgeWithContentHorizontalOffset() {
        return BadgeWithContentHorizontalOffset;
    }

    public static final float getBadgeWithContentVerticalOffset() {
        return BadgeWithContentVerticalOffset;
    }

    public static final float getBadgeOffset() {
        return BadgeOffset;
    }
}
