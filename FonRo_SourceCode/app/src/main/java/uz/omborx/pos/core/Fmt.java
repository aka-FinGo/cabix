package uz.FonRo.pos.core;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.OffsetDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: Fmt.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0013\u0010\fJ\u0017\u0010\u0014\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0014\u0010\fJ\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0016J!\u0010\u001a\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001e\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b \u0010\u001dJ!\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040!2\u0006\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010#J\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040%2\b\b\u0002\u0010$\u001a\u00020\r¢\u0006\u0004\b&\u0010'J\u0015\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004¢\u0006\u0004\b-\u0010\u001dJ-\u00101\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b3\u0010\fR\u0014\u00105\u001a\u0002048\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010<R\u0014\u0010>\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010<R\u0014\u0010?\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010<R\u0017\u0010A\u001a\u00020@8\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001c\u0010G\u001a\n F*\u0004\u0018\u00010E0E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u001c\u0010I\u001a\n F*\u0004\u0018\u00010E0E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010HR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00040%8F¢\u0006\u0006\u001a\u0004\bL\u0010M¨\u0006O"}, d2 = {"Luz/FonRo/pos/core/Fmt;", "", "<init>", "()V", "", "raw", "j$/time/OffsetDateTime", "parseInstantOrNull", "(Ljava/lang/String;)Lj$/time/OffsetDateTime;", "", "value", "nf", "(Ljava/lang/Double;)Ljava/lang/String;", "", "decimals", "(Ljava/lang/Double;I)Ljava/lang/String;", FirebaseAnalytics.Param.CURRENCY, "money", "(Ljava/lang/Double;Ljava/lang/String;)Ljava/lang/String;", "qf", "compact", "todayISO", "()Ljava/lang/String;", "currentYm", "", "withTime", "dt", "(Ljava/lang/String;Z)Ljava/lang/String;", "timeOf", "(Ljava/lang/String;)Ljava/lang/String;", "dayOf", "ym", "monthTitle", "Lkotlin/Pair;", "monthRange", "(Ljava/lang/String;)Lkotlin/Pair;", "count", "", "lastMonths", "(I)Ljava/util/List;", "", "days", "daysAgo", "(J)Ljava/lang/String;", "iso", "shortWeekday", "one", "few", "many", "plural", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "asInt", "", "NBSP", "C", "Ljava/text/DecimalFormatSymbols;", "symbols", "Ljava/text/DecimalFormatSymbols;", "Ljava/text/DecimalFormat;", "int0", "Ljava/text/DecimalFormat;", "dec2", "qty3", "dec1", "j$/time/ZoneId", "STORE_ZONE", "Lj$/time/ZoneId;", "getSTORE_ZONE", "()Lj$/time/ZoneId;", "j$/time/format/DateTimeFormatter", "kotlin.jvm.PlatformType", "dateOut", "Lj$/time/format/DateTimeFormatter;", "dateTimeOut", "RAW_MONTHS", "Ljava/util/List;", "getMONTH_NAMES", "()Ljava/util/List;", "MONTH_NAMES", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class Fmt {
    public static final int $stable = 0;
    public static final Fmt INSTANCE = new Fmt();
    private static final char NBSP = 160;
    private static final List<String> RAW_MONTHS;
    private static final ZoneId STORE_ZONE;
    private static final DateTimeFormatter dateOut;
    private static final DateTimeFormatter dateTimeOut;
    private static final DecimalFormat dec1;
    private static final DecimalFormat dec2;
    private static final DecimalFormat int0;
    private static final DecimalFormat qty3;
    private static final DecimalFormatSymbols symbols;

    private Fmt() {
    }

    static {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.forLanguageTag("ru-RU"));
        decimalFormatSymbols.setGroupingSeparator((char) 160);
        decimalFormatSymbols.setDecimalSeparator(AbstractJsonLexerKt.COMMA);
        symbols = decimalFormatSymbols;
        int0 = new DecimalFormat("#,##0", decimalFormatSymbols);
        dec2 = new DecimalFormat("#,##0.00", decimalFormatSymbols);
        qty3 = new DecimalFormat("#,##0.###", decimalFormatSymbols);
        dec1 = new DecimalFormat("#,##0.#", decimalFormatSymbols);
        ZoneId of = ZoneId.of("Asia/Tashkent");
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        STORE_ZONE = of;
        dateOut = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        dateTimeOut = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        RAW_MONTHS = CollectionsKt.listOf((Object[]) new String[]{"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"});
    }

    public final String nf(Double value) {
        double doubleValue = value != null ? value.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
        if (Math.abs(doubleValue) > Double.MAX_VALUE) {
            return "0";
        }
        String format = (Math.abs(doubleValue % 1.0d) > 1.0E-4d ? dec2 : int0).format(doubleValue);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final String nf(Double value, int decimals) {
        String str;
        double doubleValue = value != null ? value.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
        if (Math.abs(doubleValue) > Double.MAX_VALUE) {
            return "0";
        }
        if (decimals <= 0) {
            str = "#,##0";
        } else {
            str = "#,##0." + StringsKt.repeat("0", decimals);
        }
        String format = new DecimalFormat(str, symbols).format(doubleValue);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
    
        if (r3 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String money(java.lang.Double r2, java.lang.String r3) {
        /*
            r1 = this;
            if (r3 == 0) goto Lf
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 != 0) goto Lc
            goto Ld
        Lc:
            r3 = 0
        Ld:
            if (r3 != 0) goto L11
        Lf:
            java.lang.String r3 = "UZS"
        L11:
            java.lang.String r0 = "NONE"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r0)
            java.lang.String r1 = r1.nf(r2)
            if (r0 == 0) goto L1e
            return r1
        L1e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = " "
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.core.Fmt.money(java.lang.Double, java.lang.String):java.lang.String");
    }

    public final String qf(Double value) {
        double doubleValue = value != null ? value.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
        if (Math.abs(doubleValue) > Double.MAX_VALUE) {
            return "0";
        }
        String format = qty3.format(doubleValue);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final String compact(Double value) {
        double doubleValue = value != null ? value.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
        double abs = Math.abs(doubleValue);
        if (abs >= 1.0E9d) {
            return dec1.format(doubleValue / 1.0E9d) + "B";
        }
        if (abs >= 1000000.0d) {
            return dec1.format(doubleValue / 1000000.0d) + "M";
        }
        if (abs >= 1000.0d) {
            return dec1.format(doubleValue / 1000.0d) + "K";
        }
        return nf(Double.valueOf(doubleValue));
    }

    public final ZoneId getSTORE_ZONE() {
        return STORE_ZONE;
    }

    public final String todayISO() {
        String localDate = LocalDate.now(STORE_ZONE).toString();
        Intrinsics.checkNotNullExpressionValue(localDate, "toString(...)");
        return localDate;
    }

    public final String currentYm() {
        String substring = todayISO().substring(0, 7);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String dt$default(Fmt fmt, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return fmt.dt(str, z);
    }

    public final String dt(String value, boolean withTime) {
        String obj = value != null ? StringsKt.trim((CharSequence) value).toString() : null;
        if (obj == null) {
            obj = "";
        }
        if (obj.length() == 0) {
            return "—";
        }
        if (obj.length() == 10 && obj.charAt(4) == '-' && obj.charAt(7) == '-') {
            String substring = obj.substring(0, 4);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String substring2 = obj.substring(5, 7);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            String substring3 = obj.substring(8, 10);
            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
            return substring3 + "." + substring2 + "." + substring;
        }
        OffsetDateTime parseInstantOrNull = parseInstantOrNull(obj);
        if (parseInstantOrNull == null) {
            return obj;
        }
        String format = parseInstantOrNull.atZoneSameInstant(STORE_ZONE).format(withTime ? dateTimeOut : dateOut);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final String timeOf(String value) {
        String obj = value != null ? StringsKt.trim((CharSequence) value).toString() : null;
        if (obj == null) {
            obj = "";
        }
        OffsetDateTime parseInstantOrNull = parseInstantOrNull(obj);
        if (parseInstantOrNull == null) {
            return "";
        }
        String format = parseInstantOrNull.atZoneSameInstant(STORE_ZONE).format(DateTimeFormatter.ofPattern("HH:mm"));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final String dayOf(String value) {
        String obj = value != null ? StringsKt.trim((CharSequence) value).toString() : null;
        if (obj == null) {
            obj = "";
        }
        if (obj.length() >= 10 && obj.charAt(4) == '-' && obj.charAt(7) == '-') {
            String substring = obj.substring(0, 10);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        OffsetDateTime parseInstantOrNull = parseInstantOrNull(obj);
        if (parseInstantOrNull == null) {
            return "";
        }
        String localDate = parseInstantOrNull.atZoneSameInstant(STORE_ZONE).toLocalDate().toString();
        Intrinsics.checkNotNullExpressionValue(localDate, "toString(...)");
        return localDate;
    }

    private final OffsetDateTime parseInstantOrNull(String raw) {
        if (raw.length() == 0) {
            return null;
        }
        String replace$default = StringsKt.replace$default(raw, ' ', 'T', false, 4, (Object) null);
        try {
            Result.Companion companion = Result.INSTANCE;
            Fmt fmt = this;
            return OffsetDateTime.parse(replace$default);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7870constructorimpl(ResultKt.createFailure(th));
            try {
                Result.Companion companion3 = Result.INSTANCE;
                return LocalDateTime.parse(replace$default).atOffset(ZoneOffset.ofHours(5));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m7870constructorimpl(ResultKt.createFailure(th2));
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    return LocalDate.parse(replace$default).atStartOfDay().atOffset(ZoneOffset.ofHours(5));
                } catch (Throwable th3) {
                    Result.Companion companion6 = Result.INSTANCE;
                    Result.m7870constructorimpl(ResultKt.createFailure(th3));
                    return null;
                }
            }
        }
    }

    public final List<String> getMONTH_NAMES() {
        List<String> list = RAW_MONTHS;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(LangKt.tx((String) it.next(), new Object[0]));
        }
        return arrayList;
    }

    public final String monthTitle(String ym) {
        Integer intOrNull;
        int intValue;
        Intrinsics.checkNotNullParameter(ym, "ym");
        List split$default = StringsKt.split$default((CharSequence) ym, new String[]{"-"}, false, 0, 6, (Object) null);
        if (split$default.size() < 2 || (intOrNull = StringsKt.toIntOrNull((String) split$default.get(1))) == null || (intValue = intOrNull.intValue() - 1) < 0 || intValue >= getMONTH_NAMES().size()) {
            return ym;
        }
        String str = getMONTH_NAMES().get(intValue);
        return ((Object) str) + " " + split$default.get(0);
    }

    public final Pair<String, String> monthRange(String ym) {
        Integer intOrNull;
        Integer intOrNull2;
        Intrinsics.checkNotNullParameter(ym, "ym");
        List split$default = StringsKt.split$default((CharSequence) ym, new String[]{"-"}, false, 0, 6, (Object) null);
        String str = (String) CollectionsKt.getOrNull(split$default, 0);
        int year = (str == null || (intOrNull2 = StringsKt.toIntOrNull(str)) == null) ? LocalDate.now(STORE_ZONE).getYear() : intOrNull2.intValue();
        String str2 = (String) CollectionsKt.getOrNull(split$default, 1);
        LocalDate of = LocalDate.of(year, (str2 == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? LocalDate.now(STORE_ZONE).getMonthValue() : intOrNull.intValue(), 1);
        return TuplesKt.to(of.toString(), of.withDayOfMonth(of.lengthOfMonth()).toString());
    }

    public static /* synthetic */ List lastMonths$default(Fmt fmt, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 18;
        }
        return fmt.lastMonths(i);
    }

    public final List<String> lastMonths(int count) {
        LocalDate withDayOfMonth = LocalDate.now(STORE_ZONE).withDayOfMonth(1);
        IntRange until = RangesKt.until(0, count);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            String format = String.format("%04d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(withDayOfMonth.getYear()), Integer.valueOf(withDayOfMonth.getMonthValue())}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            withDayOfMonth = withDayOfMonth.minusMonths(1L);
            arrayList.add(format);
        }
        return arrayList;
    }

    public final String daysAgo(long days) {
        String localDate = LocalDate.now(STORE_ZONE).minusDays(days).toString();
        Intrinsics.checkNotNullExpressionValue(localDate, "toString(...)");
        return localDate;
    }

    public final String shortWeekday(String iso) {
        Object m7870constructorimpl;
        Intrinsics.checkNotNullParameter(iso, "iso");
        try {
            Result.Companion companion = Result.INSTANCE;
            Fmt fmt = this;
            m7870constructorimpl = Result.m7870constructorimpl(LocalDate.parse(iso));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7876isFailureimpl(m7870constructorimpl)) {
            m7870constructorimpl = null;
        }
        return ((LocalDate) m7870constructorimpl) == null ? "" : (String) CollectionsKt.listOf((Object[]) new String[]{LangKt.tx("пн", new Object[0]), LangKt.tx("вт", new Object[0]), LangKt.tx("ср", new Object[0]), LangKt.tx("чт", new Object[0]), LangKt.tx("пт", new Object[0]), LangKt.tx("сб", new Object[0]), LangKt.tx("вс", new Object[0])}).get(r9.getDayOfWeek().getValue() - 1);
    }

    public final String plural(int count, String one, String few, String many) {
        Intrinsics.checkNotNullParameter(one, "one");
        Intrinsics.checkNotNullParameter(few, "few");
        Intrinsics.checkNotNullParameter(many, "many");
        int abs = Math.abs(count) % 100;
        int i = abs % 10;
        if (11 > abs || abs >= 20) {
            if (i != 1) {
                if (2 <= i && i < 5) {
                    one = few;
                }
            }
            return count + " " + one;
        }
        one = many;
        return count + " " + one;
    }

    public final String asInt(Double value) {
        return String.valueOf(MathKt.roundToLong(value != null ? value.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE));
    }
}
