package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: LifecycleEffect.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a:\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001aD\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0013\u001aN\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001aH\u0010\t\u001a\u00020\u00012\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\u0017\"\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001a0\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001b\u001a6\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000e2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0003¢\u0006\u0002\u0010\u001e\u001a:\u0010\u001f\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001aD\u0010\u001f\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0013\u001aN\u0010\u001f\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001aH\u0010\u001f\u001a\u00020\u00012\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\u0017\"\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001a0\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001b\u001a6\u0010#\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020 2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\b\u0010H\u0003¢\u0006\u0002\u0010$\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u0006%²\u0006\u0010\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007X\u008a\u0084\u0002"}, d2 = {"LifecycleEventEffect", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onEvent", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle$Event;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "LifecycleStartEffect", "key1", "", "effects", "Lkotlin/Function1;", "Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;", "Landroidx/lifecycle/compose/LifecycleStopOrDisposeEffectResult;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "keys", "", "([Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LifecycleStartEffectNoParamError", "", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LifecycleStartEffectImpl", "scope", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LifecycleResumeEffect", "Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;", "Landroidx/lifecycle/compose/LifecyclePauseOrDisposeEffectResult;", "LifecycleResumeEffectNoParamError", "LifecycleResumeEffectImpl", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "lifecycle-runtime-compose_release", "currentOnEvent"}, k = 2, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class LifecycleEffectKt {
    private static final String LifecycleResumeEffectNoParamError = "LifecycleResumeEffect must provide one or more 'key' parameters that define the identity of the LifecycleResumeEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";
    private static final String LifecycleStartEffectNoParamError = "LifecycleStartEffect must provide one or more 'key' parameters that define the identity of the LifecycleStartEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";

    /* compiled from: LifecycleEffect.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LifecycleEventEffect$lambda$5(Lifecycle.Event event, LifecycleOwner lifecycleOwner, Function0 function0, int i, int i2, Composer composer, int i3) {
        LifecycleEventEffect(event, lifecycleOwner, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LifecycleResumeEffect$lambda$22(Object obj, LifecycleOwner lifecycleOwner, Function1 function1, int i, int i2, Composer composer, int i3) {
        LifecycleResumeEffect(obj, lifecycleOwner, (Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult>) function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LifecycleResumeEffect$lambda$24(Object obj, Object obj2, LifecycleOwner lifecycleOwner, Function1 function1, int i, int i2, Composer composer, int i3) {
        LifecycleResumeEffect(obj, obj2, lifecycleOwner, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LifecycleResumeEffect$lambda$26(Object obj, Object obj2, Object obj3, LifecycleOwner lifecycleOwner, Function1 function1, int i, int i2, Composer composer, int i3) {
        LifecycleResumeEffect(obj, obj2, obj3, lifecycleOwner, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LifecycleResumeEffect$lambda$28(Object[] objArr, LifecycleOwner lifecycleOwner, Function1 function1, int i, int i2, Composer composer, int i3) {
        LifecycleResumeEffect(objArr, lifecycleOwner, (Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult>) function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LifecycleResumeEffect$lambda$29(LifecycleOwner lifecycleOwner, Function1 function1, int i, int i2, Composer composer, int i3) {
        LifecycleResumeEffect(lifecycleOwner, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LifecycleResumeEffectImpl$lambda$35(LifecycleOwner lifecycleOwner, LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, Function1 function1, int i, Composer composer, int i2) {
        LifecycleResumeEffectImpl(lifecycleOwner, lifecycleResumePauseEffectScope, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LifecycleStartEffect$lambda$11(Object obj, Object obj2, Object obj3, LifecycleOwner lifecycleOwner, Function1 function1, int i, int i2, Composer composer, int i3) {
        LifecycleStartEffect(obj, obj2, obj3, lifecycleOwner, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LifecycleStartEffect$lambda$13(Object[] objArr, LifecycleOwner lifecycleOwner, Function1 function1, int i, int i2, Composer composer, int i3) {
        LifecycleStartEffect(objArr, lifecycleOwner, (Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult>) function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LifecycleStartEffect$lambda$14(LifecycleOwner lifecycleOwner, Function1 function1, int i, int i2, Composer composer, int i3) {
        LifecycleStartEffect(lifecycleOwner, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LifecycleStartEffect$lambda$7(Object obj, LifecycleOwner lifecycleOwner, Function1 function1, int i, int i2, Composer composer, int i3) {
        LifecycleStartEffect(obj, lifecycleOwner, (Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult>) function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LifecycleStartEffect$lambda$9(Object obj, Object obj2, LifecycleOwner lifecycleOwner, Function1 function1, int i, int i2, Composer composer, int i3) {
        LifecycleStartEffect(obj, obj2, lifecycleOwner, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LifecycleStartEffectImpl$lambda$20(LifecycleOwner lifecycleOwner, LifecycleStartStopEffectScope lifecycleStartStopEffectScope, Function1 function1, int i, Composer composer, int i2) {
        LifecycleStartEffectImpl(lifecycleOwner, lifecycleStartStopEffectScope, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0081, code lost:
    
        if ((r12 & 2) != 0) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleEventEffect(final androidx.lifecycle.Lifecycle.Event r7, final androidx.lifecycle.LifecycleOwner r8, final kotlin.jvm.functions.Function0<kotlin.Unit> r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleEventEffect(androidx.lifecycle.Lifecycle$Event, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final DisposableEffectResult LifecycleEventEffect$lambda$4$lambda$3(final LifecycleOwner lifecycleOwner, final Lifecycle.Event event, final State state, DisposableEffectScope disposableEffectScope) {
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event2) {
                LifecycleEffectKt.LifecycleEventEffect$lambda$4$lambda$3$lambda$1(Lifecycle.Event.this, state, lifecycleOwner2, event2);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleEventEffect$lambda$4$lambda$3$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                LifecycleOwner.this.getLifecycle().removeObserver(lifecycleEventObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void LifecycleEventEffect$lambda$4$lambda$3$lambda$1(Lifecycle.Event event, State state, LifecycleOwner lifecycleOwner, Lifecycle.Event event2) {
        if (event2 == event) {
            LifecycleEventEffect$lambda$0(state).invoke();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
    
        if ((r12 & 2) != 0) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleStartEffect(final java.lang.Object r7, androidx.lifecycle.LifecycleOwner r8, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect(java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0090, code lost:
    
        if ((r14 & 4) != 0) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleStartEffect(final java.lang.Object r8, final java.lang.Object r9, androidx.lifecycle.LifecycleOwner r10, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> r11, androidx.compose.runtime.Composer r12, final int r13, final int r14) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect(java.lang.Object, java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a7, code lost:
    
        if ((r15 & 8) != 0) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleStartEffect(final java.lang.Object r8, final java.lang.Object r9, final java.lang.Object r10, androidx.lifecycle.LifecycleOwner r11, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> r12, androidx.compose.runtime.Composer r13, final int r14, final int r15) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect(java.lang.Object, java.lang.Object, java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x009d, code lost:
    
        if ((r12 & 2) != 0) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleStartEffect(final java.lang.Object[] r7, androidx.lifecycle.LifecycleOwner r8, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect(java.lang.Object[], androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
    
        if ((r7 & 1) != 0) goto L22;
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffectNoParamError)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleStartEffect(final androidx.lifecycle.LifecycleOwner r3, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> r4, androidx.compose.runtime.Composer r5, final int r6, final int r7) {
        /*
            r0 = -50807951(0xfffffffffcf8bb71, float:-1.0331931E37)
            androidx.compose.runtime.Composer r5 = r5.startRestartGroup(r0)
            java.lang.String r1 = "C(LifecycleStartEffect)P(1):LifecycleEffect.kt#2vxrgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            r1 = r6 & 1
            if (r1 != 0) goto L29
            boolean r2 = r5.getSkipping()
            if (r2 != 0) goto L17
            goto L29
        L17:
            r5.skipToGroupEnd()
            androidx.compose.runtime.ScopeUpdateScope r5 = r5.endRestartGroup()
            if (r5 == 0) goto L28
            androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1 r0 = new androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1
            r0.<init>()
            r5.updateScope(r0)
        L28:
            return
        L29:
            r5.startDefaults()
            java.lang.String r3 = "331@16104L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r3)
            if (r1 == 0) goto L42
            boolean r3 = r5.getDefaultsInvalid()
            if (r3 == 0) goto L3a
            goto L42
        L3a:
            r5.skipToGroupEnd()
            r3 = r7 & 1
            if (r3 == 0) goto L5f
            goto L5d
        L42:
            r3 = r7 & 1
            if (r3 == 0) goto L5f
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r4, r7)
            java.lang.Object r3 = r5.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.lifecycle.LifecycleOwner r3 = (androidx.lifecycle.LifecycleOwner) r3
        L5d:
            r6 = r6 & (-15)
        L5f:
            r5.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L6e
            r3 = -1
            java.lang.String r4 = "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:333)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r3, r4)
        L6e:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "LifecycleStartEffect must provide one or more 'key' parameters that define the identity of the LifecycleStartEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key."
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect(androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void LifecycleStartEffectImpl(final LifecycleOwner lifecycleOwner, final LifecycleStartStopEffectScope lifecycleStartStopEffectScope, final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(228371534);
        ComposerKt.sourceInformation(startRestartGroup, "C(LifecycleStartEffectImpl)P(1,2)341@16508L661,341@16468L701:LifecycleEffect.kt#2vxrgp");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(lifecycleOwner) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(lifecycleStartStopEffectScope) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(228371534, i2, -1, "androidx.lifecycle.compose.LifecycleStartEffectImpl (LifecycleEffect.kt:340)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 421721059, "CC(remember):LifecycleEffect.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(lifecycleStartStopEffectScope) | ((i2 & 896) == 256) | startRestartGroup.changedInstance(lifecycleOwner);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LifecycleEffectKt.LifecycleStartEffectImpl$lambda$19$lambda$18(LifecycleOwner.this, lifecycleStartStopEffectScope, function1, (DisposableEffectScope) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.DisposableEffect(lifecycleOwner, lifecycleStartStopEffectScope, (Function1) rememberedValue, startRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LifecycleEffectKt.LifecycleStartEffectImpl$lambda$20(LifecycleOwner.this, lifecycleStartStopEffectScope, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final DisposableEffectResult LifecycleStartEffectImpl$lambda$19$lambda$18(final LifecycleOwner lifecycleOwner, final LifecycleStartStopEffectScope lifecycleStartStopEffectScope, final Function1 function1, DisposableEffectScope disposableEffectScope) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                LifecycleEffectKt.LifecycleStartEffectImpl$lambda$19$lambda$18$lambda$16(LifecycleStartStopEffectScope.this, objectRef, function1, lifecycleOwner2, event);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffectImpl$lambda$19$lambda$18$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                LifecycleOwner.this.getLifecycle().removeObserver(lifecycleEventObserver);
                LifecycleStopOrDisposeEffectResult lifecycleStopOrDisposeEffectResult = (LifecycleStopOrDisposeEffectResult) objectRef.element;
                if (lifecycleStopOrDisposeEffectResult != null) {
                    lifecycleStopOrDisposeEffectResult.runStopOrDisposeEffect();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    public static final void LifecycleStartEffectImpl$lambda$19$lambda$18$lambda$16(LifecycleStartStopEffectScope lifecycleStartStopEffectScope, Ref.ObjectRef objectRef, Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            objectRef.element = function1.invoke(lifecycleStartStopEffectScope);
        } else {
            if (i != 2) {
                return;
            }
            LifecycleStopOrDisposeEffectResult lifecycleStopOrDisposeEffectResult = (LifecycleStopOrDisposeEffectResult) objectRef.element;
            if (lifecycleStopOrDisposeEffectResult != null) {
                lifecycleStopOrDisposeEffectResult.runStopOrDisposeEffect();
            }
            objectRef.element = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
    
        if ((r12 & 2) != 0) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleResumeEffect(final java.lang.Object r7, androidx.lifecycle.LifecycleOwner r8, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect(java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0090, code lost:
    
        if ((r14 & 4) != 0) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleResumeEffect(final java.lang.Object r8, final java.lang.Object r9, androidx.lifecycle.LifecycleOwner r10, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> r11, androidx.compose.runtime.Composer r12, final int r13, final int r14) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect(java.lang.Object, java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a7, code lost:
    
        if ((r15 & 8) != 0) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleResumeEffect(final java.lang.Object r8, final java.lang.Object r9, final java.lang.Object r10, androidx.lifecycle.LifecycleOwner r11, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> r12, androidx.compose.runtime.Composer r13, final int r14, final int r15) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect(java.lang.Object, java.lang.Object, java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x009d, code lost:
    
        if ((r12 & 2) != 0) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleResumeEffect(final java.lang.Object[] r7, androidx.lifecycle.LifecycleOwner r8, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect(java.lang.Object[], androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
    
        if ((r7 & 1) != 0) goto L22;
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffectNoParamError)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleResumeEffect(final androidx.lifecycle.LifecycleOwner r3, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> r4, androidx.compose.runtime.Composer r5, final int r6, final int r7) {
        /*
            r0 = -747476210(0xffffffffd3726b0e, float:-1.04117817E12)
            androidx.compose.runtime.Composer r5 = r5.startRestartGroup(r0)
            java.lang.String r1 = "C(LifecycleResumeEffect)P(1):LifecycleEffect.kt#2vxrgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            r1 = r6 & 1
            if (r1 != 0) goto L29
            boolean r2 = r5.getSkipping()
            if (r2 != 0) goto L17
            goto L29
        L17:
            r5.skipToGroupEnd()
            androidx.compose.runtime.ScopeUpdateScope r5 = r5.endRestartGroup()
            if (r5 == 0) goto L28
            androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda14 r0 = new androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda14
            r0.<init>()
            r5.updateScope(r0)
        L28:
            return
        L29:
            r5.startDefaults()
            java.lang.String r3 = "654@31678L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r3)
            if (r1 == 0) goto L42
            boolean r3 = r5.getDefaultsInvalid()
            if (r3 == 0) goto L3a
            goto L42
        L3a:
            r5.skipToGroupEnd()
            r3 = r7 & 1
            if (r3 == 0) goto L5f
            goto L5d
        L42:
            r3 = r7 & 1
            if (r3 == 0) goto L5f
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r4, r7)
            java.lang.Object r3 = r5.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.lifecycle.LifecycleOwner r3 = (androidx.lifecycle.LifecycleOwner) r3
        L5d:
            r6 = r6 & (-15)
        L5f:
            r5.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L6e
            r3 = -1
            java.lang.String r4 = "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:656)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r3, r4)
        L6e:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "LifecycleResumeEffect must provide one or more 'key' parameters that define the identity of the LifecycleResumeEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key."
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect(androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void LifecycleResumeEffectImpl(final LifecycleOwner lifecycleOwner, final LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(912823238);
        ComposerKt.sourceInformation(startRestartGroup, "C(LifecycleResumeEffectImpl)P(1,2)664@32092L670,664@32052L710:LifecycleEffect.kt#2vxrgp");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(lifecycleOwner) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(lifecycleResumePauseEffectScope) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(912823238, i2, -1, "androidx.lifecycle.compose.LifecycleResumeEffectImpl (LifecycleEffect.kt:663)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1049812516, "CC(remember):LifecycleEffect.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(lifecycleResumePauseEffectScope) | ((i2 & 896) == 256) | startRestartGroup.changedInstance(lifecycleOwner);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LifecycleEffectKt.LifecycleResumeEffectImpl$lambda$34$lambda$33(LifecycleOwner.this, lifecycleResumePauseEffectScope, function1, (DisposableEffectScope) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.DisposableEffect(lifecycleOwner, lifecycleResumePauseEffectScope, (Function1) rememberedValue, startRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LifecycleEffectKt.LifecycleResumeEffectImpl$lambda$35(LifecycleOwner.this, lifecycleResumePauseEffectScope, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final DisposableEffectResult LifecycleResumeEffectImpl$lambda$34$lambda$33(final LifecycleOwner lifecycleOwner, final LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, final Function1 function1, DisposableEffectScope disposableEffectScope) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                LifecycleEffectKt.LifecycleResumeEffectImpl$lambda$34$lambda$33$lambda$31(LifecycleResumePauseEffectScope.this, objectRef, function1, lifecycleOwner2, event);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffectImpl$lambda$34$lambda$33$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                LifecycleOwner.this.getLifecycle().removeObserver(lifecycleEventObserver);
                LifecyclePauseOrDisposeEffectResult lifecyclePauseOrDisposeEffectResult = (LifecyclePauseOrDisposeEffectResult) objectRef.element;
                if (lifecyclePauseOrDisposeEffectResult != null) {
                    lifecyclePauseOrDisposeEffectResult.runPauseOrOnDisposeEffect();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    public static final void LifecycleResumeEffectImpl$lambda$34$lambda$33$lambda$31(LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, Ref.ObjectRef objectRef, Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 3) {
            objectRef.element = function1.invoke(lifecycleResumePauseEffectScope);
        } else {
            if (i != 4) {
                return;
            }
            LifecyclePauseOrDisposeEffectResult lifecyclePauseOrDisposeEffectResult = (LifecyclePauseOrDisposeEffectResult) objectRef.element;
            if (lifecyclePauseOrDisposeEffectResult != null) {
                lifecyclePauseOrDisposeEffectResult.runPauseOrOnDisposeEffect();
            }
            objectRef.element = null;
        }
    }

    private static final Function0<Unit> LifecycleEventEffect$lambda$0(State<? extends Function0<Unit>> state) {
        return state.getValue();
    }
}
