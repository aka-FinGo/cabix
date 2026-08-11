package androidx.compose.material3.carousel;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Arrangement.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0003R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/carousel/Arrangement;", "", "priority", "", "smallSize", "", "smallCount", "mediumSize", "mediumCount", "largeSize", "largeCount", "(IFIFIFI)V", "getLargeCount", "()I", "getLargeSize", "()F", "getMediumCount", "getMediumSize", "getSmallCount", "getSmallSize", "cost", "targetLargeSize", "isValid", "", "itemCount", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class Arrangement {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float MediumItemFlexPercentage = 0.1f;
    private final int largeCount;
    private final float largeSize;
    private final int mediumCount;
    private final float mediumSize;
    private final int priority;
    private final int smallCount;
    private final float smallSize;

    public Arrangement(int i, float f, int i2, float f2, int i3, float f3, int i4) {
        this.priority = i;
        this.smallSize = f;
        this.smallCount = i2;
        this.mediumSize = f2;
        this.mediumCount = i3;
        this.largeSize = f3;
        this.largeCount = i4;
    }

    public final float getSmallSize() {
        return this.smallSize;
    }

    public final int getSmallCount() {
        return this.smallCount;
    }

    public final float getMediumSize() {
        return this.mediumSize;
    }

    public final int getMediumCount() {
        return this.mediumCount;
    }

    public final float getLargeSize() {
        return this.largeSize;
    }

    public final int getLargeCount() {
        return this.largeCount;
    }

    private final boolean isValid() {
        int i = this.largeCount;
        if (i <= 0 || this.smallCount <= 0 || this.mediumCount <= 0) {
            return i <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize;
        }
        float f = this.largeSize;
        float f2 = this.mediumSize;
        return f > f2 && f2 > this.smallSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float cost(float targetLargeSize) {
        if (isValid()) {
            return Math.abs(targetLargeSize - this.largeSize) * this.priority;
        }
        return Float.MAX_VALUE;
    }

    public final int itemCount() {
        return this.largeCount + this.mediumCount + this.smallCount;
    }

    /* compiled from: Arrangement.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002JX\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0013J`\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/material3/carousel/Arrangement$Companion;", "", "()V", "MediumItemFlexPercentage", "", "calculateLargeSize", "availableSpace", "smallCount", "", "smallSize", "mediumCount", "largeCount", "findLowestCostArrangement", "Landroidx/compose/material3/carousel/Arrangement;", "itemSpacing", "targetSmallSize", "minSmallSize", "maxSmallSize", "smallCounts", "", "targetMediumSize", "mediumCounts", "targetLargeSize", "largeCounts", "fit", "priority", "mediumSize", "largeSize", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float calculateLargeSize(float availableSpace, int smallCount, float smallSize, int mediumCount, int largeCount) {
            float f = smallCount;
            float f2 = mediumCount / 2.0f;
            return (availableSpace - ((f + f2) * smallSize)) / (largeCount + f2);
        }

        private Companion() {
        }

        public final Arrangement findLowestCostArrangement(float availableSpace, float itemSpacing, float targetSmallSize, float minSmallSize, float maxSmallSize, int[] smallCounts, float targetMediumSize, int[] mediumCounts, float targetLargeSize, int[] largeCounts) {
            int[] iArr = smallCounts;
            int length = largeCounts.length;
            Arrangement arrangement = null;
            int i = 1;
            int i2 = 0;
            while (i2 < length) {
                int i3 = largeCounts[i2];
                int length2 = mediumCounts.length;
                int i4 = 0;
                while (i4 < length2) {
                    int i5 = mediumCounts[i4];
                    int length3 = iArr.length;
                    int i6 = 0;
                    while (i6 < length3) {
                        int i7 = i4;
                        int i8 = iArr[i6];
                        Arrangement arrangement2 = arrangement;
                        int i9 = i2;
                        int i10 = length2;
                        int i11 = length3;
                        int i12 = i6;
                        Arrangement fit = fit(i, availableSpace, itemSpacing, i8, targetSmallSize, minSmallSize, maxSmallSize, i5, targetMediumSize, i3, targetLargeSize);
                        if (arrangement2 != null && fit.cost(targetLargeSize) >= arrangement2.cost(targetLargeSize)) {
                            arrangement = arrangement2;
                        } else {
                            if (fit.cost(targetLargeSize) == 0.0f) {
                                return fit;
                            }
                            arrangement = fit;
                        }
                        i++;
                        i6 = i12 + 1;
                        iArr = smallCounts;
                        i2 = i9;
                        length2 = i10;
                        i4 = i7;
                        length3 = i11;
                    }
                    i4++;
                    iArr = smallCounts;
                }
                i2++;
                iArr = smallCounts;
            }
            return arrangement;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x003e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final androidx.compose.material3.carousel.Arrangement fit(int r9, float r10, float r11, int r12, float r13, float r14, float r15, int r16, float r17, int r18, float r19) {
            /*
                r8 = this;
                r4 = r16
                r5 = r18
                int r0 = r5 + r4
                int r0 = r0 + r12
                int r0 = r0 + (-1)
                float r0 = (float) r0
                float r0 = r0 * r11
                float r1 = r10 - r0
                float r10 = kotlin.ranges.RangesKt.coerceIn(r13, r14, r15)
                float r11 = (float) r5
                float r0 = r19 * r11
                float r6 = (float) r4
                float r2 = r17 * r6
                float r0 = r0 + r2
                float r2 = (float) r12
                float r3 = r10 * r2
                float r0 = r0 + r3
                float r0 = r1 - r0
                r7 = 0
                if (r12 <= 0) goto L2e
                int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                if (r3 <= 0) goto L2e
                float r0 = r0 / r2
                float r2 = r15 - r10
                float r0 = java.lang.Math.min(r0, r2)
            L2c:
                float r10 = r10 + r0
                goto L3c
            L2e:
                if (r12 <= 0) goto L3c
                int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                if (r3 >= 0) goto L3c
                float r0 = r0 / r2
                float r2 = r14 - r10
                float r0 = java.lang.Math.max(r0, r2)
                goto L2c
            L3c:
                if (r12 <= 0) goto L40
                r3 = r10
                goto L41
            L40:
                r3 = r7
            L41:
                r0 = r8
                r2 = r12
                float r8 = r0.calculateLargeSize(r1, r2, r3, r4, r5)
                r2 = r3
                float r3 = r8 + r2
                r10 = 1073741824(0x40000000, float:2.0)
                float r3 = r3 / r10
                if (r16 <= 0) goto L73
                int r10 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
                if (r10 != 0) goto L54
                goto L73
            L54:
                float r10 = r19 - r8
                float r10 = r10 * r11
                r0 = 1036831949(0x3dcccccd, float:0.1)
                float r0 = r0 * r3
                float r0 = r0 * r6
                float r1 = java.lang.Math.abs(r10)
                float r0 = java.lang.Math.min(r1, r0)
                int r10 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
                if (r10 <= 0) goto L6e
                float r10 = r0 / r6
                float r3 = r3 - r10
                float r0 = r0 / r11
                float r8 = r8 + r0
                goto L73
            L6e:
                float r10 = r0 / r6
                float r3 = r3 + r10
                float r0 = r0 / r11
                float r8 = r8 - r0
            L73:
                r6 = r8
                r4 = r3
                androidx.compose.material3.carousel.Arrangement r0 = new androidx.compose.material3.carousel.Arrangement
                r1 = r9
                r3 = r12
                r5 = r16
                r7 = r18
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.Arrangement.Companion.fit(int, float, float, int, float, float, float, int, float, int, float):androidx.compose.material3.carousel.Arrangement");
        }
    }
}
