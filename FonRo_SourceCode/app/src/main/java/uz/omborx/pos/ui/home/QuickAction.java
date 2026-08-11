package uz.FonRo.pos.ui.home;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeScreen.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0013J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003JN\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0014\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020&HÖ\u0081\u0004J\n\u0010'\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Luz/FonRo/pos/ui/home/QuickAction;", "", "label", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "tint", "Landroidx/compose/ui/graphics/Color;", "route", "badge", "dot", "", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;JLjava/lang/String;Ljava/lang/String;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLabel", "()Ljava/lang/String;", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getTint-0d7_KjU", "()J", "J", "getRoute", "getBadge", "getDot", "()Z", "component1", "component2", "component3", "component3-0d7_KjU", "component4", "component5", "component6", "copy", "copy-FNF3uiM", "(Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;JLjava/lang/String;Ljava/lang/String;Z)Luz/FonRo/pos/ui/home/QuickAction;", "equals", WriteOffReason.OTHER, "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class QuickAction {
    private final String badge;
    private final boolean dot;
    private final ImageVector icon;
    private final String label;
    private final String route;
    private final long tint;

    public /* synthetic */ QuickAction(String str, ImageVector imageVector, long j, String str2, String str3, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, imageVector, j, str2, str3, z);
    }

    /* renamed from: copy-FNF3uiM$default, reason: not valid java name */
    public static /* synthetic */ QuickAction m9964copyFNF3uiM$default(QuickAction quickAction, String str, ImageVector imageVector, long j, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = quickAction.label;
        }
        if ((i & 2) != 0) {
            imageVector = quickAction.icon;
        }
        if ((i & 4) != 0) {
            j = quickAction.tint;
        }
        if ((i & 8) != 0) {
            str2 = quickAction.route;
        }
        if ((i & 16) != 0) {
            str3 = quickAction.badge;
        }
        if ((i & 32) != 0) {
            z = quickAction.dot;
        }
        boolean z2 = z;
        String str4 = str2;
        long j2 = j;
        return quickAction.m9966copyFNF3uiM(str, imageVector, j2, str4, str3, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: component2, reason: from getter */
    public final ImageVector getIcon() {
        return this.icon;
    }

    /* renamed from: component3-0d7_KjU, reason: not valid java name and from getter */
    public final long getTint() {
        return this.tint;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRoute() {
        return this.route;
    }

    /* renamed from: component5, reason: from getter */
    public final String getBadge() {
        return this.badge;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getDot() {
        return this.dot;
    }

    /* renamed from: copy-FNF3uiM, reason: not valid java name */
    public final QuickAction m9966copyFNF3uiM(String label, ImageVector icon, long tint, String route, String badge, boolean dot) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(route, "route");
        return new QuickAction(label, icon, tint, route, badge, dot, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuickAction)) {
            return false;
        }
        QuickAction quickAction = (QuickAction) other;
        return Intrinsics.areEqual(this.label, quickAction.label) && Intrinsics.areEqual(this.icon, quickAction.icon) && Color.m4385equalsimpl0(this.tint, quickAction.tint) && Intrinsics.areEqual(this.route, quickAction.route) && Intrinsics.areEqual(this.badge, quickAction.badge) && this.dot == quickAction.dot;
    }

    public int hashCode() {
        int hashCode = ((((((this.label.hashCode() * 31) + this.icon.hashCode()) * 31) + Color.m4391hashCodeimpl(this.tint)) * 31) + this.route.hashCode()) * 31;
        String str = this.badge;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.dot);
    }

    public String toString() {
        return "QuickAction(label=" + this.label + ", icon=" + this.icon + ", tint=" + Color.m4392toStringimpl(this.tint) + ", route=" + this.route + ", badge=" + this.badge + ", dot=" + this.dot + ")";
    }

    private QuickAction(String label, ImageVector icon, long j, String route, String str, boolean z) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(route, "route");
        this.label = label;
        this.icon = icon;
        this.tint = j;
        this.route = route;
        this.badge = str;
        this.dot = z;
    }

    public /* synthetic */ QuickAction(String str, ImageVector imageVector, long j, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, imageVector, j, str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? false : z, null);
    }

    public final String getLabel() {
        return this.label;
    }

    public final ImageVector getIcon() {
        return this.icon;
    }

    /* renamed from: getTint-0d7_KjU, reason: not valid java name */
    public final long m9967getTint0d7_KjU() {
        return this.tint;
    }

    public final String getRoute() {
        return this.route;
    }

    public final String getBadge() {
        return this.badge;
    }

    public final boolean getDot() {
        return this.dot;
    }
}
