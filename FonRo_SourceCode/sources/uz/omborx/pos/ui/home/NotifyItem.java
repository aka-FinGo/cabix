package uz.FonRo.pos.ui.home;

import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: NotifySheet.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0015JN\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\t\u001a\u00020\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015Ê\u0001\f\b'\u0012\b\b(\u0012\u0004\b\u0003\u0010\u0002¨\u0006&"}, d2 = {"Luz/FonRo/pos/ui/home/NotifyItem;", "", "emoji", "", "title", "subtitle", "count", "", "route", "tone", "Landroidx/compose/ui/graphics/Color;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEmoji", "()Ljava/lang/String;", "getTitle", "getSubtitle", "getCount", "()I", "getRoute", "getTone-0d7_KjU", "()J", "J", "component1", "component2", "component3", "component4", "component5", "component6", "component6-0d7_KjU", "copy", "copy-kKL39v8", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;J)Luz/FonRo/pos/ui/home/NotifyItem;", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class NotifyItem {
    public static final int $stable = 0;
    private final int count;
    private final String emoji;
    private final String route;
    private final String subtitle;
    private final String title;
    private final long tone;

    public /* synthetic */ NotifyItem(String str, String str2, String str3, int i, String str4, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i, str4, j);
    }

    /* renamed from: copy-kKL39v8$default, reason: not valid java name */
    public static /* synthetic */ NotifyItem m9960copykKL39v8$default(NotifyItem notifyItem, String str, String str2, String str3, int i, String str4, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = notifyItem.emoji;
        }
        if ((i2 & 2) != 0) {
            str2 = notifyItem.title;
        }
        if ((i2 & 4) != 0) {
            str3 = notifyItem.subtitle;
        }
        if ((i2 & 8) != 0) {
            i = notifyItem.count;
        }
        if ((i2 & 16) != 0) {
            str4 = notifyItem.route;
        }
        if ((i2 & 32) != 0) {
            j = notifyItem.tone;
        }
        long j2 = j;
        String str5 = str4;
        String str6 = str3;
        return notifyItem.m9962copykKL39v8(str, str2, str6, i, str5, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmoji() {
        return this.emoji;
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
    public final int getCount() {
        return this.count;
    }

    /* renamed from: component5, reason: from getter */
    public final String getRoute() {
        return this.route;
    }

    /* renamed from: component6-0d7_KjU, reason: not valid java name and from getter */
    public final long getTone() {
        return this.tone;
    }

    /* renamed from: copy-kKL39v8, reason: not valid java name */
    public final NotifyItem m9962copykKL39v8(String emoji, String title, String subtitle, int count, String route, long tone) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        return new NotifyItem(emoji, title, subtitle, count, route, tone, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotifyItem)) {
            return false;
        }
        NotifyItem notifyItem = (NotifyItem) other;
        return Intrinsics.areEqual(this.emoji, notifyItem.emoji) && Intrinsics.areEqual(this.title, notifyItem.title) && Intrinsics.areEqual(this.subtitle, notifyItem.subtitle) && this.count == notifyItem.count && Intrinsics.areEqual(this.route, notifyItem.route) && Color.m4385equalsimpl0(this.tone, notifyItem.tone);
    }

    public int hashCode() {
        int hashCode = ((((((this.emoji.hashCode() * 31) + this.title.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + Integer.hashCode(this.count)) * 31;
        String str = this.route;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Color.m4391hashCodeimpl(this.tone);
    }

    public String toString() {
        return "NotifyItem(emoji=" + this.emoji + ", title=" + this.title + ", subtitle=" + this.subtitle + ", count=" + this.count + ", route=" + this.route + ", tone=" + Color.m4392toStringimpl(this.tone) + ")";
    }

    private NotifyItem(String emoji, String title, String subtitle, int i, String str, long j) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        this.emoji = emoji;
        this.title = title;
        this.subtitle = subtitle;
        this.count = i;
        this.route = str;
        this.tone = j;
    }

    public final String getEmoji() {
        return this.emoji;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getRoute() {
        return this.route;
    }

    /* renamed from: getTone-0d7_KjU, reason: not valid java name */
    public final long m9963getTone0d7_KjU() {
        return this.tone;
    }
}
