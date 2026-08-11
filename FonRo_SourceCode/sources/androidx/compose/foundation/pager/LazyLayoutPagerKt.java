package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.reflect.KProperty0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: LazyLayoutPager.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aè\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$21\u0010%\u001a-\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b)¢\u0006\u0002\b*H\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u0081\u0001\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010\u0004\u001a\u00020\u000521\u0010%\u001a-\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b)¢\u0006\u0002\b*2#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00120.H\u0003¢\u0006\u0002\u00101\u001a\u0014\u00102\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"Pager", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Pager-eLwUrMk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "rememberPagerItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "pageCount", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "dragDirectionDetector", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyLayoutPagerKt {
    /* JADX WARN: Removed duplicated region for block: B:125:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x022d  */
    /* renamed from: Pager-eLwUrMk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1289PagereLwUrMk(final androidx.compose.ui.Modifier r31, final androidx.compose.foundation.pager.PagerState r32, final androidx.compose.foundation.layout.PaddingValues r33, final boolean r34, final androidx.compose.foundation.gestures.Orientation r35, final androidx.compose.foundation.gestures.TargetedFlingBehavior r36, final boolean r37, final androidx.compose.foundation.OverscrollEffect r38, int r39, float r40, final androidx.compose.foundation.pager.PageSize r41, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r42, final kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r43, final androidx.compose.ui.Alignment.Horizontal r44, final androidx.compose.ui.Alignment.Vertical r45, final androidx.compose.foundation.gestures.snapping.SnapPosition r46, final kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, final int r49, final int r50, final int r51) {
        /*
            Method dump skipped, instructions count: 1283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.LazyLayoutPagerKt.m1289PagereLwUrMk(androidx.compose.ui.Modifier, androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.gestures.Orientation, androidx.compose.foundation.gestures.TargetedFlingBehavior, boolean, androidx.compose.foundation.OverscrollEffect, int, float, androidx.compose.foundation.pager.PageSize, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.snapping.SnapPosition, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final Function0<PagerLazyLayoutItemProvider> rememberPagerItemProviderLambda(final PagerState pagerState, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Function1<? super Integer, ? extends Object> function1, final Function0<Integer> function0, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1372505274, "C(rememberPagerItemProviderLambda)P(3,1)260@10823L33,261@10877L25,262@10914L741:LazyLayoutPager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1372505274, i, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:259)");
        }
        final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composer, (i >> 3) & 14);
        final State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function1, composer, (i >> 6) & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 1578874657, "CC(remember):LazyLayoutPager.kt#9igjgp");
        boolean changed = ((((i & 14) ^ 6) > 4 && composer.changed(pagerState)) || (i & 6) == 4) | composer.changed(rememberUpdatedState) | composer.changed(rememberUpdatedState2) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(function0)) || (i & 3072) == 2048);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            final State derivedStateOf = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0<PagerLayoutIntervalContent>() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$intervalContentState$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PagerLayoutIntervalContent invoke() {
                    return new PagerLayoutIntervalContent(rememberUpdatedState.getValue(), rememberUpdatedState2.getValue(), function0.invoke().intValue());
                }
            });
            final State derivedStateOf2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0<PagerLazyLayoutItemProvider>() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$itemProviderState$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PagerLazyLayoutItemProvider invoke() {
                    PagerLayoutIntervalContent value = derivedStateOf.getValue();
                    return new PagerLazyLayoutItemProvider(pagerState, value, new NearestRangeKeyIndexMap(pagerState.getNearestRange$foundation_release(), value));
                }
            });
            rememberedValue = (KProperty0) new PropertyReference0Impl(derivedStateOf2) { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$1
                @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return ((State) this.receiver).getValue();
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        KProperty0 kProperty0 = (KProperty0) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return kProperty0;
    }

    private static final Modifier dragDirectionDetector(Modifier modifier, final PagerState pagerState) {
        return modifier.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, pagerState, new PointerInputEventHandler() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1

            /* compiled from: LazyLayoutPager.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1", f = "LazyLayoutPager.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1, reason: invalid class name */
            /* loaded from: classes.dex */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PagerState $state;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PointerInputScope pointerInputScope, PagerState pagerState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$state = pagerState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$this_pointerInput, this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: LazyLayoutPager.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1", f = "LazyLayoutPager.kt", i = {0, 1, 1, 1}, l = {289, 293}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "downEvent", "upEventOrCancellation"}, s = {"L$0", "L$0", "L$1", "L$2"})
                /* renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1, reason: invalid class name and collision with other inner class name */
                /* loaded from: classes.dex */
                public static final class C00191 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ PagerState $state;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00191(PagerState pagerState, Continuation<? super C00191> continuation) {
                        super(2, continuation);
                        this.$state = pagerState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00191 c00191 = new C00191(this.$state, continuation);
                        c00191.L$0 = obj;
                        return c00191;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C00191) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:14:0x006c, code lost:
                    
                        if (r11 == r0) goto L17;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:15:0x006e, code lost:
                    
                        return r0;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
                    
                        if (r11 == r0) goto L17;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
                    /* JADX WARN: Removed duplicated region for block: B:17:0x009b  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x006c -> B:6:0x006f). Please report as a decompilation issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                        /*
                            r10 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r1 = r10.label
                            r2 = 2
                            r3 = 0
                            r4 = 1
                            if (r1 == 0) goto L30
                            if (r1 == r4) goto L28
                            if (r1 != r2) goto L1f
                            java.lang.Object r1 = r10.L$2
                            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
                            java.lang.Object r4 = r10.L$1
                            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                            java.lang.Object r5 = r10.L$0
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                            kotlin.ResultKt.throwOnFailure(r11)
                            goto L6f
                        L1f:
                            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                            r10.<init>(r11)
                            throw r10
                        L28:
                            java.lang.Object r1 = r10.L$0
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                            kotlin.ResultKt.throwOnFailure(r11)
                            goto L48
                        L30:
                            kotlin.ResultKt.throwOnFailure(r11)
                            java.lang.Object r11 = r10.L$0
                            r1 = r11
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                            androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                            r5 = r10
                            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                            r10.L$0 = r1
                            r10.label = r4
                            java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r1, r3, r11, r5)
                            if (r11 != r0) goto L48
                            goto L6e
                        L48:
                            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                            androidx.compose.foundation.pager.PagerState r4 = r10.$state
                            androidx.compose.ui.geometry.Offset$Companion r5 = androidx.compose.ui.geometry.Offset.INSTANCE
                            long r5 = r5.m4141getZeroF1C5BW0()
                            r4.m1308setUpDownDifferencek4lQ0M$foundation_release(r5)
                            r4 = 0
                            r5 = r1
                            r1 = r4
                            r4 = r11
                        L59:
                            if (r1 != 0) goto L9b
                            androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                            r6 = r10
                            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                            r10.L$0 = r5
                            r10.L$1 = r4
                            r10.L$2 = r1
                            r10.label = r2
                            java.lang.Object r11 = r5.awaitPointerEvent(r11, r6)
                            if (r11 != r0) goto L6f
                        L6e:
                            return r0
                        L6f:
                            androidx.compose.ui.input.pointer.PointerEvent r11 = (androidx.compose.ui.input.pointer.PointerEvent) r11
                            java.util.List r6 = r11.getChanges()
                            r7 = r6
                            java.util.Collection r7 = (java.util.Collection) r7
                            int r7 = r7.size()
                            r8 = r3
                        L7d:
                            if (r8 >= r7) goto L8f
                            java.lang.Object r9 = r6.get(r8)
                            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
                            boolean r9 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r9)
                            if (r9 != 0) goto L8c
                            goto L59
                        L8c:
                            int r8 = r8 + 1
                            goto L7d
                        L8f:
                            java.util.List r11 = r11.getChanges()
                            java.lang.Object r11 = r11.get(r3)
                            r1 = r11
                            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
                            goto L59
                        L9b:
                            androidx.compose.foundation.pager.PagerState r10 = r10.$state
                            long r0 = r1.getPosition()
                            long r2 = r4.getPosition()
                            long r0 = androidx.compose.ui.geometry.Offset.m4129minusMKHz9U(r0, r2)
                            r10.m1308setUpDownDifferencek4lQ0M$foundation_release(r0)
                            kotlin.Unit r10 = kotlin.Unit.INSTANCE
                            return r10
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1.AnonymousClass1.C00191.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$this_pointerInput, new C00191(this.$state, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object coroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(pointerInputScope, PagerState.this, null), continuation);
                return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
            }
        }));
    }
}
