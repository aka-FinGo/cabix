package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.KeyEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: TextFieldKeyInput.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
/* synthetic */ class TextFieldKeyInputKt$textFieldKeyInput$2$1$1 extends FunctionReferenceImpl implements Function1<KeyEvent, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TextFieldKeyInputKt$textFieldKeyInput$2$1$1(Object obj) {
        super(1, obj, TextFieldKeyInput.class, "process", "process-ZmokQxo(Landroid/view/KeyEvent;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
        return m1475invokeZmokQxo(keyEvent.m5452unboximpl());
    }

    /* renamed from: invoke-ZmokQxo, reason: not valid java name */
    public final Boolean m1475invokeZmokQxo(android.view.KeyEvent keyEvent) {
        return Boolean.valueOf(((TextFieldKeyInput) this.receiver).m1472processZmokQxo(keyEvent));
    }
}
