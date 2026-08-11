package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "latestTarget"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2", f = "AnchoredDraggable.kt", i = {}, l = {1391, 1409, 1433}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class AnchoredDraggableKt$animateToWithDecay$2<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
    final /* synthetic */ DecayAnimationSpec<Float> $decayAnimationSpec;
    final /* synthetic */ Ref.FloatRef $remainingVelocity;
    final /* synthetic */ AnimationSpec<Float> $snapAnimationSpec;
    final /* synthetic */ AnchoredDraggableState<T> $this_animateToWithDecay;
    final /* synthetic */ float $velocity;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableKt$animateToWithDecay$2(AnchoredDraggableState<T> anchoredDraggableState, float f, AnimationSpec<Float> animationSpec, Ref.FloatRef floatRef, DecayAnimationSpec<Float> decayAnimationSpec, Continuation<? super AnchoredDraggableKt$animateToWithDecay$2> continuation) {
        super(4, continuation);
        this.$this_animateToWithDecay = anchoredDraggableState;
        this.$velocity = f;
        this.$snapAnimationSpec = animationSpec;
        this.$remainingVelocity = floatRef;
        this.$decayAnimationSpec = decayAnimationSpec;
    }

    public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t, Continuation<? super Unit> continuation) {
        AnchoredDraggableKt$animateToWithDecay$2 anchoredDraggableKt$animateToWithDecay$2 = new AnchoredDraggableKt$animateToWithDecay$2(this.$this_animateToWithDecay, this.$velocity, this.$snapAnimationSpec, this.$remainingVelocity, this.$decayAnimationSpec, continuation);
        anchoredDraggableKt$animateToWithDecay$2.L$0 = anchoredDragScope;
        anchoredDraggableKt$animateToWithDecay$2.L$1 = draggableAnchors;
        anchoredDraggableKt$animateToWithDecay$2.L$2 = t;
        return anchoredDraggableKt$animateToWithDecay$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(AnchoredDragScope anchoredDragScope, Object obj, Object obj2, Continuation<? super Unit> continuation) {
        return invoke(anchoredDragScope, (DraggableAnchors<DraggableAnchors<T>>) obj, (DraggableAnchors<T>) obj2, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00de, code lost:
    
        if (r2 == r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c9, code lost:
    
        if (androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r22, r3, false, new androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2.AnonymousClass3(), r29, 2, null) == r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00fa, code lost:
    
        if (r2 == r1) goto L42;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r30) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
