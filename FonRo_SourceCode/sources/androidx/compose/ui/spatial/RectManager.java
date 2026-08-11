package androidx.compose.ui.spatial;

import android.os.Trace;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_androidKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: RectManager.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u000bJ8\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001dH\u0002J*\u0010(\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0006\u0010.\u001a\u00020\u000bJ\u000e\u0010/\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0004J\u001d\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u001dH\u0000¢\u0006\u0002\b3J\u000e\u00104\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0004J(\u00105\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b6\u0010,J\u0016\u00107\u001a\u0004\u0018\u00010\u00012\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ:\u00109\u001a\u00020:2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0=J:\u0010>\u001a\u00020:2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0=J\u000e\u0010?\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0004J\u000e\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000fJ\u0010\u0010B\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010\u0001J(\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020Hø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u0014\u0010K\u001a\u00020\u000b*\u00020L2\u0006\u0010M\u001a\u00020\u0007H\u0002J\u0019\u0010N\u001a\u00020**\u00020\u0004H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u0019\u0010Q\u001a\u00020**\u00020LH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bR\u0010SR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006T"}, d2 = {"Landroidx/compose/ui/spatial/RectManager;", "", "layoutNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/collection/IntObjectMap;)V", "cachedRect", "Landroidx/compose/ui/geometry/MutableRect;", "callbacks", "Landroidx/collection/MutableObjectList;", "Lkotlin/Function0;", "", "dispatchLambda", "dispatchToken", "isDirty", "", "isFragmented", "isScreenOrWindowDirty", "rects", "Landroidx/compose/ui/spatial/RectList;", "getRects", "()Landroidx/compose/ui/spatial/RectList;", "scheduledDispatchDeadline", "", "throttledCallbacks", "Landroidx/compose/ui/spatial/ThrottledCallbacks;", "currentRectInfo", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "id", "", "node", "Landroidx/compose/ui/node/DelegatableNode;", "dispatchCallbacks", "insertOrUpdate", "layoutNode", "firstPlacement", "l", "t", "r", "b", "insertOrUpdateTransformedNode", "position", "Landroidx/compose/ui/unit/IntOffset;", "insertOrUpdateTransformedNode-70tqf50", "(Landroidx/compose/ui/node/LayoutNode;JZ)V", "insertOrUpdateTransformedNodeSubhierarchy", "invalidate", "invalidateCallbacksFor", "isTargetDrawnFirst", "targetId", "otherId", "isTargetDrawnFirst$ui_release", "onLayoutLayerPositionalPropertiesChanged", "onLayoutPositionChanged", "onLayoutPositionChanged-70tqf50", "registerOnChangedCallback", "callback", "registerOnGlobalLayoutCallback", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "throttleMillis", "debounceMillis", "Lkotlin/Function1;", "registerOnRectChangedCallback", "remove", "scheduleDebounceCallback", "ensureSomethingScheduled", "unregisterOnChangedCallback", "token", "updateOffsets", "screenOffset", "windowOffset", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "updateOffsets-ucfNpQE", "(JJ[F)V", "boundingRectInRoot", "Landroidx/compose/ui/node/NodeCoordinator;", "rect", "outerToInnerOffset", "outerToInnerOffset-Bjo55l4", "(Landroidx/compose/ui/node/LayoutNode;)J", "positionInRoot", "positionInRoot-Bjo55l4", "(Landroidx/compose/ui/node/NodeCoordinator;)J", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class RectManager {
    public static final int $stable = 8;
    private final MutableRect cachedRect;
    private final MutableObjectList<Function0<Unit>> callbacks;
    private final Function0<Unit> dispatchLambda;
    private Object dispatchToken;
    private boolean isDirty;
    private boolean isFragmented;
    private boolean isScreenOrWindowDirty;
    private final IntObjectMap<LayoutNode> layoutNodes;
    private final RectList rects;
    private long scheduledDispatchDeadline;
    private final ThrottledCallbacks throttledCallbacks;

    /* JADX WARN: Multi-variable type inference failed */
    public RectManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public RectManager(IntObjectMap<LayoutNode> intObjectMap) {
        this.layoutNodes = intObjectMap;
        this.rects = new RectList();
        this.throttledCallbacks = new ThrottledCallbacks();
        this.callbacks = new MutableObjectList<>(0, 1, null);
        this.scheduledDispatchDeadline = -1L;
        this.dispatchLambda = new Function0<Unit>() { // from class: androidx.compose.ui.spatial.RectManager$dispatchLambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                RectManager.this.dispatchToken = null;
                RectManager rectManager = RectManager.this;
                Trace.beginSection("OnPositionedDispatch");
                try {
                    rectManager.dispatchCallbacks();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.endSection();
                }
            }
        };
        this.cachedRect = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public /* synthetic */ RectManager(IntObjectMap intObjectMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? IntObjectMapKt.intObjectMapOf() : intObjectMap);
    }

    public final RectList getRects() {
        return this.rects;
    }

    public final void invalidate() {
        this.isDirty = true;
    }

    /* renamed from: updateOffsets-ucfNpQE, reason: not valid java name */
    public final void m6224updateOffsetsucfNpQE(long screenOffset, long windowOffset, float[] viewToWindowMatrix) {
        int m6227analyzeComponents58bKbWc;
        m6227analyzeComponents58bKbWc = RectManagerKt.m6227analyzeComponents58bKbWc(viewToWindowMatrix);
        ThrottledCallbacks throttledCallbacks = this.throttledCallbacks;
        if ((m6227analyzeComponents58bKbWc & 2) != 0) {
            viewToWindowMatrix = null;
        }
        this.isScreenOrWindowDirty = throttledCallbacks.m6240updateOffsetsbT0EZQs(screenOffset, windowOffset, viewToWindowMatrix) || this.isScreenOrWindowDirty;
    }

    public final void dispatchCallbacks() {
        long currentTimeMillis = Actual_androidKt.currentTimeMillis();
        boolean z = this.isDirty;
        boolean z2 = z || this.isScreenOrWindowDirty;
        if (z) {
            this.isDirty = false;
            MutableObjectList<Function0<Unit>> mutableObjectList = this.callbacks;
            Object[] objArr = mutableObjectList.content;
            int i = mutableObjectList._size;
            for (int i2 = 0; i2 < i; i2++) {
                ((Function0) objArr[i2]).invoke();
            }
            RectList rectList = this.rects;
            long[] jArr = rectList.items;
            int i3 = rectList.itemsSize;
            for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
                long j = jArr[i4 + 2];
                if ((((int) (j >> 61)) & 1) != 0) {
                    this.throttledCallbacks.fireOnUpdatedRect(67108863 & ((int) j), jArr[i4], jArr[i4 + 1], currentTimeMillis);
                }
            }
            this.rects.clearUpdated();
        }
        if (this.isScreenOrWindowDirty) {
            this.isScreenOrWindowDirty = false;
            this.throttledCallbacks.fireOnRectChangedEntries(currentTimeMillis);
        }
        if (z2) {
            this.throttledCallbacks.fireGlobalChangeEntries(currentTimeMillis);
        }
        if (this.isFragmented) {
            this.isFragmented = false;
            this.rects.defragment();
        }
        this.throttledCallbacks.triggerDebounced(currentTimeMillis);
    }

    public final void scheduleDebounceCallback(boolean ensureSomethingScheduled) {
        boolean z = (ensureSomethingScheduled && this.dispatchToken == null) ? false : true;
        long minDebounceDeadline = this.throttledCallbacks.getMinDebounceDeadline();
        if (minDebounceDeadline >= 0 || !z) {
            if (this.scheduledDispatchDeadline == minDebounceDeadline && z) {
                return;
            }
            Object obj = this.dispatchToken;
            if (obj != null) {
                Actual_androidKt.removePost(obj);
            }
            long currentTimeMillis = Actual_androidKt.currentTimeMillis();
            long max = Math.max(minDebounceDeadline, 16 + currentTimeMillis);
            this.scheduledDispatchDeadline = max;
            this.dispatchToken = Actual_androidKt.postDelayed(max - currentTimeMillis, this.dispatchLambda);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RelativeLayoutBounds currentRectInfo(int id, final DelegatableNode node) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        this.rects.withRect(id, new Function4<Integer, Integer, Integer, Integer, Unit>() { // from class: androidx.compose.ui.spatial.RectManager$currentRectInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, Integer num3, Integer num4) {
                invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r11v3, types: [androidx.compose.ui.spatial.RelativeLayoutBounds, T] */
            public final void invoke(int i, int i2, int i3, int i4) {
                ThrottledCallbacks throttledCallbacks;
                ThrottledCallbacks throttledCallbacks2;
                ThrottledCallbacks throttledCallbacks3;
                throttledCallbacks = this.throttledCallbacks;
                long windowOffset = throttledCallbacks.getWindowOffset();
                throttledCallbacks2 = this.throttledCallbacks;
                long screenOffset = throttledCallbacks2.getScreenOffset();
                throttledCallbacks3 = this.throttledCallbacks;
                objectRef.element = ThrottledCallbacksKt.m6242rectInfoForQMZNJw(node, (i << 32) | (i2 & 4294967295L), (i3 << 32) | (i4 & 4294967295L), windowOffset, screenOffset, throttledCallbacks3.getViewToWindowMatrix());
            }
        });
        return (RelativeLayoutBounds) objectRef.element;
    }

    public final Object registerOnChangedCallback(Function0<Unit> callback) {
        this.callbacks.add(callback);
        return callback;
    }

    public final DelegatableNode.RegistrationHandle registerOnRectChangedCallback(int id, long throttleMillis, long debounceMillis, DelegatableNode node, Function1<? super RelativeLayoutBounds, Unit> callback) {
        return this.throttledCallbacks.registerOnRectChanged(id, throttleMillis, debounceMillis, node, callback);
    }

    public final DelegatableNode.RegistrationHandle registerOnGlobalLayoutCallback(int id, long throttleMillis, long debounceMillis, DelegatableNode node, Function1<? super RelativeLayoutBounds, Unit> callback) {
        return this.throttledCallbacks.registerOnGlobalChange(id, throttleMillis, debounceMillis, node, callback);
    }

    public final void unregisterOnChangedCallback(Object token) {
        if ((TypeIntrinsics.isFunctionOfArity(token, 0) ? (Function0) token : null) == null) {
            return;
        }
        this.callbacks.remove(token);
    }

    public final void invalidateCallbacksFor(LayoutNode layoutNode) {
        this.isDirty = true;
        this.rects.markUpdated(layoutNode.getSemanticsId());
        scheduleDebounceCallback(true);
    }

    public final void onLayoutLayerPositionalPropertiesChanged(LayoutNode layoutNode) {
        boolean m6228isSetgyyYBs;
        if (ComposeUiFlags.isRectTrackingEnabled) {
            long m6221outerToInnerOffsetBjo55l4 = m6221outerToInnerOffsetBjo55l4(layoutNode);
            m6228isSetgyyYBs = RectManagerKt.m6228isSetgyyYBs(m6221outerToInnerOffsetBjo55l4);
            if (m6228isSetgyyYBs) {
                layoutNode.m5915setOuterToInnerOffsetgyyYBs$ui_release(m6221outerToInnerOffsetBjo55l4);
                layoutNode.setOuterToInnerOffsetDirty$ui_release(false);
                MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int size = mutableVector.getSize();
                for (int i = 0; i < size; i++) {
                    LayoutNode layoutNode2 = layoutNodeArr[i];
                    m6223onLayoutPositionChanged70tqf50(layoutNode2, layoutNode2.getOuterCoordinator$ui_release().getPosition(), false);
                }
                invalidateCallbacksFor(layoutNode);
                return;
            }
            insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
        }
    }

    /* renamed from: onLayoutPositionChanged-70tqf50, reason: not valid java name */
    public final void m6223onLayoutPositionChanged70tqf50(LayoutNode layoutNode, long position, boolean firstPlacement) {
        long j;
        long j2;
        boolean m6228isSetgyyYBs;
        boolean m6228isSetgyyYBs2;
        long j3;
        boolean m6228isSetgyyYBs3;
        if (ComposeUiFlags.isRectTrackingEnabled) {
            MeasurePassDelegate measurePassDelegate$ui_release = layoutNode.getMeasurePassDelegate$ui_release();
            int measuredWidth = measurePassDelegate$ui_release.getMeasuredWidth();
            int measuredHeight = measurePassDelegate$ui_release.getMeasuredHeight();
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            long offsetFromRoot = layoutNode.getOffsetFromRoot();
            long lastSize = layoutNode.getLastSize();
            int i = (int) (lastSize >> 32);
            int i2 = (int) (lastSize & 4294967295L);
            boolean z = false;
            if (parent$ui_release != null) {
                boolean outerToInnerOffsetDirty = parent$ui_release.getOuterToInnerOffsetDirty();
                long offsetFromRoot2 = parent$ui_release.getOffsetFromRoot();
                long outerToInnerOffset = parent$ui_release.getOuterToInnerOffset();
                m6228isSetgyyYBs2 = RectManagerKt.m6228isSetgyyYBs(offsetFromRoot2);
                if (m6228isSetgyyYBs2) {
                    if (outerToInnerOffsetDirty) {
                        j = 4294967295L;
                        j3 = m6221outerToInnerOffsetBjo55l4(parent$ui_release);
                        parent$ui_release.m5915setOuterToInnerOffsetgyyYBs$ui_release(j3);
                        parent$ui_release.setOuterToInnerOffsetDirty$ui_release(false);
                    } else {
                        j = 4294967295L;
                        j3 = outerToInnerOffset;
                    }
                    m6228isSetgyyYBs3 = RectManagerKt.m6228isSetgyyYBs(j3);
                    j2 = IntOffset.m7121plusqkQi6aY(IntOffset.m7121plusqkQi6aY(offsetFromRoot2, j3), position);
                    z = !m6228isSetgyyYBs3;
                } else {
                    j = 4294967295L;
                    j2 = m6222positionInRootBjo55l4(layoutNode.getOuterCoordinator$ui_release());
                }
            } else {
                j = 4294967295L;
                j2 = position;
            }
            if (!z) {
                m6228isSetgyyYBs = RectManagerKt.m6228isSetgyyYBs(j2);
                if (m6228isSetgyyYBs) {
                    layoutNode.m5914setOffsetFromRootgyyYBs$ui_release(j2);
                    layoutNode.m5913setLastSizeozmzZPI$ui_release(IntSize.m7155constructorimpl((measuredWidth << 32) | (measuredHeight & j)));
                    int m7117getXimpl = IntOffset.m7117getXimpl(j2);
                    int m7118getYimpl = IntOffset.m7118getYimpl(j2);
                    int i3 = m7117getXimpl + measuredWidth;
                    int i4 = m7118getYimpl + measuredHeight;
                    if (!firstPlacement && IntOffset.m7116equalsimpl0(j2, offsetFromRoot) && i == measuredWidth && i2 == measuredHeight) {
                        return;
                    }
                    insertOrUpdate(layoutNode, firstPlacement, m7117getXimpl, m7118getYimpl, i3, i4);
                    return;
                }
            }
            m6220insertOrUpdateTransformedNode70tqf50(layoutNode, position, firstPlacement);
        }
    }

    /* renamed from: insertOrUpdateTransformedNode-70tqf50, reason: not valid java name */
    private final void m6220insertOrUpdateTransformedNode70tqf50(LayoutNode layoutNode, long position, boolean firstPlacement) {
        NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release();
        MeasurePassDelegate measurePassDelegate$ui_release = layoutNode.getMeasurePassDelegate$ui_release();
        int measuredWidth = measurePassDelegate$ui_release.getMeasuredWidth();
        int measuredHeight = measurePassDelegate$ui_release.getMeasuredHeight();
        MutableRect mutableRect = this.cachedRect;
        mutableRect.set(IntOffset.m7117getXimpl(position), IntOffset.m7118getYimpl(position), IntOffset.m7117getXimpl(position) + measuredWidth, IntOffset.m7118getYimpl(position) + measuredHeight);
        boundingRectInRoot(outerCoordinator$ui_release, mutableRect);
        int left = (int) mutableRect.getLeft();
        int top = (int) mutableRect.getTop();
        int right = (int) mutableRect.getRight();
        int bottom = (int) mutableRect.getBottom();
        int semanticsId = layoutNode.getSemanticsId();
        if (firstPlacement || !this.rects.update(semanticsId, left, top, right, bottom)) {
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            RectList.insert$default(this.rects, semanticsId, left, top, right, bottom, parent$ui_release != null ? parent$ui_release.getSemanticsId() : -1, false, false, 192, null);
        }
        invalidate();
    }

    private final void insertOrUpdate(LayoutNode layoutNode, boolean firstPlacement, int l, int t, int r, int b) {
        int semanticsId = layoutNode.getSemanticsId();
        if (firstPlacement || !this.rects.move(semanticsId, l, t, r, b)) {
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            RectList.insert$default(this.rects, semanticsId, l, t, r, b, parent$ui_release != null ? parent$ui_release.getSemanticsId() : -1, false, false, 192, null);
        }
        invalidate();
    }

    /* renamed from: positionInRoot-Bjo55l4, reason: not valid java name */
    private final long m6222positionInRootBjo55l4(NodeCoordinator nodeCoordinator) {
        int m6227analyzeComponents58bKbWc;
        long m4141getZeroF1C5BW0 = Offset.INSTANCE.m4141getZeroF1C5BW0();
        while (nodeCoordinator != null) {
            OwnedLayer layer = nodeCoordinator.getLayer();
            m4141getZeroF1C5BW0 = IntOffsetKt.m7132plusNvtHpc(m4141getZeroF1C5BW0, nodeCoordinator.getPosition());
            nodeCoordinator = nodeCoordinator.getWrappedBy();
            if (layer != null) {
                float[] mo6045getUnderlyingMatrixsQKQjiQ = layer.mo6045getUnderlyingMatrixsQKQjiQ();
                m6227analyzeComponents58bKbWc = RectManagerKt.m6227analyzeComponents58bKbWc(mo6045getUnderlyingMatrixsQKQjiQ);
                if (m6227analyzeComponents58bKbWc == 3) {
                    continue;
                } else {
                    if ((m6227analyzeComponents58bKbWc & 2) == 0) {
                        return IntOffset.INSTANCE.m7127getMaxnOccac();
                    }
                    m4141getZeroF1C5BW0 = Matrix.m4620mapMKHz9U(mo6045getUnderlyingMatrixsQKQjiQ, m4141getZeroF1C5BW0);
                }
            }
        }
        return IntOffsetKt.m7134roundk4lQ0M(m4141getZeroF1C5BW0);
    }

    private final void boundingRectInRoot(NodeCoordinator nodeCoordinator, MutableRect mutableRect) {
        while (nodeCoordinator != null) {
            OwnedLayer layer = nodeCoordinator.getLayer();
            long position = nodeCoordinator.getPosition();
            float m7117getXimpl = IntOffset.m7117getXimpl(position);
            float m7118getYimpl = IntOffset.m7118getYimpl(position);
            mutableRect.m4110translatek4lQ0M(Offset.m4117constructorimpl((Float.floatToRawIntBits(m7117getXimpl) << 32) | (Float.floatToRawIntBits(m7118getYimpl) & 4294967295L)));
            nodeCoordinator = nodeCoordinator.getWrappedBy();
            if (layer != null) {
                float[] mo6045getUnderlyingMatrixsQKQjiQ = layer.mo6045getUnderlyingMatrixsQKQjiQ();
                if (!MatrixKt.m4639isIdentity58bKbWc(mo6045getUnderlyingMatrixsQKQjiQ)) {
                    Matrix.m4622mapimpl(mo6045getUnderlyingMatrixsQKQjiQ, mutableRect);
                }
            }
        }
    }

    /* renamed from: outerToInnerOffset-Bjo55l4, reason: not valid java name */
    private final long m6221outerToInnerOffsetBjo55l4(LayoutNode layoutNode) {
        int m6227analyzeComponents58bKbWc;
        NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release();
        long m4141getZeroF1C5BW0 = Offset.INSTANCE.m4141getZeroF1C5BW0();
        NodeCoordinator innerCoordinator$ui_release = layoutNode.getInnerCoordinator$ui_release();
        while (innerCoordinator$ui_release != null && innerCoordinator$ui_release != outerCoordinator$ui_release) {
            OwnedLayer layer = innerCoordinator$ui_release.getLayer();
            m4141getZeroF1C5BW0 = IntOffsetKt.m7132plusNvtHpc(m4141getZeroF1C5BW0, innerCoordinator$ui_release.getPosition());
            innerCoordinator$ui_release = innerCoordinator$ui_release.getWrappedBy();
            if (layer != null) {
                float[] mo6045getUnderlyingMatrixsQKQjiQ = layer.mo6045getUnderlyingMatrixsQKQjiQ();
                m6227analyzeComponents58bKbWc = RectManagerKt.m6227analyzeComponents58bKbWc(mo6045getUnderlyingMatrixsQKQjiQ);
                if (m6227analyzeComponents58bKbWc == 3) {
                    continue;
                } else {
                    if ((m6227analyzeComponents58bKbWc & 2) == 0) {
                        return IntOffset.INSTANCE.m7127getMaxnOccac();
                    }
                    m4141getZeroF1C5BW0 = Matrix.m4620mapMKHz9U(mo6045getUnderlyingMatrixsQKQjiQ, m4141getZeroF1C5BW0);
                }
            }
        }
        return IntOffsetKt.m7134roundk4lQ0M(m4141getZeroF1C5BW0);
    }

    public final void remove(LayoutNode layoutNode) {
        this.rects.remove(layoutNode.getSemanticsId());
        invalidate();
        this.isFragmented = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        if (r3.getDepth() == 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        if (r4.getDepth() <= r3.getDepth()) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        r4 = r4.getParent$ui_release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        if (r4 != null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        if (r4 != r3) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        if (r3.getDepth() <= r4.getDepth()) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        r3 = r3.getParent$ui_release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        if (r3 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004a, code lost:
    
        if (r4 != r3) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004d, code lost:
    
        r5 = r4;
        r1 = r5;
        r4 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:
    
        if (r5 == r3) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0052, code lost:
    
        r4 = r5.getParent$ui_release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0056, code lost:
    
        if (r4 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0059, code lost:
    
        r1 = r3.getParent$ui_release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005d, code lost:
    
        if (r1 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0060, code lost:
    
        r4 = r3;
        r3 = r1;
        r1 = r5;
        r5 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0058, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0079, code lost:
    
        if (r1.getMeasurePassDelegate$ui_release().getZIndex$ui_release() != r4.getMeasurePassDelegate$ui_release().getZIndex$ui_release()) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0083, code lost:
    
        if (r1.getPlaceOrder$ui_release() >= r4.getPlaceOrder$ui_release()) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0085, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0086, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0099, code lost:
    
        if (r1.getMeasurePassDelegate$ui_release().getZIndex$ui_release() >= r4.getMeasurePassDelegate$ui_release().getZIndex$ui_release()) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009b, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isTargetDrawnFirst$ui_release(int r4, int r5) {
        /*
            r3 = this;
            androidx.collection.IntObjectMap<androidx.compose.ui.node.LayoutNode> r0 = r3.layoutNodes
            java.lang.Object r4 = r0.get(r4)
            androidx.compose.ui.node.LayoutNode r4 = (androidx.compose.ui.node.LayoutNode) r4
            r0 = 0
            if (r4 != 0) goto Lc
            return r0
        Lc:
            androidx.collection.IntObjectMap<androidx.compose.ui.node.LayoutNode> r3 = r3.layoutNodes
            java.lang.Object r3 = r3.get(r5)
            androidx.compose.ui.node.LayoutNode r3 = (androidx.compose.ui.node.LayoutNode) r3
            if (r3 != 0) goto L17
            return r0
        L17:
            int r5 = r4.getDepth()
            if (r5 == 0) goto L9c
            int r5 = r3.getDepth()
            if (r5 != 0) goto L25
            goto L9c
        L25:
            int r5 = r4.getDepth()
            int r1 = r3.getDepth()
            if (r5 <= r1) goto L36
            androidx.compose.ui.node.LayoutNode r4 = r4.getParent$ui_release()
            if (r4 != 0) goto L25
            return r0
        L36:
            if (r4 != r3) goto L39
            return r0
        L39:
            int r5 = r3.getDepth()
            int r1 = r4.getDepth()
            if (r5 <= r1) goto L4a
            androidx.compose.ui.node.LayoutNode r3 = r3.getParent$ui_release()
            if (r3 != 0) goto L39
            return r0
        L4a:
            if (r4 != r3) goto L4d
            return r0
        L4d:
            r5 = r4
            r1 = r5
            r4 = r3
        L50:
            if (r5 == r3) goto L66
            androidx.compose.ui.node.LayoutNode r4 = r5.getParent$ui_release()
            if (r4 != 0) goto L59
            return r0
        L59:
            androidx.compose.ui.node.LayoutNode r1 = r3.getParent$ui_release()
            if (r1 != 0) goto L60
            return r0
        L60:
            r2 = r4
            r4 = r3
            r3 = r1
            r1 = r5
            r5 = r2
            goto L50
        L66:
            androidx.compose.ui.node.MeasurePassDelegate r3 = r1.getMeasurePassDelegate$ui_release()
            float r3 = r3.getZIndex()
            androidx.compose.ui.node.MeasurePassDelegate r5 = r4.getMeasurePassDelegate$ui_release()
            float r5 = r5.getZIndex()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r5 = 1
            if (r3 != 0) goto L87
            int r3 = r1.getPlaceOrder$ui_release()
            int r4 = r4.getPlaceOrder$ui_release()
            if (r3 >= r4) goto L86
            return r5
        L86:
            return r0
        L87:
            androidx.compose.ui.node.MeasurePassDelegate r3 = r1.getMeasurePassDelegate$ui_release()
            float r3 = r3.getZIndex()
            androidx.compose.ui.node.MeasurePassDelegate r4 = r4.getMeasurePassDelegate$ui_release()
            float r4 = r4.getZIndex()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L9c
            return r5
        L9c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.spatial.RectManager.isTargetDrawnFirst$ui_release(int, int):boolean");
    }

    private final void insertOrUpdateTransformedNodeSubhierarchy(LayoutNode layoutNode) {
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            m6220insertOrUpdateTransformedNode70tqf50(layoutNode2, layoutNode2.getOuterCoordinator$ui_release().getPosition(), false);
            insertOrUpdateTransformedNodeSubhierarchy(layoutNode2);
        }
    }
}
