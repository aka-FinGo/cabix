package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.gestures.snapping.SnapPositionKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PagerMeasure.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002\u001aH\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0015H\u0002\u001a@\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0015H\u0002\u001a\u0017\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0082\b\u001a\u008c\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e*\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0002\u001aj\u0010\u0014\u001a\u00020\u0004*\u00020\u001f2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010(\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\u0006\u0010*\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001añ\u0001\u0010?\u001a\u00020@*\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u00103\u001a\u0002042\u0006\u0010A\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u0002022\u0006\u0010(\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010:2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010*\u001a\u00020+2\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2/\u0010I\u001a+\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\u00190\u0015¢\u0006\u0002\bL\u0012\u0004\u0012\u00020M0JH\u0000ø\u0001\u0000¢\u0006\u0004\bN\u0010O\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006P"}, d2 = {"MaxPageOffset", "", "MinPageOffset", "calculateNewCurrentPage", "Landroidx/compose/foundation/pager/MeasuredPage;", "viewportSize", "", "visiblePagesInfo", "", "beforeContentPadding", "afterContentPadding", "itemSize", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageCount", "createPagesAfterList", "currentLastPage", "pagesCount", "beyondViewportPageCount", "pinnedPages", "getAndMeasure", "Lkotlin/Function1;", "createPagesBeforeList", "currentFirstPage", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "calculatePagesOffsets", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "", "density", "Landroidx/compose/ui/unit/Density;", "spaceBetweenPages", "pageAvailableSize", FirebaseAnalytics.Param.INDEX, "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-SGf7dI0", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZI)Landroidx/compose/foundation/pager/MeasuredPage;", "measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "mainAxisAvailableSize", "currentPage", "currentPageOffset", "constraints", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measurePager-bmk8ZPk", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/MutableState;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PagerMeasureKt {
    public static final float MaxPageOffset = 0.5f;
    public static final float MinPageOffset = -0.5f;

    private static final int calculatePagesOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    /* renamed from: measurePager-bmk8ZPk, reason: not valid java name */
    public static final PagerMeasureResult m1300measurePagerbmk8ZPk(final LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, final PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, long j, final Orientation orientation, final Alignment.Vertical vertical, final Alignment.Horizontal horizontal, final boolean z, final long j2, final int i8, int i9, List<Integer> list, SnapPosition snapPosition, final MutableState<Unit> mutableState, CoroutineScope coroutineScope, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i10;
        boolean z2;
        int i11;
        int i12;
        int i13;
        int i14;
        MeasuredPage measuredPage;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i15;
        if (!(i3 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("negative beforeContentPadding");
        }
        if (!(i4 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("negative afterContentPadding");
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(i8 + i5, 0);
        if (i <= 0) {
            return new PagerMeasureResult(CollectionsKt.emptyList(), i8, i5, i4, orientation, -i3, i2 + i4, false, i9, null, null, 0.0f, 0, false, snapPosition, function3.invoke(Integer.valueOf(Constraints.m6944getMinWidthimpl(j)), Integer.valueOf(Constraints.m6943getMinHeightimpl(j)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), false, null, null, coroutineScope, 393216, null);
        }
        Orientation orientation2 = orientation;
        final long Constraints$default = ConstraintsKt.Constraints$default(0, orientation2 == Orientation.Vertical ? Constraints.m6942getMaxWidthimpl(j) : i8, 0, orientation2 != Orientation.Vertical ? Constraints.m6941getMaxHeightimpl(j) : i8, 5, null);
        int i16 = i6;
        int i17 = i7;
        while (i16 > 0 && i17 > 0) {
            i16--;
            i17 -= coerceAtLeast;
        }
        int i18 = i17 * (-1);
        if (i16 >= i) {
            i16 = i - 1;
            i18 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i19 = -i3;
        int i20 = (i5 < 0 ? i5 : 0) + i19;
        int i21 = i18 + i20;
        int i22 = 0;
        while (i21 < 0 && i16 > 0) {
            int i23 = i16 - 1;
            MeasuredPage m1299getAndMeasureSGf7dI0 = m1299getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i23, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation2, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
            arrayDeque.add(0, m1299getAndMeasureSGf7dI0);
            i22 = Math.max(i22, m1299getAndMeasureSGf7dI0.getCrossAxisSize());
            i21 += coerceAtLeast;
            i20 = i20;
            i16 = i23;
            orientation2 = orientation;
        }
        int i24 = i20;
        int i25 = i22;
        if (i21 < i24) {
            i21 = i24;
        }
        int i26 = i21 - i24;
        int i27 = i2 + i4;
        int i28 = i16;
        int coerceAtLeast2 = RangesKt.coerceAtLeast(i27, 0);
        int i29 = -i26;
        int i30 = i28;
        int i31 = 0;
        boolean z3 = false;
        while (i31 < arrayDeque.size()) {
            if (i29 >= coerceAtLeast2) {
                arrayDeque.remove(i31);
                z3 = true;
            } else {
                i30++;
                i29 += coerceAtLeast;
                i31++;
            }
        }
        int i32 = i25;
        int i33 = i30;
        boolean z4 = z3;
        int i34 = i26;
        while (i33 < i && (i29 < coerceAtLeast2 || i29 <= 0 || arrayDeque.isEmpty())) {
            int i35 = coerceAtLeast2;
            int i36 = i33;
            MeasuredPage m1299getAndMeasureSGf7dI02 = m1299getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i36, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
            int i37 = i34;
            int i38 = i - 1;
            i29 += i36 == i38 ? i8 : coerceAtLeast;
            if (i29 > i24 || i36 == i38) {
                i32 = Math.max(i32, m1299getAndMeasureSGf7dI02.getCrossAxisSize());
                arrayDeque.add(m1299getAndMeasureSGf7dI02);
                i15 = i28;
                i34 = i37;
            } else {
                i15 = i36 + 1;
                i34 = i37 - coerceAtLeast;
                z4 = true;
            }
            i33 = i36 + 1;
            i28 = i15;
            coerceAtLeast2 = i35;
        }
        int i39 = i34;
        if (i29 < i2) {
            int i40 = i2 - i29;
            i12 = i39 - i40;
            i29 += i40;
            i11 = i32;
            i13 = i28;
            while (i12 < i3 && i13 > 0) {
                int i41 = i13 - 1;
                MeasuredPage m1299getAndMeasureSGf7dI03 = m1299getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i41, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
                arrayDeque.add(0, m1299getAndMeasureSGf7dI03);
                i11 = Math.max(i11, m1299getAndMeasureSGf7dI03.getCrossAxisSize());
                i12 += coerceAtLeast;
                i33 = i33;
                i13 = i41;
            }
            i10 = i33;
            z2 = false;
            if (i12 < 0) {
                i29 += i12;
                i12 = 0;
            }
        } else {
            i10 = i33;
            z2 = false;
            i11 = i32;
            i12 = i39;
            i13 = i28;
        }
        if (!(i12 >= 0 ? true : z2)) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid currentFirstPageScrollOffset");
        }
        int i42 = i11;
        int i43 = -i12;
        MeasuredPage measuredPage2 = (MeasuredPage) arrayDeque.first();
        if (i3 > 0 || i5 < 0) {
            int size = arrayDeque.size();
            i14 = i43;
            int i44 = 0;
            while (i44 < size && i12 != 0 && coerceAtLeast <= i12 && i44 != CollectionsKt.getLastIndex(arrayDeque)) {
                i12 -= coerceAtLeast;
                i44++;
                measuredPage2 = (MeasuredPage) arrayDeque.get(i44);
            }
        } else {
            i14 = i43;
        }
        int i45 = i12;
        MeasuredPage measuredPage3 = measuredPage2;
        List<MeasuredPage> createPagesBeforeList = createPagesBeforeList(i13, i9, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int i46) {
                MeasuredPage m1299getAndMeasureSGf7dI04;
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = LazyLayoutMeasureScope.this;
                m1299getAndMeasureSGf7dI04 = PagerMeasureKt.m1299getAndMeasureSGf7dI0(lazyLayoutMeasureScope2, i46, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z, i8);
                return m1299getAndMeasureSGf7dI04;
            }
        });
        int size2 = createPagesBeforeList.size();
        int i46 = i42;
        int i47 = 0;
        while (i47 < size2) {
            i46 = Math.max(i46, createPagesBeforeList.get(i47).getCrossAxisSize());
            i47++;
            createPagesBeforeList = createPagesBeforeList;
        }
        List<MeasuredPage> list2 = createPagesBeforeList;
        List<MeasuredPage> createPagesAfterList = createPagesAfterList(((MeasuredPage) arrayDeque.last()).getIndex(), i, i9, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int i48) {
                MeasuredPage m1299getAndMeasureSGf7dI04;
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = LazyLayoutMeasureScope.this;
                m1299getAndMeasureSGf7dI04 = PagerMeasureKt.m1299getAndMeasureSGf7dI0(lazyLayoutMeasureScope2, i48, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z, i8);
                return m1299getAndMeasureSGf7dI04;
            }
        });
        int size3 = createPagesAfterList.size();
        for (int i48 = 0; i48 < size3; i48++) {
            i46 = Math.max(i46, createPagesAfterList.get(i48).getCrossAxisSize());
        }
        boolean z5 = Intrinsics.areEqual(measuredPage3, arrayDeque.first()) && list2.isEmpty() && createPagesAfterList.isEmpty();
        int m6959constrainWidthK40F9xA = ConstraintsKt.m6959constrainWidthK40F9xA(j, orientation == Orientation.Vertical ? i46 : i29);
        if (orientation == Orientation.Vertical) {
            i46 = i29;
        }
        int m6958constrainHeightK40F9xA = ConstraintsKt.m6958constrainHeightK40F9xA(j, i46);
        int i49 = i10;
        int i50 = i29;
        final List<MeasuredPage> calculatePagesOffsets = calculatePagesOffsets(lazyLayoutMeasureScope, arrayDeque, list2, createPagesAfterList, m6959constrainWidthK40F9xA, m6958constrainHeightK40F9xA, i50, i2, i14, orientation, z, lazyLayoutMeasureScope, i5, i8);
        if (z5) {
            measuredPage = measuredPage3;
            arrayList = calculatePagesOffsets;
        } else {
            ArrayList arrayList4 = new ArrayList(calculatePagesOffsets.size());
            int size4 = calculatePagesOffsets.size();
            int i51 = 0;
            while (i51 < size4) {
                MeasuredPage measuredPage4 = calculatePagesOffsets.get(i51);
                MeasuredPage measuredPage5 = measuredPage4;
                MeasuredPage measuredPage6 = measuredPage3;
                ArrayList arrayList5 = arrayList4;
                if (measuredPage5.getIndex() >= ((MeasuredPage) arrayDeque.first()).getIndex() && measuredPage5.getIndex() <= ((MeasuredPage) arrayDeque.last()).getIndex()) {
                    arrayList5.add(measuredPage4);
                }
                i51++;
                arrayList4 = arrayList5;
                measuredPage3 = measuredPage6;
            }
            measuredPage = measuredPage3;
            arrayList = arrayList4;
        }
        if (list2.isEmpty()) {
            arrayList2 = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList6 = new ArrayList(calculatePagesOffsets.size());
            int size5 = calculatePagesOffsets.size();
            int i52 = 0;
            while (i52 < size5) {
                MeasuredPage measuredPage7 = calculatePagesOffsets.get(i52);
                ArrayList arrayList7 = arrayList6;
                if (measuredPage7.getIndex() < ((MeasuredPage) arrayDeque.first()).getIndex()) {
                    arrayList7.add(measuredPage7);
                }
                i52++;
                arrayList6 = arrayList7;
            }
            arrayList2 = arrayList6;
        }
        List list3 = arrayList2;
        if (createPagesAfterList.isEmpty()) {
            arrayList3 = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList8 = new ArrayList(calculatePagesOffsets.size());
            int size6 = calculatePagesOffsets.size();
            for (int i53 = 0; i53 < size6; i53++) {
                MeasuredPage measuredPage8 = calculatePagesOffsets.get(i53);
                if (measuredPage8.getIndex() > ((MeasuredPage) arrayDeque.last()).getIndex()) {
                    arrayList8.add(measuredPage8);
                }
            }
            arrayList3 = arrayList8;
        }
        List list4 = arrayList3;
        MeasuredPage calculateNewCurrentPage = calculateNewCurrentPage(i2 + i3 + i4, arrayList, i3, i4, coerceAtLeast, snapPosition, i);
        return new PagerMeasureResult(arrayList, i8, i5, i4, orientation, i19, i27, z, i9, measuredPage, calculateNewCurrentPage, coerceAtLeast == 0 ? 0.0f : RangesKt.coerceIn((snapPosition.position(r0, i8, i3, i4, calculateNewCurrentPage != null ? calculateNewCurrentPage.getIndex() : 0, i) - (calculateNewCurrentPage != null ? calculateNewCurrentPage.getOffset() : 0)) / coerceAtLeast, -0.5f, 0.5f), i45, i49 < i || i50 > i2, snapPosition, function3.invoke(Integer.valueOf(m6959constrainWidthK40F9xA), Integer.valueOf(m6958constrainHeightK40F9xA), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$14
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                final List<MeasuredPage> list5 = calculatePagesOffsets;
                placementScope.withMotionFrameOfReferencePlacement(new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$14.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope2) {
                        invoke2(placementScope2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope placementScope2) {
                        List<MeasuredPage> list6 = list5;
                        int size7 = list6.size();
                        for (int i54 = 0; i54 < size7; i54++) {
                            list6.get(i54).place(placementScope2);
                        }
                    }
                });
                ObservableScopeInvalidator.m1228attachToScopeimpl(mutableState);
            }
        }), z4, list3, list4, coroutineScope);
    }

    private static final List<MeasuredPage> createPagesAfterList(int i, int i2, int i3, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int min = Math.min(i3 + i, i2 - 1);
        int i4 = i + 1;
        ArrayList arrayList = null;
        if (i4 <= min) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i4)));
                if (i4 == min) {
                    break;
                }
                i4++;
            }
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            int intValue = list.get(i5).intValue();
            if (min + 1 <= intValue && intValue < i2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(intValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int i, int i2, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int max = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (max <= i3) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i3)));
                if (i3 == max) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            int intValue = list.get(i4).intValue();
            if (intValue < max) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(intValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAndMeasure-SGf7dI0, reason: not valid java name */
    public static final MeasuredPage m1299getAndMeasureSGf7dI0(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j2, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z, int i2) {
        return new MeasuredPage(i, i2, lazyLayoutMeasureScope.mo1223measure0kLqBqw(i, j), j2, pagerLazyLayoutItemProvider.getKey(i), orientation, horizontal, vertical, layoutDirection, z, null);
    }

    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope lazyLayoutMeasureScope, List<MeasuredPage> list, List<MeasuredPage> list2, List<MeasuredPage> list3, int i, int i2, int i3, int i4, int i5, Orientation orientation, boolean z, Density density, int i6, int i7) {
        ArrayList arrayList;
        int i8 = i5;
        int i9 = i7 + i6;
        int i10 = orientation == Orientation.Vertical ? i2 : i;
        boolean z2 = i3 < Math.min(i10, i4);
        if (z2) {
            if (!(i8 == 0)) {
                InlineClassHelperKt.throwIllegalStateException("non-zero pagesScrollOffset=" + i8);
            }
        }
        ArrayList arrayList2 = new ArrayList(list.size() + list2.size() + list3.size());
        if (z2) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                InlineClassHelperKt.throwIllegalArgumentException("No extra pages");
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i11 = 0; i11 < size; i11++) {
                iArr[i11] = i7;
            }
            int[] iArr2 = new int[size];
            Arrangement.HorizontalOrVertical m933spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m933spacedBy0680j_4(lazyLayoutMeasureScope.mo697toDpu2uoSUM(i6));
            if (orientation == Orientation.Vertical) {
                m933spacedBy0680j_4.arrange(density, i10, iArr, iArr2);
                arrayList = arrayList2;
            } else {
                arrayList = arrayList2;
                m933spacedBy0680j_4.arrange(density, i10, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i12 = iArr2[first];
                    MeasuredPage measuredPage = list.get(calculatePagesOffsets$reverseAware(first, z, size));
                    if (z) {
                        i12 = (i10 - i12) - measuredPage.getSize();
                    }
                    measuredPage.position(i12, i, i2);
                    arrayList.add(measuredPage);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            arrayList = arrayList2;
            int size2 = list2.size();
            int i13 = i8;
            for (int i14 = 0; i14 < size2; i14++) {
                MeasuredPage measuredPage2 = list2.get(i14);
                i13 -= i9;
                measuredPage2.position(i13, i, i2);
                arrayList.add(measuredPage2);
            }
            int size3 = list.size();
            for (int i15 = 0; i15 < size3; i15++) {
                MeasuredPage measuredPage3 = list.get(i15);
                measuredPage3.position(i8, i, i2);
                arrayList.add(measuredPage3);
                i8 += i9;
            }
            int size4 = list3.size();
            for (int i16 = 0; i16 < size4; i16++) {
                MeasuredPage measuredPage4 = list3.get(i16);
                measuredPage4.position(i8, i, i2);
                arrayList.add(measuredPage4);
                i8 += i9;
            }
        }
        return arrayList;
    }

    private static final MeasuredPage calculateNewCurrentPage(int i, List<MeasuredPage> list, int i2, int i3, int i4, SnapPosition snapPosition, int i5) {
        MeasuredPage measuredPage;
        if (list.isEmpty()) {
            measuredPage = null;
        } else {
            MeasuredPage measuredPage2 = list.get(0);
            MeasuredPage measuredPage3 = measuredPage2;
            float f = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i, i2, i3, i4, measuredPage3.getOffset(), measuredPage3.getIndex(), snapPosition, i5));
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                int i6 = 1;
                while (true) {
                    MeasuredPage measuredPage4 = list.get(i6);
                    MeasuredPage measuredPage5 = measuredPage4;
                    float f2 = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i, i2, i3, i4, measuredPage5.getOffset(), measuredPage5.getIndex(), snapPosition, i5));
                    if (Float.compare(f, f2) < 0) {
                        f = f2;
                        measuredPage2 = measuredPage4;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
            measuredPage = measuredPage2;
        }
        return measuredPage;
    }
}
