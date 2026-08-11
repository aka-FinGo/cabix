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
@DebugMetadata(c = "uz.FonRo.pos.ui.auth.AuthScreenKt$AuthScreen$2$1$15$1$1", f = "AuthScreen.kt", i = {}, l = {297, 302}, m = "invokeSuspend", n = {}, nl = {298, 304}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class AuthScreenKt$AuthScreen$2$1$15$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ AuthRepository $auth;
    final /* synthetic */ MutableState<String> $error$delegate;
    final /* synthetic */ MutableState<String> $otpCode$delegate;
    final /* synthetic */ MutableState<String> $otpEmail$delegate;
    final /* synthetic */ MutableState<String> $otpMode$delegate;
    final /* synthetic */ MutableState<String> $otpVerifiedCode$delegate;
    final /* synthetic */ MutableState<String> $success$delegate;
    final /* synthetic */ MutableState<AuthView> $view$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthScreenKt$AuthScreen$2$1$15$1$1(AuthRepository authRepository, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<AuthView> mutableState5, MutableState<String> mutableState6, MutableState<String> mutableState7, Continuation<? super AuthScreenKt$AuthScreen$2$1$15$1$1> continuation) {
        super(1, continuation);
        this.$auth = authRepository;
        this.$otpCode$delegate = mutableState;
        this.$otpMode$delegate = mutableState2;
        this.$otpEmail$delegate = mutableState3;
        this.$otpVerifiedCode$delegate = mutableState4;
        this.$view$delegate = mutableState5;
        this.$error$delegate = mutableState6;
        this.$success$delegate = mutableState7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AuthScreenKt$AuthScreen$2$1$15$1$1(this.$auth, this.$otpCode$delegate, this.$otpMode$delegate, this.$otpEmail$delegate, this.$otpVerifiedCode$delegate, this.$view$delegate, this.$error$delegate, this.$success$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((AuthScreenKt$AuthScreen$2$1$15$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
    
        if (r1.resetVerify(r6, r2, r5) == r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0085, code lost:
    
        if (r1.verifyEmail(r6, r3, r5) == r0) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.throwOnFailure(r6)
            goto L88
        L13:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L1b:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L57
        L1f:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.runtime.MutableState<java.lang.String> r6 = r5.$otpCode$delegate
            java.lang.String r6 = uz.FonRo.pos.ui.auth.AuthScreenKt.access$AuthScreen$lambda$41(r6)
            int r6 = r6.length()
            r1 = 6
            if (r6 != r1) goto L8b
            androidx.compose.runtime.MutableState<java.lang.String> r6 = r5.$otpMode$delegate
            java.lang.String r6 = uz.FonRo.pos.ui.auth.AuthScreenKt.access$AuthScreen$lambda$44(r6)
            java.lang.String r1 = "reset"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r1)
            uz.FonRo.pos.data.repo.AuthRepository r1 = r5.$auth
            if (r6 == 0) goto L70
            androidx.compose.runtime.MutableState<java.lang.String> r6 = r5.$otpEmail$delegate
            java.lang.String r6 = uz.FonRo.pos.ui.auth.AuthScreenKt.access$AuthScreen$lambda$47(r6)
            androidx.compose.runtime.MutableState<java.lang.String> r2 = r5.$otpCode$delegate
            java.lang.String r2 = uz.FonRo.pos.ui.auth.AuthScreenKt.access$AuthScreen$lambda$41(r2)
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.label = r3
            java.lang.Object r6 = r1.resetVerify(r6, r2, r4)
            if (r6 != r0) goto L57
            goto L87
        L57:
            androidx.compose.runtime.MutableState<java.lang.String> r6 = r5.$otpVerifiedCode$delegate
            androidx.compose.runtime.MutableState<java.lang.String> r0 = r5.$otpCode$delegate
            java.lang.String r0 = uz.FonRo.pos.ui.auth.AuthScreenKt.access$AuthScreen$lambda$41(r0)
            uz.FonRo.pos.ui.auth.AuthScreenKt.access$AuthScreen$lambda$51(r6, r0)
            androidx.compose.runtime.MutableState<uz.FonRo.pos.ui.auth.AuthView> r6 = r5.$view$delegate
            androidx.compose.runtime.MutableState<java.lang.String> r0 = r5.$error$delegate
            androidx.compose.runtime.MutableState<java.lang.String> r5 = r5.$success$delegate
            uz.FonRo.pos.ui.auth.AuthView r1 = uz.FonRo.pos.ui.auth.AuthView.NEWPASS
            uz.FonRo.pos.ui.auth.AuthScreenKt.access$AuthScreen$goto(r6, r0, r5, r1)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            goto L88
        L70:
            androidx.compose.runtime.MutableState<java.lang.String> r6 = r5.$otpEmail$delegate
            java.lang.String r6 = uz.FonRo.pos.ui.auth.AuthScreenKt.access$AuthScreen$lambda$47(r6)
            androidx.compose.runtime.MutableState<java.lang.String> r3 = r5.$otpCode$delegate
            java.lang.String r3 = uz.FonRo.pos.ui.auth.AuthScreenKt.access$AuthScreen$lambda$41(r3)
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.label = r2
            java.lang.Object r5 = r1.verifyEmail(r6, r3, r4)
            if (r5 != r0) goto L88
        L87:
            return r0
        L88:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L8b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            r6 = 0
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r0 = "Введите 6-значный код из письма."
            java.lang.String r6 = uz.FonRo.pos.core.LangKt.tx(r0, r6)
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.auth.AuthScreenKt$AuthScreen$2$1$15$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
