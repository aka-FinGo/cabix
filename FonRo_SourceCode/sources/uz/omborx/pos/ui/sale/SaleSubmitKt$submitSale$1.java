package uz.FonRo.pos.ui.sale;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SaleSubmit.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.sale.SaleSubmitKt", f = "SaleSubmit.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {128}, m = "submitSale", n = {"app", "payType", "tid", "totals", "repo", "cart", "body", "stockDeltas", "received", "paid", "cash", "card", "change", "debt"}, nl = {130}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "D$0", "D$1", "D$2", "D$3", "D$4", "D$5"}, v = 2)
/* loaded from: classes7.dex */
public final class SaleSubmitKt$submitSale$1 extends ContinuationImpl {
    double D$0;
    double D$1;
    double D$2;
    double D$3;
    double D$4;
    double D$5;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleSubmitKt$submitSale$1(Continuation<? super SaleSubmitKt$submitSale$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SaleSubmitKt.submitSale(null, null, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, this);
    }
}
