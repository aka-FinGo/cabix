package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.platform.AndroidMultiParagraphDraw_androidKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: MultiParagraph.kt */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B+\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB+\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rBY\b\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aBY\b\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u001dBY\b\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u001eBY\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001f\u001a\u00020 ¢\u0006\u0002\u0010!B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001f\u001a\u00020 ¢\u0006\u0002\u0010\"J*\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020B2\b\b\u0001\u0010F\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u000e\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u0007J\u000e\u0010L\u001a\u00020>2\u0006\u0010K\u001a\u00020\u0007J\u000e\u0010M\u001a\u00020>2\u0006\u0010K\u001a\u00020\u0007J\u0016\u0010N\u001a\u00020\f2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\tJ\u000e\u0010P\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\u0007J\u000e\u0010R\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\u0007J\u0018\u0010S\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u00072\b\b\u0002\u0010T\u001a\u00020\tJ\u000e\u0010U\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0007J\u000e\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\fJ\u000e\u0010X\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\u0007J\u000e\u0010Y\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\u0007J\u000e\u0010Z\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\u0007J\u000e\u0010[\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u0007J\u000e\u0010\\\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\u0007J\u000e\u0010]\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\u0007J\u0018\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020`ø\u0001\u0000¢\u0006\u0004\ba\u0010bJ\u000e\u0010c\u001a\u00020J2\u0006\u0010K\u001a\u00020\u0007J\u0016\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\u0007J(\u0010h\u001a\u00020D2\u0006\u0010i\u001a\u00020>2\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020mø\u0001\u0000¢\u0006\u0004\bn\u0010oJ\u001b\u0010p\u001a\u00020D2\u0006\u0010K\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bq\u0010rJ\u000e\u0010s\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\u0007J]\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020y2\b\b\u0002\u0010z\u001a\u00020\f2\n\b\u0002\u0010{\u001a\u0004\u0018\u00010|2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010~2\u000b\b\u0002\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\n\b\u0002\u0010\u0081\u0001\u001a\u00030\u0082\u0001ø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J@\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020w2\n\b\u0002\u0010\u0085\u0001\u001a\u00030\u0086\u00012\n\b\u0002\u0010{\u001a\u0004\u0018\u00010|2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010~H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001JW\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020w2\n\b\u0002\u0010\u0085\u0001\u001a\u00030\u0086\u00012\n\b\u0002\u0010{\u001a\u0004\u0018\u00010|2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010~2\u000b\b\u0002\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\n\b\u0002\u0010\u0081\u0001\u001a\u00030\u0082\u0001ø\u0001\u0000¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u0011\u0010\u008b\u0001\u001a\u00020u2\u0006\u0010K\u001a\u00020\u0007H\u0002J\u0011\u0010\u008c\u0001\u001a\u00020u2\u0006\u0010K\u001a\u00020\u0007H\u0002J\u0011\u0010\u008d\u0001\u001a\u00020u2\u0006\u0010Q\u001a\u00020\u0007H\u0002R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b0\u0010*R\u0011\u00101\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b5\u0010*R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u00103R\u0011\u00107\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b8\u0010*R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0019\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010>0\u0013¢\u0006\b\n\u0000\u001a\u0004\b?\u0010<R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b@\u0010*\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u008e\u0001"}, d2 = {"Landroidx/compose/ui/text/MultiParagraph;", "", "intrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "maxLines", "", "ellipsis", "", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;JIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "width", "", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;IZF)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IZ)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;JIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "firstBaseline", "getFirstBaseline", "()F", "height", "getHeight", "getIntrinsics", "()Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "lastBaseline", "getLastBaseline", "lineCount", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "paragraphInfoList", "Landroidx/compose/ui/text/ParagraphInfo;", "getParagraphInfoList$ui_text_release", "()Ljava/util/List;", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "getWidth", "fillBoundingBoxes", "", "range", "Landroidx/compose/ui/text/TextRange;", "array", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)[F", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", TypedValues.CycleType.S_WAVE_OFFSET, "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineBaseline", "lineIndex", "getLineBottom", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getRangeForRect", "rect", "granularity", "Landroidx/compose/ui/text/TextGranularity;", "inclusionStrategy", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getRangeForRect-8-6BmAI", "(Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getWordBoundary", "getWordBoundary--jx7JFs", "(I)J", "isLineEllipsized", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "decoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "requireIndexInRange", "requireIndexInRangeInclusiveEnd", "requireLineIndexInRange", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class MultiParagraph {
    public static final int $stable = 8;
    private final boolean didExceedMaxLines;
    private final float height;
    private final MultiParagraphIntrinsics intrinsics;
    private final int lineCount;
    private final int maxLines;
    private final List<ParagraphInfo> paragraphInfoList;
    private final List<Rect> placeholderRects;
    private final float width;

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j, Density density, FontFamily.Resolver resolver, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, j, density, resolver, (List<AnnotatedString.Range<Placeholder>>) list, i, i2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Constructor with `ellipsis: Boolean` is deprecated, pass TextOverflow instead")
    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j, Density density, FontFamily.Resolver resolver, List list, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, j, density, resolver, (List<AnnotatedString.Range<Placeholder>>) list, i, z);
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, j, i, i2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Constructor with `ellipsis: Boolean` is deprecated, pass TextOverflow instead")
    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, j, i, z);
    }

    private MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j, int i, int i2) {
        int m6941getMaxHeightimpl;
        this.intrinsics = multiParagraphIntrinsics;
        this.maxLines = i;
        boolean z = true;
        if (!(Constraints.m6944getMinWidthimpl(j) == 0 && Constraints.m6943getMinHeightimpl(j) == 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        ArrayList arrayList = new ArrayList();
        List<ParagraphIntrinsicInfo> infoList$ui_text_release = multiParagraphIntrinsics.getInfoList$ui_text_release();
        int size = infoList$ui_text_release.size();
        int i3 = 0;
        float f = 0.0f;
        int i4 = 0;
        while (i4 < size) {
            ParagraphIntrinsicInfo paragraphIntrinsicInfo = infoList$ui_text_release.get(i4);
            ParagraphIntrinsics intrinsics = paragraphIntrinsicInfo.getIntrinsics();
            int m6942getMaxWidthimpl = Constraints.m6942getMaxWidthimpl(j);
            if (Constraints.m6937getHasBoundedHeightimpl(j)) {
                m6941getMaxHeightimpl = RangesKt.coerceAtLeast(Constraints.m6941getMaxHeightimpl(j) - ParagraphKt.ceilToInt(f), 0);
            } else {
                m6941getMaxHeightimpl = Constraints.m6941getMaxHeightimpl(j);
            }
            Paragraph m6308ParagraphczeNHc = ParagraphKt.m6308ParagraphczeNHc(intrinsics, ConstraintsKt.Constraints$default(0, m6942getMaxWidthimpl, 0, m6941getMaxHeightimpl, 5, null), this.maxLines - i3, i2);
            float height = f + m6308ParagraphczeNHc.getHeight();
            int lineCount = i3 + m6308ParagraphczeNHc.getLineCount();
            arrayList.add(new ParagraphInfo(m6308ParagraphczeNHc, paragraphIntrinsicInfo.getStartIndex(), paragraphIntrinsicInfo.getEndIndex(), i3, lineCount, f, height));
            if (m6308ParagraphczeNHc.getDidExceedMaxLines() || (lineCount == this.maxLines && i4 != CollectionsKt.getLastIndex(this.intrinsics.getInfoList$ui_text_release()))) {
                i3 = lineCount;
                f = height;
                break;
            } else {
                i4++;
                i3 = lineCount;
                f = height;
            }
        }
        z = false;
        this.height = f;
        this.lineCount = i3;
        this.didExceedMaxLines = z;
        this.paragraphInfoList = arrayList;
        this.width = Constraints.m6942getMaxWidthimpl(j);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i5 = 0; i5 < size2; i5++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i5);
            List<Rect> placeholderRects = paragraphInfo.getParagraph().getPlaceholderRects();
            ArrayList arrayList3 = new ArrayList(placeholderRects.size());
            int size3 = placeholderRects.size();
            for (int i6 = 0; i6 < size3; i6++) {
                ArrayList arrayList4 = arrayList3;
                Rect rect = placeholderRects.get(i6);
                arrayList4.add(rect != null ? paragraphInfo.toGlobal(rect) : null);
            }
            CollectionsKt.addAll(arrayList2, arrayList3);
        }
        ArrayList arrayList5 = arrayList2;
        if (arrayList5.size() < this.intrinsics.getPlaceholders().size()) {
            ArrayList arrayList6 = arrayList5;
            int size4 = this.intrinsics.getPlaceholders().size() - arrayList5.size();
            ArrayList arrayList7 = new ArrayList(size4);
            for (int i7 = 0; i7 < size4; i7++) {
                arrayList7.add(null);
            }
            arrayList5 = CollectionsKt.plus((Collection) arrayList6, (Iterable) arrayList7);
        }
        this.placeholderRects = arrayList5;
    }

    public final MultiParagraphIntrinsics getIntrinsics() {
        return this.intrinsics;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, j, (i3 & 4) != 0 ? Integer.MAX_VALUE : i, (i3 & 8) != 0 ? TextOverflow.INSTANCE.m6924getClipgIe3tQ8() : i2, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, j, (i2 & 4) != 0 ? Integer.MAX_VALUE : i, (i2 & 8) != 0 ? false : z, (DefaultConstructorMarker) null);
    }

    private MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j, int i, boolean z) {
        this(multiParagraphIntrinsics, j, i, z ? TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8() : TextOverflow.INSTANCE.m6924getClipgIe3tQ8(), (DefaultConstructorMarker) null);
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, int i, boolean z, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, (i2 & 2) != 0 ? Integer.MAX_VALUE : i, (i2 & 4) != 0 ? false : z, f);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "MultiParagraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @kotlin.ReplaceWith(expression = "MultiParagraph(intrinsics, Constraints(maxWidth = ceil(width).toInt()), maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MultiParagraph(androidx.compose.ui.text.MultiParagraphIntrinsics r14, int r15, boolean r16, float r17) {
        /*
            r13 = this;
            int r1 = androidx.compose.ui.text.ParagraphKt.ceilToInt(r17)
            r4 = 13
            r5 = 0
            r0 = 0
            r2 = 0
            r3 = 0
            long r8 = androidx.compose.ui.unit.ConstraintsKt.Constraints$default(r0, r1, r2, r3, r4, r5)
            androidx.compose.ui.text.style.TextOverflow$Companion r0 = androidx.compose.ui.text.style.TextOverflow.INSTANCE
            if (r16 == 0) goto L17
            int r0 = r0.m6925getEllipsisgIe3tQ8()
            goto L1b
        L17:
            int r0 = r0.m6924getClipgIe3tQ8()
        L1b:
            r11 = r0
            r12 = 0
            r6 = r13
            r7 = r14
            r10 = r15
            r6.<init>(r7, r8, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.MultiParagraph.<init>(androidx.compose.ui.text.MultiParagraphIntrinsics, int, boolean, float):void");
    }

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, List list, int i, boolean z, float f, Density density, Font.ResourceLoader resourceLoader, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, (List<AnnotatedString.Range<Placeholder>>) ((i2 & 4) != 0 ? CollectionsKt.emptyList() : list), (i2 & 8) != 0 ? Integer.MAX_VALUE : i, (i2 & 16) != 0 ? false : z, f, density, resourceLoader);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "Font.ResourceLoader is deprecated, use fontFamilyResolver instead", replaceWith = @kotlin.ReplaceWith(expression = "MultiParagraph(annotatedString, style, placeholders, maxLines, ellipsis, width, density, fontFamilyResolver)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MultiParagraph(androidx.compose.ui.text.AnnotatedString r7, androidx.compose.ui.text.TextStyle r8, java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> r9, int r10, boolean r11, float r12, androidx.compose.ui.unit.Density r13, androidx.compose.ui.text.font.Font.ResourceLoader r14) {
        /*
            r6 = this;
            androidx.compose.ui.text.MultiParagraphIntrinsics r0 = new androidx.compose.ui.text.MultiParagraphIntrinsics
            androidx.compose.ui.text.font.FontFamily$Resolver r5 = androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(r14)
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            r7 = r0
            androidx.compose.ui.text.style.TextOverflow$Companion r8 = androidx.compose.ui.text.style.TextOverflow.INSTANCE
            if (r11 == 0) goto L17
            int r8 = r8.m6925getEllipsisgIe3tQ8()
            goto L1b
        L17:
            int r8 = r8.m6924getClipgIe3tQ8()
        L1b:
            r11 = r8
            int r1 = androidx.compose.ui.text.ParagraphKt.ceilToInt(r12)
            r4 = 13
            r5 = 0
            r0 = 0
            r2 = 0
            r3 = 0
            long r8 = androidx.compose.ui.unit.ConstraintsKt.Constraints$default(r0, r1, r2, r3, r4, r5)
            r12 = 0
            r6.<init>(r7, r8, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.MultiParagraph.<init>(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, java.util.List, int, boolean, float, androidx.compose.ui.unit.Density, androidx.compose.ui.text.font.Font$ResourceLoader):void");
    }

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, float f, Density density, FontFamily.Resolver resolver, List list, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, f, density, resolver, (List<AnnotatedString.Range<Placeholder>>) ((i2 & 32) != 0 ? CollectionsKt.emptyList() : list), (i2 & 64) != 0 ? Integer.MAX_VALUE : i, (i2 & 128) != 0 ? false : z);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "MultiParagraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @kotlin.ReplaceWith(expression = "MultiParagraph(annotatedString, style, Constraints(maxWidth = ceil(width).toInt()), density, fontFamilyResolver, placeholders, maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MultiParagraph(androidx.compose.ui.text.AnnotatedString r7, androidx.compose.ui.text.TextStyle r8, float r9, androidx.compose.ui.unit.Density r10, androidx.compose.ui.text.font.FontFamily.Resolver r11, java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> r12, int r13, boolean r14) {
        /*
            r6 = this;
            androidx.compose.ui.text.MultiParagraphIntrinsics r0 = new androidx.compose.ui.text.MultiParagraphIntrinsics
            r1 = r7
            r2 = r8
            r4 = r10
            r5 = r11
            r3 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r7 = r0
            androidx.compose.ui.text.style.TextOverflow$Companion r8 = androidx.compose.ui.text.style.TextOverflow.INSTANCE
            if (r14 == 0) goto L14
            int r8 = r8.m6925getEllipsisgIe3tQ8()
            goto L18
        L14:
            int r8 = r8.m6924getClipgIe3tQ8()
        L18:
            r11 = r8
            int r1 = androidx.compose.ui.text.ParagraphKt.ceilToInt(r9)
            r4 = 13
            r5 = 0
            r0 = 0
            r2 = 0
            r3 = 0
            long r8 = androidx.compose.ui.unit.ConstraintsKt.Constraints$default(r0, r1, r2, r3, r4, r5)
            r12 = 0
            r10 = r13
            r6.<init>(r7, r8, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.MultiParagraph.<init>(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, float, androidx.compose.ui.unit.Density, androidx.compose.ui.text.font.FontFamily$Resolver, java.util.List, int, boolean):void");
    }

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j, Density density, FontFamily.Resolver resolver, List list, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, j, density, resolver, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list, (i2 & 64) != 0 ? Integer.MAX_VALUE : i, (i2 & 128) != 0 ? false : z, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private MultiParagraph(androidx.compose.ui.text.AnnotatedString r7, androidx.compose.ui.text.TextStyle r8, long r9, androidx.compose.ui.unit.Density r11, androidx.compose.ui.text.font.FontFamily.Resolver r12, java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> r13, int r14, boolean r15) {
        /*
            r6 = this;
            androidx.compose.ui.text.MultiParagraphIntrinsics r0 = new androidx.compose.ui.text.MultiParagraphIntrinsics
            r1 = r7
            r2 = r8
            r4 = r11
            r5 = r12
            r3 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            r7 = r0
            androidx.compose.ui.text.style.TextOverflow$Companion r8 = androidx.compose.ui.text.style.TextOverflow.INSTANCE
            if (r15 == 0) goto L14
            int r8 = r8.m6925getEllipsisgIe3tQ8()
            goto L18
        L14:
            int r8 = r8.m6924getClipgIe3tQ8()
        L18:
            r11 = r8
            r12 = 0
            r8 = r9
            r10 = r14
            r6.<init>(r7, r8, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.MultiParagraph.<init>(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, long, androidx.compose.ui.unit.Density, androidx.compose.ui.text.font.FontFamily$Resolver, java.util.List, int, boolean):void");
    }

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j, Density density, FontFamily.Resolver resolver, List list, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, j, density, resolver, (i3 & 32) != 0 ? CollectionsKt.emptyList() : list, (i3 & 64) != 0 ? Integer.MAX_VALUE : i, (i3 & 128) != 0 ? TextOverflow.INSTANCE.m6924getClipgIe3tQ8() : i2, (DefaultConstructorMarker) null);
    }

    private MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j, Density density, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list, int i, int i2) {
        this(new MultiParagraphIntrinsics(annotatedString, textStyle, list, density, resolver), j, i, i2, (DefaultConstructorMarker) null);
    }

    private final AnnotatedString getAnnotatedString() {
        return this.intrinsics.getAnnotatedString();
    }

    public final float getMinIntrinsicWidth() {
        return this.intrinsics.getMinIntrinsicWidth();
    }

    public final float getMaxIntrinsicWidth() {
        return this.intrinsics.getMaxIntrinsicWidth();
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getFirstBaseline() {
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        return this.paragraphInfoList.get(0).getParagraph().getFirstBaseline();
    }

    public final float getLastBaseline() {
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) CollectionsKt.last((List) this.paragraphInfoList);
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLastBaseline());
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    public final List<ParagraphInfo> getParagraphInfoList$ui_text_release() {
        return this.paragraphInfoList;
    }

    /* renamed from: paint-RPmYEkk$default, reason: not valid java name */
    public static /* synthetic */ void m6283paintRPmYEkk$default(MultiParagraph multiParagraph, Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Color.INSTANCE.m4420getUnspecified0d7_KjU();
        }
        multiParagraph.m6290paintRPmYEkk(canvas, j, (i & 4) != 0 ? null : shadow, (i & 8) != 0 ? null : textDecoration);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the new paint function that takes canvas as the only required parameter.")
    /* renamed from: paint-RPmYEkk, reason: not valid java name */
    public final /* synthetic */ void m6290paintRPmYEkk(Canvas canvas, long color, Shadow shadow, TextDecoration decoration) {
        canvas.save();
        List<ParagraphInfo> list = this.paragraphInfoList;
        int size = list.size();
        int i = 0;
        while (i < size) {
            ParagraphInfo paragraphInfo = list.get(i);
            Canvas canvas2 = canvas;
            long j = color;
            paragraphInfo.getParagraph().mo6250paintRPmYEkk(canvas2, j, shadow, decoration);
            canvas2.translate(0.0f, paragraphInfo.getParagraph().getHeight());
            i++;
            canvas = canvas2;
            color = j;
        }
        canvas.restore();
    }

    /* renamed from: paint-LG529CI, reason: not valid java name */
    public final void m6289paintLG529CI(Canvas canvas, long color, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        canvas.save();
        List<ParagraphInfo> list = this.paragraphInfoList;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ParagraphInfo paragraphInfo = list.get(i);
            paragraphInfo.getParagraph().mo6249paintLG529CI(canvas, color, shadow, decoration, drawStyle, blendMode);
            canvas.translate(0.0f, paragraphInfo.getParagraph().getHeight());
        }
        canvas.restore();
    }

    /* renamed from: paint-hn5TExg$default, reason: not valid java name */
    public static /* synthetic */ void m6284painthn5TExg$default(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = Float.NaN;
        }
        multiParagraph.m6291painthn5TExg(canvas, brush, f, (i2 & 8) != 0 ? null : shadow, (i2 & 16) != 0 ? null : textDecoration, (i2 & 32) != 0 ? null : drawStyle, (i2 & 64) != 0 ? DrawScope.INSTANCE.m4937getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: paint-hn5TExg, reason: not valid java name */
    public final void m6291painthn5TExg(Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        AndroidMultiParagraphDraw_androidKt.m6708drawMultiParagraph7AXcY_I(this, canvas, brush, alpha, shadow, decoration, drawStyle, blendMode);
    }

    public final Path getPathForRange(final int start, final int end) {
        if (!(start >= 0 && start <= end && end <= getAnnotatedString().getText().length())) {
            InlineClassHelperKt.throwIllegalArgumentException("Start(" + start + ") or End(" + end + ") is out of range [0.." + getAnnotatedString().getText().length() + "), or start > end!");
        }
        if (start == end) {
            return AndroidPath_androidKt.Path();
        }
        final Path Path = AndroidPath_androidKt.Path();
        MultiParagraphKt.m6292findParagraphsByRangeSbBc2M(this.paragraphInfoList, TextRangeKt.TextRange(start, end), new Function1<ParagraphInfo, Unit>() { // from class: androidx.compose.ui.text.MultiParagraph$getPathForRange$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ParagraphInfo paragraphInfo) {
                invoke2(paragraphInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ParagraphInfo paragraphInfo) {
                Path.m4654addPathUv8p0NA$default(Path.this, paragraphInfo.toGlobal(paragraphInfo.getParagraph().getPathForRange(paragraphInfo.toLocalIndex(start), paragraphInfo.toLocalIndex(end))), 0L, 2, null);
            }
        });
        return Path;
    }

    public final int getLineForVerticalPosition(float vertical) {
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByY(this.paragraphInfoList, vertical));
        if (paragraphInfo.getLength() == 0) {
            return paragraphInfo.getStartLineIndex();
        }
        return paragraphInfo.toGlobalLineIndex(paragraphInfo.getParagraph().getLineForVerticalPosition(paragraphInfo.toLocalYPosition(vertical)));
    }

    /* renamed from: getOffsetForPosition-k-4lQ0M, reason: not valid java name */
    public final int m6286getOffsetForPositionk4lQ0M(long position) {
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByY(this.paragraphInfoList, Float.intBitsToFloat((int) (4294967295L & position))));
        if (paragraphInfo.getLength() == 0) {
            return paragraphInfo.getStartIndex();
        }
        return paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().mo6245getOffsetForPositionk4lQ0M(paragraphInfo.m6301toLocalMKHz9U(position)));
    }

    /* renamed from: getRangeForRect-8-6BmAI, reason: not valid java name */
    public final long m6287getRangeForRect86BmAI(Rect rect, int granularity, TextInclusionStrategy inclusionStrategy) {
        int findParagraphByY = MultiParagraphKt.findParagraphByY(this.paragraphInfoList, rect.getTop());
        if (this.paragraphInfoList.get(findParagraphByY).getBottom() >= rect.getBottom() || findParagraphByY == CollectionsKt.getLastIndex(this.paragraphInfoList)) {
            ParagraphInfo paragraphInfo = this.paragraphInfoList.get(findParagraphByY);
            return ParagraphInfo.m6299toGlobalxdX6G0$default(paragraphInfo, paragraphInfo.getParagraph().mo6247getRangeForRect86BmAI(paragraphInfo.toLocal(rect), granularity, inclusionStrategy), false, 1, null);
        }
        int findParagraphByY2 = MultiParagraphKt.findParagraphByY(this.paragraphInfoList, rect.getBottom());
        long m6440getZerod9O1mEE = TextRange.INSTANCE.m6440getZerod9O1mEE();
        while (TextRange.m6428equalsimpl0(m6440getZerod9O1mEE, TextRange.INSTANCE.m6440getZerod9O1mEE()) && findParagraphByY <= findParagraphByY2) {
            ParagraphInfo paragraphInfo2 = this.paragraphInfoList.get(findParagraphByY);
            m6440getZerod9O1mEE = ParagraphInfo.m6299toGlobalxdX6G0$default(paragraphInfo2, paragraphInfo2.getParagraph().mo6247getRangeForRect86BmAI(paragraphInfo2.toLocal(rect), granularity, inclusionStrategy), false, 1, null);
            findParagraphByY++;
        }
        if (TextRange.m6428equalsimpl0(m6440getZerod9O1mEE, TextRange.INSTANCE.m6440getZerod9O1mEE())) {
            return TextRange.INSTANCE.m6440getZerod9O1mEE();
        }
        long m6440getZerod9O1mEE2 = TextRange.INSTANCE.m6440getZerod9O1mEE();
        while (TextRange.m6428equalsimpl0(m6440getZerod9O1mEE2, TextRange.INSTANCE.m6440getZerod9O1mEE()) && findParagraphByY <= findParagraphByY2) {
            ParagraphInfo paragraphInfo3 = this.paragraphInfoList.get(findParagraphByY2);
            m6440getZerod9O1mEE2 = ParagraphInfo.m6299toGlobalxdX6G0$default(paragraphInfo3, paragraphInfo3.getParagraph().mo6247getRangeForRect86BmAI(paragraphInfo3.toLocal(rect), granularity, inclusionStrategy), false, 1, null);
            findParagraphByY2--;
        }
        return TextRange.m6428equalsimpl0(m6440getZerod9O1mEE2, TextRange.INSTANCE.m6440getZerod9O1mEE()) ? m6440getZerod9O1mEE : TextRangeKt.TextRange(TextRange.m6435getStartimpl(m6440getZerod9O1mEE), TextRange.m6430getEndimpl(m6440getZerod9O1mEE2));
    }

    public final Rect getBoundingBox(int offset) {
        requireIndexInRange(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.toGlobal(paragraphInfo.getParagraph().getBoundingBox(paragraphInfo.toLocalIndex(offset)));
    }

    /* renamed from: fillBoundingBoxes-8ffj60Q, reason: not valid java name */
    public final float[] m6285fillBoundingBoxes8ffj60Q(final long range, final float[] array, int arrayStart) {
        requireIndexInRange(TextRange.m6433getMinimpl(range));
        requireIndexInRangeInclusiveEnd(TextRange.m6432getMaximpl(range));
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = arrayStart;
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        MultiParagraphKt.m6292findParagraphsByRangeSbBc2M(this.paragraphInfoList, range, new Function1<ParagraphInfo, Unit>() { // from class: androidx.compose.ui.text.MultiParagraph$fillBoundingBoxes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ParagraphInfo paragraphInfo) {
                invoke2(paragraphInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ParagraphInfo paragraphInfo) {
                long j = range;
                float[] fArr = array;
                Ref.IntRef intRef2 = intRef;
                Ref.FloatRef floatRef2 = floatRef;
                long TextRange = TextRangeKt.TextRange(paragraphInfo.toLocalIndex(paragraphInfo.getStartIndex() > TextRange.m6433getMinimpl(j) ? paragraphInfo.getStartIndex() : TextRange.m6433getMinimpl(j)), paragraphInfo.toLocalIndex(paragraphInfo.getEndIndex() < TextRange.m6432getMaximpl(j) ? paragraphInfo.getEndIndex() : TextRange.m6432getMaximpl(j)));
                paragraphInfo.getParagraph().mo6243fillBoundingBoxes8ffj60Q(TextRange, fArr, intRef2.element);
                int m6431getLengthimpl = intRef2.element + (TextRange.m6431getLengthimpl(TextRange) * 4);
                for (int i = intRef2.element; i < m6431getLengthimpl; i += 4) {
                    int i2 = i + 1;
                    fArr[i2] = fArr[i2] + floatRef2.element;
                    int i3 = i + 3;
                    fArr[i3] = fArr[i3] + floatRef2.element;
                }
                intRef2.element = m6431getLengthimpl;
                floatRef2.element += paragraphInfo.getParagraph().getHeight();
            }
        });
        return array;
    }

    public final float getHorizontalPosition(int offset, boolean usePrimaryDirection) {
        int findParagraphByIndex;
        requireIndexInRangeInclusiveEnd(offset);
        int length = getAnnotatedString().length();
        List<ParagraphInfo> list = this.paragraphInfoList;
        if (offset == length) {
            findParagraphByIndex = CollectionsKt.getLastIndex(list);
        } else {
            findParagraphByIndex = MultiParagraphKt.findParagraphByIndex(list, offset);
        }
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(findParagraphByIndex);
        return paragraphInfo.getParagraph().getHorizontalPosition(paragraphInfo.toLocalIndex(offset), usePrimaryDirection);
    }

    public final ResolvedTextDirection getParagraphDirection(int offset) {
        int findParagraphByIndex;
        requireIndexInRangeInclusiveEnd(offset);
        int length = getAnnotatedString().length();
        List<ParagraphInfo> list = this.paragraphInfoList;
        if (offset == length) {
            findParagraphByIndex = CollectionsKt.getLastIndex(list);
        } else {
            findParagraphByIndex = MultiParagraphKt.findParagraphByIndex(list, offset);
        }
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(findParagraphByIndex);
        return paragraphInfo.getParagraph().getParagraphDirection(paragraphInfo.toLocalIndex(offset));
    }

    public final ResolvedTextDirection getBidiRunDirection(int offset) {
        int findParagraphByIndex;
        requireIndexInRangeInclusiveEnd(offset);
        int length = getAnnotatedString().length();
        List<ParagraphInfo> list = this.paragraphInfoList;
        if (offset == length) {
            findParagraphByIndex = CollectionsKt.getLastIndex(list);
        } else {
            findParagraphByIndex = MultiParagraphKt.findParagraphByIndex(list, offset);
        }
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(findParagraphByIndex);
        return paragraphInfo.getParagraph().getBidiRunDirection(paragraphInfo.toLocalIndex(offset));
    }

    /* renamed from: getWordBoundary--jx7JFs, reason: not valid java name */
    public final long m6288getWordBoundaryjx7JFs(int offset) {
        int findParagraphByIndex;
        requireIndexInRangeInclusiveEnd(offset);
        int length = getAnnotatedString().length();
        List<ParagraphInfo> list = this.paragraphInfoList;
        if (offset == length) {
            findParagraphByIndex = CollectionsKt.getLastIndex(list);
        } else {
            findParagraphByIndex = MultiParagraphKt.findParagraphByIndex(list, offset);
        }
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(findParagraphByIndex);
        return paragraphInfo.m6300toGlobalxdX6G0(paragraphInfo.getParagraph().mo6248getWordBoundaryjx7JFs(paragraphInfo.toLocalIndex(offset)), false);
    }

    public final Rect getCursorRect(int offset) {
        int findParagraphByIndex;
        requireIndexInRangeInclusiveEnd(offset);
        int length = getAnnotatedString().length();
        List<ParagraphInfo> list = this.paragraphInfoList;
        if (offset == length) {
            findParagraphByIndex = CollectionsKt.getLastIndex(list);
        } else {
            findParagraphByIndex = MultiParagraphKt.findParagraphByIndex(list, offset);
        }
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(findParagraphByIndex);
        return paragraphInfo.toGlobal(paragraphInfo.getParagraph().getCursorRect(paragraphInfo.toLocalIndex(offset)));
    }

    public final int getLineForOffset(int offset) {
        int findParagraphByIndex;
        if (offset >= getAnnotatedString().length()) {
            findParagraphByIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            findParagraphByIndex = offset < 0 ? 0 : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(findParagraphByIndex);
        return paragraphInfo.toGlobalLineIndex(paragraphInfo.getParagraph().getLineForOffset(paragraphInfo.toLocalIndex(offset)));
    }

    public final float getLineLeft(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.getParagraph().getLineLeft(paragraphInfo.toLocalLineIndex(lineIndex));
    }

    public final float getLineRight(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.getParagraph().getLineRight(paragraphInfo.toLocalLineIndex(lineIndex));
    }

    public final float getLineTop(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLineTop(paragraphInfo.toLocalLineIndex(lineIndex)));
    }

    public final float getLineBaseline(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLineBaseline(paragraphInfo.toLocalLineIndex(lineIndex)));
    }

    public final float getLineBottom(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLineBottom(paragraphInfo.toLocalLineIndex(lineIndex)));
    }

    public final float getLineHeight(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.getParagraph().getLineHeight(paragraphInfo.toLocalLineIndex(lineIndex));
    }

    public final float getLineWidth(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.getParagraph().getLineWidth(paragraphInfo.toLocalLineIndex(lineIndex));
    }

    public final int getLineStart(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().getLineStart(paragraphInfo.toLocalLineIndex(lineIndex)));
    }

    public static /* synthetic */ int getLineEnd$default(MultiParagraph multiParagraph, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return multiParagraph.getLineEnd(i, z);
    }

    public final int getLineEnd(int lineIndex, boolean visibleEnd) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().getLineEnd(paragraphInfo.toLocalLineIndex(lineIndex), visibleEnd));
    }

    public final boolean isLineEllipsized(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        return this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex)).getParagraph().isLineEllipsized(lineIndex);
    }

    private final void requireIndexInRange(int offset) {
        boolean z = false;
        if (offset >= 0 && offset < getAnnotatedString().getText().length()) {
            z = true;
        }
        if (z) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("offset(" + offset + ") is out of bounds [0, " + getAnnotatedString().length() + ')');
    }

    private final void requireIndexInRangeInclusiveEnd(int offset) {
        boolean z = false;
        if (offset >= 0 && offset <= getAnnotatedString().getText().length()) {
            z = true;
        }
        if (z) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("offset(" + offset + ") is out of bounds [0, " + getAnnotatedString().length() + AbstractJsonLexerKt.END_LIST);
    }

    private final void requireLineIndexInRange(int lineIndex) {
        boolean z = false;
        if (lineIndex >= 0 && lineIndex < this.lineCount) {
            z = true;
        }
        if (z) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("lineIndex(" + lineIndex + ") is out of bounds [0, " + this.lineCount + ')');
    }
}
