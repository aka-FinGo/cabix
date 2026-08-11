package uz.FonRo.pos.ui.sale;

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
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.data.model.PayType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CartSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.sale.CartSheetKt$PaySheet$provide$1", f = "CartSheet.kt", i = {}, l = {548, 554, 560, 567}, m = "invokeSuspend", n = {}, nl = {554, 560, 567, 547}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class CartSheetKt$PaySheet$provide$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FonRoApp $app;
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ double $cardPart;
    final /* synthetic */ MutableState<Double> $cashPart$delegate;
    final /* synthetic */ MutableState<Boolean> $debtByCard$delegate;
    final /* synthetic */ MutableState<Double> $debtPaid$delegate;
    final /* synthetic */ Function1<SaleDone, Unit> $onDone;
    final /* synthetic */ MutableState<PayType> $payType$delegate;
    final /* synthetic */ MutableState<Double> $received$delegate;
    final /* synthetic */ String $tid;
    final /* synthetic */ double $total;
    final /* synthetic */ CartTotals $totals;
    int label;

    /* compiled from: CartSheet.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PayType.values().length];
            try {
                iArr[PayType.CASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PayType.CARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PayType.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PayType.DEBT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CartSheetKt$PaySheet$provide$1(FonRoApp FonRoApp, String str, CartTotals cartTotals, double d, double d2, Function1<? super SaleDone, Unit> function1, MutableState<PayType> mutableState, MutableState<Double> mutableState2, MutableState<Double> mutableState3, MutableState<Double> mutableState4, MutableState<Boolean> mutableState5, MutableState<Boolean> mutableState6, Continuation<? super CartSheetKt$PaySheet$provide$1> continuation) {
        super(2, continuation);
        this.$app = FonRoApp;
        this.$tid = str;
        this.$totals = cartTotals;
        this.$total = d;
        this.$cardPart = d2;
        this.$onDone = function1;
        this.$payType$delegate = mutableState;
        this.$received$delegate = mutableState2;
        this.$cashPart$delegate = mutableState3;
        this.$debtPaid$delegate = mutableState4;
        this.$debtByCard$delegate = mutableState5;
        this.$busy$delegate = mutableState6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CartSheetKt$PaySheet$provide$1(this.$app, this.$tid, this.$totals, this.$total, this.$cardPart, this.$onDone, this.$payType$delegate, this.$received$delegate, this.$cashPart$delegate, this.$debtPaid$delegate, this.$debtByCard$delegate, this.$busy$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CartSheetKt$PaySheet$provide$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x015d, code lost:
    
        if (r2 == r0) goto L50;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r30) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.sale.CartSheetKt$PaySheet$provide$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
