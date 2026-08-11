package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.local.CacheStore;

/* compiled from: StatelessInputConnection.android.kt */
@Metadata(d1 = {"\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0013\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0016J\u0012\u0010\u001f\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010 H\u0016J\"\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010'\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010*\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\bH\u0016J\u0018\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\bH\u0016J\u0018\u00100\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\bH\u0016J\b\u00101\u001a\u00020\u001aH\u0016J\b\u00102\u001a\u00020\u001aH\u0002J\b\u00103\u001a\u00020\u001aH\u0016J\u0010\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\bH\u0016J\u001a\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010$\u001a\u00020\bH\u0016J\n\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010<\u001a\u0004\u0018\u00010+2\u0006\u0010$\u001a\u00020\bH\u0016J\u0018\u0010=\u001a\u00020+2\u0006\u0010>\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bH\u0016J\u0018\u0010?\u001a\u00020+2\u0006\u0010>\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bH\u0016J\u0010\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020\bH\u0016J\u0010\u0010E\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020\bH\u0016J$\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u001c\u0010N\u001a\u00020\u001a2\b\u0010O\u001a\u0004\u0018\u00010B2\b\u0010P\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010Q\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0010\u0010U\u001a\u00020\u001a2\u0006\u0010V\u001a\u00020\u001aH\u0016J\u0010\u0010W\u001a\u00020\u001a2\u0006\u0010X\u001a\u00020\bH\u0016J\u0010\u0010Y\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020[H\u0016J\u0010\u0010\\\u001a\u00020\u00102\u0006\u0010]\u001a\u00020\bH\u0002J\u0018\u0010^\u001a\u00020\u001a2\u0006\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u00020\bH\u0016J\u001a\u0010a\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\bH\u0016J\u0018\u0010b\u001a\u00020\u001a2\u0006\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR%\u0010\f\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u00110\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006c"}, d2 = {"Landroidx/compose/foundation/text/input/internal/StatelessInputConnection;", "Landroid/view/inputmethod/InputConnection;", CacheStore.SESSION, "Landroidx/compose/foundation/text/input/internal/TextInputSession;", "editorInfo", "Landroid/view/inputmethod/EditorInfo;", "(Landroidx/compose/foundation/text/input/internal/TextInputSession;Landroid/view/inputmethod/EditorInfo;)V", "batchDepth", "", "commitContentDelegateInputConnection", "getCommitContentDelegateInputConnection$annotations", "()V", "editCommands", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/ImeEditCommandScope;", "", "Lkotlin/ExtensionFunctionType;", "terminalInputConnection", "androidx/compose/foundation/text/input/internal/StatelessInputConnection$terminalInputConnection$1", "Landroidx/compose/foundation/text/input/internal/StatelessInputConnection$terminalInputConnection$1;", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "beginBatchEdit", "", "beginBatchEditInternal", "clearMetaKeyStates", "states", "closeConnection", "commitCompletion", "Landroid/view/inputmethod/CompletionInfo;", "commitContent", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "flags", "opts", "Landroid/os/Bundle;", "commitCorrection", "correctionInfo", "Landroid/view/inputmethod/CorrectionInfo;", "commitText", "", "newCursorPosition", "deleteSurroundingText", "beforeLength", "afterLength", "deleteSurroundingTextInCodePoints", "endBatchEdit", "endBatchEditInternal", "finishComposingText", "getCursorCapsMode", "reqModes", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "request", "Landroid/view/inputmethod/ExtractedTextRequest;", "getHandler", "Landroid/os/Handler;", "getSelectedText", "getTextAfterCursor", "maxChars", "getTextBeforeCursor", "logDebug", "message", "", "performContextMenuAction", "id", "performEditorAction", "editorAction", "performHandwritingGesture", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "executor", "Ljava/util/concurrent/Executor;", "consumer", "Ljava/util/function/IntConsumer;", "performPrivateCommand", "action", "data", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "reportFullscreenMode", "enabled", "requestCursorUpdates", "cursorUpdateMode", "sendKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "sendSynthesizedKeyEvent", "code", "setComposingRegion", "start", "end", "setComposingText", "setSelection", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class StatelessInputConnection implements InputConnection {
    public static final int $stable = 8;
    private int batchDepth;
    private final InputConnection commitContentDelegateInputConnection;
    private final MutableVector<Function1<ImeEditCommandScope, Unit>> editCommands = new MutableVector<>(new Function1[16], 0);
    private final TextInputSession session;
    private final StatelessInputConnection$terminalInputConnection$1 terminalInputConnection;

    private static /* synthetic */ void getCommitContentDelegateInputConnection$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logDebug(String message) {
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        return true;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.compose.foundation.text.input.internal.StatelessInputConnection$terminalInputConnection$1] */
    public StatelessInputConnection(TextInputSession textInputSession, EditorInfo editorInfo) {
        this.session = textInputSession;
        ?? r3 = new InputConnectionWrapper(this) { // from class: androidx.compose.foundation.text.input.internal.StatelessInputConnection$terminalInputConnection$1
            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean commitContent(InputContentInfo inputContentInfo, int flags, Bundle opts) {
                return false;
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean performPrivateCommand(String action, Bundle data) {
                return true;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(this, false);
            }
        };
        this.terminalInputConnection = r3;
        this.commitContentDelegateInputConnection = InputConnectionCompat.createWrapper((InputConnection) r3, editorInfo, new InputConnectionCompat.OnCommitContentListener() { // from class: androidx.compose.foundation.text.input.internal.StatelessInputConnection$commitContentDelegateInputConnection$1
            @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
            public boolean onCommitContent(InputContentInfoCompat inputContentInfo, int flags, Bundle opts) {
                TextInputSession textInputSession2;
                if (Build.VERSION.SDK_INT >= 25 && (flags & 1) != 0) {
                    try {
                        inputContentInfo.requestPermission();
                        Object unwrap = inputContentInfo.unwrap();
                        Intrinsics.checkNotNull(unwrap, "null cannot be cast to non-null type android.os.Parcelable");
                        Parcelable parcelable = (Parcelable) unwrap;
                        opts = opts == null ? new Bundle() : new Bundle(opts);
                        opts.putParcelable("EXTRA_INPUT_CONTENT_INFO", parcelable);
                    } catch (Exception e) {
                        StatelessInputConnection.this.logDebug("Can't insert content from IME; requestPermission() failed, " + e);
                        return false;
                    }
                }
                textInputSession2 = StatelessInputConnection.this.session;
                return textInputSession2.onCommitContent(StatelessInputConnection_androidKt.toTransferableContent(inputContentInfo, opts));
            }
        });
    }

    private final TextFieldCharSequence getText() {
        return this.session.getText();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        logDebug("beginBatchEdit()");
        return beginBatchEditInternal();
    }

    private final boolean beginBatchEditInternal() {
        return this.session.beginBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        logDebug("endBatchEdit()");
        return endBatchEditInternal();
    }

    private final boolean endBatchEditInternal() {
        return this.session.endBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        logDebug("closeConnection()");
        this.editCommands.clear();
        this.batchDepth = 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence text, int newCursorPosition) {
        logDebug("commitText(\"" + ((Object) text) + "\", " + newCursorPosition + ')');
        if (text == null) {
            return true;
        }
        ImeEditCommand_androidKt.commitText(this.session, text.toString(), newCursorPosition);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int start, int end) {
        logDebug("setComposingRegion(" + start + ", " + end + ')');
        ImeEditCommand_androidKt.setComposingRegion(this.session, start, end);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        logDebug("setComposingText(\"" + ((Object) text) + "\", " + newCursorPosition + ')');
        if (text == null) {
            return true;
        }
        TextInputSession textInputSession = this.session;
        String obj = text.toString();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        ImeEditCommand_androidKt.setComposingText(textInputSession, obj, newCursorPosition, spanned != null ? StatelessInputConnection_androidKt.toAnnotationList(spanned) : null);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int beforeLength, int afterLength) {
        logDebug("deleteSurroundingTextInCodePoints(" + beforeLength + ", " + afterLength + ')');
        ImeEditCommand_androidKt.deleteSurroundingTextInCodePoints(this.session, beforeLength, afterLength);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int beforeLength, int afterLength) {
        logDebug("deleteSurroundingText(" + beforeLength + ", " + afterLength + ')');
        ImeEditCommand_androidKt.deleteSurroundingText(this.session, beforeLength, afterLength);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int start, int end) {
        logDebug("setSelection(" + start + ", " + end + ')');
        ImeEditCommand_androidKt.setSelection(this.session, start, end);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        logDebug("finishComposingText()");
        ImeEditCommand_androidKt.finishComposingText(this.session);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent event) {
        logDebug("sendKeyEvent(" + event + ')');
        this.session.sendKeyEvent(event);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int maxChars, int flags) {
        String obj = TextFieldCharSequenceKt.getTextBeforeSelection(getText(), maxChars).toString();
        logDebug("getTextBeforeCursor(" + maxChars + ", " + flags + "): " + obj);
        return obj;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int maxChars, int flags) {
        String obj = TextFieldCharSequenceKt.getTextAfterSelection(getText(), maxChars).toString();
        logDebug("getTextAfterCursor(" + maxChars + ", " + flags + "): " + obj);
        return obj;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int flags) {
        String obj = TextRange.m6429getCollapsedimpl(getText().getSelection()) ? null : TextFieldCharSequenceKt.getSelectedText(getText()).toString();
        logDebug("getSelectedText(" + flags + "): " + ((Object) obj));
        return obj;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int cursorUpdateMode) {
        logDebug("requestCursorUpdates(" + cursorUpdateMode + ')');
        this.session.requestCursorUpdates(cursorUpdateMode);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public void performHandwritingGesture(HandwritingGesture gesture, Executor executor, IntConsumer consumer) {
        logDebug("performHandwritingGesture(" + gesture + ", " + executor + ", " + consumer + ')');
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        Api34PerformHandwritingGestureImpl.INSTANCE.performHandwritingGesture(this.session, gesture, executor, consumer);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean previewHandwritingGesture(PreviewableHandwritingGesture gesture, CancellationSignal cancellationSignal) {
        logDebug("previewHandwritingGesture(" + gesture + ", " + cancellationSignal + ')');
        if (Build.VERSION.SDK_INT < 34) {
            return false;
        }
        return Api34PerformHandwritingGestureImpl.INSTANCE.previewHandwritingGesture(this.session, gesture, cancellationSignal);
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        ExtractedText extractedText;
        logDebug("getExtractedText(" + request + ", " + flags + ')');
        extractedText = StatelessInputConnection_androidKt.toExtractedText(getText());
        return extractedText;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int reqModes) {
        logDebug("getCursorCapsMode(" + reqModes + ')');
        return TextUtils.getCapsMode(getText(), TextRange.m6433getMinimpl(getText().getSelection()), reqModes);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003d, code lost:
    
        return false;
     */
    @Override // android.view.inputmethod.InputConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean performContextMenuAction(int r3) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "performContextMenuAction("
            r0.<init>(r1)
            r0.append(r3)
            r1 = 41
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.logDebug(r0)
            r0 = 0
            switch(r3) {
                case 16908319: goto L2e;
                case 16908320: goto L28;
                case 16908321: goto L22;
                case 16908322: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L3d
        L1c:
            r3 = 279(0x117, float:3.91E-43)
            r2.sendSynthesizedKeyEvent(r3)
            goto L3d
        L22:
            r3 = 278(0x116, float:3.9E-43)
            r2.sendSynthesizedKeyEvent(r3)
            goto L3d
        L28:
            r3 = 277(0x115, float:3.88E-43)
            r2.sendSynthesizedKeyEvent(r3)
            goto L3d
        L2e:
            androidx.compose.foundation.text.input.internal.TextInputSession r3 = r2.session
            androidx.compose.foundation.text.input.internal.ImeEditCommandScope r3 = (androidx.compose.foundation.text.input.internal.ImeEditCommandScope) r3
            androidx.compose.foundation.text.input.TextFieldCharSequence r2 = r2.getText()
            int r2 = r2.length()
            androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt.setSelection(r3, r0, r2)
        L3d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.StatelessInputConnection.performContextMenuAction(int):boolean");
    }

    private final void sendSynthesizedKeyEvent(int code) {
        sendKeyEvent(new KeyEvent(0, code));
        sendKeyEvent(new KeyEvent(1, code));
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int editorAction) {
        int m6634getDefaulteUduSuo;
        logDebug("performEditorAction(" + editorAction + ')');
        if (editorAction == 0) {
            m6634getDefaulteUduSuo = ImeAction.INSTANCE.m6634getDefaulteUduSuo();
        } else {
            switch (editorAction) {
                case 2:
                    m6634getDefaulteUduSuo = ImeAction.INSTANCE.m6636getGoeUduSuo();
                    break;
                case 3:
                    m6634getDefaulteUduSuo = ImeAction.INSTANCE.m6640getSearcheUduSuo();
                    break;
                case 4:
                    m6634getDefaulteUduSuo = ImeAction.INSTANCE.m6641getSendeUduSuo();
                    break;
                case 5:
                    m6634getDefaulteUduSuo = ImeAction.INSTANCE.m6637getNexteUduSuo();
                    break;
                case 6:
                    m6634getDefaulteUduSuo = ImeAction.INSTANCE.m6635getDoneeUduSuo();
                    break;
                case 7:
                    m6634getDefaulteUduSuo = ImeAction.INSTANCE.m6639getPreviouseUduSuo();
                    break;
                default:
                    logDebug("IME sent an unrecognized editor action: " + editorAction);
                    m6634getDefaulteUduSuo = ImeAction.INSTANCE.m6634getDefaulteUduSuo();
                    break;
            }
        }
        this.session.mo1542onImeActionKlQnJC8(m6634getDefaulteUduSuo);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo text) {
        StringBuilder sb = new StringBuilder("commitCompletion(");
        sb.append((Object) (text != null ? text.getText() : null));
        sb.append(')');
        logDebug(sb.toString());
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        logDebug("getHandler()");
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int states) {
        logDebug("clearMetaKeyStates(" + states + ')');
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean enabled) {
        logDebug("reportFullscreenMode(" + enabled + ')');
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String action, Bundle data) {
        logDebug("performPrivateCommand(" + action + ", " + data + ')');
        return this.commitContentDelegateInputConnection.performPrivateCommand(action, data);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int flags, Bundle opts) {
        logDebug("commitContent(" + inputContentInfo + ", " + flags + ", " + opts + ')');
        if (Build.VERSION.SDK_INT >= 25) {
            return Api25CommitContentImpl.INSTANCE.commitContent(this.commitContentDelegateInputConnection, inputContentInfo, flags, opts);
        }
        return false;
    }
}
