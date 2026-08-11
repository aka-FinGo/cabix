package uz.FonRo.pos.ui.sale;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.Customer;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CartSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.sale.CartSheetKt$CustomerPickerSheet$create$1", f = "CartSheet.kt", i = {0, 1, 1, 1}, l = {1208, 1222}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "created", "$this$invokeSuspend_u24lambda_u240"}, nl = {1207, 1222}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 2)
/* loaded from: classes7.dex */
public final class CartSheetKt$CustomerPickerSheet$create$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ MutableState<String> $name$delegate;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ Function1<Customer, Unit> $onPick;
    final /* synthetic */ MutableState<String> $phone$delegate;
    final /* synthetic */ Repo $repo;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CartSheetKt$CustomerPickerSheet$create$1(Repo repo, Function1<? super Customer, Unit> function1, Function0<Unit> function0, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<Boolean> mutableState3, Continuation<? super CartSheetKt$CustomerPickerSheet$create$1> continuation) {
        super(2, continuation);
        this.$repo = repo;
        this.$onPick = function1;
        this.$onDismiss = function0;
        this.$name$delegate = mutableState;
        this.$phone$delegate = mutableState2;
        this.$busy$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CartSheetKt$CustomerPickerSheet$create$1 cartSheetKt$CustomerPickerSheet$create$1 = new CartSheetKt$CustomerPickerSheet$create$1(this.$repo, this.$onPick, this.$onDismiss, this.$name$delegate, this.$phone$delegate, this.$busy$delegate, continuation);
        cartSheetKt$CustomerPickerSheet$create$1.L$0 = obj;
        return cartSheetKt$CustomerPickerSheet$create$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CartSheetKt$CustomerPickerSheet$create$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c4, code lost:
    
        if (r9.loadDirectory(true, r17) == r2) goto L27;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.sale.CartSheetKt$CustomerPickerSheet$create$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
