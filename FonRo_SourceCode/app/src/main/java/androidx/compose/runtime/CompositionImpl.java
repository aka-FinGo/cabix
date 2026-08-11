package androidx.compose.runtime;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.compose.ComposeNavigator;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composition.kt */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B%\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\b\u0010`\u001a\u00020\u001bH\u0016J\u0018\u0010a\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020-2\u0006\u0010c\u001a\u00020\u0014H\u0002J\u001e\u0010a\u001a\u00020\u001b2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010c\u001a\u00020\u0014H\u0002J\b\u0010e\u001a\u00020\u001bH\u0016J\u0010\u0010f\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010g\u001a\u00020\u001bH\u0016J\b\u0010h\u001a\u00020\u001bH\u0016J\b\u0010i\u001a\u00020\u001bH\u0002J \u0010j\u001a\u00020\u001b2\u0011\u0010k\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\b\u001cH\u0016¢\u0006\u0002\u0010 J \u0010l\u001a\u00020\u001b2\u0011\u0010k\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\b\u001cH\u0002¢\u0006\u0002\u0010 J\r\u0010m\u001a\u00020<H\u0000¢\u0006\u0002\bnJ\b\u0010o\u001a\u00020\u001bH\u0016J3\u0010p\u001a\u0002Hq\"\u0004\b\u0000\u0010q2\b\u0010r\u001a\u0004\u0018\u00010\u00012\u0006\u0010s\u001a\u00020<2\f\u0010t\u001a\b\u0012\u0004\u0012\u0002Hq0\u001aH\u0016¢\u0006\u0002\u0010uJ\b\u0010v\u001a\u00020\u001bH\u0016J\u0010\u0010w\u001a\u00020\u001b2\u0006\u0010x\u001a\u00020yH\u0016J\b\u0010z\u001a\u00020\u001bH\u0002J\b\u0010{\u001a\u00020\u001bH\u0002J\b\u0010|\u001a\u00020\u001bH\u0002J\u0014\u0010}\u001a\u0004\u0018\u00010Z2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J&\u0010~\u001a\u0004\u0018\u0001H\u007f\"\u0004\b\u0000\u0010\u007f2\u000e\u0010\u0080\u0001\u001a\t\u0012\u0004\u0012\u0002H\u007f0\u0081\u0001H\u0016¢\u0006\u0003\u0010\u0082\u0001J$\u0010\u0083\u0001\u001a\u0002H\u007f\"\u0004\b\u0000\u0010\u007f2\f\u0010t\u001a\b\u0012\u0004\u0012\u0002H\u007f0\u001aH\u0082\b¢\u0006\u0003\u0010\u0084\u0001JH\u0010\u0085\u0001\u001a\u0002H\u007f\"\u0004\b\u0000\u0010\u007f20\u0010t\u001a,\u0012!\u0012\u001f\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020-01¢\u0006\u000e\b\u0087\u0001\u0012\t\b\u0088\u0001\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\u007f0\u0086\u0001H\u0082\b¢\u0006\u0003\u0010\u0089\u0001J)\u0010\u008a\u0001\u001a\u00020\u001b2\u001e\u0010\u008b\u0001\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030\u008d\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u008d\u00010\u008c\u00010%H\u0016J\u001e\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020&2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010-H\u0016J\t\u0010\u0092\u0001\u001a\u00020\u001bH\u0016J(\u0010\u0093\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020&2\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010-H\u0002J\u0010\u0010\u0096\u0001\u001a\u00020\u001b2\u0007\u0010\u0080\u0001\u001a\u00020<J\u0011\u0010\u0097\u0001\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020-H\u0002J\u001a\u0010\u0098\u0001\u001a\u00030\u0099\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0000¢\u0006\u0003\b\u009c\u0001J\f\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0002J\u0017\u0010\u009d\u0001\u001a\u00020\u00142\f\u0010d\u001a\b\u0012\u0004\u0012\u00020-0,H\u0016J\u000f\u0010\u009e\u0001\u001a\u00020\u001bH\u0000¢\u0006\u0003\b\u009f\u0001J\u0017\u0010 \u0001\u001a\u00020\u001b2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\t\u0010¡\u0001\u001a\u00020\u0014H\u0016J\u0012\u0010¢\u0001\u001a\u00020\u001b2\u0007\u0010\u0090\u0001\u001a\u00020&H\u0016J\u0017\u0010£\u0001\u001a\u00020\u001b2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020-0,H\u0016J\u0011\u0010¤\u0001\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020-H\u0016J\u0011\u0010¥\u0001\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020-H\u0016J\u001b\u0010¦\u0001\u001a\u00020\u001b2\n\u0010x\u001a\u0006\u0012\u0002\b\u000302H\u0000¢\u0006\u0003\b§\u0001J!\u0010¨\u0001\u001a\u00020\u001b2\u0007\u0010\u0091\u0001\u001a\u00020-2\u0007\u0010\u0090\u0001\u001a\u00020&H\u0000¢\u0006\u0003\b©\u0001J!\u0010ª\u0001\u001a\u00020\u001b2\u0011\u0010k\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\b\u001cH\u0016¢\u0006\u0002\u0010 J!\u0010«\u0001\u001a\u00020\u001b2\u0011\u0010k\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\b\u001cH\u0016¢\u0006\u0002\u0010 J#\u0010¬\u0001\u001a\u00030\u00ad\u00012\u0011\u0010k\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\b\u001cH\u0016¢\u0006\u0003\u0010®\u0001J#\u0010¯\u0001\u001a\u00030\u00ad\u00012\u0011\u0010k\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\b\u001cH\u0016¢\u0006\u0003\u0010®\u0001J$\u0010°\u0001\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020-01H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b±\u0001\u0010²\u0001J$\u0010³\u0001\u001a\u0002H\u007f\"\u0004\b\u0000\u0010\u007f2\f\u0010t\u001a\b\u0012\u0004\u0012\u0002H\u007f0\u001aH\u0082\b¢\u0006\u0003\u0010\u0084\u0001J\u001d\u0010´\u0001\u001a\u00020\u00142\u0007\u0010\u0090\u0001\u001a\u00020&2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010-H\u0002J\u000f\u0010µ\u0001\u001a\u00020\u001bH\u0000¢\u0006\u0003\b¶\u0001J\u0011\u0010·\u0001\u001a\u00020\u001b2\u0006\u0010[\u001a\u00020\\H\u0002J\t\u0010¸\u0001\u001a\u00020\u001bH\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\b\u001cX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020&0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R&\u00100\u001a\u0012\u0012\u0004\u0012\u00020-\u0012\b\u0012\u0006\u0012\u0002\b\u00030201X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00103R\u000e\u00104\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0016R\u0014\u00107\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0016R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020&0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010=\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020-01X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00103R\u0014\u0010>\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0016R\u0014\u0010?\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0016R\u0011\u0010@\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0016R\u000e\u0010A\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010C\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020&01X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00103R\"\u0010D\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020&01X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00103R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020-0,8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010/R\u0014\u0010G\u001a\u00020HX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR \u0010M\u001a\u00020\u0014X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bN\u0010\u0012\u001a\u0004\bO\u0010\u0016\"\u0004\bP\u0010QR\"\u0010R\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010-0Sj\n\u0012\u0006\u0012\u0004\u0018\u00010-`TX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\u00020\\X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b]\u0010\u0012\u001a\u0004\b^\u0010_\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¹\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "Landroidx/compose/runtime/CompositionServices;", "Landroidx/compose/runtime/PausableComposition;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "_recomposeContext", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "getAbandonSet$annotations", "()V", "areChildrenComposing", "", "getAreChildrenComposing", "()Z", "changes", "Landroidx/compose/runtime/changelist/ChangeList;", ComposeNavigator.NAME, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "conditionalScopes", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getConditionalScopes$runtime_release", "()Ljava/util/List;", "conditionallyInvalidatedScopes", "Landroidx/collection/MutableScatterSet;", "derivedStateDependencies", "", "", "getDerivedStateDependencies$runtime_release", "()Ljava/util/Set;", "derivedStates", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/DerivedState;", "Landroidx/collection/MutableScatterMap;", "disposed", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges", "invalidatedScopes", "invalidationDelegate", "invalidationDelegateGroup", "", "invalidations", "isComposing", "isDisposed", "isRoot", "lateChanges", "lock", "observations", "observationsProcessed", "observedObjects", "getObservedObjects$runtime_release", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime_release", "()Landroidx/compose/runtime/CompositionObserverHolder;", "getParent", "()Landroidx/compose/runtime/CompositionContext;", "pendingInvalidScopes", "getPendingInvalidScopes$runtime_release$annotations", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/internal/AtomicReference;", "pendingPausedComposition", "Landroidx/compose/runtime/PausedCompositionImpl;", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release$annotations", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "abandonChanges", "addPendingInvalidationsLocked", "value", "forgetConditionalScopes", "values", "applyChanges", "applyChangesInLocked", "applyLateChanges", "changesApplied", "cleanUpDerivedStateObservations", "composeContent", FirebaseAnalytics.Param.CONTENT, "composeInitial", "composerStacksSizes", "composerStacksSizes$runtime_release", "deactivate", "delegateInvalidations", "R", TypedValues.TransitionType.S_TO, "groupIndex", "block", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dispose", "disposeUnusedMovableContent", "state", "Landroidx/compose/runtime/MovableContentState;", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "drainPendingModificationsOutOfBandLocked", "getAndSetShouldPauseCallback", "getCompositionService", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "guardChanges", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "guardInvalidationsLocked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "insertMovableContent", "references", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "invalidateAll", "invalidateChecked", "anchor", "Landroidx/compose/runtime/Anchor;", "invalidateGroupsWithKey", "invalidateScopeOfLocked", "observe", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionObserver;", "observe$runtime_release", "observesAnyOf", "pausedCompositionFinished", "pausedCompositionFinished$runtime_release", "prepareCompose", "recompose", "recomposeScopeReleased", "recordModificationsOf", "recordReadOf", "recordWriteOf", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime_release", "removeObservation", "removeObservation$runtime_release", "setContent", "setContentWithReuse", "setPausableContent", "Landroidx/compose/runtime/PausedComposition;", "(Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/PausedComposition;", "setPausableContentWithReuse", "takeInvalidations", "takeInvalidations-afanTW4", "()Landroidx/collection/MutableScatterMap;", "trackAbandonedValues", "tryImminentInvalidation", "updateMovingInvalidations", "updateMovingInvalidations$runtime_release", "validateRecomposeScopeAnchors", "verifyConsistent", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class CompositionImpl implements ControlledComposition, ReusableComposition, RecomposeScopeOwner, CompositionServices, PausableComposition {
    public static final int $stable = 8;
    private final CoroutineContext _recomposeContext;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final ChangeList changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final ComposerImpl composer;
    private final MutableScatterSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final MutableScatterMap<Object, Object> derivedStates;
    private boolean disposed;
    private final MutableScatterSet<RecomposeScopeImpl> invalidatedScopes;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private MutableScatterMap<Object, Object> invalidations;
    private final boolean isRoot;
    private final ChangeList lateChanges;
    private final Object lock;
    private final MutableScatterMap<Object, Object> observations;
    private final MutableScatterMap<Object, Object> observationsProcessed;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private PausedCompositionImpl pendingPausedComposition;
    private ShouldPauseCallback shouldPause;
    private final SlotTable slotTable;

    private static /* synthetic */ void getAbandonSet$annotations() {
    }

    public static /* synthetic */ void getPendingInvalidScopes$runtime_release$annotations() {
    }

    public static /* synthetic */ void getSlotTable$runtime_release$annotations() {
    }

    public CompositionImpl(CompositionContext compositionContext, Applier<?> applier, CoroutineContext coroutineContext) {
        this.parent = compositionContext;
        this.applier = applier;
        this.pendingModifications = new AtomicReference<>(null);
        this.lock = new Object();
        Set<RememberObserver> asMutableSet = new MutableScatterSet(0, 1, null).asMutableSet();
        this.abandonSet = asMutableSet;
        SlotTable slotTable = new SlotTable();
        if (compositionContext.getCollectingCallByInformation$runtime_release()) {
            slotTable.collectCalledByInformation();
        }
        if (compositionContext.getCollectingSourceInformation()) {
            slotTable.collectSourceInformation();
        }
        this.slotTable = slotTable;
        this.observations = ScopeMap.m3908constructorimpl$default(null, 1, null);
        this.invalidatedScopes = new MutableScatterSet<>(0, 1, null);
        this.conditionallyInvalidatedScopes = new MutableScatterSet<>(0, 1, null);
        this.derivedStates = ScopeMap.m3908constructorimpl$default(null, 1, null);
        ChangeList changeList = new ChangeList();
        this.changes = changeList;
        ChangeList changeList2 = new ChangeList();
        this.lateChanges = changeList2;
        this.observationsProcessed = ScopeMap.m3908constructorimpl$default(null, 1, null);
        this.invalidations = ScopeMap.m3908constructorimpl$default(null, 1, null);
        this.observerHolder = new CompositionObserverHolder(null, false, 3, null);
        ComposerImpl composerImpl = new ComposerImpl(applier, compositionContext, slotTable, asMutableSet, changeList, changeList2, this);
        compositionContext.registerComposer$runtime_release(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = coroutineContext;
        this.isRoot = compositionContext instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m3744getLambda1$runtime_release();
    }

    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier, (i & 4) != 0 ? null : coroutineContext);
    }

    public final CompositionContext getParent() {
        return this.parent;
    }

    /* renamed from: getSlotTable$runtime_release, reason: from getter */
    public final SlotTable getSlotTable() {
        return this.slotTable;
    }

    public final Set<Object> getObservedObjects$runtime_release() {
        return this.observations.asMap().keySet();
    }

    public final Set<Object> getDerivedStateDependencies$runtime_release() {
        return this.derivedStates.asMap().keySet();
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime_release() {
        return CollectionsKt.toList(this.conditionallyInvalidatedScopes.asSet());
    }

    /* renamed from: getPendingInvalidScopes$runtime_release, reason: from getter */
    public final boolean getPendingInvalidScopes() {
        return this.pendingInvalidScopes;
    }

    public final void setPendingInvalidScopes$runtime_release(boolean z) {
        this.pendingInvalidScopes = z;
    }

    /* renamed from: getObserverHolder$runtime_release, reason: from getter */
    public final CompositionObserverHolder getObserverHolder() {
        return this.observerHolder;
    }

    public final CoroutineContext getRecomposeContext() {
        CoroutineContext coroutineContext = this._recomposeContext;
        return coroutineContext == null ? this.parent.getRecomposeCoroutineContext$runtime_release() : coroutineContext;
    }

    /* renamed from: isRoot, reason: from getter */
    public final boolean getIsRoot() {
        return this.isRoot;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final void setComposable(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.composable = function2;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.getIsComposing();
    }

    @Override // androidx.compose.runtime.Composition
    /* renamed from: isDisposed, reason: from getter */
    public boolean getDisposed() {
        return this.disposed;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime_release;
        synchronized (this.lock) {
            hasPendingChanges$runtime_release = this.composer.getHasPendingChanges$runtime_release();
        }
        return hasPendingChanges$runtime_release;
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        if (!(this.pendingPausedComposition == null)) {
            PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
        }
        composeInitial(content);
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void setContentWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        if (!(this.pendingPausedComposition == null)) {
            PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
        }
        this.composer.startReuseFromRoot();
        composeInitial(content);
        this.composer.endReuseFromRoot();
    }

    @Override // androidx.compose.runtime.PausableComposition
    public PausedComposition setPausableContent(Function2<? super Composer, ? super Integer, Unit> content) {
        if (this.disposed) {
            PreconditionsKt.throwIllegalStateException("The composition is disposed");
        }
        if (!(this.pendingPausedComposition == null)) {
            PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
        }
        PausedCompositionImpl pausedCompositionImpl = new PausedCompositionImpl(this, this.parent, this.composer, this.abandonSet, content, false, this.applier, this.lock);
        this.pendingPausedComposition = pausedCompositionImpl;
        return pausedCompositionImpl;
    }

    @Override // androidx.compose.runtime.PausableComposition
    public PausedComposition setPausableContentWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        if (this.disposed) {
            PreconditionsKt.throwIllegalStateException("The composition is disposed");
        }
        if (!(this.pendingPausedComposition == null)) {
            PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
        }
        PausedCompositionImpl pausedCompositionImpl = new PausedCompositionImpl(this, this.parent, this.composer, this.abandonSet, content, true, this.applier, this.lock);
        this.pendingPausedComposition = pausedCompositionImpl;
        return pausedCompositionImpl;
    }

    public final void pausedCompositionFinished$runtime_release() {
        this.pendingPausedComposition = null;
    }

    private final void composeInitial(Function2<? super Composer, ? super Integer, Unit> content) {
        if (this.disposed) {
            PreconditionsKt.throwIllegalStateException("The composition is disposed");
        }
        this.composable = content;
        this.parent.composeInitial$runtime_release(this, content);
    }

    public final CompositionObserverHandle observe$runtime_release(final CompositionObserver observer) {
        synchronized (this.lock) {
            this.observerHolder.setObserver(observer);
            this.observerHolder.setRoot(true);
            Unit unit = Unit.INSTANCE;
        }
        return new CompositionObserverHandle() { // from class: androidx.compose.runtime.CompositionImpl$observe$2
            @Override // androidx.compose.runtime.tooling.CompositionObserverHandle
            public void dispose() {
                Object obj;
                obj = CompositionImpl.this.lock;
                CompositionImpl compositionImpl = CompositionImpl.this;
                CompositionObserver compositionObserver = observer;
                synchronized (obj) {
                    if (Intrinsics.areEqual(compositionImpl.getObserverHolder().getObserver(), compositionObserver)) {
                        compositionImpl.getObserverHolder().setObserver(null);
                        compositionImpl.getObserverHolder().setRoot(false);
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        };
    }

    public final void invalidateGroupsWithKey(int key) {
        List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime_release;
        synchronized (this.lock) {
            invalidateGroupsWithKey$runtime_release = this.slotTable.invalidateGroupsWithKey$runtime_release(key);
        }
        if (invalidateGroupsWithKey$runtime_release != null) {
            int size = invalidateGroupsWithKey$runtime_release.size();
            for (int i = 0; i < size; i++) {
                if (invalidateGroupsWithKey$runtime_release.get(i).invalidateForResult(null) != InvalidationResult.IGNORED) {
                }
            }
            return;
        }
        if (this.composer.forceRecomposeScopes$runtime_release()) {
            this.parent.invalidate$runtime_release(this);
        }
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object obj;
        Object obj2;
        AtomicReference<Object> atomicReference = this.pendingModifications;
        obj = CompositionKt.PendingApplyNoModifications;
        Object andSet = atomicReference.getAndSet(obj);
        if (andSet != null) {
            obj2 = CompositionKt.PendingApplyNoModifications;
            if (Intrinsics.areEqual(andSet, obj2)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set<? extends Object>) andSet, true);
                return;
            }
            if (andSet instanceof Object[]) {
                for (Set<? extends Object> set : (Set[]) andSet) {
                    addPendingInvalidationsLocked(set, true);
                }
                return;
            }
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
    }

    private final void drainPendingModificationsLocked() {
        Object obj;
        Object andSet = this.pendingModifications.getAndSet(null);
        obj = CompositionKt.PendingApplyNoModifications;
        if (Intrinsics.areEqual(andSet, obj)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
            return;
        }
        if (andSet == null) {
            ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
        throw new KotlinNothingValueException();
    }

    private final void drainPendingModificationsOutOfBandLocked() {
        Object obj;
        Object andSet = this.pendingModifications.getAndSet(SetsKt.emptySet());
        obj = CompositionKt.PendingApplyNoModifications;
        if (Intrinsics.areEqual(andSet, obj) || andSet == null) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
            return;
        }
        ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(Function2<? super Composer, ? super Integer, Unit> content) {
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                MutableScatterMap<Object, Object> m3752takeInvalidationsafanTW4 = m3752takeInvalidationsafanTW4();
                try {
                    CompositionObserver observer = observer();
                    if (observer != null) {
                        Map<RecomposeScope, ? extends Set<? extends Object>> m3904asMapimpl = ScopeMap.m3904asMapimpl(m3752takeInvalidationsafanTW4);
                        Intrinsics.checkNotNull(m3904asMapimpl, "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>>");
                        observer.onBeginComposition(this, m3904asMapimpl);
                    }
                    this.composer.m3749composeContentZbOJvo$runtime_release(m3752takeInvalidationsafanTW4, content, this.shouldPause);
                    if (observer != null) {
                        observer.onEndComposition(this);
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e) {
                    this.invalidations = m3752takeInvalidationsafanTW4;
                    throw e;
                }
            }
        } finally {
        }
    }

    public final void updateMovingInvalidations$runtime_release() {
        synchronized (this.lock) {
            drainPendingModificationsOutOfBandLocked();
            MutableScatterMap<Object, Object> m3752takeInvalidationsafanTW4 = m3752takeInvalidationsafanTW4();
            try {
                this.composer.m3751updateComposerInvalidationsRY85e9Y(m3752takeInvalidationsafanTW4);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Exception e) {
                this.invalidations = m3752takeInvalidationsafanTW4;
                throw e;
            }
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.lock) {
            if (this.composer.getIsComposing()) {
                PreconditionsKt.throwIllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
            }
            if (!this.disposed) {
                this.disposed = true;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.m3745getLambda2$runtime_release();
                ChangeList deferredChanges = this.composer.getDeferredChanges();
                if (deferredChanges != null) {
                    applyChangesInLocked(deferredChanges);
                }
                boolean z = this.slotTable.getGroupsSize() > 0;
                if (z || !this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                    if (z) {
                        this.applier.onBeginChanges();
                        SlotWriter openWriter = this.slotTable.openWriter();
                        try {
                            ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
                            Unit unit = Unit.INSTANCE;
                            openWriter.close(true);
                            this.applier.clear();
                            this.applier.onEndChanges();
                            rememberEventDispatcher.dispatchRememberObservers();
                        } catch (Throwable th) {
                            openWriter.close(false);
                            throw th;
                        }
                    }
                    rememberEventDispatcher.dispatchAbandons();
                }
                this.composer.dispose$runtime_release();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = ScopeMap.m3913getSizeimpl(this.invalidations) > 0;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.Set[]] */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(Set<? extends Object> values) {
        Object obj;
        Object obj2;
        boolean areEqual;
        Set<? extends Object> set;
        do {
            obj = this.pendingModifications.get();
            if (obj == null) {
                areEqual = true;
            } else {
                obj2 = CompositionKt.PendingApplyNoModifications;
                areEqual = Intrinsics.areEqual(obj, obj2);
            }
            if (areEqual) {
                set = values;
            } else if (obj instanceof Set) {
                set = new Set[]{obj, values};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                set = ArraysKt.plus((Set<? extends Object>[]) obj, values);
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.pendingModifications, obj, set));
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(Function0<Unit> block) {
        this.composer.prepareCompose$runtime_release(block);
    }

    private final void addPendingInvalidationsLocked(Object value, boolean forgetConditionalScopes) {
        Object obj = this.observations.get(value);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (!ScopeMap.m3915removeimpl(this.observationsProcessed, value, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(value) != InvalidationResult.IGNORED) {
                                if (recomposeScopeImpl.isConditional() && !forgetConditionalScopes) {
                                    this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                                } else {
                                    this.invalidatedScopes.add(recomposeScopeImpl);
                                }
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
            if (ScopeMap.m3915removeimpl(this.observationsProcessed, value, recomposeScopeImpl2) || recomposeScopeImpl2.invalidateForResult(value) == InvalidationResult.IGNORED) {
                return;
            }
            if (recomposeScopeImpl2.isConditional() && !forgetConditionalScopes) {
                this.conditionallyInvalidatedScopes.add(recomposeScopeImpl2);
            } else {
                this.invalidatedScopes.add(recomposeScopeImpl2);
            }
        }
    }

    private final void cleanUpDerivedStateObservations() {
        long j;
        char c;
        long j2;
        long j3;
        long[] jArr;
        long[] jArr2;
        int i;
        long j4;
        char c2;
        long j5;
        int i2;
        boolean z;
        long[] jArr3;
        int i3;
        int i4;
        MutableScatterMap<Object, Object> mutableScatterMap = this.derivedStates;
        long[] jArr4 = mutableScatterMap.metadata;
        int length = jArr4.length - 2;
        long j6 = 255;
        char c3 = 7;
        long j7 = -9187201950435737472L;
        int i5 = 8;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j8 = jArr4[i6];
                j3 = 128;
                if ((((~j8) << c3) & j8 & j7) != j7) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j8 & j6) < 128) {
                            j4 = j6;
                            int i9 = (i6 << 3) + i8;
                            Object obj = mutableScatterMap.keys[i9];
                            Object obj2 = mutableScatterMap.values[i9];
                            c2 = c3;
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr = mutableScatterSet.elements;
                                j5 = j7;
                                long[] jArr5 = mutableScatterSet.metadata;
                                int length2 = jArr5.length - 2;
                                if (length2 >= 0) {
                                    int i10 = i5;
                                    int i11 = 0;
                                    while (true) {
                                        long j9 = jArr5[i11];
                                        Object[] objArr2 = objArr;
                                        long[] jArr6 = jArr5;
                                        if ((((~j9) << c2) & j9 & j5) != j5) {
                                            int i12 = 8 - ((~(i11 - length2)) >>> 31);
                                            int i13 = 0;
                                            while (i13 < i12) {
                                                if ((j9 & j4) < 128) {
                                                    jArr3 = jArr4;
                                                    int i14 = (i11 << 3) + i13;
                                                    i3 = i8;
                                                    i4 = i13;
                                                    if (!ScopeMap.m3909containsimpl(this.observations, (DerivedState) objArr2[i14])) {
                                                        mutableScatterSet.removeElementAt(i14);
                                                    }
                                                } else {
                                                    jArr3 = jArr4;
                                                    i3 = i8;
                                                    i4 = i13;
                                                }
                                                j9 >>= i10;
                                                i13 = i4 + 1;
                                                jArr4 = jArr3;
                                                i8 = i3;
                                            }
                                            jArr2 = jArr4;
                                            i = i8;
                                            if (i12 != i10) {
                                                break;
                                            }
                                        } else {
                                            jArr2 = jArr4;
                                            i = i8;
                                        }
                                        int i15 = i11;
                                        if (i15 == length2) {
                                            break;
                                        }
                                        i11 = i15 + 1;
                                        objArr = objArr2;
                                        jArr5 = jArr6;
                                        jArr4 = jArr2;
                                        i8 = i;
                                        i10 = 8;
                                    }
                                } else {
                                    jArr2 = jArr4;
                                    i = i8;
                                }
                                z = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr4;
                                i = i8;
                                j5 = j7;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                z = !ScopeMap.m3909containsimpl(this.observations, (DerivedState) obj2);
                            }
                            if (z) {
                                mutableScatterMap.removeValueAt(i9);
                            }
                            i2 = 8;
                        } else {
                            jArr2 = jArr4;
                            i = i8;
                            j4 = j6;
                            c2 = c3;
                            j5 = j7;
                            i2 = i5;
                        }
                        j8 >>= i2;
                        i8 = i + 1;
                        i5 = i2;
                        c3 = c2;
                        j6 = j4;
                        j7 = j5;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    j = j6;
                    c = c3;
                    j2 = j7;
                    if (i7 != i5) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                    j = j6;
                    c = c3;
                    j2 = j7;
                }
                if (i6 == length) {
                    break;
                }
                i6++;
                c3 = c;
                j6 = j;
                j7 = j2;
                jArr4 = jArr;
                i5 = 8;
            }
        } else {
            j = 255;
            c = 7;
            j2 = -9187201950435737472L;
            j3 = 128;
        }
        if (!this.conditionallyInvalidatedScopes.isNotEmpty()) {
            return;
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet2 = this.conditionallyInvalidatedScopes;
        Object[] objArr3 = mutableScatterSet2.elements;
        long[] jArr7 = mutableScatterSet2.metadata;
        int length3 = jArr7.length - 2;
        if (length3 < 0) {
            return;
        }
        int i16 = 0;
        while (true) {
            long j10 = jArr7[i16];
            if ((((~j10) << c) & j10 & j2) != j2) {
                int i17 = 8 - ((~(i16 - length3)) >>> 31);
                for (int i18 = 0; i18 < i17; i18++) {
                    if ((j10 & j) < j3) {
                        int i19 = (i16 << 3) + i18;
                        if (!((RecomposeScopeImpl) objArr3[i19]).isConditional()) {
                            mutableScatterSet2.removeElementAt(i19);
                        }
                    }
                    j10 >>= 8;
                }
                if (i17 != 8) {
                    return;
                }
            }
            if (i16 == length3) {
                return;
            } else {
                i16++;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void recordReadOf(Object value) {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        int i;
        int i2;
        int i3;
        if (getAreChildrenComposing() || (currentRecomposeScope$runtime_release = this.composer.getCurrentRecomposeScope$runtime_release()) == null) {
            return;
        }
        int i4 = 1;
        currentRecomposeScope$runtime_release.setUsed(true);
        if (currentRecomposeScope$runtime_release.recordRead(value)) {
            return;
        }
        if (value instanceof StateObjectImpl) {
            ReaderKind.Companion companion = ReaderKind.INSTANCE;
            ((StateObjectImpl) value).m3941recordReadInh_f27i8$runtime_release(ReaderKind.m3928constructorimpl(1));
        }
        ScopeMap.m3902addimpl(this.observations, value, currentRecomposeScope$runtime_release);
        if (value instanceof DerivedState) {
            DerivedState<?> derivedState = (DerivedState) value;
            DerivedState.Record<?> currentRecord = derivedState.getCurrentRecord();
            ScopeMap.m3916removeScopeimpl(this.derivedStates, value);
            ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
            Object[] objArr = dependencies.keys;
            long[] jArr = dependencies.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i5 = 0;
                while (true) {
                    long j = jArr[i5];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8;
                        int i7 = 8 - ((~(i5 - length)) >>> 31);
                        int i8 = 0;
                        while (i8 < i7) {
                            if ((j & 255) < 128) {
                                i2 = i4;
                                StateObject stateObject = (StateObject) objArr[(i5 << 3) + i8];
                                if (stateObject instanceof StateObjectImpl) {
                                    ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                                    i3 = i6;
                                    ((StateObjectImpl) stateObject).m3941recordReadInh_f27i8$runtime_release(ReaderKind.m3928constructorimpl(i2));
                                } else {
                                    i3 = i6;
                                }
                                ScopeMap.m3902addimpl(this.derivedStates, stateObject, value);
                            } else {
                                i2 = i4;
                                i3 = i6;
                            }
                            j >>= i3;
                            i8++;
                            i4 = i2;
                            i6 = i3;
                        }
                        i = i4;
                        if (i7 != i6) {
                            break;
                        }
                    } else {
                        i = i4;
                    }
                    if (i5 == length) {
                        break;
                    }
                    i5++;
                    i4 = i;
                }
            }
            currentRecomposeScope$runtime_release.recordDerivedStateValue(derivedState, currentRecord.getCurrentValue());
        }
    }

    private final void invalidateScopeOfLocked(Object value) {
        Object obj = this.observations.get(value);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (recomposeScopeImpl.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                                ScopeMap.m3902addimpl(this.observationsProcessed, value, recomposeScopeImpl);
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
            if (recomposeScopeImpl2.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                ScopeMap.m3902addimpl(this.observationsProcessed, value, recomposeScopeImpl2);
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recordWriteOf(Object value) {
        synchronized (this.lock) {
            invalidateScopeOfLocked(value);
            Object obj = this.derivedStates.get(value);
            if (obj != null) {
                if (!(obj instanceof MutableScatterSet)) {
                    invalidateScopeOfLocked((DerivedState) obj);
                } else {
                    MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
                    Object[] objArr = mutableScatterSet.elements;
                    long[] jArr = mutableScatterSet.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i = 0;
                        while (true) {
                            long j = jArr[i];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i2 = 8 - ((~(i - length)) >>> 31);
                                for (int i3 = 0; i3 < i2; i3++) {
                                    if ((255 & j) < 128) {
                                        invalidateScopeOfLocked((DerivedState) objArr[(i << 3) + i3]);
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
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        boolean m3750recomposeaFTiNEg$runtime_release;
        synchronized (this.lock) {
            drainPendingModificationsForCompositionLocked();
            try {
                MutableScatterMap<Object, Object> m3752takeInvalidationsafanTW4 = m3752takeInvalidationsafanTW4();
                try {
                    CompositionObserver observer = observer();
                    if (observer != null) {
                        Map<RecomposeScope, ? extends Set<? extends Object>> m3904asMapimpl = ScopeMap.m3904asMapimpl(m3752takeInvalidationsafanTW4);
                        Intrinsics.checkNotNull(m3904asMapimpl, "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>>");
                        observer.onBeginComposition(this, m3904asMapimpl);
                    }
                    m3750recomposeaFTiNEg$runtime_release = this.composer.m3750recomposeaFTiNEg$runtime_release(m3752takeInvalidationsafanTW4, this.shouldPause);
                    if (!m3750recomposeaFTiNEg$runtime_release) {
                        drainPendingModificationsLocked();
                    }
                    if (observer != null) {
                        observer.onEndComposition(this);
                    }
                } catch (Exception e) {
                    this.invalidations = m3752takeInvalidationsafanTW4;
                    throw e;
                }
            } finally {
            }
        }
        return m3750recomposeaFTiNEg$runtime_release;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(MovableContentState state) {
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        SlotWriter openWriter = state.getSlotTable().openWriter();
        try {
            ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
            Unit unit = Unit.INSTANCE;
            openWriter.close(true);
            rememberEventDispatcher.dispatchRememberObservers();
        } catch (Throwable th) {
            openWriter.close(false);
            throw th;
        }
    }

    private final void applyChangesInLocked(ChangeList changes) {
        RememberEventDispatcher rememberEventDispatcher;
        RememberEventDispatcher rememberEventDispatcher2;
        long[] jArr;
        RememberEventDispatcher rememberEventDispatcher3;
        int i;
        long[] jArr2;
        long j;
        char c;
        long j2;
        int i2;
        boolean z;
        long j3;
        RecordingApplier<Object> pausableApplier$runtime_release;
        RememberEventDispatcher rememberEventDispatcher4 = new RememberEventDispatcher(this.abandonSet);
        try {
            if (!changes.isEmpty()) {
                try {
                    Object beginSection = Trace.INSTANCE.beginSection("Compose:applyChanges");
                    try {
                        PausedCompositionImpl pausedCompositionImpl = this.pendingPausedComposition;
                        RecordingApplier<Object> recordingApplier = (pausedCompositionImpl == null || (pausableApplier$runtime_release = pausedCompositionImpl.getPausableApplier$runtime_release()) == null) ? this.applier : pausableApplier$runtime_release;
                        PausedCompositionImpl pausedCompositionImpl2 = this.pendingPausedComposition;
                        if (pausedCompositionImpl2 == null || (rememberEventDispatcher = pausedCompositionImpl2.getRememberManager()) == null) {
                            rememberEventDispatcher = rememberEventDispatcher4;
                        }
                        recordingApplier.onBeginChanges();
                        SlotWriter openWriter = this.slotTable.openWriter();
                        int i3 = 0;
                        try {
                            changes.executeAndFlushAllPendingChanges(recordingApplier, openWriter, rememberEventDispatcher);
                            Unit unit = Unit.INSTANCE;
                            openWriter.close(true);
                            recordingApplier.onEndChanges();
                            Unit unit2 = Unit.INSTANCE;
                            Trace.INSTANCE.endSection(beginSection);
                            rememberEventDispatcher4.dispatchRememberObservers();
                            rememberEventDispatcher4.dispatchSideEffects();
                            if (this.pendingInvalidScopes) {
                                Object beginSection2 = Trace.INSTANCE.beginSection("Compose:unobserve");
                                try {
                                    this.pendingInvalidScopes = false;
                                    MutableScatterMap<Object, Object> mutableScatterMap = this.observations;
                                    long[] jArr3 = mutableScatterMap.metadata;
                                    int length = jArr3.length - 2;
                                    if (length >= 0) {
                                        int i4 = 0;
                                        while (true) {
                                            long j4 = jArr3[i4];
                                            char c2 = 7;
                                            long j5 = -9187201950435737472L;
                                            if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                int i5 = 8;
                                                int i6 = 8 - ((~(i4 - length)) >>> 31);
                                                int i7 = i3;
                                                while (i7 < i6) {
                                                    if ((j4 & 255) < 128) {
                                                        c = c2;
                                                        int i8 = (i4 << 3) + i7;
                                                        j2 = j5;
                                                        Object obj = mutableScatterMap.keys[i8];
                                                        Object obj2 = mutableScatterMap.values[i8];
                                                        if (obj2 instanceof MutableScatterSet) {
                                                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                                            Object[] objArr = mutableScatterSet.elements;
                                                            long[] jArr4 = mutableScatterSet.metadata;
                                                            int i9 = i5;
                                                            int length2 = jArr4.length - 2;
                                                            rememberEventDispatcher3 = rememberEventDispatcher4;
                                                            i = i7;
                                                            jArr2 = jArr3;
                                                            if (length2 >= 0) {
                                                                int i10 = 0;
                                                                while (true) {
                                                                    try {
                                                                        long j6 = jArr4[i10];
                                                                        j = j4;
                                                                        if ((((~j6) << c) & j6 & j2) != j2) {
                                                                            int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                                                            for (int i12 = 0; i12 < i11; i12++) {
                                                                                if ((j6 & 255) < 128) {
                                                                                    j3 = j6;
                                                                                    int i13 = (i10 << 3) + i12;
                                                                                    if (!((RecomposeScopeImpl) objArr[i13]).getValid()) {
                                                                                        mutableScatterSet.removeElementAt(i13);
                                                                                    }
                                                                                } else {
                                                                                    j3 = j6;
                                                                                }
                                                                                j6 = j3 >> i9;
                                                                            }
                                                                            if (i11 != i9) {
                                                                                break;
                                                                            }
                                                                        }
                                                                        if (i10 == length2) {
                                                                            break;
                                                                        }
                                                                        i10++;
                                                                        j4 = j;
                                                                        i9 = 8;
                                                                    } catch (Throwable th) {
                                                                        th = th;
                                                                        Trace.INSTANCE.endSection(beginSection2);
                                                                        throw th;
                                                                    }
                                                                }
                                                            } else {
                                                                j = j4;
                                                            }
                                                            z = mutableScatterSet.isEmpty();
                                                        } else {
                                                            rememberEventDispatcher3 = rememberEventDispatcher4;
                                                            i = i7;
                                                            jArr2 = jArr3;
                                                            j = j4;
                                                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                                            z = !((RecomposeScopeImpl) obj2).getValid();
                                                        }
                                                        if (z) {
                                                            mutableScatterMap.removeValueAt(i8);
                                                        }
                                                        i2 = 8;
                                                    } else {
                                                        rememberEventDispatcher3 = rememberEventDispatcher4;
                                                        i = i7;
                                                        jArr2 = jArr3;
                                                        j = j4;
                                                        c = c2;
                                                        j2 = j5;
                                                        i2 = i5;
                                                    }
                                                    j4 = j >> i2;
                                                    i5 = i2;
                                                    c2 = c;
                                                    j5 = j2;
                                                    jArr3 = jArr2;
                                                    i7 = i + 1;
                                                    rememberEventDispatcher4 = rememberEventDispatcher3;
                                                }
                                                rememberEventDispatcher2 = rememberEventDispatcher4;
                                                jArr = jArr3;
                                                if (i6 != i5) {
                                                    break;
                                                }
                                            } else {
                                                rememberEventDispatcher2 = rememberEventDispatcher4;
                                                jArr = jArr3;
                                            }
                                            if (i4 == length) {
                                                break;
                                            }
                                            i4++;
                                            rememberEventDispatcher4 = rememberEventDispatcher2;
                                            jArr3 = jArr;
                                            i3 = 0;
                                        }
                                    } else {
                                        rememberEventDispatcher2 = rememberEventDispatcher4;
                                    }
                                    cleanUpDerivedStateObservations();
                                    Unit unit3 = Unit.INSTANCE;
                                    Trace.INSTANCE.endSection(beginSection2);
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } else {
                                rememberEventDispatcher2 = rememberEventDispatcher4;
                            }
                            if (this.lateChanges.isEmpty() && this.pendingPausedComposition == null) {
                                rememberEventDispatcher2.dispatchAbandons();
                            }
                        } catch (Throwable th3) {
                            try {
                                openWriter.close(false);
                                throw th3;
                            } catch (Throwable th4) {
                                th = th4;
                                Trace.INSTANCE.endSection(beginSection);
                                throw th;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (this.lateChanges.isEmpty() && this.pendingPausedComposition == null) {
                        rememberEventDispatcher4.dispatchAbandons();
                    }
                    throw th;
                }
            } else if (this.lateChanges.isEmpty() && this.pendingPausedComposition == null) {
                rememberEventDispatcher4.dispatchAbandons();
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } finally {
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (this.lateChanges.isNotEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } finally {
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime_release();
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } finally {
            }
        }
    }

    private final <T> T guardInvalidationsLocked(Function1<? super ScopeMap<RecomposeScopeImpl, Object>, ? extends T> block) {
        MutableScatterMap<Object, Object> m3752takeInvalidationsafanTW4 = m3752takeInvalidationsafanTW4();
        try {
            return block.invoke(ScopeMap.m3905boximpl(m3752takeInvalidationsafanTW4));
        } catch (Exception e) {
            this.invalidations = m3752takeInvalidationsafanTW4;
            throw e;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        if (this.abandonSet.isEmpty()) {
            return;
        }
        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        synchronized (this.lock) {
            for (Object obj : this.slotTable.getSlots()) {
                RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.composer.verifyConsistent$runtime_release();
                this.slotTable.verifyWellFormed();
                validateRecomposeScopeAnchors(this.slotTable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(ControlledComposition to, int groupIndex, Function0<? extends R> block) {
        if (to != null && !Intrinsics.areEqual(to, this) && groupIndex >= 0) {
            this.invalidationDelegate = (CompositionImpl) to;
            this.invalidationDelegateGroup = groupIndex;
            try {
                return block.invoke();
            } finally {
                this.invalidationDelegate = null;
                this.invalidationDelegateGroup = 0;
            }
        }
        return block.invoke();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public ShouldPauseCallback getAndSetShouldPauseCallback(ShouldPauseCallback shouldPause) {
        ShouldPauseCallback shouldPauseCallback = this.shouldPause;
        this.shouldPause = shouldPause;
        return shouldPauseCallback;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
        CompositionImpl compositionImpl;
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (!this.slotTable.ownsAnchor(anchor)) {
            synchronized (this.lock) {
                compositionImpl = this.invalidationDelegate;
            }
            if (compositionImpl != null && compositionImpl.tryImminentInvalidation(scope, instance)) {
                return InvalidationResult.IMMINENT;
            }
            return InvalidationResult.IGNORED;
        }
        if (!scope.getCanRecompose()) {
            return InvalidationResult.IGNORED;
        }
        return invalidateChecked(scope, anchor, instance);
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void recomposeScopeReleased(RecomposeScopeImpl scope) {
        this.pendingInvalidScopes = true;
    }

    @Override // androidx.compose.runtime.CompositionServices
    public <T> T getCompositionService(CompositionServiceKey<T> key) {
        if (Intrinsics.areEqual(key, CompositionKt.getCompositionImplServiceKey())) {
            return (T) this;
        }
        return null;
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl scope, Object instance) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime_release(scope, instance);
    }

    private final InvalidationResult invalidateChecked(RecomposeScopeImpl scope, Anchor anchor, Object instance) {
        int i;
        synchronized (this.lock) {
            CompositionImpl compositionImpl = this.invalidationDelegate;
            CompositionImpl compositionImpl2 = null;
            if (compositionImpl != null) {
                if (!this.slotTable.groupContainsAnchor(this.invalidationDelegateGroup, anchor)) {
                    compositionImpl = null;
                }
                compositionImpl2 = compositionImpl;
            }
            if (compositionImpl2 == null) {
                if (tryImminentInvalidation(scope, instance)) {
                    return InvalidationResult.IMMINENT;
                }
                CompositionObserver observer = observer();
                if (instance == null) {
                    ScopeMap.m3918setimpl(this.invalidations, scope, ScopeInvalidated.INSTANCE);
                } else if (observer == null && !(instance instanceof DerivedState)) {
                    ScopeMap.m3918setimpl(this.invalidations, scope, ScopeInvalidated.INSTANCE);
                } else {
                    Object obj = this.invalidations.get(scope);
                    if (obj != null) {
                        if (obj instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
                            Object[] objArr = mutableScatterSet.elements;
                            long[] jArr = mutableScatterSet.metadata;
                            int length = jArr.length - 2;
                            if (length >= 0) {
                                int i2 = 0;
                                loop0: while (true) {
                                    long j = jArr[i2];
                                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i3 = 8;
                                        int i4 = 8 - ((~(i2 - length)) >>> 31);
                                        int i5 = 0;
                                        while (i5 < i4) {
                                            if ((j & 255) < 128) {
                                                i = i3;
                                                if (objArr[(i2 << 3) + i5] == ScopeInvalidated.INSTANCE) {
                                                    break loop0;
                                                }
                                            } else {
                                                i = i3;
                                            }
                                            j >>= i;
                                            i5++;
                                            i3 = i;
                                        }
                                        if (i4 != i3) {
                                            break;
                                        }
                                    }
                                    if (i2 == length) {
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        } else if (obj == ScopeInvalidated.INSTANCE) {
                        }
                    }
                    ScopeMap.m3902addimpl(this.invalidations, scope, instance);
                }
            }
            if (compositionImpl2 != null) {
                return compositionImpl2.invalidateChecked(scope, anchor, instance);
            }
            this.parent.invalidate$runtime_release(this);
            return isComposing() ? InvalidationResult.DEFERRED : InvalidationResult.SCHEDULED;
        }
    }

    public final void removeObservation$runtime_release(Object instance, RecomposeScopeImpl scope) {
        ScopeMap.m3915removeimpl(this.observations, instance, scope);
    }

    public final void removeDerivedStateObservation$runtime_release(DerivedState<?> state) {
        if (ScopeMap.m3909containsimpl(this.observations, state)) {
            return;
        }
        ScopeMap.m3916removeScopeimpl(this.derivedStates, state);
    }

    /* renamed from: takeInvalidations-afanTW4, reason: not valid java name */
    private final MutableScatterMap<Object, Object> m3752takeInvalidationsafanTW4() {
        MutableScatterMap<Object, Object> mutableScatterMap = this.invalidations;
        this.invalidations = ScopeMap.m3908constructorimpl$default(null, 1, null);
        return mutableScatterMap;
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable) {
        Object[] slots = slotTable.getSlots();
        ArrayList arrayList = new ArrayList();
        for (Object obj : slots) {
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                arrayList.add(recomposeScopeImpl);
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) arrayList2.get(i);
            Anchor anchor = recomposeScopeImpl2.getAnchor();
            if (anchor != null && !slotTable.slotsOf$runtime_release(anchor.toIndexFor(slotTable)).contains(recomposeScopeImpl2)) {
                PreconditionsKt.throwIllegalStateException("Misaligned anchor " + anchor + " in scope " + recomposeScopeImpl2 + " encountered, scope found at " + ArraysKt.indexOf((RecomposeScopeImpl[]) slotTable.getSlots(), recomposeScopeImpl2));
            }
        }
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> block) {
        try {
            return block.invoke();
        } catch (Throwable th) {
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            throw th;
        }
    }

    private final CompositionObserver observer() {
        CompositionObserverHolder compositionObserverHolder = this.observerHolder;
        if (compositionObserverHolder.getRoot()) {
            return compositionObserverHolder.getObserver();
        }
        CompositionObserverHolder observerHolder = this.parent.getObserverHolder();
        CompositionObserver observer = observerHolder != null ? observerHolder.getObserver() : null;
        if (!Intrinsics.areEqual(observer, compositionObserverHolder.getObserver())) {
            compositionObserverHolder.setObserver(observer);
        }
        return observer;
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void deactivate() {
        synchronized (this.lock) {
            boolean z = this.slotTable.getGroupsSize() > 0;
            if (z || !this.abandonSet.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:deactivate");
                try {
                    RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                    if (z) {
                        this.applier.onBeginChanges();
                        SlotWriter openWriter = this.slotTable.openWriter();
                        try {
                            ComposerKt.deactivateCurrentGroup(openWriter, rememberEventDispatcher);
                            Unit unit = Unit.INSTANCE;
                            openWriter.close(true);
                            this.applier.onEndChanges();
                            rememberEventDispatcher.dispatchRememberObservers();
                        } catch (Throwable th) {
                            openWriter.close(false);
                            throw th;
                        }
                    }
                    rememberEventDispatcher.dispatchAbandons();
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(beginSection);
                }
            }
            ScopeMap.m3906clearimpl(this.observations);
            ScopeMap.m3906clearimpl(this.derivedStates);
            ScopeMap.m3906clearimpl(this.invalidations);
            this.changes.clear();
            this.lateChanges.clear();
            this.composer.deactivate$runtime_release();
            Unit unit3 = Unit.INSTANCE;
        }
    }

    public final int composerStacksSizes$runtime_release() {
        return this.composer.stacksSize$runtime_release();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        return true;
     */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean observesAnyOf(java.util.Set<? extends java.lang.Object> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof androidx.compose.runtime.collection.ScatterSetWrapper
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5c
            androidx.compose.runtime.collection.ScatterSetWrapper r15 = (androidx.compose.runtime.collection.ScatterSetWrapper) r15
            androidx.collection.ScatterSet r15 = r15.getSet$runtime_release()
            java.lang.Object[] r0 = r15.elements
            long[] r15 = r15.metadata
            int r3 = r15.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L7d
            r4 = r1
        L16:
            r5 = r15[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L57
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r1
        L30:
            if (r9 >= r7) goto L55
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.32E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L51
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r0[r10]
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r11 = r14.observations
            boolean r11 = androidx.compose.runtime.collection.ScopeMap.m3909containsimpl(r11, r10)
            if (r11 != 0) goto L50
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r11 = r14.derivedStates
            boolean r10 = androidx.compose.runtime.collection.ScopeMap.m3909containsimpl(r11, r10)
            if (r10 == 0) goto L51
        L50:
            return r2
        L51:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L30
        L55:
            if (r7 != r8) goto L7d
        L57:
            if (r4 == r3) goto L7d
            int r4 = r4 + 1
            goto L16
        L5c:
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.Iterator r15 = r15.iterator()
        L62:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L7d
            java.lang.Object r0 = r15.next()
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r3 = r14.observations
            boolean r3 = androidx.compose.runtime.collection.ScopeMap.m3909containsimpl(r3, r0)
            if (r3 != 0) goto L7c
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r3 = r14.derivedStates
            boolean r0 = androidx.compose.runtime.collection.ScopeMap.m3909containsimpl(r3, r0)
            if (r0 == 0) goto L62
        L7c:
            return r2
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.observesAnyOf(java.util.Set):boolean");
    }

    private final void addPendingInvalidationsLocked(Set<? extends Object> values, boolean forgetConditionalScopes) {
        char c;
        long j;
        long j2;
        long j3;
        int i;
        long[] jArr;
        String str;
        long[] jArr2;
        String str2;
        int i2;
        long j4;
        boolean contains;
        String str3;
        int i3;
        long[] jArr3;
        int i4;
        long[] jArr4;
        int i5;
        int i6;
        long j5;
        boolean z;
        int i7;
        long j6;
        long j7;
        char c2;
        long j8;
        int i8;
        int i9;
        int i10;
        Object obj = null;
        char c3 = 7;
        long j9 = -9187201950435737472L;
        int i11 = 8;
        if (values instanceof ScatterSetWrapper) {
            ScatterSet set$runtime_release = ((ScatterSetWrapper) values).getSet$runtime_release();
            Object[] objArr = set$runtime_release.elements;
            long[] jArr5 = set$runtime_release.metadata;
            int length = jArr5.length - 2;
            if (length >= 0) {
                int i12 = 0;
                j2 = 128;
                while (true) {
                    long j10 = jArr5[i12];
                    j3 = 255;
                    if ((((~j10) << c3) & j10 & j9) != j9) {
                        int i13 = 8 - ((~(i12 - length)) >>> 31);
                        int i14 = 0;
                        while (i14 < i13) {
                            if ((j10 & 255) < 128) {
                                c2 = c3;
                                Object obj2 = objArr[(i12 << 3) + i14];
                                j8 = j9;
                                if (obj2 instanceof RecomposeScopeImpl) {
                                    ((RecomposeScopeImpl) obj2).invalidateForResult(obj);
                                } else {
                                    addPendingInvalidationsLocked(obj2, forgetConditionalScopes);
                                    Object obj3 = this.derivedStates.get(obj2);
                                    if (obj3 != null) {
                                        if (obj3 instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj3;
                                            Object[] objArr2 = mutableScatterSet.elements;
                                            long[] jArr6 = mutableScatterSet.metadata;
                                            int length2 = jArr6.length - 2;
                                            if (length2 >= 0) {
                                                j7 = j10;
                                                int i15 = 0;
                                                while (true) {
                                                    long j11 = jArr6[i15];
                                                    int i16 = i11;
                                                    i8 = length;
                                                    if ((((~j11) << c2) & j11 & j8) != j8) {
                                                        int i17 = 8 - ((~(i15 - length2)) >>> 31);
                                                        int i18 = 0;
                                                        while (i18 < i17) {
                                                            if ((j11 & 255) < 128) {
                                                                i10 = i16;
                                                                addPendingInvalidationsLocked((DerivedState) objArr2[(i15 << 3) + i18], forgetConditionalScopes);
                                                            } else {
                                                                i10 = i16;
                                                            }
                                                            j11 >>= i10;
                                                            i18++;
                                                            i16 = i10;
                                                        }
                                                        if (i17 != i16) {
                                                            break;
                                                        }
                                                    }
                                                    if (i15 == length2) {
                                                        break;
                                                    }
                                                    i15++;
                                                    length = i8;
                                                    i11 = 8;
                                                }
                                            }
                                        } else {
                                            j7 = j10;
                                            i8 = length;
                                            addPendingInvalidationsLocked((DerivedState) obj3, forgetConditionalScopes);
                                        }
                                        i9 = 8;
                                    }
                                }
                                j7 = j10;
                                i8 = length;
                                i9 = 8;
                            } else {
                                j7 = j10;
                                c2 = c3;
                                j8 = j9;
                                i8 = length;
                                i9 = i11;
                            }
                            i14++;
                            length = i8;
                            i11 = i9;
                            c3 = c2;
                            j9 = j8;
                            j10 = j7 >> i9;
                            obj = null;
                        }
                        c = c3;
                        j = j9;
                        int i19 = length;
                        if (i13 != i11) {
                            break;
                        } else {
                            length = i19;
                        }
                    } else {
                        c = c3;
                        j = j9;
                    }
                    if (i12 == length) {
                        break;
                    }
                    i12++;
                    c3 = c;
                    j9 = j;
                    obj = null;
                    i11 = 8;
                }
            } else {
                c = 7;
                j = -9187201950435737472L;
                j2 = 128;
                j3 = 255;
            }
        } else {
            c = 7;
            j = -9187201950435737472L;
            j2 = 128;
            j3 = 255;
            for (Object obj4 : values) {
                if (obj4 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj4).invalidateForResult(null);
                } else {
                    addPendingInvalidationsLocked(obj4, forgetConditionalScopes);
                    Object obj5 = this.derivedStates.get(obj4);
                    if (obj5 != null) {
                        if (obj5 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj5;
                            Object[] objArr3 = mutableScatterSet2.elements;
                            long[] jArr7 = mutableScatterSet2.metadata;
                            int length3 = jArr7.length - 2;
                            if (length3 >= 0) {
                                while (true) {
                                    long j12 = jArr7[i];
                                    if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i20 = 8 - ((~(i - length3)) >>> 31);
                                        for (int i21 = 0; i21 < i20; i21++) {
                                            if ((j12 & 255) < 128) {
                                                addPendingInvalidationsLocked((DerivedState) objArr3[(i << 3) + i21], forgetConditionalScopes);
                                            }
                                            j12 >>= 8;
                                        }
                                        if (i20 != 8) {
                                            break;
                                        }
                                    }
                                    i = i != length3 ? i + 1 : 0;
                                }
                            }
                        } else {
                            addPendingInvalidationsLocked((DerivedState) obj5, forgetConditionalScopes);
                        }
                    }
                }
            }
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet3 = this.conditionallyInvalidatedScopes;
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet4 = this.invalidatedScopes;
        String str4 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>";
        if (forgetConditionalScopes && mutableScatterSet3.isNotEmpty()) {
            MutableScatterMap<Object, Object> mutableScatterMap = this.observations;
            long[] jArr8 = mutableScatterMap.metadata;
            int length4 = jArr8.length - 2;
            if (length4 >= 0) {
                int i22 = 0;
                while (true) {
                    long j13 = jArr8[i22];
                    if ((((~j13) << c) & j13 & j) != j) {
                        int i23 = 8 - ((~(i22 - length4)) >>> 31);
                        int i24 = 0;
                        while (i24 < i23) {
                            if ((j13 & j3) < j2) {
                                int i25 = (i22 << 3) + i24;
                                Object obj6 = mutableScatterMap.keys[i25];
                                Object obj7 = mutableScatterMap.values[i25];
                                if (obj7 instanceof MutableScatterSet) {
                                    Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                    MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj7;
                                    Object[] objArr4 = mutableScatterSet5.elements;
                                    long[] jArr9 = mutableScatterSet5.metadata;
                                    jArr4 = jArr8;
                                    int length5 = jArr9.length - 2;
                                    if (length5 >= 0) {
                                        j5 = j13;
                                        int i26 = 0;
                                        while (true) {
                                            long j14 = jArr9[i26];
                                            i5 = length4;
                                            i6 = i22;
                                            if ((((~j14) << c) & j14 & j) != j) {
                                                int i27 = 8 - ((~(i26 - length5)) >>> 31);
                                                int i28 = 0;
                                                while (i28 < i27) {
                                                    if ((j14 & j3) < j2) {
                                                        i7 = i28;
                                                        int i29 = (i26 << 3) + i7;
                                                        j6 = j14;
                                                        RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr4[i29];
                                                        if (mutableScatterSet3.contains(recomposeScopeImpl) || mutableScatterSet4.contains(recomposeScopeImpl)) {
                                                            mutableScatterSet5.removeElementAt(i29);
                                                        }
                                                    } else {
                                                        i7 = i28;
                                                        j6 = j14;
                                                    }
                                                    j14 = j6 >> 8;
                                                    i28 = i7 + 1;
                                                }
                                                if (i27 != 8) {
                                                    break;
                                                }
                                            }
                                            if (i26 == length5) {
                                                break;
                                            }
                                            i26++;
                                            length4 = i5;
                                            i22 = i6;
                                        }
                                    } else {
                                        i5 = length4;
                                        i6 = i22;
                                        j5 = j13;
                                    }
                                    z = mutableScatterSet5.isEmpty();
                                } else {
                                    jArr4 = jArr8;
                                    i5 = length4;
                                    i6 = i22;
                                    j5 = j13;
                                    Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                    RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj7;
                                    z = mutableScatterSet3.contains(recomposeScopeImpl2) || mutableScatterSet4.contains(recomposeScopeImpl2);
                                }
                                if (z) {
                                    mutableScatterMap.removeValueAt(i25);
                                }
                            } else {
                                jArr4 = jArr8;
                                i5 = length4;
                                i6 = i22;
                                j5 = j13;
                            }
                            j13 = j5 >> 8;
                            i24++;
                            jArr8 = jArr4;
                            length4 = i5;
                            i22 = i6;
                        }
                        jArr3 = jArr8;
                        int i30 = length4;
                        int i31 = i22;
                        if (i23 != 8) {
                            break;
                        }
                        length4 = i30;
                        i4 = i31;
                    } else {
                        jArr3 = jArr8;
                        i4 = i22;
                    }
                    if (i4 == length4) {
                        break;
                    }
                    i22 = i4 + 1;
                    jArr8 = jArr3;
                }
            }
            mutableScatterSet3.clear();
            cleanUpDerivedStateObservations();
            return;
        }
        if (mutableScatterSet4.isNotEmpty()) {
            MutableScatterMap<Object, Object> mutableScatterMap2 = this.observations;
            long[] jArr10 = mutableScatterMap2.metadata;
            int length6 = jArr10.length - 2;
            if (length6 >= 0) {
                int i32 = 0;
                while (true) {
                    long j15 = jArr10[i32];
                    if ((((~j15) << c) & j15 & j) != j) {
                        int i33 = 8 - ((~(i32 - length6)) >>> 31);
                        int i34 = 0;
                        while (i34 < i33) {
                            if ((j15 & j3) < j2) {
                                int i35 = (i32 << 3) + i34;
                                Object obj8 = mutableScatterMap2.keys[i35];
                                Object obj9 = mutableScatterMap2.values[i35];
                                if (obj9 instanceof MutableScatterSet) {
                                    Intrinsics.checkNotNull(obj9, str4);
                                    MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj9;
                                    Object[] objArr5 = mutableScatterSet6.elements;
                                    long[] jArr11 = mutableScatterSet6.metadata;
                                    int length7 = jArr11.length - 2;
                                    jArr2 = jArr10;
                                    if (length7 >= 0) {
                                        j4 = j15;
                                        int i36 = 0;
                                        while (true) {
                                            long j16 = jArr11[i36];
                                            long[] jArr12 = jArr11;
                                            i2 = length6;
                                            if ((((~j16) << c) & j16 & j) != j) {
                                                int i37 = 8 - ((~(i36 - length7)) >>> 31);
                                                int i38 = 0;
                                                while (i38 < i37) {
                                                    if ((j16 & j3) < j2) {
                                                        str3 = str4;
                                                        int i39 = (i36 << 3) + i38;
                                                        i3 = i38;
                                                        if (mutableScatterSet4.contains((RecomposeScopeImpl) objArr5[i39])) {
                                                            mutableScatterSet6.removeElementAt(i39);
                                                        }
                                                    } else {
                                                        str3 = str4;
                                                        i3 = i38;
                                                    }
                                                    j16 >>= 8;
                                                    i38 = i3 + 1;
                                                    str4 = str3;
                                                }
                                                str2 = str4;
                                                if (i37 != 8) {
                                                    break;
                                                }
                                            } else {
                                                str2 = str4;
                                            }
                                            if (i36 == length7) {
                                                break;
                                            }
                                            i36++;
                                            length6 = i2;
                                            jArr11 = jArr12;
                                            str4 = str2;
                                        }
                                    } else {
                                        str2 = str4;
                                        i2 = length6;
                                        j4 = j15;
                                    }
                                    contains = mutableScatterSet6.isEmpty();
                                } else {
                                    jArr2 = jArr10;
                                    str2 = str4;
                                    i2 = length6;
                                    j4 = j15;
                                    Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                    contains = mutableScatterSet4.contains((RecomposeScopeImpl) obj9);
                                }
                                if (contains) {
                                    mutableScatterMap2.removeValueAt(i35);
                                }
                            } else {
                                jArr2 = jArr10;
                                str2 = str4;
                                i2 = length6;
                                j4 = j15;
                            }
                            j15 = j4 >> 8;
                            i34++;
                            jArr10 = jArr2;
                            length6 = i2;
                            str4 = str2;
                        }
                        jArr = jArr10;
                        str = str4;
                        int i40 = length6;
                        if (i33 != 8) {
                            break;
                        } else {
                            length6 = i40;
                        }
                    } else {
                        jArr = jArr10;
                        str = str4;
                    }
                    if (i32 == length6) {
                        break;
                    }
                    i32++;
                    jArr10 = jArr;
                    str4 = str;
                }
            }
            cleanUpDerivedStateObservations();
            mutableScatterSet4.clear();
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        int size = references.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!Intrinsics.areEqual(references.get(i).getFirst().getComposition(), this)) {
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        try {
            this.composer.insertMovableContentReferences(references);
            Unit unit = Unit.INSTANCE;
        } finally {
        }
    }

    private final <T> T guardChanges(Function0<? extends T> block) {
        try {
            return block.invoke();
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            } catch (Exception e) {
                this.abandonChanges();
                throw e;
            }
        }
    }
}
