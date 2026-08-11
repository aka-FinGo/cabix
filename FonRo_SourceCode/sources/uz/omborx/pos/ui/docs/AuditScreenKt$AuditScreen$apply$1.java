package uz.FonRo.pos.ui.docs;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AuditScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.docs.AuditScreenKt$AuditScreen$apply$1", f = "AuditScreen.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {298, 308, 309}, m = "invokeSuspend", n = {"$this$launch", "body", "$this$launch", "body", "data", "rejected", "$this$invokeSuspend_u24lambda_u241", "$this$launch", "body", "data", "rejected", "$this$invokeSuspend_u24lambda_u242"}, nl = {299, 308, 309}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
/* loaded from: classes7.dex */
public final class AuditScreenKt$AuditScreen$apply$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SnapshotStateMap<Long, Double> $actual;
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ MutableState<Boolean> $countSheet$delegate;
    final /* synthetic */ List<Product> $counted;
    final /* synthetic */ MutableState<String> $filter$delegate;
    final /* synthetic */ MutableState<String> $note$delegate;
    final /* synthetic */ MutableState<List<Product>> $picked$delegate;
    final /* synthetic */ MutableState<String> $query$delegate;
    final /* synthetic */ Repo $repo;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuditScreenKt$AuditScreen$apply$1(List<Product> list, Repo repo, MutableState<String> mutableState, SnapshotStateMap<Long, Double> snapshotStateMap, MutableState<List<Product>> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<Boolean> mutableState5, MutableState<Boolean> mutableState6, Continuation<? super AuditScreenKt$AuditScreen$apply$1> continuation) {
        super(2, continuation);
        this.$counted = list;
        this.$repo = repo;
        this.$note$delegate = mutableState;
        this.$actual = snapshotStateMap;
        this.$picked$delegate = mutableState2;
        this.$query$delegate = mutableState3;
        this.$filter$delegate = mutableState4;
        this.$countSheet$delegate = mutableState5;
        this.$busy$delegate = mutableState6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AuditScreenKt$AuditScreen$apply$1 auditScreenKt$AuditScreen$apply$1 = new AuditScreenKt$AuditScreen$apply$1(this.$counted, this.$repo, this.$note$delegate, this.$actual, this.$picked$delegate, this.$query$delegate, this.$filter$delegate, this.$countSheet$delegate, this.$busy$delegate, continuation);
        auditScreenKt$AuditScreen$apply$1.L$0 = obj;
        return auditScreenKt$AuditScreen$apply$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuditScreenKt$AuditScreen$apply$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x019c, code lost:
    
        if (r0.loadDirectory(true, r21) != r3) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.AuditScreenKt$AuditScreen$apply$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
