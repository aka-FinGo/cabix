package androidx.compose.ui.platform;

import android.content.res.Resources;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.R;
import androidx.compose.ui.contentcapture.ContentCaptureManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001aR\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000b2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u001dj\b\u0012\u0004\u0012\u00020\u000b`\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0!0 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a\u0010\u0010%\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u000bH\u0002\u001a\u001a\u0010&\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002\u001a\u0018\u0010)\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001aL\u0010*\u001a\u00020\u00012:\u0010+\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020-\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0!0,0\u001dj\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020-\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0!0,`\u001e2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002\u001a.\u0010.\u001a\u00020\u001a2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001aL\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0!2\u0006\u00103\u001a\u00020\u00012\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u001dj\b\u0012\u0004\u0012\u00020\u000b`\u001e2\u0006\u0010\u0017\u001a\u00020\u00182\u0014\b\u0002\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0!0 H\u0002\u001a:\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b0!2\u0006\u00103\u001a\u00020\u00012\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b082\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a\u001a\u00109\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002\u001a\f\u0010=\u001a\u00020\u0001*\u00020\u000bH\u0002\u001a\f\u0010>\u001a\u00020\u0001*\u00020\u000bH\u0002\u001a\"\u0010?\u001a\u0004\u0018\u00010@*\u00020@2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u00010BH\u0002\u001a\u0014\u0010C\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010D\u001a\u00020EH\u0002\"*\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u00018G@GX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\" \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000\"&\u0010\r\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\u000fj\b\u0012\u0004\u0012\u00020\u000b`\u00100\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011\"\u0018\u0010\u0012\u001a\u00020\u0001*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006F"}, d2 = {"value", "", "DisableContentCapture", "getDisableContentCapture$annotations", "()V", "getDisableContentCapture", "()Z", "setDisableContentCapture", "(Z)V", "UnmergedConfigComparator", "Lkotlin/Function2;", "Landroidx/compose/ui/semantics/SemanticsNode;", "", "semanticComparators", "", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "[Ljava/util/Comparator;", "isRtl", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "createStateDescriptionForTextField", "", "node", "resources", "Landroid/content/res/Resources;", "geometryDepthFirstSearch", "", "currNode", "geometryList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "containerMapToChildren", "Landroidx/collection/MutableIntObjectMap;", "", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getInfoIsCheckable", "getInfoStateDescriptionOrNull", "getInfoText", "Landroidx/compose/ui/text/AnnotatedString;", "isScreenReaderFocusable", "placedEntryRowOverlaps", "rowGroupings", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", "setTraversalValues", "outputBeforeMap", "Landroidx/collection/MutableIntIntMap;", "outputAfterMap", "sortByGeometryGroupings", "layoutIsRtl", "parentListToSort", "containerChildrenMapping", "subtreeSortedByGeometryGrouping", "listToSort", "", "accessibilityEquals", "Landroidx/compose/ui/semantics/AccessibilityAction;", WriteOffReason.OTHER, "", "enabled", "excludeLineAndPageGranularities", "findClosestParentNode", "Landroidx/compose/ui/node/LayoutNode;", "selector", "Lkotlin/Function1;", "propertiesDeleted", "oldConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat_androidKt {
    private static final Function2<SemanticsNode, SemanticsNode, Integer> UnmergedConfigComparator;
    private static final Comparator<SemanticsNode>[] semanticComparators;

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use ContentCapture.isEnabled instead", replaceWith = @ReplaceWith(expression = "!ContentCaptureManager.isEnabled", imports = {"androidx.compose.ui.contentcapture.ContentCaptureManager.Companion.isEnabled"}))
    public static /* synthetic */ void getDisableContentCapture$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutNode findClosestParentNode(LayoutNode layoutNode, Function1<? super LayoutNode, Boolean> function1) {
        for (LayoutNode parent$ui_release = layoutNode.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (function1.invoke(parent$ui_release).booleanValue()) {
                return parent$ui_release;
            }
        }
        return null;
    }

    static {
        Comparator comparator;
        Comparator<SemanticsNode>[] comparatorArr = new Comparator[2];
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                comparator = RtlBoundsComparator.INSTANCE;
            } else {
                comparator = LtrBoundsComparator.INSTANCE;
            }
            final Comparator comparator2 = comparator;
            final Comparator<LayoutNode> zComparator$ui_release = LayoutNode.INSTANCE.getZComparator$ui_release();
            final Comparator comparator3 = new Comparator() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$special$$inlined$thenBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int compare = comparator2.compare(t, t2);
                    return compare != 0 ? compare : zComparator$ui_release.compare(((SemanticsNode) t).getLayoutNode(), ((SemanticsNode) t2).getLayoutNode());
                }
            };
            comparatorArr[i] = new Comparator() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$special$$inlined$thenBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int compare = comparator3.compare(t, t2);
                    return compare != 0 ? compare : ComparisonsKt.compareValues(Integer.valueOf(((SemanticsNode) t).getId()), Integer.valueOf(((SemanticsNode) t2).getId()));
                }
            };
        }
        semanticComparators = comparatorArr;
        UnmergedConfigComparator = new Function2<SemanticsNode, SemanticsNode, Integer>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$UnmergedConfigComparator$1
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
                return Integer.valueOf(Float.compare(((Number) semanticsNode.getUnmergedConfig().getOrElse(SemanticsProperties.INSTANCE.getTraversalIndex(), new Function0<Float>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$UnmergedConfigComparator$1.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(0.0f);
                    }
                })).floatValue(), ((Number) semanticsNode2.getUnmergedConfig().getOrElse(SemanticsProperties.INSTANCE.getTraversalIndex(), new Function0<Float>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$UnmergedConfigComparator$1.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(0.0f);
                    }
                })).floatValue()));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTraversalValues(IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap, MutableIntIntMap mutableIntIntMap, MutableIntIntMap mutableIntIntMap2, Resources resources) {
        mutableIntIntMap.clear();
        mutableIntIntMap2.clear();
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = intObjectMap.get(-1);
        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
        Intrinsics.checkNotNull(semanticsNode);
        List<SemanticsNode> subtreeSortedByGeometryGrouping = subtreeSortedByGeometryGrouping(isRtl(semanticsNode), CollectionsKt.listOf(semanticsNode), intObjectMap, resources);
        int lastIndex = CollectionsKt.getLastIndex(subtreeSortedByGeometryGrouping);
        int i = 1;
        if (1 > lastIndex) {
            return;
        }
        while (true) {
            int id = subtreeSortedByGeometryGrouping.get(i - 1).getId();
            int id2 = subtreeSortedByGeometryGrouping.get(i).getId();
            mutableIntIntMap.set(id, id2);
            mutableIntIntMap2.set(id2, id);
            if (i == lastIndex) {
                return;
            } else {
                i++;
            }
        }
    }

    private static final List<SemanticsNode> subtreeSortedByGeometryGrouping(boolean z, List<SemanticsNode> list, IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap, Resources resources) {
        MutableIntObjectMap mutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            geometryDepthFirstSearch(list.get(i), arrayList, mutableIntObjectMapOf, intObjectMap, resources);
        }
        return sortByGeometryGroupings(z, arrayList, resources, mutableIntObjectMapOf);
    }

    private static final void geometryDepthFirstSearch(SemanticsNode semanticsNode, ArrayList<SemanticsNode> arrayList, MutableIntObjectMap<List<SemanticsNode>> mutableIntObjectMap, IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap, Resources resources) {
        boolean isRtl = isRtl(semanticsNode);
        boolean booleanValue = ((Boolean) semanticsNode.getUnmergedConfig().getOrElse(SemanticsProperties.INSTANCE.getIsTraversalGroup(), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$geometryDepthFirstSearch$isTraversalGroup$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return false;
            }
        })).booleanValue();
        if ((booleanValue || isScreenReaderFocusable(semanticsNode, resources)) && intObjectMap.containsKey(semanticsNode.getId())) {
            arrayList.add(semanticsNode);
        }
        if (booleanValue) {
            mutableIntObjectMap.set(semanticsNode.getId(), subtreeSortedByGeometryGrouping(isRtl, semanticsNode.getChildren(), intObjectMap, resources));
            return;
        }
        List<SemanticsNode> children = semanticsNode.getChildren();
        int size = children.size();
        for (int i = 0; i < size; i++) {
            geometryDepthFirstSearch(children.get(i), arrayList, mutableIntObjectMap, intObjectMap, resources);
        }
    }

    static /* synthetic */ List sortByGeometryGroupings$default(boolean z, ArrayList arrayList, Resources resources, MutableIntObjectMap mutableIntObjectMap, int i, Object obj) {
        if ((i & 8) != 0) {
            mutableIntObjectMap = IntObjectMapKt.mutableIntObjectMapOf();
        }
        return sortByGeometryGroupings(z, arrayList, resources, mutableIntObjectMap);
    }

    private static final List<SemanticsNode> sortByGeometryGroupings(boolean z, ArrayList<SemanticsNode> arrayList, Resources resources, MutableIntObjectMap<List<SemanticsNode>> mutableIntObjectMap) {
        ArrayList arrayList2 = new ArrayList(arrayList.size() / 2);
        int lastIndex = CollectionsKt.getLastIndex(arrayList);
        int i = 0;
        if (lastIndex >= 0) {
            int i2 = 0;
            while (true) {
                SemanticsNode semanticsNode = arrayList.get(i2);
                if (i2 == 0 || !placedEntryRowOverlaps(arrayList2, semanticsNode)) {
                    arrayList2.add(new Pair(semanticsNode.getBoundsInWindow(), CollectionsKt.mutableListOf(semanticsNode)));
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        ArrayList arrayList3 = arrayList2;
        CollectionsKt.sortWith(arrayList3, TopBottomBoundsComparator.INSTANCE);
        ArrayList arrayList4 = new ArrayList();
        Comparator<SemanticsNode> comparator = semanticComparators[!z ? 1 : 0];
        int size = arrayList3.size();
        for (int i3 = 0; i3 < size; i3++) {
            Pair pair = (Pair) arrayList3.get(i3);
            CollectionsKt.sortWith((List) pair.getSecond(), comparator);
            arrayList4.addAll((Collection) pair.getSecond());
        }
        ArrayList arrayList5 = arrayList4;
        final Function2<SemanticsNode, SemanticsNode, Integer> function2 = UnmergedConfigComparator;
        CollectionsKt.sortWith(arrayList5, new Comparator() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int intValue;
                intValue = ((Number) Function2.this.invoke(obj, obj2)).intValue();
                return intValue;
            }
        });
        while (i <= CollectionsKt.getLastIndex(arrayList5)) {
            List<SemanticsNode> list = mutableIntObjectMap.get(((SemanticsNode) arrayList4.get(i)).getId());
            if (list != null) {
                if (isScreenReaderFocusable((SemanticsNode) arrayList4.get(i), resources)) {
                    i++;
                } else {
                    arrayList4.remove(i);
                }
                arrayList4.addAll(i, list);
                i += list.size();
            } else {
                i++;
            }
        }
        return arrayList5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isScreenReaderFocusable(SemanticsNode semanticsNode, Resources resources) {
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getContentDescription());
        return !SemanticsUtils_androidKt.isHidden(semanticsNode) && (semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants() || (semanticsNode.isUnmergedLeafNode$ui_release() && ((list != null ? (String) CollectionsKt.firstOrNull(list) : null) != null || getInfoText(semanticsNode) != null || getInfoStateDescriptionOrNull(semanticsNode, resources) != null || getInfoIsCheckable(semanticsNode))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString getInfoText(SemanticsNode semanticsNode) {
        AnnotatedString annotatedString = (AnnotatedString) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getEditableText());
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
        return annotatedString == null ? list != null ? (AnnotatedString) CollectionsKt.firstOrNull(list) : null : annotatedString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getInfoStateDescriptionOrNull(SemanticsNode semanticsNode, Resources resources) {
        Object orNull = SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getStateDescription());
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
        int i = 0;
        if (toggleableState != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i2 == 1) {
                if ((role == null ? false : Role.m6195equalsimpl0(role.getValue(), Role.INSTANCE.m6205getSwitcho7Vup1c())) && orNull == null) {
                    orNull = resources.getString(R.string.state_on);
                }
            } else if (i2 == 2) {
                if ((role == null ? false : Role.m6195equalsimpl0(role.getValue(), Role.INSTANCE.m6205getSwitcho7Vup1c())) && orNull == null) {
                    orNull = resources.getString(R.string.state_off);
                }
            } else if (i2 == 3 && orNull == null) {
                orNull = resources.getString(R.string.indeterminate);
            }
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (!(role == null ? false : Role.m6195equalsimpl0(role.getValue(), Role.INSTANCE.m6206getTabo7Vup1c())) && orNull == null) {
                if (booleanValue) {
                    orNull = resources.getString(R.string.selected);
                } else {
                    orNull = resources.getString(R.string.not_selected);
                }
            }
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (progressBarRangeInfo != null) {
            if (progressBarRangeInfo != ProgressBarRangeInfo.INSTANCE.getIndeterminate()) {
                if (orNull == null) {
                    ClosedFloatingPointRange<Float> range = progressBarRangeInfo.getRange();
                    float current = range.getEndInclusive().floatValue() - range.getStart().floatValue() == 0.0f ? 0.0f : (progressBarRangeInfo.getCurrent() - range.getStart().floatValue()) / (range.getEndInclusive().floatValue() - range.getStart().floatValue());
                    if (current < 0.0f) {
                        current = 0.0f;
                    }
                    if (current > 1.0f) {
                        current = 1.0f;
                    }
                    if (current != 0.0f) {
                        i = current == 1.0f ? 100 : RangesKt.coerceIn(Math.round(current * 100.0f), 1, 99);
                    }
                    orNull = resources.getString(R.string.template_percent, Integer.valueOf(i));
                }
            } else if (orNull == null) {
                orNull = resources.getString(R.string.in_progress);
            }
        }
        if (semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            orNull = createStateDescriptionForTextField(semanticsNode, resources);
        }
        return (String) orNull;
    }

    private static final String createStateDescriptionForTextField(SemanticsNode semanticsNode, Resources resources) {
        SemanticsConfiguration config = semanticsNode.copyWithMergingEnabled$ui_release().getConfig();
        Collection collection = (Collection) SemanticsConfigurationKt.getOrNull(config, SemanticsProperties.INSTANCE.getContentDescription());
        if (collection != null && !collection.isEmpty()) {
            return null;
        }
        Collection collection2 = (Collection) SemanticsConfigurationKt.getOrNull(config, SemanticsProperties.INSTANCE.getText());
        if (collection2 != null && !collection2.isEmpty()) {
            return null;
        }
        CharSequence charSequence = (CharSequence) SemanticsConfigurationKt.getOrNull(config, SemanticsProperties.INSTANCE.getEditableText());
        if (charSequence == null || charSequence.length() == 0) {
            return resources.getString(R.string.state_empty);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getInfoIsCheckable(SemanticsNode semanticsNode) {
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
        boolean z = toggleableState != null;
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            bool.booleanValue();
            if (!(role != null ? Role.m6195equalsimpl0(role.getValue(), Role.INSTANCE.m6206getTabo7Vup1c()) : false)) {
                return true;
            }
        }
        return z;
    }

    private static final boolean placedEntryRowOverlaps(ArrayList<Pair<Rect, List<SemanticsNode>>> arrayList, SemanticsNode semanticsNode) {
        float top = semanticsNode.getBoundsInWindow().getTop();
        float bottom = semanticsNode.getBoundsInWindow().getBottom();
        boolean z = top >= bottom;
        int lastIndex = CollectionsKt.getLastIndex(arrayList);
        if (lastIndex >= 0) {
            int i = 0;
            while (true) {
                Rect first = arrayList.get(i).getFirst();
                boolean z2 = first.getTop() >= first.getBottom();
                if (!z && !z2 && Math.max(top, first.getTop()) < Math.min(bottom, first.getBottom())) {
                    arrayList.set(i, new Pair<>(first.intersect(0.0f, top, Float.POSITIVE_INFINITY, bottom), arrayList.get(i).getSecond()));
                    arrayList.get(i).getSecond().add(semanticsNode);
                    return true;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enabled(SemanticsNode semanticsNode) {
        return !semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getDisabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean propertiesDeleted(SemanticsNode semanticsNode, SemanticsConfiguration semanticsConfiguration) {
        Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it = semanticsConfiguration.iterator();
        while (it.hasNext()) {
            if (!semanticsNode.getConfig().contains(it.next().getKey())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRtl(SemanticsNode semanticsNode) {
        return semanticsNode.getLayoutInfo().getLayoutDirection() == LayoutDirection.Rtl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean excludeLineAndPageGranularities(SemanticsNode semanticsNode) {
        if (semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText()) && !Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getFocused()), (Object) true)) {
            return true;
        }
        LayoutNode findClosestParentNode = findClosestParentNode(semanticsNode.getLayoutNode(), new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1
            /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
            
                if (r1.contains(androidx.compose.ui.semantics.SemanticsProperties.INSTANCE.getEditableText()) != false) goto L10;
             */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r2) {
                /*
                    r1 = this;
                    androidx.compose.ui.semantics.SemanticsConfiguration r1 = r2.getSemanticsConfiguration()
                    if (r1 == 0) goto L1a
                    boolean r2 = r1.getIsMergingSemanticsOfDescendants()
                    r0 = 1
                    if (r2 != r0) goto L1a
                    androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
                    androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getEditableText()
                    boolean r1 = r1.contains(r2)
                    if (r1 == 0) goto L1a
                    goto L1b
                L1a:
                    r0 = 0
                L1b:
                    java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1.invoke(androidx.compose.ui.node.LayoutNode):java.lang.Boolean");
            }
        });
        if (findClosestParentNode != null) {
            SemanticsConfiguration semanticsConfiguration = findClosestParentNode.getSemanticsConfiguration();
            if (!(semanticsConfiguration != null ? Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsProperties.INSTANCE.getFocused()), (Object) true) : false)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean accessibilityEquals(AccessibilityAction<?> accessibilityAction, Object obj) {
        if (accessibilityAction == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityAction)) {
            return false;
        }
        AccessibilityAction accessibilityAction2 = (AccessibilityAction) obj;
        if (!Intrinsics.areEqual(accessibilityAction.getLabel(), accessibilityAction2.getLabel())) {
            return false;
        }
        if (accessibilityAction.getAction() != null || accessibilityAction2.getAction() == null) {
            return accessibilityAction.getAction() == null || accessibilityAction2.getAction() != null;
        }
        return false;
    }

    public static final boolean getDisableContentCapture() {
        return ContentCaptureManager.INSTANCE.isEnabled();
    }

    public static final void setDisableContentCapture(boolean z) {
        ContentCaptureManager.INSTANCE.setEnabled(z);
    }
}
