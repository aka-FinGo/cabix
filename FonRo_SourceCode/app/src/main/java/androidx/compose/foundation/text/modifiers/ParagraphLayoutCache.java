package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.foundation.text.modifiers.MinLinesConstrainer;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphIntrinsicsKt;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: ParagraphLayoutCache.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\u0016\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u001fJ\"\u0010=\u001a\u0002012\u0006\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020\u001fH\u0000ø\u0001\u0000¢\u0006\u0004\b?\u0010@J \u0010A\u001a\u00020\u000b2\u0006\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020\u001fø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\b\u0010D\u001a\u00020,H\u0002J\u000e\u0010E\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u001fJ\u000e\u0010F\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u001fJ\"\u0010G\u001a\u00020\u000b2\u0006\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010CJ\u0010\u0010I\u001a\u0002072\u0006\u0010<\u001a\u00020\u001fH\u0002J\u0010\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010L\u001a\u00020\u0003H\u0016JH\u0010M\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rø\u0001\u0000¢\u0006\u0004\bN\u0010OJ,\u0010P\u001a\u0002092\u0006\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\bQ\u0010RR\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\u00020!X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\"R\"\u0010#\u001a\u00020$X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020,8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u0010\b\u001a\u00020\tX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00108\u001a\u000209X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006S"}, d2 = {"Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "cachedIntrinsicHeight", "cachedIntrinsicHeightInputWidth", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "didOverflow", "getDidOverflow$foundation_release", "()Z", "setDidOverflow$foundation_release", "(Z)V", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastDensity", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "J", "layoutSize", "Landroidx/compose/ui/unit/IntSize;", "getLayoutSize-YbymL2g$foundation_release", "()J", "setLayoutSize-ozmzZPI$foundation_release", "(J)V", "mMinLinesConstrainer", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "observeFontChanges", "", "getObserveFontChanges$foundation_release", "()Lkotlin/Unit;", "I", "paragraph", "Landroidx/compose/ui/text/Paragraph;", "getParagraph$foundation_release", "()Landroidx/compose/ui/text/Paragraph;", "setParagraph$foundation_release", "(Landroidx/compose/ui/text/Paragraph;)V", "paragraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "prevConstraints", "Landroidx/compose/ui/unit/Constraints;", "intrinsicHeight", "width", "layoutDirection", "layoutText", "constraints", "layoutText-K40F9xA$foundation_release", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/Paragraph;", "layoutWithConstraints", "layoutWithConstraints-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Z", "markDirty", "maxIntrinsicWidth", "minIntrinsicWidth", "newLayoutWillBeDifferent", "newLayoutWillBeDifferent-K40F9xA", "setLayoutDirection", "slowCreateTextLayoutResultOrNull", "Landroidx/compose/ui/text/TextLayoutResult;", "toString", "update", "update-L6sJoHM", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZII)V", "useMinLinesConstrainer", "useMinLinesConstrainer-euUD3Qg", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextStyle;)J", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ParagraphLayoutCache {
    public static final int $stable = 8;
    private int cachedIntrinsicHeight;
    private int cachedIntrinsicHeightInputWidth;
    private Density density;
    private boolean didOverflow;
    private FontFamily.Resolver fontFamilyResolver;
    private LayoutDirection intrinsicsLayoutDirection;
    private long lastDensity;
    private long layoutSize;
    private MinLinesConstrainer mMinLinesConstrainer;
    private int maxLines;
    private int minLines;
    private int overflow;
    private Paragraph paragraph;
    private ParagraphIntrinsics paragraphIntrinsics;
    private long prevConstraints;
    private boolean softWrap;
    private TextStyle style;
    private String text;

    public /* synthetic */ ParagraphLayoutCache(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, resolver, i, z, i2, i3);
    }

    private ParagraphLayoutCache(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3) {
        this.text = str;
        this.style = textStyle;
        this.fontFamilyResolver = resolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.lastDensity = InlineDensity.INSTANCE.m1718getUnspecifiedL26CHvs();
        this.layoutSize = IntSize.m7155constructorimpl(0L);
        this.prevConstraints = Constraints.INSTANCE.m6952fixedJhjzzOo(0, 0);
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
    }

    public /* synthetic */ ParagraphLayoutCache(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, resolver, (i4 & 8) != 0 ? TextOverflow.INSTANCE.m6924getClipgIe3tQ8() : i, (i4 & 16) != 0 ? true : z, (i4 & 32) != 0 ? Integer.MAX_VALUE : i2, (i4 & 64) != 0 ? 1 : i3, null);
    }

    /* renamed from: getDensity$foundation_release, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity$foundation_release(Density density) {
        Density density2 = this.density;
        long m1710constructorimpl = density != null ? InlineDensity.m1710constructorimpl(density) : InlineDensity.INSTANCE.m1718getUnspecifiedL26CHvs();
        if (density2 == null) {
            this.density = density;
            this.lastDensity = m1710constructorimpl;
        } else if (density == null || !InlineDensity.m1712equalsimpl0(this.lastDensity, m1710constructorimpl)) {
            this.density = density;
            this.lastDensity = m1710constructorimpl;
            markDirty();
        }
    }

    public final Unit getObserveFontChanges$foundation_release() {
        ParagraphIntrinsics paragraphIntrinsics = this.paragraphIntrinsics;
        if (paragraphIntrinsics != null) {
            paragraphIntrinsics.getHasStaleResolvedFonts();
        }
        return Unit.INSTANCE;
    }

    /* renamed from: getParagraph$foundation_release, reason: from getter */
    public final Paragraph getParagraph() {
        return this.paragraph;
    }

    public final void setParagraph$foundation_release(Paragraph paragraph) {
        this.paragraph = paragraph;
    }

    /* renamed from: getDidOverflow$foundation_release, reason: from getter */
    public final boolean getDidOverflow() {
        return this.didOverflow;
    }

    public final void setDidOverflow$foundation_release(boolean z) {
        this.didOverflow = z;
    }

    /* renamed from: getLayoutSize-YbymL2g$foundation_release, reason: not valid java name and from getter */
    public final long getLayoutSize() {
        return this.layoutSize;
    }

    /* renamed from: setLayoutSize-ozmzZPI$foundation_release, reason: not valid java name */
    public final void m1743setLayoutSizeozmzZPI$foundation_release(long j) {
        this.layoutSize = j;
    }

    /* renamed from: layoutWithConstraints-K40F9xA, reason: not valid java name */
    public final boolean m1742layoutWithConstraintsK40F9xA(long constraints, LayoutDirection layoutDirection) {
        ParagraphLayoutCache paragraphLayoutCache;
        LayoutDirection layoutDirection2;
        boolean z = true;
        if (this.minLines > 1) {
            paragraphLayoutCache = this;
            layoutDirection2 = layoutDirection;
            constraints = m1739useMinLinesConstrainereuUD3Qg$default(paragraphLayoutCache, constraints, layoutDirection2, null, 4, null);
        } else {
            paragraphLayoutCache = this;
            layoutDirection2 = layoutDirection;
        }
        boolean z2 = false;
        if (!paragraphLayoutCache.m1737newLayoutWillBeDifferentK40F9xA(constraints, layoutDirection2)) {
            if (!Constraints.m6935equalsimpl0(constraints, paragraphLayoutCache.prevConstraints)) {
                Paragraph paragraph = paragraphLayoutCache.paragraph;
                Intrinsics.checkNotNull(paragraph);
                paragraphLayoutCache.layoutSize = ConstraintsKt.m6956constrain4WqzIAM(constraints, IntSize.m7155constructorimpl((TextDelegateKt.ceilToIntPx(paragraph.getHeight()) & 4294967295L) | (TextDelegateKt.ceilToIntPx(Math.min(paragraph.getMaxIntrinsicWidth(), paragraph.getWidth())) << 32)));
                if (TextOverflow.m6915equalsimpl0(paragraphLayoutCache.overflow, TextOverflow.INSTANCE.m6928getVisiblegIe3tQ8()) || (((int) (r5 >> 32)) >= paragraph.getWidth() && ((int) (4294967295L & r5)) >= paragraph.getHeight())) {
                    z = false;
                }
                paragraphLayoutCache.didOverflow = z;
                paragraphLayoutCache.prevConstraints = constraints;
            }
            return false;
        }
        Paragraph m1741layoutTextK40F9xA$foundation_release = paragraphLayoutCache.m1741layoutTextK40F9xA$foundation_release(constraints, layoutDirection2);
        paragraphLayoutCache.prevConstraints = constraints;
        paragraphLayoutCache.layoutSize = ConstraintsKt.m6956constrain4WqzIAM(constraints, IntSize.m7155constructorimpl((TextDelegateKt.ceilToIntPx(m1741layoutTextK40F9xA$foundation_release.getHeight()) & 4294967295L) | (TextDelegateKt.ceilToIntPx(m1741layoutTextK40F9xA$foundation_release.getWidth()) << 32)));
        if (!TextOverflow.m6915equalsimpl0(paragraphLayoutCache.overflow, TextOverflow.INSTANCE.m6928getVisiblegIe3tQ8()) && (((int) (r10 >> 32)) < m1741layoutTextK40F9xA$foundation_release.getWidth() || ((int) (r10 & 4294967295L)) < m1741layoutTextK40F9xA$foundation_release.getHeight())) {
            z2 = true;
        }
        paragraphLayoutCache.didOverflow = z2;
        paragraphLayoutCache.paragraph = m1741layoutTextK40F9xA$foundation_release;
        return true;
    }

    /* renamed from: useMinLinesConstrainer-euUD3Qg$default, reason: not valid java name */
    static /* synthetic */ long m1739useMinLinesConstrainereuUD3Qg$default(ParagraphLayoutCache paragraphLayoutCache, long j, LayoutDirection layoutDirection, TextStyle textStyle, int i, Object obj) {
        if ((i & 4) != 0) {
            textStyle = paragraphLayoutCache.style;
        }
        return paragraphLayoutCache.m1738useMinLinesConstrainereuUD3Qg(j, layoutDirection, textStyle);
    }

    /* renamed from: useMinLinesConstrainer-euUD3Qg, reason: not valid java name */
    private final long m1738useMinLinesConstrainereuUD3Qg(long constraints, LayoutDirection layoutDirection, TextStyle style) {
        MinLinesConstrainer.Companion companion = MinLinesConstrainer.INSTANCE;
        MinLinesConstrainer minLinesConstrainer = this.mMinLinesConstrainer;
        Density density = this.density;
        Intrinsics.checkNotNull(density);
        MinLinesConstrainer from = companion.from(minLinesConstrainer, layoutDirection, style, density, this.fontFamilyResolver);
        this.mMinLinesConstrainer = from;
        return from.m1723coerceMinLinesOh53vG4$foundation_release(constraints, this.minLines);
    }

    public final int intrinsicHeight(int width, LayoutDirection layoutDirection) {
        ParagraphLayoutCache paragraphLayoutCache;
        LayoutDirection layoutDirection2;
        int i = this.cachedIntrinsicHeightInputWidth;
        int i2 = this.cachedIntrinsicHeight;
        if (width == i && i != -1) {
            return i2;
        }
        long Constraints = ConstraintsKt.Constraints(0, width, 0, Integer.MAX_VALUE);
        if (this.minLines > 1) {
            paragraphLayoutCache = this;
            layoutDirection2 = layoutDirection;
            Constraints = m1739useMinLinesConstrainereuUD3Qg$default(paragraphLayoutCache, Constraints, layoutDirection2, null, 4, null);
        } else {
            paragraphLayoutCache = this;
            layoutDirection2 = layoutDirection;
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(TextDelegateKt.ceilToIntPx(paragraphLayoutCache.m1741layoutTextK40F9xA$foundation_release(Constraints, layoutDirection2).getHeight()), Constraints.m6943getMinHeightimpl(Constraints));
        paragraphLayoutCache.cachedIntrinsicHeightInputWidth = width;
        paragraphLayoutCache.cachedIntrinsicHeight = coerceAtLeast;
        return coerceAtLeast;
    }

    /* renamed from: update-L6sJoHM, reason: not valid java name */
    public final void m1744updateL6sJoHM(String text, TextStyle style, FontFamily.Resolver fontFamilyResolver, int overflow, boolean softWrap, int maxLines, int minLines) {
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.overflow = overflow;
        this.softWrap = softWrap;
        this.maxLines = maxLines;
        this.minLines = minLines;
        markDirty();
    }

    private final ParagraphIntrinsics setLayoutDirection(LayoutDirection layoutDirection) {
        ParagraphIntrinsics paragraphIntrinsics = this.paragraphIntrinsics;
        if (paragraphIntrinsics == null || layoutDirection != this.intrinsicsLayoutDirection || paragraphIntrinsics.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            String str = this.text;
            TextStyle resolveDefaults = TextStyleKt.resolveDefaults(this.style, layoutDirection);
            List emptyList = CollectionsKt.emptyList();
            Density density = this.density;
            Intrinsics.checkNotNull(density);
            paragraphIntrinsics = ParagraphIntrinsicsKt.ParagraphIntrinsics(str, resolveDefaults, (List<? extends AnnotatedString.Range<? extends AnnotatedString.Annotation>>) emptyList, density, this.fontFamilyResolver, (List<AnnotatedString.Range<Placeholder>>) CollectionsKt.emptyList());
        }
        this.paragraphIntrinsics = paragraphIntrinsics;
        return paragraphIntrinsics;
    }

    /* renamed from: layoutText-K40F9xA$foundation_release, reason: not valid java name */
    public final Paragraph m1741layoutTextK40F9xA$foundation_release(long constraints, LayoutDirection layoutDirection) {
        ParagraphIntrinsics layoutDirection2 = setLayoutDirection(layoutDirection);
        return ParagraphKt.m6308ParagraphczeNHc(layoutDirection2, LayoutUtilsKt.m1719finalConstraintstfFHcEY(constraints, this.softWrap, this.overflow, layoutDirection2.getMaxIntrinsicWidth()), LayoutUtilsKt.m1720finalMaxLinesxdlQI24(this.softWrap, this.overflow, this.maxLines), this.overflow);
    }

    /* renamed from: newLayoutWillBeDifferent-K40F9xA, reason: not valid java name */
    private final boolean m1737newLayoutWillBeDifferentK40F9xA(long constraints, LayoutDirection layoutDirection) {
        ParagraphIntrinsics paragraphIntrinsics;
        Paragraph paragraph = this.paragraph;
        if (paragraph == null || (paragraphIntrinsics = this.paragraphIntrinsics) == null || paragraphIntrinsics.getHasStaleResolvedFonts() || layoutDirection != this.intrinsicsLayoutDirection) {
            return true;
        }
        if (Constraints.m6935equalsimpl0(constraints, this.prevConstraints)) {
            return false;
        }
        return Constraints.m6942getMaxWidthimpl(constraints) != Constraints.m6942getMaxWidthimpl(this.prevConstraints) || Constraints.m6944getMinWidthimpl(constraints) != Constraints.m6944getMinWidthimpl(this.prevConstraints) || ((float) Constraints.m6941getMaxHeightimpl(constraints)) < paragraph.getHeight() || paragraph.getDidExceedMaxLines();
    }

    private final void markDirty() {
        this.paragraph = null;
        this.paragraphIntrinsics = null;
        this.intrinsicsLayoutDirection = null;
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
        this.prevConstraints = Constraints.INSTANCE.m6952fixedJhjzzOo(0, 0);
        this.layoutSize = IntSize.m7155constructorimpl(0L);
        this.didOverflow = false;
    }

    public final TextLayoutResult slowCreateTextLayoutResultOrNull(TextStyle style) {
        Density density;
        LayoutDirection layoutDirection = this.intrinsicsLayoutDirection;
        if (layoutDirection == null || (density = this.density) == null) {
            return null;
        }
        AnnotatedString annotatedString = new AnnotatedString(this.text, null, 2, null);
        if (this.paragraph == null || this.paragraphIntrinsics == null) {
            return null;
        }
        long m6930constructorimpl = Constraints.m6930constructorimpl(this.prevConstraints & ConstraintsKt.MaxDimensionsAndFocusMask);
        return new TextLayoutResult(new TextLayoutInput(annotatedString, style, CollectionsKt.emptyList(), this.maxLines, this.softWrap, this.overflow, density, layoutDirection, this.fontFamilyResolver, m6930constructorimpl, (DefaultConstructorMarker) null), new MultiParagraph(new MultiParagraphIntrinsics(annotatedString, style, (List<AnnotatedString.Range<Placeholder>>) CollectionsKt.emptyList(), density, this.fontFamilyResolver), m6930constructorimpl, this.maxLines, this.overflow, (DefaultConstructorMarker) null), this.layoutSize, null);
    }

    public final int minIntrinsicWidth(LayoutDirection layoutDirection) {
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMinIntrinsicWidth());
    }

    public final int maxIntrinsicWidth(LayoutDirection layoutDirection) {
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMaxIntrinsicWidth());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ParagraphLayoutCache(paragraph=");
        sb.append(this.paragraph != null ? "<paragraph>" : AbstractJsonLexerKt.NULL);
        sb.append(", lastDensity=");
        sb.append((Object) InlineDensity.m1716toStringimpl(this.lastDensity));
        sb.append(')');
        return sb.toString();
    }
}
