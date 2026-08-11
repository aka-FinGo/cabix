package uz.FonRo.pos.ui.clients;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.Customer;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClientsScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.clients.ClientsScreenKt$ClientFormSheet$save$1", f = "ClientsScreen.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 3}, l = {826, 834, 838, 842}, m = "invokeSuspend", n = {"$this$launch", "body", "$this$launch", "body", "created", "$this$invokeSuspend_u24lambda_u240", "$this$launch", "body", "$this$launch", "body", "$this$invokeSuspend_u24lambda_u241"}, nl = {827, 834, 841, 842}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 2)
/* loaded from: classes7.dex */
public final class ClientsScreenKt$ClientFormSheet$save$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $address$delegate;
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ Customer $customer;
    final /* synthetic */ String $fullName;
    final /* synthetic */ MutableState<String> $note$delegate;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ MutableState<String> $phone$delegate;
    final /* synthetic */ Repo $repo;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientsScreenKt$ClientFormSheet$save$1(String str, Customer customer, Repo repo, Function0<Unit> function0, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<Boolean> mutableState4, Continuation<? super ClientsScreenKt$ClientFormSheet$save$1> continuation) {
        super(2, continuation);
        this.$fullName = str;
        this.$customer = customer;
        this.$repo = repo;
        this.$onDismiss = function0;
        this.$phone$delegate = mutableState;
        this.$address$delegate = mutableState2;
        this.$note$delegate = mutableState3;
        this.$busy$delegate = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClientsScreenKt$ClientFormSheet$save$1 clientsScreenKt$ClientFormSheet$save$1 = new ClientsScreenKt$ClientFormSheet$save$1(this.$fullName, this.$customer, this.$repo, this.$onDismiss, this.$phone$delegate, this.$address$delegate, this.$note$delegate, this.$busy$delegate, continuation);
        clientsScreenKt$ClientFormSheet$save$1.L$0 = obj;
        return clientsScreenKt$ClientFormSheet$save$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClientsScreenKt$ClientFormSheet$save$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0176, code lost:
    
        if (r3.loadDirectory(true, r17) != r2) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d8 A[Catch: all -> 0x019b, TRY_ENTER, TryCatch #3 {all -> 0x019b, blocks: (B:11:0x0188, B:12:0x0195, B:65:0x017f, B:21:0x003c, B:23:0x0150, B:30:0x0116, B:31:0x0119, B:56:0x010c, B:34:0x0060, B:36:0x00c8, B:39:0x00d8, B:40:0x00dc, B:45:0x0069, B:47:0x00a4, B:51:0x0127, B:28:0x0050, B:29:0x0105, B:41:0x00e1, B:9:0x0024, B:10:0x0179, B:24:0x015c), top: B:2:0x0012, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dc A[Catch: all -> 0x019b, TRY_LEAVE, TryCatch #3 {all -> 0x019b, blocks: (B:11:0x0188, B:12:0x0195, B:65:0x017f, B:21:0x003c, B:23:0x0150, B:30:0x0116, B:31:0x0119, B:56:0x010c, B:34:0x0060, B:36:0x00c8, B:39:0x00d8, B:40:0x00dc, B:45:0x0069, B:47:0x00a4, B:51:0x0127, B:28:0x0050, B:29:0x0105, B:41:0x00e1, B:9:0x0024, B:10:0x0179, B:24:0x015c), top: B:2:0x0012, inners: #0, #2 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.clients.ClientsScreenKt$ClientFormSheet$save$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
