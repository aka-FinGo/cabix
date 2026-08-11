package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SharedTransitionScope.kt */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 \u0083\u00012\u00020\u00012\u00020\u0002:\u0004\u0083\u0001\u0084\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\u0015\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020*H\u0000¢\u0006\u0002\b8J\u0015\u00109\u001a\u00020\u001d2\u0006\u00107\u001a\u00020:H\u0000¢\u0006\u0002\b;J\b\u0010<\u001a\u00020\u001dH\u0002J7\u0010=\u001a\u00020\u001d2\u0006\u00107\u001a\u00020+2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001d0-2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0000¢\u0006\u0002\b@J\r\u0010A\u001a\u00020\u001dH\u0000¢\u0006\u0002\bBJ\u0015\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020$H\u0000¢\u0006\u0002\bEJ\u0015\u0010F\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020$H\u0000¢\u0006\u0002\bGJ\u0015\u0010H\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020JH\u0000¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020JH\u0000¢\u0006\u0002\bMJ\u0015\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020*H\u0017¢\u0006\u0002\u0010QJM\u0010R\u001a\u00020J2\u0006\u0010S\u001a\u00020+2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\n2\u0006\u0010Y\u001a\u00020O2\u0006\u0010Z\u001a\u0002032\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\nH\u0003¢\u0006\u0002\u0010^J\u0010\u0010_\u001a\u00020+2\u0006\u0010P\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020\u001dH\u0002J3\u0010`\u001a\u00020a*\u00020\u00142\u0006\u0010b\u001a\u00020\u00142\b\b\u0002\u0010c\u001a\u00020a2\b\b\u0002\u0010d\u001a\u00020\nH\u0096\u0001ø\u0001\u0000¢\u0006\u0004\be\u0010fJ>\u0010g\u001a\u00020h*\u00020h2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\n0\u001c2\u0006\u0010[\u001a\u00020\\2\u001a\u0010Z\u001a\u0016\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020l\u0012\u0006\u0012\u0004\u0018\u00010m0jH\u0016J\\\u0010n\u001a\u00020h*\u00020h2\u0006\u0010Y\u001a\u00020O2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020x2\u0006\u0010V\u001a\u00020W2\u0006\u0010]\u001a\u00020\n2\u0006\u0010[\u001a\u00020\\2\u0006\u0010Z\u001a\u000203H\u0016Jp\u0010y\u001a\u00020h\"\u0004\b\u0000\u0010z*\u00020h2\u0006\u0010Y\u001a\u00020O2\u000e\u0010{\u001a\n\u0012\u0004\u0012\u0002Hz\u0018\u00010|2\u0012\u0010}\u001a\u000e\u0012\u0004\u0012\u0002Hz\u0012\u0004\u0012\u00020\n0-2\u0006\u0010u\u001a\u00020v2\b\b\u0002\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\n2\u0006\u0010]\u001a\u00020\n2\u0006\u0010[\u001a\u00020\\2\u0006\u0010Z\u001a\u000203H\u0002JS\u0010~\u001a\u00020h*\u00020h2\u0006\u0010Y\u001a\u00020O2\u0006\u0010}\u001a\u00020\n2\b\b\u0002\u0010u\u001a\u00020v2\b\b\u0002\u0010V\u001a\u00020W2\b\b\u0002\u0010]\u001a\u00020\n2\b\b\u0002\u0010[\u001a\u00020\\2\b\b\u0002\u0010Z\u001a\u000203H\u0000¢\u0006\u0002\b\u007fJD\u0010S\u001a\u00020h*\u00020h2\u0006\u0010Y\u001a\u00020O2\u0006\u0010o\u001a\u00020p2\u0006\u0010u\u001a\u00020v2\u0006\u0010V\u001a\u00020W2\u0006\u0010]\u001a\u00020\n2\u0006\u0010[\u001a\u00020\\2\u0006\u0010Z\u001a\u000203H\u0016JE\u0010\u0080\u0001\u001a\u00020h*\u00020h2\u0006\u0010Y\u001a\u00020O2\u0006\u0010}\u001a\u00020\n2\u0006\u0010u\u001a\u00020v2\u0006\u0010V\u001a\u00020W2\u0006\u0010]\u001a\u00020\n2\u0006\u0010[\u001a\u00020\\2\u0006\u0010Z\u001a\u000203H\u0016J\r\u0010\u0081\u0001\u001a\u00020h*\u00020hH\u0016J\u000e\u0010\u0082\u0001\u001a\u00020\u0014*\u00020\u0014H\u0096\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR+\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0016\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\u0014X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u001aR\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001d0-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\u00020\u0014*\u00020/X\u0096\u0005¢\u0006\u0006\u001a\u0004\b0\u00101\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0085\u0001"}, d2 = {"Landroidx/compose/animation/SharedTransitionScopeImpl;", "Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/ui/layout/LookaheadScope;", "lookaheadScope", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/layout/LookaheadScope;Lkotlinx/coroutines/CoroutineScope;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "<set-?>", "", "disposed", "getDisposed$animation_release", "()Z", "isTransitionActive", "setTransitionActive", "(Z)V", "isTransitionActive$delegate", "Landroidx/compose/runtime/MutableState;", "lookaheadRoot", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLookaheadRoot$animation_release", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "nullableLookaheadRoot", "getNullableLookaheadRoot$animation_release", "setNullableLookaheadRoot$animation_release", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "observeAnimatingBlock", "Lkotlin/Function0;", "", "observerForTest", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "getObserverForTest$animation_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "renderers", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/LayerRenderer;", "root", "getRoot$animation_release", "setRoot$animation_release", "sharedElements", "Landroidx/collection/MutableScatterMap;", "", "Landroidx/compose/animation/SharedElement;", "updateTransitionActiveness", "Lkotlin/Function1;", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "OverlayClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "clearObservation", "scope", "clearObservation$animation_release", "drawInOverlay", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawInOverlay$animation_release", "observeIsAnimating", "observeReads", "onValueChangedForScope", "block", "observeReads$animation_release", "onDispose", "onDispose$animation_release", "onLayerRendererCreated", "renderer", "onLayerRendererCreated$animation_release", "onLayerRendererRemoved", "onLayerRendererRemoved$animation_release", "onStateAdded", "sharedElementState", "Landroidx/compose/animation/SharedElementInternalState;", "onStateAdded$animation_release", "onStateRemoved", "onStateRemoved$animation_release", "rememberSharedContentState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "key", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "rememberSharedElementState", "sharedElement", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "placeHolderSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "renderOnlyWhenVisible", "sharedContentState", "clipInOverlayDuringTransition", "zIndexInOverlay", "", "renderInOverlayDuringTransition", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsAnimation;Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;ZLandroidx/compose/animation/SharedTransitionScope$SharedContentState;Landroidx/compose/animation/SharedTransitionScope$OverlayClip;FZLandroidx/compose/runtime/Composer;I)Landroidx/compose/animation/SharedElementInternalState;", "sharedElementsFor", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "sourceCoordinates", "relativeToSource", "includeMotionFrameOfReference", "localLookaheadPositionOf-au-aQtc", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "renderInSharedTransitionScopeOverlay", "Landroidx/compose/ui/Modifier;", "renderInOverlay", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "sharedBounds", "animatedVisibilityScope", "Landroidx/compose/animation/AnimatedVisibilityScope;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "resizeMode", "Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "sharedBoundsImpl", ExifInterface.GPS_DIRECTION_TRUE, "parentTransition", "Landroidx/compose/animation/core/Transition;", "visible", "sharedBoundsWithCallerManagedVisibility", "sharedBoundsWithCallerManagedVisibility$animation_release", "sharedElementWithCallerManagedVisibility", "skipToLookaheadSize", "toLookaheadCoordinates", "Companion", "ShapeBasedClip", "animation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SharedTransitionScopeImpl implements SharedTransitionScope, LookaheadScope {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<SnapshotStateObserver> SharedTransitionObserver$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SnapshotStateObserver>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$Companion$SharedTransitionObserver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SnapshotStateObserver invoke() {
            SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$Companion$SharedTransitionObserver$2.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
                    invoke2((Function0<Unit>) function0);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Function0<Unit> function0) {
                    function0.invoke();
                }
            });
            snapshotStateObserver.start();
            return snapshotStateObserver;
        }
    });
    private final /* synthetic */ LookaheadScope $$delegate_0;
    private final CoroutineScope coroutineScope;
    private boolean disposed;

    /* renamed from: isTransitionActive$delegate, reason: from kotlin metadata */
    private final MutableState isTransitionActive;
    private LayoutCoordinates nullableLookaheadRoot;
    private final Function0<Unit> observeAnimatingBlock;
    private final SnapshotStateList<LayerRenderer> renderers;
    public LayoutCoordinates root;
    private final MutableScatterMap<Object, SharedElement> sharedElements;
    private final Function1<SharedTransitionScope, Unit> updateTransitionActiveness;

    @Override // androidx.compose.ui.layout.LookaheadScope
    public LayoutCoordinates getLookaheadScopeCoordinates(Placeable.PlacementScope placementScope) {
        return this.$$delegate_0.getLookaheadScopeCoordinates(placementScope);
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    /* renamed from: localLookaheadPositionOf-au-aQtc, reason: not valid java name */
    public long mo432localLookaheadPositionOfauaQtc(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, long j, boolean z) {
        return this.$$delegate_0.mo432localLookaheadPositionOfauaQtc(layoutCoordinates, layoutCoordinates2, j, z);
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates layoutCoordinates) {
        return this.$$delegate_0.toLookaheadCoordinates(layoutCoordinates);
    }

    public SharedTransitionScopeImpl(LookaheadScope lookaheadScope, CoroutineScope coroutineScope) {
        MutableState mutableStateOf$default;
        this.coroutineScope = coroutineScope;
        this.$$delegate_0 = lookaheadScope;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isTransitionActive = mutableStateOf$default;
        this.observeAnimatingBlock = new Function0<Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$observeAnimatingBlock$1
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
                MutableScatterMap mutableScatterMap;
                mutableScatterMap = SharedTransitionScopeImpl.this.sharedElements;
                MutableScatterMap mutableScatterMap2 = mutableScatterMap;
                Object[] objArr = mutableScatterMap2.keys;
                Object[] objArr2 = mutableScatterMap2.values;
                long[] jArr = mutableScatterMap2.metadata;
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
                                int i4 = (i << 3) + i3;
                                Object obj = objArr[i4];
                                if (((SharedElement) objArr2[i4]).isAnimating()) {
                                    return;
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
            }
        };
        this.updateTransitionActiveness = new Function1<SharedTransitionScope, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$updateTransitionActiveness$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SharedTransitionScope sharedTransitionScope) {
                invoke2(sharedTransitionScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SharedTransitionScope sharedTransitionScope) {
                SharedTransitionScopeImpl.this.updateTransitionActiveness();
            }
        };
        this.renderers = SnapshotStateKt.mutableStateListOf();
        this.sharedElements = new MutableScatterMap<>(0, 1, null);
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    /* compiled from: SharedTransitionScope.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/compose/animation/SharedTransitionScopeImpl$Companion;", "", "()V", "SharedTransitionObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "getSharedTransitionObserver", "()Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SharedTransitionObserver$delegate", "Lkotlin/Lazy;", "animation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SnapshotStateObserver getSharedTransitionObserver() {
            return (SnapshotStateObserver) SharedTransitionScopeImpl.SharedTransitionObserver$delegate.getValue();
        }
    }

    /* renamed from: getDisposed$animation_release, reason: from getter */
    public final boolean getDisposed() {
        return this.disposed;
    }

    private void setTransitionActive(boolean z) {
        this.isTransitionActive.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.animation.SharedTransitionScope
    public boolean isTransitionActive() {
        return ((Boolean) this.isTransitionActive.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier skipToLookaheadSize(Modifier modifier) {
        return modifier.then(new SkipToLookaheadElement(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier renderInSharedTransitionScopeOverlay(Modifier modifier, Function0<Boolean> function0, float f, Function2<? super LayoutDirection, ? super Density, ? extends Path> function2) {
        return modifier.then(new RenderInTransitionOverlayNodeElement(this, function0, f, function2));
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier sharedElement(Modifier modifier, SharedTransitionScope.SharedContentState sharedContentState, AnimatedVisibilityScope animatedVisibilityScope, BoundsTransform boundsTransform, SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z, float f, SharedTransitionScope.OverlayClip overlayClip) {
        return sharedBoundsImpl(modifier, sharedContentState, animatedVisibilityScope.getTransition(), new Function1<EnterExitState, Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedElement$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(EnterExitState enterExitState) {
                return Boolean.valueOf(enterExitState == EnterExitState.Visible);
            }
        }, boundsTransform, placeHolderSize, true, z, f, overlayClip);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier sharedBounds(Modifier modifier, final SharedTransitionScope.SharedContentState sharedContentState, final AnimatedVisibilityScope animatedVisibilityScope, final EnterTransition enterTransition, final ExitTransition exitTransition, BoundsTransform boundsTransform, final SharedTransitionScope.ResizeMode resizeMode, SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z, float f, SharedTransitionScope.OverlayClip overlayClip) {
        return ComposedModifierKt.composed$default(sharedBoundsImpl(modifier, sharedContentState, animatedVisibilityScope.getTransition(), new Function1<EnterExitState, Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(EnterExitState enterExitState) {
                return Boolean.valueOf(enterExitState == EnterExitState.Visible);
            }
        }, boundsTransform, placeHolderSize, false, z, f, overlayClip), null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                Modifier.Companion companion;
                composer.startReplaceGroup(-419341573);
                ComposerKt.sourceInformation(composer, "C745@41603L35,737@41080L656:SharedTransitionScope.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-419341573, i, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBounds.<anonymous> (SharedTransitionScope.kt:736)");
                }
                Transition<EnterExitState> transition = AnimatedVisibilityScope.this.getTransition();
                EnterTransition enterTransition2 = enterTransition;
                ExitTransition exitTransition2 = exitTransition;
                ComposerKt.sourceInformationMarkerStart(composer, -1411467109, "CC(remember):SharedTransitionScope.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(sharedContentState);
                final SharedTransitionScope.SharedContentState sharedContentState2 = sharedContentState;
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$2$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return Boolean.valueOf(SharedTransitionScope.SharedContentState.this.isMatchFound());
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier createModifier = EnterExitTransitionKt.createModifier(transition, enterTransition2, exitTransition2, (Function0) rememberedValue, "enter/exit for " + sharedContentState.getKey(), composer, 0, 0);
                if (resizeMode instanceof ScaleToBoundsImpl) {
                    composer.startReplaceGroup(-805568624);
                    ComposerKt.sourceInformation(composer, "750@41903L530");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    ScaleToBoundsImpl scaleToBoundsImpl = (ScaleToBoundsImpl) resizeMode;
                    ComposerKt.sourceInformationMarkerStart(composer, -1411457014, "CC(remember):SharedTransitionScope.kt#9igjgp");
                    boolean changedInstance2 = composer.changedInstance(sharedContentState);
                    final SharedTransitionScope.SharedContentState sharedContentState3 = sharedContentState;
                    Object rememberedValue2 = composer.rememberedValue();
                    if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$2$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                return Boolean.valueOf(SharedTransitionScope.SharedContentState.this.isMatchFound());
                            }
                        };
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    companion = SkipToLookaheadNodeKt.createContentScaleModifier(companion2, scaleToBoundsImpl, (Function0) rememberedValue2);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-804951414);
                    composer.endReplaceGroup();
                    companion = Modifier.INSTANCE;
                }
                Modifier then = createModifier.then(companion);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return then;
            }
        }, 1, null);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier sharedElementWithCallerManagedVisibility(Modifier modifier, SharedTransitionScope.SharedContentState sharedContentState, final boolean z, BoundsTransform boundsTransform, SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z2, float f, SharedTransitionScope.OverlayClip overlayClip) {
        return sharedBoundsImpl(modifier, sharedContentState, null, new Function1<Unit, Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedElementWithCallerManagedVisibility$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Unit unit) {
                return Boolean.valueOf(z);
            }
        }, boundsTransform, placeHolderSize, true, z2, f, overlayClip);
    }

    public static /* synthetic */ Modifier sharedBoundsWithCallerManagedVisibility$animation_release$default(SharedTransitionScopeImpl sharedTransitionScopeImpl, Modifier modifier, SharedTransitionScope.SharedContentState sharedContentState, boolean z, BoundsTransform boundsTransform, SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z2, float f, SharedTransitionScope.OverlayClip overlayClip, int i, Object obj) {
        SharedTransitionScope.OverlayClip overlayClip2;
        SharedTransitionScope.OverlayClip overlayClip3;
        if ((i & 4) != 0) {
            boundsTransform = SharedTransitionScopeKt.DefaultBoundsTransform;
        }
        BoundsTransform boundsTransform2 = boundsTransform;
        if ((i & 8) != 0) {
            placeHolderSize = SharedTransitionScope.PlaceHolderSize.INSTANCE.getContentSize();
        }
        SharedTransitionScope.PlaceHolderSize placeHolderSize2 = placeHolderSize;
        boolean z3 = (i & 16) != 0 ? true : z2;
        float f2 = (i & 32) != 0 ? 0.0f : f;
        if ((i & 64) != 0) {
            overlayClip3 = SharedTransitionScopeKt.ParentClip;
            overlayClip2 = overlayClip3;
        } else {
            overlayClip2 = overlayClip;
        }
        return sharedTransitionScopeImpl.sharedBoundsWithCallerManagedVisibility$animation_release(modifier, sharedContentState, z, boundsTransform2, placeHolderSize2, z3, f2, overlayClip2);
    }

    public final Modifier sharedBoundsWithCallerManagedVisibility$animation_release(Modifier modifier, SharedTransitionScope.SharedContentState sharedContentState, final boolean z, BoundsTransform boundsTransform, SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z2, float f, SharedTransitionScope.OverlayClip overlayClip) {
        return sharedBoundsImpl(modifier, sharedContentState, null, new Function1<Unit, Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBoundsWithCallerManagedVisibility$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Unit unit) {
                return Boolean.valueOf(z);
            }
        }, boundsTransform, placeHolderSize, false, z2, f, overlayClip);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public SharedTransitionScope.OverlayClip OverlayClip(Shape clipShape) {
        return new ShapeBasedClip(clipShape);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public SharedTransitionScope.SharedContentState rememberSharedContentState(Object obj, Composer composer, int i) {
        composer.startReplaceGroup(799702514);
        ComposerKt.sourceInformation(composer, "C(rememberSharedContentState)874@49196L41:SharedTransitionScope.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(799702514, i, -1, "androidx.compose.animation.SharedTransitionScopeImpl.rememberSharedContentState (SharedTransitionScope.kt:874)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 935461266, "CC(remember):SharedTransitionScope.kt#9igjgp");
        boolean changed = composer.changed(obj);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new SharedTransitionScope.SharedContentState(obj);
            composer.updateRememberedValue(rememberedValue);
        }
        SharedTransitionScope.SharedContentState sharedContentState = (SharedTransitionScope.SharedContentState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return sharedContentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateTransitionActiveness() {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.SharedTransitionScopeImpl.updateTransitionActiveness():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Modifier sharedBoundsImpl(Modifier modifier, final SharedTransitionScope.SharedContentState sharedContentState, final Transition<T> transition, final Function1<? super T, Boolean> function1, final BoundsTransform boundsTransform, final SharedTransitionScope.PlaceHolderSize placeHolderSize, final boolean z, final boolean z2, final float f, final SharedTransitionScope.OverlayClip overlayClip) {
        return ComposedModifierKt.composed$default(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBoundsImpl$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                Transition rememberTransition;
                SharedElementInternalState rememberSharedElementState;
                composer.startReplaceGroup(-1843478929);
                ComposerKt.sourceInformation(composer, "C:SharedTransitionScope.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1843478929, i, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.<anonymous> (SharedTransitionScope.kt:915)");
                }
                Object key = SharedTransitionScope.SharedContentState.this.getKey();
                composer.startMovableGroup(-359689844, key);
                ComposerKt.sourceInformation(composer, "918@51074L35,965@53867L558");
                ComposerKt.sourceInformationMarkerStart(composer, -359691717, "CC(remember):SharedTransitionScope.kt#9igjgp");
                SharedTransitionScopeImpl sharedTransitionScopeImpl = this;
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = sharedTransitionScopeImpl.sharedElementsFor(key);
                    composer.updateRememberedValue(rememberedValue);
                }
                SharedElement sharedElement = (SharedElement) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.startMovableGroup(-359686031, transition);
                ComposerKt.sourceInformation(composer, "*955@53381L362");
                boolean z3 = false;
                if (transition != null) {
                    composer.startReplaceGroup(1734686048);
                    ComposerKt.sourceInformation(composer, "924@51349L121");
                    Transition<T> transition2 = transition;
                    String obj = key.toString();
                    Function1<T, Boolean> function12 = function1;
                    ComposerKt.sourceInformationMarkerStart(composer, 1215497572, "CC(createChildTransition)1761@74780L36,1762@74840L74,1763@74937L39,1764@74988L63:Transition.kt#pdpnli");
                    ComposerKt.sourceInformationMarkerStart(composer, 272047797, "CC(remember):Transition.kt#9igjgp");
                    boolean changed = composer.changed(transition2);
                    Object rememberedValue2 = composer.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = transition2.getCurrentState();
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    if (transition2.isSeeking()) {
                        rememberedValue2 = transition2.getCurrentState();
                    }
                    composer.startReplaceGroup(1329676753);
                    ComposerKt.sourceInformation(composer, "C:SharedTransitionScope.kt#xbi5r1");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1329676753, 0, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SharedTransitionScope.kt:925)");
                    }
                    Boolean invoke = function12.invoke(rememberedValue2);
                    invoke.booleanValue();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    Object targetState = transition2.getTargetState();
                    composer.startReplaceGroup(1329676753);
                    ComposerKt.sourceInformation(composer, "C:SharedTransitionScope.kt#xbi5r1");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1329676753, 0, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SharedTransitionScope.kt:925)");
                    }
                    Boolean invoke2 = function12.invoke(targetState);
                    invoke2.booleanValue();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    rememberTransition = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(transition2, invoke, invoke2, obj, composer, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(1734936683);
                    ComposerKt.sourceInformation(composer, "*931@51752L1208,949@53072L35");
                    Function function = function1;
                    Intrinsics.checkNotNull(function, "null cannot be cast to non-null type kotlin.Function1<kotlin.Unit, kotlin.Boolean>");
                    Boolean bool = (Boolean) ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function, 1)).invoke(Unit.INSTANCE);
                    boolean booleanValue = bool.booleanValue();
                    ComposerKt.sourceInformationMarkerStart(composer, -359668848, "CC(remember):SharedTransitionScope.kt#9igjgp");
                    Object rememberedValue3 = composer.rememberedValue();
                    if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        if (sharedElement.getCurrentBounds() == null) {
                            z3 = booleanValue;
                        } else if (!booleanValue) {
                            z3 = true;
                        }
                        rememberedValue3 = new MutableTransitionState(Boolean.valueOf(z3));
                        composer.updateRememberedValue(rememberedValue3);
                    }
                    MutableTransitionState mutableTransitionState = (MutableTransitionState) rememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    mutableTransitionState.setTargetState$animation_core_release(bool);
                    rememberTransition = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, null, composer, MutableTransitionState.$stable, 2);
                    composer.endReplaceGroup();
                }
                composer.startMovableGroup(-359623378, Boolean.valueOf(this.isTransitionActive()));
                ComposerKt.sourceInformation(composer, "953@53281L45");
                Transition<Boolean>.DeferredAnimation<Rect, AnimationVector4D> createDeferredAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(rememberTransition, VectorConvertersKt.getVectorConverter(Rect.INSTANCE), null, composer, 0, 2);
                composer.endMovableGroup();
                ComposerKt.sourceInformationMarkerStart(composer, -359617566, "CC(remember):SharedTransitionScope.kt#9igjgp");
                boolean changed2 = composer.changed(rememberTransition);
                SharedTransitionScopeImpl sharedTransitionScopeImpl2 = this;
                BoundsTransform boundsTransform2 = boundsTransform;
                Object rememberedValue4 = composer.rememberedValue();
                if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new BoundsAnimation(sharedTransitionScopeImpl2, rememberTransition, createDeferredAnimation, boundsTransform2);
                    composer.updateRememberedValue(rememberedValue4);
                }
                BoundsAnimation boundsAnimation = (BoundsAnimation) rememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer);
                boundsAnimation.updateAnimation(createDeferredAnimation, boundsTransform);
                composer.endMovableGroup();
                rememberSharedElementState = this.rememberSharedElementState(sharedElement, boundsAnimation, placeHolderSize, z, SharedTransitionScope.SharedContentState.this, overlayClip, f, z2, composer, 0);
                composer.endMovableGroup();
                Modifier then = modifier2.then(new SharedBoundsNodeElement(rememberSharedElementState));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return then;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedElementInternalState rememberSharedElementState(SharedElement sharedElement, BoundsAnimation boundsAnimation, SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z, SharedTransitionScope.SharedContentState sharedContentState, SharedTransitionScope.OverlayClip overlayClip, float f, boolean z2, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2066772852, "C(rememberSharedElementState)P(6!1,2,4,5!1,7)*991@54957L511:SharedTransitionScope.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2066772852, i, -1, "androidx.compose.animation.SharedTransitionScopeImpl.rememberSharedElementState (SharedTransitionScope.kt:991)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -663248987, "CC(remember):SharedTransitionScope.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new SharedElementInternalState(sharedElement, boundsAnimation, placeHolderSize, z, overlayClip, z2, sharedContentState, f);
            composer.updateRememberedValue(rememberedValue);
        }
        SharedElementInternalState sharedElementInternalState = (SharedElementInternalState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        sharedContentState.setInternalState$animation_release(sharedElementInternalState);
        sharedElementInternalState.setSharedElement(sharedElement);
        sharedElementInternalState.setRenderOnlyWhenVisible(z);
        sharedElementInternalState.setBoundsAnimation(boundsAnimation);
        sharedElementInternalState.setPlaceHolderSize(placeHolderSize);
        sharedElementInternalState.setOverlayClip(overlayClip);
        sharedElementInternalState.setZIndex(f);
        sharedElementInternalState.setRenderInOverlayDuringTransition(z2);
        sharedElementInternalState.setUserState(sharedContentState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sharedElementInternalState;
    }

    public final LayoutCoordinates getRoot$animation_release() {
        LayoutCoordinates layoutCoordinates = this.root;
        if (layoutCoordinates != null) {
            return layoutCoordinates;
        }
        Intrinsics.throwUninitializedPropertyAccessException("root");
        return null;
    }

    public final void setRoot$animation_release(LayoutCoordinates layoutCoordinates) {
        this.root = layoutCoordinates;
    }

    public final LayoutCoordinates getLookaheadRoot$animation_release() {
        LayoutCoordinates layoutCoordinates = this.nullableLookaheadRoot;
        if (layoutCoordinates != null) {
            return layoutCoordinates;
        }
        throw new IllegalArgumentException("Error: Uninitialized LayoutCoordinates. Please make sure when using the SharedTransitionScope composable function, the modifier passed to the child content is being used, or use SharedTransitionLayout instead.".toString());
    }

    /* renamed from: getNullableLookaheadRoot$animation_release, reason: from getter */
    public final LayoutCoordinates getNullableLookaheadRoot() {
        return this.nullableLookaheadRoot;
    }

    public final void setNullableLookaheadRoot$animation_release(LayoutCoordinates layoutCoordinates) {
        this.nullableLookaheadRoot = layoutCoordinates;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedElement sharedElementsFor(Object key) {
        SharedElement sharedElement = this.sharedElements.get(key);
        if (sharedElement != null) {
            return sharedElement;
        }
        SharedElement sharedElement2 = new SharedElement(key, this);
        this.sharedElements.set(key, sharedElement2);
        return sharedElement2;
    }

    public final void drawInOverlay$animation_release(ContentDrawScope scope) {
        SnapshotStateList<LayerRenderer> snapshotStateList = this.renderers;
        if (snapshotStateList.size() > 1) {
            CollectionsKt.sortWith(snapshotStateList, new Comparator() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$drawInOverlay$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    LayerRenderer layerRenderer = (LayerRenderer) t;
                    LayerRenderer layerRenderer2 = (LayerRenderer) t2;
                    return ComparisonsKt.compareValues(Float.valueOf((layerRenderer.getZIndex() == 0.0f && (layerRenderer instanceof SharedElementInternalState) && ((SharedElementInternalState) layerRenderer).getParentState() == null) ? -1.0f : layerRenderer.getZIndex()), Float.valueOf((layerRenderer2.getZIndex() == 0.0f && (layerRenderer2 instanceof SharedElementInternalState) && ((SharedElementInternalState) layerRenderer2).getParentState() == null) ? -1.0f : layerRenderer2.getZIndex()));
                }
            });
        }
        SnapshotStateList<LayerRenderer> snapshotStateList2 = this.renderers;
        int size = snapshotStateList2.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList2.get(i).drawInOverlay(scope);
        }
    }

    public final void onStateRemoved$animation_release(SharedElementInternalState sharedElementState) {
        SharedElement sharedElement = sharedElementState.getSharedElement();
        sharedElement.removeState(sharedElementState);
        this.updateTransitionActiveness.invoke(this);
        sharedElement.getScope().observeIsAnimating();
        this.renderers.remove(sharedElementState);
        if (sharedElement.getStates().isEmpty()) {
            BuildersKt__Builders_commonKt.launch$default(sharedElement.getScope().coroutineScope, null, null, new SharedTransitionScopeImpl$onStateRemoved$1$1(sharedElement, null), 3, null);
        }
    }

    public final void onStateAdded$animation_release(SharedElementInternalState sharedElementState) {
        SharedElement sharedElement = sharedElementState.getSharedElement();
        sharedElement.addState(sharedElementState);
        this.updateTransitionActiveness.invoke(this);
        sharedElement.getScope().observeIsAnimating();
        Iterator<LayerRenderer> it = this.renderers.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            LayerRenderer next = it.next();
            SharedElementInternalState sharedElementInternalState = next instanceof SharedElementInternalState ? (SharedElementInternalState) next : null;
            if (Intrinsics.areEqual(sharedElementInternalState != null ? sharedElementInternalState.getSharedElement() : null, sharedElementState.getSharedElement())) {
                break;
            } else {
                i++;
            }
        }
        if (i == this.renderers.size() - 1 || i == -1) {
            this.renderers.add(sharedElementState);
        } else {
            this.renderers.add(i + 1, sharedElementState);
        }
    }

    public final void onLayerRendererCreated$animation_release(LayerRenderer renderer) {
        this.renderers.add(renderer);
    }

    public final void onLayerRendererRemoved$animation_release(LayerRenderer renderer) {
        this.renderers.remove(renderer);
    }

    public final void onDispose$animation_release() {
        INSTANCE.getSharedTransitionObserver().clear(this);
        this.disposed = true;
    }

    public final SnapshotStateObserver getObserverForTest$animation_release() {
        return INSTANCE.getSharedTransitionObserver();
    }

    private final void observeIsAnimating() {
        if (this.disposed) {
            return;
        }
        INSTANCE.getSharedTransitionObserver().observeReads(this, this.updateTransitionActiveness, this.observeAnimatingBlock);
    }

    public final void observeReads$animation_release(SharedElement scope, Function1<? super SharedElement, Unit> onValueChangedForScope, Function0<Unit> block) {
        if (this.disposed) {
            return;
        }
        INSTANCE.getSharedTransitionObserver().observeReads(scope, onValueChangedForScope, block);
    }

    public final void clearObservation$animation_release(Object scope) {
        INSTANCE.getSharedTransitionObserver().clear(scope);
    }

    /* compiled from: SharedTransitionScope.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/SharedTransitionScopeImpl$ShapeBasedClip;", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "(Landroidx/compose/ui/graphics/Shape;)V", "getClipShape", "()Landroidx/compose/ui/graphics/Shape;", "path", "Landroidx/compose/ui/graphics/Path;", "getClipPath", "sharedContentState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "animation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    private static final class ShapeBasedClip implements SharedTransitionScope.OverlayClip {
        private final Shape clipShape;
        private final Path path = AndroidPath_androidKt.Path();

        public ShapeBasedClip(Shape shape) {
            this.clipShape = shape;
        }

        public final Shape getClipShape() {
            return this.clipShape;
        }

        @Override // androidx.compose.animation.SharedTransitionScope.OverlayClip
        public Path getClipPath(SharedTransitionScope.SharedContentState sharedContentState, Rect bounds, LayoutDirection layoutDirection, Density density) {
            this.path.reset();
            OutlineKt.addOutline(this.path, this.clipShape.mo614createOutlinePq9zytI(bounds.m4158getSizeNHjbRc(), layoutDirection, density));
            this.path.mo4261translatek4lQ0M(bounds.m4160getTopLeftF1C5BW0());
            return this.path;
        }
    }
}
