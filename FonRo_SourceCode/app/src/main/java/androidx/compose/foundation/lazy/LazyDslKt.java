package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

/* compiled from: LazyDsl.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001al\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a\u0082\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0018\u001av\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0019\u001al\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001f\u001a\u0082\u0001\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010 \u001av\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010!\u001a©\u0001\u0010\"\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H#0$2%\b\n\u0010%\u001a\u001f\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010\u00112%\b\n\u0010*\u001a\u001f\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0006\u0012\u0004\u0018\u00010)0\u001123\b\u0004\u0010+\u001a-\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010,¢\u0006\u0002\b.¢\u0006\u0002\b\u0013H\u0086\b¢\u0006\u0002\u0010/\u001a\u0082\u0001\u0010\"\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H#0$2%\b\n\u0010%\u001a\u001f\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010\u001123\b\u0004\u0010+\u001a-\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010,¢\u0006\u0002\b.¢\u0006\u0002\b\u0013H\u0087\b¢\u0006\u0002\u00100\u001a©\u0001\u0010\"\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H#012%\b\n\u0010%\u001a\u001f\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010\u00112%\b\n\u0010*\u001a\u001f\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0006\u0012\u0004\u0018\u00010)0\u001123\b\u0004\u0010+\u001a-\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010,¢\u0006\u0002\b.¢\u0006\u0002\b\u0013H\u0086\b¢\u0006\u0002\u00102\u001a\u0082\u0001\u0010\"\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H#012%\b\n\u0010%\u001a\u001f\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010\u001123\b\u0004\u0010+\u001a-\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010,¢\u0006\u0002\b.¢\u0006\u0002\b\u0013H\u0087\b¢\u0006\u0002\u00103\u001aè\u0001\u00104\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H#0$2:\b\n\u0010%\u001a4\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010,2:\b\u0006\u0010*\u001a4\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0006\u0012\u0004\u0018\u00010)0,2H\b\u0004\u0010+\u001aB\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u000107¢\u0006\u0002\b.¢\u0006\u0002\b\u0013H\u0086\b¢\u0006\u0002\u00108\u001a¬\u0001\u00104\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H#0$2:\b\n\u0010%\u001a4\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010,2H\b\u0004\u0010+\u001aB\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u000107¢\u0006\u0002\b.¢\u0006\u0002\b\u0013H\u0087\b¢\u0006\u0002\u00109\u001aè\u0001\u00104\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H#012:\b\n\u0010%\u001a4\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010,2:\b\u0006\u0010*\u001a4\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0006\u0012\u0004\u0018\u00010)0,2H\b\u0004\u0010+\u001aB\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u000107¢\u0006\u0002\b.¢\u0006\u0002\b\u0013H\u0086\b¢\u0006\u0002\u0010:\u001a¬\u0001\u00104\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H#012:\b\n\u0010%\u001a4\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010,2H\b\u0004\u0010+\u001aB\u0012\u0004\u0012\u00020-\u0012\u0013\u0012\u001105¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(6\u0012\u0013\u0012\u0011H#¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u000107¢\u0006\u0002\b.¢\u0006\u0002\b\u0013H\u0087\b¢\u0006\u0002\u0010;¨\u0006<"}, d2 = {"LazyColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyRow", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", FirebaseAnalytics.Param.ITEMS, ExifInterface.GPS_DIRECTION_TRUE, "", "key", "Lkotlin/ParameterName;", "name", "item", "", "contentType", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", FirebaseAnalytics.Param.INDEX, "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyDslKt {
    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List list, Function1 function1, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = LazyDslKt$items$1.INSTANCE;
        }
        lazyListScope.items(list.size(), function1 != null ? new LazyDslKt$items$2(function1, list) : null, new LazyDslKt$items$3(function12, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(function4, list)));
    }

    public static final <T> void items(LazyListScope lazyListScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyListScope.items(list.size(), function1 != null ? new LazyDslKt$items$2(function1, list) : null, new LazyDslKt$items$3(function12, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List list, Function2 function2, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$1
                public final Void invoke(int i2, T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), (int) obj3);
                }
            };
        }
        lazyListScope.items(list.size(), function2 != null ? new LazyDslKt$itemsIndexed$2(function2, list) : null, new LazyDslKt$itemsIndexed$3(function22, list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(function5, list)));
    }

    public static final <T> void itemsIndexed(LazyListScope lazyListScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyListScope.items(list.size(), function2 != null ? new LazyDslKt$itemsIndexed$2(function2, list) : null, new LazyDslKt$itemsIndexed$3(function22, list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(function5, list)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] objArr, Function1 function1, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = LazyDslKt$items$5.INSTANCE;
        }
        lazyListScope.items(objArr.length, function1 != null ? new LazyDslKt$items$6(function1, objArr) : null, new LazyDslKt$items$7(function12, objArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(function4, objArr)));
    }

    public static final <T> void items(LazyListScope lazyListScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyListScope.items(tArr.length, function1 != null ? new LazyDslKt$items$6(function1, tArr) : null, new LazyDslKt$items$7(function12, tArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(function4, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] objArr, Function2 function2, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$5
                public final Void invoke(int i2, T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), (int) obj3);
                }
            };
        }
        lazyListScope.items(objArr.length, function2 != null ? new LazyDslKt$itemsIndexed$6(function2, objArr) : null, new LazyDslKt$itemsIndexed$7(function22, objArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(function5, objArr)));
    }

    public static final <T> void itemsIndexed(LazyListScope lazyListScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyListScope.items(tArr.length, function2 != null ? new LazyDslKt$itemsIndexed$6(function2, tArr) : null, new LazyDslKt$itemsIndexed$7(function22, tArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(function5, tArr)));
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LazyRow(androidx.compose.ui.Modifier r31, androidx.compose.foundation.lazy.LazyListState r32, androidx.compose.foundation.layout.PaddingValues r33, boolean r34, androidx.compose.foundation.layout.Arrangement.Horizontal r35, androidx.compose.ui.Alignment.Vertical r36, androidx.compose.foundation.gestures.FlingBehavior r37, boolean r38, androidx.compose.foundation.OverscrollEffect r39, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyRow(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.foundation.OverscrollEffect, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LazyColumn(androidx.compose.ui.Modifier r31, androidx.compose.foundation.lazy.LazyListState r32, androidx.compose.foundation.layout.PaddingValues r33, boolean r34, androidx.compose.foundation.layout.Arrangement.Vertical r35, androidx.compose.ui.Alignment.Horizontal r36, androidx.compose.foundation.gestures.FlingBehavior r37, boolean r38, androidx.compose.foundation.OverscrollEffect r39, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 669
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.foundation.OverscrollEffect, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void LazyColumn(androidx.compose.ui.Modifier r25, androidx.compose.foundation.lazy.LazyListState r26, androidx.compose.foundation.layout.PaddingValues r27, boolean r28, androidx.compose.foundation.layout.Arrangement.Vertical r29, androidx.compose.ui.Alignment.Horizontal r30, androidx.compose.foundation.gestures.FlingBehavior r31, boolean r32, final kotlin.jvm.functions.Function1 r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 577
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void LazyColumn(androidx.compose.ui.Modifier r24, androidx.compose.foundation.lazy.LazyListState r25, androidx.compose.foundation.layout.PaddingValues r26, boolean r27, androidx.compose.foundation.layout.Arrangement.Vertical r28, androidx.compose.ui.Alignment.Horizontal r29, androidx.compose.foundation.gestures.FlingBehavior r30, final kotlin.jvm.functions.Function1 r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 551
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void LazyRow(androidx.compose.ui.Modifier r25, androidx.compose.foundation.lazy.LazyListState r26, androidx.compose.foundation.layout.PaddingValues r27, boolean r28, androidx.compose.foundation.layout.Arrangement.Horizontal r29, androidx.compose.ui.Alignment.Vertical r30, androidx.compose.foundation.gestures.FlingBehavior r31, boolean r32, final kotlin.jvm.functions.Function1 r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 577
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyRow(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void LazyRow(androidx.compose.ui.Modifier r24, androidx.compose.foundation.lazy.LazyListState r25, androidx.compose.foundation.layout.PaddingValues r26, boolean r27, androidx.compose.foundation.layout.Arrangement.Horizontal r28, androidx.compose.ui.Alignment.Vertical r29, androidx.compose.foundation.gestures.FlingBehavior r30, final kotlin.jvm.functions.Function1 r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 551
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyRow(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.FlingBehavior, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List list, Function1 function1, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        lazyListScope.items(list.size(), function1 != null ? new LazyDslKt$items$2(function1, list) : null, new LazyDslKt$items$3(LazyDslKt$items$1.INSTANCE, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List list, Function2 function2, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        lazyListScope.items(list.size(), function2 != null ? new LazyDslKt$itemsIndexed$2(function2, list) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(function5, list)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] objArr, Function1 function1, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        lazyListScope.items(objArr.length, function1 != null ? new LazyDslKt$items$6(function1, objArr) : null, new LazyDslKt$items$7(LazyDslKt$items$5.INSTANCE, objArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(function4, objArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] objArr, Function2 function2, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        lazyListScope.items(objArr.length, function2 != null ? new LazyDslKt$itemsIndexed$6(function2, objArr) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(objArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(function5, objArr)));
    }
}
