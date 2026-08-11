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
import kotlin.text.StringsKt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.repo.AuthRepository;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AuthScreen.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.auth.AuthScreenKt$AuthScreen$2$1$12$1$1", f = "AuthScreen.kt", i = {}, l = {262}, m = "invokeSuspend", n = {}, nl = {266}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class AuthScreenKt$AuthScreen$2$1$12$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ AuthRepository $auth;
    final /* synthetic */ MutableState<String> $error$delegate;
    final /* synthetic */ MutableState<String> $otpCode$delegate;
    final /* synthetic */ MutableState<String> $otpEmail$delegate;
    final /* synthetic */ MutableState<String> $otpMode$delegate;
    final /* synthetic */ MutableState<String> $regEmail$delegate;
    final /* synthetic */ MutableState<String> $regName$delegate;
    final /* synthetic */ MutableState<String> $regPassword$delegate;
    final /* synthetic */ MutableState<String> $regPhone$delegate;
    final /* synthetic */ MutableState<String> $regStore$delegate;
    final /* synthetic */ MutableState<String> $success$delegate;
    final /* synthetic */ MutableState<AuthView> $view$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthScreenKt$AuthScreen$2$1$12$1$1(AuthRepository authRepository, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5, MutableState<String> mutableState6, MutableState<String> mutableState7, MutableState<String> mutableState8, MutableState<AuthView> mutableState9, MutableState<String> mutableState10, MutableState<String> mutableState11, Continuation<? super AuthScreenKt$AuthScreen$2$1$12$1$1> continuation) {
        super(1, continuation);
        this.$auth = authRepository;
        this.$regName$delegate = mutableState;
        this.$regStore$delegate = mutableState2;
        this.$regEmail$delegate = mutableState3;
        this.$regPassword$delegate = mutableState4;
        this.$regPhone$delegate = mutableState5;
        this.$otpMode$delegate = mutableState6;
        this.$otpEmail$delegate = mutableState7;
        this.$otpCode$delegate = mutableState8;
        this.$view$delegate = mutableState9;
        this.$error$delegate = mutableState10;
        this.$success$delegate = mutableState11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AuthScreenKt$AuthScreen$2$1$12$1$1(this.$auth, this.$regName$delegate, this.$regStore$delegate, this.$regEmail$delegate, this.$regPassword$delegate, this.$regPhone$delegate, this.$otpMode$delegate, this.$otpEmail$delegate, this.$otpCode$delegate, this.$view$delegate, this.$error$delegate, this.$success$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((AuthScreenKt$AuthScreen$2$1$12$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String AuthScreen$lambda$26;
        String AuthScreen$lambda$29;
        String AuthScreen$lambda$35;
        String AuthScreen$lambda$38;
        String AuthScreen$lambda$382;
        String AuthScreen$lambda$262;
        String AuthScreen$lambda$292;
        String AuthScreen$lambda$32;
        String AuthScreen$lambda$352;
        String AuthScreen$lambda$383;
        String AuthScreen$lambda$353;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AuthScreen$lambda$26 = AuthScreenKt.AuthScreen$lambda$26(this.$regName$delegate);
            if (!StringsKt.isBlank(AuthScreen$lambda$26)) {
                AuthScreen$lambda$29 = AuthScreenKt.AuthScreen$lambda$29(this.$regStore$delegate);
                if (!StringsKt.isBlank(AuthScreen$lambda$29)) {
                    AuthScreen$lambda$35 = AuthScreenKt.AuthScreen$lambda$35(this.$regEmail$delegate);
                    if (!StringsKt.isBlank(AuthScreen$lambda$35)) {
                        AuthScreen$lambda$38 = AuthScreenKt.AuthScreen$lambda$38(this.$regPassword$delegate);
                        if (!StringsKt.isBlank(AuthScreen$lambda$38)) {
                            AuthScreen$lambda$382 = AuthScreenKt.AuthScreen$lambda$38(this.$regPassword$delegate);
                            if (AuthScreen$lambda$382.length() < 6) {
                                throw new IllegalStateException(LangKt.tx("Пароль должен быть минимум 6 символов.", new Object[0]));
                            }
                            AuthRepository authRepository = this.$auth;
                            AuthScreen$lambda$262 = AuthScreenKt.AuthScreen$lambda$26(this.$regName$delegate);
                            String obj2 = StringsKt.trim((CharSequence) AuthScreen$lambda$262).toString();
                            AuthScreen$lambda$292 = AuthScreenKt.AuthScreen$lambda$29(this.$regStore$delegate);
                            String obj3 = StringsKt.trim((CharSequence) AuthScreen$lambda$292).toString();
                            AuthScreen$lambda$32 = AuthScreenKt.AuthScreen$lambda$32(this.$regPhone$delegate);
                            String obj4 = StringsKt.trim((CharSequence) AuthScreen$lambda$32).toString();
                            AuthScreen$lambda$352 = AuthScreenKt.AuthScreen$lambda$35(this.$regEmail$delegate);
                            String obj5 = StringsKt.trim((CharSequence) AuthScreen$lambda$352).toString();
                            AuthScreen$lambda$383 = AuthScreenKt.AuthScreen$lambda$38(this.$regPassword$delegate);
                            this.label = 1;
                            if (authRepository.register(obj2, obj3, obj4, obj5, AuthScreen$lambda$383, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                }
            }
            throw new IllegalStateException(LangKt.tx("Заполните имя, название магазина, email и пароль.", new Object[0]));
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$otpMode$delegate.setValue("verify");
        MutableState<String> mutableState = this.$otpEmail$delegate;
        AuthScreen$lambda$353 = AuthScreenKt.AuthScreen$lambda$35(this.$regEmail$delegate);
        mutableState.setValue(StringsKt.trim((CharSequence) AuthScreen$lambda$353).toString());
        this.$otpCode$delegate.setValue("");
        AuthScreenKt.AuthScreen$goto(this.$view$delegate, this.$error$delegate, this.$success$delegate, AuthView.OTP);
        return Unit.INSTANCE;
    }
}
