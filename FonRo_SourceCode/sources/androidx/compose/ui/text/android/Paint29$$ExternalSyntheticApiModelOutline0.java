package androidx.compose.ui.text.android;

import android.content.res.AssetManager;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.graphics.text.LineBreakConfig;
import android.text.BoringLayout;
import android.text.GraphemeClusterSegmentFinder;
import android.text.Layout;
import android.text.SegmentFinder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import android.view.ScrollCaptureTarget;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import android.view.translation.ViewTranslationCallback;
import java.io.File;
import java.io.FileDescriptor;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes4.dex */
public final /* synthetic */ class Paint29$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ Typeface.Builder m(AssetManager assetManager, String str) {
        return new Typeface.Builder(assetManager, str);
    }

    public static /* synthetic */ Typeface.Builder m(File file) {
        return new Typeface.Builder(file);
    }

    public static /* synthetic */ Typeface.Builder m(FileDescriptor fileDescriptor) {
        return new Typeface.Builder(fileDescriptor);
    }

    public static /* synthetic */ FontVariationAxis m(String str, float f) {
        return new FontVariationAxis(str, f);
    }

    public static /* synthetic */ LineBreakConfig.Builder m() {
        return new LineBreakConfig.Builder();
    }

    public static /* synthetic */ BoringLayout m(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, BoringLayout.Metrics metrics, boolean z, TextUtils.TruncateAt truncateAt, int i2, boolean z2) {
        return new BoringLayout(charSequence, textPaint, i, alignment, f, f2, metrics, z, truncateAt, i2, z2);
    }

    public static /* synthetic */ GraphemeClusterSegmentFinder m(CharSequence charSequence, TextPaint textPaint) {
        return new GraphemeClusterSegmentFinder(charSequence, textPaint);
    }

    public static /* bridge */ /* synthetic */ SegmentFinder m(Object obj) {
        return (SegmentFinder) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ DisplayCutout m6483m(Object obj) {
        return (DisplayCutout) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ScrollCaptureCallback m6484m(Object obj) {
        return (ScrollCaptureCallback) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ScrollCaptureSession m6485m(Object obj) {
        return (ScrollCaptureSession) obj;
    }

    public static /* synthetic */ ScrollCaptureTarget m(View view, Rect rect, Point point, ScrollCaptureCallback scrollCaptureCallback) {
        return new ScrollCaptureTarget(view, rect, point, scrollCaptureCallback);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AutofillId m6486m(Object obj) {
        return (AutofillId) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ContentCaptureSession m6487m(Object obj) {
        return (ContentCaptureSession) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ViewTranslationCallback m6488m(Object obj) {
        return (ViewTranslationCallback) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m6489m() {
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m6491m(Object obj) {
        return obj instanceof DisplayCutout;
    }

    public static /* synthetic */ void m$1() {
    }

    public static /* synthetic */ void m$2() {
    }
}
