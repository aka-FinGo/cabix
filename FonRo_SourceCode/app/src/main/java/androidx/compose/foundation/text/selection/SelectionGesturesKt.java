package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: SelectionGestures.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u001a\u0012\u0010\f\u001a\u00020\u0004*\u00020\rH\u0082@¢\u0006\u0002\u0010\u000e\u001a*\u0010\u000f\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0016\u001a*\u0010\u0017\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0016\u001a\u001c\u0010\u0018\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0000\u001a\"\u0010\u001d\u001a\u00020\u0010*\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0080@¢\u0006\u0002\u0010\u001f\u001a\"\u0010 \u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010!\u001a\"\u0010\"\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010!\u001a\"\u0010$\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010!\u001a \u0010%\u001a\u00020\u0019*\u00020\u00192\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100'H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006("}, d2 = {"STATIC_KEY", "", "isPrecisePointer", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "distanceIsTolerable", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "change1", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "change2", "awaitDown", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelection", "", "observer", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "clicksCounter", "Landroidx/compose/foundation/text/selection/ClicksCounter;", "down", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/selection/ClicksCounter;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelectionBtf2", "selectionGestureInput", "Landroidx/compose/ui/Modifier;", "mouseSelectionObserver", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "selectionGesturePointerInputBtf2", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelection", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelectionFirstPress", "downEvent", "touchSelectionSubsequentPress", "updateSelectionTouchMode", "updateTouchMode", "Lkotlin/Function1;", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SelectionGesturesKt {
    private static final int STATIC_KEY = 8675309;

    public static final Modifier updateSelectionTouchMode(Modifier modifier, final Function1<? super Boolean, Unit> function1) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, Integer.valueOf(STATIC_KEY), new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1

            /* compiled from: SelectionGestures.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1$1", f = "SelectionGestures.kt", i = {0}, l = {94}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
            /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1$1, reason: invalid class name */
            /* loaded from: classes.dex */
            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<Boolean, Unit> $updateTouchMode;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass1(Function1<? super Boolean, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$updateTouchMode = function1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$updateTouchMode, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0033 A[RETURN] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0031 -> B:5:0x0034). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                    /*
                        r4 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r4.label
                        r2 = 1
                        if (r1 == 0) goto L1c
                        if (r1 != r2) goto L13
                        java.lang.Object r1 = r4.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        kotlin.ResultKt.throwOnFailure(r5)
                        goto L34
                    L13:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L1c:
                        kotlin.ResultKt.throwOnFailure(r5)
                        java.lang.Object r5 = r4.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                        r1 = r5
                    L24:
                        androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r3 = r4
                        kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                        r4.L$0 = r1
                        r4.label = r2
                        java.lang.Object r5 = r1.awaitPointerEvent(r5, r3)
                        if (r5 != r0) goto L34
                        return r0
                    L34:
                        androidx.compose.ui.input.pointer.PointerEvent r5 = (androidx.compose.ui.input.pointer.PointerEvent) r5
                        kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r3 = r4.$updateTouchMode
                        boolean r5 = androidx.compose.foundation.text.selection.SelectionGesturesKt.isPrecisePointer(r5)
                        r5 = r5 ^ r2
                        java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                        r3.invoke(r5)
                        goto L24
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new AnonymousClass1(function1, null), continuation);
                return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
            }
        });
    }

    public static final Modifier selectionGestureInput(Modifier modifier, final MouseSelectionObserver mouseSelectionObserver, final TextDragObserver textDragObserver) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, mouseSelectionObserver, textDragObserver, new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1

            /* compiled from: SelectionGestures.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1$1", f = "SelectionGestures.kt", i = {0}, l = {107, 113, 115}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
            /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1$1, reason: invalid class name */
            /* loaded from: classes.dex */
            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ ClicksCounter $clicksCounter;
                final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
                final /* synthetic */ TextDragObserver $textDragObserver;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(MouseSelectionObserver mouseSelectionObserver, ClicksCounter clicksCounter, TextDragObserver textDragObserver, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$mouseSelectionObserver = mouseSelectionObserver;
                    this.$clicksCounter = clicksCounter;
                    this.$textDragObserver = textDragObserver;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$mouseSelectionObserver, this.$clicksCounter, this.$textDragObserver, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
                
                    if (r9 == r0) goto L32;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:26:0x0096, code lost:
                
                    return r0;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:30:0x0094, code lost:
                
                    if (r9 == r0) goto L32;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:32:0x003b, code lost:
                
                    if (r10 == r0) goto L32;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                    /*
                        r9 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r9.label
                        r2 = 3
                        r3 = 2
                        r4 = 1
                        if (r1 == 0) goto L28
                        if (r1 == r4) goto L20
                        if (r1 == r3) goto L1b
                        if (r1 != r2) goto L12
                        goto L1b
                    L12:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r10)
                        throw r9
                    L1b:
                        kotlin.ResultKt.throwOnFailure(r10)
                        goto L97
                    L20:
                        java.lang.Object r1 = r9.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        kotlin.ResultKt.throwOnFailure(r10)
                        goto L3e
                    L28:
                        kotlin.ResultKt.throwOnFailure(r10)
                        java.lang.Object r10 = r9.L$0
                        r1 = r10
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        r10 = r9
                        kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                        r9.L$0 = r1
                        r9.label = r4
                        java.lang.Object r10 = androidx.compose.foundation.text.selection.SelectionGesturesKt.access$awaitDown(r1, r10)
                        if (r10 != r0) goto L3e
                        goto L96
                    L3e:
                        androidx.compose.ui.input.pointer.PointerEvent r10 = (androidx.compose.ui.input.pointer.PointerEvent) r10
                        boolean r4 = androidx.compose.foundation.text.selection.SelectionGesturesKt.isPrecisePointer(r10)
                        r5 = 0
                        if (r4 == 0) goto L81
                        int r4 = r10.getButtons()
                        boolean r4 = androidx.compose.ui.input.pointer.PointerEvent_androidKt.m5580isPrimaryPressedaHzCxE(r4)
                        if (r4 == 0) goto L81
                        java.util.List r4 = r10.getChanges()
                        r6 = r4
                        java.util.Collection r6 = (java.util.Collection) r6
                        int r6 = r6.size()
                        r7 = 0
                    L5d:
                        if (r7 >= r6) goto L6f
                        java.lang.Object r8 = r4.get(r7)
                        androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
                        boolean r8 = r8.isConsumed()
                        if (r8 == 0) goto L6c
                        goto L81
                    L6c:
                        int r7 = r7 + 1
                        goto L5d
                    L6f:
                        androidx.compose.foundation.text.selection.MouseSelectionObserver r2 = r9.$mouseSelectionObserver
                        androidx.compose.foundation.text.selection.ClicksCounter r4 = r9.$clicksCounter
                        r6 = r9
                        kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                        r9.L$0 = r5
                        r9.label = r3
                        java.lang.Object r9 = androidx.compose.foundation.text.selection.SelectionGesturesKt.access$mouseSelection(r1, r2, r4, r10, r6)
                        if (r9 != r0) goto L97
                        goto L96
                    L81:
                        boolean r3 = androidx.compose.foundation.text.selection.SelectionGesturesKt.isPrecisePointer(r10)
                        if (r3 != 0) goto L97
                        androidx.compose.foundation.text.TextDragObserver r3 = r9.$textDragObserver
                        r4 = r9
                        kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                        r9.L$0 = r5
                        r9.label = r2
                        java.lang.Object r9 = androidx.compose.foundation.text.selection.SelectionGesturesKt.access$touchSelection(r1, r3, r10, r4)
                        if (r9 != r0) goto L97
                    L96:
                        return r0
                    L97:
                        kotlin.Unit r9 = kotlin.Unit.INSTANCE
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass1(MouseSelectionObserver.this, new ClicksCounter(pointerInputScope.getViewConfiguration()), textDragObserver, null), continuation);
                return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009f, code lost:
    
        if (r11 != r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object touchSelection(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, final androidx.compose.foundation.text.TextDragObserver r9, androidx.compose.ui.input.pointer.PointerEvent r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1
            if (r0 == 0) goto L14
            r0 = r11
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1 r0 = (androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1 r0 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L52
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L36
            java.lang.Object r8 = r0.L$1
            r9 = r8
            androidx.compose.foundation.text.TextDragObserver r9 = (androidx.compose.foundation.text.TextDragObserver) r9
            java.lang.Object r8 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.util.concurrent.CancellationException -> Ld8
            goto La2
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            java.lang.Object r8 = r0.L$2
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            java.lang.Object r9 = r0.L$1
            androidx.compose.foundation.text.TextDragObserver r9 = (androidx.compose.foundation.text.TextDragObserver) r9
            java.lang.Object r10 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.util.concurrent.CancellationException -> Ld8
            r7 = r10
            r10 = r8
            r8 = r7
            goto L72
        L52:
            kotlin.ResultKt.throwOnFailure(r11)
            java.util.List r10 = r10.getChanges()     // Catch: java.util.concurrent.CancellationException -> Ld8
            java.lang.Object r10 = kotlin.collections.CollectionsKt.first(r10)     // Catch: java.util.concurrent.CancellationException -> Ld8
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10     // Catch: java.util.concurrent.CancellationException -> Ld8
            long r5 = r10.getId()     // Catch: java.util.concurrent.CancellationException -> Ld8
            r0.L$0 = r8     // Catch: java.util.concurrent.CancellationException -> Ld8
            r0.L$1 = r9     // Catch: java.util.concurrent.CancellationException -> Ld8
            r0.L$2 = r10     // Catch: java.util.concurrent.CancellationException -> Ld8
            r0.label = r4     // Catch: java.util.concurrent.CancellationException -> Ld8
            java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m746awaitLongPressOrCancellationrnUCldI(r8, r5, r0)     // Catch: java.util.concurrent.CancellationException -> Ld8
            if (r11 != r1) goto L72
            goto La1
        L72:
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11     // Catch: java.util.concurrent.CancellationException -> Ld8
            if (r11 == 0) goto Ld5
            androidx.compose.ui.platform.ViewConfiguration r2 = r8.getViewConfiguration()     // Catch: java.util.concurrent.CancellationException -> Ld8
            boolean r10 = distanceIsTolerable(r2, r10, r11)     // Catch: java.util.concurrent.CancellationException -> Ld8
            if (r10 == 0) goto Ld5
            long r4 = r11.getPosition()     // Catch: java.util.concurrent.CancellationException -> Ld8
            r9.mo1457onStartk4lQ0M(r4)     // Catch: java.util.concurrent.CancellationException -> Ld8
            long r10 = r11.getId()     // Catch: java.util.concurrent.CancellationException -> Ld8
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$2 r2 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$2     // Catch: java.util.concurrent.CancellationException -> Ld8
            r2.<init>()     // Catch: java.util.concurrent.CancellationException -> Ld8
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch: java.util.concurrent.CancellationException -> Ld8
            r0.L$0 = r8     // Catch: java.util.concurrent.CancellationException -> Ld8
            r0.L$1 = r9     // Catch: java.util.concurrent.CancellationException -> Ld8
            r4 = 0
            r0.L$2 = r4     // Catch: java.util.concurrent.CancellationException -> Ld8
            r0.label = r3     // Catch: java.util.concurrent.CancellationException -> Ld8
            java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m756dragjO51t88(r8, r10, r2, r0)     // Catch: java.util.concurrent.CancellationException -> Ld8
            if (r11 != r1) goto La2
        La1:
            return r1
        La2:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.util.concurrent.CancellationException -> Ld8
            boolean r10 = r11.booleanValue()     // Catch: java.util.concurrent.CancellationException -> Ld8
            if (r10 == 0) goto Ld2
            androidx.compose.ui.input.pointer.PointerEvent r8 = r8.getCurrentEvent()     // Catch: java.util.concurrent.CancellationException -> Ld8
            java.util.List r8 = r8.getChanges()     // Catch: java.util.concurrent.CancellationException -> Ld8
            r10 = r8
            java.util.Collection r10 = (java.util.Collection) r10     // Catch: java.util.concurrent.CancellationException -> Ld8
            int r10 = r10.size()     // Catch: java.util.concurrent.CancellationException -> Ld8
            r11 = 0
        Lba:
            if (r11 >= r10) goto Lce
            java.lang.Object r0 = r8.get(r11)     // Catch: java.util.concurrent.CancellationException -> Ld8
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0     // Catch: java.util.concurrent.CancellationException -> Ld8
            boolean r1 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r0)     // Catch: java.util.concurrent.CancellationException -> Ld8
            if (r1 == 0) goto Lcb
            r0.consume()     // Catch: java.util.concurrent.CancellationException -> Ld8
        Lcb:
            int r11 = r11 + 1
            goto Lba
        Lce:
            r9.onStop()     // Catch: java.util.concurrent.CancellationException -> Ld8
            goto Ld5
        Ld2:
            r9.onCancel()     // Catch: java.util.concurrent.CancellationException -> Ld8
        Ld5:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        Ld8:
            r8 = move-exception
            r9.onCancel()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelection(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.text.TextDragObserver, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0086, code lost:
    
        if (r12 == r1) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object mouseSelection(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, final androidx.compose.foundation.text.selection.MouseSelectionObserver r9, androidx.compose.foundation.text.selection.ClicksCounter r10, androidx.compose.ui.input.pointer.PointerEvent r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.mouseSelection(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.text.selection.MouseSelectionObserver, androidx.compose.foundation.text.selection.ClicksCounter, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object selectionGesturePointerInputBtf2(PointerInputScope pointerInputScope, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new SelectionGesturesKt$selectionGesturePointerInputBtf2$2(new ClicksCounter(pointerInputScope.getViewConfiguration()), mouseSelectionObserver, textDragObserver, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009f, code lost:
    
        if (r11 != r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object touchSelectionFirstPress(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, final androidx.compose.foundation.text.TextDragObserver r9, androidx.compose.ui.input.pointer.PointerEvent r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$1
            if (r0 == 0) goto L14
            r0 = r11
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$1 r0 = (androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$1 r0 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L52
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L36
            java.lang.Object r8 = r0.L$1
            r9 = r8
            androidx.compose.foundation.text.TextDragObserver r9 = (androidx.compose.foundation.text.TextDragObserver) r9
            java.lang.Object r8 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.util.concurrent.CancellationException -> Ld8
            goto La2
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            java.lang.Object r8 = r0.L$2
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            java.lang.Object r9 = r0.L$1
            androidx.compose.foundation.text.TextDragObserver r9 = (androidx.compose.foundation.text.TextDragObserver) r9
            java.lang.Object r10 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.util.concurrent.CancellationException -> Ld8
            r7 = r10
            r10 = r8
            r8 = r7
            goto L72
        L52:
            kotlin.ResultKt.throwOnFailure(r11)
            java.util.List r10 = r10.getChanges()     // Catch: java.util.concurrent.CancellationException -> Ld8
            java.lang.Object r10 = kotlin.collections.CollectionsKt.first(r10)     // Catch: java.util.concurrent.CancellationException -> Ld8
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10     // Catch: java.util.concurrent.CancellationException -> Ld8
            long r5 = r10.getId()     // Catch: java.util.concurrent.CancellationException -> Ld8
            r0.L$0 = r8     // Catch: java.util.concurrent.CancellationException -> Ld8
            r0.L$1 = r9     // Catch: java.util.concurrent.CancellationException -> Ld8
            r0.L$2 = r10     // Catch: java.util.concurrent.CancellationException -> Ld8
            r0.label = r4     // Catch: java.util.concurrent.CancellationException -> Ld8
            java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m746awaitLongPressOrCancellationrnUCldI(r8, r5, r0)     // Catch: java.util.concurrent.CancellationException -> Ld8
            if (r11 != r1) goto L72
            goto La1
        L72:
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11     // Catch: java.util.concurrent.CancellationException -> Ld8
            if (r11 == 0) goto Ld5
            androidx.compose.ui.platform.ViewConfiguration r2 = r8.getViewConfiguration()     // Catch: java.util.concurrent.CancellationException -> Ld8
            boolean r10 = distanceIsTolerable(r2, r10, r11)     // Catch: java.util.concurrent.CancellationException -> Ld8
            if (r10 == 0) goto Ld5
            long r4 = r11.getPosition()     // Catch: java.util.concurrent.CancellationException -> Ld8
            r9.mo1457onStartk4lQ0M(r4)     // Catch: java.util.concurrent.CancellationException -> Ld8
            long r10 = r11.getId()     // Catch: java.util.concurrent.CancellationException -> Ld8
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$dragCompletedWithUp$1 r2 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$dragCompletedWithUp$1     // Catch: java.util.concurrent.CancellationException -> Ld8
            r2.<init>()     // Catch: java.util.concurrent.CancellationException -> Ld8
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch: java.util.concurrent.CancellationException -> Ld8
            r0.L$0 = r8     // Catch: java.util.concurrent.CancellationException -> Ld8
            r0.L$1 = r9     // Catch: java.util.concurrent.CancellationException -> Ld8
            r4 = 0
            r0.L$2 = r4     // Catch: java.util.concurrent.CancellationException -> Ld8
            r0.label = r3     // Catch: java.util.concurrent.CancellationException -> Ld8
            java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m756dragjO51t88(r8, r10, r2, r0)     // Catch: java.util.concurrent.CancellationException -> Ld8
            if (r11 != r1) goto La2
        La1:
            return r1
        La2:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.util.concurrent.CancellationException -> Ld8
            boolean r10 = r11.booleanValue()     // Catch: java.util.concurrent.CancellationException -> Ld8
            if (r10 == 0) goto Ld2
            androidx.compose.ui.input.pointer.PointerEvent r8 = r8.getCurrentEvent()     // Catch: java.util.concurrent.CancellationException -> Ld8
            java.util.List r8 = r8.getChanges()     // Catch: java.util.concurrent.CancellationException -> Ld8
            r10 = r8
            java.util.Collection r10 = (java.util.Collection) r10     // Catch: java.util.concurrent.CancellationException -> Ld8
            int r10 = r10.size()     // Catch: java.util.concurrent.CancellationException -> Ld8
            r11 = 0
        Lba:
            if (r11 >= r10) goto Lce
            java.lang.Object r0 = r8.get(r11)     // Catch: java.util.concurrent.CancellationException -> Ld8
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0     // Catch: java.util.concurrent.CancellationException -> Ld8
            boolean r1 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r0)     // Catch: java.util.concurrent.CancellationException -> Ld8
            if (r1 == 0) goto Lcb
            r0.consume()     // Catch: java.util.concurrent.CancellationException -> Ld8
        Lcb:
            int r11 = r11 + 1
            goto Lba
        Lce:
            r9.onStop()     // Catch: java.util.concurrent.CancellationException -> Ld8
            goto Ld5
        Ld2:
            r9.onCancel()     // Catch: java.util.concurrent.CancellationException -> Ld8
        Ld5:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        Ld8:
            r8 = move-exception
            r9.onCancel()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelectionFirstPress(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.text.TextDragObserver, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00df, code lost:
    
        if (r15 == r1) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7 A[Catch: CancellationException -> 0x0118, TryCatch #1 {CancellationException -> 0x0118, blocks: (B:12:0x0033, B:13:0x00e2, B:15:0x00ea, B:17:0x00fc, B:19:0x0108, B:21:0x010b, B:24:0x010e, B:28:0x0112, B:35:0x00a3, B:37:0x00a7, B:38:0x00a9, B:40:0x00ad, B:42:0x00b0, B:44:0x00bb, B:46:0x00c1, B:48:0x00c5, B:49:0x00ca, B:58:0x0065), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ad A[Catch: CancellationException -> 0x0118, TryCatch #1 {CancellationException -> 0x0118, blocks: (B:12:0x0033, B:13:0x00e2, B:15:0x00ea, B:17:0x00fc, B:19:0x0108, B:21:0x010b, B:24:0x010e, B:28:0x0112, B:35:0x00a3, B:37:0x00a7, B:38:0x00a9, B:40:0x00ad, B:42:0x00b0, B:44:0x00bb, B:46:0x00c1, B:48:0x00c5, B:49:0x00ca, B:58:0x0065), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b0 A[Catch: CancellationException -> 0x0118, TryCatch #1 {CancellationException -> 0x0118, blocks: (B:12:0x0033, B:13:0x00e2, B:15:0x00ea, B:17:0x00fc, B:19:0x0108, B:21:0x010b, B:24:0x010e, B:28:0x0112, B:35:0x00a3, B:37:0x00a7, B:38:0x00a9, B:40:0x00ad, B:42:0x00b0, B:44:0x00bb, B:46:0x00c1, B:48:0x00c5, B:49:0x00ca, B:58:0x0065), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object touchSelectionSubsequentPress(androidx.compose.ui.input.pointer.AwaitPointerEventScope r12, final androidx.compose.foundation.text.TextDragObserver r13, androidx.compose.ui.input.pointer.PointerEvent r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelectionSubsequentPress(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.text.TextDragObserver, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0137 A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:12:0x0036, B:13:0x011a, B:15:0x0122, B:17:0x0126, B:19:0x0137, B:21:0x0143, B:62:0x00e9), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0097 A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:34:0x0050, B:35:0x008f, B:37:0x0097, B:39:0x00a8, B:41:0x00b4, B:52:0x0073), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object mouseSelectionBtf2(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, final androidx.compose.foundation.text.selection.MouseSelectionObserver r9, androidx.compose.foundation.text.selection.ClicksCounter r10, androidx.compose.ui.input.pointer.PointerEvent r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.mouseSelectionBtf2(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.text.selection.MouseSelectionObserver, androidx.compose.foundation.text.selection.ClicksCounter, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0044 -> B:10:0x0047). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object awaitDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerEvent> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r0 = (androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r0 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2e
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L47
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
        L3a:
            androidx.compose.ui.input.pointer.PointerEventPass r8 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r7.awaitPointerEvent(r8, r0)
            if (r8 != r1) goto L47
            return r1
        L47:
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
            java.util.List r2 = r8.getChanges()
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            int r4 = r4.size()
            r5 = 0
        L55:
            if (r5 >= r4) goto L67
            java.lang.Object r6 = r2.get(r5)
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            boolean r6 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r6)
            if (r6 != 0) goto L64
            goto L3a
        L64:
            int r5 = r5 + 1
            goto L55
        L67:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.awaitDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean distanceIsTolerable(ViewConfiguration viewConfiguration, PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2) {
        return Offset.m4123getDistanceimpl(Offset.m4129minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange2.getPosition())) < DragGestureDetectorKt.m759pointerSlopE8SPZFQ(viewConfiguration, pointerInputChange.getType());
    }

    public static final boolean isPrecisePointer(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            if (!PointerType.m5678equalsimpl0(changes.get(i).getType(), PointerType.INSTANCE.m5683getMouseT8wyACA())) {
                return false;
            }
        }
        return true;
    }
}
