package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.MouseWheelScrollingLogic;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: MouseWheelScrollable.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001RBP\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00121\u0010\u0006\u001a-\b\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\"\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J(\u0010$\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&2\u0006\u0010 \u001a\u00020!ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u000e\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020+J\u0010\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u0013H\u0002J$\u0010.\u001a\b\u0012\u0004\u0012\u0002H00/\"\u0004\b\u0000\u001002\u000e\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H002H\u0002J\u000e\u00103\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJY\u00104\u001a\u00020\r*\u0002052\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000209072\u0006\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020<2!\u0010=\u001a\u001d\u0012\u0013\u0012\u001108¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u00150>H\u0082@¢\u0006\u0002\u0010@J\u0018\u0010A\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0082@¢\u0006\u0002\u0010BJ\u001e\u0010C\u001a\u00020\u0015*\u00020\u00032\u0006\u0010-\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\f\u0010G\u001a\u00020\r*\u00020\u001cH\u0002J\u0014\u0010H\u001a\u000208*\u0002052\u0006\u0010I\u001a\u000208H\u0002J*\u0010H\u001a\u00020\r*\u00020\u00032\u0006\u0010-\u001a\u00020\u00132\u0006\u0010J\u001a\u0002082\u0006\u0010K\u001a\u000208H\u0082@¢\u0006\u0002\u0010LJ\u0014\u0010M\u001a\u0004\u0018\u00010\u0013*\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J;\u0010N\u001a\u00020\r*\u00020\u00032'\u0010O\u001a#\b\u0001\u0012\u0004\u0012\u000205\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\bPH\u0082@¢\u0006\u0002\u0010QR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R;\u0010\u0006\u001a-\b\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001b\u001a\u00020\u0015*\u00020\u001c8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006S"}, d2 = {"Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic;", "", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "mouseWheelScrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "onScrollStopped", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Velocity;", "Lkotlin/ParameterName;", "name", "velocity", "Lkotlin/coroutines/Continuation;", "", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/unit/Density;)V", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "isScrolling", "", "Lkotlin/jvm/functions/Function2;", "receivingMouseWheelEventsJob", "Lkotlinx/coroutines/Job;", "velocityTracker", "Landroidx/compose/foundation/gestures/MouseWheelVelocityTracker;", "isConsumed", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "onMouseWheel", "pointerEvent", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onMouseWheel-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "onPointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "startReceivingMouseWheelEvents", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "trackVelocity", "scrollDelta", "untilNull", "Lkotlin/sequences/Sequence;", ExifInterface.LONGITUDE_EAST, "builderAction", "Lkotlin/Function0;", "updateDensity", "animateMouseWheelScroll", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "animationState", "Landroidx/compose/animation/core/AnimationState;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "targetValue", "durationMillis", "", "shouldCancelAnimation", "Lkotlin/Function1;", "lastValue", "(Landroidx/compose/foundation/gestures/NestedScrollScope;Landroidx/compose/animation/core/AnimationState;FILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "busyReceive", "(Lkotlinx/coroutines/channels/Channel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canConsumeDelta", "Landroidx/compose/ui/geometry/Offset;", "canConsumeDelta-Uv8p0NA", "(Landroidx/compose/foundation/gestures/ScrollingLogic;J)Z", "consume", "dispatchMouseWheelScroll", "delta", "threshold", "speed", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sumOrNull", "userScroll", "block", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MouseWheelScrollDelta", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MouseWheelScrollingLogic {
    public static final int $stable = 8;
    private Density density;
    private boolean isScrolling;
    private final ScrollConfig mouseWheelScrollConfig;
    private final Function2<Velocity, Continuation<? super Unit>, Object> onScrollStopped;
    private Job receivingMouseWheelEventsJob;
    private final ScrollingLogic scrollingLogic;
    private final Channel<MouseWheelScrollDelta> channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    private final MouseWheelVelocityTracker velocityTracker = new MouseWheelVelocityTracker();

    /* JADX WARN: Multi-variable type inference failed */
    public MouseWheelScrollingLogic(ScrollingLogic scrollingLogic, ScrollConfig scrollConfig, Function2<? super Velocity, ? super Continuation<? super Unit>, ? extends Object> function2, Density density) {
        this.scrollingLogic = scrollingLogic;
        this.mouseWheelScrollConfig = scrollConfig;
        this.onScrollStopped = function2;
        this.density = density;
    }

    public final void updateDensity(Density density) {
        this.density = density;
    }

    /* renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public final void m785onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        if (pass == PointerEventPass.Main && PointerEventType.m5556equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5565getScroll7fucELk())) {
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            for (int i = 0; i < size; i++) {
                if (changes.get(i).isConsumed()) {
                    return;
                }
            }
            if (m784onMouseWheelO0kMr_c(pointerEvent, bounds)) {
                consume(pointerEvent);
            }
        }
    }

    private final boolean isConsumed(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            if (changes.get(i).isConsumed()) {
                return true;
            }
        }
        return false;
    }

    private final void consume(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            changes.get(i).consume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MouseWheelScrollable.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u000f\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\fJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0011\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\u0086\u0002J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\r\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "", "value", "Landroidx/compose/ui/geometry/Offset;", "timeMillis", "", "shouldApplyImmediately", "", "(JJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getShouldApplyImmediately", "()Z", "getTimeMillis", "()J", "getValue-F1C5BW0", "J", "component1", "component1-F1C5BW0", "component2", "component3", "copy", "copy-9KIMszo", "(JJZ)Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "equals", WriteOffReason.OTHER, "hashCode", "", "plus", "toString", "", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final /* data */ class MouseWheelScrollDelta {
        private final boolean shouldApplyImmediately;
        private final long timeMillis;
        private final long value;

        public /* synthetic */ MouseWheelScrollDelta(long j, long j2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, z);
        }

        /* renamed from: copy-9KIMszo$default, reason: not valid java name */
        public static /* synthetic */ MouseWheelScrollDelta m786copy9KIMszo$default(MouseWheelScrollDelta mouseWheelScrollDelta, long j, long j2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                j = mouseWheelScrollDelta.value;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                j2 = mouseWheelScrollDelta.timeMillis;
            }
            long j4 = j2;
            if ((i & 4) != 0) {
                z = mouseWheelScrollDelta.shouldApplyImmediately;
            }
            return mouseWheelScrollDelta.m788copy9KIMszo(j3, j4, z);
        }

        /* renamed from: component1-F1C5BW0, reason: not valid java name and from getter */
        public final long getValue() {
            return this.value;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTimeMillis() {
            return this.timeMillis;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getShouldApplyImmediately() {
            return this.shouldApplyImmediately;
        }

        /* renamed from: copy-9KIMszo, reason: not valid java name */
        public final MouseWheelScrollDelta m788copy9KIMszo(long value, long timeMillis, boolean shouldApplyImmediately) {
            return new MouseWheelScrollDelta(value, timeMillis, shouldApplyImmediately, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MouseWheelScrollDelta)) {
                return false;
            }
            MouseWheelScrollDelta mouseWheelScrollDelta = (MouseWheelScrollDelta) other;
            return Offset.m4122equalsimpl0(this.value, mouseWheelScrollDelta.value) && this.timeMillis == mouseWheelScrollDelta.timeMillis && this.shouldApplyImmediately == mouseWheelScrollDelta.shouldApplyImmediately;
        }

        public int hashCode() {
            return (((Offset.m4127hashCodeimpl(this.value) * 31) + Long.hashCode(this.timeMillis)) * 31) + Boolean.hashCode(this.shouldApplyImmediately);
        }

        public String toString() {
            return "MouseWheelScrollDelta(value=" + ((Object) Offset.m4133toStringimpl(this.value)) + ", timeMillis=" + this.timeMillis + ", shouldApplyImmediately=" + this.shouldApplyImmediately + ')';
        }

        private MouseWheelScrollDelta(long j, long j2, boolean z) {
            this.value = j;
            this.timeMillis = j2;
            this.shouldApplyImmediately = z;
        }

        /* renamed from: getValue-F1C5BW0, reason: not valid java name */
        public final long m789getValueF1C5BW0() {
            return this.value;
        }

        public final long getTimeMillis() {
            return this.timeMillis;
        }

        public final boolean getShouldApplyImmediately() {
            return this.shouldApplyImmediately;
        }

        public final MouseWheelScrollDelta plus(MouseWheelScrollDelta other) {
            return new MouseWheelScrollDelta(Offset.m4130plusMKHz9U(this.value, other.value), Math.max(this.timeMillis, other.timeMillis), this.shouldApplyImmediately, null);
        }
    }

    public final void startReceivingMouseWheelEvents(CoroutineScope coroutineScope) {
        Job launch$default;
        if (this.receivingMouseWheelEventsJob == null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1(this, null), 3, null);
            this.receivingMouseWheelEventsJob = launch$default;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object userScroll(androidx.compose.foundation.gestures.ScrollingLogic r5, kotlin.jvm.functions.Function2<? super androidx.compose.foundation.gestures.NestedScrollScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.MouseWheelScrollingLogic$userScroll$1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic$userScroll$1 r0 = (androidx.compose.foundation.gestures.MouseWheelScrollingLogic$userScroll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic$userScroll$1 r0 = new androidx.compose.foundation.gestures.MouseWheelScrollingLogic$userScroll$1
            r0.<init>(r4, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic r4 = (androidx.compose.foundation.gestures.MouseWheelScrollingLogic) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4f
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            r4.isScrolling = r3
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic$userScroll$2 r7 = new androidx.compose.foundation.gestures.MouseWheelScrollingLogic$userScroll$2
            r2 = 0
            r7.<init>(r5, r6, r2)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = kotlinx.coroutines.SupervisorKt.supervisorScope(r7, r0)
            if (r5 != r1) goto L4f
            return r1
        L4f:
            r5 = 0
            r4.isScrolling = r5
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollingLogic.userScroll(androidx.compose.foundation.gestures.ScrollingLogic, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: onMouseWheel-O0kMr_c, reason: not valid java name */
    private final boolean m784onMouseWheelO0kMr_c(PointerEvent pointerEvent, long bounds) {
        long mo722calculateMouseWheelScroll8xgXZGE = this.mouseWheelScrollConfig.mo722calculateMouseWheelScroll8xgXZGE(this.density, pointerEvent, bounds);
        if (m783canConsumeDeltaUv8p0NA(this.scrollingLogic, mo722calculateMouseWheelScroll8xgXZGE)) {
            return ChannelResult.m9464isSuccessimpl(this.channel.mo9440trySendJP2dKIU(new MouseWheelScrollDelta(mo722calculateMouseWheelScroll8xgXZGE, ((PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges())).getUptimeMillis(), !this.mouseWheelScrollConfig.isSmoothScrollingEnabled() || this.mouseWheelScrollConfig.isPreciseWheelScroll(pointerEvent), null)));
        }
        return this.isScrolling;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MouseWheelScrollDelta sumOrNull(final Channel<MouseWheelScrollDelta> channel) {
        MouseWheelScrollDelta mouseWheelScrollDelta = null;
        for (MouseWheelScrollDelta mouseWheelScrollDelta2 : untilNull(new Function0<MouseWheelScrollDelta>() { // from class: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$sumOrNull$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MouseWheelScrollingLogic.MouseWheelScrollDelta invoke() {
                return (MouseWheelScrollingLogic.MouseWheelScrollDelta) ChannelResult.m9459getOrNullimpl(channel.mo9447tryReceivePtdJZtk());
            }
        })) {
            mouseWheelScrollDelta = mouseWheelScrollDelta == null ? mouseWheelScrollDelta2 : mouseWheelScrollDelta.plus(mouseWheelScrollDelta2);
        }
        return mouseWheelScrollDelta;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object busyReceive(Channel<MouseWheelScrollDelta> channel, Continuation<? super MouseWheelScrollDelta> continuation) {
        return CoroutineScopeKt.coroutineScope(new MouseWheelScrollingLogic$busyReceive$2(channel, null), continuation);
    }

    private final <E> Sequence<E> untilNull(Function0<? extends E> builderAction) {
        return SequencesKt.sequence(new MouseWheelScrollingLogic$untilNull$1(builderAction, null));
    }

    /* renamed from: canConsumeDelta-Uv8p0NA, reason: not valid java name */
    private final boolean m783canConsumeDeltaUv8p0NA(ScrollingLogic scrollingLogic, long j) {
        float m838toFloatk4lQ0M = scrollingLogic.m838toFloatk4lQ0M(scrollingLogic.m836reverseIfNeededMKHz9U(j));
        if (m838toFloatk4lQ0M == 0.0f) {
            return false;
        }
        if (m838toFloatk4lQ0M > 0.0f) {
            return scrollingLogic.getScrollableState().getCanScrollForward();
        }
        return scrollingLogic.getScrollableState().getCanScrollBackward();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackVelocity(MouseWheelScrollDelta scrollDelta) {
        this.velocityTracker.m790addDeltaUv8p0NA(scrollDelta.getTimeMillis(), scrollDelta.m789getValueF1C5BW0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0113, code lost:
    
        if (r0.invoke(r1, r9) != r10) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, androidx.compose.foundation.gestures.MouseWheelScrollingLogic$MouseWheelScrollDelta] */
    /* JADX WARN: Type inference failed for: r0v8, types: [androidx.compose.animation.core.AnimationState, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object dispatchMouseWheelScroll(androidx.compose.foundation.gestures.ScrollingLogic r23, androidx.compose.foundation.gestures.MouseWheelScrollingLogic.MouseWheelScrollDelta r24, float r25, float r26, kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollingLogic.dispatchMouseWheelScroll(androidx.compose.foundation.gestures.ScrollingLogic, androidx.compose.foundation.gestures.MouseWheelScrollingLogic$MouseWheelScrollDelta, float, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Type inference failed for: r1v10, types: [androidx.compose.animation.core.AnimationState, T] */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, androidx.compose.foundation.gestures.MouseWheelScrollingLogic$MouseWheelScrollDelta] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object dispatchMouseWheelScroll$waitNextScrollDelta(androidx.compose.foundation.gestures.MouseWheelScrollingLogic r21, kotlin.jvm.internal.Ref.ObjectRef<androidx.compose.foundation.gestures.MouseWheelScrollingLogic.MouseWheelScrollDelta> r22, kotlin.jvm.internal.Ref.FloatRef r23, androidx.compose.foundation.gestures.ScrollingLogic r24, kotlin.jvm.internal.Ref.ObjectRef<androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r25, long r26, kotlin.coroutines.Continuation<? super java.lang.Boolean> r28) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollingLogic.dispatchMouseWheelScroll$waitNextScrollDelta(androidx.compose.foundation.gestures.MouseWheelScrollingLogic, kotlin.jvm.internal.Ref$ObjectRef, kotlin.jvm.internal.Ref$FloatRef, androidx.compose.foundation.gestures.ScrollingLogic, kotlin.jvm.internal.Ref$ObjectRef, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateMouseWheelScroll(final NestedScrollScope nestedScrollScope, AnimationState<Float, AnimationVector1D> animationState, float f, int i, final Function1<? super Float, Boolean> function1, Continuation<? super Unit> continuation) {
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = animationState.getValue().floatValue();
        Object animateTo = SuspendAnimationKt.animateTo(animationState, Boxing.boxFloat(f), AnimationSpecKt.tween$default(i, 0, EasingKt.getLinearEasing(), 2, null), true, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$animateMouseWheelScroll$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                invoke2(animationScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                boolean isLowScrollingDelta;
                float dispatchMouseWheelScroll;
                boolean isLowScrollingDelta2;
                float floatValue = animationScope.getValue().floatValue() - Ref.FloatRef.this.element;
                isLowScrollingDelta = MouseWheelScrollableKt.isLowScrollingDelta(floatValue);
                if (!isLowScrollingDelta) {
                    dispatchMouseWheelScroll = this.dispatchMouseWheelScroll(nestedScrollScope, floatValue);
                    isLowScrollingDelta2 = MouseWheelScrollableKt.isLowScrollingDelta(floatValue - dispatchMouseWheelScroll);
                    if (!isLowScrollingDelta2) {
                        animationScope.cancelAnimation();
                        return;
                    } else {
                        Ref.FloatRef.this.element += floatValue;
                    }
                }
                if (function1.invoke(Float.valueOf(Ref.FloatRef.this.element)).booleanValue()) {
                    animationScope.cancelAnimation();
                }
            }
        }, continuation);
        return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float dispatchMouseWheelScroll(NestedScrollScope nestedScrollScope, float f) {
        ScrollingLogic scrollingLogic = this.scrollingLogic;
        return scrollingLogic.m838toFloatk4lQ0M(scrollingLogic.m836reverseIfNeededMKHz9U(nestedScrollScope.mo792scrollByOzD1aCk(scrollingLogic.m839toOffsettuRUvjQ(scrollingLogic.reverseIfNeeded(f)), NestedScrollSource.INSTANCE.m5500getUserInputWNlRxjI())));
    }
}
