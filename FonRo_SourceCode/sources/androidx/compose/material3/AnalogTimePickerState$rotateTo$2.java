package androidx.compose.material3;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimePicker.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.material3.AnalogTimePickerState$rotateTo$2", f = "TimePicker.kt", i = {}, l = {803, 806}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class AnalogTimePickerState$rotateTo$2 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {
    final /* synthetic */ float $angle;
    final /* synthetic */ boolean $animate;
    int label;
    final /* synthetic */ AnalogTimePickerState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalogTimePickerState$rotateTo$2(AnalogTimePickerState analogTimePickerState, float f, boolean z, Continuation<? super AnalogTimePickerState$rotateTo$2> continuation) {
        super(1, continuation);
        this.this$0 = analogTimePickerState;
        this.$angle = f;
        this.$animate = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AnalogTimePickerState$rotateTo$2(this.this$0, this.$angle, this.$animate, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Object> continuation) {
        return invoke2((Continuation<Object>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<Object> continuation) {
        return ((AnalogTimePickerState$rotateTo$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a7, code lost:
    
        if (r12.snapTo(kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1), r11) == r0) goto L28;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r12)
            return r12
        L12:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1a:
            kotlin.ResultKt.throwOnFailure(r12)
            goto Laa
        L1f:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.compose.material3.AnalogTimePickerState r12 = r11.this$0
            int r12 = r12.mo1864getSelectionyecRtBI()
            androidx.compose.material3.TimePickerSelectionMode$Companion r1 = androidx.compose.material3.TimePickerSelectionMode.INSTANCE
            int r1 = r1.m2856getHouryecRtBI()
            boolean r12 = androidx.compose.material3.TimePickerSelectionMode.m2852equalsimpl0(r12, r1)
            androidx.compose.material3.AnalogTimePickerState r1 = r11.this$0
            if (r12 == 0) goto L67
            float r12 = r11.$angle
            int r12 = androidx.compose.material3.AnalogTimePickerState.access$toHour(r1, r12)
            r4 = 12
            int r12 = r12 % r4
            float r12 = (float) r12
            r5 = 1057360530(0x3f060a92, float:0.5235988)
            float r12 = r12 * r5
            androidx.compose.material3.AnalogTimePickerState.access$setHourAngle$p(r1, r12)
            androidx.compose.material3.AnalogTimePickerState r12 = r11.this$0
            androidx.compose.material3.TimePickerState r12 = r12.getState()
            androidx.compose.material3.AnalogTimePickerState r1 = r11.this$0
            float r5 = androidx.compose.material3.AnalogTimePickerState.access$getHourAngle$p(r1)
            int r1 = androidx.compose.material3.AnalogTimePickerState.access$toHour(r1, r5)
            int r1 = r1 % r4
            androidx.compose.material3.AnalogTimePickerState r5 = r11.this$0
            boolean r5 = r5.isAfternoon()
            if (r5 == 0) goto L61
            goto L62
        L61:
            r4 = 0
        L62:
            int r1 = r1 + r4
            r12.setHour(r1)
            goto L88
        L67:
            float r12 = r11.$angle
            int r12 = androidx.compose.material3.AnalogTimePickerState.access$toMinute(r1, r12)
            float r12 = (float) r12
            r4 = 1037465424(0x3dd67750, float:0.10471976)
            float r12 = r12 * r4
            androidx.compose.material3.AnalogTimePickerState.access$setMinuteAngle$p(r1, r12)
            androidx.compose.material3.AnalogTimePickerState r12 = r11.this$0
            androidx.compose.material3.TimePickerState r12 = r12.getState()
            androidx.compose.material3.AnalogTimePickerState r1 = r11.this$0
            float r4 = androidx.compose.material3.AnalogTimePickerState.access$getMinuteAngle$p(r1)
            int r1 = androidx.compose.material3.AnalogTimePickerState.access$toMinute(r1, r4)
            r12.setMinute(r1)
        L88:
            boolean r12 = r11.$animate
            androidx.compose.material3.AnalogTimePickerState r1 = r11.this$0
            if (r12 != 0) goto Lad
            androidx.compose.animation.core.Animatable r12 = androidx.compose.material3.AnalogTimePickerState.access$getAnim$p(r1)
            androidx.compose.material3.AnalogTimePickerState r1 = r11.this$0
            float r2 = r11.$angle
            float r1 = androidx.compose.material3.AnalogTimePickerState.access$offsetAngle(r1, r2)
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            r2 = r11
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r11.label = r3
            java.lang.Object r11 = r12.snapTo(r1, r2)
            if (r11 != r0) goto Laa
            goto Ldd
        Laa:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        Lad:
            float r12 = r11.$angle
            float r12 = androidx.compose.material3.AnalogTimePickerState.access$offsetAngle(r1, r12)
            float r12 = androidx.compose.material3.AnalogTimePickerState.access$endValueForAnimation(r1, r12)
            androidx.compose.material3.AnalogTimePickerState r1 = r11.this$0
            androidx.compose.animation.core.Animatable r3 = androidx.compose.material3.AnalogTimePickerState.access$getAnim$p(r1)
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r12)
            r12 = 1143930880(0x442f0000, float:700.0)
            r1 = 4
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            androidx.compose.animation.core.SpringSpec r12 = androidx.compose.animation.core.AnimationSpecKt.spring$default(r5, r12, r6, r1, r6)
            r5 = r12
            androidx.compose.animation.core.AnimationSpec r5 = (androidx.compose.animation.core.AnimationSpec) r5
            r8 = r11
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r11.label = r2
            r7 = 0
            r9 = 12
            r10 = 0
            java.lang.Object r11 = androidx.compose.animation.core.Animatable.animateTo$default(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r11 != r0) goto Lde
        Ldd:
            return r0
        Lde:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AnalogTimePickerState$rotateTo$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
