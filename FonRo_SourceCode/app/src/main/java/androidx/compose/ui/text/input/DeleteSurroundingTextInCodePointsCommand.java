package androidx.compose.ui.text.input;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: EditCommand.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/input/DeleteSurroundingTextInCodePointsCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "lengthBeforeCursor", "", "lengthAfterCursor", "(II)V", "getLengthAfterCursor", "()I", "getLengthBeforeCursor", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", WriteOffReason.OTHER, "", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class DeleteSurroundingTextInCodePointsCommand implements EditCommand {
    public static final int $stable = 0;
    private final int lengthAfterCursor;
    private final int lengthBeforeCursor;

    public DeleteSurroundingTextInCodePointsCommand(int i, int i2) {
        this.lengthBeforeCursor = i;
        this.lengthAfterCursor = i2;
        if (i >= 0 && i2 >= 0) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i + " and " + i2 + " respectively.");
    }

    public final int getLengthBeforeCursor() {
        return this.lengthBeforeCursor;
    }

    public final int getLengthAfterCursor() {
        return this.lengthAfterCursor;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(EditingBuffer buffer) {
        boolean isSurrogatePair;
        boolean isSurrogatePair2;
        int i = this.lengthBeforeCursor;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 < i) {
                int i5 = i4 + 1;
                if (buffer.getSelectionStart() > i5) {
                    isSurrogatePair2 = EditCommandKt.isSurrogatePair(buffer.get$ui_text_release((buffer.getSelectionStart() - i5) - 1), buffer.get$ui_text_release(buffer.getSelectionStart() - i5));
                    i4 = isSurrogatePair2 ? i4 + 2 : i5;
                    i3++;
                } else {
                    i4 = buffer.getSelectionStart();
                    break;
                }
            } else {
                break;
            }
        }
        int i6 = this.lengthAfterCursor;
        int i7 = 0;
        while (true) {
            if (i2 >= i6) {
                break;
            }
            int i8 = i7 + 1;
            if (buffer.getSelectionEnd() + i8 < buffer.getLength$ui_text_release()) {
                isSurrogatePair = EditCommandKt.isSurrogatePair(buffer.get$ui_text_release((buffer.getSelectionEnd() + i8) - 1), buffer.get$ui_text_release(buffer.getSelectionEnd() + i8));
                i7 = isSurrogatePair ? i7 + 2 : i8;
                i2++;
            } else {
                i7 = buffer.getLength$ui_text_release() - buffer.getSelectionEnd();
                break;
            }
        }
        buffer.delete$ui_text_release(buffer.getSelectionEnd(), buffer.getSelectionEnd() + i7);
        buffer.delete$ui_text_release(buffer.getSelectionStart() - i4, buffer.getSelectionStart());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeleteSurroundingTextInCodePointsCommand)) {
            return false;
        }
        DeleteSurroundingTextInCodePointsCommand deleteSurroundingTextInCodePointsCommand = (DeleteSurroundingTextInCodePointsCommand) other;
        return this.lengthBeforeCursor == deleteSurroundingTextInCodePointsCommand.lengthBeforeCursor && this.lengthAfterCursor == deleteSurroundingTextInCodePointsCommand.lengthAfterCursor;
    }

    public int hashCode() {
        return (this.lengthBeforeCursor * 31) + this.lengthAfterCursor;
    }

    public String toString() {
        return "DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=" + this.lengthBeforeCursor + ", lengthAfterCursor=" + this.lengthAfterCursor + ')';
    }
}
