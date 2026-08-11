package coil.compose;

import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import coil.size.Size;
import coil.size.SizeResolver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: ConstraintsSizeResolver.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ#\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcoil/compose/ConstraintsSizeResolver;", "Lcoil/size/SizeResolver;", "Landroidx/compose/ui/layout/LayoutModifier;", "<init>", "()V", "currentConstraints", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/ui/unit/Constraints;", "size", "Lcoil/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "setConstraints", "", "setConstraints-BRTryo0", "(J)V", "coil-compose-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class ConstraintsSizeResolver implements SizeResolver, LayoutModifier {
    public static final int $stable = 0;
    private final MutableStateFlow<Constraints> currentConstraints = StateFlowKt.MutableStateFlow(Constraints.m6929boximpl(UtilsKt.getZeroConstraints()));

    @Override // coil.size.SizeResolver
    public Object size(Continuation<? super Size> continuation) {
        final MutableStateFlow<Constraints> mutableStateFlow = this.currentConstraints;
        return FlowKt.first(new Flow<Size>() { // from class: coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* renamed from: coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(c = "coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2", f = "ConstraintsSizeResolver.kt", i = {}, l = {221}, m = "emit", n = {}, s = {})
                /* renamed from: coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2$1 r0 = (coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 - r2
                        r0.label = r6
                        goto L19
                    L14:
                        coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2$1 r0 = new coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4f
                    L2a:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                        r6 = r0
                        kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                        androidx.compose.ui.unit.Constraints r5 = (androidx.compose.ui.unit.Constraints) r5
                        long r5 = r5.getValue()
                        coil.size.Size r5 = coil.compose.UtilsKt.m7659toSizeOrNullBRTryo0(r5)
                        if (r5 == 0) goto L4f
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L4f
                        return r1
                    L4f:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Size> flowCollector, Continuation continuation2) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation2);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, continuation);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo969measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        this.currentConstraints.setValue(Constraints.m6929boximpl(j));
        final Placeable mo5732measureBRTryo0 = measurable.mo5732measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, mo5732measureBRTryo0.getWidth(), mo5732measureBRTryo0.getHeight(), null, new Function1() { // from class: coil.compose.ConstraintsSizeResolver$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ConstraintsSizeResolver.measure_3p2s80s$lambda$0(Placeable.this, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* renamed from: setConstraints-BRTryo0, reason: not valid java name */
    public final void m7624setConstraintsBRTryo0(long constraints) {
        this.currentConstraints.setValue(Constraints.m6929boximpl(constraints));
    }
}
