package uz.FonRo.pos.ui.auth;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.repo.AuthRepository;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AuthScreen.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.auth.AuthScreenKt$AuthScreen$2$1$22$1$1", f = "AuthScreen.kt", i = {}, l = {364}, m = "invokeSuspend", n = {}, nl = {365}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class AuthScreenKt$AuthScreen$2$1$22$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ AuthRepository $auth;
    final /* synthetic */ MutableState<String> $email$delegate;
    final /* synthetic */ MutableState<String> $error$delegate;
    final /* synthetic */ MutableState<String> $newPass1$delegate;
    final /* synthetic */ MutableState<String> $newPass2$delegate;
    final /* synthetic */ MutableState<String> $otpEmail$delegate;
    final /* synthetic */ MutableState<String> $otpVerifiedCode$delegate;
    final /* synthetic */ MutableState<String> $password$delegate;
    final /* synthetic */ MutableState<String> $success$delegate;
    final /* synthetic */ MutableState<AuthView> $view$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthScreenKt$AuthScreen$2$1$22$1$1(AuthRepository authRepository, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5, MutableState<String> mutableState6, MutableState<String> mutableState7, MutableState<AuthView> mutableState8, MutableState<String> mutableState9, Continuation<? super AuthScreenKt$AuthScreen$2$1$22$1$1> continuation) {
        super(1, continuation);
        this.$auth = authRepository;
        this.$newPass1$delegate = mutableState;
        this.$newPass2$delegate = mutableState2;
        this.$otpEmail$delegate = mutableState3;
        this.$otpVerifiedCode$delegate = mutableState4;
        this.$email$delegate = mutableState5;
        this.$password$delegate = mutableState6;
        this.$success$delegate = mutableState7;
        this.$view$delegate = mutableState8;
        this.$error$delegate = mutableState9;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AuthScreenKt$AuthScreen$2$1$22$1$1(this.$auth, this.$newPass1$delegate, this.$newPass2$delegate, this.$otpEmail$delegate, this.$otpVerifiedCode$delegate, this.$email$delegate, this.$password$delegate, this.$success$delegate, this.$view$delegate, this.$error$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((AuthScreenKt$AuthScreen$2$1$22$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String AuthScreen$lambda$56;
        String AuthScreen$lambda$562;
        String AuthScreen$lambda$59;
        String AuthScreen$lambda$47;
        String AuthScreen$lambda$50;
        String AuthScreen$lambda$563;
        String AuthScreen$lambda$472;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AuthScreen$lambda$56 = AuthScreenKt.AuthScreen$lambda$56(this.$newPass1$delegate);
            if (AuthScreen$lambda$56.length() >= 6) {
                AuthScreen$lambda$562 = AuthScreenKt.AuthScreen$lambda$56(this.$newPass1$delegate);
                AuthScreen$lambda$59 = AuthScreenKt.AuthScreen$lambda$59(this.$newPass2$delegate);
                if (!Intrinsics.areEqual(AuthScreen$lambda$562, AuthScreen$lambda$59)) {
                    throw new IllegalStateException(LangKt.tx("Пароли не совпадают.", new Object[0]));
                }
                AuthRepository authRepository = this.$auth;
                AuthScreen$lambda$47 = AuthScreenKt.AuthScreen$lambda$47(this.$otpEmail$delegate);
                AuthScreen$lambda$50 = AuthScreenKt.AuthScreen$lambda$50(this.$otpVerifiedCode$delegate);
                AuthScreen$lambda$563 = AuthScreenKt.AuthScreen$lambda$56(this.$newPass1$delegate);
                this.label = 1;
                if (authRepository.resetComplete(AuthScreen$lambda$47, AuthScreen$lambda$50, AuthScreen$lambda$563, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw new IllegalStateException(LangKt.tx("Пароль должен быть минимум 6 символов.", new Object[0]));
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        MutableState<String> mutableState = this.$email$delegate;
        AuthScreen$lambda$472 = AuthScreenKt.AuthScreen$lambda$47(this.$otpEmail$delegate);
        mutableState.setValue(AuthScreen$lambda$472);
        this.$password$delegate.setValue("");
        this.$success$delegate.setValue(LangKt.tx("Пароль обновлён. Войдите с новым паролем.", new Object[0]));
        AuthScreenKt.AuthScreen$goto(this.$view$delegate, this.$error$delegate, this.$success$delegate, AuthView.LOGIN);
        return Unit.INSTANCE;
    }
}
