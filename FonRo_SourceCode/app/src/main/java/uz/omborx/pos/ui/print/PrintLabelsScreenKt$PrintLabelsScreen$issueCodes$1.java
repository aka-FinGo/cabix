package uz.FonRo.pos.ui.print;

import androidx.compose.runtime.MutableState;
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
/* compiled from: PrintLabelsScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.print.PrintLabelsScreenKt$PrintLabelsScreen$issueCodes$1", f = "PrintLabelsScreen.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {234}, m = "invokeSuspend", n = {"taken", "done", "failed", "$this$forEach$iv", "element$iv", "product", "code", "body"}, nl = {235}, s = {"L$0", "L$1", "L$2", "L$3", "L$6", "L$7", "L$8", "L$10"}, v = 2)
/* loaded from: classes7.dex */
public final class PrintLabelsScreenKt$PrintLabelsScreen$issueCodes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ List<Product> $live;
    final /* synthetic */ List<Product> $missing;
    final /* synthetic */ Repo $repo;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrintLabelsScreenKt$PrintLabelsScreen$issueCodes$1(List<Product> list, List<Product> list2, Repo repo, MutableState<Boolean> mutableState, Continuation<? super PrintLabelsScreenKt$PrintLabelsScreen$issueCodes$1> continuation) {
        super(2, continuation);
        this.$live = list;
        this.$missing = list2;
        this.$repo = repo;
        this.$busy$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PrintLabelsScreenKt$PrintLabelsScreen$issueCodes$1(this.$live, this.$missing, this.$repo, this.$busy$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PrintLabelsScreenKt$PrintLabelsScreen$issueCodes$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:4|5|6|7|8|9|10|11|12|(1:14)|15|16|17|18|(18:20|21|(1:23)|24|(1:26)(1:31)|27|(1:29)|8|9|10|11|12|(0)|15|16|17|18|(4:32|(1:34)(1:37)|35|36)(0))(0)) */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0170 A[Catch: all -> 0x01a5, TryCatch #1 {all -> 0x01a5, blocks: (B:12:0x0164, B:14:0x0170, B:15:0x0197), top: B:11:0x0164 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01b1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x015c -> B:8:0x003b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r45) {
        /*
            Method dump skipped, instructions count: 493
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$PrintLabelsScreen$issueCodes$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
