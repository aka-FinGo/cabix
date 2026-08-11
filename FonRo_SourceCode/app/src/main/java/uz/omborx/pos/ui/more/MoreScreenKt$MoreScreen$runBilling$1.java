package uz.FonRo.pos.ui.more;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.JsonElement;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoreScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.more.MoreScreenKt$MoreScreen$runBilling$1", f = "MoreScreen.kt", i = {1}, l = {200, 201}, m = "invokeSuspend", n = {"fresh"}, nl = {201, 202}, s = {"L$0"}, v = 2)
/* loaded from: classes7.dex */
public final class MoreScreenKt$MoreScreen$runBilling$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super JsonElement>, Object> $action;
    final /* synthetic */ MutableState<Boolean> $billingBusy$delegate;
    final /* synthetic */ String $okText;
    final /* synthetic */ Repo $repo;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MoreScreenKt$MoreScreen$runBilling$1(Function1<? super Continuation<? super JsonElement>, ? extends Object> function1, Repo repo, String str, MutableState<Boolean> mutableState, Continuation<? super MoreScreenKt$MoreScreen$runBilling$1> continuation) {
        super(2, continuation);
        this.$action = function1;
        this.$repo = repo;
        this.$okText = str;
        this.$billingBusy$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MoreScreenKt$MoreScreen$runBilling$1(this.$action, this.$repo, this.$okText, this.$billingBusy$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MoreScreenKt$MoreScreen$runBilling$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
    
        if (r6 == r0) goto L25;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L25
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r0 = r5.L$0
            uz.FonRo.pos.data.model.Paywall r0 = (uz.FonRo.pos.data.model.Paywall) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L23
            goto L55
        L17:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L1f:
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L23
            goto L33
        L23:
            r6 = move-exception
            goto L5d
        L25:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlinx.serialization.json.JsonElement>, java.lang.Object> r6 = r5.$action     // Catch: java.lang.Throwable -> L23
            r5.label = r3     // Catch: java.lang.Throwable -> L23
            java.lang.Object r6 = r6.invoke(r5)     // Catch: java.lang.Throwable -> L23
            if (r6 != r0) goto L33
            goto L54
        L33:
            kotlinx.serialization.json.JsonElement r6 = (kotlinx.serialization.json.JsonElement) r6     // Catch: java.lang.Throwable -> L23
            uz.FonRo.pos.data.model.Paywall r6 = uz.FonRo.pos.ui.more.MoreScreenKt.access$paywallFrom(r6)     // Catch: java.lang.Throwable -> L23
            uz.FonRo.pos.data.repo.Repo r1 = r5.$repo
            if (r6 == 0) goto L43
            r1.updatePaywall(r6)     // Catch: java.lang.Throwable -> L23
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L23
            goto L55
        L43:
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3     // Catch: java.lang.Throwable -> L23
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)     // Catch: java.lang.Throwable -> L23
            r5.L$0 = r6     // Catch: java.lang.Throwable -> L23
            r5.label = r2     // Catch: java.lang.Throwable -> L23
            java.lang.Object r6 = uz.FonRo.pos.ui.more.MoreScreenKt.access$MoreScreen$pullEntitlement(r1, r3)     // Catch: java.lang.Throwable -> L23
            if (r6 != r0) goto L55
        L54:
            return r0
        L55:
            uz.FonRo.pos.ui.Toaster r6 = uz.FonRo.pos.ui.Toaster.INSTANCE     // Catch: java.lang.Throwable -> L23
            java.lang.String r0 = r5.$okText     // Catch: java.lang.Throwable -> L23
            r6.ok(r0)     // Catch: java.lang.Throwable -> L23
            goto L62
        L5d:
            uz.FonRo.pos.ui.Toaster r0 = uz.FonRo.pos.ui.Toaster.INSTANCE     // Catch: java.lang.Throwable -> L6a
            r0.error(r6)     // Catch: java.lang.Throwable -> L6a
        L62:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r5 = r5.$billingBusy$delegate
            uz.FonRo.pos.ui.more.MoreScreenKt.access$MoreScreen$lambda$51(r5, r4)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L6a:
            r6 = move-exception
            androidx.compose.runtime.MutableState<java.lang.Boolean> r5 = r5.$billingBusy$delegate
            uz.FonRo.pos.ui.more.MoreScreenKt.access$MoreScreen$lambda$51(r5, r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.more.MoreScreenKt$MoreScreen$runBilling$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
