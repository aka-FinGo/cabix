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
@DebugMetadata(c = "uz.FonRo.pos.ui.auth.AuthScreenKt$AuthScreen$2$1$18$1$1", f = "AuthScreen.kt", i = {}, l = {334}, m = "invokeSuspend", n = {}, nl = {335}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class AuthScreenKt$AuthScreen$2$1$18$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ AuthRepository $auth;
    final /* synthetic */ MutableState<String> $error$delegate;
    final /* synthetic */ MutableState<String> $otpCode$delegate;
    final /* synthetic */ MutableState<String> $otpEmail$delegate;
    final /* synthetic */ MutableState<String> $otpMode$delegate;
    final /* synthetic */ MutableState<String> $resetEmail$delegate;
    final /* synthetic */ MutableState<String> $success$delegate;
    final /* synthetic */ MutableState<AuthView> $view$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthScreenKt$AuthScreen$2$1$18$1$1(AuthRepository authRepository, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<AuthView> mutableState5, MutableState<String> mutableState6, MutableState<String> mutableState7, Continuation<? super AuthScreenKt$AuthScreen$2$1$18$1$1> continuation) {
        super(1, continuation);
        this.$auth = authRepository;
        this.$resetEmail$delegate = mutableState;
        this.$otpMode$delegate = mutableState2;
        this.$otpEmail$delegate = mutableState3;
        this.$otpCode$delegate = mutableState4;
        this.$view$delegate = mutableState5;
        this.$error$delegate = mutableState6;
        this.$success$delegate = mutableState7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AuthScreenKt$AuthScreen$2$1$18$1$1(this.$auth, this.$resetEmail$delegate, this.$otpMode$delegate, this.$otpEmail$delegate, this.$otpCode$delegate, this.$view$delegate, this.$error$delegate, this.$success$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((AuthScreenKt$AuthScreen$2$1$18$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String AuthScreen$lambda$53;
        String AuthScreen$lambda$532;
        String AuthScreen$lambda$533;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AuthScreen$lambda$53 = AuthScreenKt.AuthScreen$lambda$53(this.$resetEmail$delegate);
            if (StringsKt.isBlank(AuthScreen$lambda$53)) {
                throw new IllegalStateException(LangKt.tx("Введите email.", new Object[0]));
            }
            AuthRepository authRepository = this.$auth;
            AuthScreen$lambda$532 = AuthScreenKt.AuthScreen$lambda$53(this.$resetEmail$delegate);
            this.label = 1;
            if (authRepository.resetRequest(StringsKt.trim((CharSequence) AuthScreen$lambda$532).toString(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$otpMode$delegate.setValue("reset");
        MutableState<String> mutableState = this.$otpEmail$delegate;
        AuthScreen$lambda$533 = AuthScreenKt.AuthScreen$lambda$53(this.$resetEmail$delegate);
        mutableState.setValue(StringsKt.trim((CharSequence) AuthScreen$lambda$533).toString());
        this.$otpCode$delegate.setValue("");
        AuthScreenKt.AuthScreen$goto(this.$view$delegate, this.$error$delegate, this.$success$delegate, AuthView.OTP);
        return Unit.INSTANCE;
    }
}
