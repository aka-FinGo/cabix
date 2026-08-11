package uz.FonRo.pos.ui.catalog;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.nav.AppNavigator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GlobalCatalogScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$GlobalCatalogScreen$runImport$1", f = "GlobalCatalogScreen.kt", i = {0, 1, 1, 1}, l = {169, 173}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "result", "$this$invokeSuspend_u24lambda_u240"}, nl = {168, 173}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 2)
/* loaded from: classes7.dex */
public final class GlobalCatalogScreenKt$GlobalCatalogScreen$runImport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $importing$delegate;
    final /* synthetic */ MutableState<String> $lang$delegate;
    final /* synthetic */ AppNavigator $nav;
    final /* synthetic */ Repo $repo;
    final /* synthetic */ MutableState<Set<Long>> $selected$delegate;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalCatalogScreenKt$GlobalCatalogScreen$runImport$1(AppNavigator appNavigator, MutableState<Set<Long>> mutableState, MutableState<String> mutableState2, Repo repo, MutableState<Boolean> mutableState3, Continuation<? super GlobalCatalogScreenKt$GlobalCatalogScreen$runImport$1> continuation) {
        super(2, continuation);
        this.$nav = appNavigator;
        this.$selected$delegate = mutableState;
        this.$lang$delegate = mutableState2;
        this.$repo = repo;
        this.$importing$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GlobalCatalogScreenKt$GlobalCatalogScreen$runImport$1 globalCatalogScreenKt$GlobalCatalogScreen$runImport$1 = new GlobalCatalogScreenKt$GlobalCatalogScreen$runImport$1(this.$nav, this.$selected$delegate, this.$lang$delegate, this.$repo, this.$importing$delegate, continuation);
        globalCatalogScreenKt$GlobalCatalogScreen$runImport$1.L$0 = obj;
        return globalCatalogScreenKt$GlobalCatalogScreen$runImport$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GlobalCatalogScreenKt$GlobalCatalogScreen$runImport$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|2|(1:(1:(9:6|7|8|9|10|(1:12)|13|14|15)(2:21|22))(2:23|24))(3:34|35|(2:37|29))|25|26|27|(7:30|9|10|(0)|13|14|15)|29|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0090, code lost:
    
        r0 = r11;
        r11 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00be A[Catch: all -> 0x00e0, TryCatch #0 {all -> 0x00e0, blocks: (B:10:0x009c, B:12:0x00be, B:13:0x00d3, B:20:0x0093, B:24:0x002e, B:25:0x0064, B:35:0x0035), top: B:2:0x000d }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$GlobalCatalogScreen$runImport$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
