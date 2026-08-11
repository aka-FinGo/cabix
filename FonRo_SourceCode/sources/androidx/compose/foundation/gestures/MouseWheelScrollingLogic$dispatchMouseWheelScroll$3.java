package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.MouseWheelScrollingLogic;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MouseWheelScrollable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$3", f = "MouseWheelScrollable.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {253, 266, 283}, m = "invokeSuspend", n = {"$this$userScroll", "requiredAnimation", "$this$userScroll", "requiredAnimation", "durationMillis", "$this$userScroll", "requiredAnimation"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0", "L$1"})
/* loaded from: classes.dex */
public final class MouseWheelScrollingLogic$dispatchMouseWheelScroll$3 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> $animationState;
    final /* synthetic */ float $speed;
    final /* synthetic */ Ref.ObjectRef<MouseWheelScrollingLogic.MouseWheelScrollDelta> $targetScrollDelta;
    final /* synthetic */ Ref.FloatRef $targetValue;
    final /* synthetic */ ScrollingLogic $this_dispatchMouseWheelScroll;
    final /* synthetic */ float $threshold;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MouseWheelScrollingLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MouseWheelScrollingLogic$dispatchMouseWheelScroll$3(Ref.FloatRef floatRef, Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> objectRef, Ref.ObjectRef<MouseWheelScrollingLogic.MouseWheelScrollDelta> objectRef2, float f, MouseWheelScrollingLogic mouseWheelScrollingLogic, float f2, ScrollingLogic scrollingLogic, Continuation<? super MouseWheelScrollingLogic$dispatchMouseWheelScroll$3> continuation) {
        super(2, continuation);
        this.$targetValue = floatRef;
        this.$animationState = objectRef;
        this.$targetScrollDelta = objectRef2;
        this.$threshold = f;
        this.this$0 = mouseWheelScrollingLogic;
        this.$speed = f2;
        this.$this_dispatchMouseWheelScroll = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MouseWheelScrollingLogic$dispatchMouseWheelScroll$3 mouseWheelScrollingLogic$dispatchMouseWheelScroll$3 = new MouseWheelScrollingLogic$dispatchMouseWheelScroll$3(this.$targetValue, this.$animationState, this.$targetScrollDelta, this.$threshold, this.this$0, this.$speed, this.$this_dispatchMouseWheelScroll, continuation);
        mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.L$0 = obj;
        return mouseWheelScrollingLogic$dispatchMouseWheelScroll$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(NestedScrollScope nestedScrollScope, Continuation<? super Unit> continuation) {
        return ((MouseWheelScrollingLogic$dispatchMouseWheelScroll$3) create(nestedScrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x019d  */
    /* JADX WARN: Type inference failed for: r2v16, types: [androidx.compose.animation.core.AnimationState, T] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x012f -> B:9:0x0067). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x015b -> B:7:0x015c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
