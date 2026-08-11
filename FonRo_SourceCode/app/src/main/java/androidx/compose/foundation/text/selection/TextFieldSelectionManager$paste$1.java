package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldSelectionManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager$paste$1", f = "TextFieldSelectionManager.kt", i = {}, l = {647}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class TextFieldSelectionManager$paste$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TextFieldSelectionManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionManager$paste$1(TextFieldSelectionManager textFieldSelectionManager, Continuation<? super TextFieldSelectionManager$paste$1> continuation) {
        super(2, continuation);
        this.this$0 = textFieldSelectionManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TextFieldSelectionManager$paste$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TextFieldSelectionManager$paste$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AnnotatedString readAnnotatedString;
        TextFieldValue m1821createTextFieldValueFDrldGo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Clipboard clipboard = this.this$0.getClipboard();
            if (clipboard != null) {
                this.label = 1;
                obj = clipboard.getClipEntry(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ClipEntry clipEntry = (ClipEntry) obj;
        if (clipEntry != null && (readAnnotatedString = ClipboardUtils_androidKt.readAnnotatedString(clipEntry)) != null) {
            AnnotatedString plus = TextFieldValueKt.getTextBeforeSelection(this.this$0.getValue$foundation_release(), this.this$0.getValue$foundation_release().getText().length()).plus(readAnnotatedString).plus(TextFieldValueKt.getTextAfterSelection(this.this$0.getValue$foundation_release(), this.this$0.getValue$foundation_release().getText().length()));
            int m6433getMinimpl = TextRange.m6433getMinimpl(this.this$0.getValue$foundation_release().getSelection()) + readAnnotatedString.length();
            m1821createTextFieldValueFDrldGo = this.this$0.m1821createTextFieldValueFDrldGo(plus, TextRangeKt.TextRange(m6433getMinimpl, m6433getMinimpl));
            this.this$0.getOnValueChange$foundation_release().invoke(m1821createTextFieldValueFDrldGo);
            this.this$0.setHandleState(HandleState.None);
            UndoManager undoManager = this.this$0.getUndoManager();
            if (undoManager != null) {
                undoManager.forceNextSnapshot();
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
