package uz.FonRo.pos.ui.components;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: TabBar.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001b"}, d2 = {"Luz/FonRo/pos/ui/components/TabItem;", "", "key", "", "title", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "permission", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getTitle", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getPermission", "component1", "component2", "component3", "component4", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class TabItem {
    public static final int $stable = 0;
    private final ImageVector icon;
    private final String key;
    private final String permission;
    private final String title;

    public static /* synthetic */ TabItem copy$default(TabItem tabItem, String str, String str2, ImageVector imageVector, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tabItem.key;
        }
        if ((i & 2) != 0) {
            str2 = tabItem.title;
        }
        if ((i & 4) != 0) {
            imageVector = tabItem.icon;
        }
        if ((i & 8) != 0) {
            str3 = tabItem.permission;
        }
        return tabItem.copy(str, str2, imageVector, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final ImageVector getIcon() {
        return this.icon;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPermission() {
        return this.permission;
    }

    public final TabItem copy(String key, String title, ImageVector icon, String permission) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new TabItem(key, title, icon, permission);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TabItem)) {
            return false;
        }
        TabItem tabItem = (TabItem) other;
        return Intrinsics.areEqual(this.key, tabItem.key) && Intrinsics.areEqual(this.title, tabItem.title) && Intrinsics.areEqual(this.icon, tabItem.icon) && Intrinsics.areEqual(this.permission, tabItem.permission);
    }

    public int hashCode() {
        int hashCode = ((((this.key.hashCode() * 31) + this.title.hashCode()) * 31) + this.icon.hashCode()) * 31;
        String str = this.permission;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "TabItem(key=" + this.key + ", title=" + this.title + ", icon=" + this.icon + ", permission=" + this.permission + ")";
    }

    public TabItem(String key, String title, ImageVector icon, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.key = key;
        this.title = title;
        this.icon = icon;
        this.permission = str;
    }

    public /* synthetic */ TabItem(String str, String str2, ImageVector imageVector, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, imageVector, (i & 8) != 0 ? null : str3);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getTitle() {
        return this.title;
    }

    public final ImageVector getIcon() {
        return this.icon;
    }

    public final String getPermission() {
        return this.permission;
    }
}
