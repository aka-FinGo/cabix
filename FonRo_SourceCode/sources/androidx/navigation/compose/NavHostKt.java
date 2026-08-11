package androidx.navigation.compose;

import androidx.collection.MutableObjectFloatMap;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SizeTransform;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavType;
import androidx.navigation.compose.ComposeNavGraphNavigator;
import androidx.navigation.compose.ComposeNavigator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: NavHost.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r\u001aÚ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u001f\b\u0002\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0014\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0016\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0017\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\f2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0018\u001a\u0098\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052$\b\u0002\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2(\b\u0002\u0010\u001a\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u001c\u001a¿\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u001d2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d2\u001d\b\u0002\u0010\u001e\u001a\u0017\u0012\u0004\u0012\u00020 \u0012\r\u0012\u000b\u0012\u0002\b\u00030!¢\u0006\u0002\b\u00190\u001f2$\b\u0002\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2(\b\u0002\u0010\u001a\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\"\u001a»\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020#2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d2\u001d\b\u0002\u0010\u001e\u001a\u0017\u0012\u0004\u0012\u00020 \u0012\r\u0012\u000b\u0012\u0002\b\u00030!¢\u0006\u0002\b\u00190\u001f2$\b\u0002\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2(\b\u0002\u0010\u001a\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010$\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010'\u001aµ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u001f\b\u0002\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0014\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0016\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0017\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010(\u001aó\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2$\b\u0002\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2(\b\u0002\u0010\u001a\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010)\u001a\u001c\u0010*\u001a\u0004\u0018\u00010\u0013*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002\u001a\u001c\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002\u001a\u001c\u0010.\u001a\u0004\u0018\u00010\u0013*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002\u001a\u001c\u0010/\u001a\u0004\u0018\u00010\u0015*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002\u001a\u001c\u00100\u001a\u0004\u0018\u00010\u001b*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¨\u00061²\u0006\u0010\u00102\u001a\b\u0012\u0004\u0012\u00020\u001203X\u008a\u0084\u0002²\u0006\n\u00104\u001a\u000205X\u008a\u008e\u0002²\u0006\n\u00106\u001a\u000207X\u008a\u008e\u0002²\u0006\u0010\u00108\u001a\b\u0012\u0004\u0012\u00020\u001203X\u008a\u0084\u0002²\u0006\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020\u001203X\u008a\u0084\u0002"}, d2 = {"NavHost", "", "navController", "Landroidx/navigation/NavHostController;", "startDestination", "", "modifier", "Landroidx/compose/ui/Modifier;", "route", "builder", "Lkotlin/Function1;", "Landroidx/navigation/NavGraphBuilder;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "contentAlignment", "Landroidx/compose/ui/Alignment;", "enterTransition", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/animation/EnterTransition;", "exitTransition", "Landroidx/compose/animation/ExitTransition;", "popEnterTransition", "popExitTransition", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Lkotlin/jvm/JvmSuppressWildcards;", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "Lkotlin/reflect/KClass;", "typeMap", "", "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "(Landroidx/navigation/NavHostController;Lkotlin/reflect/KClass;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/reflect/KClass;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "", "(Landroidx/navigation/NavHostController;Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/reflect/KClass;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "graph", "Landroidx/navigation/NavGraph;", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "createEnterTransition", "Landroidx/navigation/NavDestination;", "scope", "createExitTransition", "createPopEnterTransition", "createPopExitTransition", "createSizeTransform", "navigation-compose_release", "currentBackStack", "", "progress", "", "inPredictiveBack", "", "allVisibleEntries", "visibleEntries"}, k = 2, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class NavHostKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NavHost$lambda$1(NavHostController navHostController, String str, Modifier modifier, String str2, Function1 function1, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, str, modifier, str2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NavHost$lambda$13(NavHostController navHostController, String str, Modifier modifier, Alignment alignment, String str2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i, int i2, int i3, Composer composer, int i4) {
        NavHost(navHostController, str, modifier, alignment, str2, function1, function12, function13, function14, function15, function16, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NavHost$lambda$19(NavHostController navHostController, KClass kClass, Modifier modifier, Alignment alignment, KClass kClass2, Map map, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i, int i2, int i3, Composer composer, int i4) {
        NavHost(navHostController, (KClass<?>) kClass, modifier, alignment, (KClass<?>) kClass2, (Map<KType, NavType<?>>) map, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function1, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function12, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function13, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function14, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) function15, (Function1<? super NavGraphBuilder, Unit>) function16, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NavHost$lambda$25(NavHostController navHostController, Object obj, Modifier modifier, Alignment alignment, KClass kClass, Map map, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i, int i2, int i3, Composer composer, int i4) {
        NavHost(navHostController, obj, modifier, alignment, (KClass<?>) kClass, (Map<KType, NavType<?>>) map, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function1, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function12, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function13, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function14, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) function15, (Function1<? super NavGraphBuilder, Unit>) function16, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NavHost$lambda$26(NavHostController navHostController, NavGraph navGraph, Modifier modifier, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, navGraph, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NavHost$lambda$31(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, navGraph, modifier, alignment, function1, function12, function13, function14, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NavHost$lambda$37(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, navGraph, modifier, alignment, function1, function12, function13, function14, function15, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NavHost$lambda$7(NavHostController navHostController, String str, Modifier modifier, Alignment alignment, String str2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, str, modifier, alignment, str2, function1, function12, function13, function14, function15, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NavHost$lambda$79(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, navGraph, modifier, alignment, function1, function12, function13, function14, function15, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NavHost$lambda$80(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, navGraph, modifier, alignment, function1, function12, function13, function14, function15, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x006a  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports AnimatedContent")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void NavHost(final androidx.navigation.NavHostController r16, final java.lang.String r17, androidx.compose.ui.Modifier r18, java.lang.String r19, final kotlin.jvm.functions.Function1 r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, java.lang.String, androidx.compose.ui.Modifier, java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x019a  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports sizeTransform")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void NavHost(final androidx.navigation.NavHostController r23, final java.lang.String r24, androidx.compose.ui.Modifier r25, androidx.compose.ui.Alignment r26, java.lang.String r27, kotlin.jvm.functions.Function1 r28, kotlin.jvm.functions.Function1 r29, kotlin.jvm.functions.Function1 r30, kotlin.jvm.functions.Function1 r31, final kotlin.jvm.functions.Function1 r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 682
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void NavHost(final androidx.navigation.NavHostController r24, final java.lang.String r25, androidx.compose.ui.Modifier r26, androidx.compose.ui.Alignment r27, java.lang.String r28, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r29, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r30, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r31, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r32, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.SizeTransform> r33, final kotlin.jvm.functions.Function1<? super androidx.navigation.NavGraphBuilder, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, final int r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 758
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void NavHost(final androidx.navigation.NavHostController r26, final kotlin.reflect.KClass<?> r27, androidx.compose.ui.Modifier r28, androidx.compose.ui.Alignment r29, kotlin.reflect.KClass<?> r30, java.util.Map<kotlin.reflect.KType, androidx.navigation.NavType<?>> r31, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r32, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r33, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r34, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r35, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.SizeTransform> r36, final kotlin.jvm.functions.Function1<? super androidx.navigation.NavGraphBuilder, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, final int r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 797
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, kotlin.reflect.KClass, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, kotlin.reflect.KClass, java.util.Map, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void NavHost(final androidx.navigation.NavHostController r26, final java.lang.Object r27, androidx.compose.ui.Modifier r28, androidx.compose.ui.Alignment r29, kotlin.reflect.KClass<?> r30, java.util.Map<kotlin.reflect.KType, androidx.navigation.NavType<?>> r31, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r32, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r33, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r34, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r35, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.SizeTransform> r36, final kotlin.jvm.functions.Function1<? super androidx.navigation.NavGraphBuilder, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, final int r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 797
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, java.lang.Object, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, kotlin.reflect.KClass, java.util.Map, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007f  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports AnimatedContent")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void NavHost(final androidx.navigation.NavHostController r17, final androidx.navigation.NavGraph r18, androidx.compose.ui.Modifier r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            r4 = r21
            r0 = -957014592(0xffffffffc6f51dc0, float:-31374.875)
            r1 = r20
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(NavHost)P(2)393@15709L39:NavHost.kt#opm8kd"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r22 & 1
            if (r1 == 0) goto L1a
            r1 = r4 | 6
            r2 = r1
            r1 = r17
            goto L2e
        L1a:
            r1 = r4 & 6
            if (r1 != 0) goto L2b
            r1 = r17
            boolean r2 = r14.changedInstance(r1)
            if (r2 == 0) goto L28
            r2 = 4
            goto L29
        L28:
            r2 = 2
        L29:
            r2 = r2 | r4
            goto L2e
        L2b:
            r1 = r17
            r2 = r4
        L2e:
            r3 = r22 & 2
            if (r3 == 0) goto L37
            r2 = r2 | 48
            r6 = r18
            goto L49
        L37:
            r3 = r4 & 48
            r6 = r18
            if (r3 != 0) goto L49
            boolean r3 = r14.changedInstance(r6)
            if (r3 == 0) goto L46
            r3 = 32
            goto L48
        L46:
            r3 = 16
        L48:
            r2 = r2 | r3
        L49:
            r3 = r22 & 4
            if (r3 == 0) goto L50
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L63
        L50:
            r5 = r4 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L63
            r5 = r19
            boolean r7 = r14.changed(r5)
            if (r7 == 0) goto L5f
            r7 = 256(0x100, float:3.59E-43)
            goto L61
        L5f:
            r7 = 128(0x80, float:1.794E-43)
        L61:
            r2 = r2 | r7
            goto L65
        L63:
            r5 = r19
        L65:
            r7 = r2 & 147(0x93, float:2.06E-43)
            r8 = 146(0x92, float:2.05E-43)
            if (r7 != r8) goto L77
            boolean r7 = r14.getSkipping()
            if (r7 != 0) goto L72
            goto L77
        L72:
            r14.skipToGroupEnd()
            r3 = r5
            goto La4
        L77:
            if (r3 == 0) goto L7f
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.INSTANCE
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r7 = r3
            goto L80
        L7f:
            r7 = r5
        L80:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L8c
            r3 = -1
            java.lang.String r5 = "androidx.navigation.compose.NavHost (NavHost.kt:393)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r5)
        L8c:
            r15 = r2 & 1022(0x3fe, float:1.432E-42)
            r16 = 504(0x1f8, float:7.06E-43)
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r5 = r1
            NavHost(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto La3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        La3:
            r3 = r7
        La4:
            androidx.compose.runtime.ScopeUpdateScope r6 = r14.endRestartGroup()
            if (r6 == 0) goto Lb8
            androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda17 r0 = new androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda17
            r1 = r17
            r2 = r18
            r5 = r22
            r0.<init>()
            r6.updateScope(r0)
        Lb8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, androidx.navigation.NavGraph, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00f1  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports sizeTransform")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void NavHost(final androidx.navigation.NavHostController r23, final androidx.navigation.NavGraph r24, androidx.compose.ui.Modifier r25, androidx.compose.ui.Alignment r26, kotlin.jvm.functions.Function1 r27, kotlin.jvm.functions.Function1 r28, kotlin.jvm.functions.Function1 r29, kotlin.jvm.functions.Function1 r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, androidx.navigation.NavGraph, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x04a2, code lost:
    
        if (r5 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L243;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x070a  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0223  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void NavHost(final androidx.navigation.NavHostController r32, final androidx.navigation.NavGraph r33, androidx.compose.ui.Modifier r34, androidx.compose.ui.Alignment r35, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r36, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r37, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r38, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r39, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.SizeTransform> r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 1814
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, androidx.navigation.NavGraph, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NavHost$lambda$40(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean NavHost$lambda$43(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NavHost$lambda$44(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final DisposableEffectResult NavHost$lambda$48$lambda$47(NavHostController navHostController, LifecycleOwner lifecycleOwner, DisposableEffectScope disposableEffectScope) {
        navHostController.setLifecycleOwner(lifecycleOwner);
        return new DisposableEffectResult() { // from class: androidx.navigation.compose.NavHostKt$NavHost$lambda$48$lambda$47$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List NavHost$lambda$52$lambda$51(State state) {
        List<NavBackStackEntry> NavHost$lambda$49 = NavHost$lambda$49(state);
        ArrayList arrayList = new ArrayList();
        for (Object obj : NavHost$lambda$49) {
            if (Intrinsics.areEqual(((NavBackStackEntry) obj).getDestination().getNavigatorName(), ComposeNavigator.NAME)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final EnterTransition NavHost$lambda$58$lambda$57(ComposeNavigator composeNavigator, Function1 function1, Function1 function12, MutableState mutableState, AnimatedContentTransitionScope animatedContentTransitionScope) {
        NavDestination destination = ((NavBackStackEntry) animatedContentTransitionScope.getTargetState()).getDestination();
        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
        ComposeNavigator.Destination destination2 = (ComposeNavigator.Destination) destination;
        EnterTransition enterTransition = null;
        if (composeNavigator.isPop$navigation_compose_release().getValue().booleanValue() || NavHost$lambda$43(mutableState)) {
            Iterator<NavDestination> it = NavDestination.INSTANCE.getHierarchy(destination2).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                EnterTransition createPopEnterTransition = createPopEnterTransition(it.next(), animatedContentTransitionScope);
                if (createPopEnterTransition != null) {
                    enterTransition = createPopEnterTransition;
                    break;
                }
            }
            return enterTransition == null ? (EnterTransition) function1.invoke(animatedContentTransitionScope) : enterTransition;
        }
        Iterator<NavDestination> it2 = NavDestination.INSTANCE.getHierarchy(destination2).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            EnterTransition createEnterTransition = createEnterTransition(it2.next(), animatedContentTransitionScope);
            if (createEnterTransition != null) {
                enterTransition = createEnterTransition;
                break;
            }
        }
        return enterTransition == null ? (EnterTransition) function12.invoke(animatedContentTransitionScope) : enterTransition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ExitTransition NavHost$lambda$62$lambda$61(ComposeNavigator composeNavigator, Function1 function1, Function1 function12, MutableState mutableState, AnimatedContentTransitionScope animatedContentTransitionScope) {
        NavDestination destination = ((NavBackStackEntry) animatedContentTransitionScope.getInitialState()).getDestination();
        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
        ComposeNavigator.Destination destination2 = (ComposeNavigator.Destination) destination;
        ExitTransition exitTransition = null;
        if (composeNavigator.isPop$navigation_compose_release().getValue().booleanValue() || NavHost$lambda$43(mutableState)) {
            Iterator<NavDestination> it = NavDestination.INSTANCE.getHierarchy(destination2).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ExitTransition createPopExitTransition = createPopExitTransition(it.next(), animatedContentTransitionScope);
                if (createPopExitTransition != null) {
                    exitTransition = createPopExitTransition;
                    break;
                }
            }
            return exitTransition == null ? (ExitTransition) function1.invoke(animatedContentTransitionScope) : exitTransition;
        }
        Iterator<NavDestination> it2 = NavDestination.INSTANCE.getHierarchy(destination2).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            ExitTransition createExitTransition = createExitTransition(it2.next(), animatedContentTransitionScope);
            if (createExitTransition != null) {
                exitTransition = createExitTransition;
                break;
            }
        }
        return exitTransition == null ? (ExitTransition) function12.invoke(animatedContentTransitionScope) : exitTransition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final SizeTransform NavHost$lambda$65$lambda$64(Function1 function1, AnimatedContentTransitionScope animatedContentTransitionScope) {
        SizeTransform sizeTransform;
        NavDestination destination = ((NavBackStackEntry) animatedContentTransitionScope.getTargetState()).getDestination();
        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
        Iterator<NavDestination> it = NavDestination.INSTANCE.getHierarchy((ComposeNavigator.Destination) destination).iterator();
        while (true) {
            if (!it.hasNext()) {
                sizeTransform = null;
                break;
            }
            sizeTransform = createSizeTransform(it.next(), animatedContentTransitionScope);
            if (sizeTransform != null) {
                break;
            }
        }
        if (sizeTransform != null) {
            return sizeTransform;
        }
        if (function1 != null) {
            return (SizeTransform) function1.invoke(animatedContentTransitionScope);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ContentTransform NavHost$lambda$75$lambda$74(MutableObjectFloatMap mutableObjectFloatMap, ComposeNavigator composeNavigator, Function1 function1, Function1 function12, Function1 function13, State state, MutableState mutableState, AnimatedContentTransitionScope animatedContentTransitionScope) {
        float f;
        if (NavHost$lambda$53(state).contains(animatedContentTransitionScope.getInitialState())) {
            String id = ((NavBackStackEntry) animatedContentTransitionScope.getInitialState()).getId();
            int findKeyIndex = mutableObjectFloatMap.findKeyIndex(id);
            if (findKeyIndex >= 0) {
                f = mutableObjectFloatMap.values[findKeyIndex];
            } else {
                mutableObjectFloatMap.set(id, 0.0f);
                f = 0.0f;
            }
            if (!Intrinsics.areEqual(((NavBackStackEntry) animatedContentTransitionScope.getTargetState()).getId(), ((NavBackStackEntry) animatedContentTransitionScope.getInitialState()).getId())) {
                f = (composeNavigator.isPop$navigation_compose_release().getValue().booleanValue() || NavHost$lambda$43(mutableState)) ? f - 1.0f : f + 1.0f;
            }
            mutableObjectFloatMap.set(((NavBackStackEntry) animatedContentTransitionScope.getTargetState()).getId(), f);
            return new ContentTransform((EnterTransition) function1.invoke(animatedContentTransitionScope), (ExitTransition) function12.invoke(animatedContentTransitionScope), f, (SizeTransform) function13.invoke(animatedContentTransitionScope));
        }
        return AnimatedContentKt.togetherWith(EnterTransition.INSTANCE.getNone(), ExitTransition.INSTANCE.getNone());
    }

    private static final EnterTransition createEnterTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getEnterTransition$navigation_compose_release();
            if (enterTransition$navigation_compose_release2 != null) {
                return enterTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (enterTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getEnterTransition$navigation_compose_release()) == null) {
            return null;
        }
        return enterTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    private static final ExitTransition createExitTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getExitTransition$navigation_compose_release();
            if (exitTransition$navigation_compose_release2 != null) {
                return exitTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (exitTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getExitTransition$navigation_compose_release()) == null) {
            return null;
        }
        return exitTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    private static final EnterTransition createPopEnterTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getPopEnterTransition$navigation_compose_release();
            if (popEnterTransition$navigation_compose_release2 != null) {
                return popEnterTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (popEnterTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getPopEnterTransition$navigation_compose_release()) == null) {
            return null;
        }
        return popEnterTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    private static final ExitTransition createPopExitTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getPopExitTransition$navigation_compose_release();
            if (popExitTransition$navigation_compose_release2 != null) {
                return popExitTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (popExitTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getPopExitTransition$navigation_compose_release()) == null) {
            return null;
        }
        return popExitTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    private static final SizeTransform createSizeTransform(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> sizeTransform$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> sizeTransform$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getSizeTransform$navigation_compose_release();
            if (sizeTransform$navigation_compose_release2 != null) {
                return sizeTransform$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (sizeTransform$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getSizeTransform$navigation_compose_release()) == null) {
            return null;
        }
        return sizeTransform$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$38(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    private static final List<NavBackStackEntry> NavHost$lambda$49(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$53(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final DisposableEffectResult NavHost$lambda$69$lambda$68(final State state, final ComposeNavigator composeNavigator, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.navigation.compose.NavHostKt$NavHost$lambda$69$lambda$68$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                List NavHost$lambda$53;
                NavHost$lambda$53 = NavHostKt.NavHost$lambda$53(State.this);
                Iterator it = NavHost$lambda$53.iterator();
                while (it.hasNext()) {
                    composeNavigator.onTransitionComplete((NavBackStackEntry) it.next());
                }
            }
        };
    }
}
