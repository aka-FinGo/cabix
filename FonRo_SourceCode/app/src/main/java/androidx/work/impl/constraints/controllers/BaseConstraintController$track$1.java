package androidx.work.impl.constraints.controllers;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: ContraintControllers.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/ProducerScope;", "Landroidx/work/impl/constraints/ConstraintsState;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.work.impl.constraints.controllers.BaseConstraintController$track$1", f = "ContraintControllers.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class BaseConstraintController$track$1 extends SuspendLambda implements Function2<ProducerScope<? super ConstraintsState>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseConstraintController<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseConstraintController$track$1(BaseConstraintController<T> baseConstraintController, Continuation<? super BaseConstraintController$track$1> continuation) {
        super(2, continuation);
        this.this$0 = baseConstraintController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BaseConstraintController$track$1 baseConstraintController$track$1 = new BaseConstraintController$track$1(this.this$0, continuation);
        baseConstraintController$track$1.L$0 = obj;
        return baseConstraintController$track$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super ConstraintsState> producerScope, Continuation<? super Unit> continuation) {
        return ((BaseConstraintController$track$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.work.impl.constraints.controllers.BaseConstraintController$track$1$listener$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ConstraintTracker constraintTracker;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final BaseConstraintController<T> baseConstraintController = this.this$0;
            final ?? r1 = new ConstraintListener<T>() { // from class: androidx.work.impl.constraints.controllers.BaseConstraintController$track$1$listener$1
                @Override // androidx.work.impl.constraints.ConstraintListener
                public void onConstraintChanged(T newValue) {
                    producerScope.getChannel().mo9440trySendJP2dKIU(baseConstraintController.isConstrained(newValue) ? new ConstraintsState.ConstraintsNotMet(baseConstraintController.getReason()) : ConstraintsState.ConstraintsMet.INSTANCE);
                }
            };
            constraintTracker = ((BaseConstraintController) this.this$0).tracker;
            constraintTracker.addListener((ConstraintListener) r1);
            final BaseConstraintController<T> baseConstraintController2 = this.this$0;
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() { // from class: androidx.work.impl.constraints.controllers.BaseConstraintController$track$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ConstraintTracker constraintTracker2;
                    constraintTracker2 = ((BaseConstraintController) baseConstraintController2).tracker;
                    constraintTracker2.removeListener(r1);
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
