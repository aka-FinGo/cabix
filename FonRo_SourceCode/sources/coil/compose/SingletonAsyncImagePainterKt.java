package coil.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.compose.AsyncImagePainter;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SingletonAsyncImagePainter.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a£\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0099\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001ae\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\t2\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a[\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\t2\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"rememberAsyncImagePainter", "Lcoil/compose/AsyncImagePainter;", "model", "", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State$Loading;", "", "onSuccess", "Lcoil/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil/compose/AsyncImagePainter$State$Error;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "modelEqualityDelegate", "Lcoil/compose/EqualityDelegate;", "rememberAsyncImagePainter-HtA5bXE", "(Ljava/lang/Object;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILcoil/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "rememberAsyncImagePainter-MqR-F_0", "(Ljava/lang/Object;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "transform", "Lcoil/compose/AsyncImagePainter$State;", "onState", "rememberAsyncImagePainter-EHKIwbg", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILcoil/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "rememberAsyncImagePainter-19ie5dc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "coil-compose-singleton_release"}, k = 2, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class SingletonAsyncImagePainterKt {
    /* renamed from: rememberAsyncImagePainter-HtA5bXE, reason: not valid java name */
    public static final AsyncImagePainter m7644rememberAsyncImagePainterHtA5bXE(Object obj, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, ContentScale contentScale, int i, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(1445305568);
        Painter painter4 = (i3 & 2) != 0 ? null : painter;
        Painter painter5 = (i3 & 4) != 0 ? null : painter2;
        int i4 = i2 << 3;
        AsyncImagePainter m7617rememberAsyncImagePainter10Xjiaw = AsyncImagePainterKt.m7617rememberAsyncImagePainter10Xjiaw(obj, ImageLoaderProvidableCompositionLocal.getCurrent(LocalImageLoaderKt.getLocalImageLoader(), composer, 6), painter4, painter5, (i3 & 8) != 0 ? painter5 : painter3, (i3 & 16) != 0 ? null : function1, (i3 & 32) != 0 ? null : function12, (i3 & 64) != 0 ? null : function13, (i3 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale, (i3 & 256) != 0 ? DrawScope.INSTANCE.m4938getDefaultFilterQualityfv9h1I() : i, (i3 & 512) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate, composer, (458752 & i4) | 37448 | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), (i2 >> 27) & 14, 0);
        composer.endReplaceableGroup();
        return m7617rememberAsyncImagePainter10Xjiaw;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /* renamed from: rememberAsyncImagePainter-MqR-F_0, reason: not valid java name */
    public static final /* synthetic */ AsyncImagePainter m7645rememberAsyncImagePainterMqRF_0(Object obj, Painter painter, Painter painter2, Painter painter3, Function1 function1, Function1 function12, Function1 function13, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(533921043);
        Painter painter4 = (i3 & 2) != 0 ? null : painter;
        Painter painter5 = (i3 & 4) != 0 ? null : painter2;
        int i4 = i2 << 3;
        AsyncImagePainter m7617rememberAsyncImagePainter10Xjiaw = AsyncImagePainterKt.m7617rememberAsyncImagePainter10Xjiaw(obj, ImageLoaderProvidableCompositionLocal.getCurrent(LocalImageLoaderKt.getLocalImageLoader(), composer, 6), painter4, painter5, (i3 & 8) != 0 ? painter5 : painter3, (i3 & 16) != 0 ? null : function1, (i3 & 32) != 0 ? null : function12, (i3 & 64) != 0 ? null : function13, (i3 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale, (i3 & 256) != 0 ? DrawScope.INSTANCE.m4938getDefaultFilterQualityfv9h1I() : i, null, composer, (458752 & i4) | 37448 | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), 0, 1024);
        composer.endReplaceableGroup();
        return m7617rememberAsyncImagePainter10Xjiaw;
    }

    /* renamed from: rememberAsyncImagePainter-EHKIwbg, reason: not valid java name */
    public static final AsyncImagePainter m7643rememberAsyncImagePainterEHKIwbg(Object obj, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, ContentScale contentScale, int i, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(236159766);
        if ((i3 & 2) != 0) {
            function1 = AsyncImagePainter.INSTANCE.getDefaultTransform();
        }
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function13 = function1;
        if ((i3 & 4) != 0) {
            function12 = null;
        }
        Function1<? super AsyncImagePainter.State, Unit> function14 = function12;
        if ((i3 & 8) != 0) {
            contentScale = ContentScale.INSTANCE.getFit();
        }
        ContentScale contentScale2 = contentScale;
        if ((i3 & 16) != 0) {
            i = DrawScope.INSTANCE.m4938getDefaultFilterQualityfv9h1I();
        }
        int i4 = i;
        if ((i3 & 32) != 0) {
            equalityDelegate = EqualityDelegateKt.getDefaultModelEqualityDelegate();
        }
        int i5 = i2 << 3;
        AsyncImagePainter m7616rememberAsyncImagePainter0YpotYA = AsyncImagePainterKt.m7616rememberAsyncImagePainter0YpotYA(obj, ImageLoaderProvidableCompositionLocal.getCurrent(LocalImageLoaderKt.getLocalImageLoader(), composer, 6), function13, function14, contentScale2, i4, equalityDelegate, composer, (i5 & 896) | 72 | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (i5 & 3670016), 0);
        composer.endReplaceableGroup();
        return m7616rememberAsyncImagePainter0YpotYA;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /* renamed from: rememberAsyncImagePainter-19ie5dc, reason: not valid java name */
    public static final /* synthetic */ AsyncImagePainter m7642rememberAsyncImagePainter19ie5dc(Object obj, Function1 function1, Function1 function12, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(-1494234083);
        if ((i3 & 2) != 0) {
            function1 = AsyncImagePainter.INSTANCE.getDefaultTransform();
        }
        Function1 function13 = function1;
        if ((i3 & 4) != 0) {
            function12 = null;
        }
        Function1 function14 = function12;
        if ((i3 & 8) != 0) {
            contentScale = ContentScale.INSTANCE.getFit();
        }
        ContentScale contentScale2 = contentScale;
        if ((i3 & 16) != 0) {
            i = DrawScope.INSTANCE.m4938getDefaultFilterQualityfv9h1I();
        }
        int i4 = i2 << 3;
        AsyncImagePainter m7616rememberAsyncImagePainter0YpotYA = AsyncImagePainterKt.m7616rememberAsyncImagePainter0YpotYA(obj, ImageLoaderProvidableCompositionLocal.getCurrent(LocalImageLoaderKt.getLocalImageLoader(), composer, 6), function13, function14, contentScale2, i, null, composer, (i4 & 896) | 72 | (i4 & 7168) | (57344 & i4) | (i4 & 458752), 64);
        composer.endReplaceableGroup();
        return m7616rememberAsyncImagePainter0YpotYA;
    }
}
