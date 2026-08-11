package androidx.compose.material3;

import androidx.compose.material3.internal.DateInputFormat;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* compiled from: DateInput.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012J.\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u00060 j\u0002`!ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/material3/DateInputValidator;", "", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "errorDatePattern", "", "errorDateOutOfYearRange", "errorInvalidNotAllowed", "errorInvalidRangeInput", "currentStartDateMillis", "", "currentEndDateMillis", "(Lkotlin/ranges/IntRange;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/internal/DateInputFormat;Landroidx/compose/material3/DatePickerFormatter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getCurrentEndDateMillis$material3_release", "()Ljava/lang/Long;", "setCurrentEndDateMillis$material3_release", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCurrentStartDateMillis$material3_release", "setCurrentStartDateMillis$material3_release", "validate", "dateToValidate", "Landroidx/compose/material3/internal/CalendarDate;", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "validate-XivgLIo", "(Landroidx/compose/material3/internal/CalendarDate;ILjava/util/Locale;)Ljava/lang/String;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class DateInputValidator {
    public static final int $stable = 0;
    private Long currentEndDateMillis;
    private Long currentStartDateMillis;
    private final DatePickerFormatter dateFormatter;
    private final DateInputFormat dateInputFormat;
    private final String errorDateOutOfYearRange;
    private final String errorDatePattern;
    private final String errorInvalidNotAllowed;
    private final String errorInvalidRangeInput;
    private final SelectableDates selectableDates;
    private final IntRange yearRange;

    public DateInputValidator(IntRange intRange, SelectableDates selectableDates, DateInputFormat dateInputFormat, DatePickerFormatter datePickerFormatter, String str, String str2, String str3, String str4, Long l, Long l2) {
        this.yearRange = intRange;
        this.selectableDates = selectableDates;
        this.dateInputFormat = dateInputFormat;
        this.dateFormatter = datePickerFormatter;
        this.errorDatePattern = str;
        this.errorDateOutOfYearRange = str2;
        this.errorInvalidNotAllowed = str3;
        this.errorInvalidRangeInput = str4;
        this.currentStartDateMillis = l;
        this.currentEndDateMillis = l2;
    }

    public /* synthetic */ DateInputValidator(IntRange intRange, SelectableDates selectableDates, DateInputFormat dateInputFormat, DatePickerFormatter datePickerFormatter, String str, String str2, String str3, String str4, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(intRange, selectableDates, dateInputFormat, datePickerFormatter, str, str2, str3, str4, (i & 256) != 0 ? null : l, (i & 512) != 0 ? null : l2);
    }

    /* renamed from: getCurrentStartDateMillis$material3_release, reason: from getter */
    public final Long getCurrentStartDateMillis() {
        return this.currentStartDateMillis;
    }

    public final void setCurrentStartDateMillis$material3_release(Long l) {
        this.currentStartDateMillis = l;
    }

    /* renamed from: getCurrentEndDateMillis$material3_release, reason: from getter */
    public final Long getCurrentEndDateMillis() {
        return this.currentEndDateMillis;
    }

    public final void setCurrentEndDateMillis$material3_release(Long l) {
        this.currentEndDateMillis = l;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0097, code lost:
    
        if (r0 < (r11 != null ? r11.longValue() : Long.MAX_VALUE)) goto L23;
     */
    /* renamed from: validate-XivgLIo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m2098validateXivgLIo(androidx.compose.material3.internal.CalendarDate r9, int r10, java.util.Locale r11) {
        /*
            r8 = this;
            r0 = 1
            java.lang.String r1 = "format(this, *args)"
            if (r9 != 0) goto L28
            java.lang.String r9 = r8.errorDatePattern
            androidx.compose.material3.internal.DateInputFormat r8 = r8.dateInputFormat
            java.lang.String r8 = r8.getPatternWithDelimiters()
            java.util.Locale r10 = java.util.Locale.ROOT
            java.lang.String r8 = r8.toUpperCase(r10)
            java.lang.String r10 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r10)
            java.lang.Object[] r8 = new java.lang.Object[]{r8}
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r0)
            java.lang.String r8 = java.lang.String.format(r9, r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            return r8
        L28:
            kotlin.ranges.IntRange r2 = r8.yearRange
            int r3 = r9.getYear()
            boolean r2 = r2.contains(r3)
            if (r2 != 0) goto L60
            java.lang.String r9 = r8.errorDateOutOfYearRange
            kotlin.ranges.IntRange r10 = r8.yearRange
            int r2 = r10.getFirst()
            r6 = 7
            r7 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            java.lang.String r10 = androidx.compose.material3.CalendarLocale_jvmKt.toLocalString$default(r2, r3, r4, r5, r6, r7)
            kotlin.ranges.IntRange r8 = r8.yearRange
            int r2 = r8.getLast()
            java.lang.String r8 = androidx.compose.material3.CalendarLocale_jvmKt.toLocalString$default(r2, r3, r4, r5, r6, r7)
            java.lang.Object[] r8 = new java.lang.Object[]{r10, r8}
            r10 = 2
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r10)
            java.lang.String r8 = java.lang.String.format(r9, r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            return r8
        L60:
            androidx.compose.material3.SelectableDates r2 = r8.selectableDates
            int r3 = r9.getYear()
            boolean r3 = r2.isSelectableYear(r3)
            if (r3 == 0) goto Lbe
            long r3 = r9.getUtcTimeMillis()
            boolean r2 = r2.isSelectableDate(r3)
            if (r2 != 0) goto L77
            goto Lbe
        L77:
            androidx.compose.material3.InputIdentifier$Companion r11 = androidx.compose.material3.InputIdentifier.INSTANCE
            int r11 = r11.m2281getStartDateInputJ2x2o4M()
            boolean r11 = androidx.compose.material3.InputIdentifier.m2275equalsimpl0(r10, r11)
            if (r11 == 0) goto L99
            long r0 = r9.getUtcTimeMillis()
            java.lang.Long r11 = r8.currentEndDateMillis
            if (r11 == 0) goto L90
            long r2 = r11.longValue()
            goto L95
        L90:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L95:
            int r11 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r11 >= 0) goto Lb8
        L99:
            androidx.compose.material3.InputIdentifier$Companion r11 = androidx.compose.material3.InputIdentifier.INSTANCE
            int r11 = r11.m2279getEndDateInputJ2x2o4M()
            boolean r10 = androidx.compose.material3.InputIdentifier.m2275equalsimpl0(r10, r11)
            if (r10 == 0) goto Lbb
            long r9 = r9.getUtcTimeMillis()
            java.lang.Long r11 = r8.currentStartDateMillis
            if (r11 == 0) goto Lb2
            long r0 = r11.longValue()
            goto Lb4
        Lb2:
            r0 = -9223372036854775808
        Lb4:
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 >= 0) goto Lbb
        Lb8:
            java.lang.String r8 = r8.errorInvalidRangeInput
            return r8
        Lbb:
            java.lang.String r8 = ""
            return r8
        Lbe:
            java.lang.String r10 = r8.errorInvalidNotAllowed
            androidx.compose.material3.DatePickerFormatter r2 = r8.dateFormatter
            long r8 = r9.getUtcTimeMillis()
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            r6 = 4
            r7 = 0
            r5 = 0
            r4 = r11
            java.lang.String r8 = androidx.compose.material3.DatePickerFormatter.formatDate$default(r2, r3, r4, r5, r6, r7)
            java.lang.Object[] r8 = new java.lang.Object[]{r8}
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r0)
            java.lang.String r8 = java.lang.String.format(r10, r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateInputValidator.m2098validateXivgLIo(androidx.compose.material3.internal.CalendarDate, int, java.util.Locale):java.lang.String");
    }
}
