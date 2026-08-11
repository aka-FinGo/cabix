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
@DebugMetadata(c = "uz.FonRo.pos.ui.auth.AuthScreenKt$AuthScreen$2$1$5$1$1", f = "AuthScreen.kt", i = {0}, l = {204, 209}, m = "invokeSuspend", n = {"clean"}, nl = {206, 210}, s = {"L$0"}, v = 2)
/* loaded from: classes7.dex */
public final class AuthScreenKt$AuthScreen$2$1$5$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $accessKey$delegate;
    final /* synthetic */ AuthRepository $auth;
    final /* synthetic */ MutableState<String> $email$delegate;
    final /* synthetic */ MutableState<String> $error$delegate;
    final /* synthetic */ MutableState<LoginMode> $mode$delegate;
    final /* synthetic */ MutableState<String> $otpCode$delegate;
    final /* synthetic */ MutableState<String> $otpEmail$delegate;
    final /* synthetic */ MutableState<String> $otpMode$delegate;
    final /* synthetic */ MutableState<String> $password$delegate;
    final /* synthetic */ MutableState<String> $success$delegate;
    final /* synthetic */ MutableState<AuthView> $view$delegate;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthScreenKt$AuthScreen$2$1$5$1$1(AuthRepository authRepository, MutableState<LoginMode> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5, MutableState<String> mutableState6, MutableState<String> mutableState7, MutableState<AuthView> mutableState8, MutableState<String> mutableState9, MutableState<String> mutableState10, Continuation<? super AuthScreenKt$AuthScreen$2$1$5$1$1> continuation) {
        super(1, continuation);
        this.$auth = authRepository;
        this.$mode$delegate = mutableState;
        this.$accessKey$delegate = mutableState2;
        this.$email$delegate = mutableState3;
        this.$password$delegate = mutableState4;
        this.$otpMode$delegate = mutableState5;
        this.$otpEmail$delegate = mutableState6;
        this.$otpCode$delegate = mutableState7;
        this.$view$delegate = mutableState8;
        this.$error$delegate = mutableState9;
        this.$success$delegate = mutableState10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AuthScreenKt$AuthScreen$2$1$5$1$1(this.$auth, this.$mode$delegate, this.$accessKey$delegate, this.$email$delegate, this.$password$delegate, this.$otpMode$delegate, this.$otpEmail$delegate, this.$otpCode$delegate, this.$view$delegate, this.$error$delegate, this.$success$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((AuthScreenKt$AuthScreen$2$1$5$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x008c, code lost:
    
        if (r1.loginWithKey(kotlin.text.StringsKt.trim((java.lang.CharSequence) r2).toString(), r8) == r0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00da, code lost:
    
        if (r8 == r0) goto L34;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v14 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.auth.AuthScreenKt$AuthScreen$2$1$5$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
