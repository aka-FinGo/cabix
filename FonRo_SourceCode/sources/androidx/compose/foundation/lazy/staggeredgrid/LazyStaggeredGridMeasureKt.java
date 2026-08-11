package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyStaggeredGridMeasure.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082\b\u001a5\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\n0\u000e¢\u0006\u0002\b\u000fH\u0082\b¢\u0006\u0002\u0010\u0010\u001aR\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u000e2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u0001H\u0082\b\u001aK\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010$\u001a\u001d\u0010%\u001a\u00020\b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001e0\u001dH\u0002¢\u0006\u0002\u0010&\u001a\u001c\u0010'\u001a\u00020\u0005*\u00020\u00142\u0006\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u0003H\u0002\u001a7\u0010*\u001a\u00020\u0005\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00122\b\b\u0002\u0010+\u001a\u00020\u00012\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00050\u000eH\u0082\b\u001a\u001c\u0010-\u001a\u00020\u0003*\u00020\u00142\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0003H\u0002\u001a+\u00100\u001a\u00020\u0005*\u0002012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000eH\u0082\bø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a\f\u00104\u001a\u00020\u0003*\u00020 H\u0002\u001a2\u00105\u001a\u00020\u0003\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u001d2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00030\u000eH\u0082\b¢\u0006\u0002\u00106\u001a\u0016\u00107\u001a\u00020\u0003*\u00020 2\b\b\u0002\u00108\u001a\u00020\u0003H\u0000\u001aG\u00109\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012*\u00020\u00142\u0006\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u00012\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050=H\u0082\b\u001a\u001e\u0010>\u001a\u00020\u0003*\u00020 2\u0006\u0010?\u001a\u000201H\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a,\u0010B\u001a\u00020C*\u00020\u00142\u0006\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020 2\u0006\u0010G\u001a\u00020\u0001H\u0002\u001a¦\u0001\u0010H\u001a\u00020C*\u00020\f2\u0006\u0010I\u001a\u00020J2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u00012\u0006\u0010S\u001a\u00020\u00012\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00032\u0006\u0010W\u001a\u00020\u00032\u0006\u0010X\u001a\u00020\u00032\u0006\u0010Y\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00012\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020`H\u0000ø\u0001\u0000¢\u0006\u0004\ba\u0010b\u001a\u0014\u0010c\u001a\u00020\u0005*\u00020 2\u0006\u0010d\u001a\u00020\u0003H\u0002\u001a!\u0010e\u001a\u00020 *\u00020 2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006f"}, d2 = {"DebugLoggingEnabled", "", "Unset", "", "debugLog", "", "message", "Lkotlin/Function0;", "", "withDebugLogging", ExifInterface.GPS_DIRECTION_TRUE, "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "calculateExtraItems", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "position", "filter", "Lkotlin/ParameterName;", "name", "itemIndex", "beforeVisibleBounds", "calculateVisibleItems", "measuredItems", "", "Lkotlin/collections/ArrayDeque;", "itemScrollOffsets", "", "mainAxisLayoutSize", "minOffset", "maxOffset", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[IIII)Ljava/util/List;", "debugRender", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "ensureIndicesInRange", "indices", "itemCount", "fastForEach", "reverse", "action", "findPreviousItemIndex", "item", "lane", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "indexOfMaxValue", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMinValue", "minBound", "itemsRetainedForLookahead", "lastVisibleItemIndex", "itemsCount", "isLookingAhead", "Lkotlin/Function2;", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "initialScrollDelta", "initialItemIndices", "initialItemOffsets", "canRestartMeasure", "measureStaggeredGrid", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isInLookaheadScope", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "measureStaggeredGrid-C6celF4", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILkotlinx/coroutines/CoroutineScope;ZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;Landroidx/compose/ui/graphics/GraphicsContext;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "offsetBy", "delta", "transform", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;

    private static final void debugLog(Function0<String> function0) {
    }

    private static final <T> T withDebugLogging(LazyLayoutMeasureScope lazyLayoutMeasureScope, Function1<? super LazyLayoutMeasureScope, ? extends T> function1) {
        return function1.invoke(lazyLayoutMeasureScope);
    }

    private static final String debugRender(ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr) {
        return "";
    }

    /* renamed from: measureStaggeredGrid-C6celF4, reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m1267measureStaggeredGridC6celF4(LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridState lazyStaggeredGridState, List<Integer> list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, boolean z2, long j2, int i, int i2, int i3, int i4, CoroutineScope coroutineScope, boolean z3, boolean z4, LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, GraphicsContext graphicsContext) {
        int i5;
        int m1266maxInRangejy6DScQ;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i3, i4, z2, i2, coroutineScope, z3, z4, lazyStaggeredGridLayoutInfo, graphicsContext, null);
        int[] updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyStaggeredGridItemProvider, lazyStaggeredGridState.getScrollPosition().getIndices());
        int[] scrollOffsets = lazyStaggeredGridState.getScrollPosition().getScrollOffsets();
        if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            lazyStaggeredGridMeasureContext.getLaneInfo().reset();
            int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr = new int[laneCount];
            int i6 = 0;
            while (i6 < laneCount) {
                if (i6 >= updateScrollPositionIfTheFirstItemWasMoved$foundation_release.length || (m1266maxInRangejy6DScQ = updateScrollPositionIfTheFirstItemWasMoved$foundation_release[i6]) == -1) {
                    m1266maxInRangejy6DScQ = i6 == 0 ? 0 : m1266maxInRangejy6DScQ(iArr, SpanRange.m1277constructorimpl(0, i6)) + 1;
                }
                iArr[i6] = m1266maxInRangejy6DScQ;
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[i6], i6);
                i6++;
            }
            updateScrollPositionIfTheFirstItemWasMoved$foundation_release = iArr;
        }
        if (scrollOffsets.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            int laneCount2 = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr2 = new int[laneCount2];
            int i7 = 0;
            while (i7 < laneCount2) {
                if (i7 < scrollOffsets.length) {
                    i5 = scrollOffsets[i7];
                } else {
                    i5 = i7 == 0 ? 0 : iArr2[i7 - 1];
                }
                iArr2[i7] = i5;
                i7++;
            }
            scrollOffsets = iArr2;
        }
        return measure(lazyStaggeredGridMeasureContext, Math.round(lazyStaggeredGridState.scrollToBeConsumed$foundation_release(z4)), updateScrollPositionIfTheFirstItemWasMoved$foundation_release, scrollOffsets, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0229, code lost:
    
        r11 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x023f, code lost:
    
        r6 = indexOfMinValue$default(r14, 0, 1, null);
        r1 = kotlin.collections.ArraysKt.maxOrThrow(r8) + 1;
        r12 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x024a, code lost:
    
        if (r1 < r12) goto L400;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x092c, code lost:
    
        r7 = r13;
        r13 = r4;
        r15 = r48;
        r7 = r49;
        r24 = r3;
        r30 = r12;
        r12 = r26;
        r11 = r27;
        r3 = r0.m1262getSpanRangelOCCd4c(r0.getItemProvider(), r1, r6);
        r6 = r0.getLaneInfo();
        r47 = r8;
        r7 = (int) (r3 & 4294967295L);
        r8 = (int) (r3 >> r18);
        r9 = r7 - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0959, code lost:
    
        if (r9 == 1) goto L403;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x095b, code lost:
    
        r0 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x095e, code lost:
    
        r6.setLane(r1, r0);
        r0 = r46.getMeasuredItemProvider().m1271getAndMeasurejy6DScQ(r1, r3);
        r3 = m1266maxInRangejy6DScQ(r14, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x096e, code lost:
    
        if (r9 == 1) goto L409;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0970, code lost:
    
        r6 = r46.getLaneInfo().getGaps(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0978, code lost:
    
        if (r6 != null) goto L410;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x097a, code lost:
    
        r6 = new int[r46.getLaneCount()];
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0982, code lost:
    
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0983, code lost:
    
        if (r9 >= r7) goto L457;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0985, code lost:
    
        if (r6 == null) goto L459;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0987, code lost:
    
        r6[r9] = r3 - r14[r9];
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x098d, code lost:
    
        r47[r9] = r1;
        r14[r9] = r3 + r0.getMainAxisSizeWithSpacings();
        r7[r9].addLast(r0);
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x09a0, code lost:
    
        r46.getLaneInfo().setGaps(r1, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x09a7, code lost:
    
        if (r3 >= r2) goto L452;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x09ab, code lost:
    
        if (r14[r8] > r2) goto L453;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x09ad, code lost:
    
        r0.setVisible(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0981, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x095d, code lost:
    
        r0 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0571, code lost:
    
        if ((r1 != null ? r1.getIndex() : -1) > r15) goto L265;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x076f, code lost:
    
        if (r8[r1] < r7) goto L356;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x08c6, code lost:
    
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x02f9, code lost:
    
        r6 = indexOfMinValue$default(r9, 0, 1, null);
        r7 = indexOfMaxValue(r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x0304, code lost:
    
        if (r6 == r7) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x030a, code lost:
    
        if (r9[r6] != r9[r7]) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x030c, code lost:
    
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x030e, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x030f, code lost:
    
        r7 = r28[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x0312, code lost:
    
        if (r7 != (-1)) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:431:0x0314, code lost:
    
        r7 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:432:0x0315, code lost:
    
        r7 = findPreviousItemIndex(r0, r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x0319, code lost:
    
        if (r7 >= 0) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x035a, code lost:
    
        r11 = r27;
        r10 = r28;
        r25 = r1;
        r24 = r2;
        r1 = r0.m1262getSpanRangelOCCd4c(r0.getItemProvider(), r7, r6);
        r6 = r0.getLaneInfo();
        r30 = r12;
        r27 = r13;
        r12 = (int) (r1 & 4294967295L);
        r28 = r3;
        r13 = r4;
        r3 = (int) (r1 >> r18);
        r4 = r12 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:435:0x037e, code lost:
    
        if (r4 == 1) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x0380, code lost:
    
        r15 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x0383, code lost:
    
        r6.setLane(r7, r15);
        r6 = r0.getMeasuredItemProvider().m1271getAndMeasurejy6DScQ(r7, r1);
        r1 = m1266maxInRangejy6DScQ(r9, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:438:0x0393, code lost:
    
        if (r4 == 1) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:439:0x0395, code lost:
    
        r2 = r0.getLaneInfo().getGaps(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:441:0x039f, code lost:
    
        if (r3 >= r12) goto L505;
     */
    /* JADX WARN: Code restructure failed: missing block: B:443:0x03a3, code lost:
    
        if (r9[r3] == r1) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:444:0x03a5, code lost:
    
        r25 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:445:0x03a7, code lost:
    
        r49[r3].addFirst(r6);
        r10[r3] = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:446:0x03ae, code lost:
    
        if (r2 != null) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:447:0x03b0, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:449:0x03b4, code lost:
    
        r9[r3] = (r1 + r6.getMainAxisSizeWithSpacings()) + r4;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:450:0x03b2, code lost:
    
        r4 = r2[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:454:0x039e, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:455:0x0382, code lost:
    
        r15 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:457:0x031b, code lost:
    
        r10 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:458:0x031d, code lost:
    
        if (r1 != false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:460:0x0323, code lost:
    
        if (measure$lambda$43$misalignedStart(r10, r0, r9, r6) == false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:461:0x0350, code lost:
    
        r11 = r27;
        r24 = r2;
        r28 = r3;
        r30 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:470:0x0325, code lost:
    
        if (r50 == false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:471:0x0327, code lost:
    
        r0.getLaneInfo().reset();
        r1 = r10.length;
        r2 = new int[r1];
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:472:0x0332, code lost:
    
        if (r3 >= r1) goto L509;
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x0334, code lost:
    
        r2[r3] = -1;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x033b, code lost:
    
        r1 = r9.length;
        r3 = new int[r1];
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:476:0x033f, code lost:
    
        if (r4 >= r1) goto L510;
     */
    /* JADX WARN: Code restructure failed: missing block: B:477:0x0341, code lost:
    
        r3[r4] = r9[r6];
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:480:0x034f, code lost:
    
        return measure(r0, r27, r2, r3, false);
     */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0726  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x07c4  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x07dd  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0839  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x08ab  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x08b7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult measure(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext r46, int r47, int[] r48, int[] r49, boolean r50) {
        /*
            Method dump skipped, instructions count: 2763
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt.measure(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext, int, int[], int[], boolean):androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult");
    }

    private static final boolean measure$lambda$43$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (iArr2[i] < Math.max(-lazyStaggeredGridMeasureContext.getMainAxisSpacing(), 0) && i2 > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$43$misalignedStart(int[] iArr, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr2, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i2], i2) == -1 && iArr2[i2] != iArr2[i]) {
                return true;
            }
        }
        int length2 = iArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i3], i3) != -1 && iArr2[i3] >= iArr2[i]) {
                return true;
            }
        }
        int lane = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(0);
        return (lane == 0 || lane == -1 || lane == -2) ? false : true;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateVisibleItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr, int[] iArr, int i, int i2, int i3) {
        int i4 = 0;
        for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque : arrayDequeArr) {
            i4 += arrayDeque.size();
        }
        ArrayList arrayList = new ArrayList(i4);
        while (true) {
            for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque2 : arrayDequeArr) {
                if (!arrayDeque2.isEmpty()) {
                    int length = arrayDequeArr.length;
                    int i5 = -1;
                    int i6 = Integer.MAX_VALUE;
                    for (int i7 = 0; i7 < length; i7++) {
                        LazyStaggeredGridMeasuredItem firstOrNull = arrayDequeArr[i7].firstOrNull();
                        int index = firstOrNull != null ? firstOrNull.getIndex() : Integer.MAX_VALUE;
                        if (i6 > index) {
                            i5 = i7;
                            i6 = index;
                        }
                    }
                    LazyStaggeredGridMeasuredItem removeFirst = arrayDequeArr[i5].removeFirst();
                    if (removeFirst.getLane() == i5) {
                        long m1277constructorimpl = SpanRange.m1277constructorimpl(removeFirst.getLane(), removeFirst.getSpan());
                        int m1266maxInRangejy6DScQ = m1266maxInRangejy6DScQ(iArr, m1277constructorimpl);
                        int i8 = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions()[i5];
                        if (removeFirst.getMainAxisSize() + m1266maxInRangejy6DScQ >= i2 && m1266maxInRangejy6DScQ <= i3) {
                            removeFirst.position(m1266maxInRangejy6DScQ, i8, i);
                            arrayList.add(removeFirst);
                        }
                        int i9 = (int) (m1277constructorimpl & 4294967295L);
                        for (int i10 = (int) (m1277constructorimpl >> 32); i10 < i9; i10++) {
                            iArr[i10] = removeFirst.getMainAxisSizeWithSpacings() + m1266maxInRangejy6DScQ;
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
    
        r8 = r10.get(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> itemsRetainedForLookahead(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext r7, int r8, int r9, boolean r10, kotlin.jvm.functions.Function2<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem, ? super java.lang.Integer, kotlin.Unit> r11) {
        /*
            r0 = 0
            if (r10 == 0) goto Lf3
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo r10 = r7.getApproachLayoutInfo()
            if (r10 == 0) goto Lf3
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo r10 = r7.getApproachLayoutInfo()
            java.util.List r10 = r10.getVisibleItemsInfo()
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto Lf3
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo r10 = r7.getApproachLayoutInfo()
            java.util.List r10 = r10.getVisibleItemsInfo()
            int r1 = r10.size()
            int r1 = r1 + (-1)
        L27:
            r2 = -1
            if (r2 >= r1) goto L50
            java.lang.Object r2 = r10.get(r1)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo r2 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo) r2
            int r2 = r2.getIndex()
            if (r2 <= r8) goto L4d
            if (r1 == 0) goto L46
            int r2 = r1 + (-1)
            java.lang.Object r2 = r10.get(r2)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo r2 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo) r2
            int r2 = r2.getIndex()
            if (r2 > r8) goto L4d
        L46:
            java.lang.Object r8 = r10.get(r1)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo r8 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo) r8
            goto L51
        L4d:
            int r1 = r1 + (-1)
            goto L27
        L50:
            r8 = r0
        L51:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo r10 = r7.getApproachLayoutInfo()
            java.util.List r10 = r10.getVisibleItemsInfo()
            java.lang.Object r10 = kotlin.collections.CollectionsKt.last(r10)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo r10 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo) r10
            if (r8 == 0) goto Lf3
            int r8 = r8.getIndex()
            int r10 = r10.getIndex()
            int r9 = r9 + (-1)
            int r9 = java.lang.Math.min(r10, r9)
            if (r8 > r9) goto Lf3
            r10 = r0
        L72:
            r1 = 0
            if (r10 == 0) goto L8f
            r2 = r10
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
            r3 = r1
        L7d:
            if (r3 >= r2) goto L8f
            java.lang.Object r4 = r10.get(r3)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r4 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r4
            int r4 = r4.getIndex()
            if (r4 != r8) goto L8c
            goto Led
        L8c:
            int r3 = r3 + 1
            goto L7d
        L8f:
            if (r10 != 0) goto L98
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
        L98:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo r2 = r7.getApproachLayoutInfo()
            java.util.List r2 = r2.getVisibleItemsInfo()
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            int r3 = r3.size()
            r4 = r1
        La8:
            if (r4 >= r3) goto Lbb
            java.lang.Object r5 = r2.get(r4)
            r6 = r5
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo r6 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo) r6
            int r6 = r6.getIndex()
            if (r6 != r8) goto Lb8
            goto Lbc
        Lb8:
            int r4 = r4 + 1
            goto La8
        Lbb:
            r5 = r0
        Lbc:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo r5 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo) r5
            if (r5 == 0) goto Lc5
            int r2 = r5.getLane()
            goto Lc6
        Lc5:
            r2 = r1
        Lc6:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r3 = r7.getItemProvider()
            long r3 = r7.m1262getSpanRangelOCCd4c(r3, r8, r2)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r5 = r7.getMeasuredItemProvider()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r3 = r5.m1271getAndMeasurejy6DScQ(r8, r3)
            r10.add(r3)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots r4 = r7.getResolvedSlots()
            int[] r4 = r4.getPositions()
            int r5 = r4.length
            if (r5 <= r2) goto Le6
            r1 = r4[r2]
        Le6:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11.invoke(r3, r1)
        Led:
            if (r8 == r9) goto Lf2
            int r8 = r8 + 1
            goto L72
        Lf2:
            return r10
        Lf3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt.itemsRetainedForLookahead(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext, int, int, boolean, kotlin.jvm.functions.Function2):java.util.List");
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateExtraItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, Function1<? super LazyStaggeredGridMeasuredItem, Unit> function1, Function1<? super Integer, Boolean> function12, boolean z) {
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext.getPinnedItems();
        ArrayList arrayList = null;
        if (z) {
            int size = pinnedItems.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    int intValue = pinnedItems.get(size).intValue();
                    if (function12.invoke(Integer.valueOf(intValue)).booleanValue()) {
                        long m1262getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext.m1262getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue, 0);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        LazyStaggeredGridMeasuredItem m1271getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1271getAndMeasurejy6DScQ(intValue, m1262getSpanRangelOCCd4c);
                        function1.invoke(m1271getAndMeasurejy6DScQ);
                        arrayList.add(m1271getAndMeasurejy6DScQ);
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
        } else {
            int size2 = pinnedItems.size();
            for (int i2 = 0; i2 < size2; i2++) {
                int intValue2 = pinnedItems.get(i2).intValue();
                if (function12.invoke(Integer.valueOf(intValue2)).booleanValue()) {
                    long m1262getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext.m1262getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue2, 0);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem m1271getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1271getAndMeasurejy6DScQ(intValue2, m1262getSpanRangelOCCd4c2);
                    function1.invoke(m1271getAndMeasurejy6DScQ2);
                    arrayList.add(m1271getAndMeasurejy6DScQ2);
                }
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* renamed from: forEach-nIS5qE8, reason: not valid java name */
    private static final void m1265forEachnIS5qE8(long j, Function1<? super Integer, Unit> function1) {
        int i = (int) (j & 4294967295L);
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    private static final void offsetBy(int[] iArr, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
    }

    /* renamed from: maxInRange-jy6DScQ, reason: not valid java name */
    private static final int m1266maxInRangejy6DScQ(int[] iArr, long j) {
        int i = (int) (j & 4294967295L);
        int i2 = Integer.MIN_VALUE;
        for (int i3 = (int) (j >> 32); i3 < i; i3++) {
            i2 = Math.max(i2, iArr[i3]);
        }
        return i2;
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MIN_VALUE;
        }
        return indexOfMinValue(iArr, i);
    }

    public static final int indexOfMinValue(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = -1;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i + 1;
            int i6 = iArr[i4];
            if (i5 <= i6 && i6 < i3) {
                i2 = i4;
                i3 = i6;
            }
        }
        return i2;
    }

    private static final <T> int indexOfMinBy(T[] tArr, Function1<? super T, Integer> function1) {
        int length = tArr.length;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int intValue = function1.invoke(tArr[i3]).intValue();
            if (i2 > intValue) {
                i = i3;
                i2 = intValue;
            }
        }
        return i;
    }

    private static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i2 < i4) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private static final int[] transform(int[] iArr, Function1<? super Integer, Integer> function1) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = function1.invoke(Integer.valueOf(iArr[i])).intValue();
        }
        return iArr;
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i) {
        int length = iArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i2 = length - 1;
            while (true) {
                if (iArr[length] < i && lazyStaggeredGridMeasureContext.getLaneInfo().assignedToLane(iArr[length], length)) {
                    break;
                } else {
                    iArr[length] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[length], length);
                }
            }
            if (iArr[length] >= 0 && !lazyStaggeredGridMeasureContext.isFullSpan(lazyStaggeredGridMeasureContext.getItemProvider(), iArr[length])) {
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[length], length);
            }
            if (i2 < 0) {
                return;
            } else {
                length = i2;
            }
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2) {
        return lazyStaggeredGridMeasureContext.getLaneInfo().findPreviousItemIndex(i, i2);
    }

    private static final <T> void fastForEach(List<? extends T> list, boolean z, Function1<? super T, Unit> function1) {
        if (z) {
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i = size - 1;
                function1.invoke(list.get(size));
                if (i < 0) {
                    return;
                } else {
                    size = i;
                }
            }
        } else {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                function1.invoke(list.get(i2));
            }
        }
    }

    static /* synthetic */ void fastForEach$default(List list, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if (z) {
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i2 = size - 1;
                function1.invoke(list.get(size));
                if (i2 < 0) {
                    return;
                } else {
                    size = i2;
                }
            }
        } else {
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                function1.invoke(list.get(i3));
            }
        }
    }
}
