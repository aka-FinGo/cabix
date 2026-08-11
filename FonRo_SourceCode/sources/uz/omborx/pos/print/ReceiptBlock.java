package uz.FonRo.pos.print;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.BarcodeKind;
import uz.FonRo.pos.data.model.WriteOffReason;
import uz.FonRo.pos.print.EscPos;

/* compiled from: ReceiptBuilder.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Luz/FonRo/pos/print/ReceiptBlock;", "", "Text", "Qr", "Barcode", "Gap", "Luz/FonRo/pos/print/ReceiptBlock$Barcode;", "Luz/FonRo/pos/print/ReceiptBlock$Gap;", "Luz/FonRo/pos/print/ReceiptBlock$Qr;", "Luz/FonRo/pos/print/ReceiptBlock$Text;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public interface ReceiptBlock {

    /* compiled from: ReceiptBuilder.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012Ê\u0001\f\b$\u0012\b\b%\u0012\u0004\b\u0003\u0010\u0002¨\u0006#"}, d2 = {"Luz/FonRo/pos/print/ReceiptBlock$Text;", "Luz/FonRo/pos/print/ReceiptBlock;", "text", "", "align", "Luz/FonRo/pos/print/EscPos$Align;", "bold", "", "doubleWidth", "doubleHeight", "invert", "<init>", "(Ljava/lang/String;Luz/FonRo/pos/print/EscPos$Align;ZZZZ)V", "getText", "()Ljava/lang/String;", "getAlign", "()Luz/FonRo/pos/print/EscPos$Align;", "getBold", "()Z", "getDoubleWidth", "getDoubleHeight", "getInvert", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", WriteOffReason.OTHER, "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final /* data */ class Text implements ReceiptBlock {
        public static final int $stable = 0;
        private final EscPos.Align align;
        private final boolean bold;
        private final boolean doubleHeight;
        private final boolean doubleWidth;
        private final boolean invert;
        private final String text;

        public static /* synthetic */ Text copy$default(Text text, String str, EscPos.Align align, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = text.text;
            }
            if ((i & 2) != 0) {
                align = text.align;
            }
            if ((i & 4) != 0) {
                z = text.bold;
            }
            if ((i & 8) != 0) {
                z2 = text.doubleWidth;
            }
            if ((i & 16) != 0) {
                z3 = text.doubleHeight;
            }
            if ((i & 32) != 0) {
                z4 = text.invert;
            }
            boolean z5 = z3;
            boolean z6 = z4;
            return text.copy(str, align, z, z2, z5, z6);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component2, reason: from getter */
        public final EscPos.Align getAlign() {
            return this.align;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getBold() {
            return this.bold;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getDoubleWidth() {
            return this.doubleWidth;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getDoubleHeight() {
            return this.doubleHeight;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getInvert() {
            return this.invert;
        }

        public final Text copy(String text, EscPos.Align align, boolean bold, boolean doubleWidth, boolean doubleHeight, boolean invert) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(align, "align");
            return new Text(text, align, bold, doubleWidth, doubleHeight, invert);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Text)) {
                return false;
            }
            Text text = (Text) other;
            return Intrinsics.areEqual(this.text, text.text) && this.align == text.align && this.bold == text.bold && this.doubleWidth == text.doubleWidth && this.doubleHeight == text.doubleHeight && this.invert == text.invert;
        }

        public int hashCode() {
            return (((((((((this.text.hashCode() * 31) + this.align.hashCode()) * 31) + Boolean.hashCode(this.bold)) * 31) + Boolean.hashCode(this.doubleWidth)) * 31) + Boolean.hashCode(this.doubleHeight)) * 31) + Boolean.hashCode(this.invert);
        }

        public String toString() {
            return "Text(text=" + this.text + ", align=" + this.align + ", bold=" + this.bold + ", doubleWidth=" + this.doubleWidth + ", doubleHeight=" + this.doubleHeight + ", invert=" + this.invert + ")";
        }

        public Text(String text, EscPos.Align align, boolean z, boolean z2, boolean z3, boolean z4) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(align, "align");
            this.text = text;
            this.align = align;
            this.bold = z;
            this.doubleWidth = z2;
            this.doubleHeight = z3;
            this.invert = z4;
        }

        public final String getText() {
            return this.text;
        }

        public /* synthetic */ Text(String str, EscPos.Align align, boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? EscPos.Align.LEFT : align, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4);
        }

        public final EscPos.Align getAlign() {
            return this.align;
        }

        public final boolean getBold() {
            return this.bold;
        }

        public final boolean getDoubleWidth() {
            return this.doubleWidth;
        }

        public final boolean getDoubleHeight() {
            return this.doubleHeight;
        }

        public final boolean getInvert() {
            return this.invert;
        }
    }

    /* compiled from: ReceiptBuilder.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"Luz/FonRo/pos/print/ReceiptBlock$Qr;", "Luz/FonRo/pos/print/ReceiptBlock;", "data", "", "moduleSize", "", "<init>", "(Ljava/lang/String;I)V", "getData", "()Ljava/lang/String;", "getModuleSize", "()I", "component1", "component2", "copy", "equals", "", WriteOffReason.OTHER, "", "hashCode", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final /* data */ class Qr implements ReceiptBlock {
        public static final int $stable = 0;
        private final String data;
        private final int moduleSize;

        public static /* synthetic */ Qr copy$default(Qr qr, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = qr.data;
            }
            if ((i2 & 2) != 0) {
                i = qr.moduleSize;
            }
            return qr.copy(str, i);
        }

        /* renamed from: component1, reason: from getter */
        public final String getData() {
            return this.data;
        }

        /* renamed from: component2, reason: from getter */
        public final int getModuleSize() {
            return this.moduleSize;
        }

        public final Qr copy(String data, int moduleSize) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new Qr(data, moduleSize);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Qr)) {
                return false;
            }
            Qr qr = (Qr) other;
            return Intrinsics.areEqual(this.data, qr.data) && this.moduleSize == qr.moduleSize;
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + Integer.hashCode(this.moduleSize);
        }

        public String toString() {
            return "Qr(data=" + this.data + ", moduleSize=" + this.moduleSize + ")";
        }

        public Qr(String data, int i) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.moduleSize = i;
        }

        public /* synthetic */ Qr(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? 5 : i);
        }

        public final String getData() {
            return this.data;
        }

        public final int getModuleSize() {
            return this.moduleSize;
        }
    }

    /* compiled from: ReceiptBuilder.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0014\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015Ê\u0001\f\b\"\u0012\b\b#\u0012\u0004\b\u0003\u0010\u0002¨\u0006!"}, d2 = {"Luz/FonRo/pos/print/ReceiptBlock$Barcode;", "Luz/FonRo/pos/print/ReceiptBlock;", "data", "", "kind", "Luz/FonRo/pos/core/BarcodeKind;", "heightDots", "", "moduleWidth", "digitsBelow", "", "<init>", "(Ljava/lang/String;Luz/FonRo/pos/core/BarcodeKind;IIZ)V", "getData", "()Ljava/lang/String;", "getKind", "()Luz/FonRo/pos/core/BarcodeKind;", "getHeightDots", "()I", "getModuleWidth", "getDigitsBelow", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", WriteOffReason.OTHER, "", "hashCode", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final /* data */ class Barcode implements ReceiptBlock {
        public static final int $stable = 0;
        private final String data;
        private final boolean digitsBelow;
        private final int heightDots;
        private final BarcodeKind kind;
        private final int moduleWidth;

        public static /* synthetic */ Barcode copy$default(Barcode barcode, String str, BarcodeKind barcodeKind, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = barcode.data;
            }
            if ((i3 & 2) != 0) {
                barcodeKind = barcode.kind;
            }
            if ((i3 & 4) != 0) {
                i = barcode.heightDots;
            }
            if ((i3 & 8) != 0) {
                i2 = barcode.moduleWidth;
            }
            if ((i3 & 16) != 0) {
                z = barcode.digitsBelow;
            }
            boolean z2 = z;
            int i4 = i;
            return barcode.copy(str, barcodeKind, i4, i2, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getData() {
            return this.data;
        }

        /* renamed from: component2, reason: from getter */
        public final BarcodeKind getKind() {
            return this.kind;
        }

        /* renamed from: component3, reason: from getter */
        public final int getHeightDots() {
            return this.heightDots;
        }

        /* renamed from: component4, reason: from getter */
        public final int getModuleWidth() {
            return this.moduleWidth;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getDigitsBelow() {
            return this.digitsBelow;
        }

        public final Barcode copy(String data, BarcodeKind kind, int heightDots, int moduleWidth, boolean digitsBelow) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(kind, "kind");
            return new Barcode(data, kind, heightDots, moduleWidth, digitsBelow);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Barcode)) {
                return false;
            }
            Barcode barcode = (Barcode) other;
            return Intrinsics.areEqual(this.data, barcode.data) && this.kind == barcode.kind && this.heightDots == barcode.heightDots && this.moduleWidth == barcode.moduleWidth && this.digitsBelow == barcode.digitsBelow;
        }

        public int hashCode() {
            return (((((((this.data.hashCode() * 31) + this.kind.hashCode()) * 31) + Integer.hashCode(this.heightDots)) * 31) + Integer.hashCode(this.moduleWidth)) * 31) + Boolean.hashCode(this.digitsBelow);
        }

        public String toString() {
            return "Barcode(data=" + this.data + ", kind=" + this.kind + ", heightDots=" + this.heightDots + ", moduleWidth=" + this.moduleWidth + ", digitsBelow=" + this.digitsBelow + ")";
        }

        public Barcode(String data, BarcodeKind kind, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(kind, "kind");
            this.data = data;
            this.kind = kind;
            this.heightDots = i;
            this.moduleWidth = i2;
            this.digitsBelow = z;
        }

        public /* synthetic */ Barcode(String str, BarcodeKind barcodeKind, int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, barcodeKind, (i3 & 4) != 0 ? 60 : i, (i3 & 8) != 0 ? 2 : i2, (i3 & 16) != 0 ? true : z);
        }

        public final String getData() {
            return this.data;
        }

        public final BarcodeKind getKind() {
            return this.kind;
        }

        public final int getHeightDots() {
            return this.heightDots;
        }

        public final int getModuleWidth() {
            return this.moduleWidth;
        }

        public final boolean getDigitsBelow() {
            return this.digitsBelow;
        }
    }

    /* compiled from: ReceiptBuilder.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Luz/FonRo/pos/print/ReceiptBlock$Gap;", "Luz/FonRo/pos/print/ReceiptBlock;", "lines", "", "<init>", "(I)V", "getLines", "()I", "component1", "copy", "equals", "", WriteOffReason.OTHER, "", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final /* data */ class Gap implements ReceiptBlock {
        public static final int $stable = 0;
        private final int lines;

        public Gap() {
            this(0, 1, null);
        }

        public static /* synthetic */ Gap copy$default(Gap gap, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = gap.lines;
            }
            return gap.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getLines() {
            return this.lines;
        }

        public final Gap copy(int lines) {
            return new Gap(lines);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Gap) && this.lines == ((Gap) other).lines;
        }

        public int hashCode() {
            return Integer.hashCode(this.lines);
        }

        public String toString() {
            return "Gap(lines=" + this.lines + ")";
        }

        public Gap(int i) {
            this.lines = i;
        }

        public /* synthetic */ Gap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 1 : i);
        }

        public final int getLines() {
            return this.lines;
        }
    }
}
