package uz.FonRo.pos.ui.catalog;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.internal.ViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.Category;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CategorySheets.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.catalog.CategorySheetsKt$CategoryFormSheet$save$1", f = "CategorySheets.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {766, ViewUtils.EDGE_TO_EDGE_FLAGS, 793}, m = "invokeSuspend", n = {"$this$launch", "api", "body", "$this$launch", "api", "body", "$this$launch", "api", "body", "response", "saved", "$this$invokeSuspend_u24lambda_u240"}, nl = {ViewUtils.EDGE_TO_EDGE_FLAGS, 765, 793}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
/* loaded from: classes7.dex */
public final class CategorySheetsKt$CategoryFormSheet$save$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Category $category;
    final /* synthetic */ MutableState<String> $color$delegate;
    final /* synthetic */ boolean $isNew;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ Function1<Category, Unit> $onSaved;
    final /* synthetic */ Repo $repo;
    final /* synthetic */ MutableState<Boolean> $saving$delegate;
    final /* synthetic */ String $title;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CategorySheetsKt$CategoryFormSheet$save$1(String str, Category category, Repo repo, Function1<? super Category, Unit> function1, boolean z, Function0<Unit> function0, MutableState<String> mutableState, MutableState<Boolean> mutableState2, Continuation<? super CategorySheetsKt$CategoryFormSheet$save$1> continuation) {
        super(2, continuation);
        this.$title = str;
        this.$category = category;
        this.$repo = repo;
        this.$onSaved = function1;
        this.$isNew = z;
        this.$onDismiss = function0;
        this.$color$delegate = mutableState;
        this.$saving$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CategorySheetsKt$CategoryFormSheet$save$1 categorySheetsKt$CategoryFormSheet$save$1 = new CategorySheetsKt$CategoryFormSheet$save$1(this.$title, this.$category, this.$repo, this.$onSaved, this.$isNew, this.$onDismiss, this.$color$delegate, this.$saving$delegate, continuation);
        categorySheetsKt$CategoryFormSheet$save$1.L$0 = obj;
        return categorySheetsKt$CategoryFormSheet$save$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CategorySheetsKt$CategoryFormSheet$save$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x013c, code lost:
    
        if (r9.loadCatalog(true, r17) == r2) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0187 A[Catch: all -> 0x01a6, TryCatch #1 {all -> 0x01a6, blocks: (B:10:0x014e, B:11:0x0160, B:13:0x0166, B:17:0x0178, B:19:0x017c, B:20:0x0181, B:22:0x0187, B:23:0x0198, B:28:0x0190, B:66:0x0145, B:35:0x0045, B:37:0x00bf, B:38:0x00c1, B:40:0x00cf, B:41:0x00e0, B:43:0x00e5, B:44:0x0109, B:49:0x0054, B:51:0x009d, B:53:0x005d, B:55:0x0071, B:56:0x0077, B:58:0x0082, B:61:0x00a0, B:8:0x002d, B:9:0x013f, B:45:0x0110), top: B:2:0x0011, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0190 A[Catch: all -> 0x01a6, TryCatch #1 {all -> 0x01a6, blocks: (B:10:0x014e, B:11:0x0160, B:13:0x0166, B:17:0x0178, B:19:0x017c, B:20:0x0181, B:22:0x0187, B:23:0x0198, B:28:0x0190, B:66:0x0145, B:35:0x0045, B:37:0x00bf, B:38:0x00c1, B:40:0x00cf, B:41:0x00e0, B:43:0x00e5, B:44:0x0109, B:49:0x0054, B:51:0x009d, B:53:0x005d, B:55:0x0071, B:56:0x0077, B:58:0x0082, B:61:0x00a0, B:8:0x002d, B:9:0x013f, B:45:0x0110), top: B:2:0x0011, inners: #0 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.catalog.CategorySheetsKt$CategoryFormSheet$save$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
