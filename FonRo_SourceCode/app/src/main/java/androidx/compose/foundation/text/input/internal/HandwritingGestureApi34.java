package androidx.compose.foundation.text.input.internal;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.CancellationSignal;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.internal.Listener$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* compiled from: HandwritingGesture.android.kt */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J>\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00162\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J8\u0010\u0017\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J&\u0010\u001e\u001a\u00020\n*\u00020\u001d2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J0\u0010#\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J\u001c\u0010#\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J0\u0010(\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J\u001c\u0010(\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0002J&\u0010*\u001a\u00020\n*\u00020\u001d2\u0006\u0010+\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-JA\u0010.\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010\u00192\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0000¢\u0006\u0002\b2J;\u0010.\u001a\u00020\u0004*\u00020\u001d2\u0006\u00103\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u0001052\b\u00100\u001a\u0004\u0018\u000101H\u0000¢\u0006\u0002\b2J2\u00106\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u0002072\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J&\u00106\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u0002072\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0002J:\u00108\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u0002092\u0006\u0010\u000e\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J&\u00108\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u0002092\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0002J:\u0010:\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020;2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J&\u0010:\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020;2\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0002J2\u0010<\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020=2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J,\u0010<\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020=2\u0006\u0010&\u001a\u00020'2\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u000105H\u0002J2\u0010>\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020?2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J,\u0010>\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020?2\u0006\u0010&\u001a\u00020'2\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u000105H\u0002J\u001e\u0010@\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0002J\u001c\u0010@\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\u001e\u0010A\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0002J\u001c\u0010A\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0002J-\u0010B\u001a\u00020\u0011*\u00020$2\u0006\u0010\u0005\u001a\u00020C2\b\u0010/\u001a\u0004\u0018\u00010\u00192\b\u0010D\u001a\u0004\u0018\u00010EH\u0000¢\u0006\u0002\bFJ+\u0010B\u001a\u00020\u0011*\u00020\u001d2\u0006\u00103\u001a\u00020C2\u0006\u0010&\u001a\u00020'2\b\u0010D\u001a\u0004\u0018\u00010EH\u0000¢\u0006\u0002\bFJ\u001e\u0010G\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020=2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0002J\u001c\u0010G\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020=2\u0006\u0010&\u001a\u00020'H\u0002J\u001e\u0010H\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020?2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0002J\u001c\u0010H\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020?2\u0006\u0010&\u001a\u00020'H\u0002J\u0019\u0010I\u001a\u00020J*\u00020\u0004H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006M"}, d2 = {"Landroidx/compose/foundation/text/input/internal/HandwritingGestureApi34;", "", "()V", "fallbackOnLegacyTextField", "", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "editCommandConsumer", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/EditCommand;", "", "performDeletionOnLegacyTextField", "range", "Landroidx/compose/ui/text/TextRange;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "adjustRange", "", "performDeletionOnLegacyTextField-vJH6DeI", "(JLandroidx/compose/ui/text/AnnotatedString;ZLkotlin/jvm/functions/Function1;)V", "performInsertionOnLegacyTextField", TypedValues.CycleType.S_WAVE_OFFSET, "", "performSelectionOnLegacyTextField", "textSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "performSelectionOnLegacyTextField-8ffj60Q", "(JLandroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function1;)V", "fallback", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "highlightRange", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlightRange-XJREzCE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JI)V", "performDeleteGesture", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "Landroid/view/inputmethod/DeleteGesture;", "layoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "performDeleteRangeGesture", "Landroid/view/inputmethod/DeleteRangeGesture;", "performDeletion", "rangeInTransformedText", "performDeletion-Sb-Bc2M", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JZ)V", "performHandwritingGesture", "textFieldSelectionManager", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "performHandwritingGesture$foundation_release", "handwritingGesture", "updateSelectionState", "Lkotlin/Function0;", "performInsertGesture", "Landroid/view/inputmethod/InsertGesture;", "performJoinOrSplitGesture", "Landroid/view/inputmethod/JoinOrSplitGesture;", "performRemoveSpaceGesture", "Landroid/view/inputmethod/RemoveSpaceGesture;", "performSelectGesture", "Landroid/view/inputmethod/SelectGesture;", "performSelectRangeGesture", "Landroid/view/inputmethod/SelectRangeGesture;", "previewDeleteGesture", "previewDeleteRangeGesture", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "previewHandwritingGesture$foundation_release", "previewSelectGesture", "previewSelectRangeGesture", "toTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toTextGranularity-NUwxegE", "(I)I", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class HandwritingGestureApi34 {
    public static final int $stable = 0;
    public static final HandwritingGestureApi34 INSTANCE = new HandwritingGestureApi34();

    private HandwritingGestureApi34() {
    }

    public final int performHandwritingGesture$foundation_release(TransformedTextFieldState transformedTextFieldState, HandwritingGesture handwritingGesture, TextLayoutState textLayoutState, Function0<Unit> function0, ViewConfiguration viewConfiguration) {
        if (Listener$$ExternalSyntheticApiModelOutline0.m$4(handwritingGesture)) {
            return performSelectGesture(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3019m((Object) handwritingGesture), textLayoutState, function0);
        }
        if (Listener$$ExternalSyntheticApiModelOutline0.m$2(handwritingGesture)) {
            return performDeleteGesture(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3013m((Object) handwritingGesture), textLayoutState);
        }
        if (Listener$$ExternalSyntheticApiModelOutline0.m$5(handwritingGesture)) {
            return performSelectRangeGesture(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3020m((Object) handwritingGesture), textLayoutState, function0);
        }
        if (Listener$$ExternalSyntheticApiModelOutline0.m$6(handwritingGesture)) {
            return performDeleteRangeGesture(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3014m((Object) handwritingGesture), textLayoutState);
        }
        if (Listener$$ExternalSyntheticApiModelOutline0.m$3(handwritingGesture)) {
            return performJoinOrSplitGesture(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3017m((Object) handwritingGesture), textLayoutState, viewConfiguration);
        }
        if (Listener$$ExternalSyntheticApiModelOutline0.m3027m((Object) handwritingGesture)) {
            return performInsertGesture(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3016m((Object) handwritingGesture), textLayoutState, viewConfiguration);
        }
        if (Listener$$ExternalSyntheticApiModelOutline0.m$1(handwritingGesture)) {
            return performRemoveSpaceGesture(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3018m((Object) handwritingGesture), textLayoutState, viewConfiguration);
        }
        return 2;
    }

    public final boolean previewHandwritingGesture$foundation_release(final TransformedTextFieldState transformedTextFieldState, PreviewableHandwritingGesture previewableHandwritingGesture, TextLayoutState textLayoutState, CancellationSignal cancellationSignal) {
        if (Listener$$ExternalSyntheticApiModelOutline0.m$4(previewableHandwritingGesture)) {
            previewSelectGesture(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3019m((Object) previewableHandwritingGesture), textLayoutState);
        } else if (Listener$$ExternalSyntheticApiModelOutline0.m$2(previewableHandwritingGesture)) {
            previewDeleteGesture(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3013m((Object) previewableHandwritingGesture), textLayoutState);
        } else if (Listener$$ExternalSyntheticApiModelOutline0.m$5(previewableHandwritingGesture)) {
            previewSelectRangeGesture(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3020m((Object) previewableHandwritingGesture), textLayoutState);
        } else {
            if (!Listener$$ExternalSyntheticApiModelOutline0.m$6(previewableHandwritingGesture)) {
                return false;
            }
            previewDeleteRangeGesture(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3014m((Object) previewableHandwritingGesture), textLayoutState);
        }
        if (cancellationSignal == null) {
            return true;
        }
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$$ExternalSyntheticLambda32
            @Override // android.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                HandwritingGestureApi34.previewHandwritingGesture$lambda$1(TransformedTextFieldState.this);
            }
        });
        return true;
    }

    private final int performSelectGesture(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState, Function0<Unit> function0) {
        RectF selectionArea;
        int granularity;
        long m1576getRangeForScreenRectOH9lIzo;
        selectionArea = selectGesture.getSelectionArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(selectionArea);
        granularity = selectGesture.getGranularity();
        m1576getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1576getRangeForScreenRectOH9lIzo(textLayoutState, composeRect, m1558toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m6429getCollapsedimpl(m1576getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallback(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3015m((Object) selectGesture));
        }
        transformedTextFieldState.m1640selectCharsIn5zctL8(m1576getRangeForScreenRectOH9lIzo);
        if (function0 == null) {
            return 1;
        }
        function0.invoke();
        return 1;
    }

    private final void previewSelectGesture(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState) {
        RectF selectionArea;
        int granularity;
        long m1576getRangeForScreenRectOH9lIzo;
        selectionArea = selectGesture.getSelectionArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(selectionArea);
        granularity = selectGesture.getGranularity();
        m1576getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1576getRangeForScreenRectOH9lIzo(textLayoutState, composeRect, m1558toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
        m1554highlightRangeXJREzCE(transformedTextFieldState, m1576getRangeForScreenRectOH9lIzo, TextHighlightType.INSTANCE.m1526getHandwritingSelectPreviewsxJuwY());
    }

    private final int performDeleteGesture(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        int granularity;
        RectF deletionArea;
        long m1576getRangeForScreenRectOH9lIzo;
        granularity = deleteGesture.getGranularity();
        int m1558toTextGranularityNUwxegE = m1558toTextGranularityNUwxegE(granularity);
        deletionArea = deleteGesture.getDeletionArea();
        m1576getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1576getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(deletionArea), m1558toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m6429getCollapsedimpl(m1576getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallback(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3015m((Object) deleteGesture));
        }
        m1555performDeletionSbBc2M(transformedTextFieldState, m1576getRangeForScreenRectOH9lIzo, TextGranularity.m6393equalsimpl0(m1558toTextGranularityNUwxegE, TextGranularity.INSTANCE.m6398getWordDRrd7Zo()));
        return 1;
    }

    private final void previewDeleteGesture(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        RectF deletionArea;
        int granularity;
        long m1576getRangeForScreenRectOH9lIzo;
        deletionArea = deleteGesture.getDeletionArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(deletionArea);
        granularity = deleteGesture.getGranularity();
        m1576getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1576getRangeForScreenRectOH9lIzo(textLayoutState, composeRect, m1558toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
        m1554highlightRangeXJREzCE(transformedTextFieldState, m1576getRangeForScreenRectOH9lIzo, TextHighlightType.INSTANCE.m1525getHandwritingDeletePreviewsxJuwY());
    }

    private final int performSelectRangeGesture(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState, Function0<Unit> function0) {
        RectF selectionStartArea;
        RectF selectionEndArea;
        int granularity;
        long m1578getRangeForScreenRectsO048IG0;
        selectionStartArea = selectRangeGesture.getSelectionStartArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(selectionStartArea);
        selectionEndArea = selectRangeGesture.getSelectionEndArea();
        Rect composeRect2 = RectHelper_androidKt.toComposeRect(selectionEndArea);
        granularity = selectRangeGesture.getGranularity();
        m1578getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1578getRangeForScreenRectsO048IG0(textLayoutState, composeRect, composeRect2, m1558toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m6429getCollapsedimpl(m1578getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallback(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3015m((Object) selectRangeGesture));
        }
        transformedTextFieldState.m1640selectCharsIn5zctL8(m1578getRangeForScreenRectsO048IG0);
        if (function0 == null) {
            return 1;
        }
        function0.invoke();
        return 1;
    }

    private final void previewSelectRangeGesture(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState) {
        RectF selectionStartArea;
        RectF selectionEndArea;
        int granularity;
        long m1578getRangeForScreenRectsO048IG0;
        selectionStartArea = selectRangeGesture.getSelectionStartArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(selectionStartArea);
        selectionEndArea = selectRangeGesture.getSelectionEndArea();
        Rect composeRect2 = RectHelper_androidKt.toComposeRect(selectionEndArea);
        granularity = selectRangeGesture.getGranularity();
        m1578getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1578getRangeForScreenRectsO048IG0(textLayoutState, composeRect, composeRect2, m1558toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
        m1554highlightRangeXJREzCE(transformedTextFieldState, m1578getRangeForScreenRectsO048IG0, TextHighlightType.INSTANCE.m1526getHandwritingSelectPreviewsxJuwY());
    }

    private final int performDeleteRangeGesture(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        int granularity;
        RectF deletionStartArea;
        RectF deletionEndArea;
        long m1578getRangeForScreenRectsO048IG0;
        granularity = deleteRangeGesture.getGranularity();
        int m1558toTextGranularityNUwxegE = m1558toTextGranularityNUwxegE(granularity);
        deletionStartArea = deleteRangeGesture.getDeletionStartArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(deletionStartArea);
        deletionEndArea = deleteRangeGesture.getDeletionEndArea();
        m1578getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1578getRangeForScreenRectsO048IG0(textLayoutState, composeRect, RectHelper_androidKt.toComposeRect(deletionEndArea), m1558toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m6429getCollapsedimpl(m1578getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallback(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3015m((Object) deleteRangeGesture));
        }
        m1555performDeletionSbBc2M(transformedTextFieldState, m1578getRangeForScreenRectsO048IG0, TextGranularity.m6393equalsimpl0(m1558toTextGranularityNUwxegE, TextGranularity.INSTANCE.m6398getWordDRrd7Zo()));
        return 1;
    }

    private final void previewDeleteRangeGesture(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        RectF deletionStartArea;
        RectF deletionEndArea;
        int granularity;
        long m1578getRangeForScreenRectsO048IG0;
        deletionStartArea = deleteRangeGesture.getDeletionStartArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(deletionStartArea);
        deletionEndArea = deleteRangeGesture.getDeletionEndArea();
        Rect composeRect2 = RectHelper_androidKt.toComposeRect(deletionEndArea);
        granularity = deleteRangeGesture.getGranularity();
        m1578getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1578getRangeForScreenRectsO048IG0(textLayoutState, composeRect, composeRect2, m1558toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
        m1554highlightRangeXJREzCE(transformedTextFieldState, m1578getRangeForScreenRectsO048IG0, TextHighlightType.INSTANCE.m1525getHandwritingDeletePreviewsxJuwY());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r12 == true) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int performJoinOrSplitGesture(androidx.compose.foundation.text.input.internal.TransformedTextFieldState r10, android.view.inputmethod.JoinOrSplitGesture r11, androidx.compose.foundation.text.input.internal.TextLayoutState r12, androidx.compose.ui.platform.ViewConfiguration r13) {
        /*
            r9 = this;
            androidx.compose.foundation.text.input.TextFieldCharSequence r0 = r10.getOutputText()
            androidx.compose.foundation.text.input.TextFieldCharSequence r1 = r10.getUntransformedText()
            if (r0 == r1) goto Lc
            r9 = 3
            return r9
        Lc:
            android.graphics.PointF r0 = androidx.compose.material3.internal.Listener$$ExternalSyntheticApiModelOutline0.m(r11)
            long r0 = androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt.access$toOffset(r0)
            int r13 = androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt.m1561access$getOffsetForHandwritingGestured4ec7I(r12, r0, r13)
            r0 = -1
            if (r13 == r0) goto L4e
            androidx.compose.ui.text.TextLayoutResult r12 = r12.getLayoutResult()
            r0 = 1
            if (r12 == 0) goto L29
            boolean r12 = androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt.access$isBiDiBoundary(r12, r13)
            if (r12 != r0) goto L29
            goto L4e
        L29:
            androidx.compose.foundation.text.input.TextFieldCharSequence r11 = r10.getVisualText()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            long r3 = androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt.access$rangeOfWhitespaces(r11, r13)
            boolean r11 = androidx.compose.ui.text.TextRange.m6429getCollapsedimpl(r3)
            if (r11 == 0) goto L48
            java.lang.String r9 = " "
            r2 = r9
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r7 = 12
            r8 = 0
            r5 = 0
            r6 = 0
            r1 = r10
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.m1633replaceTextM8tDOmk$default(r1, r2, r3, r5, r6, r7, r8)
            goto L4d
        L48:
            r1 = r10
            r10 = 0
            r9.m1555performDeletionSbBc2M(r1, r3, r10)
        L4d:
            return r0
        L4e:
            r1 = r10
            android.view.inputmethod.HandwritingGesture r10 = androidx.compose.material3.internal.Listener$$ExternalSyntheticApiModelOutline0.m3015m(r11)
            int r9 = r9.fallback(r1, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34.performJoinOrSplitGesture(androidx.compose.foundation.text.input.internal.TransformedTextFieldState, android.view.inputmethod.JoinOrSplitGesture, androidx.compose.foundation.text.input.internal.TextLayoutState, androidx.compose.ui.platform.ViewConfiguration):int");
    }

    private final int performInsertGesture(TransformedTextFieldState transformedTextFieldState, InsertGesture insertGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        PointF insertionPoint;
        long offset;
        int m1571getOffsetForHandwritingGestured4ec7I;
        String textToInsert;
        insertionPoint = insertGesture.getInsertionPoint();
        offset = HandwritingGesture_androidKt.toOffset(insertionPoint);
        m1571getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m1571getOffsetForHandwritingGestured4ec7I(textLayoutState, offset, viewConfiguration);
        if (m1571getOffsetForHandwritingGestured4ec7I == -1) {
            return fallback(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3015m((Object) insertGesture));
        }
        textToInsert = insertGesture.getTextToInsert();
        TransformedTextFieldState.m1633replaceTextM8tDOmk$default(transformedTextFieldState, textToInsert, TextRangeKt.TextRange(m1571getOffsetForHandwritingGestured4ec7I), null, false, 12, null);
        return 1;
    }

    private final int performRemoveSpaceGesture(TransformedTextFieldState transformedTextFieldState, RemoveSpaceGesture removeSpaceGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        PointF startPoint;
        long offset;
        PointF endPoint;
        long offset2;
        long m1573getRangeForRemoveSpaceGesture5iVPX68;
        TextLayoutResult layoutResult = textLayoutState.getLayoutResult();
        startPoint = removeSpaceGesture.getStartPoint();
        offset = HandwritingGesture_androidKt.toOffset(startPoint);
        endPoint = removeSpaceGesture.getEndPoint();
        offset2 = HandwritingGesture_androidKt.toOffset(endPoint);
        m1573getRangeForRemoveSpaceGesture5iVPX68 = HandwritingGesture_androidKt.m1573getRangeForRemoveSpaceGesture5iVPX68(layoutResult, offset, offset2, textLayoutState.getTextLayoutNodeCoordinates(), viewConfiguration);
        if (TextRange.m6429getCollapsedimpl(m1573getRangeForRemoveSpaceGesture5iVPX68)) {
            return INSTANCE.fallback(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3015m((Object) removeSpaceGesture));
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = -1;
        String replace = new Regex("\\s+").replace(TextRangeKt.m6442substringFDrldGo(transformedTextFieldState.getVisualText(), m1573getRangeForRemoveSpaceGesture5iVPX68), new Function1<MatchResult, CharSequence>() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$performRemoveSpaceGesture$newText$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult matchResult) {
                if (Ref.IntRef.this.element == -1) {
                    Ref.IntRef.this.element = matchResult.getRange().getFirst();
                }
                intRef2.element = matchResult.getRange().getLast() + 1;
                return "";
            }
        });
        if (intRef.element == -1 || intRef2.element == -1) {
            return fallback(transformedTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3015m((Object) removeSpaceGesture));
        }
        long TextRange = TextRangeKt.TextRange(TextRange.m6435getStartimpl(m1573getRangeForRemoveSpaceGesture5iVPX68) + intRef.element, TextRange.m6435getStartimpl(m1573getRangeForRemoveSpaceGesture5iVPX68) + intRef2.element);
        String substring = replace.substring(intRef.element, replace.length() - (TextRange.m6431getLengthimpl(m1573getRangeForRemoveSpaceGesture5iVPX68) - intRef2.element));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        TransformedTextFieldState.m1633replaceTextM8tDOmk$default(transformedTextFieldState, substring, TextRange, null, false, 12, null);
        return 1;
    }

    /* renamed from: performDeletion-Sb-Bc2M, reason: not valid java name */
    private final void m1555performDeletionSbBc2M(TransformedTextFieldState transformedTextFieldState, long j, boolean z) {
        if (z) {
            j = HandwritingGesture_androidKt.m1567adjustHandwritingDeleteGestureRange72CqOWE(j, transformedTextFieldState.getVisualText());
        }
        TransformedTextFieldState.m1633replaceTextM8tDOmk$default(transformedTextFieldState, "", j, null, false, 12, null);
    }

    /* renamed from: highlightRange-XJREzCE, reason: not valid java name */
    private final void m1554highlightRangeXJREzCE(TransformedTextFieldState transformedTextFieldState, long j, int i) {
        if (TextRange.m6429getCollapsedimpl(j)) {
            TextFieldState textFieldState = transformedTextFieldState.textFieldState;
            InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
            TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
            textFieldState.getMainBuffer().getChangeTracker$foundation_release().clearChanges();
            TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
            mainBuffer.clearHighlight$foundation_release();
            transformedTextFieldState.updateWedgeAffinity(mainBuffer);
            textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
            return;
        }
        transformedTextFieldState.m1634highlightCharsIn7RAjNK8(i, j);
    }

    public final int performHandwritingGesture$foundation_release(LegacyTextFieldState legacyTextFieldState, HandwritingGesture handwritingGesture, TextFieldSelectionManager textFieldSelectionManager, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        TextLayoutResult value;
        TextLayoutInput layoutInput;
        AnnotatedString untransformedText = legacyTextFieldState.getUntransformedText();
        if (untransformedText == null) {
            return 3;
        }
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (!Intrinsics.areEqual(untransformedText, (layoutResult == null || (value = layoutResult.getValue()) == null || (layoutInput = value.getLayoutInput()) == null) ? null : layoutInput.getText())) {
            return 3;
        }
        if (Listener$$ExternalSyntheticApiModelOutline0.m$4(handwritingGesture)) {
            return performSelectGesture(legacyTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3019m((Object) handwritingGesture), textFieldSelectionManager, function1);
        }
        if (Listener$$ExternalSyntheticApiModelOutline0.m$2(handwritingGesture)) {
            return performDeleteGesture(legacyTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3013m((Object) handwritingGesture), untransformedText, function1);
        }
        if (Listener$$ExternalSyntheticApiModelOutline0.m$5(handwritingGesture)) {
            return performSelectRangeGesture(legacyTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3020m((Object) handwritingGesture), textFieldSelectionManager, function1);
        }
        if (Listener$$ExternalSyntheticApiModelOutline0.m$6(handwritingGesture)) {
            return performDeleteRangeGesture(legacyTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3014m((Object) handwritingGesture), untransformedText, function1);
        }
        if (Listener$$ExternalSyntheticApiModelOutline0.m$3(handwritingGesture)) {
            return performJoinOrSplitGesture(legacyTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3017m((Object) handwritingGesture), untransformedText, viewConfiguration, function1);
        }
        if (Listener$$ExternalSyntheticApiModelOutline0.m3027m((Object) handwritingGesture)) {
            return performInsertGesture(legacyTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3016m((Object) handwritingGesture), viewConfiguration, function1);
        }
        if (Listener$$ExternalSyntheticApiModelOutline0.m$1(handwritingGesture)) {
            return performRemoveSpaceGesture(legacyTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3018m((Object) handwritingGesture), untransformedText, viewConfiguration, function1);
        }
        return 2;
    }

    public final boolean previewHandwritingGesture$foundation_release(LegacyTextFieldState legacyTextFieldState, PreviewableHandwritingGesture previewableHandwritingGesture, final TextFieldSelectionManager textFieldSelectionManager, CancellationSignal cancellationSignal) {
        TextLayoutResult value;
        TextLayoutInput layoutInput;
        AnnotatedString untransformedText = legacyTextFieldState.getUntransformedText();
        if (untransformedText == null) {
            return false;
        }
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (!Intrinsics.areEqual(untransformedText, (layoutResult == null || (value = layoutResult.getValue()) == null || (layoutInput = value.getLayoutInput()) == null) ? null : layoutInput.getText())) {
            return false;
        }
        if (Listener$$ExternalSyntheticApiModelOutline0.m$4(previewableHandwritingGesture)) {
            previewSelectGesture(legacyTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3019m((Object) previewableHandwritingGesture), textFieldSelectionManager);
        } else if (Listener$$ExternalSyntheticApiModelOutline0.m$2(previewableHandwritingGesture)) {
            previewDeleteGesture(legacyTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3013m((Object) previewableHandwritingGesture), textFieldSelectionManager);
        } else if (Listener$$ExternalSyntheticApiModelOutline0.m$5(previewableHandwritingGesture)) {
            previewSelectRangeGesture(legacyTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3020m((Object) previewableHandwritingGesture), textFieldSelectionManager);
        } else {
            if (!Listener$$ExternalSyntheticApiModelOutline0.m$6(previewableHandwritingGesture)) {
                return false;
            }
            previewDeleteRangeGesture(legacyTextFieldState, Listener$$ExternalSyntheticApiModelOutline0.m3014m((Object) previewableHandwritingGesture), textFieldSelectionManager);
        }
        if (cancellationSignal == null) {
            return true;
        }
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$$ExternalSyntheticLambda31
            @Override // android.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                HandwritingGestureApi34.previewHandwritingGesture$lambda$9(TextFieldSelectionManager.this);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void previewHandwritingGesture$lambda$9(TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.clearPreviewHighlight$foundation_release();
        }
    }

    private final int performSelectGesture(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager, Function1<? super EditCommand, Unit> function1) {
        RectF selectionArea;
        int granularity;
        long m1575getRangeForScreenRectOH9lIzo;
        selectionArea = selectGesture.getSelectionArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(selectionArea);
        granularity = selectGesture.getGranularity();
        m1575getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1575getRangeForScreenRectOH9lIzo(legacyTextFieldState, composeRect, m1558toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m6429getCollapsedimpl(m1575getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallbackOnLegacyTextField(Listener$$ExternalSyntheticApiModelOutline0.m3015m((Object) selectGesture), function1);
        }
        m1557performSelectionOnLegacyTextField8ffj60Q(m1575getRangeForScreenRectOH9lIzo, textFieldSelectionManager, function1);
        return 1;
    }

    private final void previewSelectGesture(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager) {
        RectF selectionArea;
        int granularity;
        long m1575getRangeForScreenRectOH9lIzo;
        if (textFieldSelectionManager != null) {
            selectionArea = selectGesture.getSelectionArea();
            Rect composeRect = RectHelper_androidKt.toComposeRect(selectionArea);
            granularity = selectGesture.getGranularity();
            m1575getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1575getRangeForScreenRectOH9lIzo(legacyTextFieldState, composeRect, m1558toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
            textFieldSelectionManager.m1831setSelectionPreviewHighlight5zctL8$foundation_release(m1575getRangeForScreenRectOH9lIzo);
        }
    }

    private final int performDeleteGesture(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, AnnotatedString annotatedString, Function1<? super EditCommand, Unit> function1) {
        int granularity;
        RectF deletionArea;
        long m1575getRangeForScreenRectOH9lIzo;
        granularity = deleteGesture.getGranularity();
        int m1558toTextGranularityNUwxegE = m1558toTextGranularityNUwxegE(granularity);
        deletionArea = deleteGesture.getDeletionArea();
        m1575getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1575getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deletionArea), m1558toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m6429getCollapsedimpl(m1575getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallbackOnLegacyTextField(Listener$$ExternalSyntheticApiModelOutline0.m3015m((Object) deleteGesture), function1);
        }
        m1556performDeletionOnLegacyTextFieldvJH6DeI(m1575getRangeForScreenRectOH9lIzo, annotatedString, TextGranularity.m6393equalsimpl0(m1558toTextGranularityNUwxegE, TextGranularity.INSTANCE.m6398getWordDRrd7Zo()), function1);
        return 1;
    }

    private final void previewDeleteGesture(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, TextFieldSelectionManager textFieldSelectionManager) {
        RectF deletionArea;
        int granularity;
        long m1575getRangeForScreenRectOH9lIzo;
        if (textFieldSelectionManager != null) {
            deletionArea = deleteGesture.getDeletionArea();
            Rect composeRect = RectHelper_androidKt.toComposeRect(deletionArea);
            granularity = deleteGesture.getGranularity();
            m1575getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1575getRangeForScreenRectOH9lIzo(legacyTextFieldState, composeRect, m1558toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
            textFieldSelectionManager.m1830setDeletionPreviewHighlight5zctL8$foundation_release(m1575getRangeForScreenRectOH9lIzo);
        }
    }

    private final int performSelectRangeGesture(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager, Function1<? super EditCommand, Unit> function1) {
        RectF selectionStartArea;
        RectF selectionEndArea;
        int granularity;
        long m1577getRangeForScreenRectsO048IG0;
        selectionStartArea = selectRangeGesture.getSelectionStartArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(selectionStartArea);
        selectionEndArea = selectRangeGesture.getSelectionEndArea();
        Rect composeRect2 = RectHelper_androidKt.toComposeRect(selectionEndArea);
        granularity = selectRangeGesture.getGranularity();
        m1577getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1577getRangeForScreenRectsO048IG0(legacyTextFieldState, composeRect, composeRect2, m1558toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m6429getCollapsedimpl(m1577getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallbackOnLegacyTextField(Listener$$ExternalSyntheticApiModelOutline0.m3015m((Object) selectRangeGesture), function1);
        }
        m1557performSelectionOnLegacyTextField8ffj60Q(m1577getRangeForScreenRectsO048IG0, textFieldSelectionManager, function1);
        return 1;
    }

    private final void previewSelectRangeGesture(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        RectF selectionStartArea;
        RectF selectionEndArea;
        int granularity;
        long m1577getRangeForScreenRectsO048IG0;
        if (textFieldSelectionManager != null) {
            selectionStartArea = selectRangeGesture.getSelectionStartArea();
            Rect composeRect = RectHelper_androidKt.toComposeRect(selectionStartArea);
            selectionEndArea = selectRangeGesture.getSelectionEndArea();
            Rect composeRect2 = RectHelper_androidKt.toComposeRect(selectionEndArea);
            granularity = selectRangeGesture.getGranularity();
            m1577getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1577getRangeForScreenRectsO048IG0(legacyTextFieldState, composeRect, composeRect2, m1558toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
            textFieldSelectionManager.m1831setSelectionPreviewHighlight5zctL8$foundation_release(m1577getRangeForScreenRectsO048IG0);
        }
    }

    private final int performDeleteRangeGesture(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, AnnotatedString annotatedString, Function1<? super EditCommand, Unit> function1) {
        int granularity;
        RectF deletionStartArea;
        RectF deletionEndArea;
        long m1577getRangeForScreenRectsO048IG0;
        granularity = deleteRangeGesture.getGranularity();
        int m1558toTextGranularityNUwxegE = m1558toTextGranularityNUwxegE(granularity);
        deletionStartArea = deleteRangeGesture.getDeletionStartArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(deletionStartArea);
        deletionEndArea = deleteRangeGesture.getDeletionEndArea();
        m1577getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1577getRangeForScreenRectsO048IG0(legacyTextFieldState, composeRect, RectHelper_androidKt.toComposeRect(deletionEndArea), m1558toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m6429getCollapsedimpl(m1577getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallbackOnLegacyTextField(Listener$$ExternalSyntheticApiModelOutline0.m3015m((Object) deleteRangeGesture), function1);
        }
        m1556performDeletionOnLegacyTextFieldvJH6DeI(m1577getRangeForScreenRectsO048IG0, annotatedString, TextGranularity.m6393equalsimpl0(m1558toTextGranularityNUwxegE, TextGranularity.INSTANCE.m6398getWordDRrd7Zo()), function1);
        return 1;
    }

    private final void previewDeleteRangeGesture(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        RectF deletionStartArea;
        RectF deletionEndArea;
        int granularity;
        long m1577getRangeForScreenRectsO048IG0;
        if (textFieldSelectionManager != null) {
            deletionStartArea = deleteRangeGesture.getDeletionStartArea();
            Rect composeRect = RectHelper_androidKt.toComposeRect(deletionStartArea);
            deletionEndArea = deleteRangeGesture.getDeletionEndArea();
            Rect composeRect2 = RectHelper_androidKt.toComposeRect(deletionEndArea);
            granularity = deleteRangeGesture.getGranularity();
            m1577getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1577getRangeForScreenRectsO048IG0(legacyTextFieldState, composeRect, composeRect2, m1558toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
            textFieldSelectionManager.m1830setDeletionPreviewHighlight5zctL8$foundation_release(m1577getRangeForScreenRectsO048IG0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        if (r8 == true) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int performJoinOrSplitGesture(androidx.compose.foundation.text.LegacyTextFieldState r8, android.view.inputmethod.JoinOrSplitGesture r9, androidx.compose.ui.text.AnnotatedString r10, androidx.compose.ui.platform.ViewConfiguration r11, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.EditCommand, kotlin.Unit> r12) {
        /*
            r7 = this;
            if (r11 != 0) goto Lb
            android.view.inputmethod.HandwritingGesture r8 = androidx.compose.material3.internal.Listener$$ExternalSyntheticApiModelOutline0.m3015m(r9)
            int r7 = r7.fallbackOnLegacyTextField(r8, r12)
            return r7
        Lb:
            android.graphics.PointF r0 = androidx.compose.material3.internal.Listener$$ExternalSyntheticApiModelOutline0.m(r9)
            long r0 = androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt.access$toOffset(r0)
            int r11 = androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt.m1560access$getOffsetForHandwritingGestured4ec7I(r8, r0, r11)
            r0 = -1
            if (r11 == r0) goto L4d
            androidx.compose.foundation.text.TextLayoutResultProxy r8 = r8.getLayoutResult()
            r0 = 1
            if (r8 == 0) goto L2e
            androidx.compose.ui.text.TextLayoutResult r8 = r8.getValue()
            if (r8 == 0) goto L2e
            boolean r8 = androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt.access$isBiDiBoundary(r8, r11)
            if (r8 != r0) goto L2e
            goto L4d
        L2e:
            r8 = r10
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            long r2 = androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt.access$rangeOfWhitespaces(r8, r11)
            boolean r8 = androidx.compose.ui.text.TextRange.m6429getCollapsedimpl(r2)
            if (r8 == 0) goto L45
            int r8 = androidx.compose.ui.text.TextRange.m6435getStartimpl(r2)
            java.lang.String r9 = " "
            r7.performInsertionOnLegacyTextField(r8, r9, r12)
            goto L4c
        L45:
            r5 = 0
            r1 = r7
            r4 = r10
            r6 = r12
            r1.m1556performDeletionOnLegacyTextFieldvJH6DeI(r2, r4, r5, r6)
        L4c:
            return r0
        L4d:
            r1 = r7
            r6 = r12
            android.view.inputmethod.HandwritingGesture r7 = androidx.compose.material3.internal.Listener$$ExternalSyntheticApiModelOutline0.m3015m(r9)
            int r7 = r1.fallbackOnLegacyTextField(r7, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34.performJoinOrSplitGesture(androidx.compose.foundation.text.LegacyTextFieldState, android.view.inputmethod.JoinOrSplitGesture, androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.platform.ViewConfiguration, kotlin.jvm.functions.Function1):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        if (r3 == true) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int performInsertGesture(androidx.compose.foundation.text.LegacyTextFieldState r3, android.view.inputmethod.InsertGesture r4, androidx.compose.ui.platform.ViewConfiguration r5, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.EditCommand, kotlin.Unit> r6) {
        /*
            r2 = this;
            if (r5 != 0) goto Lb
            android.view.inputmethod.HandwritingGesture r3 = androidx.compose.material3.internal.Listener$$ExternalSyntheticApiModelOutline0.m3015m(r4)
            int r2 = r2.fallbackOnLegacyTextField(r3, r6)
            return r2
        Lb:
            android.graphics.PointF r0 = androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0.m(r4)
            long r0 = androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt.access$toOffset(r0)
            int r5 = androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt.m1560access$getOffsetForHandwritingGestured4ec7I(r3, r0, r5)
            r0 = -1
            if (r5 == r0) goto L36
            androidx.compose.foundation.text.TextLayoutResultProxy r3 = r3.getLayoutResult()
            r0 = 1
            if (r3 == 0) goto L2e
            androidx.compose.ui.text.TextLayoutResult r3 = r3.getValue()
            if (r3 == 0) goto L2e
            boolean r3 = androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt.access$isBiDiBoundary(r3, r5)
            if (r3 != r0) goto L2e
            goto L36
        L2e:
            java.lang.String r3 = androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0.m10m(r4)
            r2.performInsertionOnLegacyTextField(r5, r3, r6)
            return r0
        L36:
            android.view.inputmethod.HandwritingGesture r3 = androidx.compose.material3.internal.Listener$$ExternalSyntheticApiModelOutline0.m3015m(r4)
            int r2 = r2.fallbackOnLegacyTextField(r3, r6)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34.performInsertGesture(androidx.compose.foundation.text.LegacyTextFieldState, android.view.inputmethod.InsertGesture, androidx.compose.ui.platform.ViewConfiguration, kotlin.jvm.functions.Function1):int");
    }

    private final int performRemoveSpaceGesture(LegacyTextFieldState legacyTextFieldState, RemoveSpaceGesture removeSpaceGesture, AnnotatedString annotatedString, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        PointF startPoint;
        long offset;
        PointF endPoint;
        long offset2;
        long m1573getRangeForRemoveSpaceGesture5iVPX68;
        EditCommand compoundEditCommand;
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
        startPoint = removeSpaceGesture.getStartPoint();
        offset = HandwritingGesture_androidKt.toOffset(startPoint);
        endPoint = removeSpaceGesture.getEndPoint();
        offset2 = HandwritingGesture_androidKt.toOffset(endPoint);
        m1573getRangeForRemoveSpaceGesture5iVPX68 = HandwritingGesture_androidKt.m1573getRangeForRemoveSpaceGesture5iVPX68(value, offset, offset2, legacyTextFieldState.getLayoutCoordinates(), viewConfiguration);
        if (TextRange.m6429getCollapsedimpl(m1573getRangeForRemoveSpaceGesture5iVPX68)) {
            return INSTANCE.fallbackOnLegacyTextField(Listener$$ExternalSyntheticApiModelOutline0.m3015m((Object) removeSpaceGesture), function1);
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = -1;
        String replace = new Regex("\\s+").replace(TextRangeKt.m6442substringFDrldGo(annotatedString, m1573getRangeForRemoveSpaceGesture5iVPX68), new Function1<MatchResult, CharSequence>() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$performRemoveSpaceGesture$newText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult matchResult) {
                if (Ref.IntRef.this.element == -1) {
                    Ref.IntRef.this.element = matchResult.getRange().getFirst();
                }
                intRef2.element = matchResult.getRange().getLast() + 1;
                return "";
            }
        });
        if (intRef.element == -1 || intRef2.element == -1) {
            return fallbackOnLegacyTextField(Listener$$ExternalSyntheticApiModelOutline0.m3015m((Object) removeSpaceGesture), function1);
        }
        int m6435getStartimpl = TextRange.m6435getStartimpl(m1573getRangeForRemoveSpaceGesture5iVPX68) + intRef.element;
        int m6435getStartimpl2 = TextRange.m6435getStartimpl(m1573getRangeForRemoveSpaceGesture5iVPX68) + intRef2.element;
        String substring = replace.substring(intRef.element, replace.length() - (TextRange.m6431getLengthimpl(m1573getRangeForRemoveSpaceGesture5iVPX68) - intRef2.element));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        compoundEditCommand = HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(m6435getStartimpl, m6435getStartimpl2), new CommitTextCommand(substring, 1));
        function1.invoke(compoundEditCommand);
        return 1;
    }

    private final void performInsertionOnLegacyTextField(int offset, String text, Function1<? super EditCommand, Unit> editCommandConsumer) {
        EditCommand compoundEditCommand;
        compoundEditCommand = HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(offset, offset), new CommitTextCommand(text, 1));
        editCommandConsumer.invoke(compoundEditCommand);
    }

    /* renamed from: performSelectionOnLegacyTextField-8ffj60Q, reason: not valid java name */
    private final void m1557performSelectionOnLegacyTextField8ffj60Q(long range, TextFieldSelectionManager textSelectionManager, Function1<? super EditCommand, Unit> editCommandConsumer) {
        editCommandConsumer.invoke(new SetSelectionCommand(TextRange.m6435getStartimpl(range), TextRange.m6430getEndimpl(range)));
        if (textSelectionManager != null) {
            textSelectionManager.enterSelectionMode$foundation_release(true);
        }
    }

    /* renamed from: performDeletionOnLegacyTextField-vJH6DeI, reason: not valid java name */
    private final void m1556performDeletionOnLegacyTextFieldvJH6DeI(long range, AnnotatedString text, boolean adjustRange, Function1<? super EditCommand, Unit> editCommandConsumer) {
        EditCommand compoundEditCommand;
        if (adjustRange) {
            range = HandwritingGesture_androidKt.m1567adjustHandwritingDeleteGestureRange72CqOWE(range, text);
        }
        compoundEditCommand = HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(TextRange.m6430getEndimpl(range), TextRange.m6430getEndimpl(range)), new DeleteSurroundingTextCommand(TextRange.m6431getLengthimpl(range), 0));
        editCommandConsumer.invoke(compoundEditCommand);
    }

    private final int fallbackOnLegacyTextField(HandwritingGesture gesture, Function1<? super EditCommand, Unit> editCommandConsumer) {
        String fallbackText;
        fallbackText = gesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        editCommandConsumer.invoke(new CommitTextCommand(fallbackText, 1));
        return 5;
    }

    /* renamed from: toTextGranularity-NUwxegE, reason: not valid java name */
    private final int m1558toTextGranularityNUwxegE(int i) {
        if (i == 1) {
            return TextGranularity.INSTANCE.m6398getWordDRrd7Zo();
        }
        if (i == 2) {
            return TextGranularity.INSTANCE.m6397getCharacterDRrd7Zo();
        }
        return TextGranularity.INSTANCE.m6397getCharacterDRrd7Zo();
    }

    private final int fallback(TransformedTextFieldState transformedTextFieldState, HandwritingGesture handwritingGesture) {
        String fallbackText;
        TextFieldState textFieldState = transformedTextFieldState.textFieldState;
        InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
        mainBuffer.clearHighlight$foundation_release();
        transformedTextFieldState.updateWedgeAffinity(mainBuffer);
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
        fallbackText = handwritingGesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        TransformedTextFieldState.replaceSelectedText$default(transformedTextFieldState, fallbackText, true, null, false, 12, null);
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void previewHandwritingGesture$lambda$1(TransformedTextFieldState transformedTextFieldState) {
        TextFieldState textFieldState = transformedTextFieldState.textFieldState;
        InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
        mainBuffer.clearHighlight$foundation_release();
        transformedTextFieldState.updateWedgeAffinity(mainBuffer);
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
    }
}
