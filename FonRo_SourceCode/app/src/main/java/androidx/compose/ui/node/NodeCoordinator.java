package androidx.compose.ui.node;

import androidx.collection.MutableLongList;
import androidx.collection.MutableObjectIntMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: NodeCoordinator.kt */
@Metadata(d1 = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b-\b \u0018\u0000 ¼\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004¼\u0002½\u0002B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010\u0097\u0001\u001a\u00020\f2\u0007\u0010\u0098\u0001\u001a\u00020\u00002\u0007\u0010\u0099\u0001\u001a\u00020\u00102\u0007\u0010\u009a\u0001\u001a\u00020(H\u0002J2\u0010\u0097\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u0098\u0001\u001a\u00020\u00002\b\u0010\u009c\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009d\u0001\u001a\u00020(H\u0002ø\u0001\u0000¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u001d\u0010 \u0001\u001a\u00020c2\u0006\u0010b\u001a\u00020cH\u0004ø\u0001\u0000¢\u0006\u0006\b¡\u0001\u0010¢\u0001J'\u0010£\u0001\u001a\u00020\u001c2\b\u0010¤\u0001\u001a\u00030\u009b\u00012\u0006\u0010b\u001a\u00020cH\u0004ø\u0001\u0000¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u001b\u0010§\u0001\u001a\u00020\f2\u0007\u0010¨\u0001\u001a\u00020\n2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u000bJ\u001c\u0010ª\u0001\u001a\u00020\f2\u0007\u0010¨\u0001\u001a\u00020\n2\b\u0010«\u0001\u001a\u00030¬\u0001H\u0004J\u001d\u0010\u00ad\u0001\u001a\u00020\f2\u0007\u0010¨\u0001\u001a\u00020\n2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\t\u0010®\u0001\u001a\u00020\fH&J\u0018\u0010¯\u0001\u001a\u00020\u00002\u0007\u0010°\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\b±\u0001J*\u0010²\u0001\u001a\u00030\u009b\u00012\u0007\u0010s\u001a\u00030\u009b\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0006\b³\u0001\u0010´\u0001J\u001b\u0010µ\u0001\u001a\u00020\f2\u0007\u0010¶\u0001\u001a\u00020\u00102\u0007\u0010\u009a\u0001\u001a\u00020(H\u0002J#\u0010·\u0001\u001a\u00020(2\f\u0010¸\u0001\u001a\u0007\u0012\u0002\b\u00030¹\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\bº\u0001\u0010»\u0001J$\u0010¼\u0001\u001a\u0005\u0018\u00010\u0088\u00012\f\u0010¸\u0001\u001a\u0007\u0012\u0002\b\u00030¹\u0001ø\u0001\u0000¢\u0006\u0006\b½\u0001\u0010¾\u0001J\u0015\u0010¿\u0001\u001a\u0005\u0018\u00010\u0088\u00012\u0007\u0010À\u0001\u001a\u00020(H\u0002JD\u0010Á\u0001\u001a\u00020\f2\b\u0010Â\u0001\u001a\u00030Ã\u00012\b\u0010¤\u0001\u001a\u00030\u009b\u00012\b\u0010Ä\u0001\u001a\u00030Å\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u00012\u0007\u0010È\u0001\u001a\u00020(ø\u0001\u0000¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001JF\u0010Ë\u0001\u001a\u00020\f2\b\u0010Â\u0001\u001a\u00030Ã\u00012\b\u0010¤\u0001\u001a\u00030\u009b\u00012\b\u0010Ä\u0001\u001a\u00030Å\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u00012\u0007\u0010È\u0001\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0006\bÌ\u0001\u0010Ê\u0001J\t\u0010Í\u0001\u001a\u00020\fH\u0016J\u001f\u0010Î\u0001\u001a\u00020(2\b\u0010¤\u0001\u001a\u00030\u009b\u0001H\u0004ø\u0001\u0000¢\u0006\u0006\bÏ\u0001\u0010Ð\u0001J\u0007\u0010Ñ\u0001\u001a\u00020(J\u001c\u0010Ò\u0001\u001a\u00030Ó\u00012\u0007\u0010Ô\u0001\u001a\u00020\u00032\u0007\u0010\u009a\u0001\u001a\u00020(H\u0016J)\u0010Õ\u0001\u001a\u00030\u009b\u00012\u0007\u0010Ô\u0001\u001a\u00020\u00032\b\u0010Ö\u0001\u001a\u00030\u009b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b×\u0001\u0010Ø\u0001J2\u0010Õ\u0001\u001a\u00030\u009b\u00012\u0007\u0010Ô\u0001\u001a\u00020\u00032\b\u0010Ö\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009d\u0001\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0006\bÙ\u0001\u0010Ú\u0001J \u0010Û\u0001\u001a\u00030\u009b\u00012\b\u0010Ü\u0001\u001a\u00030\u009b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÝ\u0001\u0010¢\u0001J \u0010Þ\u0001\u001a\u00030\u009b\u00012\b\u0010Ü\u0001\u001a\u00030\u009b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bß\u0001\u0010¢\u0001J \u0010à\u0001\u001a\u00030\u009b\u00012\b\u0010Ü\u0001\u001a\u00030\u009b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bá\u0001\u0010¢\u0001J \u0010â\u0001\u001a\u00030\u009b\u00012\b\u0010¤\u0001\u001a\u00030\u009b\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\bã\u0001\u0010¢\u0001J\u0007\u0010ä\u0001\u001a\u00020\fJ\u000f\u0010å\u0001\u001a\u00020\fH\u0000¢\u0006\u0003\bæ\u0001J\u0007\u0010ç\u0001\u001a\u00020\fJ\t\u0010è\u0001\u001a\u00020\fH\u0016J\u0007\u0010é\u0001\u001a\u00020\fJ\u001d\u0010ê\u0001\u001a\u00020\f2\b\u0010ë\u0001\u001a\u00030ì\u00012\b\u0010í\u0001\u001a\u00030ì\u0001H\u0014J\u0007\u0010î\u0001\u001a\u00020\fJ\u0007\u0010ï\u0001\u001a\u00020\fJ\u0007\u0010ð\u0001\u001a\u00020\fJ\u0007\u0010ñ\u0001\u001a\u00020\fJ\u001d\u0010ò\u0001\u001a\u00020\f2\u0007\u0010¨\u0001\u001a\u00020\n2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u000bH\u0016J2\u0010ó\u0001\u001a\u00030ô\u00012\u0007\u0010õ\u0001\u001a\u00020>2\u0010\b\u0004\u0010ö\u0001\u001a\t\u0012\u0005\u0012\u00030ô\u000105H\u0084\bø\u0001\u0000¢\u0006\u0006\b÷\u0001\u0010ø\u0001JA\u0010ù\u0001\u001a\u00020\f2\u0006\u0010s\u001a\u00020r2\u0007\u0010\u0093\u0001\u001a\u00020\u001c2\u0019\u0010H\u001a\u0015\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\f\u0018\u00010E¢\u0006\u0002\bGH\u0014ø\u0001\u0000¢\u0006\u0006\bú\u0001\u0010û\u0001J.\u0010ù\u0001\u001a\u00020\f2\u0006\u0010s\u001a\u00020r2\u0007\u0010\u0093\u0001\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u000bH\u0014ø\u0001\u0000¢\u0006\u0006\bú\u0001\u0010ü\u0001JK\u0010ý\u0001\u001a\u00020\f2\u0006\u0010s\u001a\u00020r2\u0007\u0010\u0093\u0001\u001a\u00020\u001c2\u0019\u0010H\u001a\u0015\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\f\u0018\u00010E¢\u0006\u0002\bG2\b\u0010$\u001a\u0004\u0018\u00010\u000bH\u0002ø\u0001\u0000¢\u0006\u0006\bþ\u0001\u0010ÿ\u0001JI\u0010\u0080\u0002\u001a\u00020\f2\u0006\u0010s\u001a\u00020r2\u0007\u0010\u0093\u0001\u001a\u00020\u001c2\u0019\u0010H\u001a\u0015\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\f\u0018\u00010E¢\u0006\u0002\bG2\b\u0010B\u001a\u0004\u0018\u00010\u000bø\u0001\u0000¢\u0006\u0006\b\u0081\u0002\u0010ÿ\u0001J,\u0010\u0082\u0002\u001a\u00020\f2\u0007\u0010¶\u0001\u001a\u00020\u00102\u0007\u0010\u009a\u0001\u001a\u00020(2\t\b\u0002\u0010\u0083\u0002\u001a\u00020(H\u0000¢\u0006\u0003\b\u0084\u0002J\u0007\u0010\u0085\u0002\u001a\u00020\fJ\u000f\u0010\u0086\u0002\u001a\u00020\fH\u0010¢\u0006\u0003\b\u0087\u0002J \u0010\u0088\u0002\u001a\u00030\u009b\u00012\b\u0010\u0089\u0002\u001a\u00030\u009b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b\u008a\u0002\u0010¢\u0001J\u0007\u0010\u008b\u0002\u001a\u00020(J*\u0010\u008c\u0002\u001a\u00030\u009b\u00012\u0007\u0010s\u001a\u00030\u009b\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0006\b\u008d\u0002\u0010´\u0001J\b\u0010\u008e\u0002\u001a\u00030Ó\u0001J(\u0010\u008f\u0002\u001a\u00020\f2\u0007\u0010Ô\u0001\u001a\u00020\u00032\b\u0010\u0090\u0002\u001a\u00030\u0091\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0092\u0002\u0010\u0093\u0002J(\u0010\u0094\u0002\u001a\u00020\f2\u0007\u0010\u0098\u0001\u001a\u00020\u00002\b\u0010\u0090\u0002\u001a\u00030\u0091\u0002H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0095\u0002\u0010\u0096\u0002J(\u0010\u0097\u0002\u001a\u00020\f2\u0007\u0010\u0098\u0001\u001a\u00020\u00002\b\u0010\u0090\u0002\u001a\u00030\u0091\u0002H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0098\u0002\u0010\u0096\u0002J\u001f\u0010\u0099\u0002\u001a\u00020\f2\b\u0010\u0090\u0002\u001a\u00030\u0091\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b\u009a\u0002\u0010\u009b\u0002J-\u0010\u009c\u0002\u001a\u00020\f2\u0019\u0010H\u001a\u0015\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\f\u0018\u00010E¢\u0006\u0002\bG2\t\b\u0002\u0010\u009d\u0002\u001a\u00020(J\u0014\u0010\u009e\u0002\u001a\u00020(2\t\b\u0002\u0010\u009f\u0002\u001a\u00020(H\u0002JF\u0010 \u0002\u001a\u00020\f\"\u0007\b\u0000\u0010¡\u0002\u0018\u00012\u000f\u0010¸\u0001\u001a\n\u0012\u0005\u0012\u0003H¡\u00020¹\u00012\u0014\u0010ö\u0001\u001a\u000f\u0012\u0005\u0012\u0003H¡\u0002\u0012\u0004\u0012\u00020\f0EH\u0086\bø\u0001\u0000¢\u0006\u0006\b¢\u0002\u0010£\u0002J3\u0010 \u0002\u001a\u00020\f2\b\u0010¤\u0002\u001a\u00030ì\u00012\u0007\u0010À\u0001\u001a\u00020(2\u0014\u0010ö\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0088\u0001\u0012\u0004\u0012\u00020\f0EH\u0086\bJ \u0010¥\u0002\u001a\u00030\u009b\u00012\b\u0010¦\u0002\u001a\u00030\u009b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b§\u0002\u0010¢\u0001J(\u0010¨\u0002\u001a\u00020\f2\u0007\u0010¨\u0001\u001a\u00020\n2\u0013\u0010ö\u0001\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0EH\u0084\bJ\u001f\u0010©\u0002\u001a\u00020(2\b\u0010¤\u0001\u001a\u00030\u009b\u0001H\u0004ø\u0001\u0000¢\u0006\u0006\bª\u0002\u0010Ð\u0001JM\u0010«\u0002\u001a\u00020\f*\u0005\u0018\u00010\u0088\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\b\u0010¤\u0001\u001a\u00030\u009b\u00012\b\u0010Ä\u0001\u001a\u00030Å\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u00012\u0007\u0010È\u0001\u001a\u00020(H\u0002ø\u0001\u0000¢\u0006\u0006\b¬\u0002\u0010\u00ad\u0002JV\u0010®\u0002\u001a\u00020\f*\u0005\u0018\u00010\u0088\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\b\u0010¤\u0001\u001a\u00030\u009b\u00012\b\u0010Ä\u0001\u001a\u00030Å\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u00012\u0007\u0010È\u0001\u001a\u00020(2\u0007\u0010¯\u0002\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0006\b°\u0002\u0010±\u0002J0\u0010²\u0002\u001a\u00020(*\u0005\u0018\u00010\u0088\u00012\b\u0010¤\u0001\u001a\u00030\u009b\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b³\u0002\u0010´\u0002J_\u0010µ\u0002\u001a\u00020\f*\u0005\u0018\u00010\u0088\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\b\u0010¤\u0001\u001a\u00030\u009b\u00012\b\u0010Ä\u0001\u001a\u00030Å\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u00012\u0007\u0010È\u0001\u001a\u00020(2\u0007\u0010¯\u0002\u001a\u00020\u001c2\u0007\u0010¶\u0002\u001a\u00020(H\u0002ø\u0001\u0000¢\u0006\u0006\b·\u0002\u0010¸\u0002JV\u0010¹\u0002\u001a\u00020\f*\u0005\u0018\u00010\u0088\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\b\u0010¤\u0001\u001a\u00030\u009b\u00012\b\u0010Ä\u0001\u001a\u00030Å\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u00012\u0007\u0010È\u0001\u001a\u00020(2\u0007\u0010¯\u0002\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0006\bº\u0002\u0010±\u0002J\r\u0010»\u0002\u001a\u00020\u0000*\u00020\u0003H\u0002R$\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR(\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001eR\u001a\u0010'\u001a\u00020(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u0014\u00100\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010*R\u0014\u00102\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010*R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\f05X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010*R\u000e\u00107\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010*R\u000e\u00109\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010;\u001a\u00020(2\u0006\u0010:\u001a\u00020(@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010*R\u001a\u0010=\u001a\u00020>8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b?\u0010@R\"\u0010B\u001a\u0004\u0018\u00010A2\b\u0010:\u001a\u0004\u0018\u00010A@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DRD\u0010H\u001a\u0015\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\f\u0018\u00010E¢\u0006\u0002\bG2\u0019\u0010:\u001a\u0015\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\f\u0018\u00010E¢\u0006\u0002\bG@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u000e\u0010K\u001a\u00020LX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010Q\u001a\u00020N8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR&\u0010W\u001a\u0004\u0018\u00010V2\b\u0010:\u001a\u0004\u0018\u00010V@dX¦\u000e¢\u0006\f\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010]\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020\u000e8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0017\u0010b\u001a\u00020c8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bd\u0010@R\u0016\u0010e\u001a\n\u0012\u0004\u0012\u00020g\u0018\u00010fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010h\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bi\u0010\u0017R\u0013\u0010j\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bk\u0010\u001aR\u0016\u0010l\u001a\u0004\u0018\u00010m8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0013\u0010p\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bq\u0010\u001aR,\u0010s\u001a\u00020r2\u0006\u0010:\u001a\u00020r@TX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010w\u001a\u0004\bt\u0010@\"\u0004\bu\u0010vR\u001a\u0010x\u001a\b\u0012\u0004\u0012\u00020g0y8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bz\u0010{R\u0014\u0010|\u001a\u00020\u00108DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b}\u0010~R\u000e\u0010\u007f\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0080\u0001\u001a\u00030\u0081\u00018Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010@R\u0018\u0010\u0083\u0001\u001a\u00030\u0084\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0016\u0010\u0087\u0001\u001a\u00030\u0088\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R!\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R!\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u008d\u0001\"\u0006\b\u0092\u0001\u0010\u008f\u0001R(\u0010\u0093\u0001\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001c@DX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0094\u0001\u0010\u001e\"\u0006\b\u0095\u0001\u0010\u0096\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¾\u0002"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "_drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "density", "", "getDensity", "()F", "drawBlock", "getDrawBlock", "()Lkotlin/jvm/functions/Function2;", "drawBlockCanvas", "drawBlockParentLayer", "explicitLayer", "fontScale", "getFontScale", "forceMeasureWithLookaheadConstraints", "", "getForceMeasureWithLookaheadConstraints$ui_release", "()Z", "setForceMeasureWithLookaheadConstraints$ui_release", "(Z)V", "forcePlaceWithLookaheadOffset", "getForcePlaceWithLookaheadOffset$ui_release", "setForcePlaceWithLookaheadOffset$ui_release", "hasMeasureResult", "getHasMeasureResult", "introducesMotionFrameOfReference", "getIntroducesMotionFrameOfReference", "invalidateParentLayer", "Lkotlin/Function0;", "isAttached", "isClipping", "isValidOwnerScope", "lastLayerAlpha", "<set-?>", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "lastMeasurementConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastMeasurementConstraints-msEJaDk$ui_release", "()J", "Landroidx/compose/ui/node/OwnedLayer;", "layer", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "value", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "minimumTouchTargetSize", "Landroidx/compose/ui/geometry/Size;", "getMinimumTouchTargetSize-NH-jbRc", "oldAlignmentLines", "Landroidx/collection/MutableObjectIntMap;", "Landroidx/compose/ui/layout/AlignmentLine;", "parent", "getParent", "parentCoordinates", "getParentCoordinates", "parentData", "", "getParentData", "()Ljava/lang/Object;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "position", "getPosition-nOcc-ac", "setPosition--gyyYBs", "(J)V", "J", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "released", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrapped", "getWrapped$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "zIndex", "getZIndex", "setZIndex", "(F)V", "ancestorToLocal", "ancestor", "rect", "clipBounds", "Landroidx/compose/ui/geometry/Offset;", TypedValues.CycleType.S_WAVE_OFFSET, "includeMotionFrameOfReference", "ancestorToLocal-S_NoaFU", "(Landroidx/compose/ui/node/NodeCoordinator;JZ)J", "calculateMinimumTouchTargetPadding", "calculateMinimumTouchTargetPadding-E7KxVPU", "(J)J", "distanceInMinimumTouchTarget", "pointerPosition", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "draw", "canvas", "graphicsLayer", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawContainedDrawModifiers", "ensureLookaheadDelegateCreated", "findCommonAncestor", WriteOffReason.OTHER, "findCommonAncestor$ui_release", "fromParentPosition", "fromParentPosition-8S9VItk", "(JZ)J", "fromParentRect", "bounds", "hasNode", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Landroidx/compose/ui/node/NodeKind;", "hasNode-H91voCI", "(I)Z", "head", "head-H91voCI", "(I)Landroidx/compose/ui/Modifier$Node;", "headNode", "includeTail", "hitTest", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "isInLayer", "hitTest-qzLsGqo", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZ)V", "hitTestChild", "hitTestChild-qzLsGqo", "invalidateLayer", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "(J)Z", "isTransparent", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "localToScreen", "localToScreen-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "offsetFromEdge", "offsetFromEdge-MK-Hz9U", "onAttach", "onCoordinatesUsed", "onCoordinatesUsed$ui_release", "onDetach", "onLayoutModifierNodeChanged", "onLayoutNodeAttach", "onMeasureResultChanged", "width", "", "height", "onMeasured", "onPlaced", "onRelease", "onUnplaced", "performDraw", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "block", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelf", "placeSelf-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelfApparentToRealOffset", "placeSelfApparentToRealOffset-MLgxB_4", "rectInParent", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "releaseLayer", "replace", "replace$ui_release", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "shouldSharePointerInputWithSiblings", "toParentPosition", "toParentPosition-8S9VItk", "touchBoundsInRoot", "transformFrom", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFromAncestor", "transformFromAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformToAncestor", "transformToAncestor-EL8BTi8", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "updateLayerBlock", "forceUpdateLayerParameters", "updateLayerParameters", "invokeOnLayoutChange", "visitNodes", ExifInterface.GPS_DIRECTION_TRUE, "visitNodes-aLcG6gQ", "(ILkotlin/jvm/functions/Function1;)V", "mask", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "withPositionTranslation", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "hit", "hit-5ShdDok", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZ)V", "hitNear", "distanceFromEdge", "hitNear-Fh5PU_I", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZF)V", "isInExpandedTouchBounds", "isInExpandedTouchBounds-ThD-n1k", "(Landroidx/compose/ui/Modifier$Node;JI)Z", "outOfBoundsHit", "isHitInMinimumTouchTargetBetter", "outOfBoundsHit-8NAm7pk", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZFZ)V", "speculativeHit", "speculativeHit-Fh5PU_I", "toCoordinator", "Companion", "HitTestSource", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope {
    public static final int $stable = 0;
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> _drawBlock;
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private Canvas drawBlockCanvas;
    private GraphicsLayer drawBlockParentLayer;
    private GraphicsLayer explicitLayer;
    private boolean forceMeasureWithLookaheadConstraints;
    private boolean forcePlaceWithLookaheadOffset;
    private boolean isClipping;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private MutableObjectIntMap<AlignmentLine> oldAlignmentLines;
    private boolean released;
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayerParams = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayerParams$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator nodeCoordinator) {
            if (nodeCoordinator.isValidOwnerScope() && NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, null)) {
                LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
                LayoutNodeLayoutDelegate layoutDelegate = layoutNode.getLayoutDelegate();
                if (layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                    if (layoutDelegate.getCoordinatesAccessedDuringModifierPlacement() || layoutDelegate.getCoordinatesAccessedDuringPlacement()) {
                        LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                    }
                    layoutDelegate.getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
                }
                Owner requireOwner = LayoutNodeKt.requireOwner(layoutNode);
                requireOwner.getRectManager().onLayoutLayerPositionalPropertiesChanged(layoutNode);
                requireOwner.requestOnPositionedCallback(layoutNode);
            }
        }
    };
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayer = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayer$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator nodeCoordinator) {
            OwnedLayer layer = nodeCoordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
        }
    };
    private static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    private static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    private static final float[] tmpMatrix = Matrix.m4614constructorimpl$default(null, 1, null);
    private static final HitTestSource PointerInputSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$PointerInputSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            return true;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-qzLsGqo, reason: not valid java name */
        public void mo5989childHitTestqzLsGqo(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, int pointerType, boolean isInLayer) {
            layoutNode.m5909hitTest6fMxITs$ui_release(pointerPosition, hitTestResult, pointerType, isInLayer);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw, reason: not valid java name */
        public int mo5990entityTypeOLwlOKw() {
            return NodeKind.m5994constructorimpl(16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v0, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r9v1, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r9v10 */
        /* JADX WARN: Type inference failed for: r9v11 */
        /* JADX WARN: Type inference failed for: r9v12 */
        /* JADX WARN: Type inference failed for: r9v4 */
        /* JADX WARN: Type inference failed for: r9v5, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v7 */
        /* JADX WARN: Type inference failed for: r9v8 */
        /* JADX WARN: Type inference failed for: r9v9 */
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            int m5994constructorimpl = NodeKind.m5994constructorimpl(16);
            MutableVector mutableVector = null;
            while (node != 0) {
                if (node instanceof PointerInputModifierNode) {
                    if (((PointerInputModifierNode) node).interceptOutOfBoundsChildEvents()) {
                        return true;
                    }
                } else if ((node.getKindSet() & m5994constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                    Modifier.Node delegate = node.getDelegate();
                    int i = 0;
                    node = node;
                    while (delegate != null) {
                        if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                            i++;
                            if (i == 1) {
                                node = delegate;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node != 0) {
                                    if (mutableVector != null) {
                                        mutableVector.add(node);
                                    }
                                    node = 0;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate);
                                }
                            }
                        }
                        delegate = delegate.getChild();
                        node = node;
                    }
                    if (i == 1) {
                    }
                }
                node = DelegatableNodeKt.pop(mutableVector);
            }
            return false;
        }
    };
    private static final HitTestSource SemanticsSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$SemanticsSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            SemanticsConfiguration semanticsConfiguration = parentLayoutNode.getSemanticsConfiguration();
            boolean z = false;
            if (semanticsConfiguration != null && semanticsConfiguration.getIsClearingSemantics()) {
                z = true;
            }
            return !z;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-qzLsGqo */
        public void mo5989childHitTestqzLsGqo(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, int pointerType, boolean isInLayer) {
            layoutNode.m5910hitTestSemantics6fMxITs$ui_release(pointerPosition, hitTestResult, pointerType, isInLayer);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw */
        public int mo5990entityTypeOLwlOKw() {
            return NodeKind.m5994constructorimpl(8);
        }
    };
    private Density layerDensity = getLayoutNode().getDensity();
    private LayoutDirection layerLayoutDirection = getLayoutNode().getLayoutDirection();
    private float lastLayerAlpha = 0.8f;
    private long position = IntOffset.INSTANCE.m7128getZeronOccac();
    private final Function0<Unit> invalidateParentLayer = new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$invalidateParentLayer$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            NodeCoordinator wrappedBy = NodeCoordinator.this.getWrappedBy();
            if (wrappedBy != null) {
                wrappedBy.invalidateLayer();
            }
        }
    };

    /* compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0005H&ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "isInLayer", "", "childHitTest-qzLsGqo", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;IZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "Landroidx/compose/ui/Modifier$Node;", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public interface HitTestSource {
        /* renamed from: childHitTest-qzLsGqo */
        void mo5989childHitTestqzLsGqo(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, int pointerType, boolean isInLayer);

        /* renamed from: entityType-OLwlOKw */
        int mo5990entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(Modifier.Node node);

        boolean shouldHitTestChildren(LayoutNode parentLayoutNode);
    }

    public abstract void ensureLookaheadDelegateCreated();

    public abstract LookaheadDelegate getLookaheadDelegate();

    public abstract Modifier.Node getTail();

    protected abstract void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate);

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public NodeCoordinator(LayoutNode layoutNode) {
        this.layoutNode = layoutNode;
    }

    /* renamed from: getForcePlaceWithLookaheadOffset$ui_release, reason: from getter */
    public final boolean getForcePlaceWithLookaheadOffset() {
        return this.forcePlaceWithLookaheadOffset;
    }

    public final void setForcePlaceWithLookaheadOffset$ui_release(boolean z) {
        this.forcePlaceWithLookaheadOffset = z;
    }

    /* renamed from: getForceMeasureWithLookaheadConstraints$ui_release, reason: from getter */
    public final boolean getForceMeasureWithLookaheadConstraints() {
        return this.forceMeasureWithLookaheadConstraints;
    }

    public final void setForceMeasureWithLookaheadConstraints$ui_release(boolean z) {
        this.forceMeasureWithLookaheadConstraints = z;
    }

    /* renamed from: getWrapped$ui_release, reason: from getter */
    public final NodeCoordinator getWrapped() {
        return this.wrapped;
    }

    public final void setWrapped$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    /* renamed from: getWrappedBy$ui_release, reason: from getter */
    public final NodeCoordinator getWrappedBy() {
        return this.wrappedBy;
    }

    public final void setWrappedBy$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates getCoordinates() {
        return this;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean getIntroducesMotionFrameOfReference() {
        return getIsPlacedUnderMotionFrameOfReference();
    }

    public final Modifier.Node headNode(boolean includeTail) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes().getHead();
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (!includeTail) {
            if (nodeCoordinator != null) {
                return nodeCoordinator.getTail();
            }
            return null;
        }
        if (nodeCoordinator == null || (tail = nodeCoordinator.getTail()) == null) {
            return null;
        }
        return tail.getChild();
    }

    public final void visitNodes(int mask, boolean includeTail, Function1<? super Modifier.Node, Unit> block) {
        Modifier.Node tail = getTail();
        if (!includeTail && (tail = tail.getParent()) == null) {
            return;
        }
        for (Modifier.Node headNode = headNode(includeTail); headNode != null && (headNode.getAggregateChildKindSet() & mask) != 0; headNode = headNode.getChild()) {
            if ((headNode.getKindSet() & mask) != 0) {
                block.invoke(headNode);
            }
            if (headNode == tail) {
                return;
            }
        }
    }

    /* renamed from: visitNodes-aLcG6gQ */
    public final /* synthetic */ <T> void m5987visitNodesaLcG6gQ(int r10, Function1<? super T, Unit> block) {
        boolean m6003getIncludeSelfInTraversalH91voCI = NodeKindKt.m6003getIncludeSelfInTraversalH91voCI(r10);
        Modifier.Node tail = getTail();
        if (!m6003getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return;
        }
        for (Modifier.Node headNode = headNode(m6003getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet() & r10) != 0; headNode = headNode.getChild()) {
            if ((headNode.getKindSet() & r10) != 0) {
                Modifier.Node node = headNode;
                MutableVector mutableVector = null;
                while (node != null) {
                    Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                    if (node instanceof Object) {
                        block.invoke(node);
                    } else if ((node.getKindSet() & r10) != 0 && (node instanceof DelegatingNode)) {
                        int i = 0;
                        for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                            if ((delegate.getKindSet() & r10) != 0) {
                                i++;
                                if (i == 1) {
                                    node = delegate;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node != null) {
                                        if (mutableVector != null) {
                                            mutableVector.add(node);
                                        }
                                        node = null;
                                    }
                                    if (mutableVector != null) {
                                        mutableVector.add(delegate);
                                    }
                                }
                            }
                        }
                        if (i == 1) {
                        }
                    }
                    node = DelegatableNodeKt.pop(mutableVector);
                }
            }
            if (headNode == tail) {
                return;
            }
        }
    }

    /* renamed from: hasNode-H91voCI */
    private final boolean m5964hasNodeH91voCI(int r2) {
        Modifier.Node headNode = headNode(NodeKindKt.m6003getIncludeSelfInTraversalH91voCI(r2));
        return headNode != null && DelegatableNodeKt.m5852has64DMado(headNode, r2);
    }

    /* renamed from: head-H91voCI */
    public final Modifier.Node m5980headH91voCI(int r3) {
        boolean m6003getIncludeSelfInTraversalH91voCI = NodeKindKt.m6003getIncludeSelfInTraversalH91voCI(r3);
        Modifier.Node tail = getTail();
        if (!m6003getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return null;
        }
        for (Modifier.Node headNode = headNode(m6003getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet() & r3) != 0; headNode = headNode.getChild()) {
            if ((headNode.getKindSet() & r3) != 0) {
                return headNode;
            }
            if (headNode == tail) {
                return null;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public final long mo5740getSizeYbymL2g() {
        return getMeasuredSize();
    }

    protected final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate().getAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void replace$ui_release() {
        GraphicsLayer graphicsLayer = this.explicitLayer;
        if (graphicsLayer != null) {
            mo5793placeAtf8xVGno(getPosition(), this.zIndex, graphicsLayer);
        } else {
            mo5733placeAtf8xVGno(getPosition(), this.zIndex, this.layerBlock);
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getTail().getIsAttached();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
    
        if (r0.isNotEmpty() == false) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setMeasureResult$ui_release(androidx.compose.ui.layout.MeasureResult r4) {
        /*
            r3 = this;
            androidx.compose.ui.layout.MeasureResult r0 = r3._measureResult
            if (r4 == r0) goto L8c
            r3._measureResult = r4
            if (r0 == 0) goto L1c
            int r1 = r4.get$width()
            int r2 = r0.get$width()
            if (r1 != r2) goto L1c
            int r1 = r4.get$height()
            int r0 = r0.get$height()
            if (r1 == r0) goto L27
        L1c:
            int r0 = r4.get$width()
            int r1 = r4.get$height()
            r3.onMeasureResultChanged(r0, r1)
        L27:
            androidx.collection.MutableObjectIntMap<androidx.compose.ui.layout.AlignmentLine> r0 = r3.oldAlignmentLines
            if (r0 == 0) goto L34
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.isNotEmpty()
            if (r0 != 0) goto L3e
        L34:
            java.util.Map r0 = r4.getAlignmentLines()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L8c
        L3e:
            androidx.collection.MutableObjectIntMap<androidx.compose.ui.layout.AlignmentLine> r0 = r3.oldAlignmentLines
            java.util.Map r1 = r4.getAlignmentLines()
            boolean r0 = androidx.compose.ui.node.NodeCoordinatorKt.access$compareEquals(r0, r1)
            if (r0 != 0) goto L8c
            androidx.compose.ui.node.AlignmentLinesOwner r0 = r3.getAlignmentLinesOwner()
            androidx.compose.ui.node.AlignmentLines r0 = r0.getAlignmentLines()
            r0.onAlignmentsChanged()
            androidx.collection.MutableObjectIntMap<androidx.compose.ui.layout.AlignmentLine> r0 = r3.oldAlignmentLines
            if (r0 != 0) goto L5f
            androidx.collection.MutableObjectIntMap r0 = androidx.collection.ObjectIntMapKt.mutableObjectIntMapOf()
            r3.oldAlignmentLines = r0
        L5f:
            r0.clear()
            java.util.Map r3 = r4.getAlignmentLines()
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L6e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L8c
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r1 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r0.set(r1, r4)
            goto L6e
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeCoordinator.setMeasureResult$ui_release(androidx.compose.ui.layout.MeasureResult):void");
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        LinkedHashSet linkedHashSet = null;
        while (this != null) {
            MeasureResult measureResult = this._measureResult;
            Map<AlignmentLine, Integer> alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.addAll(alignmentLines.keySet());
            }
            this = this.wrapped;
        }
        return linkedHashSet == null ? SetsKt.emptySet() : linkedHashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    protected void onMeasureResultChanged(int width, int height) {
        NodeCoordinator nodeCoordinator;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo6050resizeozmzZPI(IntSize.m7155constructorimpl((width << 32) | (height & 4294967295L)));
        } else if (getLayoutNode().isPlaced() && (nodeCoordinator = this.wrappedBy) != null) {
            nodeCoordinator.invalidateLayer();
        }
        m5794setMeasuredSizeozmzZPI(IntSize.m7155constructorimpl((height & 4294967295L) | (width << 32)));
        if (this.layerBlock != null) {
            updateLayerParameters(false);
        }
        int m5994constructorimpl = NodeKind.m5994constructorimpl(4);
        boolean m6003getIncludeSelfInTraversalH91voCI = NodeKindKt.m6003getIncludeSelfInTraversalH91voCI(m5994constructorimpl);
        Modifier.Node tail = getTail();
        if (m6003getIncludeSelfInTraversalH91voCI || (tail = tail.getParent()) != null) {
            for (Modifier.Node headNode = headNode(m6003getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet() & m5994constructorimpl) != 0; headNode = headNode.getChild()) {
                if ((headNode.getKindSet() & m5994constructorimpl) != 0) {
                    DelegatingNode delegatingNode = headNode;
                    MutableVector mutableVector = null;
                    while (delegatingNode != 0) {
                        if (delegatingNode instanceof DrawModifierNode) {
                            ((DrawModifierNode) delegatingNode).onMeasureResultChanged();
                        } else if ((delegatingNode.getKindSet() & m5994constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                            Modifier.Node delegate = delegatingNode.getDelegate();
                            int i = 0;
                            delegatingNode = delegatingNode;
                            while (delegate != null) {
                                if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        delegatingNode = delegate;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (delegatingNode != 0) {
                                            if (mutableVector != null) {
                                                mutableVector.add(delegatingNode);
                                            }
                                            delegatingNode = 0;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate);
                                        }
                                    }
                                }
                                delegate = delegate.getChild();
                                delegatingNode = delegatingNode;
                            }
                            if (i == 1) {
                            }
                        }
                        delegatingNode = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if (headNode == tail) {
                    break;
                }
            }
        }
        Owner owner = getLayoutNode().getOwner();
        if (owner != null) {
            owner.onLayoutChange(getLayoutNode());
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* renamed from: getPosition-nOcc-ac, reason: from getter */
    public long getPosition() {
        return this.position;
    }

    /* renamed from: setPosition--gyyYBs */
    protected void m5985setPositiongyyYBs(long j) {
        this.position = j;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    protected final void setZIndex(float f) {
        this.zIndex = f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        if (!getLayoutNode().getNodes().m5955hasH91voCI$ui_release(NodeKind.m5994constructorimpl(64))) {
            return null;
        }
        getTail();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        for (Modifier.Node tail = getLayoutNode().getNodes().getTail(); tail != null; tail = tail.getParent()) {
            if ((NodeKind.m5994constructorimpl(64) & tail.getKindSet()) != 0) {
                int m5994constructorimpl = NodeKind.m5994constructorimpl(64);
                MutableVector mutableVector = null;
                DelegatingNode delegatingNode = tail;
                while (delegatingNode != 0) {
                    if (delegatingNode instanceof ParentDataModifierNode) {
                        objectRef.element = ((ParentDataModifierNode) delegatingNode).modifyParentData(getLayoutNode().getDensity(), objectRef.element);
                    } else if ((delegatingNode.getKindSet() & m5994constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                        Modifier.Node delegate = delegatingNode.getDelegate();
                        int i = 0;
                        delegatingNode = delegatingNode;
                        while (delegate != null) {
                            if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                                i++;
                                if (i == 1) {
                                    delegatingNode = delegate;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (delegatingNode != 0) {
                                        if (mutableVector != null) {
                                            mutableVector.add(delegatingNode);
                                        }
                                        delegatingNode = 0;
                                    }
                                    if (mutableVector != null) {
                                        mutableVector.add(delegate);
                                    }
                                }
                            }
                            delegate = delegate.getChild();
                            delegatingNode = delegatingNode;
                        }
                        if (i == 1) {
                        }
                    }
                    delegatingNode = DelegatableNodeKt.pop(mutableVector);
                }
            }
        }
        return objectRef.element;
    }

    public final void onCoordinatesUsed$ui_release() {
        getLayoutNode().getLayoutDelegate().onCoordinatesUsed();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentCoordinates() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        return this.wrappedBy;
    }

    protected final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = mutableRect2;
        return mutableRect2;
    }

    public final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* renamed from: getLastMeasurementConstraints-msEJaDk$ui_release */
    public final long m5978getLastMeasurementConstraintsmsEJaDk$ui_release() {
        return getMeasurementConstraints();
    }

    /* renamed from: performingMeasure-K40F9xA */
    protected final Placeable m5983performingMeasureK40F9xA(long constraints, Function0<? extends Placeable> block) {
        m5795setMeasurementConstraintsBRTryo0(constraints);
        return block.invoke();
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo5733placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        if (this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            m5970placeSelfMLgxB_4(lookaheadDelegate.getPosition(), zIndex, layerBlock, null);
            return;
        }
        m5970placeSelfMLgxB_4(position, zIndex, layerBlock, null);
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo5793placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) {
        if (this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            m5970placeSelfMLgxB_4(lookaheadDelegate.getPosition(), zIndex, null, layer);
            return;
        }
        m5970placeSelfMLgxB_4(position, zIndex, null, layer);
    }

    /* renamed from: placeSelf-MLgxB_4 */
    private final void m5970placeSelfMLgxB_4(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer explicitLayer) {
        if (explicitLayer != null) {
            if (!(layerBlock == null)) {
                InlineClassHelperKt.throwIllegalArgumentException("both ways to create layers shouldn't be used together");
            }
            if (this.explicitLayer != explicitLayer) {
                this.explicitLayer = null;
                updateLayerBlock$default(this, null, false, 2, null);
                this.explicitLayer = explicitLayer;
            }
            if (this.layer == null) {
                OwnedLayer createLayer$default = Owner.createLayer$default(LayoutNodeKt.requireOwner(getLayoutNode()), getDrawBlock(), this.invalidateParentLayer, explicitLayer, false, 8, null);
                createLayer$default.mo6050resizeozmzZPI(getMeasuredSize());
                createLayer$default.mo6049movegyyYBs(position);
                this.layer = createLayer$default;
                getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
            }
        } else {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
                updateLayerBlock$default(this, null, false, 2, null);
            }
            updateLayerBlock$default(this, layerBlock, false, 2, null);
        }
        if (!IntOffset.m7116equalsimpl0(getPosition(), position)) {
            m5985setPositiongyyYBs(position);
            getLayoutNode().getLayoutDelegate().getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo6049movegyyYBs(position);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner = getLayoutNode().getOwner();
            if (owner != null) {
                owner.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = zIndex;
        if (getIsPlacingForAlignment()) {
            return;
        }
        captureRulers$ui_release(getMeasureResult$ui_release());
    }

    public final void releaseLayer() {
        if (this.layer != null) {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
            }
            updateLayerBlock$default(this, null, false, 2, null);
            LayoutNode.requestRelayout$ui_release$default(getLayoutNode(), false, 1, null);
        }
    }

    /* renamed from: placeSelfApparentToRealOffset-MLgxB_4 */
    public final void m5984placeSelfApparentToRealOffsetMLgxB_4(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer layer) {
        m5970placeSelfMLgxB_4(IntOffset.m7121plusqkQi6aY(position, getApparentToRealOffset()), zIndex, layerBlock, layer);
    }

    public final void draw(Canvas canvas, GraphicsLayer graphicsLayer) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas, graphicsLayer);
            return;
        }
        float m7117getXimpl = IntOffset.m7117getXimpl(getPosition());
        float m7118getYimpl = IntOffset.m7118getYimpl(getPosition());
        canvas.translate(m7117getXimpl, m7118getYimpl);
        drawContainedDrawModifiers(canvas, graphicsLayer);
        canvas.translate(-m7117getXimpl, -m7118getYimpl);
    }

    public void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas, graphicsLayer);
        }
    }

    private final Function2<Canvas, GraphicsLayer, Unit> getDrawBlock() {
        Function2 function2 = this._drawBlock;
        if (function2 != null) {
            return function2;
        }
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$drawBlockCallToDrawModifiers$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Canvas canvas;
                GraphicsLayer graphicsLayer;
                NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                canvas = nodeCoordinator.drawBlockCanvas;
                Intrinsics.checkNotNull(canvas);
                graphicsLayer = NodeCoordinator.this.drawBlockParentLayer;
                nodeCoordinator.drawContainedDrawModifiers(canvas, graphicsLayer);
            }
        };
        Function2<Canvas, GraphicsLayer, Unit> function22 = new Function2<Canvas, GraphicsLayer, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas, GraphicsLayer graphicsLayer) {
                invoke2(canvas, graphicsLayer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Canvas canvas, GraphicsLayer graphicsLayer) {
                OwnerSnapshotObserver snapshotObserver;
                Function1 function1;
                boolean isPlaced = NodeCoordinator.this.getLayoutNode().isPlaced();
                NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                if (isPlaced) {
                    nodeCoordinator.drawBlockCanvas = canvas;
                    NodeCoordinator.this.drawBlockParentLayer = graphicsLayer;
                    snapshotObserver = NodeCoordinator.this.getSnapshotObserver();
                    NodeCoordinator nodeCoordinator2 = NodeCoordinator.this;
                    function1 = NodeCoordinator.onCommitAffectingLayer;
                    snapshotObserver.observeReads$ui_release(nodeCoordinator2, function1, function0);
                    NodeCoordinator.this.lastLayerDrawingWasSkipped = false;
                    return;
                }
                nodeCoordinator.lastLayerDrawingWasSkipped = true;
            }
        };
        this._drawBlock = function22;
        return function22;
    }

    public static /* synthetic */ void updateLayerBlock$default(NodeCoordinator nodeCoordinator, Function1 function1, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        nodeCoordinator.updateLayerBlock(function1, z);
    }

    public final void updateLayerBlock(Function1<? super GraphicsLayerScope, Unit> layerBlock, boolean forceUpdateLayerParameters) {
        Owner owner;
        if (!(layerBlock == null || this.explicitLayer == null)) {
            InlineClassHelperKt.throwIllegalArgumentException("layerBlock can't be provided when explicitLayer is provided");
        }
        LayoutNode layoutNode = getLayoutNode();
        boolean z = (!forceUpdateLayerParameters && this.layerBlock == layerBlock && Intrinsics.areEqual(this.layerDensity, layoutNode.getDensity()) && this.layerLayoutDirection == layoutNode.getLayoutDirection()) ? false : true;
        this.layerDensity = layoutNode.getDensity();
        this.layerLayoutDirection = layoutNode.getLayoutDirection();
        if (layoutNode.isAttached() && layerBlock != null) {
            this.layerBlock = layerBlock;
            if (this.layer == null) {
                OwnedLayer createLayer$default = Owner.createLayer$default(LayoutNodeKt.requireOwner(layoutNode), getDrawBlock(), this.invalidateParentLayer, null, layoutNode.getForceUseOldLayers(), 4, null);
                createLayer$default.mo6050resizeozmzZPI(getMeasuredSize());
                createLayer$default.mo6049movegyyYBs(getPosition());
                this.layer = createLayer$default;
                updateLayerParameters$default(this, false, 1, null);
                layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
                return;
            }
            if (z && updateLayerParameters$default(this, false, 1, null)) {
                LayoutNodeKt.requireOwner(layoutNode).getRectManager().onLayoutLayerPositionalPropertiesChanged(layoutNode);
                return;
            }
            return;
        }
        this.layerBlock = null;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.destroy();
            layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
            if (isAttached() && layoutNode.isPlaced() && (owner = layoutNode.getOwner()) != null) {
                owner.onLayoutChange(layoutNode);
            }
        }
        this.layer = null;
        this.lastLayerDrawingWasSkipped = false;
    }

    public static /* synthetic */ boolean updateLayerParameters$default(NodeCoordinator nodeCoordinator, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return nodeCoordinator.updateLayerParameters(z);
    }

    private final boolean updateLayerParameters(boolean invokeOnLayoutChange) {
        Owner owner;
        if (this.explicitLayer != null) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        final Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
        if (ownedLayer == null) {
            if (!(function1 == null)) {
                InlineClassHelperKt.throwIllegalStateException("null layer with a non-null layerBlock");
            }
            return false;
        }
        if (function1 != null) {
            ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
            reusableGraphicsLayerScope.reset();
            reusableGraphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
            reusableGraphicsLayerScope.setLayoutDirection$ui_release(getLayoutNode().getLayoutDirection());
            reusableGraphicsLayerScope.m4696setSizeuvyYCjk(IntSizeKt.m7172toSizeozmzZPI(mo5740getSizeYbymL2g()));
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$updateLayerParameters$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ReusableGraphicsLayerScope reusableGraphicsLayerScope2;
                    ReusableGraphicsLayerScope reusableGraphicsLayerScope3;
                    Function1<GraphicsLayerScope, Unit> function12 = function1;
                    reusableGraphicsLayerScope2 = NodeCoordinator.graphicsLayerScope;
                    function12.invoke(reusableGraphicsLayerScope2);
                    reusableGraphicsLayerScope3 = NodeCoordinator.graphicsLayerScope;
                    reusableGraphicsLayerScope3.updateOutline$ui_release();
                }
            });
            LayerPositionalProperties layerPositionalProperties = this.layerPositionalProperties;
            if (layerPositionalProperties == null) {
                layerPositionalProperties = new LayerPositionalProperties();
                this.layerPositionalProperties = layerPositionalProperties;
            }
            LayerPositionalProperties layerPositionalProperties2 = tmpLayerPositionalProperties;
            layerPositionalProperties2.copyFrom(layerPositionalProperties);
            layerPositionalProperties.copyFrom(reusableGraphicsLayerScope);
            ownedLayer.updateLayerProperties(reusableGraphicsLayerScope);
            boolean z = this.isClipping;
            this.isClipping = reusableGraphicsLayerScope.getClip();
            this.lastLayerAlpha = reusableGraphicsLayerScope.getAlpha();
            boolean hasSameValuesAs = layerPositionalProperties2.hasSameValuesAs(layerPositionalProperties);
            boolean z2 = !hasSameValuesAs;
            if (invokeOnLayoutChange && ((!hasSameValuesAs || z != this.isClipping) && (owner = getLayoutNode().getOwner()) != null)) {
                owner.onLayoutChange(getLayoutNode());
            }
            return z2;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("updateLayerParameters requires a non-null layerBlock");
        throw new KotlinNothingValueException();
    }

    /* renamed from: getLastLayerDrawingWasSkipped$ui_release, reason: from getter */
    public final boolean getLastLayerDrawingWasSkipped() {
        return this.lastLayerDrawingWasSkipped;
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return (this.layer == null || this.released || !getLayoutNode().isAttached()) ? false : true;
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc */
    public final long m5979getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.mo701toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().mo5916getMinimumTouchTargetSizeMYxV2XQ());
    }

    public final void onAttach() {
        if (this.layer != null || this.layerBlock == null) {
            return;
        }
        OwnedLayer createLayer$default = Owner.createLayer$default(LayoutNodeKt.requireOwner(getLayoutNode()), getDrawBlock(), this.invalidateParentLayer, this.explicitLayer, false, 8, null);
        createLayer$default.mo6050resizeozmzZPI(getMeasuredSize());
        createLayer$default.mo6049movegyyYBs(getPosition());
        createLayer$default.invalidate();
        this.layer = createLayer$default;
    }

    public final void onDetach() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.destroy();
        }
        this.layer = null;
    }

    /* renamed from: hitTest-qzLsGqo */
    public final void m5981hitTestqzLsGqo(HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, int pointerType, boolean isInLayer) {
        boolean z;
        Modifier.Node m5980headH91voCI = m5980headH91voCI(hitTestSource.mo5990entityTypeOLwlOKw());
        boolean z2 = false;
        if (!m5988withinLayerBoundsk4lQ0M(pointerPosition)) {
            if (PointerType.m5678equalsimpl0(pointerType, PointerType.INSTANCE.m5685getTouchT8wyACA())) {
                float m5976distanceInMinimumTouchTargettz77jQw = m5976distanceInMinimumTouchTargettz77jQw(pointerPosition, m5979getMinimumTouchTargetSizeNHjbRc());
                if ((Float.floatToRawIntBits(m5976distanceInMinimumTouchTargettz77jQw) & Integer.MAX_VALUE) >= 2139095040 || !hitTestResult.isHitInMinimumTouchTargetBetter(m5976distanceInMinimumTouchTargettz77jQw, false)) {
                    return;
                }
                m5966hitNearFh5PU_I(m5980headH91voCI, hitTestSource, pointerPosition, hitTestResult, pointerType, false, m5976distanceInMinimumTouchTargettz77jQw);
                return;
            }
            return;
        }
        if (m5980headH91voCI == null) {
            mo5898hitTestChildqzLsGqo(hitTestSource, pointerPosition, hitTestResult, pointerType, isInLayer);
            return;
        }
        if (m5982isPointerInBoundsk4lQ0M(pointerPosition)) {
            m5965hit5ShdDok(m5980headH91voCI, hitTestSource, pointerPosition, hitTestResult, pointerType, isInLayer);
            return;
        }
        float m5976distanceInMinimumTouchTargettz77jQw2 = !PointerType.m5678equalsimpl0(pointerType, PointerType.INSTANCE.m5685getTouchT8wyACA()) ? Float.POSITIVE_INFINITY : m5976distanceInMinimumTouchTargettz77jQw(pointerPosition, m5979getMinimumTouchTargetSizeNHjbRc());
        if ((Float.floatToRawIntBits(m5976distanceInMinimumTouchTargettz77jQw2) & Integer.MAX_VALUE) < 2139095040) {
            z = isInLayer;
            if (hitTestResult.isHitInMinimumTouchTargetBetter(m5976distanceInMinimumTouchTargettz77jQw2, z)) {
                z2 = true;
            }
        } else {
            z = isInLayer;
        }
        m5969outOfBoundsHit8NAm7pk(m5980headH91voCI, hitTestSource, pointerPosition, hitTestResult, pointerType, z, m5976distanceInMinimumTouchTargettz77jQw2, z2);
    }

    /* renamed from: hit-5ShdDok */
    private final void m5965hit5ShdDok(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, int i, boolean z) {
        long DistanceAndFlags;
        Modifier.Node m5992nextUntilhw7D004;
        if (node != null) {
            int i2 = hitTestResult.hitDepth;
            hitTestResult.removeNodesInRange(hitTestResult.hitDepth + 1, hitTestResult.size());
            hitTestResult.hitDepth++;
            hitTestResult.values.add(node);
            MutableLongList mutableLongList = hitTestResult.distanceFromEdgeAndFlags;
            DistanceAndFlags = HitTestResultKt.DistanceAndFlags(-1.0f, z, false);
            mutableLongList.add(DistanceAndFlags);
            m5992nextUntilhw7D004 = NodeCoordinatorKt.m5992nextUntilhw7D004(node, hitTestSource.mo5990entityTypeOLwlOKw(), NodeKind.m5994constructorimpl(2));
            m5965hit5ShdDok(m5992nextUntilhw7D004, hitTestSource, j, hitTestResult, i, z);
            hitTestResult.hitDepth = i2;
            return;
        }
        mo5898hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
    }

    /* renamed from: outOfBoundsHit-8NAm7pk */
    public final void m5969outOfBoundsHit8NAm7pk(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final int i, final boolean z, final float f, final boolean z2) {
        if (node == null) {
            mo5898hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
            return;
        }
        if (m5967isInExpandedTouchBoundsThDn1k(node, j, i)) {
            hitTestResult.hitExpandedTouchBounds(node, z, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$outOfBoundsHit$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Modifier.Node m5992nextUntilhw7D004;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    m5992nextUntilhw7D004 = NodeCoordinatorKt.m5992nextUntilhw7D004(node, hitTestSource.mo5990entityTypeOLwlOKw(), NodeKind.m5994constructorimpl(2));
                    nodeCoordinator.m5969outOfBoundsHit8NAm7pk(m5992nextUntilhw7D004, hitTestSource, j, hitTestResult, i, z, f, z2);
                }
            });
        } else if (z2) {
            m5966hitNearFh5PU_I(node, hitTestSource, j, hitTestResult, i, z, f);
        } else {
            m5971speculativeHitFh5PU_I(node, hitTestSource, j, hitTestResult, i, z, f);
        }
    }

    /* renamed from: hitNear-Fh5PU_I */
    private final void m5966hitNearFh5PU_I(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, int i, boolean z, float f) {
        long DistanceAndFlags;
        Modifier.Node m5992nextUntilhw7D004;
        if (node != null) {
            int i2 = hitTestResult.hitDepth;
            hitTestResult.removeNodesInRange(hitTestResult.hitDepth + 1, hitTestResult.size());
            hitTestResult.hitDepth++;
            hitTestResult.values.add(node);
            MutableLongList mutableLongList = hitTestResult.distanceFromEdgeAndFlags;
            DistanceAndFlags = HitTestResultKt.DistanceAndFlags(f, z, false);
            mutableLongList.add(DistanceAndFlags);
            m5992nextUntilhw7D004 = NodeCoordinatorKt.m5992nextUntilhw7D004(node, hitTestSource.mo5990entityTypeOLwlOKw(), NodeKind.m5994constructorimpl(2));
            m5969outOfBoundsHit8NAm7pk(m5992nextUntilhw7D004, hitTestSource, j, hitTestResult, i, z, f, true);
            hitTestResult.hitDepth = i2;
            return;
        }
        mo5898hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
    }

    /* renamed from: speculativeHit-Fh5PU_I */
    private final void m5971speculativeHitFh5PU_I(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final int i, final boolean z, final float f) {
        Modifier.Node m5992nextUntilhw7D004;
        if (node == null) {
            mo5898hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
        } else if (!hitTestSource.interceptOutOfBoundsChildEvents(node)) {
            m5992nextUntilhw7D004 = NodeCoordinatorKt.m5992nextUntilhw7D004(node, hitTestSource.mo5990entityTypeOLwlOKw(), NodeKind.m5994constructorimpl(2));
            m5969outOfBoundsHit8NAm7pk(m5992nextUntilhw7D004, hitTestSource, j, hitTestResult, i, z, f, false);
        } else {
            hitTestResult.speculativeHit(node, f, z, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$speculativeHit$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Modifier.Node m5992nextUntilhw7D0042;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    m5992nextUntilhw7D0042 = NodeCoordinatorKt.m5992nextUntilhw7D004(node, hitTestSource.mo5990entityTypeOLwlOKw(), NodeKind.m5994constructorimpl(2));
                    nodeCoordinator.m5969outOfBoundsHit8NAm7pk(m5992nextUntilhw7D0042, hitTestSource, j, hitTestResult, i, z, f, false);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* renamed from: isInExpandedTouchBounds-ThD-n1k */
    private final boolean m5967isInExpandedTouchBoundsThDn1k(Modifier.Node node, long j, int i) {
        if (node == 0) {
            return false;
        }
        if (!PointerType.m5678equalsimpl0(i, PointerType.INSTANCE.m5684getStylusT8wyACA()) && !PointerType.m5678equalsimpl0(i, PointerType.INSTANCE.m5682getEraserT8wyACA())) {
            return false;
        }
        int m5994constructorimpl = NodeKind.m5994constructorimpl(16);
        MutableVector mutableVector = null;
        while (node != 0) {
            if (node instanceof PointerInputModifierNode) {
                long mo1498getTouchBoundsExpansionRZrCHBk = ((PointerInputModifierNode) node).mo1498getTouchBoundsExpansionRZrCHBk();
                int i2 = (int) (j >> 32);
                if (Float.intBitsToFloat(i2) >= (-TouchBoundsExpansion.m6074computeLeftimpl$ui_release(mo1498getTouchBoundsExpansionRZrCHBk, getLayoutDirection())) && Float.intBitsToFloat(i2) < getMeasuredWidth() + TouchBoundsExpansion.m6075computeRightimpl$ui_release(mo1498getTouchBoundsExpansionRZrCHBk, getLayoutDirection())) {
                    int i3 = (int) (j & 4294967295L);
                    if (Float.intBitsToFloat(i3) >= (-TouchBoundsExpansion.m6082getTopimpl(mo1498getTouchBoundsExpansionRZrCHBk)) && Float.intBitsToFloat(i3) < getMeasuredHeight() + TouchBoundsExpansion.m6079getBottomimpl(mo1498getTouchBoundsExpansionRZrCHBk)) {
                        return true;
                    }
                }
                return false;
            }
            if ((node.getKindSet() & m5994constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                Modifier.Node delegate = node.getDelegate();
                int i4 = 0;
                node = node;
                while (delegate != null) {
                    if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                        i4++;
                        if (i4 == 1) {
                            node = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != 0) {
                                if (mutableVector != null) {
                                    mutableVector.add(node);
                                }
                                node = 0;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate);
                            }
                        }
                    }
                    delegate = delegate.getChild();
                    node = node;
                }
                if (i4 == 1) {
                }
            }
            node = DelegatableNodeKt.pop(mutableVector);
        }
        return false;
    }

    /* renamed from: hitTestChild-qzLsGqo */
    public void mo5898hitTestChildqzLsGqo(HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, int pointerType, boolean isInLayer) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m5981hitTestqzLsGqo(hitTestSource, m5963fromParentPosition8S9VItk$default(nodeCoordinator, pointerPosition, false, 2, null), hitTestResult, pointerType, isInLayer);
        }
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.INSTANCE.getZero();
        }
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect rectCache = getRectCache();
        long m5975calculateMinimumTouchTargetPaddingE7KxVPU = m5975calculateMinimumTouchTargetPaddingE7KxVPU(m5979getMinimumTouchTargetSizeNHjbRc());
        int i = (int) (m5975calculateMinimumTouchTargetPaddingE7KxVPU >> 32);
        rectCache.setLeft(-Float.intBitsToFloat(i));
        int i2 = (int) (m5975calculateMinimumTouchTargetPaddingE7KxVPU & 4294967295L);
        rectCache.setTop(-Float.intBitsToFloat(i2));
        rectCache.setRight(getMeasuredWidth() + Float.intBitsToFloat(i));
        rectCache.setBottom(getMeasuredHeight() + Float.intBitsToFloat(i2));
        while (this != findRootCoordinates) {
            this.rectInParent$ui_release(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            this = this.wrappedBy;
            Intrinsics.checkNotNull(this);
        }
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo5746screenToLocalMKHz9U(long relativeToScreen) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        return mo5741localPositionOfR5De75A(LayoutCoordinatesKt.findRootCoordinates(this), LayoutNodeKt.requireOwner(getLayoutNode()).mo5688screenToLocalMKHz9U(relativeToScreen));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToScreen-MK-Hz9U */
    public long mo5744localToScreenMKHz9U(long relativeToLocal) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        return LayoutNodeKt.requireOwner(getLayoutNode()).mo5687localToScreenMKHz9U(mo5743localToRootMKHz9U(relativeToLocal));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo5749windowToLocalMKHz9U(long relativeToWindow) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        return mo5741localPositionOfR5De75A(findRootCoordinates, Offset.m4129minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).mo6052calculateLocalPositionMKHz9U(relativeToWindow), LayoutCoordinatesKt.positionInRoot(findRootCoordinates)));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo5745localToWindowMKHz9U(long relativeToLocal) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).mo6053calculatePositionInWindowMKHz9U(mo5743localToRootMKHz9U(relativeToLocal));
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates = layoutCoordinates instanceof LookaheadLayoutCoordinates ? (LookaheadLayoutCoordinates) layoutCoordinates : null;
        if (lookaheadLayoutCoordinates != null && (coordinator = lookaheadLayoutCoordinates.getCoordinator()) != null) {
            return coordinator;
        }
        Intrinsics.checkNotNull(layoutCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) layoutCoordinates;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public long mo5741localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        return mo5742localPositionOfS_NoaFU(sourceCoordinates, relativeToSource, true);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-S_NoaFU */
    public long mo5742localPositionOfS_NoaFU(LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference) {
        if (sourceCoordinates instanceof LookaheadLayoutCoordinates) {
            ((LookaheadLayoutCoordinates) sourceCoordinates).getCoordinator().onCoordinatesUsed$ui_release();
            return Offset.m4117constructorimpl(sourceCoordinates.mo5742localPositionOfS_NoaFU(this, Offset.m4117constructorimpl(relativeToSource ^ (-9223372034707292160L)), includeMotionFrameOfReference) ^ (-9223372034707292160L));
        }
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        while (coordinator != findCommonAncestor$ui_release) {
            relativeToSource = coordinator.m5986toParentPosition8S9VItk(relativeToSource, includeMotionFrameOfReference);
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        return m5962ancestorToLocalS_NoaFU(findCommonAncestor$ui_release, relativeToSource, includeMotionFrameOfReference);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformFrom-EL8BTi8 */
    public void mo5747transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        Matrix.m4623resetimpl(matrix);
        coordinator.m5974transformToAncestorEL8BTi8(findCommonAncestor$ui_release, matrix);
        m5973transformFromAncestorEL8BTi8(findCommonAncestor$ui_release, matrix);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformToScreen-58bKbWc */
    public void mo5748transformToScreen58bKbWc(float[] matrix) {
        Owner requireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        NodeCoordinator coordinator = toCoordinator(LayoutCoordinatesKt.findRootCoordinates(this));
        m5974transformToAncestorEL8BTi8(coordinator, matrix);
        if (requireOwner instanceof MatrixPositionCalculator) {
            ((MatrixPositionCalculator) requireOwner).mo5536localToScreen58bKbWc(matrix);
            return;
        }
        long positionOnScreen = LayoutCoordinatesKt.positionOnScreen(coordinator);
        if ((9223372034707292159L & positionOnScreen) != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            Matrix.m4635translateimpl(matrix, Float.intBitsToFloat((int) (positionOnScreen >> 32)), Float.intBitsToFloat((int) (positionOnScreen & 4294967295L)), 0.0f);
        }
    }

    /* renamed from: transformToAncestor-EL8BTi8 */
    private final void m5974transformToAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        while (!Intrinsics.areEqual(this, ancestor)) {
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo6051transform58bKbWc(matrix);
            }
            if (!IntOffset.m7116equalsimpl0(this.getPosition(), IntOffset.INSTANCE.m7128getZeronOccac())) {
                float[] fArr = tmpMatrix;
                Matrix.m4623resetimpl(fArr);
                Matrix.m4636translateimpl$default(fArr, IntOffset.m7117getXimpl(r0), IntOffset.m7118getYimpl(r0), 0.0f, 4, null);
                Matrix.m4633timesAssign58bKbWc(matrix, fArr);
            }
            this = this.wrappedBy;
            Intrinsics.checkNotNull(this);
        }
    }

    /* renamed from: transformFromAncestor-EL8BTi8 */
    private final void m5973transformFromAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        if (Intrinsics.areEqual(ancestor, this)) {
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        Intrinsics.checkNotNull(nodeCoordinator);
        nodeCoordinator.m5973transformFromAncestorEL8BTi8(ancestor, matrix);
        if (!IntOffset.m7116equalsimpl0(getPosition(), IntOffset.INSTANCE.m7128getZeronOccac())) {
            float[] fArr = tmpMatrix;
            Matrix.m4623resetimpl(fArr);
            Matrix.m4636translateimpl$default(fArr, -IntOffset.m7117getXimpl(getPosition()), -IntOffset.m7118getYimpl(getPosition()), 0.0f, 4, null);
            Matrix.m4633timesAssign58bKbWc(matrix, fArr);
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo6046inverseTransform58bKbWc(matrix);
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        if (!sourceCoordinates.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates " + sourceCoordinates + " is not attached!");
        }
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        MutableRect rectCache = getRectCache();
        rectCache.setLeft(0.0f);
        rectCache.setTop(0.0f);
        rectCache.setRight((int) (sourceCoordinates.mo5740getSizeYbymL2g() >> 32));
        rectCache.setBottom((int) (sourceCoordinates.mo5740getSizeYbymL2g() & 4294967295L));
        NodeCoordinator nodeCoordinator = coordinator;
        while (nodeCoordinator != findCommonAncestor$ui_release) {
            boolean z = clipBounds;
            rectInParent$ui_release$default(nodeCoordinator, rectCache, z, false, 4, null);
            if (rectCache.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            clipBounds = z;
        }
        ancestorToLocal(findCommonAncestor$ui_release, rectCache, clipBounds);
        return MutableRectKt.toRect(rectCache);
    }

    /* renamed from: ancestorToLocal-S_NoaFU */
    private final long m5962ancestorToLocalS_NoaFU(NodeCoordinator ancestor, long r4, boolean includeMotionFrameOfReference) {
        if (ancestor == this) {
            return r4;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator == null || Intrinsics.areEqual(ancestor, nodeCoordinator)) {
            return m5977fromParentPosition8S9VItk(r4, includeMotionFrameOfReference);
        }
        return m5977fromParentPosition8S9VItk(nodeCoordinator.m5962ancestorToLocalS_NoaFU(ancestor, r4, includeMotionFrameOfReference), includeMotionFrameOfReference);
    }

    private final void ancestorToLocal(NodeCoordinator ancestor, MutableRect rect, boolean clipBounds) {
        if (ancestor == this) {
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.ancestorToLocal(ancestor, rect, clipBounds);
        }
        fromParentRect(rect, clipBounds);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public long mo5743localToRootMKHz9U(long relativeToLocal) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        long j = relativeToLocal;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
            j = m5972toParentPosition8S9VItk$default(nodeCoordinator, j, false, 2, null);
        }
        return j;
    }

    protected final void withPositionTranslation(Canvas canvas, Function1<? super Canvas, Unit> block) {
        float m7117getXimpl = IntOffset.m7117getXimpl(getPosition());
        float m7118getYimpl = IntOffset.m7118getYimpl(getPosition());
        canvas.translate(m7117getXimpl, m7118getYimpl);
        block.invoke(canvas);
        canvas.translate(-m7117getXimpl, -m7118getYimpl);
    }

    /* renamed from: toParentPosition-8S9VItk$default */
    public static /* synthetic */ long m5972toParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toParentPosition-8S9VItk");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return nodeCoordinator.m5986toParentPosition8S9VItk(j, z);
    }

    /* renamed from: toParentPosition-8S9VItk */
    public long m5986toParentPosition8S9VItk(long position, boolean includeMotionFrameOfReference) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            position = ownedLayer.mo6048mapOffset8S9VItk(position, false);
        }
        return (includeMotionFrameOfReference || !getIsPlacedUnderMotionFrameOfReference()) ? IntOffsetKt.m7132plusNvtHpc(position, getPosition()) : position;
    }

    /* renamed from: fromParentPosition-8S9VItk$default */
    public static /* synthetic */ long m5963fromParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fromParentPosition-8S9VItk");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return nodeCoordinator.m5977fromParentPosition8S9VItk(j, z);
    }

    /* renamed from: fromParentPosition-8S9VItk */
    public long m5977fromParentPosition8S9VItk(long position, boolean includeMotionFrameOfReference) {
        if (includeMotionFrameOfReference || !getIsPlacedUnderMotionFrameOfReference()) {
            position = IntOffsetKt.m7130minusNvtHpc(position, getPosition());
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ownedLayer.mo6048mapOffset8S9VItk(position, true) : position;
    }

    public final void drawBorder(Canvas canvas, Paint paint) {
        canvas.drawRect(0.5f, 0.5f, ((int) (getMeasuredSize() >> 32)) - 0.5f, ((int) (getMeasuredSize() & 4294967295L)) - 0.5f, paint);
    }

    public final void onLayoutNodeAttach() {
        updateLayerBlock(this.layerBlock, true);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void onRelease() {
        this.released = true;
        this.invalidateParentLayer.invoke();
        releaseLayer();
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        nodeCoordinator.rectInParent$ui_release(mutableRect, z, z2);
    }

    public final void rectInParent$ui_release(MutableRect bounds, boolean clipBounds, boolean clipToMinimumTouchTargetSize) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (clipToMinimumTouchTargetSize) {
                    long m5979getMinimumTouchTargetSizeNHjbRc = m5979getMinimumTouchTargetSizeNHjbRc();
                    float intBitsToFloat = Float.intBitsToFloat((int) (m5979getMinimumTouchTargetSizeNHjbRc >> 32)) / 2.0f;
                    float intBitsToFloat2 = Float.intBitsToFloat((int) (m5979getMinimumTouchTargetSizeNHjbRc & 4294967295L)) / 2.0f;
                    bounds.intersect(-intBitsToFloat, -intBitsToFloat2, ((int) (mo5740getSizeYbymL2g() >> 32)) + intBitsToFloat, ((int) (4294967295L & mo5740getSizeYbymL2g())) + intBitsToFloat2);
                } else if (clipBounds) {
                    bounds.intersect(0.0f, 0.0f, (int) (mo5740getSizeYbymL2g() >> 32), (int) (4294967295L & mo5740getSizeYbymL2g()));
                }
                if (bounds.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(bounds, false);
        }
        float m7117getXimpl = IntOffset.m7117getXimpl(getPosition());
        bounds.setLeft(bounds.getLeft() + m7117getXimpl);
        bounds.setRight(bounds.getRight() + m7117getXimpl);
        float m7118getYimpl = IntOffset.m7118getYimpl(getPosition());
        bounds.setTop(bounds.getTop() + m7118getYimpl);
        bounds.setBottom(bounds.getBottom() + m7118getYimpl);
    }

    private final void fromParentRect(MutableRect bounds, boolean clipBounds) {
        float m7117getXimpl = IntOffset.m7117getXimpl(getPosition());
        bounds.setLeft(bounds.getLeft() - m7117getXimpl);
        bounds.setRight(bounds.getRight() - m7117getXimpl);
        float m7118getYimpl = IntOffset.m7118getYimpl(getPosition());
        bounds.setTop(bounds.getTop() - m7118getYimpl);
        bounds.setBottom(bounds.getBottom() - m7118getYimpl);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(bounds, true);
            if (this.isClipping && clipBounds) {
                bounds.intersect(0.0f, 0.0f, (int) (mo5740getSizeYbymL2g() >> 32), (int) (mo5740getSizeYbymL2g() & 4294967295L));
                bounds.isEmpty();
            }
        }
    }

    /* renamed from: withinLayerBounds-k-4lQ0M */
    public final boolean m5988withinLayerBoundsk4lQ0M(long pointerPosition) {
        if ((((androidx.compose.ui.geometry.InlineClassHelperKt.DualFloatInfinityBase ^ (pointerPosition & androidx.compose.ui.geometry.InlineClassHelperKt.DualFloatInfinityBase)) - androidx.compose.ui.geometry.InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) != 0) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer == null || !this.isClipping || ownedLayer.mo6047isInLayerk4lQ0M(pointerPosition);
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator r5) {
        LayoutNode layoutNode = r5.getLayoutNode();
        LayoutNode layoutNode2 = getLayoutNode();
        if (layoutNode == layoutNode2) {
            Modifier.Node tail = r5.getTail();
            Modifier.Node tail2 = getTail();
            int m5994constructorimpl = NodeKind.m5994constructorimpl(2);
            if (!tail2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
            }
            for (Modifier.Node parent = tail2.getNode().getParent(); parent != null; parent = parent.getParent()) {
                if ((parent.getKindSet() & m5994constructorimpl) != 0 && parent == tail) {
                    return r5;
                }
            }
            return this;
        }
        while (layoutNode.getDepth() > layoutNode2.getDepth()) {
            layoutNode = layoutNode.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode);
        }
        while (layoutNode2.getDepth() > layoutNode.getDepth()) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode2);
        }
        while (layoutNode != layoutNode2) {
            layoutNode = layoutNode.getParent$ui_release();
            layoutNode2 = layoutNode2.getParent$ui_release();
            if (layoutNode == null || layoutNode2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        if (layoutNode2 != getLayoutNode()) {
            if (layoutNode != r5.getLayoutNode()) {
                return layoutNode.getInnerCoordinator$ui_release();
            }
            return r5;
        }
        return this;
    }

    /* renamed from: distanceInMinimumTouchTarget-tz77jQw */
    public final float m5976distanceInMinimumTouchTargettz77jQw(long pointerPosition, long minimumTouchTargetSize) {
        if (getMeasuredWidth() >= Float.intBitsToFloat((int) (minimumTouchTargetSize >> 32)) && getMeasuredHeight() >= Float.intBitsToFloat((int) (minimumTouchTargetSize & 4294967295L))) {
            return Float.POSITIVE_INFINITY;
        }
        long m5975calculateMinimumTouchTargetPaddingE7KxVPU = m5975calculateMinimumTouchTargetPaddingE7KxVPU(minimumTouchTargetSize);
        float intBitsToFloat = Float.intBitsToFloat((int) (m5975calculateMinimumTouchTargetPaddingE7KxVPU >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (m5975calculateMinimumTouchTargetPaddingE7KxVPU & 4294967295L));
        long m5968offsetFromEdgeMKHz9U = m5968offsetFromEdgeMKHz9U(pointerPosition);
        if ((intBitsToFloat > 0.0f || intBitsToFloat2 > 0.0f) && Float.intBitsToFloat((int) (m5968offsetFromEdgeMKHz9U >> 32)) <= intBitsToFloat && Float.intBitsToFloat((int) (m5968offsetFromEdgeMKHz9U & 4294967295L)) <= intBitsToFloat2) {
            return Offset.m4124getDistanceSquaredimpl(m5968offsetFromEdgeMKHz9U);
        }
        return Float.POSITIVE_INFINITY;
    }

    /* compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", "()V", "ExpectAttachedLayoutCoordinates", "", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "getSemanticsSource", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "", "onCommitAffectingLayerParams", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HitTestSource getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Object] */
    public final void onMeasured() {
        Modifier.Node parent;
        if (m5964hasNodeH91voCI(NodeKind.m5994constructorimpl(128))) {
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                int m5994constructorimpl = NodeKind.m5994constructorimpl(128);
                boolean m6003getIncludeSelfInTraversalH91voCI = NodeKindKt.m6003getIncludeSelfInTraversalH91voCI(m5994constructorimpl);
                if (m6003getIncludeSelfInTraversalH91voCI) {
                    parent = getTail();
                } else {
                    parent = getTail().getParent();
                    if (parent == null) {
                        Unit unit = Unit.INSTANCE;
                    }
                }
                for (Modifier.Node headNode = headNode(m6003getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet() & m5994constructorimpl) != 0; headNode = headNode.getChild()) {
                    if ((headNode.getKindSet() & m5994constructorimpl) != 0) {
                        MutableVector mutableVector = null;
                        DelegatingNode delegatingNode = headNode;
                        while (delegatingNode != 0) {
                            if (delegatingNode instanceof LayoutAwareModifierNode) {
                                ((LayoutAwareModifierNode) delegatingNode).mo688onRemeasuredozmzZPI(getMeasuredSize());
                            } else if ((delegatingNode.getKindSet() & m5994constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                                Modifier.Node delegate = delegatingNode.getDelegate();
                                int i = 0;
                                delegatingNode = delegatingNode;
                                while (delegate != null) {
                                    if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            delegatingNode = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNode != 0) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegatingNode);
                                                }
                                                delegatingNode = 0;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    delegatingNode = delegatingNode;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNode = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if (headNode == parent) {
                        break;
                    }
                }
                Unit unit2 = Unit.INSTANCE;
            } finally {
                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final void onUnplaced() {
        if (m5964hasNodeH91voCI(NodeKind.m5994constructorimpl(1048576))) {
            int m5994constructorimpl = NodeKind.m5994constructorimpl(1048576);
            boolean m6003getIncludeSelfInTraversalH91voCI = NodeKindKt.m6003getIncludeSelfInTraversalH91voCI(m5994constructorimpl);
            Modifier.Node tail = getTail();
            if (!m6003getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
                return;
            }
            for (Modifier.Node headNode = headNode(m6003getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet() & m5994constructorimpl) != 0; headNode = headNode.getChild()) {
                if ((headNode.getKindSet() & m5994constructorimpl) != 0) {
                    DelegatingNode delegatingNode = headNode;
                    MutableVector mutableVector = null;
                    while (delegatingNode != 0) {
                        if (delegatingNode instanceof OnUnplacedModifierNode) {
                            ((OnUnplacedModifierNode) delegatingNode).onUnplaced();
                        } else if ((delegatingNode.getKindSet() & m5994constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                            Modifier.Node delegate = delegatingNode.getDelegate();
                            int i = 0;
                            delegatingNode = delegatingNode;
                            while (delegate != null) {
                                if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        delegatingNode = delegate;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (delegatingNode != 0) {
                                            if (mutableVector != null) {
                                                mutableVector.add(delegatingNode);
                                            }
                                            delegatingNode = 0;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate);
                                        }
                                    }
                                }
                                delegate = delegate.getChild();
                                delegatingNode = delegatingNode;
                            }
                            if (i == 1) {
                            }
                        }
                        delegatingNode = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if (headNode == tail) {
                    return;
                }
            }
        }
    }

    public final void drawContainedDrawModifiers(Canvas canvas, GraphicsLayer graphicsLayer) {
        Modifier.Node m5980headH91voCI = m5980headH91voCI(NodeKind.m5994constructorimpl(4));
        if (m5980headH91voCI == null) {
            performDraw(canvas, graphicsLayer);
        } else {
            getLayoutNode().getMDrawScope$ui_release().m5922draweZhPAX0$ui_release(canvas, IntSizeKt.m7172toSizeozmzZPI(mo5740getSizeYbymL2g()), this, m5980headH91voCI, graphicsLayer);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final void onPlaced() {
        int m5994constructorimpl = NodeKind.m5994constructorimpl(128);
        boolean m6003getIncludeSelfInTraversalH91voCI = NodeKindKt.m6003getIncludeSelfInTraversalH91voCI(m5994constructorimpl);
        Modifier.Node tail = getTail();
        if (!m6003getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return;
        }
        for (Modifier.Node headNode = headNode(m6003getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet() & m5994constructorimpl) != 0; headNode = headNode.getChild()) {
            if ((headNode.getKindSet() & m5994constructorimpl) != 0) {
                DelegatingNode delegatingNode = headNode;
                MutableVector mutableVector = null;
                while (delegatingNode != 0) {
                    if (delegatingNode instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) delegatingNode).onPlaced(this);
                    } else if ((delegatingNode.getKindSet() & m5994constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                        Modifier.Node delegate = delegatingNode.getDelegate();
                        int i = 0;
                        delegatingNode = delegatingNode;
                        while (delegate != null) {
                            if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                                i++;
                                if (i == 1) {
                                    delegatingNode = delegate;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (delegatingNode != 0) {
                                        if (mutableVector != null) {
                                            mutableVector.add(delegatingNode);
                                        }
                                        delegatingNode = 0;
                                    }
                                    if (mutableVector != null) {
                                        mutableVector.add(delegate);
                                    }
                                }
                            }
                            delegate = delegate.getChild();
                            delegatingNode = delegatingNode;
                        }
                        if (i == 1) {
                        }
                    }
                    delegatingNode = DelegatableNodeKt.pop(mutableVector);
                }
            }
            if (headNode == tail) {
                return;
            }
        }
    }

    /* renamed from: isPointerInBounds-k-4lQ0M */
    protected final boolean m5982isPointerInBoundsk4lQ0M(long pointerPosition) {
        float intBitsToFloat = Float.intBitsToFloat((int) (pointerPosition >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (pointerPosition & 4294967295L));
        return intBitsToFloat >= 0.0f && intBitsToFloat2 >= 0.0f && intBitsToFloat < ((float) getMeasuredWidth()) && intBitsToFloat2 < ((float) getMeasuredHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final boolean shouldSharePointerInputWithSiblings() {
        Modifier.Node headNode = headNode(NodeKindKt.m6003getIncludeSelfInTraversalH91voCI(NodeKind.m5994constructorimpl(16)));
        if (headNode != null && headNode.getIsAttached()) {
            Modifier.Node node = headNode;
            int m5994constructorimpl = NodeKind.m5994constructorimpl(16);
            if (!node.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
            }
            Modifier.Node node2 = node.getNode();
            if ((node2.getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                while (node2 != null) {
                    if ((node2.getKindSet() & m5994constructorimpl) != 0) {
                        DelegatingNode delegatingNode = node2;
                        MutableVector mutableVector = null;
                        while (delegatingNode != 0) {
                            if (delegatingNode instanceof PointerInputModifierNode) {
                                if (((PointerInputModifierNode) delegatingNode).sharePointerInputWithSiblings()) {
                                    return true;
                                }
                            } else if ((delegatingNode.getKindSet() & m5994constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                                Modifier.Node delegate = delegatingNode.getDelegate();
                                int i = 0;
                                delegatingNode = delegatingNode;
                                while (delegate != null) {
                                    if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            delegatingNode = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNode != 0) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegatingNode);
                                                }
                                                delegatingNode = 0;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    delegatingNode = delegatingNode;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNode = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    node2 = node2.getChild();
                }
            }
        }
        return false;
    }

    /* renamed from: offsetFromEdge-MK-Hz9U */
    private final long m5968offsetFromEdgeMKHz9U(long pointerPosition) {
        float intBitsToFloat = Float.intBitsToFloat((int) (pointerPosition >> 32));
        float max = Math.max(0.0f, intBitsToFloat < 0.0f ? -intBitsToFloat : intBitsToFloat - getMeasuredWidth());
        return Offset.m4117constructorimpl((Float.floatToRawIntBits(max) << 32) | (Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (pointerPosition & 4294967295L)) < 0.0f ? -r6 : r6 - getMeasuredHeight())) & 4294967295L));
    }

    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU */
    protected final long m5975calculateMinimumTouchTargetPaddingE7KxVPU(long minimumTouchTargetSize) {
        float intBitsToFloat = Float.intBitsToFloat((int) (minimumTouchTargetSize >> 32)) - getMeasuredWidth();
        float intBitsToFloat2 = Float.intBitsToFloat((int) (minimumTouchTargetSize & 4294967295L)) - getMeasuredHeight();
        float max = Math.max(0.0f, intBitsToFloat / 2.0f);
        float max2 = Math.max(0.0f, intBitsToFloat2 / 2.0f);
        return Size.m4185constructorimpl((Float.floatToRawIntBits(max) << 32) | (Float.floatToRawIntBits(max2) & 4294967295L));
    }
}
