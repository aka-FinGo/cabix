package uz.FonRo.pos.print;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.print.PrintAttributes;
import android.print.PrintManager;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.print.ReceiptPrinter;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.nav.Routes;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReceiptPrinter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.print.ReceiptPrinter$systemPrint$2", f = "ReceiptPrinter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class ReceiptPrinter$systemPrint$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function3<Integer, Canvas, Rect, Unit> $draw;
    final /* synthetic */ String $jobName;
    final /* synthetic */ int $pageCount;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ReceiptPrinter$systemPrint$2(Context context, String str, int i, Function3<? super Integer, ? super Canvas, ? super Rect, Unit> function3, Continuation<? super ReceiptPrinter$systemPrint$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$jobName = str;
        this.$pageCount = i;
        this.$draw = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ReceiptPrinter$systemPrint$2 receiptPrinter$systemPrint$2 = new ReceiptPrinter$systemPrint$2(this.$context, this.$jobName, this.$pageCount, this.$draw, continuation);
        receiptPrinter$systemPrint$2.L$0 = obj;
        return receiptPrinter$systemPrint$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReceiptPrinter$systemPrint$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Activity findActivity;
        Object m7870constructorimpl;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            findActivity = ReceiptPrinter.INSTANCE.findActivity(this.$context);
            if (findActivity == null) {
                Toaster.INSTANCE.error(LangKt.tx("Печать доступна только при открытом приложении", new Object[0]));
                return Unit.INSTANCE;
            }
            Object systemService = findActivity.getSystemService(Routes.PRINT);
            PrintManager printManager = systemService instanceof PrintManager ? (PrintManager) systemService : null;
            if (printManager == null) {
                Toaster.INSTANCE.error(LangKt.tx("На этом устройстве нет системной печати", new Object[0]));
                return Unit.INSTANCE;
            }
            PrintAttributes build = new PrintAttributes.Builder().setMediaSize(PrintAttributes.MediaSize.ISO_A4).setColorMode(1).setMinMargins(PrintAttributes.Margins.NO_MARGINS).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            String str = this.$jobName;
            int i = this.$pageCount;
            Function3<Integer, Canvas, Rect, Unit> function3 = this.$draw;
            try {
                Result.Companion companion = Result.INSTANCE;
                m7870constructorimpl = Result.m7870constructorimpl(printManager.print(str, new ReceiptPrinter.PagePrintAdapter(findActivity, str, i, function3), build));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7873exceptionOrNullimpl(m7870constructorimpl) != null) {
                Toaster.INSTANCE.error(LangKt.tx("Не удалось открыть системную печать", new Object[0]));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
