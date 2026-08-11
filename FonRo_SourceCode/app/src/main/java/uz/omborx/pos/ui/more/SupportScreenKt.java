package uz.FonRo.pos.ui.more;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.model.SupportMessage;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: SupportScreen.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a/\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007b\u0002\b\u000bb\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0002\u0010\n\u001a'\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0003b\u0002\b\u000bb\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006²\u0006\u0010\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014X\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\f\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\u0016X\u008a\u008e\u0002"}, d2 = {"BubbleShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "POLL_MS", "", "SupportScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "Bubble", "message", "Luz/FonRo/pos/data/model/SupportMessage;", "(Luz/FonRo/pos/data/model/SupportMessage;Landroidx/compose/runtime/Composer;I)V", "messages", "", "loaded", "", "error", "", "draft", "sending"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class SupportScreenKt {
    private static final RoundedCornerShape BubbleShape = RoundedCornerShapeKt.m1342RoundedCornerShape0680j_4(Dp.m6989constructorimpl(18.0f));
    private static final long POLL_MS = 15000;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Bubble$lambda$1(SupportMessage supportMessage, int i, Composer composer, int i2) {
        Bubble(supportMessage, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupportScreen$lambda$19(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        SupportScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x08f4  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0a7f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0a8b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0b52  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0a8f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x08ff  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x087d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x086d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0879  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SupportScreen(final uz.FonRo.pos.FonRoApp r114, final uz.FonRo.pos.ui.nav.AppNavigator r115, androidx.compose.runtime.Composer r116, final int r117) {
        /*
            Method dump skipped, instructions count: 2926
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.more.SupportScreenKt.SupportScreen(uz.FonRo.pos.FonRoApp, uz.FonRo.pos.ui.nav.AppNavigator, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<SupportMessage> SupportScreen$lambda$1(MutableState<List<SupportMessage>> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean SupportScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void SupportScreen$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String SupportScreen$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SupportScreen$lambda$10(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean SupportScreen$lambda$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SupportScreen$lambda$14(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SupportScreen$markSeen(Repo repo, List<SupportMessage> list) {
        Long l;
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            Long valueOf = Long.valueOf(((SupportMessage) it.next()).getId());
            while (it.hasNext()) {
                Long valueOf2 = Long.valueOf(((SupportMessage) it.next()).getId());
                if (valueOf.compareTo(valueOf2) < 0) {
                    valueOf = valueOf2;
                }
            }
            l = valueOf;
        } else {
            l = null;
        }
        Long l2 = l;
        if (l2 != null) {
            long longValue = l2.longValue();
            if (longValue > repo.getPrefs().getSupportSeen()) {
                repo.getPrefs().setSupportSeen(longValue);
            }
            repo.setSupportUnread(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|7|(1:(2:10|11)(2:17|18))(3:19|20|(1:22)(1:23))|12|13|14))|31|6|7|(0)(0)|12|13|14|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0083, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009b, code lost:
    
        throw r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object SupportScreen$reload(androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.SupportMessage>> r6, androidx.compose.runtime.MutableState<java.lang.String> r7, uz.FonRo.pos.data.repo.Repo r8, androidx.compose.runtime.MutableState<java.lang.Boolean> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            boolean r0 = r10 instanceof uz.FonRo.pos.ui.more.SupportScreenKt$SupportScreen$reload$1
            if (r0 == 0) goto L14
            r0 = r10
            uz.FonRo.pos.ui.more.SupportScreenKt$SupportScreen$reload$1 r0 = (uz.FonRo.pos.ui.more.SupportScreenKt$SupportScreen$reload$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            uz.FonRo.pos.ui.more.SupportScreenKt$SupportScreen$reload$1 r0 = new uz.FonRo.pos.ui.more.SupportScreenKt$SupportScreen$reload$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 != r4) goto L41
            java.lang.Object r6 = r0.L$4
            uz.FonRo.pos.data.net.ApiClient r6 = (uz.FonRo.pos.data.net.ApiClient) r6
            java.lang.Object r7 = r0.L$3
            r9 = r7
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            java.lang.Object r7 = r0.L$2
            r8 = r7
            uz.FonRo.pos.data.repo.Repo r8 = (uz.FonRo.pos.data.repo.Repo) r8
            java.lang.Object r7 = r0.L$1
            androidx.compose.runtime.MutableState r7 = (androidx.compose.runtime.MutableState) r7
            java.lang.Object r0 = r0.L$0
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L83
            goto L6b
        L41:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L49:
            kotlin.ResultKt.throwOnFailure(r10)
            uz.FonRo.pos.data.net.ApiClient r10 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L83
            uz.FonRo.pos.data.net.ApiClient r2 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L83
            uz.FonRo.pos.data.net.ApiService r2 = r2.api()     // Catch: java.lang.Throwable -> L83
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L83
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L83
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L83
            r0.L$3 = r9     // Catch: java.lang.Throwable -> L83
            r0.L$4 = r10     // Catch: java.lang.Throwable -> L83
            r0.label = r4     // Catch: java.lang.Throwable -> L83
            java.lang.Object r0 = r2.supportList(r3, r0)     // Catch: java.lang.Throwable -> L83
            if (r0 != r1) goto L67
            return r1
        L67:
            r5 = r0
            r0 = r6
            r6 = r10
            r10 = r5
        L6b:
            retrofit2.Response r10 = (retrofit2.Response) r10     // Catch: java.lang.Throwable -> L83
            r1 = 0
            r2 = 2
            java.lang.Object r6 = uz.FonRo.pos.data.net.ApiClient.unwrap$default(r6, r10, r1, r2, r3)     // Catch: java.lang.Throwable -> L83
            uz.FonRo.pos.data.model.SupportListResponse r6 = (uz.FonRo.pos.data.model.SupportListResponse) r6     // Catch: java.lang.Throwable -> L83
            java.util.List r6 = r6.getMessages()     // Catch: java.lang.Throwable -> L83
            SupportScreen$lambda$2(r0, r6)     // Catch: java.lang.Throwable -> L83
            SupportScreen$lambda$8(r7, r3)     // Catch: java.lang.Throwable -> L83
            SupportScreen$markSeen(r8, r6)     // Catch: java.lang.Throwable -> L83
            goto L91
        L83:
            r6 = move-exception
            uz.FonRo.pos.data.net.ApiClient r8 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L97
            uz.FonRo.pos.data.net.ApiException r6 = r8.asApiError(r6)     // Catch: java.lang.Throwable -> L97
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> L97
            SupportScreen$lambda$8(r7, r6)     // Catch: java.lang.Throwable -> L97
        L91:
            SupportScreen$lambda$5(r9, r4)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L97:
            r6 = move-exception
            SupportScreen$lambda$5(r9, r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.more.SupportScreenKt.SupportScreen$reload(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, uz.FonRo.pos.data.repo.Repo, androidx.compose.runtime.MutableState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final void SupportScreen$send(CoroutineScope coroutineScope, MutableState<String> mutableState, MutableState<Boolean> mutableState2, MutableState<List<SupportMessage>> mutableState3, MutableState<String> mutableState4, Repo repo, MutableState<Boolean> mutableState5) {
        String obj = StringsKt.trim((CharSequence) SupportScreen$lambda$10(mutableState)).toString();
        if (obj.length() == 0 || SupportScreen$lambda$13(mutableState2)) {
            return;
        }
        SupportScreen$lambda$14(mutableState2, true);
        mutableState.setValue("");
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SupportScreenKt$SupportScreen$send$1(obj, mutableState3, mutableState4, repo, mutableState5, mutableState, mutableState2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupportScreen$lambda$18$1$0$0(MutableState mutableState, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final List<SupportMessage> SupportScreen$lambda$1 = SupportScreen$lambda$1(mutableState);
        final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.more.SupportScreenKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object SupportScreen$lambda$18$1$0$0$0;
                SupportScreen$lambda$18$1$0$0$0 = SupportScreenKt.SupportScreen$lambda$18$1$0$0$0((SupportMessage) obj);
                return SupportScreen$lambda$18$1$0$0$0;
            }
        };
        final SupportScreenKt$SupportScreen$lambda$18$1$0$0$$inlined$items$default$1 supportScreenKt$SupportScreen$lambda$18$1$0$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.more.SupportScreenKt$SupportScreen$lambda$18$1$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(SupportMessage supportMessage) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((SupportMessage) obj);
            }
        };
        LazyColumn.items(SupportScreen$lambda$1.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.more.SupportScreenKt$SupportScreen$lambda$18$1$0$0$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(SupportScreen$lambda$1.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.more.SupportScreenKt$SupportScreen$lambda$18$1$0$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(SupportScreen$lambda$1.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.more.SupportScreenKt$SupportScreen$lambda$18$1$0$0$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "C178@8826L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                SupportMessage supportMessage = (SupportMessage) SupportScreen$lambda$1.get(i);
                composer.startReplaceGroup(-246316567);
                ComposerKt.sourceInformation(composer, "C*217@8469L15:SupportScreen.kt#1sifzz");
                SupportScreenKt.Bubble(supportMessage, composer, SupportMessage.$stable);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SupportScreen$lambda$18$1$0$0$0(SupportMessage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupportScreen$lambda$18$2$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(StringsKt.take(it, 4000));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupportScreen$lambda$18$2$1$0(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, Repo repo, MutableState mutableState5) {
        SupportScreen$send(coroutineScope, mutableState, mutableState2, mutableState3, mutableState4, repo, mutableState5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupportScreen$lambda$18$2$2$0(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, Repo repo, MutableState mutableState5) {
        SupportScreen$send(coroutineScope, mutableState, mutableState2, mutableState3, mutableState4, repo, mutableState5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bubble(final SupportMessage supportMessage, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        float f;
        Object obj;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1229135702);
        ComposerKt.sourceInformation(startRestartGroup, "C(Bubble)266@10237L1591:SupportScreen.kt#1sifzz");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? startRestartGroup.changed(supportMessage) : startRestartGroup.changedInstance(supportMessage) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1229135702, i2, -1, "uz.FonRo.pos.ui.more.Bubble (SupportScreen.kt:261)");
            }
            boolean equals = StringsKt.equals(supportMessage.getSender(), "admin", true);
            String timeOf = Fmt.INSTANCE.timeOf(supportMessage.getCreatedAt());
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), equals ? Dp.m6989constructorimpl(0.0f) : Dp.m6989constructorimpl(44.0f), 0.0f, equals ? Dp.m6989constructorimpl(44.0f) : Dp.m6989constructorimpl(0.0f), 0.0f, 10, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Horizontal start = equals ? arrangement.getStart() : arrangement.getEnd();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, Alignment.INSTANCE.getTop(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1053paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -567866329, "C272@10500L1322:SupportScreen.kt#1sifzz");
            Modifier.Companion companion = Modifier.INSTANCE;
            RoundedCornerShape roundedCornerShape = BubbleShape;
            Modifier clip = ClipKt.clip(companion, roundedCornerShape);
            Ox ox = Ox.INSTANCE;
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(clip, equals ? ox.m10218getPanel20d7_KjU() : ox.m10220getPrimary0d7_KjU(), null, 2, null);
            float m6989constructorimpl = Dp.m6989constructorimpl(1.0f);
            Ox ox2 = Ox.INSTANCE;
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(BorderKt.m569borderxT4_qwU(m558backgroundbw27NRU$default, m6989constructorimpl, equals ? ox2.m10189getBorder0d7_KjU() : ox2.m10220getPrimary0d7_KjU(), roundedCornerShape), Dp.m6989constructorimpl(13.0f), Dp.m6989constructorimpl(10.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m1050paddingVpY3zN4);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl2 = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl2, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1239960316, "C286@11057L255:SupportScreen.kt#1sifzz");
            if (equals) {
                startRestartGroup.startReplaceGroup(-1239969710);
                ComposerKt.sourceInformation(startRestartGroup, "280@10850L153,284@11020L10");
                composer2 = startRestartGroup;
                z = equals;
                obj = null;
                i3 = 1;
                f = 0.0f;
                TextKt.m2798Text4IGK_g(LangKt.tx("Поддержка FonRo", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getChip(), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), TextUnitKt.getSp(11.5d), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), composer2, 0, 0, 65534);
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(3.0f), composer2, 6);
                composer2.endReplaceGroup();
            } else {
                z = equals;
                i3 = 1;
                f = 0.0f;
                obj = null;
                startRestartGroup.startReplaceGroup(-1239765978);
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
            }
            String message = supportMessage.getMessage();
            TextStyle body = OxType.INSTANCE.getBody();
            Ox ox3 = Ox.INSTANCE;
            TextKt.m2798Text4IGK_g(message, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(body, z ? ox3.m10233getText0d7_KjU() : ox3.m10217getPanel0d7_KjU(), TextUnitKt.getSp(14), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(20), null, null, null, 0, 0, null, 16646140, null), composer2, 0, 0, 65534);
            startRestartGroup = composer2;
            if (timeOf.length() > 0) {
                startRestartGroup.startReplaceGroup(-1239433162);
                ComposerKt.sourceInformation(startRestartGroup, "295@11366L432");
                TextStyle caption = OxType.INSTANCE.getCaption();
                Ox ox4 = Ox.INSTANCE;
                TextKt.m2798Text4IGK_g(timeOf, PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f, i3, obj), 0.0f, Dp.m6989constructorimpl(4.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6866boximpl(TextAlign.INSTANCE.m6874getEnde0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(caption, z ? ox4.m10200getDim20d7_KjU() : Color.m4383copywmQWz5c$default(ox4.m10217getPanel0d7_KjU(), 0.75f, 0.0f, 0.0f, 0.0f, 14, null), TextUnitKt.getSp(10.5d), FontWeight.INSTANCE.getNormal(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), startRestartGroup, 48, 0, 65020);
                startRestartGroup = startRestartGroup;
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1239004122);
                startRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.more.SupportScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return SupportScreenKt.Bubble$lambda$1(SupportMessage.this, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }
}
