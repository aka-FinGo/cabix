package coil.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* compiled from: SubcomposeAsyncImage.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aÓ\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2&\b\u0002\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122&\b\u0002\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122&\b\u0002\u0010\u0015\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'H\u0007¢\u0006\u0004\b(\u0010)\u001a©\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2&\b\u0002\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122&\b\u0002\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122&\b\u0002\u0010\u0015\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b*\u0010+\u001aÉ\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\u001c\u0010-\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0004\b.\u0010/\u001aµ\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\u001c\u0010-\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0004\b0\u00101\u001a¥\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u00102\u001a\u0002032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u001c\u0010-\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0003¢\u0006\u0004\b4\u00105\u001ae\u00106\u001a\u00020\u0001*\u00020\u000f2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0002\u00109\u001a[\u00106\u001a\u00020\u0001*\u00020\u000f2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007¢\u0006\u0002\u0010:\u001a\u0095\u0001\u0010;\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\u0015\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0003¢\u0006\u0002\u0010<¨\u0006="}, d2 = {"SubcomposeAsyncImage", "", "model", "", "contentDescription", "", "imageLoader", "Lcoil/ImageLoader;", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "loading", "Lkotlin/Function2;", "Lcoil/compose/SubcomposeAsyncImageScope;", "Lcoil/compose/AsyncImagePainter$State$Loading;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/runtime/Composable;", FirebaseAnalytics.Param.SUCCESS, "Lcoil/compose/AsyncImagePainter$State$Success;", "error", "Lcoil/compose/AsyncImagePainter$State$Error;", "onLoading", "onSuccess", "onError", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "clipToBounds", "", "modelEqualityDelegate", "Lcoil/compose/EqualityDelegate;", "SubcomposeAsyncImage-TCQMD7g", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLcoil/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;III)V", "SubcomposeAsyncImage-Q4Kwu38", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V", "onState", FirebaseAnalytics.Param.CONTENT, "SubcomposeAsyncImage-FSyRiR8", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLcoil/compose/EqualityDelegate;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SubcomposeAsyncImage-sKDTAoQ", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "state", "Lcoil/compose/AsyncImageState;", "SubcomposeAsyncImage-gl8XCv8", "(Lcoil/compose/AsyncImageState;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SubcomposeAsyncImageContent", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lcoil/compose/SubcomposeAsyncImageScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLandroidx/compose/runtime/Composer;II)V", "(Lcoil/compose/SubcomposeAsyncImageScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "contentOf", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;)Lkotlin/jvm/functions/Function3;", "coil-compose-base_release"}, k = 2, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class SubcomposeAsyncImageKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SubcomposeAsyncImageContent$lambda$3(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, int i, int i2, Composer composer, int i3) {
        SubcomposeAsyncImageContent(subcomposeAsyncImageScope, modifier, painter, str, alignment, contentScale, f, colorFilter, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SubcomposeAsyncImageContent$lambda$4(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, int i2, Composer composer, int i3) {
        SubcomposeAsyncImageContent(subcomposeAsyncImageScope, modifier, painter, str, alignment, contentScale, f, colorFilter, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SubcomposeAsyncImage_gl8XCv8$lambda$1(AsyncImageState asyncImageState, String str, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Function3 function3, int i2, int i3, int i4, Composer composer, int i5) {
        m7653SubcomposeAsyncImagegl8XCv8(asyncImageState, str, modifier, function1, function12, alignment, contentScale, f, colorFilter, i, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* renamed from: SubcomposeAsyncImage-TCQMD7g, reason: not valid java name */
    public static final void m7652SubcomposeAsyncImageTCQMD7g(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43, Function1<? super AsyncImagePainter.State.Loading, Unit> function12, Function1<? super AsyncImagePainter.State.Success, Unit> function13, Function1<? super AsyncImagePainter.State.Error, Unit> function14, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(-1545157471);
        Modifier.Companion companion = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function44 = (i4 & 32) != 0 ? null : function4;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function45 = (i4 & 64) != 0 ? null : function42;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function46 = (i4 & 128) != 0 ? null : function43;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function15 = (i4 & 256) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Success, Unit> function16 = (i4 & 512) != 0 ? null : function13;
        Function1<? super AsyncImagePainter.State.Error, Unit> function17 = (i4 & 1024) != 0 ? null : function14;
        Alignment center = (i4 & 2048) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i4 & 4096) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i4 & 8192) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 16384) == 0 ? colorFilter : null;
        int m4938getDefaultFilterQualityfv9h1I = (32768 & i4) != 0 ? DrawScope.INSTANCE.m4938getDefaultFilterQualityfv9h1I() : i;
        boolean z2 = (65536 & i4) != 0 ? true : z;
        Modifier modifier2 = companion;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function18 = defaultTransform;
        AsyncImageState asyncImageState = new AsyncImageState(obj, (i4 & 131072) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate, imageLoader);
        Function1<AsyncImagePainter.State, Unit> onStateOf = UtilsKt.onStateOf(function15, function16, function17);
        Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> contentOf = contentOf(function44, function45, function46);
        int i5 = i2 >> 3;
        int i6 = (i2 & 112) | (i5 & 896) | (i5 & 7168);
        int i7 = i3 << 12;
        m7653SubcomposeAsyncImagegl8XCv8(asyncImageState, str, modifier2, function18, onStateOf, center, fit, f2, colorFilter2, m4938getDefaultFilterQualityfv9h1I, z2, contentOf, composer, i6 | (458752 & i7) | (3670016 & i7) | (29360128 & i7) | (234881024 & i7) | (i7 & 1879048192), (i3 >> 18) & 14, 0);
        composer.endReplaceableGroup();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /* renamed from: SubcomposeAsyncImage-Q4Kwu38, reason: not valid java name */
    public static final /* synthetic */ void m7651SubcomposeAsyncImageQ4Kwu38(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function4 function4, Function4 function42, Function4 function43, Function1 function1, Function1 function12, Function1 function13, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(-976228417);
        Modifier modifier2 = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        Function4 function44 = (i4 & 16) != 0 ? null : function4;
        Function4 function45 = (i4 & 32) != 0 ? null : function42;
        Function4 function46 = (i4 & 64) != 0 ? null : function43;
        Function1 function14 = (i4 & 128) != 0 ? null : function1;
        Function1 function15 = (i4 & 256) != 0 ? null : function12;
        Function1 function16 = (i4 & 512) != 0 ? null : function13;
        Alignment center = (i4 & 1024) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i4 & 2048) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i4 & 4096) != 0 ? 1.0f : f;
        int i5 = i3 << 15;
        m7653SubcomposeAsyncImagegl8XCv8(new AsyncImageState(obj, EqualityDelegateKt.getDefaultModelEqualityDelegate(), imageLoader), str, modifier2, AsyncImagePainter.INSTANCE.getDefaultTransform(), UtilsKt.onStateOf(function14, function15, function16), center, fit, f2, (i4 & 8192) == 0 ? colorFilter : null, (i4 & 16384) != 0 ? DrawScope.INSTANCE.m4938getDefaultFilterQualityfv9h1I() : i, true, contentOf(function44, function45, function46), composer, (i2 & 112) | 3072 | ((i2 >> 3) & 896) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (234881024 & i5) | (i5 & 1879048192), 6, 0);
        composer.endReplaceableGroup();
    }

    /* renamed from: SubcomposeAsyncImage-FSyRiR8, reason: not valid java name */
    public static final void m7650SubcomposeAsyncImageFSyRiR8(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, EqualityDelegate equalityDelegate, Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(-105413282);
        int i5 = i2 >> 3;
        m7653SubcomposeAsyncImagegl8XCv8(new AsyncImageState(obj, (i4 & 4096) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate, imageLoader), str, (i4 & 8) != 0 ? Modifier.INSTANCE : modifier, (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1, (i4 & 32) != 0 ? null : function12, (i4 & 64) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i4 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale, (i4 & 256) != 0 ? 1.0f : f, (i4 & 512) != 0 ? null : colorFilter, (i4 & 1024) != 0 ? DrawScope.INSTANCE.m4938getDefaultFilterQualityfv9h1I() : i, (i4 & 2048) != 0 ? true : z, function3, composer, (i2 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (i5 & 234881024) | ((i3 << 27) & 1879048192), ((i3 >> 3) & 14) | ((i3 >> 6) & 112), 0);
        composer.endReplaceableGroup();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /* renamed from: SubcomposeAsyncImage-sKDTAoQ, reason: not valid java name */
    public static final /* synthetic */ void m7654SubcomposeAsyncImagesKDTAoQ(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Function3 function3, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(1166576943);
        int i5 = i2 >> 3;
        m7653SubcomposeAsyncImagegl8XCv8(new AsyncImageState(obj, EqualityDelegateKt.getDefaultModelEqualityDelegate(), imageLoader), str, (i4 & 8) != 0 ? Modifier.INSTANCE : modifier, (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1, (i4 & 32) != 0 ? null : function12, (i4 & 64) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i4 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale, (i4 & 256) != 0 ? 1.0f : f, (i4 & 512) != 0 ? null : colorFilter, (i4 & 1024) != 0 ? DrawScope.INSTANCE.m4938getDefaultFilterQualityfv9h1I() : i, true, function3, composer, (i2 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (i5 & 234881024) | ((i3 << 27) & 1879048192), (i3 & 112) | 6, 0);
        composer.endReplaceableGroup();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011e  */
    /* renamed from: SubcomposeAsyncImage-gl8XCv8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m7653SubcomposeAsyncImagegl8XCv8(coil.compose.AsyncImageState r24, final java.lang.String r25, androidx.compose.ui.Modifier r26, final kotlin.jvm.functions.Function1<? super coil.compose.AsyncImagePainter.State, ? extends coil.compose.AsyncImagePainter.State> r27, final kotlin.jvm.functions.Function1<? super coil.compose.AsyncImagePainter.State, kotlin.Unit> r28, final androidx.compose.ui.Alignment r29, final androidx.compose.ui.layout.ContentScale r30, final float r31, final androidx.compose.ui.graphics.ColorFilter r32, final int r33, final boolean r34, final kotlin.jvm.functions.Function3<? super coil.compose.SubcomposeAsyncImageScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, final int r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 809
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.compose.SubcomposeAsyncImageKt.m7653SubcomposeAsyncImagegl8XCv8(coil.compose.AsyncImageState, java.lang.String, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, androidx.compose.ui.layout.ContentScale, float, androidx.compose.ui.graphics.ColorFilter, int, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SubcomposeAsyncImageContent(final coil.compose.SubcomposeAsyncImageScope r17, androidx.compose.ui.Modifier r18, androidx.compose.ui.graphics.painter.Painter r19, java.lang.String r20, androidx.compose.ui.Alignment r21, androidx.compose.ui.layout.ContentScale r22, float r23, androidx.compose.ui.graphics.ColorFilter r24, boolean r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 589
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.compose.SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(coil.compose.SubcomposeAsyncImageScope, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.painter.Painter, java.lang.String, androidx.compose.ui.Alignment, androidx.compose.ui.layout.ContentScale, float, androidx.compose.ui.graphics.ColorFilter, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0180  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void SubcomposeAsyncImageContent(final coil.compose.SubcomposeAsyncImageScope r22, androidx.compose.ui.Modifier r23, androidx.compose.ui.graphics.painter.Painter r24, java.lang.String r25, androidx.compose.ui.Alignment r26, androidx.compose.ui.layout.ContentScale r27, float r28, androidx.compose.ui.graphics.ColorFilter r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.compose.SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(coil.compose.SubcomposeAsyncImageScope, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.painter.Painter, java.lang.String, androidx.compose.ui.Alignment, androidx.compose.ui.layout.ContentScale, float, androidx.compose.ui.graphics.ColorFilter, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> contentOf(final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43) {
        return (function4 == null && function42 == null && function43 == null) ? ComposableSingletons$SubcomposeAsyncImageKt.INSTANCE.m7623getLambda1$coil_compose_base_release() : ComposableLambdaKt.composableLambdaInstance(750771424, true, new Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$contentOf$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, Integer num) {
                invoke(subcomposeAsyncImageScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:22:0x009e  */
            /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke(coil.compose.SubcomposeAsyncImageScope r13, androidx.compose.runtime.Composer r14, int r15) {
                /*
                    r12 = this;
                    r2 = r15 & 14
                    if (r2 != 0) goto Lf
                    boolean r2 = r14.changed(r13)
                    if (r2 == 0) goto Lc
                    r2 = 4
                    goto Ld
                Lc:
                    r2 = 2
                Ld:
                    r2 = r2 | r15
                    goto L10
                Lf:
                    r2 = r15
                L10:
                    r3 = r2 & 91
                    r4 = 18
                    if (r3 != r4) goto L21
                    boolean r3 = r14.getSkipping()
                    if (r3 != 0) goto L1d
                    goto L21
                L1d:
                    r14.skipToGroupEnd()
                    return
                L21:
                    coil.compose.AsyncImagePainter r3 = r13.getPainter()
                    coil.compose.AsyncImagePainter$State r3 = r3.getState()
                    boolean r4 = r3 instanceof coil.compose.AsyncImagePainter.State.Loading
                    r5 = 0
                    r6 = 1
                    if (r4 == 0) goto L4d
                    r4 = 1739512213(0x67aed995, float:1.6514109E24)
                    r14.startReplaceableGroup(r4)
                    kotlin.jvm.functions.Function4<coil.compose.SubcomposeAsyncImageScope, coil.compose.AsyncImagePainter$State$Loading, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r0 = r1
                    if (r0 == 0) goto L47
                    r4 = r2 & 14
                    r4 = r4 | 64
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                    r0.invoke(r13, r3, r14, r4)
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    goto L48
                L47:
                    r5 = r6
                L48:
                    r14.endReplaceableGroup()
                L4b:
                    r6 = r5
                    goto L9c
                L4d:
                    boolean r4 = r3 instanceof coil.compose.AsyncImagePainter.State.Success
                    if (r4 == 0) goto L6e
                    r4 = 1739605461(0x67b045d5, float:1.6648493E24)
                    r14.startReplaceableGroup(r4)
                    kotlin.jvm.functions.Function4<coil.compose.SubcomposeAsyncImageScope, coil.compose.AsyncImagePainter$State$Success, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r0 = r2
                    if (r0 == 0) goto L69
                    r4 = r2 & 14
                    r4 = r4 | 64
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                    r0.invoke(r13, r3, r14, r4)
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    goto L6a
                L69:
                    r5 = r6
                L6a:
                    r14.endReplaceableGroup()
                    goto L4b
                L6e:
                    boolean r4 = r3 instanceof coil.compose.AsyncImagePainter.State.Error
                    if (r4 == 0) goto L8f
                    r4 = 1739696601(0x67b1a9d9, float:1.677984E24)
                    r14.startReplaceableGroup(r4)
                    kotlin.jvm.functions.Function4<coil.compose.SubcomposeAsyncImageScope, coil.compose.AsyncImagePainter$State$Error, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r0 = r3
                    if (r0 == 0) goto L8a
                    r4 = r2 & 14
                    r4 = r4 | 64
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                    r0.invoke(r13, r3, r14, r4)
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    goto L8b
                L8a:
                    r5 = r6
                L8b:
                    r14.endReplaceableGroup()
                    goto L4b
                L8f:
                    boolean r0 = r3 instanceof coil.compose.AsyncImagePainter.State.Empty
                    if (r0 == 0) goto Lb0
                    r0 = 1739782316(0x67b2f8ac, float:1.6903368E24)
                    r14.startReplaceableGroup(r0)
                    r14.endReplaceableGroup()
                L9c:
                    if (r6 == 0) goto Laf
                    r10 = r2 & 14
                    r11 = 255(0xff, float:3.57E-43)
                    r1 = 0
                    r2 = 0
                    r3 = 0
                    r4 = 0
                    r5 = 0
                    r6 = 0
                    r7 = 0
                    r8 = 0
                    r0 = r13
                    r9 = r14
                    coil.compose.SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                Laf:
                    return
                Lb0:
                    r0 = -82435959(0xfffffffffb162089, float:-7.795044E35)
                    r14.startReplaceableGroup(r0)
                    r14.endReplaceableGroup()
                    kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
                    r0.<init>()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: coil.compose.SubcomposeAsyncImageKt$contentOf$1.invoke(coil.compose.SubcomposeAsyncImageScope, androidx.compose.runtime.Composer, int):void");
            }
        });
    }
}
