package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016*\u0001\u0011\b\u0007\u0018\u0000 \u007f*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u007fB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006B2\b\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0002\u0010\rBB\b\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012#\b\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0002\u0010\u000eB\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJy\u0010_\u001a\u00020`2\u0006\u0010S\u001a\u00028\u00002\b\b\u0002\u0010a\u001a\u00020b2W\u0010c\u001aS\b\u0001\u0012\u0004\u0012\u00020e\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(S\u0012\n\u0012\b\u0012\u0004\u0012\u00020`0g\u0012\u0006\u0012\u0004\u0018\u00010\u00020d¢\u0006\u0002\bhH\u0086@¢\u0006\u0002\u0010iJ\\\u0010_\u001a\u00020`2\b\b\u0002\u0010a\u001a\u00020b2B\u0010c\u001a>\b\u0001\u0012\u0004\u0012\u00020e\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020`0g\u0012\u0006\u0012\u0004\u0018\u00010\u00020j¢\u0006\u0002\bhH\u0086@¢\u0006\u0002\u0010kJ\u000e\u0010l\u001a\u00020$2\u0006\u0010m\u001a\u00020$J\u0015\u0010n\u001a\u00020$2\u0006\u0010m\u001a\u00020$H\u0000¢\u0006\u0002\boJ\u001d\u0010C\u001a\u00020$2\u0006\u0010p\u001a\u00028\u00002\u0006\u0010q\u001a\u00028\u0000H\u0007¢\u0006\u0002\u0010rJ\u0006\u0010s\u001a\u00020$J\u001c\u0010t\u001a\u00020`2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020$0LH\u0086@¢\u0006\u0002\u0010vJ\u0016\u0010t\u001a\u00020$2\u0006\u0010w\u001a\u00020$H\u0087@¢\u0006\u0002\u0010xJ\u0015\u0010y\u001a\u00020\f2\u0006\u0010S\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010zJ#\u0010{\u001a\u00020`2\f\u0010|\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\b\b\u0002\u0010}\u001a\u00028\u0000¢\u0006\u0002\u0010~R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R7\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R5\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR+\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0019\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u000fR8\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020$0#8\u0006@@X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010.\u001a\u0004\u0018\u00018\u00002\b\u0010\u0013\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0019\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\u000fR\u0011\u00102\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b2\u00103R+\u00104\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020$8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b5\u00106\"\u0004\b7\u00108R+\u0010;\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020$8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010:\u001a\u0004\b<\u00106\"\u0004\b=\u00108R5\u0010?\u001a\u001d\u0012\u0013\u0012\u00110$¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020$0\bX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001b\"\u0004\bB\u0010\u001dR!\u0010C\u001a\u00020$8GX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\bF\u0010G\u0012\u0004\bD\u0010'\u001a\u0004\bE\u00106R+\u0010H\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010\u0019\u001a\u0004\bI\u0010 \"\u0004\bJ\u0010\u000fR8\u0010M\u001a\b\u0012\u0004\u0012\u00020$0L2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020$0L8\u0006@@X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\bN\u0010'\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001b\u0010S\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010G\u001a\u0004\bT\u0010 R\u001a\u0010V\u001a\u00020\f8@X\u0080\u0004¢\u0006\f\u0012\u0004\bW\u0010'\u001a\u0004\bX\u00103R \u0010Y\u001a\b\u0012\u0004\u0012\u00020$0ZX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^¨\u0006\u0080\u0001"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialValue", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;)V", "confirmValueChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;)V", "anchoredDragScope", "androidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1", "Landroidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1;", "<set-?>", "getAnchors", "()Landroidx/compose/foundation/gestures/DraggableAnchors;", "setAnchors", "(Landroidx/compose/foundation/gestures/DraggableAnchors;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getConfirmValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setConfirmValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "currentValue$delegate", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "decayAnimationSpec", "getDecayAnimationSpec$annotations", "()V", "getDecayAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "setDecayAnimationSpec$foundation_release", "(Landroidx/compose/animation/core/DecayAnimationSpec;)V", "dragMutex", "Landroidx/compose/foundation/MutatorMutex;", "dragTarget", "getDragTarget", "setDragTarget", "dragTarget$delegate", "isAnimationRunning", "()Z", "lastVelocity", "getLastVelocity", "()F", "setLastVelocity", "(F)V", "lastVelocity$delegate", "Landroidx/compose/runtime/MutableFloatState;", TypedValues.CycleType.S_WAVE_OFFSET, "getOffset", "setOffset", "offset$delegate", "positionalThreshold", "totalDistance", "getPositionalThreshold$foundation_release", "setPositionalThreshold$foundation_release", "progress", "getProgress$annotations", "getProgress", "progress$delegate", "Landroidx/compose/runtime/State;", "settledValue", "getSettledValue", "setSettledValue", "settledValue$delegate", "Landroidx/compose/animation/core/AnimationSpec;", "snapAnimationSpec", "getSnapAnimationSpec$annotations", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "setSnapAnimationSpec$foundation_release", "(Landroidx/compose/animation/core/AnimationSpec;)V", "targetValue", "getTargetValue", "targetValue$delegate", "usePreModifierChangeBehavior", "getUsePreModifierChangeBehavior$foundation_release$annotations", "getUsePreModifierChangeBehavior$foundation_release", "velocityThreshold", "Lkotlin/Function0;", "getVelocityThreshold$foundation_release", "()Lkotlin/jvm/functions/Function0;", "setVelocityThreshold$foundation_release", "(Lkotlin/jvm/functions/Function0;)V", "anchoredDrag", "", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function4;", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchor", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "newOffsetForDelta", "newOffsetForDelta$foundation_release", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "(Ljava/lang/Object;Ljava/lang/Object;)F", "requireOffset", "settle", "animationSpec", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySnapTo", "(Ljava/lang/Object;)Z", "updateAnchors", "newAnchors", "newTarget", "(Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;)V", "Companion", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AnchoredDraggableState<T> {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnchoredDraggableState$anchoredDragScope$1 anchoredDragScope;

    /* renamed from: anchors$delegate, reason: from kotlin metadata */
    private final MutableState anchors;
    private Function1<? super T, Boolean> confirmValueChange;

    /* renamed from: currentValue$delegate, reason: from kotlin metadata */
    private final MutableState currentValue;
    public DecayAnimationSpec<Float> decayAnimationSpec;
    private final MutatorMutex dragMutex;

    /* renamed from: dragTarget$delegate, reason: from kotlin metadata */
    private final MutableState dragTarget;

    /* renamed from: lastVelocity$delegate, reason: from kotlin metadata */
    private final MutableFloatState lastVelocity;

    /* renamed from: offset$delegate, reason: from kotlin metadata */
    private final MutableFloatState androidx.constraintlayout.core.motion.utils.TypedValues.CycleType.S_WAVE_OFFSET java.lang.String;
    public Function1<? super Float, Float> positionalThreshold;

    /* renamed from: progress$delegate, reason: from kotlin metadata */
    private final State progress;

    /* renamed from: settledValue$delegate, reason: from kotlin metadata */
    private final MutableState settledValue;
    public AnimationSpec<Float> snapAnimationSpec;

    /* renamed from: targetValue$delegate, reason: from kotlin metadata */
    private final State targetValue;
    public Function0<Float> velocityThreshold;

    @Deprecated(level = DeprecationLevel.WARNING, message = "This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to anchoredDraggableFlingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.")
    public static /* synthetic */ void getDecayAnimationSpec$annotations() {
    }

    @Deprecated(message = "Use the progress function to query the progress between two specified anchors.", replaceWith = @ReplaceWith(expression = "progress(state.settledValue, state.targetValue)", imports = {}))
    public static /* synthetic */ void getProgress$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to anchoredDraggableFlingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.")
    public static /* synthetic */ void getSnapAnimationSpec$annotations() {
    }

    public static /* synthetic */ void getUsePreModifierChangeBehavior$foundation_release$annotations() {
    }

    public AnchoredDraggableState(T t) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        DefaultDraggableAnchors emptyDraggableAnchors;
        MutableState mutableStateOf$default4;
        this.confirmValueChange = new Function1<T, Boolean>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$confirmValueChange$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(T t2) {
                return true;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return invoke((AnchoredDraggableState$confirmValueChange$1<T>) obj);
            }
        };
        this.dragMutex = new MutatorMutex();
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.currentValue = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.settledValue = mutableStateOf$default2;
        this.targetValue = SnapshotStateKt.derivedStateOf(new Function0<T>(this) { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$targetValue$2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                Object dragTarget;
                dragTarget = this.this$0.getDragTarget();
                T t2 = (T) dragTarget;
                if (t2 != null) {
                    return t2;
                }
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                if (!Float.isNaN(anchoredDraggableState.getOffset())) {
                    T closestAnchor = anchoredDraggableState.getAnchors().closestAnchor(anchoredDraggableState.getOffset());
                    return closestAnchor == null ? anchoredDraggableState.getCurrentValue() : closestAnchor;
                }
                return anchoredDraggableState.getCurrentValue();
            }
        });
        this.androidx.constraintlayout.core.motion.utils.TypedValues.CycleType.S_WAVE_OFFSET java.lang.String = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NaN);
        this.progress = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Float>(this) { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$progress$2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                float positionOf = this.this$0.getAnchors().positionOf(this.this$0.getSettledValue());
                float positionOf2 = this.this$0.getAnchors().positionOf(this.this$0.getTargetValue()) - positionOf;
                float abs = Math.abs(positionOf2);
                float f = 1.0f;
                if (!Float.isNaN(abs) && abs > 1.0E-6f) {
                    float requireOffset = (this.this$0.requireOffset() - positionOf) / positionOf2;
                    if (requireOffset < 1.0E-6f) {
                        f = 0.0f;
                    } else if (requireOffset <= 0.999999f) {
                        f = requireOffset;
                    }
                }
                return Float.valueOf(f);
            }
        });
        this.lastVelocity = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.dragTarget = mutableStateOf$default3;
        emptyDraggableAnchors = AnchoredDraggableKt.emptyDraggableAnchors();
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(emptyDraggableAnchors, null, 2, null);
        this.anchors = mutableStateOf$default4;
        this.anchoredDragScope = new AnchoredDraggableState$anchoredDragScope$1(this);
    }

    public AnchoredDraggableState(T t, DraggableAnchors<T> draggableAnchors) {
        this(t);
        setAnchors(draggableAnchors);
        trySnapTo(t);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.")
    public AnchoredDraggableState(T t, Function1<? super T, Boolean> function1) {
        this(t);
        this.confirmValueChange = function1;
    }

    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$1 */
    /* loaded from: classes.dex */
    static final class AnonymousClass1 extends Lambda implements Function1<T, Boolean> {
        public static final AnonymousClass1 INSTANCE = ;

        AnonymousClass1() {
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(T t) {
            return true;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return invoke((AnonymousClass1) obj);
        }
    }

    public /* synthetic */ AnchoredDraggableState(Object obj, DraggableAnchors draggableAnchors, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, draggableAnchors, (i & 4) != 0 ? AnonymousClass1.INSTANCE : anonymousClass1);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.")
    public AnchoredDraggableState(T t, DraggableAnchors<T> draggableAnchors, Function1<? super T, Boolean> function1) {
        this(t, function1);
        setAnchors(draggableAnchors);
        trySnapTo(t);
    }

    public final Function1<T, Boolean> getConfirmValueChange$foundation_release() {
        return this.confirmValueChange;
    }

    public final void setConfirmValueChange$foundation_release(Function1<? super T, Boolean> function1) {
        this.confirmValueChange = function1;
    }

    public final Function1<Float, Float> getPositionalThreshold$foundation_release() {
        Function1 function1 = this.positionalThreshold;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("positionalThreshold");
        return null;
    }

    public final void setPositionalThreshold$foundation_release(Function1<? super Float, Float> function1) {
        this.positionalThreshold = function1;
    }

    public final Function0<Float> getVelocityThreshold$foundation_release() {
        Function0<Float> function0 = this.velocityThreshold;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityThreshold");
        return null;
    }

    public final void setVelocityThreshold$foundation_release(Function0<Float> function0) {
        this.velocityThreshold = function0;
    }

    public final AnimationSpec<Float> getSnapAnimationSpec() {
        AnimationSpec<Float> animationSpec = this.snapAnimationSpec;
        if (animationSpec != null) {
            return animationSpec;
        }
        Intrinsics.throwUninitializedPropertyAccessException("snapAnimationSpec");
        return null;
    }

    public final void setSnapAnimationSpec$foundation_release(AnimationSpec<Float> animationSpec) {
        this.snapAnimationSpec = animationSpec;
    }

    public final DecayAnimationSpec<Float> getDecayAnimationSpec() {
        DecayAnimationSpec<Float> decayAnimationSpec = this.decayAnimationSpec;
        if (decayAnimationSpec != null) {
            return decayAnimationSpec;
        }
        Intrinsics.throwUninitializedPropertyAccessException("decayAnimationSpec");
        return null;
    }

    public final void setDecayAnimationSpec$foundation_release(DecayAnimationSpec<Float> decayAnimationSpec) {
        this.decayAnimationSpec = decayAnimationSpec;
    }

    public final boolean getUsePreModifierChangeBehavior$foundation_release() {
        return (this.positionalThreshold == null || this.velocityThreshold == null || this.snapAnimationSpec == null || this.decayAnimationSpec == null) ? false : true;
    }

    public final void setCurrentValue(T t) {
        this.currentValue.setValue(t);
    }

    public final T getCurrentValue() {
        return this.currentValue.getValue();
    }

    public final void setSettledValue(T t) {
        this.settledValue.setValue(t);
    }

    public final T getSettledValue() {
        return this.settledValue.getValue();
    }

    public final T getTargetValue() {
        return (T) this.targetValue.getValue();
    }

    public final void setOffset(float f) {
        this.androidx.constraintlayout.core.motion.utils.TypedValues.CycleType.S_WAVE_OFFSET java.lang.String.setFloatValue(f);
    }

    public final float getOffset() {
        return this.androidx.constraintlayout.core.motion.utils.TypedValues.CycleType.S_WAVE_OFFSET java.lang.String.getFloatValue();
    }

    public final float requireOffset() {
        if (Float.isNaN(getOffset())) {
            InlineClassHelperKt.throwIllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?");
        }
        return getOffset();
    }

    public final boolean isAnimationRunning() {
        return getDragTarget() != null;
    }

    public final float progress(T r3, T r4) {
        float positionOf = getAnchors().positionOf(r3);
        float positionOf2 = getAnchors().positionOf(r4);
        float coerceIn = (RangesKt.coerceIn(getOffset(), Math.min(positionOf, positionOf2), Math.max(positionOf, positionOf2)) - positionOf) / (positionOf2 - positionOf);
        if (Float.isNaN(coerceIn)) {
            return 1.0f;
        }
        if (coerceIn < 1.0E-6f) {
            return 0.0f;
        }
        if (coerceIn > 0.999999f) {
            return 1.0f;
        }
        return Math.abs(coerceIn);
    }

    public final float getProgress() {
        return ((Number) this.progress.getValue()).floatValue();
    }

    public final void setLastVelocity(float f) {
        this.lastVelocity.setFloatValue(f);
    }

    public final float getLastVelocity() {
        return this.lastVelocity.getFloatValue();
    }

    public final T getDragTarget() {
        return this.dragTarget.getValue();
    }

    public final void setDragTarget(T t) {
        this.dragTarget.setValue(t);
    }

    private final void setAnchors(DraggableAnchors<T> draggableAnchors) {
        this.anchors.setValue(draggableAnchors);
    }

    public final DraggableAnchors<T> getAnchors() {
        return (DraggableAnchors) this.anchors.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateAnchors$default(AnchoredDraggableState anchoredDraggableState, DraggableAnchors draggableAnchors, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            if (!Float.isNaN(anchoredDraggableState.getOffset())) {
                obj = draggableAnchors.closestAnchor(anchoredDraggableState.getOffset());
                if (obj == null) {
                    obj = anchoredDraggableState.getTargetValue();
                }
            } else {
                obj = anchoredDraggableState.getTargetValue();
            }
        }
        anchoredDraggableState.updateAnchors(draggableAnchors, obj);
    }

    public final void updateAnchors(DraggableAnchors<T> newAnchors, T newTarget) {
        if (Intrinsics.areEqual(getAnchors(), newAnchors)) {
            return;
        }
        setAnchors(newAnchors);
        if (trySnapTo(newTarget)) {
            return;
        }
        setDragTarget(newTarget);
    }

    public final Object settle(AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        T currentValue = getCurrentValue();
        T closestAnchor = getAnchors().closestAnchor(requireOffset());
        if (closestAnchor != null && this.confirmValueChange.invoke(closestAnchor).booleanValue()) {
            Object animateTo = AnchoredDraggableKt.animateTo(this, closestAnchor, animationSpec, continuation);
            return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
        }
        Object animateTo2 = AnchoredDraggableKt.animateTo(this, currentValue, animationSpec, continuation);
        return animateTo2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo2 : Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "settle does not accept a velocity anymore. Please use FlingBehavior#performFling instead. See AnchoredDraggableSamples.kt for example usages.")
    public final Object settle(float f, Continuation<? super Float> continuation) {
        Object computeTarget;
        if (!getUsePreModifierChangeBehavior$foundation_release()) {
            InlineClassHelperKt.throwIllegalArgumentException("AnchoredDraggableState was configured through a constructor without providing positional and velocity threshold. This overload of settle has been deprecated. Please refer to AnchoredDraggableState#settle(animationSpec) for more information.");
        }
        T currentValue = getCurrentValue();
        computeTarget = AnchoredDraggableKt.computeTarget(getAnchors(), requireOffset(), f, getPositionalThreshold$foundation_release(), getVelocityThreshold$foundation_release());
        if (this.confirmValueChange.invoke(computeTarget).booleanValue()) {
            return AnchoredDraggableKt.animateToWithDecay$default(this, computeTarget, f, null, null, continuation, 12, null);
        }
        return AnchoredDraggableKt.animateToWithDecay$default(this, currentValue, f, null, null, continuation, 12, null);
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, MutatePriority mutatePriority, Function3 function3, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(mutatePriority, function3, continuation);
    }

    public final Object anchoredDrag(MutatePriority mutatePriority, Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object mutate = this.dragMutex.mutate(mutatePriority, new AnchoredDraggableState$anchoredDrag$2(this, function3, null), continuation);
        return mutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object anchoredDrag(T r6, androidx.compose.foundation.MutatePriority r7, kotlin.jvm.functions.Function4<? super androidx.compose.foundation.gestures.AnchoredDragScope, ? super androidx.compose.foundation.gestures.DraggableAnchors<T>, ? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3 r0 = (androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3 r0 = new androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3
            r0.<init>(r5, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.gestures.AnchoredDraggableState r5 = (androidx.compose.foundation.gestures.AnchoredDraggableState) r5
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L5d
            goto L59
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.ResultKt.throwOnFailure(r9)
            androidx.compose.foundation.gestures.DraggableAnchors r9 = r5.getAnchors()
            boolean r9 = r9.hasPositionFor(r6)
            if (r9 == 0) goto L62
            androidx.compose.foundation.MutatorMutex r9 = r5.dragMutex     // Catch: java.lang.Throwable -> L5d
            androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4 r2 = new androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4     // Catch: java.lang.Throwable -> L5d
            r2.<init>(r5, r6, r8, r4)     // Catch: java.lang.Throwable -> L5d
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch: java.lang.Throwable -> L5d
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L5d
            r0.label = r3     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r6 = r9.mutate(r7, r2, r0)     // Catch: java.lang.Throwable -> L5d
            if (r6 != r1) goto L59
            return r1
        L59:
            r5.setDragTarget(r4)
            goto L76
        L5d:
            r6 = move-exception
            r5.setDragTarget(r4)
            throw r6
        L62:
            kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r7 = r5.confirmValueChange
            java.lang.Object r7 = r7.invoke(r6)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L76
            r5.setSettledValue(r6)
            r5.setCurrentValue(r6)
        L76:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableState.anchoredDrag(java.lang.Object, androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function4, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, Object obj, MutatePriority mutatePriority, Function4 function4, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(obj, mutatePriority, function4, continuation);
    }

    public final float newOffsetForDelta$foundation_release(float delta) {
        return RangesKt.coerceIn((Float.isNaN(getOffset()) ? 0.0f : getOffset()) + delta, getAnchors().minPosition(), getAnchors().maxPosition());
    }

    public final float dispatchRawDelta(float delta) {
        float newOffsetForDelta$foundation_release = newOffsetForDelta$foundation_release(delta);
        float requireOffset = newOffsetForDelta$foundation_release - requireOffset();
        AnchoredDragScope.dragTo$default(this.anchoredDragScope, newOffsetForDelta$foundation_release, 0.0f, 2, null);
        return requireOffset;
    }

    private final boolean trySnapTo(T targetValue) {
        MutatorMutex mutatorMutex = this.dragMutex;
        boolean tryLock = mutatorMutex.tryLock();
        if (!tryLock) {
            return tryLock;
        }
        try {
            AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = this.anchoredDragScope;
            float positionOf = getAnchors().positionOf(targetValue);
            if (!Float.isNaN(positionOf)) {
                AnchoredDragScope.dragTo$default(anchoredDraggableState$anchoredDragScope$1, positionOf, 0.0f, 2, null);
                setDragTarget(null);
            }
            setCurrentValue(targetValue);
            setSettledValue(targetValue);
            return tryLock;
        } finally {
            mutatorMutex.unlock();
        }
    }

    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u0001J:\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0087\u0001\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\f0\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\t0\bH\u0007¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", ExifInterface.GPS_DIRECTION_TRUE, "confirmValueChange", "Lkotlin/Function1;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "positionalThreshold", "Lkotlin/ParameterName;", "name", "distance", "velocityThreshold", "Lkotlin/Function0;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> Saver<AnchoredDraggableState<T>, T> Saver() {
            return SaverKt.Saver(new Function2<SaverScope, AnchoredDraggableState<T>, T>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final T invoke(SaverScope saverScope, AnchoredDraggableState<T> anchoredDraggableState) {
                    return anchoredDraggableState.getCurrentValue();
                }
            }, new Function1<T, AnchoredDraggableState<T>>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$Saver$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((AnchoredDraggableState$Companion$Saver$2<T>) obj);
                }

                @Override // kotlin.jvm.functions.Function1
                public final AnchoredDraggableState<T> invoke(T t) {
                    return new AnchoredDraggableState<>(t);
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Saver Saver$default(Companion companion, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = new Function1<T, Boolean>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$Saver$3
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(T t) {
                        return true;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Object obj2) {
                        return invoke((AnchoredDraggableState$Companion$Saver$3<T>) obj2);
                    }
                };
            }
            return companion.Saver(function1);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.")
        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(final Function1<? super T, Boolean> confirmValueChange) {
            return SaverKt.Saver(new Function2<SaverScope, AnchoredDraggableState<T>, T>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$Saver$4
                @Override // kotlin.jvm.functions.Function2
                public final T invoke(SaverScope saverScope, AnchoredDraggableState<T> anchoredDraggableState) {
                    return anchoredDraggableState.getCurrentValue();
                }
            }, new Function1<T, AnchoredDraggableState<T>>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$Saver$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((AnchoredDraggableState$Companion$Saver$5<T>) obj);
                }

                @Override // kotlin.jvm.functions.Function1
                public final AnchoredDraggableState<T> invoke(T t) {
                    return new AnchoredDraggableState<>(t, confirmValueChange);
                }
            });
        }

        public static /* synthetic */ Saver Saver$default(Companion companion, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Function1 function1, Function0 function0, Function1 function12, int i, Object obj) {
            if ((i & 16) != 0) {
                function12 = new Function1<T, Boolean>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$Saver$6
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(T t) {
                        return true;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Object obj2) {
                        return invoke((AnchoredDraggableState$Companion$Saver$6<T>) obj2);
                    }
                };
            }
            return companion.Saver(animationSpec, decayAnimationSpec, function1, function0, function12);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to anchoredDraggableFlingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.")
        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(final AnimationSpec<Float> snapAnimationSpec, final DecayAnimationSpec<Float> decayAnimationSpec, final Function1<? super Float, Float> positionalThreshold, final Function0<Float> velocityThreshold, final Function1<? super T, Boolean> confirmValueChange) {
            return SaverKt.Saver(new Function2<SaverScope, AnchoredDraggableState<T>, T>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$Saver$7
                @Override // kotlin.jvm.functions.Function2
                public final T invoke(SaverScope saverScope, AnchoredDraggableState<T> anchoredDraggableState) {
                    return anchoredDraggableState.getCurrentValue();
                }
            }, new Function1<T, AnchoredDraggableState<T>>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$Saver$8
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((AnchoredDraggableState$Companion$Saver$8<T>) obj);
                }

                @Override // kotlin.jvm.functions.Function1
                public final AnchoredDraggableState<T> invoke(T t) {
                    return AnchoredDraggableKt.AnchoredDraggableState(t, positionalThreshold, velocityThreshold, snapAnimationSpec, decayAnimationSpec, confirmValueChange);
                }
            });
        }
    }
}
