package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Map;

/* loaded from: classes6.dex */
public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final Charset EUC_JP;
    public static final String GB2312 = "GB2312";
    public static final Charset GB2312_CHARSET;
    private static final Charset PLATFORM_DEFAULT_ENCODING = Charset.defaultCharset();
    public static final String SHIFT_JIS = "SJIS";
    public static final Charset SHIFT_JIS_CHARSET;

    static {
        Charset charset;
        Charset charset2;
        Charset charset3 = null;
        try {
            charset = Charset.forName(SHIFT_JIS);
        } catch (UnsupportedCharsetException unused) {
            charset = null;
        }
        SHIFT_JIS_CHARSET = charset;
        try {
            charset2 = Charset.forName(GB2312);
        } catch (UnsupportedCharsetException unused2) {
            charset2 = null;
        }
        GB2312_CHARSET = charset2;
        try {
            charset3 = Charset.forName("EUC_JP");
        } catch (UnsupportedCharsetException unused3) {
        }
        EUC_JP = charset3;
        Charset charset4 = SHIFT_JIS_CHARSET;
        ASSUME_SHIFT_JIS = (charset4 != null && charset4.equals(PLATFORM_DEFAULT_ENCODING)) || (charset3 != null && charset3.equals(PLATFORM_DEFAULT_ENCODING));
    }

    private StringUtils() {
    }

    public static String guessEncoding(byte[] bArr, Map<DecodeHintType, ?> map) {
        Charset guessCharset = guessCharset(bArr, map);
        if (guessCharset.equals(SHIFT_JIS_CHARSET)) {
            return SHIFT_JIS;
        }
        if (guessCharset.equals(StandardCharsets.UTF_8)) {
            return "UTF8";
        }
        if (guessCharset.equals(StandardCharsets.ISO_8859_1)) {
            return "ISO8859_1";
        }
        return guessCharset.name();
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.nio.charset.Charset guessCharset(byte[] r21, java.util.Map<com.google.zxing.DecodeHintType, ?> r22) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.StringUtils.guessCharset(byte[], java.util.Map):java.nio.charset.Charset");
    }
}
