package coil.intercept;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.EventListener;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.memory.MemoryCacheService;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.RequestService;
import coil.transform.Transformation;
import coil.util.Bitmaps;
import coil.util.DrawableUtils;
import coil.util.Logger;
import coil.util.SystemCallbacks;
import coil.util.Utils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;

/* compiled from: EngineInterceptor.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 42\u00020\u0001:\u000234B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J.\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\u001dJ6\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010#J>\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010'J0\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0081@¢\u0006\u0004\b*\u0010+J&\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u0010\"\u001a\u00020\u001a2\f\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcoil/intercept/EngineInterceptor;", "Lcoil/intercept/Interceptor;", "imageLoader", "Lcoil/ImageLoader;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "requestService", "Lcoil/request/RequestService;", "logger", "Lcoil/util/Logger;", "<init>", "(Lcoil/ImageLoader;Lcoil/util/SystemCallbacks;Lcoil/request/RequestService;Lcoil/util/Logger;)V", "memoryCacheService", "Lcoil/memory/MemoryCacheService;", "intercept", "Lcoil/request/ImageResult;", "chain", "Lcoil/intercept/Interceptor$Chain;", "(Lcoil/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "request", "Lcoil/request/ImageRequest;", "mappedData", "", "_options", "Lcoil/request/Options;", "eventListener", "Lcoil/EventListener;", "(Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetch", "Lcoil/fetch/FetchResult;", "components", "Lcoil/ComponentRegistry;", "options", "(Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decode", "fetchResult", "Lcoil/fetch/SourceResult;", "(Lcoil/fetch/SourceResult;Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transform", "result", "transform$coil_base_release", "(Lcoil/intercept/EngineInterceptor$ExecuteResult;Lcoil/request/ImageRequest;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertDrawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "transformations", "", "Lcoil/transform/Transformation;", "ExecuteResult", "Companion", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class EngineInterceptor implements Interceptor {
    private static final String TAG = "EngineInterceptor";
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final MemoryCacheService memoryCacheService;
    private final RequestService requestService;
    private final SystemCallbacks systemCallbacks;

    public EngineInterceptor(ImageLoader imageLoader, SystemCallbacks systemCallbacks, RequestService requestService, Logger logger) {
        this.imageLoader = imageLoader;
        this.systemCallbacks = systemCallbacks;
        this.requestService = requestService;
        this.logger = logger;
        this.memoryCacheService = new MemoryCacheService(imageLoader, requestService, logger);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    @Override // coil.intercept.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object intercept(coil.intercept.Interceptor.Chain r14, kotlin.coroutines.Continuation<? super coil.request.ImageResult> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof coil.intercept.EngineInterceptor$intercept$1
            if (r0 == 0) goto L14
            r0 = r15
            coil.intercept.EngineInterceptor$intercept$1 r0 = (coil.intercept.EngineInterceptor$intercept$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            coil.intercept.EngineInterceptor$intercept$1 r0 = new coil.intercept.EngineInterceptor$intercept$1
            r0.<init>(r13, r15)
        L19:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r13 = r0.L$1
            r14 = r13
            coil.intercept.Interceptor$Chain r14 = (coil.intercept.Interceptor.Chain) r14
            java.lang.Object r13 = r0.L$0
            coil.intercept.EngineInterceptor r13 = (coil.intercept.EngineInterceptor) r13
            kotlin.ResultKt.throwOnFailure(r15)     // Catch: java.lang.Throwable -> L33
            return r15
        L33:
            r0 = move-exception
            goto Laa
        L36:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3e:
            kotlin.ResultKt.throwOnFailure(r15)
            coil.request.ImageRequest r6 = r14.getRequest()     // Catch: java.lang.Throwable -> La7
            java.lang.Object r15 = r6.getData()     // Catch: java.lang.Throwable -> La7
            coil.size.Size r2 = r14.getSize()     // Catch: java.lang.Throwable -> La7
            coil.EventListener r9 = coil.util.Utils.getEventListener(r14)     // Catch: java.lang.Throwable -> La7
            coil.request.RequestService r4 = r13.requestService     // Catch: java.lang.Throwable -> La7
            coil.request.Options r8 = r4.options(r6, r2)     // Catch: java.lang.Throwable -> La7
            coil.size.Scale r4 = r8.getScale()     // Catch: java.lang.Throwable -> La7
            r9.mapStart(r6, r15)     // Catch: java.lang.Throwable -> La7
            coil.ImageLoader r5 = r13.imageLoader     // Catch: java.lang.Throwable -> La7
            coil.ComponentRegistry r5 = r5.getComponents()     // Catch: java.lang.Throwable -> La7
            java.lang.Object r7 = r5.map(r15, r8)     // Catch: java.lang.Throwable -> La7
            r9.mapEnd(r6, r7)     // Catch: java.lang.Throwable -> La7
            coil.memory.MemoryCacheService r15 = r13.memoryCacheService     // Catch: java.lang.Throwable -> La7
            coil.memory.MemoryCache$Key r10 = r15.newCacheKey(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> La7
            if (r10 == 0) goto L7a
            coil.memory.MemoryCacheService r15 = r13.memoryCacheService     // Catch: java.lang.Throwable -> L33
            coil.memory.MemoryCache$Value r15 = r15.getCacheValue(r6, r10, r2, r4)     // Catch: java.lang.Throwable -> L33
            goto L7b
        L7a:
            r15 = 0
        L7b:
            if (r15 == 0) goto L84
            coil.memory.MemoryCacheService r0 = r13.memoryCacheService     // Catch: java.lang.Throwable -> L33
            coil.request.SuccessResult r13 = r0.newResult(r14, r6, r10, r15)     // Catch: java.lang.Throwable -> L33
            return r13
        L84:
            kotlinx.coroutines.CoroutineDispatcher r15 = r6.getFetcherDispatcher()     // Catch: java.lang.Throwable -> La7
            kotlin.coroutines.CoroutineContext r15 = (kotlin.coroutines.CoroutineContext) r15     // Catch: java.lang.Throwable -> La7
            coil.intercept.EngineInterceptor$intercept$2 r4 = new coil.intercept.EngineInterceptor$intercept$2     // Catch: java.lang.Throwable -> La7
            r12 = 0
            r5 = r13
            r11 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> La2
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch: java.lang.Throwable -> La2
            r0.L$0 = r5     // Catch: java.lang.Throwable -> La2
            r0.L$1 = r11     // Catch: java.lang.Throwable -> La2
            r0.label = r3     // Catch: java.lang.Throwable -> La2
            java.lang.Object r13 = kotlinx.coroutines.BuildersKt.withContext(r15, r4, r0)     // Catch: java.lang.Throwable -> La2
            if (r13 != r1) goto La1
            return r1
        La1:
            return r13
        La2:
            r0 = move-exception
            r15 = r0
            r13 = r5
            r14 = r11
            goto Lab
        La7:
            r0 = move-exception
            r5 = r13
            r11 = r14
        Laa:
            r15 = r0
        Lab:
            boolean r0 = r15 instanceof java.util.concurrent.CancellationException
            if (r0 != 0) goto Lbb
            coil.request.RequestService r13 = r13.requestService
            coil.request.ImageRequest r14 = r14.getRequest()
            coil.request.ErrorResult r13 = r13.errorResult(r14, r15)
            return r13
        Lbb:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.intercept(coil.intercept.Interceptor$Chain, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01d2, code lost:
    
        if (r1 == r7) goto L68;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012c A[Catch: all -> 0x0087, TRY_LEAVE, TryCatch #1 {all -> 0x0087, blocks: (B:25:0x0054, B:26:0x015f, B:40:0x0077, B:42:0x0122, B:44:0x012c, B:49:0x0141, B:64:0x016d, B:66:0x0177, B:67:0x01ee, B:68:0x01f3), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x016d A[Catch: all -> 0x0087, TryCatch #1 {all -> 0x0087, blocks: (B:25:0x0054, B:26:0x015f, B:40:0x0077, B:42:0x0122, B:44:0x012c, B:49:0x0141, B:64:0x016d, B:66:0x0177, B:67:0x01ee, B:68:0x01f3), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /* JADX WARN: Type inference failed for: r1v14, types: [T, coil.ComponentRegistry] */
    /* JADX WARN: Type inference failed for: r1v7, types: [T, coil.ComponentRegistry] */
    /* JADX WARN: Type inference failed for: r1v9, types: [T, coil.request.Options] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object execute(coil.request.ImageRequest r24, java.lang.Object r25, coil.request.Options r26, coil.EventListener r27, kotlin.coroutines.Continuation<? super coil.intercept.EngineInterceptor.ExecuteResult> r28) {
        /*
            Method dump skipped, instructions count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.execute(coil.request.ImageRequest, java.lang.Object, coil.request.Options, coil.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0091 -> B:10:0x0098). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fetch(coil.ComponentRegistry r7, coil.request.ImageRequest r8, java.lang.Object r9, coil.request.Options r10, coil.EventListener r11, kotlin.coroutines.Continuation<? super coil.fetch.FetchResult> r12) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.fetch(coil.ComponentRegistry, coil.request.ImageRequest, java.lang.Object, coil.request.Options, coil.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0097 -> B:10:0x009e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object decode(coil.fetch.SourceResult r7, coil.ComponentRegistry r8, coil.request.ImageRequest r9, java.lang.Object r10, coil.request.Options r11, coil.EventListener r12, kotlin.coroutines.Continuation<? super coil.intercept.EngineInterceptor.ExecuteResult> r13) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.decode(coil.fetch.SourceResult, coil.ComponentRegistry, coil.request.ImageRequest, java.lang.Object, coil.request.Options, coil.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object transform$coil_base_release(ExecuteResult executeResult, ImageRequest imageRequest, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        List<Transformation> transformations = imageRequest.getTransformations();
        if (!transformations.isEmpty()) {
            if (!(executeResult.getDrawable() instanceof BitmapDrawable) && !imageRequest.getAllowConversionToBitmap()) {
                Logger logger = this.logger;
                if (logger != null && logger.getLevel() <= 4) {
                    logger.log(TAG, 4, "allowConversionToBitmap=false, skipping transformations for type " + executeResult.getDrawable().getClass().getCanonicalName() + '.', null);
                }
            } else {
                return BuildersKt.withContext(imageRequest.getTransformationDispatcher(), new EngineInterceptor$transform$3(this, executeResult, options, transformations, eventListener, imageRequest, null), continuation);
            }
        }
        return executeResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap convertDrawableToBitmap(Drawable drawable, Options options, List<? extends Transformation> transformations) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap.Config safeConfig = Bitmaps.getSafeConfig(bitmap);
            if (ArraysKt.contains(Utils.getVALID_TRANSFORMATION_CONFIGS(), safeConfig)) {
                return bitmap;
            }
            Logger logger = this.logger;
            if (logger != null && logger.getLevel() <= 4) {
                logger.log(TAG, 4, "Converting bitmap with config " + safeConfig + " to apply transformations: " + transformations + '.', null);
            }
        } else {
            Logger logger2 = this.logger;
            if (logger2 != null && logger2.getLevel() <= 4) {
                logger2.log(TAG, 4, "Converting drawable of type " + drawable.getClass().getCanonicalName() + " to apply transformations: " + transformations + '.', null);
            }
        }
        return DrawableUtils.INSTANCE.convertToBitmap(drawable, options.getConfig(), options.getSize(), options.getScale(), options.getAllowInexactSize());
    }

    /* compiled from: EngineInterceptor.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ0\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcoil/intercept/EngineInterceptor$ExecuteResult;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "isSampled", "", "dataSource", "Lcoil/decode/DataSource;", "diskCacheKey", "", "<init>", "(Landroid/graphics/drawable/Drawable;ZLcoil/decode/DataSource;Ljava/lang/String;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "()Z", "getDataSource", "()Lcoil/decode/DataSource;", "getDiskCacheKey", "()Ljava/lang/String;", "copy", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class ExecuteResult {
        private final DataSource dataSource;
        private final String diskCacheKey;
        private final Drawable drawable;
        private final boolean isSampled;

        public ExecuteResult(Drawable drawable, boolean z, DataSource dataSource, String str) {
            this.drawable = drawable;
            this.isSampled = z;
            this.dataSource = dataSource;
            this.diskCacheKey = str;
        }

        public final Drawable getDrawable() {
            return this.drawable;
        }

        /* renamed from: isSampled, reason: from getter */
        public final boolean getIsSampled() {
            return this.isSampled;
        }

        public final DataSource getDataSource() {
            return this.dataSource;
        }

        public final String getDiskCacheKey() {
            return this.diskCacheKey;
        }

        public static /* synthetic */ ExecuteResult copy$default(ExecuteResult executeResult, Drawable drawable, boolean z, DataSource dataSource, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                drawable = executeResult.drawable;
            }
            if ((i & 2) != 0) {
                z = executeResult.isSampled;
            }
            if ((i & 4) != 0) {
                dataSource = executeResult.dataSource;
            }
            if ((i & 8) != 0) {
                str = executeResult.diskCacheKey;
            }
            return executeResult.copy(drawable, z, dataSource, str);
        }

        public final ExecuteResult copy(Drawable drawable, boolean isSampled, DataSource dataSource, String diskCacheKey) {
            return new ExecuteResult(drawable, isSampled, dataSource, diskCacheKey);
        }
    }
}
