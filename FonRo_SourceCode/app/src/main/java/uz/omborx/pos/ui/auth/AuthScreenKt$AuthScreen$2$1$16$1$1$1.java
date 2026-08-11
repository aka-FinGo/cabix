package uz.FonRo.pos.ui.auth;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import uz.FonRo.pos.data.repo.AuthRepository;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AuthScreen.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.auth.AuthScreenKt$AuthScreen$2$1$16$1$1$1", f = "AuthScreen.kt", i = {}, l = {312, 313}, m = "invokeSuspend", n = {}, nl = {313, 314}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class AuthScreenKt$AuthScreen$2$1$16$1$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ AuthRepository $auth;
    final /* synthetic */ MutableState<String> $error$delegate;
    final /* synthetic */ MutableState<String> $otpEmail$delegate;
    final /* synthetic */ MutableState<String> $otpMode$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthScreenKt$AuthScreen$2$1$16$1$1$1(AuthRepository authRepository, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, Continuation<? super AuthScreenKt$AuthScreen$2$1$16$1$1$1> continuation) {
        super(1, continuation);
        this.$auth = authRepository;
        this.$otpMode$delegate = mutableState;
        this.$otpEmail$delegate = mutableState2;
        this.$error$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AuthScreenKt$AuthScreen$2$1$16$1$1$1(this.$auth, this.$otpMode$delegate, this.$otpEmail$delegate, this.$error$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((AuthScreenKt$AuthScreen$2$1$16$1$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
    
        if (r1.resetRequest(r5, r4) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004f, code lost:
    
        if (r1.resendCode(r5, r4) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L17:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L52
        L1b:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.compose.runtime.MutableState<java.lang.String> r5 = r4.$otpMode$delegate
            java.lang.String r5 = uz.FonRo.pos.ui.auth.AuthScreenKt.access$AuthScreen$lambda$44(r5)
            java.lang.String r1 = "reset"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r1)
            uz.FonRo.pos.data.repo.AuthRepository r1 = r4.$auth
            if (r5 == 0) goto L40
            androidx.compose.runtime.MutableState<java.lang.String> r5 = r4.$otpEmail$delegate
            java.lang.String r5 = uz.FonRo.pos.ui.auth.AuthScreenKt.access$AuthScreen$lambda$47(r5)
            r2 = r4
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r4.label = r3
            java.lang.Object r5 = r1.resetRequest(r5, r2)
            if (r5 != r0) goto L52
            goto L51
        L40:
            androidx.compose.runtime.MutableState<java.lang.String> r5 = r4.$otpEmail$delegate
            java.lang.String r5 = uz.FonRo.pos.ui.auth.AuthScreenKt.access$AuthScreen$lambda$47(r5)
            r3 = r4
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4.label = r2
            java.lang.Object r5 = r1.resendCode(r5, r3)
            if (r5 != r0) goto L52
        L51:
            return r0
        L52:
            androidx.compose.runtime.MutableState<java.lang.String> r4 = r4.$error$delegate
            java.lang.String r5 = ""
            uz.FonRo.pos.ui.auth.AuthScreenKt.access$AuthScreen$lambda$12(r4, r5)
            uz.FonRo.pos.ui.Toaster r4 = uz.FonRo.pos.ui.Toaster.INSTANCE
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r0 = "Код отправлен повторно. Проверьте почту и папку «Спам»."
            java.lang.String r5 = uz.FonRo.pos.core.LangKt.tx(r0, r5)
            r4.ok(r5)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.auth.AuthScreenKt$AuthScreen$2$1$16$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
