package uz.FonRo.pos.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: Lang.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Luz/FonRo/pos/core/OxLanguage;", "", "code", "", "title", "hint", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getTitle", "getHint", "component1", "component2", "component3", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class OxLanguage {
    public static final int $stable = 0;
    private final String code;
    private final String hint;
    private final String title;

    public static /* synthetic */ OxLanguage copy$default(OxLanguage oxLanguage, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oxLanguage.code;
        }
        if ((i & 2) != 0) {
            str2 = oxLanguage.title;
        }
        if ((i & 4) != 0) {
            str3 = oxLanguage.hint;
        }
        return oxLanguage.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getHint() {
        return this.hint;
    }

    public final OxLanguage copy(String code, String title, String hint) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(hint, "hint");
        return new OxLanguage(code, title, hint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OxLanguage)) {
            return false;
        }
        OxLanguage oxLanguage = (OxLanguage) other;
        return Intrinsics.areEqual(this.code, oxLanguage.code) && Intrinsics.areEqual(this.title, oxLanguage.title) && Intrinsics.areEqual(this.hint, oxLanguage.hint);
    }

    public int hashCode() {
        return (((this.code.hashCode() * 31) + this.title.hashCode()) * 31) + this.hint.hashCode();
    }

    public String toString() {
        return "OxLanguage(code=" + this.code + ", title=" + this.title + ", hint=" + this.hint + ")";
    }

    public OxLanguage(String code, String title, String hint) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(hint, "hint");
        this.code = code;
        this.title = title;
        this.hint = hint;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getHint() {
        return this.hint;
    }

    public final String getTitle() {
        return this.title;
    }
}
