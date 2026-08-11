package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: LazyLayoutItemAnimator.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0003JKLB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010(\u001a\u0004\u0018\u00010\u00072\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u000bJ1\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\u000b2\u0012\b\u0002\u0010.\u001a\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002¢\u0006\u0002\u0010/J\u0082\u0001\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\f\u001a\u00020\r2\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u0000062\u0006\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@J\b\u0010A\u001a\u00020,H\u0002J\u0010\u0010B\u001a\u00020,2\u0006\u0010)\u001a\u00020\u0003H\u0002J\u0006\u0010C\u001a\u00020,J\u001f\u0010D\u001a\u00020,2\u0006\u0010-\u001a\u00028\u00002\b\b\u0002\u0010E\u001a\u00020#H\u0002¢\u0006\u0002\u0010FJ\u0019\u0010G\u001a\u00020\u000b*\u00020H2\u0006\u0010-\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010IR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\u00020\u00128Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\u00020\u000b*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\u00020#*\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0018\u0010&\u001a\u00020\u000b*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010!\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006M"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "", "()V", "disappearingItems", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "displayingNode", "Landroidx/compose/ui/node/DrawModifierNode;", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", "minSizeToFitDisappearingItems", "Landroidx/compose/ui/unit/IntSize;", "getMinSizeToFitDisappearingItems-YbymL2g", "()J", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "movingAwayKeys", "Landroidx/collection/MutableScatterSet;", "movingAwayToEndBound", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "crossAxisOffset", "getCrossAxisOffset", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)Z", "mainAxisOffset", "getMainAxisOffset", "getAnimation", "key", "placeableIndex", "initializeAnimation", "", "item", "itemInfo", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;ILandroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;)V", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "isVertical", "isLookingAhead", "laneCount", "hasLookaheadOccurred", "layoutMinOffset", "layoutMaxOffset", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "releaseAnimations", "removeInfoForKey", "reset", "startPlacementAnimationsIfNeeded", "isMovingAway", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Z)V", "updateAndReturnOffsetFor", "", "([ILandroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "DisplayingDisappearingItemsElement", "DisplayingDisappearingItemsNode", "ItemInfo", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyLayoutItemAnimator<T extends LazyLayoutMeasuredItem> {
    public static final int $stable = 8;
    private DrawModifierNode displayingNode;
    private int firstVisibleIndex;
    private LazyLayoutKeyIndexMap keyIndexMap;
    private final MutableScatterMap<Object, LazyLayoutItemAnimator<T>.ItemInfo> keyToItemInfoMap = ScatterMapKt.mutableScatterMapOf();
    private final MutableScatterSet<Object> movingAwayKeys = ScatterSetKt.mutableScatterSetOf();
    private final List<T> movingInFromStartBound = new ArrayList();
    private final List<T> movingInFromEndBound = new ArrayList();
    private final List<T> movingAwayToStartBound = new ArrayList();
    private final List<T> movingAwayToEndBound = new ArrayList();
    private final List<LazyLayoutItemAnimation> disappearingItems = new ArrayList();
    private final Modifier modifier = new DisplayingDisappearingItemsElement(this);

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01ed, code lost:
    
        startPlacementAnimationsIfNeeded$default(r41, r14, false, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x010a, code lost:
    
        r15 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0103, code lost:
    
        r13 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01f4, code lost:
    
        r34 = r1;
        r35 = r2;
        removeInfoForKey(r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0205, code lost:
    
        r6 = new int[r50];
     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0044, code lost:
    
        r41.firstVisibleIndex = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0207, code lost:
    
        if (r23 == false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0209, code lost:
    
        if (r11 == null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0213, code lost:
    
        if (r41.movingInFromStartBound.isEmpty() != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0215, code lost:
    
        r1 = r41.movingInFromStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x021c, code lost:
    
        if (r1.size() <= 1) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x021e, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$1(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0228, code lost:
    
        r7 = r41.movingInFromStartBound;
        r12 = r7.size();
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0232, code lost:
    
        if (r13 >= r12) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0234, code lost:
    
        r1 = r7.get(r13);
        initializeAnimation$default(r41, r1, r52 - updateAndReturnOffsetFor(r6, r1), null, 4, null);
        startPlacementAnimationsIfNeeded$default(r41, r1, false, 2, null);
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0046, code lost:
    
        if (r48 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x024f, code lost:
    
        kotlin.collections.ArraysKt.fill$default(r6, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0266, code lost:
    
        if (r41.movingInFromEndBound.isEmpty() != false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0268, code lost:
    
        r1 = r41.movingInFromEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x026f, code lost:
    
        if (r1.size() <= 1) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0271, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$1(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x027b, code lost:
    
        r7 = r41.movingInFromEndBound;
        r12 = r7.size();
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0285, code lost:
    
        if (r13 >= r12) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0287, code lost:
    
        r1 = r7.get(r13);
        initializeAnimation$default(r41, r1, (r53 + updateAndReturnOffsetFor(r6, r1)) - r1.getMainAxisSizeWithSpacings(), null, 4, null);
        startPlacementAnimationsIfNeeded$default(r41, r1, false, 2, null);
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
    
        r4 = androidx.compose.ui.unit.IntOffset.m7111constructorimpl(r42 & 4294967295L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02a7, code lost:
    
        kotlin.collections.ArraysKt.fill$default(r6, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x02b6, code lost:
    
        r1 = r41.movingAwayKeys;
        r2 = r1.elements;
        r1 = r1.metadata;
        r3 = r1.length - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02c1, code lost:
    
        if (r3 < 0) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x02c3, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x02c4, code lost:
    
        r12 = r1[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02ce, code lost:
    
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02d0, code lost:
    
        r5 = 8 - ((~(r4 - r3)) >>> 31);
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02da, code lost:
    
        if (r7 >= r5) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005c, code lost:
    
        if (r49 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x02e0, code lost:
    
        if ((r12 & 255) >= 128) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02e2, code lost:
    
        r14 = r2[(r4 << 3) + r7];
        r15 = r41.keyToItemInfoMap.get(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02ef, code lost:
    
        if (r15 != null) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02f3, code lost:
    
        r30 = r1;
        r1 = r46.getIndex(r14);
        r31 = r2;
        r15.setSpan(java.lang.Math.min(r50, r15.getSpan()));
        r32 = r7;
        r15.setLane(java.lang.Math.min(r50 - r15.getSpan(), r15.getLane()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x031a, code lost:
    
        if (r1 != (-1)) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x031c, code lost:
    
        r1 = r15.getAnimations();
        r7 = r1.length;
        r2 = 0;
        r24 = false;
        r25 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0326, code lost:
    
        if (r2 >= r7) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0328, code lost:
    
        r48 = r1;
        r1 = r48[r2];
        r26 = r25 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x032e, code lost:
    
        if (r1 == null) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005e, code lost:
    
        if (r51 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0334, code lost:
    
        if (r1.isDisappearanceAnimationInProgress() == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0336, code lost:
    
        r27 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0338, code lost:
    
        r24 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x038e, code lost:
    
        r2 = r27 + 1;
        r1 = r48;
        r25 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0341, code lost:
    
        if (r1.isDisappearanceAnimationFinished() == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0343, code lost:
    
        r1.release();
        r15.getAnimations()[r25] = null;
        r27 = r2;
        r41.disappearingItems.remove(r1);
        r1 = r41.displayingNode;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0357, code lost:
    
        if (r1 == null) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0061, code lost:
    
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0359, code lost:
    
        androidx.compose.ui.node.DrawModifierNodeKt.invalidateDraw(r1);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x035f, code lost:
    
        r27 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0365, code lost:
    
        if (r1.getLayer() == null) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0367, code lost:
    
        r1.animateDisappearance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x036e, code lost:
    
        if (r1.isDisappearanceAnimationInProgress() == false) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0370, code lost:
    
        r41.disappearingItems.add(r1);
        r1 = r41.displayingNode;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0377, code lost:
    
        if (r1 == null) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0379, code lost:
    
        androidx.compose.ui.node.DrawModifierNodeKt.invalidateDraw(r1);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x037f, code lost:
    
        r1.release();
        r15.getAnimations()[r25] = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
    
        r1 = r41.keyToItemInfoMap;
        r15 = r1.keys;
        r1 = r1.metadata;
        r13 = r1.length - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x038b, code lost:
    
        r27 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0397, code lost:
    
        if (r24 != false) goto L252;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0399, code lost:
    
        removeInfoForKey(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x041b, code lost:
    
        r12 = r12 >> 8;
        r7 = r32 + 1;
        r1 = r30;
        r2 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x039e, code lost:
    
        r2 = r15.getConstraints();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
        r1 = r47.mo1165getAndMeasurehBUhpc(r1, r15.getLane(), r15.getSpan(), r2.getValue());
        r1.setNonScrollableItem(true);
        r7 = r15.getAnimations();
        r1 = r7.length;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007a, code lost:
    
        if (r13 < 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x03cb, code lost:
    
        if (r7 >= r1) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x03cd, code lost:
    
        r24 = r7[r7];
        r25 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x03d1, code lost:
    
        if (r24 == null) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x03d3, code lost:
    
        r1 = r24.isPlacementAnimationInProgress();
        r24 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x03da, code lost:
    
        if (r1 != true) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x03f0, code lost:
    
        r15.updateAnimation(r1, r54, r55, r52, r53, r15.getCrossAxisOffset());
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0405, code lost:
    
        if (r1 >= r41.firstVisibleIndex) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0407, code lost:
    
        r41.movingAwayToStartBound.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007c, code lost:
    
        r23 = r14;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x040d, code lost:
    
        r41.movingAwayToEndBound.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x03df, code lost:
    
        r7 = r24 + 1;
        r1 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x03dd, code lost:
    
        r24 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x03e4, code lost:
    
        if (r11 == null) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x03ea, code lost:
    
        if (r1 != r11.getIndex(r14)) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0081, code lost:
    
        r14 = r1[r12];
        r26 = r1;
        r25 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x03ec, code lost:
    
        removeInfoForKey(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0413, code lost:
    
        r30 = r1;
        r31 = r2;
        r32 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x0426, code lost:
    
        r30 = r1;
        r31 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x042e, code lost:
    
        if (r5 != 8) goto L248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0439, code lost:
    
        if (r4 == r3) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x043b, code lost:
    
        r4 = r4 + 1;
        r1 = r30;
        r2 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0091, code lost:
    
        if (((((~r14) << 7) & r14) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0431, code lost:
    
        r30 = r1;
        r31 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x044b, code lost:
    
        if (r41.movingAwayToStartBound.isEmpty() != false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x044d, code lost:
    
        r1 = r41.movingAwayToStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0454, code lost:
    
        if (r1.size() <= 1) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0456, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$2(r46));
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x0460, code lost:
    
        r1 = r41.movingAwayToStartBound;
        r2 = r1.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x046a, code lost:
    
        if (r3 >= r2) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x046c, code lost:
    
        r4 = r1.get(r3);
        r5 = r41.keyToItemInfoMap.get(r4.getKey());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r5 = r5;
        r7 = updateAndReturnOffsetFor(r6, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0093, code lost:
    
        r1 = 8 - ((~(r12 - r13)) >>> 31);
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0485, code lost:
    
        if (r49 == false) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0487, code lost:
    
        r10 = getMainAxisOffset((androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) kotlin.collections.CollectionsKt.first((java.util.List) r45));
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0496, code lost:
    
        r4.position(r10 - r7, r5.getCrossAxisOffset(), r43, r44);
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x04a2, code lost:
    
        if (r23 == false) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x04a4, code lost:
    
        startPlacementAnimationsIfNeeded(r4, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x04a8, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0492, code lost:
    
        r10 = r5.getLayoutMinOffset();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009b, code lost:
    
        if (r2 >= r1) goto L226;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x04ab, code lost:
    
        r7 = r43;
        r11 = r44;
        kotlin.collections.ArraysKt.fill$default(r6, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x04cb, code lost:
    
        if (r41.movingAwayToEndBound.isEmpty() != false) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x04cd, code lost:
    
        r1 = r41.movingAwayToEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x04d4, code lost:
    
        if (r1.size() <= 1) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x04d6, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$2(r46));
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x04e0, code lost:
    
        r1 = r41.movingAwayToEndBound;
        r2 = r1.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x04ea, code lost:
    
        if (r3 >= r2) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x04ec, code lost:
    
        r4 = r1.get(r3);
        r5 = r41.keyToItemInfoMap.get(r4.getKey());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r5 = r5;
        r9 = updateAndReturnOffsetFor(r6, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0505, code lost:
    
        if (r49 == false) goto L215;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0507, code lost:
    
        r10 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) kotlin.collections.CollectionsKt.last((java.util.List) r45);
        r12 = getMainAxisOffset(r10) + r10.getMainAxisSizeWithSpacings();
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x051b, code lost:
    
        r4.position((r12 - r4.getMainAxisSizeWithSpacings()) + r9, r5.getCrossAxisOffset(), r7, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0529, code lost:
    
        if (r23 == false) goto L269;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x052b, code lost:
    
        startPlacementAnimationsIfNeeded(r4, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x052e, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0517, code lost:
    
        r12 = r5.getLayoutMaxOffset();
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0531, code lost:
    
        r1 = r41.movingAwayToStartBound;
        kotlin.collections.CollectionsKt.reverse(r1);
        r2 = kotlin.Unit.INSTANCE;
        r45.addAll(0, r1);
        r45.addAll(r41.movingAwayToEndBound);
        r41.movingInFromStartBound.clear();
        r41.movingInFromEndBound.clear();
        r41.movingAwayToStartBound.clear();
        r41.movingAwayToEndBound.clear();
        r41.movingAwayKeys.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a1, code lost:
    
        if ((r14 & 255) >= 128) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x055e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x04bf, code lost:
    
        r7 = r43;
        r11 = r44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x00c0, code lost:
    
        if (r12 == r13) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x00c2, code lost:
    
        r12 = r12 + 1;
        r2 = r25;
        r1 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x00c9, code lost:
    
        r25 = r2;
        r23 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0063, code lost:
    
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0054, code lost:
    
        r4 = androidx.compose.ui.unit.IntOffset.m7111constructorimpl(r42 << 32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0043, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a3, code lost:
    
        r28 = r2;
        r29 = r14;
        r41.movingAwayKeys.add(r15[(r12 << 3) + r2]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b7, code lost:
    
        r14 = r29 >> 8;
        r2 = r28 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b3, code lost:
    
        r28 = r2;
        r29 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00be, code lost:
    
        if (r1 != 8) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00cd, code lost:
    
        r1 = r25.size();
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d3, code lost:
    
        if (r2 >= r1) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d5, code lost:
    
        r14 = r45.get(r2);
        r41.movingAwayKeys.remove(r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e8, code lost:
    
        if (getHasAnimations(r14) == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ea, code lost:
    
        r24 = r41.keyToItemInfoMap.get(r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f8, code lost:
    
        if (r11 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00fa, code lost:
    
        r13 = r11.getIndex(r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0104, code lost:
    
        if (r13 != (-1)) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0106, code lost:
    
        if (r11 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0108, code lost:
    
        r15 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x010b, code lost:
    
        if (r24 != null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x010d, code lost:
    
        r12 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo(r41);
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo.updateAnimation$default(r12, r14, r54, r55, r52, r53, 0, 32, null);
        r34 = r1;
        r35 = r2;
        r41.keyToItemInfoMap.set(r14.getKey(), r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0138, code lost:
    
        if (r14.getIndex() == r13) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x013b, code lost:
    
        if (r13 == (-1)) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x013d, code lost:
    
        if (r13 >= r3) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x013f, code lost:
    
        r41.movingInFromStartBound.add(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01ff, code lost:
    
        r2 = r35 + 1;
        r1 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0146, code lost:
    
        r41.movingInFromEndBound.add(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014d, code lost:
    
        r24 = r14.mo1163getOffsetBjo55l4(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0156, code lost:
    
        if (r14.getIsVertical() == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0158, code lost:
    
        r1 = androidx.compose.ui.unit.IntOffset.m7118getYimpl(r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0161, code lost:
    
        initializeAnimation(r14, r1, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0164, code lost:
    
        if (r15 == false) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0166, code lost:
    
        r1 = r12.getAnimations();
        r2 = r1.length;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x016c, code lost:
    
        if (r12 >= r2) goto L234;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x016e, code lost:
    
        r13 = r1[r12];
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0170, code lost:
    
        if (r13 == null) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0172, code lost:
    
        r13.animateAppearance();
        r13 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0177, code lost:
    
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x015d, code lost:
    
        r1 = androidx.compose.ui.unit.IntOffset.m7117getXimpl(r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x017a, code lost:
    
        r34 = r1;
        r35 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x017e, code lost:
    
        if (r23 == false) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0180, code lost:
    
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo.updateAnimation$default(r24, r14, r54, r55, r52, r53, 0, 32, null);
        r1 = r24.getAnimations();
        r2 = r1.length;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0199, code lost:
    
        if (r12 >= r2) goto L239;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x019b, code lost:
    
        r13 = r1[r12];
        r25 = r1;
        r26 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01a1, code lost:
    
        if (r13 == null) goto L241;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01b1, code lost:
    
        if (androidx.compose.ui.unit.IntOffset.m7116equalsimpl0(r13.getRawOffset(), androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.INSTANCE.m1216getNotInitializednOccac()) != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0034, code lost:
    
        r3 = r41.firstVisibleIndex;
        r4 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) kotlin.collections.CollectionsKt.firstOrNull((java.util.List) r45);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01b3, code lost:
    
        r13.m1215setRawOffsetgyyYBs(androidx.compose.ui.unit.IntOffset.m7121plusqkQi6aY(r13.getRawOffset(), r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01be, code lost:
    
        r12 = r12 + 1;
        r1 = r25;
        r2 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01c5, code lost:
    
        if (r15 == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c7, code lost:
    
        r1 = r24.getAnimations();
        r2 = r1.length;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01cd, code lost:
    
        if (r6 >= r2) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01cf, code lost:
    
        r7 = r1[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003c, code lost:
    
        if (r4 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01d1, code lost:
    
        if (r7 == null) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d7, code lost:
    
        if (r7.isDisappearanceAnimationInProgress() == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d9, code lost:
    
        r41.disappearingItems.remove(r7);
        r12 = r41.displayingNode;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01e0, code lost:
    
        if (r12 == null) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e2, code lost:
    
        androidx.compose.ui.node.DrawModifierNodeKt.invalidateDraw(r12);
        r12 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01e7, code lost:
    
        r7.animateAppearance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01ea, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003e, code lost:
    
        r4 = r4.getIndex();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasured(int r42, int r43, int r44, java.util.List<T> r45, final androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r46, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider<T> r47, boolean r48, boolean r49, int r50, boolean r51, int r52, int r53, kotlinx.coroutines.CoroutineScope r54, androidx.compose.ui.graphics.GraphicsContext r55) {
        /*
            Method dump skipped, instructions count: 1375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.onMeasured(int, int, int, java.util.List, androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider, boolean, boolean, int, boolean, int, int, kotlinx.coroutines.CoroutineScope, androidx.compose.ui.graphics.GraphicsContext):void");
    }

    private final void removeInfoForKey(Object key) {
        LazyLayoutItemAnimation[] animations;
        LazyLayoutItemAnimator<T>.ItemInfo remove = this.keyToItemInfoMap.remove(key);
        if (remove == null || (animations = remove.getAnimations()) == null) {
            return;
        }
        for (LazyLayoutItemAnimation lazyLayoutItemAnimation : animations) {
            if (lazyLayoutItemAnimation != null) {
                lazyLayoutItemAnimation.release();
            }
        }
    }

    public final void reset() {
        releaseAnimations();
        this.keyIndexMap = null;
        this.firstVisibleIndex = -1;
    }

    private final void releaseAnimations() {
        if (this.keyToItemInfoMap.isNotEmpty()) {
            MutableScatterMap<Object, LazyLayoutItemAnimator<T>.ItemInfo> mutableScatterMap = this.keyToItemInfoMap;
            Object[] objArr = mutableScatterMap.values;
            long[] jArr = mutableScatterMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                for (LazyLayoutItemAnimation lazyLayoutItemAnimation : ((ItemInfo) objArr[(i << 3) + i3]).getAnimations()) {
                                    if (lazyLayoutItemAnimation != null) {
                                        lazyLayoutItemAnimation.release();
                                    }
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            this.keyToItemInfoMap.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void initializeAnimation$default(LazyLayoutItemAnimator lazyLayoutItemAnimator, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, int i, ItemInfo itemInfo, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            LazyLayoutItemAnimator<T>.ItemInfo itemInfo2 = lazyLayoutItemAnimator.keyToItemInfoMap.get(lazyLayoutMeasuredItem.getKey());
            Intrinsics.checkNotNull(itemInfo2);
            itemInfo = itemInfo2;
        }
        lazyLayoutItemAnimator.initializeAnimation(lazyLayoutMeasuredItem, i, itemInfo);
    }

    private final void initializeAnimation(T item, int mainAxisOffset, LazyLayoutItemAnimator<T>.ItemInfo itemInfo) {
        long m7113copyiSbpLlY$default;
        int i = 0;
        long mo1163getOffsetBjo55l4 = item.mo1163getOffsetBjo55l4(0);
        if (item.getIsVertical()) {
            m7113copyiSbpLlY$default = IntOffset.m7113copyiSbpLlY$default(mo1163getOffsetBjo55l4, 0, mainAxisOffset, 1, null);
        } else {
            m7113copyiSbpLlY$default = IntOffset.m7113copyiSbpLlY$default(mo1163getOffsetBjo55l4, mainAxisOffset, 0, 2, null);
        }
        LazyLayoutItemAnimation[] animations = itemInfo.getAnimations();
        int length = animations.length;
        int i2 = 0;
        while (i < length) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = animations[i];
            int i3 = i2 + 1;
            if (lazyLayoutItemAnimation != null) {
                lazyLayoutItemAnimation.m1215setRawOffsetgyyYBs(IntOffset.m7121plusqkQi6aY(m7113copyiSbpLlY$default, IntOffset.m7120minusqkQi6aY(item.mo1163getOffsetBjo55l4(i2), mo1163getOffsetBjo55l4)));
            }
            i++;
            i2 = i3;
        }
    }

    static /* synthetic */ void startPlacementAnimationsIfNeeded$default(LazyLayoutItemAnimator lazyLayoutItemAnimator, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        lazyLayoutItemAnimator.startPlacementAnimationsIfNeeded(lazyLayoutMeasuredItem, z);
    }

    private final void startPlacementAnimationsIfNeeded(T item, boolean isMovingAway) {
        LazyLayoutItemAnimator<T>.ItemInfo itemInfo = this.keyToItemInfoMap.get(item.getKey());
        Intrinsics.checkNotNull(itemInfo);
        LazyLayoutItemAnimation[] animations = itemInfo.getAnimations();
        int length = animations.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = animations[i];
            int i3 = i2 + 1;
            if (lazyLayoutItemAnimation != null) {
                long mo1163getOffsetBjo55l4 = item.mo1163getOffsetBjo55l4(i2);
                long rawOffset = lazyLayoutItemAnimation.getRawOffset();
                if (!IntOffset.m7116equalsimpl0(rawOffset, LazyLayoutItemAnimation.INSTANCE.m1216getNotInitializednOccac()) && !IntOffset.m7116equalsimpl0(rawOffset, mo1163getOffsetBjo55l4)) {
                    lazyLayoutItemAnimation.m1208animatePlacementDeltaar5cAso(IntOffset.m7120minusqkQi6aY(mo1163getOffsetBjo55l4, rawOffset), isMovingAway);
                }
                lazyLayoutItemAnimation.m1215setRawOffsetgyyYBs(mo1163getOffsetBjo55l4);
            }
            i++;
            i2 = i3;
        }
    }

    public final LazyLayoutItemAnimation getAnimation(Object key, int placeableIndex) {
        LazyLayoutItemAnimation[] animations;
        LazyLayoutItemAnimator<T>.ItemInfo itemInfo = this.keyToItemInfoMap.get(key);
        if (itemInfo == null || (animations = itemInfo.getAnimations()) == null) {
            return null;
        }
        return animations[placeableIndex];
    }

    private final int updateAndReturnOffsetFor(int[] iArr, T t) {
        int lane = t.getLane();
        int span = t.getSpan() + lane;
        int i = 0;
        while (lane < span) {
            int mainAxisSizeWithSpacings = iArr[lane] + t.getMainAxisSizeWithSpacings();
            iArr[lane] = mainAxisSizeWithSpacings;
            i = Math.max(i, mainAxisSizeWithSpacings);
            lane++;
        }
        return i;
    }

    /* renamed from: getMinSizeToFitDisappearingItems-YbymL2g, reason: not valid java name */
    public final long m1217getMinSizeToFitDisappearingItemsYbymL2g() {
        long m7165getZeroYbymL2g = IntSize.INSTANCE.m7165getZeroYbymL2g();
        List<LazyLayoutItemAnimation> list = this.disappearingItems;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = list.get(i);
            GraphicsLayer layer = lazyLayoutItemAnimation.getLayer();
            if (layer != null) {
                m7165getZeroYbymL2g = IntSize.m7155constructorimpl((Math.max((int) (m7165getZeroYbymL2g & 4294967295L), IntOffset.m7118getYimpl(lazyLayoutItemAnimation.getRawOffset()) + ((int) (layer.getSize() & 4294967295L))) & 4294967295L) | (Math.max((int) (m7165getZeroYbymL2g >> 32), IntOffset.m7117getXimpl(lazyLayoutItemAnimation.getRawOffset()) + ((int) (layer.getSize() >> 32))) << 32));
            }
        }
        return m7165getZeroYbymL2g;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    private final boolean getHasAnimations(T t) {
        int placeablesCount = t.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            if (LazyLayoutItemAnimatorKt.access$getSpecs(t.getParentData(i)) != null) {
                return true;
            }
        }
        return false;
    }

    private final int getMainAxisOffset(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        long mo1163getOffsetBjo55l4 = lazyLayoutMeasuredItem.mo1163getOffsetBjo55l4(0);
        return lazyLayoutMeasuredItem.getIsVertical() ? IntOffset.m7118getYimpl(mo1163getOffsetBjo55l4) : IntOffset.m7117getXimpl(mo1163getOffsetBjo55l4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCrossAxisOffset(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        long mo1163getOffsetBjo55l4 = lazyLayoutMeasuredItem.mo1163getOffsetBjo55l4(0);
        return !lazyLayoutMeasuredItem.getIsVertical() ? IntOffset.m7118getYimpl(mo1163getOffsetBjo55l4) : IntOffset.m7117getXimpl(mo1163getOffsetBjo55l4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyLayoutItemAnimator.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J=\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00028\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010*R0\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u001e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u001a\u0010 \u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", "", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "<set-?>", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "animations", "getAnimations", "()[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "setConstraints-_Sx5XlM", "(Landroidx/compose/ui/unit/Constraints;)V", "crossAxisOffset", "", "getCrossAxisOffset", "()I", "setCrossAxisOffset", "(I)V", "isRunningPlacement", "", "()Z", "lane", "getLane", "setLane", "layoutMaxOffset", "getLayoutMaxOffset", "layoutMinOffset", "getLayoutMinOffset", "span", "getSpan", "setSpan", "updateAnimation", "", "positionedItem", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;III)V", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public final class ItemInfo {
        private Constraints constraints;
        private int crossAxisOffset;
        private int lane;
        private int layoutMaxOffset;
        private int layoutMinOffset;
        private LazyLayoutItemAnimation[] animations = LazyLayoutItemAnimatorKt.access$getEmptyArray$p();
        private int span = 1;

        public ItemInfo() {
        }

        public final LazyLayoutItemAnimation[] getAnimations() {
            return this.animations;
        }

        /* renamed from: getConstraints-DWUhwKw, reason: not valid java name and from getter */
        public final Constraints getConstraints() {
            return this.constraints;
        }

        /* renamed from: setConstraints-_Sx5XlM, reason: not valid java name */
        public final void m1219setConstraints_Sx5XlM(Constraints constraints) {
            this.constraints = constraints;
        }

        public final int getCrossAxisOffset() {
            return this.crossAxisOffset;
        }

        public final void setCrossAxisOffset(int i) {
            this.crossAxisOffset = i;
        }

        public final int getLane() {
            return this.lane;
        }

        public final void setLane(int i) {
            this.lane = i;
        }

        public final int getSpan() {
            return this.span;
        }

        public final void setSpan(int i) {
            this.span = i;
        }

        private final boolean isRunningPlacement() {
            for (LazyLayoutItemAnimation lazyLayoutItemAnimation : this.animations) {
                if (lazyLayoutItemAnimation != null && lazyLayoutItemAnimation.getIsRunningMovingAwayAnimation()) {
                    return true;
                }
            }
            return false;
        }

        public final int getLayoutMinOffset() {
            return this.layoutMinOffset;
        }

        public final int getLayoutMaxOffset() {
            return this.layoutMaxOffset;
        }

        public static /* synthetic */ void updateAnimation$default(ItemInfo itemInfo, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, CoroutineScope coroutineScope, GraphicsContext graphicsContext, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 32) != 0) {
                i3 = LazyLayoutItemAnimator.this.getCrossAxisOffset(lazyLayoutMeasuredItem);
            }
            itemInfo.updateAnimation(lazyLayoutMeasuredItem, coroutineScope, graphicsContext, i, i2, i3);
        }

        public final void updateAnimation(T positionedItem, CoroutineScope coroutineScope, GraphicsContext graphicsContext, int layoutMinOffset, int layoutMaxOffset, int crossAxisOffset) {
            LazyLayoutItemAnimation[] lazyLayoutItemAnimationArr;
            if (!isRunningPlacement()) {
                this.layoutMinOffset = layoutMinOffset;
                this.layoutMaxOffset = layoutMaxOffset;
            }
            int placeablesCount = positionedItem.getPlaceablesCount();
            int length = this.animations.length;
            while (true) {
                lazyLayoutItemAnimationArr = this.animations;
                if (placeablesCount >= length) {
                    break;
                }
                LazyLayoutItemAnimation lazyLayoutItemAnimation = lazyLayoutItemAnimationArr[placeablesCount];
                if (lazyLayoutItemAnimation != null) {
                    lazyLayoutItemAnimation.release();
                }
                placeablesCount++;
            }
            if (lazyLayoutItemAnimationArr.length != positionedItem.getPlaceablesCount()) {
                Object[] copyOf = Arrays.copyOf(this.animations, positionedItem.getPlaceablesCount());
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                this.animations = (LazyLayoutItemAnimation[]) copyOf;
            }
            this.constraints = Constraints.m6929boximpl(positionedItem.getConstraints());
            this.crossAxisOffset = crossAxisOffset;
            this.lane = positionedItem.getLane();
            this.span = positionedItem.getSpan();
            int placeablesCount2 = positionedItem.getPlaceablesCount();
            final LazyLayoutItemAnimator<T> lazyLayoutItemAnimator = LazyLayoutItemAnimator.this;
            for (int i = 0; i < placeablesCount2; i++) {
                LazyLayoutAnimationSpecsNode access$getSpecs = LazyLayoutItemAnimatorKt.access$getSpecs(positionedItem.getParentData(i));
                LazyLayoutItemAnimation[] lazyLayoutItemAnimationArr2 = this.animations;
                if (access$getSpecs == null) {
                    LazyLayoutItemAnimation lazyLayoutItemAnimation2 = lazyLayoutItemAnimationArr2[i];
                    if (lazyLayoutItemAnimation2 != null) {
                        lazyLayoutItemAnimation2.release();
                    }
                    this.animations[i] = null;
                } else {
                    LazyLayoutItemAnimation lazyLayoutItemAnimation3 = lazyLayoutItemAnimationArr2[i];
                    if (lazyLayoutItemAnimation3 == null) {
                        lazyLayoutItemAnimation3 = new LazyLayoutItemAnimation(coroutineScope, graphicsContext, new Function0<Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo$updateAnimation$1$animation$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                DrawModifierNode drawModifierNode;
                                drawModifierNode = ((LazyLayoutItemAnimator) lazyLayoutItemAnimator).displayingNode;
                                if (drawModifierNode != null) {
                                    DrawModifierNodeKt.invalidateDraw(drawModifierNode);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }
                        });
                        this.animations[i] = lazyLayoutItemAnimation3;
                    }
                    lazyLayoutItemAnimation3.setFadeInSpec(access$getSpecs.getFadeInSpec());
                    lazyLayoutItemAnimation3.setPlacementSpec(access$getSpecs.getPlacementSpec());
                    lazyLayoutItemAnimation3.setFadeOutSpec(access$getSpecs.getFadeOutSpec());
                }
            }
        }
    }

    /* compiled from: LazyLayoutItemAnimator.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0004HÂ\u0003J\u0017\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004HÆ\u0001J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\f\u0010\u0014\u001a\u00020\u0012*\u00020\u0015H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "component1", "copy", "create", "equals", "", WriteOffReason.OTHER, "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    private static final /* data */ class DisplayingDisappearingItemsElement extends ModifierNodeElement<DisplayingDisappearingItemsNode> {
        private final LazyLayoutItemAnimator<?> animator;

        private final LazyLayoutItemAnimator<?> component1() {
            return this.animator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DisplayingDisappearingItemsElement copy$default(DisplayingDisappearingItemsElement displayingDisappearingItemsElement, LazyLayoutItemAnimator lazyLayoutItemAnimator, int i, Object obj) {
            if ((i & 1) != 0) {
                lazyLayoutItemAnimator = displayingDisappearingItemsElement.animator;
            }
            return displayingDisappearingItemsElement.copy(lazyLayoutItemAnimator);
        }

        public final DisplayingDisappearingItemsElement copy(LazyLayoutItemAnimator<?> animator) {
            return new DisplayingDisappearingItemsElement(animator);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DisplayingDisappearingItemsElement) && Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsElement) other).animator);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public int hashCode() {
            return this.animator.hashCode();
        }

        public String toString() {
            return "DisplayingDisappearingItemsElement(animator=" + this.animator + ')';
        }

        public DisplayingDisappearingItemsElement(LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            this.animator = lazyLayoutItemAnimator;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* renamed from: create */
        public DisplayingDisappearingItemsNode getNode() {
            return new DisplayingDisappearingItemsNode(this.animator);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(DisplayingDisappearingItemsNode node) {
            node.setAnimator(this.animator);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.setName("DisplayingDisappearingItemsElement");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyLayoutItemAnimator.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0004HÂ\u0003J\u0017\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u000f2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\f\u0010\u0014\u001a\u00020\u000f*\u00020\u0015H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "component1", "copy", "equals", "", WriteOffReason.OTHER, "", "hashCode", "", "onAttach", "", "onDetach", "setAnimator", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final /* data */ class DisplayingDisappearingItemsNode extends Modifier.Node implements DrawModifierNode {
        private LazyLayoutItemAnimator<?> animator;

        private final LazyLayoutItemAnimator<?> component1() {
            return this.animator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DisplayingDisappearingItemsNode copy$default(DisplayingDisappearingItemsNode displayingDisappearingItemsNode, LazyLayoutItemAnimator lazyLayoutItemAnimator, int i, Object obj) {
            if ((i & 1) != 0) {
                lazyLayoutItemAnimator = displayingDisappearingItemsNode.animator;
            }
            return displayingDisappearingItemsNode.copy(lazyLayoutItemAnimator);
        }

        public final DisplayingDisappearingItemsNode copy(LazyLayoutItemAnimator<?> animator) {
            return new DisplayingDisappearingItemsNode(animator);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DisplayingDisappearingItemsNode) && Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsNode) other).animator);
        }

        public int hashCode() {
            return this.animator.hashCode();
        }

        public String toString() {
            return "DisplayingDisappearingItemsNode(animator=" + this.animator + ')';
        }

        public DisplayingDisappearingItemsNode(LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            this.animator = lazyLayoutItemAnimator;
        }

        @Override // androidx.compose.ui.node.DrawModifierNode
        public void draw(ContentDrawScope contentDrawScope) {
            List list = ((LazyLayoutItemAnimator) this.animator).disappearingItems;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                LazyLayoutItemAnimation lazyLayoutItemAnimation = (LazyLayoutItemAnimation) list.get(i);
                GraphicsLayer layer = lazyLayoutItemAnimation.getLayer();
                if (layer != null) {
                    float m7117getXimpl = IntOffset.m7117getXimpl(lazyLayoutItemAnimation.getFinalOffset());
                    ContentDrawScope contentDrawScope2 = contentDrawScope;
                    float m7117getXimpl2 = m7117getXimpl - IntOffset.m7117getXimpl(layer.getTopLeft());
                    float m7118getYimpl = IntOffset.m7118getYimpl(lazyLayoutItemAnimation.getFinalOffset()) - IntOffset.m7118getYimpl(layer.getTopLeft());
                    contentDrawScope2.getDrawContext().getTransform().translate(m7117getXimpl2, m7118getYimpl);
                    try {
                        GraphicsLayerKt.drawLayer(contentDrawScope2, layer);
                    } finally {
                        contentDrawScope2.getDrawContext().getTransform().translate(-m7117getXimpl2, -m7118getYimpl);
                    }
                }
            }
            contentDrawScope.drawContent();
        }

        @Override // androidx.compose.ui.Modifier.Node
        public void onAttach() {
            ((LazyLayoutItemAnimator) this.animator).displayingNode = this;
        }

        @Override // androidx.compose.ui.Modifier.Node
        public void onDetach() {
            this.animator.reset();
        }

        public final void setAnimator(LazyLayoutItemAnimator<?> animator) {
            if (Intrinsics.areEqual(this.animator, animator) || !getNode().getIsAttached()) {
                return;
            }
            this.animator.reset();
            ((LazyLayoutItemAnimator) animator).displayingNode = this;
            this.animator = animator;
        }
    }
}
