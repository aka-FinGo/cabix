package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TabRow.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a\u0094\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0080\u0001\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u009a\u0001\u0010 \u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012.\b\u0002\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u00162\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u0086\u0001\u0010(\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a \u0001\u0010+\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2,\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a\u0094\u0001\u0010.\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u001c\u001a\u0080\u0001\u00100\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u001f\u001a\u0090\u0001\u00102\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102.\b\u0002\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u00162\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u001f\u001an\u00104\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a~\u00107\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102,\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u00162\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b8\u00106\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "TabRowIndicatorSpec", "PrimaryScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "Landroidx/compose/material3/TabIndicatorScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "divider", "Lkotlin/Function0;", "tabs", "PrimaryScrollableTabRow-qhFBPw4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PrimaryTabRow", "PrimaryTabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRow", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRowImpl", "ScrollableTabRowImpl-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ScrollableTabRowWithSubcomposeImpl", "ScrollableTabRowWithSubcomposeImpl-qhFBPw4", "(ILkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow", "SecondaryScrollableTabRow-qhFBPw4", "SecondaryTabRow", "SecondaryTabRow-pAZo6Ak", "TabRow", "TabRow-pAZo6Ak", "TabRowImpl", "TabRowImpl-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabRowWithSubcomposeImpl", "TabRowWithSubcomposeImpl-DTcfvLk", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = Dp.m6989constructorimpl(90.0f);
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final AnimationSpec<Dp> TabRowIndicatorSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    public static final /* synthetic */ AnimationSpec access$getTabRowIndicatorSpec$p() {
        return TabRowIndicatorSpec;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0082  */
    /* renamed from: PrimaryTabRow-pAZo6Ak */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2697PrimaryTabRowpAZo6Ak(final int r21, androidx.compose.ui.Modifier r22, long r23, long r25, kotlin.jvm.functions.Function3<? super androidx.compose.material3.TabIndicatorScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2697PrimaryTabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0082  */
    /* renamed from: SecondaryTabRow-pAZo6Ak */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2702SecondaryTabRowpAZo6Ak(final int r21, androidx.compose.ui.Modifier r22, long r23, long r25, kotlin.jvm.functions.Function3<? super androidx.compose.material3.TabIndicatorScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2702SecondaryTabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0082  */
    /* renamed from: TabRow-pAZo6Ak */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2703TabRowpAZo6Ak(final int r21, androidx.compose.ui.Modifier r22, long r23, long r25, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material3.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2703TabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00fe  */
    /* renamed from: PrimaryScrollableTabRow-qhFBPw4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2696PrimaryScrollableTabRowqhFBPw4(final int r21, androidx.compose.ui.Modifier r22, androidx.compose.foundation.ScrollState r23, long r24, long r26, float r28, kotlin.jvm.functions.Function3<? super androidx.compose.material3.TabIndicatorScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2696PrimaryScrollableTabRowqhFBPw4(int, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00fe  */
    /* renamed from: SecondaryScrollableTabRow-qhFBPw4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2701SecondaryScrollableTabRowqhFBPw4(final int r21, androidx.compose.ui.Modifier r22, androidx.compose.foundation.ScrollState r23, long r24, long r26, float r28, kotlin.jvm.functions.Function3<? super androidx.compose.material3.TabIndicatorScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2701SecondaryScrollableTabRowqhFBPw4(int, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00a1  */
    /* renamed from: ScrollableTabRow-sKfQg0A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2698ScrollableTabRowsKfQg0A(final int r19, androidx.compose.ui.Modifier r20, long r21, long r23, float r25, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material3.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2698ScrollableTabRowsKfQg0A(int, androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: TabRowImpl-DTcfvLk */
    public static final void m2704TabRowImplDTcfvLk(Modifier modifier, final long j, final long j2, final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        Modifier modifier2;
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1757425411);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabRowImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)576@28021L4041,572@27891L4171:TabRow.kt#uh7d8r");
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i2 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1757425411, i2, -1, "androidx.compose.material3.TabRowImpl (TabRow.kt:571)");
            }
            int i3 = i2 << 3;
            composer2 = startRestartGroup;
            SurfaceKt.m2648SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-65106680, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C577@28043L1274,618@29505L21,620@29556L2500,612@29327L2729:TabRow.kt#uh7d8r");
                    if ((i4 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-65106680, i4, -1, "androidx.compose.material3.TabRowImpl.<anonymous> (TabRow.kt:577)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, 1811399233, "CC(remember):TabRow.kt#9igjgp");
                        Object rememberedValue = composer3.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new TabRowKt$TabRowImpl$1$scope$1$1();
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        final TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1 = (TabRowKt$TabRowImpl$1$scope$1$1) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        final Function3<TabIndicatorScope, Composer, Integer, Unit> function32 = function3;
                        List listOf = CollectionsKt.listOf((Object[]) new Function2[]{function22, function2, ComposableLambdaKt.rememberComposableLambda(1236693605, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i5) {
                                ComposerKt.sourceInformation(composer4, "C618@29513L11:TabRow.kt#uh7d8r");
                                if ((i5 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1236693605, i5, -1, "androidx.compose.material3.TabRowImpl.<anonymous>.<anonymous> (TabRow.kt:618)");
                                }
                                function32.invoke(tabRowKt$TabRowImpl$1$scope$1$1, composer4, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54)});
                        ComposerKt.sourceInformationMarkerStart(composer3, 1811448875, "CC(remember):TabRow.kt#9igjgp");
                        MultiContentMeasurePolicy rememberedValue2 = composer3.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1
                                @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                                /* renamed from: measure-3p2s80s */
                                public final MeasureResult mo996measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j3) {
                                    List<? extends Measurable> list2 = list.get(0);
                                    List<? extends Measurable> list3 = list.get(1);
                                    List<? extends Measurable> list4 = list.get(2);
                                    int m6942getMaxWidthimpl = Constraints.m6942getMaxWidthimpl(j3);
                                    int size = list2.size();
                                    final Ref.IntRef intRef = new Ref.IntRef();
                                    if (size > 0) {
                                        intRef.element = m6942getMaxWidthimpl / size;
                                    }
                                    int i5 = 0;
                                    int size2 = list2.size();
                                    for (int i6 = 0; i6 < size2; i6++) {
                                        i5 = Integer.valueOf(Math.max(list2.get(i6).maxIntrinsicHeight(intRef.element), i5.intValue()));
                                    }
                                    final int intValue = i5.intValue();
                                    TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$12 = TabRowKt$TabRowImpl$1$scope$1$1.this;
                                    ArrayList arrayList = new ArrayList(size);
                                    for (int i7 = 0; i7 < size; i7++) {
                                        arrayList.add(new TabPosition(Dp.m6989constructorimpl(measureScope.mo697toDpu2uoSUM(intRef.element) * i7), measureScope.mo697toDpu2uoSUM(intRef.element), ((Dp) ComparisonsKt.maxOf(Dp.m6987boximpl(Dp.m6989constructorimpl(measureScope.mo697toDpu2uoSUM(Math.min(list2.get(i7).maxIntrinsicWidth(intValue), intRef.element)) - Dp.m6989constructorimpl(TabKt.getHorizontalTextPadding() * 2.0f))), Dp.m6987boximpl(Dp.m6989constructorimpl(24.0f)))).m7003unboximpl(), null));
                                    }
                                    tabRowKt$TabRowImpl$1$scope$1$12.setTabPositions(arrayList);
                                    ArrayList arrayList2 = new ArrayList(list2.size());
                                    int size3 = list2.size();
                                    for (int i8 = 0; i8 < size3; i8++) {
                                        Measurable measurable = list2.get(i8);
                                        int i9 = intValue;
                                        long m6931copyZbe2FdA = Constraints.m6931copyZbe2FdA(j3, intRef.element, intRef.element, i9, intValue);
                                        intValue = i9;
                                        arrayList2.add(measurable.mo5732measureBRTryo0(m6931copyZbe2FdA));
                                    }
                                    final ArrayList arrayList3 = arrayList2;
                                    ArrayList arrayList4 = new ArrayList(list3.size());
                                    int size4 = list3.size();
                                    for (int i10 = 0; i10 < size4; i10++) {
                                        arrayList4.add(list3.get(i10).mo5732measureBRTryo0(Constraints.m6932copyZbe2FdA$default(j3, 0, 0, 0, 0, 11, null)));
                                    }
                                    final ArrayList arrayList5 = arrayList4;
                                    ArrayList arrayList6 = new ArrayList(list4.size());
                                    int size5 = list4.size();
                                    for (int i11 = 0; i11 < size5; i11++) {
                                        int i12 = intValue;
                                        intValue = i12;
                                        arrayList6.add(list4.get(i11).mo5732measureBRTryo0(Constraints.m6931copyZbe2FdA(j3, intRef.element, intRef.element, 0, i12)));
                                    }
                                    final ArrayList arrayList7 = arrayList6;
                                    return MeasureScope.layout$default(measureScope, m6942getMaxWidthimpl, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                            invoke2(placementScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(Placeable.PlacementScope placementScope) {
                                            List<Placeable> list5 = arrayList3;
                                            Ref.IntRef intRef2 = intRef;
                                            int size6 = list5.size();
                                            for (int i13 = 0; i13 < size6; i13++) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, list5.get(i13), i13 * intRef2.element, 0, 0.0f, 4, null);
                                            }
                                            List<Placeable> list6 = arrayList5;
                                            int i14 = intValue;
                                            int size7 = list6.size();
                                            for (int i15 = 0; i15 < size7; i15++) {
                                                Placeable placeable = list6.get(i15);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i14 - placeable.getHeight(), 0.0f, 4, null);
                                            }
                                            List<Placeable> list7 = arrayList7;
                                            int i16 = intValue;
                                            int size8 = list7.size();
                                            for (int i17 = 0; i17 < size8; i17++) {
                                                Placeable placeable2 = list7.get(i17);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, 0, i16 - placeable2.getHeight(), 0.0f, 4, null);
                                            }
                                        }
                                    }, 4, null);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) rememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listOf);
                        ComposerKt.sourceInformationMarkerStart(composer3, -290761997, "CC(remember):Layout.kt#9igjgp");
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer m3808constructorimpl = Updater.m3808constructorimpl(composer3);
                        Updater.m3815setimpl(m3808constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        combineAsVirtualLayouts.invoke(composer3, 0);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, startRestartGroup, 54), composer2, (i3 & 896) | 12582912 | (i3 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    TabRowKt.m2704TabRowImplDTcfvLk(Modifier.this, j, j2, function3, function2, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* renamed from: ScrollableTabRowImpl-sKfQg0A */
    public static final void m2699ScrollableTabRowImplsKfQg0A(final int i, final Modifier modifier, final long j, final long j2, final float f, final ScrollState scrollState, final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2) {
        int i3;
        float f2;
        ScrollState scrollState2;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function32;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1594140035);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScrollableTabRowImpl)P(7,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,6,4)710@32775L5081,700@32441L5415:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= startRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 16384 : 8192;
        } else {
            f2 = f;
        }
        if ((196608 & i2) == 0) {
            scrollState2 = scrollState;
            i3 |= startRestartGroup.changed(scrollState2) ? 131072 : 65536;
        } else {
            scrollState2 = scrollState;
        }
        if ((1572864 & i2) == 0) {
            function32 = function3;
            i3 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
        } else {
            function32 = function3;
        }
        if ((i2 & 12582912) == 0) {
            function23 = function2;
            i3 |= startRestartGroup.changedInstance(function23) ? 8388608 : 4194304;
        } else {
            function23 = function2;
        }
        if ((100663296 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i3 & 38347923) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1594140035, i3, -1, "androidx.compose.material3.ScrollableTabRowImpl (TabRow.kt:699)");
            }
            Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), scrollState2, false, null, false, 14, null)));
            final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
            final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function33 = function32;
            final float f3 = f2;
            composer2 = startRestartGroup;
            SurfaceKt.m2648SurfaceT9BRK9s(clipToBounds, null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1556158104, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C711@32806L24,713@32875L147,717@33044L1274,757@34458L21,759@34509L3341,752@34328L3522:TabRow.kt#uh7d8r");
                    if ((i4 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1556158104, i4, -1, "androidx.compose.material3.ScrollableTabRowImpl.<anonymous> (TabRow.kt:711)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composer3, -954363344, "CC(remember):Effects.kt#9igjgp");
                        Object rememberedValue = composer3.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                            composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            rememberedValue = compositionScopedCoroutineScopeCanceller;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, 413419233, "CC(remember):TabRow.kt#9igjgp");
                        boolean changed = composer3.changed(ScrollState.this) | composer3.changed(coroutineScope);
                        ScrollState scrollState3 = ScrollState.this;
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new ScrollableTabData(scrollState3, coroutineScope);
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, 413425768, "CC(remember):TabRow.kt#9igjgp");
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = new TabRowKt$ScrollableTabRowImpl$1$scope$1$1();
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        final TabRowKt$ScrollableTabRowImpl$1$scope$1$1 tabRowKt$ScrollableTabRowImpl$1$scope$1$1 = (TabRowKt$ScrollableTabRowImpl$1$scope$1$1) rememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        final Function3<TabIndicatorScope, Composer, Integer, Unit> function34 = function33;
                        List listOf = CollectionsKt.listOf((Object[]) new Function2[]{function22, function24, ComposableLambdaKt.rememberComposableLambda(-1530560661, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i5) {
                                ComposerKt.sourceInformation(composer4, "C757@34466L11:TabRow.kt#uh7d8r");
                                if ((i5 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1530560661, i5, -1, "androidx.compose.material3.ScrollableTabRowImpl.<anonymous>.<anonymous> (TabRow.kt:757)");
                                }
                                function34.invoke(tabRowKt$ScrollableTabRowImpl$1$scope$1$1, composer4, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54)});
                        ComposerKt.sourceInformationMarkerStart(composer3, 413474715, "CC(remember):TabRow.kt#9igjgp");
                        boolean changed2 = composer3.changed(f3) | composer3.changed(i) | composer3.changedInstance(scrollableTabData);
                        final float f4 = f3;
                        final int i5 = i;
                        Object rememberedValue4 = composer3.rememberedValue();
                        if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = (MultiContentMeasurePolicy) new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1$2$1
                                @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                                /* renamed from: measure-3p2s80s */
                                public final MeasureResult mo996measure3p2s80s(final MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j3) {
                                    float f5;
                                    float f6;
                                    List<? extends Measurable> list2 = list.get(0);
                                    List<? extends Measurable> list3 = list.get(1);
                                    List<? extends Measurable> list4 = list.get(2);
                                    final int i6 = measureScope.mo694roundToPx0680j_4(f4);
                                    int size = list2.size();
                                    f5 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                    int i7 = measureScope.mo694roundToPx0680j_4(f5);
                                    int i8 = 0;
                                    int size2 = list2.size();
                                    for (int i9 = 0; i9 < size2; i9++) {
                                        i8 = Integer.valueOf(Math.max(i8.intValue(), list2.get(i9).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                    }
                                    int intValue = i8.intValue();
                                    int i10 = i6 * 2;
                                    long m6932copyZbe2FdA$default = Constraints.m6932copyZbe2FdA$default(j3, i7, 0, intValue, intValue, 2, null);
                                    final Ref.FloatRef floatRef = new Ref.FloatRef();
                                    floatRef.element = f4;
                                    ArrayList arrayList = new ArrayList(list2.size());
                                    int size3 = list2.size();
                                    int i11 = 0;
                                    while (i11 < size3) {
                                        arrayList.add(list2.get(i11).mo5732measureBRTryo0(m6932copyZbe2FdA$default));
                                        i11++;
                                        list2 = list2;
                                    }
                                    ArrayList arrayList2 = arrayList;
                                    ArrayList arrayList3 = new ArrayList(size);
                                    int i12 = i10;
                                    for (int i13 = 0; i13 < size; i13++) {
                                        f6 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                        float m7003unboximpl = ((Dp) ComparisonsKt.maxOf(Dp.m6987boximpl(f6), Dp.m6987boximpl(measureScope.mo697toDpu2uoSUM(((Placeable) arrayList2.get(i13)).getWidth())))).m7003unboximpl();
                                        i12 += measureScope.mo694roundToPx0680j_4(m7003unboximpl);
                                        TabPosition tabPosition = new TabPosition(floatRef.element, m7003unboximpl, ((Dp) ComparisonsKt.maxOf(Dp.m6987boximpl(Dp.m6989constructorimpl(m7003unboximpl - Dp.m6989constructorimpl(TabKt.getHorizontalTextPadding() * 2.0f))), Dp.m6987boximpl(Dp.m6989constructorimpl(24.0f)))).m7003unboximpl(), null);
                                        floatRef.element = Dp.m6989constructorimpl(floatRef.element + m7003unboximpl);
                                        arrayList3.add(tabPosition);
                                    }
                                    final ArrayList arrayList4 = arrayList3;
                                    tabRowKt$ScrollableTabRowImpl$1$scope$1$1.setTabPositions(arrayList4);
                                    ArrayList arrayList5 = new ArrayList(list3.size());
                                    int size4 = list3.size();
                                    int i14 = 0;
                                    while (i14 < size4) {
                                        arrayList5.add(list3.get(i14).mo5732measureBRTryo0(Constraints.m6932copyZbe2FdA$default(j3, i12, i12, 0, 0, 8, null)));
                                        i14++;
                                        arrayList2 = arrayList2;
                                        list3 = list3;
                                    }
                                    final ArrayList arrayList6 = arrayList2;
                                    int i15 = i12;
                                    final ArrayList arrayList7 = arrayList5;
                                    int i16 = i5;
                                    ArrayList arrayList8 = new ArrayList(list4.size());
                                    int size5 = list4.size();
                                    int i17 = 0;
                                    while (i17 < size5) {
                                        int i18 = intValue;
                                        intValue = i18;
                                        arrayList8.add(list4.get(i17).mo5732measureBRTryo0(Constraints.m6931copyZbe2FdA(j3, 0, measureScope.mo694roundToPx0680j_4(((TabPosition) arrayList4.get(i16)).getWidth()), 0, i18)));
                                        i17++;
                                        list4 = list4;
                                    }
                                    final ArrayList arrayList9 = arrayList8;
                                    final float f7 = f4;
                                    final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                    final int i19 = i5;
                                    final int i20 = intValue;
                                    return MeasureScope.layout$default(measureScope, i15, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                            invoke2(placementScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(Placeable.PlacementScope placementScope) {
                                            Ref.FloatRef.this.element = f7;
                                            List<Placeable> list5 = arrayList6;
                                            MeasureScope measureScope2 = measureScope;
                                            Ref.FloatRef floatRef2 = Ref.FloatRef.this;
                                            List<TabPosition> list6 = arrayList4;
                                            int size6 = list5.size();
                                            for (int i21 = 0; i21 < size6; i21++) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, list5.get(i21), measureScope2.mo694roundToPx0680j_4(floatRef2.element), 0, 0.0f, 4, null);
                                                floatRef2.element = Dp.m6989constructorimpl(floatRef2.element + list6.get(i21).getWidth());
                                            }
                                            List<Placeable> list7 = arrayList7;
                                            int i22 = i20;
                                            int size7 = list7.size();
                                            for (int i23 = 0; i23 < size7; i23++) {
                                                Placeable placeable = list7.get(i23);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i22 - placeable.getHeight(), 0.0f, 4, null);
                                            }
                                            List<Placeable> list8 = arrayList9;
                                            MeasureScope measureScope3 = measureScope;
                                            List<TabPosition> list9 = arrayList4;
                                            int i24 = i19;
                                            int i25 = i20;
                                            int size8 = list8.size();
                                            for (int i26 = 0; i26 < size8; i26++) {
                                                Placeable placeable2 = list8.get(i26);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, Math.max(0, (measureScope3.mo694roundToPx0680j_4(list9.get(i24).getWidth()) - placeable2.getWidth()) / 2), i25 - placeable2.getHeight(), 0.0f, 4, null);
                                            }
                                            scrollableTabData2.onLaidOut(measureScope, i6, arrayList4, i19);
                                        }
                                    }, 4, null);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue4);
                        }
                        MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) rememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listOf);
                        ComposerKt.sourceInformationMarkerStart(composer3, -290761997, "CC(remember):Layout.kt#9igjgp");
                        boolean changed3 = composer3.changed(multiContentMeasurePolicy);
                        Object rememberedValue5 = composer3.rememberedValue();
                        if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue5 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                            composer3.updateRememberedValue(rememberedValue5);
                        }
                        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, companion);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer m3808constructorimpl = Updater.m3808constructorimpl(composer3);
                        Updater.m3815setimpl(m3808constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        combineAsVirtualLayouts.invoke(composer3, 0);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, startRestartGroup, 54), composer2, (i3 & 896) | 12582912 | (i3 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    TabRowKt.m2699ScrollableTabRowImplsKfQg0A(i, modifier, j, j2, f, scrollState, function3, function2, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* renamed from: TabRowWithSubcomposeImpl-DTcfvLk */
    public static final void m2705TabRowWithSubcomposeImplDTcfvLk(Modifier modifier, final long j, final long j2, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        Modifier modifier2;
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-160898917);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabRowWithSubcomposeImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)953@41542L2218,949@41412L2348:TabRow.kt#uh7d8r");
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i2 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-160898917, i2, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl (TabRow.kt:948)");
            }
            int i3 = i2 << 3;
            composer2 = startRestartGroup;
            SurfaceKt.m2648SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1617702432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C954@41594L2160,954@41552L2202:TabRow.kt#uh7d8r");
                    if ((i4 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1617702432, i4, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:954)");
                    }
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1807606673, "CC(remember):TabRow.kt#9igjgp");
                    boolean changed = composer3.changed(function22) | composer3.changed(function2) | composer3.changed(function3);
                    final Function2<Composer, Integer, Unit> function23 = function22;
                    final Function2<Composer, Integer, Unit> function24 = function2;
                    final Function3<List<TabPosition>, Composer, Integer, Unit> function32 = function3;
                    Object rememberedValue = composer3.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                return m2713invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                            }

                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2713invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j3) {
                                int m6942getMaxWidthimpl = Constraints.m6942getMaxWidthimpl(j3);
                                List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function23);
                                int size = subcompose.size();
                                final Ref.IntRef intRef = new Ref.IntRef();
                                if (size > 0) {
                                    intRef.element = m6942getMaxWidthimpl / size;
                                }
                                int i5 = 0;
                                int size2 = subcompose.size();
                                for (int i6 = 0; i6 < size2; i6++) {
                                    i5 = Integer.valueOf(Math.max(subcompose.get(i6).maxIntrinsicHeight(intRef.element), i5.intValue()));
                                }
                                final int intValue = i5.intValue();
                                ArrayList arrayList = new ArrayList(subcompose.size());
                                int size3 = subcompose.size();
                                int i7 = 0;
                                while (i7 < size3) {
                                    arrayList.add(subcompose.get(i7).mo5732measureBRTryo0(Constraints.m6931copyZbe2FdA(j3, intRef.element, intRef.element, intValue, intValue)));
                                    i7++;
                                    m6942getMaxWidthimpl = m6942getMaxWidthimpl;
                                }
                                final int i8 = m6942getMaxWidthimpl;
                                final ArrayList arrayList2 = arrayList;
                                ArrayList arrayList3 = new ArrayList(size);
                                for (int i9 = 0; i9 < size; i9++) {
                                    arrayList3.add(new TabPosition(Dp.m6989constructorimpl(subcomposeMeasureScope.mo697toDpu2uoSUM(intRef.element) * i9), subcomposeMeasureScope.mo697toDpu2uoSUM(intRef.element), ((Dp) ComparisonsKt.maxOf(Dp.m6987boximpl(Dp.m6989constructorimpl(subcomposeMeasureScope.mo697toDpu2uoSUM(Math.min(subcompose.get(i9).maxIntrinsicWidth(intValue), intRef.element)) - Dp.m6989constructorimpl(TabKt.getHorizontalTextPadding() * 2.0f))), Dp.m6987boximpl(Dp.m6989constructorimpl(24.0f)))).m7003unboximpl(), null));
                                }
                                final ArrayList arrayList4 = arrayList3;
                                final Function2<Composer, Integer, Unit> function25 = function24;
                                final Function3<List<TabPosition>, Composer, Integer, Unit> function33 = function32;
                                return MeasureScope.layout$default(subcomposeMeasureScope, i8, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope placementScope) {
                                        List<Placeable> list = arrayList2;
                                        Ref.IntRef intRef2 = intRef;
                                        int size4 = list.size();
                                        for (int i10 = 0; i10 < size4; i10++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i10), i10 * intRef2.element, 0, 0.0f, 4, null);
                                        }
                                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function25);
                                        long j4 = j3;
                                        int i11 = intValue;
                                        int size5 = subcompose2.size();
                                        for (int i12 = 0; i12 < size5; i12++) {
                                            Placeable mo5732measureBRTryo0 = subcompose2.get(i12).mo5732measureBRTryo0(Constraints.m6932copyZbe2FdA$default(j4, 0, 0, 0, 0, 11, null));
                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo5732measureBRTryo0, 0, i11 - mo5732measureBRTryo0.getHeight(), 0.0f, 4, null);
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                        TabSlots tabSlots = TabSlots.Indicator;
                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function34 = function33;
                                        final List<TabPosition> list2 = arrayList4;
                                        List<Measurable> subcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(1621992604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.TabRowWithSubcomposeImpl.1.1.1.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                invoke(composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i13) {
                                                ComposerKt.sourceInformation(composer4, "C1000@43547L23:TabRow.kt#uh7d8r");
                                                if ((i13 & 3) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1621992604, i13, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:1000)");
                                                }
                                                function34.invoke(list2, composer4, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }));
                                        int i13 = i8;
                                        int i14 = intValue;
                                        int size6 = subcompose3.size();
                                        for (int i15 = 0; i15 < size6; i15++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i15).mo5732measureBRTryo0(Constraints.INSTANCE.m6952fixedJhjzzOo(i13, i14)), 0, 0, 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    SubcomposeLayoutKt.SubcomposeLayout(fillMaxWidth$default, (Function2) rememberedValue, composer3, 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, (i3 & 896) | 12582912 | (i3 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    TabRowKt.m2705TabRowWithSubcomposeImplDTcfvLk(Modifier.this, j, j2, function3, function2, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00c5  */
    /* renamed from: ScrollableTabRowWithSubcomposeImpl-qhFBPw4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2700ScrollableTabRowWithSubcomposeImplqhFBPw4(final int r27, final kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material3.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, long r30, long r32, float r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, final androidx.compose.foundation.ScrollState r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instructions count: 528
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2700ScrollableTabRowWithSubcomposeImplqhFBPw4(int, kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.foundation.ScrollState, androidx.compose.runtime.Composer, int, int):void");
    }
}
