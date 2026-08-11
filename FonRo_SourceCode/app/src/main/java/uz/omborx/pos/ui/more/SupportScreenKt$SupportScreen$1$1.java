package uz.FonRo.pos.ui.more;

import android.content.Context;
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
import uz.FonRo.pos.data.model.SupportMessage;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SupportScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.more.SupportScreenKt$SupportScreen$1$1", f = "SupportScreen.kt", i = {0, 1, 2, 2, 2}, l = {145, 149, 152}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "$this$LaunchedEffect", "$this$LaunchedEffect", "$this$invokeSuspend_u24lambda_u240", "after"}, nl = {148, 150, 153}, s = {"L$0", "L$0", "L$0", "L$3", "J$0"}, v = 2)
/* loaded from: classes7.dex */
public final class SupportScreenKt$SupportScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<String> $error$delegate;
    final /* synthetic */ MutableState<Boolean> $loaded$delegate;
    final /* synthetic */ MutableState<List<SupportMessage>> $messages$delegate;
    final /* synthetic */ Repo $repo;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SupportScreenKt$SupportScreen$1$1(Repo repo, Context context, MutableState<List<SupportMessage>> mutableState, MutableState<String> mutableState2, MutableState<Boolean> mutableState3, Continuation<? super SupportScreenKt$SupportScreen$1$1> continuation) {
        super(2, continuation);
        this.$repo = repo;
        this.$context = context;
        this.$messages$delegate = mutableState;
        this.$error$delegate = mutableState2;
        this.$loaded$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SupportScreenKt$SupportScreen$1$1 supportScreenKt$SupportScreen$1$1 = new SupportScreenKt$SupportScreen$1$1(this.$repo, this.$context, this.$messages$delegate, this.$error$delegate, this.$loaded$delegate, continuation);
        supportScreenKt$SupportScreen$1$1.L$0 = obj;
        return supportScreenKt$SupportScreen$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SupportScreenKt$SupportScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(15000, r14) == r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f5, code lost:
    
        if (r15 == r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f7, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0065, code lost:
    
        if (r15 == r1) goto L38;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00f5 -> B:9:0x00f8). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.more.SupportScreenKt$SupportScreen$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
