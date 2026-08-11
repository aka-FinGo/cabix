package uz.FonRo.pos.print;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import uz.FonRo.pos.core.BarcodeKind;
import uz.FonRo.pos.core.Barcodes;

/* compiled from: LabelSheet.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ4\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\tJ\u001e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002JR\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020 2\b\b\u0002\u0010&\u001a\u00020\tH\u0002J.\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00132\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)2\u0006\u0010\"\u001a\u00020 2\u0006\u0010&\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b+\u0012\b\b,\u0012\u0004\b\u0003\u0010\u0002¨\u0006*"}, d2 = {"Luz/FonRo/pos/print/LabelSheet;", "", "<init>", "()V", "FONT", "Landroid/graphics/Typeface;", "FONT_BOLD", "MONO", "pageCount", "", "labels", "layout", "Luz/FonRo/pos/print/LabelLayout;", "drawPage", "", "canvas", "Landroid/graphics/Canvas;", FirebaseAnalytics.Param.CONTENT, "Landroid/graphics/Rect;", "", "Luz/FonRo/pos/print/LabelDoc;", "pageIndex", "drawLabel", "area", "Landroid/graphics/RectF;", "doc", "spaced", "", "code", "drawFitted", "text", "left", "", "top", "width", "height", OptionalModuleUtils.FACE, "fill", "maxLines", "wrapToWidth", "paint", "Landroid/graphics/Paint;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class LabelSheet {
    public static final int $stable = 0;
    private static final Typeface FONT;
    private static final Typeface FONT_BOLD;
    public static final LabelSheet INSTANCE = new LabelSheet();
    private static final Typeface MONO;

    private LabelSheet() {
    }

    static {
        Typeface SANS_SERIF = Typeface.SANS_SERIF;
        Intrinsics.checkNotNullExpressionValue(SANS_SERIF, "SANS_SERIF");
        FONT = SANS_SERIF;
        Typeface create = Typeface.create(Typeface.SANS_SERIF, 1);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        FONT_BOLD = create;
        Typeface MONOSPACE = Typeface.MONOSPACE;
        Intrinsics.checkNotNullExpressionValue(MONOSPACE, "MONOSPACE");
        MONO = MONOSPACE;
    }

    public final int pageCount(int labels, LabelLayout layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        if (labels <= 0) {
            return 1;
        }
        int perPage = layout.getPerPage();
        return RangesKt.coerceAtLeast(((labels + perPage) - 1) / perPage, 1);
    }

    public final void drawPage(Canvas canvas, Rect content, List<LabelDoc> labels, LabelLayout layout, int pageIndex) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(labels, "labels");
        Intrinsics.checkNotNullParameter(layout, "layout");
        float width = content.width() / 210.0f;
        int perPage = layout.getPerPage();
        int i = pageIndex * perPage;
        for (int i2 = 0; i2 < perPage; i2++) {
            LabelDoc labelDoc = (LabelDoc) CollectionsKt.getOrNull(labels, i + i2);
            if (labelDoc == null) {
                return;
            }
            int cols = i2 / layout.getCols();
            float left = content.left + ((layout.getLeft() + ((i2 % layout.getCols()) * (layout.getW() + layout.getGapX()))) * width);
            float top = content.top + ((layout.getTop() + (cols * (layout.getH() + layout.getGapY()))) * width);
            drawLabel(canvas, new RectF(left, top, (layout.getW() * width) + left, (layout.getH() * width) + top), labelDoc);
        }
    }

    public final void drawLabel(Canvas canvas, RectF area, LabelDoc doc) {
        float f;
        String str;
        BarcodeKind barcodeKind;
        Canvas canvas2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(doc, "doc");
        float width = area.width() * 0.06f;
        float height = area.height() * 0.06f;
        RectF rectF = new RectF(area.left + width, area.top + height, area.right - width, area.bottom - height);
        if (rectF.width() <= 1.0f || rectF.height() <= 1.0f) {
            return;
        }
        String obj = StringsKt.trim((CharSequence) doc.getStoreName()).toString();
        String obj2 = StringsKt.trim((CharSequence) doc.getTitle()).toString();
        String obj3 = StringsKt.trim((CharSequence) doc.getPrice()).toString();
        String obj4 = StringsKt.trim((CharSequence) doc.getCode()).toString();
        BarcodeKind kindOf = Barcodes.INSTANCE.kindOf(obj4);
        float f2 = obj.length() == 0 ? 0.0f : 0.11f;
        float f3 = obj2.length() == 0 ? 0.0f : 0.24f;
        float f4 = obj3.length() == 0 ? 0.0f : 0.22f;
        float f5 = (obj4.length() != 0 && doc.getShowDigits()) ? 0.13f : 0.0f;
        float f6 = (((1.0f - f2) - f3) - f4) - f5;
        if (kindOf == BarcodeKind.NONE) {
            float f7 = f6 * 0.5f;
            f3 += f7;
            f4 += f7;
            f6 = 0.0f;
        }
        float f8 = f4;
        if (f6 >= 0.18f || kindOf == BarcodeKind.NONE) {
            f = f6;
        } else {
            f3 = RangesKt.coerceAtLeast(f3 - (0.18f - f6), 0.1f);
            f = 0.18f;
            f2 = 0.0f;
        }
        float f9 = f3;
        float f10 = rectF.top;
        float height2 = rectF.height();
        if (f2 > 0.0f) {
            float f11 = f2 * height2;
            str = obj2;
            barcodeKind = kindOf;
            drawFitted$default(this, canvas, obj, rectF.left, f10, rectF.width(), f11, FONT, 0.72f, 0, 256, null);
            f10 += f11;
        } else {
            str = obj2;
            barcodeKind = kindOf;
        }
        if (f9 > 0.0f) {
            float f12 = height2 * f9;
            canvas2 = canvas;
            drawFitted(canvas2, str, rectF.left, f10, rectF.width(), f12, FONT_BOLD, 1.0f, 2);
            f10 += f12;
        } else {
            canvas2 = canvas;
        }
        if (f > 0.0f) {
            float f13 = f * height2;
            int coerceAtLeast = RangesKt.coerceAtLeast((int) (0.86f * f13), 8);
            int coerceAtLeast2 = RangesKt.coerceAtLeast((int) rectF.width(), 8);
            Bitmap barcodeBitmap = ReceiptPrinterKt.barcodeBitmap(obj4, barcodeKind, coerceAtLeast2, coerceAtLeast);
            if (barcodeBitmap != null) {
                canvas2.drawBitmap(barcodeBitmap, (Rect) null, new RectF(rectF.left, f10, rectF.left + coerceAtLeast2, coerceAtLeast + f10), (Paint) null);
                barcodeBitmap.recycle();
            }
            f10 += f13;
        }
        if (f5 > 0.0f) {
            float f14 = height2 * f5;
            drawFitted$default(this, canvas2, spaced(obj4), rectF.left, f10, rectF.width(), f14, MONO, 0.9f, 0, 256, null);
            f10 += f14;
        }
        if (f8 > 0.0f) {
            drawFitted$default(this, canvas, obj3, rectF.left, f10, rectF.width(), height2 * f8, FONT_BOLD, 1.0f, 0, 256, null);
        }
    }

    private final String spaced(String code) {
        if (code.length() > 20) {
            return code;
        }
        char[] charArray = code.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        return ArraysKt.joinToString$default(charArray, (CharSequence) " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    static /* synthetic */ void drawFitted$default(LabelSheet labelSheet, Canvas canvas, String str, float f, float f2, float f3, float f4, Typeface typeface, float f5, int i, int i2, Object obj) {
        labelSheet.drawFitted(canvas, str, f, f2, f3, f4, typeface, f5, (i2 & 256) != 0 ? 1 : i);
    }

    private final void drawFitted(Canvas canvas, String text, float left, float top, float width, float height, Typeface face, float fill, int maxLines) {
        Float valueOf;
        if (text.length() != 0 && width > 0.0f && height > 0.0f) {
            Paint paint = new Paint(1);
            paint.setTypeface(face);
            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            paint.setTextAlign(Paint.Align.CENTER);
            List<String> listOf = CollectionsKt.listOf(text);
            int coerceAtLeast = RangesKt.coerceAtLeast(maxLines, 1);
            float f = 0.0f;
            if (1 <= coerceAtLeast) {
                int i = 1;
                while (true) {
                    float f2 = (height / i) * 0.82f * fill;
                    paint.setTextSize(f2);
                    List<String> listOf2 = i == 1 ? CollectionsKt.listOf(text) : wrapToWidth(text, paint, width, i);
                    if (listOf2.size() <= i) {
                        Iterator<T> it = listOf2.iterator();
                        if (it.hasNext()) {
                            float measureText = paint.measureText((String) it.next());
                            while (it.hasNext()) {
                                measureText = Math.max(measureText, paint.measureText((String) it.next()));
                            }
                            valueOf = Float.valueOf(measureText);
                        } else {
                            valueOf = null;
                        }
                        float floatValue = valueOf != null ? valueOf.floatValue() : 0.0f;
                        if (floatValue > width && floatValue > 0.0f) {
                            f2 = (f2 * width) / floatValue;
                        }
                        if (f2 > f) {
                            f = f2;
                            listOf = listOf2;
                        }
                    }
                    if (i == coerceAtLeast) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (f <= 0.0f) {
                return;
            }
            paint.setTextSize(f);
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float f3 = fontMetrics.descent - fontMetrics.ascent;
            float size = (top + ((height - (listOf.size() * f3)) / 2.0f)) - fontMetrics.ascent;
            Iterator<T> it2 = listOf.iterator();
            while (it2.hasNext()) {
                canvas.drawText((String) it2.next(), left + (width / 2.0f), size, paint);
                size += f3;
            }
        }
    }

    private final List<String> wrapToWidth(String text, Paint paint, float width, int maxLines) {
        List split$default = StringsKt.split$default((CharSequence) text, new char[]{' '}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return CollectionsKt.listOf(text);
        }
        ArrayList arrayList3 = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList2.get(i);
            StringBuilder sb2 = sb;
            String str2 = sb2.length() == 0 ? str : ((Object) sb) + " " + str;
            if (sb2.length() != 0 && paint.measureText(str2) > width) {
                ArrayList arrayList4 = arrayList3;
                arrayList4.add(sb.toString());
                if (arrayList3.size() == maxLines - 1) {
                    arrayList4.add(CollectionsKt.joinToString$default(arrayList2.subList(i, arrayList2.size()), " ", null, null, 0, null, null, 62, null));
                    return arrayList3;
                }
                sb = new StringBuilder(str);
            }
            sb = new StringBuilder(str2);
        }
        if (sb.length() > 0) {
            arrayList3.add(sb.toString());
        }
        return arrayList3;
    }
}
