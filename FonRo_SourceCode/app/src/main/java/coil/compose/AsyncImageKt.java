package coil.compose;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import coil.size.SizeResolver;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AsyncImage.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aé\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007¢\u0006\u0004\b#\u0010$\u001aÕ\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0004\b%\u0010&\u001a«\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(0\u000f2\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007¢\u0006\u0004\b*\u0010+\u001a\u0097\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(0\u000f2\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0004\b,\u0010-\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(0\u000f2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0003¢\u0006\u0004\b0\u00101\u001aQ\u00102\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u00103\u001a\u0002042\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0003¢\u0006\u0002\u00105¨\u00066"}, d2 = {"AsyncImage", "", "model", "", "contentDescription", "", "imageLoader", "Lcoil/ImageLoader;", "modifier", "Landroidx/compose/ui/Modifier;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil/compose/AsyncImagePainter$State$Error;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "clipToBounds", "", "modelEqualityDelegate", "Lcoil/compose/EqualityDelegate;", "AsyncImage-J-FEaFM", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLcoil/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;III)V", "AsyncImage-Q4Kwu38", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V", "transform", "Lcoil/compose/AsyncImagePainter$State;", "onState", "AsyncImage-QgsmV_s", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLcoil/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;III)V", "AsyncImage-MvsnxeU", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V", "state", "Lcoil/compose/AsyncImageState;", "AsyncImage-76YX9Dk", "(Lcoil/compose/AsyncImageState;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLandroidx/compose/runtime/Composer;II)V", "Content", "painter", "Lcoil/compose/AsyncImagePainter;", "(Landroidx/compose/ui/Modifier;Lcoil/compose/AsyncImagePainter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLandroidx/compose/runtime/Composer;I)V", "coil-compose-base_release"}, k = 2, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class AsyncImageKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AsyncImage_76YX9Dk$lambda$0(AsyncImageState asyncImageState, String str, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, int i2, int i3, Composer composer, int i4) {
        m7608AsyncImage76YX9Dk(asyncImageState, str, modifier, function1, function12, alignment, contentScale, f, colorFilter, i, z, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Content$lambda$2(Modifier modifier, AsyncImagePainter asyncImagePainter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, int i, Composer composer, int i2) {
        Content(modifier, asyncImagePainter, str, alignment, contentScale, f, colorFilter, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* renamed from: AsyncImage-J-FEaFM, reason: not valid java name */
    public static final void m7609AsyncImageJFEaFM(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(-1481548872);
        Modifier.Companion companion = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        Painter painter4 = (i4 & 16) != 0 ? null : painter;
        Painter painter5 = (i4 & 32) != 0 ? null : painter2;
        Painter painter6 = (i4 & 64) != 0 ? painter5 : painter3;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function14 = (i4 & 128) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function15 = (i4 & 256) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Error, Unit> function16 = (i4 & 512) != 0 ? null : function13;
        Alignment center = (i4 & 1024) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i4 & 2048) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i4 & 4096) != 0 ? 1.0f : f;
        int i5 = i3 << 15;
        m7608AsyncImage76YX9Dk(new AsyncImageState(obj, (i4 & 65536) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate, imageLoader), str, companion, UtilsKt.transformOf(painter4, painter5, painter6), UtilsKt.onStateOf(function14, function15, function16), center, fit, f2, (i4 & 8192) == 0 ? colorFilter : null, (i4 & 16384) != 0 ? DrawScope.INSTANCE.m4938getDefaultFilterQualityfv9h1I() : i, (32768 & i4) != 0 ? true : z, composer, (i2 & 112) | ((i2 >> 3) & 896) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (234881024 & i5) | (i5 & 1879048192), (i3 >> 15) & 14);
        composer.endReplaceableGroup();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /* renamed from: AsyncImage-Q4Kwu38, reason: not valid java name */
    public static final /* synthetic */ void m7611AsyncImageQ4Kwu38(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Painter painter, Painter painter2, Painter painter3, Function1 function1, Function1 function12, Function1 function13, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(-245964807);
        Modifier modifier2 = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        Painter painter4 = (i4 & 16) != 0 ? null : painter;
        Painter painter5 = (i4 & 32) != 0 ? null : painter2;
        Painter painter6 = (i4 & 64) != 0 ? painter5 : painter3;
        Function1 function14 = (i4 & 128) != 0 ? null : function1;
        Function1 function15 = (i4 & 256) != 0 ? null : function12;
        Function1 function16 = (i4 & 512) != 0 ? null : function13;
        int i5 = i3 << 15;
        m7608AsyncImage76YX9Dk(new AsyncImageState(obj, EqualityDelegateKt.getDefaultModelEqualityDelegate(), imageLoader), str, modifier2, UtilsKt.transformOf(painter4, painter5, painter6), UtilsKt.onStateOf(function14, function15, function16), (i4 & 1024) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i4 & 2048) != 0 ? ContentScale.INSTANCE.getFit() : contentScale, (i4 & 4096) != 0 ? 1.0f : f, (i4 & 8192) == 0 ? colorFilter : null, (i4 & 16384) != 0 ? DrawScope.INSTANCE.m4938getDefaultFilterQualityfv9h1I() : i, true, composer, (i2 & 112) | ((i2 >> 3) & 896) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (234881024 & i5) | (i5 & 1879048192), 6);
        composer.endReplaceableGroup();
    }

    /* renamed from: AsyncImage-QgsmV_s, reason: not valid java name */
    public static final void m7612AsyncImageQgsmV_s(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(2032051394);
        int i5 = i2 >> 3;
        m7608AsyncImage76YX9Dk(new AsyncImageState(obj, (i4 & 4096) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate, imageLoader), str, (i4 & 8) != 0 ? Modifier.INSTANCE : modifier, (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1, (i4 & 32) != 0 ? null : function12, (i4 & 64) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i4 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale, (i4 & 256) != 0 ? 1.0f : f, (i4 & 512) != 0 ? null : colorFilter, (i4 & 1024) != 0 ? DrawScope.INSTANCE.m4938getDefaultFilterQualityfv9h1I() : i, (i4 & 2048) != 0 ? true : z, composer, (i2 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (i5 & 234881024) | ((i3 << 27) & 1879048192), (i3 >> 3) & 14);
        composer.endReplaceableGroup();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /* renamed from: AsyncImage-MvsnxeU, reason: not valid java name */
    public static final /* synthetic */ void m7610AsyncImageMvsnxeU(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(-2030202961);
        int i5 = i2 >> 3;
        m7608AsyncImage76YX9Dk(new AsyncImageState(obj, EqualityDelegateKt.getDefaultModelEqualityDelegate(), imageLoader), str, (i4 & 8) != 0 ? Modifier.INSTANCE : modifier, (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1, (i4 & 32) != 0 ? null : function12, (i4 & 64) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i4 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale, (i4 & 256) != 0 ? 1.0f : f, (i4 & 512) != 0 ? null : colorFilter, (i4 & 1024) != 0 ? DrawScope.INSTANCE.m4938getDefaultFilterQualityfv9h1I() : i, true, composer, (i2 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (i5 & 234881024) | ((i3 << 27) & 1879048192), 6);
        composer.endReplaceableGroup();
    }

    /* renamed from: AsyncImage-76YX9Dk, reason: not valid java name */
    private static final void m7608AsyncImage76YX9Dk(AsyncImageState asyncImageState, final String str, final Modifier modifier, final Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, final Function1<? super AsyncImagePainter.State, Unit> function12, final Alignment alignment, final ContentScale contentScale, final float f, final ColorFilter colorFilter, final int i, final boolean z, Composer composer, final int i2, final int i3) {
        final AsyncImageState asyncImageState2;
        int i4;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function13;
        Function1<? super AsyncImagePainter.State, Unit> function14;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-421592773);
        if ((i2 & 14) == 0) {
            asyncImageState2 = asyncImageState;
            i4 = (startRestartGroup.changed(asyncImageState2) ? 4 : 2) | i2;
        } else {
            asyncImageState2 = asyncImageState;
            i4 = i2;
        }
        if ((i2 & 112) == 0) {
            i4 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            function13 = function1;
            i4 |= startRestartGroup.changedInstance(function13) ? 2048 : 1024;
        } else {
            function13 = function1;
        }
        if ((i2 & 57344) == 0) {
            function14 = function12;
            i4 |= startRestartGroup.changedInstance(function14) ? 16384 : 8192;
        } else {
            function14 = function12;
        }
        if ((i2 & 458752) == 0) {
            i4 |= startRestartGroup.changed(alignment) ? 131072 : 65536;
        }
        if ((i2 & 3670016) == 0) {
            i4 |= startRestartGroup.changed(contentScale) ? 1048576 : 524288;
        }
        if ((i2 & 29360128) == 0) {
            i4 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
        }
        if ((234881024 & i2) == 0) {
            i4 |= startRestartGroup.changed(colorFilter) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i2 & 1879048192) == 0) {
            i4 |= startRestartGroup.changed(i) ? 536870912 : 268435456;
        }
        int i6 = i4;
        if ((i3 & 14) == 0) {
            i5 = i3 | (startRestartGroup.changed(z) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i6 & 1533916891) != 306783378 || (i5 & 11) != 2 || !startRestartGroup.getSkipping()) {
            ImageRequest requestOfWithSizeResolver = UtilsKt.requestOfWithSizeResolver(asyncImageState2.getModel(), contentScale, startRestartGroup, ((i6 >> 15) & 112) | 8);
            int i7 = i6 >> 3;
            int i8 = i6 >> 6;
            int i9 = i8 & 57344;
            AsyncImagePainter m7616rememberAsyncImagePainter0YpotYA = AsyncImagePainterKt.m7616rememberAsyncImagePainter0YpotYA(requestOfWithSizeResolver, asyncImageState2.getImageLoader(), function13, function14, contentScale, i, asyncImageState2.getModelEqualityDelegate(), startRestartGroup, (i7 & 7168) | (i7 & 896) | 72 | i9 | ((i6 >> 12) & 458752), 0);
            SizeResolver sizeResolver = requestOfWithSizeResolver.getSizeResolver();
            Content(sizeResolver instanceof ConstraintsSizeResolver ? modifier.then((Modifier) sizeResolver) : modifier, m7616rememberAsyncImagePainter0YpotYA, str, alignment, contentScale, f, colorFilter, z, startRestartGroup, ((i6 << 3) & 896) | (i8 & 7168) | i9 | (i8 & 458752) | (i8 & 3670016) | ((i5 << 21) & 29360128));
            startRestartGroup = startRestartGroup;
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: coil.compose.AsyncImageKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AsyncImageKt.AsyncImage_76YX9Dk$lambda$0(AsyncImageState.this, str, modifier, function1, function12, alignment, contentScale, f, colorFilter, i, z, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void Content(final Modifier modifier, final AsyncImagePainter asyncImagePainter, final String str, final Alignment alignment, final ContentScale contentScale, final float f, final ColorFilter colorFilter, final boolean z, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(777774312);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(asyncImagePainter) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(alignment) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= startRestartGroup.changed(contentScale) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= startRestartGroup.changed(f) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= startRestartGroup.changed(colorFilter) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= startRestartGroup.changed(z) ? 8388608 : 4194304;
        }
        if ((i2 & 23967451) != 4793490 || !startRestartGroup.getSkipping()) {
            Modifier contentDescription = UtilsKt.contentDescription(modifier, str);
            if (z) {
                contentDescription = ClipKt.clipToBounds(contentDescription);
            }
            Modifier then = contentDescription.then(new ContentPainterElement(asyncImagePainter, alignment, contentScale, f, colorFilter));
            AsyncImageKt$Content$2 asyncImageKt$Content$2 = AsyncImageKt$Content$2.INSTANCE;
            startRestartGroup.startReplaceableGroup(544976794);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(1)123@4784L23,126@4935L385:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            final Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            startRestartGroup.startReplaceableGroup(1405779621);
            ComposerKt.sourceInformation(startRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(new Function0<ComposeUiNode>() { // from class: coil.compose.AsyncImageKt$Content$$inlined$Layout$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final ComposeUiNode invoke() {
                        return Function0.this.invoke();
                    }
                });
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl, asyncImageKt$Content$2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: coil.compose.AsyncImageKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AsyncImageKt.Content$lambda$2(Modifier.this, asyncImagePainter, str, alignment, contentScale, f, colorFilter, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
