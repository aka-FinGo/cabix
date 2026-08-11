package uz.FonRo.pos.print;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.common.primitives.SignedBytes;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;
import uz.FonRo.pos.core.BarcodeKind;

/* compiled from: EscPos.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001<B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0011J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0006\u0010\u0018\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001eJ\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\tJ\u0006\u0010%\u001a\u00020\u0015J\u0006\u0010&\u001a\u00020\u0015J\u000e\u0010'\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0011J\u0018\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00112\b\b\u0002\u0010*\u001a\u00020\tJ4\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\t2\b\b\u0002\u00100\u001a\u00020\t2\b\b\u0002\u00101\u001a\u00020\u001eJ\u0018\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\t2\b\b\u0002\u00104\u001a\u00020\u0010J\u000e\u00105\u001a\u00020\u00112\u0006\u00103\u001a\u00020\tJ(\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u00112\u0006\u00103\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\u0010J\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00110;2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u00103\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b>\u0012\b\b?\u0012\u0004\b\u0003\u0010\u0002¨\u0006="}, d2 = {"Luz/FonRo/pos/print/EscPos;", "", "<init>", "()V", "ESC", "", "GS", "LF", "charsFor", "", "widthMm", "dotsFor", "cp866", "Ljava/nio/charset/Charset;", "TRANSLIT", "", "", "", "printable", "text", "encode", "", "sanitize", "translit", "init", "align", "value", "Luz/FonRo/pos/print/EscPos$Align;", "bold", DebugKt.DEBUG_PROPERTY_VALUE_ON, "", "size", "doubleWidth", "doubleHeight", "invert", "feed", "lines", "cut", "newline", "line", "qr", "data", "moduleSize", OptionalModuleUtils.BARCODE, "code", "kind", "Luz/FonRo/pos/core/BarcodeKind;", "heightDots", "moduleWidth", "digitsBelow", "rule", "width", "ch", "dashRule", "twoCols", "left", "right", "fill", "wrap", "", "Align", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class EscPos {
    public static final int $stable = 0;
    private static final byte ESC = 27;
    private static final byte GS = 29;
    private static final byte LF = 10;
    public static final EscPos INSTANCE = new EscPos();
    private static final Charset cp866 = (Charset) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.sequenceOf((Object[]) new String[]{"IBM866", "cp866", "x-IBM866", "866"}), new Function1() { // from class: uz.FonRo.pos.print.EscPos$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return EscPos.cp866$lambda$0((String) obj);
        }
    }));
    private static final Map<Character, String> TRANSLIT = MapsKt.mapOf(TuplesKt.to((char) 1072, "a"), TuplesKt.to((char) 1073, "b"), TuplesKt.to((char) 1074, "v"), TuplesKt.to((char) 1075, "g"), TuplesKt.to((char) 1076, "d"), TuplesKt.to((char) 1077, "e"), TuplesKt.to((char) 1105, "e"), TuplesKt.to((char) 1078, "zh"), TuplesKt.to((char) 1079, "z"), TuplesKt.to((char) 1080, "i"), TuplesKt.to((char) 1081, "y"), TuplesKt.to((char) 1082, "k"), TuplesKt.to((char) 1083, "l"), TuplesKt.to((char) 1084, "m"), TuplesKt.to((char) 1085, "n"), TuplesKt.to((char) 1086, "o"), TuplesKt.to((char) 1087, "p"), TuplesKt.to((char) 1088, "r"), TuplesKt.to((char) 1089, "s"), TuplesKt.to((char) 1090, "t"), TuplesKt.to((char) 1091, "u"), TuplesKt.to((char) 1092, "f"), TuplesKt.to((char) 1093, "h"), TuplesKt.to((char) 1094, "c"), TuplesKt.to((char) 1095, "ch"), TuplesKt.to((char) 1096, "sh"), TuplesKt.to((char) 1097, "sch"), TuplesKt.to((char) 1098, ""), TuplesKt.to((char) 1099, "y"), TuplesKt.to((char) 1100, ""), TuplesKt.to((char) 1101, "e"), TuplesKt.to((char) 1102, "yu"), TuplesKt.to((char) 1103, "ya"));

    /* compiled from: EscPos.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Align.values().length];
            try {
                iArr[Align.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Align.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Align.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BarcodeKind.values().length];
            try {
                iArr2[BarcodeKind.EAN13.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[BarcodeKind.EAN8.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[BarcodeKind.CODE128.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[BarcodeKind.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public final int charsFor(int widthMm) {
        if (widthMm != 58) {
            return widthMm != 80 ? 42 : 48;
        }
        return 32;
    }

    public final int dotsFor(int widthMm) {
        if (widthMm != 58) {
            return widthMm != 80 ? 512 : 576;
        }
        return 384;
    }

    private EscPos() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: EscPos.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/print/EscPos$Align;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "CENTER", "RIGHT", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Align {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Align[] $VALUES;
        public static final Align LEFT = new Align("LEFT", 0);
        public static final Align CENTER = new Align("CENTER", 1);
        public static final Align RIGHT = new Align("RIGHT", 2);

        private static final /* synthetic */ Align[] $values() {
            return new Align[]{LEFT, CENTER, RIGHT};
        }

        public static EnumEntries<Align> getEntries() {
            return $ENTRIES;
        }

        public static Align valueOf(String str) {
            return (Align) Enum.valueOf(Align.class, str);
        }

        public static Align[] values() {
            return (Align[]) $VALUES.clone();
        }

        static {
            Align[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Align(String str, int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Charset cp866$lambda$0(String name) {
        Object m7870constructorimpl;
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            Result.Companion companion = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(Charset.forName(name));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7876isFailureimpl(m7870constructorimpl)) {
            m7870constructorimpl = null;
        }
        return (Charset) m7870constructorimpl;
    }

    public final String printable(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        String sanitize = sanitize(text);
        return cp866 != null ? sanitize : translit(sanitize);
    }

    public final byte[] encode(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        String printable = printable(text);
        Charset charset = cp866;
        if (charset == null) {
            byte[] bytes = printable.getBytes(Charsets.US_ASCII);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return bytes;
        }
        byte[] bytes2 = printable.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        return bytes2;
    }

    private final String sanitize(String text) {
        StringBuilder sb = new StringBuilder(text.length());
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char charAt = text.charAt(i);
            if (charAt != '\t') {
                if (charAt == '\n' || charAt == '\r') {
                    sb.append(' ');
                } else if (charAt != 160) {
                    if (charAt != 171 && charAt != 187) {
                        if (charAt == 215) {
                            sb.append('x');
                        } else {
                            if (charAt != 700) {
                                if (charAt != 8201) {
                                    if (charAt == 8230) {
                                        sb.append("...");
                                    } else if (charAt != 8239) {
                                        if (charAt != 8722 && charAt != 8211 && charAt != 8212) {
                                            if (charAt != 8216 && charAt != 8217) {
                                                switch (charAt) {
                                                    case 8220:
                                                    case 8221:
                                                    case 8222:
                                                        break;
                                                    default:
                                                        sb.append(charAt);
                                                        break;
                                                }
                                            }
                                        } else {
                                            sb.append('-');
                                        }
                                    }
                                }
                            }
                            sb.append('\'');
                        }
                    }
                    sb.append('\"');
                }
            }
            sb.append(' ');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private final String translit(String text) {
        StringBuilder sb = new StringBuilder(text.length());
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char charAt = text.charAt(i);
            String str = TRANSLIT.get(Character.valueOf(Character.toLowerCase(charAt)));
            if (str != null) {
                if (Character.isUpperCase(charAt) && str.length() > 0) {
                    char upperCase = Character.toUpperCase(str.charAt(0));
                    String substring = str.substring(1);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    str = upperCase + substring;
                }
                sb.append(str);
            } else if (charAt < 128) {
                sb.append(charAt);
            } else if (charAt == 183) {
                sb.append('-');
            } else if (charAt == 8470) {
                sb.append('N');
            } else {
                sb.append('?');
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final byte[] init() {
        return new byte[]{27, SignedBytes.MAX_POWER_OF_TWO, 27, 116, 17};
    }

    public final byte[] align(Align value) {
        byte b;
        Intrinsics.checkNotNullParameter(value, "value");
        int i = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
        if (i == 1) {
            b = 0;
        } else if (i == 2) {
            b = 1;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            b = 2;
        }
        return new byte[]{27, 97, b};
    }

    public final byte[] bold(boolean on) {
        return new byte[]{27, 69, on ? (byte) 1 : (byte) 0};
    }

    public final byte[] size(boolean doubleWidth, boolean doubleHeight) {
        int i = doubleWidth ? 16 : 0;
        if (doubleHeight) {
            i |= 1;
        }
        return new byte[]{29, 33, (byte) i};
    }

    public final byte[] invert(boolean on) {
        return new byte[]{29, 66, on ? (byte) 1 : (byte) 0};
    }

    public final byte[] feed(int lines) {
        return new byte[]{27, 100, (byte) RangesKt.coerceIn(lines, 0, 255)};
    }

    public final byte[] cut() {
        return new byte[]{29, 86, 66, 0};
    }

    public final byte[] newline() {
        return new byte[]{10};
    }

    public final byte[] line(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return ArraysKt.plus(encode(text), new byte[]{10});
    }

    public static /* synthetic */ byte[] qr$default(EscPos escPos, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 5;
        }
        return escPos.qr(str, i);
    }

    public final byte[] qr(String data, int moduleSize) {
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] bytes = data.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        if (bytes.length == 0 || bytes.length > 2953) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(new byte[]{29, 40, 107, 4, 0, 49, 65, 50, 0});
        byteArrayOutputStream.write(new byte[]{29, 40, 107, 3, 0, 49, 67, (byte) RangesKt.coerceIn(moduleSize, 1, 16)});
        byteArrayOutputStream.write(new byte[]{29, 40, 107, 3, 0, 49, 69, 49});
        int length = bytes.length + 3;
        byteArrayOutputStream.write(new byte[]{29, 40, 107, (byte) (length & 255), (byte) ((length >> 8) & 255), 49, 80, 48});
        byteArrayOutputStream.write(bytes);
        byteArrayOutputStream.write(new byte[]{29, 40, 107, 3, 0, 49, 81, 48});
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static /* synthetic */ byte[] barcode$default(EscPos escPos, String str, BarcodeKind barcodeKind, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 60;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = 2;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            z = true;
        }
        return escPos.barcode(str, barcodeKind, i4, i5, z);
    }

    public final byte[] barcode(String code, BarcodeKind kind, int heightDots, int moduleWidth, boolean digitsBelow) {
        byte[] bytes;
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(kind, "kind");
        String obj = StringsKt.trim((CharSequence) code).toString();
        String str = obj;
        if (str.length() == 0 || kind == BarcodeKind.NONE) {
            return new byte[0];
        }
        int i = WhenMappings.$EnumSwitchMapping$1[kind.ordinal()];
        if (i == 1 || i == 2) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (!('0' <= charAt && charAt < ':')) {
                    return new byte[0];
                }
            }
            bytes = obj.getBytes(Charsets.US_ASCII);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        } else {
            if (i != 3) {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                return new byte[0];
            }
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i3 = 0; i3 < length; i3++) {
                char charAt2 = str.charAt(i3);
                if (' ' <= charAt2 && charAt2 < 127) {
                    sb.append(charAt2);
                }
            }
            String sb2 = sb.toString();
            if (sb2.length() == 0) {
                return new byte[0];
            }
            byte[] bytes2 = sb2.getBytes(Charsets.US_ASCII);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            bytes = ArraysKt.plus(new byte[]{123, 66}, bytes2);
        }
        if (bytes.length > 255) {
            return new byte[0];
        }
        int i4 = WhenMappings.$EnumSwitchMapping$1[kind.ordinal()];
        byte b = i4 != 1 ? i4 != 2 ? (byte) 73 : (byte) 68 : (byte) 67;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(new byte[]{29, 104, (byte) RangesKt.coerceIn(heightDots, 24, 255)});
        byteArrayOutputStream.write(new byte[]{29, 119, (byte) RangesKt.coerceIn(moduleWidth, 2, 6)});
        byteArrayOutputStream.write(new byte[]{29, 72, (byte) (digitsBelow ? 2 : 0)});
        byteArrayOutputStream.write(new byte[]{29, 102, 0});
        byteArrayOutputStream.write(new byte[]{29, 107, b, (byte) bytes.length});
        byteArrayOutputStream.write(bytes);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static /* synthetic */ String rule$default(EscPos escPos, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = '-';
        }
        return escPos.rule(i, c);
    }

    public final String rule(int width, char ch) {
        return width <= 0 ? "" : StringsKt.repeat(String.valueOf(ch), width);
    }

    public final String dashRule(int width) {
        if (width <= 0) {
            return "";
        }
        return StringsKt.take(StringsKt.trimEnd((CharSequence) StringsKt.repeat("- ", (width + 1) / 2)).toString(), width);
    }

    public static /* synthetic */ String twoCols$default(EscPos escPos, String str, String str2, int i, char c, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            c = '.';
        }
        return escPos.twoCols(str, str2, i, c);
    }

    public final String twoCols(String left, String right, int width, char fill) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        String obj = StringsKt.trim((CharSequence) printable(right)).toString();
        String obj2 = StringsKt.trimEnd((CharSequence) printable(left)).toString();
        if (width <= 0) {
            return "";
        }
        if (obj.length() >= width) {
            return StringsKt.takeLast(obj, width);
        }
        int length = (width - obj.length()) - 1;
        if (obj2.length() > length) {
            obj2 = StringsKt.take(obj2, RangesKt.coerceAtLeast(length, 0));
        }
        return obj2 + StringsKt.repeat(String.valueOf(fill), RangesKt.coerceAtLeast((width - obj2.length()) - obj.length(), 1)) + obj;
    }

    public final List<String> wrap(String text, int width) {
        Intrinsics.checkNotNullParameter(text, "text");
        String obj = StringsKt.trim((CharSequence) printable(text)).toString();
        if (width <= 0) {
            return CollectionsKt.listOf(obj);
        }
        String str = obj;
        if (str.length() == 0) {
            return CollectionsKt.listOf("");
        }
        if (obj.length() <= width) {
            return CollectionsKt.listOf(obj);
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        List split$default = StringsKt.split$default((CharSequence) str, new char[]{' '}, false, 0, 6, (Object) null);
        ArrayList<String> arrayList2 = new ArrayList();
        for (Object obj2 : split$default) {
            if (((String) obj2).length() > 0) {
                arrayList2.add(obj2);
            }
        }
        for (String str2 : arrayList2) {
            while (str2.length() > width) {
                if (sb.length() > 0) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                }
                arrayList.add(StringsKt.take(str2, width));
                str2 = StringsKt.drop(str2, width);
            }
            if (sb.length() == 0) {
                sb.append(str2);
            } else if (sb.length() + 1 + str2.length() <= width) {
                sb.append(' ');
                sb.append(str2);
            } else {
                arrayList.add(sb.toString());
                sb.setLength(0);
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            arrayList.add(sb.toString());
        }
        return arrayList.isEmpty() ? CollectionsKt.listOf("") : arrayList;
    }
}
