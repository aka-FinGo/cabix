package uz.FonRo.pos.print;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.pdf.PrintedPdfDocument;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.LangKt;

/* compiled from: ReceiptPrinter.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001-B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ6\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J#\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0002¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0016H\u0002J \u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002JF\u0010%\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00050)H\u0082@¢\u0006\u0002\u0010*J\u000e\u0010+\u001a\u0004\u0018\u00010,*\u00020\u0007H\u0002Ê\u0001\f\b.\u0012\b\b/\u0012\u0004\b\u0003\u0010\u0002¨\u0006\b"}, d2 = {"Luz/FonRo/pos/print/ReceiptPrinter;", "", "<init>", "()V", "printSaleReceipt", "", "context", "Landroid/content/Context;", "app", "Luz/FonRo/pos/FonRoApp;", "doc", "Luz/FonRo/pos/print/ReceiptDoc;", "(Landroid/content/Context;Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/print/ReceiptDoc;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "printLabels", "labels", "", "Luz/FonRo/pos/print/LabelDoc;", "layout", "Luz/FonRo/pos/print/LabelLayout;", "(Landroid/content/Context;Luz/FonRo/pos/FonRoApp;Ljava/util/List;Luz/FonRo/pos/print/LabelLayout;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rollAsSheet", "failureText", "", "printerName", "result", "Lkotlin/Result;", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;", "jobName", "prefix", "number", "drawScaled", "canvas", "Landroid/graphics/Canvas;", FirebaseAnalytics.Param.CONTENT, "Landroid/graphics/Rect;", "bitmap", "Landroid/graphics/Bitmap;", "systemPrint", "pageCount", "", "draw", "Lkotlin/Function3;", "(Landroid/content/Context;Ljava/lang/String;ILkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findActivity", "Landroid/app/Activity;", "PagePrintAdapter", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class ReceiptPrinter {
    public static final int $stable = 0;
    public static final ReceiptPrinter INSTANCE = new ReceiptPrinter();

    private ReceiptPrinter() {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0213 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0214 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object printSaleReceipt(android.content.Context r17, uz.FonRo.pos.FonRoApp r18, uz.FonRo.pos.print.ReceiptDoc r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instructions count: 533
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.print.ReceiptPrinter.printSaleReceipt(android.content.Context, uz.FonRo.pos.FonRoApp, uz.FonRo.pos.print.ReceiptDoc, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit printSaleReceipt$lambda$0(List list, int i, int i2, Canvas canvas, Rect content) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(content, "content");
        Bitmap renderBitmap = ReceiptPrinterKt.renderBitmap(list, i);
        INSTANCE.drawScaled(canvas, content, renderBitmap);
        renderBitmap.recycle();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x011a, code lost:
    
        if (systemPrint(r17, r3, r4, r4, r5) == r6) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0229 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x022a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object printLabels(android.content.Context r17, uz.FonRo.pos.FonRoApp r18, final java.util.List<uz.FonRo.pos.print.LabelDoc> r19, uz.FonRo.pos.print.LabelLayout r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            Method dump skipped, instructions count: 555
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.print.ReceiptPrinter.printLabels(android.content.Context, uz.FonRo.pos.FonRoApp, java.util.List, uz.FonRo.pos.print.LabelLayout, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object printLabels$default(ReceiptPrinter receiptPrinter, Context context, FonRoApp FonRoApp, List list, LabelLayout labelLayout, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            labelLayout = LabelLayouts.INSTANCE.getDefault();
        }
        return receiptPrinter.printLabels(context, FonRoApp, list, labelLayout, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit printLabels$lambda$0(List list, LabelLayout labelLayout, int i, Canvas canvas, Rect content) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(content, "content");
        LabelSheet.INSTANCE.drawPage(canvas, content, list, labelLayout, i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit printLabels$lambda$1(List list, LabelLayout labelLayout, int i, Canvas canvas, Rect content) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(content, "content");
        LabelSheet.INSTANCE.drawPage(canvas, content, list, labelLayout, i);
        return Unit.INSTANCE;
    }

    private final LabelLayout rollAsSheet(LabelLayout layout) {
        return LabelLayout.copy$default(layout, null, null, null, SheetKind.A4, 0.0f, 0.0f, RangesKt.coerceAtLeast((int) (198.0f / layout.getW()), 1), RangesKt.coerceAtLeast((int) (285.0f / layout.getH()), 1), 6.0f, 6.0f, 0.0f, 0.0f, 55, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        if (r0 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String failureText(java.lang.String r3, java.lang.Object r4) {
        /*
            r2 = this;
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.CharSequence r2 = kotlin.text.StringsKt.trim(r3)
            java.lang.String r2 = r2.toString()
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            r0 = 0
            if (r3 <= 0) goto L15
            goto L16
        L15:
            r2 = r0
        L16:
            r3 = 0
            if (r2 != 0) goto L21
            java.lang.String r2 = "Принтер"
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r2 = uz.FonRo.pos.core.LangKt.tx(r2, r1)
        L21:
            java.lang.Throwable r4 = kotlin.Result.m7873exceptionOrNullimpl(r4)
            if (r4 == 0) goto L39
            java.lang.String r4 = r4.getMessage()
            if (r4 == 0) goto L39
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            if (r1 != 0) goto L37
            r0 = r4
        L37:
            if (r0 != 0) goto L41
        L39:
            java.lang.String r4 = "принтер не отвечает"
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r0 = uz.FonRo.pos.core.LangKt.tx(r4, r3)
        L41:
            java.lang.String r3 = "%s: %s Печатаем через системный диалог."
            java.lang.Object[] r2 = new java.lang.Object[]{r2, r0}
            java.lang.String r2 = uz.FonRo.pos.core.LangKt.tx(r3, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.print.ReceiptPrinter.failureText(java.lang.String, java.lang.Object):java.lang.String");
    }

    private final String jobName(String prefix, String number) {
        if (StringsKt.isBlank(number)) {
            return prefix;
        }
        return prefix + " " + number;
    }

    private final void drawScaled(Canvas canvas, Rect content, Bitmap bitmap) {
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return;
        }
        float min = Math.min(content.width() / bitmap.getWidth(), content.height() / bitmap.getHeight());
        int coerceAtLeast = RangesKt.coerceAtLeast((int) (bitmap.getWidth() * min), 1);
        int coerceAtLeast2 = RangesKt.coerceAtLeast((int) (bitmap.getHeight() * min), 1);
        int width = content.left + ((content.width() - coerceAtLeast) / 2);
        int i = content.top;
        canvas.drawBitmap(bitmap, (Rect) null, new Rect(width, i, coerceAtLeast + width, coerceAtLeast2 + i), (Paint) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object systemPrint(Context context, String str, int i, Function3<? super Integer, ? super Canvas, ? super Rect, Unit> function3, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new ReceiptPrinter$systemPrint$2(context, str, i, function3, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity findActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReceiptPrinter.kt */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0004\b\r\u0010\u000eJ6\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J9\u0010\u001a\u001a\u00020\f2\u0010\u0010\u001b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020 H\u0016¢\u0006\u0002\u0010!J#\u0010\"\u001a\u00020#*\f\u0012\u0006\b\u0001\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010$\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Luz/FonRo/pos/print/ReceiptPrinter$PagePrintAdapter;", "Landroid/print/PrintDocumentAdapter;", "context", "Landroid/content/Context;", "jobName", "", "pageCount", "", "draw", "Lkotlin/Function3;", "Landroid/graphics/Canvas;", "Landroid/graphics/Rect;", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;ILkotlin/jvm/functions/Function3;)V", "attributes", "Landroid/print/PrintAttributes;", "onLayout", "oldAttributes", "newAttributes", "cancellationSignal", "Landroid/os/CancellationSignal;", "callback", "Landroid/print/PrintDocumentAdapter$LayoutResultCallback;", "extras", "Landroid/os/Bundle;", "onWrite", "pages", "", "Landroid/print/PageRange;", FirebaseAnalytics.Param.DESTINATION, "Landroid/os/ParcelFileDescriptor;", "Landroid/print/PrintDocumentAdapter$WriteResultCallback;", "([Landroid/print/PageRange;Landroid/os/ParcelFileDescriptor;Landroid/os/CancellationSignal;Landroid/print/PrintDocumentAdapter$WriteResultCallback;)V", "containsPage", "", FirebaseAnalytics.Param.INDEX, "([Landroid/print/PageRange;I)Z", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class PagePrintAdapter extends PrintDocumentAdapter {
        private PrintAttributes attributes;
        private final Context context;
        private final Function3<Integer, Canvas, Rect, Unit> draw;
        private final String jobName;
        private final int pageCount;

        /* JADX WARN: Multi-variable type inference failed */
        public PagePrintAdapter(Context context, String jobName, int i, Function3<? super Integer, ? super Canvas, ? super Rect, Unit> draw) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(jobName, "jobName");
            Intrinsics.checkNotNullParameter(draw, "draw");
            this.context = context;
            this.jobName = jobName;
            this.pageCount = i;
            this.draw = draw;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes oldAttributes, PrintAttributes newAttributes, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback callback, Bundle extras) {
            Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.attributes = newAttributes;
            if (cancellationSignal != null && cancellationSignal.isCanceled()) {
                callback.onLayoutCancelled();
                return;
            }
            PrintDocumentInfo build = new PrintDocumentInfo.Builder(this.jobName).setContentType(0).setPageCount(RangesKt.coerceAtLeast(this.pageCount, 1)).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            callback.onLayoutFinished(build, !Intrinsics.areEqual(newAttributes, oldAttributes));
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pages, ParcelFileDescriptor destination, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback callback) {
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(callback, "callback");
            PrintAttributes printAttributes = this.attributes;
            if (printAttributes == null) {
                callback.onWriteFailed(LangKt.tx("Не удалось подготовить документ", new Object[0]));
                return;
            }
            PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(this.context, printAttributes);
            ArrayList arrayList = new ArrayList();
            try {
                int i = this.pageCount;
                for (int i2 = 0; i2 < i; i2++) {
                    if (cancellationSignal != null && cancellationSignal.isCanceled()) {
                        callback.onWriteCancelled();
                        return;
                    }
                    if (containsPage(pages, i2)) {
                        PdfDocument.Page startPage = printedPdfDocument.startPage(i2);
                        Intrinsics.checkNotNullExpressionValue(startPage, "startPage(...)");
                        Function3<Integer, Canvas, Rect, Unit> function3 = this.draw;
                        Integer valueOf = Integer.valueOf(i2);
                        Canvas canvas = startPage.getCanvas();
                        Intrinsics.checkNotNullExpressionValue(canvas, "getCanvas(...)");
                        Rect pageContentRect = printedPdfDocument.getPageContentRect();
                        Intrinsics.checkNotNullExpressionValue(pageContentRect, "getPageContentRect(...)");
                        function3.invoke(valueOf, canvas, pageContentRect);
                        printedPdfDocument.finishPage(startPage);
                        arrayList.add(new PageRange(i2, i2));
                    }
                }
                FileOutputStream fileOutputStream = new FileOutputStream(destination.getFileDescriptor());
                try {
                    printedPdfDocument.writeTo(fileOutputStream);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                    callback.onWriteFinished(arrayList.isEmpty() ? new PageRange[]{PageRange.ALL_PAGES} : (PageRange[]) arrayList.toArray(new PageRange[0]));
                } finally {
                }
            } catch (Throwable th) {
                try {
                    String message = th.getMessage();
                    if (message == null) {
                        message = LangKt.tx("Не удалось записать документ", new Object[0]);
                    }
                    callback.onWriteFailed(message);
                } finally {
                    printedPdfDocument.close();
                }
            }
        }

        private final boolean containsPage(PageRange[] pageRangeArr, int i) {
            if (pageRangeArr == null || pageRangeArr.length == 0) {
                return true;
            }
            for (PageRange pageRange : pageRangeArr) {
                if (i >= pageRange.getStart() && i <= pageRange.getEnd()) {
                    return true;
                }
            }
            return false;
        }
    }
}
