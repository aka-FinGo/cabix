package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversionsJVM.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\f\n\u0002\b\u000e\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a\"\u0010\u000b\u001a\u00020\f*\u0004\u0018\u00010\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\rb\u0002\b\b\u001a\u0012\u0010\u000e\u001a\u00020\u0002*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a(\u0010\u000e\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a\u0012\u0010\u000f\u001a\u00020\t*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a(\u0010\u000f\u001a\u00020\t*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a\u0012\u0010\u0010\u001a\u00020\u0004*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a(\u0010\u0010\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a\u0012\u0010\u0011\u001a\u00020\n*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a(\u0010\u0011\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a\u0012\u0010\u0012\u001a\u00020\u0013*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a\u0012\u0010\u0014\u001a\u00020\u0015*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a#\u0010\u0016\u001a\u0004\u0018\u00010\u0013*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0002\u0010\u0017\u001a#\u0010\u0018\u001a\u0004\u0018\u00010\u0015*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0002\u0010\u0019\u001a \u0010\u001a\u001a\u00020\u001b*\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001cb\u0002\b\b\u001a(\u0010\u001a\u001a\u00020\u001b*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001cb\u0002\b\b\u001a\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001b*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u001a&\u0010\u001d\u001a\u0004\u0018\u00010\u001b*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u001a \u0010\u001e\u001a\u00020\u001f*\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001cb\u0002\b\b\u001a(\u0010\u001e\u001a\u00020\u001f*\u00020\u00012\u0006\u0010 \u001a\u00020!H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001cb\u0002\b\b\u001a\u001e\u0010\"\u001a\u0004\u0018\u00010\u001f*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u001a&\u0010\"\u001a\u0004\u0018\u00010\u001f*\u00020\u00012\u0006\u0010 \u001a\u00020!H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u001a5\u0010#\u001a\u0004\u0018\u0001H$\"\u0004\b\u0000\u0010$2\u0006\u0010%\u001a\u00020\u00012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H$0'H\u0082\u0088\u0004¢\u0006\u0004\b(\u0010)\u001a5\u0010*\u001a\u0004\u0018\u0001H$\"\u0004\b\u0000\u0010$2\u0006\u0010%\u001a\u00020\u00012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H$0'H\u0082\u0088\u0004¢\u0006\u0004\b+\u0010)\u001a\u0017\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b.\u001a\u0017\u0010/\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b0\u001a%\u00101\u001a\u0004\u0018\u00010\u00012\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b4\u001a\u0017\u00105\u001a\u00020\f*\u000206H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b7\u001a\u0017\u00108\u001a\u00020\f*\u000206H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b9\u001a\u0017\u0010:\u001a\u00020\u0004*\u000206H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b;\u001a;\u0010<\u001a\u00020\u0004*\u00020\u00012\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\f0'H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b>\u001a;\u0010?\u001a\u00020\u0004*\u00020\u00012\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\f0'H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b@\u001aC\u0010A\u001a\u00020\u0004*\u00020\u00012\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\f2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\f0'H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\bC¨\u0006D"}, d2 = {"toString", "", "", "radix", "", "Lkotlin/SinceKotlin;", "version", "1.1", "Lkotlin/internal/InlineOnly;", "", "", "toBoolean", "", "1.4", "toByte", "toShort", "toInt", "toLong", "toFloat", "", "toDouble", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toBigInteger", "Ljava/math/BigInteger;", "1.2", "toBigIntegerOrNull", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "screenFloatValue", ExifInterface.GPS_DIRECTION_TRUE, "str", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "screenBigDecimalValue", "screenBigDecimalValue$StringsKt__StringNumberConversionsJVMKt", "isValidFloat", "s", "isValidFloat$StringsKt__StringNumberConversionsJVMKt", "isValidBigDecimal", "isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt", "guessNamedFloatConstant", "start", "endInclusive", "guessNamedFloatConstant$StringsKt__StringNumberConversionsJVMKt", "isAsciiDigit", "", "isAsciiDigit$StringsKt__StringNumberConversionsJVMKt", "isHexLetter", "isHexLetter$StringsKt__StringNumberConversionsJVMKt", "asciiLetterToLowerCaseCode", "asciiLetterToLowerCaseCode$StringsKt__StringNumberConversionsJVMKt", "advanceWhile", "predicate", "advanceWhile$StringsKt__StringNumberConversionsJVMKt", "backtrackWhile", "backtrackWhile$StringsKt__StringNumberConversionsJVMKt", "advanceAndValidateMantissa", "hexFormat", "advanceAndValidateMantissa$StringsKt__StringNumberConversionsJVMKt", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes6.dex */
public class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    private static final int asciiLetterToLowerCaseCode$StringsKt__StringNumberConversionsJVMKt(char c) {
        return c | ' ';
    }

    private static final boolean isAsciiDigit$StringsKt__StringNumberConversionsJVMKt(char c) {
        return ((c + 65488) & 65535) < 10;
    }

    private static final boolean isHexLetter$StringsKt__StringNumberConversionsJVMKt(char c) {
        return (((c | ' ') + (-97)) & 65535) < 6;
    }

    private static final String toString(byte b, int i) {
        String num = Integer.toString(b, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return num;
    }

    private static final String toString(short s, int i) {
        String num = Integer.toString(s, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return num;
    }

    private static final String toString(int i, int i2) {
        String num = Integer.toString(i, CharsKt.checkRadix(i2));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return num;
    }

    private static final String toString(long j, int i) {
        String l = Long.toString(j, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
        return l;
    }

    private static final boolean toBoolean(String str) {
        return Boolean.parseBoolean(str);
    }

    private static final byte toByte(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Byte.parseByte(str);
    }

    private static final byte toByte(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Byte.parseByte(str, CharsKt.checkRadix(i));
    }

    private static final short toShort(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Short.parseShort(str);
    }

    private static final short toShort(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Short.parseShort(str, CharsKt.checkRadix(i));
    }

    private static final int toInt(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Integer.parseInt(str);
    }

    private static final int toInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Integer.parseInt(str, CharsKt.checkRadix(i));
    }

    private static final long toLong(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Long.parseLong(str);
    }

    private static final long toLong(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Long.parseLong(str, CharsKt.checkRadix(i));
    }

    private static final float toFloat(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Float.parseFloat(str);
    }

    private static final double toDouble(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Double.parseDouble(str);
    }

    private static final BigInteger toBigInteger(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BigInteger(str);
    }

    private static final BigInteger toBigInteger(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BigInteger(str, CharsKt.checkRadix(i));
    }

    public static final BigInteger toBigIntegerOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.toBigIntegerOrNull(str, 10);
    }

    public static final BigInteger toBigIntegerOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            if (CharsKt.digitOf(str.charAt(0), i) < 0) {
                return null;
            }
        } else {
            for (int i2 = str.charAt(0) == '-' ? 1 : 0; i2 < length; i2++) {
                if (CharsKt.digitOf(str.charAt(i2), i) < 0) {
                    return null;
                }
            }
        }
        return new BigInteger(str, CharsKt.checkRadix(i));
    }

    private static final BigDecimal toBigDecimal(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BigDecimal(str);
    }

    private static final BigDecimal toBigDecimal(String str, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(str, mathContext);
    }

    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return function1.invoke(str);
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    private static final <T> T screenBigDecimalValue$StringsKt__StringNumberConversionsJVMKt(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt(str)) {
                return function1.invoke(str);
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final boolean isValidFloat$StringsKt__StringNumberConversionsJVMKt(java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringNumberConversionsJVMKt.isValidFloat$StringsKt__StringNumberConversionsJVMKt(java.lang.String):boolean");
    }

    private static final boolean isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt(String str) {
        int i;
        if (str.length() == 0) {
            return false;
        }
        int i2 = (str.charAt(0) == '-' || str.charAt(0) == '+') ? 1 : 0;
        int i3 = i2;
        while (i3 < str.length() && Character.isDigit(str.charAt(i3))) {
            i3++;
        }
        if (i3 == str.length()) {
            return i3 - i2 > 0;
        }
        if (str.charAt(i3) == '.') {
            i3++;
            if (i3 == str.length()) {
                return i3 - i2 > 1;
            }
            while (i3 < str.length() && Character.isDigit(str.charAt(i3))) {
                i3++;
            }
        }
        if (i3 == str.length()) {
            return true;
        }
        if ((str.charAt(i3) != 'e' && str.charAt(i3) != 'E') || (i = i3 + 1) == str.length()) {
            return false;
        }
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            i = i3 + 2;
        }
        if (i == str.length()) {
            return false;
        }
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            i++;
        }
        return i == str.length();
    }

    private static final String guessNamedFloatConstant$StringsKt__StringNumberConversionsJVMKt(int i, int i2) {
        if (i2 == i + 2) {
            return "NaN";
        }
        if (i2 == i + 7) {
            return "Infinity";
        }
        return null;
    }

    private static final int advanceWhile$StringsKt__StringNumberConversionsJVMKt(String str, int i, int i2, Function1<? super Character, Boolean> function1) {
        while (i <= i2 && function1.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
            i++;
        }
        return i;
    }

    private static final int backtrackWhile$StringsKt__StringNumberConversionsJVMKt(String str, int i, int i2, Function1<? super Character, Boolean> function1) {
        while (i2 > i && function1.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
            i2--;
        }
        return i2;
    }

    private static final int advanceAndValidateMantissa$StringsKt__StringNumberConversionsJVMKt(String str, int i, int i2, boolean z, Function1<? super Character, Boolean> function1) {
        boolean z2;
        String str2;
        int i3 = i;
        while (i3 <= i2 && function1.invoke(Character.valueOf(str.charAt(i3))).booleanValue()) {
            i3++;
        }
        boolean z3 = i != i3;
        if (i3 > i2) {
            if (z) {
                return -1;
            }
            return i3;
        }
        if (str.charAt(i3) == '.') {
            int i4 = i3 + 1;
            int i5 = i4;
            while (i5 <= i2 && function1.invoke(Character.valueOf(str.charAt(i5))).booleanValue()) {
                i5++;
            }
            z2 = i4 != i5;
            i3 = i5;
        } else {
            z2 = false;
        }
        if (z3 || z2) {
            return i3;
        }
        if (z) {
            return -1;
        }
        if (i2 == i3 + 2) {
            str2 = "NaN";
        } else {
            str2 = i2 == i3 + 7 ? "Infinity" : null;
        }
        if (str2 != null && StringsKt.indexOf((CharSequence) str, str2, i3, false) == i3) {
            return i2 + 1;
        }
        return -1;
    }

    public static final Float toFloatOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    public static final Double toDoubleOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    public static final BigDecimal toBigDecimalOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt(str)) {
                return new BigDecimal(str);
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    public static final BigDecimal toBigDecimalOrNull(String str, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        try {
            if (isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt(str)) {
                return new BigDecimal(str, mathContext);
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }
}
