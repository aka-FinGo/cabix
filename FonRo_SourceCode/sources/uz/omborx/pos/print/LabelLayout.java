package uz.FonRo.pos.print;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: LabelSheet.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\u0081\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001J\u0014\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00106\u001a\u00020\fHÖ\u0081\u0004J\n\u00107\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010$\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b%\u0010\u001eÊ\u0001\f\b9\u0012\b\b:\u0012\u0004\b\u0003\u0010\u0002¨\u00068"}, d2 = {"Luz/FonRo/pos/print/LabelLayout;", "", "key", "", "title", "subtitle", "kind", "Luz/FonRo/pos/print/SheetKind;", "w", "", "h", "cols", "", "rows", "top", "left", "gapX", "gapY", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Luz/FonRo/pos/print/SheetKind;FFIIFFFF)V", "getKey", "()Ljava/lang/String;", "getTitle", "getSubtitle", "getKind", "()Luz/FonRo/pos/print/SheetKind;", "getW", "()F", "getH", "getCols", "()I", "getRows", "getTop", "getLeft", "getGapX", "getGapY", "perPage", "getPerPage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final /* data */ class LabelLayout {
    public static final int $stable = 0;
    private final int cols;
    private final float gapX;
    private final float gapY;
    private final float h;
    private final String key;
    private final SheetKind kind;
    private final float left;
    private final int rows;
    private final String subtitle;
    private final String title;
    private final float top;
    private final float w;

    public static /* synthetic */ LabelLayout copy$default(LabelLayout labelLayout, String str, String str2, String str3, SheetKind sheetKind, float f, float f2, int i, int i2, float f3, float f4, float f5, float f6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = labelLayout.key;
        }
        if ((i3 & 2) != 0) {
            str2 = labelLayout.title;
        }
        if ((i3 & 4) != 0) {
            str3 = labelLayout.subtitle;
        }
        if ((i3 & 8) != 0) {
            sheetKind = labelLayout.kind;
        }
        if ((i3 & 16) != 0) {
            f = labelLayout.w;
        }
        if ((i3 & 32) != 0) {
            f2 = labelLayout.h;
        }
        if ((i3 & 64) != 0) {
            i = labelLayout.cols;
        }
        if ((i3 & 128) != 0) {
            i2 = labelLayout.rows;
        }
        if ((i3 & 256) != 0) {
            f3 = labelLayout.top;
        }
        if ((i3 & 512) != 0) {
            f4 = labelLayout.left;
        }
        if ((i3 & 1024) != 0) {
            f5 = labelLayout.gapX;
        }
        if ((i3 & 2048) != 0) {
            f6 = labelLayout.gapY;
        }
        float f7 = f5;
        float f8 = f6;
        float f9 = f3;
        float f10 = f4;
        int i4 = i;
        int i5 = i2;
        float f11 = f;
        float f12 = f2;
        return labelLayout.copy(str, str2, str3, sheetKind, f11, f12, i4, i5, f9, f10, f7, f8);
    }

    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component10, reason: from getter */
    public final float getLeft() {
        return this.left;
    }

    /* renamed from: component11, reason: from getter */
    public final float getGapX() {
        return this.gapX;
    }

    /* renamed from: component12, reason: from getter */
    public final float getGapY() {
        return this.gapY;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* renamed from: component4, reason: from getter */
    public final SheetKind getKind() {
        return this.kind;
    }

    /* renamed from: component5, reason: from getter */
    public final float getW() {
        return this.w;
    }

    /* renamed from: component6, reason: from getter */
    public final float getH() {
        return this.h;
    }

    /* renamed from: component7, reason: from getter */
    public final int getCols() {
        return this.cols;
    }

    /* renamed from: component8, reason: from getter */
    public final int getRows() {
        return this.rows;
    }

    /* renamed from: component9, reason: from getter */
    public final float getTop() {
        return this.top;
    }

    public final LabelLayout copy(String key, String title, String subtitle, SheetKind kind, float w, float h, int cols, int rows, float top, float left, float gapX, float gapY) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(kind, "kind");
        return new LabelLayout(key, title, subtitle, kind, w, h, cols, rows, top, left, gapX, gapY);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LabelLayout)) {
            return false;
        }
        LabelLayout labelLayout = (LabelLayout) other;
        return Intrinsics.areEqual(this.key, labelLayout.key) && Intrinsics.areEqual(this.title, labelLayout.title) && Intrinsics.areEqual(this.subtitle, labelLayout.subtitle) && this.kind == labelLayout.kind && Float.compare(this.w, labelLayout.w) == 0 && Float.compare(this.h, labelLayout.h) == 0 && this.cols == labelLayout.cols && this.rows == labelLayout.rows && Float.compare(this.top, labelLayout.top) == 0 && Float.compare(this.left, labelLayout.left) == 0 && Float.compare(this.gapX, labelLayout.gapX) == 0 && Float.compare(this.gapY, labelLayout.gapY) == 0;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.key.hashCode() * 31) + this.title.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.kind.hashCode()) * 31) + Float.hashCode(this.w)) * 31) + Float.hashCode(this.h)) * 31) + Integer.hashCode(this.cols)) * 31) + Integer.hashCode(this.rows)) * 31) + Float.hashCode(this.top)) * 31) + Float.hashCode(this.left)) * 31) + Float.hashCode(this.gapX)) * 31) + Float.hashCode(this.gapY);
    }

    public String toString() {
        return "LabelLayout(key=" + this.key + ", title=" + this.title + ", subtitle=" + this.subtitle + ", kind=" + this.kind + ", w=" + this.w + ", h=" + this.h + ", cols=" + this.cols + ", rows=" + this.rows + ", top=" + this.top + ", left=" + this.left + ", gapX=" + this.gapX + ", gapY=" + this.gapY + ")";
    }

    public LabelLayout(String key, String title, String subtitle, SheetKind kind, float f, float f2, int i, int i2, float f3, float f4, float f5, float f6) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(kind, "kind");
        this.key = key;
        this.title = title;
        this.subtitle = subtitle;
        this.kind = kind;
        this.w = f;
        this.h = f2;
        this.cols = i;
        this.rows = i2;
        this.top = f3;
        this.left = f4;
        this.gapX = f5;
        this.gapY = f6;
    }

    public /* synthetic */ LabelLayout(String str, String str2, String str3, SheetKind sheetKind, float f, float f2, int i, int i2, float f3, float f4, float f5, float f6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, sheetKind, f, f2, (i3 & 64) != 0 ? 1 : i, (i3 & 128) != 0 ? 1 : i2, (i3 & 256) != 0 ? 0.0f : f3, (i3 & 512) != 0 ? 0.0f : f4, (i3 & 1024) != 0 ? 0.0f : f5, (i3 & 2048) != 0 ? 0.0f : f6);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final SheetKind getKind() {
        return this.kind;
    }

    public final float getW() {
        return this.w;
    }

    public final float getH() {
        return this.h;
    }

    public final int getCols() {
        return this.cols;
    }

    public final int getRows() {
        return this.rows;
    }

    public final float getTop() {
        return this.top;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getGapX() {
        return this.gapX;
    }

    public final float getGapY() {
        return this.gapY;
    }

    public final int getPerPage() {
        return RangesKt.coerceAtLeast(this.cols * this.rows, 1);
    }
}
