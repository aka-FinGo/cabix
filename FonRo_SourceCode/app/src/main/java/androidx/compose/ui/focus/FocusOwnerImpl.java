package androidx.compose.ui.focus;

import android.os.Trace;
import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Ref;

/* compiled from: FocusOwnerImpl.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001Bª\u0001\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012:\u0010\u0006\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007\u0012!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004¢\u0006\u0002\u0010\u0014J\u0010\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u000eH\u0016J\u001a\u00108\u001a\u00020\u000e2\b\b\u0002\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000eH\u0002J2\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u001a\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020AH\u0016ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ(\u0010D\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020A2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001e\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020J2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H\u0016J\n\u0010K\u001a\u0004\u0018\u00010\u0016H\u0002J:\u0010L\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010M\u001a\u0004\u0018\u00010\f2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\n\u0010Q\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010R\u001a\u00020\u0005H\u0002J\u001a\u0010S\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\b\u0010V\u001a\u00020\u0005H\u0016J$\u0010W\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016ø\u0001\u0000¢\u0006\u0002\bXJ\u0010\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020[H\u0016J\u0010\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\\H\u0016J\u0010\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u0016H\u0016J\b\u0010]\u001a\u00020\u0005H\u0016J$\u0010^\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016ø\u0001\u0000¢\u0006\u0004\b_\u0010`J\u001a\u0010a\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020AH\u0002ø\u0001\u0000¢\u0006\u0004\bb\u0010CJ\u000e\u0010c\u001a\u0004\u0018\u00010d*\u00020eH\u0002J3\u0010f\u001a\u0004\u0018\u0001Hg\"\n\b\u0000\u0010g\u0018\u0001*\u00020h*\u00020e2\f\u0010i\u001a\b\u0012\u0004\u0012\u0002Hg0jH\u0082\bø\u0001\u0000¢\u0006\u0004\bk\u0010lJg\u0010m\u001a\u00020\u0005\"\n\b\u0000\u0010g\u0018\u0001*\u00020e*\u00020e2\f\u0010i\u001a\b\u0012\u0004\u0012\u0002Hg0j2\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u0002Hg\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u0002Hg\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bø\u0001\u0000¢\u0006\u0004\bq\u0010rR(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R$\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0006\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR\u0014\u00104\u001a\u0002058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006s"}, d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "onRequestFocusForOwner", "Lkotlin/Function2;", "Landroidx/compose/ui/focus/FocusDirection;", "Lkotlin/ParameterName;", "name", "focusDirection", "Landroidx/compose/ui/geometry/Rect;", "previouslyFocusedRect", "", "onMoveFocusInterop", "onClearFocusForOwner", "onFocusRectInterop", "onLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "value", "Landroidx/compose/ui/focus/FocusTargetNode;", "activeFocusTargetNode", "getActiveFocusTargetNode", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setActiveFocusTargetNode", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "focusTransactionManager", "Landroidx/compose/ui/focus/FocusTransactionManager;", "getFocusTransactionManager", "()Landroidx/compose/ui/focus/FocusTransactionManager;", "isFocusCaptured", "()Z", "setFocusCaptured", "(Z)V", "keysCurrentlyDown", "Landroidx/collection/MutableLongSet;", "listeners", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/focus/FocusListener;", "getListeners", "()Landroidx/collection/MutableObjectList;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "rootFocusNode", "getRootFocusNode$ui_release", "setRootFocusNode$ui_release", "rootState", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "clearFocus", "force", "forced", "refreshFocusEvents", "clearOwnerFocus", "clearFocus-I7lrPNg", "(ZZZI)Z", "dispatchInterceptedSoftKeyboardEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchKeyEvent", "onFocusedItem", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchRotaryEvent", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "findFocusTargetNode", "focusSearch", "focusedRect", "onFound", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "getFocusRect", "invalidateOwnerFocusState", "moveFocus", "moveFocus-3ESFkO8", "(I)Z", "releaseFocus", "requestFocusForOwner", "requestFocusForOwner-7o62pno", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "scheduleInvalidationForOwner", "takeFocus", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "validateKeyEvent", "validateKeyEvent-ZmokQxo", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "nearestAncestorIncludingSelf", ExifInterface.GPS_DIRECTION_TRUE, "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Landroidx/compose/ui/node/NodeKind;", "nearestAncestorIncludingSelf-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "traverseAncestorsIncludingSelf", "onPreVisit", "onVisit", "onPostVisit", "traverseAncestorsIncludingSelf-QFhIj7k", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class FocusOwnerImpl implements FocusOwner {
    public static final int $stable = 8;
    private FocusTargetNode activeFocusTargetNode;
    private final FocusInvalidationManager focusInvalidationManager;
    private boolean isFocusCaptured;
    private MutableLongSet keysCurrentlyDown;
    private final Function0<Unit> onClearFocusForOwner;
    private final Function0<Rect> onFocusRectInterop;
    private final Function0<LayoutDirection> onLayoutDirection;
    private final Function1<FocusDirection, Boolean> onMoveFocusInterop;
    private final Function2<FocusDirection, Rect, Boolean> onRequestFocusForOwner;
    private FocusTargetNode rootFocusNode = new FocusTargetNode(Focusability.INSTANCE.m4062getNeverLCbbffg(), null, null, 6, null);
    private final FocusTransactionManager focusTransactionManager = new FocusTransactionManager();
    private final Modifier modifier = new ModifierNodeElement<FocusTargetNode>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        @Override // androidx.compose.ui.node.ModifierNodeElement
        public boolean equals(Object other) {
            return other == this;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(FocusTargetNode node) {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* renamed from: create, reason: avoid collision after fix types in other method */
        public FocusTargetNode getNode() {
            return FocusOwnerImpl.this.getRootFocusNode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.setName("RootFocusTarget");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public int hashCode() {
            return FocusOwnerImpl.this.getRootFocusNode().hashCode();
        }
    };
    private final MutableObjectList<FocusListener> listeners = new MutableObjectList<>(1);

    /* compiled from: FocusOwnerImpl.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FocusOwnerImpl(Function1<? super Function0<Unit>, Unit> function1, Function2<? super FocusDirection, ? super Rect, Boolean> function2, Function1<? super FocusDirection, Boolean> function12, Function0<Unit> function0, Function0<Rect> function02, Function0<? extends LayoutDirection> function03) {
        this.onRequestFocusForOwner = function2;
        this.onMoveFocusInterop = function12;
        this.onClearFocusForOwner = function0;
        this.onFocusRectInterop = function02;
        this.onLayoutDirection = function03;
        this.focusInvalidationManager = new FocusInvalidationManager(function1, new FocusOwnerImpl$focusInvalidationManager$1(this), new PropertyReference0Impl(this) { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusInvalidationManager$2
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((FocusOwnerImpl) this.receiver).getRootState();
            }
        }, new MutablePropertyReference0Impl(this) { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusInvalidationManager$3
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((FocusOwnerImpl) this.receiver).getActiveFocusTargetNode();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((FocusOwnerImpl) this.receiver).setActiveFocusTargetNode((FocusTargetNode) obj);
            }
        });
    }

    /* renamed from: getRootFocusNode$ui_release, reason: from getter */
    public final FocusTargetNode getRootFocusNode() {
        return this.rootFocusNode;
    }

    public final void setRootFocusNode$ui_release(FocusTargetNode focusTargetNode) {
        this.rootFocusNode = focusTargetNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusTransactionManager getFocusTransactionManager() {
        return this.focusTransactionManager;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: requestFocusForOwner-7o62pno */
    public boolean mo4028requestFocusForOwner7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect) {
        return this.onRequestFocusForOwner.invoke(focusDirection, previouslyFocusedRect).booleanValue();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: takeFocus-aToIllA */
    public boolean mo4029takeFocusaToIllA(final int focusDirection, Rect previouslyFocusedRect) {
        Boolean mo4027focusSearchULY8qGw = mo4027focusSearchULY8qGw(focusDirection, previouslyFocusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$takeFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.mo4040requestFocus3ESFkO8(focusDirection));
            }
        });
        if (mo4027focusSearchULY8qGw != null) {
            return mo4027focusSearchULY8qGw.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void releaseFocus() {
        if (ComposeUiFlags.isTrackFocusEnabled) {
            FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
            return;
        }
        FocusTransactionManager focusTransactionManager = getFocusTransactionManager();
        if (!focusTransactionManager.getOngoingTransaction()) {
            try {
                focusTransactionManager.beginTransaction();
                FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
                return;
            } finally {
                focusTransactionManager.commitTransaction();
            }
        }
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public void clearFocus(boolean force) {
        mo4024clearFocusI7lrPNg(force, true, true, FocusDirection.INSTANCE.m4015getExitdhqQ8s());
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0062, code lost:
    
        if (r11 != 3) goto L27;
     */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: clearFocus-I7lrPNg */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean mo4024clearFocusI7lrPNg(boolean r8, boolean r9, boolean r10, int r11) {
        /*
            r7 = this;
            boolean r0 = androidx.compose.ui.ComposeUiFlags.isTrackFocusEnabled
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == 0) goto L31
            if (r8 != 0) goto L2c
            androidx.compose.ui.focus.FocusTargetNode r0 = r7.rootFocusNode
            androidx.compose.ui.focus.CustomDestinationResult r11 = androidx.compose.ui.focus.FocusTransactionsKt.m4047performCustomClearFocusMxy_nc0(r0, r11)
            int[] r0 = androidx.compose.ui.focus.FocusOwnerImpl.WhenMappings.$EnumSwitchMapping$0
            int r11 = r11.ordinal()
            r11 = r0[r11]
            if (r11 == r4) goto L6e
            if (r11 == r3) goto L6e
            if (r11 == r2) goto L6e
            r0 = 4
            if (r11 != r0) goto L26
            boolean r1 = r7.clearFocus(r8, r9)
            goto L6e
        L26:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L2c:
            boolean r1 = r7.clearFocus(r8, r9)
            goto L6e
        L31:
            androidx.compose.ui.focus.FocusTransactionManager r0 = r7.getFocusTransactionManager()
            androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 r5 = new kotlin.jvm.functions.Function0<kotlin.Unit>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1
                static {
                    /*
                        androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 r0 = new androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1) androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1.INSTANCE androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1.<init>():void");
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    /*
                        r0 = this;
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1.invoke2():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.Unit invoke() {
                    /*
                        r0 = this;
                        r0.invoke2()
                        kotlin.Unit r0 = kotlin.Unit.INSTANCE
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1.invoke():java.lang.Object");
                }
            }
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            boolean r6 = r0.getOngoingTransaction()     // Catch: java.lang.Throwable -> L78
            if (r6 == 0) goto L42
            androidx.compose.ui.focus.FocusTransactionManager.access$cancelTransaction(r0)     // Catch: java.lang.Throwable -> L78
        L42:
            androidx.compose.ui.focus.FocusTransactionManager.access$beginTransaction(r0)     // Catch: java.lang.Throwable -> L78
            if (r5 == 0) goto L4e
            androidx.compose.runtime.collection.MutableVector r6 = androidx.compose.ui.focus.FocusTransactionManager.access$getCancellationListener$p(r0)     // Catch: java.lang.Throwable -> L78
            r6.add(r5)     // Catch: java.lang.Throwable -> L78
        L4e:
            if (r8 != 0) goto L64
            androidx.compose.ui.focus.FocusTargetNode r5 = r7.rootFocusNode     // Catch: java.lang.Throwable -> L78
            androidx.compose.ui.focus.CustomDestinationResult r11 = androidx.compose.ui.focus.FocusTransactionsKt.m4047performCustomClearFocusMxy_nc0(r5, r11)     // Catch: java.lang.Throwable -> L78
            int[] r5 = androidx.compose.ui.focus.FocusOwnerImpl.WhenMappings.$EnumSwitchMapping$0     // Catch: java.lang.Throwable -> L78
            int r11 = r11.ordinal()     // Catch: java.lang.Throwable -> L78
            r11 = r5[r11]     // Catch: java.lang.Throwable -> L78
            if (r11 == r4) goto L6b
            if (r11 == r3) goto L6b
            if (r11 == r2) goto L6b
        L64:
            androidx.compose.ui.focus.FocusTargetNode r11 = r7.rootFocusNode     // Catch: java.lang.Throwable -> L78
            boolean r8 = androidx.compose.ui.focus.FocusTransactionsKt.clearFocus(r11, r8, r9)     // Catch: java.lang.Throwable -> L78
            r1 = r8
        L6b:
            androidx.compose.ui.focus.FocusTransactionManager.access$commitTransaction(r0)
        L6e:
            if (r1 == 0) goto L77
            if (r10 == 0) goto L77
            kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r7.onClearFocusForOwner
            r7.invoke()
        L77:
            return r1
        L78:
            r7 = move-exception
            androidx.compose.ui.focus.FocusTransactionManager.access$commitTransaction(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.mo4024clearFocusI7lrPNg(boolean, boolean, boolean, int):boolean");
    }

    static /* synthetic */ boolean clearFocus$default(FocusOwnerImpl focusOwnerImpl, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return focusOwnerImpl.clearFocus(z, z2);
    }

    private final boolean clearFocus(boolean forced, boolean refreshFocusEvents) {
        NodeChain nodes;
        if (getActiveFocusTargetNode() == null) {
            return true;
        }
        if (getIsFocusCaptured() && !forced) {
            return false;
        }
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        setActiveFocusTargetNode(null);
        if (refreshFocusEvents && activeFocusTargetNode != null) {
            activeFocusTargetNode.dispatchFocusCallbacks$ui_release(getIsFocusCaptured() ? FocusStateImpl.Captured : FocusStateImpl.Active, FocusStateImpl.Inactive);
            FocusTargetNode focusTargetNode = activeFocusTargetNode;
            int m5994constructorimpl = NodeKind.m5994constructorimpl(1024);
            if (!focusTargetNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = focusTargetNode.getNode().getParent();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & m5994constructorimpl) != 0) {
                            Modifier.Node node = parent;
                            MutableVector mutableVector = null;
                            while (node != null) {
                                if (node instanceof FocusTargetNode) {
                                    ((FocusTargetNode) node).dispatchFocusCallbacks$ui_release(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
                                } else if ((node.getKindSet() & m5994constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                        if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(node);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate);
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                parent = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
            }
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [T, java.lang.Boolean] */
    @Override // androidx.compose.ui.focus.FocusManager
    /* renamed from: moveFocus-3ESFkO8 */
    public boolean mo4022moveFocus3ESFkO8(final int focusDirection) {
        if (ComposeUiFlags.isViewFocusFixEnabled && this.onMoveFocusInterop.invoke(FocusDirection.m4006boximpl(focusDirection)).booleanValue()) {
            return true;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = false;
        int generation = getFocusTransactionManager().getGeneration();
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        Boolean mo4027focusSearchULY8qGw = mo4027focusSearchULY8qGw(focusDirection, this.onFocusRectInterop.invoke(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$focusSearchSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Boolean] */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                objectRef.element = Boolean.valueOf(focusTargetNode.mo4040requestFocus3ESFkO8(focusDirection));
                Boolean bool = objectRef.element;
                return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
            }
        });
        int generation2 = getFocusTransactionManager().getGeneration();
        if (Intrinsics.areEqual((Object) mo4027focusSearchULY8qGw, (Object) true) && (generation != generation2 || (ComposeUiFlags.isTrackFocusEnabled && activeFocusTargetNode != getActiveFocusTargetNode()))) {
            return true;
        }
        if (mo4027focusSearchULY8qGw != null && objectRef.element != 0) {
            if (Intrinsics.areEqual((Object) mo4027focusSearchULY8qGw, (Object) true) && Intrinsics.areEqual((Object) objectRef.element, (Object) true)) {
                return true;
            }
            if (FocusOwnerImplKt.m4033is1dFocusSearch3ESFkO8(focusDirection)) {
                return mo4024clearFocusI7lrPNg(false, true, false, focusDirection) && mo4029takeFocusaToIllA(focusDirection, null);
            }
            if (!ComposeUiFlags.isViewFocusFixEnabled && this.onMoveFocusInterop.invoke(FocusDirection.m4006boximpl(focusDirection)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: focusSearch-ULY8qGw */
    public Boolean mo4027focusSearchULY8qGw(int focusDirection, Rect focusedRect, final Function1<? super FocusTargetNode, Boolean> onFound) {
        final FocusTargetNode findFocusTargetNode = findFocusTargetNode();
        if (findFocusTargetNode != null) {
            FocusRequester m4051customFocusSearchOMvw8 = FocusTraversalKt.m4051customFocusSearchOMvw8(findFocusTargetNode, focusDirection, this.onLayoutDirection.invoke());
            if (Intrinsics.areEqual(m4051customFocusSearchOMvw8, FocusRequester.INSTANCE.getCancel())) {
                return null;
            }
            if (Intrinsics.areEqual(m4051customFocusSearchOMvw8, FocusRequester.INSTANCE.getRedirect$ui_release())) {
                FocusTargetNode findFocusTargetNode2 = findFocusTargetNode();
                if (findFocusTargetNode2 != null) {
                    return onFound.invoke(findFocusTargetNode2);
                }
                return null;
            }
            if (!Intrinsics.areEqual(m4051customFocusSearchOMvw8, FocusRequester.INSTANCE.getDefault())) {
                return Boolean.valueOf(m4051customFocusSearchOMvw8.findFocusTargetNode$ui_release(onFound));
            }
        } else {
            findFocusTargetNode = null;
        }
        return FocusTraversalKt.m4052focusSearch0X8WOeE(this.rootFocusNode, focusDirection, this.onLayoutDirection.invoke(), focusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusSearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                boolean booleanValue;
                if (Intrinsics.areEqual(focusTargetNode, FocusTargetNode.this)) {
                    booleanValue = false;
                } else {
                    if (Intrinsics.areEqual(focusTargetNode, this.getRootFocusNode())) {
                        throw new IllegalStateException("Focus search landed at the root.".toString());
                    }
                    booleanValue = onFound.invoke(focusTargetNode).booleanValue();
                }
                return Boolean.valueOf(booleanValue);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v15, types: [T, androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v20, types: [T, androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v32, types: [T, androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v42, types: [T, java.lang.Object, androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v51, types: [T, androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v61, types: [T, java.lang.Object, androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v79 */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r2v82 */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchKeyEvent-YhN2O0w */
    public boolean mo4026dispatchKeyEventYhN2O0w(KeyEvent keyEvent, Function0<Boolean> onFocusedItem) {
        Object obj;
        Modifier.Node node;
        NodeChain nodes;
        Object obj2;
        NodeChain nodes2;
        NodeChain nodes3;
        Trace.beginSection("FocusOwnerImpl:dispatchKeyEvent");
        try {
            if (this.focusInvalidationManager.hasPendingInvalidation()) {
                System.out.println((Object) "FocusRelatedWarning: Dispatching key event while focus system is invalidated.");
                return false;
            }
            if (!m4032validateKeyEventZmokQxo(keyEvent)) {
                return false;
            }
            FocusTargetNode findFocusTargetNode = findFocusTargetNode();
            if (findFocusTargetNode == null || (node = lastLocalKeyInputNode(findFocusTargetNode)) == null) {
                if (findFocusTargetNode != null) {
                    FocusTargetNode focusTargetNode = findFocusTargetNode;
                    int m5994constructorimpl = NodeKind.m5994constructorimpl(8192);
                    if (!focusTargetNode.getNode().getIsAttached()) {
                        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                    }
                    Modifier.Node node2 = focusTargetNode.getNode();
                    LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                    loop10: while (true) {
                        if (requireLayoutNode == null) {
                            obj2 = null;
                            break;
                        }
                        if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                            while (node2 != null) {
                                if ((node2.getKindSet() & m5994constructorimpl) != 0) {
                                    MutableVector mutableVector = null;
                                    Modifier.Node node3 = node2;
                                    while (node3 != null) {
                                        if (node3 instanceof KeyInputModifierNode) {
                                            obj2 = node3;
                                            break loop10;
                                        }
                                        if ((node3.getKindSet() & m5994constructorimpl) != 0 && (node3 instanceof DelegatingNode)) {
                                            Modifier.Node delegate = ((DelegatingNode) node3).getDelegate();
                                            int i = 0;
                                            node3 = node3;
                                            while (delegate != null) {
                                                if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                                                    i++;
                                                    if (i == 1) {
                                                        node3 = delegate;
                                                    } else {
                                                        if (mutableVector == null) {
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        }
                                                        if (node3 != null) {
                                                            if (mutableVector != null) {
                                                                Boolean.valueOf(mutableVector.add(node3));
                                                            }
                                                            node3 = null;
                                                        }
                                                        if (mutableVector != null) {
                                                            Boolean.valueOf(mutableVector.add(delegate));
                                                        }
                                                    }
                                                }
                                                delegate = delegate.getChild();
                                                node3 = node3;
                                            }
                                            if (i == 1) {
                                            }
                                        }
                                        node3 = DelegatableNodeKt.pop(mutableVector);
                                    }
                                }
                                node2 = node2.getParent();
                            }
                        }
                        requireLayoutNode = requireLayoutNode.getParent$ui_release();
                        node2 = (requireLayoutNode == null || (nodes2 = requireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
                    }
                    KeyInputModifierNode keyInputModifierNode = (KeyInputModifierNode) obj2;
                    if (keyInputModifierNode != null) {
                        node = keyInputModifierNode.getNode();
                    }
                }
                FocusTargetNode focusTargetNode2 = this.rootFocusNode;
                int m5994constructorimpl2 = NodeKind.m5994constructorimpl(8192);
                if (!focusTargetNode2.getNode().getIsAttached()) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node parent = focusTargetNode2.getNode().getParent();
                LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
                loop14: while (true) {
                    if (requireLayoutNode2 == null) {
                        obj = null;
                        break;
                    }
                    if ((requireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl2) != 0) {
                        while (parent != null) {
                            if ((parent.getKindSet() & m5994constructorimpl2) != 0) {
                                MutableVector mutableVector2 = null;
                                Modifier.Node node4 = parent;
                                while (node4 != null) {
                                    if (node4 instanceof KeyInputModifierNode) {
                                        obj = node4;
                                        break loop14;
                                    }
                                    if ((node4.getKindSet() & m5994constructorimpl2) != 0 && (node4 instanceof DelegatingNode)) {
                                        Modifier.Node delegate2 = ((DelegatingNode) node4).getDelegate();
                                        int i2 = 0;
                                        node4 = node4;
                                        while (delegate2 != null) {
                                            if ((delegate2.getKindSet() & m5994constructorimpl2) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    node4 = delegate2;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (node4 != null) {
                                                        if (mutableVector2 != null) {
                                                            Boolean.valueOf(mutableVector2.add(node4));
                                                        }
                                                        node4 = null;
                                                    }
                                                    if (mutableVector2 != null) {
                                                        Boolean.valueOf(mutableVector2.add(delegate2));
                                                    }
                                                }
                                            }
                                            delegate2 = delegate2.getChild();
                                            node4 = node4;
                                        }
                                        if (i2 == 1) {
                                        }
                                    }
                                    node4 = DelegatableNodeKt.pop(mutableVector2);
                                }
                            }
                            parent = parent.getParent();
                        }
                    }
                    requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                    parent = (requireLayoutNode2 == null || (nodes = requireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
                }
                KeyInputModifierNode keyInputModifierNode2 = (KeyInputModifierNode) obj;
                node = keyInputModifierNode2 != null ? keyInputModifierNode2.getNode() : null;
            }
            if (node != null) {
                Modifier.Node node5 = node;
                int m5994constructorimpl3 = NodeKind.m5994constructorimpl(8192);
                if (!node5.getNode().getIsAttached()) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node parent2 = node5.getNode().getParent();
                LayoutNode requireLayoutNode3 = DelegatableNodeKt.requireLayoutNode(node5);
                ArrayList arrayList = null;
                while (requireLayoutNode3 != null) {
                    if ((requireLayoutNode3.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl3) != 0) {
                        while (parent2 != null) {
                            if ((parent2.getKindSet() & m5994constructorimpl3) != 0) {
                                Modifier.Node node6 = parent2;
                                MutableVector mutableVector3 = null;
                                while (node6 != null) {
                                    if (node6 instanceof KeyInputModifierNode) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(node6);
                                    } else if ((node6.getKindSet() & m5994constructorimpl3) != 0 && (node6 instanceof DelegatingNode)) {
                                        int i3 = 0;
                                        for (Modifier.Node delegate3 = ((DelegatingNode) node6).getDelegate(); delegate3 != null; delegate3 = delegate3.getChild()) {
                                            if ((delegate3.getKindSet() & m5994constructorimpl3) != 0) {
                                                i3++;
                                                if (i3 == 1) {
                                                    node6 = delegate3;
                                                } else {
                                                    if (mutableVector3 == null) {
                                                        mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (node6 != null) {
                                                        if (mutableVector3 != null) {
                                                            Boolean.valueOf(mutableVector3.add(node6));
                                                        }
                                                        node6 = null;
                                                    }
                                                    if (mutableVector3 != null) {
                                                        Boolean.valueOf(mutableVector3.add(delegate3));
                                                    }
                                                }
                                            }
                                        }
                                        if (i3 == 1) {
                                        }
                                    }
                                    node6 = DelegatableNodeKt.pop(mutableVector3);
                                }
                            }
                            parent2 = parent2.getParent();
                        }
                    }
                    requireLayoutNode3 = requireLayoutNode3.getParent$ui_release();
                    parent2 = (requireLayoutNode3 == null || (nodes3 = requireLayoutNode3.getNodes()) == null) ? null : nodes3.getTail();
                }
                if (arrayList != null) {
                    int size = arrayList.size() - 1;
                    if (size >= 0) {
                        while (true) {
                            int i4 = size - 1;
                            if (((KeyInputModifierNode) arrayList.get(size)).mo529onPreKeyEventZmokQxo(keyEvent)) {
                                return true;
                            }
                            if (i4 < 0) {
                                break;
                            }
                            size = i4;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
                ?? node7 = node5.getNode();
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = node7;
                while (objectRef2.element != 0) {
                    if (objectRef2.element instanceof KeyInputModifierNode) {
                        if (((KeyInputModifierNode) objectRef2.element).mo529onPreKeyEventZmokQxo(keyEvent)) {
                            return true;
                        }
                    } else if ((((Modifier.Node) objectRef2.element).getKindSet() & m5994constructorimpl3) != 0 && (objectRef2.element instanceof DelegatingNode)) {
                        int i5 = 0;
                        for (?? r2 = ((DelegatingNode) objectRef2.element).getDelegate(); r2 != 0; r2 = r2.getChild()) {
                            if ((r2.getKindSet() & m5994constructorimpl3) != 0) {
                                i5++;
                                if (i5 == 1) {
                                    objectRef2.element = r2;
                                } else {
                                    MutableVector mutableVector4 = (MutableVector) objectRef.element;
                                    T t = mutableVector4;
                                    if (mutableVector4 == null) {
                                        t = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    objectRef.element = t;
                                    Modifier.Node node8 = (Modifier.Node) objectRef2.element;
                                    if (node8 != null) {
                                        MutableVector mutableVector5 = (MutableVector) objectRef.element;
                                        if (mutableVector5 != null) {
                                            Boolean.valueOf(mutableVector5.add(node8));
                                        }
                                        objectRef2.element = null;
                                    }
                                    MutableVector mutableVector6 = (MutableVector) objectRef.element;
                                    if (mutableVector6 != null) {
                                        Boolean.valueOf(mutableVector6.add(r2));
                                    }
                                }
                            }
                        }
                        if (i5 == 1) {
                        }
                    }
                    objectRef2.element = DelegatableNodeKt.pop((MutableVector) objectRef.element);
                }
                if (onFocusedItem.invoke().booleanValue()) {
                    return true;
                }
                ?? node9 = node5.getNode();
                Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
                objectRef4.element = node9;
                while (objectRef4.element != 0) {
                    if (objectRef4.element instanceof KeyInputModifierNode) {
                        if (((KeyInputModifierNode) objectRef4.element).mo527onKeyEventZmokQxo(keyEvent)) {
                            return true;
                        }
                    } else if ((((Modifier.Node) objectRef4.element).getKindSet() & m5994constructorimpl3) != 0 && (objectRef4.element instanceof DelegatingNode)) {
                        int i6 = 0;
                        for (?? r22 = ((DelegatingNode) objectRef4.element).getDelegate(); r22 != 0; r22 = r22.getChild()) {
                            if ((r22.getKindSet() & m5994constructorimpl3) != 0) {
                                i6++;
                                if (i6 == 1) {
                                    objectRef4.element = r22;
                                } else {
                                    MutableVector mutableVector7 = (MutableVector) objectRef3.element;
                                    T t2 = mutableVector7;
                                    if (mutableVector7 == null) {
                                        t2 = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    objectRef3.element = t2;
                                    Modifier.Node node10 = (Modifier.Node) objectRef4.element;
                                    if (node10 != null) {
                                        MutableVector mutableVector8 = (MutableVector) objectRef3.element;
                                        if (mutableVector8 != null) {
                                            Boolean.valueOf(mutableVector8.add(node10));
                                        }
                                        objectRef4.element = null;
                                    }
                                    MutableVector mutableVector9 = (MutableVector) objectRef3.element;
                                    if (mutableVector9 != null) {
                                        Boolean.valueOf(mutableVector9.add(r22));
                                    }
                                }
                            }
                        }
                        if (i6 == 1) {
                        }
                    }
                    objectRef4.element = DelegatableNodeKt.pop((MutableVector) objectRef3.element);
                }
                if (arrayList != null) {
                    int size2 = arrayList.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        if (((KeyInputModifierNode) arrayList.get(i7)).mo527onKeyEventZmokQxo(keyEvent)) {
                            return true;
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
                Unit unit3 = Unit.INSTANCE;
            }
            return false;
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    public boolean mo4025dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent keyEvent) {
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode;
        int size;
        NodeChain nodes;
        DelegatingNode delegatingNode;
        NodeChain nodes2;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching intercepted soft keyboard event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            FocusTargetNode focusTargetNode = findActiveFocusNode;
            int m5994constructorimpl = NodeKind.m5994constructorimpl(131072);
            if (!focusTargetNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNode.getNode();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (requireLayoutNode == null) {
                    delegatingNode = 0;
                    break;
                }
                if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                    while (node != null) {
                        if ((node.getKindSet() & m5994constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            delegatingNode = node;
                            while (delegatingNode != 0) {
                                if (delegatingNode instanceof SoftKeyboardInterceptionModifierNode) {
                                    break loop0;
                                }
                                if ((delegatingNode.getKindSet() & m5994constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                                    Modifier.Node delegate = delegatingNode.getDelegate();
                                    int i = 0;
                                    delegatingNode = delegatingNode;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                delegatingNode = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (delegatingNode != 0) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(delegatingNode);
                                                    }
                                                    delegatingNode = 0;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate);
                                                }
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        delegatingNode = delegatingNode;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                delegatingNode = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        node = node.getParent();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                node = (requireLayoutNode == null || (nodes2 = requireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
            }
            softKeyboardInterceptionModifierNode = (SoftKeyboardInterceptionModifierNode) delegatingNode;
        } else {
            softKeyboardInterceptionModifierNode = null;
        }
        if (softKeyboardInterceptionModifierNode != null) {
            SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode2 = softKeyboardInterceptionModifierNode;
            int m5994constructorimpl2 = NodeKind.m5994constructorimpl(131072);
            if (!softKeyboardInterceptionModifierNode2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = softKeyboardInterceptionModifierNode2.getNode().getParent();
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(softKeyboardInterceptionModifierNode2);
            ArrayList arrayList = null;
            while (requireLayoutNode2 != null) {
                if ((requireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl2) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & m5994constructorimpl2) != 0) {
                            Modifier.Node node2 = parent;
                            MutableVector mutableVector2 = null;
                            while (node2 != null) {
                                if (node2 instanceof SoftKeyboardInterceptionModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(node2);
                                } else if ((node2.getKindSet() & m5994constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate2 = ((DelegatingNode) node2).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                        if ((delegate2.getKindSet() & m5994constructorimpl2) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                node2 = delegate2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node2 != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node2);
                                                    }
                                                    node2 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate2);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                node2 = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                parent = (requireLayoutNode2 == null || (nodes = requireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i3 = size - 1;
                    if (((SoftKeyboardInterceptionModifierNode) arrayList.get(size)).mo5151onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                    if (i3 < 0) {
                        break;
                    }
                    size = i3;
                }
            }
            DelegatingNode node3 = softKeyboardInterceptionModifierNode2.getNode();
            MutableVector mutableVector3 = null;
            while (node3 != 0) {
                if (node3 instanceof SoftKeyboardInterceptionModifierNode) {
                    if (((SoftKeyboardInterceptionModifierNode) node3).mo5151onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node3.getKindSet() & m5994constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                    Modifier.Node delegate3 = node3.getDelegate();
                    int i4 = 0;
                    node3 = node3;
                    while (delegate3 != null) {
                        if ((delegate3.getKindSet() & m5994constructorimpl2) != 0) {
                            i4++;
                            if (i4 == 1) {
                                node3 = delegate3;
                            } else {
                                if (mutableVector3 == null) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node3 != 0) {
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(node3);
                                    }
                                    node3 = 0;
                                }
                                if (mutableVector3 != null) {
                                    mutableVector3.add(delegate3);
                                }
                            }
                        }
                        delegate3 = delegate3.getChild();
                        node3 = node3;
                    }
                    if (i4 == 1) {
                    }
                }
                node3 = DelegatableNodeKt.pop(mutableVector3);
            }
            DelegatingNode node4 = softKeyboardInterceptionModifierNode2.getNode();
            MutableVector mutableVector4 = null;
            while (node4 != 0) {
                if (node4 instanceof SoftKeyboardInterceptionModifierNode) {
                    if (((SoftKeyboardInterceptionModifierNode) node4).mo5150onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node4.getKindSet() & m5994constructorimpl2) != 0 && (node4 instanceof DelegatingNode)) {
                    Modifier.Node delegate4 = node4.getDelegate();
                    int i5 = 0;
                    node4 = node4;
                    while (delegate4 != null) {
                        if ((delegate4.getKindSet() & m5994constructorimpl2) != 0) {
                            i5++;
                            if (i5 == 1) {
                                node4 = delegate4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node4 != 0) {
                                    if (mutableVector4 != null) {
                                        mutableVector4.add(node4);
                                    }
                                    node4 = 0;
                                }
                                if (mutableVector4 != null) {
                                    mutableVector4.add(delegate4);
                                }
                            }
                        }
                        delegate4 = delegate4.getChild();
                        node4 = node4;
                    }
                    if (i5 == 1) {
                    }
                }
                node4 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    if (((SoftKeyboardInterceptionModifierNode) arrayList.get(i6)).mo5150onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r15v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r15v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(RotaryScrollEvent event, Function0<Boolean> onFocusedItem) {
        RotaryInputModifierNode rotaryInputModifierNode;
        int size;
        NodeChain nodes;
        DelegatingNode delegatingNode;
        NodeChain nodes2;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching rotary event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode findFocusTargetNode = findFocusTargetNode();
        if (findFocusTargetNode != null) {
            FocusTargetNode focusTargetNode = findFocusTargetNode;
            int m5994constructorimpl = NodeKind.m5994constructorimpl(16384);
            if (!focusTargetNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNode.getNode();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (requireLayoutNode == null) {
                    delegatingNode = 0;
                    break;
                }
                if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                    while (node != null) {
                        if ((node.getKindSet() & m5994constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            delegatingNode = node;
                            while (delegatingNode != 0) {
                                if (delegatingNode instanceof RotaryInputModifierNode) {
                                    break loop0;
                                }
                                if ((delegatingNode.getKindSet() & m5994constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                                    Modifier.Node delegate = delegatingNode.getDelegate();
                                    int i = 0;
                                    delegatingNode = delegatingNode;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                delegatingNode = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (delegatingNode != 0) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(delegatingNode);
                                                    }
                                                    delegatingNode = 0;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate);
                                                }
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        delegatingNode = delegatingNode;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                delegatingNode = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        node = node.getParent();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                node = (requireLayoutNode == null || (nodes2 = requireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
            }
            rotaryInputModifierNode = (RotaryInputModifierNode) delegatingNode;
        } else {
            rotaryInputModifierNode = null;
        }
        if (rotaryInputModifierNode != null) {
            RotaryInputModifierNode rotaryInputModifierNode2 = rotaryInputModifierNode;
            int m5994constructorimpl2 = NodeKind.m5994constructorimpl(16384);
            if (!rotaryInputModifierNode2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = rotaryInputModifierNode2.getNode().getParent();
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(rotaryInputModifierNode2);
            ArrayList arrayList = null;
            while (requireLayoutNode2 != null) {
                if ((requireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl2) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & m5994constructorimpl2) != 0) {
                            Modifier.Node node2 = parent;
                            MutableVector mutableVector2 = null;
                            while (node2 != null) {
                                if (node2 instanceof RotaryInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(node2);
                                } else if ((node2.getKindSet() & m5994constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate2 = ((DelegatingNode) node2).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                        if ((delegate2.getKindSet() & m5994constructorimpl2) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                node2 = delegate2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node2 != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node2);
                                                    }
                                                    node2 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate2);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                node2 = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                parent = (requireLayoutNode2 == null || (nodes = requireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i3 = size - 1;
                    if (((RotaryInputModifierNode) arrayList.get(size)).onPreRotaryScrollEvent(event)) {
                        return true;
                    }
                    if (i3 < 0) {
                        break;
                    }
                    size = i3;
                }
            }
            DelegatingNode node3 = rotaryInputModifierNode2.getNode();
            MutableVector mutableVector3 = null;
            while (node3 != 0) {
                if (node3 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node3).onPreRotaryScrollEvent(event)) {
                        return true;
                    }
                } else if ((node3.getKindSet() & m5994constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                    Modifier.Node delegate3 = node3.getDelegate();
                    int i4 = 0;
                    node3 = node3;
                    while (delegate3 != null) {
                        if ((delegate3.getKindSet() & m5994constructorimpl2) != 0) {
                            i4++;
                            if (i4 == 1) {
                                node3 = delegate3;
                            } else {
                                if (mutableVector3 == null) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node3 != 0) {
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(node3);
                                    }
                                    node3 = 0;
                                }
                                if (mutableVector3 != null) {
                                    mutableVector3.add(delegate3);
                                }
                            }
                        }
                        delegate3 = delegate3.getChild();
                        node3 = node3;
                    }
                    if (i4 == 1) {
                    }
                }
                node3 = DelegatableNodeKt.pop(mutableVector3);
            }
            if (onFocusedItem.invoke().booleanValue()) {
                return true;
            }
            DelegatingNode node4 = rotaryInputModifierNode2.getNode();
            MutableVector mutableVector4 = null;
            while (node4 != 0) {
                if (node4 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node4).onRotaryScrollEvent(event)) {
                        return true;
                    }
                } else if ((node4.getKindSet() & m5994constructorimpl2) != 0 && (node4 instanceof DelegatingNode)) {
                    Modifier.Node delegate4 = node4.getDelegate();
                    int i5 = 0;
                    node4 = node4;
                    while (delegate4 != null) {
                        if ((delegate4.getKindSet() & m5994constructorimpl2) != 0) {
                            i5++;
                            if (i5 == 1) {
                                node4 = delegate4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node4 != 0) {
                                    if (mutableVector4 != null) {
                                        mutableVector4.add(node4);
                                    }
                                    node4 = 0;
                                }
                                if (mutableVector4 != null) {
                                    mutableVector4.add(delegate4);
                                }
                            }
                        }
                        delegate4 = delegate4.getChild();
                        node4 = node4;
                    }
                    if (i5 == 1) {
                    }
                }
                node4 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    if (((RotaryInputModifierNode) arrayList.get(i6)).onRotaryScrollEvent(event)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusTargetNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusEventModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusPropertiesModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidationForOwner() {
        this.focusInvalidationManager.scheduleInvalidationForOwner();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOwnerFocusState() {
        if ((ComposeUiFlags.isTrackFocusEnabled && getActiveFocusTargetNode() == null) || this.rootFocusNode.getFocusState() == FocusStateImpl.Inactive) {
            this.onClearFocusForOwner.invoke();
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Rect getFocusRect() {
        FocusTargetNode findFocusTargetNode = findFocusTargetNode();
        if (findFocusTargetNode != null) {
            return FocusTraversalKt.focusRect(findFocusTargetNode);
        }
        return null;
    }

    private final FocusTargetNode findFocusTargetNode() {
        return FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusState getRootState() {
        return this.rootFocusNode.getFocusState();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public MutableObjectList<FocusListener> getListeners() {
        return this.listeners;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusTargetNode getActiveFocusTargetNode() {
        return this.activeFocusTargetNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void setActiveFocusTargetNode(FocusTargetNode focusTargetNode) {
        FocusTargetNode focusTargetNode2 = this.activeFocusTargetNode;
        this.activeFocusTargetNode = focusTargetNode;
        if (focusTargetNode == null || focusTargetNode2 != focusTargetNode) {
            setFocusCaptured(false);
        }
        if (ComposeUiFlags.isSemanticAutofillEnabled) {
            MutableObjectList<FocusListener> listeners = getListeners();
            Object[] objArr = listeners.content;
            int i = listeners._size;
            for (int i2 = 0; i2 < i; i2++) {
                ((FocusListener) objArr[i2]).onFocusChanged(focusTargetNode2, focusTargetNode);
            }
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: isFocusCaptured, reason: from getter */
    public boolean getIsFocusCaptured() {
        return this.isFocusCaptured;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void setFocusCaptured(boolean z) {
        if (!((z && getActiveFocusTargetNode() == null) ? false : true)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot capture focus when the active focus target node is unset");
        }
        this.isFocusCaptured = z;
    }

    /* renamed from: validateKeyEvent-ZmokQxo, reason: not valid java name */
    private final boolean m4032validateKeyEventZmokQxo(KeyEvent keyEvent) {
        long m5463getKeyZmokQxo = KeyEvent_androidKt.m5463getKeyZmokQxo(keyEvent);
        int m5464getTypeZmokQxo = KeyEvent_androidKt.m5464getTypeZmokQxo(keyEvent);
        if (KeyEventType.m5456equalsimpl0(m5464getTypeZmokQxo, KeyEventType.INSTANCE.m5460getKeyDownCS__XNY())) {
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (mutableLongSet == null) {
                mutableLongSet = new MutableLongSet(3);
                this.keysCurrentlyDown = mutableLongSet;
            }
            mutableLongSet.plusAssign(m5463getKeyZmokQxo);
        } else if (KeyEventType.m5456equalsimpl0(m5464getTypeZmokQxo, KeyEventType.INSTANCE.m5461getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (mutableLongSet2 == null || !mutableLongSet2.contains(m5463getKeyZmokQxo)) {
                return false;
            }
            MutableLongSet mutableLongSet3 = this.keysCurrentlyDown;
            if (mutableLongSet3 != null) {
                mutableLongSet3.remove(m5463getKeyZmokQxo);
            }
        }
        return true;
    }

    /* renamed from: traverseAncestorsIncludingSelf-QFhIj7k, reason: not valid java name */
    private final /* synthetic */ <T extends DelegatableNode> void m4031traverseAncestorsIncludingSelfQFhIj7k(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1, Function0<Unit> function0, Function1<? super T, Unit> function12) {
        int i2;
        int size;
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        ArrayList arrayList = null;
        while (true) {
            if (requireLayoutNode == null) {
                break;
            }
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & i) != 0) {
                        Modifier.Node node = parent;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (node instanceof Object) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(node);
                            } else if ((node.getKindSet() & i) != 0 && (node instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & i) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        if (arrayList != null && arrayList.size() - 1 >= 0) {
            while (true) {
                int i4 = size - 1;
                function1.invoke((Object) arrayList.get(size));
                if (i4 < 0) {
                    break;
                } else {
                    size = i4;
                }
            }
        }
        Modifier.Node node2 = delegatableNode.getNode();
        MutableVector mutableVector2 = null;
        while (node2 != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node2 instanceof Object) {
                function1.invoke(node2);
            } else if ((node2.getKindSet() & i) != 0 && (node2 instanceof DelegatingNode)) {
                int i5 = 0;
                for (Modifier.Node delegate2 = ((DelegatingNode) node2).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                    if ((delegate2.getKindSet() & i) != 0) {
                        i5++;
                        if (i5 == 1) {
                            node2 = delegate2;
                        } else {
                            if (mutableVector2 == null) {
                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node2 != null) {
                                if (mutableVector2 != null) {
                                    mutableVector2.add(node2);
                                }
                                node2 = null;
                            }
                            if (mutableVector2 != null) {
                                mutableVector2.add(delegate2);
                            }
                        }
                    }
                }
                if (i5 == 1) {
                }
            }
            node2 = DelegatableNodeKt.pop(mutableVector2);
        }
        function0.invoke();
        Modifier.Node node3 = delegatableNode.getNode();
        MutableVector mutableVector3 = null;
        while (node3 != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node3 instanceof Object) {
                function12.invoke(node3);
            } else if ((node3.getKindSet() & i) != 0 && (node3 instanceof DelegatingNode)) {
                int i6 = 0;
                for (Modifier.Node delegate3 = ((DelegatingNode) node3).getDelegate(); delegate3 != null; delegate3 = delegate3.getChild()) {
                    if ((delegate3.getKindSet() & i) != 0) {
                        i6++;
                        if (i6 == 1) {
                            node3 = delegate3;
                        } else {
                            if (mutableVector3 == null) {
                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node3 != null) {
                                if (mutableVector3 != null) {
                                    mutableVector3.add(node3);
                                }
                                node3 = null;
                            }
                            if (mutableVector3 != null) {
                                mutableVector3.add(delegate3);
                            }
                        }
                    }
                }
                if (i6 == 1) {
                }
            }
            node3 = DelegatableNodeKt.pop(mutableVector3);
        }
        if (arrayList != null) {
            int size2 = arrayList.size();
            for (i2 = 0; i2 < size2; i2++) {
                function12.invoke((Object) arrayList.get(i2));
            }
        }
    }

    /* renamed from: nearestAncestorIncludingSelf-64DMado, reason: not valid java name */
    private final /* synthetic */ <T> T m4030nearestAncestorIncludingSelf64DMado(DelegatableNode delegatableNode, int i) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        Object obj = (T) node;
                        MutableVector mutableVector = null;
                        while (obj != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (obj instanceof Object) {
                                return (T) obj;
                            }
                            Object obj2 = obj;
                            if ((((Modifier.Node) obj).getKindSet() & i) != 0 && (obj instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate = obj.getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            obj = (T) delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            Object obj3 = obj;
                                            if (obj != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(obj);
                                                }
                                                obj = (T) null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            obj = (T) DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    node = node.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            node = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode delegatableNode) {
        int m5994constructorimpl = NodeKind.m5994constructorimpl(1024) | NodeKind.m5994constructorimpl(8192);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        Modifier.Node node2 = null;
        if ((node.getAggregateChildKindSet() & m5994constructorimpl) != 0) {
            for (Modifier.Node child = node.getChild(); child != null; child = child.getChild()) {
                if ((child.getKindSet() & m5994constructorimpl) != 0) {
                    if ((NodeKind.m5994constructorimpl(1024) & child.getKindSet()) != 0) {
                        return node2;
                    }
                    node2 = child;
                }
            }
        }
        return node2;
    }
}
