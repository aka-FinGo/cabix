package uz.FonRo.pos.ui.more;

import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.SupportMessage;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SupportScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.more.SupportScreenKt$SupportScreen$send$1", f = "SupportScreen.kt", i = {}, l = {121, 125}, m = "invokeSuspend", n = {}, nl = {MenuKt.InTransitionDuration, 131}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class SupportScreenKt$SupportScreen$send$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $draft$delegate;
    final /* synthetic */ MutableState<String> $error$delegate;
    final /* synthetic */ MutableState<Boolean> $loaded$delegate;
    final /* synthetic */ MutableState<List<SupportMessage>> $messages$delegate;
    final /* synthetic */ Repo $repo;
    final /* synthetic */ MutableState<Boolean> $sending$delegate;
    final /* synthetic */ String $text;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SupportScreenKt$SupportScreen$send$1(String str, MutableState<List<SupportMessage>> mutableState, MutableState<String> mutableState2, Repo repo, MutableState<Boolean> mutableState3, MutableState<String> mutableState4, MutableState<Boolean> mutableState5, Continuation<? super SupportScreenKt$SupportScreen$send$1> continuation) {
        super(2, continuation);
        this.$text = str;
        this.$messages$delegate = mutableState;
        this.$error$delegate = mutableState2;
        this.$repo = repo;
        this.$loaded$delegate = mutableState3;
        this.$draft$delegate = mutableState4;
        this.$sending$delegate = mutableState5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SupportScreenKt$SupportScreen$send$1(this.$text, this.$messages$delegate, this.$error$delegate, this.$repo, this.$loaded$delegate, this.$draft$delegate, this.$sending$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SupportScreenKt$SupportScreen$send$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005e, code lost:
    
        if (r9 == r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            r4 = 0
            r5 = 0
            if (r1 == 0) goto L26
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L14
            goto L61
        L14:
            r9 = move-exception
            goto L67
        L16:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L1e:
            java.lang.Object r1 = r8.L$0
            uz.FonRo.pos.data.net.ApiClient r1 = (uz.FonRo.pos.data.net.ApiClient) r1
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L14
            goto L46
        L26:
            kotlin.ResultKt.throwOnFailure(r9)
            uz.FonRo.pos.data.net.ApiClient r1 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L14
            uz.FonRo.pos.data.net.ApiClient r9 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L14
            uz.FonRo.pos.data.net.ApiService r9 = r9.api()     // Catch: java.lang.Throwable -> L14
            uz.FonRo.pos.data.model.SupportSendBody r6 = new uz.FonRo.pos.data.model.SupportSendBody     // Catch: java.lang.Throwable -> L14
            java.lang.String r7 = r8.$text     // Catch: java.lang.Throwable -> L14
            r6.<init>(r4, r7, r3, r4)     // Catch: java.lang.Throwable -> L14
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch: java.lang.Throwable -> L14
            r8.L$0 = r1     // Catch: java.lang.Throwable -> L14
            r8.label = r3     // Catch: java.lang.Throwable -> L14
            java.lang.Object r9 = r9.supportSend(r6, r7)     // Catch: java.lang.Throwable -> L14
            if (r9 != r0) goto L46
            goto L60
        L46:
            retrofit2.Response r9 = (retrofit2.Response) r9     // Catch: java.lang.Throwable -> L14
            uz.FonRo.pos.data.net.ApiClient.unwrapVoid$default(r1, r9, r5, r2, r4)     // Catch: java.lang.Throwable -> L14
            androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.SupportMessage>> r9 = r8.$messages$delegate     // Catch: java.lang.Throwable -> L14
            androidx.compose.runtime.MutableState<java.lang.String> r1 = r8.$error$delegate     // Catch: java.lang.Throwable -> L14
            uz.FonRo.pos.data.repo.Repo r3 = r8.$repo     // Catch: java.lang.Throwable -> L14
            androidx.compose.runtime.MutableState<java.lang.Boolean> r6 = r8.$loaded$delegate     // Catch: java.lang.Throwable -> L14
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch: java.lang.Throwable -> L14
            r8.L$0 = r4     // Catch: java.lang.Throwable -> L14
            r8.label = r2     // Catch: java.lang.Throwable -> L14
            java.lang.Object r9 = uz.FonRo.pos.ui.more.SupportScreenKt.access$SupportScreen$reload(r9, r1, r3, r6, r7)     // Catch: java.lang.Throwable -> L14
            if (r9 != r0) goto L61
        L60:
            return r0
        L61:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r8 = r8.$sending$delegate
            uz.FonRo.pos.ui.more.SupportScreenKt.access$SupportScreen$lambda$14(r8, r5)
            goto L82
        L67:
            uz.FonRo.pos.ui.Toaster r0 = uz.FonRo.pos.ui.Toaster.INSTANCE     // Catch: java.lang.Throwable -> L85
            r0.error(r9)     // Catch: java.lang.Throwable -> L85
            androidx.compose.runtime.MutableState<java.lang.String> r9 = r8.$draft$delegate     // Catch: java.lang.Throwable -> L85
            java.lang.String r9 = uz.FonRo.pos.ui.more.SupportScreenKt.access$SupportScreen$lambda$10(r9)     // Catch: java.lang.Throwable -> L85
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch: java.lang.Throwable -> L85
            boolean r9 = kotlin.text.StringsKt.isBlank(r9)     // Catch: java.lang.Throwable -> L85
            if (r9 == 0) goto L61
            androidx.compose.runtime.MutableState<java.lang.String> r9 = r8.$draft$delegate     // Catch: java.lang.Throwable -> L85
            java.lang.String r0 = r8.$text     // Catch: java.lang.Throwable -> L85
            uz.FonRo.pos.ui.more.SupportScreenKt.access$SupportScreen$lambda$11(r9, r0)     // Catch: java.lang.Throwable -> L85
            goto L61
        L82:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L85:
            r9 = move-exception
            androidx.compose.runtime.MutableState<java.lang.Boolean> r8 = r8.$sending$delegate
            uz.FonRo.pos.ui.more.SupportScreenKt.access$SupportScreen$lambda$14(r8, r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.more.SupportScreenKt$SupportScreen$send$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
