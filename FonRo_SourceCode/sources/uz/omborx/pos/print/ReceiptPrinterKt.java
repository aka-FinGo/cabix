package uz.FonRo.pos.print;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import uz.FonRo.pos.core.BarcodeKind;
import uz.FonRo.pos.print.EscPos;
import uz.FonRo.pos.print.ReceiptBlock;

/* compiled from: ReceiptPrinter.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0000\u001a*\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0000\u001a\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\tH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"MONO", "Landroid/graphics/Typeface;", "MONO_BOLD", "renderBitmap", "Landroid/graphics/Bitmap;", "blocks", "", "Luz/FonRo/pos/print/ReceiptBlock;", "widthMm", "", "barcodeBitmap", "code", "", "kind", "Luz/FonRo/pos/core/BarcodeKind;", "width", "height", "qrBitmap", "text", "size", "app"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class ReceiptPrinterKt {
    private static final Typeface MONO;
    private static final Typeface MONO_BOLD;

    /* compiled from: ReceiptPrinter.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[EscPos.Align.values().length];
            try {
                iArr[EscPos.Align.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EscPos.Align.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EscPos.Align.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BarcodeKind.values().length];
            try {
                iArr2[BarcodeKind.EAN13.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[BarcodeKind.EAN8.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[BarcodeKind.CODE128.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[BarcodeKind.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static {
        Typeface MONOSPACE = Typeface.MONOSPACE;
        Intrinsics.checkNotNullExpressionValue(MONOSPACE, "MONOSPACE");
        MONO = MONOSPACE;
        Typeface create = Typeface.create(Typeface.MONOSPACE, 1);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        MONO_BOLD = create;
    }

    public static final Bitmap renderBitmap(List<? extends ReceiptBlock> blocks, int i) {
        Iterator it;
        float renderBitmap$heightOf;
        ReceiptBlock.Text text;
        Paint paint;
        Paint.Align align;
        float f;
        float lines;
        Intrinsics.checkNotNullParameter(blocks, "blocks");
        int dotsFor = EscPos.INSTANCE.dotsFor(i);
        int coerceAtLeast = RangesKt.coerceAtLeast(dotsFor - 24, 32);
        int charsFor = EscPos.INSTANCE.charsFor(i);
        int i2 = 1;
        Paint paint2 = new Paint(1);
        paint2.setTypeface(MONO);
        int i3 = ViewCompat.MEASURED_STATE_MASK;
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint2.setTextSize(24.0f);
        Float valueOf = Float.valueOf(paint2.measureText("0"));
        if (valueOf.floatValue() <= 0.0f) {
            valueOf = null;
        }
        float f2 = coerceAtLeast;
        paint2.setTextSize((24.0f * f2) / ((valueOf != null ? valueOf.floatValue() : 12.0f) * charsFor));
        int coerceAtMost = RangesKt.coerceAtMost(RangesKt.coerceAtLeast((int) (f2 * 0.62f), 96), coerceAtLeast);
        float textSize = paint2.getTextSize() * 0.4f;
        List<? extends ReceiptBlock> list = blocks;
        float f3 = 12.0f;
        for (ReceiptBlock receiptBlock : list) {
            if (receiptBlock instanceof ReceiptBlock.Text) {
                lines = renderBitmap$heightOf(renderBitmap$paintFor(paint2, (ReceiptBlock.Text) receiptBlock));
            } else if (receiptBlock instanceof ReceiptBlock.Qr) {
                lines = coerceAtMost + textSize;
            } else if (receiptBlock instanceof ReceiptBlock.Barcode) {
                lines = renderBitmap$barcodeHeightOf(textSize, paint2, (ReceiptBlock.Barcode) receiptBlock);
            } else {
                if (!(receiptBlock instanceof ReceiptBlock.Gap)) {
                    throw new NoWhenBranchMatchedException();
                }
                lines = ((ReceiptBlock.Gap) receiptBlock).getLines() * renderBitmap$heightOf(paint2);
            }
            f3 += lines;
        }
        Bitmap createBitmap = Bitmap.createBitmap(dotsFor, RangesKt.coerceAtLeast((int) (f3 + 12.0f), 1), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        int i4 = -1;
        canvas.drawColor(-1);
        Iterator it2 = list.iterator();
        float f4 = 12.0f;
        while (it2.hasNext()) {
            ReceiptBlock receiptBlock2 = (ReceiptBlock) it2.next();
            if (receiptBlock2 instanceof ReceiptBlock.Text) {
                ReceiptBlock.Text text2 = (ReceiptBlock.Text) receiptBlock2;
                Paint renderBitmap$paintFor = renderBitmap$paintFor(paint2, text2);
                float renderBitmap$heightOf2 = renderBitmap$heightOf(renderBitmap$paintFor);
                if (text2.getInvert()) {
                    Paint paint3 = new Paint();
                    paint3.setColor(i3);
                    text = text2;
                    paint = renderBitmap$paintFor;
                    canvas.drawRect(0.0f, f4, dotsFor, f4 + renderBitmap$heightOf2, paint3);
                    paint.setColor(i4);
                } else {
                    text = text2;
                    paint = renderBitmap$paintFor;
                }
                int i5 = WhenMappings.$EnumSwitchMapping$0[text.getAlign().ordinal()];
                if (i5 == i2) {
                    align = Paint.Align.LEFT;
                } else if (i5 == 2) {
                    align = Paint.Align.CENTER;
                } else {
                    if (i5 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    align = Paint.Align.RIGHT;
                }
                paint.setTextAlign(align);
                int i6 = WhenMappings.$EnumSwitchMapping$0[text.getAlign().ordinal()];
                if (i6 == i2) {
                    f = 12.0f;
                } else if (i6 == 2) {
                    f = dotsFor / 2.0f;
                } else {
                    if (i6 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    f = dotsFor - 12;
                }
                canvas.drawText(EscPos.INSTANCE.printable(text.getText()), f, f4 - paint.getFontMetrics().ascent, paint);
                f4 += renderBitmap$heightOf2;
            } else if (receiptBlock2 instanceof ReceiptBlock.Qr) {
                Bitmap qrBitmap = qrBitmap(((ReceiptBlock.Qr) receiptBlock2).getData(), coerceAtMost);
                if (qrBitmap != null) {
                    int i7 = (dotsFor - coerceAtMost) / 2;
                    int i8 = (int) f4;
                    canvas.drawBitmap(qrBitmap, (Rect) null, new Rect(i7, i8, i7 + coerceAtMost, i8 + coerceAtMost), (Paint) null);
                    qrBitmap.recycle();
                }
                f4 += coerceAtMost + textSize;
            } else {
                if (receiptBlock2 instanceof ReceiptBlock.Barcode) {
                    ReceiptBlock.Barcode barcode = (ReceiptBlock.Barcode) receiptBlock2;
                    int heightDots = barcode.getHeightDots();
                    Bitmap barcodeBitmap = barcodeBitmap(barcode.getData(), barcode.getKind(), coerceAtLeast, heightDots);
                    if (barcodeBitmap != null) {
                        int i9 = (dotsFor - coerceAtLeast) / 2;
                        int i10 = (int) f4;
                        it = it2;
                        canvas.drawBitmap(barcodeBitmap, (Rect) null, new Rect(i9, i10, i9 + coerceAtLeast, i10 + heightDots), (Paint) null);
                        barcodeBitmap.recycle();
                    } else {
                        it = it2;
                    }
                    if (barcode.getDigitsBelow()) {
                        Paint paint4 = new Paint(paint2);
                        paint4.setTextAlign(Paint.Align.CENTER);
                        paint4.setLetterSpacing(0.18f);
                        canvas.drawText(EscPos.INSTANCE.printable(barcode.getData()), dotsFor / 2.0f, ((heightDots + f4) + textSize) - paint4.getFontMetrics().ascent, paint4);
                    }
                    renderBitmap$heightOf = renderBitmap$barcodeHeightOf(textSize, paint2, barcode);
                } else {
                    it = it2;
                    if (!(receiptBlock2 instanceof ReceiptBlock.Gap)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    renderBitmap$heightOf = renderBitmap$heightOf(paint2) * ((ReceiptBlock.Gap) receiptBlock2).getLines();
                }
                f4 += renderBitmap$heightOf;
                it2 = it;
                i2 = 1;
                i3 = ViewCompat.MEASURED_STATE_MASK;
                i4 = -1;
            }
            it = it2;
            it2 = it;
            i2 = 1;
            i3 = ViewCompat.MEASURED_STATE_MASK;
            i4 = -1;
        }
        return createBitmap;
    }

    private static final float renderBitmap$barcodeHeightOf(float f, Paint paint, ReceiptBlock.Barcode barcode) {
        return barcode.getHeightDots() + f + (paint.getTextSize() * (barcode.getDigitsBelow() ? 1.1f : 0.0f));
    }

    private static final Paint renderBitmap$paintFor(Paint paint, ReceiptBlock.Text text) {
        Paint paint2 = new Paint(paint);
        paint2.setTypeface(text.getBold() ? MONO_BOLD : MONO);
        if (text.getDoubleHeight()) {
            paint2.setTextSize(paint.getTextSize() * 2.0f);
            paint2.setTextScaleX(text.getDoubleWidth() ? 1.0f : 0.5f);
            return paint2;
        }
        paint2.setTextScaleX(text.getDoubleWidth() ? 2.0f : 1.0f);
        return paint2;
    }

    private static final float renderBitmap$heightOf(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (fontMetrics.descent - fontMetrics.ascent) * 1.12f;
    }

    public static final Bitmap barcodeBitmap(String code, BarcodeKind kind, int i, int i2) {
        BarcodeFormat barcodeFormat;
        Object m7870constructorimpl;
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (StringsKt.isBlank(code) || i <= 0 || i2 <= 0) {
            return null;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[kind.ordinal()];
        if (i3 == 1) {
            barcodeFormat = BarcodeFormat.EAN_13;
        } else if (i3 == 2) {
            barcodeFormat = BarcodeFormat.EAN_8;
        } else {
            if (i3 != 3) {
                if (i3 == 4) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            barcodeFormat = BarcodeFormat.CODE_128;
        }
        BarcodeFormat barcodeFormat2 = barcodeFormat;
        try {
            Result.Companion companion = Result.INSTANCE;
            BitMatrix encode = new MultiFormatWriter().encode(StringsKt.trim((CharSequence) code).toString(), barcodeFormat2, i, i2, MapsKt.mapOf(TuplesKt.to(EncodeHintType.MARGIN, 0)));
            int width = encode.getWidth();
            int height = encode.getHeight();
            int[] iArr = new int[width * height];
            for (int i4 = 0; i4 < height; i4++) {
                int i5 = i4 * width;
                for (int i6 = 0; i6 < width; i6++) {
                    iArr[i5 + i6] = encode.get(i6, i4) ? ViewCompat.MEASURED_STATE_MASK : -1;
                }
            }
            m7870constructorimpl = Result.m7870constructorimpl(Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        return (Bitmap) (Result.m7876isFailureimpl(m7870constructorimpl) ? null : m7870constructorimpl);
    }

    public static final Bitmap qrBitmap(String text, int i) {
        Object m7870constructorimpl;
        Intrinsics.checkNotNullParameter(text, "text");
        if (StringsKt.isBlank(text) || i <= 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            BitMatrix encode = new QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, i, i, MapsKt.mapOf(TuplesKt.to(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M), TuplesKt.to(EncodeHintType.MARGIN, 1), TuplesKt.to(EncodeHintType.CHARACTER_SET, "UTF-8")));
            int width = encode.getWidth();
            int height = encode.getHeight();
            int[] iArr = new int[width * height];
            for (int i2 = 0; i2 < height; i2++) {
                int i3 = i2 * width;
                for (int i4 = 0; i4 < width; i4++) {
                    iArr[i3 + i4] = encode.get(i4, i2) ? ViewCompat.MEASURED_STATE_MASK : -1;
                }
            }
            m7870constructorimpl = Result.m7870constructorimpl(Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        return (Bitmap) (Result.m7876isFailureimpl(m7870constructorimpl) ? null : m7870constructorimpl);
    }
}
