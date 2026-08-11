package androidx.compose.ui.text.input;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: KeyboardType.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/input/KeyboardType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", WriteOffReason.OTHER, "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes4.dex */
public final class KeyboardType {
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Unspecified = m6672constructorimpl(0);
    private static final int Text = m6672constructorimpl(1);
    private static final int Ascii = m6672constructorimpl(2);
    private static final int Number = m6672constructorimpl(3);
    private static final int Phone = m6672constructorimpl(4);
    private static final int Uri = m6672constructorimpl(5);
    private static final int Email = m6672constructorimpl(6);
    private static final int Password = m6672constructorimpl(7);
    private static final int NumberPassword = m6672constructorimpl(8);
    private static final int Decimal = m6672constructorimpl(9);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyboardType m6671boximpl(int i) {
        return new KeyboardType(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m6672constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m6673equalsimpl(int i, Object obj) {
        return (obj instanceof KeyboardType) && i == ((KeyboardType) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6674equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m6675hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m6673equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6675hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ KeyboardType(int i) {
        this.value = i;
    }

    public String toString() {
        return m6676toStringimpl(this.value);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m6676toStringimpl(int i) {
        return m6674equalsimpl0(i, Unspecified) ? "Unspecified" : m6674equalsimpl0(i, Text) ? "Text" : m6674equalsimpl0(i, Ascii) ? "Ascii" : m6674equalsimpl0(i, Number) ? "Number" : m6674equalsimpl0(i, Phone) ? "Phone" : m6674equalsimpl0(i, Uri) ? "Uri" : m6674equalsimpl0(i, Email) ? "Email" : m6674equalsimpl0(i, Password) ? "Password" : m6674equalsimpl0(i, NumberPassword) ? "NumberPassword" : m6674equalsimpl0(i, Decimal) ? "Decimal" : "Invalid";
    }

    /* compiled from: KeyboardType.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R$\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007R$\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0007R$\u0010\u0015\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0007R$\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u0007R$\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u0007R$\u0010\u001e\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u0007R$\u0010!\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\"\u0010\u0002\u001a\u0004\b#\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/ui/text/input/KeyboardType$Companion;", "", "()V", "Ascii", "Landroidx/compose/ui/text/input/KeyboardType;", "getAscii-PjHm6EE$annotations", "getAscii-PjHm6EE", "()I", "I", "Decimal", "getDecimal-PjHm6EE$annotations", "getDecimal-PjHm6EE", "Email", "getEmail-PjHm6EE$annotations", "getEmail-PjHm6EE", "Number", "getNumber-PjHm6EE$annotations", "getNumber-PjHm6EE", "NumberPassword", "getNumberPassword-PjHm6EE$annotations", "getNumberPassword-PjHm6EE", "Password", "getPassword-PjHm6EE$annotations", "getPassword-PjHm6EE", "Phone", "getPhone-PjHm6EE$annotations", "getPhone-PjHm6EE", "Text", "getText-PjHm6EE$annotations", "getText-PjHm6EE", "Unspecified", "getUnspecified-PjHm6EE$annotations", "getUnspecified-PjHm6EE", "Uri", "getUri-PjHm6EE$annotations", "getUri-PjHm6EE", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAscii-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m6678getAsciiPjHm6EE$annotations() {
        }

        /* renamed from: getDecimal-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m6679getDecimalPjHm6EE$annotations() {
        }

        /* renamed from: getEmail-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m6680getEmailPjHm6EE$annotations() {
        }

        /* renamed from: getNumber-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m6681getNumberPjHm6EE$annotations() {
        }

        /* renamed from: getNumberPassword-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m6682getNumberPasswordPjHm6EE$annotations() {
        }

        /* renamed from: getPassword-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m6683getPasswordPjHm6EE$annotations() {
        }

        /* renamed from: getPhone-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m6684getPhonePjHm6EE$annotations() {
        }

        /* renamed from: getText-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m6685getTextPjHm6EE$annotations() {
        }

        /* renamed from: getUnspecified-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m6686getUnspecifiedPjHm6EE$annotations() {
        }

        /* renamed from: getUri-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m6687getUriPjHm6EE$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getUnspecified-PjHm6EE, reason: not valid java name */
        public final int m6696getUnspecifiedPjHm6EE() {
            return KeyboardType.Unspecified;
        }

        /* renamed from: getText-PjHm6EE, reason: not valid java name */
        public final int m6695getTextPjHm6EE() {
            return KeyboardType.Text;
        }

        /* renamed from: getAscii-PjHm6EE, reason: not valid java name */
        public final int m6688getAsciiPjHm6EE() {
            return KeyboardType.Ascii;
        }

        /* renamed from: getNumber-PjHm6EE, reason: not valid java name */
        public final int m6691getNumberPjHm6EE() {
            return KeyboardType.Number;
        }

        /* renamed from: getPhone-PjHm6EE, reason: not valid java name */
        public final int m6694getPhonePjHm6EE() {
            return KeyboardType.Phone;
        }

        /* renamed from: getUri-PjHm6EE, reason: not valid java name */
        public final int m6697getUriPjHm6EE() {
            return KeyboardType.Uri;
        }

        /* renamed from: getEmail-PjHm6EE, reason: not valid java name */
        public final int m6690getEmailPjHm6EE() {
            return KeyboardType.Email;
        }

        /* renamed from: getPassword-PjHm6EE, reason: not valid java name */
        public final int m6693getPasswordPjHm6EE() {
            return KeyboardType.Password;
        }

        /* renamed from: getNumberPassword-PjHm6EE, reason: not valid java name */
        public final int m6692getNumberPasswordPjHm6EE() {
            return KeyboardType.NumberPassword;
        }

        /* renamed from: getDecimal-PjHm6EE, reason: not valid java name */
        public final int m6689getDecimalPjHm6EE() {
            return KeyboardType.Decimal;
        }
    }
}
