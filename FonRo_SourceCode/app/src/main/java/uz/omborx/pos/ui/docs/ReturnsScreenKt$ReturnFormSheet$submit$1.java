package uz.FonRo.pos.ui.docs;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.ReturnLineBody;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReturnsScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.docs.ReturnsScreenKt$ReturnFormSheet$submit$1", f = "ReturnsScreen.kt", i = {0, 1, 1, 2, 2}, l = {537, 558, 559}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$invokeSuspend_u24lambda_u241", "$this$launch", "$this$invokeSuspend_u24lambda_u242"}, nl = {536, 558, 559}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 2)
/* loaded from: classes7.dex */
public final class ReturnsScreenKt$ReturnFormSheet$submit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ List<ReturnLineBody> $lines;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ MutableState<String> $reason$delegate;
    final /* synthetic */ Repo $repo;
    final /* synthetic */ long $saleId;
    final /* synthetic */ String $transaction;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReturnsScreenKt$ReturnFormSheet$submit$1(long j, String str, List<ReturnLineBody> list, Repo repo, Function0<Unit> function0, MutableState<String> mutableState, MutableState<Boolean> mutableState2, Continuation<? super ReturnsScreenKt$ReturnFormSheet$submit$1> continuation) {
        super(2, continuation);
        this.$saleId = j;
        this.$transaction = str;
        this.$lines = list;
        this.$repo = repo;
        this.$onDismiss = function0;
        this.$reason$delegate = mutableState;
        this.$busy$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ReturnsScreenKt$ReturnFormSheet$submit$1 returnsScreenKt$ReturnFormSheet$submit$1 = new ReturnsScreenKt$ReturnFormSheet$submit$1(this.$saleId, this.$transaction, this.$lines, this.$repo, this.$onDismiss, this.$reason$delegate, this.$busy$delegate, continuation);
        returnsScreenKt$ReturnFormSheet$submit$1.L$0 = obj;
        return returnsScreenKt$ReturnFormSheet$submit$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReturnsScreenKt$ReturnFormSheet$submit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x010d, code lost:
    
        if (r0.loadDirectory(true, r18) != r3) goto L41;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.ReturnsScreenKt$ReturnFormSheet$submit$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
