package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.compose.animation.core.AnimationVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorizedAnimationSpec.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B9\b\u0016\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00070\u0005\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bBC\b\u0000\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010&\u001a\u00020\u0006H\u0002J \u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,H\u0002J-\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J-\u00104\u001a\u00028\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J%\u00105\u001a\u0002062\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00107R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\t\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0011\u001a\u00020\u0012X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0019R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u001c\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010$\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00068"}, d2 = {"Landroidx/compose/animation/core/VectorizedKeyframesSpec;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "keyframes", "", "", "Lkotlin/Pair;", "Landroidx/compose/animation/core/Easing;", "durationMillis", "delayMillis", "(Ljava/util/Map;II)V", "timestamps", "Landroidx/collection/IntList;", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/animation/core/VectorizedKeyframeSpecElementInfo;", "defaultEasing", "initialArcMode", "Landroidx/compose/animation/core/ArcMode;", "(Landroidx/collection/IntList;Landroidx/collection/IntObjectMap;IILandroidx/compose/animation/core/Easing;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "arcSpline", "Landroidx/compose/animation/core/ArcSpline;", "getDelayMillis", "()I", "getDurationMillis", "I", "lastInitialValue", "Landroidx/compose/animation/core/AnimationVector;", "lastTargetValue", "modes", "", "posArray", "", "slopeArray", "times", "valueVector", "velocityVector", "findEntryForTimeMillis", "timeMillis", "getEasedTime", "", "getEasedTimeFromIndex", FirebaseAnalytics.Param.INDEX, "asFraction", "", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "init", "", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "animation-core_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class VectorizedKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private ArcSpline arcSpline;
    private final Easing defaultEasing;
    private final int delayMillis;
    private final int durationMillis;
    private final int initialArcMode;
    private final IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> keyframes;
    private V lastInitialValue;
    private V lastTargetValue;
    private int[] modes;
    private float[] posArray;
    private float[] slopeArray;
    private float[] times;
    private final IntList timestamps;
    private V valueVector;
    private V velocityVector;

    public /* synthetic */ VectorizedKeyframesSpec(IntList intList, IntObjectMap intObjectMap, int i, int i2, Easing easing, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(intList, intObjectMap, i, i2, easing, i3);
    }

    private VectorizedKeyframesSpec(IntList intList, IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> intObjectMap, int i, int i2, Easing easing, int i3) {
        int[] iArr;
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        ArcSpline arcSpline;
        this.timestamps = intList;
        this.keyframes = intObjectMap;
        this.durationMillis = i;
        this.delayMillis = i2;
        this.defaultEasing = easing;
        this.initialArcMode = i3;
        iArr = VectorizedAnimationSpecKt.EmptyIntArray;
        this.modes = iArr;
        fArr = VectorizedAnimationSpecKt.EmptyFloatArray;
        this.times = fArr;
        fArr2 = VectorizedAnimationSpecKt.EmptyFloatArray;
        this.posArray = fArr2;
        fArr3 = VectorizedAnimationSpecKt.EmptyFloatArray;
        this.slopeArray = fArr3;
        arcSpline = VectorizedAnimationSpecKt.EmptyArcSpline;
        this.arcSpline = arcSpline;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    public /* synthetic */ VectorizedKeyframesSpec(Map map, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, i, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public VectorizedKeyframesSpec(java.util.Map<java.lang.Integer, ? extends kotlin.Pair<? extends V, ? extends androidx.compose.animation.core.Easing>> r12, int r13, int r14) {
        /*
            r11 = this;
            androidx.collection.MutableIntList r0 = new androidx.collection.MutableIntList
            int r1 = r12.size()
            int r1 = r1 + 2
            r0.<init>(r1)
            java.util.Set r1 = r12.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L13:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L2d
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r2 = r2.getKey()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            r0.add(r2)
            goto L13
        L2d:
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            boolean r2 = r12.containsKey(r2)
            if (r2 != 0) goto L3b
            r0.add(r1, r1)
        L3b:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            boolean r2 = r12.containsKey(r2)
            if (r2 != 0) goto L48
            r0.add(r13)
        L48:
            r0.sort()
            r4 = r0
            androidx.collection.IntList r4 = (androidx.collection.IntList) r4
            androidx.collection.MutableIntObjectMap r0 = new androidx.collection.MutableIntObjectMap
            r2 = 1
            r3 = 0
            r0.<init>(r1, r2, r3)
            java.util.Set r12 = r12.entrySet()
            java.util.Iterator r12 = r12.iterator()
        L5d:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L94
            java.lang.Object r1 = r12.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r1 = r1.getValue()
            kotlin.Pair r1 = (kotlin.Pair) r1
            androidx.compose.animation.core.VectorizedKeyframeSpecElementInfo r5 = new androidx.compose.animation.core.VectorizedKeyframeSpecElementInfo
            java.lang.Object r6 = r1.getFirst()
            androidx.compose.animation.core.AnimationVector r6 = (androidx.compose.animation.core.AnimationVector) r6
            java.lang.Object r1 = r1.getSecond()
            androidx.compose.animation.core.Easing r1 = (androidx.compose.animation.core.Easing) r1
            androidx.compose.animation.core.ArcMode$Companion r7 = androidx.compose.animation.core.ArcMode.INSTANCE
            int r7 = r7.m472getArcLinear9TMq4()
            r5.<init>(r6, r1, r7, r3)
            r0.set(r2, r5)
            goto L5d
        L94:
            r5 = r0
            androidx.collection.IntObjectMap r5 = (androidx.collection.IntObjectMap) r5
            androidx.compose.animation.core.Easing r8 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.ArcMode$Companion r12 = androidx.compose.animation.core.ArcMode.INSTANCE
            int r9 = r12.m472getArcLinear9TMq4()
            r10 = 0
            r3 = r11
            r6 = r13
            r7 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.VectorizedKeyframesSpec.<init>(java.util.Map, int, int):void");
    }

    private final void init(V initialValue, V targetValue, V initialVelocity) {
        ArcSpline arcSpline;
        ArcSpline arcSpline2;
        float[] fArr;
        ArcSpline arcSpline3 = this.arcSpline;
        arcSpline = VectorizedAnimationSpecKt.EmptyArcSpline;
        boolean z = arcSpline3 != arcSpline;
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(initialValue);
            this.velocityVector = (V) AnimationVectorsKt.newInstance(initialVelocity);
            int i = this.timestamps._size;
            float[] fArr2 = new float[i];
            for (int i2 = 0; i2 < i; i2++) {
                fArr2[i2] = this.timestamps.get(i2) / 1000.0f;
            }
            this.times = fArr2;
            int i3 = this.timestamps._size;
            int[] iArr = new int[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(this.timestamps.get(i4));
                int m523getArcMode9TMq4 = vectorizedKeyframeSpecElementInfo != null ? vectorizedKeyframeSpecElementInfo.m523getArcMode9TMq4() : this.initialArcMode;
                if (!ArcMode.m466equalsimpl0(m523getArcMode9TMq4, ArcMode.INSTANCE.m472getArcLinear9TMq4())) {
                    z = true;
                }
                iArr[i4] = m523getArcMode9TMq4;
            }
            this.modes = iArr;
        }
        if (z) {
            ArcSpline arcSpline4 = this.arcSpline;
            arcSpline2 = VectorizedAnimationSpecKt.EmptyArcSpline;
            if (arcSpline4 != arcSpline2 && Intrinsics.areEqual(this.lastInitialValue, initialValue) && Intrinsics.areEqual(this.lastTargetValue, targetValue)) {
                return;
            }
            this.lastInitialValue = initialValue;
            this.lastTargetValue = targetValue;
            int size = (initialValue.getSize() % 2) + initialValue.getSize();
            this.posArray = new float[size];
            this.slopeArray = new float[size];
            int i5 = this.timestamps._size;
            float[][] fArr3 = new float[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = this.timestamps.get(i6);
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo2 = this.keyframes.get(i7);
                if (i7 == 0 && vectorizedKeyframeSpecElementInfo2 == null) {
                    fArr = new float[size];
                    for (int i8 = 0; i8 < size; i8++) {
                        fArr[i8] = initialValue.get$animation_core_release(i8);
                    }
                } else if (i7 == getDurationMillis() && vectorizedKeyframeSpecElementInfo2 == null) {
                    fArr = new float[size];
                    for (int i9 = 0; i9 < size; i9++) {
                        fArr[i9] = targetValue.get$animation_core_release(i9);
                    }
                } else {
                    Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo2);
                    V vectorValue = vectorizedKeyframeSpecElementInfo2.getVectorValue();
                    float[] fArr4 = new float[size];
                    for (int i10 = 0; i10 < size; i10++) {
                        fArr4[i10] = vectorValue.get$animation_core_release(i10);
                    }
                    fArr = fArr4;
                }
                fArr3[i6] = fArr;
            }
            this.arcSpline = new ArcSpline(this.modes, this.times, fArr3);
        }
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        ArcSpline arcSpline;
        V vectorValue;
        V vectorValue2;
        int clampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, playTimeNanos / AnimationKt.MillisToNanos);
        VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(clampPlayTime);
        if (vectorizedKeyframeSpecElementInfo != null) {
            return vectorizedKeyframeSpecElementInfo.getVectorValue();
        }
        if (clampPlayTime >= getDurationMillis()) {
            return targetValue;
        }
        if (clampPlayTime <= 0) {
            return initialValue;
        }
        init(initialValue, targetValue, initialVelocity);
        V v = this.valueVector;
        Intrinsics.checkNotNull(v);
        ArcSpline arcSpline2 = this.arcSpline;
        arcSpline = VectorizedAnimationSpecKt.EmptyArcSpline;
        int i = 0;
        if (arcSpline2 != arcSpline) {
            float easedTime = getEasedTime(clampPlayTime);
            float[] fArr = this.posArray;
            this.arcSpline.getPos(easedTime, fArr);
            int length = fArr.length;
            while (i < length) {
                v.set$animation_core_release(i, fArr[i]);
                i++;
            }
        } else {
            int findEntryForTimeMillis = findEntryForTimeMillis(clampPlayTime);
            float easedTimeFromIndex = getEasedTimeFromIndex(findEntryForTimeMillis, clampPlayTime, true);
            VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo2 = this.keyframes.get(this.timestamps.get(findEntryForTimeMillis));
            if (vectorizedKeyframeSpecElementInfo2 != null && (vectorValue2 = vectorizedKeyframeSpecElementInfo2.getVectorValue()) != null) {
                initialValue = vectorValue2;
            }
            VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo3 = this.keyframes.get(this.timestamps.get(findEntryForTimeMillis + 1));
            if (vectorizedKeyframeSpecElementInfo3 != null && (vectorValue = vectorizedKeyframeSpecElementInfo3.getVectorValue()) != null) {
                targetValue = vectorValue;
            }
            int size = v.getSize();
            while (i < size) {
                v.set$animation_core_release(i, (initialValue.get$animation_core_release(i) * (1.0f - easedTimeFromIndex)) + (targetValue.get$animation_core_release(i) * easedTimeFromIndex));
                i++;
            }
        }
        return v;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        ArcSpline arcSpline;
        long clampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, playTimeNanos / AnimationKt.MillisToNanos);
        if (clampPlayTime < 0) {
            return initialVelocity;
        }
        init(initialValue, targetValue, initialVelocity);
        V v = this.velocityVector;
        Intrinsics.checkNotNull(v);
        ArcSpline arcSpline2 = this.arcSpline;
        arcSpline = VectorizedAnimationSpecKt.EmptyArcSpline;
        int i = 0;
        if (arcSpline2 != arcSpline) {
            float easedTime = getEasedTime((int) clampPlayTime);
            float[] fArr = this.slopeArray;
            this.arcSpline.getSlope(easedTime, fArr);
            int length = fArr.length;
            while (i < length) {
                v.set$animation_core_release(i, fArr[i]);
                i++;
            }
        } else {
            VectorizedKeyframesSpec<V> vectorizedKeyframesSpec = this;
            AnimationVector valueFromMillis = VectorizedAnimationSpecKt.getValueFromMillis(vectorizedKeyframesSpec, clampPlayTime - 1, initialValue, targetValue, initialVelocity);
            AnimationVector valueFromMillis2 = VectorizedAnimationSpecKt.getValueFromMillis(vectorizedKeyframesSpec, clampPlayTime, initialValue, targetValue, initialVelocity);
            int size = valueFromMillis.getSize();
            while (i < size) {
                v.set$animation_core_release(i, (valueFromMillis.get$animation_core_release(i) - valueFromMillis2.get$animation_core_release(i)) * 1000.0f);
                i++;
            }
        }
        return v;
    }

    private final float getEasedTime(int timeMillis) {
        return getEasedTimeFromIndex(findEntryForTimeMillis(timeMillis), timeMillis, false);
    }

    private final float getEasedTimeFromIndex(int index, int timeMillis, boolean asFraction) {
        Easing easing;
        float f;
        if (index >= this.timestamps._size - 1) {
            f = timeMillis;
        } else {
            int i = this.timestamps.get(index);
            int i2 = this.timestamps.get(index + 1);
            if (timeMillis != i) {
                int i3 = i2 - i;
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(i);
                if (vectorizedKeyframeSpecElementInfo == null || (easing = vectorizedKeyframeSpecElementInfo.getEasing()) == null) {
                    easing = this.defaultEasing;
                }
                float f2 = i3;
                float transform = easing.transform((timeMillis - i) / f2);
                return asFraction ? transform : ((f2 * transform) + i) / 1000.0f;
            }
            f = i;
        }
        return f / 1000.0f;
    }

    private final int findEntryForTimeMillis(int timeMillis) {
        int binarySearch$default = IntList.binarySearch$default(this.timestamps, timeMillis, 0, 0, 6, null);
        return binarySearch$default < -1 ? -(binarySearch$default + 2) : binarySearch$default;
    }
}
