package uz.FonRo.pos.ui.more;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.SupportMessage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SupportScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.more.SupportScreenKt$SupportScreen$2$1", f = "SupportScreen.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, nl = {165}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class SupportScreenKt$SupportScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ MutableState<List<SupportMessage>> $messages$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SupportScreenKt$SupportScreen$2$1(LazyListState lazyListState, MutableState<List<SupportMessage>> mutableState, Continuation<? super SupportScreenKt$SupportScreen$2$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$messages$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SupportScreenKt$SupportScreen$2$1(this.$listState, this.$messages$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SupportScreenKt$SupportScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List SupportScreen$lambda$1;
        List SupportScreen$lambda$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SupportScreen$lambda$1 = SupportScreenKt.SupportScreen$lambda$1(this.$messages$delegate);
            if (!SupportScreen$lambda$1.isEmpty()) {
                LazyListState lazyListState = this.$listState;
                SupportScreen$lambda$12 = SupportScreenKt.SupportScreen$lambda$1(this.$messages$delegate);
                this.label = 1;
                if (LazyListState.animateScrollToItem$default(lazyListState, CollectionsKt.getLastIndex(SupportScreen$lambda$12), 0, this, 2, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
