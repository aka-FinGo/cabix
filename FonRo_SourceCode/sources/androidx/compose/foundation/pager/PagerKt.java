package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Pager.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e21\u0010\u001f\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0002\b#¢\u0006\u0002\b$H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(21\u0010\u001f\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0002\b#¢\u0006\u0002\b$H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aâ\u0001\u0010+\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e21\u0010\u001f\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0002\b#¢\u0006\u0002\b$H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001aî\u0001\u0010+\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(21\u0010\u001f\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0002\b#¢\u0006\u0002\b$H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u0017\u00102\u001a\u00020\u00012\f\u00103\u001a\b\u0012\u0004\u0012\u00020504H\u0082\b\u001aL\u00106\u001a\u00020\u000b*\u00020\u001e2\u0006\u00107\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u000bH\u0000\u001a,\u0010?\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u00132\u0006\u0010A\u001a\u00020B2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C"}, d2 = {"HorizontalPager", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "", "reverseLayout", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "HorizontalPager--8jOkeI", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "VerticalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager--8jOkeI", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "currentPageOffset", "layoutSize", "spaceBetweenPages", "beforeContentPadding", "afterContentPadding", "currentPage", "currentPageOffsetFraction", "", "pageCount", "pagerSemantics", "isVertical", "scope", "Lkotlinx/coroutines/CoroutineScope;", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PagerKt {
    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03ef  */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    /* renamed from: HorizontalPager--8jOkeI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1293HorizontalPager8jOkeI(final androidx.compose.foundation.pager.PagerState r36, androidx.compose.ui.Modifier r37, androidx.compose.foundation.layout.PaddingValues r38, androidx.compose.foundation.pager.PageSize r39, int r40, float r41, androidx.compose.ui.Alignment.Vertical r42, androidx.compose.foundation.gestures.TargetedFlingBehavior r43, boolean r44, boolean r45, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r46, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r47, androidx.compose.foundation.gestures.snapping.SnapPosition r48, androidx.compose.foundation.OverscrollEffect r49, final kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, androidx.compose.runtime.Composer r51, final int r52, final int r53, final int r54) {
        /*
            Method dump skipped, instructions count: 1033
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m1293HorizontalPager8jOkeI(androidx.compose.foundation.pager.PagerState, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.pager.PageSize, int, float, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.TargetedFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, androidx.compose.foundation.gestures.snapping.SnapPosition, androidx.compose.foundation.OverscrollEffect, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* renamed from: HorizontalPager-oI3XNZo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m1294HorizontalPageroI3XNZo(final androidx.compose.foundation.pager.PagerState r34, androidx.compose.ui.Modifier r35, androidx.compose.foundation.layout.PaddingValues r36, androidx.compose.foundation.pager.PageSize r37, int r38, float r39, androidx.compose.ui.Alignment.Vertical r40, androidx.compose.foundation.gestures.TargetedFlingBehavior r41, boolean r42, boolean r43, kotlin.jvm.functions.Function1 r44, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r45, androidx.compose.foundation.gestures.snapping.SnapPosition r46, final kotlin.jvm.functions.Function4 r47, androidx.compose.runtime.Composer r48, final int r49, final int r50, final int r51) {
        /*
            Method dump skipped, instructions count: 851
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m1294HorizontalPageroI3XNZo(androidx.compose.foundation.pager.PagerState, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.pager.PageSize, int, float, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.TargetedFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, androidx.compose.foundation.gestures.snapping.SnapPosition, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03ef  */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    /* renamed from: VerticalPager--8jOkeI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1295VerticalPager8jOkeI(final androidx.compose.foundation.pager.PagerState r36, androidx.compose.ui.Modifier r37, androidx.compose.foundation.layout.PaddingValues r38, androidx.compose.foundation.pager.PageSize r39, int r40, float r41, androidx.compose.ui.Alignment.Horizontal r42, androidx.compose.foundation.gestures.TargetedFlingBehavior r43, boolean r44, boolean r45, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r46, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r47, androidx.compose.foundation.gestures.snapping.SnapPosition r48, androidx.compose.foundation.OverscrollEffect r49, final kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, androidx.compose.runtime.Composer r51, final int r52, final int r53, final int r54) {
        /*
            Method dump skipped, instructions count: 1033
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m1295VerticalPager8jOkeI(androidx.compose.foundation.pager.PagerState, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.pager.PageSize, int, float, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.TargetedFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, androidx.compose.foundation.gestures.snapping.SnapPosition, androidx.compose.foundation.OverscrollEffect, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* renamed from: VerticalPager-oI3XNZo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m1296VerticalPageroI3XNZo(final androidx.compose.foundation.pager.PagerState r34, androidx.compose.ui.Modifier r35, androidx.compose.foundation.layout.PaddingValues r36, androidx.compose.foundation.pager.PageSize r37, int r38, float r39, androidx.compose.ui.Alignment.Horizontal r40, androidx.compose.foundation.gestures.TargetedFlingBehavior r41, boolean r42, boolean r43, kotlin.jvm.functions.Function1 r44, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r45, androidx.compose.foundation.gestures.snapping.SnapPosition r46, final kotlin.jvm.functions.Function4 r47, androidx.compose.runtime.Composer r48, final int r49, final int r50, final int r51) {
        /*
            Method dump skipped, instructions count: 851
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m1296VerticalPageroI3XNZo(androidx.compose.foundation.pager.PagerState, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.pager.PageSize, int, float, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.TargetedFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, androidx.compose.foundation.gestures.snapping.SnapPosition, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final int currentPageOffset(SnapPosition snapPosition, int i, int i2, int i3, int i4, int i5, int i6, float f, int i7) {
        return MathKt.roundToInt(snapPosition.position(i, i2, i4, i5, i6, i7) - (f * (i2 + i3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performForwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollForward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PagerKt$pagerSemantics$performForwardPaging$1(pagerState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performBackwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollBackward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PagerKt$pagerSemantics$performBackwardPaging$1(pagerState, null), 3, null);
        return true;
    }

    public static final Modifier pagerSemantics(Modifier modifier, final PagerState pagerState, final boolean z, final CoroutineScope coroutineScope, boolean z2) {
        if (z2) {
            return modifier.then(SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    if (z) {
                        final PagerState pagerState2 = pagerState;
                        final CoroutineScope coroutineScope2 = coroutineScope;
                        SemanticsPropertiesKt.pageUp$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                boolean pagerSemantics$performBackwardPaging;
                                pagerSemantics$performBackwardPaging = PagerKt.pagerSemantics$performBackwardPaging(PagerState.this, coroutineScope2);
                                return Boolean.valueOf(pagerSemantics$performBackwardPaging);
                            }
                        }, 1, null);
                        final PagerState pagerState3 = pagerState;
                        final CoroutineScope coroutineScope3 = coroutineScope;
                        SemanticsPropertiesKt.pageDown$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                boolean pagerSemantics$performForwardPaging;
                                pagerSemantics$performForwardPaging = PagerKt.pagerSemantics$performForwardPaging(PagerState.this, coroutineScope3);
                                return Boolean.valueOf(pagerSemantics$performForwardPaging);
                            }
                        }, 1, null);
                        return;
                    }
                    final PagerState pagerState4 = pagerState;
                    final CoroutineScope coroutineScope4 = coroutineScope;
                    SemanticsPropertiesKt.pageLeft$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            boolean pagerSemantics$performBackwardPaging;
                            pagerSemantics$performBackwardPaging = PagerKt.pagerSemantics$performBackwardPaging(PagerState.this, coroutineScope4);
                            return Boolean.valueOf(pagerSemantics$performBackwardPaging);
                        }
                    }, 1, null);
                    final PagerState pagerState5 = pagerState;
                    final CoroutineScope coroutineScope5 = coroutineScope;
                    SemanticsPropertiesKt.pageRight$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            boolean pagerSemantics$performForwardPaging;
                            pagerSemantics$performForwardPaging = PagerKt.pagerSemantics$performForwardPaging(PagerState.this, coroutineScope5);
                            return Boolean.valueOf(pagerSemantics$performForwardPaging);
                        }
                    }, 1, null);
                }
            }, 1, null));
        }
        return modifier.then(Modifier.INSTANCE);
    }
}
