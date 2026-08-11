package uz.FonRo.pos.print;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: ReceiptDoc.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011Ê\u0001\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001d"}, d2 = {"Luz/FonRo/pos/print/LabelDoc;", "", "title", "", FirebaseAnalytics.Param.PRICE, "code", "storeName", "showDigits", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getTitle", "()Ljava/lang/String;", "getPrice", "getCode", "getStoreName", "getShowDigits", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", WriteOffReason.OTHER, "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final /* data */ class LabelDoc {
    public static final int $stable = 0;
    private final String code;
    private final String price;
    private final boolean showDigits;
    private final String storeName;
    private final String title;

    public static /* synthetic */ LabelDoc copy$default(LabelDoc labelDoc, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = labelDoc.title;
        }
        if ((i & 2) != 0) {
            str2 = labelDoc.price;
        }
        if ((i & 4) != 0) {
            str3 = labelDoc.code;
        }
        if ((i & 8) != 0) {
            str4 = labelDoc.storeName;
        }
        if ((i & 16) != 0) {
            z = labelDoc.showDigits;
        }
        boolean z2 = z;
        String str5 = str3;
        return labelDoc.copy(str, str2, str5, str4, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPrice() {
        return this.price;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStoreName() {
        return this.storeName;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getShowDigits() {
        return this.showDigits;
    }

    public final LabelDoc copy(String title, String price, String code, String storeName, boolean showDigits) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(storeName, "storeName");
        return new LabelDoc(title, price, code, storeName, showDigits);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LabelDoc)) {
            return false;
        }
        LabelDoc labelDoc = (LabelDoc) other;
        return Intrinsics.areEqual(this.title, labelDoc.title) && Intrinsics.areEqual(this.price, labelDoc.price) && Intrinsics.areEqual(this.code, labelDoc.code) && Intrinsics.areEqual(this.storeName, labelDoc.storeName) && this.showDigits == labelDoc.showDigits;
    }

    public int hashCode() {
        return (((((((this.title.hashCode() * 31) + this.price.hashCode()) * 31) + this.code.hashCode()) * 31) + this.storeName.hashCode()) * 31) + Boolean.hashCode(this.showDigits);
    }

    public String toString() {
        return "LabelDoc(title=" + this.title + ", price=" + this.price + ", code=" + this.code + ", storeName=" + this.storeName + ", showDigits=" + this.showDigits + ")";
    }

    public LabelDoc(String title, String price, String code, String storeName, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(storeName, "storeName");
        this.title = title;
        this.price = price;
        this.code = code;
        this.storeName = storeName;
        this.showDigits = z;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getCode() {
        return this.code;
    }

    public /* synthetic */ LabelDoc(String str, String str2, String str3, String str4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? true : z);
    }

    public final String getStoreName() {
        return this.storeName;
    }

    public final boolean getShowDigits() {
        return this.showDigits;
    }
}
