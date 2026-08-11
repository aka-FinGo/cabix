package uz.FonRo.pos.print;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import uz.FonRo.pos.core.BarcodeKind;
import uz.FonRo.pos.core.Barcodes;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.data.model.Store;
import uz.FonRo.pos.print.EscPos;
import uz.FonRo.pos.print.ReceiptBlock;

/* compiled from: ReceiptBuilder.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nJ\u001c\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J&\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0010\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\nH\u0002Ê\u0001\f\b!\u0012\b\b\"\u0012\u0004\b\u0003\u0010\u0002¨\u0006 "}, d2 = {"Luz/FonRo/pos/print/ReceiptBuilder;", "", "<init>", "()V", "layout", "", "Luz/FonRo/pos/print/ReceiptBlock;", "doc", "Luz/FonRo/pos/print/ReceiptDoc;", "widthMm", "", "store", "Luz/FonRo/pos/data/model/Store;", "build", "", "labelLayout", "label", "Luz/FonRo/pos/print/LabelDoc;", "buildLabels", "labels", "render", "blocks", "cut", "", "writeBlocks", "", "out", "Ljava/io/ByteArrayOutputStream;", "infoRow", "", "value", "cols", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class ReceiptBuilder {
    public static final int $stable = 0;
    public static final ReceiptBuilder INSTANCE = new ReceiptBuilder();

    private ReceiptBuilder() {
    }

    public final List<ReceiptBlock> layout(ReceiptDoc doc, int widthMm, Store store) {
        String obj;
        StringBuilder sb;
        String obj2;
        String obj3;
        String obj4;
        String address;
        String obj5;
        String phone;
        String obj6;
        String name;
        Intrinsics.checkNotNullParameter(doc, "doc");
        int charsFor = EscPos.INSTANCE.charsFor(widthMm);
        int i = charsFor / 2;
        ArrayList arrayList = new ArrayList();
        String obj7 = (store == null || (name = store.getName()) == null) ? null : StringsKt.trim((CharSequence) name).toString();
        if (obj7 == null) {
            obj7 = "";
        }
        String str = obj7;
        if (str.length() == 0) {
            str = "FonRo";
        }
        Iterator<T> it = EscPos.INSTANCE.wrap(str, i).iterator();
        while (it.hasNext()) {
            arrayList.add(new ReceiptBlock.Text((String) it.next(), EscPos.Align.CENTER, true, true, true, false, 32, null));
        }
        if (store != null && (phone = store.getPhone()) != null && (obj6 = StringsKt.trim((CharSequence) phone).toString()) != null) {
            if (obj6.length() <= 0) {
                obj6 = null;
            }
            if (obj6 != null) {
                Iterator<T> it2 = EscPos.INSTANCE.wrap(obj6, charsFor).iterator();
                while (it2.hasNext()) {
                    arrayList.add(new ReceiptBlock.Text((String) it2.next(), EscPos.Align.CENTER, false, false, false, false, 60, null));
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
        }
        if (store != null && (address = store.getAddress()) != null && (obj5 = StringsKt.trim((CharSequence) address).toString()) != null) {
            if (obj5.length() <= 0) {
                obj5 = null;
            }
            if (obj5 != null) {
                Iterator<T> it3 = EscPos.INSTANCE.wrap(obj5, charsFor).iterator();
                while (it3.hasNext()) {
                    arrayList.add(new ReceiptBlock.Text((String) it3.next(), EscPos.Align.CENTER, false, false, false, false, 60, null));
                }
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
            }
        }
        ArrayList arrayList2 = arrayList;
        arrayList2.add(new ReceiptBlock.Text(EscPos.rule$default(EscPos.INSTANCE, charsFor, (char) 0, 2, null), null, false, false, false, false, 62, null));
        if (!StringsKt.isBlank(doc.getReceiptNumber())) {
            CollectionsKt.addAll(arrayList2, infoRow("Чек", doc.getReceiptNumber(), charsFor));
        }
        if (!StringsKt.isBlank(doc.getDateText())) {
            CollectionsKt.addAll(arrayList2, infoRow("Дата", doc.getDateText(), charsFor));
        }
        String paymentText = doc.getPaymentText();
        if (paymentText != null && (obj4 = StringsKt.trim((CharSequence) paymentText).toString()) != null) {
            if (obj4.length() <= 0) {
                obj4 = null;
            }
            if (obj4 != null) {
                CollectionsKt.addAll(arrayList2, INSTANCE.infoRow("Оплата", obj4, charsFor));
                Unit unit5 = Unit.INSTANCE;
                Unit unit6 = Unit.INSTANCE;
            }
        }
        String customer = doc.getCustomer();
        if (customer != null && (obj3 = StringsKt.trim((CharSequence) customer).toString()) != null) {
            if (obj3.length() <= 0) {
                obj3 = null;
            }
            if (obj3 != null) {
                CollectionsKt.addAll(arrayList2, INSTANCE.infoRow("Клиент", obj3, charsFor));
                Unit unit7 = Unit.INSTANCE;
                Unit unit8 = Unit.INSTANCE;
            }
        }
        String itemsCountText = doc.getItemsCountText();
        if (itemsCountText != null && (obj2 = StringsKt.trim((CharSequence) itemsCountText).toString()) != null) {
            if (obj2.length() <= 0) {
                obj2 = null;
            }
            if (obj2 != null) {
                CollectionsKt.addAll(arrayList2, INSTANCE.infoRow("Товаров", obj2, charsFor));
                Unit unit9 = Unit.INSTANCE;
                Unit unit10 = Unit.INSTANCE;
            }
        }
        String statusText = doc.getStatusText();
        if (statusText != null && (obj = StringsKt.trim((CharSequence) statusText).toString()) != null) {
            if (obj.length() <= 0) {
                obj = null;
            }
            if (obj != null) {
                String upperCase = EscPos.INSTANCE.printable(obj).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                if (doc.getStatusFilled()) {
                    sb = new StringBuilder("  ");
                    sb.append(upperCase);
                    sb.append("  ");
                } else {
                    sb = new StringBuilder("[ ");
                    sb.append(upperCase);
                    sb.append(" ]");
                }
                arrayList2.add(new ReceiptBlock.Text(StringsKt.take(sb.toString(), charsFor), EscPos.Align.CENTER, true, false, false, doc.getStatusFilled(), 24, null));
                Unit unit11 = Unit.INSTANCE;
                Unit unit12 = Unit.INSTANCE;
            }
        }
        arrayList2.add(new ReceiptBlock.Text(EscPos.INSTANCE.dashRule(charsFor), null, false, false, false, false, 62, null));
        int i2 = 0;
        for (Object obj8 : doc.getLines()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ReceiptLine receiptLine = (ReceiptLine) obj8;
            String str2 = i3 + ". ";
            String repeat = StringsKt.repeat(" ", str2.length());
            int i4 = 0;
            for (Object obj9 : EscPos.INSTANCE.wrap(receiptLine.getName(), RangesKt.coerceAtLeast(charsFor - str2.length(), 8))) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str3 = (String) obj9;
                arrayList2.add(new ReceiptBlock.Text((i4 == 0 ? str2 : repeat) + str3, null, true, false, false, false, 58, null));
                i4 = i5;
            }
            StringBuilder sb2 = new StringBuilder();
            String obj10 = StringsKt.trim((CharSequence) receiptLine.getQty()).toString();
            if (obj10.length() <= 0) {
                obj10 = null;
            }
            if (obj10 != null) {
                sb2.append(obj10);
            }
            if (receiptLine.getPrice() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                if (sb2.length() > 0) {
                    sb2.append(" × ");
                }
                sb2.append(Fmt.INSTANCE.nf(Double.valueOf(receiptLine.getPrice())));
            }
            arrayList2.add(new ReceiptBlock.Text(EscPos.INSTANCE.twoCols(repeat + ((Object) sb2), Fmt.INSTANCE.nf(Double.valueOf(receiptLine.getSum())), charsFor, ' '), null, false, false, false, false, 62, null));
            i2 = i3;
        }
        arrayList2.add(new ReceiptBlock.Text(EscPos.INSTANCE.dashRule(charsFor), null, false, false, false, false, 62, null));
        for (ReceiptTotal receiptTotal : doc.getTotals()) {
            arrayList2.add(new ReceiptBlock.Text(EscPos.twoCols$default(EscPos.INSTANCE, receiptTotal.getLabel(), receiptTotal.getValue(), charsFor, (char) 0, 8, null), null, receiptTotal.getBig() || receiptTotal.getStrong(), false, receiptTotal.getBig(), false, 42, null));
        }
        if (!doc.getPaySection().isEmpty()) {
            arrayList2.add(new ReceiptBlock.Text(EscPos.INSTANCE.dashRule(charsFor), null, false, false, false, false, 62, null));
            for (ReceiptPay receiptPay : doc.getPaySection()) {
                arrayList2.add(new ReceiptBlock.Text(EscPos.twoCols$default(EscPos.INSTANCE, receiptPay.getLabel(), receiptPay.getValue(), charsFor, (char) 0, 8, null), null, false, false, false, false, 62, null));
            }
        }
        arrayList2.add(new ReceiptBlock.Text(EscPos.rule$default(EscPos.INSTANCE, charsFor, (char) 0, 2, null), null, false, false, false, false, 62, null));
        String qrText = doc.getQrText();
        String obj11 = qrText != null ? StringsKt.trim((CharSequence) qrText).toString() : null;
        String str4 = obj11 != null ? obj11 : "";
        if (str4.length() > 0) {
            arrayList2.add(new ReceiptBlock.Qr(str4, widthMm <= 58 ? 4 : 5));
            arrayList2.add(new ReceiptBlock.Text("QR чека", EscPos.Align.CENTER, true, false, false, false, 56, null));
            Iterator<T> it4 = EscPos.INSTANCE.wrap(str4, charsFor).iterator();
            while (it4.hasNext()) {
                arrayList2.add(new ReceiptBlock.Text((String) it4.next(), EscPos.Align.CENTER, false, false, false, false, 60, null));
            }
        }
        arrayList2.add(new ReceiptBlock.Gap(1));
        Iterator<T> it5 = EscPos.INSTANCE.wrap(doc.getFooter(), charsFor).iterator();
        while (it5.hasNext()) {
            arrayList2.add(new ReceiptBlock.Text((String) it5.next(), EscPos.Align.CENTER, true, false, false, false, 56, null));
        }
        if (!StringsKt.isBlank(doc.getReceiptNumber())) {
            Iterator<T> it6 = EscPos.INSTANCE.wrap(doc.getReceiptNumber() + " · " + doc.getDateText(), charsFor).iterator();
            while (it6.hasNext()) {
                arrayList2.add(new ReceiptBlock.Text((String) it6.next(), EscPos.Align.CENTER, false, false, false, false, 60, null));
            }
        }
        arrayList2.add(new ReceiptBlock.Gap(3));
        arrayList2.add(new ReceiptBlock.Text(EscPos.rule$default(EscPos.INSTANCE, charsFor, (char) 0, 2, null), EscPos.Align.CENTER, false, false, false, false, 60, null));
        return arrayList;
    }

    public final byte[] build(ReceiptDoc doc, int widthMm, Store store) {
        Intrinsics.checkNotNullParameter(doc, "doc");
        return render$default(this, layout(doc, widthMm, store), false, 2, null);
    }

    public final List<ReceiptBlock> labelLayout(LabelDoc label, int widthMm) {
        Intrinsics.checkNotNullParameter(label, "label");
        int charsFor = EscPos.INSTANCE.charsFor(widthMm);
        int i = charsFor / 2;
        ArrayList arrayList = new ArrayList();
        String obj = StringsKt.trim((CharSequence) label.getStoreName()).toString();
        if (obj.length() > 0) {
            Iterator it = CollectionsKt.take(EscPos.INSTANCE.wrap(obj, charsFor), 1).iterator();
            while (it.hasNext()) {
                arrayList.add(new ReceiptBlock.Text((String) it.next(), EscPos.Align.CENTER, false, false, false, false, 60, null));
            }
        }
        Iterator it2 = CollectionsKt.take(EscPos.INSTANCE.wrap(label.getTitle(), charsFor), 2).iterator();
        while (it2.hasNext()) {
            arrayList.add(new ReceiptBlock.Text((String) it2.next(), EscPos.Align.CENTER, true, false, false, false, 56, null));
        }
        String obj2 = StringsKt.trim((CharSequence) label.getCode()).toString();
        BarcodeKind kindOf = Barcodes.INSTANCE.kindOf(obj2);
        if (kindOf != BarcodeKind.NONE) {
            arrayList.add(new ReceiptBlock.Barcode(obj2, kindOf, widthMm <= 58 ? 56 : 64, widthMm > 58 ? 3 : 2, label.getShowDigits()));
        }
        String obj3 = StringsKt.trim((CharSequence) label.getPrice()).toString();
        if (obj3.length() > 0) {
            Iterator<T> it3 = EscPos.INSTANCE.wrap(obj3, i).iterator();
            while (it3.hasNext()) {
                arrayList.add(new ReceiptBlock.Text((String) it3.next(), EscPos.Align.CENTER, true, true, true, false, 32, null));
            }
        }
        return arrayList;
    }

    public final byte[] buildLabels(List<LabelDoc> labels, int widthMm) {
        Intrinsics.checkNotNullParameter(labels, "labels");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(EscPos.INSTANCE.init());
        for (LabelDoc labelDoc : labels) {
            ReceiptBuilder receiptBuilder = INSTANCE;
            receiptBuilder.writeBlocks(byteArrayOutputStream, receiptBuilder.labelLayout(labelDoc, widthMm));
            byteArrayOutputStream.write(EscPos.INSTANCE.align(EscPos.Align.LEFT));
            byteArrayOutputStream.write(EscPos.INSTANCE.feed(2));
            byteArrayOutputStream.write(EscPos.INSTANCE.cut());
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static /* synthetic */ byte[] render$default(ReceiptBuilder receiptBuilder, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return receiptBuilder.render(list, z);
    }

    public final byte[] render(List<? extends ReceiptBlock> blocks, boolean cut) {
        Intrinsics.checkNotNullParameter(blocks, "blocks");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(EscPos.INSTANCE.init());
        writeBlocks(byteArrayOutputStream, blocks);
        byteArrayOutputStream.write(EscPos.INSTANCE.align(EscPos.Align.LEFT));
        if (cut) {
            byteArrayOutputStream.write(EscPos.INSTANCE.feed(3));
            byteArrayOutputStream.write(EscPos.INSTANCE.cut());
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    private final void writeBlocks(ByteArrayOutputStream out, List<? extends ReceiptBlock> blocks) {
        for (ReceiptBlock receiptBlock : blocks) {
            if (receiptBlock instanceof ReceiptBlock.Text) {
                ReceiptBlock.Text text = (ReceiptBlock.Text) receiptBlock;
                out.write(EscPos.INSTANCE.align(text.getAlign()));
                if (text.getBold()) {
                    out.write(EscPos.INSTANCE.bold(true));
                }
                if (text.getDoubleWidth() || text.getDoubleHeight()) {
                    out.write(EscPos.INSTANCE.size(text.getDoubleWidth(), text.getDoubleHeight()));
                }
                if (text.getInvert()) {
                    out.write(EscPos.INSTANCE.invert(true));
                }
                out.write(EscPos.INSTANCE.line(text.getText()));
                if (text.getInvert()) {
                    out.write(EscPos.INSTANCE.invert(false));
                }
                if (text.getDoubleWidth() || text.getDoubleHeight()) {
                    out.write(EscPos.INSTANCE.size(false, false));
                }
                if (text.getBold()) {
                    out.write(EscPos.INSTANCE.bold(false));
                }
            } else if (receiptBlock instanceof ReceiptBlock.Qr) {
                out.write(EscPos.INSTANCE.align(EscPos.Align.CENTER));
                ReceiptBlock.Qr qr = (ReceiptBlock.Qr) receiptBlock;
                out.write(EscPos.INSTANCE.qr(qr.getData(), qr.getModuleSize()));
                out.write(EscPos.INSTANCE.newline());
            } else if (receiptBlock instanceof ReceiptBlock.Barcode) {
                out.write(EscPos.INSTANCE.align(EscPos.Align.CENTER));
                ReceiptBlock.Barcode barcode = (ReceiptBlock.Barcode) receiptBlock;
                out.write(EscPos.INSTANCE.barcode(barcode.getData(), barcode.getKind(), barcode.getHeightDots(), barcode.getModuleWidth(), barcode.getDigitsBelow()));
                out.write(EscPos.INSTANCE.newline());
            } else {
                if (!(receiptBlock instanceof ReceiptBlock.Gap)) {
                    throw new NoWhenBranchMatchedException();
                }
                out.write(EscPos.INSTANCE.feed(((ReceiptBlock.Gap) receiptBlock).getLines()));
            }
        }
    }

    private final List<ReceiptBlock> infoRow(String label, String value, int cols) {
        String obj = StringsKt.trim((CharSequence) EscPos.INSTANCE.printable(label)).toString();
        String obj2 = StringsKt.trim((CharSequence) EscPos.INSTANCE.printable(value)).toString();
        if (obj.length() + 1 + obj2.length() <= cols) {
            return CollectionsKt.listOf(new ReceiptBlock.Text(EscPos.twoCols$default(EscPos.INSTANCE, obj, obj2, cols, (char) 0, 8, null), null, false, false, false, false, 62, null));
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = arrayList;
        arrayList2.add(new ReceiptBlock.Text(obj, null, false, false, false, false, 62, null));
        Iterator<T> it = EscPos.INSTANCE.wrap(obj2, cols).iterator();
        while (it.hasNext()) {
            arrayList2.add(new ReceiptBlock.Text((String) it.next(), EscPos.Align.RIGHT, false, false, false, false, 60, null));
        }
        return arrayList;
    }
}
