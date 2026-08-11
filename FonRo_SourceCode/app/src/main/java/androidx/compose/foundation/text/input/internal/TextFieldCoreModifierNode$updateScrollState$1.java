package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.geometry.Rect;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldCoreModifier.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$updateScrollState$1", f = "TextFieldCoreModifier.kt", i = {}, l = {447, 450}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class TextFieldCoreModifierNode$updateScrollState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $offsetDifference;
    final /* synthetic */ Rect $rawCursorRect;
    int label;
    final /* synthetic */ TextFieldCoreModifierNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldCoreModifierNode$updateScrollState$1(TextFieldCoreModifierNode textFieldCoreModifierNode, float f, Rect rect, Continuation<? super TextFieldCoreModifierNode$updateScrollState$1> continuation) {
        super(2, continuation);
        this.this$0 = textFieldCoreModifierNode;
        this.$offsetDifference = f;
        this.$rawCursorRect = rect;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TextFieldCoreModifierNode$updateScrollState$1(this.this$0, this.$offsetDifference, this.$rawCursorRect, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TextFieldCoreModifierNode$updateScrollState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0051, code lost:
    
        if (r6.getBringIntoViewRequester().bringIntoView(r5.$rawCursorRect, r5) == r0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        if (androidx.compose.foundation.gestures.ScrollExtensionsKt.scrollBy(r6, r1, r5) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r6)
            goto L54
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L1b:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L3c
        L1f:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode r6 = r5.this$0
            androidx.compose.foundation.ScrollState r6 = androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode.access$getScrollState$p(r6)
            androidx.compose.foundation.gestures.ScrollableState r6 = (androidx.compose.foundation.gestures.ScrollableState) r6
            float r1 = r5.$offsetDifference
            float r1 = androidx.compose.foundation.text.input.internal.TextFieldCoreModifierKt.access$roundToNext(r1)
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.label = r3
            java.lang.Object r6 = androidx.compose.foundation.gestures.ScrollExtensionsKt.scrollBy(r6, r1, r4)
            if (r6 != r0) goto L3c
            goto L53
        L3c:
            androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode r6 = r5.this$0
            androidx.compose.foundation.text.input.internal.TextLayoutState r6 = androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode.access$getTextLayoutState$p(r6)
            androidx.compose.foundation.relocation.BringIntoViewRequester r6 = r6.getBringIntoViewRequester()
            androidx.compose.ui.geometry.Rect r1 = r5.$rawCursorRect
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r5.label = r2
            java.lang.Object r5 = r6.bringIntoView(r1, r3)
            if (r5 != r0) goto L54
        L53:
            return r0
        L54:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$updateScrollState$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
