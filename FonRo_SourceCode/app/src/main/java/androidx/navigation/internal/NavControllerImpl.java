package androidx.navigation.internal;

import android.net.Uri;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryState;
import androidx.navigation.NavController;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.NavOptionsBuilderKt;
import androidx.navigation.NavUriKt;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.SupportingPane;
import androidx.navigation.serialization.RouteSerializerKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.SerializersKt;

/* compiled from: NavControllerImpl.kt */
@Metadata(d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u008e\u00022\u00020\u0001:\u0002\u008e\u0002B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020,H\u0000¢\u0006\u0002\bFJ\u0017\u0010G\u001a\u0004\u0018\u00010,2\u0006\u0010D\u001a\u00020,H\u0000¢\u0006\u0002\bHJm\u0010\u0088\u0001\u001a\u00020\u00062\u000f\u0010\u0089\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020u0t2\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020,012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u00012$\b\u0002\u0010\u008f\u0001\u001a\u001d\u0012\u0013\u0012\u00110,¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(|\u0012\u0004\u0012\u00020\u00060yH\u0000¢\u0006\u0003\b\u0090\u0001JZ\u0010\u0091\u0001\u001a\u00020\u00062\u000f\u0010\u0089\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020u0t2\u0007\u0010\u0082\u0001\u001a\u00020,2\b\u0010\u0092\u0001\u001a\u00030\u0086\u00012%\b\u0002\u0010\u008f\u0001\u001a\u001e\u0012\u0014\u0012\u00120,¢\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0082\u0001\u0012\u0004\u0012\u00020\u00060yH\u0000¢\u0006\u0003\b\u0093\u0001J$\u0010\u0094\u0001\u001a\u00020\u00062\u000b\u0010\u0095\u0001\u001a\u00060vR\u00020\u00032\u0006\u0010|\u001a\u00020,H\u0000¢\u0006\u0003\b\u0096\u0001J)\u0010\u0097\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020u2\u000f\u0010\u0099\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eH\u0000¢\u0006\u0003\b\u009a\u0001J>\u0010\u009b\u0001\u001a\u00020\u00062\u000b\u0010\u0095\u0001\u001a\u00060vR\u00020\u00032\u0007\u0010\u0082\u0001\u001a\u00020,2\b\u0010\u0092\u0001\u001a\u00030\u0086\u00012\r\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¢\u0006\u0003\b\u009d\u0001J4\u0010\u009e\u0001\u001a\u00020\u00062\u000b\u0010\u0095\u0001\u001a\u00060vR\u00020\u00032\u0007\u0010\u009f\u0001\u001a\u00020,2\r\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¢\u0006\u0003\b \u0001J\u0018\u0010¡\u0001\u001a\u00020\u00062\u0007\u0010\u009f\u0001\u001a\u00020,H\u0000¢\u0006\u0003\b¢\u0001J\u0018\u0010£\u0001\u001a\u00020\u00062\u0007\u0010¤\u0001\u001a\u00020]H\u0000¢\u0006\u0003\b¥\u0001J\u0018\u0010¦\u0001\u001a\u00020\u00062\u0007\u0010¤\u0001\u001a\u00020]H\u0000¢\u0006\u0003\b§\u0001J\u0010\u0010¨\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\b©\u0001J#\u0010¨\u0001\u001a\u00030\u0086\u00012\u0007\u0010ª\u0001\u001a\u00020J2\b\u0010«\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\b©\u0001J-\u0010¨\u0001\u001a\u00030\u0086\u00012\u0007\u0010ª\u0001\u001a\u00020J2\b\u0010«\u0001\u001a\u00030\u0086\u00012\b\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\b©\u0001J-\u0010¨\u0001\u001a\u00030\u0086\u00012\u0007\u0010¬\u0001\u001a\u00020K2\b\u0010«\u0001\u001a\u00030\u0086\u00012\b\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\b©\u0001J@\u0010¨\u0001\u001a\u00030\u0086\u0001\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\u000f\u0010¬\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00ad\u00010®\u00012\b\u0010«\u0001\u001a\u00030\u0086\u00012\b\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\b©\u0001J<\u0010¨\u0001\u001a\u00030\u0086\u0001\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\b\u0010¬\u0001\u001a\u0003H\u00ad\u00012\b\u0010«\u0001\u001a\u00030\u0086\u00012\b\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0006\b©\u0001\u0010¯\u0001J/\u0010\u0091\u0001\u001a\u00030\u0086\u00012\u0007\u0010ª\u0001\u001a\u00020J2\b\u0010«\u0001\u001a\u00030\u0086\u00012\n\b\u0002\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\b\u0093\u0001J>\u0010\u0091\u0001\u001a\u00030\u0086\u0001\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\b\u0010¬\u0001\u001a\u0003H\u00ad\u00012\b\u0010«\u0001\u001a\u00030\u0086\u00012\n\b\u0002\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0006\b\u0093\u0001\u0010¯\u0001J-\u0010\u0091\u0001\u001a\u00030\u0086\u00012\u0007\u0010¬\u0001\u001a\u00020K2\b\u0010«\u0001\u001a\u00030\u0086\u00012\b\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\b\u0093\u0001J@\u0010°\u0001\u001a\u00030\u0086\u00012\u0011\u0010±\u0001\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030t012\u0007\u0010²\u0001\u001a\u00020u2\b\u0010«\u0001\u001a\u00030\u0086\u00012\b\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\b³\u0001J'\u0010´\u0001\u001a\u00020\u00062\u0007\u0010\u0082\u0001\u001a\u00020,2\r\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¢\u0006\u0003\b¶\u0001J5\u0010·\u0001\u001a\u00020\u00062\u0007\u0010\u0082\u0001\u001a\u00020,2\n\b\u0002\u0010\u0092\u0001\u001a\u00030\u0086\u00012\u000f\b\u0002\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020N0+H\u0000¢\u0006\u0003\b¹\u0001J\u0019\u0010º\u0001\u001a\u00030\u0086\u00012\u0007\u0010¬\u0001\u001a\u00020KH\u0000¢\u0006\u0003\b»\u0001J\u0019\u0010º\u0001\u001a\u00030\u0086\u00012\u0007\u0010ª\u0001\u001a\u00020JH\u0000¢\u0006\u0003\b»\u0001J,\u0010º\u0001\u001a\u00030\u0086\u0001\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\u000f\u0010¬\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00ad\u00010®\u0001H\u0000¢\u0006\u0003\b»\u0001J(\u0010º\u0001\u001a\u00030\u0086\u0001\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\b\u0010¬\u0001\u001a\u0003H\u00ad\u0001H\u0000¢\u0006\u0006\b»\u0001\u0010¼\u0001J\u0019\u0010½\u0001\u001a\u00030\u0086\u00012\u0007\u0010ª\u0001\u001a\u00020JH\u0000¢\u0006\u0003\b¾\u0001J\u0019\u0010½\u0001\u001a\u00030\u0086\u00012\u0007\u0010¬\u0001\u001a\u00020KH\u0000¢\u0006\u0003\b¾\u0001J\u0010\u0010Á\u0001\u001a\u00030\u0086\u0001H\u0000¢\u0006\u0003\bÂ\u0001J\u000f\u0010Ã\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0003\bÄ\u0001J\u0015\u0010Å\u0001\u001a\b\u0012\u0004\u0012\u00020,01H\u0000¢\u0006\u0003\bÆ\u0001J'\u0010Ç\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00142\u000f\u0010È\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eH\u0000¢\u0006\u0002\b\u001bJ \u0010É\u0001\u001a\u00020\u00062\u000f\u0010È\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eH\u0000¢\u0006\u0003\bÊ\u0001J\u001b\u0010Ë\u0001\u001a\u0004\u0018\u00010K2\b\u0010Ì\u0001\u001a\u00030Í\u0001H\u0000¢\u0006\u0003\bÎ\u0001J'\u0010Ò\u0001\u001a\u0004\u0018\u00010u2\u0007\u0010ª\u0001\u001a\u00020J2\u000b\b\u0002\u0010Ó\u0001\u001a\u0004\u0018\u00010uH\u0000¢\u0006\u0003\bÔ\u0001J:\u0010Õ\u0001\u001a\u0004\u0018\u00010u2\u0007\u0010\u0098\u0001\u001a\u00020u2\u0007\u0010ª\u0001\u001a\u00020J2\b\u0010Ö\u0001\u001a\u00030\u0086\u00012\u000b\b\u0002\u0010Ó\u0001\u001a\u0004\u0018\u00010uH\u0000¢\u0006\u0003\b×\u0001J\u001a\u0010Ò\u0001\u001a\u0004\u0018\u00010u2\u0007\u0010¬\u0001\u001a\u00020KH\u0000¢\u0006\u0003\bÔ\u0001J\u000f\u0010Ø\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0003\bÙ\u0001J'\u0010Ú\u0001\u001a\u00020K\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\b\u0010¬\u0001\u001a\u0003H\u00ad\u0001H\u0000¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001J\u001e\u0010Ý\u0001\u001a\u00020\u00062\r\u0010Ì\u0001\u001a\b0Þ\u0001j\u0003`ß\u0001H\u0000¢\u0006\u0003\bà\u0001J*\u0010Ý\u0001\u001a\u00020\u00062\r\u0010Ì\u0001\u001a\b0Þ\u0001j\u0003`ß\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0000¢\u0006\u0003\bà\u0001J6\u0010Ý\u0001\u001a\u00020\u00062\r\u0010Ì\u0001\u001a\b0Þ\u0001j\u0003`ß\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0000¢\u0006\u0003\bà\u0001J\u0019\u0010Ý\u0001\u001a\u00020\u00062\b\u0010á\u0001\u001a\u00030â\u0001H\u0000¢\u0006\u0003\bà\u0001J%\u0010Ý\u0001\u001a\u00020\u00062\b\u0010á\u0001\u001a\u00030â\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0000¢\u0006\u0003\bà\u0001J1\u0010Ý\u0001\u001a\u00020\u00062\b\u0010á\u0001\u001a\u00030â\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0000¢\u0006\u0003\bà\u0001JA\u0010Ý\u0001\u001a\u00020\u00062\u0007\u0010ã\u0001\u001a\u00020u2\u000f\u0010ä\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0000¢\u0006\u0003\bà\u0001J$\u0010å\u0001\u001a\u00030\u0086\u00012\u0007\u0010ã\u0001\u001a\u00020u2\u000f\u0010ä\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eH\u0002J<\u0010æ\u0001\u001a\u00030\u0086\u00012\u0007\u0010ç\u0001\u001a\u00020J2\u000f\u0010ä\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0002J\u0013\u0010æ\u0001\u001a\u00030\u0086\u00012\u0007\u0010¬\u0001\u001a\u00020KH\u0002JB\u0010è\u0001\u001a\u00030\u0086\u00012\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020,012\u000f\u0010ä\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0002J \u0010é\u0001\u001a\b\u0012\u0004\u0012\u00020,012\u000f\u0010ê\u0001\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010+H\u0002J<\u0010ë\u0001\u001a\u00020\u00062\u0007\u0010ã\u0001\u001a\u00020u2\u000f\u0010ì\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e2\u0006\u0010|\u001a\u00020,2\u000f\b\u0002\u0010í\u0001\u001a\b\u0012\u0004\u0012\u00020,01H\u0002J4\u0010Ý\u0001\u001a\u00020\u00062\u0007\u0010¬\u0001\u001a\u00020K2\u001a\u0010î\u0001\u001a\u0015\u0012\u0005\u0012\u00030ï\u0001\u0012\u0004\u0012\u00020\u00060y¢\u0006\u0003\bð\u0001H\u0000¢\u0006\u0003\bà\u0001J2\u0010Ý\u0001\u001a\u00020\u00062\u0007\u0010¬\u0001\u001a\u00020K2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\f\b\u0002\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0000¢\u0006\u0003\bà\u0001JC\u0010Ý\u0001\u001a\u00020\u0006\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\b\u0010¬\u0001\u001a\u0003H\u00ad\u00012\u001a\u0010î\u0001\u001a\u0015\u0012\u0005\u0012\u00030ï\u0001\u0012\u0004\u0012\u00020\u00060y¢\u0006\u0003\bð\u0001H\u0000¢\u0006\u0006\bà\u0001\u0010ñ\u0001JA\u0010Ý\u0001\u001a\u00020\u0006\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\b\u0010¬\u0001\u001a\u0003H\u00ad\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\f\b\u0002\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0000¢\u0006\u0006\bà\u0001\u0010ò\u0001J\u0017\u0010\u0092\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eH\u0000¢\u0006\u0003\bó\u0001J \u0010ô\u0001\u001a\u00020\u00062\u000f\u0010õ\u0001\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eH\u0000¢\u0006\u0003\bö\u0001J\u0018\u0010÷\u0001\u001a\u00020\u00062\u0007\u0010ø\u0001\u001a\u00020QH\u0001¢\u0006\u0003\bù\u0001J\u0019\u0010ú\u0001\u001a\u00020\u00062\b\u0010û\u0001\u001a\u00030ü\u0001H\u0000¢\u0006\u0003\bý\u0001J\u0019\u0010þ\u0001\u001a\u00030ÿ\u00012\u0007\u0010\u0080\u0002\u001a\u00020JH\u0000¢\u0006\u0003\b\u0081\u0002J\u0018\u0010\u0082\u0002\u001a\u00020,2\u0007\u0010ª\u0001\u001a\u00020JH\u0000¢\u0006\u0003\b\u0083\u0002J\u0018\u0010\u0082\u0002\u001a\u00020,2\u0007\u0010¬\u0001\u001a\u00020KH\u0000¢\u0006\u0003\b\u0083\u0002J+\u0010\u0082\u0002\u001a\u00020,\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\u000f\u0010¬\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00ad\u00010®\u0001H\u0000¢\u0006\u0003\b\u0083\u0002J'\u0010\u0082\u0002\u001a\u00020,\"\t\b\u0000\u0010\u00ad\u0001*\u00020\u00012\b\u0010¬\u0001\u001a\u0003H\u00ad\u0001H\u0000¢\u0006\u0006\b\u0083\u0002\u0010\u0084\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00148A@AX\u0080\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u001c\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010#\u001a\u000e\u0012\b\u0012\u00060\u001dj\u0002`\u001e\u0018\u00010$X\u0080\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R \u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0100X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\"\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01058AX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R \u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0100X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u00103R \u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0105X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00107R \u0010<\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,0=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R \u0010@\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020A0=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010?R\"\u0010I\u001a\u0010\u0012\u0004\u0012\u00020J\u0012\u0006\u0012\u0004\u0018\u00010K0=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010?R&\u0010M\u001a\u0014\u0012\u0004\u0012\u00020K\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0+0=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010?R\"\u0010R\u001a\u0004\u0018\u00010Q2\b\u0010P\u001a\u0004\u0018\u00010Q@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u001c\u0010U\u001a\u0004\u0018\u00010VX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u001c\u0010`\u001a\u00020a8@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0014\u0010f\u001a\u00020gX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u001a\u0010j\u001a\u00020kX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR$\u0010p\u001a\u00020k2\u0006\u0010p\u001a\u00020k8@@AX\u0080\u000e¢\u0006\f\u001a\u0004\bq\u0010m\"\u0004\br\u0010oR,\u0010s\u001a\u001a\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020u0t\u0012\b\u0012\u00060vR\u00020\u00030=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010?R8\u0010x\u001a\u001f\u0012\u0013\u0012\u00110,¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(|\u0012\u0004\u0012\u00020\u0006\u0018\u00010yX\u0080\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R<\u0010\u0081\u0001\u001a \u0012\u0014\u0012\u00120,¢\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0082\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010yX\u0080\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0083\u0001\u0010~\"\u0006\b\u0084\u0001\u0010\u0080\u0001R#\u0010\u0085\u0001\u001a\u000f\u0012\u0004\u0012\u00020,\u0012\u0005\u0012\u00030\u0086\u00010=X\u0080\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010?R\u000f\u0010¿\u0001\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010À\u0001\u001a\b\u0012\u0004\u0012\u00020,0\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010Ï\u0001\u001a\u0004\u0018\u00010u8@X\u0080\u0004¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Ñ\u0001R\u0019\u0010\u0085\u0002\u001a\u0004\u0018\u00010,8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0086\u0002\u0010\u0087\u0002R\u001e\u0010\u0088\u0002\u001a\t\u0012\u0004\u0012\u00020,0\u0089\u0002X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0002\u0010\u008b\u0002R\u0019\u0010\u008c\u0002\u001a\u0004\u0018\u00010,8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u008d\u0002\u0010\u0087\u0002¨\u0006\u008f\u0002"}, d2 = {"Landroidx/navigation/internal/NavControllerImpl;", "", "navController", "Landroidx/navigation/NavController;", "updateOnBackPressedCallbackEnabledCallback", "Lkotlin/Function0;", "", "<init>", "(Landroidx/navigation/NavController;Lkotlin/jvm/functions/Function0;)V", "getNavController", "()Landroidx/navigation/NavController;", "getUpdateOnBackPressedCallbackEnabledCallback", "()Lkotlin/jvm/functions/Function0;", "setUpdateOnBackPressedCallbackEnabledCallback", "(Lkotlin/jvm/functions/Function0;)V", "navContext", "Landroidx/navigation/internal/NavContext;", "getNavContext", "()Landroidx/navigation/internal/NavContext;", "_graph", "Landroidx/navigation/NavGraph;", "get_graph$navigation_runtime_release", "()Landroidx/navigation/NavGraph;", "set_graph$navigation_runtime_release", "(Landroidx/navigation/NavGraph;)V", "graph", "getGraph$navigation_runtime_release", "setGraph$navigation_runtime_release", "navigatorStateToRestore", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "getNavigatorStateToRestore$navigation_runtime_release", "()Landroid/os/Bundle;", "setNavigatorStateToRestore$navigation_runtime_release", "(Landroid/os/Bundle;)V", "backStackToRestore", "", "getBackStackToRestore$navigation_runtime_release", "()[Landroid/os/Bundle;", "setBackStackToRestore$navigation_runtime_release", "([Landroid/os/Bundle;)V", "[Landroid/os/Bundle;", "backQueue", "Lkotlin/collections/ArrayDeque;", "Landroidx/navigation/NavBackStackEntry;", "getBackQueue$navigation_runtime_release", "()Lkotlin/collections/ArrayDeque;", "_currentBackStack", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "get_currentBackStack$navigation_runtime_release", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "currentBackStack", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentBackStack$navigation_runtime_release", "()Lkotlinx/coroutines/flow/StateFlow;", "_visibleEntries", "get_visibleEntries$navigation_runtime_release", "visibleEntries", "getVisibleEntries$navigation_runtime_release", "childToParentEntries", "", "getChildToParentEntries$navigation_runtime_release", "()Ljava/util/Map;", "parentToChildCount", "Landroidx/navigation/internal/AtomicInt;", "getParentToChildCount$navigation_runtime_release", "linkChildToParent", "child", "parent", "linkChildToParent$navigation_runtime_release", "unlinkChildFromParent", "unlinkChildFromParent$navigation_runtime_release", "backStackMap", "", "", "getBackStackMap$navigation_runtime_release", "backStackStates", "Landroidx/navigation/NavBackStackEntryState;", "getBackStackStates$navigation_runtime_release", "value", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "getLifecycleOwner$navigation_runtime_release", "()Landroidx/lifecycle/LifecycleOwner;", "viewModel", "Landroidx/navigation/NavControllerViewModel;", "getViewModel$navigation_runtime_release", "()Landroidx/navigation/NavControllerViewModel;", "setViewModel$navigation_runtime_release", "(Landroidx/navigation/NavControllerViewModel;)V", "onDestinationChangedListeners", "", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "getOnDestinationChangedListeners$navigation_runtime_release", "()Ljava/util/List;", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "getHostLifecycleState$navigation_runtime_release", "()Landroidx/lifecycle/Lifecycle$State;", "setHostLifecycleState$navigation_runtime_release", "(Landroidx/lifecycle/Lifecycle$State;)V", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "getLifecycleObserver$navigation_runtime_release", "()Landroidx/lifecycle/LifecycleObserver;", "_navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "get_navigatorProvider$navigation_runtime_release", "()Landroidx/navigation/NavigatorProvider;", "set_navigatorProvider$navigation_runtime_release", "(Landroidx/navigation/NavigatorProvider;)V", "navigatorProvider", "getNavigatorProvider$navigation_runtime_release", "setNavigatorProvider$navigation_runtime_release", "navigatorState", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/NavController$NavControllerNavigatorState;", "getNavigatorState$navigation_runtime_release", "addToBackStackHandler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "backStackEntry", "getAddToBackStackHandler$navigation_runtime_release", "()Lkotlin/jvm/functions/Function1;", "setAddToBackStackHandler$navigation_runtime_release", "(Lkotlin/jvm/functions/Function1;)V", "popFromBackStackHandler", "popUpTo", "getPopFromBackStackHandler$navigation_runtime_release", "setPopFromBackStackHandler$navigation_runtime_release", "entrySavedState", "", "getEntrySavedState$navigation_runtime_release", "navigateInternal", "navigator", "entries", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "handler", "navigateInternal$navigation_runtime_release", "popBackStackInternal", "saveState", "popBackStackInternal$navigation_runtime_release", "push", "state", "push$navigation_runtime_release", "createBackStackEntry", FirebaseAnalytics.Param.DESTINATION, "arguments", "createBackStackEntry$navigation_runtime_release", "pop", "superCallback", "pop$navigation_runtime_release", "markTransitionComplete", "entry", "markTransitionComplete$navigation_runtime_release", "prepareForTransition", "prepareForTransition$navigation_runtime_release", "addOnDestinationChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addOnDestinationChangedListener$navigation_runtime_release", "removeOnDestinationChangedListener", "removeOnDestinationChangedListener$navigation_runtime_release", "popBackStack", "popBackStack$navigation_runtime_release", "destinationId", "inclusive", "route", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "(Ljava/lang/Object;ZZ)Z", "executePopOperations", "popOperations", "foundDestination", "executePopOperations$navigation_runtime_release", "popBackStackFromNavigator", "onComplete", "popBackStackFromNavigator$navigation_runtime_release", "popEntryFromBackStack", "savedState", "popEntryFromBackStack$navigation_runtime_release", "clearBackStack", "clearBackStack$navigation_runtime_release", "(Ljava/lang/Object;)Z", "clearBackStackInternal", "clearBackStackInternal$navigation_runtime_release", "dispatchReentrantCount", "backStackEntriesToDispatch", "dispatchOnDestinationChanged", "dispatchOnDestinationChanged$navigation_runtime_release", "updateBackStackLifecycle", "updateBackStackLifecycle$navigation_runtime_release", "populateVisibleEntries", "populateVisibleEntries$navigation_runtime_release", "setGraph", "startDestinationArgs", "onGraphCreated", "onGraphCreated$navigation_runtime_release", "findInvalidDestinationDisplayNameInDeepLink", "deepLink", "", "findInvalidDestinationDisplayNameInDeepLink$navigation_runtime_release", "currentDestination", "getCurrentDestination$navigation_runtime_release", "()Landroidx/navigation/NavDestination;", "findDestination", "matchingDest", "findDestination$navigation_runtime_release", "findDestinationComprehensive", "searchChildren", "findDestinationComprehensive$navigation_runtime_release", "getTopGraph", "getTopGraph$navigation_runtime_release", "generateRouteFilled", "generateRouteFilled$navigation_runtime_release", "(Ljava/lang/Object;)Ljava/lang/String;", "navigate", "Landroid/net/Uri;", "Landroidx/navigation/NavUri;", "navigate$navigation_runtime_release", "request", "Landroidx/navigation/NavDeepLinkRequest;", "node", "args", "launchSingleTopInternal", "restoreStateInternal", "id", "executeRestoreState", "instantiateBackStack", "backStackState", "addEntryToBackStack", "finalArgs", "restoredEntries", "builder", "Landroidx/navigation/NavOptionsBuilder;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "saveState$navigation_runtime_release", "restoreState", "navState", "restoreState$navigation_runtime_release", "setLifecycleOwner", "owner", "setLifecycleOwner$navigation_runtime_release", "setViewModelStore", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "setViewModelStore$navigation_runtime_release", "getViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "navGraphId", "getViewModelStoreOwner$navigation_runtime_release", "getBackStackEntry", "getBackStackEntry$navigation_runtime_release", "(Ljava/lang/Object;)Landroidx/navigation/NavBackStackEntry;", "currentBackStackEntry", "getCurrentBackStackEntry$navigation_runtime_release", "()Landroidx/navigation/NavBackStackEntry;", "_currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "get_currentBackStackEntryFlow$navigation_runtime_release", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "previousBackStackEntry", "getPreviousBackStackEntry$navigation_runtime_release", "Companion", "navigation-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class NavControllerImpl {
    private static final String KEY_BACK_STACK = "android-support-nav:controller:backStack";
    private static final String KEY_BACK_STACK_DEST_IDS = "android-support-nav:controller:backStackDestIds";
    private static final String KEY_BACK_STACK_IDS = "android-support-nav:controller:backStackIds";
    private static final String KEY_BACK_STACK_STATES_IDS = "android-support-nav:controller:backStackStates";
    private static final String KEY_BACK_STACK_STATES_PREFIX = "android-support-nav:controller:backStackStates:";
    private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
    private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
    public static final String TAG = "NavController";
    private final MutableStateFlow<List<NavBackStackEntry>> _currentBackStack;
    private final MutableSharedFlow<NavBackStackEntry> _currentBackStackEntryFlow;
    private NavGraph _graph;
    private NavigatorProvider _navigatorProvider;
    private final MutableStateFlow<List<NavBackStackEntry>> _visibleEntries;
    private Function1<? super NavBackStackEntry, Unit> addToBackStackHandler;
    private final ArrayDeque<NavBackStackEntry> backQueue;
    private final List<NavBackStackEntry> backStackEntriesToDispatch;
    private final Map<Integer, String> backStackMap;
    private final Map<String, ArrayDeque<NavBackStackEntryState>> backStackStates;
    private Bundle[] backStackToRestore;
    private final Map<NavBackStackEntry, NavBackStackEntry> childToParentEntries;
    private final StateFlow<List<NavBackStackEntry>> currentBackStack;
    private int dispatchReentrantCount;
    private final Map<NavBackStackEntry, Boolean> entrySavedState;
    private Lifecycle.State hostLifecycleState;
    private final LifecycleObserver lifecycleObserver;
    private LifecycleOwner lifecycleOwner;
    private final NavController navController;
    private final Map<Navigator<? extends NavDestination>, NavController.NavControllerNavigatorState> navigatorState;
    private Bundle navigatorStateToRestore;
    private final List<NavController.OnDestinationChangedListener> onDestinationChangedListeners;
    private final Map<NavBackStackEntry, AtomicInt> parentToChildCount;
    private Function1<? super NavBackStackEntry, Unit> popFromBackStackHandler;
    private Function0<Unit> updateOnBackPressedCallbackEnabledCallback;
    private NavControllerViewModel viewModel;
    private final StateFlow<List<NavBackStackEntry>> visibleEntries;

    public NavControllerImpl(NavController navController, Function0<Unit> updateOnBackPressedCallbackEnabledCallback) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(updateOnBackPressedCallbackEnabledCallback, "updateOnBackPressedCallbackEnabledCallback");
        this.navController = navController;
        this.updateOnBackPressedCallbackEnabledCallback = updateOnBackPressedCallbackEnabledCallback;
        this.backQueue = new ArrayDeque<>();
        MutableStateFlow<List<NavBackStackEntry>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._currentBackStack = MutableStateFlow;
        this.currentBackStack = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<List<NavBackStackEntry>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._visibleEntries = MutableStateFlow2;
        this.visibleEntries = FlowKt.asStateFlow(MutableStateFlow2);
        this.childToParentEntries = new LinkedHashMap();
        this.parentToChildCount = new LinkedHashMap();
        this.backStackMap = new LinkedHashMap();
        this.backStackStates = new LinkedHashMap();
        this.onDestinationChangedListeners = new ArrayList();
        this.hostLifecycleState = Lifecycle.State.INITIALIZED;
        this.lifecycleObserver = new LifecycleEventObserver() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                NavControllerImpl.lifecycleObserver$lambda$1(NavControllerImpl.this, lifecycleOwner, event);
            }
        };
        this._navigatorProvider = new NavigatorProvider();
        this.navigatorState = new LinkedHashMap();
        this.entrySavedState = new LinkedHashMap();
        this.backStackEntriesToDispatch = new ArrayList();
        this._currentBackStackEntryFlow = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
    }

    public final NavController getNavController() {
        return this.navController;
    }

    public final Function0<Unit> getUpdateOnBackPressedCallbackEnabledCallback() {
        return this.updateOnBackPressedCallbackEnabledCallback;
    }

    public final void setUpdateOnBackPressedCallbackEnabledCallback(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.updateOnBackPressedCallbackEnabledCallback = function0;
    }

    public final NavContext getNavContext() {
        return this.navController.getNavContext();
    }

    /* renamed from: get_graph$navigation_runtime_release, reason: from getter */
    public final NavGraph get_graph() {
        return this._graph;
    }

    public final void set_graph$navigation_runtime_release(NavGraph navGraph) {
        this._graph = navGraph;
    }

    public final NavGraph getGraph$navigation_runtime_release() {
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            throw new IllegalStateException("You must call setGraph() before calling getGraph()".toString());
        }
        Intrinsics.checkNotNull(navGraph, "null cannot be cast to non-null type androidx.navigation.NavGraph");
        return navGraph;
    }

    public final void setGraph$navigation_runtime_release(NavGraph graph) {
        Intrinsics.checkNotNullParameter(graph, "graph");
        setGraph$navigation_runtime_release(graph, null);
    }

    /* renamed from: getNavigatorStateToRestore$navigation_runtime_release, reason: from getter */
    public final Bundle getNavigatorStateToRestore() {
        return this.navigatorStateToRestore;
    }

    public final void setNavigatorStateToRestore$navigation_runtime_release(Bundle bundle) {
        this.navigatorStateToRestore = bundle;
    }

    /* renamed from: getBackStackToRestore$navigation_runtime_release, reason: from getter */
    public final Bundle[] getBackStackToRestore() {
        return this.backStackToRestore;
    }

    public final void setBackStackToRestore$navigation_runtime_release(Bundle[] bundleArr) {
        this.backStackToRestore = bundleArr;
    }

    public final ArrayDeque<NavBackStackEntry> getBackQueue$navigation_runtime_release() {
        return this.backQueue;
    }

    public final MutableStateFlow<List<NavBackStackEntry>> get_currentBackStack$navigation_runtime_release() {
        return this._currentBackStack;
    }

    public final StateFlow<List<NavBackStackEntry>> getCurrentBackStack$navigation_runtime_release() {
        return this.currentBackStack;
    }

    public final MutableStateFlow<List<NavBackStackEntry>> get_visibleEntries$navigation_runtime_release() {
        return this._visibleEntries;
    }

    public final StateFlow<List<NavBackStackEntry>> getVisibleEntries$navigation_runtime_release() {
        return this.visibleEntries;
    }

    public final Map<NavBackStackEntry, NavBackStackEntry> getChildToParentEntries$navigation_runtime_release() {
        return this.childToParentEntries;
    }

    public final Map<NavBackStackEntry, AtomicInt> getParentToChildCount$navigation_runtime_release() {
        return this.parentToChildCount;
    }

    public final void linkChildToParent$navigation_runtime_release(NavBackStackEntry child, NavBackStackEntry parent) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.childToParentEntries.put(child, parent);
        if (this.parentToChildCount.get(parent) == null) {
            this.parentToChildCount.put(parent, new AtomicInt(0));
        }
        AtomicInt atomicInt = this.parentToChildCount.get(parent);
        Intrinsics.checkNotNull(atomicInt);
        atomicInt.incrementAndGet$navigation_runtime_release();
    }

    public final NavBackStackEntry unlinkChildFromParent$navigation_runtime_release(NavBackStackEntry child) {
        Intrinsics.checkNotNullParameter(child, "child");
        NavBackStackEntry remove = this.childToParentEntries.remove(child);
        if (remove == null) {
            return null;
        }
        AtomicInt atomicInt = this.parentToChildCount.get(remove);
        Integer valueOf = atomicInt != null ? Integer.valueOf(atomicInt.decrementAndGet$navigation_runtime_release()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            NavController.NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(this._navigatorProvider.getNavigator(remove.getDestination().getNavigatorName()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.markTransitionComplete(remove);
            }
            this.parentToChildCount.remove(remove);
        }
        return remove;
    }

    public final Map<Integer, String> getBackStackMap$navigation_runtime_release() {
        return this.backStackMap;
    }

    public final Map<String, ArrayDeque<NavBackStackEntryState>> getBackStackStates$navigation_runtime_release() {
        return this.backStackStates;
    }

    /* renamed from: getLifecycleOwner$navigation_runtime_release, reason: from getter */
    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    /* renamed from: getViewModel$navigation_runtime_release, reason: from getter */
    public final NavControllerViewModel getViewModel() {
        return this.viewModel;
    }

    public final void setViewModel$navigation_runtime_release(NavControllerViewModel navControllerViewModel) {
        this.viewModel = navControllerViewModel;
    }

    public final List<NavController.OnDestinationChangedListener> getOnDestinationChangedListeners$navigation_runtime_release() {
        return this.onDestinationChangedListeners;
    }

    public final void setHostLifecycleState$navigation_runtime_release(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.hostLifecycleState = state;
    }

    public final Lifecycle.State getHostLifecycleState$navigation_runtime_release() {
        if (this.lifecycleOwner == null) {
            return Lifecycle.State.CREATED;
        }
        return this.hostLifecycleState;
    }

    /* renamed from: getLifecycleObserver$navigation_runtime_release, reason: from getter */
    public final LifecycleObserver getLifecycleObserver() {
        return this.lifecycleObserver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lifecycleObserver$lambda$1(NavControllerImpl navControllerImpl, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        navControllerImpl.hostLifecycleState = event.getTargetState();
        if (navControllerImpl._graph != null) {
            Iterator it = CollectionsKt.toMutableList((Collection) navControllerImpl.backQueue).iterator();
            while (it.hasNext()) {
                ((NavBackStackEntry) it.next()).handleLifecycleEvent(event);
            }
        }
    }

    public final NavigatorProvider get_navigatorProvider$navigation_runtime_release() {
        return this._navigatorProvider;
    }

    public final void set_navigatorProvider$navigation_runtime_release(NavigatorProvider navigatorProvider) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "<set-?>");
        this._navigatorProvider = navigatorProvider;
    }

    /* renamed from: getNavigatorProvider$navigation_runtime_release, reason: from getter */
    public final NavigatorProvider get_navigatorProvider() {
        return this._navigatorProvider;
    }

    public final void setNavigatorProvider$navigation_runtime_release(NavigatorProvider navigatorProvider) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        if (!this.backQueue.isEmpty()) {
            throw new IllegalStateException("NavigatorProvider must be set before setGraph call".toString());
        }
        this._navigatorProvider = navigatorProvider;
    }

    public final Map<Navigator<? extends NavDestination>, NavController.NavControllerNavigatorState> getNavigatorState$navigation_runtime_release() {
        return this.navigatorState;
    }

    public final Function1<NavBackStackEntry, Unit> getAddToBackStackHandler$navigation_runtime_release() {
        return this.addToBackStackHandler;
    }

    public final void setAddToBackStackHandler$navigation_runtime_release(Function1<? super NavBackStackEntry, Unit> function1) {
        this.addToBackStackHandler = function1;
    }

    public final Function1<NavBackStackEntry, Unit> getPopFromBackStackHandler$navigation_runtime_release() {
        return this.popFromBackStackHandler;
    }

    public final void setPopFromBackStackHandler$navigation_runtime_release(Function1<? super NavBackStackEntry, Unit> function1) {
        this.popFromBackStackHandler = function1;
    }

    public final Map<NavBackStackEntry, Boolean> getEntrySavedState$navigation_runtime_release() {
        return this.entrySavedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit navigateInternal$lambda$3(NavBackStackEntry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void navigateInternal$navigation_runtime_release$default(NavControllerImpl navControllerImpl, Navigator navigator, List list, NavOptions navOptions, Navigator.Extras extras, Function1 function1, int i, Object obj) {
        if ((i & 16) != 0) {
            function1 = new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return NavControllerImpl.navigateInternal$lambda$3((NavBackStackEntry) obj2);
                }
            };
        }
        navControllerImpl.navigateInternal$navigation_runtime_release(navigator, list, navOptions, extras, function1);
    }

    public final void navigateInternal$navigation_runtime_release(Navigator<? extends NavDestination> navigator, List<NavBackStackEntry> entries, NavOptions navOptions, Navigator.Extras navigatorExtras, Function1<? super NavBackStackEntry, Unit> handler) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.addToBackStackHandler = handler;
        navigator.navigate(entries, navOptions, navigatorExtras);
        this.addToBackStackHandler = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit popBackStackInternal$lambda$4(NavBackStackEntry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void popBackStackInternal$navigation_runtime_release$default(NavControllerImpl navControllerImpl, Navigator navigator, NavBackStackEntry navBackStackEntry, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return NavControllerImpl.popBackStackInternal$lambda$4((NavBackStackEntry) obj2);
                }
            };
        }
        navControllerImpl.popBackStackInternal$navigation_runtime_release(navigator, navBackStackEntry, z, function1);
    }

    public final void popBackStackInternal$navigation_runtime_release(Navigator<? extends NavDestination> navigator, NavBackStackEntry popUpTo, boolean saveState, Function1<? super NavBackStackEntry, Unit> handler) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.popFromBackStackHandler = handler;
        navigator.popBackStack(popUpTo, saveState);
        this.popFromBackStackHandler = null;
    }

    public final void push$navigation_runtime_release(NavController.NavControllerNavigatorState state, NavBackStackEntry backStackEntry) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
        Navigator navigator = this._navigatorProvider.getNavigator(backStackEntry.getDestination().getNavigatorName());
        if (Intrinsics.areEqual(navigator, state.getNavigator())) {
            Function1<? super NavBackStackEntry, Unit> function1 = this.addToBackStackHandler;
            if (function1 != null) {
                function1.invoke(backStackEntry);
                state.addInternal(backStackEntry);
                return;
            }
            Log.INSTANCE.i(TAG, "Ignoring add of destination " + backStackEntry.getDestination() + " outside of the call to navigate(). ");
            return;
        }
        NavController.NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(navigator);
        if (navControllerNavigatorState == null) {
            throw new IllegalStateException(("NavigatorBackStack for " + backStackEntry.getDestination().getNavigatorName() + " should already be created").toString());
        }
        navControllerNavigatorState.push(backStackEntry);
    }

    public final NavBackStackEntry createBackStackEntry$navigation_runtime_release(NavDestination destination, Bundle arguments) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return NavBackStackEntry.Companion.create$default(NavBackStackEntry.INSTANCE, getNavContext(), destination, arguments, getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
    }

    public final void pop$navigation_runtime_release(NavController.NavControllerNavigatorState state, NavBackStackEntry popUpTo, boolean saveState, final Function0<Unit> superCallback) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        Intrinsics.checkNotNullParameter(superCallback, "superCallback");
        Navigator navigator = this._navigatorProvider.getNavigator(popUpTo.getDestination().getNavigatorName());
        this.entrySavedState.put(popUpTo, Boolean.valueOf(saveState));
        if (Intrinsics.areEqual(navigator, state.getNavigator())) {
            Function1<? super NavBackStackEntry, Unit> function1 = this.popFromBackStackHandler;
            if (function1 != null) {
                function1.invoke(popUpTo);
                superCallback.invoke();
                return;
            } else {
                popBackStackFromNavigator$navigation_runtime_release(popUpTo, new Function0() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavControllerImpl.pop$lambda$6(Function0.this);
                    }
                });
                return;
            }
        }
        NavController.NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(navigator);
        Intrinsics.checkNotNull(navControllerNavigatorState);
        navControllerNavigatorState.pop(popUpTo, saveState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit pop$lambda$6(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public final void markTransitionComplete$navigation_runtime_release(NavController.NavControllerNavigatorState state, NavBackStackEntry entry, Function0<Unit> superCallback) {
        NavControllerViewModel navControllerViewModel;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(superCallback, "superCallback");
        boolean areEqual = Intrinsics.areEqual((Object) this.entrySavedState.get(entry), (Object) true);
        superCallback.invoke();
        this.entrySavedState.remove(entry);
        if (!this.backQueue.contains(entry)) {
            unlinkChildFromParent$navigation_runtime_release(entry);
            if (entry.getLifecycle().getState().isAtLeast(Lifecycle.State.CREATED)) {
                entry.setMaxLifecycle(Lifecycle.State.DESTROYED);
            }
            ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
            if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
                Iterator<NavBackStackEntry> it = arrayDeque.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(it.next().getId(), entry.getId())) {
                        break;
                    }
                }
            }
            if (!areEqual && (navControllerViewModel = this.viewModel) != null) {
                navControllerViewModel.clear(entry.getId());
            }
            updateBackStackLifecycle$navigation_runtime_release();
            this._visibleEntries.tryEmit(populateVisibleEntries$navigation_runtime_release());
            return;
        }
        if (state.getIsNavigating()) {
            return;
        }
        updateBackStackLifecycle$navigation_runtime_release();
        this._currentBackStack.tryEmit(CollectionsKt.toMutableList((Collection) this.backQueue));
        this._visibleEntries.tryEmit(populateVisibleEntries$navigation_runtime_release());
    }

    public final void prepareForTransition$navigation_runtime_release(NavBackStackEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        if (this.backQueue.contains(entry)) {
            entry.setMaxLifecycle(Lifecycle.State.STARTED);
            return;
        }
        throw new IllegalStateException("Cannot transition entry that is not in the back stack");
    }

    public final void addOnDestinationChangedListener$navigation_runtime_release(NavController.OnDestinationChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onDestinationChangedListeners.add(listener);
        if (this.backQueue.isEmpty()) {
            return;
        }
        NavBackStackEntry last = this.backQueue.last();
        listener.onDestinationChanged(this.navController, last.getDestination(), last.getArguments());
    }

    public final void removeOnDestinationChangedListener$navigation_runtime_release(NavController.OnDestinationChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onDestinationChangedListeners.remove(listener);
    }

    public final boolean popBackStack$navigation_runtime_release() {
        if (this.backQueue.isEmpty()) {
            return false;
        }
        NavDestination currentDestination$navigation_runtime_release = getCurrentDestination$navigation_runtime_release();
        Intrinsics.checkNotNull(currentDestination$navigation_runtime_release);
        return popBackStack$navigation_runtime_release(currentDestination$navigation_runtime_release.getId(), true);
    }

    public final boolean popBackStack$navigation_runtime_release(int destinationId, boolean inclusive) {
        return popBackStack$navigation_runtime_release(destinationId, inclusive, false);
    }

    public final boolean popBackStack$navigation_runtime_release(int destinationId, boolean inclusive, boolean saveState) {
        return popBackStackInternal$navigation_runtime_release(destinationId, inclusive, saveState) && dispatchOnDestinationChanged$navigation_runtime_release();
    }

    public final boolean popBackStack$navigation_runtime_release(String route, boolean inclusive, boolean saveState) {
        Intrinsics.checkNotNullParameter(route, "route");
        return popBackStackInternal$navigation_runtime_release(route, inclusive, saveState) && dispatchOnDestinationChanged$navigation_runtime_release();
    }

    public final <T> boolean popBackStack$navigation_runtime_release(KClass<T> route, boolean inclusive, boolean saveState) {
        Intrinsics.checkNotNullParameter(route, "route");
        int generateHashCode = RouteSerializerKt.generateHashCode(SerializersKt.serializer(route));
        if (findDestinationComprehensive$navigation_runtime_release$default(this, getGraph$navigation_runtime_release(), generateHashCode, true, null, 8, null) == null) {
            throw new IllegalArgumentException(("Destination with route " + route.getSimpleName() + " cannot be found in navigation graph " + getGraph$navigation_runtime_release()).toString());
        }
        return popBackStack$navigation_runtime_release(generateHashCode, inclusive, saveState);
    }

    public final <T> boolean popBackStack$navigation_runtime_release(T route, boolean inclusive, boolean saveState) {
        Intrinsics.checkNotNullParameter(route, "route");
        return popBackStackInternal$navigation_runtime_release((NavControllerImpl) route, inclusive, saveState) && dispatchOnDestinationChanged$navigation_runtime_release();
    }

    public static /* synthetic */ boolean popBackStackInternal$navigation_runtime_release$default(NavControllerImpl navControllerImpl, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return navControllerImpl.popBackStackInternal$navigation_runtime_release(i, z, z2);
    }

    public final boolean popBackStackInternal$navigation_runtime_release(int destinationId, boolean inclusive, boolean saveState) {
        NavDestination navDestination;
        if (this.backQueue.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = CollectionsKt.reversed(this.backQueue).iterator();
        while (true) {
            if (!it.hasNext()) {
                navDestination = null;
                break;
            }
            navDestination = ((NavBackStackEntry) it.next()).getDestination();
            Navigator navigator = this._navigatorProvider.getNavigator(navDestination.getNavigatorName());
            if (inclusive || navDestination.getId() != destinationId) {
                arrayList.add(navigator);
            }
            if (navDestination.getId() == destinationId) {
                break;
            }
        }
        if (navDestination == null) {
            String displayName = NavDestination.INSTANCE.getDisplayName(getNavContext(), destinationId);
            Log.INSTANCE.i(TAG, "Ignoring popBackStack to destination " + displayName + " as it was not found on the current back stack");
            return false;
        }
        return executePopOperations$navigation_runtime_release(arrayList, navDestination, inclusive, saveState);
    }

    public static /* synthetic */ boolean popBackStackInternal$navigation_runtime_release$default(NavControllerImpl navControllerImpl, Object obj, boolean z, boolean z2, int i, Object obj2) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return navControllerImpl.popBackStackInternal$navigation_runtime_release((NavControllerImpl) obj, z, z2);
    }

    public final <T> boolean popBackStackInternal$navigation_runtime_release(T route, boolean inclusive, boolean saveState) {
        Intrinsics.checkNotNullParameter(route, "route");
        return popBackStackInternal$navigation_runtime_release(generateRouteFilled$navigation_runtime_release(route), inclusive, saveState);
    }

    public final boolean popBackStackInternal$navigation_runtime_release(String route, boolean inclusive, boolean saveState) {
        NavBackStackEntry navBackStackEntry;
        Intrinsics.checkNotNullParameter(route, "route");
        if (this.backQueue.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
            boolean hasRoute = navBackStackEntry2.getDestination().hasRoute(route, navBackStackEntry2.getArguments());
            if (inclusive || !hasRoute) {
                arrayList.add(this._navigatorProvider.getNavigator(navBackStackEntry2.getDestination().getNavigatorName()));
            }
            if (hasRoute) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry3 = navBackStackEntry;
        NavDestination destination = navBackStackEntry3 != null ? navBackStackEntry3.getDestination() : null;
        if (destination == null) {
            Log.INSTANCE.i(TAG, "Ignoring popBackStack to route " + route + " as it was not found on the current back stack");
            return false;
        }
        return executePopOperations$navigation_runtime_release(arrayList, destination, inclusive, saveState);
    }

    public final boolean executePopOperations$navigation_runtime_release(List<? extends Navigator<?>> popOperations, NavDestination foundDestination, boolean inclusive, boolean saveState) {
        final NavControllerImpl navControllerImpl;
        final boolean z;
        Intrinsics.checkNotNullParameter(popOperations, "popOperations");
        Intrinsics.checkNotNullParameter(foundDestination, "foundDestination");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final ArrayDeque<NavBackStackEntryState> arrayDeque = new ArrayDeque<>();
        Iterator<? extends Navigator<?>> it = popOperations.iterator();
        while (true) {
            if (!it.hasNext()) {
                navControllerImpl = this;
                z = saveState;
                break;
            }
            Navigator<? extends NavDestination> navigator = (Navigator) it.next();
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            navControllerImpl = this;
            z = saveState;
            navControllerImpl.popBackStackInternal$navigation_runtime_release(navigator, this.backQueue.last(), z, new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NavControllerImpl.executePopOperations$lambda$10(Ref.BooleanRef.this, booleanRef, navControllerImpl, z, arrayDeque, (NavBackStackEntry) obj);
                }
            });
            if (!booleanRef2.element) {
                break;
            }
            this = navControllerImpl;
            saveState = z;
        }
        if (z) {
            if (!inclusive) {
                for (NavDestination navDestination : SequencesKt.takeWhile(SequencesKt.generateSequence(foundDestination, (Function1<? super NavDestination, ? extends NavDestination>) new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavControllerImpl.executePopOperations$lambda$11((NavDestination) obj);
                    }
                }), new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(NavControllerImpl.executePopOperations$lambda$12(NavControllerImpl.this, (NavDestination) obj));
                    }
                })) {
                    Map<Integer, String> map = navControllerImpl.backStackMap;
                    Integer valueOf = Integer.valueOf(navDestination.getId());
                    NavBackStackEntryState firstOrNull = arrayDeque.firstOrNull();
                    map.put(valueOf, firstOrNull != null ? firstOrNull.getId() : null);
                }
            }
            if (!arrayDeque.isEmpty()) {
                NavBackStackEntryState first = arrayDeque.first();
                Iterator it2 = SequencesKt.takeWhile(SequencesKt.generateSequence(findDestination$navigation_runtime_release$default(navControllerImpl, first.getDestinationId(), null, 2, null), (Function1<? super NavDestination, ? extends NavDestination>) new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavControllerImpl.executePopOperations$lambda$14((NavDestination) obj);
                    }
                }), new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(NavControllerImpl.executePopOperations$lambda$15(NavControllerImpl.this, (NavDestination) obj));
                    }
                }).iterator();
                while (it2.hasNext()) {
                    navControllerImpl.backStackMap.put(Integer.valueOf(((NavDestination) it2.next()).getId()), first.getId());
                }
                if (navControllerImpl.backStackMap.values().contains(first.getId())) {
                    navControllerImpl.backStackStates.put(first.getId(), arrayDeque);
                }
            }
        }
        navControllerImpl.updateOnBackPressedCallbackEnabledCallback.invoke();
        return booleanRef.element;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit executePopOperations$lambda$10(Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, NavControllerImpl navControllerImpl, boolean z, ArrayDeque arrayDeque, NavBackStackEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        booleanRef.element = true;
        booleanRef2.element = true;
        navControllerImpl.popEntryFromBackStack$navigation_runtime_release(entry, z, arrayDeque);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final NavDestination executePopOperations$lambda$11(NavDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        NavGraph parent = destination.getParent();
        if (parent == null || parent.getStartDestinationId() != destination.getId()) {
            return null;
        }
        return destination.getParent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean executePopOperations$lambda$12(NavControllerImpl navControllerImpl, NavDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return !navControllerImpl.backStackMap.containsKey(Integer.valueOf(destination.getId()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final NavDestination executePopOperations$lambda$14(NavDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        NavGraph parent = destination.getParent();
        if (parent == null || parent.getStartDestinationId() != destination.getId()) {
            return null;
        }
        return destination.getParent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean executePopOperations$lambda$15(NavControllerImpl navControllerImpl, NavDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return !navControllerImpl.backStackMap.containsKey(Integer.valueOf(destination.getId()));
    }

    public final void popBackStackFromNavigator$navigation_runtime_release(NavBackStackEntry popUpTo, Function0<Unit> onComplete) {
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        int indexOf = this.backQueue.indexOf(popUpTo);
        if (indexOf < 0) {
            Log.INSTANCE.i(TAG, "Ignoring pop of " + popUpTo + " as it was not found on the current back stack");
            return;
        }
        int i = indexOf + 1;
        if (i != this.backQueue.size()) {
            popBackStackInternal$navigation_runtime_release(this.backQueue.get(i).getDestination().getId(), true, false);
        }
        popEntryFromBackStack$navigation_runtime_release$default(this, popUpTo, false, null, 6, null);
        onComplete.invoke();
        this.updateOnBackPressedCallbackEnabledCallback.invoke();
        dispatchOnDestinationChanged$navigation_runtime_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void popEntryFromBackStack$navigation_runtime_release$default(NavControllerImpl navControllerImpl, NavBackStackEntry navBackStackEntry, boolean z, ArrayDeque arrayDeque, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            arrayDeque = new ArrayDeque();
        }
        navControllerImpl.popEntryFromBackStack$navigation_runtime_release(navBackStackEntry, z, arrayDeque);
    }

    public final void popEntryFromBackStack$navigation_runtime_release(NavBackStackEntry popUpTo, boolean saveState, ArrayDeque<NavBackStackEntryState> savedState) {
        NavControllerViewModel navControllerViewModel;
        StateFlow<Set<NavBackStackEntry>> transitionsInProgress;
        Set<NavBackStackEntry> value;
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        NavBackStackEntry last = this.backQueue.last();
        if (!Intrinsics.areEqual(last, popUpTo)) {
            throw new IllegalStateException(("Attempted to pop " + popUpTo.getDestination() + ", which is not the top of the back stack (" + last.getDestination() + ')').toString());
        }
        CollectionsKt.removeLast(this.backQueue);
        NavController.NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(get_navigatorProvider().getNavigator(last.getDestination().getNavigatorName()));
        boolean z = true;
        if ((navControllerNavigatorState == null || (transitionsInProgress = navControllerNavigatorState.getTransitionsInProgress()) == null || (value = transitionsInProgress.getValue()) == null || !value.contains(last)) && !this.parentToChildCount.containsKey(last)) {
            z = false;
        }
        if (last.getLifecycle().getState().isAtLeast(Lifecycle.State.CREATED)) {
            if (saveState) {
                last.setMaxLifecycle(Lifecycle.State.CREATED);
                savedState.addFirst(new NavBackStackEntryState(last));
            }
            if (!z) {
                last.setMaxLifecycle(Lifecycle.State.DESTROYED);
                unlinkChildFromParent$navigation_runtime_release(last);
            } else {
                last.setMaxLifecycle(Lifecycle.State.CREATED);
            }
        }
        if (saveState || z || (navControllerViewModel = this.viewModel) == null) {
            return;
        }
        navControllerViewModel.clear(last.getId());
    }

    public final boolean clearBackStack$navigation_runtime_release(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return clearBackStackInternal$navigation_runtime_release(route) && dispatchOnDestinationChanged$navigation_runtime_release();
    }

    public final boolean clearBackStack$navigation_runtime_release(int destinationId) {
        return clearBackStackInternal$navigation_runtime_release(destinationId) && dispatchOnDestinationChanged$navigation_runtime_release();
    }

    public final <T> boolean clearBackStack$navigation_runtime_release(KClass<T> route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return clearBackStack$navigation_runtime_release(RouteSerializerKt.generateHashCode(SerializersKt.serializer(route)));
    }

    public final <T> boolean clearBackStack$navigation_runtime_release(T route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return clearBackStackInternal$navigation_runtime_release(generateRouteFilled$navigation_runtime_release(route)) && dispatchOnDestinationChanged$navigation_runtime_release();
    }

    public final boolean clearBackStackInternal$navigation_runtime_release(int destinationId) {
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            ((NavController.NavControllerNavigatorState) it.next()).setNavigating(true);
        }
        boolean restoreStateInternal = restoreStateInternal(destinationId, null, NavOptionsBuilderKt.navOptions(new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavControllerImpl.clearBackStackInternal$lambda$19((NavOptionsBuilder) obj);
            }
        }), null);
        Iterator<T> it2 = this.navigatorState.values().iterator();
        while (it2.hasNext()) {
            ((NavController.NavControllerNavigatorState) it2.next()).setNavigating(false);
        }
        return restoreStateInternal && popBackStackInternal$navigation_runtime_release(destinationId, true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit clearBackStackInternal$lambda$19(NavOptionsBuilder navOptions) {
        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
        navOptions.setRestoreState(true);
        return Unit.INSTANCE;
    }

    public final boolean clearBackStackInternal$navigation_runtime_release(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            ((NavController.NavControllerNavigatorState) it.next()).setNavigating(true);
        }
        boolean restoreStateInternal = restoreStateInternal(route);
        Iterator<T> it2 = this.navigatorState.values().iterator();
        while (it2.hasNext()) {
            ((NavController.NavControllerNavigatorState) it2.next()).setNavigating(false);
        }
        return restoreStateInternal && popBackStackInternal$navigation_runtime_release(route, true, false);
    }

    public final boolean dispatchOnDestinationChanged$navigation_runtime_release() {
        while (!this.backQueue.isEmpty() && (this.backQueue.last().getDestination() instanceof NavGraph)) {
            popEntryFromBackStack$navigation_runtime_release$default(this, this.backQueue.last(), false, null, 6, null);
        }
        NavBackStackEntry lastOrNull = this.backQueue.lastOrNull();
        if (lastOrNull != null) {
            this.backStackEntriesToDispatch.add(lastOrNull);
        }
        this.dispatchReentrantCount++;
        updateBackStackLifecycle$navigation_runtime_release();
        int i = this.dispatchReentrantCount - 1;
        this.dispatchReentrantCount = i;
        if (i == 0) {
            List<NavBackStackEntry> mutableList = CollectionsKt.toMutableList((Collection) this.backStackEntriesToDispatch);
            this.backStackEntriesToDispatch.clear();
            for (NavBackStackEntry navBackStackEntry : mutableList) {
                Iterator<NavController.OnDestinationChangedListener> it = this.onDestinationChangedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onDestinationChanged(this.navController, navBackStackEntry.getDestination(), navBackStackEntry.getArguments());
                }
                this._currentBackStackEntryFlow.tryEmit(navBackStackEntry);
            }
            this._currentBackStack.tryEmit(CollectionsKt.toMutableList((Collection) this.backQueue));
            this._visibleEntries.tryEmit(populateVisibleEntries$navigation_runtime_release());
        }
        return lastOrNull != null;
    }

    public final void updateBackStackLifecycle$navigation_runtime_release() {
        AtomicInt atomicInt;
        StateFlow<Set<NavBackStackEntry>> transitionsInProgress;
        Set<NavBackStackEntry> value;
        List<NavBackStackEntry> mutableList = CollectionsKt.toMutableList((Collection) this.backQueue);
        if (mutableList.isEmpty()) {
            return;
        }
        NavDestination destination = ((NavBackStackEntry) CollectionsKt.last(mutableList)).getDestination();
        List mutableListOf = CollectionsKt.mutableListOf(destination);
        if (destination instanceof SupportingPane) {
            boolean z = destination instanceof FloatingWindow;
            Iterator it = CollectionsKt.drop(CollectionsKt.reversed(mutableList), 1).iterator();
            while (it.hasNext()) {
                NavDestination destination2 = ((NavBackStackEntry) it.next()).getDestination();
                if (z && !(destination2 instanceof FloatingWindow) && !(destination2 instanceof NavGraph)) {
                    break;
                }
                mutableListOf.add(destination2);
                if (!(destination2 instanceof SupportingPane) && !(destination2 instanceof NavGraph)) {
                    break;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        if (CollectionsKt.last(mutableListOf) instanceof FloatingWindow) {
            Iterator it2 = CollectionsKt.reversed(mutableList).iterator();
            while (it2.hasNext()) {
                NavDestination destination3 = ((NavBackStackEntry) it2.next()).getDestination();
                arrayList.add(destination3);
                if (!(destination3 instanceof FloatingWindow) && !(destination3 instanceof SupportingPane) && !(destination3 instanceof NavGraph)) {
                    break;
                }
            }
        }
        HashMap hashMap = new HashMap();
        for (NavBackStackEntry navBackStackEntry : CollectionsKt.reversed(mutableList)) {
            Lifecycle.State maxLifecycle = navBackStackEntry.getMaxLifecycle();
            NavDestination destination4 = navBackStackEntry.getDestination();
            NavDestination navDestination = (NavDestination) CollectionsKt.firstOrNull(mutableListOf);
            if (navDestination != null && navDestination.getId() == destination4.getId()) {
                if (maxLifecycle != Lifecycle.State.RESUMED) {
                    NavController.NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(get_navigatorProvider().getNavigator(navBackStackEntry.getDestination().getNavigatorName()));
                    if (!Intrinsics.areEqual((Object) ((navControllerNavigatorState == null || (transitionsInProgress = navControllerNavigatorState.getTransitionsInProgress()) == null || (value = transitionsInProgress.getValue()) == null) ? null : Boolean.valueOf(value.contains(navBackStackEntry))), (Object) true) && ((atomicInt = this.parentToChildCount.get(navBackStackEntry)) == null || atomicInt.get$navigation_runtime_release() != 0)) {
                        hashMap.put(navBackStackEntry, Lifecycle.State.RESUMED);
                    } else {
                        hashMap.put(navBackStackEntry, Lifecycle.State.STARTED);
                    }
                }
                NavDestination navDestination2 = (NavDestination) CollectionsKt.firstOrNull((List) arrayList);
                if (navDestination2 != null && navDestination2.getId() == destination4.getId()) {
                    CollectionsKt.removeFirst(arrayList);
                }
                CollectionsKt.removeFirst(mutableListOf);
                NavGraph parent = destination4.getParent();
                if (parent != null) {
                    mutableListOf.add(parent);
                }
            } else if (!arrayList.isEmpty() && destination4.getId() == ((NavDestination) CollectionsKt.first((List) arrayList)).getId()) {
                NavDestination navDestination3 = (NavDestination) CollectionsKt.removeFirst(arrayList);
                if (maxLifecycle == Lifecycle.State.RESUMED) {
                    navBackStackEntry.setMaxLifecycle(Lifecycle.State.STARTED);
                } else if (maxLifecycle != Lifecycle.State.STARTED) {
                    hashMap.put(navBackStackEntry, Lifecycle.State.STARTED);
                }
                NavGraph parent2 = navDestination3.getParent();
                if (parent2 != null && !arrayList.contains(parent2)) {
                    arrayList.add(parent2);
                }
            } else {
                navBackStackEntry.setMaxLifecycle(Lifecycle.State.CREATED);
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : mutableList) {
            Lifecycle.State state = (Lifecycle.State) hashMap.get(navBackStackEntry2);
            if (state != null) {
                navBackStackEntry2.setMaxLifecycle(state);
            } else {
                navBackStackEntry2.updateState();
            }
        }
    }

    public final List<NavBackStackEntry> populateVisibleEntries$navigation_runtime_release() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            ArrayList arrayList2 = arrayList;
            Set<NavBackStackEntry> value = ((NavController.NavControllerNavigatorState) it.next()).getTransitionsInProgress().getValue();
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : value) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                if (!arrayList.contains(navBackStackEntry) && !navBackStackEntry.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                    arrayList3.add(obj);
                }
            }
            CollectionsKt.addAll(arrayList2, arrayList3);
        }
        ArrayList arrayList4 = arrayList;
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ArrayList arrayList5 = new ArrayList();
        for (NavBackStackEntry navBackStackEntry2 : arrayDeque) {
            NavBackStackEntry navBackStackEntry3 = navBackStackEntry2;
            if (!arrayList.contains(navBackStackEntry3) && navBackStackEntry3.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                arrayList5.add(navBackStackEntry2);
            }
        }
        CollectionsKt.addAll(arrayList4, arrayList5);
        ArrayList arrayList6 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!(((NavBackStackEntry) obj2).getDestination() instanceof NavGraph)) {
                arrayList6.add(obj2);
            }
        }
        return arrayList6;
    }

    public final void setGraph$navigation_runtime_release(NavGraph graph, Bundle startDestinationArgs) {
        NavControllerImpl navControllerImpl;
        Intrinsics.checkNotNullParameter(graph, "graph");
        if (!this.backQueue.isEmpty() && getHostLifecycleState$navigation_runtime_release() == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("You cannot set a new graph on a NavController with entries on the back stack after the NavController has been destroyed. Please ensure that your NavHost has the same lifetime as your NavController.".toString());
        }
        if (!Intrinsics.areEqual(this._graph, graph)) {
            NavGraph navGraph = this._graph;
            if (navGraph != null) {
                for (Integer num : new ArrayList(this.backStackMap.keySet())) {
                    Intrinsics.checkNotNull(num);
                    clearBackStackInternal$navigation_runtime_release(num.intValue());
                }
                navControllerImpl = this;
                popBackStackInternal$navigation_runtime_release$default(navControllerImpl, navGraph.getId(), true, false, 4, (Object) null);
            } else {
                navControllerImpl = this;
            }
            navControllerImpl._graph = graph;
            navControllerImpl.onGraphCreated$navigation_runtime_release(startDestinationArgs);
            return;
        }
        int size = graph.getNodes().size();
        for (int i = 0; i < size; i++) {
            NavDestination valueAt = graph.getNodes().valueAt(i);
            NavGraph navGraph2 = this._graph;
            Intrinsics.checkNotNull(navGraph2);
            int keyAt = navGraph2.getNodes().keyAt(i);
            NavGraph navGraph3 = this._graph;
            Intrinsics.checkNotNull(navGraph3);
            navGraph3.getNodes().replace(keyAt, valueAt);
        }
        for (NavBackStackEntry navBackStackEntry : this.backQueue) {
            List<NavDestination> asReversed = CollectionsKt.asReversed(SequencesKt.toList(NavDestination.INSTANCE.getHierarchy(navBackStackEntry.getDestination())));
            NavDestination navDestination = this._graph;
            Intrinsics.checkNotNull(navDestination);
            for (NavDestination navDestination2 : asReversed) {
                navDestination = navDestination;
                if (!Intrinsics.areEqual(navDestination2, this._graph) || !Intrinsics.areEqual(navDestination, graph)) {
                    if (navDestination instanceof NavGraph) {
                        navDestination = ((NavGraph) navDestination).findNode(navDestination2.getId());
                        Intrinsics.checkNotNull(navDestination);
                    }
                }
            }
            navBackStackEntry.setDestination(navDestination);
        }
    }

    public final void onGraphCreated$navigation_runtime_release(Bundle startDestinationArgs) {
        Bundle bundle = this.navigatorStateToRestore;
        if (bundle != null) {
            Bundle m7464constructorimpl = SavedStateReader.m7464constructorimpl(bundle);
            if (SavedStateReader.m7465containsimpl(m7464constructorimpl, KEY_NAVIGATOR_STATE_NAMES)) {
                for (String str : SavedStateReader.m7538getStringListimpl(m7464constructorimpl, KEY_NAVIGATOR_STATE_NAMES)) {
                    Navigator navigator = this._navigatorProvider.getNavigator(str);
                    if (SavedStateReader.m7465containsimpl(m7464constructorimpl, str)) {
                        navigator.onRestoreState(SavedStateReader.m7521getSavedStateimpl(m7464constructorimpl, str));
                    }
                }
            }
        }
        Bundle[] bundleArr = this.backStackToRestore;
        if (bundleArr != null) {
            for (Bundle bundle2 : bundleArr) {
                NavBackStackEntryState navBackStackEntryState = new NavBackStackEntryState(bundle2);
                NavDestination findDestination$navigation_runtime_release$default = findDestination$navigation_runtime_release$default(this, navBackStackEntryState.getDestinationId(), null, 2, null);
                if (findDestination$navigation_runtime_release$default == null) {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.INSTANCE.getDisplayName(getNavContext(), navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + getCurrentDestination$navigation_runtime_release());
                }
                NavBackStackEntry instantiate = navBackStackEntryState.instantiate(getNavContext(), findDestination$navigation_runtime_release$default, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                Navigator<? extends NavDestination> navigator2 = this._navigatorProvider.getNavigator(findDestination$navigation_runtime_release$default.getNavigatorName());
                Map<Navigator<? extends NavDestination>, NavController.NavControllerNavigatorState> map = this.navigatorState;
                NavController.NavControllerNavigatorState navControllerNavigatorState = map.get(navigator2);
                if (navControllerNavigatorState == null) {
                    navControllerNavigatorState = this.navController.createNavControllerNavigatorState$navigation_runtime_release(navigator2);
                    map.put(navigator2, navControllerNavigatorState);
                }
                this.backQueue.add(instantiate);
                navControllerNavigatorState.addInternal(instantiate);
                NavGraph parent = instantiate.getDestination().getParent();
                if (parent != null) {
                    linkChildToParent$navigation_runtime_release(instantiate, getBackStackEntry$navigation_runtime_release(parent.getId()));
                }
            }
            this.updateOnBackPressedCallbackEnabledCallback.invoke();
            this.backStackToRestore = null;
        }
        Collection<Navigator<? extends NavDestination>> values = this._navigatorProvider.getNavigators().values();
        ArrayList<Navigator<? extends NavDestination>> arrayList = new ArrayList();
        for (Object obj : values) {
            if (!((Navigator) obj).getIsAttached()) {
                arrayList.add(obj);
            }
        }
        for (Navigator<? extends NavDestination> navigator3 : arrayList) {
            Map<Navigator<? extends NavDestination>, NavController.NavControllerNavigatorState> map2 = this.navigatorState;
            NavController.NavControllerNavigatorState navControllerNavigatorState2 = map2.get(navigator3);
            if (navControllerNavigatorState2 == null) {
                navControllerNavigatorState2 = this.navController.createNavControllerNavigatorState$navigation_runtime_release(navigator3);
                map2.put(navigator3, navControllerNavigatorState2);
            }
            navigator3.onAttach(navControllerNavigatorState2);
        }
        if (this._graph != null && this.backQueue.isEmpty()) {
            if (this.navController.checkDeepLinkHandled$navigation_runtime_release()) {
                return;
            }
            NavGraph navGraph = this._graph;
            Intrinsics.checkNotNull(navGraph);
            navigate$navigation_runtime_release(navGraph, startDestinationArgs, null, null);
            return;
        }
        dispatchOnDestinationChanged$navigation_runtime_release();
    }

    public final String findInvalidDestinationDisplayNameInDeepLink$navigation_runtime_release(int[] deepLink) {
        NavGraph findNode;
        NavGraph navGraph;
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        NavGraph navGraph2 = this._graph;
        int length = deepLink.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                return null;
            }
            int i2 = deepLink[i];
            if (i == 0) {
                NavGraph navGraph3 = this._graph;
                Intrinsics.checkNotNull(navGraph3);
                findNode = navGraph3.getId() == i2 ? this._graph : null;
            } else {
                Intrinsics.checkNotNull(navGraph2);
                findNode = navGraph2.findNode(i2);
            }
            if (findNode == null) {
                return NavDestination.INSTANCE.getDisplayName(getNavContext(), i2);
            }
            if (i != deepLink.length - 1 && (findNode instanceof NavGraph)) {
                while (true) {
                    navGraph = (NavGraph) findNode;
                    Intrinsics.checkNotNull(navGraph);
                    if (!(navGraph.findNode(navGraph.getStartDestinationId()) instanceof NavGraph)) {
                        break;
                    }
                    findNode = navGraph.findNode(navGraph.getStartDestinationId());
                }
                navGraph2 = navGraph;
            }
            i++;
        }
    }

    public final NavDestination getCurrentDestination$navigation_runtime_release() {
        NavBackStackEntry currentBackStackEntry$navigation_runtime_release = getCurrentBackStackEntry$navigation_runtime_release();
        if (currentBackStackEntry$navigation_runtime_release != null) {
            return currentBackStackEntry$navigation_runtime_release.getDestination();
        }
        return null;
    }

    public static /* synthetic */ NavDestination findDestination$navigation_runtime_release$default(NavControllerImpl navControllerImpl, int i, NavDestination navDestination, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            navDestination = null;
        }
        return navControllerImpl.findDestination$navigation_runtime_release(i, navDestination);
    }

    public final NavDestination findDestination$navigation_runtime_release(int destinationId, NavDestination matchingDest) {
        NavGraph navGraph;
        NavGraph navGraph2 = this._graph;
        if (navGraph2 == null) {
            return null;
        }
        Intrinsics.checkNotNull(navGraph2);
        if (navGraph2.getId() == destinationId) {
            NavGraph navGraph3 = this._graph;
            if (matchingDest != null) {
                if (Intrinsics.areEqual(navGraph3, matchingDest) && matchingDest.getParent() == null) {
                    return this._graph;
                }
            } else {
                return navGraph3;
            }
        }
        NavBackStackEntry lastOrNull = this.backQueue.lastOrNull();
        if (lastOrNull == null || (navGraph = lastOrNull.getDestination()) == null) {
            NavGraph navGraph4 = this._graph;
            Intrinsics.checkNotNull(navGraph4);
            navGraph = navGraph4;
        }
        return findDestinationComprehensive$navigation_runtime_release(navGraph, destinationId, false, matchingDest);
    }

    public static /* synthetic */ NavDestination findDestinationComprehensive$navigation_runtime_release$default(NavControllerImpl navControllerImpl, NavDestination navDestination, int i, boolean z, NavDestination navDestination2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            navDestination2 = null;
        }
        return navControllerImpl.findDestinationComprehensive$navigation_runtime_release(navDestination, i, z, navDestination2);
    }

    public final NavDestination findDestinationComprehensive$navigation_runtime_release(NavDestination destination, int destinationId, boolean searchChildren, NavDestination matchingDest) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination.getId() == destinationId && (matchingDest == null || (Intrinsics.areEqual(destination, matchingDest) && Intrinsics.areEqual(destination.getParent(), matchingDest.getParent())))) {
            return destination;
        }
        NavGraph navGraph = destination instanceof NavGraph ? (NavGraph) destination : null;
        if (navGraph == null) {
            navGraph = destination.getParent();
            Intrinsics.checkNotNull(navGraph);
        }
        return navGraph.findNodeComprehensive(destinationId, navGraph, searchChildren, matchingDest);
    }

    public final NavDestination findDestination$navigation_runtime_release(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            return null;
        }
        Intrinsics.checkNotNull(navGraph);
        if (!Intrinsics.areEqual(navGraph.getRoute(), route)) {
            NavGraph navGraph2 = this._graph;
            Intrinsics.checkNotNull(navGraph2);
            if (navGraph2.matchRoute(route) == null) {
                return getTopGraph$navigation_runtime_release().findNode(route);
            }
        }
        return this._graph;
    }

    public final NavGraph getTopGraph$navigation_runtime_release() {
        NavGraph navGraph;
        NavBackStackEntry lastOrNull = this.backQueue.lastOrNull();
        if (lastOrNull == null || (navGraph = lastOrNull.getDestination()) == null) {
            NavGraph navGraph2 = this._graph;
            Intrinsics.checkNotNull(navGraph2);
            navGraph = navGraph2;
        }
        NavGraph navGraph3 = navGraph instanceof NavGraph ? (NavGraph) navGraph : null;
        if (navGraph3 != null) {
            return navGraph3;
        }
        NavGraph parent = navGraph.getParent();
        Intrinsics.checkNotNull(parent);
        return parent;
    }

    public final <T> String generateRouteFilled$navigation_runtime_release(T route) {
        Intrinsics.checkNotNullParameter(route, "route");
        NavDestination findDestinationComprehensive$navigation_runtime_release$default = findDestinationComprehensive$navigation_runtime_release$default(this, getGraph$navigation_runtime_release(), RouteSerializerKt.generateHashCode(SerializersKt.serializer(Reflection.getOrCreateKotlinClass(route.getClass()))), true, null, 8, null);
        if (findDestinationComprehensive$navigation_runtime_release$default == null) {
            throw new IllegalArgumentException(("Destination with route " + Reflection.getOrCreateKotlinClass(route.getClass()).getSimpleName() + " cannot be found in navigation graph " + this._graph).toString());
        }
        Map<String, NavArgument> arguments = findDestinationComprehensive$navigation_runtime_release$default.getArguments();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(arguments.size()));
        Iterator<T> it = arguments.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((NavArgument) entry.getValue()).getType());
        }
        return RouteSerializerKt.generateRouteWithArgs(route, linkedHashMap);
    }

    public final void navigate$navigation_runtime_release(Uri deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        navigate$navigation_runtime_release(new NavDeepLinkRequest(deepLink, null, null));
    }

    public final void navigate$navigation_runtime_release(Uri deepLink, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        navigate$navigation_runtime_release(new NavDeepLinkRequest(deepLink, null, null), navOptions, (Navigator.Extras) null);
    }

    public final void navigate$navigation_runtime_release(Uri deepLink, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        navigate$navigation_runtime_release(new NavDeepLinkRequest(deepLink, null, null), navOptions, navigatorExtras);
    }

    public final void navigate$navigation_runtime_release(NavDeepLinkRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        navigate$navigation_runtime_release(request, (NavOptions) null);
    }

    public final void navigate$navigation_runtime_release(NavDeepLinkRequest request, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(request, "request");
        navigate$navigation_runtime_release(request, navOptions, (Navigator.Extras) null);
    }

    public final void navigate$navigation_runtime_release(NavDeepLinkRequest request, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(request, "request");
        if (this._graph == null) {
            throw new IllegalArgumentException(("Cannot navigate to " + request + ". Navigation graph has not been set for NavController " + this.navController + '.').toString());
        }
        NavGraph topGraph$navigation_runtime_release = getTopGraph$navigation_runtime_release();
        NavDestination.DeepLinkMatch matchDeepLinkComprehensive = topGraph$navigation_runtime_release.matchDeepLinkComprehensive(request, true, true, topGraph$navigation_runtime_release);
        if (matchDeepLinkComprehensive != null) {
            Bundle addInDefaultArgs = matchDeepLinkComprehensive.getDestination().addInDefaultArgs(matchDeepLinkComprehensive.getMatchingArgs());
            if (addInDefaultArgs == null) {
                Map emptyMap = MapsKt.emptyMap();
                if (emptyMap.isEmpty()) {
                    pairArr = new Pair[0];
                } else {
                    ArrayList arrayList = new ArrayList(emptyMap.size());
                    for (Map.Entry entry : emptyMap.entrySet()) {
                        arrayList.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
                    }
                    pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
                }
                addInDefaultArgs = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
                SavedStateWriter.m7550constructorimpl(addInDefaultArgs);
            }
            NavDestination destination = matchDeepLinkComprehensive.getDestination();
            this.navController.writeIntent$navigation_runtime_release(request, addInDefaultArgs);
            navigate$navigation_runtime_release(destination, addInDefaultArgs, navOptions, navigatorExtras);
            return;
        }
        throw new IllegalArgumentException("Navigation destination that matches request " + request + " cannot be found in the navigation graph " + this._graph);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x012c A[LOOP:1: B:20:0x0126->B:22:0x012c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void navigate$navigation_runtime_release(final androidx.navigation.NavDestination r18, android.os.Bundle r19, androidx.navigation.NavOptions r20, androidx.navigation.Navigator.Extras r21) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.internal.NavControllerImpl.navigate$navigation_runtime_release(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit navigate$lambda$44(Ref.BooleanRef booleanRef, NavControllerImpl navControllerImpl, NavDestination navDestination, Bundle bundle, NavBackStackEntry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        booleanRef.element = true;
        addEntryToBackStack$default(navControllerImpl, navDestination, bundle, it, null, 8, null);
        return Unit.INSTANCE;
    }

    private final boolean launchSingleTopInternal(NavDestination node, Bundle args) {
        int i;
        NavDestination destination;
        NavBackStackEntry currentBackStackEntry$navigation_runtime_release = getCurrentBackStackEntry$navigation_runtime_release();
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                i = -1;
                break;
            }
            if (listIterator.previous().getDestination() == node) {
                i = listIterator.nextIndex();
                break;
            }
        }
        if (i == -1) {
            return false;
        }
        if (node instanceof NavGraph) {
            List list = SequencesKt.toList(SequencesKt.map(NavGraph.INSTANCE.childHierarchy((NavGraph) node), new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(NavControllerImpl.launchSingleTopInternal$lambda$47((NavDestination) obj));
                }
            }));
            if (this.backQueue.size() - i != list.size()) {
                return false;
            }
            ArrayDeque<NavBackStackEntry> arrayDeque2 = this.backQueue;
            List subList = arrayDeque2.subList(i, arrayDeque2.size());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subList, 10));
            Iterator it = subList.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((NavBackStackEntry) it.next()).getDestination().getId()));
            }
            if (!Intrinsics.areEqual(arrayList, list)) {
                return false;
            }
        } else if (currentBackStackEntry$navigation_runtime_release == null || (destination = currentBackStackEntry$navigation_runtime_release.getDestination()) == null || node.getId() != destination.getId()) {
            return false;
        }
        ArrayDeque arrayDeque3 = new ArrayDeque();
        while (CollectionsKt.getLastIndex(this.backQueue) >= i) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) CollectionsKt.removeLast(this.backQueue);
            unlinkChildFromParent$navigation_runtime_release(navBackStackEntry);
            arrayDeque3.addFirst(new NavBackStackEntry(navBackStackEntry, navBackStackEntry.getDestination().addInDefaultArgs(args)));
        }
        ArrayDeque<NavBackStackEntry> arrayDeque4 = arrayDeque3;
        for (NavBackStackEntry navBackStackEntry2 : arrayDeque4) {
            NavGraph parent = navBackStackEntry2.getDestination().getParent();
            if (parent != null) {
                linkChildToParent$navigation_runtime_release(navBackStackEntry2, getBackStackEntry$navigation_runtime_release(parent.getId()));
            }
            this.backQueue.add(navBackStackEntry2);
        }
        for (NavBackStackEntry navBackStackEntry3 : arrayDeque4) {
            this._navigatorProvider.getNavigator(navBackStackEntry3.getDestination().getNavigatorName()).onLaunchSingleTop(navBackStackEntry3);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int launchSingleTopInternal$lambda$47(NavDestination it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId();
    }

    private final boolean restoreStateInternal(int id, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        if (!this.backStackMap.containsKey(Integer.valueOf(id))) {
            return false;
        }
        final String str = this.backStackMap.get(Integer.valueOf(id));
        CollectionsKt.removeAll(this.backStackMap.values(), new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean areEqual;
                areEqual = Intrinsics.areEqual((String) obj, str);
                return Boolean.valueOf(areEqual);
            }
        });
        return executeRestoreState(instantiateBackStack((ArrayDeque) TypeIntrinsics.asMutableMap(this.backStackStates).remove(str)), args, navOptions, navigatorExtras);
    }

    private final boolean restoreStateInternal(String route) {
        NavBackStackEntryState firstOrNull;
        int hashCode = NavDestination.INSTANCE.createRoute(route).hashCode();
        if (this.backStackMap.containsKey(Integer.valueOf(hashCode))) {
            return restoreStateInternal(hashCode, null, null, null);
        }
        NavDestination findDestination$navigation_runtime_release = findDestination$navigation_runtime_release(route);
        if (findDestination$navigation_runtime_release == null) {
            throw new IllegalStateException(("Restore State failed: route " + route + " cannot be found from the current destination " + getCurrentDestination$navigation_runtime_release()).toString());
        }
        final String str = this.backStackMap.get(Integer.valueOf(findDestination$navigation_runtime_release.getId()));
        CollectionsKt.removeAll(this.backStackMap.values(), new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean areEqual;
                areEqual = Intrinsics.areEqual((String) obj, str);
                return Boolean.valueOf(areEqual);
            }
        });
        ArrayDeque<NavBackStackEntryState> arrayDeque = (ArrayDeque) TypeIntrinsics.asMutableMap(this.backStackStates).remove(str);
        NavDestination.DeepLinkMatch matchRoute = findDestination$navigation_runtime_release.matchRoute(route);
        Intrinsics.checkNotNull(matchRoute);
        if (matchRoute.hasMatchingArgs((arrayDeque == null || (firstOrNull = arrayDeque.firstOrNull()) == null) ? null : firstOrNull.getArgs())) {
            return executeRestoreState(instantiateBackStack(arrayDeque), null, null, null);
        }
        return false;
    }

    private final boolean executeRestoreState(final List<NavBackStackEntry> entries, final Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        NavBackStackEntry navBackStackEntry;
        NavDestination destination;
        ArrayList<List<NavBackStackEntry>> arrayList = new ArrayList();
        ArrayList<NavBackStackEntry> arrayList2 = new ArrayList();
        for (Object obj : entries) {
            if (!(((NavBackStackEntry) obj).getDestination() instanceof NavGraph)) {
                arrayList2.add(obj);
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayList2) {
            List list = (List) CollectionsKt.lastOrNull((List) arrayList);
            if (Intrinsics.areEqual((list == null || (navBackStackEntry = (NavBackStackEntry) CollectionsKt.last(list)) == null || (destination = navBackStackEntry.getDestination()) == null) ? null : destination.getNavigatorName(), navBackStackEntry2.getDestination().getNavigatorName())) {
                list.add(navBackStackEntry2);
            } else {
                arrayList.add(CollectionsKt.mutableListOf(navBackStackEntry2));
            }
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        for (List<NavBackStackEntry> list2 : arrayList) {
            Navigator<? extends NavDestination> navigator = this._navigatorProvider.getNavigator(((NavBackStackEntry) CollectionsKt.first((List) list2)).getDestination().getNavigatorName());
            final Ref.IntRef intRef = new Ref.IntRef();
            navigateInternal$navigation_runtime_release(navigator, list2, navOptions, navigatorExtras, new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return NavControllerImpl.executeRestoreState$lambda$57(Ref.BooleanRef.this, entries, intRef, this, args, (NavBackStackEntry) obj2);
                }
            });
        }
        return booleanRef.element;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit executeRestoreState$lambda$57(Ref.BooleanRef booleanRef, List list, Ref.IntRef intRef, NavControllerImpl navControllerImpl, Bundle bundle, NavBackStackEntry entry) {
        List<NavBackStackEntry> emptyList;
        Intrinsics.checkNotNullParameter(entry, "entry");
        booleanRef.element = true;
        int indexOf = list.indexOf(entry);
        if (indexOf != -1) {
            int i = indexOf + 1;
            emptyList = list.subList(intRef.element, i);
            intRef.element = i;
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        navControllerImpl.addEntryToBackStack(entry.getDestination(), bundle, entry, emptyList);
        return Unit.INSTANCE;
    }

    private final List<NavBackStackEntry> instantiateBackStack(ArrayDeque<NavBackStackEntryState> backStackState) {
        NavGraph graph$navigation_runtime_release;
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry lastOrNull = this.backQueue.lastOrNull();
        if (lastOrNull == null || (graph$navigation_runtime_release = lastOrNull.getDestination()) == null) {
            graph$navigation_runtime_release = getGraph$navigation_runtime_release();
        }
        if (backStackState != null) {
            NavDestination navDestination = graph$navigation_runtime_release;
            for (NavBackStackEntryState navBackStackEntryState : backStackState) {
                NavControllerImpl navControllerImpl = this;
                NavDestination findDestinationComprehensive$navigation_runtime_release$default = findDestinationComprehensive$navigation_runtime_release$default(navControllerImpl, navDestination, navBackStackEntryState.getDestinationId(), true, null, 8, null);
                if (findDestinationComprehensive$navigation_runtime_release$default == null) {
                    throw new IllegalStateException(("Restore State failed: destination " + NavDestination.INSTANCE.getDisplayName(navControllerImpl.getNavContext(), navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + navDestination).toString());
                }
                arrayList.add(navBackStackEntryState.instantiate(navControllerImpl.getNavContext(), findDestinationComprehensive$navigation_runtime_release$default, navControllerImpl.getHostLifecycleState$navigation_runtime_release(), navControllerImpl.viewModel));
                navDestination = findDestinationComprehensive$navigation_runtime_release$default;
                this = navControllerImpl;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void addEntryToBackStack$default(NavControllerImpl navControllerImpl, NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list, int i, Object obj) {
        if ((i & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        navControllerImpl.addEntryToBackStack(navDestination, bundle, navBackStackEntry, list);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x025b, code lost:
    
        r1 = r9.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0266, code lost:
    
        if (r1.hasNext() == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0268, code lost:
    
        r2 = (androidx.navigation.NavBackStackEntry) r1.next();
        r3 = r29.navigatorState.get(r29._navigatorProvider.getNavigator(r2.getDestination().getNavigatorName()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0282, code lost:
    
        if (r3 == null) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0284, code lost:
    
        r3.addInternal(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02aa, code lost:
    
        throw new java.lang.IllegalStateException(("NavigatorBackStack for " + r30.getNavigatorName() + " should already be created").toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02ab, code lost:
    
        r2 = r9;
        r29.backQueue.addAll(r2);
        r29.backQueue.add(r7);
        r1 = kotlin.collections.CollectionsKt.plus((java.util.Collection<? extends androidx.navigation.NavBackStackEntry>) r2, r7).iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02c6, code lost:
    
        if (r1.hasNext() == false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02c8, code lost:
    
        r2 = (androidx.navigation.NavBackStackEntry) r1.next();
        r3 = r2.getDestination().getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02d6, code lost:
    
        if (r3 == null) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02d8, code lost:
    
        linkChildToParent$navigation_runtime_release(r2, getBackStackEntry$navigation_runtime_release(r3.getId()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02e4, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01f4, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0104, code lost:
    
        r1 = ((androidx.navigation.NavBackStackEntry) r9.first()).getDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x00d5, code lost:
    
        r7 = r32;
        r8 = r33;
        r9 = r1;
        r11 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x009d, code lost:
    
        r10 = r31;
        r18 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0075, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x00dc, code lost:
    
        r10 = r31;
        r9 = r1;
        r11 = r2;
        r18 = r8;
        r8 = r7;
        r7 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x00f3, code lost:
    
        r10 = r31;
        r9 = r1;
        r18 = r8;
        r8 = r7;
        r7 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
    
        r1 = new kotlin.collections.ArrayDeque();
        r17 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
    
        if ((r30 instanceof androidx.navigation.NavGraph) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
    
        r2 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
        r2 = r2.getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
    
        if (r2 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
    
        r3 = r7.listIterator(r7.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
    
        if (r3.hasPrevious() == false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
    
        r4 = r3.previous();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r4.getDestination(), r2) == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0077, code lost:
    
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        if (r4 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007b, code lost:
    
        r10 = r31;
        r18 = r8;
        r4 = androidx.navigation.NavBackStackEntry.Companion.create$default(androidx.navigation.NavBackStackEntry.INSTANCE, getNavContext(), r2, r10, getHostLifecycleState$navigation_runtime_release(), r29.viewModel, null, null, 96, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a1, code lost:
    
        r1.addFirst(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ac, code lost:
    
        if (r29.backQueue.isEmpty() != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x000c, code lost:
    
        if ((r8 instanceof androidx.navigation.FloatingWindow) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ba, code lost:
    
        if (r29.backQueue.last().getDestination() != r2) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bc, code lost:
    
        r11 = r2;
        r9 = r1;
        r7 = r32;
        r8 = r33;
        popEntryFromBackStack$navigation_runtime_release$default(r29, r29.backQueue.last(), false, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e5, code lost:
    
        r2 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e8, code lost:
    
        if (r2 == null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ea, code lost:
    
        if (r2 != r30) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ed, code lost:
    
        r7 = r8;
        r1 = r9;
        r8 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ff, code lost:
    
        if (r9.isEmpty() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0101, code lost:
    
        r1 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x010e, code lost:
    
        if (r1 == null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0118, code lost:
    
        if (findDestination$navigation_runtime_release(r1.getId(), r1) == r1) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x011a, code lost:
    
        r1 = r1.getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x011e, code lost:
    
        if (r1 == null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0120, code lost:
    
        if (r10 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x012b, code lost:
    
        if (androidx.savedstate.SavedStateReader.m7542isEmptyimpl(androidx.savedstate.SavedStateReader.m7464constructorimpl(r10)) != true) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x012d, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if (r29.backQueue.isEmpty() != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0131, code lost:
    
        r3 = r8.listIterator(r8.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x013d, code lost:
    
        if (r3.hasPrevious() == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x013f, code lost:
    
        r4 = r3.previous();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x014e, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r4.getDestination(), r1) == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0153, code lost:
    
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0155, code lost:
    
        if (r4 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0157, code lost:
    
        r4 = androidx.navigation.NavBackStackEntry.Companion.create$default(androidx.navigation.NavBackStackEntry.INSTANCE, getNavContext(), r1, r1.addInDefaultArgs(r2), getHostLifecycleState$navigation_runtime_release(), r29.viewModel, null, null, 96, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x017b, code lost:
    
        r9.addFirst(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x017e, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0151, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0130, code lost:
    
        r2 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0185, code lost:
    
        if (r9.isEmpty() == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0024, code lost:
    
        if ((r29.backQueue.last().getDestination() instanceof androidx.navigation.FloatingWindow) == false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0188, code lost:
    
        r18 = ((androidx.navigation.NavBackStackEntry) r9.first()).getDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x019a, code lost:
    
        if (r29.backQueue.isEmpty() != false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01aa, code lost:
    
        if ((r29.backQueue.last().getDestination() instanceof androidx.navigation.NavGraph) == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01ac, code lost:
    
        r1 = r29.backQueue.last().getDestination();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.navigation.NavGraph");
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01cb, code lost:
    
        if (((androidx.navigation.NavGraph) r1).getNodes().get(r18.getId()) != null) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01cd, code lost:
    
        popEntryFromBackStack$navigation_runtime_release$default(r29, r29.backQueue.last(), false, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01dd, code lost:
    
        r1 = r29.backQueue.firstOrNull();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01e5, code lost:
    
        if (r1 != null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01e7, code lost:
    
        r1 = (androidx.navigation.NavBackStackEntry) r9.firstOrNull();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01ed, code lost:
    
        if (r1 == null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01ef, code lost:
    
        r1 = r1.getDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01fc, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1, r29._graph) != false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01fe, code lost:
    
        r1 = r8.listIterator(r8.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x020a, code lost:
    
        if (r1.hasPrevious() == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003e, code lost:
    
        if (popBackStackInternal$navigation_runtime_release$default(r29, r29.backQueue.last().getDestination().getId(), true, false, 4, (java.lang.Object) null) != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x020c, code lost:
    
        r2 = r1.previous();
        r3 = r2.getDestination();
        r4 = r29._graph;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0220, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3, r4) == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0222, code lost:
    
        r17 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0224, code lost:
    
        r17 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0226, code lost:
    
        if (r17 != null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0228, code lost:
    
        r18 = androidx.navigation.NavBackStackEntry.INSTANCE;
        r19 = getNavContext();
        r1 = r29._graph;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r20 = r1;
        r1 = r29._graph;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r17 = androidx.navigation.NavBackStackEntry.Companion.create$default(r18, r19, r20, r1.addInDefaultArgs(r10), getHostLifecycleState$navigation_runtime_release(), r29.viewModel, null, null, 96, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0256, code lost:
    
        r9.addFirst(r17);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void addEntryToBackStack(androidx.navigation.NavDestination r30, android.os.Bundle r31, androidx.navigation.NavBackStackEntry r32, java.util.List<androidx.navigation.NavBackStackEntry> r33) {
        /*
            Method dump skipped, instructions count: 741
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.internal.NavControllerImpl.addEntryToBackStack(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavBackStackEntry, java.util.List):void");
    }

    public final void navigate$navigation_runtime_release(String route, Function1<? super NavOptionsBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(builder, "builder");
        navigate$navigation_runtime_release$default(this, route, NavOptionsBuilderKt.navOptions(builder), (Navigator.Extras) null, 4, (Object) null);
    }

    public static /* synthetic */ void navigate$navigation_runtime_release$default(NavControllerImpl navControllerImpl, String str, NavOptions navOptions, Navigator.Extras extras, int i, Object obj) {
        if ((i & 4) != 0) {
            extras = null;
        }
        navControllerImpl.navigate$navigation_runtime_release(str, navOptions, extras);
    }

    public final void navigate$navigation_runtime_release(String route, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(route, "route");
        if (this._graph == null) {
            throw new IllegalArgumentException(("Cannot navigate to " + route + ". Navigation graph has not been set for NavController " + this + '.').toString());
        }
        NavGraph topGraph$navigation_runtime_release = getTopGraph$navigation_runtime_release();
        NavDestination.DeepLinkMatch matchRouteComprehensive = topGraph$navigation_runtime_release.matchRouteComprehensive(route, true, true, topGraph$navigation_runtime_release);
        if (matchRouteComprehensive != null) {
            NavDestination destination = matchRouteComprehensive.getDestination();
            Bundle addInDefaultArgs = destination.addInDefaultArgs(matchRouteComprehensive.getMatchingArgs());
            if (addInDefaultArgs == null) {
                Map emptyMap = MapsKt.emptyMap();
                if (emptyMap.isEmpty()) {
                    pairArr = new Pair[0];
                } else {
                    ArrayList arrayList = new ArrayList(emptyMap.size());
                    for (Map.Entry entry : emptyMap.entrySet()) {
                        arrayList.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
                    }
                    pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
                }
                addInDefaultArgs = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
                SavedStateWriter.m7550constructorimpl(addInDefaultArgs);
            }
            NavDestination destination2 = matchRouteComprehensive.getDestination();
            this.navController.writeIntent$navigation_runtime_release(NavDeepLinkRequest.Builder.INSTANCE.fromUri(NavUriKt.NavUri(NavDestination.INSTANCE.createRoute(destination.getRoute()))).build(), addInDefaultArgs);
            navigate$navigation_runtime_release(destination2, addInDefaultArgs, navOptions, navigatorExtras);
            return;
        }
        throw new IllegalArgumentException("Navigation destination that matches route " + route + " cannot be found in the navigation graph " + this._graph);
    }

    public final <T> void navigate$navigation_runtime_release(T route, Function1<? super NavOptionsBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(builder, "builder");
        navigate$navigation_runtime_release$default(this, route, NavOptionsBuilderKt.navOptions(builder), (Navigator.Extras) null, 4, (Object) null);
    }

    public static /* synthetic */ void navigate$navigation_runtime_release$default(NavControllerImpl navControllerImpl, Object obj, NavOptions navOptions, Navigator.Extras extras, int i, Object obj2) {
        if ((i & 4) != 0) {
            extras = null;
        }
        navControllerImpl.navigate$navigation_runtime_release((NavControllerImpl) obj, navOptions, extras);
    }

    public final <T> void navigate$navigation_runtime_release(T route, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        Intrinsics.checkNotNullParameter(route, "route");
        navigate$navigation_runtime_release(generateRouteFilled$navigation_runtime_release(route), navOptions, navigatorExtras);
    }

    public final Bundle saveState$navigation_runtime_release() {
        Pair[] pairArr;
        Bundle bundle;
        Pair[] pairArr2;
        Pair[] pairArr3;
        Pair[] pairArr4;
        Pair[] pairArr5;
        ArrayList arrayList = new ArrayList();
        Map emptyMap = MapsKt.emptyMap();
        if (emptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList2 = new ArrayList(emptyMap.size());
            for (Map.Entry entry : emptyMap.entrySet()) {
                arrayList2.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList2.toArray(new Pair[0]);
        }
        Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.m7550constructorimpl(bundleOf);
        for (Map.Entry<String, Navigator<? extends NavDestination>> entry2 : this._navigatorProvider.getNavigators().entrySet()) {
            String key = entry2.getKey();
            Bundle onSaveState = entry2.getValue().onSaveState();
            if (onSaveState != null) {
                arrayList.add(key);
                SavedStateWriter.m7577putSavedStateimpl(SavedStateWriter.m7550constructorimpl(bundleOf), key, onSaveState);
            }
        }
        if (arrayList.isEmpty()) {
            bundle = null;
        } else {
            Map emptyMap2 = MapsKt.emptyMap();
            if (emptyMap2.isEmpty()) {
                pairArr5 = new Pair[0];
            } else {
                ArrayList arrayList3 = new ArrayList(emptyMap2.size());
                for (Map.Entry entry3 : emptyMap2.entrySet()) {
                    arrayList3.add(TuplesKt.to((String) entry3.getKey(), entry3.getValue()));
                }
                pairArr5 = (Pair[]) arrayList3.toArray(new Pair[0]);
            }
            bundle = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr5, pairArr5.length));
            Bundle m7550constructorimpl = SavedStateWriter.m7550constructorimpl(bundle);
            SavedStateWriter.m7585putStringListimpl(SavedStateWriter.m7550constructorimpl(bundleOf), KEY_NAVIGATOR_STATE_NAMES, arrayList);
            SavedStateWriter.m7577putSavedStateimpl(m7550constructorimpl, KEY_NAVIGATOR_STATE, bundleOf);
        }
        if (!this.backQueue.isEmpty()) {
            if (bundle == null) {
                Map emptyMap3 = MapsKt.emptyMap();
                if (emptyMap3.isEmpty()) {
                    pairArr4 = new Pair[0];
                } else {
                    ArrayList arrayList4 = new ArrayList(emptyMap3.size());
                    for (Map.Entry entry4 : emptyMap3.entrySet()) {
                        arrayList4.add(TuplesKt.to((String) entry4.getKey(), entry4.getValue()));
                    }
                    pairArr4 = (Pair[]) arrayList4.toArray(new Pair[0]);
                }
                Bundle bundleOf2 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr4, pairArr4.length));
                SavedStateWriter.m7550constructorimpl(bundleOf2);
                bundle = bundleOf2;
            }
            ArrayList arrayList5 = new ArrayList();
            Iterator it = this.backQueue.iterator();
            while (it.hasNext()) {
                arrayList5.add(new NavBackStackEntryState((NavBackStackEntry) it.next()).writeToState());
            }
            SavedStateWriter.m7579putSavedStateListimpl(SavedStateWriter.m7550constructorimpl(bundle), KEY_BACK_STACK, arrayList5);
        }
        if (!this.backStackMap.isEmpty()) {
            if (bundle == null) {
                Map emptyMap4 = MapsKt.emptyMap();
                if (emptyMap4.isEmpty()) {
                    pairArr3 = new Pair[0];
                } else {
                    ArrayList arrayList6 = new ArrayList(emptyMap4.size());
                    for (Map.Entry entry5 : emptyMap4.entrySet()) {
                        arrayList6.add(TuplesKt.to((String) entry5.getKey(), entry5.getValue()));
                    }
                    pairArr3 = (Pair[]) arrayList6.toArray(new Pair[0]);
                }
                Bundle bundleOf3 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr3, pairArr3.length));
                SavedStateWriter.m7550constructorimpl(bundleOf3);
                bundle = bundleOf3;
            }
            int[] iArr = new int[this.backStackMap.size()];
            ArrayList arrayList7 = new ArrayList();
            int i = 0;
            for (Map.Entry<Integer, String> entry6 : this.backStackMap.entrySet()) {
                int intValue = entry6.getKey().intValue();
                String value = entry6.getValue();
                int i2 = i + 1;
                iArr[i] = intValue;
                if (value == null) {
                    value = "";
                }
                arrayList7.add(value);
                i = i2;
            }
            Bundle m7550constructorimpl2 = SavedStateWriter.m7550constructorimpl(bundle);
            SavedStateWriter.m7568putIntArrayimpl(m7550constructorimpl2, KEY_BACK_STACK_DEST_IDS, iArr);
            SavedStateWriter.m7585putStringListimpl(m7550constructorimpl2, KEY_BACK_STACK_IDS, arrayList7);
        }
        if (!this.backStackStates.isEmpty()) {
            if (bundle == null) {
                Map emptyMap5 = MapsKt.emptyMap();
                if (emptyMap5.isEmpty()) {
                    pairArr2 = new Pair[0];
                } else {
                    ArrayList arrayList8 = new ArrayList(emptyMap5.size());
                    for (Map.Entry entry7 : emptyMap5.entrySet()) {
                        arrayList8.add(TuplesKt.to((String) entry7.getKey(), entry7.getValue()));
                    }
                    pairArr2 = (Pair[]) arrayList8.toArray(new Pair[0]);
                }
                bundle = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr2, pairArr2.length));
                SavedStateWriter.m7550constructorimpl(bundle);
            }
            ArrayList arrayList9 = new ArrayList();
            for (Map.Entry<String, ArrayDeque<NavBackStackEntryState>> entry8 : this.backStackStates.entrySet()) {
                String key2 = entry8.getKey();
                ArrayDeque<NavBackStackEntryState> value2 = entry8.getValue();
                arrayList9.add(key2);
                ArrayList arrayList10 = new ArrayList();
                Iterator<NavBackStackEntryState> it2 = value2.iterator();
                while (it2.hasNext()) {
                    arrayList10.add(it2.next().writeToState());
                }
                SavedStateWriter.m7579putSavedStateListimpl(SavedStateWriter.m7550constructorimpl(bundle), KEY_BACK_STACK_STATES_PREFIX + key2, arrayList10);
            }
            SavedStateWriter.m7585putStringListimpl(SavedStateWriter.m7550constructorimpl(bundle), KEY_BACK_STACK_STATES_IDS, arrayList9);
        }
        return bundle;
    }

    public final void setLifecycleOwner$navigation_runtime_release(LifecycleOwner owner) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (Intrinsics.areEqual(owner, this.lifecycleOwner)) {
            return;
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this.lifecycleObserver);
        }
        this.lifecycleOwner = owner;
        owner.getLifecycle().addObserver(this.lifecycleObserver);
    }

    public final void setViewModelStore$navigation_runtime_release(ViewModelStore viewModelStore) {
        Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
        if (Intrinsics.areEqual(this.viewModel, NavControllerViewModel.INSTANCE.getInstance(viewModelStore))) {
            return;
        }
        if (!this.backQueue.isEmpty()) {
            throw new IllegalStateException("ViewModelStore should be set before setGraph call".toString());
        }
        this.viewModel = NavControllerViewModel.INSTANCE.getInstance(viewModelStore);
    }

    public final ViewModelStoreOwner getViewModelStoreOwner$navigation_runtime_release(int navGraphId) {
        if (this.viewModel == null) {
            throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().".toString());
        }
        NavBackStackEntry backStackEntry$navigation_runtime_release = getBackStackEntry$navigation_runtime_release(navGraphId);
        if (!(backStackEntry$navigation_runtime_release.getDestination() instanceof NavGraph)) {
            throw new IllegalArgumentException(("No NavGraph with ID " + navGraphId + " is on the NavController's back stack").toString());
        }
        return backStackEntry$navigation_runtime_release;
    }

    public final NavBackStackEntry getBackStackEntry$navigation_runtime_release(int destinationId) {
        NavBackStackEntry navBackStackEntry;
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            if (navBackStackEntry.getDestination().getId() == destinationId) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
        if (navBackStackEntry2 != null) {
            return navBackStackEntry2;
        }
        throw new IllegalArgumentException(("No destination with ID " + destinationId + " is on the NavController's back stack. The current destination is " + getCurrentDestination$navigation_runtime_release()).toString());
    }

    public final NavBackStackEntry getBackStackEntry$navigation_runtime_release(String route) {
        NavBackStackEntry navBackStackEntry;
        Intrinsics.checkNotNullParameter(route, "route");
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
            if (navBackStackEntry2.getDestination().hasRoute(route, navBackStackEntry2.getArguments())) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry3 = navBackStackEntry;
        if (navBackStackEntry3 != null) {
            return navBackStackEntry3;
        }
        throw new IllegalArgumentException(("No destination with route " + route + " is on the NavController's back stack. The current destination is " + getCurrentDestination$navigation_runtime_release()).toString());
    }

    public final <T> NavBackStackEntry getBackStackEntry$navigation_runtime_release(KClass<T> route) {
        NavBackStackEntry navBackStackEntry;
        Intrinsics.checkNotNullParameter(route, "route");
        int generateHashCode = RouteSerializerKt.generateHashCode(SerializersKt.serializer(route));
        if (findDestinationComprehensive$navigation_runtime_release$default(this, getGraph$navigation_runtime_release(), generateHashCode, true, null, 8, null) == null) {
            throw new IllegalArgumentException(("Destination with route " + route.getSimpleName() + " cannot be found in navigation graph " + getGraph$navigation_runtime_release()).toString());
        }
        List<NavBackStackEntry> value = this.currentBackStack.getValue();
        ListIterator<NavBackStackEntry> listIterator = value.listIterator(value.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            if (navBackStackEntry.getDestination().getId() == generateHashCode) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
        if (navBackStackEntry2 != null) {
            return navBackStackEntry2;
        }
        throw new IllegalArgumentException(("No destination with route " + route.getSimpleName() + " is on the NavController's back stack. The current destination is " + getCurrentDestination$navigation_runtime_release()).toString());
    }

    public final <T> NavBackStackEntry getBackStackEntry$navigation_runtime_release(T route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return getBackStackEntry$navigation_runtime_release(generateRouteFilled$navigation_runtime_release(route));
    }

    public final NavBackStackEntry getCurrentBackStackEntry$navigation_runtime_release() {
        return this.backQueue.lastOrNull();
    }

    public final MutableSharedFlow<NavBackStackEntry> get_currentBackStackEntryFlow$navigation_runtime_release() {
        return this._currentBackStackEntryFlow;
    }

    public final NavBackStackEntry getPreviousBackStackEntry$navigation_runtime_release() {
        Object obj;
        Iterator it = CollectionsKt.reversed(this.backQueue).iterator();
        if (it.hasNext()) {
            it.next();
        }
        Iterator it2 = SequencesKt.asSequence(it).iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (!(((NavBackStackEntry) obj).getDestination() instanceof NavGraph)) {
                break;
            }
        }
        return (NavBackStackEntry) obj;
    }

    public final void restoreState$navigation_runtime_release(Bundle navState) {
        if (navState == null) {
            return;
        }
        Bundle m7464constructorimpl = SavedStateReader.m7464constructorimpl(navState);
        this.navigatorStateToRestore = SavedStateReader.m7465containsimpl(m7464constructorimpl, KEY_NAVIGATOR_STATE) ? SavedStateReader.m7521getSavedStateimpl(m7464constructorimpl, KEY_NAVIGATOR_STATE) : null;
        int i = 0;
        this.backStackToRestore = SavedStateReader.m7465containsimpl(m7464constructorimpl, KEY_BACK_STACK) ? (Bundle[]) SavedStateReader.m7524getSavedStateListimpl(m7464constructorimpl, KEY_BACK_STACK).toArray(new Bundle[0]) : null;
        this.backStackStates.clear();
        if (SavedStateReader.m7465containsimpl(m7464constructorimpl, KEY_BACK_STACK_DEST_IDS) && SavedStateReader.m7465containsimpl(m7464constructorimpl, KEY_BACK_STACK_IDS)) {
            int[] m7496getIntArrayimpl = SavedStateReader.m7496getIntArrayimpl(m7464constructorimpl, KEY_BACK_STACK_DEST_IDS);
            List<String> m7538getStringListimpl = SavedStateReader.m7538getStringListimpl(m7464constructorimpl, KEY_BACK_STACK_IDS);
            int length = m7496getIntArrayimpl.length;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                this.backStackMap.put(Integer.valueOf(m7496getIntArrayimpl[i]), !Intrinsics.areEqual(m7538getStringListimpl.get(i2), "") ? m7538getStringListimpl.get(i2) : null);
                i++;
                i2 = i3;
            }
        }
        if (SavedStateReader.m7465containsimpl(m7464constructorimpl, KEY_BACK_STACK_STATES_IDS)) {
            for (String str : SavedStateReader.m7538getStringListimpl(m7464constructorimpl, KEY_BACK_STACK_STATES_IDS)) {
                if (SavedStateReader.m7465containsimpl(m7464constructorimpl, KEY_BACK_STACK_STATES_PREFIX + str)) {
                    List<Bundle> m7524getSavedStateListimpl = SavedStateReader.m7524getSavedStateListimpl(m7464constructorimpl, KEY_BACK_STACK_STATES_PREFIX + str);
                    Map<String, ArrayDeque<NavBackStackEntryState>> map = this.backStackStates;
                    ArrayDeque<NavBackStackEntryState> arrayDeque = new ArrayDeque<>(m7524getSavedStateListimpl.size());
                    Iterator<Bundle> it = m7524getSavedStateListimpl.iterator();
                    while (it.hasNext()) {
                        arrayDeque.add(new NavBackStackEntryState(it.next()));
                    }
                    map.put(str, arrayDeque);
                }
            }
        }
    }
}
