package coil.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import coil.decode.ExifOrientationPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ImageLoaderOptions.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcoil/util/ImageLoaderOptions;", "", "addLastModifiedToFileCacheKey", "", "networkObserverEnabled", "respectCacheHeaders", "bitmapFactoryMaxParallelism", "", "bitmapFactoryExifOrientationPolicy", "Lcoil/decode/ExifOrientationPolicy;", "<init>", "(ZZZILcoil/decode/ExifOrientationPolicy;)V", "getAddLastModifiedToFileCacheKey", "()Z", "getNetworkObserverEnabled", "getRespectCacheHeaders", "getBitmapFactoryMaxParallelism", "()I", "getBitmapFactoryExifOrientationPolicy", "()Lcoil/decode/ExifOrientationPolicy;", "copy", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class ImageLoaderOptions {
    private final boolean addLastModifiedToFileCacheKey;
    private final ExifOrientationPolicy bitmapFactoryExifOrientationPolicy;
    private final int bitmapFactoryMaxParallelism;
    private final boolean networkObserverEnabled;
    private final boolean respectCacheHeaders;

    public ImageLoaderOptions() {
        this(false, false, false, 0, null, 31, null);
    }

    public ImageLoaderOptions(boolean z, boolean z2, boolean z3, int i, ExifOrientationPolicy exifOrientationPolicy) {
        this.addLastModifiedToFileCacheKey = z;
        this.networkObserverEnabled = z2;
        this.respectCacheHeaders = z3;
        this.bitmapFactoryMaxParallelism = i;
        this.bitmapFactoryExifOrientationPolicy = exifOrientationPolicy;
    }

    public final boolean getAddLastModifiedToFileCacheKey() {
        return this.addLastModifiedToFileCacheKey;
    }

    public final boolean getNetworkObserverEnabled() {
        return this.networkObserverEnabled;
    }

    public final boolean getRespectCacheHeaders() {
        return this.respectCacheHeaders;
    }

    public final int getBitmapFactoryMaxParallelism() {
        return this.bitmapFactoryMaxParallelism;
    }

    public /* synthetic */ ImageLoaderOptions(boolean z, boolean z2, boolean z3, int i, ExifOrientationPolicy exifOrientationPolicy, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? true : z2, (i2 & 4) != 0 ? true : z3, (i2 & 8) != 0 ? 4 : i, (i2 & 16) != 0 ? ExifOrientationPolicy.RESPECT_PERFORMANCE : exifOrientationPolicy);
    }

    public final ExifOrientationPolicy getBitmapFactoryExifOrientationPolicy() {
        return this.bitmapFactoryExifOrientationPolicy;
    }

    public static /* synthetic */ ImageLoaderOptions copy$default(ImageLoaderOptions imageLoaderOptions, boolean z, boolean z2, boolean z3, int i, ExifOrientationPolicy exifOrientationPolicy, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = imageLoaderOptions.addLastModifiedToFileCacheKey;
        }
        if ((i2 & 2) != 0) {
            z2 = imageLoaderOptions.networkObserverEnabled;
        }
        if ((i2 & 4) != 0) {
            z3 = imageLoaderOptions.respectCacheHeaders;
        }
        if ((i2 & 8) != 0) {
            i = imageLoaderOptions.bitmapFactoryMaxParallelism;
        }
        if ((i2 & 16) != 0) {
            exifOrientationPolicy = imageLoaderOptions.bitmapFactoryExifOrientationPolicy;
        }
        ExifOrientationPolicy exifOrientationPolicy2 = exifOrientationPolicy;
        boolean z4 = z3;
        return imageLoaderOptions.copy(z, z2, z4, i, exifOrientationPolicy2);
    }

    public final ImageLoaderOptions copy(boolean addLastModifiedToFileCacheKey, boolean networkObserverEnabled, boolean respectCacheHeaders, int bitmapFactoryMaxParallelism, ExifOrientationPolicy bitmapFactoryExifOrientationPolicy) {
        return new ImageLoaderOptions(addLastModifiedToFileCacheKey, networkObserverEnabled, respectCacheHeaders, bitmapFactoryMaxParallelism, bitmapFactoryExifOrientationPolicy);
    }
}
