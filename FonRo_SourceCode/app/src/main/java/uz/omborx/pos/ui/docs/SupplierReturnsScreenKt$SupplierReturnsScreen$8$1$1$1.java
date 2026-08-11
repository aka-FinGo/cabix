package uz.FonRo.pos.ui.docs;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.SupplierReturnDoc;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SupplierReturnsScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$SupplierReturnsScreen$8$1$1$1", f = "SupplierReturnsScreen.kt", i = {0, 1, 1, 2, 2}, l = {295, 304, 305}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$invokeSuspend_u24lambda_u240", "$this$launch", "$this$invokeSuspend_u24lambda_u241"}, nl = {302, 304, 305}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 2)
/* loaded from: classes7.dex */
public final class SupplierReturnsScreenKt$SupplierReturnsScreen$8$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ Repo $repo;
    final /* synthetic */ SupplierReturnDoc $target;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SupplierReturnsScreenKt$SupplierReturnsScreen$8$1$1$1(SupplierReturnDoc supplierReturnDoc, Repo repo, MutableState<Boolean> mutableState, Continuation<? super SupplierReturnsScreenKt$SupplierReturnsScreen$8$1$1$1> continuation) {
        super(2, continuation);
        this.$target = supplierReturnDoc;
        this.$repo = repo;
        this.$busy$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SupplierReturnsScreenKt$SupplierReturnsScreen$8$1$1$1 supplierReturnsScreenKt$SupplierReturnsScreen$8$1$1$1 = new SupplierReturnsScreenKt$SupplierReturnsScreen$8$1$1$1(this.$target, this.$repo, this.$busy$delegate, continuation);
        supplierReturnsScreenKt$SupplierReturnsScreen$8$1$1$1.L$0 = obj;
        return supplierReturnsScreenKt$SupplierReturnsScreen$8$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SupplierReturnsScreenKt$SupplierReturnsScreen$8$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d0, code lost:
    
        if (r0.loadDirectory(true, r21) != r3) goto L38;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$SupplierReturnsScreen$8$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
