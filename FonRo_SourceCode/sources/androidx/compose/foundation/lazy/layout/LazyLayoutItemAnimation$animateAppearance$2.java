package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyLayoutItemAnimation.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2", f = "LazyLayoutItemAnimation.kt", i = {}, l = {183, ModuleDescriptor.MODULE_VERSION}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class LazyLayoutItemAnimation$animateAppearance$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GraphicsLayer $layer;
    final /* synthetic */ boolean $shouldResetValue;
    final /* synthetic */ FiniteAnimationSpec<Float> $spec;
    int label;
    final /* synthetic */ LazyLayoutItemAnimation this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutItemAnimation$animateAppearance$2(boolean z, LazyLayoutItemAnimation lazyLayoutItemAnimation, FiniteAnimationSpec<Float> finiteAnimationSpec, GraphicsLayer graphicsLayer, Continuation<? super LazyLayoutItemAnimation$animateAppearance$2> continuation) {
        super(2, continuation);
        this.$shouldResetValue = z;
        this.this$0 = lazyLayoutItemAnimation;
        this.$spec = finiteAnimationSpec;
        this.$layer = graphicsLayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutItemAnimation$animateAppearance$2(this.$shouldResetValue, this.this$0, this.$spec, this.$layer, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutItemAnimation$animateAppearance$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006a, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r4, r5, r6, null, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2.AnonymousClass1(), r12, 4, null) == r0) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L23
            if (r1 == r4) goto L1c
            if (r1 != r3) goto L13
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L20
            goto L6d
        L13:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L1c:
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L20
            goto L41
        L20:
            r0 = move-exception
            r13 = r0
            goto L75
        L23:
            kotlin.ResultKt.throwOnFailure(r13)
            boolean r13 = r12.$shouldResetValue     // Catch: java.lang.Throwable -> L20
            if (r13 == 0) goto L41
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r13 = r12.this$0     // Catch: java.lang.Throwable -> L20
            androidx.compose.animation.core.Animatable r13 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.access$getVisibilityAnimation$p(r13)     // Catch: java.lang.Throwable -> L20
            r1 = 0
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)     // Catch: java.lang.Throwable -> L20
            r5 = r12
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Throwable -> L20
            r12.label = r4     // Catch: java.lang.Throwable -> L20
            java.lang.Object r13 = r13.snapTo(r1, r5)     // Catch: java.lang.Throwable -> L20
            if (r13 != r0) goto L41
            goto L6c
        L41:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r13 = r12.this$0     // Catch: java.lang.Throwable -> L20
            androidx.compose.animation.core.Animatable r4 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.access$getVisibilityAnimation$p(r13)     // Catch: java.lang.Throwable -> L20
            r13 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)     // Catch: java.lang.Throwable -> L20
            androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r13 = r12.$spec     // Catch: java.lang.Throwable -> L20
            r6 = r13
            androidx.compose.animation.core.AnimationSpec r6 = (androidx.compose.animation.core.AnimationSpec) r6     // Catch: java.lang.Throwable -> L20
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2$1 r13 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2$1     // Catch: java.lang.Throwable -> L20
            androidx.compose.ui.graphics.layer.GraphicsLayer r1 = r12.$layer     // Catch: java.lang.Throwable -> L20
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r7 = r12.this$0     // Catch: java.lang.Throwable -> L20
            r13.<init>()     // Catch: java.lang.Throwable -> L20
            r8 = r13
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8     // Catch: java.lang.Throwable -> L20
            r9 = r12
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch: java.lang.Throwable -> L20
            r12.label = r3     // Catch: java.lang.Throwable -> L20
            r7 = 0
            r10 = 4
            r11 = 0
            java.lang.Object r13 = androidx.compose.animation.core.Animatable.animateTo$default(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L20
            if (r13 != r0) goto L6d
        L6c:
            return r0
        L6d:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r12 = r12.this$0
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.access$setAppearanceAnimationInProgress(r12, r2)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L75:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r12 = r12.this$0
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.access$setAppearanceAnimationInProgress(r12, r2)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
