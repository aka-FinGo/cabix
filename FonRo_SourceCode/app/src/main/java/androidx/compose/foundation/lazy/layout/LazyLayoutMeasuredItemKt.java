package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.unit.IntOffset;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyLayoutMeasuredItem.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\u001aD\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\t0\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\bH\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"LazyLayoutMeasuredItemIndexComparator", "Ljava/util/Comparator;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "mainAxisOffset", "", "getMainAxisOffset", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "updatedVisibleItems", "", ExifInterface.GPS_DIRECTION_TRUE, "firstVisibleIndex", "lastVisibleIndex", "positionedItems", "stickingItems", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyLayoutMeasuredItemKt {
    private static final Comparator<LazyLayoutMeasuredItem> LazyLayoutMeasuredItemIndexComparator = new Comparator() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemKt$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int compare;
            compare = Intrinsics.compare(((LazyLayoutMeasuredItem) obj).getIndex(), ((LazyLayoutMeasuredItem) obj2).getIndex());
            return compare;
        }
    };

    public static final <T extends LazyLayoutMeasuredItem> List<T> updatedVisibleItems(int i, int i2, List<? extends T> list, List<? extends T> list2) {
        if (list.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List<T> mutableList = CollectionsKt.toMutableList((Collection) list2);
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            T t = list.get(i3);
            int index = t.getIndex();
            if (i <= index && index <= i2) {
                mutableList.add(t);
            }
        }
        CollectionsKt.sortWith(mutableList, LazyLayoutMeasuredItemIndexComparator);
        return mutableList;
    }

    private static final int getMainAxisOffset(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        long mo1163getOffsetBjo55l4 = lazyLayoutMeasuredItem.mo1163getOffsetBjo55l4(0);
        return lazyLayoutMeasuredItem.getIsVertical() ? IntOffset.m7118getYimpl(mo1163getOffsetBjo55l4) : IntOffset.m7117getXimpl(mo1163getOffsetBjo55l4);
    }
}
