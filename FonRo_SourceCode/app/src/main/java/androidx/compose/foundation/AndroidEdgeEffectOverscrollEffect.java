package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

/* compiled from: AndroidOverscroll.android.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010)\u001a\u00020%H\u0002J?\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020,2\"\u0010-\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020,\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0/\u0012\u0006\u0012\u0004\u0018\u0001000.H\u0096@ø\u0001\u0000¢\u0006\u0004\b1\u00102J6\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\"2\u0006\u00105\u001a\u0002062\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"08H\u0016ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0015\u0010;\u001a\u00020\"H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\r\u0010>\u001a\u00020%H\u0000¢\u0006\u0002\b?J\u001a\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\"H\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\u001a\u0010E\u001a\u00020A2\u0006\u0010B\u001a\u00020\"H\u0002ø\u0001\u0000¢\u0006\u0004\bF\u0010DJ\u001a\u0010G\u001a\u00020A2\u0006\u0010B\u001a\u00020\"H\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010DJ\u001a\u0010I\u001a\u00020A2\u0006\u0010B\u001a\u00020\"H\u0002ø\u0001\u0000¢\u0006\u0004\bJ\u0010DJ\u001a\u0010K\u001a\u00020\u00112\u0006\u00104\u001a\u00020\"H\u0002ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\u001a\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\bP\u0010QR\u0016\u0010\u000b\u001a\u00020\fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u001eX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\u00020\"X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006R"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "density", "Landroidx/compose/ui/unit/Density;", "glowColor", "Landroidx/compose/ui/graphics/Color;", "glowDrawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroid/content/Context;Landroidx/compose/ui/unit/Density;JLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "containerSize", "Landroidx/compose/ui/geometry/Size;", "J", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "invalidationEnabled", "", "getInvalidationEnabled$foundation_release$annotations", "()V", "getInvalidationEnabled$foundation_release", "()Z", "setInvalidationEnabled$foundation_release", "(Z)V", "isInProgress", "node", "Landroidx/compose/ui/node/DelegatableNode;", "getNode", "()Landroidx/compose/ui/node/DelegatableNode;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "", "getRedrawSignal$foundation_release", "()Landroidx/compose/runtime/MutableState;", "scrollCycleInProgress", "animateToReleaseIfNeeded", "applyToFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyToScroll", "delta", FirebaseAnalytics.Param.SOURCE, "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "Lkotlin/Function1;", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "displacement", "displacement-F1C5BW0$foundation_release", "()J", "invalidateOverscroll", "invalidateOverscroll$foundation_release", "pullBottom", "", "scroll", "pullBottom-k-4lQ0M", "(J)F", "pullLeft", "pullLeft-k-4lQ0M", "pullRight", "pullRight-k-4lQ0M", "pullTop", "pullTop-k-4lQ0M", "releaseOppositeOverscroll", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "updateSize", "size", "updateSize-uvyYCjk$foundation_release", "(J)V", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    public static final int $stable = 0;
    private long containerSize;
    private final Density density;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private boolean invalidationEnabled;
    private final DelegatableNode node;
    private long pointerId;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private long pointerPosition;
    private final MutableState<Unit> redrawSignal;
    private boolean scrollCycleInProgress;

    public /* synthetic */ AndroidEdgeEffectOverscrollEffect(Context context, Density density, long j, PaddingValues paddingValues, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, density, j, paddingValues);
    }

    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    private AndroidEdgeEffectOverscrollEffect(Context context, Density density, long j, PaddingValues paddingValues) {
        GlowOverscrollNode glowOverscrollNode;
        this.density = density;
        this.pointerPosition = Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
        EdgeEffectWrapper edgeEffectWrapper = new EdgeEffectWrapper(context, ColorKt.m4438toArgb8_81llA(j));
        this.edgeEffectWrapper = edgeEffectWrapper;
        this.redrawSignal = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.INSTANCE.m4203getZeroNHjbRc();
        this.pointerId = PointerId.m5587constructorimpl(-1L);
        SuspendingPointerInputModifierNode SuspendingPointerInputModifierNode = SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new PointerInputEventHandler() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$pointerInputNode$1

            /* compiled from: AndroidOverscroll.android.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$pointerInputNode$1$1", f = "AndroidOverscroll.android.kt", i = {0, 1}, l = {783, 787}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture"}, s = {"L$0", "L$0"})
            /* renamed from: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$pointerInputNode$1$1, reason: invalid class name */
            /* loaded from: classes.dex */
            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = androidEdgeEffectOverscrollEffect;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
                
                    if (r15 != r0) goto L18;
                 */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0062 -> B:6:0x0065). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r15) {
                    /*
                        Method dump skipped, instructions count: 239
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$pointerInputNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass1(AndroidEdgeEffectOverscrollEffect.this, null), continuation);
                return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
            }
        });
        this.pointerInputNode = SuspendingPointerInputModifierNode;
        if (Build.VERSION.SDK_INT >= 31) {
            glowOverscrollNode = new StretchOverscrollNode(SuspendingPointerInputModifierNode, this, edgeEffectWrapper);
        } else {
            glowOverscrollNode = new GlowOverscrollNode(SuspendingPointerInputModifierNode, this, edgeEffectWrapper, paddingValues);
        }
        this.node = glowOverscrollNode;
    }

    public final MutableState<Unit> getRedrawSignal$foundation_release() {
        return this.redrawSignal;
    }

    /* renamed from: getInvalidationEnabled$foundation_release, reason: from getter */
    public final boolean getInvalidationEnabled() {
        return this.invalidationEnabled;
    }

    public final void setInvalidationEnabled$foundation_release(boolean z) {
        this.invalidationEnabled = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x023f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00fe  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToScroll-Rhakbz0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long mo537applyToScrollRhakbz0(long r21, int r23, kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Offset, androidx.compose.ui.geometry.Offset> r24) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.mo537applyToScrollRhakbz0(long, int, kotlin.jvm.functions.Function1):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x005b, code lost:
    
        if (r16.invoke(r13, r2) == r3) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToFling-BMRW4eQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo536applyToFlingBMRW4eQ(long r14, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Velocity, ? super kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity>, ? extends java.lang.Object> r16, kotlin.coroutines.Continuation<? super kotlin.Unit> r17) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.mo536applyToFlingBMRW4eQ(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        if (edgeEffect != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect2) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect3) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        return (edgeEffect4 == null || EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect4) == 0.0f) ? false : true;
    }

    /* renamed from: updateSize-uvyYCjk$foundation_release, reason: not valid java name */
    public final void m539updateSizeuvyYCjk$foundation_release(long size) {
        boolean m4190equalsimpl0 = Size.m4190equalsimpl0(this.containerSize, Size.INSTANCE.m4203getZeroNHjbRc());
        boolean m4190equalsimpl02 = Size.m4190equalsimpl0(size, this.containerSize);
        this.containerSize = size;
        if (!m4190equalsimpl02) {
            this.edgeEffectWrapper.m612updateSizeozmzZPI(IntSize.m7155constructorimpl((MathKt.roundToInt(Float.intBitsToFloat((int) (size & 4294967295L))) & 4294967295L) | (MathKt.roundToInt(Float.intBitsToFloat((int) (size >> 32))) << 32)));
        }
        if (m4190equalsimpl0 || m4190equalsimpl02) {
            return;
        }
        animateToReleaseIfNeeded();
    }

    /* renamed from: displacement-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m538displacementF1C5BW0$foundation_release() {
        long j = this.pointerPosition;
        if ((9223372034707292159L & j) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            j = SizeKt.m4204getCenteruvyYCjk(this.containerSize);
        }
        float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
        return Offset.m4117constructorimpl((Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(intBitsToFloat) << 32));
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public DelegatableNode getNode() {
        return this.node;
    }

    public final void invalidateOverscroll$foundation_release() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    private final void animateToReleaseIfNeeded() {
        boolean z;
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        boolean z2 = true;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = !edgeEffect.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z = !edgeEffect2.isFinished() || z;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z = !edgeEffect3.isFinished() || z;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            if (edgeEffect4.isFinished() && !z) {
                z2 = false;
            }
            z = z2;
        }
        if (z) {
            invalidateOverscroll$foundation_release();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0037  */
    /* renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean m535releaseOppositeOverscrollk4lQ0M(long r11) {
        /*
            r10 = this;
            androidx.compose.foundation.EdgeEffectWrapper r0 = r10.edgeEffectWrapper
            boolean r0 = r0.isLeftAnimating()
            r1 = 32
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L2d
            long r4 = r11 >> r1
            int r0 = (int) r4
            float r4 = java.lang.Float.intBitsToFloat(r0)
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 >= 0) goto L2d
            androidx.compose.foundation.EdgeEffectCompat r4 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            androidx.compose.foundation.EdgeEffectWrapper r5 = r10.edgeEffectWrapper
            android.widget.EdgeEffect r5 = r5.getOrCreateLeftEffect()
            float r0 = java.lang.Float.intBitsToFloat(r0)
            r4.onReleaseWithOppositeDelta(r5, r0)
            androidx.compose.foundation.EdgeEffectWrapper r0 = r10.edgeEffectWrapper
            boolean r0 = r0.isLeftAnimating()
            goto L2e
        L2d:
            r0 = r3
        L2e:
            androidx.compose.foundation.EdgeEffectWrapper r4 = r10.edgeEffectWrapper
            boolean r4 = r4.isRightAnimating()
            r5 = 1
            if (r4 == 0) goto L5f
            long r6 = r11 >> r1
            int r1 = (int) r6
            float r4 = java.lang.Float.intBitsToFloat(r1)
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 <= 0) goto L5f
            androidx.compose.foundation.EdgeEffectCompat r4 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            androidx.compose.foundation.EdgeEffectWrapper r6 = r10.edgeEffectWrapper
            android.widget.EdgeEffect r6 = r6.getOrCreateRightEffect()
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r4.onReleaseWithOppositeDelta(r6, r1)
            if (r0 != 0) goto L5e
            androidx.compose.foundation.EdgeEffectWrapper r0 = r10.edgeEffectWrapper
            boolean r0 = r0.isRightAnimating()
            if (r0 == 0) goto L5c
            goto L5e
        L5c:
            r0 = r3
            goto L5f
        L5e:
            r0 = r5
        L5f:
            androidx.compose.foundation.EdgeEffectWrapper r1 = r10.edgeEffectWrapper
            boolean r1 = r1.isTopAnimating()
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            if (r1 == 0) goto L94
            long r8 = r11 & r6
            int r1 = (int) r8
            float r4 = java.lang.Float.intBitsToFloat(r1)
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 >= 0) goto L94
            androidx.compose.foundation.EdgeEffectCompat r4 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            androidx.compose.foundation.EdgeEffectWrapper r8 = r10.edgeEffectWrapper
            android.widget.EdgeEffect r8 = r8.getOrCreateTopEffect()
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r4.onReleaseWithOppositeDelta(r8, r1)
            if (r0 != 0) goto L93
            androidx.compose.foundation.EdgeEffectWrapper r0 = r10.edgeEffectWrapper
            boolean r0 = r0.isTopAnimating()
            if (r0 == 0) goto L91
            goto L93
        L91:
            r0 = r3
            goto L94
        L93:
            r0 = r5
        L94:
            androidx.compose.foundation.EdgeEffectWrapper r1 = r10.edgeEffectWrapper
            boolean r1 = r1.isBottomAnimating()
            if (r1 == 0) goto Lc2
            long r11 = r11 & r6
            int r11 = (int) r11
            float r12 = java.lang.Float.intBitsToFloat(r11)
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 <= 0) goto Lc2
            androidx.compose.foundation.EdgeEffectCompat r12 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            androidx.compose.foundation.EdgeEffectWrapper r1 = r10.edgeEffectWrapper
            android.widget.EdgeEffect r1 = r1.getOrCreateBottomEffect()
            float r11 = java.lang.Float.intBitsToFloat(r11)
            r12.onReleaseWithOppositeDelta(r1, r11)
            if (r0 != 0) goto Lc1
            androidx.compose.foundation.EdgeEffectWrapper r10 = r10.edgeEffectWrapper
            boolean r10 = r10.isBottomAnimating()
            if (r10 == 0) goto Lc0
            goto Lc1
        Lc0:
            return r3
        Lc1:
            return r5
        Lc2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.m535releaseOppositeOverscrollk4lQ0M(long):boolean");
    }

    /* renamed from: pullTop-k-4lQ0M, reason: not valid java name */
    private final float m534pullTopk4lQ0M(long scroll) {
        float intBitsToFloat = Float.intBitsToFloat((int) (m538displacementF1C5BW0$foundation_release() >> 32));
        int i = (int) (scroll & 4294967295L);
        float intBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
        EdgeEffect orCreateTopEffect = this.edgeEffectWrapper.getOrCreateTopEffect();
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateTopEffect) == 0.0f ? EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateTopEffect, intBitsToFloat2, intBitsToFloat) * Float.intBitsToFloat((int) (this.containerSize & 4294967295L)) : Float.intBitsToFloat(i);
    }

    /* renamed from: pullBottom-k-4lQ0M, reason: not valid java name */
    private final float m531pullBottomk4lQ0M(long scroll) {
        float intBitsToFloat = Float.intBitsToFloat((int) (m538displacementF1C5BW0$foundation_release() >> 32));
        int i = (int) (scroll & 4294967295L);
        float intBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
        EdgeEffect orCreateBottomEffect = this.edgeEffectWrapper.getOrCreateBottomEffect();
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateBottomEffect) == 0.0f ? (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateBottomEffect, -intBitsToFloat2, 1.0f - intBitsToFloat)) * Float.intBitsToFloat((int) (this.containerSize & 4294967295L)) : Float.intBitsToFloat(i);
    }

    /* renamed from: pullLeft-k-4lQ0M, reason: not valid java name */
    private final float m532pullLeftk4lQ0M(long scroll) {
        float intBitsToFloat = Float.intBitsToFloat((int) (m538displacementF1C5BW0$foundation_release() & 4294967295L));
        int i = (int) (scroll >> 32);
        float intBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        EdgeEffect orCreateLeftEffect = this.edgeEffectWrapper.getOrCreateLeftEffect();
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateLeftEffect) == 0.0f ? EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateLeftEffect, intBitsToFloat2, 1.0f - intBitsToFloat) * Float.intBitsToFloat((int) (this.containerSize >> 32)) : Float.intBitsToFloat(i);
    }

    /* renamed from: pullRight-k-4lQ0M, reason: not valid java name */
    private final float m533pullRightk4lQ0M(long scroll) {
        float intBitsToFloat = Float.intBitsToFloat((int) (m538displacementF1C5BW0$foundation_release() & 4294967295L));
        int i = (int) (scroll >> 32);
        float intBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        EdgeEffect orCreateRightEffect = this.edgeEffectWrapper.getOrCreateRightEffect();
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateRightEffect) == 0.0f ? (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateRightEffect, -intBitsToFloat2, intBitsToFloat)) * Float.intBitsToFloat((int) (this.containerSize >> 32)) : Float.intBitsToFloat(i);
    }
}
