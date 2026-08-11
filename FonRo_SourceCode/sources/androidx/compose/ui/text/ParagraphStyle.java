package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: ParagraphStyle.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bq\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014B5\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0015BM\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0016Be\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0017Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0018Jr\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013ø\u0001\u0000¢\u0006\u0004\b<\u0010=J@\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007ø\u0001\u0000¢\u0006\u0004\b>\u0010?JX\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007ø\u0001\u0000¢\u0006\u0004\b@\u0010AJp\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ|\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0096\u0002J\b\u0010J\u001a\u00020KH\u0016J\u0014\u0010L\u001a\u00020\u00002\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0000H\u0007J\u0011\u0010M\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\u0000H\u0087\u0002J\b\u0010N\u001a\u00020OH\u0016R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00118GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u0004\u0018\u00010\u000f8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010!R\"\u0010\"\u001a\u0004\u0018\u00010\u00038GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010%R\"\u0010&\u001a\u0004\u0018\u00010\u00058GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010)R\u0019\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0019\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010,\u001a\u0004\b-\u0010+R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010,\u001a\u0004\b5\u0010+R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010,\u001a\u0004\b6\u0010+R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006P"}, d2 = {"Landroidx/compose/ui/text/ParagraphStyle;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "Landroidx/compose/ui/unit/TextUnit;", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "platformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "deprecated_boxing_hyphens", "getHyphens-EaSxIns$annotations", "()V", "getHyphens-EaSxIns", "()Landroidx/compose/ui/text/style/Hyphens;", "deprecated_boxing_lineBreak", "getLineBreak-LgCVezo$annotations", "getLineBreak-LgCVezo", "()Landroidx/compose/ui/text/style/LineBreak;", "deprecated_boxing_textAlign", "getTextAlign-buA522U$annotations", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "deprecated_boxing_textDirection", "getTextDirection-mmuk1to$annotations", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getHyphens-vmbZdU8", "()I", "I", "getLineBreak-rAG3T2k", "getLineHeight-XSAIIZE", "()J", "J", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformParagraphStyle;", "getTextAlign-e0LSkKk", "getTextDirection-s_7X-co", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "getTextMotion", "()Landroidx/compose/ui/text/style/TextMotion;", "copy", "copy-ykzQM6k", "(IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-Elsmlbk", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-xPh5V4g", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-ciSxzs0", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-NH1kkwU", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "equals", "", WriteOffReason.OTHER, "", "hashCode", "", "merge", "plus", "toString", "", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class ParagraphStyle implements AnnotatedString.Annotation {
    public static final int $stable = 0;
    private final int hyphens;
    private final int lineBreak;
    private final long lineHeight;
    private final LineHeightStyle lineHeightStyle;
    private final PlatformParagraphStyle platformStyle;
    private final int textAlign;
    private final int textDirection;
    private final TextIndent textIndent;
    private final TextMotion textMotion;

    public /* synthetic */ ParagraphStyle(int i, int i2, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, j, textIndent, platformParagraphStyle, lineHeightStyle, i3, i4, textMotion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign, textDirection, j, textIndent, platformParagraphStyle, lineHeightStyle, lineBreak, hyphens, textMotion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that do not take new stable parameters like LineBreak, Hyphens, TextMotion are deprecated. Please use the new stable constructors.")
    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign, textDirection, j, textIndent, platformParagraphStyle, lineHeightStyle, lineBreak, hyphens);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructors.")
    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign, textDirection, j, textIndent, platformParagraphStyle, lineHeightStyle);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.")
    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign, textDirection, j, textIndent);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* renamed from: getHyphens-EaSxIns$annotations, reason: not valid java name */
    public static /* synthetic */ void m6315getHyphensEaSxIns$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* renamed from: getLineBreak-LgCVezo$annotations, reason: not valid java name */
    public static /* synthetic */ void m6316getLineBreakLgCVezo$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* renamed from: getTextAlign-buA522U$annotations, reason: not valid java name */
    public static /* synthetic */ void m6317getTextAlignbuA522U$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* renamed from: getTextDirection-mmuk1to$annotations, reason: not valid java name */
    public static /* synthetic */ void m6318getTextDirectionmmuk1to$annotations() {
    }

    private ParagraphStyle(int i, int i2, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        this.textAlign = i;
        this.textDirection = i2;
        this.lineHeight = j;
        this.textIndent = textIndent;
        this.platformStyle = platformParagraphStyle;
        this.lineHeightStyle = lineHeightStyle;
        this.lineBreak = i3;
        this.hyphens = i4;
        this.textMotion = textMotion;
        if (TextUnit.m7180equalsimpl0(j, TextUnit.INSTANCE.m7194getUnspecifiedXSAIIZE())) {
            return;
        }
        if (TextUnit.m7183getValueimpl(j) >= 0.0f) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("lineHeight can't be negative (" + TextUnit.m7183getValueimpl(j) + ')');
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ ParagraphStyle(int r12, int r13, long r14, androidx.compose.ui.text.style.TextIndent r16, androidx.compose.ui.text.PlatformParagraphStyle r17, androidx.compose.ui.text.style.LineHeightStyle r18, int r19, int r20, androidx.compose.ui.text.style.TextMotion r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            if (r1 == 0) goto Ld
            androidx.compose.ui.text.style.TextAlign$Companion r1 = androidx.compose.ui.text.style.TextAlign.INSTANCE
            int r1 = r1.m6879getUnspecifiede0LSkKk()
            goto Le
        Ld:
            r1 = r12
        Le:
            r2 = r0 & 2
            if (r2 == 0) goto L19
            androidx.compose.ui.text.style.TextDirection$Companion r2 = androidx.compose.ui.text.style.TextDirection.INSTANCE
            int r2 = r2.m6892getUnspecifieds_7Xco()
            goto L1a
        L19:
            r2 = r13
        L1a:
            r3 = r0 & 4
            if (r3 == 0) goto L25
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.INSTANCE
            long r3 = r3.m7194getUnspecifiedXSAIIZE()
            goto L26
        L25:
            r3 = r14
        L26:
            r5 = r0 & 8
            r6 = 0
            if (r5 == 0) goto L2d
            r5 = r6
            goto L2f
        L2d:
            r5 = r16
        L2f:
            r7 = r0 & 16
            if (r7 == 0) goto L35
            r7 = r6
            goto L37
        L35:
            r7 = r17
        L37:
            r8 = r0 & 32
            if (r8 == 0) goto L3d
            r8 = r6
            goto L3f
        L3d:
            r8 = r18
        L3f:
            r9 = r0 & 64
            if (r9 == 0) goto L4a
            androidx.compose.ui.text.style.LineBreak$Companion r9 = androidx.compose.ui.text.style.LineBreak.INSTANCE
            int r9 = r9.m6794getUnspecifiedrAG3T2k()
            goto L4c
        L4a:
            r9 = r19
        L4c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L57
            androidx.compose.ui.text.style.Hyphens$Companion r10 = androidx.compose.ui.text.style.Hyphens.INSTANCE
            int r10 = r10.m6773getUnspecifiedvmbZdU8()
            goto L59
        L57:
            r10 = r20
        L59:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L5e
            goto L60
        L5e:
            r6 = r21
        L60:
            r0 = 0
            r12 = r11
            r23 = r0
            r13 = r1
            r14 = r2
            r15 = r3
            r17 = r5
            r22 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r12.<init>(r13, r14, r15, r17, r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.ParagraphStyle.<init>(int, int, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformParagraphStyle, androidx.compose.ui.text.style.LineHeightStyle, int, int, androidx.compose.ui.text.style.TextMotion, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getTextAlign-e0LSkKk, reason: not valid java name and from getter */
    public final int getTextAlign() {
        return this.textAlign;
    }

    /* renamed from: getTextDirection-s_7X-co, reason: not valid java name and from getter */
    public final int getTextDirection() {
        return this.textDirection;
    }

    /* renamed from: getLineHeight-XSAIIZE, reason: not valid java name and from getter */
    public final long getLineHeight() {
        return this.lineHeight;
    }

    public final TextIndent getTextIndent() {
        return this.textIndent;
    }

    public final PlatformParagraphStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.lineHeightStyle;
    }

    /* renamed from: getLineBreak-rAG3T2k, reason: not valid java name and from getter */
    public final int getLineBreak() {
        return this.lineBreak;
    }

    /* renamed from: getHyphens-vmbZdU8, reason: not valid java name and from getter */
    public final int getHyphens() {
        return this.hyphens;
    }

    public final TextMotion getTextMotion() {
        return this.textMotion;
    }

    /* renamed from: getTextAlign-buA522U, reason: not valid java name */
    public final TextAlign m6329getTextAlignbuA522U() {
        return TextAlign.m6866boximpl(this.textAlign);
    }

    /* renamed from: getTextDirection-mmuk1to, reason: not valid java name */
    public final TextDirection m6331getTextDirectionmmuk1to() {
        return TextDirection.m6880boximpl(this.textDirection);
    }

    /* renamed from: getHyphens-EaSxIns, reason: not valid java name */
    public final Hyphens m6324getHyphensEaSxIns() {
        return Hyphens.m6764boximpl(this.hyphens);
    }

    /* renamed from: getLineBreak-LgCVezo, reason: not valid java name */
    public final LineBreak m6326getLineBreakLgCVezo() {
        return LineBreak.m6774boximpl(this.lineBreak);
    }

    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textAlign, (i & 2) != 0 ? null : textDirection, (i & 4) != 0 ? TextUnit.INSTANCE.m7194getUnspecifiedXSAIIZE() : j, (i & 8) != 0 ? null : textIndent, (i & 16) != 0 ? null : platformParagraphStyle, (i & 32) != 0 ? null : lineHeightStyle, (i & 64) != 0 ? null : lineBreak, (i & 128) != 0 ? null : hyphens, (i & 256) != 0 ? null : textMotion, (DefaultConstructorMarker) null);
    }

    private ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        this(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6879getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6892getUnspecifieds_7Xco(), j, textIndent, platformParagraphStyle, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m6794getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m6773getUnspecifiedvmbZdU8(), textMotion, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textAlign, (i & 2) != 0 ? null : textDirection, (i & 4) != 0 ? TextUnit.INSTANCE.m7194getUnspecifiedXSAIIZE() : j, (i & 8) != 0 ? null : textIndent, null);
    }

    private ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent) {
        this(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6879getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6892getUnspecifieds_7Xco(), j, textIndent, (PlatformParagraphStyle) null, (LineHeightStyle) null, LineBreak.INSTANCE.m6794getUnspecifiedrAG3T2k(), Hyphens.INSTANCE.m6773getUnspecifiedvmbZdU8(), (TextMotion) null, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textAlign, (i & 2) != 0 ? null : textDirection, (i & 4) != 0 ? TextUnit.INSTANCE.m7194getUnspecifiedXSAIIZE() : j, (i & 8) != 0 ? null : textIndent, (i & 16) != 0 ? null : platformParagraphStyle, (i & 32) != 0 ? null : lineHeightStyle, null);
    }

    private ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle) {
        this(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6879getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6892getUnspecifieds_7Xco(), j, textIndent, platformParagraphStyle, lineHeightStyle, LineBreak.INSTANCE.m6794getUnspecifiedrAG3T2k(), Hyphens.INSTANCE.m6773getUnspecifiedvmbZdU8(), (TextMotion) null, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textAlign, (i & 2) != 0 ? null : textDirection, (i & 4) != 0 ? TextUnit.INSTANCE.m7194getUnspecifiedXSAIIZE() : j, (i & 8) != 0 ? null : textIndent, (i & 16) != 0 ? null : platformParagraphStyle, (i & 32) != 0 ? null : lineHeightStyle, (i & 64) != 0 ? null : lineBreak, (i & 128) != 0 ? null : hyphens, (DefaultConstructorMarker) null);
    }

    private ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens) {
        this(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6879getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6892getUnspecifieds_7Xco(), j, textIndent, platformParagraphStyle, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m6794getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m6773getUnspecifiedvmbZdU8(), (TextMotion) null, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ParagraphStyle merge$default(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            paragraphStyle2 = null;
        }
        return paragraphStyle.merge(paragraphStyle2);
    }

    public final ParagraphStyle merge(ParagraphStyle other) {
        return other == null ? this : ParagraphStyleKt.m6333fastMergej5T8yCg(this, other.textAlign, other.textDirection, other.lineHeight, other.textIndent, other.platformStyle, other.lineHeightStyle, other.lineBreak, other.hyphens, other.textMotion);
    }

    public final ParagraphStyle plus(ParagraphStyle other) {
        return merge(other);
    }

    /* renamed from: copy-Elsmlbk$default, reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m6310copyElsmlbk$default(ParagraphStyle paragraphStyle, TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, int i, Object obj) {
        if ((i & 1) != 0) {
            textAlign = TextAlign.m6866boximpl(paragraphStyle.textAlign);
        }
        if ((i & 2) != 0) {
            textDirection = TextDirection.m6880boximpl(paragraphStyle.textDirection);
        }
        if ((i & 4) != 0) {
            j = paragraphStyle.lineHeight;
        }
        if ((i & 8) != 0) {
            textIndent = paragraphStyle.textIndent;
        }
        TextIndent textIndent2 = textIndent;
        return paragraphStyle.m6319copyElsmlbk(textAlign, textDirection, j, textIndent2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-Elsmlbk, reason: not valid java name */
    public final /* synthetic */ ParagraphStyle m6319copyElsmlbk(TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent) {
        return new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6879getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6892getUnspecifieds_7Xco(), lineHeight, textIndent, this.platformStyle, this.lineHeightStyle, this.lineBreak, this.hyphens, this.textMotion, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-xPh5V4g$default, reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m6313copyxPh5V4g$default(ParagraphStyle paragraphStyle, TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i, Object obj) {
        if ((i & 1) != 0) {
            textAlign = TextAlign.m6866boximpl(paragraphStyle.textAlign);
        }
        if ((i & 2) != 0) {
            textDirection = TextDirection.m6880boximpl(paragraphStyle.textDirection);
        }
        if ((i & 4) != 0) {
            j = paragraphStyle.lineHeight;
        }
        if ((i & 8) != 0) {
            textIndent = paragraphStyle.textIndent;
        }
        if ((i & 16) != 0) {
            platformParagraphStyle = paragraphStyle.platformStyle;
        }
        if ((i & 32) != 0) {
            lineHeightStyle = paragraphStyle.lineHeightStyle;
        }
        LineHeightStyle lineHeightStyle2 = lineHeightStyle;
        TextIndent textIndent2 = textIndent;
        long j2 = j;
        return paragraphStyle.m6322copyxPh5V4g(textAlign, textDirection, j2, textIndent2, platformParagraphStyle, lineHeightStyle2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-xPh5V4g, reason: not valid java name */
    public final /* synthetic */ ParagraphStyle m6322copyxPh5V4g(TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, PlatformParagraphStyle platformStyle, LineHeightStyle lineHeightStyle) {
        return new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6879getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6892getUnspecifieds_7Xco(), lineHeight, textIndent, platformStyle, lineHeightStyle, this.lineBreak, this.hyphens, this.textMotion, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-ciSxzs0$default, reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m6312copyciSxzs0$default(ParagraphStyle paragraphStyle, TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, int i, Object obj) {
        if ((i & 1) != 0) {
            textAlign = TextAlign.m6866boximpl(paragraphStyle.textAlign);
        }
        if ((i & 2) != 0) {
            textDirection = TextDirection.m6880boximpl(paragraphStyle.textDirection);
        }
        if ((i & 4) != 0) {
            j = paragraphStyle.lineHeight;
        }
        if ((i & 8) != 0) {
            textIndent = paragraphStyle.textIndent;
        }
        if ((i & 16) != 0) {
            platformParagraphStyle = paragraphStyle.platformStyle;
        }
        if ((i & 32) != 0) {
            lineHeightStyle = paragraphStyle.lineHeightStyle;
        }
        if ((i & 64) != 0) {
            lineBreak = LineBreak.m6774boximpl(paragraphStyle.lineBreak);
        }
        if ((i & 128) != 0) {
            hyphens = Hyphens.m6764boximpl(paragraphStyle.hyphens);
        }
        Hyphens hyphens2 = hyphens;
        LineHeightStyle lineHeightStyle2 = lineHeightStyle;
        TextIndent textIndent2 = textIndent;
        long j2 = j;
        return paragraphStyle.m6321copyciSxzs0(textAlign, textDirection, j2, textIndent2, platformParagraphStyle, lineHeightStyle2, lineBreak, hyphens2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that do not take new stable parameters like LineBreak, Hyphens, TextMotion are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-ciSxzs0, reason: not valid java name */
    public final /* synthetic */ ParagraphStyle m6321copyciSxzs0(TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, PlatformParagraphStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens) {
        return new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6879getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6892getUnspecifieds_7Xco(), lineHeight, textIndent, platformStyle, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m6794getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m6773getUnspecifiedvmbZdU8(), this.textMotion, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-NH1kkwU$default, reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m6311copyNH1kkwU$default(ParagraphStyle paragraphStyle, TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, Object obj) {
        if ((i & 1) != 0) {
            textAlign = TextAlign.m6866boximpl(paragraphStyle.textAlign);
        }
        if ((i & 2) != 0) {
            textDirection = TextDirection.m6880boximpl(paragraphStyle.textDirection);
        }
        if ((i & 4) != 0) {
            j = paragraphStyle.lineHeight;
        }
        if ((i & 8) != 0) {
            textIndent = paragraphStyle.textIndent;
        }
        if ((i & 16) != 0) {
            platformParagraphStyle = paragraphStyle.platformStyle;
        }
        if ((i & 32) != 0) {
            lineHeightStyle = paragraphStyle.lineHeightStyle;
        }
        if ((i & 64) != 0) {
            lineBreak = LineBreak.m6774boximpl(paragraphStyle.lineBreak);
        }
        if ((i & 128) != 0) {
            hyphens = Hyphens.m6764boximpl(paragraphStyle.hyphens);
        }
        if ((i & 256) != 0) {
            textMotion = paragraphStyle.textMotion;
        }
        Hyphens hyphens2 = hyphens;
        TextMotion textMotion2 = textMotion;
        long j2 = j;
        return paragraphStyle.m6320copyNH1kkwU(textAlign, textDirection, j2, textIndent, platformParagraphStyle, lineHeightStyle, lineBreak, hyphens2, textMotion2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    /* renamed from: copy-NH1kkwU, reason: not valid java name */
    public final /* synthetic */ ParagraphStyle m6320copyNH1kkwU(TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, PlatformParagraphStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        return new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m6879getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m6892getUnspecifieds_7Xco(), lineHeight, textIndent, platformStyle, lineHeightStyle, lineBreak != null ? lineBreak.getMask() : LineBreak.INSTANCE.m6794getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.getValue() : Hyphens.INSTANCE.m6773getUnspecifiedvmbZdU8(), textMotion, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-ykzQM6k$default, reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m6314copyykzQM6k$default(ParagraphStyle paragraphStyle, int i, int i2, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = paragraphStyle.textAlign;
        }
        if ((i5 & 2) != 0) {
            i2 = paragraphStyle.textDirection;
        }
        if ((i5 & 4) != 0) {
            j = paragraphStyle.lineHeight;
        }
        if ((i5 & 8) != 0) {
            textIndent = paragraphStyle.textIndent;
        }
        if ((i5 & 16) != 0) {
            platformParagraphStyle = paragraphStyle.platformStyle;
        }
        if ((i5 & 32) != 0) {
            lineHeightStyle = paragraphStyle.lineHeightStyle;
        }
        if ((i5 & 64) != 0) {
            i3 = paragraphStyle.lineBreak;
        }
        if ((i5 & 128) != 0) {
            i4 = paragraphStyle.hyphens;
        }
        if ((i5 & 256) != 0) {
            textMotion = paragraphStyle.textMotion;
        }
        int i6 = i4;
        TextMotion textMotion2 = textMotion;
        long j2 = j;
        return paragraphStyle.m6323copyykzQM6k(i, i2, j2, textIndent, platformParagraphStyle, lineHeightStyle, i3, i6, textMotion2);
    }

    /* renamed from: copy-ykzQM6k, reason: not valid java name */
    public final ParagraphStyle m6323copyykzQM6k(int textAlign, int textDirection, long lineHeight, TextIndent textIndent, PlatformParagraphStyle platformStyle, LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, TextMotion textMotion) {
        return new ParagraphStyle(textAlign, textDirection, lineHeight, textIndent, platformStyle, lineHeightStyle, lineBreak, hyphens, textMotion, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParagraphStyle)) {
            return false;
        }
        ParagraphStyle paragraphStyle = (ParagraphStyle) other;
        return TextAlign.m6869equalsimpl0(this.textAlign, paragraphStyle.textAlign) && TextDirection.m6883equalsimpl0(this.textDirection, paragraphStyle.textDirection) && TextUnit.m7180equalsimpl0(this.lineHeight, paragraphStyle.lineHeight) && Intrinsics.areEqual(this.textIndent, paragraphStyle.textIndent) && Intrinsics.areEqual(this.platformStyle, paragraphStyle.platformStyle) && Intrinsics.areEqual(this.lineHeightStyle, paragraphStyle.lineHeightStyle) && LineBreak.m6780equalsimpl0(this.lineBreak, paragraphStyle.lineBreak) && Hyphens.m6767equalsimpl0(this.hyphens, paragraphStyle.hyphens) && Intrinsics.areEqual(this.textMotion, paragraphStyle.textMotion);
    }

    public int hashCode() {
        int m6870hashCodeimpl = ((((TextAlign.m6870hashCodeimpl(this.textAlign) * 31) + TextDirection.m6884hashCodeimpl(this.textDirection)) * 31) + TextUnit.m7184hashCodeimpl(this.lineHeight)) * 31;
        TextIndent textIndent = this.textIndent;
        int hashCode = (m6870hashCodeimpl + (textIndent != null ? textIndent.hashCode() : 0)) * 31;
        PlatformParagraphStyle platformParagraphStyle = this.platformStyle;
        int hashCode2 = (hashCode + (platformParagraphStyle != null ? platformParagraphStyle.hashCode() : 0)) * 31;
        LineHeightStyle lineHeightStyle = this.lineHeightStyle;
        int hashCode3 = (((((hashCode2 + (lineHeightStyle != null ? lineHeightStyle.hashCode() : 0)) * 31) + LineBreak.m6784hashCodeimpl(this.lineBreak)) * 31) + Hyphens.m6768hashCodeimpl(this.hyphens)) * 31;
        TextMotion textMotion = this.textMotion;
        return hashCode3 + (textMotion != null ? textMotion.hashCode() : 0);
    }

    public String toString() {
        return "ParagraphStyle(textAlign=" + ((Object) TextAlign.m6871toStringimpl(this.textAlign)) + ", textDirection=" + ((Object) TextDirection.m6885toStringimpl(this.textDirection)) + ", lineHeight=" + ((Object) TextUnit.m7190toStringimpl(this.lineHeight)) + ", textIndent=" + this.textIndent + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + this.lineHeightStyle + ", lineBreak=" + ((Object) LineBreak.m6785toStringimpl(this.lineBreak)) + ", hyphens=" + ((Object) Hyphens.m6769toStringimpl(this.hyphens)) + ", textMotion=" + this.textMotion + ')';
    }
}
