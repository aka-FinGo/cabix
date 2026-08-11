package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NestedScrollNode.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J#\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0096@ø\u0001\u0000¢\u0006\u0004\b%\u0010&J*\u0010'\u001a\u00020(2\u0006\u0010#\u001a\u00020(2\u0006\u0010$\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001b\u0010-\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0096@ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\"\u00100\u001a\u00020(2\u0006\u0010$\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\b1\u00102J\b\u00103\u001a\u00020\u001fH\u0002J\u0012\u00104\u001a\u00020\u001f2\b\u00105\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u00106\u001a\u00020\u001fH\u0002J\u001f\u00107\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b8R\u001a\u0010\u0004\u001a\u00020\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\tR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000eR\u000e\u0010\u0019\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/ui/Modifier$Node;", "connection", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "lastKnownParentNode", "getLastKnownParentNode$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "setLastKnownParentNode$ui_release", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;)V", "nestedCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getNestedCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "parentConnection", "getParentConnection", "parentNestedScrollNode", "getParentNestedScrollNode$ui_release", "resolvedDispatcher", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "onAttach", "", "onDetach", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", FirebaseAnalytics.Param.SOURCE, "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "resetDispatcherFields", "updateDispatcher", "newDispatcher", "updateDispatcherFields", "updateNode", "updateNode$ui_release", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class NestedScrollNode extends Modifier.Node implements TraversableNode, NestedScrollConnection {
    public static final int $stable = 8;
    private NestedScrollConnection connection;
    private NestedScrollNode lastKnownParentNode;
    private NestedScrollDispatcher resolvedDispatcher;
    private final Object traverseKey;

    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    public final void setConnection(NestedScrollConnection nestedScrollConnection) {
        this.connection = nestedScrollConnection;
    }

    public NestedScrollNode(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        this.connection = nestedScrollConnection;
        this.resolvedDispatcher = nestedScrollDispatcher == null ? new NestedScrollDispatcher() : nestedScrollDispatcher;
        this.traverseKey = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    /* renamed from: getLastKnownParentNode$ui_release, reason: from getter */
    public final NestedScrollNode getLastKnownParentNode() {
        return this.lastKnownParentNode;
    }

    public final void setLastKnownParentNode$ui_release(NestedScrollNode nestedScrollNode) {
        this.lastKnownParentNode = nestedScrollNode;
    }

    public final NestedScrollNode getParentNestedScrollNode$ui_release() {
        if (getIsAttached()) {
            return (NestedScrollNode) TraversableNodeKt.findNearestAncestor(this);
        }
        return null;
    }

    private final NestedScrollConnection getParentConnection() {
        if (getIsAttached()) {
            return getParentNestedScrollNode$ui_release();
        }
        return null;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope getNestedCoroutineScope() {
        CoroutineScope nestedCoroutineScope;
        NestedScrollNode parentNestedScrollNode$ui_release = getParentNestedScrollNode$ui_release();
        if (parentNestedScrollNode$ui_release != null && (nestedCoroutineScope = parentNestedScrollNode$ui_release.getNestedCoroutineScope()) != null) {
            return nestedCoroutineScope;
        }
        CoroutineScope scope = this.resolvedDispatcher.getScope();
        if (scope != null) {
            return scope;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo1127onPreScrollOzD1aCk(long available, int source) {
        NestedScrollConnection parentConnection = getParentConnection();
        long mo1127onPreScrollOzD1aCk = parentConnection != null ? parentConnection.mo1127onPreScrollOzD1aCk(available, source) : Offset.INSTANCE.m4141getZeroF1C5BW0();
        return Offset.m4130plusMKHz9U(mo1127onPreScrollOzD1aCk, this.connection.mo1127onPreScrollOzD1aCk(Offset.m4129minusMKHz9U(available, mo1127onPreScrollOzD1aCk), source));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo821onPostScrollDzOQY0M(long consumed, long available, int source) {
        long m4141getZeroF1C5BW0;
        long mo821onPostScrollDzOQY0M = this.connection.mo821onPostScrollDzOQY0M(consumed, available, source);
        NestedScrollConnection parentConnection = getParentConnection();
        if (parentConnection != null) {
            m4141getZeroF1C5BW0 = parentConnection.mo821onPostScrollDzOQY0M(Offset.m4130plusMKHz9U(consumed, mo821onPostScrollDzOQY0M), Offset.m4129minusMKHz9U(available, mo821onPostScrollDzOQY0M), source);
        } else {
            m4141getZeroF1C5BW0 = Offset.INSTANCE.m4141getZeroF1C5BW0();
        }
        return Offset.m4130plusMKHz9U(mo821onPostScrollDzOQY0M, m4141getZeroF1C5BW0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x007c, code lost:
    
        if (r11 == r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0057, code lost:
    
        if (r11 == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo1126onPreFlingQWom1Mo(long r9, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            if (r0 == 0) goto L14
            r0 = r11
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            r0.<init>(r8, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            long r8 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L7f
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            long r8 = r0.J$0
            java.lang.Object r10 = r0.L$0
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r10 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode) r10
            kotlin.ResultKt.throwOnFailure(r11)
            r6 = r8
            r8 = r10
            r9 = r6
            goto L5a
        L44:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r11 = r8.getParentConnection()
            if (r11 == 0) goto L61
            r0.L$0 = r8
            r0.J$0 = r9
            r0.label = r4
            java.lang.Object r11 = r11.mo1126onPreFlingQWom1Mo(r9, r0)
            if (r11 != r1) goto L5a
            goto L7e
        L5a:
            androidx.compose.ui.unit.Velocity r11 = (androidx.compose.ui.unit.Velocity) r11
            long r4 = r11.getPackedValue()
            goto L67
        L61:
            androidx.compose.ui.unit.Velocity$Companion r11 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r4 = r11.m7238getZero9UxMQ8M()
        L67:
            r6 = r9
            r10 = r8
            r8 = r4
            r4 = r6
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r10 = r10.connection
            long r4 = androidx.compose.ui.unit.Velocity.m7230minusAH228Gc(r4, r8)
            r11 = 0
            r0.L$0 = r11
            r0.J$0 = r8
            r0.label = r3
            java.lang.Object r11 = r10.mo1126onPreFlingQWom1Mo(r4, r0)
            if (r11 != r1) goto L7f
        L7e:
            return r1
        L7f:
            androidx.compose.ui.unit.Velocity r11 = (androidx.compose.ui.unit.Velocity) r11
            long r10 = r11.getPackedValue()
            long r8 = androidx.compose.ui.unit.Velocity.m7231plusAH228Gc(r8, r10)
            androidx.compose.ui.unit.Velocity r8 = androidx.compose.ui.unit.Velocity.m7218boximpl(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollNode.mo1126onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo820onPostFlingRZ2iAVY(long r12, long r14, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r16) {
        /*
            r11 = this;
            r0 = r16
            boolean r1 = r0 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1
            if (r1 == 0) goto L16
            r1 = r0
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1 r1 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L1b
        L16:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1 r1 = new androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1
            r1.<init>(r11, r0)
        L1b:
            r7 = r1
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r8 = 2
            r3 = 1
            if (r2 == 0) goto L4b
            if (r2 == r3) goto L3b
            if (r2 != r8) goto L33
            long r11 = r7.J$0
            kotlin.ResultKt.throwOnFailure(r0)
            goto L9c
        L33:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3b:
            long r11 = r7.J$1
            long r2 = r7.J$0
            java.lang.Object r13 = r7.L$0
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r13 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode) r13
            kotlin.ResultKt.throwOnFailure(r0)
            r9 = r11
            r11 = r13
            r12 = r2
            r2 = r9
            goto L62
        L4b:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r2 = r11.connection
            r7.L$0 = r11
            r7.J$0 = r12
            r7.J$1 = r14
            r7.label = r3
            r3 = r12
            r5 = r14
            java.lang.Object r0 = r2.mo820onPostFlingRZ2iAVY(r3, r5, r7)
            if (r0 != r1) goto L61
            goto L9a
        L61:
            r2 = r14
        L62:
            androidx.compose.ui.unit.Velocity r0 = (androidx.compose.ui.unit.Velocity) r0
            long r4 = r0.getPackedValue()
            boolean r0 = androidx.compose.ui.ComposeUiFlags.NewNestedScrollFlingDispatchingEnabled
            if (r0 == 0) goto L7c
            boolean r0 = r11.getIsAttached()
            if (r0 == 0) goto L77
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r11 = r11.getParentConnection()
            goto L80
        L77:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r11 = r11.lastKnownParentNode
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r11 = (androidx.compose.ui.input.nestedscroll.NestedScrollConnection) r11
            goto L80
        L7c:
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r11 = r11.getParentConnection()
        L80:
            if (r11 == 0) goto La4
            long r12 = androidx.compose.ui.unit.Velocity.m7231plusAH228Gc(r12, r4)
            long r2 = androidx.compose.ui.unit.Velocity.m7230minusAH228Gc(r2, r4)
            r0 = 0
            r7.L$0 = r0
            r7.J$0 = r4
            r7.label = r8
            r14 = r2
            r16 = r7
            java.lang.Object r0 = r11.mo820onPostFlingRZ2iAVY(r12, r14, r16)
            if (r0 != r1) goto L9b
        L9a:
            return r1
        L9b:
            r11 = r4
        L9c:
            androidx.compose.ui.unit.Velocity r0 = (androidx.compose.ui.unit.Velocity) r0
            long r0 = r0.getPackedValue()
            r4 = r11
            goto Laa
        La4:
            androidx.compose.ui.unit.Velocity$Companion r11 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r0 = r11.m7238getZero9UxMQ8M()
        Laa:
            long r11 = androidx.compose.ui.unit.Velocity.m7231plusAH228Gc(r4, r0)
            androidx.compose.ui.unit.Velocity r11 = androidx.compose.ui.unit.Velocity.m7218boximpl(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollNode.mo820onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void updateDispatcher(NestedScrollDispatcher newDispatcher) {
        resetDispatcherFields();
        if (newDispatcher == null) {
            this.resolvedDispatcher = new NestedScrollDispatcher();
        } else if (!Intrinsics.areEqual(newDispatcher, this.resolvedDispatcher)) {
            this.resolvedDispatcher = newDispatcher;
        }
        if (getIsAttached()) {
            updateDispatcherFields();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDispatcherFields();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        if (ComposeUiFlags.NewNestedScrollFlingDispatchingEnabled) {
            NestedScrollNode nestedScrollNode = (NestedScrollNode) NestedScrollNodeKt.access$findNearestAttachedAncestor(this);
            this.lastKnownParentNode = nestedScrollNode;
            this.resolvedDispatcher.setLastKnownParentNode$ui_release(nestedScrollNode);
        }
        resetDispatcherFields();
    }

    private final void updateDispatcherFields() {
        this.resolvedDispatcher.setNestedScrollNode$ui_release(this);
        if (ComposeUiFlags.NewNestedScrollFlingDispatchingEnabled) {
            this.resolvedDispatcher.setLastKnownParentNode$ui_release(null);
            this.lastKnownParentNode = null;
        }
        this.resolvedDispatcher.setCalculateNestedScrollScope$ui_release(new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollNode$updateDispatcherFields$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                CoroutineScope nestedCoroutineScope;
                nestedCoroutineScope = NestedScrollNode.this.getNestedCoroutineScope();
                return nestedCoroutineScope;
            }
        });
        this.resolvedDispatcher.setScope$ui_release(getCoroutineScope());
    }

    private final void resetDispatcherFields() {
        if (this.resolvedDispatcher.getNestedScrollNode() == this) {
            this.resolvedDispatcher.setNestedScrollNode$ui_release(null);
        }
    }

    public final void updateNode$ui_release(NestedScrollConnection connection, NestedScrollDispatcher dispatcher) {
        this.connection = connection;
        updateDispatcher(dispatcher);
    }
}
