package uz.FonRo.pos.ui.more;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoreScreen.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001a\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0013J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JN\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006'"}, d2 = {"Luz/FonRo/pos/ui/more/MoreLink;", "", "title", "", "subtitle", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "tint", "Landroidx/compose/ui/graphics/Color;", "route", "badge", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;JLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getSubtitle", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getTint-0d7_KjU", "()J", "J", "getRoute", "getBadge", "component1", "component2", "component3", "component4", "component4-0d7_KjU", "component5", "component6", "copy", "copy-Bx497Mc", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;JLjava/lang/String;Ljava/lang/String;)Luz/FonRo/pos/ui/more/MoreLink;", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class MoreLink {
    private final String badge;
    private final ImageVector icon;
    private final String route;
    private final String subtitle;
    private final long tint;
    private final String title;

    public /* synthetic */ MoreLink(String str, String str2, ImageVector imageVector, long j, String str3, String str4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, imageVector, j, str3, str4);
    }

    /* renamed from: copy-Bx497Mc$default, reason: not valid java name */
    public static /* synthetic */ MoreLink m10025copyBx497Mc$default(MoreLink moreLink, String str, String str2, ImageVector imageVector, long j, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = moreLink.title;
        }
        if ((i & 2) != 0) {
            str2 = moreLink.subtitle;
        }
        if ((i & 4) != 0) {
            imageVector = moreLink.icon;
        }
        if ((i & 8) != 0) {
            j = moreLink.tint;
        }
        if ((i & 16) != 0) {
            str3 = moreLink.route;
        }
        if ((i & 32) != 0) {
            str4 = moreLink.badge;
        }
        long j2 = j;
        ImageVector imageVector2 = imageVector;
        return moreLink.m10027copyBx497Mc(str, str2, imageVector2, j2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* renamed from: component3, reason: from getter */
    public final ImageVector getIcon() {
        return this.icon;
    }

    /* renamed from: component4-0d7_KjU, reason: not valid java name and from getter */
    public final long getTint() {
        return this.tint;
    }

    /* renamed from: component5, reason: from getter */
    public final String getRoute() {
        return this.route;
    }

    /* renamed from: component6, reason: from getter */
    public final String getBadge() {
        return this.badge;
    }

    /* renamed from: copy-Bx497Mc, reason: not valid java name */
    public final MoreLink m10027copyBx497Mc(String title, String subtitle, ImageVector icon, long tint, String route, String badge) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(route, "route");
        return new MoreLink(title, subtitle, icon, tint, route, badge, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MoreLink)) {
            return false;
        }
        MoreLink moreLink = (MoreLink) other;
        return Intrinsics.areEqual(this.title, moreLink.title) && Intrinsics.areEqual(this.subtitle, moreLink.subtitle) && Intrinsics.areEqual(this.icon, moreLink.icon) && Color.m4385equalsimpl0(this.tint, moreLink.tint) && Intrinsics.areEqual(this.route, moreLink.route) && Intrinsics.areEqual(this.badge, moreLink.badge);
    }

    public int hashCode() {
        int hashCode = ((((((((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.icon.hashCode()) * 31) + Color.m4391hashCodeimpl(this.tint)) * 31) + this.route.hashCode()) * 31;
        String str = this.badge;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "MoreLink(title=" + this.title + ", subtitle=" + this.subtitle + ", icon=" + this.icon + ", tint=" + Color.m4392toStringimpl(this.tint) + ", route=" + this.route + ", badge=" + this.badge + ")";
    }

    private MoreLink(String title, String subtitle, ImageVector icon, long j, String route, String str) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(route, "route");
        this.title = title;
        this.subtitle = subtitle;
        this.icon = icon;
        this.tint = j;
        this.route = route;
        this.badge = str;
    }

    public /* synthetic */ MoreLink(String str, String str2, ImageVector imageVector, long j, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, imageVector, j, str3, (i & 32) != 0 ? null : str4, null);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final ImageVector getIcon() {
        return this.icon;
    }

    /* renamed from: getTint-0d7_KjU, reason: not valid java name */
    public final long m10028getTint0d7_KjU() {
        return this.tint;
    }

    public final String getRoute() {
        return this.route;
    }

    public final String getBadge() {
        return this.badge;
    }
}
