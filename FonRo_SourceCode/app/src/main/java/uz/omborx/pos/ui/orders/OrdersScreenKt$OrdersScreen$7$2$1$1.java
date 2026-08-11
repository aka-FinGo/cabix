package uz.FonRo.pos.ui.orders;

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
import uz.FonRo.pos.data.model.ShopReview;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OrdersScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$7$2$1$1", f = "OrdersScreen.kt", i = {}, l = {454, 460}, m = "invokeSuspend", n = {}, nl = {453, 461}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class OrdersScreenKt$OrdersScreen$7$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<ShopReview> $replyFor$delegate;
    final /* synthetic */ ShopReview $review;
    final /* synthetic */ MutableState<List<ShopReview>> $reviews$delegate;
    final /* synthetic */ MutableState<Boolean> $reviewsLoading$delegate;
    final /* synthetic */ String $text;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrdersScreenKt$OrdersScreen$7$2$1$1(ShopReview shopReview, String str, MutableState<ShopReview> mutableState, MutableState<Boolean> mutableState2, MutableState<List<ShopReview>> mutableState3, Continuation<? super OrdersScreenKt$OrdersScreen$7$2$1$1> continuation) {
        super(2, continuation);
        this.$review = shopReview;
        this.$text = str;
        this.$replyFor$delegate = mutableState;
        this.$reviewsLoading$delegate = mutableState2;
        this.$reviews$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OrdersScreenKt$OrdersScreen$7$2$1$1(this.$review, this.$text, this.$replyFor$delegate, this.$reviewsLoading$delegate, this.$reviews$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OrdersScreenKt$OrdersScreen$7$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0081, code lost:
    
        if (r9 == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L23
            if (r1 == r2) goto L1b
            if (r1 != r3) goto L13
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L84
            goto L8a
        L13:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L1b:
            java.lang.Object r1 = r9.L$0
            uz.FonRo.pos.data.net.ApiClient r1 = (uz.FonRo.pos.data.net.ApiClient) r1
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L84
            goto L59
        L23:
            kotlin.ResultKt.throwOnFailure(r10)
            uz.FonRo.pos.data.net.ApiClient r1 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L84
            uz.FonRo.pos.data.net.ApiClient r10 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L84
            uz.FonRo.pos.data.net.ApiService r10 = r10.api()     // Catch: java.lang.Throwable -> L84
            uz.FonRo.pos.data.model.ReviewReplyBody r4 = new uz.FonRo.pos.data.model.ReviewReplyBody     // Catch: java.lang.Throwable -> L84
            uz.FonRo.pos.data.model.ShopReview r5 = r9.$review     // Catch: java.lang.Throwable -> L84
            java.lang.String r5 = r5.getType()     // Catch: java.lang.Throwable -> L84
            uz.FonRo.pos.data.model.ShopReview r6 = r9.$review     // Catch: java.lang.Throwable -> L84
            long r6 = r6.getId()     // Catch: java.lang.Throwable -> L84
            java.lang.String r8 = r9.$text     // Catch: java.lang.Throwable -> L84
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch: java.lang.Throwable -> L84
            java.lang.CharSequence r8 = kotlin.text.StringsKt.trim(r8)     // Catch: java.lang.Throwable -> L84
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L84
            r4.<init>(r5, r6, r8)     // Catch: java.lang.Throwable -> L84
            r5 = r9
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Throwable -> L84
            r9.L$0 = r1     // Catch: java.lang.Throwable -> L84
            r9.label = r2     // Catch: java.lang.Throwable -> L84
            java.lang.Object r10 = r10.shopReviewReply(r4, r5)     // Catch: java.lang.Throwable -> L84
            if (r10 != r0) goto L59
            goto L83
        L59:
            retrofit2.Response r10 = (retrofit2.Response) r10     // Catch: java.lang.Throwable -> L84
            r2 = 0
            r4 = 0
            uz.FonRo.pos.data.net.ApiClient.unwrapVoid$default(r1, r10, r2, r3, r4)     // Catch: java.lang.Throwable -> L84
            uz.FonRo.pos.ui.Toaster r10 = uz.FonRo.pos.ui.Toaster.INSTANCE     // Catch: java.lang.Throwable -> L84
            java.lang.String r1 = "Ответ сохранён"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L84
            java.lang.String r1 = uz.FonRo.pos.core.LangKt.tx(r1, r2)     // Catch: java.lang.Throwable -> L84
            r10.ok(r1)     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.MutableState<uz.FonRo.pos.data.model.ShopReview> r10 = r9.$replyFor$delegate     // Catch: java.lang.Throwable -> L84
            uz.FonRo.pos.ui.orders.OrdersScreenKt.access$OrdersScreen$lambda$26(r10, r4)     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.MutableState<java.lang.Boolean> r10 = r9.$reviewsLoading$delegate     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.ShopReview>> r1 = r9.$reviews$delegate     // Catch: java.lang.Throwable -> L84
            r2 = r9
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch: java.lang.Throwable -> L84
            r9.L$0 = r4     // Catch: java.lang.Throwable -> L84
            r9.label = r3     // Catch: java.lang.Throwable -> L84
            java.lang.Object r9 = uz.FonRo.pos.ui.orders.OrdersScreenKt.access$OrdersScreen$loadReviews(r10, r1, r2)     // Catch: java.lang.Throwable -> L84
            if (r9 != r0) goto L8a
        L83:
            return r0
        L84:
            r9 = move-exception
            uz.FonRo.pos.ui.Toaster r10 = uz.FonRo.pos.ui.Toaster.INSTANCE
            r10.error(r9)
        L8a:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$7$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
