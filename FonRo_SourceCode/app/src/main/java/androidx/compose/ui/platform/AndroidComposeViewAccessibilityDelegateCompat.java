package androidx.compose.ui.platform;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.ArraySet;
import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.R;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AccessibilityIterators;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.accessibility.CollectionInfo_androidKt;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesAndroid;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.text.platform.URLSpanCache;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
@Metadata(d1 = {"\u0000Î\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 å\u00012\u00020\u0001:\nã\u0001ä\u0001å\u0001æ\u0001ç\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010r\u001a\u00020\"2\u0006\u0010s\u001a\u00020\u00122\u0006\u0010t\u001a\u00020+2\u0006\u0010u\u001a\u00020\u00062\b\u0010v\u001a\u0004\u0018\u00010wH\u0002J\u0010\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020&H\u0002J\u0010\u0010{\u001a\u00020\"H\u0080@¢\u0006\u0004\b|\u0010}J=\u0010~\u001a\u00020\u00152\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010\u007f\u001a\u00020\u00152\u0007\u0010\u0080\u0001\u001a\u00020\u00122\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J/\u0010~\u001a\u00020\u00152\u0006\u0010\u007f\u001a\u00020\u00152\u0007\u0010\u0080\u0001\u001a\u00020\u00122\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\t\u0010\u0087\u0001\u001a\u00020\"H\u0002J\u0011\u0010\u0088\u0001\u001a\u00020\u00152\u0006\u0010s\u001a\u00020\u0012H\u0002J\u001a\u0010\u0089\u0001\u001a\u00020P2\u0006\u0010s\u001a\u00020\u00122\u0007\u0010\u008a\u0001\u001a\u00020\u0012H\u0003J\u0013\u0010\u008b\u0001\u001a\u0004\u0018\u00010+2\u0006\u0010s\u001a\u00020\u0012H\u0002JC\u0010\u008c\u0001\u001a\u00020P2\u0006\u0010s\u001a\u00020\u00122\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0003\u0010\u0091\u0001J\u0019\u0010\u0092\u0001\u001a\u00020\u00152\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0000¢\u0006\u0003\b\u0095\u0001J\u0014\u0010\u0096\u0001\u001a\u00030\u0097\u00012\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020\u00122\u0007\u0010z\u001a\u00030\u009b\u0001H\u0002J\u0012\u0010\u009c\u0001\u001a\u00020\u00122\u0007\u0010z\u001a\u00030\u009b\u0001H\u0002J\u0016\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010z\u001a\u0005\u0018\u00010\u009b\u0001H\u0002J \u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u00012\t\u0010z\u001a\u0005\u0018\u00010\u009b\u00012\u0007\u0010 \u0001\u001a\u00020\u0012H\u0002J#\u0010¡\u0001\u001a\u00020\u00122\b\u0010¢\u0001\u001a\u00030£\u00012\b\u0010¤\u0001\u001a\u00030£\u0001H\u0001¢\u0006\u0003\b¥\u0001J\u0011\u0010¦\u0001\u001a\u00020\u00152\u0006\u0010s\u001a\u00020\u0012H\u0002J\u0012\u0010§\u0001\u001a\u00020\u00152\u0007\u0010z\u001a\u00030\u009b\u0001H\u0002J\u0012\u0010¨\u0001\u001a\u00020\"2\u0007\u0010©\u0001\u001a\u00020kH\u0002J\u0018\u0010ª\u0001\u001a\u00020\"2\u0007\u0010©\u0001\u001a\u00020kH\u0000¢\u0006\u0003\b«\u0001J\u000f\u0010¬\u0001\u001a\u00020\"H\u0000¢\u0006\u0003\b\u00ad\u0001J$\u0010®\u0001\u001a\u00020\u00152\u0006\u0010s\u001a\u00020\u00122\u0007\u0010¯\u0001\u001a\u00020\u00122\b\u0010v\u001a\u0004\u0018\u00010wH\u0002J#\u0010°\u0001\u001a\u00020\"2\u0006\u0010s\u001a\u00020\u00122\u0006\u0010t\u001a\u00020+2\b\u0010±\u0001\u001a\u00030\u009b\u0001H\u0002J!\u0010²\u0001\u001a\u00020\u00152\u0007\u0010³\u0001\u001a\u00020\u00122\r\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020d01H\u0002J\u0011\u0010µ\u0001\u001a\u00020\u00152\u0006\u0010s\u001a\u00020\u0012H\u0002J\u0012\u0010¶\u0001\u001a\u00020\"2\u0007\u0010·\u0001\u001a\u00020dH\u0002J\u0012\u0010¸\u0001\u001a\u00020\u00122\u0007\u0010³\u0001\u001a\u00020\u0012H\u0002J\u001c\u0010¹\u0001\u001a\u00020\"2\b\u0010º\u0001\u001a\u00030\u009b\u00012\u0007\u0010»\u0001\u001a\u00020_H\u0002J\u0012\u0010¼\u0001\u001a\u00020\u00152\u0007\u0010\u0093\u0001\u001a\u00020PH\u0002J@\u0010½\u0001\u001a\u00020\u00152\u0006\u0010s\u001a\u00020\u00122\u0007\u0010\u008a\u0001\u001a\u00020\u00122\u000b\b\u0002\u0010¾\u0001\u001a\u0004\u0018\u00010\u00122\u0011\b\u0002\u0010¿\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u000101H\u0002¢\u0006\u0003\u0010À\u0001J&\u0010Á\u0001\u001a\u00020\"2\u0007\u0010Â\u0001\u001a\u00020\u00122\u0007\u0010¾\u0001\u001a\u00020\u00122\t\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010Ä\u0001\u001a\u00020\"2\u0007\u0010Â\u0001\u001a\u00020\u0012H\u0002J\u0018\u0010Å\u0001\u001a\u00020\"2\r\u0010Æ\u0001\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002J\u001b\u0010Ç\u0001\u001a\u00020\"2\u0007\u0010©\u0001\u001a\u00020k2\u0007\u0010È\u0001\u001a\u00020WH\u0002J\u0012\u0010É\u0001\u001a\u00020\"2\u0007\u0010©\u0001\u001a\u00020kH\u0002J-\u0010Ê\u0001\u001a\u00020\u00152\u0007\u0010z\u001a\u00030\u009b\u00012\u0007\u0010Ë\u0001\u001a\u00020\u00122\u0007\u0010Ì\u0001\u001a\u00020\u00122\u0007\u0010Í\u0001\u001a\u00020\u0015H\u0002J\u001a\u0010Î\u0001\u001a\u00020\"2\u0007\u0010z\u001a\u00030\u009b\u00012\u0006\u0010t\u001a\u00020+H\u0002J\u001a\u0010Ï\u0001\u001a\u00020\"2\u0007\u0010z\u001a\u00030\u009b\u00012\u0006\u0010t\u001a\u00020+H\u0002J\"\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u00012\n\u0010Ò\u0001\u001a\u0005\u0018\u00010\u009b\u00012\b\u0010Ó\u0001\u001a\u00030Ô\u0001H\u0002J-\u0010Õ\u0001\u001a\u00020\u00152\u0007\u0010z\u001a\u00030\u009b\u00012\u0007\u0010 \u0001\u001a\u00020\u00122\u0007\u0010Ö\u0001\u001a\u00020\u00152\u0007\u0010×\u0001\u001a\u00020\u0015H\u0002J4\u0010Ø\u0001\u001a\u0005\u0018\u0001HÙ\u0001\"\t\b\u0000\u0010Ù\u0001*\u00020\u001f2\n\u0010\u0090\u0001\u001a\u0005\u0018\u0001HÙ\u00012\t\b\u0001\u0010Ú\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0003\u0010Û\u0001J\u0011\u0010Ü\u0001\u001a\u00020\"2\u0006\u0010s\u001a\u00020\u0012H\u0002J\t\u0010Ý\u0001\u001a\u00020\"H\u0002J\u0011\u0010Þ\u0001\u001a\u0005\u0018\u00010ß\u0001*\u00030à\u0001H\u0002J\u0011\u0010á\u0001\u001a\u0005\u0018\u00010â\u0001*\u00030ß\u0001H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010-\u001a&\u0012\f\u0012\n 0*\u0004\u0018\u00010/0/ 0*\u0012\u0012\f\u0012\n 0*\u0004\u0018\u00010/0/\u0018\u0001010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R$\u00107\u001a\u00020\u00128\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020?X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020?X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR\u0014\u0010G\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u0018R\u0014\u0010I\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u0018R\u001a\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0K0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010L\u001a\u00060MR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010N\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00150O8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bQ\u00109\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u000e\u0010V\u001a\u00020WX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010X\u001a\b\u0012\u0004\u0012\u00020Z0YX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010]\u001a\b\u0012\u0004\u0012\u00020Z0YX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010^\u001a\b\u0012\u0004\u0012\u00020_0YX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010a\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010bR\u001a\u0010c\u001a\u000e\u0012\u0004\u0012\u00020d\u0012\u0004\u0012\u00020\"0OX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010e\u001a\b\u0012\u0004\u0012\u00020d0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020gX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010i\u001a\b\u0012\u0004\u0012\u00020k0jX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020mX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020oX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bp\u0010q\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006è\u0001"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "ExtraDataTestTraversalAfterVal", "", "getExtraDataTestTraversalAfterVal$ui_release", "()Ljava/lang/String;", "ExtraDataTestTraversalBeforeVal", "getExtraDataTestTraversalBeforeVal$ui_release", "SendRecurringAccessibilityEventsIntervalMillis", "", "getSendRecurringAccessibilityEventsIntervalMillis$ui_release", "()J", "setSendRecurringAccessibilityEventsIntervalMillis$ui_release", "(J)V", "accessibilityCursorPosition", "", "accessibilityFocusedVirtualViewId", "value", "", "accessibilityForceEnabledForTesting", "getAccessibilityForceEnabledForTesting$ui_release", "()Z", "setAccessibilityForceEnabledForTesting$ui_release", "(Z)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "checkingForSemanticsChanges", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes", "()Landroidx/collection/IntObjectMap;", "currentSemanticsNodesInvalidated", "currentlyAccessibilityFocusedANI", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "currentlyFocusedANI", "enabledServices", "", "Landroid/accessibilityservice/AccessibilityServiceInfo;", "kotlin.jvm.PlatformType", "", "enabledStateListener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "focusedVirtualViewId", "handler", "Landroid/os/Handler;", "hoveredVirtualViewId", "getHoveredVirtualViewId$ui_release$annotations", "()V", "getHoveredVirtualViewId$ui_release", "()I", "setHoveredVirtualViewId$ui_release", "(I)V", "idToAfterMap", "Landroidx/collection/MutableIntIntMap;", "getIdToAfterMap$ui_release", "()Landroidx/collection/MutableIntIntMap;", "setIdToAfterMap$ui_release", "(Landroidx/collection/MutableIntIntMap;)V", "idToBeforeMap", "getIdToBeforeMap$ui_release", "setIdToBeforeMap$ui_release", "isEnabled", "isEnabled$ui_release", "isTouchExplorationEnabled", "labelToActionId", "Landroidx/collection/MutableObjectIntMap;", "nodeProvider", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "onSendAccessibilityEvent", "Lkotlin/Function1;", "Landroid/view/accessibility/AccessibilityEvent;", "getOnSendAccessibilityEvent$ui_release$annotations", "getOnSendAccessibilityEvent$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnSendAccessibilityEvent$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "paneDisplayed", "Landroidx/collection/MutableIntSet;", "pendingHorizontalScrollEvents", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "pendingVerticalScrollEvents", "previousSemanticsNodes", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "previousSemanticsRoot", "previousTraversedNode", "Ljava/lang/Integer;", "scheduleScrollEventIfNeededLambda", "Landroidx/compose/ui/platform/ScrollObservationScope;", "scrollObservationScopes", "semanticsChangeChecker", "Ljava/lang/Runnable;", "sendingFocusAffectingEvent", "subtreeChangedLayoutNodes", "Landroidx/collection/ArraySet;", "Landroidx/compose/ui/node/LayoutNode;", "touchExplorationStateListener", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "extraDataKey", "arguments", "Landroid/os/Bundle;", "boundsInScreen", "Landroid/graphics/Rect;", "node", "boundsUpdatesEventLoop", "boundsUpdatesEventLoop$ui_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canScroll", "vertical", "direction", "position", "Landroidx/compose/ui/geometry/Offset;", "canScroll-moWRBKg", "(Landroidx/collection/IntObjectMap;ZIJ)Z", "canScroll-0AR0LA0$ui_release", "(ZIJ)Z", "checkForSemanticsChanges", "clearAccessibilityFocus", "createEvent", "eventType", "createNodeInfo", "createTextSelectionChangedEvent", "fromIndex", "toIndex", "itemCount", "text", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;)Landroid/view/accessibility/AccessibilityEvent;", "dispatchHoverEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "dispatchHoverEvent$ui_release", "getAccessibilityNodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "host", "Landroid/view/View;", "getAccessibilitySelectionEnd", "Landroidx/compose/ui/semantics/SemanticsNode;", "getAccessibilitySelectionStart", "getIterableTextForAccessibility", "getIteratorForGranularity", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "granularity", "hitTestSemanticsAt", "x", "", "y", "hitTestSemanticsAt$ui_release", "isAccessibilityFocused", "isAccessibilitySelectionExtendable", "notifySubtreeAccessibilityStateChangedIfNeeded", "layoutNode", "onLayoutChange", "onLayoutChange$ui_release", "onSemanticsChange", "onSemanticsChange$ui_release", "performActionHelper", "action", "populateAccessibilityNodeInfoProperties", "semanticsNode", "registerScrollingId", "id", "oldScrollObservationScopes", "requestAccessibilityFocus", "scheduleScrollEventIfNeeded", "scrollObservationScope", "semanticsNodeIdToAccessibilityVirtualNodeId", "sendAccessibilitySemanticsStructureChangeEvents", "newNode", "oldNode", "sendEvent", "sendEventForVirtualView", "contentChangeType", "contentDescription", "(IILjava/lang/Integer;Ljava/util/List;)Z", "sendPaneChangeEvents", "semanticsNodeId", "title", "sendPendingTextTraversedAtGranularityEvent", "sendSemanticsPropertyChangeEvents", "newSemanticsNodes", "sendSubtreeChangeAccessibilityEvents", "subtreeChangedSemanticsNodesIds", "sendTypeViewScrolledAccessibilityEvent", "setAccessibilitySelection", "start", "end", "traversalMode", "setContentInvalid", "setText", "toScreenCoords", "Landroid/graphics/RectF;", "textNode", "bounds", "Landroidx/compose/ui/geometry/Rect;", "traverseAtGranularity", "forward", "extendSelection", "trimToSize", ExifInterface.GPS_DIRECTION_TRUE, "size", "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "updateHoveredVirtualView", "updateSemanticsNodesCopyAndPanes", "getTextForTextField", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "toSpannableString", "Landroid/text/SpannableString;", "Api24Impl", "Api29Impl", "Companion", "ComposeAccessibilityNodeProvider", "PendingTextTraversedEvent", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;
    public static final String ClassName = "android.view.View";
    public static final String ExtraDataIdKey = "androidx.compose.ui.semantics.id";
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    public static final int InvalidId = Integer.MIN_VALUE;
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    public static final String TextClassName = "android.widget.TextView";
    public static final String TextFieldClassName = "android.widget.EditText";
    public static final long TextTraversedEventTimeoutMillis = 1000;
    private final String ExtraDataTestTraversalAfterVal;
    private final String ExtraDataTestTraversalBeforeVal;
    private long SendRecurringAccessibilityEventsIntervalMillis;
    private int accessibilityCursorPosition;
    private int accessibilityFocusedVirtualViewId;
    private boolean accessibilityForceEnabledForTesting;
    private final android.view.accessibility.AccessibilityManager accessibilityManager;
    private SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;
    private final Channel<Unit> boundsUpdateChannel;
    private boolean checkingForSemanticsChanges;
    private IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private AccessibilityNodeInfoCompat currentlyAccessibilityFocusedANI;
    private AccessibilityNodeInfoCompat currentlyFocusedANI;
    private List<AccessibilityServiceInfo> enabledServices;
    private final AccessibilityManager.AccessibilityStateChangeListener enabledStateListener;
    private int focusedVirtualViewId;
    private final Handler handler;
    private MutableIntIntMap idToAfterMap;
    private MutableIntIntMap idToBeforeMap;
    private SparseArrayCompat<MutableObjectIntMap<CharSequence>> labelToActionId;
    private ComposeAccessibilityNodeProvider nodeProvider;
    private MutableIntSet paneDisplayed;
    private final MutableIntObjectMap<ScrollAxisRange> pendingHorizontalScrollEvents;
    private PendingTextTraversedEvent pendingTextTraversedEvent;
    private final MutableIntObjectMap<ScrollAxisRange> pendingVerticalScrollEvents;
    private MutableIntObjectMap<SemanticsNodeCopy> previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private Integer previousTraversedNode;
    private final Function1<ScrollObservationScope, Unit> scheduleScrollEventIfNeededLambda;
    private final List<ScrollObservationScope> scrollObservationScopes;
    private final Runnable semanticsChangeChecker;
    private boolean sendingFocusAffectingEvent;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateListener;
    private final URLSpanCache urlSpanCache;
    private final AndroidComposeView view;
    public static final int $stable = 8;
    private static final IntList AccessibilityActionsResourceIds = IntListKt.intListOf(R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31);
    private int hoveredVirtualViewId = Integer.MIN_VALUE;
    private Function1<? super AccessibilityEvent, Boolean> onSendAccessibilityEvent = new Function1<AccessibilityEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(AccessibilityEvent accessibilityEvent) {
            return Boolean.valueOf(AndroidComposeViewAccessibilityDelegateCompat.this.getView().getParent().requestSendAccessibilityEvent(AndroidComposeViewAccessibilityDelegateCompat.this.getView(), accessibilityEvent));
        }
    };

    public static /* synthetic */ void getHoveredVirtualViewId$ui_release$annotations() {
    }

    public static /* synthetic */ void getOnSendAccessibilityEvent$ui_release$annotations() {
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView androidComposeView) {
        this.view = androidComposeView;
        Object systemService = androidComposeView.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        android.view.accessibility.AccessibilityManager accessibilityManager = (android.view.accessibility.AccessibilityManager) systemService;
        this.accessibilityManager = accessibilityManager;
        this.SendRecurringAccessibilityEventsIntervalMillis = 100L;
        this.enabledStateListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public final void onAccessibilityStateChanged(boolean z) {
                AndroidComposeViewAccessibilityDelegateCompat.enabledStateListener$lambda$0(AndroidComposeViewAccessibilityDelegateCompat.this, z);
            }
        };
        this.touchExplorationStateListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                AndroidComposeViewAccessibilityDelegateCompat.this.enabledServices = r0.accessibilityManager.getEnabledAccessibilityServiceList(-1);
            }
        };
        this.enabledServices = accessibilityManager.getEnabledAccessibilityServiceList(-1);
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new ComposeAccessibilityNodeProvider();
        this.accessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.pendingHorizontalScrollEvents = new MutableIntObjectMap<>(0, 1, null);
        this.pendingVerticalScrollEvents = new MutableIntObjectMap<>(0, 1, null);
        this.actionIdToLabel = new SparseArrayCompat<>(0, 1, null);
        this.labelToActionId = new SparseArrayCompat<>(0, 1, null);
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>(0, 1, null);
        this.boundsUpdateChannel = ChannelKt.Channel$default(1, null, null, 6, null);
        this.currentSemanticsNodesInvalidated = true;
        this.currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();
        this.paneDisplayed = new MutableIntSet(0, 1, null);
        this.idToBeforeMap = new MutableIntIntMap(0, 1, null);
        this.idToAfterMap = new MutableIntIntMap(0, 1, null);
        this.ExtraDataTestTraversalBeforeVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.ExtraDataTestTraversalAfterVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.urlSpanCache = new URLSpanCache();
        this.previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();
        this.previousSemanticsRoot = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
        androidComposeView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                android.view.accessibility.AccessibilityManager accessibilityManager2 = AndroidComposeViewAccessibilityDelegateCompat.this.accessibilityManager;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
                accessibilityManager2.addAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.enabledStateListener);
                accessibilityManager2.addTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                AndroidComposeViewAccessibilityDelegateCompat.this.handler.removeCallbacks(AndroidComposeViewAccessibilityDelegateCompat.this.semanticsChangeChecker);
                android.view.accessibility.AccessibilityManager accessibilityManager2 = AndroidComposeViewAccessibilityDelegateCompat.this.accessibilityManager;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
                accessibilityManager2.removeAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.enabledStateListener);
                accessibilityManager2.removeTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
            }
        });
        this.semanticsChangeChecker = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeViewAccessibilityDelegateCompat.semanticsChangeChecker$lambda$37(AndroidComposeViewAccessibilityDelegateCompat.this);
            }
        };
        this.scrollObservationScopes = new ArrayList();
        this.scheduleScrollEventIfNeededLambda = new Function1<ScrollObservationScope, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeededLambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScrollObservationScope scrollObservationScope) {
                invoke2(scrollObservationScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ScrollObservationScope scrollObservationScope) {
                AndroidComposeViewAccessibilityDelegateCompat.this.scheduleScrollEventIfNeeded(scrollObservationScope);
            }
        };
    }

    /* renamed from: getHoveredVirtualViewId$ui_release, reason: from getter */
    public final int getHoveredVirtualViewId() {
        return this.hoveredVirtualViewId;
    }

    public final void setHoveredVirtualViewId$ui_release(int i) {
        this.hoveredVirtualViewId = i;
    }

    public final Function1<AccessibilityEvent, Boolean> getOnSendAccessibilityEvent$ui_release() {
        return this.onSendAccessibilityEvent;
    }

    public final void setOnSendAccessibilityEvent$ui_release(Function1<? super AccessibilityEvent, Boolean> function1) {
        this.onSendAccessibilityEvent = function1;
    }

    /* renamed from: getAccessibilityForceEnabledForTesting$ui_release, reason: from getter */
    public final boolean getAccessibilityForceEnabledForTesting() {
        return this.accessibilityForceEnabledForTesting;
    }

    public final void setAccessibilityForceEnabledForTesting$ui_release(boolean z) {
        this.accessibilityForceEnabledForTesting = z;
        this.currentSemanticsNodesInvalidated = true;
    }

    /* renamed from: getSendRecurringAccessibilityEventsIntervalMillis$ui_release, reason: from getter */
    public final long getSendRecurringAccessibilityEventsIntervalMillis() {
        return this.SendRecurringAccessibilityEventsIntervalMillis;
    }

    public final void setSendRecurringAccessibilityEventsIntervalMillis$ui_release(long j) {
        this.SendRecurringAccessibilityEventsIntervalMillis = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void enabledStateListener$lambda$0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z) {
        List<AccessibilityServiceInfo> emptyList;
        if (z) {
            emptyList = androidComposeViewAccessibilityDelegateCompat.accessibilityManager.getEnabledAccessibilityServiceList(-1);
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        androidComposeViewAccessibilityDelegateCompat.enabledServices = emptyList;
    }

    public final boolean isEnabled$ui_release() {
        if (this.accessibilityForceEnabledForTesting) {
            return true;
        }
        return this.accessibilityManager.isEnabled() && !this.enabledServices.isEmpty();
    }

    private final boolean isTouchExplorationEnabled() {
        if (this.accessibilityForceEnabledForTesting) {
            return true;
        }
        return this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "action", "", "granularity", "fromIndex", "toIndex", "traverseTime", "", "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getAction", "()I", "getFromIndex", "getGranularity", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getToIndex", "getTraverseTime", "()J", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode semanticsNode, int i, int i2, int i3, int i4, long j) {
            this.node = semanticsNode;
            this.action = i;
            this.granularity = i2;
            this.fromIndex = i3;
            this.toIndex = i4;
            this.traverseTime = j;
        }

        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IntObjectMap<SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = SemanticsUtils_androidKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner());
            if (isEnabled$ui_release()) {
                AndroidComposeViewAccessibilityDelegateCompat_androidKt.setTraversalValues(this.currentSemanticsNodes, this.idToBeforeMap, this.idToAfterMap, this.view.getContext().getResources());
            }
        }
        return this.currentSemanticsNodes;
    }

    /* renamed from: getIdToBeforeMap$ui_release, reason: from getter */
    public final MutableIntIntMap getIdToBeforeMap() {
        return this.idToBeforeMap;
    }

    public final void setIdToBeforeMap$ui_release(MutableIntIntMap mutableIntIntMap) {
        this.idToBeforeMap = mutableIntIntMap;
    }

    /* renamed from: getIdToAfterMap$ui_release, reason: from getter */
    public final MutableIntIntMap getIdToAfterMap() {
        return this.idToAfterMap;
    }

    public final void setIdToAfterMap$ui_release(MutableIntIntMap mutableIntIntMap) {
        this.idToAfterMap = mutableIntIntMap;
    }

    /* renamed from: getExtraDataTestTraversalBeforeVal$ui_release, reason: from getter */
    public final String getExtraDataTestTraversalBeforeVal() {
        return this.ExtraDataTestTraversalBeforeVal;
    }

    /* renamed from: getExtraDataTestTraversalAfterVal$ui_release, reason: from getter */
    public final String getExtraDataTestTraversalAfterVal() {
        return this.ExtraDataTestTraversalAfterVal;
    }

    /* renamed from: canScroll-0AR0LA0$ui_release, reason: not valid java name */
    public final boolean m6111canScroll0AR0LA0$ui_release(boolean vertical, int direction, long position) {
        if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            return m6110canScrollmoWRBKg(getCurrentSemanticsNodes(), vertical, direction, position);
        }
        return false;
    }

    /* renamed from: canScroll-moWRBKg, reason: not valid java name */
    private final boolean m6110canScrollmoWRBKg(IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes, boolean vertical, int direction, long position) {
        SemanticsPropertyKey<ScrollAxisRange> horizontalScrollAxisRange;
        ScrollAxisRange scrollAxisRange;
        if (Offset.m4122equalsimpl0(position, Offset.INSTANCE.m4140getUnspecifiedF1C5BW0()) || (((9223372034707292159L & position) + InlineClassHelperKt.DualLoadedSignificand) & (-9223372034707292160L)) != 0) {
            return false;
        }
        if (vertical) {
            horizontalScrollAxisRange = SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
        } else if (!vertical) {
            horizontalScrollAxisRange = SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Object[] objArr = currentSemanticsNodes.values;
        long[] jArr = currentSemanticsNodes.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i = 0;
        boolean z = false;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((j & 255) < 128) {
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) objArr[(i << 3) + i3];
                        if (RectHelper_androidKt.toComposeRect(semanticsNodeWithAdjustedBounds.getAdjustedBounds()).m4151containsk4lQ0M(position) && (scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNodeWithAdjustedBounds.getSemanticsNode().getUnmergedConfig(), horizontalScrollAxisRange)) != null) {
                            int i4 = scrollAxisRange.getReverseScrolling() ? -direction : direction;
                            if (direction == 0 && scrollAxisRange.getReverseScrolling()) {
                                i4 = -1;
                            }
                            if (i4 < 0) {
                                if (scrollAxisRange.getValue().invoke().floatValue() <= 0.0f) {
                                    j >>= 8;
                                }
                                z = true;
                                j >>= 8;
                            } else {
                                if (scrollAxisRange.getValue().invoke().floatValue() >= scrollAxisRange.getMaxValue().invoke().floatValue()) {
                                    j >>= 8;
                                }
                                z = true;
                                j >>= 8;
                            }
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return z;
                }
            }
            if (i == length) {
                return z;
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final AccessibilityNodeInfoCompat createNodeInfo(int virtualViewId) {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        AndroidComposeView.ViewTreeOwners viewTreeOwners = this.view.getViewTreeOwners();
        if (((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? null : lifecycle.getState()) == Lifecycle.State.DESTROYED) {
            return null;
        }
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId);
        if (semanticsNodeWithAdjustedBounds == null) {
            return null;
        }
        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode();
        if (virtualViewId == -1) {
            ViewParent parentForAccessibility = this.view.getParentForAccessibility();
            obtain.setParent(parentForAccessibility instanceof View ? (View) parentForAccessibility : null);
        } else {
            SemanticsNode parent = semanticsNode.getParent();
            Integer valueOf = parent != null ? Integer.valueOf(parent.getId()) : null;
            if (valueOf == null) {
                androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("semanticsNode " + virtualViewId + " has null parent");
                throw new KotlinNothingValueException();
            }
            int intValue = valueOf.intValue();
            obtain.setParent(this.view, intValue != this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId() ? intValue : -1);
        }
        obtain.setSource(this.view, virtualViewId);
        obtain.setBoundsInScreen(boundsInScreen(semanticsNodeWithAdjustedBounds));
        populateAccessibilityNodeInfoProperties(virtualViewId, obtain, semanticsNode);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect boundsInScreen(SemanticsNodeWithAdjustedBounds node) {
        Rect adjustedBounds = node.getAdjustedBounds();
        AndroidComposeView androidComposeView = this.view;
        float f = adjustedBounds.left;
        float f2 = adjustedBounds.top;
        long mo5687localToScreenMKHz9U = androidComposeView.mo5687localToScreenMKHz9U(Offset.m4117constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32)));
        AndroidComposeView androidComposeView2 = this.view;
        float f3 = adjustedBounds.right;
        float f4 = adjustedBounds.bottom;
        long mo5687localToScreenMKHz9U2 = androidComposeView2.mo5687localToScreenMKHz9U(Offset.m4117constructorimpl((Float.floatToRawIntBits(f3) << 32) | (Float.floatToRawIntBits(f4) & 4294967295L)));
        return new Rect((int) Math.floor(Float.intBitsToFloat((int) (mo5687localToScreenMKHz9U >> 32))), (int) Math.floor(Float.intBitsToFloat((int) (mo5687localToScreenMKHz9U & 4294967295L))), (int) Math.ceil(Float.intBitsToFloat((int) (mo5687localToScreenMKHz9U2 >> 32))), (int) Math.ceil(Float.intBitsToFloat((int) (mo5687localToScreenMKHz9U2 & 4294967295L))));
    }

    private final void populateAccessibilityNodeInfoProperties(int virtualViewId, AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
        String infoStateDescriptionOrNull;
        boolean infoIsCheckable;
        boolean enabled;
        boolean enabled2;
        boolean enabled3;
        boolean isScreenReaderFocusable;
        View semanticsIdToView;
        boolean enabled4;
        boolean enabled5;
        boolean isRtl;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
        boolean isRtl2;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2;
        boolean enabled6;
        boolean excludeLineAndPageGranularities;
        boolean enabled7;
        boolean z;
        boolean enabled8;
        boolean z2;
        Resources resources = this.view.getContext().getResources();
        info.setClassName(ClassName);
        if (semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            info.setClassName(TextFieldClassName);
        }
        if (semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getText())) {
            info.setClassName(TextClassName);
        }
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
        if (role != null) {
            role.getValue();
            if (semanticsNode.getIsFake() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
                if (Role.m6195equalsimpl0(role.getValue(), Role.INSTANCE.m6206getTabo7Vup1c())) {
                    info.setRoleDescription(resources.getString(R.string.tab));
                } else if (Role.m6195equalsimpl0(role.getValue(), Role.INSTANCE.m6205getSwitcho7Vup1c())) {
                    info.setRoleDescription(resources.getString(R.string.switch_role));
                } else {
                    String m6175toLegacyClassNameV4PA4sw = SemanticsUtils_androidKt.m6175toLegacyClassNameV4PA4sw(role.getValue());
                    if (!Role.m6195equalsimpl0(role.getValue(), Role.INSTANCE.m6203getImageo7Vup1c()) || semanticsNode.isUnmergedLeafNode$ui_release() || semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants()) {
                        info.setClassName(m6175toLegacyClassNameV4PA4sw);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        info.setPackageName(this.view.getContext().getPackageName());
        info.setImportantForAccessibility(SemanticsUtils_androidKt.isImportantForAccessibility(semanticsNode));
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i);
            if (getCurrentSemanticsNodes().containsKey(semanticsNode2.getId())) {
                AndroidViewHolder androidViewHolder = this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(semanticsNode2.getLayoutNode());
                if (semanticsNode2.getId() != -1) {
                    if (androidViewHolder != null) {
                        info.addChild(androidViewHolder);
                    } else {
                        info.addChild(this.view, semanticsNode2.getId());
                    }
                }
            }
        }
        if (virtualViewId == this.accessibilityFocusedVirtualViewId) {
            info.setAccessibilityFocused(true);
            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            info.setAccessibilityFocused(false);
            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        }
        setText(semanticsNode, info);
        setContentInvalid(semanticsNode, info);
        infoStateDescriptionOrNull = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoStateDescriptionOrNull(semanticsNode, resources);
        info.setStateDescription(infoStateDescriptionOrNull);
        infoIsCheckable = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoIsCheckable(semanticsNode);
        info.setCheckable(infoIsCheckable);
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getToggleableState());
        if (toggleableState != null) {
            if (toggleableState == ToggleableState.On) {
                info.setChecked(true);
            } else if (toggleableState == ToggleableState.Off) {
                info.setChecked(false);
            }
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (role == null ? false : Role.m6195equalsimpl0(role.getValue(), Role.INSTANCE.m6206getTabo7Vup1c())) {
                info.setSelected(booleanValue);
            } else {
                info.setChecked(booleanValue);
            }
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        if (!semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
            List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getContentDescription());
            info.setContentDescription(list != null ? (String) CollectionsKt.firstOrNull(list) : null);
        }
        String str = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getTestTag());
        if (str != null) {
            SemanticsNode semanticsNode3 = semanticsNode;
            while (true) {
                if (semanticsNode3 == null) {
                    z2 = false;
                    break;
                } else {
                    if (semanticsNode3.getUnmergedConfig().contains(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())) {
                        z2 = ((Boolean) semanticsNode3.getUnmergedConfig().get(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())).booleanValue();
                        break;
                    }
                    semanticsNode3 = semanticsNode3.getParent();
                }
            }
            if (z2) {
                info.setViewIdResourceName(str);
            }
        }
        if (((Unit) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHeading())) != null) {
            info.setHeading(true);
            Unit unit7 = Unit.INSTANCE;
            Unit unit8 = Unit.INSTANCE;
        }
        info.setPassword(semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPassword()));
        info.setEditable(semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getIsEditable()));
        Integer num = (Integer) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getMaxTextLength());
        info.setMaxTextLength(num != null ? num.intValue() : -1);
        enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
        info.setEnabled(enabled);
        info.setFocusable(semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getFocused()));
        if (info.isFocusable()) {
            info.setFocused(((Boolean) semanticsNode.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getFocused())).booleanValue());
            if (info.isFocused()) {
                info.addAction(2);
                this.focusedVirtualViewId = virtualViewId;
            } else {
                info.addAction(1);
            }
        }
        info.setVisibleToUser(!SemanticsUtils_androidKt.isHidden(semanticsNode));
        LiveRegionMode liveRegionMode = (LiveRegionMode) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getLiveRegion());
        if (liveRegionMode != null) {
            int value = liveRegionMode.getValue();
            info.setLiveRegion((LiveRegionMode.m6186equalsimpl0(value, LiveRegionMode.INSTANCE.m6191getPolite0phEisY()) || !LiveRegionMode.m6186equalsimpl0(value, LiveRegionMode.INSTANCE.m6190getAssertive0phEisY())) ? 1 : 2);
            Unit unit9 = Unit.INSTANCE;
            Unit unit10 = Unit.INSTANCE;
        }
        info.setClickable(false);
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnClick());
        if (accessibilityAction != null) {
            boolean areEqual = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected()), (Object) true);
            if (!(role == null ? false : Role.m6195equalsimpl0(role.getValue(), Role.INSTANCE.m6206getTabo7Vup1c()))) {
                if (!(role == null ? false : Role.m6195equalsimpl0(role.getValue(), Role.INSTANCE.m6204getRadioButtono7Vup1c()))) {
                    z = false;
                    info.setClickable(z || (z && !areEqual));
                    enabled8 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
                    if (enabled8 && info.isClickable()) {
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, accessibilityAction.getLabel()));
                    }
                    Unit unit11 = Unit.INSTANCE;
                    Unit unit12 = Unit.INSTANCE;
                }
            }
            z = true;
            info.setClickable(z || (z && !areEqual));
            enabled8 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled8) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, accessibilityAction.getLabel()));
            }
            Unit unit112 = Unit.INSTANCE;
            Unit unit122 = Unit.INSTANCE;
        }
        info.setLongClickable(false);
        AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnLongClick());
        if (accessibilityAction2 != null) {
            info.setLongClickable(true);
            enabled7 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled7) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, accessibilityAction2.getLabel()));
            }
            Unit unit13 = Unit.INSTANCE;
            Unit unit14 = Unit.INSTANCE;
        }
        AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCopyText());
        if (accessibilityAction3 != null) {
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, accessibilityAction3.getLabel()));
            Unit unit15 = Unit.INSTANCE;
            Unit unit16 = Unit.INSTANCE;
        }
        enabled2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
        if (enabled2) {
            AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetText());
            if (accessibilityAction4 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, accessibilityAction4.getLabel()));
                Unit unit17 = Unit.INSTANCE;
                Unit unit18 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnImeAction());
            if (accessibilityAction5 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionImeEnter, accessibilityAction5.getLabel()));
                Unit unit19 = Unit.INSTANCE;
                Unit unit20 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCutText());
            if (accessibilityAction6 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, accessibilityAction6.getLabel()));
                Unit unit21 = Unit.INSTANCE;
                Unit unit22 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPasteText());
            if (accessibilityAction7 != null) {
                if (info.isFocused() && this.view.getClipboardManager().hasText()) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, accessibilityAction7.getLabel()));
                }
                Unit unit23 = Unit.INSTANCE;
                Unit unit24 = Unit.INSTANCE;
            }
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if (iterableTextForAccessibility != null && iterableTextForAccessibility.length() != 0) {
            info.setTextSelection(getAccessibilitySelectionStart(semanticsNode), getAccessibilitySelectionEnd(semanticsNode));
            AccessibilityAction accessibilityAction8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetSelection());
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, accessibilityAction8 != null ? accessibilityAction8.getLabel() : null));
            info.addAction(256);
            info.addAction(512);
            info.setMovementGranularities(11);
            List list2 = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getContentDescription());
            if ((list2 == null || list2.isEmpty()) && semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                excludeLineAndPageGranularities = AndroidComposeViewAccessibilityDelegateCompat_androidKt.excludeLineAndPageGranularities(semanticsNode);
                if (!excludeLineAndPageGranularities) {
                    info.setMovementGranularities(info.getMovementGranularities() | 20);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(ExtraDataIdKey);
            CharSequence text = info.getText();
            if (text != null && text.length() != 0 && semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                arrayList.add(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY);
            }
            if (semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTestTag())) {
                arrayList.add(ExtraDataTestTagKey);
            }
            info.setAvailableExtraData(arrayList);
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (progressBarRangeInfo != null) {
            if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetProgress())) {
                info.setClassName("android.widget.SeekBar");
            } else {
                info.setClassName("android.widget.ProgressBar");
            }
            if (progressBarRangeInfo != ProgressBarRangeInfo.INSTANCE.getIndeterminate()) {
                info.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getCurrent()));
            }
            if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetProgress())) {
                enabled6 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
                if (enabled6) {
                    if (progressBarRangeInfo.getCurrent() < RangesKt.coerceAtLeast(progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getRange().getStart().floatValue())) {
                        info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    }
                    if (progressBarRangeInfo.getCurrent() > RangesKt.coerceAtMost(progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue())) {
                        info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    }
                }
            }
        }
        Api24Impl.addSetProgressAction(info, semanticsNode);
        CollectionInfo_androidKt.setCollectionInfo(semanticsNode, info);
        CollectionInfo_androidKt.setCollectionItemInfo(semanticsNode, info);
        ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
        AccessibilityAction accessibilityAction9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getScrollBy());
        if (scrollAxisRange != null && accessibilityAction9 != null) {
            if (!CollectionInfo_androidKt.hasCollectionInfo(semanticsNode)) {
                info.setClassName("android.widget.HorizontalScrollView");
            }
            if (scrollAxisRange.getMaxValue().invoke().floatValue() > 0.0f) {
                info.setScrollable(true);
            }
            enabled5 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled5) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    isRtl2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
                    if (!isRtl2) {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    } else {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    }
                    info.addAction(accessibilityActionCompat2);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    isRtl = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
                    if (!isRtl) {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    } else {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    }
                    info.addAction(accessibilityActionCompat);
                }
            }
        }
        ScrollAxisRange scrollAxisRange2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        if (scrollAxisRange2 != null && accessibilityAction9 != null) {
            if (!CollectionInfo_androidKt.hasCollectionInfo(semanticsNode)) {
                info.setClassName("android.widget.ScrollView");
            }
            if (scrollAxisRange2.getMaxValue().invoke().floatValue() > 0.0f) {
                info.setScrollable(true);
            }
            enabled4 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled4) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange2)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange2)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.addPageActions(info, semanticsNode);
        }
        info.setPaneTitle((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getPaneTitle()));
        enabled3 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
        if (enabled3) {
            AccessibilityAction accessibilityAction10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getExpand());
            if (accessibilityAction10 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, accessibilityAction10.getLabel()));
                Unit unit25 = Unit.INSTANCE;
                Unit unit26 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCollapse());
            if (accessibilityAction11 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, accessibilityAction11.getLabel()));
                Unit unit27 = Unit.INSTANCE;
                Unit unit28 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction12 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getDismiss());
            if (accessibilityAction12 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, accessibilityAction12.getLabel()));
                Unit unit29 = Unit.INSTANCE;
                Unit unit30 = Unit.INSTANCE;
            }
            if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getCustomActions())) {
                List list3 = (List) semanticsNode.getUnmergedConfig().get(SemanticsActions.INSTANCE.getCustomActions());
                int size2 = list3.size();
                IntList intList = AccessibilityActionsResourceIds;
                if (size2 >= intList._size) {
                    throw new IllegalStateException("Can't have more than " + intList._size + " custom actions for one widget");
                }
                SparseArrayCompat<CharSequence> sparseArrayCompat = new SparseArrayCompat<>(0, 1, null);
                MutableObjectIntMap<CharSequence> mutableObjectIntMapOf = ObjectIntMapKt.mutableObjectIntMapOf();
                if (this.labelToActionId.containsKey(virtualViewId)) {
                    MutableObjectIntMap<CharSequence> mutableObjectIntMap = this.labelToActionId.get(virtualViewId);
                    MutableIntList mutableIntList = new MutableIntList(0, 1, null);
                    int[] iArr = intList.content;
                    int i2 = intList._size;
                    for (int i3 = 0; i3 < i2; i3++) {
                        mutableIntList.add(iArr[i3]);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int size3 = list3.size();
                    for (int i4 = 0; i4 < size3; i4++) {
                        CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) list3.get(i4);
                        Intrinsics.checkNotNull(mutableObjectIntMap);
                        if (mutableObjectIntMap.containsKey(customAccessibilityAction.getLabel())) {
                            int i5 = mutableObjectIntMap.get(customAccessibilityAction.getLabel());
                            sparseArrayCompat.put(i5, customAccessibilityAction.getLabel());
                            mutableObjectIntMapOf.set(customAccessibilityAction.getLabel(), i5);
                            mutableIntList.remove(i5);
                            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i5, customAccessibilityAction.getLabel()));
                        } else {
                            arrayList2.add(customAccessibilityAction);
                        }
                    }
                    int size4 = arrayList2.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        CustomAccessibilityAction customAccessibilityAction2 = (CustomAccessibilityAction) arrayList2.get(i6);
                        int i7 = mutableIntList.get(i6);
                        sparseArrayCompat.put(i7, customAccessibilityAction2.getLabel());
                        mutableObjectIntMapOf.set(customAccessibilityAction2.getLabel(), i7);
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i7, customAccessibilityAction2.getLabel()));
                    }
                } else {
                    int size5 = list3.size();
                    for (int i8 = 0; i8 < size5; i8++) {
                        CustomAccessibilityAction customAccessibilityAction3 = (CustomAccessibilityAction) list3.get(i8);
                        int i9 = AccessibilityActionsResourceIds.get(i8);
                        sparseArrayCompat.put(i9, customAccessibilityAction3.getLabel());
                        mutableObjectIntMapOf.set(customAccessibilityAction3.getLabel(), i9);
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i9, customAccessibilityAction3.getLabel()));
                    }
                }
                this.actionIdToLabel.put(virtualViewId, sparseArrayCompat);
                this.labelToActionId.put(virtualViewId, mutableObjectIntMapOf);
            }
        }
        isScreenReaderFocusable = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isScreenReaderFocusable(semanticsNode, resources);
        info.setScreenReaderFocusable(isScreenReaderFocusable);
        int orDefault = this.idToBeforeMap.getOrDefault(virtualViewId, -1);
        if (orDefault != -1) {
            View semanticsIdToView2 = SemanticsUtils_androidKt.semanticsIdToView(this.view.getAndroidViewsHandler$ui_release(), orDefault);
            if (semanticsIdToView2 != null) {
                info.setTraversalBefore(semanticsIdToView2);
            } else {
                info.setTraversalBefore(this.view, orDefault);
            }
            addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info, this.ExtraDataTestTraversalBeforeVal, null);
        }
        int orDefault2 = this.idToAfterMap.getOrDefault(virtualViewId, -1);
        if (orDefault2 == -1 || (semanticsIdToView = SemanticsUtils_androidKt.semanticsIdToView(this.view.getAndroidViewsHandler$ui_release(), orDefault2)) == null) {
            return;
        }
        info.setTraversalAfter(semanticsIdToView);
        addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info, this.ExtraDataTestTraversalAfterVal, null);
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange scrollAxisRange) {
        if (scrollAxisRange.getValue().invoke().floatValue() >= scrollAxisRange.getMaxValue().invoke().floatValue() || scrollAxisRange.getReverseScrolling()) {
            return scrollAxisRange.getValue().invoke().floatValue() > 0.0f && scrollAxisRange.getReverseScrolling();
        }
        return true;
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange scrollAxisRange) {
        if (scrollAxisRange.getValue().invoke().floatValue() <= 0.0f || scrollAxisRange.getReverseScrolling()) {
            return scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue() && scrollAxisRange.getReverseScrolling();
        }
        return true;
    }

    private final void setContentInvalid(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getError())) {
            info.setContentInvalid(true);
            info.setError((CharSequence) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getError()));
        }
    }

    private final SpannableString toSpannableString(AnnotatedString annotatedString) {
        return (SpannableString) trimToSize(AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(annotatedString, this.view.getDensity(), this.view.getFontFamilyResolver(), this.urlSpanCache), ParcelSafeTextLength);
    }

    private final void setText(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        AnnotatedString infoText;
        infoText = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoText(node);
        info.setText(infoText != null ? toSpannableString(infoText) : null);
    }

    private final boolean isAccessibilityFocused(int virtualViewId) {
        return this.accessibilityFocusedVirtualViewId == virtualViewId;
    }

    private final boolean requestAccessibilityFocus(int virtualViewId) {
        if (!isTouchExplorationEnabled() || isAccessibilityFocused(virtualViewId)) {
            return false;
        }
        int i = this.accessibilityFocusedVirtualViewId;
        if (i != Integer.MIN_VALUE) {
            sendEventForVirtualView$default(this, i, 65536, null, null, 12, null);
        }
        this.accessibilityFocusedVirtualViewId = virtualViewId;
        this.view.invalidate();
        sendEventForVirtualView$default(this, virtualViewId, 32768, null, null, 12, null);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i, int i2, Integer num, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i, i2, num, list);
    }

    private final boolean sendEventForVirtualView(int virtualViewId, int eventType, Integer contentChangeType, List<String> contentDescription) {
        if (virtualViewId == Integer.MIN_VALUE || !isEnabled$ui_release()) {
            return false;
        }
        AccessibilityEvent createEvent = createEvent(virtualViewId, eventType);
        if (contentChangeType != null) {
            createEvent.setContentChangeTypes(contentChangeType.intValue());
        }
        if (contentDescription != null) {
            createEvent.setContentDescription(ListUtilsKt.fastJoinToString$default(contentDescription, ",", null, null, 0, null, null, 62, null));
        }
        return sendEvent(createEvent);
    }

    private final boolean sendEvent(AccessibilityEvent event) {
        if (!isEnabled$ui_release()) {
            return false;
        }
        if (event.getEventType() == 2048 || event.getEventType() == 32768) {
            this.sendingFocusAffectingEvent = true;
        }
        try {
            return this.onSendAccessibilityEvent.invoke(event).booleanValue();
        } finally {
            this.sendingFocusAffectingEvent = false;
        }
    }

    private final AccessibilityEvent createEvent(int virtualViewId, int eventType) {
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
        AccessibilityEvent obtain = AccessibilityEvent.obtain(eventType);
        obtain.setEnabled(true);
        obtain.setClassName(ClassName);
        obtain.setPackageName(this.view.getContext().getPackageName());
        obtain.setSource(this.view, virtualViewId);
        if (isEnabled$ui_release() && (semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId)) != null) {
            obtain.setPassword(semanticsNodeWithAdjustedBounds.getSemanticsNode().getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPassword()));
        }
        return obtain;
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int virtualViewId, Integer fromIndex, Integer toIndex, Integer itemCount, CharSequence text) {
        AccessibilityEvent createEvent = createEvent(virtualViewId, 8192);
        if (fromIndex != null) {
            createEvent.setFromIndex(fromIndex.intValue());
        }
        if (toIndex != null) {
            createEvent.setToIndex(toIndex.intValue());
        }
        if (itemCount != null) {
            createEvent.setItemCount(itemCount.intValue());
        }
        if (text != null) {
            createEvent.getText().add(text);
        }
        return createEvent;
    }

    private final boolean clearAccessibilityFocus(int virtualViewId) {
        if (!isAccessibilityFocused(virtualViewId)) {
            return false;
        }
        this.accessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.currentlyAccessibilityFocusedANI = null;
        this.view.invalidate();
        sendEventForVirtualView$default(this, virtualViewId, 65536, null, null, 12, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01c8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01aa A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:125:0x01a7 -> B:93:0x01a8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean performActionHelper(int r13, int r14, android.os.Bundle r15) {
        /*
            Method dump skipped, instructions count: 1892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.performActionHelper(int, int, android.os.Bundle):boolean");
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange scrollAxisRange, float f) {
        if (f >= 0.0f || scrollAxisRange.getValue().invoke().floatValue() <= 0.0f) {
            return f > 0.0f && scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue();
        }
        return true;
    }

    private static final float performActionHelper$scrollDelta(float f, float f2) {
        if (Math.signum(f) == Math.signum(f2)) {
            return Math.abs(f) < Math.abs(f2) ? f : f2;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfoCompat info, String extraDataKey, Bundle arguments) {
        SemanticsNode semanticsNode;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId);
        if (semanticsNodeWithAdjustedBounds == null || (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null) {
            return;
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if (Intrinsics.areEqual(extraDataKey, this.ExtraDataTestTraversalBeforeVal)) {
            int orDefault = this.idToBeforeMap.getOrDefault(virtualViewId, -1);
            if (orDefault != -1) {
                info.getExtras().putInt(extraDataKey, orDefault);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, this.ExtraDataTestTraversalAfterVal)) {
            int orDefault2 = this.idToAfterMap.getOrDefault(virtualViewId, -1);
            if (orDefault2 != -1) {
                info.getExtras().putInt(extraDataKey, orDefault2);
                return;
            }
            return;
        }
        if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && arguments != null && Intrinsics.areEqual(extraDataKey, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY)) {
            int i = arguments.getInt(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX, -1);
            int i2 = arguments.getInt(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH, -1);
            if (i2 > 0 && i >= 0) {
                if (i < (iterableTextForAccessibility != null ? iterableTextForAccessibility.length() : Integer.MAX_VALUE)) {
                    TextLayoutResult textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(semanticsNode.getUnmergedConfig());
                    if (textLayoutResult == null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = i + i3;
                        if (i4 >= textLayoutResult.getLayoutInput().getText().length()) {
                            arrayList.add(null);
                        } else {
                            arrayList.add(toScreenCoords(semanticsNode, textLayoutResult.getBoundingBox(i4)));
                        }
                    }
                    info.getExtras().putParcelableArray(extraDataKey, (Parcelable[]) arrayList.toArray(new RectF[0]));
                    return;
                }
            }
            Log.e(LogTag, "Invalid arguments for accessibility character locations");
            return;
        }
        if (semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTestTag()) && arguments != null && Intrinsics.areEqual(extraDataKey, ExtraDataTestTagKey)) {
            String str = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getTestTag());
            if (str != null) {
                info.getExtras().putCharSequence(extraDataKey, str);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, ExtraDataIdKey)) {
            info.getExtras().putInt(extraDataKey, semanticsNode.getId());
        }
    }

    private final RectF toScreenCoords(SemanticsNode textNode, androidx.compose.ui.geometry.Rect bounds) {
        if (textNode == null) {
            return null;
        }
        androidx.compose.ui.geometry.Rect m4162translatek4lQ0M = bounds.m4162translatek4lQ0M(textNode.m6209getPositionInRootF1C5BW0());
        androidx.compose.ui.geometry.Rect boundsInRoot = textNode.getBoundsInRoot();
        androidx.compose.ui.geometry.Rect intersect = m4162translatek4lQ0M.overlaps(boundsInRoot) ? m4162translatek4lQ0M.intersect(boundsInRoot) : null;
        if (intersect == null) {
            return null;
        }
        AndroidComposeView androidComposeView = this.view;
        float left = intersect.getLeft();
        long mo5687localToScreenMKHz9U = androidComposeView.mo5687localToScreenMKHz9U(Offset.m4117constructorimpl((Float.floatToRawIntBits(intersect.getTop()) & 4294967295L) | (Float.floatToRawIntBits(left) << 32)));
        AndroidComposeView androidComposeView2 = this.view;
        float right = intersect.getRight();
        long mo5687localToScreenMKHz9U2 = androidComposeView2.mo5687localToScreenMKHz9U(Offset.m4117constructorimpl((Float.floatToRawIntBits(intersect.getBottom()) & 4294967295L) | (Float.floatToRawIntBits(right) << 32)));
        return new RectF(Float.intBitsToFloat((int) (mo5687localToScreenMKHz9U >> 32)), Float.intBitsToFloat((int) (mo5687localToScreenMKHz9U & 4294967295L)), Float.intBitsToFloat((int) (mo5687localToScreenMKHz9U2 >> 32)), Float.intBitsToFloat((int) (mo5687localToScreenMKHz9U2 & 4294967295L)));
    }

    public final boolean dispatchHoverEvent$ui_release(MotionEvent event) {
        if (!isTouchExplorationEnabled()) {
            return false;
        }
        int action = event.getAction();
        if (action == 7 || action == 9) {
            int hitTestSemanticsAt$ui_release = hitTestSemanticsAt$ui_release(event.getX(), event.getY());
            boolean dispatchGenericMotionEvent = this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
            updateHoveredVirtualView(hitTestSemanticsAt$ui_release);
            if (hitTestSemanticsAt$ui_release == Integer.MIN_VALUE) {
                return dispatchGenericMotionEvent;
            }
            return true;
        }
        if (action != 10) {
            return false;
        }
        if (this.hoveredVirtualViewId != Integer.MIN_VALUE) {
            updateHoveredVirtualView(Integer.MIN_VALUE);
            return true;
        }
        return this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
    }

    public final int hitTestSemanticsAt$ui_release(float x, float y) {
        int i;
        Owner.measureAndLayout$default(this.view, false, 1, null);
        HitTestResult hitTestResult = new HitTestResult();
        LayoutNode.m5903hitTestSemantics6fMxITs$ui_release$default(this.view.getRoot(), Offset.m4117constructorimpl((Float.floatToRawIntBits(y) & 4294967295L) | (Float.floatToRawIntBits(x) << 32)), hitTestResult, 0, false, 12, null);
        int lastIndex = CollectionsKt.getLastIndex(hitTestResult);
        while (true) {
            i = Integer.MIN_VALUE;
            if (-1 >= lastIndex) {
                break;
            }
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(hitTestResult.get(lastIndex));
            if (this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(requireLayoutNode) != null) {
                return Integer.MIN_VALUE;
            }
            if (requireLayoutNode.getNodes().m5955hasH91voCI$ui_release(NodeKind.m5994constructorimpl(8))) {
                i = semanticsNodeIdToAccessibilityVirtualNodeId(requireLayoutNode.getSemanticsId());
                SemanticsNode SemanticsNode = SemanticsNodeKt.SemanticsNode(requireLayoutNode, false);
                if (SemanticsUtils_androidKt.isImportantForAccessibility(SemanticsNode) && !SemanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getLinkTestMarker())) {
                    break;
                }
            }
            lastIndex--;
        }
        return i;
    }

    private final void updateHoveredVirtualView(int virtualViewId) {
        int i = this.hoveredVirtualViewId;
        if (i == virtualViewId) {
            return;
        }
        this.hoveredVirtualViewId = virtualViewId;
        sendEventForVirtualView$default(this, virtualViewId, 128, null, null, 12, null);
        sendEventForVirtualView$default(this, i, 256, null, null, 12, null);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        return this.nodeProvider;
    }

    private final <T extends CharSequence> T trimToSize(T text, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size should be greater than 0".toString());
        }
        if (text == null || text.length() == 0 || text.length() <= size) {
            return text;
        }
        int i = size - 1;
        if (Character.isHighSurrogate(text.charAt(i)) && Character.isLowSurrogate(text.charAt(size))) {
            size = i;
        }
        T t = (T) text.subSequence(0, size);
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void semanticsChangeChecker$lambda$37(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        Trace.beginSection("measureAndLayout");
        try {
            Owner.measureAndLayout$default(androidComposeViewAccessibilityDelegateCompat.view, false, 1, null);
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Trace.beginSection("checkForSemanticsChanges");
            try {
                androidComposeViewAccessibilityDelegateCompat.checkForSemanticsChanges();
                Unit unit2 = Unit.INSTANCE;
                Trace.endSection();
                androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges = false;
            } finally {
            }
        } finally {
        }
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (!isEnabled$ui_release() || this.checkingForSemanticsChanges) {
            return;
        }
        this.checkingForSemanticsChanges = true;
        this.handler.post(this.semanticsChangeChecker);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0085 A[Catch: all -> 0x00e4, TryCatch #0 {all -> 0x00e4, blocks: (B:11:0x006b, B:17:0x007d, B:19:0x0085, B:21:0x008e, B:23:0x0099, B:25:0x00aa, B:27:0x00b1, B:28:0x00ba, B:10:0x005f), top: B:9:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00da -> B:11:0x006b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object boundsUpdatesEventLoop$ui_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop$ui_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onLayoutChange$ui_release(LayoutNode layoutNode) {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release()) {
            notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.mo9440trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    private final void sendTypeViewScrolledAccessibilityEvent(LayoutNode layoutNode) {
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            int semanticsId = layoutNode.getSemanticsId();
            ScrollAxisRange scrollAxisRange = this.pendingHorizontalScrollEvents.get(semanticsId);
            ScrollAxisRange scrollAxisRange2 = this.pendingVerticalScrollEvents.get(semanticsId);
            if (scrollAxisRange == null && scrollAxisRange2 == null) {
                return;
            }
            AccessibilityEvent createEvent = createEvent(semanticsId, 4096);
            if (scrollAxisRange != null) {
                createEvent.setScrollX((int) scrollAxisRange.getValue().invoke().floatValue());
                createEvent.setMaxScrollX((int) scrollAxisRange.getMaxValue().invoke().floatValue());
            }
            if (scrollAxisRange2 != null) {
                createEvent.setScrollY((int) scrollAxisRange2.getValue().invoke().floatValue());
                createEvent.setMaxScrollY((int) scrollAxisRange2.getMaxValue().invoke().floatValue());
            }
            sendEvent(createEvent);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(r8, androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.INSTANCE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void sendSubtreeChangeAccessibilityEvents(androidx.compose.ui.node.LayoutNode r8, androidx.collection.MutableIntSet r9) {
        /*
            r7 = this;
            boolean r0 = r8.isAttached()
            if (r0 != 0) goto L7
            goto L6d
        L7:
            androidx.compose.ui.platform.AndroidComposeView r0 = r7.view
            androidx.compose.ui.platform.AndroidViewsHandler r0 = r0.getAndroidViewsHandler$ui_release()
            java.util.HashMap r0 = r0.getLayoutNodeToHolder()
            java.util.Map r0 = (java.util.Map) r0
            boolean r0 = r0.containsKey(r8)
            if (r0 == 0) goto L1a
            goto L6d
        L1a:
            androidx.compose.ui.node.NodeChain r0 = r8.getNodes()
            r1 = 8
            int r1 = androidx.compose.ui.node.NodeKind.m5994constructorimpl(r1)
            boolean r0 = r0.m5955hasH91voCI$ui_release(r1)
            if (r0 == 0) goto L2b
            goto L33
        L2b:
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1 r0 = new kotlin.jvm.functions.Function1<androidx.compose.ui.node.LayoutNode, java.lang.Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1
                static {
                    /*
                        androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1 r0 = new androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT 
  (r0 I:androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1)
 androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.INSTANCE androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r1) {
                    /*
                        r0 = this;
                        androidx.compose.ui.node.NodeChain r0 = r1.getNodes()
                        r1 = 8
                        int r1 = androidx.compose.ui.node.NodeKind.m5994constructorimpl(r1)
                        boolean r0 = r0.m5955hasH91voCI$ui_release(r1)
                        java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.invoke(androidx.compose.ui.node.LayoutNode):java.lang.Boolean");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r1) {
                    /*
                        r0 = this;
                        androidx.compose.ui.node.LayoutNode r1 = (androidx.compose.ui.node.LayoutNode) r1
                        java.lang.Boolean r0 = r0.invoke(r1)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            androidx.compose.ui.node.LayoutNode r8 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$findClosestParentNode(r8, r0)
        L33:
            if (r8 == 0) goto L6d
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r8.getSemanticsConfiguration()
            if (r0 != 0) goto L3c
            goto L6d
        L3c:
            boolean r0 = r0.getIsMergingSemanticsOfDescendants()
            if (r0 != 0) goto L4d
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1 r0 = new kotlin.jvm.functions.Function1<androidx.compose.ui.node.LayoutNode, java.lang.Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1
                static {
                    /*
                        androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1 r0 = new androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT 
  (r0 I:androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1)
 androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.INSTANCE androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r1) {
                    /*
                        r0 = this;
                        androidx.compose.ui.node.LayoutNode r1 = (androidx.compose.ui.node.LayoutNode) r1
                        java.lang.Boolean r0 = r0.invoke(r1)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.invoke(java.lang.Object):java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function1
                public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r2) {
                    /*
                        r1 = this;
                        androidx.compose.ui.semantics.SemanticsConfiguration r1 = r2.getSemanticsConfiguration()
                        r2 = 0
                        if (r1 == 0) goto Lf
                        boolean r1 = r1.getIsMergingSemanticsOfDescendants()
                        r0 = 1
                        if (r1 != r0) goto Lf
                        r2 = r0
                    Lf:
                        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.invoke(androidx.compose.ui.node.LayoutNode):java.lang.Boolean");
                }
            }
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$findClosestParentNode(r8, r0)
            if (r0 == 0) goto L4d
            r8 = r0
        L4d:
            if (r8 == 0) goto L6d
            int r8 = r8.getSemanticsId()
            boolean r9 = r9.add(r8)
            if (r9 != 0) goto L5a
            goto L6d
        L5a:
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r8)
            r8 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            r5 = 8
            r6 = 0
            r2 = 2048(0x800, float:2.87E-42)
            r4 = 0
            r0 = r7
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendSubtreeChangeAccessibilityEvents(androidx.compose.ui.node.LayoutNode, androidx.collection.MutableIntSet):void");
    }

    private final void checkForSemanticsChanges() {
        Trace.beginSection("sendAccessibilitySemanticsStructureChangeEvents");
        try {
            if (isEnabled$ui_release()) {
                sendAccessibilitySemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Trace.beginSection("sendSemanticsPropertyChangeEvents");
            try {
                sendSemanticsPropertyChangeEvents(getCurrentSemanticsNodes());
                Unit unit2 = Unit.INSTANCE;
                Trace.endSection();
                Trace.beginSection("updateSemanticsNodesCopyAndPanes");
                try {
                    updateSemanticsNodesCopyAndPanes();
                    Unit unit3 = Unit.INSTANCE;
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    private final void updateSemanticsNodesCopyAndPanes() {
        long j;
        long j2;
        long j3;
        long j4;
        SemanticsConfiguration unmergedConfig;
        MutableIntSet mutableIntSet = new MutableIntSet(0, 1, null);
        MutableIntSet mutableIntSet2 = this.paneDisplayed;
        int[] iArr = mutableIntSet2.elements;
        long[] jArr = mutableIntSet2.metadata;
        int length = jArr.length - 2;
        long j5 = 128;
        long j6 = 255;
        char c = 7;
        long j7 = -9187201950435737472L;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j8 = jArr[i];
                int[] iArr2 = iArr;
                if ((((~j8) << 7) & j8 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    int i3 = 0;
                    while (i3 < i2) {
                        if ((j8 & j6) < j5) {
                            j3 = j5;
                            int i4 = iArr2[(i << 3) + i3];
                            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(i4);
                            SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                            if (semanticsNode != null) {
                                j4 = j6;
                                if (semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle())) {
                                }
                            } else {
                                j4 = j6;
                            }
                            mutableIntSet.add(i4);
                            SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(i4);
                            sendPaneChangeEvents(i4, 32, (semanticsNodeCopy == null || (unmergedConfig = semanticsNodeCopy.getUnmergedConfig()) == null) ? null : (String) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsProperties.INSTANCE.getPaneTitle()));
                        } else {
                            j3 = j5;
                            j4 = j6;
                        }
                        j8 >>= 8;
                        i3++;
                        j5 = j3;
                        j6 = j4;
                    }
                    j = j5;
                    j2 = j6;
                    if (i2 != 8) {
                        break;
                    }
                } else {
                    j = j5;
                    j2 = j6;
                }
                if (i == length) {
                    break;
                }
                i++;
                iArr = iArr2;
                j5 = j;
                j6 = j2;
            }
        } else {
            j = 128;
            j2 = 255;
        }
        this.paneDisplayed.removeAll(mutableIntSet);
        this.previousSemanticsNodes.clear();
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes = getCurrentSemanticsNodes();
        int[] iArr3 = currentSemanticsNodes.keys;
        Object[] objArr = currentSemanticsNodes.values;
        long[] jArr2 = currentSemanticsNodes.metadata;
        int length2 = jArr2.length - 2;
        if (length2 >= 0) {
            int i5 = 0;
            while (true) {
                long j9 = jArr2[i5];
                if ((((~j9) << c) & j9 & j7) != j7) {
                    int i6 = 8 - ((~(i5 - length2)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((j9 & j2) < j) {
                            int i8 = (i5 << 3) + i7;
                            int i9 = iArr3[i8];
                            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds2 = (SemanticsNodeWithAdjustedBounds) objArr[i8];
                            if (semanticsNodeWithAdjustedBounds2.getSemanticsNode().getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle()) && this.paneDisplayed.add(i9)) {
                                sendPaneChangeEvents(i9, 16, (String) semanticsNodeWithAdjustedBounds2.getSemanticsNode().getUnmergedConfig().get(SemanticsProperties.INSTANCE.getPaneTitle()));
                            }
                            this.previousSemanticsNodes.set(i9, new SemanticsNodeCopy(semanticsNodeWithAdjustedBounds2.getSemanticsNode(), getCurrentSemanticsNodes()));
                        }
                        j9 >>= 8;
                    }
                    if (i6 != 8) {
                        break;
                    }
                }
                if (i5 == length2) {
                    break;
                }
                i5++;
                c = 7;
                j7 = -9187201950435737472L;
            }
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes());
    }

    /* JADX WARN: Code restructure failed: missing block: B:165:0x05c6, code lost:
    
        if (r1.containsAll(r3) != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x05e7, code lost:
    
        r31 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x05cf, code lost:
    
        if (r1.isEmpty() == false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x05e4, code lost:
    
        if (r1 == false) goto L175;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void sendSemanticsPropertyChangeEvents(androidx.collection.IntObjectMap<androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> r52) {
        /*
            Method dump skipped, instructions count: 1768
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendSemanticsPropertyChangeEvents(androidx.collection.IntObjectMap):void");
    }

    private final boolean registerScrollingId(int id, List<ScrollObservationScope> oldScrollObservationScopes) {
        boolean z;
        ScrollObservationScope findById = SemanticsUtils_androidKt.findById(oldScrollObservationScopes, id);
        if (findById != null) {
            z = false;
        } else {
            ScrollObservationScope scrollObservationScope = new ScrollObservationScope(id, this.scrollObservationScopes, null, null, null, null);
            z = true;
            findById = scrollObservationScope;
        }
        this.scrollObservationScopes.add(findById);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleScrollEventIfNeeded(final ScrollObservationScope scrollObservationScope) {
        if (scrollObservationScope.isValidOwnerScope()) {
            this.view.getSnapshotObserver().observeReads$ui_release(scrollObservationScope, this.scheduleScrollEventIfNeededLambda, new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeeded$1
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
                    int semanticsNodeIdToAccessibilityVirtualNodeId;
                    IntObjectMap currentSemanticsNodes;
                    IntObjectMap currentSemanticsNodes2;
                    IntObjectMap currentSemanticsNodes3;
                    SemanticsNode semanticsNode;
                    LayoutNode layoutNode;
                    MutableIntObjectMap mutableIntObjectMap;
                    MutableIntObjectMap mutableIntObjectMap2;
                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
                    Rect boundsInScreen;
                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
                    Rect boundsInScreen2;
                    ScrollAxisRange horizontalScrollAxisRange = ScrollObservationScope.this.getHorizontalScrollAxisRange();
                    ScrollAxisRange verticalScrollAxisRange = ScrollObservationScope.this.getVerticalScrollAxisRange();
                    Float oldXValue = ScrollObservationScope.this.getOldXValue();
                    Float oldYValue = ScrollObservationScope.this.getOldYValue();
                    float floatValue = (horizontalScrollAxisRange == null || oldXValue == null) ? 0.0f : horizontalScrollAxisRange.getValue().invoke().floatValue() - oldXValue.floatValue();
                    float floatValue2 = (verticalScrollAxisRange == null || oldYValue == null) ? 0.0f : verticalScrollAxisRange.getValue().invoke().floatValue() - oldYValue.floatValue();
                    if (floatValue != 0.0f || floatValue2 != 0.0f) {
                        semanticsNodeIdToAccessibilityVirtualNodeId = this.semanticsNodeIdToAccessibilityVirtualNodeId(ScrollObservationScope.this.getSemanticsNodeId());
                        currentSemanticsNodes = this.getCurrentSemanticsNodes();
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) currentSemanticsNodes.get(this.accessibilityFocusedVirtualViewId);
                        if (semanticsNodeWithAdjustedBounds != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this;
                            try {
                                accessibilityNodeInfoCompat2 = androidComposeViewAccessibilityDelegateCompat.currentlyAccessibilityFocusedANI;
                                if (accessibilityNodeInfoCompat2 != null) {
                                    boundsInScreen2 = androidComposeViewAccessibilityDelegateCompat.boundsInScreen(semanticsNodeWithAdjustedBounds);
                                    accessibilityNodeInfoCompat2.setBoundsInScreen(boundsInScreen2);
                                    Unit unit = Unit.INSTANCE;
                                }
                            } catch (IllegalStateException unused) {
                                Unit unit2 = Unit.INSTANCE;
                            }
                        }
                        currentSemanticsNodes2 = this.getCurrentSemanticsNodes();
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds2 = (SemanticsNodeWithAdjustedBounds) currentSemanticsNodes2.get(this.focusedVirtualViewId);
                        if (semanticsNodeWithAdjustedBounds2 != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat2 = this;
                            try {
                                accessibilityNodeInfoCompat = androidComposeViewAccessibilityDelegateCompat2.currentlyFocusedANI;
                                if (accessibilityNodeInfoCompat != null) {
                                    boundsInScreen = androidComposeViewAccessibilityDelegateCompat2.boundsInScreen(semanticsNodeWithAdjustedBounds2);
                                    accessibilityNodeInfoCompat.setBoundsInScreen(boundsInScreen);
                                    Unit unit3 = Unit.INSTANCE;
                                }
                            } catch (IllegalStateException unused2) {
                                Unit unit4 = Unit.INSTANCE;
                            }
                        }
                        this.getView().invalidate();
                        currentSemanticsNodes3 = this.getCurrentSemanticsNodes();
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds3 = (SemanticsNodeWithAdjustedBounds) currentSemanticsNodes3.get(semanticsNodeIdToAccessibilityVirtualNodeId);
                        if (semanticsNodeWithAdjustedBounds3 != null && (semanticsNode = semanticsNodeWithAdjustedBounds3.getSemanticsNode()) != null && (layoutNode = semanticsNode.getLayoutNode()) != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat3 = this;
                            if (horizontalScrollAxisRange != null) {
                                mutableIntObjectMap2 = androidComposeViewAccessibilityDelegateCompat3.pendingHorizontalScrollEvents;
                                mutableIntObjectMap2.set(semanticsNodeIdToAccessibilityVirtualNodeId, horizontalScrollAxisRange);
                            }
                            if (verticalScrollAxisRange != null) {
                                mutableIntObjectMap = androidComposeViewAccessibilityDelegateCompat3.pendingVerticalScrollEvents;
                                mutableIntObjectMap.set(semanticsNodeIdToAccessibilityVirtualNodeId, verticalScrollAxisRange);
                            }
                            androidComposeViewAccessibilityDelegateCompat3.notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
                        }
                    }
                    if (horizontalScrollAxisRange != null) {
                        ScrollObservationScope.this.setOldXValue(horizontalScrollAxisRange.getValue().invoke());
                    }
                    if (verticalScrollAxisRange != null) {
                        ScrollObservationScope.this.setOldYValue(verticalScrollAxisRange.getValue().invoke());
                    }
                }
            });
        }
    }

    private final void sendPaneChangeEvents(int semanticsNodeId, int contentChangeType, String title) {
        AccessibilityEvent createEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNodeId), 32);
        createEvent.setContentChangeTypes(contentChangeType);
        if (title != null) {
            createEvent.getText().add(title);
        }
        sendEvent(createEvent);
    }

    private final void sendAccessibilitySemanticsStructureChangeEvents(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        MutableIntSet mutableIntSetOf = IntSetKt.mutableIntSetOf();
        List<SemanticsNode> replacedChildren$ui_release = newNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode = replacedChildren$ui_release.get(i);
            if (getCurrentSemanticsNodes().containsKey(semanticsNode.getId())) {
                if (!oldNode.getChildren().contains(semanticsNode.getId())) {
                    notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode());
                    return;
                }
                mutableIntSetOf.add(semanticsNode.getId());
            }
        }
        MutableIntSet children = oldNode.getChildren();
        int[] iArr = children.elements;
        long[] jArr = children.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128 && !mutableIntSetOf.contains(iArr[(i2 << 3) + i4])) {
                            notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode());
                            return;
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i2 == length) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        List<SemanticsNode> replacedChildren$ui_release2 = newNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        for (int i5 = 0; i5 < size2; i5++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release2.get(i5);
            if (getCurrentSemanticsNodes().containsKey(semanticsNode2.getId())) {
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(semanticsNode2.getId());
                Intrinsics.checkNotNull(semanticsNodeCopy);
                sendAccessibilitySemanticsStructureChangeEvents(semanticsNode2, semanticsNodeCopy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int id) {
        if (id == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return id;
    }

    private final boolean traverseAtGranularity(SemanticsNode node, int granularity, boolean forward, boolean extendSelection) {
        AccessibilityIterators.TextSegmentIterator iteratorForGranularity;
        int i;
        int i2;
        int id = node.getId();
        Integer num = this.previousTraversedNode;
        if (num == null || id != num.intValue()) {
            this.accessibilityCursorPosition = -1;
            this.previousTraversedNode = Integer.valueOf(node.getId());
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(node);
        String str = iterableTextForAccessibility;
        if (str == null || str.length() == 0 || (iteratorForGranularity = getIteratorForGranularity(node, granularity)) == null) {
            return false;
        }
        int accessibilitySelectionEnd = getAccessibilitySelectionEnd(node);
        if (accessibilitySelectionEnd == -1) {
            accessibilitySelectionEnd = forward ? 0 : iterableTextForAccessibility.length();
        }
        int[] following = forward ? iteratorForGranularity.following(accessibilitySelectionEnd) : iteratorForGranularity.preceding(accessibilitySelectionEnd);
        if (following == null) {
            return false;
        }
        int i3 = following[0];
        int i4 = following[1];
        if (extendSelection && isAccessibilitySelectionExtendable(node)) {
            i = getAccessibilitySelectionStart(node);
            if (i == -1) {
                i = forward ? i3 : i4;
            }
            i2 = forward ? i4 : i3;
        } else {
            i = forward ? i4 : i3;
            i2 = i;
        }
        this.pendingTextTraversedEvent = new PendingTextTraversedEvent(node, forward ? 256 : 512, granularity, i3, i4, SystemClock.uptimeMillis());
        setAccessibilitySelection(node, i, i2, true);
        return true;
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int semanticsNodeId) {
        PendingTextTraversedEvent pendingTextTraversedEvent = this.pendingTextTraversedEvent;
        if (pendingTextTraversedEvent != null) {
            if (semanticsNodeId != pendingTextTraversedEvent.getNode().getId()) {
                return;
            }
            if (SystemClock.uptimeMillis() - pendingTextTraversedEvent.getTraverseTime() <= 1000) {
                AccessibilityEvent createEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(pendingTextTraversedEvent.getNode().getId()), 131072);
                createEvent.setFromIndex(pendingTextTraversedEvent.getFromIndex());
                createEvent.setToIndex(pendingTextTraversedEvent.getToIndex());
                createEvent.setAction(pendingTextTraversedEvent.getAction());
                createEvent.setMovementGranularity(pendingTextTraversedEvent.getGranularity());
                createEvent.getText().add(getIterableTextForAccessibility(pendingTextTraversedEvent.getNode()));
                sendEvent(createEvent);
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    private final boolean setAccessibilitySelection(SemanticsNode node, int start, int end, boolean traversalMode) {
        String iterableTextForAccessibility;
        boolean enabled;
        if (node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetSelection())) {
            enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(node);
            if (enabled) {
                Function3 function3 = (Function3) ((AccessibilityAction) node.getUnmergedConfig().get(SemanticsActions.INSTANCE.getSetSelection())).getAction();
                if (function3 != null) {
                    return ((Boolean) function3.invoke(Integer.valueOf(start), Integer.valueOf(end), Boolean.valueOf(traversalMode))).booleanValue();
                }
                return false;
            }
        }
        if ((start == end && end == this.accessibilityCursorPosition) || (iterableTextForAccessibility = getIterableTextForAccessibility(node)) == null) {
            return false;
        }
        if (start < 0 || start != end || end > iterableTextForAccessibility.length()) {
            start = -1;
        }
        this.accessibilityCursorPosition = start;
        String str = iterableTextForAccessibility;
        boolean z = str.length() > 0;
        sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(node.getId()), z ? Integer.valueOf(this.accessibilityCursorPosition) : null, z ? Integer.valueOf(this.accessibilityCursorPosition) : null, z ? Integer.valueOf(iterableTextForAccessibility.length()) : null, str));
        sendPendingTextTraversedAtGranularityEvent(node.getId());
        return true;
    }

    private final int getAccessibilitySelectionStart(SemanticsNode node) {
        if (!node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return TextRange.m6435getStartimpl(((TextRange) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue());
        }
        return this.accessibilityCursorPosition;
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode node) {
        if (!node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return TextRange.m6430getEndimpl(((TextRange) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue());
        }
        return this.accessibilityCursorPosition;
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode node) {
        return !node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText());
    }

    private final AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(SemanticsNode node, int granularity) {
        AccessibilityIterators.AbstractTextSegmentIterator companion;
        TextLayoutResult textLayoutResult;
        if (node == null) {
            return null;
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(node);
        String str = iterableTextForAccessibility;
        if (str == null || str.length() == 0) {
            return null;
        }
        if (granularity == 1) {
            companion = AccessibilityIterators.CharacterTextSegmentIterator.INSTANCE.getInstance(this.view.getContext().getResources().getConfiguration().locale);
            companion.initialize(iterableTextForAccessibility);
        } else if (granularity == 2) {
            companion = AccessibilityIterators.WordTextSegmentIterator.INSTANCE.getInstance(this.view.getContext().getResources().getConfiguration().locale);
            companion.initialize(iterableTextForAccessibility);
        } else {
            if (granularity != 4) {
                if (granularity == 8) {
                    companion = AccessibilityIterators.ParagraphTextSegmentIterator.INSTANCE.getInstance();
                    companion.initialize(iterableTextForAccessibility);
                } else if (granularity != 16) {
                    return null;
                }
            }
            if (!node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) || (textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(node.getUnmergedConfig())) == null) {
                return null;
            }
            if (granularity == 4) {
                companion = AccessibilityIterators.LineTextSegmentIterator.INSTANCE.getInstance();
                ((AccessibilityIterators.LineTextSegmentIterator) companion).initialize(iterableTextForAccessibility, textLayoutResult);
            } else {
                companion = AccessibilityIterators.PageTextSegmentIterator.INSTANCE.getInstance();
                ((AccessibilityIterators.PageTextSegmentIterator) companion).initialize(iterableTextForAccessibility, textLayoutResult, node);
            }
        }
        return companion;
    }

    private final String getIterableTextForAccessibility(SemanticsNode node) {
        AnnotatedString annotatedString;
        if (node == null) {
            return null;
        }
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription())) {
            return ListUtilsKt.fastJoinToString$default((List) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getContentDescription()), ",", null, null, 0, null, null, 62, null);
        }
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            AnnotatedString textForTextField = getTextForTextField(node.getUnmergedConfig());
            if (textForTextField != null) {
                return textForTextField.getText();
            }
            return null;
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        return annotatedString.getText();
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration semanticsConfiguration) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsProperties.INSTANCE.getEditableText());
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "addExtraDataToAccessibilityNodeInfo", "", "virtualViewId", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "extraDataKey", "", "arguments", "Landroid/os/Bundle;", "createAccessibilityNodeInfo", "findFocus", "focus", "performAction", "", "action", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    private final class ComposeAccessibilityNodeProvider extends AccessibilityNodeProviderCompat {
        public ComposeAccessibilityNodeProvider() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int virtualViewId) {
            AccessibilityNodeInfoCompat createNodeInfo = AndroidComposeViewAccessibilityDelegateCompat.this.createNodeInfo(virtualViewId);
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            if (androidComposeViewAccessibilityDelegateCompat.sendingFocusAffectingEvent) {
                if (virtualViewId == androidComposeViewAccessibilityDelegateCompat.accessibilityFocusedVirtualViewId) {
                    androidComposeViewAccessibilityDelegateCompat.currentlyAccessibilityFocusedANI = createNodeInfo;
                }
                if (virtualViewId == androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId) {
                    androidComposeViewAccessibilityDelegateCompat.currentlyFocusedANI = createNodeInfo;
                }
            }
            return createNodeInfo;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.performActionHelper(virtualViewId, action, arguments);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public void addExtraDataToAccessibilityNodeInfo(int virtualViewId, AccessibilityNodeInfoCompat info, String extraDataKey, Bundle arguments) {
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info, extraDataKey, arguments);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int focus) {
            if (focus == 1) {
                if (AndroidComposeViewAccessibilityDelegateCompat.this.focusedVirtualViewId == Integer.MIN_VALUE) {
                    return null;
                }
                return createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.this.focusedVirtualViewId);
            }
            if (focus == 2) {
                return createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.this.accessibilityFocusedVirtualViewId);
            }
            throw new IllegalArgumentException("Unknown focus type: " + focus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl;", "", "()V", "addSetProgressAction", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @JvmStatic
        public static final void addSetProgressAction(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            boolean enabled;
            AccessibilityAction accessibilityAction;
            enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (!enabled || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress())) == null) {
                return;
            }
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionSetProgress, accessibilityAction.getLabel()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api29Impl;", "", "()V", "addPageActions", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Api29Impl {
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        @JvmStatic
        public static final void addPageActions(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            boolean enabled;
            Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
            enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled) {
                if (role == null ? false : Role.m6195equalsimpl0(role.getValue(), Role.INSTANCE.m6200getCarouselo7Vup1c())) {
                    return;
                }
                AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageUp());
                if (accessibilityAction != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageUp, accessibilityAction.getLabel()));
                }
                AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageDown());
                if (accessibilityAction2 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageDown, accessibilityAction2.getLabel()));
                }
                AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageLeft());
                if (accessibilityAction3 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageLeft, accessibilityAction3.getLabel()));
                }
                AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageRight());
                if (accessibilityAction4 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageRight, accessibilityAction4.getLabel()));
                }
            }
        }
    }
}
