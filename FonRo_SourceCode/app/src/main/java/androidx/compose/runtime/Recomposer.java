package androidx.compose.runtime;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectList;
import androidx.collection.ObjectListKt;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.internal.SnapshotThreadLocal;
import androidx.compose.runtime.internal.Utils_androidKt;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.compose.runtime.tooling.CompositionRegistrationObserver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.compose.ComposeNavigator;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: Recomposer.kt */
@Metadata(d1 = {"\u0000Ð\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 Ú\u00012\u00020\u0001:\nÚ\u0001Û\u0001Ü\u0001Ý\u0001Þ\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020_H\u0001¢\u0006\u0002\bsJ\u0010\u0010t\u001a\u00020o2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0010\u0010u\u001a\u00020o2\u0006\u0010v\u001a\u00020wH\u0002J\u0006\u0010x\u001a\u00020yJ\u000e\u0010z\u001a\u00020oH\u0086@¢\u0006\u0002\u0010{J\u000e\u0010|\u001a\u00020oH\u0082@¢\u0006\u0002\u0010{J\u0006\u0010}\u001a\u00020oJ\b\u0010~\u001a\u00020oH\u0002J\u0006\u0010\u007f\u001a\u00020oJ0\u0010\u0080\u0001\u001a\u00020o2\u0006\u0010\u001e\u001a\u00020\u00072\u0014\u0010\u0081\u0001\u001a\u000f\u0012\u0004\u0012\u00020o0\u0082\u0001¢\u0006\u0003\b\u0083\u0001H\u0010¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001JA\u0010\u0086\u0001\u001a\t\u0012\u0004\u0012\u00020X0\u0087\u00012\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0014\u0010\u0081\u0001\u001a\u000f\u0012\u0004\u0012\u00020o0\u0082\u0001¢\u0006\u0003\b\u0083\u0001H\u0010¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001JB\u0010\u008c\u0001\u001a\u0003H\u008d\u0001\"\u0005\b\u0000\u0010\u008d\u00012\u0006\u0010\u001e\u001a\u00020\u00072\u000f\u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010W2\u000f\u0010\u008f\u0001\u001a\n\u0012\u0005\u0012\u0003H\u008d\u00010\u0082\u0001H\u0082\b¢\u0006\u0003\u0010\u0090\u0001J\u0018\u0010\u0091\u0001\u001a\u00020o2\u0007\u0010\u0092\u0001\u001a\u00020IH\u0010¢\u0006\u0003\b\u0093\u0001J\u0011\u0010\u0094\u0001\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010nH\u0002J\t\u0010\u0095\u0001\u001a\u00020oH\u0002J\u0018\u0010\u0096\u0001\u001a\u00020o2\u0007\u0010\u0092\u0001\u001a\u00020IH\u0010¢\u0006\u0003\b\u0097\u0001J\u0017\u0010\u0098\u0001\u001a\u00020o2\u0006\u0010\u001e\u001a\u00020\u0007H\u0010¢\u0006\u0003\b\u0099\u0001J\u0018\u0010\u009a\u0001\u001a\u00020o2\u0007\u0010\u009b\u0001\u001a\u00020XH\u0010¢\u0006\u0003\b\u009c\u0001J\u000f\u0010\u009d\u0001\u001a\u00020oH\u0086@¢\u0006\u0002\u0010{J/\u0010\u009e\u0001\u001a\u00020o2\u0007\u0010\u0092\u0001\u001a\u00020I2\u0007\u0010\u009f\u0001\u001a\u00020T2\f\u0010 \u0001\u001a\u0007\u0012\u0002\b\u00030¡\u0001H\u0010¢\u0006\u0003\b¢\u0001J\u001a\u0010£\u0001\u001a\u0004\u0018\u00010T2\u0007\u0010\u0092\u0001\u001a\u00020IH\u0010¢\u0006\u0003\b¤\u0001J\u0007\u0010¥\u0001\u001a\u00020oJ\u0011\u0010¦\u0001\u001a\u00020o2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J/\u0010§\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\r\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020I0\t2\u000f\u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010WH\u0002J$\u0010©\u0001\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u000f\u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010WH\u0002J*\u0010ª\u0001\u001a\u00020o2\u0007\u0010«\u0001\u001a\u00020\u00152\u000b\b\u0002\u0010¬\u0001\u001a\u0004\u0018\u00010\u00072\t\b\u0002\u0010\u00ad\u0001\u001a\u00020\u0017H\u0002J\u001e\u0010®\u0001\u001a\u000f\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020o0¯\u00012\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J8\u0010°\u0001\u001a\t\u0012\u0004\u0012\u00020X0\u0087\u00012\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u000e\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020X0\u0087\u0001H\u0010¢\u0006\u0003\b²\u0001JW\u0010³\u0001\u001a\u00020o2E\u0010\u008f\u0001\u001a@\b\u0001\u0012\u0005\u0012\u00030µ\u0001\u0012\u0017\u0012\u00150¶\u0001¢\u0006\u000f\b·\u0001\u0012\n\b¸\u0001\u0012\u0005\b\b(¹\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020o0º\u0001\u0012\u0006\u0012\u0004\u0018\u00010Q0´\u0001¢\u0006\u0003\b»\u0001H\u0082@¢\u0006\u0003\u0010¼\u0001J\t\u0010½\u0001\u001a\u00020\u0017H\u0002J \u0010½\u0001\u001a\u00020o2\u0014\u0010¾\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020o0¯\u0001H\u0082\bJ\u0011\u0010¿\u0001\u001a\u00020o2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u001f\u0010À\u0001\u001a\u00020o2\u000e\u0010Á\u0001\u001a\t\u0012\u0005\u0012\u00030Â\u00010&H\u0010¢\u0006\u0003\bÃ\u0001J\u0017\u0010Ä\u0001\u001a\u00020o2\u0006\u0010\u001e\u001a\u00020\u0007H\u0010¢\u0006\u0003\bÅ\u0001J\u0012\u0010Æ\u0001\u001a\u00020o2\u0007\u0010Ç\u0001\u001a\u00020cH\u0002J\u0011\u0010È\u0001\u001a\u00020o2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0018\u0010É\u0001\u001a\u00020o2\u0007\u0010\u009b\u0001\u001a\u00020XH\u0010¢\u0006\u0003\bÊ\u0001J\u0017\u0010Ë\u0001\u001a\u00020o2\u0006\u0010\u001e\u001a\u00020\u0007H\u0010¢\u0006\u0003\bÌ\u0001J\u000b\u0010Í\u0001\u001a\u0004\u0018\u000105H\u0002J\u0007\u0010Î\u0001\u001a\u00020oJ\t\u0010Ï\u0001\u001a\u00020oH\u0002J$\u0010Ð\u0001\u001a\u00020o2\b\u0010¹\u0001\u001a\u00030¶\u00012\b\u0010Ñ\u0001\u001a\u00030Ò\u0001H\u0082@¢\u0006\u0003\u0010Ó\u0001J\u000f\u0010Ô\u0001\u001a\u00020oH\u0086@¢\u0006\u0002\u0010{J\u0018\u0010Õ\u0001\u001a\u00020o2\u0006\u0010Y\u001a\u00020\u0003H\u0087@¢\u0006\u0003\u0010Ö\u0001J\u0017\u0010×\u0001\u001a\u00020o2\u0006\u0010\u001e\u001a\u00020\u0007H\u0010¢\u0006\u0003\bØ\u0001J/\u0010Ù\u0001\u001a\u000f\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020o0¯\u00012\u0006\u0010\u001e\u001a\u00020\u00072\u000f\u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010WH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0-8F¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00106\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0019R\u0014\u0010:\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0019R\u0014\u0010<\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0019R\u0014\u0010>\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0019R\u0011\u0010@\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\bA\u0010\u0019R\u0014\u0010B\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0019R\u000e\u0010D\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00070\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010J\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020I0KX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010LR\u000e\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010O\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010Q0P\u0012\u0004\u0012\u00020I0KX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010LR\u001a\u0010R\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020T0SX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010U\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020X\u0018\u00010W0VX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010Y\u001a\u00020\u00038PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bZ\u00101R\u0012\u0010[\u001a\u00060\\R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010]\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010^8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b`\u0010aR\u0010\u0010b\u001a\u0004\u0018\u00010cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010d\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\be\u0010\u0019R\u0014\u0010f\u001a\b\u0012\u0004\u0012\u00020Q0WX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010g\u001a\b\u0012\u0004\u0012\u00020\f0h8FX\u0087\u0004¢\u0006\f\u0012\u0004\bi\u0010a\u001a\u0004\bj\u0010kR\u000e\u0010l\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010m\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010nX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006ß\u0001"}, d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "_knownCompositions", "", "Landroidx/compose/runtime/ControlledComposition;", "_knownCompositionsCache", "", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "<set-?>", "", "changeCount", "getChangeCount", "()J", "closeCause", "", "collectingCallByInformation", "", "getCollectingCallByInformation$runtime_release", "()Z", "collectingParameterInformation", "getCollectingParameterInformation$runtime_release", "collectingSourceInformation", "getCollectingSourceInformation$runtime_release", "composition", "Landroidx/compose/runtime/Composition;", "getComposition$runtime_release", "()Landroidx/compose/runtime/Composition;", "compositionInvalidations", "Landroidx/compose/runtime/collection/MutableVector;", "compositionsAwaitingApply", "compositionsRemoved", "", "compoundHashKey", "", "getCompoundHashKey$runtime_release", "()I", "concurrentCompositionsOutstanding", "currentState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "errorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "failedCompositions", "frameClockPaused", "hasBroadcastFrameClockAwaiters", "getHasBroadcastFrameClockAwaiters", "hasBroadcastFrameClockAwaitersLocked", "getHasBroadcastFrameClockAwaitersLocked", "hasConcurrentFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "hasFrameWorkLocked", "getHasFrameWorkLocked", "hasPendingWork", "getHasPendingWork", "hasSchedulingWork", "getHasSchedulingWork", "isClosed", "knownCompositions", "getKnownCompositions", "()Ljava/util/List;", "movableContentAwaitingInsert", "Landroidx/compose/runtime/MovableContentStateReference;", "movableContentNestedExtractionsPending", "Landroidx/compose/runtime/collection/MultiValueMap;", "Landroidx/collection/MutableScatterMap;", "movableContentNestedStatesAvailable", "Landroidx/compose/runtime/NestedContentMap;", "movableContentRemoved", "Landroidx/compose/runtime/MovableContent;", "", "movableContentStatesAvailable", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/MovableContentState;", "pausedScopes", "Landroidx/compose/runtime/internal/SnapshotThreadLocal;", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "registrationObservers", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/runtime/tooling/CompositionRegistrationObserver;", "getRegistrationObservers$annotations", "()V", "runnerJob", "Lkotlinx/coroutines/Job;", "shouldKeepRecomposing", "getShouldKeepRecomposing", "snapshotInvalidations", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "getState", "()Lkotlinx/coroutines/flow/Flow;", "stateLock", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "addCompositionRegistrationObserver", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "addCompositionRegistrationObserver$runtime_release", "addKnownCompositionLocked", "applyAndCheck", "snapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "awaitIdle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitWorkAvailable", "cancel", "clearKnownCompositionsLocked", "close", "composeInitial", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composeInitialPaused", "Landroidx/collection/ScatterSet;", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "composeInitialPaused$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;Lkotlin/jvm/functions/Function2;)Landroidx/collection/ScatterSet;", "composing", ExifInterface.GPS_DIRECTION_TRUE, "modifiedValues", "block", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/collection/MutableScatterSet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "deletedMovableContent", TypedValues.Custom.S_REFERENCE, "deletedMovableContent$runtime_release", "deriveStateLocked", "discardUnusedMovableContentState", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "invalidateScope$runtime_release", "join", "movableContentStateReleased", "data", "applier", "Landroidx/compose/runtime/Applier;", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "pauseCompositionFrameClock", "performInitialMovableContentInserts", "performInsertValues", "references", "performRecompose", "processCompositionError", "e", "failedInitialComposition", "recoverable", "readObserverOf", "Lkotlin/Function1;", "recomposePaused", "invalidScopes", "recomposePaused$runtime_release", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/ParameterName;", "name", "parentFrameClock", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordComposerModifications", "onEachInvalidComposition", "recordFailedCompositionLocked", "recordInspectionTable", "table", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime_release", "registerComposition", "registerComposition$runtime_release", "registerRunnerJob", "callingJob", "removeKnownCompositionLocked", "reportPausedScope", "reportPausedScope$runtime_release", "reportRemovedComposition", "reportRemovedComposition$runtime_release", "resetErrorState", "resumeCompositionFrameClock", "retryFailedCompositions", "runFrameLoop", "frameSignal", "Landroidx/compose/runtime/ProduceFrameSignal;", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRecomposeAndApplyChanges", "runRecomposeConcurrentlyAndApplyChanges", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterComposition", "unregisterComposition$runtime_release", "writeObserverOf", "Companion", "HotReloadable", "RecomposerErrorState", "RecomposerInfoImpl", "State", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class Recomposer extends CompositionContext {
    private final List<ControlledComposition> _knownCompositions;
    private List<? extends ControlledComposition> _knownCompositionsCache;
    private final MutableStateFlow<State> _state;
    private final BroadcastFrameClock broadcastFrameClock;
    private long changeCount;
    private Throwable closeCause;
    private final MutableVector<ControlledComposition> compositionInvalidations;
    private final List<ControlledComposition> compositionsAwaitingApply;
    private Set<ControlledComposition> compositionsRemoved;
    private int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    private RecomposerErrorState errorState;
    private List<ControlledComposition> failedCompositions;
    private boolean frameClockPaused;
    private boolean isClosed;
    private final List<MovableContentStateReference> movableContentAwaitingInsert;
    private final MutableScatterMap<Object, Object> movableContentNestedExtractionsPending;
    private final NestedContentMap movableContentNestedStatesAvailable;
    private final MutableScatterMap<Object, Object> movableContentRemoved;
    private final MutableScatterMap<MovableContentStateReference, MovableContentState> movableContentStatesAvailable;
    private final SnapshotThreadLocal<MutableScatterSet<RecomposeScopeImpl>> pausedScopes;
    private final RecomposerInfoImpl recomposerInfo;
    private MutableObjectList<CompositionRegistrationObserver> registrationObservers;
    private Job runnerJob;
    private MutableScatterSet<Object> snapshotInvalidations;
    private final Object stateLock;
    private CancellableContinuation<? super Unit> workContinuation;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final MutableStateFlow<PersistentSet<RecomposerInfoImpl>> _runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());
    private static final AtomicReference<Boolean> _hotReloadEnabled = new AtomicReference<>(false);

    private static /* synthetic */ void getRegistrationObservers$annotations() {
    }

    @Deprecated(message = "Replaced by currentState as a StateFlow", replaceWith = @ReplaceWith(expression = "currentState", imports = {}))
    public static /* synthetic */ void getState$annotations() {
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* renamed from: getCollectingParameterInformation$runtime_release */
    public boolean getCollectingParameterInformation() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* renamed from: getCollectingSourceInformation$runtime_release */
    public boolean getCollectingSourceInformation() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public Composition getComposition$runtime_release() {
        return null;
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* renamed from: getCompoundHashKey$runtime_release */
    public int getCompoundHashKey() {
        return 1000;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void recordInspectionTable$runtime_release(Set<CompositionData> table) {
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void registerComposition$runtime_release(ControlledComposition composition) {
    }

    public Recomposer(CoroutineContext coroutineContext) {
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$broadcastFrameClock$1
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
                CancellableContinuation deriveStateLocked;
                MutableStateFlow mutableStateFlow;
                Throwable th;
                Object obj = Recomposer.this.stateLock;
                Recomposer recomposer = Recomposer.this;
                synchronized (obj) {
                    deriveStateLocked = recomposer.deriveStateLocked();
                    mutableStateFlow = recomposer._state;
                    if (((Recomposer.State) mutableStateFlow.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                        th = recomposer.closeCause;
                        throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", th);
                    }
                }
                if (deriveStateLocked != null) {
                    Result.Companion companion = Result.INSTANCE;
                    deriveStateLocked.resumeWith(Result.m7870constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.broadcastFrameClock = broadcastFrameClock;
        this.stateLock = new Object();
        this._knownCompositions = new ArrayList();
        this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
        this.compositionInvalidations = new MutableVector<>(new ControlledComposition[16], 0);
        this.compositionsAwaitingApply = new ArrayList();
        this.movableContentAwaitingInsert = new ArrayList();
        this.movableContentRemoved = MultiValueMap.m3887constructorimpl$default(null, 1, null);
        this.movableContentNestedStatesAvailable = new NestedContentMap();
        this.movableContentStatesAvailable = ScatterMapKt.mutableScatterMapOf();
        this.movableContentNestedExtractionsPending = MultiValueMap.m3887constructorimpl$default(null, 1, null);
        this._state = StateFlowKt.MutableStateFlow(State.Inactive);
        this.pausedScopes = new SnapshotThreadLocal<>();
        CompletableJob Job = JobKt.Job((Job) coroutineContext.get(Job.INSTANCE));
        Job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final Throwable th) {
                Job job;
                CancellableContinuation cancellableContinuation;
                MutableStateFlow mutableStateFlow;
                MutableStateFlow mutableStateFlow2;
                boolean z;
                CancellableContinuation cancellableContinuation2;
                CancellableContinuation cancellableContinuation3;
                CancellationException CancellationException = ExceptionsKt.CancellationException("Recomposer effect job completed", th);
                Object obj = Recomposer.this.stateLock;
                final Recomposer recomposer = Recomposer.this;
                synchronized (obj) {
                    job = recomposer.runnerJob;
                    cancellableContinuation = null;
                    if (job != null) {
                        mutableStateFlow2 = recomposer._state;
                        mutableStateFlow2.setValue(Recomposer.State.ShuttingDown);
                        z = recomposer.isClosed;
                        if (z) {
                            cancellableContinuation2 = recomposer.workContinuation;
                            if (cancellableContinuation2 != null) {
                                cancellableContinuation3 = recomposer.workContinuation;
                                recomposer.workContinuation = null;
                                job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                                        invoke2(th2);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Throwable th2) {
                                        MutableStateFlow mutableStateFlow3;
                                        Object obj2 = Recomposer.this.stateLock;
                                        Recomposer recomposer2 = Recomposer.this;
                                        Throwable th3 = th;
                                        synchronized (obj2) {
                                            if (th3 == null) {
                                                th3 = null;
                                            } else if (th2 != null) {
                                                if (th2 instanceof CancellationException) {
                                                    th2 = null;
                                                }
                                                if (th2 != null) {
                                                    kotlin.ExceptionsKt.addSuppressed(th3, th2);
                                                }
                                            }
                                            recomposer2.closeCause = th3;
                                            mutableStateFlow3 = recomposer2._state;
                                            mutableStateFlow3.setValue(Recomposer.State.ShutDown);
                                            Unit unit = Unit.INSTANCE;
                                        }
                                    }
                                });
                                cancellableContinuation = cancellableContinuation3;
                            }
                        } else {
                            job.cancel(CancellationException);
                        }
                        cancellableContinuation3 = null;
                        recomposer.workContinuation = null;
                        job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                                invoke2(th2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th2) {
                                MutableStateFlow mutableStateFlow3;
                                Object obj2 = Recomposer.this.stateLock;
                                Recomposer recomposer2 = Recomposer.this;
                                Throwable th3 = th;
                                synchronized (obj2) {
                                    if (th3 == null) {
                                        th3 = null;
                                    } else if (th2 != null) {
                                        if (th2 instanceof CancellationException) {
                                            th2 = null;
                                        }
                                        if (th2 != null) {
                                            kotlin.ExceptionsKt.addSuppressed(th3, th2);
                                        }
                                    }
                                    recomposer2.closeCause = th3;
                                    mutableStateFlow3 = recomposer2._state;
                                    mutableStateFlow3.setValue(Recomposer.State.ShutDown);
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                        });
                        cancellableContinuation = cancellableContinuation3;
                    } else {
                        recomposer.closeCause = CancellationException;
                        mutableStateFlow = recomposer._state;
                        mutableStateFlow.setValue(Recomposer.State.ShutDown);
                        Unit unit = Unit.INSTANCE;
                    }
                }
                if (cancellableContinuation != null) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7870constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.effectJob = Job;
        this.effectCoroutineContext = coroutineContext.plus(broadcastFrameClock).plus(Job);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State ShutDown = new State("ShutDown", 0);
        public static final State ShuttingDown = new State("ShuttingDown", 1);
        public static final State Inactive = new State("Inactive", 2);
        public static final State InactivePendingWork = new State("InactivePendingWork", 3);
        public static final State Idle = new State("Idle", 4);
        public static final State PendingWork = new State("PendingWork", 5);

        private static final /* synthetic */ State[] $values() {
            return new State[]{ShutDown, ShuttingDown, Inactive, InactivePendingWork, Idle, PendingWork};
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        private State(String str, int i) {
        }

        static {
            State[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ControlledComposition> getKnownCompositions() {
        List list = this._knownCompositionsCache;
        if (list == null) {
            List<ControlledComposition> list2 = this._knownCompositions;
            list = list2.isEmpty() ? CollectionsKt.emptyList() : new ArrayList(list2);
            this._knownCompositionsCache = list;
        }
        return list;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
        return EmptyCoroutineContext.INSTANCE;
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        return !this.frameClockPaused && this.broadcastFrameClock.getHasAwaiters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasBroadcastFrameClockAwaiters() {
        boolean hasBroadcastFrameClockAwaitersLocked;
        synchronized (this.stateLock) {
            hasBroadcastFrameClockAwaitersLocked = getHasBroadcastFrameClockAwaitersLocked();
        }
        return hasBroadcastFrameClockAwaitersLocked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CancellableContinuation<Unit> deriveStateLocked() {
        State state;
        int i = 0;
        int i2 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            clearKnownCompositionsLocked();
            this.snapshotInvalidations = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.movableContentAwaitingInsert.clear();
            this.failedCompositions = null;
            CancellableContinuation<? super Unit> cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, null, 1, null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            state = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
            this.compositionInvalidations.clear();
            state = getHasBroadcastFrameClockAwaitersLocked() ? State.InactivePendingWork : State.Inactive;
        } else if (this.compositionInvalidations.getSize() != 0 || this.snapshotInvalidations.isNotEmpty() || !this.compositionsAwaitingApply.isEmpty() || !this.movableContentAwaitingInsert.isEmpty() || this.concurrentCompositionsOutstanding > 0 || getHasBroadcastFrameClockAwaitersLocked()) {
            state = State.PendingWork;
        } else {
            state = State.Idle;
        }
        this._state.setValue(state);
        if (state != State.PendingWork) {
            return null;
        }
        CancellableContinuation cancellableContinuation2 = this.workContinuation;
        this.workContinuation = null;
        return cancellableContinuation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.isClosed;
        }
        if (!z) {
            return true;
        }
        Iterator<Job> it = this.effectJob.getChildren().iterator();
        while (it.hasNext()) {
            if (it.next().isActive()) {
                return true;
            }
        }
        return false;
    }

    public final Flow<State> getState() {
        return getCurrentState();
    }

    public final StateFlow<State> getCurrentState() {
        return this._state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u0015J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "(Landroidx/compose/runtime/Recomposer;)V", "changeCount", "", "getChangeCount", "()J", "currentError", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentError", "()Landroidx/compose/runtime/RecomposerErrorInfo;", "hasPendingWork", "", "getHasPendingWork", "()Z", "state", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "invalidateGroupsWithKey", "", "key", "", "resetErrorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public final class RecomposerInfoImpl implements RecomposerInfo {
        public RecomposerInfoImpl() {
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public Flow<State> getState() {
            return Recomposer.this.getCurrentState();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public boolean getHasPendingWork() {
            return Recomposer.this.getHasPendingWork();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public long getChangeCount() {
            return Recomposer.this.getChangeCount();
        }

        public final RecomposerErrorInfo getCurrentError() {
            RecomposerErrorState recomposerErrorState;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                recomposerErrorState = recomposer.errorState;
            }
            return recomposerErrorState;
        }

        public final void invalidateGroupsWithKey(int key) {
            List knownCompositions;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                knownCompositions = recomposer.getKnownCompositions();
            }
            ArrayList arrayList = new ArrayList(knownCompositions.size());
            int size = knownCompositions.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = (ControlledComposition) knownCompositions.get(i);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            ArrayList arrayList2 = arrayList;
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((CompositionImpl) arrayList2.get(i2)).invalidateGroupsWithKey(key);
            }
        }

        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            List knownCompositions;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                knownCompositions = recomposer.getKnownCompositions();
            }
            ArrayList arrayList = new ArrayList(knownCompositions.size());
            int size = knownCompositions.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = (ControlledComposition) knownCompositions.get(i);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(arrayList2.size());
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                HotReloadable hotReloadable = new HotReloadable((CompositionImpl) arrayList2.get(i2));
                hotReloadable.clearContent();
                arrayList3.add(hotReloadable);
            }
            return arrayList3;
        }

        public final RecomposerErrorState resetErrorState() {
            return Recomposer.this.resetErrorState();
        }

        public final void retryFailedCompositions() {
            Recomposer.this.retryFailedCompositions();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u001b\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "(Landroidx/compose/runtime/CompositionImpl;)V", ComposeNavigator.NAME, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "recompose", "resetContent", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class HotReloadable {
        private Function2<? super Composer, ? super Integer, Unit> composable;
        private final CompositionImpl composition;

        public HotReloadable(CompositionImpl compositionImpl) {
            this.composition = compositionImpl;
            this.composable = compositionImpl.getComposable();
        }

        public final void clearContent() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m3746getLambda1$runtime_release());
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }

        public final void recompose() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(this.composable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "Landroidx/compose/runtime/RecomposerErrorInfo;", "recoverable", "", "cause", "", "(ZLjava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "getRecoverable", "()Z", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class RecomposerErrorState implements RecomposerErrorInfo {
        private final Throwable cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean z, Throwable th) {
            this.recoverable = z;
            this.cause = th;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public boolean getRecoverable() {
            return this.recoverable;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public Throwable getCause() {
            return this.cause;
        }
    }

    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean recordComposerModifications() {
        List<ControlledComposition> knownCompositions;
        boolean hasFrameWorkLocked;
        synchronized (this.stateLock) {
            if (this.snapshotInvalidations.isEmpty()) {
                return getHasFrameWorkLocked();
            }
            Set<? extends Object> wrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(this.snapshotInvalidations);
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i = 1;
            int i2 = 0;
            this.snapshotInvalidations = new MutableScatterSet<>(i2, i, defaultConstructorMarker);
            synchronized (this.stateLock) {
                knownCompositions = getKnownCompositions();
            }
            try {
                Recomposer recomposer = this;
                int size = knownCompositions.size();
                for (int i3 = 0; i3 < size; i3++) {
                    knownCompositions.get(i3).recordModificationsOf(wrapIntoSet);
                    if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                        break;
                    }
                }
                synchronized (this.stateLock) {
                    this.snapshotInvalidations = new MutableScatterSet<>(i2, i, defaultConstructorMarker);
                    Unit unit = Unit.INSTANCE;
                }
                synchronized (this.stateLock) {
                    if (deriveStateLocked() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
                    }
                    hasFrameWorkLocked = getHasFrameWorkLocked();
                }
                return hasFrameWorkLocked;
            } catch (Throwable th) {
                synchronized (this.stateLock) {
                    this.snapshotInvalidations.addAll(wrapIntoSet);
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void recordComposerModifications(Function1<? super ControlledComposition, Unit> onEachInvalidComposition) {
        MutableScatterSet mutableScatterSet;
        int i;
        synchronized (this.stateLock) {
            mutableScatterSet = this.snapshotInvalidations;
            i = 0;
            if (mutableScatterSet.isNotEmpty()) {
                this.snapshotInvalidations = new MutableScatterSet(i, 1, null);
            }
        }
        Set<? extends Object> wrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(mutableScatterSet);
        if (!wrapIntoSet.isEmpty()) {
            List knownCompositions = getKnownCompositions();
            int size = knownCompositions.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((ControlledComposition) knownCompositions.get(i2)).recordModificationsOf(wrapIntoSet);
            }
        }
        MutableVector mutableVector = this.compositionInvalidations;
        T[] tArr = mutableVector.content;
        int size2 = mutableVector.getSize();
        while (i < size2) {
            onEachInvalidComposition.invoke(tArr[i]);
            i++;
        }
        this.compositionInvalidations.clear();
        synchronized (this.stateLock) {
            if (deriveStateLocked() != null) {
                throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerRunnerJob(Job callingJob) {
        synchronized (this.stateLock) {
            Throwable th = this.closeCause;
            if (th != null) {
                throw th;
            }
            if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down".toString());
            }
            if (this.runnerJob != null) {
                throw new IllegalStateException("Recomposer already running".toString());
            }
            this.runnerJob = callingJob;
            deriveStateLocked();
        }
    }

    public final Object runRecomposeAndApplyChanges(Continuation<? super Unit> continuation) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeAndApplyChanges$2(this, null), continuation);
        return recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void processCompositionError$default(Recomposer recomposer, Throwable th, ControlledComposition controlledComposition, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            controlledComposition = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        recomposer.processCompositionError(th, controlledComposition, z);
    }

    private final void processCompositionError(Throwable e, ControlledComposition failedInitialComposition, boolean recoverable) {
        int i = 0;
        if (_hotReloadEnabled.get().booleanValue() && !(e instanceof ComposeRuntimeError)) {
            synchronized (this.stateLock) {
                Utils_androidKt.logError("Error was captured in composition while live edit was enabled.", e);
                this.compositionsAwaitingApply.clear();
                this.compositionInvalidations.clear();
                this.snapshotInvalidations = new MutableScatterSet<>(i, 1, null);
                this.movableContentAwaitingInsert.clear();
                MultiValueMap.m3885clearimpl(this.movableContentRemoved);
                this.movableContentStatesAvailable.clear();
                this.errorState = new RecomposerErrorState(recoverable, e);
                if (failedInitialComposition != null) {
                    recordFailedCompositionLocked(failedInitialComposition);
                }
                deriveStateLocked();
            }
            return;
        }
        synchronized (this.stateLock) {
            RecomposerErrorState recomposerErrorState = this.errorState;
            if (recomposerErrorState == null) {
                this.errorState = new RecomposerErrorState(false, e);
                Unit unit = Unit.INSTANCE;
            } else {
                throw recomposerErrorState.getCause();
            }
        }
        throw e;
    }

    private final void clearKnownCompositionsLocked() {
        MutableObjectList<CompositionRegistrationObserver> mutableObjectList = this.registrationObservers;
        if (mutableObjectList != null) {
            MutableObjectList<CompositionRegistrationObserver> mutableObjectList2 = mutableObjectList;
            Object[] objArr = mutableObjectList2.content;
            int i = mutableObjectList2._size;
            for (int i2 = 0; i2 < i; i2++) {
                CompositionRegistrationObserver compositionRegistrationObserver = (CompositionRegistrationObserver) objArr[i2];
                Iterator<T> it = getKnownCompositions().iterator();
                while (it.hasNext()) {
                    compositionRegistrationObserver.onCompositionUnregistered(this, (ControlledComposition) it.next());
                }
            }
        }
        this._knownCompositions.clear();
        this._knownCompositionsCache = CollectionsKt.emptyList();
    }

    private final void removeKnownCompositionLocked(ControlledComposition composition) {
        if (this._knownCompositions.remove(composition)) {
            this._knownCompositionsCache = null;
            MutableObjectList<CompositionRegistrationObserver> mutableObjectList = this.registrationObservers;
            if (mutableObjectList != null) {
                MutableObjectList<CompositionRegistrationObserver> mutableObjectList2 = mutableObjectList;
                Object[] objArr = mutableObjectList2.content;
                int i = mutableObjectList2._size;
                for (int i2 = 0; i2 < i; i2++) {
                    ((CompositionRegistrationObserver) objArr[i2]).onCompositionUnregistered(this, composition);
                }
            }
        }
    }

    private final void addKnownCompositionLocked(ControlledComposition composition) {
        this._knownCompositions.add(composition);
        this._knownCompositionsCache = null;
        MutableObjectList<CompositionRegistrationObserver> mutableObjectList = this.registrationObservers;
        if (mutableObjectList != null) {
            MutableObjectList<CompositionRegistrationObserver> mutableObjectList2 = mutableObjectList;
            Object[] objArr = mutableObjectList2.content;
            int i = mutableObjectList2._size;
            for (int i2 = 0; i2 < i; i2++) {
                ((CompositionRegistrationObserver) objArr[i2]).onCompositionRegistered(this, composition);
            }
        }
    }

    public final CompositionObserverHandle addCompositionRegistrationObserver$runtime_release(final CompositionRegistrationObserver observer) {
        synchronized (this.stateLock) {
            MutableObjectList<CompositionRegistrationObserver> mutableObjectList = this.registrationObservers;
            int i = 0;
            if (mutableObjectList == null) {
                mutableObjectList = new MutableObjectList<>(i, 1, null);
                this.registrationObservers = mutableObjectList;
            }
            mutableObjectList.add(observer);
            List<ControlledComposition> list = this._knownCompositions;
            int size = list.size();
            while (i < size) {
                observer.onCompositionRegistered(this, list.get(i));
                i++;
            }
            Unit unit = Unit.INSTANCE;
        }
        return new CompositionObserverHandle() { // from class: androidx.compose.runtime.Recomposer$addCompositionRegistrationObserver$2
            @Override // androidx.compose.runtime.tooling.CompositionObserverHandle
            public void dispose() {
                MutableObjectList mutableObjectList2;
                Object obj = Recomposer.this.stateLock;
                Recomposer recomposer = Recomposer.this;
                CompositionRegistrationObserver compositionRegistrationObserver = observer;
                synchronized (obj) {
                    mutableObjectList2 = recomposer.registrationObservers;
                    if (mutableObjectList2 != null) {
                        Boolean.valueOf(mutableObjectList2.remove(compositionRegistrationObserver));
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecomposerErrorState resetErrorState() {
        RecomposerErrorState recomposerErrorState;
        synchronized (this.stateLock) {
            recomposerErrorState = this.errorState;
            if (recomposerErrorState != null) {
                this.errorState = null;
                deriveStateLocked();
            }
        }
        return recomposerErrorState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retryFailedCompositions() {
        List<ControlledComposition> list;
        int i;
        synchronized (this.stateLock) {
            list = this.failedCompositions;
            this.failedCompositions = null;
        }
        if (list == null) {
            return;
        }
        while (true) {
            i = 0;
            try {
                if (list.isEmpty()) {
                    break;
                }
                ControlledComposition controlledComposition = (ControlledComposition) CollectionsKt.removeLast(list);
                if (controlledComposition instanceof CompositionImpl) {
                    controlledComposition.invalidateAll();
                    controlledComposition.setContent(((CompositionImpl) controlledComposition).getComposable());
                    if (this.errorState != null) {
                        break;
                    }
                }
            } catch (Throwable th) {
                if (!list.isEmpty()) {
                    synchronized (this.stateLock) {
                        int size = list.size();
                        while (i < size) {
                            recordFailedCompositionLocked(list.get(i));
                            i++;
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                throw th;
            }
        }
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.stateLock) {
            int size2 = list.size();
            while (i < size2) {
                recordFailedCompositionLocked(list.get(i));
                i++;
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordFailedCompositionLocked(ControlledComposition composition) {
        ArrayList arrayList = this.failedCompositions;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.failedCompositions = arrayList;
        }
        if (!arrayList.contains(composition)) {
            arrayList.add(composition);
        }
        removeKnownCompositionLocked(composition);
    }

    public final Object runRecomposeConcurrentlyAndApplyChanges(CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(coroutineContext, this, null), continuation);
        return recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a6, code lost:
    
        if (r2.withFrameNanos(r9, r0) != r1) goto L13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00a6 -> B:11:0x0040). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runFrameLoop(androidx.compose.runtime.MonotonicFrameClock r7, final androidx.compose.runtime.ProduceFrameSignal r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.runtime.Recomposer$runFrameLoop$1
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = (androidx.compose.runtime.Recomposer$runFrameLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = new androidx.compose.runtime.Recomposer$runFrameLoop$1
            r0.<init>(r6, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L65
            if (r2 == r4) goto L4d
            if (r2 != r3) goto L45
            java.lang.Object r6 = r0.L$4
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r0.L$3
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r0.L$2
            androidx.compose.runtime.ProduceFrameSignal r8 = (androidx.compose.runtime.ProduceFrameSignal) r8
            java.lang.Object r2 = r0.L$1
            androidx.compose.runtime.MonotonicFrameClock r2 = (androidx.compose.runtime.MonotonicFrameClock) r2
            java.lang.Object r5 = r0.L$0
            androidx.compose.runtime.Recomposer r5 = (androidx.compose.runtime.Recomposer) r5
            kotlin.ResultKt.throwOnFailure(r9)
        L40:
            r9 = r7
            r7 = r2
            r2 = r6
            r6 = r5
            goto L76
        L45:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L4d:
            java.lang.Object r6 = r0.L$4
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r0.L$3
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r0.L$2
            androidx.compose.runtime.ProduceFrameSignal r8 = (androidx.compose.runtime.ProduceFrameSignal) r8
            java.lang.Object r2 = r0.L$1
            androidx.compose.runtime.MonotonicFrameClock r2 = (androidx.compose.runtime.MonotonicFrameClock) r2
            java.lang.Object r5 = r0.L$0
            androidx.compose.runtime.Recomposer r5 = (androidx.compose.runtime.Recomposer) r5
            kotlin.ResultKt.throwOnFailure(r9)
            goto L8f
        L65:
            kotlin.ResultKt.throwOnFailure(r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.List r9 = (java.util.List) r9
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
        L76:
            java.lang.Object r5 = r6.stateLock
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.L$3 = r9
            r0.L$4 = r2
            r0.label = r4
            java.lang.Object r5 = r8.awaitFrameRequest(r5, r0)
            if (r5 != r1) goto L8b
            goto La8
        L8b:
            r5 = r6
            r6 = r2
            r2 = r7
            r7 = r9
        L8f:
            androidx.compose.runtime.Recomposer$runFrameLoop$2 r9 = new androidx.compose.runtime.Recomposer$runFrameLoop$2
            r9.<init>()
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r0.L$0 = r5
            r0.L$1 = r2
            r0.L$2 = r8
            r0.L$3 = r7
            r0.L$4 = r6
            r0.label = r3
            java.lang.Object r9 = r2.withFrameNanos(r9, r0)
            if (r9 != r1) goto L40
        La8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.runFrameLoop(androidx.compose.runtime.MonotonicFrameClock, androidx.compose.runtime.ProduceFrameSignal, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasSchedulingWork() {
        boolean z;
        synchronized (this.stateLock) {
            if (!this.snapshotInvalidations.isNotEmpty() && this.compositionInvalidations.getSize() == 0) {
                z = getHasBroadcastFrameClockAwaitersLocked();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitWorkAvailable(Continuation<? super Unit> continuation) {
        if (getHasSchedulingWork()) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        synchronized (this.stateLock) {
            if (!getHasSchedulingWork()) {
                this.workContinuation = cancellableContinuationImpl2;
                cancellableContinuationImpl2 = null;
            }
        }
        if (cancellableContinuationImpl2 != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m7870constructorimpl(Unit.INSTANCE));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object recompositionRunner(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.broadcastFrameClock, new Recomposer$recompositionRunner$2(this, function3, MonotonicFrameClockKt.getMonotonicFrameClock(continuation.getContext()), null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            if (this._state.getValue().compareTo(State.Idle) >= 0) {
                this._state.setValue(State.ShuttingDown);
            }
            Unit unit = Unit.INSTANCE;
        }
        Job.DefaultImpls.cancel$default((Job) this.effectJob, (CancellationException) null, 1, (Object) null);
    }

    public final void close() {
        if (this.effectJob.complete()) {
            synchronized (this.stateLock) {
                this.isClosed = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final Object join(Continuation<? super Unit> continuation) {
        Object first = FlowKt.first(getCurrentState(), new Recomposer$join$2(null), continuation);
        return first == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? first : Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void composeInitial$runtime_release(ControlledComposition composition, Function2<? super Composer, ? super Integer, Unit> content) {
        boolean isComposing = composition.isComposing();
        try {
            MutableSnapshot takeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, null));
            try {
                MutableSnapshot mutableSnapshot = takeMutableSnapshot;
                Snapshot makeCurrent = mutableSnapshot.makeCurrent();
                try {
                    composition.composeContent(content);
                    Unit unit = Unit.INSTANCE;
                    mutableSnapshot.restoreCurrent(makeCurrent);
                    applyAndCheck(takeMutableSnapshot);
                    if (!isComposing) {
                        Snapshot.INSTANCE.notifyObjectsInitialized();
                    }
                    synchronized (this.stateLock) {
                        if (this._state.getValue().compareTo(State.ShuttingDown) > 0 && !getKnownCompositions().contains(composition)) {
                            addKnownCompositionLocked(composition);
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                    try {
                        performInitialMovableContentInserts(composition);
                        try {
                            composition.applyChanges();
                            composition.applyLateChanges();
                            if (isComposing) {
                                return;
                            }
                            Snapshot.INSTANCE.notifyObjectsInitialized();
                        } catch (Throwable th) {
                            processCompositionError$default(this, th, null, false, 6, null);
                        }
                    } catch (Throwable th2) {
                        processCompositionError(th2, composition, true);
                    }
                } catch (Throwable th3) {
                    mutableSnapshot.restoreCurrent(makeCurrent);
                    throw th3;
                }
            } catch (Throwable th4) {
                applyAndCheck(takeMutableSnapshot);
                throw th4;
            }
        } catch (Throwable th5) {
            processCompositionError(th5, composition, true);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public ScatterSet<RecomposeScopeImpl> recomposePaused$runtime_release(ControlledComposition composition, ShouldPauseCallback shouldPause, ScatterSet<RecomposeScopeImpl> invalidScopes) {
        try {
            recordComposerModifications();
            composition.recordModificationsOf(ScatterSetWrapperKt.wrapIntoSet(invalidScopes));
            ShouldPauseCallback andSetShouldPauseCallback = composition.getAndSetShouldPauseCallback(shouldPause);
            try {
                ControlledComposition performRecompose = performRecompose(composition, null);
                if (performRecompose != null) {
                    performInitialMovableContentInserts(composition);
                    performRecompose.applyChanges();
                    performRecompose.applyLateChanges();
                }
                MutableScatterSet<RecomposeScopeImpl> mutableScatterSet = this.pausedScopes.get();
                return mutableScatterSet != null ? mutableScatterSet : ScatterSetKt.emptyScatterSet();
            } finally {
                composition.getAndSetShouldPauseCallback(andSetShouldPauseCallback);
            }
        } finally {
            this.pausedScopes.set(null);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportPausedScope$runtime_release(RecomposeScopeImpl scope) {
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet = this.pausedScopes.get();
        if (mutableScatterSet == null) {
            mutableScatterSet = ScatterSetKt.mutableScatterSetOf();
            this.pausedScopes.set(mutableScatterSet);
        }
        mutableScatterSet.add(scope);
    }

    private final void performInitialMovableContentInserts(ControlledComposition composition) {
        synchronized (this.stateLock) {
            List<MovableContentStateReference> list = this.movableContentAwaitingInsert;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (Intrinsics.areEqual(list.get(i).getComposition(), composition)) {
                    Unit unit = Unit.INSTANCE;
                    ArrayList arrayList = new ArrayList();
                    performInitialMovableContentInserts$fillToInsert(arrayList, this, composition);
                    while (!arrayList.isEmpty()) {
                        performInsertValues(arrayList, null);
                        performInitialMovableContentInserts$fillToInsert(arrayList, this, composition);
                    }
                    return;
                }
            }
        }
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer, ControlledComposition controlledComposition) {
        list.clear();
        synchronized (recomposer.stateLock) {
            Iterator<MovableContentStateReference> it = recomposer.movableContentAwaitingInsert.iterator();
            while (it.hasNext()) {
                MovableContentStateReference next = it.next();
                if (Intrinsics.areEqual(next.getComposition(), controlledComposition)) {
                    list.add(next);
                    it.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ControlledComposition performRecompose(final ControlledComposition composition, final MutableScatterSet<Object> modifiedValues) {
        Set<ControlledComposition> set;
        if (composition.isComposing() || composition.getDisposed() || ((set = this.compositionsRemoved) != null && set.contains(composition))) {
            return null;
        }
        MutableSnapshot takeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            MutableSnapshot mutableSnapshot = takeMutableSnapshot;
            Snapshot makeCurrent = mutableSnapshot.makeCurrent();
            if (modifiedValues != null) {
                try {
                    if (modifiedValues.isNotEmpty()) {
                        composition.prepareCompose(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$performRecompose$1$1
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
                                MutableScatterSet<Object> mutableScatterSet = modifiedValues;
                                ControlledComposition controlledComposition = composition;
                                Object[] objArr = mutableScatterSet.elements;
                                long[] jArr = mutableScatterSet.metadata;
                                int length = jArr.length - 2;
                                if (length < 0) {
                                    return;
                                }
                                int i = 0;
                                while (true) {
                                    long j = jArr[i];
                                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i2 = 8 - ((~(i - length)) >>> 31);
                                        for (int i3 = 0; i3 < i2; i3++) {
                                            if ((255 & j) < 128) {
                                                controlledComposition.recordWriteOf(objArr[(i << 3) + i3]);
                                            }
                                            j >>= 8;
                                        }
                                        if (i2 != 8) {
                                            return;
                                        }
                                    }
                                    if (i == length) {
                                        return;
                                    } else {
                                        i++;
                                    }
                                }
                            }
                        });
                    }
                } catch (Throwable th) {
                    mutableSnapshot.restoreCurrent(makeCurrent);
                    throw th;
                }
            }
            boolean recompose = composition.recompose();
            mutableSnapshot.restoreCurrent(makeCurrent);
            if (recompose) {
                return composition;
            }
            return null;
        } finally {
            applyAndCheck(takeMutableSnapshot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void discardUnusedMovableContentState() {
        int i;
        MutableObjectList emptyObjectList;
        synchronized (this.stateLock) {
            if (MultiValueMap.m3895isNotEmptyimpl(this.movableContentRemoved)) {
                ObjectList m3900valuesimpl = MultiValueMap.m3900valuesimpl(this.movableContentRemoved);
                MultiValueMap.m3885clearimpl(this.movableContentRemoved);
                this.movableContentNestedStatesAvailable.clear();
                MultiValueMap.m3885clearimpl(this.movableContentNestedExtractionsPending);
                MutableObjectList mutableObjectList = new MutableObjectList(m3900valuesimpl.getSize());
                Object[] objArr = m3900valuesimpl.content;
                int i2 = m3900valuesimpl._size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MovableContentStateReference movableContentStateReference = (MovableContentStateReference) objArr[i3];
                    mutableObjectList.add(TuplesKt.to(movableContentStateReference, this.movableContentStatesAvailable.get(movableContentStateReference)));
                }
                emptyObjectList = mutableObjectList;
                this.movableContentStatesAvailable.clear();
            } else {
                emptyObjectList = ObjectListKt.emptyObjectList();
            }
        }
        Object[] objArr2 = emptyObjectList.content;
        int i4 = emptyObjectList._size;
        for (i = 0; i < i4; i++) {
            Pair pair = (Pair) objArr2[i];
            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) pair.component1();
            MovableContentState movableContentState = (MovableContentState) pair.component2();
            if (movableContentState != null) {
                movableContentStateReference2.getComposition().disposeUnusedMovableContent(movableContentState);
            }
        }
    }

    private final Function1<Object, Unit> readObserverOf(final ControlledComposition composition) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer$readObserverOf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                ControlledComposition.this.recordReadOf(obj);
            }
        };
    }

    private final Function1<Object, Unit> writeObserverOf(final ControlledComposition composition, final MutableScatterSet<Object> modifiedValues) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer$writeObserverOf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                ControlledComposition.this.recordWriteOf(obj);
                MutableScatterSet<Object> mutableScatterSet = modifiedValues;
                if (mutableScatterSet != null) {
                    mutableScatterSet.add(obj);
                }
            }
        };
    }

    private final <T> T composing(ControlledComposition composition, MutableScatterSet<Object> modifiedValues, Function0<? extends T> block) {
        MutableSnapshot takeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            MutableSnapshot mutableSnapshot = takeMutableSnapshot;
            Snapshot makeCurrent = mutableSnapshot.makeCurrent();
            try {
                return block.invoke();
            } finally {
                mutableSnapshot.restoreCurrent(makeCurrent);
            }
        } finally {
            applyAndCheck(takeMutableSnapshot);
        }
    }

    private final void applyAndCheck(MutableSnapshot snapshot) {
        try {
            if (snapshot.apply() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
            }
        } finally {
            snapshot.dispose();
        }
    }

    public final boolean getHasPendingWork() {
        boolean z;
        synchronized (this.stateLock) {
            if (!this.snapshotInvalidations.isNotEmpty() && this.compositionInvalidations.getSize() == 0 && this.concurrentCompositionsOutstanding <= 0 && this.compositionsAwaitingApply.isEmpty()) {
                z = getHasBroadcastFrameClockAwaitersLocked();
            }
        }
        return z;
    }

    private final boolean getHasFrameWorkLocked() {
        return this.compositionInvalidations.getSize() != 0 || getHasBroadcastFrameClockAwaitersLocked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasConcurrentFrameWorkLocked() {
        return !this.compositionsAwaitingApply.isEmpty() || getHasBroadcastFrameClockAwaitersLocked();
    }

    public final Object awaitIdle(Continuation<? super Unit> continuation) {
        Object collect = FlowKt.collect(FlowKt.takeWhile(getCurrentState(), new Recomposer$awaitIdle$2(null)), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public final void pauseCompositionFrameClock() {
        synchronized (this.stateLock) {
            this.frameClockPaused = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void resumeCompositionFrameClock() {
        CancellableContinuation<Unit> cancellableContinuation;
        synchronized (this.stateLock) {
            if (this.frameClockPaused) {
                this.frameClockPaused = false;
                cancellableContinuation = deriveStateLocked();
            } else {
                cancellableContinuation = null;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m7870constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingCallByInformation$runtime_release() {
        return _hotReloadEnabled.get().booleanValue();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void unregisterComposition$runtime_release(ControlledComposition composition) {
        synchronized (this.stateLock) {
            removeKnownCompositionLocked(composition);
            this.compositionInvalidations.remove(composition);
            this.compositionsAwaitingApply.remove(composition);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidate$runtime_release(ControlledComposition composition) {
        CancellableContinuation<Unit> cancellableContinuation;
        synchronized (this.stateLock) {
            if (this.compositionInvalidations.contains(composition)) {
                cancellableContinuation = null;
            } else {
                this.compositionInvalidations.add(composition);
                cancellableContinuation = deriveStateLocked();
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m7870constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidateScope$runtime_release(RecomposeScopeImpl scope) {
        CancellableContinuation<Unit> deriveStateLocked;
        synchronized (this.stateLock) {
            this.snapshotInvalidations.add(scope);
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            deriveStateLocked.resumeWith(Result.m7870constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void insertMovableContent$runtime_release(MovableContentStateReference reference) {
        CancellableContinuation<Unit> deriveStateLocked;
        synchronized (this.stateLock) {
            this.movableContentAwaitingInsert.add(reference);
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            deriveStateLocked.resumeWith(Result.m7870constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void deletedMovableContent$runtime_release(MovableContentStateReference reference) {
        synchronized (this.stateLock) {
            MultiValueMap.m3883addimpl(this.movableContentRemoved, reference.getContent$runtime_release(), reference);
            if (reference.getNestedReferences$runtime_release() != null) {
                deletedMovableContent$lambda$73$recordNestedStatesOf(this, reference, reference);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private static final void deletedMovableContent$lambda$73$recordNestedStatesOf(Recomposer recomposer, MovableContentStateReference movableContentStateReference, MovableContentStateReference movableContentStateReference2) {
        List<MovableContentStateReference> nestedReferences$runtime_release = movableContentStateReference2.getNestedReferences$runtime_release();
        if (nestedReferences$runtime_release != null) {
            int size = nestedReferences$runtime_release.size();
            for (int i = 0; i < size; i++) {
                MovableContentStateReference movableContentStateReference3 = nestedReferences$runtime_release.get(i);
                recomposer.movableContentNestedStatesAvailable.add(movableContentStateReference3.getContent$runtime_release(), new NestedMovableContent(movableContentStateReference3, movableContentStateReference));
                deletedMovableContent$lambda$73$recordNestedStatesOf(recomposer, movableContentStateReference, movableContentStateReference3);
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void movableContentStateReleased$runtime_release(MovableContentStateReference reference, MovableContentState data, Applier<?> applier) {
        synchronized (this.stateLock) {
            this.movableContentStatesAvailable.set(reference, data);
            ObjectList<MovableContentStateReference> m3892getimpl = MultiValueMap.m3892getimpl(this.movableContentNestedExtractionsPending, reference);
            if (m3892getimpl.isNotEmpty()) {
                ScatterMap<MovableContentStateReference, MovableContentState> extractNestedStates$runtime_release = data.extractNestedStates$runtime_release(applier, m3892getimpl);
                Object[] objArr = extractNestedStates$runtime_release.keys;
                Object[] objArr2 = extractNestedStates$runtime_release.values;
                long[] jArr = extractNestedStates$runtime_release.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128) {
                                    int i4 = (i << 3) + i3;
                                    Object obj = objArr[i4];
                                    this.movableContentStatesAvailable.set((MovableContentStateReference) obj, (MovableContentState) objArr2[i4]);
                                }
                                j >>= 8;
                            }
                            if (i2 != 8) {
                                break;
                            }
                        }
                        if (i == length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportRemovedComposition$runtime_release(ControlledComposition composition) {
        synchronized (this.stateLock) {
            LinkedHashSet linkedHashSet = this.compositionsRemoved;
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                this.compositionsRemoved = linkedHashSet;
            }
            linkedHashSet.add(composition);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference reference) {
        MovableContentState remove;
        synchronized (this.stateLock) {
            remove = this.movableContentStatesAvailable.remove(reference);
        }
        return remove;
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010\u0016\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0017J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0000¢\u0006\u0002\b\u0019J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0000¢\u0006\u0002\b\u001dJ\u0015\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J\u0015\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0001H\u0000¢\u0006\u0002\b$J\u0014\u0010%\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010&\u001a\u00020\u0001H\u0000¢\u0006\u0002\b'J\u0015\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0005H\u0000¢\u0006\u0002\b*R.\u0010\u0003\u001a\"\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004j\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000bR\u00020\f0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006+"}, d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "()V", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/internal/AtomicReference;", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "addRunning", "", "info", "clearErrors", "clearErrors$runtime_release", "currentRunningRecomposers", "currentRunningRecomposers$runtime_release", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime_release", "invalidateGroupsWithKey", "key", "", "invalidateGroupsWithKey$runtime_release", "loadStateAndComposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime_release", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime_release", "setHotReloadEnabled", "value", "setHotReloadEnabled$runtime_release", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StateFlow<Set<RecomposerInfo>> getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        public final Set<RecomposerInfo> currentRunningRecomposers$runtime_release() {
            return (Set) Recomposer._runningRecomposers.getValue();
        }

        public final void setHotReloadEnabled$runtime_release(boolean value) {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(value));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addRunning(RecomposerInfoImpl info) {
            PersistentSet persistentSet;
            PersistentSet add;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                add = persistentSet.add((PersistentSet) info);
                if (persistentSet == add) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, add));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeRunning(RecomposerInfoImpl info) {
            PersistentSet persistentSet;
            PersistentSet remove;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                remove = persistentSet.remove((PersistentSet) info);
                if (persistentSet == remove) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, remove));
        }

        public final Object saveStateAndDisposeForHotReload$runtime_release() {
            Recomposer._hotReloadEnabled.set(true);
            Iterable iterable = (Iterable) Recomposer._runningRecomposers.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, ((RecomposerInfoImpl) it.next()).saveStateAndDisposeForHotReload());
            }
            return arrayList;
        }

        public final void loadStateAndComposeForHotReload$runtime_release(Object token) {
            Recomposer._hotReloadEnabled.set(true);
            Iterator it = ((Iterable) Recomposer._runningRecomposers.getValue()).iterator();
            while (it.hasNext()) {
                ((RecomposerInfoImpl) it.next()).resetErrorState();
            }
            Intrinsics.checkNotNull(token, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.runtime.Recomposer.HotReloadable>");
            List list = (List) token;
            List list2 = list;
            int size = list2.size();
            for (int i = 0; i < size; i++) {
                ((HotReloadable) list.get(i)).resetContent();
            }
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((HotReloadable) list.get(i2)).recompose();
            }
            Iterator it2 = ((Iterable) Recomposer._runningRecomposers.getValue()).iterator();
            while (it2.hasNext()) {
                ((RecomposerInfoImpl) it2.next()).retryFailedCompositions();
            }
        }

        public final void invalidateGroupsWithKey$runtime_release(int key) {
            Recomposer._hotReloadEnabled.set(true);
            for (RecomposerInfoImpl recomposerInfoImpl : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorInfo currentError = recomposerInfoImpl.getCurrentError();
                if (currentError == null || currentError.getRecoverable()) {
                    recomposerInfoImpl.resetErrorState();
                    recomposerInfoImpl.invalidateGroupsWithKey(key);
                    recomposerInfoImpl.retryFailedCompositions();
                }
            }
        }

        public final List<RecomposerErrorInfo> getCurrentErrors$runtime_release() {
            Iterable iterable = (Iterable) Recomposer._runningRecomposers.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                RecomposerErrorInfo currentError = ((RecomposerInfoImpl) it.next()).getCurrentError();
                if (currentError != null) {
                    arrayList.add(currentError);
                }
            }
            return arrayList;
        }

        public final void clearErrors$runtime_release() {
            Iterable iterable = (Iterable) Recomposer._runningRecomposers.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                RecomposerErrorState resetErrorState = ((RecomposerInfoImpl) it.next()).resetErrorState();
                if (resetErrorState != null) {
                    arrayList.add(resetErrorState);
                }
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public ScatterSet<RecomposeScopeImpl> composeInitialPaused$runtime_release(ControlledComposition composition, ShouldPauseCallback shouldPause, Function2<? super Composer, ? super Integer, Unit> content) {
        try {
            ShouldPauseCallback andSetShouldPauseCallback = composition.getAndSetShouldPauseCallback(shouldPause);
            try {
                composeInitial$runtime_release(composition, content);
                MutableScatterSet<RecomposeScopeImpl> mutableScatterSet = this.pausedScopes.get();
                return mutableScatterSet != null ? mutableScatterSet : ScatterSetKt.emptyScatterSet();
            } finally {
                composition.getAndSetShouldPauseCallback(andSetShouldPauseCallback);
            }
        } finally {
            this.pausedScopes.set(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01f0, code lost:
    
        r11 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x016b, code lost:
    
        r0 = r11.size();
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0173, code lost:
    
        if (r2 >= r0) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x017f, code lost:
    
        if (r11.get(r2).getSecond() == null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0181, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0184, code lost:
    
        r0 = new java.util.ArrayList(r11.size());
        r2 = r11.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0195, code lost:
    
        if (r3 >= r2) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0197, code lost:
    
        r4 = r11.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01a1, code lost:
    
        if (r4.getSecond() != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a3, code lost:
    
        r4 = r4.getFirst();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ab, code lost:
    
        if (r4 == null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01ad, code lost:
    
        r0.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b3, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01aa, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01b6, code lost:
    
        r0 = r0;
        r2 = r17.stateLock;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01ba, code lost:
    
        monitor-enter(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01bb, code lost:
    
        kotlin.collections.CollectionsKt.addAll(r17.movableContentAwaitingInsert, r0);
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c6, code lost:
    
        monitor-exit(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01c7, code lost:
    
        r0 = new java.util.ArrayList(r11.size());
        r2 = r11.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d8, code lost:
    
        if (r3 >= r2) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01da, code lost:
    
        r4 = r11.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01e5, code lost:
    
        if (r4.getSecond() == null) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e7, code lost:
    
        r0.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01ed, code lost:
    
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<androidx.compose.runtime.ControlledComposition> performInsertValues(java.util.List<androidx.compose.runtime.MovableContentStateReference> r18, androidx.collection.MutableScatterSet<java.lang.Object> r19) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.performInsertValues(java.util.List, androidx.collection.MutableScatterSet):java.util.List");
    }
}
