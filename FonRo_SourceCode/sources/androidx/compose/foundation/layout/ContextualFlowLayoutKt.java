package androidx.compose.foundation.layout;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* compiled from: ContextualFlowLayout.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u008e\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f21\u0010\u0010\u001a-\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a\u008e\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u001d21\u0010\u0010\u001a-\u0012\u0004\u0012\u00020\u001e\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u001f\u001a\u00ad\u0001\u0010 \u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010'\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010)¢\u0006\u0002\b\u00160(2;\u0010*\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010-\u001a\u00ad\u0001\u0010.\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010'\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010)¢\u0006\u0002\b\u00160(2;\u0010*\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010/¨\u00060"}, d2 = {"ContextualFlowColumn", "", "itemCount", "", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "itemHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "maxItemsInEachColumn", "maxLines", "overflow", "Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/ContextualFlowColumnScope;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/ContextualFlowColumnOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "ContextualFlowRow", "itemVerticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "maxItemsInEachRow", "Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "Landroidx/compose/foundation/layout/ContextualFlowRowScope;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/ContextualFlowRowOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "contextualColumnMeasureHelper", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "maxItemsInMainAxis", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflowComposables", "", "Lkotlin/Function0;", "getComposable", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "contextualRowMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "foundation-layout_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ContextualFlowLayoutKt {
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01ca, code lost:
    
        if (r6 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L144;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00eb  */
    @kotlin.Deprecated(message = "ContextualFlowLayouts are no longer maintained")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ContextualFlowRow(final int r24, androidx.compose.ui.Modifier r25, androidx.compose.foundation.layout.Arrangement.Horizontal r26, androidx.compose.foundation.layout.Arrangement.Vertical r27, androidx.compose.ui.Alignment.Vertical r28, int r29, int r30, androidx.compose.foundation.layout.ContextualFlowRowOverflow r31, final kotlin.jvm.functions.Function4<? super androidx.compose.foundation.layout.ContextualFlowRowScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow(int, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, int, int, androidx.compose.foundation.layout.ContextualFlowRowOverflow, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x01ca, code lost:
    
        if (r6 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L144;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00eb  */
    @kotlin.Deprecated(message = "ContextualFlowLayouts are no longer maintained")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ContextualFlowColumn(final int r24, androidx.compose.ui.Modifier r25, androidx.compose.foundation.layout.Arrangement.Vertical r26, androidx.compose.foundation.layout.Arrangement.Horizontal r27, androidx.compose.ui.Alignment.Horizontal r28, int r29, int r30, androidx.compose.foundation.layout.ContextualFlowColumnOverflow r31, final kotlin.jvm.functions.Function4<? super androidx.compose.foundation.layout.ContextualFlowColumnScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn(int, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Horizontal, int, int, androidx.compose.foundation.layout.ContextualFlowColumnOverflow, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0077, code lost:
    
        if (r30.changed(r4) == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cf, code lost:
    
        if (r30.changed(r29) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d7, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d8, code lost:
    
        r2 = r3 | r5;
        r3 = r30.rememberedValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00de, code lost:
    
        if (r2 != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e6, code lost:
    
        if (r3 != androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010d, code lost:
    
        r3 = (kotlin.jvm.functions.Function2) r3;
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0116, code lost:
    
        if (androidx.compose.runtime.ComposerKt.isTraceInProgress() == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0118, code lost:
    
        androidx.compose.runtime.ComposerKt.traceEventEnd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x011b, code lost:
    
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x011e, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e8, code lost:
    
        r3 = new androidx.compose.foundation.layout.FlowMeasureLazyPolicy(true, r21, r22, r21.getSpacing(), androidx.compose.foundation.layout.CrossAxisAlignment.INSTANCE.vertical$foundation_layout_release(r23), r22.getSpacing(), r27, r25, r4, r26, r28, r29, null).getMeasurePolicy();
        r30.updateRememberedValue(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d5, code lost:
    
        if ((r31 & 100663296) != 67108864) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.jvm.functions.Function2<androidx.compose.ui.layout.SubcomposeMeasureScope, androidx.compose.ui.unit.Constraints, androidx.compose.ui.layout.MeasureResult> contextualRowMeasurementHelper(androidx.compose.foundation.layout.Arrangement.Horizontal r21, androidx.compose.foundation.layout.Arrangement.Vertical r22, androidx.compose.ui.Alignment.Vertical r23, int r24, int r25, androidx.compose.foundation.layout.FlowLayoutOverflowState r26, int r27, java.util.List<? extends kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>> r28, kotlin.jvm.functions.Function4<? super java.lang.Integer, ? super androidx.compose.foundation.layout.FlowLineInfo, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.ContextualFlowLayoutKt.contextualRowMeasurementHelper(androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, int, int, androidx.compose.foundation.layout.FlowLayoutOverflowState, int, java.util.List, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int):kotlin.jvm.functions.Function2");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0077, code lost:
    
        if (r30.changed(r4) == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cf, code lost:
    
        if (r30.changed(r29) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d7, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d8, code lost:
    
        r2 = r3 | r5;
        r3 = r30.rememberedValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00de, code lost:
    
        if (r2 != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e6, code lost:
    
        if (r3 != androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010d, code lost:
    
        r3 = (kotlin.jvm.functions.Function2) r3;
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0116, code lost:
    
        if (androidx.compose.runtime.ComposerKt.isTraceInProgress() == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0118, code lost:
    
        androidx.compose.runtime.ComposerKt.traceEventEnd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x011b, code lost:
    
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x011e, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e8, code lost:
    
        r3 = new androidx.compose.foundation.layout.FlowMeasureLazyPolicy(false, r22, r21, r21.getSpacing(), androidx.compose.foundation.layout.CrossAxisAlignment.INSTANCE.horizontal$foundation_layout_release(r23), r22.getSpacing(), r27, r25, r4, r26, r28, r29, null).getMeasurePolicy();
        r30.updateRememberedValue(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d5, code lost:
    
        if ((r31 & 100663296) != 67108864) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.jvm.functions.Function2<androidx.compose.ui.layout.SubcomposeMeasureScope, androidx.compose.ui.unit.Constraints, androidx.compose.ui.layout.MeasureResult> contextualColumnMeasureHelper(androidx.compose.foundation.layout.Arrangement.Vertical r21, androidx.compose.foundation.layout.Arrangement.Horizontal r22, androidx.compose.ui.Alignment.Horizontal r23, int r24, int r25, androidx.compose.foundation.layout.FlowLayoutOverflowState r26, int r27, java.util.List<? extends kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>> r28, kotlin.jvm.functions.Function4<? super java.lang.Integer, ? super androidx.compose.foundation.layout.FlowLineInfo, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.ContextualFlowLayoutKt.contextualColumnMeasureHelper(androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Horizontal, int, int, androidx.compose.foundation.layout.FlowLayoutOverflowState, int, java.util.List, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int):kotlin.jvm.functions.Function2");
    }
}
