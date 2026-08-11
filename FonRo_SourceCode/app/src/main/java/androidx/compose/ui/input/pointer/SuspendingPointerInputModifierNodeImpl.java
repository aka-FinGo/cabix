package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: SuspendingPointerInputFilter.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\\BX\b\u0017\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t\u0012'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fB;\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J=\u0010F\u001a\u0002HG\"\u0004\b\u0000\u0010G2'\u0010H\u001a#\b\u0001\u0012\u0004\u0012\u00020I\u0012\n\u0012\b\u0012\u0004\u0012\u0002HG0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¢\u0006\u0002\b\u000eH\u0096@¢\u0006\u0002\u0010JJ\u0018\u0010K\u001a\u00020\r2\u0006\u0010L\u001a\u00020\u001a2\u0006\u0010M\u001a\u00020NH\u0002J-\u0010O\u001a\u00020\r2\u0006\u0010M\u001a\u00020N2\u001a\u0010H\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u00030!R\u00020\u0000\u0012\u0004\u0012\u00020\r0PH\u0082\bJ\b\u0010Q\u001a\u00020\rH\u0016J\b\u0010R\u001a\u00020\rH\u0016J\b\u0010S\u001a\u00020\rH\u0016J*\u0010T\u001a\u00020\r2\u0006\u0010L\u001a\u00020\u001a2\u0006\u0010M\u001a\u00020N2\u0006\u0010U\u001a\u00020\u0017H\u0016ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\b\u0010X\u001a\u00020\rH\u0016J\b\u0010Y\u001a\u00020\rH\u0016J?\u0010Z\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0004\b[\u0010\u0012R3\u0010\u0013\u001a%\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000b¢\u0006\u0002\b\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\u00020\u0017X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030!R\u00020\u00000 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u001eR\u001a\u0010(\u001a\u00020)X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010.R\u0010\u0010/\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00100\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030!R\u00020\u00000 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00118V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106Rl\u00107\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¢\u0006\u0002\b\u000e2'\u00102\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¢\u0006\u0002\b\u000e8V@VX\u0097\u000e¢\u0006\u0012\u0012\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\u00178VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bA\u0010%R\u0014\u0010B\u001a\u00020C8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010E\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006]"}, d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/unit/Density;", "key1", "", "key2", "keys", "", "pointerInputEvent", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "pointerInputEventHandler", "Landroidx/compose/ui/input/pointer/PointerInputEventHandler;", "(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)V", "_deprecatedPointerInputHandler", "Lkotlin/jvm/functions/Function2;", "_pointerInputEventHandler", "boundsSize", "Landroidx/compose/ui/unit/IntSize;", "J", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "density", "", "getDensity", "()F", "dispatchingPointerHandlers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine;", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "fontScale", "getFontScale", "interceptOutOfBoundsChildEvents", "", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "[Ljava/lang/Object;", "lastPointerEvent", "pointerHandlers", "pointerHandlersLock", "value", "getPointerInputEventHandler", "()Landroidx/compose/ui/input/pointer/PointerInputEventHandler;", "setPointerInputEventHandler", "(Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)V", "pointerInputHandler", "getPointerInputHandler$annotations", "()V", "getPointerInputHandler", "()Lkotlin/jvm/functions/Function2;", "setPointerInputHandler", "(Lkotlin/jvm/functions/Function2;)V", "pointerInputJob", "Lkotlinx/coroutines/Job;", "size", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEventScope", "R", "block", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPointerEvent", "pointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "forEachCurrentPointerHandler", "Lkotlin/Function1;", "onCancelPointerInput", "onDensityChange", "onDetach", "onPointerEvent", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onViewConfigurationChange", "resetPointerInputHandler", "update", "update$ui_release", "PointerEventHandlerCoroutine", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class SuspendingPointerInputModifierNodeImpl extends Modifier.Node implements SuspendingPointerInputModifierNode, PointerInputScope, Density {
    public static final int $stable = 0;
    private Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> _deprecatedPointerInputHandler;
    private PointerInputEventHandler _pointerInputEventHandler;
    private long boundsSize;
    private PointerEvent currentEvent;
    private final MutableVector<PointerEventHandlerCoroutine<?>> dispatchingPointerHandlers;
    private boolean interceptOutOfBoundsChildEvents;
    private Object key1;
    private Object key2;
    private Object[] keys;
    private PointerEvent lastPointerEvent;
    private final MutableVector<PointerEventHandlerCoroutine<?>> pointerHandlers;
    private final Object pointerHandlersLock;
    private Job pointerInputJob;

    /* compiled from: SuspendingPointerInputFilter.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEventPass.values().length];
            try {
                iArr[PointerEventPass.Initial.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PointerEventPass.Final.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PointerEventPass.Main.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Deprecated(message = "Super property deprecated")
    public static /* synthetic */ void getPointerInputHandler$annotations() {
    }

    public /* synthetic */ SuspendingPointerInputModifierNodeImpl(Object obj, Object obj2, Object[] objArr, PointerInputEventHandler pointerInputEventHandler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj, (i & 2) != 0 ? null : obj2, (i & 4) != 0 ? null : objArr, pointerInputEventHandler);
    }

    public SuspendingPointerInputModifierNodeImpl(Object obj, Object obj2, Object[] objArr, PointerInputEventHandler pointerInputEventHandler) {
        PointerEvent pointerEvent;
        this.key1 = obj;
        this.key2 = obj2;
        this.keys = objArr;
        this._pointerInputEventHandler = pointerInputEventHandler;
        pointerEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
        this.currentEvent = pointerEvent;
        MutableVector<PointerEventHandlerCoroutine<?>> mutableVector = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.pointerHandlers = mutableVector;
        this.pointerHandlersLock = mutableVector;
        this.dispatchingPointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.boundsSize = IntSize.INSTANCE.m7165getZeroYbymL2g();
    }

    @Deprecated(message = "Exists to maintain compatibility with previous API shape")
    public SuspendingPointerInputModifierNodeImpl(Object obj, Object obj2, Object[] objArr, Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this(obj, obj2, objArr, new PointerInputEventHandler() { // from class: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.1
            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                return Unit.INSTANCE;
            }
        });
        this._deprecatedPointerInputHandler = function2;
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public Function2<PointerInputScope, Continuation<? super Unit>, Object> getPointerInputHandler() {
        Function2 function2 = this._deprecatedPointerInputHandler;
        return function2 == null ? new SuspendingPointerInputModifierNodeImpl$pointerInputHandler$1(null) : function2;
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public void setPointerInputHandler(Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        resetPointerInputHandler();
        this._deprecatedPointerInputHandler = function2;
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public void setPointerInputEventHandler(PointerInputEventHandler pointerInputEventHandler) {
        resetPointerInputHandler();
        this._deprecatedPointerInputHandler = null;
        this._pointerInputEventHandler = pointerInputEventHandler;
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    /* renamed from: getPointerInputEventHandler, reason: from getter */
    public PointerInputEventHandler get_pointerInputEventHandler() {
        return this._pointerInputEventHandler;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public ViewConfiguration getViewConfiguration() {
        return DelegatableNodeKt.requireLayoutNode(this).getViewConfiguration();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    /* renamed from: getSize-YbymL2g, reason: from getter */
    public long getBoundsSize() {
        return this.boundsSize;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    /* renamed from: getExtendedTouchPadding-NH-jbRc */
    public long mo690getExtendedTouchPaddingNHjbRc() {
        long j = mo701toSizeXkaWNTQ(getViewConfiguration().mo5916getMinimumTouchTargetSizeMYxV2XQ());
        long boundsSize = getBoundsSize();
        float max = Math.max(0.0f, Float.intBitsToFloat((int) (j >> 32)) - ((int) (boundsSize >> 32))) / 2.0f;
        float max2 = Math.max(0.0f, Float.intBitsToFloat((int) (j & 4294967295L)) - ((int) (boundsSize & 4294967295L))) / 2.0f;
        return Size.m4185constructorimpl((Float.floatToRawIntBits(max) << 32) | (Float.floatToRawIntBits(max2) & 4294967295L));
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public boolean getInterceptOutOfBoundsChildEvents() {
        return this.interceptOutOfBoundsChildEvents;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public void setInterceptOutOfBoundsChildEvents(boolean z) {
        this.interceptOutOfBoundsChildEvents = z;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        resetPointerInputHandler();
        super.onDetach();
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public void onDensityChange() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onViewConfigurationChange() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public void resetPointerInputHandler() {
        Job job = this.pointerInputJob;
        if (job != null) {
            job.cancel((CancellationException) new PointerInputResetException());
            this.pointerInputJob = null;
        }
    }

    public final void update$ui_release(Object key1, Object key2, Object[] keys, PointerInputEventHandler pointerInputEventHandler) {
        boolean z = !Intrinsics.areEqual(this.key1, key1);
        this.key1 = key1;
        if (!Intrinsics.areEqual(this.key2, key2)) {
            z = true;
        }
        this.key2 = key2;
        Object[] objArr = this.keys;
        if (objArr != null && keys == null) {
            z = true;
        }
        if (objArr == null && keys != null) {
            z = true;
        }
        if (objArr != null && keys != null && !Arrays.equals(keys, objArr)) {
            z = true;
        }
        this.keys = keys;
        if (get_pointerInputEventHandler().getClass() == pointerInputEventHandler.getClass() ? z : true) {
            resetPointerInputHandler();
        }
        this._pointerInputEventHandler = pointerInputEventHandler;
    }

    private final void forEachCurrentPointerHandler(PointerEventPass pass, Function1<? super PointerEventHandlerCoroutine<?>, Unit> block) {
        synchronized (this.pointerHandlersLock) {
            MutableVector<PointerEventHandlerCoroutine<?>> mutableVector = this.dispatchingPointerHandlers;
            mutableVector.addAll(mutableVector.getSize(), this.pointerHandlers);
        }
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[pass.ordinal()];
            if (i == 1 || i == 2) {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector2 = this.dispatchingPointerHandlers;
                PointerEventHandlerCoroutine<?>[] pointerEventHandlerCoroutineArr = mutableVector2.content;
                int size = mutableVector2.getSize();
                for (int i2 = 0; i2 < size; i2++) {
                    block.invoke(pointerEventHandlerCoroutineArr[i2]);
                }
            } else if (i == 3) {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector3 = this.dispatchingPointerHandlers;
                int size2 = mutableVector3.getSize() - 1;
                PointerEventHandlerCoroutine<?>[] pointerEventHandlerCoroutineArr2 = mutableVector3.content;
                if (size2 < pointerEventHandlerCoroutineArr2.length) {
                    while (size2 >= 0) {
                        block.invoke(pointerEventHandlerCoroutineArr2[size2]);
                        size2--;
                    }
                }
            }
        } finally {
            this.dispatchingPointerHandlers.clear();
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo528onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        Job launch$default;
        this.boundsSize = bounds;
        if (pass == PointerEventPass.Initial) {
            this.currentEvent = pointerEvent;
        }
        if (this.pointerInputJob == null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new SuspendingPointerInputModifierNodeImpl$onPointerEvent$1(this, null), 1, null);
            this.pointerInputJob = launch$default;
        }
        dispatchPointerEvent(pointerEvent, pass);
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!PointerEventKt.changedToUpIgnoreConsumed(changes.get(i))) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            pointerEvent = null;
        }
        this.lastPointerEvent = pointerEvent;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        PointerEvent pointerEvent = this.lastPointerEvent;
        if (pointerEvent == null) {
            return;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            if (changes.get(i).getPressed()) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                ArrayList arrayList = new ArrayList(changes2.size());
                int size2 = changes2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    PointerInputChange pointerInputChange = changes2.get(i2);
                    arrayList.add(new PointerInputChange(pointerInputChange.getId(), pointerInputChange.getUptimeMillis(), pointerInputChange.getPosition(), false, pointerInputChange.getPressure(), pointerInputChange.getUptimeMillis(), pointerInputChange.getPosition(), pointerInputChange.getPressed(), pointerInputChange.getPressed(), pointerInputChange.getType(), 0L, 1024, (DefaultConstructorMarker) null));
                }
                PointerEvent pointerEvent2 = new PointerEvent(arrayList);
                this.currentEvent = pointerEvent2;
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Initial);
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Main);
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Final);
                this.lastPointerEvent = null;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuspendingPointerInputFilter.kt */
    @Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*J\u0016\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\bJ\u001b\u0010-\u001a\u00020(2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0016¢\u0006\u0002\u00100JE\u00101\u001a\u0002H2\"\u0004\b\u0001\u001022\u0006\u00103\u001a\u0002042'\u00105\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H20\u0004\u0012\u0006\u0012\u0004\u0018\u00010706¢\u0006\u0002\b8H\u0096@¢\u0006\u0002\u00109JG\u0010:\u001a\u0004\u0018\u0001H2\"\u0004\b\u0001\u001022\u0006\u00103\u001a\u0002042'\u00105\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H20\u0004\u0012\u0006\u0012\u0004\u0018\u00010706¢\u0006\u0002\b8H\u0096@¢\u0006\u0002\u00109J\u0017\u0010;\u001a\u00020<*\u00020=H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u0017\u0010;\u001a\u00020<*\u00020@H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020=*\u00020@H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001a\u0010C\u001a\u00020=*\u00020\u0012H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001a\u0010C\u001a\u00020=*\u00020<H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010HJ\u0017\u0010I\u001a\u00020J*\u00020\u0016H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\u0012*\u00020=H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010GJ\u0017\u0010M\u001a\u00020\u0012*\u00020@H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010EJ\r\u0010P\u001a\u00020Q*\u00020RH\u0097\u0001J\u0017\u0010S\u001a\u00020\u0016*\u00020JH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010LJ\u0017\u0010U\u001a\u00020@*\u00020=H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u001a\u0010U\u001a\u00020@*\u00020\u0012H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010WJ\u001a\u0010U\u001a\u00020@*\u00020<H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010YR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0018R\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine;", "R", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/coroutines/Continuation;", "completion", "(Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;Lkotlin/coroutines/Continuation;)V", "awaitPass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "density", "", "getDensity", "()F", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "fontScale", "getFontScale", "pointerAwaiter", "Lkotlinx/coroutines/CancellableContinuation;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEvent", "pass", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "cause", "", "offerPointerEvent", NotificationCompat.CATEGORY_EVENT, "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "withTimeout", ExifInterface.GPS_DIRECTION_TRUE, "timeMillis", "", "block", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public final class PointerEventHandlerCoroutine<R> implements AwaitPointerEventScope, Density, Continuation<R> {
        private final /* synthetic */ SuspendingPointerInputModifierNodeImpl $$delegate_0;
        private final Continuation<R> completion;
        private CancellableContinuation<? super PointerEvent> pointerAwaiter;
        private PointerEventPass awaitPass = PointerEventPass.Main;
        private final CoroutineContext context = EmptyCoroutineContext.INSTANCE;

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx--R2X_6o */
        public int mo693roundToPxR2X_6o(long j) {
            return this.$$delegate_0.mo693roundToPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx-0680j_4 */
        public int mo694roundToPx0680j_4(float f) {
            return this.$$delegate_0.mo694roundToPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* renamed from: toDp-GaN1DYA */
        public float mo695toDpGaN1DYA(long j) {
            return this.$$delegate_0.mo695toDpGaN1DYA(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo696toDpu2uoSUM(float f) {
            return this.$$delegate_0.mo696toDpu2uoSUM(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo697toDpu2uoSUM(int i) {
            return this.$$delegate_0.mo697toDpu2uoSUM(i);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDpSize-k-rfVVM */
        public long mo698toDpSizekrfVVM(long j) {
            return this.$$delegate_0.mo698toDpSizekrfVVM(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx--R2X_6o */
        public float mo699toPxR2X_6o(long j) {
            return this.$$delegate_0.mo699toPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx-0680j_4 */
        public float mo700toPx0680j_4(float f) {
            return this.$$delegate_0.mo700toPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        public Rect toRect(DpRect dpRect) {
            return this.$$delegate_0.toRect(dpRect);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSize-XkaWNTQ */
        public long mo701toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.mo701toSizeXkaWNTQ(j);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* renamed from: toSp-0xMU5do */
        public long mo702toSp0xMU5do(float f) {
            return this.$$delegate_0.mo702toSp0xMU5do(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public long mo703toSpkPz2Gy4(float f) {
            return this.$$delegate_0.mo703toSpkPz2Gy4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public long mo704toSpkPz2Gy4(int i) {
            return this.$$delegate_0.mo704toSpkPz2Gy4(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PointerEventHandlerCoroutine(Continuation<? super R> continuation) {
            this.completion = continuation;
            this.$$delegate_0 = SuspendingPointerInputModifierNodeImpl.this;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public PointerEvent getCurrentEvent() {
            return SuspendingPointerInputModifierNodeImpl.this.currentEvent;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /* renamed from: getSize-YbymL2g */
        public long mo5516getSizeYbymL2g() {
            return SuspendingPointerInputModifierNodeImpl.this.boundsSize;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public ViewConfiguration getViewConfiguration() {
            return SuspendingPointerInputModifierNodeImpl.this.getViewConfiguration();
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /* renamed from: getExtendedTouchPadding-NH-jbRc */
        public long mo5515getExtendedTouchPaddingNHjbRc() {
            return SuspendingPointerInputModifierNodeImpl.this.mo690getExtendedTouchPaddingNHjbRc();
        }

        public final void offerPointerEvent(PointerEvent event, PointerEventPass pass) {
            CancellableContinuation<? super PointerEvent> cancellableContinuation;
            if (pass != this.awaitPass || (cancellableContinuation = this.pointerAwaiter) == null) {
                return;
            }
            this.pointerAwaiter = null;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m7870constructorimpl(event));
        }

        public final void cancel(Throwable cause) {
            CancellableContinuation<? super PointerEvent> cancellableContinuation = this.pointerAwaiter;
            if (cancellableContinuation != null) {
                cancellableContinuation.cancel(cause);
            }
            this.pointerAwaiter = null;
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.context;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object result) {
            Object obj = SuspendingPointerInputModifierNodeImpl.this.pointerHandlersLock;
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = SuspendingPointerInputModifierNodeImpl.this;
            synchronized (obj) {
                suspendingPointerInputModifierNodeImpl.pointerHandlers.remove(this);
                Unit unit = Unit.INSTANCE;
            }
            this.completion.resumeWith(result);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public <T> java.lang.Object withTimeoutOrNull(long r5, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super T> r8) {
            /*
                r4 = this;
                boolean r0 = r8 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1
                if (r0 == 0) goto L14
                r0 = r8
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r8 = r0.label
                int r8 = r8 - r2
                r0.label = r8
                goto L19
            L14:
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = new androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1
                r0.<init>(r4, r8)
            L19:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L32
                if (r2 != r3) goto L2a
                kotlin.ResultKt.throwOnFailure(r8)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3f
                return r8
            L2a:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L32:
                kotlin.ResultKt.throwOnFailure(r8)
                r0.label = r3     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3f
                java.lang.Object r4 = r4.withTimeout(r5, r7, r0)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3f
                if (r4 != r1) goto L3e
                return r1
            L3e:
                return r4
            L3f:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.withTimeoutOrNull(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public <T> java.lang.Object withTimeout(long r12, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r14, kotlin.coroutines.Continuation<? super T> r15) {
            /*
                r11 = this;
                boolean r0 = r15 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1
                if (r0 == 0) goto L14
                r0 = r15
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r15 = r0.label
                int r15 = r15 - r2
                r0.label = r15
                goto L19
            L14:
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 r0 = new androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1
                r0.<init>(r11, r15)
            L19:
                java.lang.Object r15 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L39
                if (r2 != r3) goto L31
                java.lang.Object r11 = r0.L$0
                kotlinx.coroutines.Job r11 = (kotlinx.coroutines.Job) r11
                kotlin.ResultKt.throwOnFailure(r15)     // Catch: java.lang.Throwable -> L2e
                goto L7f
            L2e:
                r0 = move-exception
                r12 = r0
                goto L8c
            L31:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L39:
                kotlin.ResultKt.throwOnFailure(r15)
                r4 = 0
                int r15 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
                if (r15 > 0) goto L5c
                kotlinx.coroutines.CancellableContinuation<? super androidx.compose.ui.input.pointer.PointerEvent> r15 = r11.pointerAwaiter
                if (r15 == 0) goto L5c
                kotlin.coroutines.Continuation r15 = (kotlin.coroutines.Continuation) r15
                kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
                androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException r2 = new androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException
                r2.<init>(r12)
                java.lang.Throwable r2 = (java.lang.Throwable) r2
                java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)
                java.lang.Object r2 = kotlin.Result.m7870constructorimpl(r2)
                r15.resumeWith(r2)
            L5c:
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl r15 = androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.this
                kotlinx.coroutines.CoroutineScope r4 = r15.getCoroutineScope()
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1 r15 = new androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1
                r2 = 0
                r15.<init>(r12, r11, r2)
                r7 = r15
                kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
                r8 = 3
                r9 = 0
                r5 = 0
                r6 = 0
                kotlinx.coroutines.Job r12 = kotlinx.coroutines.BuildersKt.launch$default(r4, r5, r6, r7, r8, r9)
                r0.L$0 = r12     // Catch: java.lang.Throwable -> L87
                r0.label = r3     // Catch: java.lang.Throwable -> L87
                java.lang.Object r15 = r14.invoke(r11, r0)     // Catch: java.lang.Throwable -> L87
                if (r15 != r1) goto L7e
                return r1
            L7e:
                r11 = r12
            L7f:
                androidx.compose.ui.input.pointer.CancelTimeoutCancellationException r12 = androidx.compose.ui.input.pointer.CancelTimeoutCancellationException.INSTANCE
                java.util.concurrent.CancellationException r12 = (java.util.concurrent.CancellationException) r12
                r11.cancel(r12)
                return r15
            L87:
                r0 = move-exception
                r11 = r0
                r10 = r12
                r12 = r11
                r11 = r10
            L8c:
                androidx.compose.ui.input.pointer.CancelTimeoutCancellationException r13 = androidx.compose.ui.input.pointer.CancelTimeoutCancellationException.INSTANCE
                java.util.concurrent.CancellationException r13 = (java.util.concurrent.CancellationException) r13
                r11.cancel(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.withTimeout(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public Object awaitPointerEvent(PointerEventPass pointerEventPass, Continuation<? super PointerEvent> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.awaitPass = pointerEventPass;
            this.pointerAwaiter = cancellableContinuationImpl;
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }
    }

    private final void dispatchPointerEvent(PointerEvent pointerEvent, PointerEventPass pass) {
        synchronized (this.pointerHandlersLock) {
            MutableVector<PointerEventHandlerCoroutine<?>> mutableVector = this.dispatchingPointerHandlers;
            mutableVector.addAll(mutableVector.getSize(), this.pointerHandlers);
        }
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[pass.ordinal()];
            if (i == 1 || i == 2) {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector2 = this.dispatchingPointerHandlers;
                PointerEventHandlerCoroutine<?>[] pointerEventHandlerCoroutineArr = mutableVector2.content;
                int size = mutableVector2.getSize();
                for (int i2 = 0; i2 < size; i2++) {
                    pointerEventHandlerCoroutineArr[i2].offerPointerEvent(pointerEvent, pass);
                }
            } else if (i == 3) {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector3 = this.dispatchingPointerHandlers;
                int size2 = mutableVector3.getSize() - 1;
                PointerEventHandlerCoroutine<?>[] pointerEventHandlerCoroutineArr2 = mutableVector3.content;
                if (size2 < pointerEventHandlerCoroutineArr2.length) {
                    while (size2 >= 0) {
                        pointerEventHandlerCoroutineArr2[size2].offerPointerEvent(pointerEvent, pass);
                        size2--;
                    }
                }
            }
        } finally {
            this.dispatchingPointerHandlers.clear();
        }
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public <R> Object awaitPointerEventScope(Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final PointerEventHandlerCoroutine pointerEventHandlerCoroutine = new PointerEventHandlerCoroutine(cancellableContinuationImpl2);
        synchronized (this.pointerHandlersLock) {
            this.pointerHandlers.add(pointerEventHandlerCoroutine);
            Continuation<Unit> createCoroutine = ContinuationKt.createCoroutine(function2, pointerEventHandlerCoroutine, pointerEventHandlerCoroutine);
            Result.Companion companion = Result.INSTANCE;
            createCoroutine.resumeWith(Result.m7870constructorimpl(Unit.INSTANCE));
            Unit unit = Unit.INSTANCE;
        }
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$awaitPointerEventScope$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                pointerEventHandlerCoroutine.cancel(th);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
