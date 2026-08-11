package coil.compose;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Trace;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import coil.size.Precision;
import coil.size.SizeResolver;
import coil.target.Target;
import coil.transition.CrossfadeTransition;
import coil.transition.Transition;
import com.google.accompanist.drawablepainter.DrawablePainter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: AsyncImagePainter.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 o2\u00020\u00012\u00020\u0002:\u0002noB\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\f\u0010[\u001a\u000203*\u00020\\H\u0014J\u0010\u0010]\u001a\u00020D2\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J\u0012\u0010^\u001a\u00020D2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010_\u001a\u000203H\u0016J\b\u0010`\u001a\u000203H\u0016J\b\u0010a\u001a\u000203H\u0016J\b\u0010b\u001a\u000203H\u0002J\u0010\u0010c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010d\u001a\u0002032\u0006\u0010e\u001a\u00020&H\u0002J\u001a\u0010f\u001a\u0004\u0018\u00010g2\u0006\u0010h\u001a\u00020&2\u0006\u0010i\u001a\u00020&H\u0002J\f\u0010j\u001a\u00020&*\u00020kH\u0002J\f\u0010l\u001a\u00020\u0001*\u00020mH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u00168B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR/\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001e8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0015\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020&@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b(\u0010)R\"\u0010*\u001a\u0004\u0018\u00010\u00012\b\u0010%\u001a\u0004\u0018\u00010\u0001@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b+\u0010\u0013R&\u0010,\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0-X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00102\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u000203\u0018\u00010-X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u001a\u00106\u001a\u000207X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u00020=X\u0080\u000e¢\u0006\u0010\n\u0002\u0010B\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010C\u001a\u00020DX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR+\u0010I\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020&8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bM\u0010\u0015\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010)R+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00048F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bR\u0010\u0015\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR+\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00068F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bW\u0010\u0015\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010Z¨\u0006p"}, d2 = {"Lcoil/compose/AsyncImagePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "request", "Lcoil/request/ImageRequest;", "imageLoader", "Lcoil/ImageLoader;", "<init>", "(Lcoil/request/ImageRequest;Lcoil/ImageLoader;)V", "rememberScope", "Lkotlinx/coroutines/CoroutineScope;", "drawSize", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/ui/geometry/Size;", "<set-?>", "painter", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "painter$delegate", "Landroidx/compose/runtime/MutableState;", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "alpha$delegate", "Landroidx/compose/runtime/MutableFloatState;", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter$delegate", "value", "Lcoil/compose/AsyncImagePainter$State;", "_state", "set_state", "(Lcoil/compose/AsyncImagePainter$State;)V", "_painter", "set_painter", "transform", "Lkotlin/Function1;", "getTransform$coil_compose_base_release", "()Lkotlin/jvm/functions/Function1;", "setTransform$coil_compose_base_release", "(Lkotlin/jvm/functions/Function1;)V", "onState", "", "getOnState$coil_compose_base_release", "setOnState$coil_compose_base_release", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "getContentScale$coil_compose_base_release", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale$coil_compose_base_release", "(Landroidx/compose/ui/layout/ContentScale;)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getFilterQuality-f-v9h1I$coil_compose_base_release", "()I", "setFilterQuality-vDHp3xo$coil_compose_base_release", "(I)V", "I", "isPreview", "", "isPreview$coil_compose_base_release", "()Z", "setPreview$coil_compose_base_release", "(Z)V", "state", "getState", "()Lcoil/compose/AsyncImagePainter$State;", "setState", "state$delegate", "getRequest", "()Lcoil/request/ImageRequest;", "setRequest$coil_compose_base_release", "(Lcoil/request/ImageRequest;)V", "request$delegate", "getImageLoader", "()Lcoil/ImageLoader;", "setImageLoader$coil_compose_base_release", "(Lcoil/ImageLoader;)V", "imageLoader$delegate", "intrinsicSize", "getIntrinsicSize-NH-jbRc", "()J", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "applyAlpha", "applyColorFilter", "onRemembered", "onForgotten", "onAbandoned", "clear", "updateRequest", "updateState", "input", "maybeNewCrossfadePainter", "Lcoil/compose/CrossfadePainter;", "previous", "current", "toState", "Lcoil/request/ImageResult;", "toPainter", "Landroid/graphics/drawable/Drawable;", "State", "Companion", "coil-compose-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class AsyncImagePainter extends Painter implements RememberObserver {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<State, State> DefaultTransform = new Function1() { // from class: coil.compose.AsyncImagePainter$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return AsyncImagePainter.DefaultTransform$lambda$5((AsyncImagePainter.State) obj);
        }
    };
    private Painter _painter;
    private State _state;

    /* renamed from: alpha$delegate, reason: from kotlin metadata */
    private final MutableFloatState alpha;

    /* renamed from: colorFilter$delegate, reason: from kotlin metadata */
    private final MutableState colorFilter;
    private ContentScale contentScale;
    private final MutableStateFlow<Size> drawSize = StateFlowKt.MutableStateFlow(Size.m4182boximpl(Size.INSTANCE.m4203getZeroNHjbRc()));
    private int filterQuality;

    /* renamed from: imageLoader$delegate, reason: from kotlin metadata */
    private final MutableState imageLoader;
    private boolean isPreview;
    private Function1<? super State, Unit> onState;

    /* renamed from: painter$delegate, reason: from kotlin metadata */
    private final MutableState painter;
    private CoroutineScope rememberScope;

    /* renamed from: request$delegate, reason: from kotlin metadata */
    private final MutableState request;

    /* renamed from: state$delegate, reason: from kotlin metadata */
    private final MutableState state;
    private Function1<? super State, ? extends State> transform;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final State DefaultTransform$lambda$5(State state) {
        return state;
    }

    public AsyncImagePainter(ImageRequest imageRequest, ImageLoader imageLoader) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.painter = mutableStateOf$default;
        this.alpha = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.colorFilter = mutableStateOf$default2;
        this._state = State.Empty.INSTANCE;
        this.transform = DefaultTransform;
        this.contentScale = ContentScale.INSTANCE.getFit();
        this.filterQuality = DrawScope.INSTANCE.m4938getDefaultFilterQualityfv9h1I();
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(State.Empty.INSTANCE, null, 2, null);
        this.state = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(imageRequest, null, 2, null);
        this.request = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(imageLoader, null, 2, null);
        this.imageLoader = mutableStateOf$default5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Painter getPainter() {
        return (Painter) this.painter.getValue();
    }

    private final void setPainter(Painter painter) {
        this.painter.setValue(painter);
    }

    private final float getAlpha() {
        return this.alpha.getFloatValue();
    }

    private final void setAlpha(float f) {
        this.alpha.setFloatValue(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ColorFilter getColorFilter() {
        return (ColorFilter) this.colorFilter.getValue();
    }

    private final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter.setValue(colorFilter);
    }

    private final void set_state(State state) {
        this._state = state;
        setState(state);
    }

    private final void set_painter(Painter painter) {
        this._painter = painter;
        setPainter(painter);
    }

    public final Function1<State, State> getTransform$coil_compose_base_release() {
        return this.transform;
    }

    public final void setTransform$coil_compose_base_release(Function1<? super State, ? extends State> function1) {
        this.transform = function1;
    }

    public final Function1<State, Unit> getOnState$coil_compose_base_release() {
        return this.onState;
    }

    public final void setOnState$coil_compose_base_release(Function1<? super State, Unit> function1) {
        this.onState = function1;
    }

    /* renamed from: getContentScale$coil_compose_base_release, reason: from getter */
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final void setContentScale$coil_compose_base_release(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    /* renamed from: getFilterQuality-f-v9h1I$coil_compose_base_release, reason: not valid java name and from getter */
    public final int getFilterQuality() {
        return this.filterQuality;
    }

    /* renamed from: setFilterQuality-vDHp3xo$coil_compose_base_release, reason: not valid java name */
    public final void m7614setFilterQualityvDHp3xo$coil_compose_base_release(int i) {
        this.filterQuality = i;
    }

    /* renamed from: isPreview$coil_compose_base_release, reason: from getter */
    public final boolean getIsPreview() {
        return this.isPreview;
    }

    public final void setPreview$coil_compose_base_release(boolean z) {
        this.isPreview = z;
    }

    private final void setState(State state) {
        this.state.setValue(state);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final State getState() {
        return (State) this.state.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ImageRequest getRequest() {
        return (ImageRequest) this.request.getValue();
    }

    public final void setRequest$coil_compose_base_release(ImageRequest imageRequest) {
        this.request.setValue(imageRequest);
    }

    public final ImageLoader getImageLoader() {
        return (ImageLoader) this.imageLoader.getValue();
    }

    public final void setImageLoader$coil_compose_base_release(ImageLoader imageLoader) {
        this.imageLoader.setValue(imageLoader);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc */
    public long getIntrinsicSize() {
        Painter painter = getPainter();
        return painter != null ? painter.getIntrinsicSize() : Size.INSTANCE.m4202getUnspecifiedNHjbRc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.graphics.painter.Painter
    public void onDraw(DrawScope drawScope) {
        this.drawSize.setValue(Size.m4182boximpl(drawScope.mo4935getSizeNHjbRc()));
        Painter painter = getPainter();
        if (painter != null) {
            painter.m5061drawx_KDEd0(drawScope, drawScope.mo4935getSizeNHjbRc(), getAlpha(), getColorFilter());
        }
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float alpha) {
        setAlpha(alpha);
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(ColorFilter colorFilter) {
        setColorFilter(colorFilter);
        return true;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        Trace.beginSection("AsyncImagePainter.onRemembered");
        try {
            if (this.rememberScope == null) {
                CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
                this.rememberScope = CoroutineScope;
                Object obj = this._painter;
                RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
                if (rememberObserver != null) {
                    rememberObserver.onRemembered();
                }
                if (!this.isPreview) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AsyncImagePainter$onRemembered$1$1(this, null), 3, null);
                } else {
                    Drawable placeholder = ImageRequest.newBuilder$default(getRequest(), null, 1, null).defaults(getImageLoader().getDefaults()).build().getPlaceholder();
                    updateState(new State.Loading(placeholder != null ? toPainter(placeholder) : null));
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        clear();
        Object obj = this._painter;
        RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
        if (rememberObserver != null) {
            rememberObserver.onForgotten();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        clear();
        Object obj = this._painter;
        RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
        if (rememberObserver != null) {
            rememberObserver.onAbandoned();
        }
    }

    private final void clear() {
        CoroutineScope coroutineScope = this.rememberScope;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
        }
        this.rememberScope = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageRequest updateRequest(ImageRequest request) {
        ImageRequest.Builder target = ImageRequest.newBuilder$default(request, null, 1, null).target(new Target() { // from class: coil.compose.AsyncImagePainter$updateRequest$$inlined$target$default$1
            @Override // coil.target.Target
            public void onError(Drawable error) {
            }

            @Override // coil.target.Target
            public void onSuccess(Drawable result) {
            }

            @Override // coil.target.Target
            public void onStart(Drawable placeholder) {
                AsyncImagePainter.this.updateState(new AsyncImagePainter.State.Loading(placeholder != null ? AsyncImagePainter.this.toPainter(placeholder) : null));
            }
        });
        if (request.getDefined().getSizeResolver() == null) {
            target.size(new SizeResolver() { // from class: coil.compose.AsyncImagePainter$updateRequest$2$1
                @Override // coil.size.SizeResolver
                public final Object size(Continuation<? super coil.size.Size> continuation) {
                    MutableStateFlow mutableStateFlow;
                    mutableStateFlow = AsyncImagePainter.this.drawSize;
                    final MutableStateFlow mutableStateFlow2 = mutableStateFlow;
                    return FlowKt.first(new Flow<coil.size.Size>() { // from class: coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1

                        /* compiled from: Emitters.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        /* renamed from: coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2, reason: invalid class name */
                        /* loaded from: classes5.dex */
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ FlowCollector $this_unsafeFlow;

                            /* compiled from: Emitters.kt */
                            @Metadata(k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                            @DebugMetadata(c = "coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2", f = "AsyncImagePainter.kt", i = {}, l = {221}, m = "emit", n = {}, s = {})
                            /* renamed from: coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                            /* loaded from: classes5.dex */
                            public static final class AnonymousClass1 extends ContinuationImpl {
                                Object L$0;
                                int label;
                                /* synthetic */ Object result;

                                public AnonymousClass1(Continuation continuation) {
                                    super(continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    this.result = obj;
                                    this.label |= Integer.MIN_VALUE;
                                    return AnonymousClass2.this.emit(null, this);
                                }
                            }

                            public AnonymousClass2(FlowCollector flowCollector) {
                                this.$this_unsafeFlow = flowCollector;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                            /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                                /*
                                    r4 = this;
                                    boolean r0 = r6 instanceof coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                                    if (r0 == 0) goto L14
                                    r0 = r6
                                    coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1 r0 = (coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                                    int r1 = r0.label
                                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                    r1 = r1 & r2
                                    if (r1 == 0) goto L14
                                    int r6 = r0.label
                                    int r6 = r6 - r2
                                    r0.label = r6
                                    goto L19
                                L14:
                                    coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1 r0 = new coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1
                                    r0.<init>(r6)
                                L19:
                                    java.lang.Object r6 = r0.result
                                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                    int r2 = r0.label
                                    r3 = 1
                                    if (r2 == 0) goto L32
                                    if (r2 != r3) goto L2a
                                    kotlin.ResultKt.throwOnFailure(r6)
                                    goto L4f
                                L2a:
                                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                    r4.<init>(r5)
                                    throw r4
                                L32:
                                    kotlin.ResultKt.throwOnFailure(r6)
                                    kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                                    r6 = r0
                                    kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                                    androidx.compose.ui.geometry.Size r5 = (androidx.compose.ui.geometry.Size) r5
                                    long r5 = r5.m4199unboximpl()
                                    coil.size.Size r5 = coil.compose.AsyncImagePainterKt.m7615access$toSizeOrNulluvyYCjk(r5)
                                    if (r5 == 0) goto L4f
                                    r0.label = r3
                                    java.lang.Object r4 = r4.emit(r5, r0)
                                    if (r4 != r1) goto L4f
                                    return r1
                                L4f:
                                    kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                    return r4
                                */
                                throw new UnsupportedOperationException("Method not decompiled: coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                            }
                        }

                        @Override // kotlinx.coroutines.flow.Flow
                        public Object collect(FlowCollector<? super coil.size.Size> flowCollector, Continuation continuation2) {
                            Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation2);
                            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                        }
                    }, continuation);
                }
            });
        }
        if (request.getDefined().getScale() == null) {
            target.scale(UtilsKt.toScale(this.contentScale));
        }
        if (request.getDefined().getPrecision() != Precision.EXACT) {
            target.precision(Precision.INEXACT);
        }
        return target.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateState(State input) {
        State state = this._state;
        State invoke = this.transform.invoke(input);
        set_state(invoke);
        CrossfadePainter maybeNewCrossfadePainter = maybeNewCrossfadePainter(state, invoke);
        set_painter(maybeNewCrossfadePainter != null ? maybeNewCrossfadePainter : invoke.getPainter());
        if (this.rememberScope != null && state.getPainter() != invoke.getPainter()) {
            Object painter = state.getPainter();
            RememberObserver rememberObserver = painter instanceof RememberObserver ? (RememberObserver) painter : null;
            if (rememberObserver != null) {
                rememberObserver.onForgotten();
            }
            Object painter2 = invoke.getPainter();
            RememberObserver rememberObserver2 = painter2 instanceof RememberObserver ? (RememberObserver) painter2 : null;
            if (rememberObserver2 != null) {
                rememberObserver2.onRemembered();
            }
        }
        Function1<? super State, Unit> function1 = this.onState;
        if (function1 != null) {
            function1.invoke(invoke);
        }
    }

    private final CrossfadePainter maybeNewCrossfadePainter(State previous, State current) {
        ErrorResult result;
        if (!(current instanceof State.Success)) {
            if (current instanceof State.Error) {
                result = ((State.Error) current).getResult();
            }
            return null;
        }
        result = ((State.Success) current).getResult();
        Transition create = result.getRequest().getTransitionFactory().create(AsyncImagePainterKt.access$getFakeTransitionTarget$p(), result);
        if (create instanceof CrossfadeTransition) {
            CrossfadeTransition crossfadeTransition = (CrossfadeTransition) create;
            return new CrossfadePainter(previous instanceof State.Loading ? previous.getPainter() : null, current.getPainter(), this.contentScale, crossfadeTransition.getDurationMillis(), ((result instanceof SuccessResult) && ((SuccessResult) result).getIsPlaceholderCached()) ? false : true, crossfadeTransition.getPreferExactIntrinsicSize());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final State toState(ImageResult imageResult) {
        if (imageResult instanceof SuccessResult) {
            SuccessResult successResult = (SuccessResult) imageResult;
            return new State.Success(toPainter(successResult.getDrawable()), successResult);
        }
        if (!(imageResult instanceof ErrorResult)) {
            throw new NoWhenBranchMatchedException();
        }
        ErrorResult errorResult = (ErrorResult) imageResult;
        Drawable drawable = errorResult.getDrawable();
        return new State.Error(drawable != null ? toPainter(drawable) : null, errorResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Painter toPainter(Drawable drawable) {
        return drawable instanceof BitmapDrawable ? BitmapPainterKt.m5058BitmapPainterQZhYCtY$default(AndroidImageBitmap_androidKt.asImageBitmap(((BitmapDrawable) drawable).getBitmap()), 0L, 0L, this.filterQuality, 6, null) : new DrawablePainter(drawable.mutate());
    }

    /* compiled from: AsyncImagePainter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0005¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcoil/compose/AsyncImagePainter$State;", "", "<init>", "()V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "Empty", "Loading", "Success", "Error", "Lcoil/compose/AsyncImagePainter$State$Empty;", "Lcoil/compose/AsyncImagePainter$State$Error;", "Lcoil/compose/AsyncImagePainter$State$Loading;", "Lcoil/compose/AsyncImagePainter$State$Success;", "coil-compose-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static abstract class State {
        public static final int $stable = 0;

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract Painter getPainter();

        private State() {
        }

        /* compiled from: AsyncImagePainter.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH×\u0003J\t\u0010\f\u001a\u00020\rH×\u0001J\t\u0010\u000e\u001a\u00020\u000fH×\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcoil/compose/AsyncImagePainter$State$Empty;", "Lcoil/compose/AsyncImagePainter$State;", "<init>", "()V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "equals", "", WriteOffReason.OTHER, "", "hashCode", "", "toString", "", "coil-compose-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes5.dex */
        public static final /* data */ class Empty extends State {
            public static final int $stable = 0;
            public static final Empty INSTANCE = new Empty();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Empty)) {
                    return false;
                }
                return true;
            }

            @Override // coil.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return null;
            }

            public int hashCode() {
                return -1515560141;
            }

            public String toString() {
                return "Empty";
            }

            private Empty() {
                super(null);
            }
        }

        /* compiled from: AsyncImagePainter.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcoil/compose/AsyncImagePainter$State$Loading;", "Lcoil/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "component1", "copy", "equals", "", WriteOffReason.OTHER, "", "hashCode", "", "toString", "", "coil-compose-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes5.dex */
        public static final /* data */ class Loading extends State {
            public static final int $stable = 8;
            private final Painter painter;

            public static /* synthetic */ Loading copy$default(Loading loading, Painter painter, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter = loading.painter;
                }
                return loading.copy(painter);
            }

            /* renamed from: component1, reason: from getter */
            public final Painter getPainter() {
                return this.painter;
            }

            public final Loading copy(Painter painter) {
                return new Loading(painter);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Loading) && Intrinsics.areEqual(this.painter, ((Loading) other).painter);
            }

            public int hashCode() {
                Painter painter = this.painter;
                if (painter == null) {
                    return 0;
                }
                return painter.hashCode();
            }

            public String toString() {
                return "Loading(painter=" + this.painter + ')';
            }

            @Override // coil.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return this.painter;
            }

            public Loading(Painter painter) {
                super(null);
                this.painter = painter;
            }
        }

        /* compiled from: AsyncImagePainter.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0014H×\u0001J\t\u0010\u0015\u001a\u00020\u0016H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcoil/compose/AsyncImagePainter$State$Success;", "Lcoil/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "result", "Lcoil/request/SuccessResult;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Lcoil/request/SuccessResult;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getResult", "()Lcoil/request/SuccessResult;", "component1", "component2", "copy", "equals", "", WriteOffReason.OTHER, "", "hashCode", "", "toString", "", "coil-compose-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes5.dex */
        public static final /* data */ class Success extends State {
            public static final int $stable = 8;
            private final Painter painter;
            private final SuccessResult result;

            public static /* synthetic */ Success copy$default(Success success, Painter painter, SuccessResult successResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter = success.painter;
                }
                if ((i & 2) != 0) {
                    successResult = success.result;
                }
                return success.copy(painter, successResult);
            }

            /* renamed from: component1, reason: from getter */
            public final Painter getPainter() {
                return this.painter;
            }

            /* renamed from: component2, reason: from getter */
            public final SuccessResult getResult() {
                return this.result;
            }

            public final Success copy(Painter painter, SuccessResult result) {
                return new Success(painter, result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return Intrinsics.areEqual(this.painter, success.painter) && Intrinsics.areEqual(this.result, success.result);
            }

            public int hashCode() {
                return (this.painter.hashCode() * 31) + this.result.hashCode();
            }

            public String toString() {
                return "Success(painter=" + this.painter + ", result=" + this.result + ')';
            }

            @Override // coil.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return this.painter;
            }

            public final SuccessResult getResult() {
                return this.result;
            }

            public Success(Painter painter, SuccessResult successResult) {
                super(null);
                this.painter = painter;
                this.result = successResult;
            }
        }

        /* compiled from: AsyncImagePainter.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0014H×\u0001J\t\u0010\u0015\u001a\u00020\u0016H×\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcoil/compose/AsyncImagePainter$State$Error;", "Lcoil/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "result", "Lcoil/request/ErrorResult;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Lcoil/request/ErrorResult;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getResult", "()Lcoil/request/ErrorResult;", "component1", "component2", "copy", "equals", "", WriteOffReason.OTHER, "", "hashCode", "", "toString", "", "coil-compose-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes5.dex */
        public static final /* data */ class Error extends State {
            public static final int $stable = 8;
            private final Painter painter;
            private final ErrorResult result;

            public static /* synthetic */ Error copy$default(Error error, Painter painter, ErrorResult errorResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter = error.painter;
                }
                if ((i & 2) != 0) {
                    errorResult = error.result;
                }
                return error.copy(painter, errorResult);
            }

            /* renamed from: component1, reason: from getter */
            public final Painter getPainter() {
                return this.painter;
            }

            /* renamed from: component2, reason: from getter */
            public final ErrorResult getResult() {
                return this.result;
            }

            public final Error copy(Painter painter, ErrorResult result) {
                return new Error(painter, result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return Intrinsics.areEqual(this.painter, error.painter) && Intrinsics.areEqual(this.result, error.result);
            }

            public int hashCode() {
                Painter painter = this.painter;
                return ((painter == null ? 0 : painter.hashCode()) * 31) + this.result.hashCode();
            }

            public String toString() {
                return "Error(painter=" + this.painter + ", result=" + this.result + ')';
            }

            @Override // coil.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return this.painter;
            }

            public final ErrorResult getResult() {
                return this.result;
            }

            public Error(Painter painter, ErrorResult errorResult) {
                super(null);
                this.painter = painter;
                this.result = errorResult;
            }
        }
    }

    /* compiled from: AsyncImagePainter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcoil/compose/AsyncImagePainter$Companion;", "", "<init>", "()V", "DefaultTransform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "getDefaultTransform", "()Lkotlin/jvm/functions/Function1;", "coil-compose-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function1<State, State> getDefaultTransform() {
            return AsyncImagePainter.DefaultTransform;
        }
    }
}
