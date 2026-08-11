package androidx.compose.foundation.gestures;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.Channel;

/* compiled from: Transformable.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0007\u001a\u001a\u0010\b\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0007\u001a<\u0010\t\u001a\u00020\n*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u0011H\u0082@¢\u0006\u0002\u0010\u0012\u001a(\u0010\u0013\u001a\u00020\n*\u00020\u00142\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0015\u001a:\u0010\u0016\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u00112\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f\u001a&\u0010\u0016\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"SCROLL_FACTOR", "", "awaitCtrlMouseScrollOrNull", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "scrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstCtrlMouseScroll", "detectZoom", "", "panZoomLock", "", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "canPan", "Lkotlin/Function1;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectZoomByCtrlMouseScroll", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlinx/coroutines/channels/Channel;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "enabled", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TransformableKt {
    public static final float SCROLL_FACTOR = 545.0f;

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, boolean z, boolean z2) {
        return transformable(modifier, transformableState, new Function1<Offset, Boolean>() { // from class: androidx.compose.foundation.gestures.TransformableKt$transformable$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Offset offset) {
                return m852invokek4lQ0M(offset.m4135unboximpl());
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final Boolean m852invokek4lQ0M(long j) {
                return true;
            }
        }, z, z2);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, Function1 function1, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, function1, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, Function1<? super Offset, Boolean> function1, boolean z, boolean z2) {
        return modifier.then(new TransformableElement(transformableState, function1, z, z2));
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0052 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x004b -> B:10:0x004e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object awaitFirstCtrlMouseScroll(androidx.compose.ui.input.pointer.AwaitPointerEventScope r5, androidx.compose.foundation.gestures.ScrollConfig r6, kotlin.coroutines.Continuation<? super androidx.compose.ui.geometry.Offset> r7) {
        /*
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1 r0 = (androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1 r0 = new androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.L$1
            androidx.compose.foundation.gestures.ScrollConfig r5 = (androidx.compose.foundation.gestures.ScrollConfig) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
            kotlin.ResultKt.throwOnFailure(r7)
            r4 = r6
            r6 = r5
            r5 = r4
            goto L4e
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            kotlin.ResultKt.throwOnFailure(r7)
        L41:
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = awaitCtrlMouseScrollOrNull(r5, r6, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            androidx.compose.ui.geometry.Offset r7 = (androidx.compose.ui.geometry.Offset) r7
            if (r7 == 0) goto L41
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.awaitFirstCtrlMouseScroll(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.gestures.ScrollConfig, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object awaitCtrlMouseScrollOrNull(androidx.compose.ui.input.pointer.AwaitPointerEventScope r5, androidx.compose.foundation.gestures.ScrollConfig r6, kotlin.coroutines.Continuation<? super androidx.compose.ui.geometry.Offset> r7) {
        /*
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.TransformableKt$awaitCtrlMouseScrollOrNull$1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.foundation.gestures.TransformableKt$awaitCtrlMouseScrollOrNull$1 r0 = (androidx.compose.foundation.gestures.TransformableKt$awaitCtrlMouseScrollOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.foundation.gestures.TransformableKt$awaitCtrlMouseScrollOrNull$1 r0 = new androidx.compose.foundation.gestures.TransformableKt$awaitCtrlMouseScrollOrNull$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 != r4) goto L34
            java.lang.Object r5 = r0.L$1
            r6 = r5
            androidx.compose.foundation.gestures.ScrollConfig r6 = (androidx.compose.foundation.gestures.ScrollConfig) r6
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4d
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r5, r3, r0, r4, r3)
            if (r7 != r1) goto L4d
            return r1
        L4d:
            androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
            int r0 = r7.getKeyboardModifiers()
            boolean r0 = androidx.compose.ui.input.pointer.PointerEvent_androidKt.m5574isCtrlPressed5xRPYO0(r0)
            if (r0 == 0) goto La1
            int r0 = r7.getType()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r1 = androidx.compose.ui.input.pointer.PointerEventType.INSTANCE
            int r1 = r1.m5565getScroll7fucELk()
            boolean r0 = androidx.compose.ui.input.pointer.PointerEventType.m5556equalsimpl0(r0, r1)
            if (r0 != 0) goto L6a
            goto La1
        L6a:
            r0 = r5
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            long r1 = r5.mo5516getSizeYbymL2g()
            long r5 = r6.mo722calculateMouseWheelScroll8xgXZGE(r0, r7, r1)
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r0 = r0.m4141getZeroF1C5BW0()
            boolean r0 = androidx.compose.ui.geometry.Offset.m4122equalsimpl0(r5, r0)
            if (r0 == 0) goto L82
            return r3
        L82:
            java.util.List r7 = r7.getChanges()
            r0 = r7
            java.util.Collection r0 = (java.util.Collection) r0
            int r0 = r0.size()
            r1 = 0
        L8e:
            if (r1 >= r0) goto L9c
            java.lang.Object r2 = r7.get(r1)
            androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
            r2.consume()
            int r1 = r1 + 1
            goto L8e
        L9c:
            androidx.compose.ui.geometry.Offset r5 = androidx.compose.ui.geometry.Offset.m4114boximpl(r5)
            return r5
        La1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.awaitCtrlMouseScrollOrNull(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.gestures.ScrollConfig, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x02c5, code lost:
    
        if (r6 != 0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x02c7, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x020d, code lost:
    
        if (r13.invoke(androidx.compose.ui.geometry.Offset.m4114boximpl(r8)).booleanValue() != false) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x014b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02cc A[EDGE_INSN: B:96:0x02cc->B:95:0x02cc BREAK  A[LOOP:0: B:13:0x02b7->B:16:0x02c9], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x0297 -> B:12:0x02a6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope r28, boolean r29, kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r30, kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Offset, java.lang.Boolean> r31, kotlin.coroutines.Continuation<? super kotlin.Unit> r32) {
        /*
            Method dump skipped, instructions count: 764
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, kotlinx.coroutines.channels.Channel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object detectZoomByCtrlMouseScroll(PointerInputScope pointerInputScope, Channel<TransformEvent> channel, ScrollConfig scrollConfig, Continuation<? super Unit> continuation) {
        Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new TransformableKt$detectZoomByCtrlMouseScroll$2(continuation.getContext(), scrollConfig, channel, null), continuation);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }
}
