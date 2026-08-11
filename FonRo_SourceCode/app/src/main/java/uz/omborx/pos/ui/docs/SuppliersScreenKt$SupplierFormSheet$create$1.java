package uz.FonRo.pos.ui.docs;

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
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SuppliersScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.docs.SuppliersScreenKt$SupplierFormSheet$create$1", f = "SuppliersScreen.kt", i = {0, 0, 1, 1, 1, 1, 1}, l = {428, 438}, m = "invokeSuspend", n = {"$this$launch", "body", "$this$launch", "body", "data", "rejected", "$this$invokeSuspend_u24lambda_u240"}, nl = {429, 438}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
/* loaded from: classes7.dex */
public final class SuppliersScreenKt$SupplierFormSheet$create$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ MutableState<String> $note$delegate;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ MutableState<String> $phone$delegate;
    final /* synthetic */ Repo $repo;
    final /* synthetic */ String $title;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuppliersScreenKt$SupplierFormSheet$create$1(String str, Function0<Unit> function0, MutableState<String> mutableState, MutableState<String> mutableState2, Repo repo, MutableState<Boolean> mutableState3, Continuation<? super SuppliersScreenKt$SupplierFormSheet$create$1> continuation) {
        super(2, continuation);
        this.$title = str;
        this.$onDismiss = function0;
        this.$phone$delegate = mutableState;
        this.$note$delegate = mutableState2;
        this.$repo = repo;
        this.$busy$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SuppliersScreenKt$SupplierFormSheet$create$1 suppliersScreenKt$SupplierFormSheet$create$1 = new SuppliersScreenKt$SupplierFormSheet$create$1(this.$title, this.$onDismiss, this.$phone$delegate, this.$note$delegate, this.$repo, this.$busy$delegate, continuation);
        suppliersScreenKt$SupplierFormSheet$create$1.L$0 = obj;
        return suppliersScreenKt$SupplierFormSheet$create$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuppliersScreenKt$SupplierFormSheet$create$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00e0, code lost:
    
        if (r7.loadDirectory(true, r14) == r1) goto L28;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.SuppliersScreenKt$SupplierFormSheet$create$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
