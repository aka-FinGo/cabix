package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1", f = "AnchoredDraggable.kt", i = {}, l = {434, 436}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class AnchoredDraggableNode$onDragStopped$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $velocity;
    int label;
    final /* synthetic */ AnchoredDraggableNode<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableNode$onDragStopped$1(AnchoredDraggableNode<T> anchoredDraggableNode, long j, Continuation<? super AnchoredDraggableNode$onDragStopped$1> continuation) {
        super(2, continuation);
        this.this$0 = anchoredDraggableNode;
        this.$velocity = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnchoredDraggableNode$onDragStopped$1(this.this$0, this.$velocity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnchoredDraggableNode$onDragStopped$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
    
        if (r7 == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0061, code lost:
    
        if (r1.mo536applyToFlingBMRW4eQ(r3, new androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1.AnonymousClass1(r7.this$0, null), r7) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1c
            if (r1 == r3) goto L18
            if (r1 != r2) goto Lf
            goto L18
        Lf:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L18:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L64
        L1c:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r8 = r7.this$0
            long r4 = r7.$velocity
            long r4 = androidx.compose.foundation.gestures.AnchoredDraggableNode.m706access$reverseIfNeededAH228Gc(r8, r4)
            float r8 = androidx.compose.foundation.gestures.AnchoredDraggableNode.m708access$toFloatTH1AsA0(r8, r4)
            androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r1 = r7.this$0
            androidx.compose.foundation.OverscrollEffect r1 = androidx.compose.foundation.gestures.AnchoredDraggableNode.access$getOverscrollEffect$p(r1)
            androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r4 = r7.this$0
            if (r1 != 0) goto L41
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r7.label = r3
            java.lang.Object r7 = androidx.compose.foundation.gestures.AnchoredDraggableNode.access$fling(r4, r8, r1)
            if (r7 != r0) goto L64
            goto L63
        L41:
            androidx.compose.foundation.OverscrollEffect r1 = androidx.compose.foundation.gestures.AnchoredDraggableNode.access$getOverscrollEffect$p(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r3 = r7.this$0
            long r3 = androidx.compose.foundation.gestures.AnchoredDraggableNode.m711access$toVelocityadjELrA(r3, r8)
            androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1 r8 = new androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1
            androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r5 = r7.this$0
            r6 = 0
            r8.<init>(r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r7.label = r2
            java.lang.Object r7 = r1.mo536applyToFlingBMRW4eQ(r3, r8, r5)
            if (r7 != r0) goto L64
        L63:
            return r0
        L64:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", ExifInterface.GPS_DIRECTION_TRUE, "availableVelocity"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1", f = "AnchoredDraggable.kt", i = {0}, l = {438}, m = "invokeSuspend", n = {"availableVelocity"}, s = {"J$0"})
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
        /* synthetic */ long J$0;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AnchoredDraggableNode<T> anchoredDraggableNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = anchoredDraggableNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.J$0 = ((Velocity) obj).getPackedValue();
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
            return m721invokesFctU(velocity.getPackedValue(), continuation);
        }

        /* renamed from: invoke-sF-c-tU, reason: not valid java name */
        public final Object m721invokesFctU(long j, Continuation<? super Velocity> continuation) {
            return ((AnonymousClass1) create(Velocity.m7218boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            float m714toFloatTH1AsA0;
            long j;
            AnchoredDraggableState anchoredDraggableState;
            AnchoredDraggableState anchoredDraggableState2;
            AnchoredDraggableState anchoredDraggableState3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j2 = this.J$0;
                AnchoredDraggableNode<T> anchoredDraggableNode = this.this$0;
                m714toFloatTH1AsA0 = anchoredDraggableNode.m714toFloatTH1AsA0(j2);
                this.J$0 = j2;
                this.label = 1;
                obj = anchoredDraggableNode.fling(m714toFloatTH1AsA0, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j = j2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.J$0;
                ResultKt.throwOnFailure(obj);
            }
            float floatValue = ((Number) obj).floatValue();
            anchoredDraggableState = ((AnchoredDraggableNode) this.this$0).state;
            float requireOffset = anchoredDraggableState.requireOffset();
            anchoredDraggableState2 = ((AnchoredDraggableNode) this.this$0).state;
            float minPosition = anchoredDraggableState2.getAnchors().minPosition();
            anchoredDraggableState3 = ((AnchoredDraggableNode) this.this$0).state;
            if (requireOffset >= anchoredDraggableState3.getAnchors().maxPosition() || requireOffset <= minPosition) {
                j = this.this$0.m717toVelocityadjELrA(floatValue);
            }
            return Velocity.m7218boximpl(j);
        }
    }
}
