package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ImageWriter;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.OperationCanceledException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class ImageAnalysisAbstractAnalyzer implements ImageReaderProxy.OnImageAvailableListener {
    private static final String TAG = "ImageAnalysisAnalyzer";
    private volatile boolean mOnePixelShiftEnabled;
    private volatile boolean mOutputImageRotationEnabled;
    private volatile int mPrevBufferRotationDegrees;
    private SafeCloseImageReaderProxy mProcessedImageReaderProxy;
    private ImageWriter mProcessedImageWriter;
    ByteBuffer mRGBConvertedBuffer;
    private volatile int mRelativeRotation;
    private ImageAnalysis.Analyzer mSubscribedAnalyzer;
    ByteBuffer mURotatedBuffer;
    private Executor mUserExecutor;
    ByteBuffer mVRotatedBuffer;
    ByteBuffer mYRotatedBuffer;
    private volatile int mOutputImageFormat = 1;
    private Rect mOriginalViewPortCropRect = new Rect();
    private Rect mUpdatedViewPortCropRect = new Rect();
    private Matrix mOriginalSensorToBufferTransformMatrix = new Matrix();
    private Matrix mUpdatedSensorToBufferTransformMatrix = new Matrix();
    private final Object mAnalyzerLock = new Object();
    protected boolean mIsAttached = true;

    abstract ImageProxy acquireImage(ImageReaderProxy imageReaderProxy);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void clearCache();

    abstract void onValidImageAvailable(ImageProxy imageProxy);

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy acquireImage = acquireImage(imageReaderProxy);
            if (acquireImage != null) {
                onValidImageAvailable(acquireImage);
            }
        } catch (IllegalStateException e) {
            Logger.e(TAG, "Failed to acquire image.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.common.util.concurrent.ListenableFuture<java.lang.Void> analyzeImage(final androidx.camera.core.ImageProxy r17) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageAnalysisAbstractAnalyzer.analyzeImage(androidx.camera.core.ImageProxy):com.google.common.util.concurrent.ListenableFuture");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$analyzeImage$1$androidx-camera-core-ImageAnalysisAbstractAnalyzer, reason: not valid java name */
    public /* synthetic */ Object m154x9959ff20(Executor executor, final ImageProxy imageProxy, final Matrix matrix, final ImageProxy imageProxy2, final Rect rect, final ImageAnalysis.Analyzer analyzer, final CallbackToFutureAdapter.Completer completer) throws Exception {
        executor.execute(new Runnable() { // from class: androidx.camera.core.ImageAnalysisAbstractAnalyzer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ImageAnalysisAbstractAnalyzer.this.m153x6b8164c1(imageProxy, matrix, imageProxy2, rect, analyzer, completer);
            }
        });
        return "analyzeImage";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$analyzeImage$0$androidx-camera-core-ImageAnalysisAbstractAnalyzer, reason: not valid java name */
    public /* synthetic */ void m153x6b8164c1(ImageProxy imageProxy, Matrix matrix, ImageProxy imageProxy2, Rect rect, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.Completer completer) {
        if (this.mIsAttached) {
            SettableImageProxy settableImageProxy = new SettableImageProxy(imageProxy2, ImmutableImageInfo.create(imageProxy.getImageInfo().getTagBundle(), imageProxy.getImageInfo().getTimestamp(), this.mOutputImageRotationEnabled ? 0 : this.mRelativeRotation, matrix));
            if (!rect.isEmpty()) {
                settableImageProxy.setCropRect(rect);
            }
            analyzer.analyze(settableImageProxy);
            completer.set(null);
            return;
        }
        completer.setException(new OperationCanceledException("ImageAnalysis is detached"));
    }

    private static SafeCloseImageReaderProxy createImageReaderProxy(int i, int i2, int i3, int i4, int i5) {
        boolean z = i3 == 90 || i3 == 270;
        int i6 = z ? i2 : i;
        if (!z) {
            i = i2;
        }
        return new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader(i6, i, i4, i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRelativeRotation(int i) {
        this.mRelativeRotation = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOutputImageRotationEnabled(boolean z) {
        this.mOutputImageRotationEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOutputImageFormat(int i) {
        this.mOutputImageFormat = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnePixelShiftEnabled(boolean z) {
        this.mOnePixelShiftEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setViewPortCropRect(Rect rect) {
        synchronized (this.mAnalyzerLock) {
            this.mOriginalViewPortCropRect = rect;
            this.mUpdatedViewPortCropRect = new Rect(this.mOriginalViewPortCropRect);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSensorToBufferTransformMatrix(Matrix matrix) {
        synchronized (this.mAnalyzerLock) {
            this.mOriginalSensorToBufferTransformMatrix = matrix;
            this.mUpdatedSensorToBufferTransformMatrix = new Matrix(this.mOriginalSensorToBufferTransformMatrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProcessedImageReaderProxy(SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        synchronized (this.mAnalyzerLock) {
            this.mProcessedImageReaderProxy = safeCloseImageReaderProxy;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAnalyzer(Executor executor, ImageAnalysis.Analyzer analyzer) {
        if (analyzer == null) {
            clearCache();
        }
        synchronized (this.mAnalyzerLock) {
            this.mSubscribedAnalyzer = analyzer;
            this.mUserExecutor = executor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void attach() {
        this.mIsAttached = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void detach() {
        this.mIsAttached = false;
        clearCache();
    }

    private void createHelperBuffer(ImageProxy imageProxy) {
        if (this.mOutputImageFormat == 1) {
            ByteBuffer byteBuffer = this.mYRotatedBuffer;
            if (byteBuffer == null) {
                byteBuffer = ByteBuffer.allocateDirect(imageProxy.getWidth() * imageProxy.getHeight());
                this.mYRotatedBuffer = byteBuffer;
            }
            byteBuffer.position(0);
            ByteBuffer byteBuffer2 = this.mURotatedBuffer;
            if (byteBuffer2 == null) {
                byteBuffer2 = ByteBuffer.allocateDirect((imageProxy.getWidth() * imageProxy.getHeight()) / 4);
                this.mURotatedBuffer = byteBuffer2;
            }
            byteBuffer2.position(0);
            ByteBuffer byteBuffer3 = this.mVRotatedBuffer;
            if (byteBuffer3 == null) {
                byteBuffer3 = ByteBuffer.allocateDirect((imageProxy.getWidth() * imageProxy.getHeight()) / 4);
                this.mVRotatedBuffer = byteBuffer3;
            }
            byteBuffer3.position(0);
            return;
        }
        if (this.mOutputImageFormat == 2 && this.mRGBConvertedBuffer == null) {
            this.mRGBConvertedBuffer = ByteBuffer.allocateDirect(imageProxy.getWidth() * imageProxy.getHeight() * 4);
        }
    }

    private void recreateImageReaderProxy(ImageProxy imageProxy, int i) {
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mProcessedImageReaderProxy;
        if (safeCloseImageReaderProxy == null) {
            return;
        }
        safeCloseImageReaderProxy.safeClose();
        this.mProcessedImageReaderProxy = createImageReaderProxy(imageProxy.getWidth(), imageProxy.getHeight(), i, this.mProcessedImageReaderProxy.getImageFormat(), this.mProcessedImageReaderProxy.getMaxImages());
        if (this.mOutputImageFormat == 1) {
            ImageWriter imageWriter = this.mProcessedImageWriter;
            if (imageWriter != null) {
                ImageWriterCompat.close(imageWriter);
            }
            this.mProcessedImageWriter = ImageWriterCompat.newInstance(this.mProcessedImageReaderProxy.getSurface(), this.mProcessedImageReaderProxy.getMaxImages());
        }
    }

    private void recalculateTransformMatrixAndCropRect(int i, int i2, int i3, int i4) {
        Matrix additionalTransformMatrixAppliedByProcessor = getAdditionalTransformMatrixAppliedByProcessor(i, i2, i3, i4, this.mRelativeRotation);
        this.mUpdatedViewPortCropRect = getUpdatedCropRect(this.mOriginalViewPortCropRect, additionalTransformMatrixAppliedByProcessor);
        this.mUpdatedSensorToBufferTransformMatrix.setConcat(this.mOriginalSensorToBufferTransformMatrix, additionalTransformMatrixAppliedByProcessor);
    }

    static Rect getUpdatedCropRect(Rect rect, Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    static Matrix getAdditionalTransformMatrixAppliedByProcessor(int i, int i2, int i3, int i4, int i5) {
        Matrix matrix = new Matrix();
        if (i5 > 0) {
            matrix.setRectToRect(new RectF(0.0f, 0.0f, i, i2), TransformUtils.NORMALIZED_RECT, Matrix.ScaleToFit.FILL);
            matrix.postRotate(i5);
            matrix.postConcat(TransformUtils.getNormalizedToBuffer(new RectF(0.0f, 0.0f, i3, i4)));
        }
        return matrix;
    }
}
