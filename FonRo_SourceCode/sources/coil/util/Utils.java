package coil.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import coil.ComponentRegistry;
import coil.EventListener;
import coil.base.R;
import coil.decode.DataSource;
import coil.decode.Decoder;
import coil.disk.DiskCache;
import coil.fetch.Fetcher;
import coil.intercept.Interceptor;
import coil.intercept.RealInterceptorChain;
import coil.memory.MemoryCache;
import coil.request.Parameters;
import coil.request.Tags;
import coil.request.ViewTargetRequestManager;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.Closeable;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Deferred;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\u009a\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\u001a\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0000\u001a\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u0006*\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0000\u001a\u000e\u00108\u001a\u000205*\u0004\u0018\u000105H\u0000\u001a\u000e\u00108\u001a\u000209*\u0004\u0018\u000109H\u0000\u001a\u000e\u00108\u001a\u00020:*\u0004\u0018\u00010:H\u0000\u001a\b\u0010;\u001a\u00020\u0012H\u0000\u001a\u001f\u0010@\u001a\u0004\u0018\u0001HA\"\u0004\b\u0000\u0010A*\b\u0012\u0004\u0012\u0002HA0BH\u0000¢\u0006\u0002\u0010C\u001a\u0019\u0010D\u001a\u0004\u0018\u00010E*\u00020F2\b\u0010G\u001a\u0004\u0018\u00010HH\u0080\n\u001a+\u0010N\u001a\u00020O*\u00020O2\u001c\u0010P\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030R\u0012\b\u0012\u0006\u0012\u0002\b\u00030S\u0018\u00010QH\u0080\b\u001a\u0017\u0010N\u001a\u00020O*\u00020O2\b\u0010T\u001a\u0004\u0018\u00010UH\u0080\b\u001a\u0014\u0010V\u001a\u00020\u000b*\u00020\u00062\u0006\u0010W\u001a\u00020\u000bH\u0000\u001a\f\u0010X\u001a\u00020\u0015*\u00020YH\u0000\u001a\f\u0010e\u001a\u00020\u0012*\u00020\u000bH\u0000\u001a#\u0010f\u001a\u00020\u000b*\u00020g2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000b0iH\u0080\b\u001a#\u0010j\u001a\u00020\u000b*\u00020g2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000b0iH\u0080\b\u001a\u0014\u0010k\u001a\u00020\u000b*\u00020l2\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001a\b\u0010m\u001a\u00020nH\u0000\u001a\u0010\u0010p\u001a\u00020\u00122\u0006\u0010q\u001a\u00020 H\u0000\u001a\u0014\u0010r\u001a\u00020s*\u00020s2\u0006\u0010t\u001a\u00020\u0006H\u0000\u001a\f\u0010u\u001a\u00020v*\u00020wH\u0000\u001a\u0010\u0010{\u001a\u00020y2\u0006\u0010|\u001a\u00020KH\u0000\u001a\u0018\u0010~\u001a\u00020\u000b2\u0006\u0010|\u001a\u00020K2\u0006\u0010\u007f\u001a\u00020yH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0018\u0010\n\u001a\u00020\u000b*\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0018\u0010\u000f\u001a\u00020\u000b*\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\"\u0018\u0010\u0011\u001a\u00020\u0012*\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013\"\u0018\u0010\u0017\u001a\u00020\u0018*\u00020\u00198@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u0006*\u00020 8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\"\u0018\u0010#\u001a\u00020\u000b*\u00020$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&\"\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+\"\u0014\u0010-\u001a\u00020)X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/\"\u0016\u00100\u001a\u0004\u0018\u000101X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103\"\u0014\u00104\u001a\u000205X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107\"\u0019\u0010<\u001a\u00020\u000b*\u00020=8À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?\"\u0018\u0010I\u001a\u00020J*\u00020K8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bL\u0010M\"\u000e\u0010Z\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010[\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\\\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010]\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010^\u001a\u00020\u0012*\u00020_8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b^\u0010`\"\u0018\u0010a\u001a\u00020b*\u00020_8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bc\u0010d\"\u000e\u0010o\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010x\u001a\u00020yX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010z\u001a\u00020yX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010}\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0080\u0001"}, d2 = {"requestManager", "Lcoil/request/ViewTargetRequestManager;", "Landroid/view/View;", "getRequestManager", "(Landroid/view/View;)Lcoil/request/ViewTargetRequestManager;", "emoji", "", "Lcoil/decode/DataSource;", "getEmoji", "(Lcoil/decode/DataSource;)Ljava/lang/String;", "width", "", "Landroid/graphics/drawable/Drawable;", "getWidth", "(Landroid/graphics/drawable/Drawable;)I", "height", "getHeight", "isVector", "", "(Landroid/graphics/drawable/Drawable;)Z", "closeQuietly", "", "Ljava/io/Closeable;", "scale", "Lcoil/size/Scale;", "Landroid/widget/ImageView;", "getScale", "(Landroid/widget/ImageView;)Lcoil/size/Scale;", "getMimeTypeFromUrl", "Landroid/webkit/MimeTypeMap;", ImagesContract.URL, "firstPathSegment", "Landroid/net/Uri;", "getFirstPathSegment", "(Landroid/net/Uri;)Ljava/lang/String;", "nightMode", "Landroid/content/res/Configuration;", "getNightMode", "(Landroid/content/res/Configuration;)I", "VALID_TRANSFORMATION_CONFIGS", "", "Landroid/graphics/Bitmap$Config;", "getVALID_TRANSFORMATION_CONFIGS", "()[Landroid/graphics/Bitmap$Config;", "[Landroid/graphics/Bitmap$Config;", "DEFAULT_BITMAP_CONFIG", "getDEFAULT_BITMAP_CONFIG", "()Landroid/graphics/Bitmap$Config;", "NULL_COLOR_SPACE", "Landroid/graphics/ColorSpace;", "getNULL_COLOR_SPACE", "()Landroid/graphics/ColorSpace;", "EMPTY_HEADERS", "Lokhttp3/Headers;", "getEMPTY_HEADERS", "()Lokhttp3/Headers;", "orEmpty", "Lcoil/request/Tags;", "Lcoil/request/Parameters;", "isMainThread", "identityHashCode", "", "getIdentityHashCode", "(Ljava/lang/Object;)I", "getCompletedOrNull", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/Deferred;", "(Lkotlinx/coroutines/Deferred;)Ljava/lang/Object;", "get", "Lcoil/memory/MemoryCache$Value;", "Lcoil/memory/MemoryCache;", "key", "Lcoil/memory/MemoryCache$Key;", "safeCacheDir", "Ljava/io/File;", "Landroid/content/Context;", "getSafeCacheDir", "(Landroid/content/Context;)Ljava/io/File;", "addFirst", "Lcoil/ComponentRegistry$Builder;", "pair", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher$Factory;", "Ljava/lang/Class;", "factory", "Lcoil/decode/Decoder$Factory;", "toNonNegativeInt", "defaultValue", "abortQuietly", "Lcoil/disk/DiskCache$Editor;", "MIME_TYPE_JPEG", "MIME_TYPE_WEBP", "MIME_TYPE_HEIC", "MIME_TYPE_HEIF", "isPlaceholderCached", "Lcoil/intercept/Interceptor$Chain;", "(Lcoil/intercept/Interceptor$Chain;)Z", "eventListener", "Lcoil/EventListener;", "getEventListener", "(Lcoil/intercept/Interceptor$Chain;)Lcoil/EventListener;", "isMinOrMax", "widthPx", "Lcoil/size/Size;", "original", "Lkotlin/Function0;", "heightPx", "toPx", "Lcoil/size/Dimension;", "unsupported", "", "ASSET_FILE_PATH_ROOT", "isAssetUri", "uri", "addUnsafeNonAscii", "Lokhttp3/Headers$Builder;", "line", "requireBody", "Lokhttp3/ResponseBody;", "Lokhttp3/Response;", "STANDARD_MEMORY_MULTIPLIER", "", "LOW_MEMORY_MULTIPLIER", "defaultMemoryCacheSizePercent", "context", "DEFAULT_MEMORY_CLASS_MEGABYTES", "calculateMemoryCacheSize", "percent", "coil-base_release"}, k = 2, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: coil.util.-Utils, reason: invalid class name */
/* loaded from: classes5.dex */
public final class Utils {
    public static final String ASSET_FILE_PATH_ROOT = "android_asset";
    private static final Bitmap.Config DEFAULT_BITMAP_CONFIG;
    private static final int DEFAULT_MEMORY_CLASS_MEGABYTES = 256;
    private static final Headers EMPTY_HEADERS;
    private static final double LOW_MEMORY_MULTIPLIER = 0.15d;
    public static final String MIME_TYPE_HEIC = "image/heic";
    public static final String MIME_TYPE_HEIF = "image/heif";
    public static final String MIME_TYPE_JPEG = "image/jpeg";
    public static final String MIME_TYPE_WEBP = "image/webp";
    private static final ColorSpace NULL_COLOR_SPACE = null;
    private static final double STANDARD_MEMORY_MULTIPLIER = 0.2d;
    private static final Bitmap.Config[] VALID_TRANSFORMATION_CONFIGS;

    /* compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* renamed from: coil.util.-Utils$WhenMappings */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[DataSource.values().length];
            try {
                iArr[DataSource.MEMORY_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DataSource.MEMORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DataSource.DISK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DataSource.NETWORK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            try {
                iArr2[ImageView.ScaleType.FIT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Scale.values().length];
            try {
                iArr3[Scale.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[Scale.FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final boolean isMinOrMax(int i) {
        return i == Integer.MIN_VALUE || i == Integer.MAX_VALUE;
    }

    public static final ViewTargetRequestManager getRequestManager(View view) {
        ViewTargetRequestManager viewTargetRequestManager;
        Object tag = view.getTag(R.id.coil_request_manager);
        ViewTargetRequestManager viewTargetRequestManager2 = tag instanceof ViewTargetRequestManager ? (ViewTargetRequestManager) tag : null;
        if (viewTargetRequestManager2 != null) {
            return viewTargetRequestManager2;
        }
        synchronized (view) {
            Object tag2 = view.getTag(R.id.coil_request_manager);
            viewTargetRequestManager = tag2 instanceof ViewTargetRequestManager ? (ViewTargetRequestManager) tag2 : null;
            if (viewTargetRequestManager == null) {
                viewTargetRequestManager = new ViewTargetRequestManager(view);
                view.addOnAttachStateChangeListener(viewTargetRequestManager);
                view.setTag(R.id.coil_request_manager, viewTargetRequestManager);
            }
        }
        return viewTargetRequestManager;
    }

    public static final String getEmoji(DataSource dataSource) {
        int i = WhenMappings.$EnumSwitchMapping$0[dataSource.ordinal()];
        if (i == 1 || i == 2) {
            return Emoji.BRAIN;
        }
        if (i == 3) {
            return Emoji.FLOPPY;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return Emoji.CLOUD;
    }

    public static final int getWidth(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicWidth() : bitmap.getWidth();
    }

    public static final int getHeight(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicHeight() : bitmap.getHeight();
    }

    public static final boolean isVector(Drawable drawable) {
        return (drawable instanceof VectorDrawable) || (drawable instanceof VectorDrawableCompat);
    }

    public static final void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final Scale getScale(ImageView imageView) {
        ImageView.ScaleType scaleType = imageView.getScaleType();
        int i = scaleType == null ? -1 : WhenMappings.$EnumSwitchMapping$1[scaleType.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return Scale.FIT;
        }
        return Scale.FILL;
    }

    public static final String getMimeTypeFromUrl(MimeTypeMap mimeTypeMap, String str) {
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return null;
        }
        return mimeTypeMap.getMimeTypeFromExtension(StringsKt.substringAfterLast(StringsKt.substringAfterLast$default(StringsKt.substringBeforeLast$default(StringsKt.substringBeforeLast$default(str, '#', (String) null, 2, (Object) null), '?', (String) null, 2, (Object) null), '/', (String) null, 2, (Object) null), '.', ""));
    }

    public static final String getFirstPathSegment(Uri uri) {
        return (String) CollectionsKt.firstOrNull((List) uri.getPathSegments());
    }

    public static final int getNightMode(Configuration configuration) {
        return configuration.uiMode & 48;
    }

    static {
        Bitmap.Config[] configArr;
        Bitmap.Config config;
        Bitmap.Config config2;
        if (Build.VERSION.SDK_INT >= 26) {
            config2 = Bitmap.Config.RGBA_F16;
            configArr = new Bitmap.Config[]{Bitmap.Config.ARGB_8888, config2};
        } else {
            configArr = new Bitmap.Config[]{Bitmap.Config.ARGB_8888};
        }
        VALID_TRANSFORMATION_CONFIGS = configArr;
        if (Build.VERSION.SDK_INT >= 26) {
            config = Bitmap.Config.HARDWARE;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        DEFAULT_BITMAP_CONFIG = config;
        EMPTY_HEADERS = new Headers.Builder().build();
    }

    public static final Bitmap.Config[] getVALID_TRANSFORMATION_CONFIGS() {
        return VALID_TRANSFORMATION_CONFIGS;
    }

    public static final Bitmap.Config getDEFAULT_BITMAP_CONFIG() {
        return DEFAULT_BITMAP_CONFIG;
    }

    public static final ColorSpace getNULL_COLOR_SPACE() {
        return NULL_COLOR_SPACE;
    }

    public static final Headers getEMPTY_HEADERS() {
        return EMPTY_HEADERS;
    }

    public static final Headers orEmpty(Headers headers) {
        return headers == null ? EMPTY_HEADERS : headers;
    }

    public static final Tags orEmpty(Tags tags) {
        return tags == null ? Tags.EMPTY : tags;
    }

    public static final Parameters orEmpty(Parameters parameters) {
        return parameters == null ? Parameters.EMPTY : parameters;
    }

    public static final boolean isMainThread() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    public static final int getIdentityHashCode(Object obj) {
        return System.identityHashCode(obj);
    }

    public static final <T> T getCompletedOrNull(Deferred<? extends T> deferred) {
        try {
            return deferred.getCompleted();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final MemoryCache.Value get(MemoryCache memoryCache, MemoryCache.Key key) {
        if (key != null) {
            return memoryCache.get(key);
        }
        return null;
    }

    public static final File getSafeCacheDir(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            throw new IllegalStateException("cacheDir == null".toString());
        }
        cacheDir.mkdirs();
        return cacheDir;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ComponentRegistry.Builder addFirst(ComponentRegistry.Builder builder, Pair<? extends Fetcher.Factory<?>, ? extends Class<?>> pair) {
        if (pair != 0) {
            builder.getFetcherFactories$coil_base_release().add(0, pair);
        }
        return builder;
    }

    public static final ComponentRegistry.Builder addFirst(ComponentRegistry.Builder builder, Decoder.Factory factory) {
        if (factory != null) {
            builder.getDecoderFactories$coil_base_release().add(0, factory);
        }
        return builder;
    }

    public static final int toNonNegativeInt(String str, int i) {
        Long longOrNull = StringsKt.toLongOrNull(str);
        if (longOrNull == null) {
            return i;
        }
        long longValue = longOrNull.longValue();
        if (longValue > SieveCacheKt.NodeLinkMask) {
            return Integer.MAX_VALUE;
        }
        if (longValue < 0) {
            return 0;
        }
        return (int) longValue;
    }

    public static final void abortQuietly(DiskCache.Editor editor) {
        try {
            editor.abort();
        } catch (Exception unused) {
        }
    }

    public static final boolean isPlaceholderCached(Interceptor.Chain chain) {
        return (chain instanceof RealInterceptorChain) && ((RealInterceptorChain) chain).getIsPlaceholderCached();
    }

    public static final EventListener getEventListener(Interceptor.Chain chain) {
        return chain instanceof RealInterceptorChain ? ((RealInterceptorChain) chain).getEventListener() : EventListener.NONE;
    }

    public static final int widthPx(Size size, Scale scale, Function0<Integer> function0) {
        return Sizes.isOriginal(size) ? function0.invoke().intValue() : toPx(size.getWidth(), scale);
    }

    public static final int heightPx(Size size, Scale scale, Function0<Integer> function0) {
        return Sizes.isOriginal(size) ? function0.invoke().intValue() : toPx(size.getHeight(), scale);
    }

    public static final Void unsupported() {
        throw new IllegalStateException("Unsupported".toString());
    }

    public static final boolean isAssetUri(Uri uri) {
        return Intrinsics.areEqual(uri.getScheme(), "file") && Intrinsics.areEqual(getFirstPathSegment(uri), ASSET_FILE_PATH_ROOT);
    }

    public static final Headers.Builder addUnsafeNonAscii(Headers.Builder builder, String str) {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, AbstractJsonLexerKt.COLON, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            throw new IllegalArgumentException(("Unexpected header: " + str).toString());
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        String obj = StringsKt.trim((CharSequence) substring).toString();
        String substring2 = str.substring(indexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        builder.addUnsafeNonAscii(obj, substring2);
        return builder;
    }

    public static final ResponseBody requireBody(Response response) {
        ResponseBody body = response.body();
        if (body != null) {
            return body;
        }
        throw new IllegalStateException("response body == null".toString());
    }

    public static final int toPx(Dimension dimension, Scale scale) {
        if (dimension instanceof Dimension.Pixels) {
            return ((Dimension.Pixels) dimension).px;
        }
        int i = WhenMappings.$EnumSwitchMapping$2[scale.ordinal()];
        if (i == 1) {
            return Integer.MIN_VALUE;
        }
        if (i == 2) {
            return Integer.MAX_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final double defaultMemoryCacheSizePercent(Context context) {
        try {
            Object systemService = ContextCompat.getSystemService(context, ActivityManager.class);
            Intrinsics.checkNotNull(systemService);
            return ((ActivityManager) systemService).isLowRamDevice() ? LOW_MEMORY_MULTIPLIER : STANDARD_MEMORY_MULTIPLIER;
        } catch (Exception unused) {
            return STANDARD_MEMORY_MULTIPLIER;
        }
    }

    public static final int calculateMemoryCacheSize(Context context, double d) {
        int i;
        try {
            Object systemService = ContextCompat.getSystemService(context, ActivityManager.class);
            Intrinsics.checkNotNull(systemService);
            ActivityManager activityManager = (ActivityManager) systemService;
            i = (context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
        } catch (Exception unused) {
            i = 256;
        }
        return (int) (d * i * 1024.0d * 1024.0d);
    }
}
