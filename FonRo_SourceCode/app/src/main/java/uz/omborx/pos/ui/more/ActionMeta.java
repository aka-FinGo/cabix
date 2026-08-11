package uz.FonRo.pos.ui.more;

import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LogScreen.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0012\u0010\rJ.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Luz/FonRo/pos/ui/more/ActionMeta;", "", "title", "", "icon", "tint", "Landroidx/compose/ui/graphics/Color;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getIcon", "getTint-0d7_KjU", "()J", "J", "component1", "component2", "component3", "component3-0d7_KjU", "copy", "copy-mxwnekA", "(Ljava/lang/String;Ljava/lang/String;J)Luz/FonRo/pos/ui/more/ActionMeta;", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class ActionMeta {
    private final String icon;
    private final long tint;
    private final String title;

    public /* synthetic */ ActionMeta(String str, String str2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j);
    }

    /* renamed from: copy-mxwnekA$default, reason: not valid java name */
    public static /* synthetic */ ActionMeta m10015copymxwnekA$default(ActionMeta actionMeta, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = actionMeta.title;
        }
        if ((i & 2) != 0) {
            str2 = actionMeta.icon;
        }
        if ((i & 4) != 0) {
            j = actionMeta.tint;
        }
        return actionMeta.m10017copymxwnekA(str, str2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component3-0d7_KjU, reason: not valid java name and from getter */
    public final long getTint() {
        return this.tint;
    }

    /* renamed from: copy-mxwnekA, reason: not valid java name */
    public final ActionMeta m10017copymxwnekA(String title, String icon, long tint) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new ActionMeta(title, icon, tint, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionMeta)) {
            return false;
        }
        ActionMeta actionMeta = (ActionMeta) other;
        return Intrinsics.areEqual(this.title, actionMeta.title) && Intrinsics.areEqual(this.icon, actionMeta.icon) && Color.m4385equalsimpl0(this.tint, actionMeta.tint);
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.icon.hashCode()) * 31) + Color.m4391hashCodeimpl(this.tint);
    }

    public String toString() {
        return "ActionMeta(title=" + this.title + ", icon=" + this.icon + ", tint=" + Color.m4392toStringimpl(this.tint) + ")";
    }

    private ActionMeta(String title, String icon, long j) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.title = title;
        this.icon = icon;
        this.tint = j;
    }

    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: getTint-0d7_KjU, reason: not valid java name */
    public final long m10018getTint0d7_KjU() {
        return this.tint;
    }

    public final String getTitle() {
        return this.title;
    }
}
