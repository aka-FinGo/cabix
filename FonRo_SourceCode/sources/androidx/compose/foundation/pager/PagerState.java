package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: PagerState.kt */
@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b'\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ7\u0010¦\u0001\u001a\u00030§\u00012\u0007\u0010¨\u0001\u001a\u00020\u00032\t\b\u0003\u0010©\u0001\u001a\u00020\u00052\u0010\b\u0002\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050«\u0001H\u0086@¢\u0006\u0003\u0010¬\u0001J-\u0010\u00ad\u0001\u001a\u00030§\u00012\u0007\u0010®\u0001\u001a\u00020\f2\u0007\u0010¯\u0001\u001a\u00020\u00182\t\b\u0002\u0010°\u0001\u001a\u00020\u0018H\u0000¢\u0006\u0003\b±\u0001J\u0011\u0010²\u0001\u001a\u00030§\u0001H\u0082@¢\u0006\u0003\u0010³\u0001J\u0013\u0010´\u0001\u001a\u00030§\u00012\u0007\u0010µ\u0001\u001a\u00020HH\u0002J\u0012\u0010¶\u0001\u001a\u00020\u00052\u0007\u0010·\u0001\u001a\u00020\u0005H\u0016J\u0010\u0010¸\u0001\u001a\u00020\u00052\u0007\u0010¨\u0001\u001a\u00020\u0003J\u0012\u0010¹\u0001\u001a\u00020\u00182\u0007\u0010º\u0001\u001a\u00020\u0005H\u0002J\u000f\u0010»\u0001\u001a\u00020\u0018H\u0000¢\u0006\u0003\b¼\u0001J#\u0010½\u0001\u001a\u00020\u00032\b\u0010¾\u0001\u001a\u00030¿\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0003\bÀ\u0001J\u001c\u0010Á\u0001\u001a\u00030§\u00012\u0007\u0010·\u0001\u001a\u00020\u00052\u0007\u0010µ\u0001\u001a\u00020HH\u0002J\u0012\u0010Â\u0001\u001a\u00020\u00052\u0007\u0010·\u0001\u001a\u00020\u0005H\u0002J\u001e\u0010Ã\u0001\u001a\u00030§\u00012\t\b\u0001\u0010¨\u0001\u001a\u00020\u00032\t\b\u0003\u0010©\u0001\u001a\u00020\u0005JK\u0010Ä\u0001\u001a\u00030§\u00012\b\u0010Å\u0001\u001a\u00030Æ\u00012.\u0010Ç\u0001\u001a)\b\u0001\u0012\u0005\u0012\u00030É\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030§\u00010Ê\u0001\u0012\u0007\u0012\u0005\u0018\u00010Ë\u00010È\u0001¢\u0006\u0003\bÌ\u0001H\u0096@¢\u0006\u0003\u0010Í\u0001J%\u0010Î\u0001\u001a\u00030§\u00012\u0007\u0010¨\u0001\u001a\u00020\u00032\t\b\u0003\u0010©\u0001\u001a\u00020\u0005H\u0086@¢\u0006\u0003\u0010Ï\u0001J+\u0010Ð\u0001\u001a\u00030§\u00012\u0007\u0010¨\u0001\u001a\u00020\u00032\u0007\u0010Ñ\u0001\u001a\u00020\u00052\u0007\u0010Ò\u0001\u001a\u00020\u0018H\u0000¢\u0006\u0003\bÓ\u0001J\u0013\u0010Ô\u0001\u001a\u00030§\u00012\u0007\u0010®\u0001\u001a\u00020\fH\u0002J\r\u0010Õ\u0001\u001a\u00020\u0003*\u00020\u0003H\u0002J!\u0010Ö\u0001\u001a\u00030§\u0001*\u00030É\u00012\u0007\u0010¨\u0001\u001a\u00020\u00032\t\b\u0003\u0010©\u0001\u001a\u00020\u0005J\u0016\u0010×\u0001\u001a\u00030§\u0001*\u00030É\u00012\u0007\u0010\u009d\u0001\u001a\u00020\u0003R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u00188F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR+\u0010 \u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u00188F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001f\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u001e\u00102\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u001e\u00104\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u0018@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001bR\u000e\u00106\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00107\u001a\u0002088F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020<X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00180@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00180@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u001bR\u0014\u0010C\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010\u001bR\u0014\u0010E\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u001bR\u0011\u0010G\u001a\u00020H8F¢\u0006\u0006\u001a\u0004\bI\u0010JR\u001e\u0010K\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bL\u0010%R\u000e\u0010M\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010N\u001a\u00020OX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010T\u001a\u00020UX\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\bV\u0010WR\u001a\u0010X\u001a\u00020OX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Q\"\u0004\bZ\u0010SR\u001b\u0010[\u001a\u00020\\8@X\u0080\u0084\u0002¢\u0006\f\u001a\u0004\b_\u0010`*\u0004\b]\u0010^R\u0014\u0010a\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bb\u0010%R\u0012\u0010c\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bd\u0010%R\u0014\u0010e\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bf\u0010%R\u0014\u0010g\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bh\u0010%R\u0014\u0010i\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bj\u0010%R\u0014\u0010k\u001a\b\u0012\u0004\u0012\u00020\f0@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010l\u001a\u00020mX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u001c\u0010p\u001a\u00020UX\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\bq\u0010WR\u0014\u0010r\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bs\u0010'R\u0014\u0010t\u001a\u00020uX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR\u001a\u0010x\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u001b\"\u0004\bz\u0010\u001dR\"\u0010{\u001a\u00020|X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u007f\u001a\u0004\b}\u0010Q\"\u0004\b~\u0010SR\u000f\u0010\u0080\u0001\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010\u0081\u0001\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0017\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0005\b\u0082\u0001\u0010%\"\u0006\b\u0083\u0001\u0010\u0084\u0001R7\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00012\t\u0010\u000b\u001a\u0005\u0018\u00010\u0087\u00018@@BX\u0080\u008e\u0002¢\u0006\u0017\n\u0005\b\u008d\u0001\u0010\u001f\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0018\u0010\u008e\u0001\u001a\u00030\u008f\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0010\u0010\u0092\u0001\u001a\u00030\u0093\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0001\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0095\u0001\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0005\b\u0096\u0001\u0010%R1\u0010\u0099\u0001\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0017\n\u0006\b\u009c\u0001\u0010\u0086\u0001\u001a\u0005\b\u009a\u0001\u0010%\"\u0006\b\u009b\u0001\u0010\u0084\u0001R\u001f\u0010\u009d\u0001\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b\u009f\u0001\u0010\u0098\u0001\u001a\u0005\b\u009e\u0001\u0010%R7\u0010¡\u0001\u001a\u00030 \u00012\u0007\u0010\u000b\u001a\u00030 \u00018@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0015\n\u0005\b¤\u0001\u0010\u001f\u001a\u0005\b¢\u0001\u0010Q\"\u0005\b£\u0001\u0010SR\u000f\u0010¥\u0001\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Ø\u0001"}, d2 = {"Landroidx/compose/foundation/pager/PagerState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "currentPage", "", "currentPageOffsetFraction", "", "(IF)V", "prefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "(IFLandroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "accumulator", "<set-?>", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "approachLayoutInfo", "getApproachLayoutInfo$foundation_release", "()Landroidx/compose/foundation/pager/PagerMeasureResult;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "", "canScrollBackward", "getCanScrollBackward", "()Z", "setCanScrollBackward", "(Z)V", "canScrollBackward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "getCurrentPage", "()I", "getCurrentPageOffsetFraction", "()F", "currentPrefetchHandle", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "firstVisiblePage", "getFirstVisiblePage$foundation_release", "firstVisiblePageOffset", "getFirstVisiblePageOffset$foundation_release", "hasLookaheadOccurred", "getHasLookaheadOccurred$foundation_release", "indexToPrefetch", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isLastScrollBackwardState", "Landroidx/compose/runtime/MutableState;", "isLastScrollForwardState", "isScrollInProgress", "lastScrolledBackward", "getLastScrolledBackward", "lastScrolledForward", "getLastScrolledForward", "layoutInfo", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/pager/PagerLayoutInfo;", "layoutWithMeasurement", "getLayoutWithMeasurement$foundation_release", "layoutWithoutMeasurement", "maxScrollOffset", "", "getMaxScrollOffset$foundation_release", "()J", "setMaxScrollOffset$foundation_release", "(J)V", "measurementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getMeasurementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", "minScrollOffset", "getMinScrollOffset$foundation_release", "setMinScrollOffset$foundation_release", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/pager/PagerState;)Ljava/lang/Object;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "pageCount", "getPageCount", "pageSize", "getPageSize$foundation_release", "pageSizeWithSpacing", "getPageSizeWithSpacing$foundation_release", "pageSpacing", "getPageSpacing$foundation_release", "pagerLayoutInfoState", "pinnedPages", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedPages$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "placementScopeInvalidator", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "positionThresholdFraction", "getPositionThresholdFraction$foundation_release", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "premeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "getPremeasureConstraints-msEJaDk$foundation_release", "setPremeasureConstraints-BRTryo0$foundation_release", "J", "previousPassDelta", "programmaticScrollTargetPage", "getProgrammaticScrollTargetPage", "setProgrammaticScrollTargetPage", "(I)V", "programmaticScrollTargetPage$delegate", "Landroidx/compose/runtime/MutableIntState;", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "setRemeasurement", "(Landroidx/compose/ui/layout/Remeasurement;)V", "remeasurement$delegate", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollPosition", "Landroidx/compose/foundation/pager/PagerScrollPosition;", "scrollableState", "settledPage", "getSettledPage", "settledPage$delegate", "Landroidx/compose/runtime/State;", "settledPageState", "getSettledPageState", "setSettledPageState", "settledPageState$delegate", "targetPage", "getTargetPage", "targetPage$delegate", "Landroidx/compose/ui/geometry/Offset;", "upDownDifference", "getUpDownDifference-F1C5BW0$foundation_release", "setUpDownDifference-k-4lQ0M$foundation_release", "upDownDifference$delegate", "wasPrefetchingForward", "animateScrollToPage", "", "page", "pageOffsetFraction", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(IFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "isLookingAhead", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "awaitScrollDependencies", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelPrefetchIfVisibleItemsChanged", "info", "dispatchRawDelta", "delta", "getOffsetDistanceInPages", "isGestureActionMatchesScroll", "scrollDelta", "isNotGestureAction", "isNotGestureAction$foundation_release", "matchScrollPositionWithKey", "itemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "matchScrollPositionWithKey$foundation_release", "notifyPrefetch", "performScroll", "requestScrollToPage", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToPage", "(IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapToItem", "offsetFraction", "forceRemeasure", "snapToItem$foundation_release", "tryRunPrefetch", "coerceInPageRange", "updateCurrentPage", "updateTargetPage", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class PagerState implements ScrollableState {
    public static final int $stable = 0;
    private float accumulator;
    private PagerMeasureResult approachLayoutInfo;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;

    /* renamed from: canScrollBackward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollBackward;

    /* renamed from: canScrollForward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollForward;
    private LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    private Density density;
    private int firstVisiblePage;
    private int firstVisiblePageOffset;
    private boolean hasLookaheadOccurred;
    private int indexToPrefetch;
    private final MutableInteractionSource internalInteractionSource;
    private final MutableState<Boolean> isLastScrollBackwardState;
    private final MutableState<Boolean> isLastScrollForwardState;
    private int layoutWithMeasurement;
    private int layoutWithoutMeasurement;
    private long maxScrollOffset;
    private final MutableState<Unit> measurementScopeInvalidator;
    private long minScrollOffset;
    private MutableState<PagerMeasureResult> pagerLayoutInfoState;
    private final LazyLayoutPinnedItemList pinnedPages;
    private final MutableState<Unit> placementScopeInvalidator;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private long premeasureConstraints;
    private float previousPassDelta;

    /* renamed from: programmaticScrollTargetPage$delegate, reason: from kotlin metadata */
    private final MutableIntState programmaticScrollTargetPage;

    /* renamed from: remeasurement$delegate, reason: from kotlin metadata */
    private final MutableState remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final PagerScrollPosition scrollPosition;
    private final ScrollableState scrollableState;

    /* renamed from: settledPage$delegate, reason: from kotlin metadata */
    private final State settledPage;

    /* renamed from: settledPageState$delegate, reason: from kotlin metadata */
    private final MutableIntState settledPageState;

    /* renamed from: targetPage$delegate, reason: from kotlin metadata */
    private final State targetPage;

    /* renamed from: upDownDifference$delegate, reason: from kotlin metadata */
    private final MutableState upDownDifference;
    private boolean wasPrefetchingForward;

    public PagerState() {
        this(0, 0.0f, null, 7, null);
    }

    public abstract int getPageCount();

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return scroll$suspendImpl(this, mutatePriority, function2, continuation);
    }

    public PagerState(int i, float f, PrefetchScheduler prefetchScheduler) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState<Boolean> mutableStateOf$default5;
        MutableState<Boolean> mutableStateOf$default6;
        double d = f;
        boolean z = false;
        if (-0.5d <= d && d <= 0.5d) {
            z = true;
        }
        if (!z) {
            InlineClassHelperKt.throwIllegalArgumentException("currentPageOffsetFraction " + f + " is not within the range -0.5 to 0.5");
        }
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m4114boximpl(Offset.INSTANCE.m4141getZeroF1C5BW0()), null, 2, null);
        this.upDownDifference = mutableStateOf$default;
        PagerScrollPosition pagerScrollPosition = new PagerScrollPosition(i, f, this);
        this.scrollPosition = pagerScrollPosition;
        this.firstVisiblePage = i;
        this.maxScrollOffset = Long.MAX_VALUE;
        this.scrollableState = ScrollableStateKt.ScrollableState(new Function1<Float, Float>() { // from class: androidx.compose.foundation.pager.PagerState$scrollableState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Float invoke(float f2) {
                float performScroll;
                performScroll = PagerState.this.performScroll(f2);
                return Float.valueOf(performScroll);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f2) {
                return invoke(f2.floatValue());
            }
        });
        this.prefetchingEnabled = true;
        this.indexToPrefetch = -1;
        this.pagerLayoutInfoState = SnapshotStateKt.mutableStateOf(PagerStateKt.getEmptyLayoutInfo(), SnapshotStateKt.neverEqualPolicy());
        this.density = PagerStateKt.access$getUnitDensity$p();
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.programmaticScrollTargetPage = SnapshotIntStateKt.mutableIntStateOf(-1);
        this.settledPageState = SnapshotIntStateKt.mutableIntStateOf(i);
        this.settledPage = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Integer>() { // from class: androidx.compose.foundation.pager.PagerState$settledPage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                int currentPage;
                boolean isScrollInProgress = PagerState.this.isScrollInProgress();
                PagerState pagerState = PagerState.this;
                if (isScrollInProgress) {
                    currentPage = pagerState.getSettledPageState();
                } else {
                    currentPage = pagerState.getCurrentPage();
                }
                return Integer.valueOf(currentPage);
            }
        });
        this.targetPage = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Integer>() { // from class: androidx.compose.foundation.pager.PagerState$targetPage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                int programmaticScrollTargetPage;
                int currentPage;
                int coerceInPageRange;
                boolean isScrollInProgress = PagerState.this.isScrollInProgress();
                PagerState pagerState = PagerState.this;
                if (isScrollInProgress) {
                    programmaticScrollTargetPage = pagerState.getProgrammaticScrollTargetPage();
                    PagerState pagerState2 = PagerState.this;
                    if (programmaticScrollTargetPage != -1) {
                        currentPage = pagerState2.getProgrammaticScrollTargetPage();
                    } else {
                        float abs = Math.abs(pagerState2.getCurrentPageOffsetFraction());
                        float abs2 = Math.abs(PagerState.this.getPositionThresholdFraction$foundation_release());
                        PagerState pagerState3 = PagerState.this;
                        if (abs >= abs2) {
                            boolean lastScrolledForward = pagerState3.getLastScrolledForward();
                            PagerState pagerState4 = PagerState.this;
                            if (lastScrolledForward) {
                                currentPage = pagerState4.getFirstVisiblePage() + 1;
                            } else {
                                currentPage = pagerState4.getFirstVisiblePage();
                            }
                        } else {
                            currentPage = pagerState3.getCurrentPage();
                        }
                    }
                } else {
                    currentPage = pagerState.getCurrentPage();
                }
                coerceInPageRange = PagerState.this.coerceInPageRange(currentPage);
                return Integer.valueOf(coerceInPageRange);
            }
        });
        this.prefetchState = new LazyLayoutPrefetchState(prefetchScheduler, new Function1<NestedPrefetchScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerState$prefetchState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NestedPrefetchScope nestedPrefetchScope) {
                invoke2(nestedPrefetchScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NestedPrefetchScope nestedPrefetchScope) {
                Snapshot.Companion companion = Snapshot.INSTANCE;
                PagerState pagerState = PagerState.this;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    nestedPrefetchScope.schedulePrefetch(pagerState.getFirstVisiblePage());
                    Unit unit = Unit.INSTANCE;
                } finally {
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                }
            }
        });
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.remeasurement = mutableStateOf$default2;
        this.remeasurementModifier = new RemeasurementModifier() { // from class: androidx.compose.foundation.pager.PagerState$remeasurementModifier$1
            @Override // androidx.compose.ui.layout.RemeasurementModifier
            public void onRemeasurementAvailable(Remeasurement remeasurement) {
                PagerState.this.setRemeasurement(remeasurement);
            }
        };
        this.premeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        this.pinnedPages = new LazyLayoutPinnedItemList();
        pagerScrollPosition.getNearestRangeState();
        this.placementScopeInvalidator = ObservableScopeInvalidator.m1231constructorimpl$default(null, 1, null);
        this.measurementScopeInvalidator = ObservableScopeInvalidator.m1231constructorimpl$default(null, 1, null);
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.canScrollForward = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.canScrollBackward = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isLastScrollForwardState = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isLastScrollBackwardState = mutableStateOf$default6;
    }

    public /* synthetic */ PagerState(int i, float f, PrefetchScheduler prefetchScheduler, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0.0f : f, (i2 & 4) != 0 ? null : prefetchScheduler);
    }

    public /* synthetic */ PagerState(int i, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0.0f : f);
    }

    public PagerState(int i, float f) {
        this(i, f, null);
    }

    /* renamed from: getHasLookaheadOccurred$foundation_release, reason: from getter */
    public final boolean getHasLookaheadOccurred() {
        return this.hasLookaheadOccurred;
    }

    /* renamed from: getApproachLayoutInfo$foundation_release, reason: from getter */
    public final PagerMeasureResult getApproachLayoutInfo() {
        return this.approachLayoutInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getUpDownDifference-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m1306getUpDownDifferenceF1C5BW0$foundation_release() {
        return ((Offset) this.upDownDifference.getValue()).m4135unboximpl();
    }

    /* renamed from: setUpDownDifference-k-4lQ0M$foundation_release, reason: not valid java name */
    public final void m1308setUpDownDifferencek4lQ0M$foundation_release(long j) {
        this.upDownDifference.setValue(Offset.m4114boximpl(j));
    }

    /* renamed from: getFirstVisiblePage$foundation_release, reason: from getter */
    public final int getFirstVisiblePage() {
        return this.firstVisiblePage;
    }

    /* renamed from: getFirstVisiblePageOffset$foundation_release, reason: from getter */
    public final int getFirstVisiblePageOffset() {
        return this.firstVisiblePageOffset;
    }

    /* renamed from: getMaxScrollOffset$foundation_release, reason: from getter */
    public final long getMaxScrollOffset() {
        return this.maxScrollOffset;
    }

    public final void setMaxScrollOffset$foundation_release(long j) {
        this.maxScrollOffset = j;
    }

    /* renamed from: getMinScrollOffset$foundation_release, reason: from getter */
    public final long getMinScrollOffset() {
        return this.minScrollOffset;
    }

    public final void setMinScrollOffset$foundation_release(long j) {
        this.minScrollOffset = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float performScroll(float delta) {
        PagerMeasureResult pagerMeasureResult;
        long currentAbsoluteScrollOffset = PagerScrollPositionKt.currentAbsoluteScrollOffset(this);
        float f = this.accumulator + delta;
        long roundToLong = MathKt.roundToLong(f);
        this.accumulator = f - ((float) roundToLong);
        if (Math.abs(delta) < 1.0E-4f) {
            return delta;
        }
        long j = currentAbsoluteScrollOffset + roundToLong;
        long coerceIn = RangesKt.coerceIn(j, this.minScrollOffset, this.maxScrollOffset);
        boolean z = j != coerceIn;
        long j2 = coerceIn - currentAbsoluteScrollOffset;
        float f2 = (float) j2;
        this.previousPassDelta = f2;
        if (Math.abs(j2) != 0) {
            this.isLastScrollForwardState.setValue(Boolean.valueOf(f2 > 0.0f));
            this.isLastScrollBackwardState.setValue(Boolean.valueOf(f2 < 0.0f));
        }
        int i = (int) j2;
        int i2 = -i;
        PagerMeasureResult copyWithScrollDeltaWithoutRemeasure = this.pagerLayoutInfoState.getValue().copyWithScrollDeltaWithoutRemeasure(i2);
        if (copyWithScrollDeltaWithoutRemeasure != null && (pagerMeasureResult = this.approachLayoutInfo) != null) {
            PagerMeasureResult copyWithScrollDeltaWithoutRemeasure2 = pagerMeasureResult != null ? pagerMeasureResult.copyWithScrollDeltaWithoutRemeasure(i2) : null;
            if (copyWithScrollDeltaWithoutRemeasure2 != null) {
                this.approachLayoutInfo = copyWithScrollDeltaWithoutRemeasure2;
            } else {
                copyWithScrollDeltaWithoutRemeasure = null;
            }
        }
        if (copyWithScrollDeltaWithoutRemeasure != null) {
            applyMeasureResult$foundation_release(copyWithScrollDeltaWithoutRemeasure, this.hasLookaheadOccurred, true);
            ObservableScopeInvalidator.m1235invalidateScopeimpl(this.placementScopeInvalidator);
            this.layoutWithoutMeasurement++;
        } else {
            this.scrollPosition.applyScrollDelta(i);
            Remeasurement remeasurement$foundation_release = getRemeasurement$foundation_release();
            if (remeasurement$foundation_release != null) {
                remeasurement$foundation_release.forceRemeasure();
            }
            this.layoutWithMeasurement++;
        }
        return (z ? Long.valueOf(j2) : Float.valueOf(delta)).floatValue();
    }

    public final int getNumMeasurePasses$foundation_release() {
        return this.layoutWithMeasurement + this.layoutWithoutMeasurement;
    }

    /* renamed from: getLayoutWithMeasurement$foundation_release, reason: from getter */
    public final int getLayoutWithMeasurement() {
        return this.layoutWithMeasurement;
    }

    /* renamed from: getPrefetchingEnabled$foundation_release, reason: from getter */
    public final boolean getPrefetchingEnabled() {
        return this.prefetchingEnabled;
    }

    public final void setPrefetchingEnabled$foundation_release(boolean z) {
        this.prefetchingEnabled = z;
    }

    public final PagerLayoutInfo getLayoutInfo() {
        return this.pagerLayoutInfoState.getValue();
    }

    public final int getPageSpacing$foundation_release() {
        return this.pagerLayoutInfoState.getValue().getPageSpacing();
    }

    public final int getPageSize$foundation_release() {
        return this.pagerLayoutInfoState.getValue().getPageSize();
    }

    /* renamed from: getDensity$foundation_release, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity$foundation_release(Density density) {
        this.density = density;
    }

    public final int getPageSizeWithSpacing$foundation_release() {
        return getPageSize$foundation_release() + getPageSpacing$foundation_release();
    }

    public final float getPositionThresholdFraction$foundation_release() {
        return Math.min(this.density.mo700toPx0680j_4(PagerStateKt.getDefaultPositionThreshold()), getPageSize$foundation_release() / 2.0f) / getPageSize$foundation_release();
    }

    /* renamed from: getInternalInteractionSource$foundation_release, reason: from getter */
    public final MutableInteractionSource getInternalInteractionSource() {
        return this.internalInteractionSource;
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    public final int getCurrentPage() {
        return this.scrollPosition.getCurrentPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getProgrammaticScrollTargetPage() {
        return this.programmaticScrollTargetPage.getIntValue();
    }

    private final void setProgrammaticScrollTargetPage(int i) {
        this.programmaticScrollTargetPage.setIntValue(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSettledPageState() {
        return this.settledPageState.getIntValue();
    }

    private final void setSettledPageState(int i) {
        this.settledPageState.setIntValue(i);
    }

    public final int getSettledPage() {
        return ((Number) this.settledPage.getValue()).intValue();
    }

    public final int getTargetPage() {
        return ((Number) this.targetPage.getValue()).intValue();
    }

    public final float getCurrentPageOffsetFraction() {
        return this.scrollPosition.getCurrentPageOffsetFraction();
    }

    /* renamed from: getPrefetchState$foundation_release, reason: from getter */
    public final LazyLayoutPrefetchState getPrefetchState() {
        return this.prefetchState;
    }

    /* renamed from: getBeyondBoundsInfo$foundation_release, reason: from getter */
    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo() {
        return this.beyondBoundsInfo;
    }

    /* renamed from: getAwaitLayoutModifier$foundation_release, reason: from getter */
    public final AwaitFirstLayoutModifier getAwaitLayoutModifier() {
        return this.awaitLayoutModifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRemeasurement(Remeasurement remeasurement) {
        this.remeasurement.setValue(remeasurement);
    }

    public final Remeasurement getRemeasurement$foundation_release() {
        return (Remeasurement) this.remeasurement.getValue();
    }

    /* renamed from: getRemeasurementModifier$foundation_release, reason: from getter */
    public final RemeasurementModifier getRemeasurementModifier() {
        return this.remeasurementModifier;
    }

    /* renamed from: getPremeasureConstraints-msEJaDk$foundation_release, reason: not valid java name and from getter */
    public final long getPremeasureConstraints() {
        return this.premeasureConstraints;
    }

    /* renamed from: setPremeasureConstraints-BRTryo0$foundation_release, reason: not valid java name */
    public final void m1307setPremeasureConstraintsBRTryo0$foundation_release(long j) {
        this.premeasureConstraints = j;
    }

    /* renamed from: getPinnedPages$foundation_release, reason: from getter */
    public final LazyLayoutPinnedItemList getPinnedPages() {
        return this.pinnedPages;
    }

    public final IntRange getNearestRange$foundation_release() {
        return this.scrollPosition.getNearestRangeState().getValue();
    }

    /* renamed from: getPlacementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<Unit> m1304getPlacementScopeInvalidatorzYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
    }

    public static /* synthetic */ Object scrollToPage$default(PagerState pagerState, int i, float f, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToPage");
        }
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        return pagerState.scrollToPage(i, f, continuation);
    }

    public final Object scrollToPage(int i, float f, Continuation<? super Unit> continuation) {
        Object scroll$default = ScrollableState.scroll$default(this, null, new PagerState$scrollToPage$2(this, f, i, null), continuation, 1, null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }

    public static /* synthetic */ void updateCurrentPage$default(PagerState pagerState, ScrollScope scrollScope, int i, float f, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCurrentPage");
        }
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        pagerState.updateCurrentPage(scrollScope, i, f);
    }

    public final void updateCurrentPage(ScrollScope scrollScope, int i, float f) {
        snapToItem$foundation_release(i, f, true);
    }

    public final void updateTargetPage(ScrollScope scrollScope, int i) {
        setProgrammaticScrollTargetPage(coerceInPageRange(i));
    }

    public final void snapToItem$foundation_release(int page, float offsetFraction, boolean forceRemeasure) {
        this.scrollPosition.requestPositionAndForgetLastKnownKey(page, offsetFraction);
        if (forceRemeasure) {
            Remeasurement remeasurement$foundation_release = getRemeasurement$foundation_release();
            if (remeasurement$foundation_release != null) {
                remeasurement$foundation_release.forceRemeasure();
                return;
            }
            return;
        }
        ObservableScopeInvalidator.m1235invalidateScopeimpl(this.measurementScopeInvalidator);
    }

    /* renamed from: getMeasurementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<Unit> m1303getMeasurementScopeInvalidatorzYiylxw$foundation_release() {
        return this.measurementScopeInvalidator;
    }

    public static /* synthetic */ void requestScrollToPage$default(PagerState pagerState, int i, float f, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestScrollToPage");
        }
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        pagerState.requestScrollToPage(i, f);
    }

    public final void requestScrollToPage(int page, float pageOffsetFraction) {
        if (isScrollInProgress()) {
            BuildersKt__Builders_commonKt.launch$default(this.pagerLayoutInfoState.getValue().getCoroutineScope(), null, null, new PagerState$requestScrollToPage$1(this, null), 3, null);
        }
        snapToItem$foundation_release(page, pageOffsetFraction, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c5, code lost:
    
        if (androidx.compose.foundation.gestures.ScrollableState.scroll$default(r6, null, r3, r4, 1, null) != r0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c7, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0074, code lost:
    
        if (awaitScrollDependencies(r4) == r0) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateScrollToPage(int r12, float r13, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.animateScrollToPage(int, float, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateScrollToPage$default(PagerState pagerState, int i, float f, AnimationSpec animationSpec, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateScrollToPage");
        }
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        if ((i2 & 4) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return pagerState.animateScrollToPage(i, f, animationSpec, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitScrollDependencies(Continuation<? super Unit> continuation) {
        Object waitForFirstLayout = this.awaitLayoutModifier.waitForFirstLayout(continuation);
        return waitForFirstLayout == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? waitForFirstLayout : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007a, code lost:
    
        if (r8.scroll(r6, r7, r0) != r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007c, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
    
        if (r5.awaitScrollDependencies(r0) == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object scroll$suspendImpl(androidx.compose.foundation.pager.PagerState r5, androidx.compose.foundation.MutatePriority r6, kotlin.jvm.functions.Function2<? super androidx.compose.foundation.gestures.ScrollScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.pager.PagerState$scroll$1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.foundation.pager.PagerState$scroll$1 r0 = (androidx.compose.foundation.pager.PagerState$scroll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.foundation.pager.PagerState$scroll$1 r0 = new androidx.compose.foundation.pager.PagerState$scroll$1
            r0.<init>(r5, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.pager.PagerState r5 = (androidx.compose.foundation.pager.PagerState) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7d
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            java.lang.Object r5 = r0.L$2
            r7 = r5
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r5 = r0.L$1
            r6 = r5
            androidx.compose.foundation.MutatePriority r6 = (androidx.compose.foundation.MutatePriority) r6
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.pager.PagerState r5 = (androidx.compose.foundation.pager.PagerState) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5e
        L4c:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r8 = r5.awaitScrollDependencies(r0)
            if (r8 != r1) goto L5e
            goto L7c
        L5e:
            boolean r8 = r5.isScrollInProgress()
            if (r8 != 0) goto L6b
            int r8 = r5.getCurrentPage()
            r5.setSettledPageState(r8)
        L6b:
            androidx.compose.foundation.gestures.ScrollableState r8 = r5.scrollableState
            r0.L$0 = r5
            r2 = 0
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r6 = r8.scroll(r6, r7, r0)
            if (r6 != r1) goto L7d
        L7c:
            return r1
        L7d:
            r6 = -1
            r5.setProgrammaticScrollTargetPage(r6)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.scroll$suspendImpl(androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return this.scrollableState.dispatchRawDelta(delta);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    private final void setCanScrollForward(boolean z) {
        this.canScrollForward.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward.getValue()).booleanValue();
    }

    private final void setCanScrollBackward(boolean z) {
        this.canScrollBackward.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledForward() {
        return this.isLastScrollForwardState.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledBackward() {
        return this.isLastScrollBackwardState.getValue().booleanValue();
    }

    public static /* synthetic */ void applyMeasureResult$foundation_release$default(PagerState pagerState, PagerMeasureResult pagerMeasureResult, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyMeasureResult");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        pagerState.applyMeasureResult$foundation_release(pagerMeasureResult, z, z2);
    }

    public final void applyMeasureResult$foundation_release(PagerMeasureResult result, boolean isLookingAhead, boolean visibleItemsStayedTheSame) {
        if (!isLookingAhead && this.hasLookaheadOccurred) {
            this.approachLayoutInfo = result;
            return;
        }
        if (isLookingAhead) {
            this.hasLookaheadOccurred = true;
        }
        PagerScrollPosition pagerScrollPosition = this.scrollPosition;
        if (visibleItemsStayedTheSame) {
            pagerScrollPosition.updateCurrentPageOffsetFraction(result.getCurrentPageOffsetFraction());
        } else {
            pagerScrollPosition.updateFromMeasureResult(result);
            cancelPrefetchIfVisibleItemsChanged(result);
        }
        this.pagerLayoutInfoState.setValue(result);
        setCanScrollForward(result.getCanScrollForward());
        setCanScrollBackward(result.getCanScrollBackward());
        MeasuredPage firstVisiblePage = result.getFirstVisiblePage();
        if (firstVisiblePage != null) {
            this.firstVisiblePage = firstVisiblePage.getIndex();
        }
        this.firstVisiblePageOffset = result.getFirstVisiblePageScrollOffset();
        tryRunPrefetch(result);
        this.maxScrollOffset = PagerStateKt.calculateNewMaxScrollOffset(result, getPageCount());
        this.minScrollOffset = PagerStateKt.access$calculateNewMinScrollOffset(result, getPageCount());
    }

    private final void tryRunPrefetch(PagerMeasureResult result) {
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (Math.abs(this.previousPassDelta) > 0.5f && this.prefetchingEnabled && isGestureActionMatchesScroll(this.previousPassDelta)) {
                notifyPrefetch(this.previousPassDelta, result);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int coerceInPageRange(int i) {
        if (getPageCount() > 0) {
            return RangesKt.coerceIn(i, 0, getPageCount() - 1);
        }
        return 0;
    }

    private final boolean isGestureActionMatchesScroll(float scrollDelta) {
        if (getLayoutInfo().getOrientation() == Orientation.Vertical) {
            if (Math.signum(scrollDelta) == Math.signum(-Float.intBitsToFloat((int) (m1306getUpDownDifferenceF1C5BW0$foundation_release() & 4294967295L)))) {
                return true;
            }
        } else if (Math.signum(scrollDelta) == Math.signum(-Float.intBitsToFloat((int) (m1306getUpDownDifferenceF1C5BW0$foundation_release() >> 32)))) {
            return true;
        }
        return isNotGestureAction$foundation_release();
    }

    public final boolean isNotGestureAction$foundation_release() {
        return ((int) Float.intBitsToFloat((int) (m1306getUpDownDifferenceF1C5BW0$foundation_release() >> 32))) == 0 && ((int) Float.intBitsToFloat((int) (m1306getUpDownDifferenceF1C5BW0$foundation_release() & 4294967295L))) == 0;
    }

    private final void notifyPrefetch(float delta, PagerLayoutInfo info) {
        int index;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle2;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle3;
        if (this.prefetchingEnabled && !info.getVisiblePagesInfo().isEmpty()) {
            boolean z = delta > 0.0f;
            if (z) {
                index = ((PageInfo) CollectionsKt.last((List) info.getVisiblePagesInfo())).getIndex() + info.getBeyondViewportPageCount() + 1;
            } else {
                index = (((PageInfo) CollectionsKt.first((List) info.getVisiblePagesInfo())).getIndex() - info.getBeyondViewportPageCount()) - 1;
            }
            if (index < 0 || index >= getPageCount()) {
                return;
            }
            if (index != this.indexToPrefetch) {
                if (this.wasPrefetchingForward != z && (prefetchHandle3 = this.currentPrefetchHandle) != null) {
                    prefetchHandle3.cancel();
                }
                this.wasPrefetchingForward = z;
                this.indexToPrefetch = index;
                this.currentPrefetchHandle = this.prefetchState.m1226schedulePrefetch0kLqBqw(index, this.premeasureConstraints);
            }
            if (z) {
                if ((((PageInfo) CollectionsKt.last((List) info.getVisiblePagesInfo())).getOffset() + (info.getPageSize() + info.getPageSpacing())) - info.getViewportEndOffset() >= delta || (prefetchHandle2 = this.currentPrefetchHandle) == null) {
                    return;
                }
                prefetchHandle2.markAsUrgent();
                return;
            }
            if (info.getViewportStartOffset() - ((PageInfo) CollectionsKt.first((List) info.getVisiblePagesInfo())).getOffset() >= (-delta) || (prefetchHandle = this.currentPrefetchHandle) == null) {
                return;
            }
            prefetchHandle.markAsUrgent();
        }
    }

    private final void cancelPrefetchIfVisibleItemsChanged(PagerLayoutInfo info) {
        int index;
        if (this.indexToPrefetch == -1 || info.getVisiblePagesInfo().isEmpty()) {
            return;
        }
        if (this.wasPrefetchingForward) {
            index = ((PageInfo) CollectionsKt.last((List) info.getVisiblePagesInfo())).getIndex() + info.getBeyondViewportPageCount() + 1;
        } else {
            index = (((PageInfo) CollectionsKt.first((List) info.getVisiblePagesInfo())).getIndex() - info.getBeyondViewportPageCount()) - 1;
        }
        if (this.indexToPrefetch != index) {
            this.indexToPrefetch = -1;
            LazyLayoutPrefetchState.PrefetchHandle prefetchHandle = this.currentPrefetchHandle;
            if (prefetchHandle != null) {
                prefetchHandle.cancel();
            }
            this.currentPrefetchHandle = null;
        }
    }

    public final float getOffsetDistanceInPages(int page) {
        boolean z = false;
        if (page >= 0 && page <= getPageCount()) {
            z = true;
        }
        if (!z) {
            InlineClassHelperKt.throwIllegalArgumentException("page " + page + " is not within the range 0 to " + getPageCount());
        }
        return (page - getCurrentPage()) - getCurrentPageOffsetFraction();
    }

    public static /* synthetic */ int matchScrollPositionWithKey$foundation_release$default(PagerState pagerState, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: matchScrollPositionWithKey");
        }
        if ((i2 & 2) != 0) {
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                int currentPage = pagerState.scrollPosition.getCurrentPage();
                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                i = currentPage;
            } catch (Throwable th) {
                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                throw th;
            }
        }
        return pagerState.matchScrollPositionWithKey$foundation_release(pagerLazyLayoutItemProvider, i);
    }

    public final int matchScrollPositionWithKey$foundation_release(PagerLazyLayoutItemProvider itemProvider, int currentPage) {
        return this.scrollPosition.matchPageWithKey(itemProvider, currentPage);
    }
}
