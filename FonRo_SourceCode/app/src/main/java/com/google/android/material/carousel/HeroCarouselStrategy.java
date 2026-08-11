package com.google.android.material.carousel;

import android.view.View;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public class HeroCarouselStrategy extends CarouselStrategy {
    private int keylineCount = 0;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {0, 1};

    @Override // com.google.android.material.carousel.CarouselStrategy
    public KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View view) {
        int[] iArr;
        float f;
        int[] iArr2;
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f2 = layoutParams.topMargin + layoutParams.bottomMargin;
        float measuredWidth = view.getMeasuredWidth() * 2;
        if (carousel.isHorizontal()) {
            f2 = layoutParams.leftMargin + layoutParams.rightMargin;
            measuredWidth = view.getMeasuredHeight() * 2;
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f2;
        float max = Math.max(getSmallItemSizeMax() + f2, smallItemSizeMin);
        float f3 = containerHeight;
        float min = Math.min(measuredWidth + f2, f3);
        float clamp = MathUtils.clamp((measuredWidth / 3.0f) + f2, smallItemSizeMin + f2, max + f2);
        float f4 = (min + clamp) / 2.0f;
        int i = 0;
        int[] iArr3 = f3 < 2.0f * smallItemSizeMin ? new int[]{0} : SMALL_COUNTS;
        int max2 = (int) Math.max(1.0d, Math.floor((f3 - (CarouselStrategyHelper.maxValue(r1) * max)) / min));
        int ceil = (((int) Math.ceil(f3 / min)) - max2) + 1;
        int[] iArr4 = new int[ceil];
        for (int i2 = 0; i2 < ceil; i2++) {
            iArr4[i2] = max2 + i2;
        }
        int i3 = carousel.getCarouselAlignment() == 1 ? 1 : 0;
        int[] doubleCounts = i3 != 0 ? doubleCounts(iArr3) : iArr3;
        if (i3 != 0) {
            int[] iArr5 = MEDIUM_COUNTS;
            iArr = doubleCounts(iArr5);
            f = f4;
            iArr2 = iArr5;
        } else {
            iArr = MEDIUM_COUNTS;
            f = f4;
            iArr2 = iArr;
        }
        Arrangement findLowestCostArrangement = Arrangement.findLowestCostArrangement(f3, clamp, smallItemSizeMin, max, doubleCounts, f, iArr, min, iArr4);
        this.keylineCount = findLowestCostArrangement.getItemCount();
        if (findLowestCostArrangement.getItemCount() > carousel.getItemCount()) {
            findLowestCostArrangement = Arrangement.findLowestCostArrangement(f3, clamp, smallItemSizeMin, max, iArr3, f, iArr2, min, iArr4);
        } else {
            i = i3;
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f2, containerHeight, findLowestCostArrangement, i);
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean shouldRefreshKeylineState(Carousel carousel, int i) {
        if (carousel.getCarouselAlignment() != 1) {
            return false;
        }
        int i2 = this.keylineCount;
        if (i < i2) {
            int itemCount = carousel.getItemCount();
            int i3 = this.keylineCount;
            if (itemCount < i3) {
                i2 = i3;
            }
        }
        return i >= i2 && carousel.getItemCount() < this.keylineCount;
    }
}
