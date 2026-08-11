package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemClock;
import android.os.Trace;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.ScrollCaptureTarget;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.material3.internal.Listener$$ExternalSyntheticApiModelOutline0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.SessionMutex;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofillManager;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.autofill.PlatformAutofillManagerImpl;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.draganddrop.AndroidDragAndDropManager;
import androidx.compose.ui.draganddrop.ComposeDragShadowBuilder;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusOwnerImplKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.focus.TwoDimensionalFocusSearchKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidGraphicsContext_androidKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import androidx.compose.ui.semantics.EmptySemanticsElement;
import androidx.compose.ui.semantics.EmptySemanticsModifier;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Ref;
import uz.FonRo.pos.data.local.CacheStore;

/* compiled from: AndroidComposeView.android.kt */
@Metadata(d1 = {"\u0000Í\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f*\u00034Õ\u0001\b\u0000\u0018\u0000 ®\u00042\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004®\u0004¯\u0004B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001b\u0010¯\u0002\u001a\u00020E2\b\u0010\u0096\u0002\u001a\u00030°\u00022\b\u0010±\u0002\u001a\u00030«\u0001J&\u0010²\u0002\u001a\u00020E2\u0007\u0010³\u0002\u001a\u00020V2\b\u0010´\u0002\u001a\u00030µ\u00022\b\u0010¶\u0002\u001a\u00030·\u0002H\u0002J\u0015\u0010¸\u0002\u001a\u00020E2\n\u0010¹\u0002\u001a\u0005\u0018\u00010\u0097\u0002H\u0016J!\u0010¸\u0002\u001a\u00020E2\n\u0010¹\u0002\u001a\u0005\u0018\u00010\u0097\u00022\n\u0010º\u0002\u001a\u0005\u0018\u00010»\u0002H\u0016J\u001e\u0010¸\u0002\u001a\u00020E2\n\u0010¹\u0002\u001a\u0005\u0018\u00010\u0097\u00022\u0007\u0010¼\u0002\u001a\u00020VH\u0016J*\u0010¸\u0002\u001a\u00020E2\n\u0010¹\u0002\u001a\u0005\u0018\u00010\u0097\u00022\u0007\u0010¼\u0002\u001a\u00020V2\n\u0010º\u0002\u001a\u0005\u0018\u00010»\u0002H\u0016J'\u0010¸\u0002\u001a\u00020E2\n\u0010¹\u0002\u001a\u0005\u0018\u00010\u0097\u00022\u0007\u0010½\u0002\u001a\u00020V2\u0007\u0010¾\u0002\u001a\u00020VH\u0016J\u0019\u0010'\u001a\u00020E2\u000f\u0010¿\u0002\u001a\n\u0012\u0005\u0012\u00030Á\u00020À\u0002H\u0016J\t\u0010Â\u0002\u001a\u00020zH\u0002J\u0010\u0010Ã\u0002\u001a\u00020EH\u0086@¢\u0006\u0003\u0010Ä\u0002J\u0010\u0010Å\u0002\u001a\u00020EH\u0086@¢\u0006\u0003\u0010Ä\u0002J \u0010Æ\u0002\u001a\u00030\u0098\u00012\b\u0010Ç\u0002\u001a\u00030\u0098\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÈ\u0002\u0010É\u0002J \u0010Ê\u0002\u001a\u00030\u0098\u00012\b\u0010Ë\u0002\u001a\u00030\u0098\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÌ\u0002\u0010É\u0002J\u0012\u0010Í\u0002\u001a\u00020z2\u0007\u0010Î\u0002\u001a\u00020VH\u0016J\u0012\u0010Ï\u0002\u001a\u00020z2\u0007\u0010Î\u0002\u001a\u00020VH\u0016J\u0012\u0010Ð\u0002\u001a\u00020E2\u0007\u0010Ñ\u0002\u001a\u00020\u0001H\u0002J\"\u0010Ò\u0002\u001a\u00030Ó\u00022\u0007\u0010Ô\u0002\u001a\u00020VH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÕ\u0002\u0010Ö\u0002Jq\u0010×\u0002\u001a\u00020`2B\u0010Ø\u0002\u001a=\u0012\u0017\u0012\u00150Ú\u0002¢\u0006\u000f\bÛ\u0002\u0012\n\bÜ\u0002\u0012\u0005\b\b(Ý\u0002\u0012\u0019\u0012\u0017\u0018\u00010Þ\u0002¢\u0006\u000f\bÛ\u0002\u0012\n\bÜ\u0002\u0012\u0005\b\b(ß\u0002\u0012\u0004\u0012\u00020E0Ù\u00022\r\u0010à\u0002\u001a\b\u0012\u0004\u0012\u00020E0g2\n\u0010á\u0002\u001a\u0005\u0018\u00010Þ\u00022\u0007\u0010â\u0002\u001a\u00020zH\u0016J\t\u0010ã\u0002\u001a\u00020EH\u0016J\u0013\u0010ä\u0002\u001a\u00020E2\b\u0010Ý\u0002\u001a\u00030å\u0002H\u0014J\u0013\u0010æ\u0002\u001a\u00020z2\b\u0010ç\u0002\u001a\u00030Ì\u0001H\u0016J\u0013\u0010è\u0002\u001a\u00020z2\b\u0010é\u0002\u001a\u00030Ì\u0001H\u0016J\u0013\u0010ê\u0002\u001a\u00020z2\b\u0010é\u0002\u001a\u00030ë\u0002H\u0016J\u0013\u0010ì\u0002\u001a\u00020z2\b\u0010é\u0002\u001a\u00030ë\u0002H\u0016J\t\u0010í\u0002\u001a\u00020EH\u0002J\u0013\u0010î\u0002\u001a\u00020E2\b\u0010ï\u0002\u001a\u00030ð\u0002H\u0016J\u0013\u0010ñ\u0002\u001a\u00020z2\b\u0010ç\u0002\u001a\u00030Ì\u0001H\u0016J\u001b\u0010ò\u0002\u001a\u00020E2\b\u0010\u0096\u0002\u001a\u00030°\u00022\b\u0010Ý\u0002\u001a\u00030å\u0002J\u0015\u0010ó\u0002\u001a\u0005\u0018\u00010\u0097\u00022\u0007\u0010Î\u0002\u001a\u00020VH\u0002J\u001f\u0010ô\u0002\u001a\u0005\u0018\u00010\u0097\u00022\u0007\u0010õ\u0002\u001a\u00020V2\b\u0010ö\u0002\u001a\u00030\u0097\u0002H\u0002J\u0013\u0010÷\u0002\u001a\u0005\u0018\u00010\u0097\u00022\u0007\u0010õ\u0002\u001a\u00020VJ!\u0010ø\u0002\u001a\u0005\u0018\u00010\u0097\u00022\n\u0010ù\u0002\u001a\u0005\u0018\u00010\u0097\u00022\u0007\u0010Î\u0002\u001a\u00020VH\u0016J\u0012\u0010ú\u0002\u001a\u00020E2\u0007\u0010û\u0002\u001a\u00020zH\u0016J\u001c\u0010ü\u0002\u001a\u00020E2\b\u0010±\u0002\u001a\u00030«\u00012\u0007\u0010ý\u0002\u001a\u00020zH\u0016J\"\u0010þ\u0002\u001a\u0005\u0018\u00010ÿ\u00022\b\u0010\u0080\u0003\u001a\u00030\u0081\u0003H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0082\u0003\u0010\u0083\u0003J\u0013\u0010\u0084\u0003\u001a\u00020E2\b\u0010\u0085\u0003\u001a\u00030\u0086\u0003H\u0016J\t\u0010\u0087\u0003\u001a\u00020VH\u0016J#\u0010\u0088\u0003\u001a\u00030\u0089\u00032\b\u0010ç\u0002\u001a\u00030Ì\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008a\u0003\u0010\u008b\u0003J\u0013\u0010\u008c\u0003\u001a\u00020z2\b\u0010é\u0002\u001a\u00030Ì\u0001H\u0002J\u001d\u0010\u008d\u0003\u001a\u00020z2\b\u0010é\u0002\u001a\u00030Ì\u00012\b\u0010\u008e\u0003\u001a\u00030Ì\u0001H\u0002J\t\u0010\u008f\u0003\u001a\u00020EH\u0016J\t\u0010\u0090\u0003\u001a\u00020EH\u0016J\u0013\u0010\u0091\u0003\u001a\u00020E2\b\u0010\u0092\u0003\u001a\u00030«\u0001H\u0002J\u0013\u0010\u0093\u0003\u001a\u00020E2\b\u0010\u0092\u0003\u001a\u00030«\u0001H\u0002J\u0013\u0010\u0094\u0003\u001a\u00020z2\b\u0010é\u0002\u001a\u00030Ì\u0001H\u0002J\u0013\u0010\u0095\u0003\u001a\u00020z2\b\u0010é\u0002\u001a\u00030Ì\u0001H\u0002J\u0013\u0010\u0096\u0003\u001a\u00020z2\b\u0010ç\u0002\u001a\u00030Ì\u0001H\u0002J\u0013\u0010\u0097\u0003\u001a\u00020z2\b\u0010é\u0002\u001a\u00030Ì\u0001H\u0002J \u0010\u0098\u0003\u001a\u00030\u0098\u00012\b\u0010Ë\u0002\u001a\u00030\u0098\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0099\u0003\u0010É\u0002J\u001f\u0010\u0098\u0003\u001a\u00020E2\b\u0010\u009a\u0003\u001a\u00030\u0090\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b\u009b\u0003\u0010\u009c\u0003J)\u0010\u009d\u0003\u001a\u00020E2\b\u0010±\u0002\u001a\u00030«\u00012\b\u0010\u009e\u0003\u001a\u00030¾\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b\u009f\u0003\u0010 \u0003J\u0012\u0010\u009d\u0003\u001a\u00020E2\u0007\u0010¡\u0003\u001a\u00020zH\u0016J\t\u0010¢\u0003\u001a\u00020EH\u0016J!\u0010£\u0003\u001a\u00020E2\u0007\u0010¤\u0003\u001a\u00020`2\u0007\u0010¥\u0003\u001a\u00020zH\u0000¢\u0006\u0003\b¦\u0003J\t\u0010§\u0003\u001a\u00020EH\u0014J\t\u0010¨\u0003\u001a\u00020zH\u0016J\t\u0010©\u0003\u001a\u00020EH\u0002J\u0012\u0010ª\u0003\u001a\u00020E2\u0007\u0010«\u0003\u001a\u00020DH\u0014J\u0016\u0010¬\u0003\u001a\u0005\u0018\u00010\u00ad\u00032\b\u0010®\u0003\u001a\u00030¯\u0003H\u0016J0\u0010°\u0003\u001a\u00020E2\b\u0010±\u0003\u001a\u00030²\u00032\b\u0010³\u0003\u001a\u00030\u0093\u00022\u0011\u0010´\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010¶\u00030µ\u0003H\u0017J\u0013\u0010·\u0003\u001a\u00020E2\b\u0010\u0092\u0003\u001a\u00030«\u0001H\u0016J\t\u0010¸\u0003\u001a\u00020EH\u0014J\u0013\u0010¹\u0003\u001a\u00020E2\b\u0010Ý\u0002\u001a\u00030å\u0002H\u0014J\t\u0010º\u0003\u001a\u00020EH\u0016J\f\u0010»\u0003\u001a\u0005\u0018\u00010¼\u0003H\u0002J'\u0010½\u0003\u001a\u00020E2\u0007\u0010¾\u0003\u001a\u00020z2\u0007\u0010Î\u0002\u001a\u00020V2\n\u0010¿\u0003\u001a\u0005\u0018\u00010\u0086\u0003H\u0014J\u0018\u0010À\u0003\u001a\u00020E2\r\u0010\u0096\u0002\u001a\b0\u0097\u0002j\u0003`Á\u0003H\u0016J6\u0010Â\u0003\u001a\u00020E2\u0007\u0010Ã\u0003\u001a\u00020z2\u0007\u0010Ä\u0003\u001a\u00020V2\u0007\u0010Å\u0003\u001a\u00020V2\u0007\u0010Æ\u0003\u001a\u00020V2\u0007\u0010Ç\u0003\u001a\u00020VH\u0014J\u0013\u0010È\u0003\u001a\u00020E2\b\u0010±\u0002\u001a\u00030«\u0001H\u0016J\u0013\u0010É\u0003\u001a\u00020E2\b\u0010±\u0002\u001a\u00030«\u0001H\u0016J\u001b\u0010Ê\u0003\u001a\u00020E2\u0007\u0010Ë\u0003\u001a\u00020V2\u0007\u0010Ì\u0003\u001a\u00020VH\u0014J\u001f\u0010Í\u0003\u001a\u00020z2\b\u0010Î\u0003\u001a\u00030ÿ\u0002H\u0002ø\u0001\u0000¢\u0006\u0006\bÏ\u0003\u0010Ð\u0003J\u0013\u0010Ñ\u0003\u001a\u00020E2\b\u0010\u0092\u0003\u001a\u00030«\u0001H\u0016J\u001c\u0010Ò\u0003\u001a\u00020E2\b\u0010±\u0002\u001a\u00030«\u00012\u0007\u0010Ó\u0003\u001a\u00020VH\u0016J\u0013\u0010Ô\u0003\u001a\u00020E2\b\u0010\u0092\u0003\u001a\u00030«\u0001H\u0016J\u001c\u0010Õ\u0003\u001a\u00020E2\b\u0010±\u0002\u001a\u00030«\u00012\u0007\u0010Ó\u0003\u001a\u00020VH\u0016J\u001e\u0010Ö\u0003\u001a\u00020E2\n\u0010ï\u0002\u001a\u0005\u0018\u00010ð\u00022\u0007\u0010×\u0003\u001a\u00020VH\u0016J*\u0010Ø\u0003\u001a\u00020z2\n\u0010Î\u0003\u001a\u0005\u0018\u00010ÿ\u00022\n\u0010¿\u0003\u001a\u0005\u0018\u00010¼\u0003H\u0002ø\u0001\u0000¢\u0006\u0003\bÙ\u0003J.\u0010Ú\u0003\u001a\u00020E2\b\u0010±\u0002\u001a\u00030«\u00012\u0007\u0010ý\u0002\u001a\u00020z2\u0007\u0010Û\u0003\u001a\u00020z2\u0007\u0010Ü\u0003\u001a\u00020zH\u0016J%\u0010Ý\u0003\u001a\u00020E2\b\u0010±\u0002\u001a\u00030«\u00012\u0007\u0010ý\u0002\u001a\u00020z2\u0007\u0010Û\u0003\u001a\u00020zH\u0016J\u001d\u0010Þ\u0003\u001a\u00030ß\u00032\b\u0010é\u0002\u001a\u00030Ì\u00012\u0007\u0010à\u0003\u001a\u00020VH\u0017J\u0013\u0010á\u0003\u001a\u00020E2\b\u0010â\u0003\u001a\u00030ã\u0003H\u0016J\u0012\u0010ä\u0003\u001a\u00020E2\u0007\u0010£\u0001\u001a\u00020VH\u0016J.\u0010å\u0003\u001a\u00020E2\b\u0010æ\u0003\u001a\u00030\u0086\u00032\b\u0010ç\u0003\u001a\u00030è\u00032\u000f\u0010é\u0003\u001a\n\u0012\u0005\u0012\u00030ê\u00030µ\u0003H\u0016J\t\u0010ë\u0003\u001a\u00020EH\u0016J\u001c\u0010ì\u0003\u001a\u00020E2\u0011\u0010í\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010ï\u00030î\u0003H\u0017J\u0012\u0010ð\u0003\u001a\u00020E2\u0007\u0010ñ\u0003\u001a\u00020zH\u0016J+\u0010ò\u0003\u001a\u00030Ó\u00022\u0007\u0010ó\u0003\u001a\u00020V2\u0007\u0010Ç\u0003\u001a\u00020VH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bô\u0003\u0010õ\u0003J\t\u0010ö\u0003\u001a\u00020EH\u0002J\u0013\u0010ö\u0003\u001a\u00020E2\b\u0010ç\u0002\u001a\u00030Ì\u0001H\u0002J\t\u0010÷\u0003\u001a\u00020EH\u0002J\u0018\u0010ø\u0003\u001a\u00020z2\u0007\u0010¤\u0003\u001a\u00020`H\u0000¢\u0006\u0003\bù\u0003J\u0018\u0010ú\u0003\u001a\u00020E2\r\u0010û\u0003\u001a\b\u0012\u0004\u0012\u00020E0gH\u0016J\u0013\u0010ü\u0003\u001a\u00020E2\b\u0010û\u0003\u001a\u00030ý\u0003H\u0016J\u0011\u0010þ\u0003\u001a\u00020E2\b\u0010\u0096\u0002\u001a\u00030°\u0002J\u0013\u0010ÿ\u0003\u001a\u00020E2\b\u0010\u0092\u0003\u001a\u00030«\u0001H\u0016J\u0007\u0010\u0080\u0004\u001a\u00020EJ\u001e\u0010\u0081\u0004\u001a\u00020z2\u0007\u0010Î\u0002\u001a\u00020V2\n\u0010¿\u0003\u001a\u0005\u0018\u00010\u0086\u0003H\u0016J\u0013\u0010\u0082\u0004\u001a\u00020E2\b\u0010±\u0002\u001a\u00030«\u0001H\u0016J\u0017\u0010Ü\u0003\u001a\u00020E2\f\b\u0002\u0010\u0083\u0004\u001a\u0005\u0018\u00010«\u0001H\u0002J \u0010\u0084\u0004\u001a\u00030\u0098\u00012\b\u0010\u0085\u0004\u001a\u00030\u0098\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0086\u0004\u0010É\u0002J\u001f\u0010\u0087\u0004\u001a\u00020z2\b\u0010\u0080\u0003\u001a\u00030\u0081\u0003H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0088\u0004\u0010\u0089\u0004J#\u0010\u008a\u0004\u001a\u00030\u0089\u00032\b\u0010ç\u0002\u001a\u00030Ì\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008b\u0004\u0010\u008b\u0003J1\u0010\u008c\u0004\u001a\u00020E2\b\u0010ç\u0002\u001a\u00030Ì\u00012\u0007\u0010\u008d\u0004\u001a\u00020V2\b\u0010\u008e\u0004\u001a\u00030\u009a\u00012\t\b\u0002\u0010\u008f\u0004\u001a\u00020zH\u0002J\u0013\u0010\u0090\u0004\u001a\u00020E2\b\u0010\u0091\u0004\u001a\u00030\u009a\u0001H\u0016J\u001c\u0010\u0092\u0004\u001a\u00020E2\u0013\u0010\u0093\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020E0CJ\t\u0010\u0094\u0004\u001a\u00020zH\u0016JE\u0010\u0095\u0004\u001a\u00020z2\b\u0010\u0096\u0004\u001a\u00030\u0097\u00042\b\u0010\u0098\u0004\u001a\u00030\u0099\u00042\u001a\u0010\u009a\u0004\u001a\u0015\u0012\u0005\u0012\u00030\u009b\u0004\u0012\u0004\u0012\u00020E0C¢\u0006\u0003\b\u009c\u0004H\u0002ø\u0001\u0000¢\u0006\u0006\b\u009d\u0004\u0010\u009e\u0004JA\u0010\u009f\u0004\u001a\u00030 \u00042.\u0010¡\u0004\u001a)\b\u0001\u0012\u0005\u0012\u00030¢\u0004\u0012\f\u0012\n\u0012\u0005\u0012\u00030 \u00040£\u0004\u0012\u0007\u0012\u0005\u0018\u00010¤\u00040Ù\u0002¢\u0006\u0003\b\u009c\u0004H\u0096@¢\u0006\u0003\u0010¥\u0004J\t\u0010¦\u0004\u001a\u00020EH\u0002J\t\u0010§\u0004\u001a\u00020EH\u0002J\u000e\u0010¨\u0004\u001a\u00020z*\u00030«\u0001H\u0002J\u001b\u0010©\u0004\u001a\u00020V*\u00030Ó\u0002H\u0082\nø\u0001\u0000¢\u0006\u0006\bª\u0004\u0010«\u0004J\u001b\u0010¬\u0004\u001a\u00020V*\u00030Ó\u0002H\u0082\nø\u0001\u0000¢\u0006\u0006\b\u00ad\u0004\u0010«\u0004R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010'\u001a\u0004\u0018\u00010(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010+\u001a\u0004\u0018\u00010,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u000200X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u000209X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020=X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010B\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020E0CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020KX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010\b\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u000e\u0010U\u001a\u00020VX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010X\u001a\u00020W2\u0006\u0010\u0015\u001a\u00020W8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b]\u0010\u001d\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0014\u0010^\u001a\b\u0012\u0004\u0012\u00020`0_X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010a\u001a\u00020bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u001c\u0010e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020E\u0018\u00010g0fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010h\u001a\u00020iX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR+\u0010m\u001a\u00020l2\u0006\u0010\u0015\u001a\u00020l8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\br\u0010\u001d\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001c\u0010s\u001a\u00020t8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bu\u0010v\u001a\u0004\bw\u0010xR\u000e\u0010y\u001a\u00020zX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020|X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010}\u001a\u00020~X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u007fR\u0018\u0010\u0080\u0001\u001a\u00030\u0081\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0084\u0001\u001a\u00030\u0085\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0017\u0010\u0088\u0001\u001a\u00020z8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u000f\u0010\u008b\u0001\u001a\u00020zX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u008c\u0001\u001a\u00030\u008d\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u000f\u0010\u0090\u0001\u001a\u00020zX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0091\u0001\u001a\u00020z8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u008a\u0001R\u000f\u0010\u0092\u0001\u001a\u00020zX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u00020zX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0094\u0001\u001a\u00030\u0095\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0096\u0001\u001a\u00020zX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0097\u0001\u001a\u00030\u0098\u0001X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u007fR+\u0010\u0099\u0001\u001a\u00030\u009a\u00018\u0000@\u0000X\u0081\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b\u009b\u0001\u0010v\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0016\u0010 \u0001\u001a\t\u0012\u0004\u0012\u00020`0¡\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R3\u0010£\u0001\u001a\u00030¢\u00012\u0007\u0010\u0015\u001a\u00030¢\u00018V@RX\u0096\u008e\u0002¢\u0006\u0017\n\u0005\b¨\u0001\u0010\u001d\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R\u001f\u0010©\u0001\u001a\n\u0012\u0005\u0012\u00030«\u00010ª\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R\u0010\u0010®\u0001\u001a\u00030¯\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010°\u0001\u001a\u00030±\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010²\u0001\u001a\u00030³\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010´\u0001\u001a\u00030\u009a\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bµ\u0001\u0010\u009d\u0001R\u0018\u0010¶\u0001\u001a\u00030·\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b¸\u0001\u0010¹\u0001R\u0010\u0010º\u0001\u001a\u00030»\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010¼\u0001\u001a\u00020zX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010½\u0001\u001a\u0005\u0018\u00010¾\u0001X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u001d\u0010¿\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020E\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010À\u0001\u001a\u00030Á\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u0018\u0010Ä\u0001\u001a\u00030Å\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u0010\u0010È\u0001\u001a\u00030É\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010Ê\u0001\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Í\u0001\u001a\u00020zX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010Î\u0001\u001a\u00030Ï\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÐ\u0001\u0010Ñ\u0001R\u0010\u0010Ò\u0001\u001a\u00030\u009a\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010Ó\u0001\u001a\b\u0012\u0004\u0012\u00020E0gX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010Ô\u0001\u001a\u00030Õ\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010Ö\u0001R\u0018\u0010×\u0001\u001a\u00030«\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bØ\u0001\u0010Ù\u0001R\u0018\u0010Ú\u0001\u001a\u00030Û\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÜ\u0001\u0010Ý\u0001R\u0010\u0010Þ\u0001\u001a\u00030ß\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010à\u0001\u001a\u00030\u0095\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010á\u0001\u001a\u0005\u0018\u00010â\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010ã\u0001\u001a\u00020z8@X\u0080\u0004¢\u0006\b\u001a\u0006\bä\u0001\u0010\u008a\u0001R\u0010\u0010å\u0001\u001a\u00030æ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010ç\u0001\u001a\u00030è\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010é\u0001\u001a\u00030ê\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bë\u0001\u0010ì\u0001R\u0010\u0010í\u0001\u001a\u00030î\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010ï\u0001\u001a\u00020VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010ð\u0001\u001a\u00030ñ\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bò\u0001\u0010ó\u0001R&\u0010ô\u0001\u001a\u00020zX\u0096\u000e¢\u0006\u0019\n\u0000\u0012\u0005\bõ\u0001\u0010v\u001a\u0006\bö\u0001\u0010\u008a\u0001\"\u0006\b÷\u0001\u0010ø\u0001R\u0018\u0010ù\u0001\u001a\u00030ú\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bû\u0001\u0010ü\u0001R\u0018\u0010ý\u0001\u001a\u00030þ\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÿ\u0001\u0010\u0080\u0002R\u000f\u0010\u0081\u0002\u001a\u00020zX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0082\u0002\u001a\u00030\u0083\u00028\u0016X\u0097\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u0084\u0002\u0010v\u001a\u0006\b\u0085\u0002\u0010\u0086\u0002R \u0010\u0087\u0002\u001a\n\u0012\u0005\u0012\u00030\u0089\u00020\u0088\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010\u008a\u0002R\u0018\u0010\u008b\u0002\u001a\u00030\u008c\u0002X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008d\u0002\u0010\u008e\u0002R\u0019\u0010\u008f\u0002\u001a\u00030\u0090\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010\u0091\u0002R\u0010\u0010\u0092\u0002\u001a\u00030\u0093\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0094\u0002\u001a\u00030\u0095\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0096\u0002\u001a\u00030\u0097\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0098\u0002\u0010\u0099\u0002R\u0018\u0010\u009a\u0002\u001a\u00030\u009b\u0002X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u009c\u0002\u0010\u009d\u0002R\u0012\u0010\u009e\u0002\u001a\u0005\u0018\u00010\u009f\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010 \u0002\u001a\u00030\u0090\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010\u0091\u0002R!\u0010¡\u0002\u001a\u0004\u0018\u00010\u00168FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b£\u0002\u0010¤\u0002\u001a\u0005\b¢\u0002\u0010\u0019R\u000f\u0010¥\u0002\u001a\u00020zX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010¦\u0002\u001a\u00030§\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b¨\u0002\u0010©\u0002R\u0018\u0010ª\u0002\u001a\u00030\u0098\u0001X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u007fR\u0019\u0010«\u0002\u001a\u00030\u0090\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010\u0091\u0002R\u001b\u0010¬\u0002\u001a\u00020V*\u00020D8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u00ad\u0002\u0010®\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006°\u0004"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/MatrixPositionCalculator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_autofillManager", "Landroidx/compose/ui/autofill/AndroidAutofillManager;", "get_autofillManager$ui_release", "()Landroidx/compose/ui/autofill/AndroidAutofillManager;", "_inputModeManager", "Landroidx/compose/ui/input/InputModeManagerImpl;", "<set-?>", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "_viewTreeOwners", "get_viewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "set_viewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "_viewTreeOwners$delegate", "Landroidx/compose/runtime/MutableState;", "_windowInfo", "Landroidx/compose/ui/platform/LazyWindowInfo;", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "androidViewsHandler", "getAndroidViewsHandler$ui_release", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillManager", "Landroidx/compose/ui/autofill/AutofillManager;", "getAutofillManager", "()Landroidx/compose/ui/autofill/AutofillManager;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "bringIntoViewNode", "androidx/compose/ui/platform/AndroidComposeView$bringIntoViewNode$1", "Landroidx/compose/ui/platform/AndroidComposeView$bringIntoViewNode$1;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipboard", "Landroidx/compose/ui/platform/AndroidClipboard;", "getClipboard", "()Landroidx/compose/ui/platform/AndroidClipboard;", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "composeAccessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "configurationChangeObserver", "Lkotlin/Function1;", "Landroid/content/res/Configuration;", "", "getConfigurationChangeObserver", "()Lkotlin/jvm/functions/Function1;", "setConfigurationChangeObserver", "(Lkotlin/jvm/functions/Function1;)V", "contentCaptureManager", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "getContentCaptureManager$ui_release", "()Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "setContentCaptureManager$ui_release", "(Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;)V", "value", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "setCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;)V", "currentFontWeightAdjustment", "", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "dirtyLayers", "", "Landroidx/compose/ui/node/OwnedLayer;", "dragAndDropManager", "Landroidx/compose/ui/draganddrop/AndroidDragAndDropManager;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/AndroidDragAndDropManager;", "endApplyChangesListeners", "Landroidx/collection/MutableObjectList;", "Lkotlin/Function0;", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "getFocusOwner", "()Landroidx/compose/ui/focus/FocusOwner;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontFamilyResolver$delegate", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "()V", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "forceUseMatrixCache", "", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "hoverExitReceived", "inputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "isDrawingContent", "isLifecycleInResumedState", "isPendingInteropViewLayoutChangeDispatch", "isRenderNodeCompatible", "keyInputModifier", "Landroidx/compose/ui/Modifier;", "keyboardModifiersRequireUpdate", "lastDownPointerPosition", "Landroidx/compose/ui/geometry/Offset;", "lastMatrixRecalculationAnimationTime", "", "getLastMatrixRecalculationAnimationTime$ui_release$annotations", "getLastMatrixRecalculationAnimationTime$ui_release", "()J", "setLastMatrixRecalculationAnimationTime$ui_release", "(J)V", "layerCache", "Landroidx/compose/ui/platform/WeakCache;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "layoutNodes", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNodes", "()Landroidx/collection/MutableIntObjectMap;", "legacyTextInputServiceAndroid", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "matrixToWindow", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureIteration", "getMeasureIteration", "modifierLocalManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "observationClearRequested", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "onViewTreeOwnersAvailable", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "postponedDirtyLayers", "previousMotionEvent", "Landroid/view/MotionEvent;", "processingRequestFocusForNextNonChildView", "rectManager", "Landroidx/compose/ui/spatial/RectManager;", "getRectManager", "()Landroidx/compose/ui/spatial/RectManager;", "relayoutTime", "resendMotionEventOnLayout", "resendMotionEventRunnable", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "root", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "rootSemanticsNode", "Landroidx/compose/ui/semantics/EmptySemanticsModifier;", "rotaryInputModifier", "scrollCapture", "Landroidx/compose/ui/scrollcapture/ScrollCapture;", "scrollCaptureInProgress", "getScrollCaptureInProgress$ui_release", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "semanticsModifier", "Landroidx/compose/ui/semantics/EmptySemanticsElement;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "sendHoverExitEvent", "Ljava/lang/Runnable;", "sensitiveComponentCount", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "softwareKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getSoftwareKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "superclassInitComplete", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService$annotations", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textInputSessionMutex", "Landroidx/compose/ui/SessionMutex;", "Landroidx/compose/ui/platform/AndroidPlatformTextInputSession;", "Ljava/util/concurrent/atomic/AtomicReference;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "tmpPositionArray", "", "touchModeChangeListener", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "viewToWindowMatrix", "viewTreeOwners", "getViewTreeOwners", "viewTreeOwners$delegate", "Landroidx/compose/runtime/State;", "wasMeasuredWithMultipleConstraints", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "windowPosition", "windowToViewMatrix", "fontWeightAdjustmentCompat", "getFontWeightAdjustmentCompat", "(Landroid/content/res/Configuration;)I", "addAndroidView", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "layoutNode", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "addView", "child", "params", "Landroid/view/ViewGroup$LayoutParams;", FirebaseAnalytics.Param.INDEX, "width", "height", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "autofillSupported", "boundsUpdatesAccessibilityEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boundsUpdatesContentCaptureEventLoop", "calculateLocalPosition", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "(J)J", "calculatePositionInWindow", "localPosition", "calculatePositionInWindow-MK-Hz9U", "canScrollHorizontally", "direction", "canScrollVertically", "clearChildInvalidObservations", "viewGroup", "convertMeasureSpec", "Lkotlin/ULong;", "measureSpec", "convertMeasureSpec-I7RO_PI", "(I)J", "createLayer", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "invalidateParentLayer", "explicitLayer", "forceUseOldLayers", "decrementSensitiveComponentCount", "dispatchDraw", "Landroid/graphics/Canvas;", "dispatchGenericMotionEvent", "motionEvent", "dispatchHoverEvent", NotificationCompat.CATEGORY_EVENT, "dispatchKeyEvent", "Landroid/view/KeyEvent;", "dispatchKeyEventPreIme", "dispatchPendingInteropLayoutCallbacks", "dispatchProvideStructure", "structure", "Landroid/view/ViewStructure;", "dispatchTouchEvent", "drawAndroidView", "findNextNonChildView", "findViewByAccessibilityIdRootedAtCurrentView", "accessibilityId", "currentView", "findViewByAccessibilityIdTraversal", "focusSearch", "focused", "forceAccessibilityForTesting", "enable", "forceMeasureTheSubtree", "affectsLookahead", "getFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "getFocusedRect", "rect", "Landroid/graphics/Rect;", "getImportantForAutofill", "handleMotionEvent", "Landroidx/compose/ui/input/pointer/ProcessResult;", "handleMotionEvent-8iAsVTc", "(Landroid/view/MotionEvent;)I", "handleRotaryEvent", "hasChangedDevices", "lastEvent", "incrementSensitiveComponentCount", "invalidateDescendants", "invalidateLayers", "node", "invalidateLayoutNodeMeasurement", "isBadMotionEvent", "isDevicePressEvent", "isInBounds", "isPositionChanged", "localToScreen", "localToScreen-MK-Hz9U", "localTransform", "localToScreen-58bKbWc", "([F)V", "measureAndLayout", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "sendPointerUpdate", "measureAndLayoutForTest", "notifyLayerIsDirty", "layer", "isDirty", "notifyLayerIsDirty$ui_release", "onAttachedToWindow", "onCheckIsTextEditor", "onClearFocusForOwner", "onConfigurationChanged", "newConfig", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onDetach", "onDetachedFromWindow", "onDraw", "onEndApplyChanges", "onFetchFocusRect", "Landroidx/compose/ui/geometry/Rect;", "onFocusChanged", "gainFocus", "previouslyFocusedRect", "onInteropViewLayoutChange", "Landroidx/compose/ui/viewinterop/InteropView;", "onLayout", "changed", "l", "t", "r", "b", "onLayoutChange", "onLayoutNodeDeactivated", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onMoveFocusInChildren", "focusDirection", "onMoveFocusInChildren-3ESFkO8", "(I)Z", "onPostAttach", "onPostLayoutNodeReused", "oldSemanticsId", "onPreAttach", "onPreLayoutNodeReused", "onProvideAutofillVirtualStructure", "flags", "onRequestFocusForOwner", "onRequestFocusForOwner-7o62pno", "onRequestMeasure", "forceRequest", "scheduleMeasureAndLayout", "onRequestRelayout", "onResolvePointerIcon", "Landroid/view/PointerIcon;", "pointerIndex", "onResume", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onRtlPropertiesChanged", "onScrollCaptureSearch", "localVisibleRect", "windowOffset", "Landroid/graphics/Point;", "targets", "Landroid/view/ScrollCaptureTarget;", "onSemanticsChange", "onVirtualViewTranslationResponses", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onWindowFocusChanged", "hasWindowFocus", "pack", "a", "pack-ZIaKswc", "(II)J", "recalculateWindowPosition", "recalculateWindowViewTransforms", "recycle", "recycle$ui_release", "registerOnEndApplyChangesListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "registerOnLayoutCompletedListener", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "removeAndroidView", "requestAutofill", "requestClearInvalidObservations", "requestFocus", "requestOnPositionedCallback", "nodeToRemeasure", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "sendKeyEvent", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendMotionEvent", "sendMotionEvent-8iAsVTc", "sendSimulatedEvent", "action", "eventTime", "forceHover", "setAccessibilityEventBatchIntervalMillis", "intervalMillis", "setOnViewTreeOwnersAvailable", "callback", "shouldDelayChildPressedState", "startDrag", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "startDrag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", "textInputSession", "", CacheStore.SESSION, "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePositionCacheAndDispatch", "updateWindowMetrics", "childSizeCanAffectParentSize", "component1", "component1-VKZWuLQ", "(J)I", "component2", "component2-VKZWuLQ", "Companion", "ViewTreeOwners", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class AndroidComposeView extends ViewGroup implements Owner, ViewRootForTest, MatrixPositionCalculator, DefaultLifecycleObserver {
    private static Method getBooleanMethod;
    private static Class<?> systemPropertiesClass;
    private AndroidViewsHandler _androidViewsHandler;
    private final AndroidAutofill _autofill;
    private final AndroidAutofillManager _autofillManager;
    private final InputModeManagerImpl _inputModeManager;

    /* renamed from: _viewTreeOwners$delegate, reason: from kotlin metadata */
    private final MutableState _viewTreeOwners;
    private final LazyWindowInfo _windowInfo;
    private final AndroidAccessibilityManager accessibilityManager;
    private final AutofillTree autofillTree;
    private final AndroidComposeView$bringIntoViewNode$1 bringIntoViewNode;
    private final CanvasHolder canvasHolder;
    private final AndroidClipboard clipboard;
    private final AndroidClipboardManager clipboardManager;
    private final AndroidComposeViewAccessibilityDelegateCompat composeAccessibilityDelegate;
    private Function1<? super Configuration, Unit> configurationChangeObserver;
    private AndroidContentCaptureManager contentCaptureManager;
    private CoroutineContext coroutineContext;
    private int currentFontWeightAdjustment;

    /* renamed from: density$delegate, reason: from kotlin metadata */
    private final MutableState density;
    private final List<OwnedLayer> dirtyLayers;
    private final AndroidDragAndDropManager dragAndDropManager;
    private final MutableObjectList<Function0<Unit>> endApplyChangesListeners;
    private final FocusOwner focusOwner;

    /* renamed from: fontFamilyResolver$delegate, reason: from kotlin metadata */
    private final MutableState fontFamilyResolver;
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private long globalPosition;
    private final GraphicsContext graphicsContext;
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private boolean isDrawingContent;
    private boolean isPendingInteropViewLayoutChangeDispatch;
    private boolean isRenderNodeCompatible;
    private final Modifier keyInputModifier;
    private boolean keyboardModifiersRequireUpdate;
    private long lastDownPointerPosition;
    private long lastMatrixRecalculationAnimationTime;
    private final WeakCache<OwnedLayer> layerCache;

    /* renamed from: layoutDirection$delegate, reason: from kotlin metadata */
    private final MutableState layoutDirection;
    private final MutableIntObjectMap<LayoutNode> layoutNodes;
    private final TextInputServiceAndroid legacyTextInputServiceAndroid;
    private final CalculateMatrixToWindow matrixToWindow;
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    private final ModifierLocalManager modifierLocalManager;
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;
    private Constraints onMeasureConstraints;
    private Function1<? super ViewTreeOwners, Unit> onViewTreeOwnersAvailable;
    private final PointerIconService pointerIconService;
    private final PointerInputEventProcessor pointerInputEventProcessor;
    private List<OwnedLayer> postponedDirtyLayers;
    private MotionEvent previousMotionEvent;
    private boolean processingRequestFocusForNextNonChildView;
    private final RectManager rectManager;
    private long relayoutTime;
    private final Function0<Unit> resendMotionEventOnLayout;
    private final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;
    private final LayoutNode root;
    private final RootForTest rootForTest;
    private final EmptySemanticsModifier rootSemanticsNode;
    private final Modifier rotaryInputModifier;
    private final ScrollCapture scrollCapture;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final EmptySemanticsElement semanticsModifier;
    private final SemanticsOwner semanticsOwner;
    private final Runnable sendHoverExitEvent;
    private int sensitiveComponentCount;
    private final LayoutNodeDrawScope sharedDrawScope;
    private boolean showLayoutBounds;
    private final OwnerSnapshotObserver snapshotObserver;
    private final SoftwareKeyboardController softwareKeyboardController;
    private boolean superclassInitComplete;
    private final TextInputService textInputService;
    private final AtomicReference<SessionMutex.Session<T>> textInputSessionMutex;
    private final TextToolbar textToolbar;
    private final float[] tmpMatrix;
    private final int[] tmpPositionArray;
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;
    private final ViewConfiguration viewConfiguration;
    private DrawChildContainer viewLayersContainer;
    private final float[] viewToWindowMatrix;

    /* renamed from: viewTreeOwners$delegate, reason: from kotlin metadata */
    private final State viewTreeOwners;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;
    private final float[] windowToViewMatrix;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Deprecated(message = "fontLoader is deprecated, use fontFamilyResolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    @Deprecated(message = "Use PlatformTextInputModifierNode instead.")
    public static /* synthetic */ void getTextInputService$annotations() {
    }

    @Override // android.view.View
    public int getImportantForAutofill() {
        return 1;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15, types: [androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1] */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.compose.ui.platform.AndroidComposeView$bringIntoViewNode$1] */
    public AndroidComposeView(Context context, CoroutineContext coroutineContext) {
        super(context);
        AndroidAutofillManager androidAutofillManager;
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        this.lastDownPointerPosition = Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
        int i = 1;
        this.superclassInitComplete = true;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        this.sharedDrawScope = new LayoutNodeDrawScope(0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        this.density = SnapshotStateKt.mutableStateOf(AndroidDensity_androidKt.Density(context), SnapshotStateKt.referentialEqualityPolicy());
        EmptySemanticsModifier emptySemanticsModifier = new EmptySemanticsModifier();
        this.rootSemanticsNode = emptySemanticsModifier;
        EmptySemanticsElement emptySemanticsElement = new EmptySemanticsElement(emptySemanticsModifier);
        this.semanticsModifier = emptySemanticsElement;
        ?? r6 = new ModifierNodeElement<BringIntoViewOnScreenResponderNode>() { // from class: androidx.compose.ui.platform.AndroidComposeView$bringIntoViewNode$1
            @Override // androidx.compose.ui.node.ModifierNodeElement
            public boolean equals(Object other) {
                return other == this;
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            /* renamed from: create, reason: avoid collision after fix types in other method */
            public BringIntoViewOnScreenResponderNode getNode() {
                return new BringIntoViewOnScreenResponderNode(AndroidComposeView.this);
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public void update(BringIntoViewOnScreenResponderNode node) {
                node.setView(AndroidComposeView.this);
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public void inspectableProperties(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("BringIntoViewOnScreen");
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public int hashCode() {
                return AndroidComposeView.this.hashCode();
            }
        };
        this.bringIntoViewNode = r6;
        this.focusOwner = new FocusOwnerImpl(new AndroidComposeView$focusOwner$1(this), new AndroidComposeView$focusOwner$2(this), new AndroidComposeView$focusOwner$3(this), new AndroidComposeView$focusOwner$4(this), new AndroidComposeView$focusOwner$5(this), new MutablePropertyReference0Impl(this) { // from class: androidx.compose.ui.platform.AndroidComposeView$focusOwner$6
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((AndroidComposeView) this.receiver).getLayoutDirection();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((AndroidComposeView) this.receiver).setLayoutDirection((LayoutDirection) obj);
            }
        });
        this.coroutineContext = coroutineContext;
        this.dragAndDropManager = new AndroidDragAndDropManager(new AndroidComposeView$dragAndDropManager$1(this));
        this._windowInfo = new LazyWindowInfo();
        Modifier onKeyEvent = KeyInputModifierKt.onKeyEvent(Modifier.INSTANCE, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m6108invokeZmokQxo(keyEvent.m5452unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m6108invokeZmokQxo(android.view.KeyEvent keyEvent) {
                Rect onFetchFocusRect;
                View findNextNonChildView;
                int[] iArr;
                int[] iArr2;
                int[] iArr3;
                int[] iArr4;
                int[] iArr5;
                int[] iArr6;
                boolean m6099onMoveFocusInChildren3ESFkO8;
                final FocusDirection mo6054getFocusDirectionP8AzH3I = AndroidComposeView.this.mo6054getFocusDirectionP8AzH3I(keyEvent);
                if (mo6054getFocusDirectionP8AzH3I == null || !KeyEventType.m5456equalsimpl0(KeyEvent_androidKt.m5464getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m5460getKeyDownCS__XNY())) {
                    return false;
                }
                Integer m4021toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m4021toAndroidFocusDirection3ESFkO8(mo6054getFocusDirectionP8AzH3I.getValue());
                if (ComposeUiFlags.isViewFocusFixEnabled && AndroidComposeView.this.hasFocus() && m4021toAndroidFocusDirection3ESFkO8 != null) {
                    m6099onMoveFocusInChildren3ESFkO8 = AndroidComposeView.this.m6099onMoveFocusInChildren3ESFkO8(mo6054getFocusDirectionP8AzH3I.getValue());
                    if (m6099onMoveFocusInChildren3ESFkO8) {
                        return true;
                    }
                }
                onFetchFocusRect = AndroidComposeView.this.onFetchFocusRect();
                Boolean mo4027focusSearchULY8qGw = AndroidComposeView.this.getFocusOwner().mo4027focusSearchULY8qGw(mo6054getFocusDirectionP8AzH3I.getValue(), onFetchFocusRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1$focusWasMovedOrCancelled$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(FocusTargetNode focusTargetNode) {
                        return Boolean.valueOf(focusTargetNode.mo4040requestFocus3ESFkO8(FocusDirection.this.getValue()));
                    }
                });
                if (mo4027focusSearchULY8qGw != null ? mo4027focusSearchULY8qGw.booleanValue() : true) {
                    return true;
                }
                if (!FocusOwnerImplKt.m4033is1dFocusSearch3ESFkO8(mo6054getFocusDirectionP8AzH3I.getValue())) {
                    return false;
                }
                if (m4021toAndroidFocusDirection3ESFkO8 != null) {
                    findNextNonChildView = AndroidComposeView.this.findNextNonChildView(m4021toAndroidFocusDirection3ESFkO8.intValue());
                    if (Intrinsics.areEqual(findNextNonChildView, AndroidComposeView.this)) {
                        findNextNonChildView = null;
                    }
                    if (findNextNonChildView != null) {
                        android.graphics.Rect androidRect = onFetchFocusRect != null ? RectHelper_androidKt.toAndroidRect(onFetchFocusRect) : null;
                        if (androidRect != null) {
                            iArr = AndroidComposeView.this.tmpPositionArray;
                            findNextNonChildView.getLocationInWindow(iArr);
                            iArr2 = AndroidComposeView.this.tmpPositionArray;
                            int i2 = iArr2[0];
                            iArr3 = AndroidComposeView.this.tmpPositionArray;
                            int i3 = iArr3[1];
                            AndroidComposeView androidComposeView = AndroidComposeView.this;
                            iArr4 = androidComposeView.tmpPositionArray;
                            androidComposeView.getLocationInWindow(iArr4);
                            iArr5 = AndroidComposeView.this.tmpPositionArray;
                            int i4 = iArr5[0];
                            iArr6 = AndroidComposeView.this.tmpPositionArray;
                            androidRect.offset(i4 - i2, iArr6[1] - i3);
                            if (FocusInteropUtils_androidKt.requestInteropFocus(findNextNonChildView, m4021toAndroidFocusDirection3ESFkO8, androidRect)) {
                                return true;
                            }
                        } else {
                            throw new IllegalStateException("Invalid rect".toString());
                        }
                    }
                }
                if (!AndroidComposeView.this.getFocusOwner().mo4024clearFocusI7lrPNg(false, true, false, mo6054getFocusDirectionP8AzH3I.getValue())) {
                    return true;
                }
                Boolean mo4027focusSearchULY8qGw2 = AndroidComposeView.this.getFocusOwner().mo4027focusSearchULY8qGw(mo6054getFocusDirectionP8AzH3I.getValue(), null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(FocusTargetNode focusTargetNode) {
                        return Boolean.valueOf(focusTargetNode.mo4040requestFocus3ESFkO8(FocusDirection.this.getValue()));
                    }
                });
                return Boolean.valueOf(mo4027focusSearchULY8qGw2 != null ? mo4027focusSearchULY8qGw2.booleanValue() : true);
            }
        });
        this.keyInputModifier = onKeyEvent;
        Modifier onRotaryScrollEvent = RotaryInputModifierKt.onRotaryScrollEvent(Modifier.INSTANCE, new Function1<RotaryScrollEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$rotaryInputModifier$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(RotaryScrollEvent rotaryScrollEvent) {
                return false;
            }
        });
        this.rotaryInputModifier = onRotaryScrollEvent;
        this.canvasHolder = new CanvasHolder();
        this.viewConfiguration = new AndroidViewConfiguration(android.view.ViewConfiguration.get(context));
        Object[] objArr4 = 0;
        LayoutNode layoutNode = new LayoutNode(false, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setDensity(getDensity());
        layoutNode.setViewConfiguration(getViewConfiguration());
        layoutNode.setModifier(Modifier.INSTANCE.then(emptySemanticsElement).then(onRotaryScrollEvent).then(onKeyEvent).then(getFocusOwner().getModifier()).then(getDragAndDropManager().getModifier()).then((Modifier) r6));
        this.root = layoutNode;
        this.layoutNodes = IntObjectMapKt.mutableIntObjectMapOf();
        this.rectManager = new RectManager(getLayoutNodes());
        this.rootForTest = this;
        this.semanticsOwner = new SemanticsOwner(getRoot(), emptySemanticsModifier, getLayoutNodes());
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.composeAccessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        this.contentCaptureManager = new AndroidContentCaptureManager(this, new AndroidComposeView$contentCaptureManager$1(this));
        this.accessibilityManager = new AndroidAccessibilityManager(context);
        this.graphicsContext = AndroidGraphicsContext_androidKt.GraphicsContext(this);
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configurationChangeObserver = new Function1<Configuration, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$configurationChangeObserver$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Configuration configuration) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Configuration configuration) {
                invoke2(configuration);
                return Unit.INSTANCE;
            }
        };
        this._autofill = autofillSupported() ? new AndroidAutofill(this, getAutofillTree()) : null;
        if (autofillSupported()) {
            AutofillManager m3011m = Listener$$ExternalSyntheticApiModelOutline0.m3011m(context.getSystemService(Listener$$ExternalSyntheticApiModelOutline0.m3024m()));
            if (m3011m != null) {
                androidAutofillManager = new AndroidAutofillManager(new PlatformAutofillManagerImpl(m3011m), getSemanticsOwner(), this, getRectManager(), context.getPackageName());
            } else {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Autofill service could not be located.");
                throw new KotlinNothingValueException();
            }
        } else {
            androidAutofillManager = null;
        }
        this._autofillManager = androidAutofillManager;
        this.clipboardManager = new AndroidClipboardManager(context);
        this.clipboard = new AndroidClipboard(getClipboardManager());
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        this.globalPosition = IntOffset.m7111constructorimpl(9223372034707292159L);
        this.tmpPositionArray = new int[]{0, 0};
        float[] m4614constructorimpl$default = Matrix.m4614constructorimpl$default(null, 1, null);
        this.tmpMatrix = m4614constructorimpl$default;
        this.viewToWindowMatrix = Matrix.m4614constructorimpl$default(null, 1, null);
        this.windowToViewMatrix = Matrix.m4614constructorimpl$default(null, 1, null);
        this.lastMatrixRecalculationAnimationTime = -1L;
        this.windowPosition = Offset.INSTANCE.m4139getInfiniteF1C5BW0();
        this.isRenderNodeCompatible = true;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this._viewTreeOwners = mutableStateOf$default;
        this.viewTreeOwners = SnapshotStateKt.derivedStateOf(new Function0<ViewTreeOwners>() { // from class: androidx.compose.ui.platform.AndroidComposeView$viewTreeOwners$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AndroidComposeView.ViewTreeOwners invoke() {
                AndroidComposeView.ViewTreeOwners viewTreeOwners;
                viewTreeOwners = AndroidComposeView.this.get_viewTreeOwners();
                return viewTreeOwners;
            }
        });
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                AndroidComposeView.this.updatePositionCacheAndDispatch();
            }
        };
        this.scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                AndroidComposeView.this.updatePositionCacheAndDispatch();
            }
        };
        this.touchModeChangeListener = new ViewTreeObserver.OnTouchModeChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda3
            @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
            public final void onTouchModeChanged(boolean z) {
                AndroidComposeView.this._inputModeManager.m5149setInputModeiuPiT84(r1 ? InputMode.INSTANCE.m5146getTouchaOaMEAU() : InputMode.INSTANCE.m5145getKeyboardaOaMEAU());
            }
        };
        TextInputServiceAndroid textInputServiceAndroid = new TextInputServiceAndroid(getView(), this);
        this.legacyTextInputServiceAndroid = textInputServiceAndroid;
        this.textInputService = new TextInputService(AndroidComposeView_androidKt.getPlatformTextInputServiceInterceptor().invoke(textInputServiceAndroid));
        this.textInputSessionMutex = SessionMutex.m3945constructorimpl();
        this.softwareKeyboardController = new DelegatingSoftwareKeyboardController(getTextInputService());
        this.fontLoader = new AndroidFontResourceLoader(context);
        this.fontFamilyResolver = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), SnapshotStateKt.referentialEqualityPolicy());
        this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(context.getResources().getConfiguration());
        LayoutDirection layoutDirection = FocusInteropUtils_androidKt.toLayoutDirection(context.getResources().getConfiguration().getLayoutDirection());
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(layoutDirection == null ? LayoutDirection.Ltr : layoutDirection, null, 2, null);
        this.layoutDirection = mutableStateOf$default2;
        AndroidComposeView androidComposeView = this;
        this.hapticFeedBack = new PlatformHapticFeedback(androidComposeView);
        this._inputModeManager = new InputModeManagerImpl(isInTouchMode() ? InputMode.INSTANCE.m5146getTouchaOaMEAU() : InputMode.INSTANCE.m5145getKeyboardaOaMEAU(), new Function1<InputMode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$_inputModeManager$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(InputMode inputMode) {
                return m6104invokeiuPiT84(inputMode.getValue());
            }

            /* renamed from: invoke-iuPiT84, reason: not valid java name */
            public final Boolean m6104invokeiuPiT84(int i2) {
                boolean requestFocusFromTouch;
                if (InputMode.m5141equalsimpl0(i2, InputMode.INSTANCE.m5146getTouchaOaMEAU())) {
                    requestFocusFromTouch = AndroidComposeView.this.isInTouchMode();
                } else {
                    requestFocusFromTouch = InputMode.m5141equalsimpl0(i2, InputMode.INSTANCE.m5145getKeyboardaOaMEAU()) ? AndroidComposeView.this.isInTouchMode() ? AndroidComposeView.this.requestFocusFromTouch() : true : false;
                }
                return Boolean.valueOf(requestFocusFromTouch);
            }
        }, objArr3 == true ? 1 : 0);
        AndroidComposeView androidComposeView2 = this;
        this.modifierLocalManager = new ModifierLocalManager(androidComposeView2);
        this.textToolbar = new AndroidTextToolbar(androidComposeView);
        this.layerCache = new WeakCache<>();
        this.endApplyChangesListeners = new MutableObjectList<>(objArr4 == true ? 1 : 0, i, objArr2 == true ? 1 : 0);
        this.resendMotionEventRunnable = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                MotionEvent motionEvent;
                long j;
                AndroidComposeView.this.removeCallbacks(this);
                motionEvent = AndroidComposeView.this.previousMotionEvent;
                if (motionEvent != null) {
                    boolean z = motionEvent.getToolType(0) == 3;
                    int actionMasked = motionEvent.getActionMasked();
                    if (z) {
                        if (actionMasked == 10 || actionMasked == 1) {
                            return;
                        }
                    } else if (actionMasked == 1) {
                        return;
                    }
                    int i2 = 7;
                    if (actionMasked != 7 && actionMasked != 9) {
                        i2 = 2;
                    }
                    AndroidComposeView androidComposeView3 = AndroidComposeView.this;
                    j = androidComposeView3.relayoutTime;
                    androidComposeView3.sendSimulatedEvent(motionEvent, i2, j, false);
                }
            }
        };
        this.sendHoverExitEvent = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeView.sendHoverExitEvent$lambda$10(AndroidComposeView.this);
            }
        };
        this.resendMotionEventOnLayout = new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventOnLayout$1
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
                MotionEvent motionEvent;
                AndroidComposeView$resendMotionEventRunnable$1 androidComposeView$resendMotionEventRunnable$1;
                motionEvent = AndroidComposeView.this.previousMotionEvent;
                if (motionEvent != null) {
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked == 7 || actionMasked == 9) {
                        AndroidComposeView.this.relayoutTime = SystemClock.uptimeMillis();
                        AndroidComposeView androidComposeView3 = AndroidComposeView.this;
                        androidComposeView$resendMotionEventRunnable$1 = androidComposeView3.resendMotionEventRunnable;
                        androidComposeView3.post(androidComposeView$resendMotionEventRunnable$1);
                    }
                }
            }
        };
        this.matrixToWindow = Build.VERSION.SDK_INT < 29 ? new CalculateMatrixToWindowApi21(m4614constructorimpl$default, objArr == true ? 1 : 0) : new CalculateMatrixToWindowApi29();
        addOnAttachStateChangeListener(this.contentCaptureManager);
        setWillNotDraw(false);
        setFocusable(true);
        if (Build.VERSION.SDK_INT >= 26) {
            AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(androidComposeView, 1, false);
        }
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(androidComposeView, androidComposeViewAccessibilityDelegateCompat);
        Function1<ViewRootForTest, Unit> onViewCreatedCallback = ViewRootForTest.INSTANCE.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        setOnDragListener(getDragAndDropManager());
        getRoot().attach$ui_release(androidComposeView2);
        if (Build.VERSION.SDK_INT >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(androidComposeView);
        }
        this.scrollCapture = Build.VERSION.SDK_INT >= 31 ? new ScrollCapture() : null;
        this.pointerIconService = new PointerIconService() { // from class: androidx.compose.ui.platform.AndroidComposeView$pointerIconService$1
            private PointerIcon currentMouseCursorIcon = PointerIcon.INSTANCE.getDefault();
            private PointerIcon currentStylusHoverIcon;

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            /* renamed from: getIcon, reason: from getter */
            public PointerIcon getCurrentMouseCursorIcon() {
                return this.currentMouseCursorIcon;
            }

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            public void setIcon(PointerIcon value) {
                if (value == null) {
                    value = PointerIcon.INSTANCE.getDefault();
                }
                this.currentMouseCursorIcon = value;
                AndroidComposeViewVerificationHelperMethodsN.INSTANCE.setPointerIcon(AndroidComposeView.this, this.currentMouseCursorIcon);
            }

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            /* renamed from: getStylusHoverIcon, reason: from getter */
            public PointerIcon getCurrentStylusHoverIcon() {
                return this.currentStylusHoverIcon;
            }

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            public void setStylusHoverIcon(PointerIcon value) {
                this.currentStylusHoverIcon = value;
            }
        };
    }

    @Override // androidx.compose.ui.node.Owner
    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public View getView() {
        return this;
    }

    private void setDensity(Density density) {
        this.density.setValue(density);
    }

    @Override // androidx.compose.ui.node.Owner, androidx.compose.ui.node.RootForTest
    public Density getDensity() {
        return (Density) this.density.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    @Override // androidx.compose.ui.node.Owner
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public void setCoroutineContext(CoroutineContext coroutineContext) {
        this.coroutineContext = coroutineContext;
        DelegatableNode head = getRoot().getNodes().getHead();
        if (head instanceof SuspendingPointerInputModifierNode) {
            ((SuspendingPointerInputModifierNode) head).resetPointerInputHandler();
        }
        DelegatableNode delegatableNode = head;
        int m5994constructorimpl = NodeKind.m5994constructorimpl(16);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), false);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                for (Modifier.Node node2 = node; node2 != null; node2 = node2.getChild()) {
                    if ((node2.getKindSet() & m5994constructorimpl) != 0) {
                        DelegatingNode delegatingNode = node2;
                        MutableVector mutableVector2 = null;
                        while (delegatingNode != 0) {
                            if (delegatingNode instanceof PointerInputModifierNode) {
                                PointerInputModifierNode pointerInputModifierNode = (PointerInputModifierNode) delegatingNode;
                                if (pointerInputModifierNode instanceof SuspendingPointerInputModifierNode) {
                                    ((SuspendingPointerInputModifierNode) pointerInputModifierNode).resetPointerInputHandler();
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
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNode != 0) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegatingNode);
                                                }
                                                delegatingNode = 0;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    delegatingNode = delegatingNode;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNode = DelegatableNodeKt.access$pop(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node, false);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidDragAndDropManager getDragAndDropManager() {
        return this.dragAndDropManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onMoveFocusInChildren-3ESFkO8, reason: not valid java name */
    public final boolean m6099onMoveFocusInChildren3ESFkO8(int focusDirection) {
        AndroidViewsHandler androidViewsHandler;
        View view;
        View findNextFocusFromRect;
        if (!ComposeUiFlags.isViewFocusFixEnabled) {
            if (FocusDirection.m4009equalsimpl0(focusDirection, FocusDirection.INSTANCE.m4014getEnterdhqQ8s()) || FocusDirection.m4009equalsimpl0(focusDirection, FocusDirection.INSTANCE.m4015getExitdhqQ8s())) {
                return false;
            }
            Integer m4021toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m4021toAndroidFocusDirection3ESFkO8(focusDirection);
            if (m4021toAndroidFocusDirection3ESFkO8 == null) {
                throw new IllegalStateException("Invalid focus direction".toString());
            }
            int intValue = m4021toAndroidFocusDirection3ESFkO8.intValue();
            Rect onFetchFocusRect = onFetchFocusRect();
            r2 = onFetchFocusRect != null ? RectHelper_androidKt.toAndroidRect(onFetchFocusRect) : null;
            FocusFinder focusFinder = FocusFinder.getInstance();
            if (r2 == null) {
                findNextFocusFromRect = focusFinder.findNextFocus(this, findFocus(), intValue);
            } else {
                findNextFocusFromRect = focusFinder.findNextFocusFromRect(this, r2, intValue);
            }
            if (findNextFocusFromRect != null) {
                return FocusInteropUtils_androidKt.requestInteropFocus(findNextFocusFromRect, Integer.valueOf(intValue), r2);
            }
            return false;
        }
        if (FocusDirection.m4009equalsimpl0(focusDirection, FocusDirection.INSTANCE.m4014getEnterdhqQ8s()) || FocusDirection.m4009equalsimpl0(focusDirection, FocusDirection.INSTANCE.m4015getExitdhqQ8s()) || !hasFocus() || (androidViewsHandler = this._androidViewsHandler) == null) {
            return false;
        }
        Integer m4021toAndroidFocusDirection3ESFkO82 = FocusInteropUtils_androidKt.m4021toAndroidFocusDirection3ESFkO8(focusDirection);
        if (m4021toAndroidFocusDirection3ESFkO82 == null) {
            throw new IllegalStateException("Invalid focus direction".toString());
        }
        int intValue2 = m4021toAndroidFocusDirection3ESFkO82.intValue();
        View rootView = getRootView();
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) rootView;
        View findFocus = viewGroup.findFocus();
        if (findFocus == null) {
            throw new IllegalStateException("view hasFocus but root can't find it".toString());
        }
        FocusFinder focusFinder2 = FocusFinder.getInstance();
        if (FocusOwnerImplKt.m4033is1dFocusSearch3ESFkO8(focusDirection) && androidViewsHandler.hasFocus()) {
            if (Build.VERSION.SDK_INT >= 26) {
                view = focusFinder2.findNextFocus(viewGroup, findFocus, intValue2);
            } else {
                view = FocusFinderCompat.INSTANCE.getInstance().findNextFocus1d(viewGroup, findFocus, intValue2);
            }
        } else {
            Rect onFetchFocusRect2 = onFetchFocusRect();
            r2 = onFetchFocusRect2 != null ? RectHelper_androidKt.toAndroidRect(onFetchFocusRect2) : null;
            View findNextFocusFromRect2 = focusFinder2.findNextFocusFromRect(viewGroup, r2, intValue2);
            if (findNextFocusFromRect2 != null) {
                findNextFocusFromRect2.getLocationInWindow(this.tmpPositionArray);
            }
            int[] iArr = this.tmpPositionArray;
            int i = iArr[0];
            int i2 = iArr[1];
            getLocationInWindow(iArr);
            if (r2 != null) {
                int[] iArr2 = this.tmpPositionArray;
                r2.offset(iArr2[0] - i, iArr2[1] - i2);
            }
            view = findNextFocusFromRect2;
        }
        if (view == null || view == findFocus) {
            return false;
        }
        View focusedChild = androidViewsHandler.getFocusedChild();
        ViewParent parent = view.getParent();
        while (parent != null && parent != focusedChild) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return false;
        }
        return FocusInteropUtils_androidKt.requestInteropFocus(view, Integer.valueOf(intValue2), r2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect onFetchFocusRect() {
        if (isFocused()) {
            return getFocusOwner().getFocusRect();
        }
        View findFocus = findFocus();
        if (findFocus != null) {
            return FocusInteropUtils_androidKt.calculateBoundingRectRelativeTo(findFocus, this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View findNextNonChildView(int direction) {
        AndroidComposeView androidComposeView = this;
        FocusFinder focusFinder = FocusFinder.getInstance();
        View view = androidComposeView;
        while (view != null) {
            View rootView = getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            view = focusFinder.findNextFocus((ViewGroup) rootView, view, direction);
            if (view != null && !AndroidComposeView_androidKt.access$containsDescendant(androidComposeView, view)) {
                return view;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.node.Owner
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Override // androidx.compose.ui.node.Owner
    public LayoutNode getRoot() {
        return this.root;
    }

    @Override // androidx.compose.ui.node.Owner
    public MutableIntObjectMap<LayoutNode> getLayoutNodes() {
        return this.layoutNodes;
    }

    @Override // androidx.compose.ui.node.Owner
    public RectManager getRectManager() {
        return this.rectManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    @Override // androidx.compose.ui.node.Owner, androidx.compose.ui.node.RootForTest
    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    /* renamed from: getContentCaptureManager$ui_release, reason: from getter */
    public final AndroidContentCaptureManager getContentCaptureManager() {
        return this.contentCaptureManager;
    }

    public final void setContentCaptureManager$ui_release(AndroidContentCaptureManager androidContentCaptureManager) {
        this.contentCaptureManager = androidContentCaptureManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    @Override // androidx.compose.ui.node.Owner
    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    public final void setConfigurationChangeObserver(Function1<? super Configuration, Unit> function1) {
        this.configurationChangeObserver = function1;
    }

    /* renamed from: get_autofillManager$ui_release, reason: from getter */
    public final AndroidAutofillManager get_autofillManager() {
        return this._autofillManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public Autofill getAutofill() {
        return this._autofill;
    }

    @Override // androidx.compose.ui.node.Owner
    public androidx.compose.ui.autofill.AutofillManager getAutofillManager() {
        return this._autofillManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidClipboard getClipboard() {
        return this.clipboard;
    }

    @Override // androidx.compose.ui.node.Owner
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    @Override // androidx.compose.ui.node.Owner
    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    @Override // androidx.compose.ui.node.Owner
    public void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(getContext());
            this._androidViewsHandler = androidViewsHandler;
            addView(androidViewsHandler);
            requestLayout();
        }
        AndroidViewsHandler androidViewsHandler2 = this._androidViewsHandler;
        Intrinsics.checkNotNull(androidViewsHandler2);
        return androidViewsHandler2;
    }

    @Override // androidx.compose.ui.node.Owner
    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout();
    }

    /* renamed from: getLastMatrixRecalculationAnimationTime$ui_release, reason: from getter */
    public final long getLastMatrixRecalculationAnimationTime() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j) {
        this.lastMatrixRecalculationAnimationTime = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ViewTreeOwners get_viewTreeOwners() {
        return (ViewTreeOwners) this._viewTreeOwners.getValue();
    }

    private final void set_viewTreeOwners(ViewTreeOwners viewTreeOwners) {
        this._viewTreeOwners.setValue(viewTreeOwners);
    }

    public final ViewTreeOwners getViewTreeOwners() {
        return (ViewTreeOwners) this.viewTreeOwners.getValue();
    }

    @Override // androidx.compose.ui.node.Owner, androidx.compose.ui.node.RootForTest
    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    @Override // androidx.compose.ui.node.Owner
    public SoftwareKeyboardController getSoftwareKeyboardController() {
        return this.softwareKeyboardController;
    }

    @Override // androidx.compose.ui.node.Owner
    public Placeable.PlacementScope getPlacementScope() {
        return PlaceableKt.PlacementScope(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.ui.node.Owner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object textInputSession(kotlin.jvm.functions.Function2<? super androidx.compose.ui.platform.PlatformTextInputSessionScope, ? super kotlin.coroutines.Continuation<?>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<?> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.ui.platform.AndroidComposeView$textInputSession$1
            if (r0 == 0) goto L14
            r0 = r6
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$1 r0 = (androidx.compose.ui.platform.AndroidComposeView$textInputSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$1 r0 = new androidx.compose.ui.platform.AndroidComposeView$textInputSession$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 == r3) goto L2e
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2e:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L47
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.concurrent.atomic.AtomicReference<androidx.compose.ui.SessionMutex$Session<T>> r6 = r4.textInputSessionMutex
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$2 r2 = new androidx.compose.ui.platform.AndroidComposeView$textInputSession$2
            r2.<init>()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r0.label = r3
            java.lang.Object r4 = androidx.compose.ui.SessionMutex.m3952withSessionCancellingPreviousimpl(r6, r2, r5, r0)
            if (r4 != r1) goto L47
            return r1
        L47:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.textInputSession(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.node.Owner
    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        this.fontFamilyResolver.setValue(resolver);
    }

    @Override // androidx.compose.ui.node.Owner
    public FontFamily.Resolver getFontFamilyResolver() {
        return (FontFamily.Resolver) this.fontFamilyResolver.getValue();
    }

    private final int getFontWeightAdjustmentCompat(Configuration configuration) {
        int i;
        if (Build.VERSION.SDK_INT < 31) {
            return 0;
        }
        i = configuration.fontWeightAdjustment;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection.setValue(layoutDirection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View, android.view.ViewParent, androidx.compose.ui.node.Owner
    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    @Override // androidx.compose.ui.node.Owner
    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void sendHoverExitEvent$lambda$10(AndroidComposeView androidComposeView) {
        androidComposeView.hoverExitReceived = false;
        MotionEvent motionEvent = androidComposeView.previousMotionEvent;
        Intrinsics.checkNotNull(motionEvent);
        if (motionEvent.getActionMasked() != 10) {
            throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
        }
        androidComposeView.m6102sendMotionEvent8iAsVTc(motionEvent);
    }

    @Override // android.view.View
    public void getFocusedRect(android.graphics.Rect rect) {
        Rect onFetchFocusRect = onFetchFocusRect();
        if (onFetchFocusRect != null) {
            rect.left = Math.round(onFetchFocusRect.getLeft());
            rect.top = Math.round(onFetchFocusRect.getTop());
            rect.right = Math.round(onFetchFocusRect.getRight());
            rect.bottom = Math.round(onFetchFocusRect.getBottom());
            return;
        }
        if (!Intrinsics.areEqual((Object) getFocusOwner().mo4027focusSearchULY8qGw(FocusDirection.INSTANCE.m4013getDowndhqQ8s(), null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$getFocusedRect$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return true;
            }
        }), (Object) true)) {
            rect.set(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        } else {
            super.getFocusedRect(rect);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideStructure(ViewStructure structure) {
        if (Build.VERSION.SDK_INT < 28) {
            AndroidComposeViewAssistHelperMethodsO.INSTANCE.setClassName(structure, getView());
        } else {
            super.dispatchProvideStructure(structure);
        }
    }

    public final boolean getScrollCaptureInProgress$ui_release() {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.scrollCapture) == null) {
            return false;
        }
        return scrollCapture.getScrollCaptureInProgress();
    }

    @Override // android.view.View
    public void onScrollCaptureSearch(android.graphics.Rect localVisibleRect, Point windowOffset, Consumer<ScrollCaptureTarget> targets) {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.scrollCapture) == null) {
            return;
        }
        scrollCapture.onScrollCaptureSearch(this, getSemanticsOwner(), getCoroutineContext(), targets);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        setShowLayoutBounds(INSTANCE.getIsShowingLayoutBounds());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View focused, int direction) {
        Rect calculateBoundingRectRelativeTo;
        if (focused == null || this.measureAndLayoutDelegate.getDuringMeasureLayout()) {
            return super.focusSearch(focused, direction);
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, focused, direction);
        if (focused == this) {
            calculateBoundingRectRelativeTo = getFocusOwner().getFocusRect();
            if (calculateBoundingRectRelativeTo == null) {
                calculateBoundingRectRelativeTo = FocusInteropUtils_androidKt.calculateBoundingRectRelativeTo(focused, this);
            }
        } else {
            calculateBoundingRectRelativeTo = FocusInteropUtils_androidKt.calculateBoundingRectRelativeTo(focused, this);
        }
        FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(direction);
        int value = focusDirection != null ? focusDirection.getValue() : FocusDirection.INSTANCE.m4013getDowndhqQ8s();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (getFocusOwner().mo4027focusSearchULY8qGw(value, calculateBoundingRectRelativeTo, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$focusSearch$searchResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                objectRef.element = focusTargetNode;
                return true;
            }
        }) != null) {
            if (objectRef.element == 0) {
                if (findNextFocus == null) {
                }
            } else {
                if (findNextFocus == null) {
                    return this;
                }
                if (FocusOwnerImplKt.m4033is1dFocusSearch3ESFkO8(value)) {
                    return super.focusSearch(focused, direction);
                }
                T t = objectRef.element;
                Intrinsics.checkNotNull(t);
                AndroidComposeView androidComposeView = this;
                if (TwoDimensionalFocusSearchKt.m4073isBetterCandidateI7lrPNg(FocusTraversalKt.focusRect((FocusTargetNode) t), FocusInteropUtils_androidKt.calculateBoundingRectRelativeTo(findNextFocus, androidComposeView), calculateBoundingRectRelativeTo, value)) {
                    return androidComposeView;
                }
            }
            return findNextFocus;
        }
        return focused;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int direction, android.graphics.Rect previouslyFocusedRect) {
        View findNextNonChildView;
        if (!ComposeUiFlags.isViewFocusFixEnabled) {
            if (isFocused()) {
                return true;
            }
            if (getFocusOwner().getRootState().getHasFocus()) {
                return super.requestFocus(direction, previouslyFocusedRect);
            }
            FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(direction);
            final int value = focusDirection != null ? focusDirection.getValue() : FocusDirection.INSTANCE.m4014getEnterdhqQ8s();
            return Intrinsics.areEqual((Object) getFocusOwner().mo4027focusSearchULY8qGw(value, previouslyFocusedRect != null ? RectHelper_androidKt.toComposeRect(previouslyFocusedRect) : null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$requestFocus$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(FocusTargetNode focusTargetNode) {
                    return Boolean.valueOf(focusTargetNode.mo4040requestFocus3ESFkO8(value));
                }
            }), (Object) true);
        }
        if (isFocused()) {
            return true;
        }
        if (this.processingRequestFocusForNextNonChildView || getFocusOwner().getFocusTransactionManager().getOngoingTransaction()) {
            return false;
        }
        FocusDirection focusDirection2 = FocusInteropUtils_androidKt.toFocusDirection(direction);
        final int value2 = focusDirection2 != null ? focusDirection2.getValue() : FocusDirection.INSTANCE.m4014getEnterdhqQ8s();
        if (hasFocus() && m6099onMoveFocusInChildren3ESFkO8(value2)) {
            return true;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Boolean mo4027focusSearchULY8qGw = getFocusOwner().mo4027focusSearchULY8qGw(value2, previouslyFocusedRect != null ? RectHelper_androidKt.toComposeRect(previouslyFocusedRect) : null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$requestFocus$focusSearchResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                Ref.BooleanRef.this.element = true;
                return Boolean.valueOf(focusTargetNode.mo4040requestFocus3ESFkO8(value2));
            }
        });
        if (mo4027focusSearchULY8qGw == null) {
            return false;
        }
        if (mo4027focusSearchULY8qGw.booleanValue()) {
            return true;
        }
        if (booleanRef.element) {
            return false;
        }
        if ((previouslyFocusedRect != null && !hasFocus() && Intrinsics.areEqual((Object) getFocusOwner().mo4027focusSearchULY8qGw(value2, null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$requestFocus$altFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.mo4040requestFocus3ESFkO8(value2));
            }
        }), (Object) true)) || (findNextNonChildView = findNextNonChildView(direction)) == null || findNextNonChildView == this) {
            return true;
        }
        this.processingRequestFocusForNextNonChildView = true;
        boolean requestFocus = findNextNonChildView.requestFocus(direction);
        this.processingRequestFocusForNextNonChildView = false;
        return requestFocus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onRequestFocusForOwner-7o62pno, reason: not valid java name */
    public final boolean m6100onRequestFocusForOwner7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect) {
        Integer m4021toAndroidFocusDirection3ESFkO8;
        if (isFocused() || hasFocus()) {
            return true;
        }
        return super.requestFocus((focusDirection == null || (m4021toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m4021toAndroidFocusDirection3ESFkO8(focusDirection.getValue())) == null) ? 130 : m4021toAndroidFocusDirection3ESFkO8.intValue(), previouslyFocusedRect != null ? RectHelper_androidKt.toAndroidRect(previouslyFocusedRect) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClearFocusForOwner() {
        if (isFocused() || (!ComposeUiFlags.isViewFocusFixEnabled && hasFocus())) {
            super.clearFocus();
        } else if (hasFocus()) {
            View findFocus = findFocus();
            if (findFocus != null) {
                findFocus.clearFocus();
            }
            super.clearFocus();
        }
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean gainFocus, int direction, android.graphics.Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (gainFocus || hasFocus()) {
            return;
        }
        getFocusOwner().releaseFocus();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        boolean isShowingLayoutBounds;
        this._windowInfo.setWindowFocused(hasWindowFocus);
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(hasWindowFocus);
        if (!hasWindowFocus || getShowLayoutBounds() == (isShowingLayoutBounds = INSTANCE.getIsShowingLayoutBounds())) {
            return;
        }
        setShowLayoutBounds(isShowingLayoutBounds);
        invalidateDescendants();
    }

    @Override // androidx.compose.ui.node.RootForTest
    /* renamed from: sendKeyEvent-ZmokQxo */
    public boolean mo6056sendKeyEventZmokQxo(android.view.KeyEvent keyEvent) {
        return getFocusOwner().mo4025dispatchInterceptedSoftKeyboardEventZmokQxo(keyEvent) || FocusOwner.m4023dispatchKeyEventYhN2O0w$default(getFocusOwner(), keyEvent, null, 2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(final android.view.KeyEvent event) {
        if (isFocused()) {
            this._windowInfo.m6151setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m5669constructorimpl(event.getMetaState()));
            return FocusOwner.m4023dispatchKeyEventYhN2O0w$default(getFocusOwner(), KeyEvent.m5447constructorimpl(event), null, 2, null) || super.dispatchKeyEvent(event);
        }
        return getFocusOwner().mo4026dispatchKeyEventYhN2O0w(KeyEvent.m5447constructorimpl(event), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$dispatchKeyEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean dispatchKeyEvent;
                dispatchKeyEvent = super/*android.view.ViewGroup*/.dispatchKeyEvent(event);
                return Boolean.valueOf(dispatchKeyEvent);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(android.view.KeyEvent event) {
        return (isFocused() && getFocusOwner().mo4025dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent.m5447constructorimpl(event))) || super.dispatchKeyEventPreIme(event);
    }

    @Override // androidx.compose.ui.node.RootForTest
    public void forceAccessibilityForTesting(boolean enable) {
        this.composeAccessibilityDelegate.setAccessibilityForceEnabledForTesting$ui_release(enable);
    }

    @Override // androidx.compose.ui.node.RootForTest
    public void setAccessibilityEventBatchIntervalMillis(long intervalMillis) {
        this.composeAccessibilityDelegate.setSendRecurringAccessibilityEventsIntervalMillis$ui_release(intervalMillis);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onPreAttach(LayoutNode node) {
        getLayoutNodes().set(node.getSemanticsId(), node);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onPostAttach(LayoutNode node) {
        AndroidAutofillManager androidAutofillManager;
        if (autofillSupported() && ComposeUiFlags.isSemanticAutofillEnabled && (androidAutofillManager = this._autofillManager) != null) {
            androidAutofillManager.onPostAttach$ui_release(node);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void onDetach(LayoutNode node) {
        AndroidAutofillManager androidAutofillManager;
        getLayoutNodes().remove(node.getSemanticsId());
        this.measureAndLayoutDelegate.onNodeDetached(node);
        requestClearInvalidObservations();
        if (ComposeUiFlags.isRectTrackingEnabled) {
            getRectManager().remove(node);
        }
        if (autofillSupported() && ComposeUiFlags.isSemanticAutofillEnabled && (androidAutofillManager = this._autofillManager) != null) {
            androidAutofillManager.onDetach$ui_release(node);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void requestAutofill(LayoutNode node) {
        AndroidAutofillManager androidAutofillManager;
        if (autofillSupported() && ComposeUiFlags.isSemanticAutofillEnabled && (androidAutofillManager = this._autofillManager) != null) {
            androidAutofillManager.requestAutofill$ui_release(node);
        }
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void onEndApplyChanges() {
        MutableObjectList<Function0<Unit>> mutableObjectList;
        AndroidAutofillManager androidAutofillManager;
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui_release();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            clearChildInvalidObservations(androidViewsHandler);
        }
        if (autofillSupported() && ComposeUiFlags.isSemanticAutofillEnabled && (androidAutofillManager = this._autofillManager) != null) {
            androidAutofillManager.onEndApplyChanges$ui_release();
        }
        while (this.endApplyChangesListeners.isNotEmpty() && this.endApplyChangesListeners.get(0) != null) {
            int size = this.endApplyChangesListeners.getSize();
            int i = 0;
            while (true) {
                mutableObjectList = this.endApplyChangesListeners;
                if (i < size) {
                    Function0<Unit> function0 = mutableObjectList.get(i);
                    this.endApplyChangesListeners.set(i, null);
                    if (function0 != null) {
                        function0.invoke();
                    }
                    i++;
                }
            }
            mutableObjectList.removeRange(0, size);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void registerOnEndApplyChangesListener(Function0<Unit> listener) {
        if (this.endApplyChangesListeners.contains(listener)) {
            return;
        }
        this.endApplyChangesListeners.add(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startDrag-12SF9DM, reason: not valid java name */
    public final boolean m6103startDrag12SF9DM(DragAndDropTransferData transferData, long decorationSize, Function1<? super DrawScope, Unit> drawDragDecoration) {
        Resources resources = getContext().getResources();
        return AndroidComposeViewStartDragAndDropN.INSTANCE.startDragAndDrop(this, transferData, new ComposeDragShadowBuilder(DensityKt.Density(resources.getDisplayMetrics().density, resources.getConfiguration().fontScale), decorationSize, drawDragDecoration, null));
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).onEndApplyChanges();
            } else if (childAt instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) childAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey) {
        int orDefault;
        boolean areEqual = Intrinsics.areEqual(extraDataKey, this.composeAccessibilityDelegate.getExtraDataTestTraversalBeforeVal());
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.composeAccessibilityDelegate;
        if (areEqual) {
            int orDefault2 = androidComposeViewAccessibilityDelegateCompat.getIdToBeforeMap().getOrDefault(virtualViewId, -1);
            if (orDefault2 != -1) {
                info.getExtras().putInt(extraDataKey, orDefault2);
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(extraDataKey, androidComposeViewAccessibilityDelegateCompat.getExtraDataTestTraversalAfterVal()) || (orDefault = this.composeAccessibilityDelegate.getIdToAfterMap().getOrDefault(virtualViewId, -1)) == -1) {
            return;
        }
        info.getExtras().putInt(extraDataKey, orDefault);
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        addView(child, -1);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        Intrinsics.checkNotNull(child);
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addView(child, index, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int width, int height) {
        ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.width = width;
        generateDefaultLayoutParams.height = height;
        Unit unit = Unit.INSTANCE;
        addView(child, -1, generateDefaultLayoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View child, ViewGroup.LayoutParams params) {
        addView(child, -1, params);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        addViewInLayout(child, index, params, true);
    }

    public final void addAndroidView(AndroidViewHolder view, final LayoutNode layoutNode) {
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(view, layoutNode);
        AndroidViewHolder androidViewHolder = view;
        getAndroidViewsHandler$ui_release().addView(androidViewHolder);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, view);
        view.setImportantForAccessibility(1);
        ViewCompat.setAccessibilityDelegate(androidViewHolder, new AccessibilityDelegateCompat() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1
            /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
            
                if (r0.intValue() == r4.this$0.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) goto L19;
             */
            @Override // androidx.core.view.AccessibilityDelegateCompat
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onInitializeAccessibilityNodeInfo(android.view.View r5, androidx.core.view.accessibility.AccessibilityNodeInfoCompat r6) {
                /*
                    r4 = this;
                    super.onInitializeAccessibilityNodeInfo(r5, r6)
                    androidx.compose.ui.platform.AndroidComposeView r5 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r5 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r5)
                    boolean r5 = r5.isEnabled$ui_release()
                    if (r5 == 0) goto L13
                    r5 = 0
                    r6.setVisibleToUser(r5)
                L13:
                    androidx.compose.ui.node.LayoutNode r5 = r2
                    androidx.compose.ui.node.LayoutNode r5 = r5.getParent$ui_release()
                L19:
                    r0 = 0
                    if (r5 == 0) goto L32
                    androidx.compose.ui.node.NodeChain r1 = r5.getNodes()
                    r2 = 8
                    int r2 = androidx.compose.ui.node.NodeKind.m5994constructorimpl(r2)
                    boolean r1 = r1.m5955hasH91voCI$ui_release(r2)
                    if (r1 == 0) goto L2d
                    goto L33
                L2d:
                    androidx.compose.ui.node.LayoutNode r5 = r5.getParent$ui_release()
                    goto L19
                L32:
                    r5 = r0
                L33:
                    if (r5 == 0) goto L3d
                    int r5 = r5.getSemanticsId()
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
                L3d:
                    r5 = -1
                    if (r0 == 0) goto L54
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.semantics.SemanticsOwner r1 = r1.getSemanticsOwner()
                    androidx.compose.ui.semantics.SemanticsNode r1 = r1.getUnmergedRootSemanticsNode()
                    int r1 = r1.getId()
                    int r2 = r0.intValue()
                    if (r2 != r1) goto L58
                L54:
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
                L58:
                    androidx.compose.ui.platform.AndroidComposeView r1 = r3
                    android.view.View r1 = (android.view.View) r1
                    int r0 = r0.intValue()
                    r6.setParent(r1, r0)
                    androidx.compose.ui.node.LayoutNode r0 = r2
                    int r0 = r0.getSemanticsId()
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r1 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r1)
                    androidx.collection.MutableIntIntMap r1 = r1.getIdToBeforeMap()
                    int r1 = r1.getOrDefault(r0, r5)
                    if (r1 == r5) goto La3
                    androidx.compose.ui.platform.AndroidComposeView r2 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidViewsHandler r2 = r2.getAndroidViewsHandler$ui_release()
                    android.view.View r2 = androidx.compose.ui.platform.SemanticsUtils_androidKt.semanticsIdToView(r2, r1)
                    if (r2 == 0) goto L89
                    r6.setTraversalBefore(r2)
                    goto L90
                L89:
                    androidx.compose.ui.platform.AndroidComposeView r2 = r3
                    android.view.View r2 = (android.view.View) r2
                    r6.setTraversalBefore(r2, r1)
                L90:
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    android.view.accessibility.AccessibilityNodeInfo r2 = r6.unwrap()
                    androidx.compose.ui.platform.AndroidComposeView r3 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r3 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r3)
                    java.lang.String r3 = r3.getExtraDataTestTraversalBeforeVal()
                    androidx.compose.ui.platform.AndroidComposeView.access$addExtraDataToAccessibilityNodeInfoHelper(r1, r0, r2, r3)
                La3:
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r1 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r1)
                    androidx.collection.MutableIntIntMap r1 = r1.getIdToAfterMap()
                    int r1 = r1.getOrDefault(r0, r5)
                    if (r1 == r5) goto Ldd
                    androidx.compose.ui.platform.AndroidComposeView r5 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidViewsHandler r5 = r5.getAndroidViewsHandler$ui_release()
                    android.view.View r5 = androidx.compose.ui.platform.SemanticsUtils_androidKt.semanticsIdToView(r5, r1)
                    if (r5 == 0) goto Lc3
                    r6.setTraversalAfter(r5)
                    goto Lca
                Lc3:
                    androidx.compose.ui.platform.AndroidComposeView r5 = r3
                    android.view.View r5 = (android.view.View) r5
                    r6.setTraversalAfter(r5, r1)
                Lca:
                    androidx.compose.ui.platform.AndroidComposeView r5 = androidx.compose.ui.platform.AndroidComposeView.this
                    android.view.accessibility.AccessibilityNodeInfo r6 = r6.unwrap()
                    androidx.compose.ui.platform.AndroidComposeView r4 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r4 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r4)
                    java.lang.String r4 = r4.getExtraDataTestTraversalAfterVal()
                    androidx.compose.ui.platform.AndroidComposeView.access$addExtraDataToAccessibilityNodeInfoHelper(r5, r0, r6, r4)
                Ldd:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1.onInitializeAccessibilityNodeInfo(android.view.View, androidx.core.view.accessibility.AccessibilityNodeInfoCompat):void");
            }
        });
    }

    public final void removeAndroidView(final AndroidViewHolder view) {
        registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$removeAndroidView$1
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
                AndroidComposeView.this.getAndroidViewsHandler$ui_release().removeViewInLayout(view);
                AndroidComposeView.this.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().remove(AndroidComposeView.this.getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(view));
                view.setImportantForAccessibility(0);
            }
        });
    }

    public final void drawAndroidView(AndroidViewHolder view, Canvas canvas) {
        getAndroidViewsHandler$ui_release().drawView(view, canvas);
    }

    static /* synthetic */ void scheduleMeasureAndLayout$default(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.scheduleMeasureAndLayout(layoutNode);
    }

    private final void scheduleMeasureAndLayout(LayoutNode nodeToRemeasure) {
        if (isLayoutRequested() || !isAttachedToWindow()) {
            return;
        }
        if (nodeToRemeasure != null) {
            while (nodeToRemeasure != null && nodeToRemeasure.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && childSizeCanAffectParentSize(nodeToRemeasure)) {
                nodeToRemeasure = nodeToRemeasure.getParent$ui_release();
            }
            if (nodeToRemeasure == getRoot()) {
                requestLayout();
                return;
            }
        }
        if (getWidth() == 0 || getHeight() == 0) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    private final boolean childSizeCanAffectParentSize(LayoutNode layoutNode) {
        if (this.wasMeasuredWithMultipleConstraints) {
            return true;
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        return (parent$ui_release == null || parent$ui_release.getHasFixedInnerContentConstraints$ui_release()) ? false : true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void measureAndLayout(boolean sendPointerUpdate) {
        Function0<Unit> function0;
        if (this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout() || this.measureAndLayoutDelegate.getHasPendingOnPositionedCallbacks()) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            if (sendPointerUpdate) {
                try {
                    function0 = this.resendMotionEventOnLayout;
                } finally {
                    Trace.endSection();
                }
            } else {
                function0 = null;
            }
            if (this.measureAndLayoutDelegate.measureAndLayout(function0)) {
                requestLayout();
            }
            MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
            dispatchPendingInteropLayoutCallbacks();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: measureAndLayout-0kLqBqw */
    public void mo6055measureAndLayout0kLqBqw(LayoutNode layoutNode, long constraints) {
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.m5942measureAndLayout0kLqBqw(layoutNode, constraints);
            if (!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout()) {
                MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
                dispatchPendingInteropLayoutCallbacks();
            }
            if (ComposeUiFlags.isRectTrackingEnabled) {
                getRectManager().dispatchCallbacks();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    private final void dispatchPendingInteropLayoutCallbacks() {
        if (this.isPendingInteropViewLayoutChangeDispatch) {
            getViewTreeObserver().dispatchOnGlobalLayout();
            this.isPendingInteropViewLayoutChangeDispatch = false;
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void forceMeasureTheSubtree(LayoutNode layoutNode, boolean affectsLookahead) {
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode, affectsLookahead);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onRequestMeasure(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest, boolean scheduleMeasureAndLayout) {
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        if (affectsLookahead) {
            if (measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
                scheduleMeasureAndLayout(layoutNode);
                return;
            }
            return;
        }
        if (measureAndLayoutDelegate.requestRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void onRequestRelayout(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest) {
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        if (affectsLookahead) {
            if (measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, forceRequest)) {
                scheduleMeasureAndLayout$default(this, null, 1, null);
            }
        } else if (measureAndLayoutDelegate.requestRelayout(layoutNode, forceRequest)) {
            scheduleMeasureAndLayout$default(this, null, 1, null);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void requestOnPositionedCallback(LayoutNode layoutNode) {
        this.measureAndLayoutDelegate.requestOnPositionedCallback(layoutNode);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // androidx.compose.ui.node.RootForTest
    public void measureAndLayoutForTest() {
        Owner.measureAndLayout$default(this, false, 1, null);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            long m6097convertMeasureSpecI7RO_PI = m6097convertMeasureSpecI7RO_PI(widthMeasureSpec);
            int m8049constructorimpl = (int) ULong.m8049constructorimpl(m6097convertMeasureSpecI7RO_PI >>> 32);
            int m8049constructorimpl2 = (int) ULong.m8049constructorimpl(m6097convertMeasureSpecI7RO_PI & 4294967295L);
            long m6097convertMeasureSpecI7RO_PI2 = m6097convertMeasureSpecI7RO_PI(heightMeasureSpec);
            long m6950fitPrioritizingHeightZbe2FdA = Constraints.INSTANCE.m6950fitPrioritizingHeightZbe2FdA(m8049constructorimpl, m8049constructorimpl2, (int) ULong.m8049constructorimpl(m6097convertMeasureSpecI7RO_PI2 >>> 32), (int) ULong.m8049constructorimpl(4294967295L & m6097convertMeasureSpecI7RO_PI2));
            Constraints constraints = this.onMeasureConstraints;
            boolean z = false;
            if (constraints == null) {
                this.onMeasureConstraints = Constraints.m6929boximpl(m6950fitPrioritizingHeightZbe2FdA);
                this.wasMeasuredWithMultipleConstraints = false;
            } else {
                if (constraints != null) {
                    z = Constraints.m6935equalsimpl0(constraints.getValue(), m6950fitPrioritizingHeightZbe2FdA);
                }
                if (!z) {
                    this.wasMeasuredWithMultipleConstraints = true;
                }
            }
            this.measureAndLayoutDelegate.m5943updateRootConstraintsBRTryo0(m6950fitPrioritizingHeightZbe2FdA);
            this.measureAndLayoutDelegate.measureOnly();
            setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
            if (this._androidViewsHandler != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), 1073741824));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    /* renamed from: component1-VKZWuLQ, reason: not valid java name */
    private final int m6095component1VKZWuLQ(long j) {
        return (int) ULong.m8049constructorimpl(j >>> 32);
    }

    /* renamed from: component2-VKZWuLQ, reason: not valid java name */
    private final int m6096component2VKZWuLQ(long j) {
        return (int) ULong.m8049constructorimpl(j & 4294967295L);
    }

    /* renamed from: pack-ZIaKswc, reason: not valid java name */
    private final long m6101packZIaKswc(int a, int b) {
        return ULong.m8049constructorimpl(ULong.m8049constructorimpl(ULong.m8049constructorimpl(a) << 32) | ULong.m8049constructorimpl(b));
    }

    /* renamed from: convertMeasureSpec-I7RO_PI, reason: not valid java name */
    private final long m6097convertMeasureSpecI7RO_PI(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        if (mode == Integer.MIN_VALUE) {
            return m6101packZIaKswc(0, size);
        }
        if (mode == 0) {
            return m6101packZIaKswc(0, Integer.MAX_VALUE);
        }
        if (mode == 1073741824) {
            return m6101packZIaKswc(size, size);
        }
        throw new IllegalStateException();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.lastMatrixRecalculationAnimationTime = 0L;
        this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = null;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, r - l, b - t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePositionCacheAndDispatch() {
        getLocationOnScreen(this.tmpPositionArray);
        long j = this.globalPosition;
        int m7117getXimpl = IntOffset.m7117getXimpl(j);
        int m7118getYimpl = IntOffset.m7118getYimpl(j);
        int[] iArr = this.tmpPositionArray;
        boolean z = false;
        int i = iArr[0];
        if (m7117getXimpl != i || m7118getYimpl != iArr[1] || this.lastMatrixRecalculationAnimationTime < 0) {
            this.globalPosition = IntOffset.m7111constructorimpl((i << 32) | (iArr[1] & 4294967295L));
            if (m7117getXimpl != Integer.MAX_VALUE && m7118getYimpl != Integer.MAX_VALUE) {
                getRoot().getLayoutDelegate().getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
                z = true;
            }
        }
        recalculateWindowPosition();
        getRectManager().m6224updateOffsetsucfNpQE(this.globalPosition, IntOffsetKt.m7134roundk4lQ0M(this.windowPosition), this.viewToWindowMatrix);
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
        if (ComposeUiFlags.isRectTrackingEnabled) {
            getRectManager().dispatchCallbacks();
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public OwnedLayer createLayer(Function2<? super androidx.compose.ui.graphics.Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer, GraphicsLayer explicitLayer, boolean forceUseOldLayers) {
        ViewLayerContainer viewLayerContainer;
        if (explicitLayer != null) {
            return new GraphicsLayerOwnerLayer(explicitLayer, null, this, drawBlock, invalidateParentLayer);
        }
        if (!forceUseOldLayers) {
            OwnedLayer pop = this.layerCache.pop();
            if (pop != null) {
                pop.reuseLayer(drawBlock, invalidateParentLayer);
                return pop;
            }
            return new GraphicsLayerOwnerLayer(getGraphicsContext().createGraphicsLayer(), getGraphicsContext(), this, drawBlock, invalidateParentLayer);
        }
        if (isHardwareAccelerated() && this.isRenderNodeCompatible) {
            try {
                return new RenderNodeLayer(this, drawBlock, invalidateParentLayer);
            } catch (Throwable unused) {
                this.isRenderNodeCompatible = false;
            }
        }
        if (this.viewLayersContainer == null) {
            if (!ViewLayer.INSTANCE.getHasRetrievedMethod()) {
                ViewLayer.INSTANCE.updateDisplayList(new View(getContext()));
            }
            if (ViewLayer.INSTANCE.getShouldUseDispatchDraw()) {
                viewLayerContainer = new DrawChildContainer(getContext());
            } else {
                viewLayerContainer = new ViewLayerContainer(getContext());
            }
            this.viewLayersContainer = viewLayerContainer;
            addView(viewLayerContainer);
        }
        DrawChildContainer drawChildContainer = this.viewLayersContainer;
        Intrinsics.checkNotNull(drawChildContainer);
        return new ViewLayer(this, drawChildContainer, drawBlock, invalidateParentLayer);
    }

    public final boolean recycle$ui_release(OwnedLayer layer) {
        if (this.viewLayersContainer != null) {
            ViewLayer.INSTANCE.getShouldUseDispatchDraw();
        }
        this.layerCache.push(layer);
        this.dirtyLayers.remove(layer);
        return true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void onSemanticsChange() {
        this.composeAccessibilityDelegate.onSemanticsChange$ui_release();
        this.contentCaptureManager.onSemanticsChange$ui_release();
    }

    @Override // androidx.compose.ui.node.Owner
    public void onLayoutChange(LayoutNode layoutNode) {
        this.composeAccessibilityDelegate.onLayoutChange$ui_release(layoutNode);
        this.contentCaptureManager.onLayoutChange$ui_release();
    }

    @Override // androidx.compose.ui.node.Owner
    public void onLayoutNodeDeactivated(LayoutNode layoutNode) {
        AndroidAutofillManager androidAutofillManager;
        if (ComposeUiFlags.isRectTrackingEnabled) {
            getRectManager().remove(layoutNode);
        }
        if (autofillSupported() && ComposeUiFlags.isSemanticAutofillEnabled && (androidAutofillManager = this._autofillManager) != null) {
            androidAutofillManager.onLayoutNodeDeactivated$ui_release(layoutNode);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void onPreLayoutNodeReused(LayoutNode layoutNode, int oldSemanticsId) {
        getLayoutNodes().remove(oldSemanticsId);
        getLayoutNodes().set(layoutNode.getSemanticsId(), layoutNode);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onPostLayoutNodeReused(LayoutNode layoutNode, int oldSemanticsId) {
        AndroidAutofillManager androidAutofillManager;
        if (autofillSupported() && ComposeUiFlags.isSemanticAutofillEnabled && (androidAutofillManager = this._autofillManager) != null) {
            androidAutofillManager.onPostLayoutNodeReused$ui_release(layoutNode, oldSemanticsId);
        }
        getRectManager().m6223onLayoutPositionChanged70tqf50(layoutNode, layoutNode.getLayoutDelegate().getMeasurePassDelegate().getLastPosition(), true);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onInteropViewLayoutChange(View view) {
        this.isPendingInteropViewLayoutChangeDispatch = true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void registerOnLayoutCompletedListener(Owner.OnLayoutCompletedListener listener) {
        this.measureAndLayoutDelegate.registerOnLayoutCompletedListener(listener);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: getFocusDirection-P8AzH3I */
    public FocusDirection mo6054getFocusDirectionP8AzH3I(android.view.KeyEvent keyEvent) {
        long m5463getKeyZmokQxo = KeyEvent_androidKt.m5463getKeyZmokQxo(keyEvent);
        if (Key.m5155equalsimpl0(m5463getKeyZmokQxo, Key.INSTANCE.m5391getTabEK5gGoQ())) {
            return FocusDirection.m4006boximpl(KeyEvent_androidKt.m5469isShiftPressedZmokQxo(keyEvent) ? FocusDirection.INSTANCE.m4018getPreviousdhqQ8s() : FocusDirection.INSTANCE.m4017getNextdhqQ8s());
        }
        if (Key.m5155equalsimpl0(m5463getKeyZmokQxo, Key.INSTANCE.m5232getDirectionRightEK5gGoQ())) {
            return FocusDirection.m4006boximpl(FocusDirection.INSTANCE.m4019getRightdhqQ8s());
        }
        if (Key.m5155equalsimpl0(m5463getKeyZmokQxo, Key.INSTANCE.m5231getDirectionLeftEK5gGoQ())) {
            return FocusDirection.m4006boximpl(FocusDirection.INSTANCE.m4016getLeftdhqQ8s());
        }
        if (Key.m5155equalsimpl0(m5463getKeyZmokQxo, Key.INSTANCE.m5233getDirectionUpEK5gGoQ()) ? true : Key.m5155equalsimpl0(m5463getKeyZmokQxo, Key.INSTANCE.m5344getPageUpEK5gGoQ())) {
            return FocusDirection.m4006boximpl(FocusDirection.INSTANCE.m4020getUpdhqQ8s());
        }
        if (Key.m5155equalsimpl0(m5463getKeyZmokQxo, Key.INSTANCE.m5228getDirectionDownEK5gGoQ()) ? true : Key.m5155equalsimpl0(m5463getKeyZmokQxo, Key.INSTANCE.m5343getPageDownEK5gGoQ())) {
            return FocusDirection.m4006boximpl(FocusDirection.INSTANCE.m4013getDowndhqQ8s());
        }
        if (Key.m5155equalsimpl0(m5463getKeyZmokQxo, Key.INSTANCE.m5227getDirectionCenterEK5gGoQ()) ? true : Key.m5155equalsimpl0(m5463getKeyZmokQxo, Key.INSTANCE.m5241getEnterEK5gGoQ()) ? true : Key.m5155equalsimpl0(m5463getKeyZmokQxo, Key.INSTANCE.m5333getNumPadEnterEK5gGoQ())) {
            return FocusDirection.m4006boximpl(FocusDirection.INSTANCE.m4014getEnterdhqQ8s());
        }
        if (Key.m5155equalsimpl0(m5463getKeyZmokQxo, Key.INSTANCE.m5170getBackEK5gGoQ()) ? true : Key.m5155equalsimpl0(m5463getKeyZmokQxo, Key.INSTANCE.m5244getEscapeEK5gGoQ())) {
            return FocusDirection.m4006boximpl(FocusDirection.INSTANCE.m4015getExitdhqQ8s());
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        Owner.measureAndLayout$default(this, false, 1, null);
        Snapshot.INSTANCE.notifyObjectsInitialized();
        this.isDrawingContent = true;
        CanvasHolder canvasHolder = this.canvasHolder;
        Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
        getRoot().draw$ui_release(canvasHolder.getAndroidCanvas(), null);
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        if (!this.dirtyLayers.isEmpty()) {
            int size = this.dirtyLayers.size();
            for (int i = 0; i < size; i++) {
                this.dirtyLayers.get(i).updateDisplayList();
            }
        }
        if (ViewLayer.INSTANCE.getShouldUseDispatchDraw()) {
            int save = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(save);
        }
        this.dirtyLayers.clear();
        this.isDrawingContent = false;
        List<OwnedLayer> list = this.postponedDirtyLayers;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            this.dirtyLayers.addAll(list);
            list.clear();
        }
        if (ComposeUiFlags.isRectTrackingEnabled) {
            getRectManager().dispatchCallbacks();
        }
    }

    public final void notifyLayerIsDirty$ui_release(OwnedLayer layer, boolean isDirty) {
        boolean z = this.isDrawingContent;
        if (!isDirty) {
            if (z) {
                return;
            }
            this.dirtyLayers.remove(layer);
            List<OwnedLayer> list = this.postponedDirtyLayers;
            if (list != null) {
                list.remove(layer);
                return;
            }
            return;
        }
        if (!z) {
            this.dirtyLayers.add(layer);
            return;
        }
        ArrayList arrayList = this.postponedDirtyLayers;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.postponedDirtyLayers = arrayList;
        }
        arrayList.add(layer);
    }

    public final void setOnViewTreeOwnersAvailable(Function1<? super ViewTreeOwners, Unit> callback) {
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            callback.invoke(viewTreeOwners);
        }
        if (isAttachedToWindow()) {
            return;
        }
        this.onViewTreeOwnersAvailable = callback;
    }

    public final Object boundsUpdatesContentCaptureEventLoop(Continuation<? super Unit> continuation) {
        Object boundsUpdatesEventLoop$ui_release = this.contentCaptureManager.boundsUpdatesEventLoop$ui_release(continuation);
        return boundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? boundsUpdatesEventLoop$ui_release : Unit.INSTANCE;
    }

    public final Object boundsUpdatesAccessibilityEventLoop(Continuation<? super Unit> continuation) {
        Object boundsUpdatesEventLoop$ui_release = this.composeAccessibilityDelegate.boundsUpdatesEventLoop$ui_release(continuation);
        return boundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? boundsUpdatesEventLoop$ui_release : Unit.INSTANCE;
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode node) {
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, node, false, 2, null);
        MutableVector<LayoutNode> mutableVector = node.get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            invalidateLayoutNodeMeasurement(layoutNodeArr[i]);
        }
    }

    private final void invalidateLayers(LayoutNode node) {
        node.invalidateLayers$ui_release();
        MutableVector<LayoutNode> mutableVector = node.get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            invalidateLayers(layoutNodeArr[i]);
        }
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner2;
        AndroidAutofill androidAutofill;
        super.onAttachedToWindow();
        this._windowInfo.setWindowFocused(hasWindowFocus());
        this._windowInfo.setOnInitializeContainerSize(new Function0<IntSize>() { // from class: androidx.compose.ui.platform.AndroidComposeView$onAttachedToWindow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ IntSize invoke() {
                return IntSize.m7152boximpl(m6109invokeYbymL2g());
            }

            /* renamed from: invoke-YbymL2g, reason: not valid java name */
            public final long m6109invokeYbymL2g() {
                return AndroidWindowInfo_androidKt.calculateWindowSize(AndroidComposeView.this);
            }
        });
        updateWindowMetrics();
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui_release();
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(androidAutofill);
        }
        AndroidComposeView androidComposeView = this;
        LifecycleOwner lifecycleOwner3 = ViewTreeLifecycleOwner.get(androidComposeView);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(androidComposeView);
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        Lifecycle lifecycle2 = null;
        if (viewTreeOwners == null || (lifecycleOwner3 != null && savedStateRegistryOwner != null && (lifecycleOwner3 != viewTreeOwners.getLifecycleOwner() || savedStateRegistryOwner != viewTreeOwners.getLifecycleOwner()))) {
            if (lifecycleOwner3 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            }
            if (savedStateRegistryOwner == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
            if (viewTreeOwners != null && (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                lifecycle.removeObserver(this);
            }
            lifecycleOwner3.getLifecycle().addObserver(this);
            ViewTreeOwners viewTreeOwners2 = new ViewTreeOwners(lifecycleOwner3, savedStateRegistryOwner);
            set_viewTreeOwners(viewTreeOwners2);
            Function1<? super ViewTreeOwners, Unit> function1 = this.onViewTreeOwnersAvailable;
            if (function1 != null) {
                function1.invoke(viewTreeOwners2);
            }
            this.onViewTreeOwnersAvailable = null;
        }
        this._inputModeManager.m5149setInputModeiuPiT84(isInTouchMode() ? InputMode.INSTANCE.m5146getTouchaOaMEAU() : InputMode.INSTANCE.m5145getKeyboardaOaMEAU());
        ViewTreeOwners viewTreeOwners3 = getViewTreeOwners();
        if (viewTreeOwners3 != null && (lifecycleOwner2 = viewTreeOwners3.getLifecycleOwner()) != null) {
            lifecycle2 = lifecycleOwner2.getLifecycle();
        }
        if (lifecycle2 != null) {
            lifecycle2.addObserver(this);
            lifecycle2.addObserver(this.contentCaptureManager);
            getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
            getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
            getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
            if (Build.VERSION.SDK_INT >= 31) {
                AndroidComposeViewTranslationCallbackS.INSTANCE.setViewTranslationCallback(androidComposeView);
            }
            AndroidAutofillManager androidAutofillManager = this._autofillManager;
            if (androidAutofillManager != null) {
                getFocusOwner().getListeners().add(androidAutofillManager);
                getSemanticsOwner().getListeners$ui_release().add(androidAutofillManager);
                return;
            }
            return;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("No lifecycle owner exists");
        throw new KotlinNothingValueException();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AndroidAutofill androidAutofill;
        LifecycleOwner lifecycleOwner;
        super.onDetachedFromWindow();
        getSnapshotObserver().stopObserving$ui_release();
        Lifecycle lifecycle = null;
        this._windowInfo.setOnInitializeContainerSize(null);
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null && (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) != null) {
            lifecycle = lifecycleOwner.getLifecycle();
        }
        if (lifecycle != null) {
            lifecycle.removeObserver(this.contentCaptureManager);
            lifecycle.removeObserver(this);
            if (autofillSupported() && (androidAutofill = this._autofill) != null) {
                AutofillCallback.INSTANCE.unregister(androidAutofill);
            }
            getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
            getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
            getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
            if (Build.VERSION.SDK_INT >= 31) {
                AndroidComposeViewTranslationCallbackS.INSTANCE.clearViewTranslationCallback(this);
            }
            AndroidAutofillManager androidAutofillManager = this._autofillManager;
            if (androidAutofillManager != null) {
                getSemanticsOwner().getListeners$ui_release().remove(androidAutofillManager);
                getFocusOwner().getListeners().remove(androidAutofillManager);
                return;
            }
            return;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("No lifecycle owner exists");
        throw new KotlinNothingValueException();
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure structure, int flags) {
        AndroidAutofillManager androidAutofillManager;
        if (!autofillSupported() || structure == null) {
            return;
        }
        if (ComposeUiFlags.isSemanticAutofillEnabled && (androidAutofillManager = this._autofillManager) != null) {
            androidAutofillManager.populateViewStructure(structure);
        }
        AndroidAutofill androidAutofill = this._autofill;
        if (androidAutofill != null) {
            AndroidAutofill_androidKt.populateViewStructure(androidAutofill, structure);
        }
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> values) {
        AndroidAutofillManager androidAutofillManager;
        if (autofillSupported()) {
            if (ComposeUiFlags.isSemanticAutofillEnabled && (androidAutofillManager = this._autofillManager) != null) {
                androidAutofillManager.performAutofill(values);
            }
            AndroidAutofill androidAutofill = this._autofill;
            if (androidAutofill != null) {
                AndroidAutofill_androidKt.performAutofill(androidAutofill, values);
            }
        }
    }

    @Override // android.view.View
    public void onCreateVirtualViewTranslationRequests(long[] virtualIds, int[] supportedFormats, Consumer<ViewTranslationRequest> requestsCollector) {
        this.contentCaptureManager.onCreateVirtualViewTranslationRequests$ui_release(virtualIds, supportedFormats, requestsCollector);
    }

    @Override // android.view.View
    public void onVirtualViewTranslationResponses(LongSparseArray<ViewTranslationResponse> response) {
        AndroidContentCaptureManager androidContentCaptureManager = this.contentCaptureManager;
        androidContentCaptureManager.onVirtualViewTranslationResponses$ui_release(androidContentCaptureManager, response);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            if (motionEvent.getActionMasked() == 8) {
                this.hoverExitReceived = false;
            } else {
                this.sendHoverExitEvent.run();
            }
        }
        if (motionEvent.getActionMasked() == 8) {
            if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
                return super.dispatchGenericMotionEvent(motionEvent);
            }
            if (motionEvent.isFromSource(4194304)) {
                return handleRotaryEvent(motionEvent);
            }
            return (m6098handleMotionEvent8iAsVTc(motionEvent) & 1) != 0;
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent motionEvent2 = this.previousMotionEvent;
            Intrinsics.checkNotNull(motionEvent2);
            if (motionEvent.getActionMasked() != 0 || hasChangedDevices(motionEvent, motionEvent2)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow() || (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent))) {
            return false;
        }
        int m6098handleMotionEvent8iAsVTc = m6098handleMotionEvent8iAsVTc(motionEvent);
        if ((m6098handleMotionEvent8iAsVTc & 2) != 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return (m6098handleMotionEvent8iAsVTc & 1) != 0;
    }

    private final boolean handleRotaryEvent(final MotionEvent event) {
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(getContext());
        float f = -event.getAxisValue(26);
        return getFocusOwner().dispatchRotaryEvent(new RotaryScrollEvent(ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, getContext()) * f, f * ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, getContext()), event.getEventTime(), event.getDeviceId()), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$handleRotaryEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean dispatchGenericMotionEvent;
                dispatchGenericMotionEvent = super/*android.view.ViewGroup*/.dispatchGenericMotionEvent(event);
                return Boolean.valueOf(dispatchGenericMotionEvent);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b A[Catch: all -> 0x0122, TryCatch #0 {all -> 0x0122, blocks: (B:5:0x001a, B:7:0x0023, B:90:0x003c, B:25:0x0082, B:27:0x008b, B:28:0x008e, B:30:0x0092, B:32:0x0098, B:34:0x009c, B:35:0x00a2, B:37:0x00a8, B:40:0x00b0, B:41:0x00b6, B:43:0x00bc, B:45:0x00c2, B:47:0x00c8, B:48:0x00ce, B:50:0x00d2, B:51:0x00d6, B:56:0x00e9, B:58:0x00ed, B:59:0x00f4, B:65:0x0104, B:66:0x0109, B:72:0x010e), top: B:4:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c A[Catch: all -> 0x0122, TryCatch #0 {all -> 0x0122, blocks: (B:5:0x001a, B:7:0x0023, B:90:0x003c, B:25:0x0082, B:27:0x008b, B:28:0x008e, B:30:0x0092, B:32:0x0098, B:34:0x009c, B:35:0x00a2, B:37:0x00a8, B:40:0x00b0, B:41:0x00b6, B:43:0x00bc, B:45:0x00c2, B:47:0x00c8, B:48:0x00ce, B:50:0x00d2, B:51:0x00d6, B:56:0x00e9, B:58:0x00ed, B:59:0x00f4, B:65:0x0104, B:66:0x0109, B:72:0x010e), top: B:4:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c8 A[Catch: all -> 0x0122, TryCatch #0 {all -> 0x0122, blocks: (B:5:0x001a, B:7:0x0023, B:90:0x003c, B:25:0x0082, B:27:0x008b, B:28:0x008e, B:30:0x0092, B:32:0x0098, B:34:0x009c, B:35:0x00a2, B:37:0x00a8, B:40:0x00b0, B:41:0x00b6, B:43:0x00bc, B:45:0x00c2, B:47:0x00c8, B:48:0x00ce, B:50:0x00d2, B:51:0x00d6, B:56:0x00e9, B:58:0x00ed, B:59:0x00f4, B:65:0x0104, B:66:0x0109, B:72:0x010e), top: B:4:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d2 A[Catch: all -> 0x0122, TryCatch #0 {all -> 0x0122, blocks: (B:5:0x001a, B:7:0x0023, B:90:0x003c, B:25:0x0082, B:27:0x008b, B:28:0x008e, B:30:0x0092, B:32:0x0098, B:34:0x009c, B:35:0x00a2, B:37:0x00a8, B:40:0x00b0, B:41:0x00b6, B:43:0x00bc, B:45:0x00c2, B:47:0x00c8, B:48:0x00ce, B:50:0x00d2, B:51:0x00d6, B:56:0x00e9, B:58:0x00ed, B:59:0x00f4, B:65:0x0104, B:66:0x0109, B:72:0x010e), top: B:4:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed A[Catch: all -> 0x0122, TryCatch #0 {all -> 0x0122, blocks: (B:5:0x001a, B:7:0x0023, B:90:0x003c, B:25:0x0082, B:27:0x008b, B:28:0x008e, B:30:0x0092, B:32:0x0098, B:34:0x009c, B:35:0x00a2, B:37:0x00a8, B:40:0x00b0, B:41:0x00b6, B:43:0x00bc, B:45:0x00c2, B:47:0x00c8, B:48:0x00ce, B:50:0x00d2, B:51:0x00d6, B:56:0x00e9, B:58:0x00ed, B:59:0x00f4, B:65:0x0104, B:66:0x0109, B:72:0x010e), top: B:4:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0104 A[Catch: all -> 0x0122, TryCatch #0 {all -> 0x0122, blocks: (B:5:0x001a, B:7:0x0023, B:90:0x003c, B:25:0x0082, B:27:0x008b, B:28:0x008e, B:30:0x0092, B:32:0x0098, B:34:0x009c, B:35:0x00a2, B:37:0x00a8, B:40:0x00b0, B:41:0x00b6, B:43:0x00bc, B:45:0x00c2, B:47:0x00c8, B:48:0x00ce, B:50:0x00d2, B:51:0x00d6, B:56:0x00e9, B:58:0x00ed, B:59:0x00f4, B:65:0x0104, B:66:0x0109, B:72:0x010e), top: B:4:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0062  */
    /* renamed from: handleMotionEvent-8iAsVTc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int m6098handleMotionEvent8iAsVTc(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.m6098handleMotionEvent8iAsVTc(android.view.MotionEvent):int");
    }

    private final boolean hasChangedDevices(MotionEvent event, MotionEvent lastEvent) {
        return (lastEvent.getSource() == event.getSource() && lastEvent.getToolType(0) == event.getToolType(0)) ? false : true;
    }

    private final boolean isDevicePressEvent(MotionEvent event) {
        int actionMasked;
        return event.getButtonState() != 0 || (actionMasked = event.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6;
    }

    /* renamed from: sendMotionEvent-8iAsVTc, reason: not valid java name */
    private final int m6102sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        PointerInputEventData pointerInputEventData;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            this._windowInfo.m6151setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m5669constructorimpl(motionEvent.getMetaState()));
        }
        AndroidComposeView androidComposeView = this;
        PointerInputEvent convertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEvent, androidComposeView);
        if (convertToPointerInputEvent$ui_release != null) {
            List<PointerInputEventData> pointers = convertToPointerInputEvent$ui_release.getPointers();
            int size = pointers.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    pointerInputEventData = pointers.get(size);
                    if (pointerInputEventData.getDown()) {
                        break;
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
            pointerInputEventData = null;
            PointerInputEventData pointerInputEventData2 = pointerInputEventData;
            if (pointerInputEventData2 != null) {
                this.lastDownPointerPosition = pointerInputEventData2.m5623getPositionF1C5BW0();
            }
            int m5628processBIzXfog = this.pointerInputEventProcessor.m5628processBIzXfog(convertToPointerInputEvent$ui_release, androidComposeView, isInBounds(motionEvent));
            int actionMasked = motionEvent.getActionMasked();
            if ((actionMasked != 0 && actionMasked != 5) || (m5628processBIzXfog & 1) != 0) {
                return m5628processBIzXfog;
            }
            this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
            return m5628processBIzXfog;
        }
        this.pointerInputEventProcessor.processCancel();
        return PointerInputEventProcessorKt.ProcessResult(false, false);
    }

    static /* synthetic */ void sendSimulatedEvent$default(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i, long j, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        androidComposeView.sendSimulatedEvent(motionEvent, i, j, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSimulatedEvent(MotionEvent motionEvent, int action, long eventTime, boolean forceHover) {
        int actionMasked = motionEvent.getActionMasked();
        int i = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                i = motionEvent.getActionIndex();
            }
        } else if (action != 9 && action != 10) {
            i = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (i >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        for (int i2 = 0; i2 < pointerCount; i2++) {
            pointerPropertiesArr[i2] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i3 = 0; i3 < pointerCount; i3++) {
            pointerCoordsArr[i3] = new MotionEvent.PointerCoords();
        }
        int i4 = 0;
        while (i4 < pointerCount) {
            int i5 = ((i < 0 || i4 < i) ? 0 : 1) + i4;
            motionEvent.getPointerProperties(i5, pointerPropertiesArr[i4]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i4];
            motionEvent.getPointerCoords(i5, pointerCoords);
            float f = pointerCoords.x;
            long mo5687localToScreenMKHz9U = mo5687localToScreenMKHz9U(Offset.m4117constructorimpl((Float.floatToRawIntBits(pointerCoords.y) & 4294967295L) | (Float.floatToRawIntBits(f) << 32)));
            pointerCoords.x = Float.intBitsToFloat((int) (mo5687localToScreenMKHz9U >> 32));
            pointerCoords.y = Float.intBitsToFloat((int) (mo5687localToScreenMKHz9U & 4294967295L));
            i4++;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent.getDownTime() == motionEvent.getEventTime() ? eventTime : motionEvent.getDownTime(), eventTime, action, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), forceHover ? 0 : motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        AndroidComposeView androidComposeView = this;
        PointerInputEvent convertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(obtain, androidComposeView);
        Intrinsics.checkNotNull(convertToPointerInputEvent$ui_release);
        this.pointerInputEventProcessor.m5628processBIzXfog(convertToPointerInputEvent$ui_release, androidComposeView, true);
        obtain.recycle();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        return this.composeAccessibilityDelegate.m6111canScroll0AR0LA0$ui_release(false, direction, this.lastDownPointerPosition);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        return this.composeAccessibilityDelegate.m6111canScroll0AR0LA0$ui_release(true, direction, this.lastDownPointerPosition);
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return 0.0f <= x && x <= ((float) getWidth()) && 0.0f <= y && y <= ((float) getHeight());
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: localToScreen-MK-Hz9U */
    public long mo5687localToScreenMKHz9U(long localPosition) {
        recalculateWindowPosition();
        long m4620mapMKHz9U = Matrix.m4620mapMKHz9U(this.viewToWindowMatrix, localPosition);
        float intBitsToFloat = Float.intBitsToFloat((int) (m4620mapMKHz9U >> 32)) + Float.intBitsToFloat((int) (this.windowPosition >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (m4620mapMKHz9U & 4294967295L)) + Float.intBitsToFloat((int) (this.windowPosition & 4294967295L));
        return Offset.m4117constructorimpl((Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(intBitsToFloat) << 32));
    }

    @Override // androidx.compose.ui.input.pointer.MatrixPositionCalculator
    /* renamed from: localToScreen-58bKbWc */
    public void mo5536localToScreen58bKbWc(float[] localTransform) {
        recalculateWindowPosition();
        Matrix.m4633timesAssign58bKbWc(localTransform, this.viewToWindowMatrix);
        AndroidComposeView_androidKt.m6113access$preTranslatecG2Xzmc(localTransform, Float.intBitsToFloat((int) (this.windowPosition >> 32)), Float.intBitsToFloat((int) (this.windowPosition & 4294967295L)), this.tmpMatrix);
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo5688screenToLocalMKHz9U(long positionOnScreen) {
        recalculateWindowPosition();
        float intBitsToFloat = Float.intBitsToFloat((int) (positionOnScreen >> 32)) - Float.intBitsToFloat((int) (this.windowPosition >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (positionOnScreen & 4294967295L)) - Float.intBitsToFloat((int) (this.windowPosition & 4294967295L));
        return Matrix.m4620mapMKHz9U(this.windowToViewMatrix, Offset.m4117constructorimpl((Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(intBitsToFloat) << 32)));
    }

    private final void recalculateWindowPosition() {
        if (this.forceUseMatrixCache) {
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (currentAnimationTimeMillis != this.lastMatrixRecalculationAnimationTime) {
            this.lastMatrixRecalculationAnimationTime = currentAnimationTimeMillis;
            recalculateWindowViewTransforms();
            ViewParent parent = getParent();
            AndroidComposeView androidComposeView = this;
            while (parent instanceof ViewGroup) {
                androidComposeView = (View) parent;
                parent = ((ViewGroup) androidComposeView).getParent();
            }
            androidComposeView.getLocationOnScreen(this.tmpPositionArray);
            int[] iArr = this.tmpPositionArray;
            float f = iArr[0];
            float f2 = iArr[1];
            androidComposeView.getLocationInWindow(iArr);
            float f3 = this.tmpPositionArray[0];
            float f4 = f2 - r0[1];
            this.windowPosition = Offset.m4117constructorimpl((Float.floatToRawIntBits(f - f3) << 32) | (Float.floatToRawIntBits(f4) & 4294967295L));
        }
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        float[] fArr = this.viewToWindowMatrix;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        long m4620mapMKHz9U = Matrix.m4620mapMKHz9U(fArr, Offset.m4117constructorimpl((Float.floatToRawIntBits(y) & 4294967295L) | (Float.floatToRawIntBits(x) << 32)));
        float rawX = motionEvent.getRawX() - Float.intBitsToFloat((int) (m4620mapMKHz9U >> 32));
        float rawY = motionEvent.getRawY() - Float.intBitsToFloat((int) (m4620mapMKHz9U & 4294967295L));
        this.windowPosition = Offset.m4117constructorimpl((Float.floatToRawIntBits(rawX) << 32) | (Float.floatToRawIntBits(rawY) & 4294967295L));
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.mo6117calculateMatrixToWindowEL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.m6143invertToJiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    private final void updateWindowMetrics() {
        MutableState access$get_containerSize$p = LazyWindowInfo.access$get_containerSize$p(this._windowInfo);
        if (access$get_containerSize$p != null) {
            access$get_containerSize$p.setValue(IntSize.m7152boximpl(AndroidWindowInfo_androidKt.calculateWindowSize(this)));
        }
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m3949getCurrentSessionimpl(this.textInputSessionMutex);
        if (androidPlatformTextInputSession == null) {
            return this.legacyTextInputServiceAndroid.getEditorHasFocus();
        }
        return androidPlatformTextInputSession.isReadyForConnection();
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m3949getCurrentSessionimpl(this.textInputSessionMutex);
        if (androidPlatformTextInputSession == null) {
            return this.legacyTextInputServiceAndroid.createInputConnection(outAttrs);
        }
        return androidPlatformTextInputSession.createInputConnection(outAttrs);
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: calculateLocalPosition-MK-Hz9U */
    public long mo6052calculateLocalPositionMKHz9U(long positionInWindow) {
        recalculateWindowPosition();
        return Matrix.m4620mapMKHz9U(this.windowToViewMatrix, positionInWindow);
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: calculatePositionInWindow-MK-Hz9U */
    public long mo6053calculatePositionInWindowMKHz9U(long localPosition) {
        recalculateWindowPosition();
        return Matrix.m4620mapMKHz9U(this.viewToWindowMatrix, localPosition);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setDensity(AndroidDensity_androidKt.Density(getContext()));
        updateWindowMetrics();
        if (getFontWeightAdjustmentCompat(newConfig) != this.currentFontWeightAdjustment) {
            this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(newConfig);
            setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(getContext()));
        }
        this.configurationChangeObserver.invoke(newConfig);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        if (this.superclassInitComplete) {
            LayoutDirection layoutDirection2 = FocusInteropUtils_androidKt.toLayoutDirection(layoutDirection);
            if (layoutDirection2 == null) {
                layoutDirection2 = LayoutDirection.Ltr;
            }
            setLayoutDirection(layoutDirection2);
        }
    }

    private final boolean autofillSupported() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent event) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (!isBadMotionEvent(event) && isAttachedToWindow()) {
            this.composeAccessibilityDelegate.dispatchHoverEvent$ui_release(event);
            int actionMasked = event.getActionMasked();
            if (actionMasked != 7) {
                if (actionMasked == 10 && isInBounds(event)) {
                    if (event.getToolType(0) == 3 && event.getButtonState() != 0) {
                        return false;
                    }
                    MotionEvent motionEvent = this.previousMotionEvent;
                    if (motionEvent != null) {
                        motionEvent.recycle();
                    }
                    this.previousMotionEvent = MotionEvent.obtainNoHistory(event);
                    this.hoverExitReceived = true;
                    postDelayed(this.sendHoverExitEvent, 8L);
                    return false;
                }
            } else if (!isPositionChanged(event)) {
                return false;
            }
            if ((m6098handleMotionEvent8iAsVTc(event) & 1) != 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean isBadMotionEvent(MotionEvent event) {
        boolean z = (Float.floatToRawIntBits(event.getX()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(event.getY()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(event.getRawX()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(event.getRawY()) & Integer.MAX_VALUE) >= 2139095040;
        if (!z) {
            int pointerCount = event.getPointerCount();
            for (int i = 1; i < pointerCount; i++) {
                z = (Float.floatToRawIntBits(event.getX(i)) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(event.getY(i)) & Integer.MAX_VALUE) >= 2139095040 || (Build.VERSION.SDK_INT >= 29 && !MotionEventVerifierApi29.INSTANCE.isValidMotionEvent(event, i));
                if (z) {
                    break;
                }
            }
        }
        return z;
    }

    private final boolean isPositionChanged(MotionEvent event) {
        MotionEvent motionEvent;
        return (event.getPointerCount() == 1 && (motionEvent = this.previousMotionEvent) != null && motionEvent.getPointerCount() == event.getPointerCount() && event.getRawX() == motionEvent.getRawX() && event.getRawY() == motionEvent.getRawY()) ? false : true;
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int accessibilityId, View currentView) {
        if (Build.VERSION.SDK_INT < 29) {
            Method declaredMethod = Class.forName(AndroidComposeViewAccessibilityDelegateCompat.ClassName).getDeclaredMethod("getAccessibilityViewId", null);
            declaredMethod.setAccessible(true);
            if (Intrinsics.areEqual(declaredMethod.invoke(currentView, null), Integer.valueOf(accessibilityId))) {
                return currentView;
            }
            if (currentView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) currentView;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View findViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, viewGroup.getChildAt(i));
                    if (findViewByAccessibilityIdRootedAtCurrentView != null) {
                        return findViewByAccessibilityIdRootedAtCurrentView;
                    }
                }
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public android.view.PointerIcon onResolvePointerIcon(MotionEvent event, int pointerIndex) {
        PointerIcon currentStylusHoverIcon;
        int toolType = event.getToolType(pointerIndex);
        if (!event.isFromSource(8194) && event.isFromSource(InputDeviceCompat.SOURCE_STYLUS) && ((toolType == 2 || toolType == 4) && (currentStylusHoverIcon = getPointerIconService().getCurrentStylusHoverIcon()) != null)) {
            return AndroidComposeViewVerificationHelperMethodsN.INSTANCE.toAndroidPointerIcon(getContext(), currentStylusHoverIcon);
        }
        return super.onResolvePointerIcon(event, pointerIndex);
    }

    @Override // androidx.compose.ui.node.Owner
    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    public final View findViewByAccessibilityIdTraversal(int accessibilityId) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Method declaredMethod = Class.forName(AndroidComposeViewAccessibilityDelegateCompat.ClassName).getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(this, Integer.valueOf(accessibilityId));
                if (invoke instanceof View) {
                    return (View) invoke;
                }
                return null;
            }
            return findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, this);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public boolean isLifecycleInResumedState() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        return ((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? null : lifecycle.getState()) == Lifecycle.State.RESUMED;
    }

    @Override // androidx.compose.ui.node.Owner
    public void incrementSensitiveComponentCount() {
        if (Build.VERSION.SDK_INT >= 35) {
            if (this.sensitiveComponentCount == 0) {
                AndroidComposeViewSensitiveContent35.INSTANCE.setContentSensitivity(getView(), true);
            }
            this.sensitiveComponentCount++;
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void decrementSensitiveComponentCount() {
        if (Build.VERSION.SDK_INT >= 35) {
            if (this.sensitiveComponentCount == 1) {
                AndroidComposeViewSensitiveContent35.INSTANCE.setContentSensitivity(getView(), false);
            }
            this.sensitiveComponentCount--;
        }
    }

    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", "", "()V", "getBooleanMethod", "Ljava/lang/reflect/Method;", "systemPropertiesClass", "Ljava/lang/Class;", "getIsShowingLayoutBounds", "", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getIsShowingLayoutBounds() {
            try {
                if (AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                    Class cls = AndroidComposeView.systemPropertiesClass;
                    AndroidComposeView.getBooleanMethod = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
                }
                Method method = AndroidComposeView.getBooleanMethod;
                Object invoke = method != null ? method.invoke(null, "debug.layout", false) : null;
                Boolean bool = invoke instanceof Boolean ? (Boolean) invoke : null;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class ViewTreeOwners {
        public static final int $stable = 8;
        private final LifecycleOwner lifecycleOwner;
        private final SavedStateRegistryOwner savedStateRegistryOwner;

        public ViewTreeOwners(LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner) {
            this.lifecycleOwner = lifecycleOwner;
            this.savedStateRegistryOwner = savedStateRegistryOwner;
        }

        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }
    }
}
