package androidx.compose.ui.graphics.vector;

import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* compiled from: VectorCompose.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a¦\u0001\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"Group", "", "name", "", Key.ROTATION, "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Path", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "Path-9cdaXJ4", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLandroidx/compose/runtime/Composer;III)V", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class VectorComposeKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Group(java.lang.String r21, float r22, float r23, float r24, float r25, float r26, float r27, float r28, java.util.List<? extends androidx.compose.ui.graphics.vector.PathNode> r29, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 647
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorComposeKt.Group(java.lang.String, float, float, float, float, float, float, float, java.util.List, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ea  */
    /* renamed from: Path-9cdaXJ4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m5082Path9cdaXJ4(final java.util.List<? extends androidx.compose.ui.graphics.vector.PathNode> r34, int r35, java.lang.String r36, androidx.compose.ui.graphics.Brush r37, float r38, androidx.compose.ui.graphics.Brush r39, float r40, float r41, int r42, int r43, float r44, float r45, float r46, float r47, androidx.compose.runtime.Composer r48, final int r49, final int r50, final int r51) {
        /*
            Method dump skipped, instructions count: 854
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorComposeKt.m5082Path9cdaXJ4(java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
