package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import coil.EventListener;
import coil.ImageLoader;
import coil.decode.BitmapFactoryDecoder;
import coil.disk.DiskCache;
import coil.fetch.AssetUriFetcher;
import coil.fetch.BitmapFetcher;
import coil.fetch.ByteBufferFetcher;
import coil.fetch.ContentUriFetcher;
import coil.fetch.DrawableFetcher;
import coil.fetch.FileFetcher;
import coil.fetch.HttpUriFetcher;
import coil.fetch.ResourceUriFetcher;
import coil.intercept.EngineInterceptor;
import coil.intercept.Interceptor;
import coil.key.FileKeyer;
import coil.key.UriKeyer;
import coil.map.ByteArrayMapper;
import coil.map.FileUriMapper;
import coil.map.HttpUrlMapper;
import coil.map.ResourceIntMapper;
import coil.map.ResourceUriMapper;
import coil.map.StringMapper;
import coil.memory.MemoryCache;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.OneShotDisposable;
import coil.request.RequestService;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.transition.NoneTransition;
import coil.transition.Transition;
import coil.transition.TransitionTarget;
import coil.util.ImageLoaderOptions;
import coil.util.Logger;
import coil.util.SystemCallbacks;
import coil.util.Utils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.Call;
import okhttp3.HttpUrl;

/* compiled from: RealImageLoader.kt */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \\2\u00020\u0001:\u0001\\Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0016J\u0016\u0010A\u001a\u00020B2\u0006\u0010?\u001a\u00020@H\u0096@¢\u0006\u0002\u0010CJ\u001e\u0010D\u001a\u00020B2\u0006\u0010E\u001a\u00020@2\u0006\u0010F\u001a\u00020GH\u0083@¢\u0006\u0002\u0010HJ\u0015\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020GH\u0000¢\u0006\u0002\bLJ\b\u0010;\u001a\u00020JH\u0016J\b\u0010M\u001a\u00020NH\u0016J\"\u0010O\u001a\u00020J2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020UH\u0002J\"\u0010V\u001a\u00020J2\u0006\u0010P\u001a\u00020W2\b\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020UH\u0002J\u0018\u0010X\u001a\u00020J2\u0006\u0010?\u001a\u00020@2\u0006\u0010T\u001a\u00020UH\u0002J1\u0010Y\u001a\u00020J2\u0006\u0010P\u001a\u00020B2\b\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020U2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020J0[H\u0082\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010-\u001a\u0004\u0018\u00010\b8VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b0\u00101*\u0004\b.\u0010/R\u001d\u00102\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b4\u00105*\u0004\b3\u0010/R\u0014\u00106\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\"R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020:09X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcoil/RealImageLoader;", "Lcoil/ImageLoader;", "context", "Landroid/content/Context;", "defaults", "Lcoil/request/DefaultRequestOptions;", "memoryCacheLazy", "Lkotlin/Lazy;", "Lcoil/memory/MemoryCache;", "diskCacheLazy", "Lcoil/disk/DiskCache;", "callFactoryLazy", "Lokhttp3/Call$Factory;", "eventListenerFactory", "Lcoil/EventListener$Factory;", "componentRegistry", "Lcoil/ComponentRegistry;", "options", "Lcoil/util/ImageLoaderOptions;", "logger", "Lcoil/util/Logger;", "<init>", "(Landroid/content/Context;Lcoil/request/DefaultRequestOptions;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil/EventListener$Factory;Lcoil/ComponentRegistry;Lcoil/util/ImageLoaderOptions;Lcoil/util/Logger;)V", "getContext", "()Landroid/content/Context;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "getMemoryCacheLazy", "()Lkotlin/Lazy;", "getDiskCacheLazy", "getCallFactoryLazy", "getEventListenerFactory", "()Lcoil/EventListener$Factory;", "getComponentRegistry", "()Lcoil/ComponentRegistry;", "getOptions", "()Lcoil/util/ImageLoaderOptions;", "getLogger", "()Lcoil/util/Logger;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "requestService", "Lcoil/request/RequestService;", "memoryCache", "getMemoryCache$delegate", "(Lcoil/RealImageLoader;)Ljava/lang/Object;", "getMemoryCache", "()Lcoil/memory/MemoryCache;", "diskCache", "getDiskCache$delegate", "getDiskCache", "()Lcoil/disk/DiskCache;", "components", "getComponents", "interceptors", "", "Lcoil/intercept/Interceptor;", "shutdown", "Ljava/util/concurrent/atomic/AtomicBoolean;", "enqueue", "Lcoil/request/Disposable;", "request", "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeMain", "initialRequest", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "(Lcoil/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onTrimMemory", "", FirebaseAnalytics.Param.LEVEL, "onTrimMemory$coil_base_release", "newBuilder", "Lcoil/ImageLoader$Builder;", "onSuccess", "result", "Lcoil/request/SuccessResult;", TypedValues.AttributesType.S_TARGET, "Lcoil/target/Target;", "eventListener", "Lcoil/EventListener;", "onError", "Lcoil/request/ErrorResult;", "onCancel", "transition", "setDrawable", "Lkotlin/Function0;", "Companion", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class RealImageLoader implements ImageLoader {
    private static final int REQUEST_TYPE_ENQUEUE = 0;
    private static final int REQUEST_TYPE_EXECUTE = 1;
    private static final String TAG = "RealImageLoader";
    private final Lazy<Call.Factory> callFactoryLazy;
    private final ComponentRegistry componentRegistry;
    private final ComponentRegistry components;
    private final Context context;
    private final DefaultRequestOptions defaults;
    private final Lazy<DiskCache> diskCacheLazy;
    private final EventListener.Factory eventListenerFactory;
    private final List<Interceptor> interceptors;
    private final Logger logger;
    private final Lazy<MemoryCache> memoryCacheLazy;
    private final ImageLoaderOptions options;
    private final RequestService requestService;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()).plus(new RealImageLoader$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this)));
    private final AtomicBoolean shutdown;
    private final SystemCallbacks systemCallbacks;

    /* JADX WARN: Multi-variable type inference failed */
    public RealImageLoader(Context context, DefaultRequestOptions defaultRequestOptions, Lazy<? extends MemoryCache> lazy, Lazy<? extends DiskCache> lazy2, Lazy<? extends Call.Factory> lazy3, EventListener.Factory factory, ComponentRegistry componentRegistry, ImageLoaderOptions imageLoaderOptions, Logger logger) {
        this.context = context;
        this.defaults = defaultRequestOptions;
        this.memoryCacheLazy = lazy;
        this.diskCacheLazy = lazy2;
        this.callFactoryLazy = lazy3;
        this.eventListenerFactory = factory;
        this.componentRegistry = componentRegistry;
        this.options = imageLoaderOptions;
        this.logger = logger;
        SystemCallbacks systemCallbacks = new SystemCallbacks(this);
        this.systemCallbacks = systemCallbacks;
        RealImageLoader realImageLoader = this;
        RequestService requestService = new RequestService(realImageLoader, systemCallbacks, logger);
        this.requestService = requestService;
        this.components = componentRegistry.newBuilder().add(new HttpUrlMapper(), HttpUrl.class).add(new StringMapper(), String.class).add(new FileUriMapper(), Uri.class).add(new ResourceUriMapper(), Uri.class).add(new ResourceIntMapper(), Integer.class).add(new ByteArrayMapper(), byte[].class).add(new UriKeyer(), Uri.class).add(new FileKeyer(imageLoaderOptions.getAddLastModifiedToFileCacheKey()), File.class).add(new HttpUriFetcher.Factory(lazy3, lazy2, imageLoaderOptions.getRespectCacheHeaders()), Uri.class).add(new FileFetcher.Factory(), File.class).add(new AssetUriFetcher.Factory(), Uri.class).add(new ContentUriFetcher.Factory(), Uri.class).add(new ResourceUriFetcher.Factory(), Uri.class).add(new DrawableFetcher.Factory(), Drawable.class).add(new BitmapFetcher.Factory(), Bitmap.class).add(new ByteBufferFetcher.Factory(), ByteBuffer.class).add(new BitmapFactoryDecoder.Factory(imageLoaderOptions.getBitmapFactoryMaxParallelism(), imageLoaderOptions.getBitmapFactoryExifOrientationPolicy())).build();
        this.interceptors = CollectionsKt.plus((Collection<? extends EngineInterceptor>) getComponents().getInterceptors(), new EngineInterceptor(realImageLoader, systemCallbacks, requestService, logger));
        this.shutdown = new AtomicBoolean(false);
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // coil.ImageLoader
    public DefaultRequestOptions getDefaults() {
        return this.defaults;
    }

    public final Lazy<MemoryCache> getMemoryCacheLazy() {
        return this.memoryCacheLazy;
    }

    public final Lazy<DiskCache> getDiskCacheLazy() {
        return this.diskCacheLazy;
    }

    public final Lazy<Call.Factory> getCallFactoryLazy() {
        return this.callFactoryLazy;
    }

    public final EventListener.Factory getEventListenerFactory() {
        return this.eventListenerFactory;
    }

    public final ComponentRegistry getComponentRegistry() {
        return this.componentRegistry;
    }

    public final ImageLoaderOptions getOptions() {
        return this.options;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    @Override // coil.ImageLoader
    public MemoryCache getMemoryCache() {
        return this.memoryCacheLazy.getValue();
    }

    @Override // coil.ImageLoader
    public DiskCache getDiskCache() {
        return this.diskCacheLazy.getValue();
    }

    @Override // coil.ImageLoader
    public ComponentRegistry getComponents() {
        return this.components;
    }

    @Override // coil.ImageLoader
    public Disposable enqueue(ImageRequest request) {
        Deferred<? extends ImageResult> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this.scope, null, null, new RealImageLoader$enqueue$job$1(this, request, null), 3, null);
        if (request.getTarget() instanceof ViewTarget) {
            return Utils.getRequestManager(((ViewTarget) request.getTarget()).getView()).getDisposable(async$default);
        }
        return new OneShotDisposable(async$default);
    }

    @Override // coil.ImageLoader
    public Object execute(ImageRequest imageRequest, Continuation<? super ImageResult> continuation) {
        if (imageRequest.getTarget() instanceof ViewTarget) {
            return CoroutineScopeKt.coroutineScope(new RealImageLoader$execute$2(imageRequest, this, null), continuation);
        }
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new RealImageLoader$execute$3(this, imageRequest, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x018b A[Catch: all -> 0x01ae, TryCatch #6 {all -> 0x01ae, blocks: (B:16:0x0185, B:18:0x018b, B:22:0x0196, B:24:0x019a, B:25:0x01a8, B:26:0x01ad), top: B:15:0x0185 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0196 A[Catch: all -> 0x01ae, TryCatch #6 {all -> 0x01ae, blocks: (B:16:0x0185, B:18:0x018b, B:22:0x0196, B:24:0x019a, B:25:0x01a8, B:26:0x01ad), top: B:15:0x0185 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fc A[Catch: all -> 0x01bd, TryCatch #3 {all -> 0x01bd, blocks: (B:66:0x00f6, B:68:0x00fc, B:70:0x0102, B:72:0x010a, B:74:0x0112, B:75:0x0126, B:77:0x012c, B:78:0x012f, B:80:0x0138, B:81:0x013b, B:84:0x0122, B:92:0x00cf, B:94:0x00d7, B:96:0x00dc, B:100:0x01b7, B:101:0x01bc), top: B:91:0x00cf }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0112 A[Catch: all -> 0x01bd, TryCatch #3 {all -> 0x01bd, blocks: (B:66:0x00f6, B:68:0x00fc, B:70:0x0102, B:72:0x010a, B:74:0x0112, B:75:0x0126, B:77:0x012c, B:78:0x012f, B:80:0x0138, B:81:0x013b, B:84:0x0122, B:92:0x00cf, B:94:0x00d7, B:96:0x00dc, B:100:0x01b7, B:101:0x01bc), top: B:91:0x00cf }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012c A[Catch: all -> 0x01bd, TryCatch #3 {all -> 0x01bd, blocks: (B:66:0x00f6, B:68:0x00fc, B:70:0x0102, B:72:0x010a, B:74:0x0112, B:75:0x0126, B:77:0x012c, B:78:0x012f, B:80:0x0138, B:81:0x013b, B:84:0x0122, B:92:0x00cf, B:94:0x00d7, B:96:0x00dc, B:100:0x01b7, B:101:0x01bc), top: B:91:0x00cf }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0138 A[Catch: all -> 0x01bd, TryCatch #3 {all -> 0x01bd, blocks: (B:66:0x00f6, B:68:0x00fc, B:70:0x0102, B:72:0x010a, B:74:0x0112, B:75:0x0126, B:77:0x012c, B:78:0x012f, B:80:0x0138, B:81:0x013b, B:84:0x0122, B:92:0x00cf, B:94:0x00d7, B:96:0x00dc, B:100:0x01b7, B:101:0x01bc), top: B:91:0x00cf }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0122 A[Catch: all -> 0x01bd, TryCatch #3 {all -> 0x01bd, blocks: (B:66:0x00f6, B:68:0x00fc, B:70:0x0102, B:72:0x010a, B:74:0x0112, B:75:0x0126, B:77:0x012c, B:78:0x012f, B:80:0x0138, B:81:0x013b, B:84:0x0122, B:92:0x00cf, B:94:0x00d7, B:96:0x00dc, B:100:0x01b7, B:101:0x01bc), top: B:91:0x00cf }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeMain(coil.request.ImageRequest r20, int r21, kotlin.coroutines.Continuation<? super coil.request.ImageResult> r22) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.executeMain(coil.request.ImageRequest, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onTrimMemory$coil_base_release(int level) {
        MemoryCache value;
        Lazy<MemoryCache> lazy = this.memoryCacheLazy;
        if (lazy == null || (value = lazy.getValue()) == null) {
            return;
        }
        value.trimMemory(level);
    }

    @Override // coil.ImageLoader
    public void shutdown() {
        if (this.shutdown.getAndSet(true)) {
            return;
        }
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        this.systemCallbacks.shutdown();
        MemoryCache memoryCache = getMemoryCache();
        if (memoryCache != null) {
            memoryCache.clear();
        }
    }

    @Override // coil.ImageLoader
    public ImageLoader.Builder newBuilder() {
        return new ImageLoader.Builder(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0045, code lost:
    
        if (r7 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void onSuccess(coil.request.SuccessResult r6, coil.target.Target r7, coil.EventListener r8) {
        /*
            r5 = this;
            coil.request.ImageRequest r0 = r6.getRequest()
            coil.decode.DataSource r1 = r6.getDataSource()
            coil.util.Logger r5 = r5.logger
            if (r5 == 0) goto L41
            int r2 = r5.getLevel()
            r3 = 4
            if (r2 > r3) goto L41
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = coil.util.Utils.getEmoji(r1)
            r2.append(r4)
            java.lang.String r4 = " Successful ("
            r2.append(r4)
            java.lang.String r1 = r1.name()
            r2.append(r1)
            java.lang.String r1 = ") - "
            r2.append(r1)
            java.lang.Object r1 = r0.getData()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r2 = 0
            java.lang.String r4 = "RealImageLoader"
            r5.log(r4, r3, r1, r2)
        L41:
            boolean r5 = r7 instanceof coil.transition.TransitionTarget
            if (r5 != 0) goto L48
            if (r7 == 0) goto L77
            goto L5e
        L48:
            r5 = r6
            coil.request.ImageResult r5 = (coil.request.ImageResult) r5
            coil.request.ImageRequest r1 = r5.getRequest()
            coil.transition.Transition$Factory r1 = r1.getTransitionFactory()
            r2 = r7
            coil.transition.TransitionTarget r2 = (coil.transition.TransitionTarget) r2
            coil.transition.Transition r1 = r1.create(r2, r5)
            boolean r2 = r1 instanceof coil.transition.NoneTransition
            if (r2 == 0) goto L66
        L5e:
            android.graphics.drawable.Drawable r5 = r6.getDrawable()
            r7.onSuccess(r5)
            goto L77
        L66:
            coil.request.ImageRequest r7 = r5.getRequest()
            r8.transitionStart(r7, r1)
            r1.transition()
            coil.request.ImageRequest r5 = r5.getRequest()
            r8.transitionEnd(r5, r1)
        L77:
            r8.onSuccess(r0, r6)
            coil.request.ImageRequest$Listener r5 = r0.getListener()
            if (r5 == 0) goto L83
            r5.onSuccess(r0, r6)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.onSuccess(coil.request.SuccessResult, coil.target.Target, coil.EventListener):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0037, code lost:
    
        if (r7 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void onError(coil.request.ErrorResult r6, coil.target.Target r7, coil.EventListener r8) {
        /*
            r5 = this;
            coil.request.ImageRequest r0 = r6.getRequest()
            coil.util.Logger r5 = r5.logger
            if (r5 == 0) goto L33
            int r1 = r5.getLevel()
            r2 = 4
            if (r1 > r2) goto L33
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "🚨 Failed - "
            r1.<init>(r3)
            java.lang.Object r3 = r0.getData()
            r1.append(r3)
            java.lang.String r3 = " - "
            r1.append(r3)
            java.lang.Throwable r3 = r6.getThrowable()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r3 = 0
            java.lang.String r4 = "RealImageLoader"
            r5.log(r4, r2, r1, r3)
        L33:
            boolean r5 = r7 instanceof coil.transition.TransitionTarget
            if (r5 != 0) goto L3a
            if (r7 == 0) goto L69
            goto L50
        L3a:
            r5 = r6
            coil.request.ImageResult r5 = (coil.request.ImageResult) r5
            coil.request.ImageRequest r1 = r5.getRequest()
            coil.transition.Transition$Factory r1 = r1.getTransitionFactory()
            r2 = r7
            coil.transition.TransitionTarget r2 = (coil.transition.TransitionTarget) r2
            coil.transition.Transition r1 = r1.create(r2, r5)
            boolean r2 = r1 instanceof coil.transition.NoneTransition
            if (r2 == 0) goto L58
        L50:
            android.graphics.drawable.Drawable r5 = r6.getDrawable()
            r7.onError(r5)
            goto L69
        L58:
            coil.request.ImageRequest r7 = r5.getRequest()
            r8.transitionStart(r7, r1)
            r1.transition()
            coil.request.ImageRequest r5 = r5.getRequest()
            r8.transitionEnd(r5, r1)
        L69:
            r8.onError(r0, r6)
            coil.request.ImageRequest$Listener r5 = r0.getListener()
            if (r5 == 0) goto L75
            r5.onError(r0, r6)
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.onError(coil.request.ErrorResult, coil.target.Target, coil.EventListener):void");
    }

    private final void onCancel(ImageRequest request, EventListener eventListener) {
        Logger logger = this.logger;
        if (logger != null && logger.getLevel() <= 4) {
            logger.log(TAG, 4, "🏗  Cancelled - " + request.getData(), null);
        }
        eventListener.onCancel(request);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onCancel(request);
        }
    }

    private final void transition(ImageResult result, Target target, EventListener eventListener, Function0<Unit> setDrawable) {
        if (!(target instanceof TransitionTarget)) {
            setDrawable.invoke();
            return;
        }
        Transition create = result.getRequest().getTransitionFactory().create((TransitionTarget) target, result);
        if (create instanceof NoneTransition) {
            setDrawable.invoke();
            return;
        }
        eventListener.transitionStart(result.getRequest(), create);
        create.transition();
        eventListener.transitionEnd(result.getRequest(), create);
    }
}
