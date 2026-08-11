package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.LongPressTextDragObserverKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: SelectionContainer.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a*\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\t\u001aJ\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\f\u0010\n\u001a\u0004\u0018\u00010\u000bX\u008a\u008e\u0002"}, d2 = {"DisableSelection", "", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionContainer", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "onSelectionChange", "Lkotlin/Function1;", "children", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/Selection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SelectionContainerKt {
    public static final void SelectionContainer(final Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Composer startRestartGroup = composer.startRestartGroup(-1075498320);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionContainer)P(1)53@2355L45,57@2513L18,54@2405L160:SelectionContainer.kt#eksfi3");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1075498320, i3, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:52)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 882584971, "CC(remember):SelectionContainer.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i5 = i3;
            Selection SelectionContainer$lambda$1 = SelectionContainer$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 882590000, "CC(remember):SelectionContainer.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = (Function1) new Function1<Selection, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Selection selection) {
                        invoke2(selection);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Selection selection) {
                        mutableState.setValue(selection);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i6 = (i5 & 14) | 384 | ((i5 << 6) & 7168);
            Modifier modifier2 = modifier;
            function22 = function2;
            SelectionContainer(modifier2, SelectionContainer$lambda$1, (Function1) rememberedValue2, function22, startRestartGroup, i6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier = modifier2;
        } else {
            function22 = function2;
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    SelectionContainerKt.SelectionContainer(Modifier.this, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    private static final Selection SelectionContainer$lambda$1(MutableState<Selection> mutableState) {
        return mutableState.getValue();
    }

    public static final void DisableSelection(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(336063542);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisableSelection)70@2856L82:SelectionContainer.kt#eksfi3");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(336063542, i2, -1, "androidx.compose.foundation.text.selection.DisableSelection (SelectionContainer.kt:69)");
            }
            CompositionLocalKt.CompositionLocalProvider(SelectionRegistrarKt.getLocalSelectionRegistrar().provides(null), function2, startRestartGroup, ((i2 << 3) & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$DisableSelection$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    SelectionContainerKt.DisableSelection(function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void SelectionContainer(Modifier modifier, final Selection selection, final Function1<? super Selection, Unit> function1, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(2078139907);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionContainer)P(1,3,2)91@3548L83,93@3651L44,95@3732L7,96@3765L24,97@3839L7,99@3883L253,106@4180L7,117@4649L2468,117@4592L2525,173@7149L106,173@7123L132:SelectionContainer.kt#eksfi3");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(selection) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if (startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2078139907, i3, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:89)");
            }
            final SelectionRegistrarImpl selectionRegistrarImpl = (SelectionRegistrarImpl) RememberSaveableKt.m3923rememberSaveable(new Object[0], (Saver) SelectionRegistrarImpl.INSTANCE.getSaver(), (String) null, (Function0) new Function0<SelectionRegistrarImpl>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$registrarImpl$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final SelectionRegistrarImpl invoke() {
                    return new SelectionRegistrarImpl();
                }
            }, startRestartGroup, 3072, 4);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 882626442, "CC(remember):SelectionContainer.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SelectionManager(selectionRegistrarImpl);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final SelectionManager selectionManager = (SelectionManager) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ProvidableCompositionLocal<Clipboard> localClipboard = CompositionLocalsKt.getLocalClipboard();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localClipboard);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Clipboard clipboard = (Clipboard) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954203484, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(localHapticFeedback);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            selectionManager.setHapticFeedBack((HapticFeedback) consume2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 882634075, "CC(remember):SelectionContainer.kt#9igjgp");
            boolean changed = startRestartGroup.changed(coroutineScope) | startRestartGroup.changed(clipboard);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = (Function1) new Function1<AnnotatedString, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: SelectionContainer.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1$1", f = "SelectionContainer.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1$1, reason: invalid class name */
                    /* loaded from: classes.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Clipboard $clipboard;
                        final /* synthetic */ AnnotatedString $textToCopy;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(Clipboard clipboard, AnnotatedString annotatedString, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$clipboard = clipboard;
                            this.$textToCopy = annotatedString;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$clipboard, this.$textToCopy, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$clipboard.setClipEntry(ClipboardUtils_androidKt.toClipEntry(this.$textToCopy), this) == coroutine_suspended) {
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

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AnnotatedString annotatedString) {
                        invoke2(annotatedString);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(AnnotatedString annotatedString) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(clipboard, annotatedString, null), 1, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            selectionManager.setOnCopyHandler((Function1) rememberedValue3);
            ProvidableCompositionLocal<TextToolbar> localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(localTextToolbar);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            selectionManager.setTextToolbar((TextToolbar) consume3);
            selectionManager.setOnSelectionChange(function1);
            selectionManager.setSelection(selection);
            SimpleLayoutKt.SimpleLayout(companion.then(selectionManager.getModifier()), ComposableLambdaKt.rememberComposableLambda(-1869667463, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    ComposerKt.sourceInformation(composer2, "C118@4684L2427,118@4659L2452:SelectionContainer.kt#eksfi3");
                    if (!composer2.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1869667463, i5, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous> (SelectionContainer.kt:118)");
                    }
                    SelectionManager selectionManager2 = SelectionManager.this;
                    final SelectionRegistrarImpl selectionRegistrarImpl2 = selectionRegistrarImpl;
                    final Function2<Composer, Integer, Unit> function22 = function2;
                    final SelectionManager selectionManager3 = SelectionManager.this;
                    ContextMenu_androidKt.ContextMenuArea(selectionManager2, ComposableLambdaKt.rememberComposableLambda(577209674, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4.1
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

                        public final void invoke(Composer composer3, int i6) {
                            ComposerKt.sourceInformation(composer3, "C119@4771L2330,119@4698L2403:SelectionContainer.kt#eksfi3");
                            if (!composer3.shouldExecute((i6 & 3) != 2, i6 & 1)) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(577209674, i6, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous> (SelectionContainer.kt:119)");
                            }
                            ProvidedValue<SelectionRegistrar> provides = SelectionRegistrarKt.getLocalSelectionRegistrar().provides(SelectionRegistrarImpl.this);
                            final Function2<Composer, Integer, Unit> function23 = function22;
                            final SelectionManager selectionManager4 = selectionManager3;
                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(-272381430, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt.SelectionContainer.4.1.1
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

                                public final void invoke(Composer composer4, int i7) {
                                    Object obj;
                                    ResolvedTextDirection direction;
                                    float endHandleLineHeight;
                                    ComposerKt.sourceInformation(composer4, "C120@4789L10:SelectionContainer.kt#eksfi3");
                                    if (!composer4.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-272381430, i7, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous>.<anonymous> (SelectionContainer.kt:120)");
                                    }
                                    function23.invoke(composer4, 0);
                                    if (selectionManager4.isInTouchMode() && selectionManager4.getHasFocus() && !selectionManager4.isTriviallyCollapsedSelection$foundation_release()) {
                                        composer4.startReplaceGroup(-881553831);
                                        ComposerKt.sourceInformation(composer4, "");
                                        Selection selection2 = selectionManager4.getSelection();
                                        if (selection2 == null) {
                                            composer4.startReplaceGroup(-881514989);
                                        } else {
                                            composer4.startReplaceGroup(-881514988);
                                            ComposerKt.sourceInformation(composer4, "");
                                            final SelectionManager selectionManager5 = selectionManager4;
                                            composer4.startReplaceGroup(1495586214);
                                            ComposerKt.sourceInformation(composer4, "*129@5190L137,134@5426L385,162@6863L127,155@6425L596");
                                            List listOf = CollectionsKt.listOf((Object[]) new Boolean[]{true, false});
                                            int size = listOf.size();
                                            for (int i8 = 0; i8 < size; i8++) {
                                                boolean booleanValue = ((Boolean) listOf.get(i8)).booleanValue();
                                                ComposerKt.sourceInformationMarkerStart(composer4, -1635755966, "CC(remember):SelectionContainer.kt#9igjgp");
                                                boolean changed2 = composer4.changed(booleanValue);
                                                Object rememberedValue4 = composer4.rememberedValue();
                                                if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue4 = selectionManager5.handleDragObserver(booleanValue);
                                                    composer4.updateRememberedValue(rememberedValue4);
                                                }
                                                final TextDragObserver textDragObserver = (TextDragObserver) rememberedValue4;
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerStart(composer4, -1635748166, "CC(remember):SelectionContainer.kt#9igjgp");
                                                boolean changed3 = composer4.changed(booleanValue);
                                                Object rememberedValue5 = composer4.rememberedValue();
                                                if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                                    if (booleanValue) {
                                                        obj = (Function0) new Function0<Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4$1$1$1$1$positionProvider$1$1
                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public /* bridge */ /* synthetic */ Offset invoke() {
                                                                return Offset.m4114boximpl(m1764invokeF1C5BW0());
                                                            }

                                                            /* renamed from: invoke-F1C5BW0, reason: not valid java name */
                                                            public final long m1764invokeF1C5BW0() {
                                                                Offset m1799getStartHandlePosition_m7T9E = SelectionManager.this.m1799getStartHandlePosition_m7T9E();
                                                                return m1799getStartHandlePosition_m7T9E != null ? m1799getStartHandlePosition_m7T9E.m4135unboximpl() : Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
                                                            }
                                                        };
                                                    } else {
                                                        obj = (Function0) new Function0<Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4$1$1$1$1$positionProvider$1$2
                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public /* bridge */ /* synthetic */ Offset invoke() {
                                                                return Offset.m4114boximpl(m1765invokeF1C5BW0());
                                                            }

                                                            /* renamed from: invoke-F1C5BW0, reason: not valid java name */
                                                            public final long m1765invokeF1C5BW0() {
                                                                Offset m1798getEndHandlePosition_m7T9E = SelectionManager.this.m1798getEndHandlePosition_m7T9E();
                                                                return m1798getEndHandlePosition_m7T9E != null ? m1798getEndHandlePosition_m7T9E.m4135unboximpl() : Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
                                                            }
                                                        };
                                                    }
                                                    rememberedValue5 = obj;
                                                    composer4.updateRememberedValue(rememberedValue5);
                                                }
                                                Function0 function0 = (Function0) rememberedValue5;
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                if (booleanValue) {
                                                    direction = selection2.getStart().getDirection();
                                                } else {
                                                    direction = selection2.getEnd().getDirection();
                                                }
                                                if (booleanValue) {
                                                    endHandleLineHeight = selectionManager5.getStartHandleLineHeight();
                                                } else {
                                                    endHandleLineHeight = selectionManager5.getEndHandleLineHeight();
                                                }
                                                float f = endHandleLineHeight;
                                                SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 selectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 = new SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0(function0);
                                                boolean handlesCrossed = selection2.getHandlesCrossed();
                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer4, -1635702440, "CC(remember):SelectionContainer.kt#9igjgp");
                                                boolean changedInstance = composer4.changedInstance(textDragObserver);
                                                Object rememberedValue6 = composer4.rememberedValue();
                                                if (changedInstance || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue6 = (PointerInputEventHandler) new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4$1$1$1$1$1$1
                                                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                                            Object detectDownAndDragGesturesWithObserver = LongPressTextDragObserverKt.detectDownAndDragGesturesWithObserver(pointerInputScope, TextDragObserver.this, continuation);
                                                            return detectDownAndDragGesturesWithObserver == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectDownAndDragGesturesWithObserver : Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer4.updateRememberedValue(rememberedValue6);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                AndroidSelectionHandles_androidKt.m1752SelectionHandlewLIcFTc(selectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0, booleanValue, direction, handlesCrossed, 0L, f, SuspendingPointerInputFilterKt.pointerInput(companion2, textDragObserver, (PointerInputEventHandler) rememberedValue6), composer4, 0, 16);
                                            }
                                            composer4.endReplaceGroup();
                                        }
                                        composer4.endReplaceGroup();
                                        composer4.endReplaceGroup();
                                    } else {
                                        composer4.startReplaceGroup(-879541497);
                                        composer4.endReplaceGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer3, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 48, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 882738440, "CC(remember):SelectionContainer.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(selectionManager);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$5$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final SelectionManager selectionManager2 = SelectionManager.this;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$5$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                SelectionManager.this.onRelease();
                                SelectionManager.this.setHasFocus(false);
                            }
                        };
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.DisposableEffect(selectionManager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue4, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            companion = modifier2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$6
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    SelectionContainerKt.SelectionContainer(Modifier.this, selection, function1, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
