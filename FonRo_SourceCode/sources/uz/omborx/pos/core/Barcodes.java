package uz.FonRo.pos.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Barcodes.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007J\u001c\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015J\u0010\u0010\u0016\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0017"}, d2 = {"Luz/FonRo/pos/core/Barcodes;", "", "<init>", "()V", "INTERNAL_PREFIX", "", "INTERNAL_BODY", "", "checkDigit", "", "digits", "isValidEan", "", "code", "kindOf", "Luz/FonRo/pos/core/BarcodeKind;", "internalEan13", "unique", "issueUnique", "seed", "taken", "", "isInternal", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class Barcodes {
    public static final int $stable = 0;
    public static final Barcodes INSTANCE = new Barcodes();
    private static final long INTERNAL_BODY = 100000000000L;
    public static final String INTERNAL_PREFIX = "2";

    private Barcodes() {
    }

    public final int checkDigit(String digits) {
        Intrinsics.checkNotNullParameter(digits, "digits");
        int length = digits.length() - 1;
        int i = 0;
        if (length >= 0) {
            int i2 = 3;
            while (true) {
                int i3 = length - 1;
                char charAt = digits.charAt(length);
                if ('0' <= charAt && charAt < ':') {
                    i += (charAt - '0') * i2;
                    i2 = i2 == 3 ? 1 : 3;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return (10 - (i % 10)) % 10;
    }

    public final boolean isValidEan(String code) {
        String obj = code != null ? StringsKt.trim((CharSequence) code).toString() : null;
        if (obj == null) {
            obj = "";
        }
        if (obj.length() != 8 && obj.length() != 13) {
            return false;
        }
        String str = obj;
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                return checkDigit(StringsKt.dropLast(obj, 1)) == StringsKt.last(str) - '0';
            }
            char charAt = str.charAt(i);
            if (!('0' <= charAt && charAt < ':')) {
                return false;
            }
            i++;
        }
    }

    public final BarcodeKind kindOf(String code) {
        String obj = code != null ? StringsKt.trim((CharSequence) code).toString() : null;
        if (obj == null) {
            obj = "";
        }
        if (obj.length() == 0) {
            return BarcodeKind.NONE;
        }
        if (isValidEan(obj)) {
            return obj.length() == 13 ? BarcodeKind.EAN13 : BarcodeKind.EAN8;
        }
        return BarcodeKind.CODE128;
    }

    public final String internalEan13(long unique) {
        String str = "2" + StringsKt.padStart(String.valueOf(Math.abs(unique) % INTERNAL_BODY), 11, '0');
        return str + checkDigit(str);
    }

    public final String issueUnique(long seed, Set<String> taken) {
        Intrinsics.checkNotNullParameter(taken, "taken");
        String internalEan13 = internalEan13(seed);
        int i = 0;
        while (taken.contains(internalEan13) && i < 50) {
            i++;
            internalEan13 = internalEan13((i * 7919) + seed);
        }
        return internalEan13;
    }

    public final boolean isInternal(String code) {
        String obj = code != null ? StringsKt.trim((CharSequence) code).toString() : null;
        if (obj == null) {
            obj = "";
        }
        return obj.length() == 13 && StringsKt.startsWith$default(obj, "2", false, 2, (Object) null) && isValidEan(obj);
    }
}
