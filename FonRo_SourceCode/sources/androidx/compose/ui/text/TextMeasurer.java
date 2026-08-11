package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TextMeasurer.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u008a\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#Jt\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020$2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"Landroidx/compose/ui/text/TextMeasurer;", "", "defaultFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "defaultDensity", "Landroidx/compose/ui/unit/Density;", "defaultLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "cacheSize", "", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;I)V", "textLayoutCache", "Landroidx/compose/ui/text/TextLayoutCache;", "measure", "Landroidx/compose/ui/text/TextLayoutResult;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "density", "fontFamilyResolver", "skipCache", "measure-xDpz5zY", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IZILjava/util/List;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "", "measure-wNUYSr0", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;IZIJLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "Companion", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class TextMeasurer {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int cacheSize;
    private final Density defaultDensity;
    private final FontFamily.Resolver defaultFontFamilyResolver;
    private final LayoutDirection defaultLayoutDirection;
    private final TextLayoutCache textLayoutCache;

    public TextMeasurer(FontFamily.Resolver resolver, Density density, LayoutDirection layoutDirection, int i) {
        this.defaultFontFamilyResolver = resolver;
        this.defaultDensity = density;
        this.defaultLayoutDirection = layoutDirection;
        this.cacheSize = i;
        this.textLayoutCache = i > 0 ? new TextLayoutCache(i) : null;
    }

    public /* synthetic */ TextMeasurer(FontFamily.Resolver resolver, Density density, LayoutDirection layoutDirection, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(resolver, density, layoutDirection, (i2 & 8) != 0 ? 8 : i);
    }

    /* renamed from: measure-xDpz5zY$default */
    public static /* synthetic */ TextLayoutResult m6409measurexDpz5zY$default(TextMeasurer textMeasurer, AnnotatedString annotatedString, TextStyle textStyle, int i, boolean z, int i2, List list, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            textStyle = TextStyle.INSTANCE.getDefault();
        }
        return textMeasurer.m6411measurexDpz5zY(annotatedString, textStyle, (i3 & 4) != 0 ? TextOverflow.INSTANCE.m6924getClipgIe3tQ8() : i, (i3 & 8) != 0 ? true : z, (i3 & 16) != 0 ? Integer.MAX_VALUE : i2, (i3 & 32) != 0 ? CollectionsKt.emptyList() : list, (i3 & 64) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null) : j, (i3 & 128) != 0 ? textMeasurer.defaultLayoutDirection : layoutDirection, (i3 & 256) != 0 ? textMeasurer.defaultDensity : density, (i3 & 512) != 0 ? textMeasurer.defaultFontFamilyResolver : resolver, (i3 & 1024) != 0 ? false : z2);
    }

    /* renamed from: measure-xDpz5zY */
    public final TextLayoutResult m6411measurexDpz5zY(AnnotatedString text, TextStyle style, int overflow, boolean softWrap, int maxLines, List<AnnotatedString.Range<Placeholder>> placeholders, long constraints, LayoutDirection layoutDirection, Density density, FontFamily.Resolver fontFamilyResolver, boolean skipCache) {
        TextLayoutCache textLayoutCache;
        TextLayoutInput textLayoutInput = new TextLayoutInput(text, style, placeholders, maxLines, softWrap, overflow, density, layoutDirection, fontFamilyResolver, constraints, (DefaultConstructorMarker) null);
        TextLayoutResult textLayoutResult = (skipCache || (textLayoutCache = this.textLayoutCache) == null) ? null : textLayoutCache.get(textLayoutInput);
        if (textLayoutResult != null) {
            return textLayoutResult.m6404copyO0kMr_c(textLayoutInput, ConstraintsKt.m6956constrain4WqzIAM(constraints, IntSize.m7155constructorimpl((ParagraphKt.ceilToInt(textLayoutResult.getMultiParagraph().getWidth()) << 32) | (ParagraphKt.ceilToInt(textLayoutResult.getMultiParagraph().getHeight()) & 4294967295L))));
        }
        TextLayoutResult layout = INSTANCE.layout(textLayoutInput);
        TextLayoutCache textLayoutCache2 = this.textLayoutCache;
        if (textLayoutCache2 != null) {
            textLayoutCache2.put(textLayoutInput, layout);
        }
        return layout;
    }

    /* renamed from: measure-wNUYSr0$default */
    public static /* synthetic */ TextLayoutResult m6408measurewNUYSr0$default(TextMeasurer textMeasurer, String str, TextStyle textStyle, int i, boolean z, int i2, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            textStyle = TextStyle.INSTANCE.getDefault();
        }
        TextStyle textStyle2 = textStyle;
        if ((i3 & 4) != 0) {
            i = TextOverflow.INSTANCE.m6924getClipgIe3tQ8();
        }
        return textMeasurer.m6410measurewNUYSr0(str, textStyle2, i, (i3 & 8) != 0 ? true : z, (i3 & 16) != 0 ? Integer.MAX_VALUE : i2, (i3 & 32) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null) : j, (i3 & 64) != 0 ? textMeasurer.defaultLayoutDirection : layoutDirection, (i3 & 128) != 0 ? textMeasurer.defaultDensity : density, (i3 & 256) != 0 ? textMeasurer.defaultFontFamilyResolver : resolver, (i3 & 512) != 0 ? false : z2);
    }

    /* renamed from: measure-wNUYSr0 */
    public final TextLayoutResult m6410measurewNUYSr0(String text, TextStyle style, int overflow, boolean softWrap, int maxLines, long constraints, LayoutDirection layoutDirection, Density density, FontFamily.Resolver fontFamilyResolver, boolean skipCache) {
        return m6409measurexDpz5zY$default(this, new AnnotatedString(text, null, 2, null), style, overflow, softWrap, maxLines, null, constraints, layoutDirection, density, fontFamilyResolver, skipCache, 32, null);
    }

    /* compiled from: TextMeasurer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/TextMeasurer$Companion;", "", "()V", "layout", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x0037, code lost:
        
            if (r1 != false) goto L28;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0055  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.compose.ui.text.TextLayoutResult layout(androidx.compose.ui.text.TextLayoutInput r14) {
            /*
                r13 = this;
                androidx.compose.ui.text.AnnotatedString r1 = r14.getText()
                androidx.compose.ui.text.TextStyle r13 = r14.getStyle()
                androidx.compose.ui.unit.LayoutDirection r0 = r14.getLayoutDirection()
                androidx.compose.ui.text.TextStyle r2 = androidx.compose.ui.text.TextStyleKt.resolveDefaults(r13, r0)
                androidx.compose.ui.unit.Density r4 = r14.getDensity()
                androidx.compose.ui.text.font.FontFamily$Resolver r5 = r14.getFontFamilyResolver()
                java.util.List r3 = r14.getPlaceholders()
                androidx.compose.ui.text.MultiParagraphIntrinsics r0 = new androidx.compose.ui.text.MultiParagraphIntrinsics
                r0.<init>(r1, r2, r3, r4, r5)
                long r1 = r14.getConstraints()
                int r13 = androidx.compose.ui.unit.Constraints.m6944getMinWidthimpl(r1)
                boolean r1 = r14.getSoftWrap()
                if (r1 != 0) goto L39
                int r1 = r14.getOverflow()
                boolean r1 = androidx.compose.ui.text.TextMeasurerKt.m6412access$isEllipsisMW5ApA(r1)
                if (r1 == 0) goto L4c
            L39:
                long r1 = r14.getConstraints()
                boolean r1 = androidx.compose.ui.unit.Constraints.m6938getHasBoundedWidthimpl(r1)
                if (r1 == 0) goto L4c
                long r1 = r14.getConstraints()
                int r1 = androidx.compose.ui.unit.Constraints.m6942getMaxWidthimpl(r1)
                goto L4f
            L4c:
                r1 = 2147483647(0x7fffffff, float:NaN)
            L4f:
                boolean r2 = r14.getSoftWrap()
                if (r2 != 0) goto L61
                int r2 = r14.getOverflow()
                boolean r2 = androidx.compose.ui.text.TextMeasurerKt.m6412access$isEllipsisMW5ApA(r2)
                if (r2 == 0) goto L61
                r2 = 1
                goto L65
            L61:
                int r2 = r14.getMaxLines()
            L65:
                r10 = r2
                if (r13 != r1) goto L69
                goto L75
            L69:
                float r2 = r0.getMaxIntrinsicWidth()
                int r2 = androidx.compose.ui.text.ParagraphKt.ceilToInt(r2)
                int r1 = kotlin.ranges.RangesKt.coerceIn(r2, r13, r1)
            L75:
                androidx.compose.ui.text.MultiParagraph r4 = new androidx.compose.ui.text.MultiParagraph
                androidx.compose.ui.unit.Constraints$Companion r13 = androidx.compose.ui.unit.Constraints.INSTANCE
                long r2 = r14.getConstraints()
                int r2 = androidx.compose.ui.unit.Constraints.m6941getMaxHeightimpl(r2)
                r3 = 0
                long r8 = r13.m6951fitPrioritizingWidthZbe2FdA(r3, r1, r3, r2)
                int r11 = r14.getOverflow()
                r12 = 0
                r7 = r0
                r6 = r4
                r6.<init>(r7, r8, r10, r11, r12)
                androidx.compose.ui.text.TextLayoutResult r2 = new androidx.compose.ui.text.TextLayoutResult
                long r0 = r14.getConstraints()
                float r13 = r4.getWidth()
                double r5 = (double) r13
                double r5 = java.lang.Math.ceil(r5)
                float r13 = (float) r5
                int r13 = (int) r13
                float r3 = r4.getHeight()
                double r5 = (double) r3
                double r5 = java.lang.Math.ceil(r5)
                float r3 = (float) r5
                int r3 = (int) r3
                long r5 = (long) r13
                r13 = 32
                long r5 = r5 << r13
                long r7 = (long) r3
                r9 = 4294967295(0xffffffff, double:2.1219957905E-314)
                long r7 = r7 & r9
                long r5 = r5 | r7
                long r5 = androidx.compose.ui.unit.IntSize.m7155constructorimpl(r5)
                long r5 = androidx.compose.ui.unit.ConstraintsKt.m6956constrain4WqzIAM(r0, r5)
                r7 = 0
                r3 = r14
                r2.<init>(r3, r4, r5, r7)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextMeasurer.Companion.layout(androidx.compose.ui.text.TextLayoutInput):androidx.compose.ui.text.TextLayoutResult");
        }
    }
}
