package androidx.compose.ui.text;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: Placeholder.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "", "value", "", "constructor-impl", "(I)I", "equals", "", WriteOffReason.OTHER, "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes4.dex */
public final class PlaceholderVerticalAlign {
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int AboveBaseline = m6340constructorimpl(1);
    private static final int Top = m6340constructorimpl(2);
    private static final int Bottom = m6340constructorimpl(3);
    private static final int Center = m6340constructorimpl(4);
    private static final int TextTop = m6340constructorimpl(5);
    private static final int TextBottom = m6340constructorimpl(6);
    private static final int TextCenter = m6340constructorimpl(7);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PlaceholderVerticalAlign m6339boximpl(int i) {
        return new PlaceholderVerticalAlign(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m6340constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m6341equalsimpl(int i, Object obj) {
        return (obj instanceof PlaceholderVerticalAlign) && i == ((PlaceholderVerticalAlign) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6342equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m6343hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m6341equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6343hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ PlaceholderVerticalAlign(int i) {
        this.value = i;
    }

    public String toString() {
        return m6344toStringimpl(this.value);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m6344toStringimpl(int i) {
        return m6342equalsimpl0(i, AboveBaseline) ? "AboveBaseline" : m6342equalsimpl0(i, Top) ? "Top" : m6342equalsimpl0(i, Bottom) ? "Bottom" : m6342equalsimpl0(i, Center) ? "Center" : m6342equalsimpl0(i, TextTop) ? "TextTop" : m6342equalsimpl0(i, TextBottom) ? "TextBottom" : m6342equalsimpl0(i, TextCenter) ? "TextCenter" : "Invalid";
    }

    /* compiled from: Placeholder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/PlaceholderVerticalAlign$Companion;", "", "()V", "AboveBaseline", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "getAboveBaseline-J6kI3mc", "()I", "I", "Bottom", "getBottom-J6kI3mc", "Center", "getCenter-J6kI3mc", "TextBottom", "getTextBottom-J6kI3mc", "TextCenter", "getTextCenter-J6kI3mc", "TextTop", "getTextTop-J6kI3mc", "Top", "getTop-J6kI3mc", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getAboveBaseline-J6kI3mc, reason: not valid java name */
        public final int m6346getAboveBaselineJ6kI3mc() {
            return PlaceholderVerticalAlign.AboveBaseline;
        }

        /* renamed from: getTop-J6kI3mc, reason: not valid java name */
        public final int m6352getTopJ6kI3mc() {
            return PlaceholderVerticalAlign.Top;
        }

        /* renamed from: getBottom-J6kI3mc, reason: not valid java name */
        public final int m6347getBottomJ6kI3mc() {
            return PlaceholderVerticalAlign.Bottom;
        }

        /* renamed from: getCenter-J6kI3mc, reason: not valid java name */
        public final int m6348getCenterJ6kI3mc() {
            return PlaceholderVerticalAlign.Center;
        }

        /* renamed from: getTextTop-J6kI3mc, reason: not valid java name */
        public final int m6351getTextTopJ6kI3mc() {
            return PlaceholderVerticalAlign.TextTop;
        }

        /* renamed from: getTextBottom-J6kI3mc, reason: not valid java name */
        public final int m6349getTextBottomJ6kI3mc() {
            return PlaceholderVerticalAlign.TextBottom;
        }

        /* renamed from: getTextCenter-J6kI3mc, reason: not valid java name */
        public final int m6350getTextCenterJ6kI3mc() {
            return PlaceholderVerticalAlign.TextCenter;
        }
    }
}
