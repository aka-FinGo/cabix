package androidx.compose.foundation.text.input.internal;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldCoreModifier.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1", f = "TextFieldCoreModifier.kt", i = {}, l = {558}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class TextFieldCoreModifierNode$startCursorJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TextFieldCoreModifierNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldCoreModifierNode$startCursorJob$1(TextFieldCoreModifierNode textFieldCoreModifierNode, Continuation<? super TextFieldCoreModifierNode$startCursorJob$1> continuation) {
        super(2, continuation);
        this.this$0 = textFieldCoreModifierNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TextFieldCoreModifierNode$startCursorJob$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TextFieldCoreModifierNode$startCursorJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 1;
            final TextFieldCoreModifierNode textFieldCoreModifierNode = this.this$0;
            this.label = 1;
            if (FlowKt.collectLatest(SnapshotStateKt.snapshotFlow(new Function0<Integer>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    TransformedTextFieldState transformedTextFieldState;
                    transformedTextFieldState = TextFieldCoreModifierNode.this.textFieldState;
                    transformedTextFieldState.getVisualText();
                    Integer valueOf = Integer.valueOf(((TextFieldCoreModifierNode.this.getIsAttached() && ((WindowInfo) CompositionLocalConsumerModifierNodeKt.currentValueOf(TextFieldCoreModifierNode.this, CompositionLocalsKt.getLocalWindowInfo())).isWindowFocused()) ? 1 : 2) * intRef.element);
                    Ref.IntRef intRef2 = intRef;
                    valueOf.intValue();
                    intRef2.element *= -1;
                    return valueOf;
                }
            }), new AnonymousClass2(this.this$0, null), this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TextFieldCoreModifier.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "isWindowFocused", ""}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1$2", f = "TextFieldCoreModifier.kt", i = {}, l = {560}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        /* synthetic */ int I$0;
        int label;
        final /* synthetic */ TextFieldCoreModifierNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TextFieldCoreModifierNode textFieldCoreModifierNode, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = textFieldCoreModifierNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
            anonymousClass2.I$0 = ((Number) obj).intValue();
            return anonymousClass2;
        }

        public final Object invoke(int i, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Unit> continuation) {
            return invoke(num.intValue(), continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
        
            r4 = r3.this$0.cursorAnimation;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L18
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r4)
                goto L37
            Lf:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r4)
                throw r3
            L18:
                kotlin.ResultKt.throwOnFailure(r4)
                int r4 = r3.I$0
                int r4 = java.lang.Math.abs(r4)
                if (r4 != r2) goto L37
                androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode r4 = r3.this$0
                androidx.compose.foundation.text.input.internal.CursorAnimationState r4 = androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode.access$getCursorAnimation$p(r4)
                if (r4 == 0) goto L37
                r1 = r3
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r3.label = r2
                java.lang.Object r3 = r4.snapToVisibleAndAnimate(r1)
                if (r3 != r0) goto L37
                return r0
            L37:
                kotlin.Unit r3 = kotlin.Unit.INSTANCE
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
