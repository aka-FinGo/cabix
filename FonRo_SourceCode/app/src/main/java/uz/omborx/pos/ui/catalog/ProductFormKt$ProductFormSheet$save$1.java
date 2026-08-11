package uz.FonRo.pos.ui.catalog;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProductForm.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.catalog.ProductFormKt$ProductFormSheet$save$1", f = "ProductForm.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {199, 201, 222}, m = "invokeSuspend", n = {"$this$launch", "api", "current", "body", "$this$launch", "api", "current", "body", "$this$launch", "api", "fresh", "clientId"}, nl = {201, 198, 221}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 2)
/* loaded from: classes7.dex */
public final class ProductFormKt$ProductFormSheet$save$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<List<String>> $aliases$delegate;
    final /* synthetic */ MutableState<String> $barcode$delegate;
    final /* synthetic */ MutableState<Long> $categoryId$delegate;
    final /* synthetic */ MutableState<String> $errorText$delegate;
    final /* synthetic */ boolean $isNew;
    final /* synthetic */ boolean $measurable;
    final /* synthetic */ String $name;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ Function1<Product, Unit> $onSaved;
    final /* synthetic */ Product $product;
    final /* synthetic */ double $purchaseValue;
    final /* synthetic */ double $qtyValue;
    final /* synthetic */ Repo $repo;
    final /* synthetic */ double $saleValue;
    final /* synthetic */ MutableState<Boolean> $saving$delegate;
    final /* synthetic */ MutableState<String> $sku$delegate;
    final /* synthetic */ double $stepValue;
    final /* synthetic */ MutableState<String> $unit$delegate;
    final /* synthetic */ boolean $wantsStockIn;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ProductFormKt$ProductFormSheet$save$1(Product product, Repo repo, String str, double d, double d2, boolean z, boolean z2, double d3, boolean z3, double d4, Function1<? super Product, Unit> function1, Function0<Unit> function0, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<List<String>> mutableState3, MutableState<Long> mutableState4, MutableState<String> mutableState5, MutableState<String> mutableState6, MutableState<Boolean> mutableState7, Continuation<? super ProductFormKt$ProductFormSheet$save$1> continuation) {
        super(2, continuation);
        this.$product = product;
        this.$repo = repo;
        this.$name = str;
        this.$purchaseValue = d;
        this.$saleValue = d2;
        this.$isNew = z;
        this.$measurable = z2;
        this.$stepValue = d3;
        this.$wantsStockIn = z3;
        this.$qtyValue = d4;
        this.$onSaved = function1;
        this.$onDismiss = function0;
        this.$barcode$delegate = mutableState;
        this.$sku$delegate = mutableState2;
        this.$aliases$delegate = mutableState3;
        this.$categoryId$delegate = mutableState4;
        this.$unit$delegate = mutableState5;
        this.$errorText$delegate = mutableState6;
        this.$saving$delegate = mutableState7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProductFormKt$ProductFormSheet$save$1 productFormKt$ProductFormSheet$save$1 = new ProductFormKt$ProductFormSheet$save$1(this.$product, this.$repo, this.$name, this.$purchaseValue, this.$saleValue, this.$isNew, this.$measurable, this.$stepValue, this.$wantsStockIn, this.$qtyValue, this.$onSaved, this.$onDismiss, this.$barcode$delegate, this.$sku$delegate, this.$aliases$delegate, this.$categoryId$delegate, this.$unit$delegate, this.$errorText$delegate, this.$saving$delegate, continuation);
        productFormKt$ProductFormSheet$save$1.L$0 = obj;
        return productFormKt$ProductFormSheet$save$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProductFormKt$ProductFormSheet$save$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x025f A[Catch: all -> 0x0338, TryCatch #2 {all -> 0x0338, blocks: (B:12:0x024a, B:14:0x025f, B:15:0x0263, B:17:0x0268, B:20:0x026f, B:22:0x0279, B:26:0x029d, B:29:0x02a4, B:31:0x02a8, B:36:0x0293, B:37:0x02b2, B:39:0x02b6, B:40:0x02bf, B:41:0x02c2, B:43:0x02c3, B:45:0x02d8, B:46:0x02e5, B:48:0x02ed, B:49:0x02fa, B:57:0x02f6, B:58:0x02e1, B:25:0x0283), top: B:11:0x024a, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02b6 A[Catch: all -> 0x0338, TryCatch #2 {all -> 0x0338, blocks: (B:12:0x024a, B:14:0x025f, B:15:0x0263, B:17:0x0268, B:20:0x026f, B:22:0x0279, B:26:0x029d, B:29:0x02a4, B:31:0x02a8, B:36:0x0293, B:37:0x02b2, B:39:0x02b6, B:40:0x02bf, B:41:0x02c2, B:43:0x02c3, B:45:0x02d8, B:46:0x02e5, B:48:0x02ed, B:49:0x02fa, B:57:0x02f6, B:58:0x02e1, B:25:0x0283), top: B:11:0x024a, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02d8 A[Catch: all -> 0x0338, TryCatch #2 {all -> 0x0338, blocks: (B:12:0x024a, B:14:0x025f, B:15:0x0263, B:17:0x0268, B:20:0x026f, B:22:0x0279, B:26:0x029d, B:29:0x02a4, B:31:0x02a8, B:36:0x0293, B:37:0x02b2, B:39:0x02b6, B:40:0x02bf, B:41:0x02c2, B:43:0x02c3, B:45:0x02d8, B:46:0x02e5, B:48:0x02ed, B:49:0x02fa, B:57:0x02f6, B:58:0x02e1, B:25:0x0283), top: B:11:0x024a, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02ed A[Catch: all -> 0x0338, TryCatch #2 {all -> 0x0338, blocks: (B:12:0x024a, B:14:0x025f, B:15:0x0263, B:17:0x0268, B:20:0x026f, B:22:0x0279, B:26:0x029d, B:29:0x02a4, B:31:0x02a8, B:36:0x0293, B:37:0x02b2, B:39:0x02b6, B:40:0x02bf, B:41:0x02c2, B:43:0x02c3, B:45:0x02d8, B:46:0x02e5, B:48:0x02ed, B:49:0x02fa, B:57:0x02f6, B:58:0x02e1, B:25:0x0283), top: B:11:0x024a, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02f6 A[Catch: all -> 0x0338, TryCatch #2 {all -> 0x0338, blocks: (B:12:0x024a, B:14:0x025f, B:15:0x0263, B:17:0x0268, B:20:0x026f, B:22:0x0279, B:26:0x029d, B:29:0x02a4, B:31:0x02a8, B:36:0x0293, B:37:0x02b2, B:39:0x02b6, B:40:0x02bf, B:41:0x02c2, B:43:0x02c3, B:45:0x02d8, B:46:0x02e5, B:48:0x02ed, B:49:0x02fa, B:57:0x02f6, B:58:0x02e1, B:25:0x0283), top: B:11:0x024a, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02e1 A[Catch: all -> 0x0338, TryCatch #2 {all -> 0x0338, blocks: (B:12:0x024a, B:14:0x025f, B:15:0x0263, B:17:0x0268, B:20:0x026f, B:22:0x0279, B:26:0x029d, B:29:0x02a4, B:31:0x02a8, B:36:0x0293, B:37:0x02b2, B:39:0x02b6, B:40:0x02bf, B:41:0x02c2, B:43:0x02c3, B:45:0x02d8, B:46:0x02e5, B:48:0x02ed, B:49:0x02fa, B:57:0x02f6, B:58:0x02e1, B:25:0x0283), top: B:11:0x024a, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0262  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r61) {
        /*
            Method dump skipped, instructions count: 988
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.catalog.ProductFormKt$ProductFormSheet$save$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
