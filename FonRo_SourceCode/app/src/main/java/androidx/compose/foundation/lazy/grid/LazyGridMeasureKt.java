package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: LazyGridMeasure.kt */
@Metadata(d1 = {"\u0000´\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nH\u0082\b\u001a\u008c\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002\u001aF\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u000b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\b\u0010$\u001a\u0004\u0018\u00010%H\u0002\u001aÜ\u0002\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0002032\u0006\u00104\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u00105\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\b\u00106\u001a\u0004\u0018\u00010%2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<23\u0010=\u001a/\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002010A0\u00010\n2\b\u0010B\u001a\u0004\u0018\u00010C2/\u0010D\u001a+\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020G0\n¢\u0006\u0002\bH\u0012\u0004\u0012\u00020I0EH\u0000ø\u0001\u0000¢\u0006\u0004\bJ\u0010K\u001a+\u0010L\u001a\u00020G\"\u0004\b\u0000\u0010M*\b\u0012\u0004\u0012\u0002HM0\r2\f\u0010N\u001a\b\u0012\u0004\u0012\u0002HM0OH\u0002¢\u0006\u0002\u0010P\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Q"}, d2 = {"calculateExtraItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "pinnedItems", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "filter", "Lkotlin/Function1;", "", "calculateItemsOffsets", "", "lines", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "isVertical", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "linesRetainedForLookahead", "lastVisibleItemIndex", "itemsCount", "isLookingAhead", "visibleLines", "lastApproachLayoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "slotsPerLine", "isInLookaheadScope", "approachLayoutInfo", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "prefetchInfoRetriever", "Lkotlin/ParameterName;", "name", "line", "Lkotlin/Pair;", "stickyItemsScrollBehavior", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-GyuLg2I", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "addAllFromArray", ExifInterface.GPS_DIRECTION_TRUE, "arr", "", "(Ljava/util/List;[Ljava/lang/Object;)V", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyGridMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0498  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0239  */
    /* renamed from: measureLazyGrid-GyuLg2I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.foundation.lazy.grid.LazyGridMeasureResult m1193measureLazyGridGyuLg2I(int r54, final androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider r55, final androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider r56, int r57, int r58, int r59, int r60, int r61, int r62, float r63, long r64, boolean r66, androidx.compose.foundation.layout.Arrangement.Vertical r67, androidx.compose.foundation.layout.Arrangement.Horizontal r68, boolean r69, androidx.compose.ui.unit.Density r70, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r71, int r72, java.util.List<java.lang.Integer> r73, boolean r74, final boolean r75, androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo r76, kotlinx.coroutines.CoroutineScope r77, final androidx.compose.runtime.MutableState<kotlin.Unit> r78, androidx.compose.ui.graphics.GraphicsContext r79, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.util.List<kotlin.Pair<java.lang.Integer, androidx.compose.ui.unit.Constraints>>> r80, androidx.compose.foundation.lazy.layout.StickyItemsPlacement r81, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, kotlin.Unit>, ? extends androidx.compose.ui.layout.MeasureResult> r82) {
        /*
            Method dump skipped, instructions count: 1220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt.m1193measureLazyGridGyuLg2I(int, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider, int, int, int, int, int, int, float, long, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator, int, java.util.List, boolean, boolean, androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo, kotlinx.coroutines.CoroutineScope, androidx.compose.runtime.MutableState, androidx.compose.ui.graphics.GraphicsContext, kotlin.jvm.functions.Function1, androidx.compose.foundation.lazy.layout.StickyItemsPlacement, kotlin.jvm.functions.Function3):androidx.compose.foundation.lazy.grid.LazyGridMeasureResult");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        r6 = r9.get(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine> linesRetainedForLookahead(int r6, int r7, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider r8, boolean r9, java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine> r10, androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo r11) {
        /*
            r0 = 0
            if (r9 == 0) goto Lb3
            if (r11 == 0) goto Lb3
            java.util.List r9 = r11.getVisibleItemsInfo()
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto Lb3
            java.util.List r9 = r11.getVisibleItemsInfo()
            int r1 = r9.size()
            int r1 = r1 + (-1)
        L1b:
            r2 = -1
            if (r2 >= r1) goto L44
            java.lang.Object r2 = r9.get(r1)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r2 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r2
            int r2 = r2.getIndex()
            if (r2 <= r6) goto L41
            if (r1 == 0) goto L3a
            int r2 = r1 + (-1)
            java.lang.Object r2 = r9.get(r2)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r2 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r2
            int r2 = r2.getIndex()
            if (r2 > r6) goto L41
        L3a:
            java.lang.Object r6 = r9.get(r1)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r6 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r6
            goto L45
        L41:
            int r1 = r1 + (-1)
            goto L1b
        L44:
            r6 = r0
        L45:
            java.util.List r9 = r11.getVisibleItemsInfo()
            java.lang.Object r9 = kotlin.collections.CollectionsKt.last(r9)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r9 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r9
            java.lang.Object r10 = kotlin.collections.CollectionsKt.lastOrNull(r10)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r10 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r10
            r11 = 0
            if (r10 == 0) goto L5f
            int r10 = r10.getIndex()
            int r10 = r10 + 1
            goto L60
        L5f:
            r10 = r11
        L60:
            if (r6 == 0) goto Lb3
            int r6 = r6.getIndex()
            int r9 = r9.getIndex()
            int r7 = r7 + (-1)
            int r7 = java.lang.Math.min(r9, r7)
            if (r6 > r7) goto Lb3
        L72:
            if (r0 == 0) goto L9b
            r9 = r0
            java.util.Collection r9 = (java.util.Collection) r9
            int r9 = r9.size()
            r1 = r11
        L7c:
            if (r1 >= r9) goto L9b
            java.lang.Object r2 = r0.get(r1)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r2 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r2
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r2 = r2.getItems()
            int r3 = r2.length
            r4 = r11
        L8a:
            if (r4 >= r3) goto L98
            r5 = r2[r4]
            int r5 = r5.getIndex()
            if (r5 != r6) goto L95
            goto Lae
        L95:
            int r4 = r4 + 1
            goto L8a
        L98:
            int r1 = r1 + 1
            goto L7c
        L9b:
            if (r0 != 0) goto La5
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r0 = r9
            java.util.List r0 = (java.util.List) r0
        La5:
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r9 = r8.getAndMeasure(r10)
            int r10 = r10 + 1
            r0.add(r9)
        Lae:
            if (r6 == r7) goto Lb3
            int r6 = r6 + 1
            goto L72
        Lb3:
            if (r0 != 0) goto Lba
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
            return r6
        Lba:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt.linesRetainedForLookahead(int, int, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider, boolean, java.util.List, androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo):java.util.List");
    }

    private static final List<LazyGridMeasuredItem> calculateItemsOffsets(List<LazyGridMeasuredLine> list, List<LazyGridMeasuredItem> list2, List<LazyGridMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3) {
            if (!(i5 == 0)) {
                InlineClassHelperKt.throwIllegalStateException("non-zero firstLineScrollOffset");
            }
        }
        List<LazyGridMeasuredLine> list4 = list;
        int size = list4.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            i7 += list.get(i8).getItems().length;
        }
        ArrayList arrayList = new ArrayList(i7);
        if (z3) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                InlineClassHelperKt.throwIllegalArgumentException("no items");
            }
            int size2 = list.size();
            int[] iArr = new int[size2];
            for (int i9 = 0; i9 < size2; i9++) {
                iArr[i9] = list.get(calculateItemsOffsets$reverseAware(i9, z2, size2)).getMainAxisSize();
            }
            int[] iArr2 = new int[size2];
            if (z) {
                if (vertical != null) {
                    vertical.arrange(density, i6, iArr, iArr2);
                } else {
                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement");
                    throw new KotlinNothingValueException();
                }
            } else if (horizontal != null) {
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            } else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement");
                throw new KotlinNothingValueException();
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z2) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i10 = iArr2[first];
                    LazyGridMeasuredLine lazyGridMeasuredLine = list.get(calculateItemsOffsets$reverseAware(first, z2, size2));
                    if (z2) {
                        i10 = (i6 - i10) - lazyGridMeasuredLine.getMainAxisSize();
                    }
                    addAllFromArray(arrayList, lazyGridMeasuredLine.position(i10, i, i2));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list2.size() - 1;
            if (size3 >= 0) {
                int i11 = i5;
                while (true) {
                    int i12 = size3 - 1;
                    LazyGridMeasuredItem lazyGridMeasuredItem = list2.get(size3);
                    i11 -= lazyGridMeasuredItem.getMainAxisSizeWithSpacings();
                    lazyGridMeasuredItem.position(i11, 0, i, i2);
                    arrayList.add(lazyGridMeasuredItem);
                    if (i12 < 0) {
                        break;
                    }
                    size3 = i12;
                }
            }
            int size4 = list4.size();
            int i13 = i5;
            for (int i14 = 0; i14 < size4; i14++) {
                LazyGridMeasuredLine lazyGridMeasuredLine2 = list.get(i14);
                addAllFromArray(arrayList, lazyGridMeasuredLine2.position(i13, i, i2));
                i13 += lazyGridMeasuredLine2.getMainAxisSizeWithSpacings();
            }
            int size5 = list3.size();
            for (int i15 = 0; i15 < size5; i15++) {
                LazyGridMeasuredItem lazyGridMeasuredItem2 = list3.get(i15);
                lazyGridMeasuredItem2.position(i13, 0, i, i2);
                arrayList.add(lazyGridMeasuredItem2);
                i13 += lazyGridMeasuredItem2.getMainAxisSizeWithSpacings();
            }
        }
        return arrayList;
    }

    private static final <T> void addAllFromArray(List<T> list, T[] tArr) {
        for (T t : tArr) {
            list.add(t);
        }
    }

    private static final List<LazyGridMeasuredItem> calculateExtraItems(List<Integer> list, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, Function1<? super Integer, Boolean> function1) {
        LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider2;
        int size = list.size();
        ArrayList arrayList = null;
        int i = 0;
        while (i < size) {
            int intValue = list.get(i).intValue();
            if (function1.invoke(Integer.valueOf(intValue)).booleanValue()) {
                int spanOf = lazyGridMeasuredLineProvider.spanOf(intValue);
                lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
                LazyGridMeasuredItem mo1165getAndMeasurehBUhpc = lazyGridMeasuredItemProvider2.mo1165getAndMeasurehBUhpc(intValue, 0, spanOf, lazyGridMeasuredLineProvider.m1197childConstraintsJhjzzOo$foundation_release(0, spanOf));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(mo1165getAndMeasurehBUhpc);
            } else {
                lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
            }
            i++;
            lazyGridMeasuredItemProvider = lazyGridMeasuredItemProvider2;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }
}
