package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LookaheadPassDelegate.kt */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b?\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002³\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010s\u001a\u000e\u0012\u0004\u0012\u00020u\u0012\u0004\u0012\u00020W0tH\u0016J\b\u0010v\u001a\u00020-H\u0002J\b\u0010w\u001a\u00020-H\u0002J\u001c\u0010x\u001a\u00020-2\u0012\u0010y\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020-0+H\u0016J\u001d\u0010z\u001a\u00020-2\u0012\u0010y\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020-0+H\u0082\bJ\u0011\u0010{\u001a\u00020W2\u0006\u0010|\u001a\u00020uH\u0096\u0002J\u000e\u0010}\u001a\u00020-2\u0006\u0010~\u001a\u00020\u0015J\u0006\u0010\u007f\u001a\u00020-J\t\u0010\u0080\u0001\u001a\u00020-H\u0016J\u000f\u0010\u0081\u0001\u001a\u00020-H\u0000¢\u0006\u0003\b\u0082\u0001J\u000f\u0010\u0083\u0001\u001a\u00020-H\u0000¢\u0006\u0003\b\u0084\u0001J\u0018\u0010\u0085\u0001\u001a\u00020-2\u0007\u0010\u0086\u0001\u001a\u00020\u0015H\u0000¢\u0006\u0003\b\u0087\u0001J\t\u0010\u0088\u0001\u001a\u00020-H\u0002J\u0012\u0010\u0089\u0001\u001a\u00020W2\u0007\u0010\u008a\u0001\u001a\u00020WH\u0016J\u0012\u0010\u008b\u0001\u001a\u00020W2\u0007\u0010\u008c\u0001\u001a\u00020WH\u0016J\u001e\u0010\u008d\u0001\u001a\u00020\u00012\u0007\u0010\u008e\u0001\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0012\u0010\u0091\u0001\u001a\u00020W2\u0007\u0010\u008a\u0001\u001a\u00020WH\u0016J\u0012\u0010\u0092\u0001\u001a\u00020W2\u0007\u0010\u008c\u0001\u001a\u00020WH\u0016J\u0007\u0010\u0093\u0001\u001a\u00020-J\u0007\u0010\u0094\u0001\u001a\u00020-J\t\u0010\u0095\u0001\u001a\u00020-H\u0002J\t\u0010\u0096\u0001\u001a\u00020-H\u0002J\u0007\u0010\u0097\u0001\u001a\u00020-J\u000f\u0010\u0098\u0001\u001a\u00020-H\u0000¢\u0006\u0003\b\u0099\u0001J\u001e\u0010\u009a\u0001\u001a\u00020-2\u0007\u0010\u008e\u0001\u001a\u00020%H\u0000ø\u0001\u0000¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001JC\u0010\u009d\u0001\u001a\u00020-2\u0007\u0010\u009e\u0001\u001a\u0002002\u0007\u0010\u009f\u0001\u001a\u0002032\u001a\u0010 \u0001\u001a\u0015\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-\u0018\u00010+¢\u0006\u0002\b.H\u0014ø\u0001\u0000¢\u0006\u0006\b¡\u0001\u0010¢\u0001J0\u0010\u009d\u0001\u001a\u00020-2\u0007\u0010\u009e\u0001\u001a\u0002002\u0007\u0010\u009f\u0001\u001a\u0002032\u0007\u0010£\u0001\u001a\u00020)H\u0014ø\u0001\u0000¢\u0006\u0006\b¡\u0001\u0010¤\u0001JN\u0010¥\u0001\u001a\u00020-2\u0007\u0010\u009e\u0001\u001a\u0002002\u0007\u0010\u009f\u0001\u001a\u0002032\u001a\u0010 \u0001\u001a\u0015\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-\u0018\u00010+¢\u0006\u0002\b.2\t\u0010£\u0001\u001a\u0004\u0018\u00010)H\u0002ø\u0001\u0000¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u001c\u0010¨\u0001\u001a\u00020\u00152\u0007\u0010\u008e\u0001\u001a\u00020%ø\u0001\u0000¢\u0006\u0006\b©\u0001\u0010ª\u0001J\u0007\u0010«\u0001\u001a\u00020-J\t\u0010¬\u0001\u001a\u00020-H\u0016J\t\u0010\u00ad\u0001\u001a\u00020-H\u0016J\u0012\u0010®\u0001\u001a\u00020-2\u0007\u0010¯\u0001\u001a\u000208H\u0002J\u0007\u0010°\u0001\u001a\u00020\u0015J\u0012\u0010±\u0001\u001a\u00020-2\u0007\u0010²\u0001\u001a\u00020\u0015H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0017R\u001a\u0010\"\u001a\u00020\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u0019\u0010$\u001a\u0004\u0018\u00010%8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010*\u001a\u0015\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-\u0018\u00010+¢\u0006\u0002\b.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\u000200X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00101R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00105\u001a\u00020\u00152\u0006\u00104\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0017R\u0014\u00107\u001a\u0002088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010<\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u00158B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b=\u0010\u0017\"\u0004\b>\u0010\u0019R$\u0010?\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u00158B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b@\u0010\u0017\"\u0004\bA\u0010\u0019R$\u0010C\u001a\u00020B2\u0006\u0010;\u001a\u00020B8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0016\u0010H\u001a\u0004\u0018\u00010%X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\u00020J8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR$\u0010M\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u00158B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bN\u0010\u0017\"\u0004\bO\u0010\u0019R\u001a\u0010P\u001a\u00020QX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010V\u001a\u00020W8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u000e\u0010Z\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010[\u001a\u00020W8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010YR\u0011\u0010]\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b^\u0010\u0017R\u000e\u0010_\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010`\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\ba\u0010 R\u0016\u0010b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010dR\"\u0010f\u001a\u0004\u0018\u00010e2\b\u00104\u001a\u0004\u0018\u00010e@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u000e\u0010i\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010j\u001a\u00020WX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010Y\"\u0004\bl\u0010mR\u001a\u0010n\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0017\"\u0004\bp\u0010\u0019R\u000e\u0010q\u001a\u00020WX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006´\u0001"}, d2 = {"Landroidx/compose/ui/node/LookaheadPassDelegate;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "layoutNodeLayoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", "_childDelegates", "Landroidx/compose/runtime/collection/MutableVector;", "_placedState", "Landroidx/compose/ui/node/LookaheadPassDelegate$PlacedState;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "childDelegates", "", "getChildDelegates$ui_release", "()Ljava/util/List;", "childDelegatesDirty", "", "getChildDelegatesDirty$ui_release", "()Z", "setChildDelegatesDirty$ui_release", "(Z)V", "detachedFromParentLookaheadPlacement", "getDetachedFromParentLookaheadPlacement", "duringAlignmentLinesQuery", "innerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "isPlaced", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastExplicitLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "lastLayerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "lastPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "lastZIndex", "", "<set-?>", "layingOutChildren", "getLayingOutChildren", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "value", "layoutPending", "getLayoutPending", "setLayoutPending", "layoutPendingForAlignment", "getLayoutPendingForAlignment", "setLayoutPendingForAlignment", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "layoutState", "getLayoutState", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "setLayoutState", "(Landroidx/compose/ui/node/LayoutNode$LayoutState;)V", "lookaheadConstraints", "measurePassDelegate", "Landroidx/compose/ui/node/MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/MeasurePassDelegate;", "measurePending", "getMeasurePending", "setMeasurePending", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setMeasuredByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "measuredHeight", "", "getMeasuredHeight", "()I", "measuredOnce", "measuredWidth", "getMeasuredWidth", "needsToBePlacedInApproach", "getNeedsToBePlacedInApproach", "onNodePlacedCalled", "outerCoordinator", "getOuterCoordinator", "parentAlignmentLinesOwner", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "", "parentData", "getParentData", "()Ljava/lang/Object;", "parentDataDirty", "placeOrder", "getPlaceOrder$ui_release", "setPlaceOrder$ui_release", "(I)V", "placedOnce", "getPlacedOnce$ui_release", "setPlacedOnce$ui_release", "previousPlaceOrder", "relayoutWithoutParentInProgress", "calculateAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "checkChildrenPlaceOrderForUpdates", "clearPlaceOrder", "forEachChildAlignmentLinesOwner", "block", "forEachChildDelegate", "get", "alignmentLine", "invalidateIntrinsicsParent", "forceRequest", "invalidateParentData", "layoutChildren", "markLayoutPending", "markLayoutPending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "markNodeAndSubtreeAsNotPlaced", "inLookahead", "markNodeAndSubtreeAsNotPlaced$ui_release", "markNodeAndSubtreeAsPlaced", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "notifyChildrenUsingLookaheadCoordinatesWhilePlacing", "onAttachedToNullParent", "onBeforeLayoutChildren", "onIntrinsicsQueried", "onNodeDetached", "onNodePlaced", "onNodePlaced$ui_release", "performMeasure", "performMeasure-BRTryo0$ui_release", "(J)V", "placeAt", "position", "zIndex", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "layer", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelf", "placeSelf-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "remeasure", "remeasure-BRTryo0", "(J)Z", "replace", "requestLayout", "requestMeasure", "trackLookaheadMeasurementByParent", "node", "updateParentData", "updatePlacedUnderMotionFrameOfReference", "newMFR", "PlacedState", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class LookaheadPassDelegate extends Placeable implements Measurable, AlignmentLinesOwner, MotionReferencePlacementDelegate {
    public static final int $stable = 8;
    private boolean duringAlignmentLinesQuery;
    private boolean isPlacedUnderMotionFrameOfReference;
    private GraphicsLayer lastExplicitLayer;
    private Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
    private float lastZIndex;
    private boolean layingOutChildren;
    private final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
    private Constraints lookaheadConstraints;
    private boolean measuredOnce;
    private boolean onNodePlacedCalled;
    private boolean placedOnce;
    private boolean relayoutWithoutParentInProgress;
    private int previousPlaceOrder = Integer.MAX_VALUE;
    private int placeOrder = Integer.MAX_VALUE;
    private LayoutNode.UsageByParent measuredByParent = LayoutNode.UsageByParent.NotUsed;
    private long lastPosition = IntOffset.INSTANCE.m7128getZeronOccac();
    private PlacedState _placedState = PlacedState.IsNotPlaced;
    private final AlignmentLines alignmentLines = new LookaheadAlignmentLines(this);
    private final MutableVector<LookaheadPassDelegate> _childDelegates = new MutableVector<>(new LookaheadPassDelegate[16], 0);
    private boolean childDelegatesDirty = true;
    private boolean parentDataDirty = true;
    private Object parentData = getMeasurePassDelegate$ui_release().getParentData();

    /* compiled from: LookaheadPassDelegate.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            try {
                iArr[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
            try {
                iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public LookaheadPassDelegate(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate) {
        this.layoutNodeLayoutDelegate = layoutNodeLayoutDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: LookaheadPassDelegate.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/node/LookaheadPassDelegate$PlacedState;", "", "(Ljava/lang/String;I)V", "IsPlacedInLookahead", "IsPlacedInApproach", "IsNotPlaced", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class PlacedState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PlacedState[] $VALUES;
        public static final PlacedState IsPlacedInLookahead = new PlacedState("IsPlacedInLookahead", 0);
        public static final PlacedState IsPlacedInApproach = new PlacedState("IsPlacedInApproach", 1);
        public static final PlacedState IsNotPlaced = new PlacedState("IsNotPlaced", 2);

        private static final /* synthetic */ PlacedState[] $values() {
            return new PlacedState[]{IsPlacedInLookahead, IsPlacedInApproach, IsNotPlaced};
        }

        public static EnumEntries<PlacedState> getEntries() {
            return $ENTRIES;
        }

        public static PlacedState valueOf(String str) {
            return (PlacedState) Enum.valueOf(PlacedState.class, str);
        }

        public static PlacedState[] values() {
            return (PlacedState[]) $VALUES.clone();
        }

        private PlacedState(String str, int i) {
        }

        static {
            PlacedState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    private final void setMeasurePending(boolean z) {
        this.layoutNodeLayoutDelegate.setLookaheadMeasurePending$ui_release(z);
    }

    private final boolean getMeasurePending() {
        return this.layoutNodeLayoutDelegate.getLookaheadMeasurePending();
    }

    private final void setLayoutPending(boolean z) {
        this.layoutNodeLayoutDelegate.setLookaheadLayoutPending$ui_release(z);
    }

    private final boolean getLayoutPending() {
        return this.layoutNodeLayoutDelegate.getLookaheadLayoutPending();
    }

    private final void setLayoutPendingForAlignment(boolean z) {
        this.layoutNodeLayoutDelegate.setLookaheadLayoutPendingForAlignment$ui_release(z);
    }

    private final boolean getLayoutPendingForAlignment() {
        return this.layoutNodeLayoutDelegate.getLookaheadLayoutPendingForAlignment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutNode getLayoutNode() {
        return this.layoutNodeLayoutDelegate.getLayoutNode();
    }

    public final void markLayoutPending$ui_release() {
        setLayoutPending(true);
        setLayoutPendingForAlignment(true);
    }

    public final void markMeasurePending$ui_release() {
        setMeasurePending(true);
    }

    /* renamed from: getPlaceOrder$ui_release, reason: from getter */
    public final int getPlaceOrder() {
        return this.placeOrder;
    }

    public final void setPlaceOrder$ui_release(int i) {
        this.placeOrder = i;
    }

    /* renamed from: getMeasuredByParent$ui_release, reason: from getter */
    public final LayoutNode.UsageByParent getMeasuredByParent() {
        return this.measuredByParent;
    }

    public final void setMeasuredByParent$ui_release(LayoutNode.UsageByParent usageByParent) {
        this.measuredByParent = usageByParent;
    }

    public final MeasurePassDelegate getMeasurePassDelegate$ui_release() {
        return this.layoutNodeLayoutDelegate.getMeasurePassDelegate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NodeCoordinator getOuterCoordinator() {
        return this.layoutNodeLayoutDelegate.getOuterCoordinator();
    }

    private final void setLayoutState(LayoutNode.LayoutState layoutState) {
        this.layoutNodeLayoutDelegate.setLayoutState$ui_release(layoutState);
    }

    private final LayoutNode.LayoutState getLayoutState() {
        return this.layoutNodeLayoutDelegate.getLayoutState();
    }

    /* renamed from: getPlacedOnce$ui_release, reason: from getter */
    public final boolean getPlacedOnce() {
        return this.placedOnce;
    }

    public final void setPlacedOnce$ui_release(boolean z) {
        this.placedOnce = z;
    }

    /* renamed from: getLastConstraints-DWUhwKw, reason: not valid java name and from getter */
    public final Constraints getLookaheadConstraints() {
        return this.lookaheadConstraints;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    /* renamed from: isPlaced */
    public boolean getIsPlaced() {
        return this._placedState != PlacedState.IsNotPlaced;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public NodeCoordinator getInnerCoordinator() {
        return getLayoutNode().getInnerCoordinator$ui_release();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public AlignmentLines getAlignmentLines() {
        return this.alignmentLines;
    }

    public final boolean getNeedsToBePlacedInApproach() {
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            return true;
        }
        if (this._placedState == PlacedState.IsNotPlaced && !this.layoutNodeLayoutDelegate.getDetachedFromParentLookaheadPass()) {
            this.layoutNodeLayoutDelegate.setDetachedFromParentLookaheadPlacement$ui_release(true);
        }
        return getDetachedFromParentLookaheadPlacement();
    }

    /* renamed from: getChildDelegatesDirty$ui_release, reason: from getter */
    public final boolean getChildDelegatesDirty() {
        return this.childDelegatesDirty;
    }

    public final void setChildDelegatesDirty$ui_release(boolean z) {
        this.childDelegatesDirty = z;
    }

    public final List<LookaheadPassDelegate> getChildDelegates$ui_release() {
        getLayoutNode().getChildren$ui_release();
        if (!this.childDelegatesDirty) {
            return this._childDelegates.asMutableList();
        }
        LayoutNode layoutNode = getLayoutNode();
        MutableVector<LookaheadPassDelegate> mutableVector = this._childDelegates;
        MutableVector<LayoutNode> mutableVector2 = layoutNode.get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector2.content;
        int size = mutableVector2.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            if (mutableVector.getSize() <= i) {
                LookaheadPassDelegate lookaheadPassDelegate = layoutNode2.getLayoutDelegate().getLookaheadPassDelegate();
                Intrinsics.checkNotNull(lookaheadPassDelegate);
                mutableVector.add(lookaheadPassDelegate);
            } else {
                LookaheadPassDelegate lookaheadPassDelegate2 = layoutNode2.getLayoutDelegate().getLookaheadPassDelegate();
                Intrinsics.checkNotNull(lookaheadPassDelegate2);
                mutableVector.set(i, lookaheadPassDelegate2);
            }
        }
        mutableVector.removeRange(layoutNode.getChildren$ui_release().size(), mutableVector.getSize());
        this.childDelegatesDirty = false;
        return this._childDelegates.asMutableList();
    }

    public final boolean getLayingOutChildren() {
        return this.layingOutChildren;
    }

    private final void forEachChildDelegate(Function1<? super LookaheadPassDelegate, Unit> block) {
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LookaheadPassDelegate lookaheadPassDelegate = layoutNodeArr[i].getLayoutDelegate().getLookaheadPassDelegate();
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            block.invoke(lookaheadPassDelegate);
        }
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void layoutChildren() {
        this.layingOutChildren = true;
        getAlignmentLines().recalculateQueryOwner();
        if (getLayoutPending()) {
            onBeforeLayoutChildren();
        }
        final LookaheadDelegate lookaheadDelegate = getInnerCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        if (getLayoutPendingForAlignment() || (!this.duringAlignmentLinesQuery && !lookaheadDelegate.getIsPlacingForAlignment() && getLayoutPending())) {
            setLayoutPending(false);
            LayoutNode.LayoutState layoutState = getLayoutState();
            setLayoutState(LayoutNode.LayoutState.LookaheadLayingOut);
            Owner requireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
            this.layoutNodeLayoutDelegate.setLookaheadCoordinatesAccessedDuringPlacement(false);
            OwnerSnapshotObserver.observeLayoutSnapshotReads$ui_release$default(requireOwner.getSnapshotObserver(), getLayoutNode(), false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LookaheadPassDelegate$layoutChildren$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    LayoutNode layoutNode;
                    LayoutNode layoutNode2;
                    LookaheadPassDelegate.this.clearPlaceOrder();
                    LookaheadPassDelegate.this.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LookaheadPassDelegate$layoutChildren$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                            invoke2(alignmentLinesOwner);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
                            alignmentLinesOwner.getAlignmentLines().setUsedDuringParentLayout$ui_release(false);
                        }
                    });
                    LookaheadDelegate lookaheadDelegate2 = LookaheadPassDelegate.this.getInnerCoordinator().getLookaheadDelegate();
                    if (lookaheadDelegate2 != null) {
                        boolean isPlacingForAlignment$ui_release = lookaheadDelegate2.getIsPlacingForAlignment();
                        layoutNode2 = LookaheadPassDelegate.this.getLayoutNode();
                        List<LayoutNode> children$ui_release = layoutNode2.getChildren$ui_release();
                        int size = children$ui_release.size();
                        for (int i = 0; i < size; i++) {
                            LookaheadDelegate lookaheadDelegate3 = children$ui_release.get(i).getOuterCoordinator$ui_release().getLookaheadDelegate();
                            if (lookaheadDelegate3 != null) {
                                lookaheadDelegate3.setPlacingForAlignment$ui_release(isPlacingForAlignment$ui_release);
                            }
                        }
                    }
                    lookaheadDelegate.getMeasureResult$ui_release().placeChildren();
                    LookaheadDelegate lookaheadDelegate4 = LookaheadPassDelegate.this.getInnerCoordinator().getLookaheadDelegate();
                    if (lookaheadDelegate4 != null) {
                        lookaheadDelegate4.getIsPlacingForAlignment();
                        layoutNode = LookaheadPassDelegate.this.getLayoutNode();
                        List<LayoutNode> children$ui_release2 = layoutNode.getChildren$ui_release();
                        int size2 = children$ui_release2.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            LookaheadDelegate lookaheadDelegate5 = children$ui_release2.get(i2).getOuterCoordinator$ui_release().getLookaheadDelegate();
                            if (lookaheadDelegate5 != null) {
                                lookaheadDelegate5.setPlacingForAlignment$ui_release(false);
                            }
                        }
                    }
                    LookaheadPassDelegate.this.checkChildrenPlaceOrderForUpdates();
                    LookaheadPassDelegate.this.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LookaheadPassDelegate$layoutChildren$1.4
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                            invoke2(alignmentLinesOwner);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
                            alignmentLinesOwner.getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(alignmentLinesOwner.getAlignmentLines().getUsedDuringParentLayout());
                        }
                    });
                }
            }, 2, null);
            setLayoutState(layoutState);
            if (this.layoutNodeLayoutDelegate.getLookaheadCoordinatesAccessedDuringPlacement() && lookaheadDelegate.getIsPlacingForAlignment()) {
                requestLayout();
            }
            setLayoutPendingForAlignment(false);
        }
        if (getAlignmentLines().getUsedDuringParentLayout()) {
            getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
        }
        if (getAlignmentLines().getDirty() && getAlignmentLines().getRequired$ui_release()) {
            getAlignmentLines().recalculate();
        }
        this.layingOutChildren = false;
    }

    private final boolean getDetachedFromParentLookaheadPlacement() {
        return this.layoutNodeLayoutDelegate.getDetachedFromParentLookaheadPlacement();
    }

    public final void markNodeAndSubtreeAsNotPlaced$ui_release(boolean inLookahead) {
        if (inLookahead && getDetachedFromParentLookaheadPlacement()) {
            return;
        }
        if (inLookahead || getDetachedFromParentLookaheadPlacement()) {
            this._placedState = PlacedState.IsNotPlaced;
            MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                LookaheadPassDelegate lookaheadPassDelegate = layoutNodeArr[i].getLayoutDelegate().getLookaheadPassDelegate();
                Intrinsics.checkNotNull(lookaheadPassDelegate);
                lookaheadPassDelegate.markNodeAndSubtreeAsNotPlaced$ui_release(true);
            }
        }
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public Map<AlignmentLine, Integer> calculateAlignmentLines() {
        if (!this.duringAlignmentLinesQuery) {
            if (getLayoutState() == LayoutNode.LayoutState.LookaheadMeasuring) {
                getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                if (getAlignmentLines().getDirty()) {
                    this.layoutNodeLayoutDelegate.markLookaheadLayoutPending$ui_release();
                }
            } else {
                getAlignmentLines().setUsedByModifierLayout$ui_release(true);
            }
        }
        LookaheadDelegate lookaheadDelegate = getInnerCoordinator().getLookaheadDelegate();
        if (lookaheadDelegate != null) {
            lookaheadDelegate.setPlacingForAlignment$ui_release(true);
        }
        layoutChildren();
        LookaheadDelegate lookaheadDelegate2 = getInnerCoordinator().getLookaheadDelegate();
        if (lookaheadDelegate2 != null) {
            lookaheadDelegate2.setPlacingForAlignment$ui_release(false);
        }
        return getAlignmentLines().getLastCalculation();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public AlignmentLinesOwner getParentAlignmentLinesOwner() {
        LayoutNodeLayoutDelegate layoutDelegate;
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if (parent$ui_release == null || (layoutDelegate = parent$ui_release.getLayoutDelegate()) == null) {
            return null;
        }
        return layoutDelegate.getLookaheadAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void forEachChildAlignmentLinesOwner(Function1<? super AlignmentLinesOwner, Unit> block) {
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = layoutNodeArr[i].getLayoutDelegate().getLookaheadAlignmentLinesOwner$ui_release();
            Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
            block.invoke(lookaheadAlignmentLinesOwner$ui_release);
        }
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void requestLayout() {
        LayoutNode.requestLookaheadRelayout$ui_release$default(getLayoutNode(), false, 1, null);
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void requestMeasure() {
        LayoutNode.requestLookaheadRemeasure$ui_release$default(getLayoutNode(), false, false, false, 7, null);
    }

    public final void notifyChildrenUsingLookaheadCoordinatesWhilePlacing() {
        if (this.layoutNodeLayoutDelegate.getChildrenAccessingLookaheadCoordinatesDuringPlacement() > 0) {
            MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                LayoutNode layoutNode = layoutNodeArr[i];
                LayoutNodeLayoutDelegate layoutDelegate = layoutNode.getLayoutDelegate();
                if ((layoutDelegate.getLookaheadCoordinatesAccessedDuringPlacement() || layoutDelegate.getLookaheadCoordinatesAccessedDuringModifierPlacement()) && !layoutDelegate.getLookaheadLayoutPending()) {
                    LayoutNode.requestLookaheadRelayout$ui_release$default(layoutNode, false, 1, null);
                }
                LookaheadPassDelegate lookaheadPassDelegate = layoutDelegate.getLookaheadPassDelegate();
                if (lookaheadPassDelegate != null) {
                    lookaheadPassDelegate.notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        if ((r0 != null ? r0.getLayoutState$ui_release() : null) == androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadLayingOut) goto L13;
     */
    @Override // androidx.compose.ui.layout.Measurable
    /* renamed from: measure-BRTryo0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.ui.layout.Placeable mo5732measureBRTryo0(long r4) {
        /*
            r3 = this;
            androidx.compose.ui.node.LayoutNode r0 = r3.getLayoutNode()
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            r1 = 0
            if (r0 == 0) goto L10
            androidx.compose.ui.node.LayoutNode$LayoutState r0 = r0.getLayoutState$ui_release()
            goto L11
        L10:
            r0 = r1
        L11:
            androidx.compose.ui.node.LayoutNode$LayoutState r2 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadMeasuring
            if (r0 == r2) goto L27
            androidx.compose.ui.node.LayoutNode r0 = r3.getLayoutNode()
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L23
            androidx.compose.ui.node.LayoutNode$LayoutState r1 = r0.getLayoutState$ui_release()
        L23:
            androidx.compose.ui.node.LayoutNode$LayoutState r0 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadLayingOut
            if (r1 != r0) goto L2d
        L27:
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = r3.layoutNodeLayoutDelegate
            r1 = 0
            r0.setDetachedFromParentLookaheadPass$ui_release(r1)
        L2d:
            androidx.compose.ui.node.LayoutNode r0 = r3.getLayoutNode()
            r3.trackLookaheadMeasurementByParent(r0)
            androidx.compose.ui.node.LayoutNode r0 = r3.getLayoutNode()
            androidx.compose.ui.node.LayoutNode$UsageByParent r0 = r0.getIntrinsicsUsageByParent()
            androidx.compose.ui.node.LayoutNode$UsageByParent r1 = androidx.compose.ui.node.LayoutNode.UsageByParent.NotUsed
            if (r0 != r1) goto L47
            androidx.compose.ui.node.LayoutNode r0 = r3.getLayoutNode()
            r0.clearSubtreeIntrinsicsUsage$ui_release()
        L47:
            r3.m5939remeasureBRTryo0(r4)
            androidx.compose.ui.layout.Placeable r3 = (androidx.compose.ui.layout.Placeable) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LookaheadPassDelegate.mo5732measureBRTryo0(long):androidx.compose.ui.layout.Placeable");
    }

    private final void trackLookaheadMeasurementByParent(LayoutNode node) {
        LayoutNode.UsageByParent usageByParent;
        LayoutNode parent$ui_release = node.getParent$ui_release();
        if (parent$ui_release != null) {
            if (!(this.measuredByParent == LayoutNode.UsageByParent.NotUsed || node.getCanMultiMeasure())) {
                InlineClassHelperKt.throwIllegalStateException(LayoutNodeLayoutDelegateKt.MeasuredTwiceErrorMessage);
            }
            int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
            if (i == 1 || i == 2) {
                usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
            } else if (i == 3 || i == 4) {
                usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
            } else {
                throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent$ui_release.getLayoutState$ui_release());
            }
            this.measuredByParent = usageByParent;
            return;
        }
        this.measuredByParent = LayoutNode.UsageByParent.NotUsed;
    }

    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        return this.parentData;
    }

    /* renamed from: performMeasure-BRTryo0$ui_release, reason: not valid java name */
    public final void m5938performMeasureBRTryo0$ui_release(final long constraints) {
        setLayoutState(LayoutNode.LayoutState.LookaheadMeasuring);
        setMeasurePending(false);
        OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release$default(LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver(), getLayoutNode(), false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LookaheadPassDelegate$performMeasure$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                NodeCoordinator outerCoordinator;
                outerCoordinator = LookaheadPassDelegate.this.getOuterCoordinator();
                LookaheadDelegate lookaheadDelegate = outerCoordinator.getLookaheadDelegate();
                Intrinsics.checkNotNull(lookaheadDelegate);
                lookaheadDelegate.mo5732measureBRTryo0(constraints);
            }
        }, 2, null);
        markLayoutPending$ui_release();
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            getMeasurePassDelegate$ui_release().markLayoutPending();
        } else {
            getMeasurePassDelegate$ui_release().markMeasurePending$ui_release();
        }
        setLayoutState(LayoutNode.LayoutState.Idle);
    }

    /* renamed from: remeasure-BRTryo0, reason: not valid java name */
    public final boolean m5939remeasureBRTryo0(long constraints) {
        if (getLayoutNode().getIsDeactivated()) {
            InlineClassHelperKt.throwIllegalArgumentException("measure is called on a deactivated node");
        }
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        getLayoutNode().setCanMultiMeasure$ui_release(getLayoutNode().getCanMultiMeasure() || (parent$ui_release != null && parent$ui_release.getCanMultiMeasure()));
        if (!getLayoutNode().getLookaheadMeasurePending$ui_release()) {
            Constraints constraints2 = this.lookaheadConstraints;
            if (constraints2 == null ? false : Constraints.m6935equalsimpl0(constraints2.getValue(), constraints)) {
                Owner owner = getLayoutNode().getOwner();
                if (owner != null) {
                    owner.forceMeasureTheSubtree(getLayoutNode(), true);
                }
                getLayoutNode().resetSubtreeIntrinsicsUsage$ui_release();
                return false;
            }
        }
        this.lookaheadConstraints = Constraints.m6929boximpl(constraints);
        m5795setMeasurementConstraintsBRTryo0(constraints);
        getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
        forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LookaheadPassDelegate$remeasure$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                invoke2(alignmentLinesOwner);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
                alignmentLinesOwner.getAlignmentLines().setUsedDuringParentMeasurement$ui_release(false);
            }
        });
        long j = this.measuredOnce ? getMeasuredSize() : IntSize.m7155constructorimpl(-9223372034707292160L);
        this.measuredOnce = true;
        LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
        if (!(lookaheadDelegate != null)) {
            InlineClassHelperKt.throwIllegalStateException("Lookahead result from lookaheadRemeasure cannot be null");
        }
        this.layoutNodeLayoutDelegate.m5926performLookaheadMeasureBRTryo0$ui_release(constraints);
        m5794setMeasuredSizeozmzZPI(IntSize.m7155constructorimpl((lookaheadDelegate.getWidth() << 32) | (lookaheadDelegate.getHeight() & 4294967295L)));
        return (((int) (j >> 32)) == lookaheadDelegate.getWidth() && ((int) (j & 4294967295L)) == lookaheadDelegate.getHeight()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo5733placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        m5936placeSelfMLgxB_4(position, zIndex, layerBlock, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo5793placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) {
        m5936placeSelfMLgxB_4(position, zIndex, null, layer);
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    /* renamed from: isPlacedUnderMotionFrameOfReference, reason: from getter */
    public boolean getIsPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    public void setPlacedUnderMotionFrameOfReference(boolean z) {
        this.isPlacedUnderMotionFrameOfReference = z;
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public void updatePlacedUnderMotionFrameOfReference(boolean newMFR) {
        LookaheadDelegate lookaheadDelegate;
        LookaheadDelegate lookaheadDelegate2 = getOuterCoordinator().getLookaheadDelegate();
        if (!Intrinsics.areEqual(Boolean.valueOf(newMFR), lookaheadDelegate2 != null ? Boolean.valueOf(lookaheadDelegate2.getIsPlacedUnderMotionFrameOfReference()) : null) && (lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate()) != null) {
            lookaheadDelegate.setPlacedUnderMotionFrameOfReference(newMFR);
        }
        setPlacedUnderMotionFrameOfReference(newMFR);
    }

    /* renamed from: placeSelf-MLgxB_4, reason: not valid java name */
    private final void m5936placeSelfMLgxB_4(final long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer layer) {
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LookaheadLayingOut) {
            this.layoutNodeLayoutDelegate.setDetachedFromParentLookaheadPlacement$ui_release(false);
        }
        if (getLayoutNode().getIsDeactivated()) {
            InlineClassHelperKt.throwIllegalArgumentException("place is called on a deactivated node");
        }
        setLayoutState(LayoutNode.LayoutState.LookaheadLayingOut);
        this.placedOnce = true;
        this.onNodePlacedCalled = false;
        if (!IntOffset.m7116equalsimpl0(position, this.lastPosition)) {
            if (this.layoutNodeLayoutDelegate.getLookaheadCoordinatesAccessedDuringModifierPlacement() || this.layoutNodeLayoutDelegate.getLookaheadCoordinatesAccessedDuringPlacement()) {
                setLayoutPending(true);
            }
            notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
        }
        final Owner requireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        if (!getLayoutPending() && getIsPlaced()) {
            LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            lookaheadDelegate.m5933placeSelfApparentToRealOffsetgyyYBs$ui_release(position);
            onNodePlaced$ui_release();
        } else {
            this.layoutNodeLayoutDelegate.setLookaheadCoordinatesAccessedDuringModifierPlacement(false);
            getAlignmentLines().setUsedByModifierLayout$ui_release(false);
            OwnerSnapshotObserver.observeLayoutModifierSnapshotReads$ui_release$default(requireOwner.getSnapshotObserver(), getLayoutNode(), false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LookaheadPassDelegate$placeSelf$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0042  */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void invoke2() {
                    /*
                        r9 = this;
                        androidx.compose.ui.node.LookaheadPassDelegate r0 = androidx.compose.ui.node.LookaheadPassDelegate.this
                        androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.LookaheadPassDelegate.access$getLayoutNode(r0)
                        boolean r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(r0)
                        r1 = 0
                        if (r0 != 0) goto L30
                        androidx.compose.ui.node.LookaheadPassDelegate r0 = androidx.compose.ui.node.LookaheadPassDelegate.this
                        androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = androidx.compose.ui.node.LookaheadPassDelegate.access$getLayoutNodeLayoutDelegate$p(r0)
                        boolean r0 = r0.getDetachedFromParentLookaheadPlacement()
                        if (r0 != 0) goto L30
                        androidx.compose.ui.node.LookaheadPassDelegate r0 = androidx.compose.ui.node.LookaheadPassDelegate.this
                        androidx.compose.ui.node.NodeCoordinator r0 = androidx.compose.ui.node.LookaheadPassDelegate.access$getOuterCoordinator(r0)
                        androidx.compose.ui.node.NodeCoordinator r0 = r0.getWrappedBy()
                        if (r0 == 0) goto L40
                        androidx.compose.ui.node.LookaheadDelegate r0 = r0.getLookaheadDelegate()
                        if (r0 == 0) goto L40
                        androidx.compose.ui.layout.Placeable$PlacementScope r1 = r0.getPlacementScope()
                        goto L40
                    L30:
                        androidx.compose.ui.node.LookaheadPassDelegate r0 = androidx.compose.ui.node.LookaheadPassDelegate.this
                        androidx.compose.ui.node.NodeCoordinator r0 = androidx.compose.ui.node.LookaheadPassDelegate.access$getOuterCoordinator(r0)
                        androidx.compose.ui.node.NodeCoordinator r0 = r0.getWrappedBy()
                        if (r0 == 0) goto L40
                        androidx.compose.ui.layout.Placeable$PlacementScope r1 = r0.getPlacementScope()
                    L40:
                        if (r1 != 0) goto L48
                        androidx.compose.ui.node.Owner r0 = r2
                        androidx.compose.ui.layout.Placeable$PlacementScope r1 = r0.getPlacementScope()
                    L48:
                        r2 = r1
                        androidx.compose.ui.node.LookaheadPassDelegate r0 = androidx.compose.ui.node.LookaheadPassDelegate.this
                        long r4 = r3
                        androidx.compose.ui.node.NodeCoordinator r9 = androidx.compose.ui.node.LookaheadPassDelegate.access$getOuterCoordinator(r0)
                        androidx.compose.ui.node.LookaheadDelegate r9 = r9.getLookaheadDelegate()
                        kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
                        r3 = r9
                        androidx.compose.ui.layout.Placeable r3 = (androidx.compose.ui.layout.Placeable) r3
                        r7 = 2
                        r8 = 0
                        r6 = 0
                        androidx.compose.ui.layout.Placeable.PlacementScope.m5796place70tqf50$default(r2, r3, r4, r6, r7, r8)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LookaheadPassDelegate$placeSelf$2.invoke2():void");
                }
            }, 2, null);
        }
        this.lastPosition = position;
        this.lastZIndex = zIndex;
        this.lastLayerBlock = layerBlock;
        this.lastExplicitLayer = layer;
        setLayoutState(LayoutNode.LayoutState.Idle);
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured
    public int getMeasuredWidth() {
        LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.getMeasuredWidth();
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured
    public int getMeasuredHeight() {
        LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.getMeasuredHeight();
    }

    @Override // androidx.compose.ui.layout.Measured
    public int get(AlignmentLine alignmentLine) {
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LookaheadMeasuring) {
            getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
        } else {
            LayoutNode parent$ui_release2 = getLayoutNode().getParent$ui_release();
            if ((parent$ui_release2 != null ? parent$ui_release2.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LookaheadLayingOut) {
                getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
            }
        }
        this.duringAlignmentLinesQuery = true;
        LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        int i = lookaheadDelegate.get(alignmentLine);
        this.duringAlignmentLinesQuery = false;
        return i;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int height) {
        onIntrinsicsQueried();
        LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.minIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int height) {
        onIntrinsicsQueried();
        LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int width) {
        onIntrinsicsQueried();
        LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.minIntrinsicHeight(width);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int width) {
        onIntrinsicsQueried();
        LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.maxIntrinsicHeight(width);
    }

    private final void onIntrinsicsQueried() {
        LayoutNode.UsageByParent usageByParent;
        LayoutNode.requestLookaheadRemeasure$ui_release$default(getLayoutNode(), false, false, false, 7, null);
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if (parent$ui_release == null || getLayoutNode().getIntrinsicsUsageByParent() != LayoutNode.UsageByParent.NotUsed) {
            return;
        }
        LayoutNode layoutNode = getLayoutNode();
        int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
        if (i == 2) {
            usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
        } else if (i == 3) {
            usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
        } else {
            usageByParent = parent$ui_release.getIntrinsicsUsageByParent();
        }
        layoutNode.setIntrinsicsUsageByParent$ui_release(usageByParent);
    }

    public final void invalidateIntrinsicsParent(boolean forceRequest) {
        LayoutNode layoutNode;
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        LayoutNode.UsageByParent intrinsicsUsageByParent = getLayoutNode().getIntrinsicsUsageByParent();
        if (parent$ui_release == null || intrinsicsUsageByParent == LayoutNode.UsageByParent.NotUsed) {
            return;
        }
        do {
            layoutNode = parent$ui_release;
            if (layoutNode.getIntrinsicsUsageByParent() != intrinsicsUsageByParent) {
                break;
            } else {
                parent$ui_release = layoutNode.getParent$ui_release();
            }
        } while (parent$ui_release != null);
        int i = WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent.ordinal()];
        if (i == 1) {
            if (layoutNode.getLookaheadRoot() != null) {
                LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNode, forceRequest, false, false, 6, null);
                return;
            } else {
                LayoutNode.requestRemeasure$ui_release$default(layoutNode, forceRequest, false, false, 6, null);
                return;
            }
        }
        if (i == 2) {
            if (layoutNode.getLookaheadRoot() != null) {
                layoutNode.requestLookaheadRelayout$ui_release(forceRequest);
                return;
            } else {
                layoutNode.requestRelayout$ui_release(forceRequest);
                return;
            }
        }
        throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
    }

    public final void invalidateParentData() {
        this.parentDataDirty = true;
    }

    public final boolean updateParentData() {
        if (getParentData() == null) {
            LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            if (lookaheadDelegate.getParentData() == null) {
                return false;
            }
        }
        if (!this.parentDataDirty) {
            return false;
        }
        this.parentDataDirty = false;
        LookaheadDelegate lookaheadDelegate2 = getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate2);
        this.parentData = lookaheadDelegate2.getParentData();
        return true;
    }

    public final void onNodePlaced$ui_release() {
        this.onNodePlacedCalled = true;
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if ((this._placedState != PlacedState.IsPlacedInLookahead && !getDetachedFromParentLookaheadPlacement()) || (this._placedState != PlacedState.IsPlacedInApproach && getDetachedFromParentLookaheadPlacement())) {
            markNodeAndSubtreeAsPlaced();
            if (this.relayoutWithoutParentInProgress && parent$ui_release != null) {
                LayoutNode.requestLookaheadRelayout$ui_release$default(parent$ui_release, false, 1, null);
            }
        }
        if (parent$ui_release != null) {
            if (!this.relayoutWithoutParentInProgress && (parent$ui_release.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut || parent$ui_release.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadLayingOut)) {
                if (!(this.placeOrder == Integer.MAX_VALUE)) {
                    InlineClassHelperKt.throwIllegalStateException("Place was called on a node which was placed already");
                }
                this.placeOrder = parent$ui_release.getLayoutDelegate().getNextChildLookaheadPlaceOrder();
                LayoutNodeLayoutDelegate layoutDelegate = parent$ui_release.getLayoutDelegate();
                layoutDelegate.setNextChildLookaheadPlaceOrder$ui_release(layoutDelegate.getNextChildLookaheadPlaceOrder() + 1);
            }
        } else {
            this.placeOrder = 0;
        }
        layoutChildren();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearPlaceOrder() {
        this.layoutNodeLayoutDelegate.setNextChildLookaheadPlaceOrder$ui_release(0);
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LookaheadPassDelegate lookaheadPassDelegate = layoutNodeArr[i].getLayoutDelegate().getLookaheadPassDelegate();
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            lookaheadPassDelegate.previousPlaceOrder = lookaheadPassDelegate.placeOrder;
            lookaheadPassDelegate.placeOrder = Integer.MAX_VALUE;
            if (lookaheadPassDelegate.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                lookaheadPassDelegate.measuredByParent = LayoutNode.UsageByParent.NotUsed;
            }
        }
    }

    private final void markNodeAndSubtreeAsPlaced() {
        PlacedState placedState = this._placedState;
        if (getDetachedFromParentLookaheadPlacement()) {
            this._placedState = PlacedState.IsPlacedInApproach;
        } else {
            this._placedState = PlacedState.IsPlacedInLookahead;
        }
        if (placedState != PlacedState.IsPlacedInLookahead && this.layoutNodeLayoutDelegate.getLookaheadMeasurePending()) {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(getLayoutNode(), true, false, false, 6, null);
        }
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode = layoutNodeArr[i];
            LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode.getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release == null) {
                throw new IllegalArgumentException("Error: Child node's lookahead pass delegate cannot be null when in a lookahead scope.".toString());
            }
            if (lookaheadPassDelegate$ui_release.placeOrder != Integer.MAX_VALUE) {
                lookaheadPassDelegate$ui_release.markNodeAndSubtreeAsPlaced();
                layoutNode.rescheduleRemeasureOrRelayout$ui_release(layoutNode);
            }
        }
    }

    private final void onBeforeLayoutChildren() {
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode = layoutNodeArr[i];
            if (layoutNode.getLookaheadMeasurePending$ui_release() && layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                LookaheadPassDelegate lookaheadPassDelegate = layoutNode.getLayoutDelegate().getLookaheadPassDelegate();
                Intrinsics.checkNotNull(lookaheadPassDelegate);
                Constraints m5925getLastLookaheadConstraintsDWUhwKw = layoutNode.getLayoutDelegate().m5925getLastLookaheadConstraintsDWUhwKw();
                Intrinsics.checkNotNull(m5925getLastLookaheadConstraintsDWUhwKw);
                if (lookaheadPassDelegate.m5939remeasureBRTryo0(m5925getLastLookaheadConstraintsDWUhwKw.getValue())) {
                    LayoutNode.requestLookaheadRemeasure$ui_release$default(getLayoutNode(), false, false, false, 7, null);
                }
            }
        }
    }

    public final void replace() {
        LookaheadPassDelegate lookaheadPassDelegate;
        LayoutNode parent$ui_release;
        try {
            this.relayoutWithoutParentInProgress = true;
            if (!this.placedOnce) {
                InlineClassHelperKt.throwIllegalStateException("replace() called on item that was not placed");
            }
            this.onNodePlacedCalled = false;
            boolean isPlaced = getIsPlaced();
            lookaheadPassDelegate = this;
            try {
                lookaheadPassDelegate.m5936placeSelfMLgxB_4(this.lastPosition, 0.0f, this.lastLayerBlock, this.lastExplicitLayer);
                if (isPlaced && !lookaheadPassDelegate.onNodePlacedCalled && (parent$ui_release = lookaheadPassDelegate.getLayoutNode().getParent$ui_release()) != null) {
                    LayoutNode.requestLookaheadRelayout$ui_release$default(parent$ui_release, false, 1, null);
                }
                lookaheadPassDelegate.relayoutWithoutParentInProgress = false;
            } catch (Throwable th) {
                th = th;
                lookaheadPassDelegate.relayoutWithoutParentInProgress = false;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lookaheadPassDelegate = this;
        }
    }

    public final void onNodeDetached() {
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        this._placedState = PlacedState.IsNotPlaced;
    }

    public final void onAttachedToNullParent() {
        this._placedState = PlacedState.IsPlacedInLookahead;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkChildrenPlaceOrderForUpdates() {
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LookaheadPassDelegate lookaheadPassDelegate = layoutNodeArr[i].getLayoutDelegate().getLookaheadPassDelegate();
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            int i2 = lookaheadPassDelegate.previousPlaceOrder;
            int i3 = lookaheadPassDelegate.placeOrder;
            if (i2 != i3 && i3 == Integer.MAX_VALUE) {
                lookaheadPassDelegate.markNodeAndSubtreeAsNotPlaced$ui_release(true);
            }
        }
    }
}
