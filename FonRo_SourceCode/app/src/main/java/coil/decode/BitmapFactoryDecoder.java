package coil.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.ImageLoader;
import coil.decode.Decoder;
import coil.decode.ImageSource;
import coil.fetch.SourceResult;
import coil.request.Options;
import coil.size.Size;
import coil.size.Sizes;
import coil.util.Bitmaps;
import coil.util.Utils;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: BitmapFactoryDecoder.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0003\u0017\u0018\u0019B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u0019\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\fB#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0011H\u0002J\u0014\u0010\u0012\u001a\u00020\u0013*\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010\u0016\u001a\u00020\u0013*\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder;", "Lcoil/decode/Decoder;", FirebaseAnalytics.Param.SOURCE, "Lcoil/decode/ImageSource;", "options", "Lcoil/request/Options;", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "exifOrientationPolicy", "Lcoil/decode/ExifOrientationPolicy;", "<init>", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Lkotlinx/coroutines/sync/Semaphore;Lcoil/decode/ExifOrientationPolicy;)V", "(Lcoil/decode/ImageSource;Lcoil/request/Options;)V", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Lkotlinx/coroutines/sync/Semaphore;)V", "decode", "Lcoil/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/graphics/BitmapFactory$Options;", "configureConfig", "", "exifData", "Lcoil/decode/ExifData;", "configureScale", "Factory", "ExceptionCatchingSource", "Companion", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class BitmapFactoryDecoder implements Decoder {
    public static final int DEFAULT_MAX_PARALLELISM = 4;
    private final ExifOrientationPolicy exifOrientationPolicy;
    private final Options options;
    private final Semaphore parallelismLock;
    private final ImageSource source;

    public BitmapFactoryDecoder(ImageSource imageSource, Options options, Semaphore semaphore, ExifOrientationPolicy exifOrientationPolicy) {
        this.source = imageSource;
        this.options = options;
        this.parallelismLock = semaphore;
        this.exifOrientationPolicy = exifOrientationPolicy;
    }

    public /* synthetic */ BitmapFactoryDecoder(ImageSource imageSource, Options options, Semaphore semaphore, ExifOrientationPolicy exifOrientationPolicy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options, (i & 4) != 0 ? SemaphoreKt.Semaphore$default(Integer.MAX_VALUE, 0, 2, null) : semaphore, (i & 8) != 0 ? ExifOrientationPolicy.RESPECT_PERFORMANCE : exifOrientationPolicy);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    public /* synthetic */ BitmapFactoryDecoder(ImageSource imageSource, Options options) {
        this(imageSource, options, null, null, 12, null);
    }

    public /* synthetic */ BitmapFactoryDecoder(ImageSource imageSource, Options options, Semaphore semaphore, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options, (i & 4) != 0 ? SemaphoreKt.Semaphore$default(Integer.MAX_VALUE, 0, 2, null) : semaphore);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    public /* synthetic */ BitmapFactoryDecoder(ImageSource imageSource, Options options, Semaphore semaphore) {
        this(imageSource, options, semaphore, null, 8, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0058, code lost:
    
        if (r7.acquire(r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // coil.decode.Decoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object decode(kotlin.coroutines.Continuation<? super coil.decode.DecodeResult> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof coil.decode.BitmapFactoryDecoder$decode$1
            if (r0 == 0) goto L14
            r0 = r7
            coil.decode.BitmapFactoryDecoder$decode$1 r0 = (coil.decode.BitmapFactoryDecoder$decode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            coil.decode.BitmapFactoryDecoder$decode$1 r0 = new coil.decode.BitmapFactoryDecoder$decode$1
            r0.<init>(r6, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.sync.Semaphore r6 = (kotlinx.coroutines.sync.Semaphore) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L31
            goto L71
        L31:
            r7 = move-exception
            goto L7b
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.sync.Semaphore r6 = (kotlinx.coroutines.sync.Semaphore) r6
            java.lang.Object r2 = r0.L$0
            coil.decode.BitmapFactoryDecoder r2 = (coil.decode.BitmapFactoryDecoder) r2
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r6
            r6 = r2
            goto L5b
        L49:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.sync.Semaphore r7 = r6.parallelismLock
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r2 = r7.acquire(r0)
            if (r2 != r1) goto L5b
            goto L6d
        L5b:
            coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2 r2 = new coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2     // Catch: java.lang.Throwable -> L77
            r2.<init>()     // Catch: java.lang.Throwable -> L77
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L77
            r6 = 0
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L77
            r0.label = r3     // Catch: java.lang.Throwable -> L77
            java.lang.Object r6 = kotlinx.coroutines.InterruptibleKt.runInterruptible$default(r6, r2, r0, r4, r6)     // Catch: java.lang.Throwable -> L77
            if (r6 != r1) goto L6e
        L6d:
            return r1
        L6e:
            r5 = r7
            r7 = r6
            r6 = r5
        L71:
            coil.decode.DecodeResult r7 = (coil.decode.DecodeResult) r7     // Catch: java.lang.Throwable -> L31
            r6.release()
            return r7
        L77:
            r6 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L7b:
            r6.release()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.BitmapFactoryDecoder.decode(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DecodeResult decode(BitmapFactory.Options options) {
        ExceptionCatchingSource exceptionCatchingSource = new ExceptionCatchingSource(this.source.source());
        BufferedSource buffer = Okio.buffer(exceptionCatchingSource);
        boolean z = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(buffer.peek().inputStream(), null, options);
        Exception exception = exceptionCatchingSource.getException();
        if (exception != null) {
            throw exception;
        }
        options.inJustDecodeBounds = false;
        ExifData exifData = ExifUtils.INSTANCE.getExifData(options.outMimeType, buffer, this.exifOrientationPolicy);
        Exception exception2 = exceptionCatchingSource.getException();
        if (exception2 != null) {
            throw exception2;
        }
        options.inMutable = false;
        if (Build.VERSION.SDK_INT >= 26 && this.options.getColorSpace() != null) {
            options.inPreferredColorSpace = this.options.getColorSpace();
        }
        options.inPremultiplied = this.options.getPremultipliedAlpha();
        configureConfig(options, exifData);
        configureScale(options, exifData);
        BufferedSource bufferedSource = buffer;
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(bufferedSource.inputStream(), null, options);
            CloseableKt.closeFinally(bufferedSource, null);
            Exception exception3 = exceptionCatchingSource.getException();
            if (exception3 != null) {
                throw exception3;
            }
            if (decodeStream == null) {
                throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.".toString());
            }
            decodeStream.setDensity(this.options.getContext().getResources().getDisplayMetrics().densityDpi);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.options.getContext().getResources(), ExifUtils.INSTANCE.reverseTransformations(decodeStream, exifData));
            if (options.inSampleSize <= 1 && !options.inScaled) {
                z = false;
            }
            return new DecodeResult(bitmapDrawable, z);
        } finally {
        }
    }

    private final void configureConfig(BitmapFactory.Options options, ExifData exifData) {
        Bitmap.Config config;
        Bitmap.Config config2;
        Bitmap.Config config3;
        Bitmap.Config config4 = this.options.getConfig();
        if (exifData.getIsFlipped() || ExifUtilsKt.isRotated(exifData)) {
            config4 = Bitmaps.toSoftware(config4);
        }
        if (this.options.getAllowRgb565() && config4 == Bitmap.Config.ARGB_8888 && Intrinsics.areEqual(options.outMimeType, Utils.MIME_TYPE_JPEG)) {
            config4 = Bitmap.Config.RGB_565;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            config = options.outConfig;
            config2 = Bitmap.Config.RGBA_F16;
            if (config == config2) {
                config3 = Bitmap.Config.HARDWARE;
                if (config4 != config3) {
                    config4 = Bitmap.Config.RGBA_F16;
                }
            }
        }
        options.inPreferredConfig = config4;
    }

    private final void configureScale(BitmapFactory.Options options, ExifData exifData) {
        ImageSource.Metadata metadata = this.source.getMetadata();
        if ((metadata instanceof ResourceMetadata) && Sizes.isOriginal(this.options.getSize())) {
            options.inSampleSize = 1;
            options.inScaled = true;
            options.inDensity = ((ResourceMetadata) metadata).getDensity();
            options.inTargetDensity = this.options.getContext().getResources().getDisplayMetrics().densityDpi;
            return;
        }
        if (options.outWidth <= 0 || options.outHeight <= 0) {
            options.inSampleSize = 1;
            options.inScaled = false;
            return;
        }
        int i = ExifUtilsKt.isSwapped(exifData) ? options.outHeight : options.outWidth;
        int i2 = ExifUtilsKt.isSwapped(exifData) ? options.outWidth : options.outHeight;
        Size size = this.options.getSize();
        int px = Sizes.isOriginal(size) ? i : Utils.toPx(size.getWidth(), this.options.getScale());
        Size size2 = this.options.getSize();
        int px2 = Sizes.isOriginal(size2) ? i2 : Utils.toPx(size2.getHeight(), this.options.getScale());
        options.inSampleSize = DecodeUtils.calculateInSampleSize(i, i2, px, px2, this.options.getScale());
        double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(i / options.inSampleSize, i2 / options.inSampleSize, px, px2, this.options.getScale());
        if (this.options.getAllowInexactSize()) {
            computeSizeMultiplier = RangesKt.coerceAtMost(computeSizeMultiplier, 1.0d);
        }
        options.inScaled = !(computeSizeMultiplier == 1.0d);
        if (options.inScaled) {
            if (computeSizeMultiplier > 1.0d) {
                options.inDensity = MathKt.roundToInt(2.147483647E9d / computeSizeMultiplier);
                options.inTargetDensity = Integer.MAX_VALUE;
            } else {
                options.inDensity = Integer.MAX_VALUE;
                options.inTargetDensity = MathKt.roundToInt(2.147483647E9d * computeSizeMultiplier);
            }
        }
    }

    /* compiled from: BitmapFactoryDecoder.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0017¢\u0006\u0004\b\u0006\u0010\bB\u0013\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\tJ \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$Factory;", "Lcoil/decode/Decoder$Factory;", "maxParallelism", "", "exifOrientationPolicy", "Lcoil/decode/ExifOrientationPolicy;", "<init>", "(ILcoil/decode/ExifOrientationPolicy;)V", "()V", "(I)V", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "create", "Lcoil/decode/Decoder;", "result", "Lcoil/fetch/SourceResult;", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "equals", "", WriteOffReason.OTHER, "", "hashCode", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Factory implements Decoder.Factory {
        private final ExifOrientationPolicy exifOrientationPolicy;
        private final Semaphore parallelismLock;

        public Factory(int i, ExifOrientationPolicy exifOrientationPolicy) {
            this.exifOrientationPolicy = exifOrientationPolicy;
            this.parallelismLock = SemaphoreKt.Semaphore$default(i, 0, 2, null);
        }

        public /* synthetic */ Factory(int i, ExifOrientationPolicy exifOrientationPolicy, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 4 : i, (i2 & 2) != 0 ? ExifOrientationPolicy.RESPECT_PERFORMANCE : exifOrientationPolicy);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Factory() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ Factory(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 4 : i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
        public /* synthetic */ Factory(int i) {
            this(i, null, 2, 0 == true ? 1 : 0);
        }

        @Override // coil.decode.Decoder.Factory
        public Decoder create(SourceResult result, Options options, ImageLoader imageLoader) {
            return new BitmapFactoryDecoder(result.getSource(), options, this.parallelismLock, this.exifOrientationPolicy);
        }

        public boolean equals(Object other) {
            return other instanceof Factory;
        }

        public int hashCode() {
            return getClass().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BitmapFactoryDecoder.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R0\u0010\t\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\u00072\u000e\u0010\u0006\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\u0007@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$ExceptionCatchingSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "<init>", "(Lokio/Source;)V", "value", "Lkotlin/Exception;", "Ljava/lang/Exception;", "exception", "getException", "()Ljava/lang/Exception;", "Ljava/lang/Exception;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class ExceptionCatchingSource extends ForwardingSource {
        private Exception exception;

        public ExceptionCatchingSource(Source source) {
            super(source);
        }

        public final Exception getException() {
            return this.exception;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer sink, long byteCount) {
            try {
                return super.read(sink, byteCount);
            } catch (Exception e) {
                this.exception = e;
                throw e;
            }
        }
    }
}
