package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001a*\u0001\u0018\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\u0002\u0010\u0010J\u001a\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001eH\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0086@ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0006\u0010.\u001a\u00020\u000bJ#\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u0018\u00105\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001eø\u0001\u0000¢\u0006\u0004\b6\u0010(JA\u0010&\u001a\u0002002\b\b\u0002\u00107\u001a\u0002082'\u00109\u001a#\b\u0001\u0012\u0004\u0012\u00020;\u0012\n\u0012\b\u0012\u0004\u0012\u0002000<\u0012\u0006\u0012\u0004\u0018\u00010\u00010:¢\u0006\u0002\b=H\u0086@¢\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020AH\u0002J\u0006\u0010B\u001a\u00020\u000bJ8\u0010C\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ&\u0010D\u001a\u00020\u001e*\u00020\u001b2\u0006\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u0014\u0010I\u001a\u00020\u001e*\u00020\u001eø\u0001\u0000¢\u0006\u0004\bJ\u0010(J\n\u0010I\u001a\u00020A*\u00020AJ\u0014\u0010K\u001a\u00020\u001e*\u00020\u001eø\u0001\u0000¢\u0006\u0004\bL\u0010(J\u0016\u0010M\u001a\u00020**\u00020*H\u0002ø\u0001\u0000¢\u0006\u0004\bN\u0010(J\u0014\u0010O\u001a\u00020A*\u00020\u001eø\u0001\u0000¢\u0006\u0004\bP\u0010QJ\u0016\u0010O\u001a\u00020A*\u00020*H\u0002ø\u0001\u0000¢\u0006\u0004\bR\u0010QJ\u0017\u0010S\u001a\u00020\u001e*\u00020Aø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\u0017\u0010V\u001a\u00020**\u00020Aø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010UJ\u001e\u0010C\u001a\u00020**\u00020*2\u0006\u0010X\u001a\u00020AH\u0002ø\u0001\u0000¢\u0006\u0004\bY\u0010ZR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u00020\u0015X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006["}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "isScrollableNodeAttached", "Lkotlin/Function0;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Lkotlin/jvm/functions/Function0;)V", "<set-?>", "isFlinging", "()Z", "latestScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "I", "nestedScrollScope", "androidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1", "Landroidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1;", "outerStateScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "performScrollForOverscroll", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "setScrollableState", "(Landroidx/compose/foundation/gestures/ScrollableState;)V", "shouldDispatchOverscroll", "getShouldDispatchOverscroll", "dispatchRawDelta", "scroll", "dispatchRawDelta-MK-Hz9U", "(J)J", "doFlingAnimation", "Landroidx/compose/ui/unit/Velocity;", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isVertical", "onScrollStopped", "", "initialVelocity", "isMouseWheel", "onScrollStopped-BMRW4eQ", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performRawScroll", "performRawScroll-MK-Hz9U", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldCancelFling", "pixels", "", "shouldScrollImmediately", "update", "performScroll", "delta", FirebaseAnalytics.Param.SOURCE, "performScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "toVelocity", "toVelocity-adjELrA", "newValue", "update-QWom1Mo", "(JF)J", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ScrollingLogic {
    public static final int $stable = 8;
    private FlingBehavior flingBehavior;
    private boolean isFlinging;
    private final Function0<Boolean> isScrollableNodeAttached;
    private NestedScrollDispatcher nestedScrollDispatcher;
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    private boolean reverseDirection;
    private ScrollableState scrollableState;
    private int latestScrollSource = NestedScrollSource.INSTANCE.m5500getUserInputWNlRxjI();
    private ScrollScope outerStateScope = ScrollableKt.access$getNoOpScrollScope$p();
    private final ScrollingLogic$nestedScrollScope$1 nestedScrollScope = new NestedScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1
        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        /* renamed from: scrollBy-OzD1aCk */
        public long mo792scrollByOzD1aCk(long offset, int source) {
            ScrollScope scrollScope;
            long m829performScroll3eAAhYA;
            scrollScope = ScrollingLogic.this.outerStateScope;
            m829performScroll3eAAhYA = ScrollingLogic.this.m829performScroll3eAAhYA(scrollScope, offset, source);
            return m829performScroll3eAAhYA;
        }

        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        /* renamed from: scrollByWithOverscroll-OzD1aCk */
        public long mo793scrollByWithOverscrollOzD1aCk(long offset, int source) {
            OverscrollEffect overscrollEffect;
            ScrollScope scrollScope;
            long m829performScroll3eAAhYA;
            boolean shouldDispatchOverscroll;
            int i;
            Function1<? super Offset, Offset> function1;
            ScrollingLogic.this.latestScrollSource = source;
            overscrollEffect = ScrollingLogic.this.overscrollEffect;
            if (overscrollEffect != null) {
                shouldDispatchOverscroll = ScrollingLogic.this.getShouldDispatchOverscroll();
                if (shouldDispatchOverscroll) {
                    i = ScrollingLogic.this.latestScrollSource;
                    function1 = ScrollingLogic.this.performScrollForOverscroll;
                    return overscrollEffect.mo537applyToScrollRhakbz0(offset, i, function1);
                }
            }
            scrollScope = ScrollingLogic.this.outerStateScope;
            m829performScroll3eAAhYA = ScrollingLogic.this.m829performScroll3eAAhYA(scrollScope, offset, source);
            return m829performScroll3eAAhYA;
        }
    };
    private final Function1<Offset, Offset> performScrollForOverscroll = new Function1<Offset, Offset>() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$performScrollForOverscroll$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Offset invoke(Offset offset) {
            return Offset.m4114boximpl(m842invokeMKHz9U(offset.m4135unboximpl()));
        }

        /* renamed from: invoke-MK-Hz9U, reason: not valid java name */
        public final long m842invokeMKHz9U(long j) {
            ScrollScope scrollScope;
            int i;
            long m829performScroll3eAAhYA;
            scrollScope = ScrollingLogic.this.outerStateScope;
            ScrollingLogic scrollingLogic = ScrollingLogic.this;
            i = scrollingLogic.latestScrollSource;
            m829performScroll3eAAhYA = scrollingLogic.m829performScroll3eAAhYA(scrollScope, j, i);
            return m829performScroll3eAAhYA;
        }
    };

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1] */
    public ScrollingLogic(ScrollableState scrollableState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, Orientation orientation, boolean z, NestedScrollDispatcher nestedScrollDispatcher, Function0<Boolean> function0) {
        this.scrollableState = scrollableState;
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        this.orientation = orientation;
        this.reverseDirection = z;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        this.isScrollableNodeAttached = function0;
    }

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    public final void setScrollableState(ScrollableState scrollableState) {
        this.scrollableState = scrollableState;
    }

    /* renamed from: isFlinging, reason: from getter */
    public final boolean getIsFlinging() {
        return this.isFlinging;
    }

    /* renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m839toOffsettuRUvjQ(float f) {
        if (f == 0.0f) {
            return Offset.INSTANCE.m4141getZeroF1C5BW0();
        }
        if (this.orientation == Orientation.Horizontal) {
            return Offset.m4117constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
        }
        return Offset.m4117constructorimpl((Float.floatToRawIntBits(f) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32));
    }

    /* renamed from: singleAxisOffset-MK-Hz9U, reason: not valid java name */
    public final long m837singleAxisOffsetMKHz9U(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m4119copydBAh8RU$default(j, 0.0f, 0.0f, 1, null) : Offset.m4119copydBAh8RU$default(j, 0.0f, 0.0f, 2, null);
    }

    /* renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m838toFloatk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j >> 32 : j & 4294967295L));
    }

    /* renamed from: toVelocity-adjELrA, reason: not valid java name */
    public final long m840toVelocityadjELrA(float f) {
        if (f == 0.0f) {
            return Velocity.INSTANCE.m7238getZero9UxMQ8M();
        }
        return this.orientation == Orientation.Horizontal ? VelocityKt.Velocity(f, 0.0f) : VelocityKt.Velocity(0.0f, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m831toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m7227getXimpl(j) : Velocity.m7228getYimpl(j);
    }

    /* renamed from: singleAxisVelocity-AH228Gc, reason: not valid java name */
    private final long m830singleAxisVelocityAH228Gc(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m7223copyOhffZ5M$default(j, 0.0f, 0.0f, 1, null) : Velocity.m7223copyOhffZ5M$default(j, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: update-QWom1Mo, reason: not valid java name */
    public final long m832updateQWom1Mo(long j, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m7223copyOhffZ5M$default(j, f, 0.0f, 2, null) : Velocity.m7223copyOhffZ5M$default(j, 0.0f, f, 1, null);
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * (-1.0f) : f;
    }

    /* renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m836reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m4132timestuRUvjQ(j, -1.0f) : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performScroll-3eAAhYA, reason: not valid java name */
    public final long m829performScroll3eAAhYA(ScrollScope scrollScope, long j, int i) {
        long m5484dispatchPreScrollOzD1aCk = this.nestedScrollDispatcher.m5484dispatchPreScrollOzD1aCk(j, i);
        long m4129minusMKHz9U = Offset.m4129minusMKHz9U(j, m5484dispatchPreScrollOzD1aCk);
        long m836reverseIfNeededMKHz9U = m836reverseIfNeededMKHz9U(m839toOffsettuRUvjQ(scrollScope.scrollBy(m838toFloatk4lQ0M(m836reverseIfNeededMKHz9U(m837singleAxisOffsetMKHz9U(m4129minusMKHz9U))))));
        return Offset.m4130plusMKHz9U(Offset.m4130plusMKHz9U(m5484dispatchPreScrollOzD1aCk, m836reverseIfNeededMKHz9U), this.nestedScrollDispatcher.m5482dispatchPostScrollDzOQY0M(m836reverseIfNeededMKHz9U, Offset.m4129minusMKHz9U(m4129minusMKHz9U, m836reverseIfNeededMKHz9U), i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    /* renamed from: performRawScroll-MK-Hz9U, reason: not valid java name */
    public final long m835performRawScrollMKHz9U(long scroll) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.INSTANCE.m4141getZeroF1C5BW0();
        }
        return m828dispatchRawDeltaMKHz9U(scroll);
    }

    /* renamed from: dispatchRawDelta-MK-Hz9U, reason: not valid java name */
    private final long m828dispatchRawDeltaMKHz9U(long scroll) {
        return m839toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m838toFloatk4lQ0M(scroll)))));
    }

    /* renamed from: onScrollStopped-BMRW4eQ, reason: not valid java name */
    public final Object m834onScrollStoppedBMRW4eQ(long j, boolean z, Continuation<? super Unit> continuation) {
        if (z && !ScrollableKt.access$getShouldBeTriggeredByMouseWheel(this.flingBehavior)) {
            return Unit.INSTANCE;
        }
        long m830singleAxisVelocityAH228Gc = m830singleAxisVelocityAH228Gc(j);
        ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$1 = new ScrollingLogic$onScrollStopped$performFling$1(this, null);
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        if (overscrollEffect != null && getShouldDispatchOverscroll()) {
            Object mo536applyToFlingBMRW4eQ = overscrollEffect.mo536applyToFlingBMRW4eQ(m830singleAxisVelocityAH228Gc, scrollingLogic$onScrollStopped$performFling$1, continuation);
            return mo536applyToFlingBMRW4eQ == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo536applyToFlingBMRW4eQ : Unit.INSTANCE;
        }
        Object invoke = scrollingLogic$onScrollStopped$performFling$1.invoke(Velocity.m7218boximpl(m830singleAxisVelocityAH228Gc), continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldCancelFling(float pixels) {
        if (pixels <= 0.0f || this.scrollableState.getCanScrollForward()) {
            return (pixels < 0.0f && !this.scrollableState.getCanScrollBackward()) || !this.isScrollableNodeAttached.invoke().booleanValue();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m833doFlingAnimationQWom1Mo(long r11, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L14
            r0 = r13
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r10, r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L34
            java.lang.Object r10 = r0.L$1
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r0.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r11 = (androidx.compose.foundation.gestures.ScrollingLogic) r11
            kotlin.ResultKt.throwOnFailure(r13)
            r6 = r10
            r10 = r11
            goto L63
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3d:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.jvm.internal.Ref$LongRef r6 = new kotlin.jvm.internal.Ref$LongRef
            r6.<init>()
            r6.element = r11
            r10.isFlinging = r3
            androidx.compose.foundation.MutatePriority r13 = androidx.compose.foundation.MutatePriority.Default
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r4 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r9 = 0
            r5 = r10
            r7 = r11
            r4.<init>(r5, r6, r7, r9)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r10 = r5.scroll(r13, r4, r0)
            if (r10 != r1) goto L62
            return r1
        L62:
            r10 = r5
        L63:
            r11 = 0
            r10.isFlinging = r11
            long r10 = r6.element
            androidx.compose.ui.unit.Velocity r10 = androidx.compose.ui.unit.Velocity.m7218boximpl(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m833doFlingAnimationQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean shouldScrollImmediately() {
        if (this.scrollableState.isScrollInProgress()) {
            return true;
        }
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        return overscrollEffect != null ? overscrollEffect.isInProgress() : false;
    }

    public static /* synthetic */ Object scroll$default(ScrollingLogic scrollingLogic, MutatePriority mutatePriority, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return scrollingLogic.scroll(mutatePriority, function2, continuation);
    }

    public final Object scroll(MutatePriority mutatePriority, Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll = this.scrollableState.scroll(mutatePriority, new ScrollingLogic$scroll$2(this, function2, null), continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    public final boolean update(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean reverseDirection, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        boolean z;
        boolean z2 = true;
        if (Intrinsics.areEqual(this.scrollableState, scrollableState)) {
            z = false;
        } else {
            this.scrollableState = scrollableState;
            z = true;
        }
        this.overscrollEffect = overscrollEffect;
        if (this.orientation != orientation) {
            this.orientation = orientation;
            z = true;
        }
        if (this.reverseDirection != reverseDirection) {
            this.reverseDirection = reverseDirection;
        } else {
            z2 = z;
        }
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        return z2;
    }

    public final boolean isVertical() {
        return this.orientation == Orientation.Vertical;
    }
}
