package uz.FonRo.pos.ui.stats;

import androidx.camera.video.AudioStats;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: Charts.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\t\u001a1\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007b\u0002\b\u0014b\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017¢\u0006\u0002\u0010\u0013\u001aU\u0010\u0018\u001a\u00020\u000e2\u0018\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u0007b\u0002\b\u0014b\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017¢\u0006\u0002\u0010\u001f\u001aI\u0010 \u001a\u00020\u000e2\u001e\u0010\u0019\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u001a0\u001b0\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007b\u0002\b\u0014b\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017¢\u0006\u0002\u0010\"\u001aU\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u0010H\u0007b\u0002\b\u0014b\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017¢\u0006\u0004\b)\u0010*\u001aK\u0010+\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007b\u0002\b\u0014b\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017¢\u0006\u0004\b,\u0010-\u001a?\u0010.\u001a\u00020\u000e2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020!0\u001a2\u0006\u00100\u001a\u0002012\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007b\u0002\b\u0014b\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017¢\u0006\u0002\u00102\u001a;\u00103\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007b\u0002\b\u0014b\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017¢\u0006\u0004\b4\u00105\u001a;\u00106\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007b\u0002\b\u0014b\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017¢\u0006\u0004\b7\u00105\u001a \u00108\u001a\u0002012\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u00012\u0006\u00109\u001a\u000201H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"NEAR_ZERO", "", "TrackShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "HintBg", "Landroidx/compose/ui/graphics/Color;", "getHintBg", "()J", "AxisStyle", "Landroidx/compose/ui/text/TextStyle;", "getAxisStyle", "()Landroidx/compose/ui/text/TextStyle;", "ValueStyle", "ChartNote", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "OxVChart", "points", "", "Lkotlin/Pair;", "positive", "Landroidx/compose/ui/graphics/Brush;", "negative", "(Ljava/util/List;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/runtime/Composer;II)V", "OxGroupedVChart", "Luz/FonRo/pos/ui/stats/ChartBar;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "OxHBar", "label", "value", "max", TypedValues.Custom.S_COLOR, "valueText", "OxHBar-fWhpE4E", "(Ljava/lang/String;DDJLandroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "OxMetricBar", "OxMetricBar-T042LqI", "(DDJLjava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "OxSplitBar", "segments", "fillFraction", "", "(Ljava/util/List;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "OxLegendChip", "OxLegendChip-3IgeMak", "(Ljava/lang/String;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "OxDotLabel", "OxDotLabel-3IgeMak", "barShare", "min", "app"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ChartsKt {
    private static final double NEAR_ZERO = 0.001d;
    private static final RoundedCornerShape TrackShape = RoundedCornerShapeKt.m1342RoundedCornerShape0680j_4(Dp.m6989constructorimpl(14.0f));
    private static final TextStyle ValueStyle = TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0, TextUnitKt.getSp(12.5d), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777209, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ChartNote$lambda$0(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ChartNote(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxDotLabel_3IgeMak$lambda$1(String str, long j, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m10152OxDotLabel3IgeMak(str, j, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxGroupedVChart$lambda$0(List list, Modifier modifier, int i, int i2, Composer composer, int i3) {
        OxGroupedVChart(list, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxGroupedVChart$lambda$4(List list, Modifier modifier, int i, int i2, Composer composer, int i3) {
        OxGroupedVChart(list, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxHBar_fWhpE4E$lambda$1(String str, double d, double d2, long j, Modifier modifier, String str2, int i, int i2, Composer composer, int i3) {
        m10153OxHBarfWhpE4E(str, d, d2, j, modifier, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxLegendChip_3IgeMak$lambda$1(String str, long j, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m10154OxLegendChip3IgeMak(str, j, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxMetricBar_T042LqI$lambda$1(double d, double d2, long j, String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m10155OxMetricBarT042LqI(d, d2, j, str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxSplitBar$lambda$1(List list, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        OxSplitBar(list, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxVChart$lambda$0(List list, Brush brush, Modifier modifier, Brush brush2, int i, int i2, Composer composer, int i3) {
        OxVChart(list, brush, modifier, brush2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxVChart$lambda$3(List list, Brush brush, Modifier modifier, Brush brush2, int i, int i2, Composer composer, int i3) {
        OxVChart(list, brush, modifier, brush2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final long getHintBg() {
        return Ox.INSTANCE.m10191getChipDim0d7_KjU();
    }

    private static final TextStyle getAxisStyle() {
        return TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(12), FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ChartNote(final java.lang.String r41, androidx.compose.ui.Modifier r42, androidx.compose.runtime.Composer r43, final int r44, final int r45) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.stats.ChartsKt.ChartNote(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x06ee  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x06e1  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013c  */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OxVChart(final java.util.List<kotlin.Pair<java.lang.String, java.lang.Double>> r75, final androidx.compose.ui.graphics.Brush r76, androidx.compose.ui.Modifier r77, androidx.compose.ui.graphics.Brush r78, androidx.compose.runtime.Composer r79, final int r80, final int r81) {
        /*
            Method dump skipped, instructions count: 1791
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.stats.ChartsKt.OxVChart(java.util.List, androidx.compose.ui.graphics.Brush, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Brush, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x0700  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x06f5  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OxGroupedVChart(final java.util.List<? extends kotlin.Pair<java.lang.String, ? extends java.util.List<uz.FonRo.pos.ui.stats.ChartBar>>> r71, androidx.compose.ui.Modifier r72, androidx.compose.runtime.Composer r73, final int r74, final int r75) {
        /*
            Method dump skipped, instructions count: 1807
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.stats.ChartsKt.OxGroupedVChart(java.util.List, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x022a  */
    /* renamed from: OxHBar-fWhpE4E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m10153OxHBarfWhpE4E(final java.lang.String r93, final double r94, double r96, final long r98, androidx.compose.ui.Modifier r100, java.lang.String r101, androidx.compose.runtime.Composer r102, final int r103, final int r104) {
        /*
            Method dump skipped, instructions count: 1358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.stats.ChartsKt.m10153OxHBarfWhpE4E(java.lang.String, double, double, long, androidx.compose.ui.Modifier, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0081  */
    /* renamed from: OxMetricBar-T042LqI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m10155OxMetricBarT042LqI(final double r43, final double r45, final long r47, final java.lang.String r49, androidx.compose.ui.Modifier r50, androidx.compose.runtime.Composer r51, final int r52, final int r53) {
        /*
            Method dump skipped, instructions count: 857
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.stats.ChartsKt.m10155OxMetricBarT042LqI(double, double, long, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OxSplitBar(final java.util.List<uz.FonRo.pos.ui.stats.ChartBar> r20, final float r21, androidx.compose.ui.Modifier r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instructions count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.stats.ChartsKt.OxSplitBar(java.util.List, float, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x005f  */
    /* renamed from: OxLegendChip-3IgeMak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m10154OxLegendChip3IgeMak(final java.lang.String r39, final long r40, androidx.compose.ui.Modifier r42, androidx.compose.runtime.Composer r43, final int r44, final int r45) {
        /*
            Method dump skipped, instructions count: 603
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.stats.ChartsKt.m10154OxLegendChip3IgeMak(java.lang.String, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x005e  */
    /* renamed from: OxDotLabel-3IgeMak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m10152OxDotLabel3IgeMak(final java.lang.String r38, final long r39, androidx.compose.ui.Modifier r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instructions count: 528
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.stats.ChartsKt.m10152OxDotLabel3IgeMak(java.lang.String, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final float barShare(double d, double d2, float f) {
        return Math.max(f, RangesKt.coerceIn((float) (Math.abs(d) / RangesKt.coerceAtLeast(d2, 1.0d)), 0.0f, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxSplitBar$lambda$0$1(List list, double d, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i) {
        int i2;
        float m7003unboximpl;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C349@12557L604:Charts.kt#fklwc3");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(BoxWithConstraints) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2111339785, i2, -1, "uz.FonRo.pos.ui.stats.OxSplitBar.<anonymous>.<anonymous> (Charts.kt:347)");
            }
            float m6989constructorimpl = Dp.m6989constructorimpl(2.0f);
            float m7003unboximpl2 = ((Dp) RangesKt.coerceAtLeast(Dp.m6987boximpl(Dp.m6989constructorimpl(BoxWithConstraints.mo956getMaxWidthD9Ej5fM() - Dp.m6989constructorimpl(RangesKt.coerceAtLeast(list.size() - 1, 0) * m6989constructorimpl))), Dp.m6987boximpl(Dp.m6989constructorimpl(0.0f)))).m7003unboximpl();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(m6989constructorimpl);
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, fillMaxSize$default);
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
            Updater.m3815setimpl(m3808constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1176011863, "C:Charts.kt#fklwc3");
            composer.startReplaceGroup(1700504131);
            ComposerKt.sourceInformation(composer, "*356@12886L243");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ChartBar chartBar = (ChartBar) it.next();
                if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    m7003unboximpl = ((Dp) RangesKt.coerceAtLeast(Dp.m6987boximpl(Dp.m6989constructorimpl(((float) (Math.abs(chartBar.getValue()) / d)) * m7003unboximpl2)), Dp.m6987boximpl(Dp.m6989constructorimpl(3.0f)))).m7003unboximpl();
                } else {
                    m7003unboximpl = Dp.m6989constructorimpl(3.0f);
                }
                BoxKt.Box(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxHeight$default(SizeKt.m1101width3ABfNKs(Modifier.INSTANCE, m7003unboximpl), 0.0f, 1, null), OxShape.INSTANCE.getPill()), chartBar.m10151getColor0d7_KjU(), null, 2, null), composer, 0);
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
