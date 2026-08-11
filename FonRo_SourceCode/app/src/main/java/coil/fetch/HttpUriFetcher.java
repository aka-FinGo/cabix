package coil.fetch;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.ImageSource;
import coil.decode.ImageSources;
import coil.disk.DiskCache;
import coil.fetch.Fetcher;
import coil.network.CacheResponse;
import coil.network.CacheStrategy;
import coil.request.Options;
import coil.util.Utils;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;

/* compiled from: HttpUriFetcher.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 22\u00020\u0001:\u000212B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J.\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\u0016\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!H\u0001¢\u0006\u0002\b\"J\u0018\u0010#\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010$\u001a\u0004\u0018\u00010\u001b*\u00020\u0013H\u0002J\f\u0010%\u001a\u00020&*\u00020\u0013H\u0002J\f\u0010%\u001a\u00020&*\u00020'H\u0002J\f\u0010(\u001a\u00020)*\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00063"}, d2 = {"Lcoil/fetch/HttpUriFetcher;", "Lcoil/fetch/Fetcher;", ImagesContract.URL, "", "options", "Lcoil/request/Options;", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "diskCache", "Lcoil/disk/DiskCache;", "respectCacheHeaders", "", "<init>", "(Ljava/lang/String;Lcoil/request/Options;Lkotlin/Lazy;Lkotlin/Lazy;Z)V", "fetch", "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFromDiskCache", "Lcoil/disk/DiskCache$Snapshot;", "writeToDiskCache", "snapshot", "request", "Lokhttp3/Request;", "response", "Lokhttp3/Response;", "cacheResponse", "Lcoil/network/CacheResponse;", "newRequest", "executeNetworkRequest", "(Lokhttp3/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", "contentType", "Lokhttp3/MediaType;", "getMimeType$coil_base_release", "isCacheable", "toCacheResponse", "toImageSource", "Lcoil/decode/ImageSource;", "Lokhttp3/ResponseBody;", "toDataSource", "Lcoil/decode/DataSource;", "diskCacheKey", "getDiskCacheKey", "()Ljava/lang/String;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "Factory", "Companion", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class HttpUriFetcher implements Fetcher {
    private static final String MIME_TYPE_TEXT_PLAIN = "text/plain";
    private final Lazy<Call.Factory> callFactory;
    private final Lazy<DiskCache> diskCache;
    private final Options options;
    private final boolean respectCacheHeaders;
    private final String url;
    private static final CacheControl CACHE_CONTROL_FORCE_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().noStore().build();
    private static final CacheControl CACHE_CONTROL_NO_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().onlyIfCached().build();

    /* JADX WARN: Multi-variable type inference failed */
    public HttpUriFetcher(String str, Options options, Lazy<? extends Call.Factory> lazy, Lazy<? extends DiskCache> lazy2, boolean z) {
        this.url = str;
        this.options = options;
        this.callFactory = lazy;
        this.diskCache = lazy2;
        this.respectCacheHeaders = z;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(3:(2:3|(9:5|6|7|(1:(1:(7:11|12|13|14|15|16|17)(2:33|34))(3:35|36|37))(4:62|(4:64|(2:85|86)|67|(2:69|(2:73|74))(4:78|(1:80)|81|82))(1:87)|75|(2:77|55))|38|39|40|42|(4:44|(1:46)|47|48)(2:49|(2:51|52)(3:53|(5:56|14|15|16|17)|55))))|42|(0)(0))|89|6|7|(0)(0)|38|39|40|(2:(0)|(1:25))) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01a8, code lost:
    
        r12 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01a9, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0124 A[Catch: Exception -> 0x01a4, TRY_ENTER, TryCatch #4 {Exception -> 0x01a4, blocks: (B:44:0x0124, B:46:0x0132, B:47:0x0136, B:49:0x0140, B:51:0x014c, B:53:0x0164), top: B:42:0x0122 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0140 A[Catch: Exception -> 0x01a4, TryCatch #4 {Exception -> 0x01a4, blocks: (B:44:0x0124, B:46:0x0132, B:47:0x0136, B:49:0x0140, B:51:0x014c, B:53:0x0164), top: B:42:0x0122 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    @Override // coil.fetch.Fetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object fetch(kotlin.coroutines.Continuation<? super coil.fetch.FetchResult> r12) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.HttpUriFetcher.fetch(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final DiskCache.Snapshot readFromDiskCache() {
        DiskCache value;
        if (!this.options.getDiskCachePolicy().getReadEnabled() || (value = this.diskCache.getValue()) == null) {
            return null;
        }
        return value.openSnapshot(getDiskCacheKey());
    }

    private final DiskCache.Snapshot writeToDiskCache(DiskCache.Snapshot snapshot, Request request, Response response, CacheResponse cacheResponse) {
        DiskCache.Editor openEditor;
        Throwable th;
        Throwable th2 = null;
        if (!isCacheable(request, response)) {
            if (snapshot != null) {
                Utils.closeQuietly(snapshot);
            }
            return null;
        }
        if (snapshot != null) {
            openEditor = snapshot.closeAndOpenEditor();
        } else {
            DiskCache value = this.diskCache.getValue();
            openEditor = value != null ? value.openEditor(getDiskCacheKey()) : null;
        }
        try {
            if (openEditor == null) {
                return null;
            }
            try {
                if (response.code() == 304 && cacheResponse != null) {
                    Response build = response.newBuilder().headers(CacheStrategy.INSTANCE.combineHeaders(cacheResponse.getResponseHeaders(), response.headers())).build();
                    BufferedSink buffer = Okio.buffer(getFileSystem().sink(openEditor.getMetadata(), false));
                    try {
                        new CacheResponse(build).writeTo(buffer);
                        Unit unit = Unit.INSTANCE;
                        if (buffer != null) {
                            try {
                                buffer.close();
                            } catch (Throwable th3) {
                                th2 = th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (buffer != null) {
                            try {
                                buffer.close();
                            } catch (Throwable th5) {
                                ExceptionsKt.addSuppressed(th2, th5);
                            }
                        }
                    }
                    if (th2 != null) {
                        throw th2;
                    }
                } else {
                    BufferedSink buffer2 = Okio.buffer(getFileSystem().sink(openEditor.getMetadata(), false));
                    try {
                        new CacheResponse(response).writeTo(buffer2);
                        Unit unit2 = Unit.INSTANCE;
                        if (buffer2 != null) {
                            try {
                                buffer2.close();
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        }
                        th = null;
                    } catch (Throwable th7) {
                        if (buffer2 != null) {
                            try {
                                buffer2.close();
                            } catch (Throwable th8) {
                                ExceptionsKt.addSuppressed(th7, th8);
                            }
                        }
                        th = th7;
                    }
                    if (th != null) {
                        throw th;
                    }
                    BufferedSink buffer3 = Okio.buffer(getFileSystem().sink(openEditor.getData(), false));
                    try {
                        ResponseBody body = response.body();
                        Intrinsics.checkNotNull(body);
                        Long.valueOf(body.getSource().readAll(buffer3));
                        if (buffer3 != null) {
                            try {
                                buffer3.close();
                            } catch (Throwable th9) {
                                th2 = th9;
                            }
                        }
                    } catch (Throwable th10) {
                        th2 = th10;
                        if (buffer3 != null) {
                            try {
                                buffer3.close();
                            } catch (Throwable th11) {
                                ExceptionsKt.addSuppressed(th2, th11);
                            }
                        }
                    }
                    if (th2 != null) {
                        throw th2;
                    }
                }
                return openEditor.commitAndOpenSnapshot();
            } catch (Exception e) {
                Utils.abortQuietly(openEditor);
                throw e;
            }
        } finally {
            Utils.closeQuietly(response);
        }
    }

    private final Request newRequest() {
        Request.Builder headers = new Request.Builder().url(this.url).headers(this.options.getHeaders());
        for (Map.Entry<Class<?>, Object> entry : this.options.getTags().asMap().entrySet()) {
            Class<?> key = entry.getKey();
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            headers.tag(key, entry.getValue());
        }
        boolean readEnabled = this.options.getDiskCachePolicy().getReadEnabled();
        boolean readEnabled2 = this.options.getNetworkCachePolicy().getReadEnabled();
        if (!readEnabled2 && readEnabled) {
            headers.cacheControl(CacheControl.FORCE_CACHE);
        } else if (!readEnabled2 || readEnabled) {
            if (!readEnabled2 && !readEnabled) {
                headers.cacheControl(CACHE_CONTROL_NO_NETWORK_NO_CACHE);
            }
        } else if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            headers.cacheControl(CacheControl.FORCE_NETWORK);
        } else {
            headers.cacheControl(CACHE_CONTROL_FORCE_NETWORK_NO_CACHE);
        }
        return headers.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeNetworkRequest(okhttp3.Request r5, kotlin.coroutines.Continuation<? super okhttp3.Response> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof coil.fetch.HttpUriFetcher$executeNetworkRequest$1
            if (r0 == 0) goto L14
            r0 = r6
            coil.fetch.HttpUriFetcher$executeNetworkRequest$1 r0 = (coil.fetch.HttpUriFetcher$executeNetworkRequest$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            coil.fetch.HttpUriFetcher$executeNetworkRequest$1 r0 = new coil.fetch.HttpUriFetcher$executeNetworkRequest$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L73
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = coil.util.Utils.isMainThread()
            if (r6 == 0) goto L5e
            coil.request.Options r6 = r4.options
            coil.request.CachePolicy r6 = r6.getNetworkCachePolicy()
            boolean r6 = r6.getReadEnabled()
            if (r6 != 0) goto L58
            kotlin.Lazy<okhttp3.Call$Factory> r4 = r4.callFactory
            java.lang.Object r4 = r4.getValue()
            okhttp3.Call$Factory r4 = (okhttp3.Call.Factory) r4
            okhttp3.Call r4 = r4.newCall(r5)
            okhttp3.Response r4 = r4.execute()
            goto L76
        L58:
            android.os.NetworkOnMainThreadException r4 = new android.os.NetworkOnMainThreadException
            r4.<init>()
            throw r4
        L5e:
            kotlin.Lazy<okhttp3.Call$Factory> r4 = r4.callFactory
            java.lang.Object r4 = r4.getValue()
            okhttp3.Call$Factory r4 = (okhttp3.Call.Factory) r4
            okhttp3.Call r4 = r4.newCall(r5)
            r0.label = r3
            java.lang.Object r6 = coil.util.Calls.await(r4, r0)
            if (r6 != r1) goto L73
            return r1
        L73:
            r4 = r6
            okhttp3.Response r4 = (okhttp3.Response) r4
        L76:
            boolean r5 = r4.isSuccessful()
            if (r5 != 0) goto L95
            int r5 = r4.code()
            r6 = 304(0x130, float:4.26E-43)
            if (r5 == r6) goto L95
            okhttp3.ResponseBody r5 = r4.body()
            if (r5 == 0) goto L8f
            java.io.Closeable r5 = (java.io.Closeable) r5
            coil.util.Utils.closeQuietly(r5)
        L8f:
            coil.network.HttpException r5 = new coil.network.HttpException
            r5.<init>(r4)
            throw r5
        L95:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.HttpUriFetcher.executeNetworkRequest(okhttp3.Request, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String getMimeType$coil_base_release(String url, MediaType contentType) {
        String mimeTypeFromUrl;
        String mediaType = contentType != null ? contentType.getMediaType() : null;
        if ((mediaType == null || StringsKt.startsWith$default(mediaType, MIME_TYPE_TEXT_PLAIN, false, 2, (Object) null)) && (mimeTypeFromUrl = Utils.getMimeTypeFromUrl(MimeTypeMap.getSingleton(), url)) != null) {
            return mimeTypeFromUrl;
        }
        if (mediaType != null) {
            return StringsKt.substringBefore$default(mediaType, ';', (String) null, 2, (Object) null);
        }
        return null;
    }

    private final boolean isCacheable(Request request, Response response) {
        if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            return !this.respectCacheHeaders || CacheStrategy.INSTANCE.isCacheable(request, response);
        }
        return false;
    }

    private final CacheResponse toCacheResponse(DiskCache.Snapshot snapshot) {
        Throwable th;
        CacheResponse cacheResponse;
        try {
            BufferedSource buffer = Okio.buffer(getFileSystem().source(snapshot.getMetadata()));
            try {
                cacheResponse = new CacheResponse(buffer);
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                th = null;
            } catch (Throwable th3) {
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.addSuppressed(th3, th4);
                    }
                }
                th = th3;
                cacheResponse = null;
            }
            if (th == null) {
                return cacheResponse;
            }
            throw th;
        } catch (IOException unused) {
            return null;
        }
    }

    private final ImageSource toImageSource(DiskCache.Snapshot snapshot) {
        return ImageSources.create(snapshot.getData(), getFileSystem(), getDiskCacheKey(), snapshot);
    }

    private final ImageSource toImageSource(ResponseBody responseBody) {
        return ImageSources.create(responseBody.getSource(), this.options.getContext());
    }

    private final DataSource toDataSource(Response response) {
        return response.networkResponse() != null ? DataSource.NETWORK : DataSource.DISK;
    }

    private final String getDiskCacheKey() {
        String diskCacheKey = this.options.getDiskCacheKey();
        return diskCacheKey == null ? this.url : diskCacheKey;
    }

    private final FileSystem getFileSystem() {
        DiskCache value = this.diskCache.getValue();
        Intrinsics.checkNotNull(value);
        return value.getFileSystem();
    }

    /* compiled from: HttpUriFetcher.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcoil/fetch/HttpUriFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Landroid/net/Uri;", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "diskCache", "Lcoil/disk/DiskCache;", "respectCacheHeaders", "", "<init>", "(Lkotlin/Lazy;Lkotlin/Lazy;Z)V", "create", "Lcoil/fetch/Fetcher;", "data", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "isApplicable", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final Lazy<Call.Factory> callFactory;
        private final Lazy<DiskCache> diskCache;
        private final boolean respectCacheHeaders;

        /* JADX WARN: Multi-variable type inference failed */
        public Factory(Lazy<? extends Call.Factory> lazy, Lazy<? extends DiskCache> lazy2, boolean z) {
            this.callFactory = lazy;
            this.diskCache = lazy2;
            this.respectCacheHeaders = z;
        }

        @Override // coil.fetch.Fetcher.Factory
        public Fetcher create(Uri data, Options options, ImageLoader imageLoader) {
            if (isApplicable(data)) {
                return new HttpUriFetcher(data.toString(), options, this.callFactory, this.diskCache, this.respectCacheHeaders);
            }
            return null;
        }

        private final boolean isApplicable(Uri data) {
            return Intrinsics.areEqual(data.getScheme(), "http") || Intrinsics.areEqual(data.getScheme(), "https");
        }
    }
}
