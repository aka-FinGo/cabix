package coil.compose;

import android.graphics.drawable.Drawable;
import android.os.Trace;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import coil.size.Dimension;
import coil.size.Dimensions;
import coil.size.Size;
import coil.transition.TransitionTarget;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* compiled from: AsyncImagePainter.kt */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003*\u00015\u001a«\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a¡\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001am\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u000b2\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001f\u0010 \u001ac\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u000b2\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0004\b!\u0010\"\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u000b2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0004\b%\u0010&\u001a\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)H\u0002\u001a\u001a\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-H\u0002\u001a\u0015\u0010/\u001a\u0004\u0018\u000100*\u000201H\u0002¢\u0006\u0004\b2\u00103\"\u0010\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0004\n\u0002\u00106¨\u00067"}, d2 = {"rememberAsyncImagePainter", "Lcoil/compose/AsyncImagePainter;", "model", "", "imageLoader", "Lcoil/ImageLoader;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State$Loading;", "", "onSuccess", "Lcoil/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil/compose/AsyncImagePainter$State$Error;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "modelEqualityDelegate", "Lcoil/compose/EqualityDelegate;", "rememberAsyncImagePainter-10Xjiaw", "(Ljava/lang/Object;Lcoil/ImageLoader;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILcoil/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;III)Lcoil/compose/AsyncImagePainter;", "rememberAsyncImagePainter-3HmZ8SU", "(Ljava/lang/Object;Lcoil/ImageLoader;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "transform", "Lcoil/compose/AsyncImagePainter$State;", "onState", "rememberAsyncImagePainter-0YpotYA", "(Ljava/lang/Object;Lcoil/ImageLoader;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILcoil/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "rememberAsyncImagePainter-5jETZwI", "(Ljava/lang/Object;Lcoil/ImageLoader;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "state", "Lcoil/compose/AsyncImageState;", "rememberAsyncImagePainter-GSdzBsE", "(Lcoil/compose/AsyncImageState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;I)Lcoil/compose/AsyncImagePainter;", "validateRequest", "request", "Lcoil/request/ImageRequest;", "unsupportedData", "", "name", "", "description", "toSizeOrNull", "Lcoil/size/Size;", "Landroidx/compose/ui/geometry/Size;", "toSizeOrNull-uvyYCjk", "(J)Lcoil/size/Size;", "fakeTransitionTarget", "coil/compose/AsyncImagePainterKt$fakeTransitionTarget$1", "Lcoil/compose/AsyncImagePainterKt$fakeTransitionTarget$1;", "coil-compose-base_release"}, k = 2, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class AsyncImagePainterKt {
    private static final AsyncImagePainterKt$fakeTransitionTarget$1 fakeTransitionTarget = new TransitionTarget() { // from class: coil.compose.AsyncImagePainterKt$fakeTransitionTarget$1
        @Override // coil.transition.TransitionTarget
        public Drawable getDrawable() {
            return null;
        }

        @Override // coil.transition.TransitionTarget
        public /* bridge */ /* synthetic */ View getView() {
            return (View) m7622getView();
        }

        /* renamed from: getView, reason: collision with other method in class */
        public Void m7622getView() {
            throw new UnsupportedOperationException();
        }
    };

    /* renamed from: rememberAsyncImagePainter-10Xjiaw */
    public static final AsyncImagePainter m7617rememberAsyncImagePainter10Xjiaw(Object obj, ImageLoader imageLoader, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, ContentScale contentScale, int i, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(-79978785);
        if ((i4 & 4) != 0) {
            painter = null;
        }
        if ((i4 & 8) != 0) {
            painter2 = null;
        }
        if ((i4 & 16) != 0) {
            painter3 = painter2;
        }
        AsyncImagePainter m7620rememberAsyncImagePainterGSdzBsE = m7620rememberAsyncImagePainterGSdzBsE(new AsyncImageState(obj, (i4 & 1024) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate, imageLoader), UtilsKt.transformOf(painter, painter2, painter3), UtilsKt.onStateOf((i4 & 32) != 0 ? null : function1, (i4 & 64) != 0 ? null : function12, (i4 & 128) == 0 ? function13 : null), (i4 & 256) != 0 ? ContentScale.INSTANCE.getFit() : contentScale, (i4 & 512) != 0 ? DrawScope.INSTANCE.m4938getDefaultFilterQualityfv9h1I() : i, composer, (i2 >> 15) & 64512);
        composer.endReplaceableGroup();
        return m7620rememberAsyncImagePainterGSdzBsE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /* renamed from: rememberAsyncImagePainter-3HmZ8SU */
    public static final /* synthetic */ AsyncImagePainter m7618rememberAsyncImagePainter3HmZ8SU(Object obj, ImageLoader imageLoader, Painter painter, Painter painter2, Painter painter3, Function1 function1, Function1 function12, Function1 function13, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(2140758544);
        if ((i3 & 4) != 0) {
            painter = null;
        }
        if ((i3 & 8) != 0) {
            painter2 = null;
        }
        if ((i3 & 16) != 0) {
            painter3 = painter2;
        }
        AsyncImagePainter m7620rememberAsyncImagePainterGSdzBsE = m7620rememberAsyncImagePainterGSdzBsE(new AsyncImageState(obj, EqualityDelegateKt.getDefaultModelEqualityDelegate(), imageLoader), UtilsKt.transformOf(painter, painter2, painter3), UtilsKt.onStateOf((i3 & 32) != 0 ? null : function1, (i3 & 64) != 0 ? null : function12, (i3 & 128) == 0 ? function13 : null), (i3 & 256) != 0 ? ContentScale.INSTANCE.getFit() : contentScale, (i3 & 512) != 0 ? DrawScope.INSTANCE.m4938getDefaultFilterQualityfv9h1I() : i, composer, (i2 >> 15) & 64512);
        composer.endReplaceableGroup();
        return m7620rememberAsyncImagePainterGSdzBsE;
    }

    /* renamed from: rememberAsyncImagePainter-0YpotYA */
    public static final AsyncImagePainter m7616rememberAsyncImagePainter0YpotYA(Object obj, ImageLoader imageLoader, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, ContentScale contentScale, int i, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(1645646697);
        if ((i3 & 4) != 0) {
            function1 = AsyncImagePainter.INSTANCE.getDefaultTransform();
        }
        if ((i3 & 8) != 0) {
            function12 = null;
        }
        if ((i3 & 16) != 0) {
            contentScale = ContentScale.INSTANCE.getFit();
        }
        if ((i3 & 32) != 0) {
            i = DrawScope.INSTANCE.m4938getDefaultFilterQualityfv9h1I();
        }
        if ((i3 & 64) != 0) {
            equalityDelegate = EqualityDelegateKt.getDefaultModelEqualityDelegate();
        }
        int i4 = i;
        ContentScale contentScale2 = contentScale;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function13 = function1;
        AsyncImagePainter m7620rememberAsyncImagePainterGSdzBsE = m7620rememberAsyncImagePainterGSdzBsE(new AsyncImageState(obj, equalityDelegate, imageLoader), function13, function12, contentScale2, i4, composer, (i2 >> 3) & 65520);
        composer.endReplaceableGroup();
        return m7620rememberAsyncImagePainterGSdzBsE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /* renamed from: rememberAsyncImagePainter-5jETZwI */
    public static final /* synthetic */ AsyncImagePainter m7619rememberAsyncImagePainter5jETZwI(Object obj, ImageLoader imageLoader, Function1 function1, Function1 function12, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(-2020614074);
        if ((i3 & 4) != 0) {
            function1 = AsyncImagePainter.INSTANCE.getDefaultTransform();
        }
        Function1 function13 = function1;
        if ((i3 & 8) != 0) {
            function12 = null;
        }
        Function1 function14 = function12;
        if ((i3 & 16) != 0) {
            contentScale = ContentScale.INSTANCE.getFit();
        }
        ContentScale contentScale2 = contentScale;
        if ((i3 & 32) != 0) {
            i = DrawScope.INSTANCE.m4938getDefaultFilterQualityfv9h1I();
        }
        AsyncImagePainter m7620rememberAsyncImagePainterGSdzBsE = m7620rememberAsyncImagePainterGSdzBsE(new AsyncImageState(obj, EqualityDelegateKt.getDefaultModelEqualityDelegate(), imageLoader), function13, function14, contentScale2, i, composer, (i2 >> 3) & 65520);
        composer.endReplaceableGroup();
        return m7620rememberAsyncImagePainterGSdzBsE;
    }

    /* renamed from: rememberAsyncImagePainter-GSdzBsE */
    private static final AsyncImagePainter m7620rememberAsyncImagePainterGSdzBsE(AsyncImageState asyncImageState, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, ContentScale contentScale, int i, Composer composer, int i2) {
        composer.startReplaceableGroup(952940650);
        Trace.beginSection("rememberAsyncImagePainter");
        try {
            ImageRequest requestOf = UtilsKt.requestOf(asyncImageState.getModel(), composer, 8);
            validateRequest(requestOf);
            composer.startReplaceableGroup(1094691773);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new AsyncImagePainter(requestOf, asyncImageState.getImageLoader());
                composer.updateRememberedValue(rememberedValue);
            }
            AsyncImagePainter asyncImagePainter = (AsyncImagePainter) rememberedValue;
            composer.endReplaceableGroup();
            asyncImagePainter.setTransform$coil_compose_base_release(function1);
            asyncImagePainter.setOnState$coil_compose_base_release(function12);
            asyncImagePainter.setContentScale$coil_compose_base_release(contentScale);
            asyncImagePainter.m7614setFilterQualityvDHp3xo$coil_compose_base_release(i);
            ProvidableCompositionLocal<Boolean> localInspectionMode = InspectionModeKt.getLocalInspectionMode();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localInspectionMode);
            ComposerKt.sourceInformationMarkerEnd(composer);
            asyncImagePainter.setPreview$coil_compose_base_release(((Boolean) consume).booleanValue());
            asyncImagePainter.setImageLoader$coil_compose_base_release(asyncImageState.getImageLoader());
            asyncImagePainter.setRequest$coil_compose_base_release(requestOf);
            asyncImagePainter.onRemembered();
            composer.endReplaceableGroup();
            return asyncImagePainter;
        } finally {
            Trace.endSection();
        }
    }

    private static final void validateRequest(ImageRequest imageRequest) {
        Object data = imageRequest.getData();
        if (data instanceof ImageRequest.Builder) {
            unsupportedData("ImageRequest.Builder", "Did you forget to call ImageRequest.Builder.build()?");
            throw new KotlinNothingValueException();
        }
        if (data instanceof ImageBitmap) {
            unsupportedData$default("ImageBitmap", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (data instanceof ImageVector) {
            unsupportedData$default("ImageVector", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (data instanceof Painter) {
            unsupportedData$default("Painter", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (imageRequest.getTarget() != null) {
            throw new IllegalArgumentException("request.target must be null.".toString());
        }
    }

    static /* synthetic */ Void unsupportedData$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "If you wish to display this " + str + ", use androidx.compose.foundation.Image.";
        }
        return unsupportedData(str, str2);
    }

    private static final Void unsupportedData(String str, String str2) {
        throw new IllegalArgumentException("Unsupported type: " + str + ". " + str2);
    }

    /* renamed from: toSizeOrNull-uvyYCjk */
    public static final Size m7621toSizeOrNulluvyYCjk(long j) {
        if (j == androidx.compose.ui.geometry.Size.INSTANCE.m4202getUnspecifiedNHjbRc()) {
            return Size.ORIGINAL;
        }
        if (!UtilsKt.m7657isPositiveuvyYCjk(j)) {
            return null;
        }
        float m4194getWidthimpl = androidx.compose.ui.geometry.Size.m4194getWidthimpl(j);
        Dimension Dimension = (Float.isInfinite(m4194getWidthimpl) || Float.isNaN(m4194getWidthimpl)) ? Dimension.Undefined.INSTANCE : Dimensions.Dimension(MathKt.roundToInt(androidx.compose.ui.geometry.Size.m4194getWidthimpl(j)));
        float m4191getHeightimpl = androidx.compose.ui.geometry.Size.m4191getHeightimpl(j);
        return new Size(Dimension, (Float.isInfinite(m4191getHeightimpl) || Float.isNaN(m4191getHeightimpl)) ? Dimension.Undefined.INSTANCE : Dimensions.Dimension(MathKt.roundToInt(androidx.compose.ui.geometry.Size.m4191getHeightimpl(j))));
    }
}
