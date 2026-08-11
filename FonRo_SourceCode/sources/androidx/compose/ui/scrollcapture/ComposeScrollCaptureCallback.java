package androidx.compose.ui.scrollcapture;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CancellationSignal;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import android.view.View;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.unit.IntRect;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.internal.view.SupportMenu;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.NonCancellable;
import uz.FonRo.pos.data.local.CacheStore;

/* compiled from: ComposeScrollCaptureCallback.android.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0001$B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J.\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001dH\u0016J\u001e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001dH\u0016J \u0010 \u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\f\u0010!\u001a\u00020\u0012*\u00020\"H\u0002J\f\u0010#\u001a\u00020\u0012*\u00020\"H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback;", "Landroid/view/ScrollCaptureCallback;", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "viewportBoundsInWindow", "Landroidx/compose/ui/unit/IntRect;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", "composeView", "Landroid/view/View;", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroidx/compose/ui/unit/IntRect;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;Landroid/view/View;)V", "requestCount", "", "scrollTracker", "Landroidx/compose/ui/scrollcapture/RelativeScroller;", "onScrollCaptureEnd", "", "onReady", "Ljava/lang/Runnable;", "onScrollCaptureImageRequest", CacheStore.SESSION, "Landroid/view/ScrollCaptureSession;", "signal", "Landroid/os/CancellationSignal;", "captureArea", "Landroid/graphics/Rect;", "onComplete", "Ljava/util/function/Consumer;", "(Landroid/view/ScrollCaptureSession;Landroidx/compose/ui/unit/IntRect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onScrollCaptureSearch", "onScrollCaptureStart", "drawDebugBackground", "Landroid/graphics/Canvas;", "drawDebugOverlay", "ScrollCaptureSessionListener", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class ComposeScrollCaptureCallback implements ScrollCaptureCallback {
    public static final int $stable = 8;
    private final View composeView;
    private final CoroutineScope coroutineScope;
    private final ScrollCaptureSessionListener listener;
    private final SemanticsNode node;
    private int requestCount;
    private final RelativeScroller scrollTracker;
    private final IntRect viewportBoundsInWindow;

    /* compiled from: ComposeScrollCaptureCallback.android.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", "", "onSessionEnded", "", "onSessionStarted", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public interface ScrollCaptureSessionListener {
        void onSessionEnded();

        void onSessionStarted();
    }

    public ComposeScrollCaptureCallback(SemanticsNode semanticsNode, IntRect intRect, CoroutineScope coroutineScope, ScrollCaptureSessionListener scrollCaptureSessionListener, View view) {
        this.node = semanticsNode;
        this.viewportBoundsInWindow = intRect;
        this.listener = scrollCaptureSessionListener;
        this.composeView = view;
        this.coroutineScope = CoroutineScopeKt.plus(coroutineScope, DisableAnimationMotionDurationScale.INSTANCE);
        this.scrollTracker = new RelativeScroller(intRect.getHeight(), new ComposeScrollCaptureCallback$scrollTracker$1(this, null));
    }

    public void onScrollCaptureSearch(CancellationSignal signal, Consumer<Rect> onReady) {
        onReady.accept(RectHelper_androidKt.toAndroidRect(this.viewportBoundsInWindow));
    }

    public void onScrollCaptureStart(ScrollCaptureSession session, CancellationSignal signal, Runnable onReady) {
        this.scrollTracker.reset();
        this.requestCount = 0;
        this.listener.onSessionStarted();
        onReady.run();
    }

    public void onScrollCaptureImageRequest(ScrollCaptureSession session, CancellationSignal signal, Rect captureArea, Consumer<Rect> onComplete) {
        ComposeScrollCaptureCallback_androidKt.launchWithCancellationSignal(this.coroutineScope, signal, new ComposeScrollCaptureCallback$onScrollCaptureImageRequest$1(this, session, captureArea, onComplete, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0082, code lost:
    
        if (r5.scrollRangeIntoView(r10, r2, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object onScrollCaptureImageRequest(android.view.ScrollCaptureSession r8, androidx.compose.ui.unit.IntRect r9, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.IntRect> r10) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.onScrollCaptureImageRequest(android.view.ScrollCaptureSession, androidx.compose.ui.unit.IntRect, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void onScrollCaptureEnd(Runnable onReady) {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, NonCancellable.INSTANCE, null, new ComposeScrollCaptureCallback$onScrollCaptureEnd$1(this, onReady, null), 2, null);
    }

    private final void drawDebugBackground(Canvas canvas) {
        canvas.drawColor(ColorKt.m4438toArgb8_81llA(Color.Companion.m4408hslJlNiLsg$default(Color.INSTANCE, 360.0f * Random.INSTANCE.nextFloat(), 0.75f, 0.5f, 1.0f, null, 16, null)));
    }

    private final void drawDebugOverlay(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setTextSize(48.0f);
        canvas.drawCircle(0.0f, 0.0f, 20.0f, paint);
        canvas.drawCircle(canvas.getWidth(), 0.0f, 20.0f, paint);
        canvas.drawCircle(canvas.getWidth(), canvas.getHeight(), 20.0f, paint);
        canvas.drawCircle(0.0f, canvas.getHeight(), 20.0f, paint);
        canvas.drawText(String.valueOf(this.requestCount), canvas.getWidth() / 2.0f, canvas.getHeight() / 2.0f, paint);
        this.requestCount++;
    }
}
