package androidx.camera.video;

import android.view.Surface;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.encoder.EncoderFactory;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class VideoEncoderSession {
    private static final String TAG = "VideoEncoderSession";
    private final Executor mExecutor;
    private final Executor mSequentialExecutor;
    private final EncoderFactory mVideoEncoderFactory;
    private Encoder mVideoEncoder = null;
    private Surface mActiveSurface = null;
    private SurfaceRequest mSurfaceRequest = null;
    private Executor mOnSurfaceUpdateExecutor = null;
    private Encoder.SurfaceInput.OnSurfaceUpdateListener mOnSurfaceUpdateListener = null;
    private VideoEncoderState mVideoEncoderState = VideoEncoderState.NOT_INITIALIZED;
    private ListenableFuture<Void> mReleasedFuture = Futures.immediateFailedFuture(new IllegalStateException("Cannot close the encoder before configuring."));
    private CallbackToFutureAdapter.Completer<Void> mReleasedCompleter = null;
    private ListenableFuture<Encoder> mReadyToReleaseFuture = Futures.immediateFailedFuture(new IllegalStateException("Cannot close the encoder before configuring."));
    private CallbackToFutureAdapter.Completer<Encoder> mReadyToReleaseCompleter = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum VideoEncoderState {
        NOT_INITIALIZED,
        INITIALIZING,
        PENDING_RELEASE,
        READY,
        RELEASED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoEncoderSession(EncoderFactory encoderFactory, Executor executor, Executor executor2) {
        this.mExecutor = executor2;
        this.mSequentialExecutor = executor;
        this.mVideoEncoderFactory = encoderFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListenableFuture<Encoder> configure(final SurfaceRequest surfaceRequest, final Timebase timebase, final MediaSpec mediaSpec, final VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy) {
        if (this.mVideoEncoderState.ordinal() == 0) {
            this.mVideoEncoderState = VideoEncoderState.INITIALIZING;
            this.mSurfaceRequest = surfaceRequest;
            Logger.d(TAG, "Create VideoEncoderSession: " + this);
            this.mReleasedFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.VideoEncoderSession$$ExternalSyntheticLambda2
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return VideoEncoderSession.this.m259lambda$configure$0$androidxcameravideoVideoEncoderSession(completer);
                }
            });
            this.mReadyToReleaseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.VideoEncoderSession$$ExternalSyntheticLambda3
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return VideoEncoderSession.this.m260lambda$configure$1$androidxcameravideoVideoEncoderSession(completer);
                }
            });
            ListenableFuture future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.VideoEncoderSession$$ExternalSyntheticLambda4
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return VideoEncoderSession.this.m261lambda$configure$2$androidxcameravideoVideoEncoderSession(surfaceRequest, timebase, videoValidatedEncoderProfilesProxy, mediaSpec, completer);
                }
            });
            Futures.addCallback(future, new FutureCallback<Encoder>() { // from class: androidx.camera.video.VideoEncoderSession.1
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(Encoder encoder) {
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    Logger.w(VideoEncoderSession.TAG, "VideoEncoder configuration failed.", th);
                    VideoEncoderSession.this.terminateNow();
                }
            }, this.mSequentialExecutor);
            return Futures.nonCancellationPropagating(future);
        }
        return Futures.immediateFailedFuture(new IllegalStateException("configure() shouldn't be called in " + this.mVideoEncoderState));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$configure$0$androidx-camera-video-VideoEncoderSession, reason: not valid java name */
    public /* synthetic */ Object m259lambda$configure$0$androidxcameravideoVideoEncoderSession(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mReleasedCompleter = completer;
        return "ReleasedFuture " + this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$configure$1$androidx-camera-video-VideoEncoderSession, reason: not valid java name */
    public /* synthetic */ Object m260lambda$configure$1$androidxcameravideoVideoEncoderSession(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mReadyToReleaseCompleter = completer;
        return "ReadyToReleaseFuture " + this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$configure$2$androidx-camera-video-VideoEncoderSession, reason: not valid java name */
    public /* synthetic */ Object m261lambda$configure$2$androidxcameravideoVideoEncoderSession(SurfaceRequest surfaceRequest, Timebase timebase, VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, MediaSpec mediaSpec, CallbackToFutureAdapter.Completer completer) throws Exception {
        configureVideoEncoderInternal(surfaceRequest, timebase, videoValidatedEncoderProfilesProxy, mediaSpec, completer);
        return "ConfigureVideoEncoderFuture " + this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isConfiguredSurfaceRequest(SurfaceRequest surfaceRequest) {
        int ordinal = this.mVideoEncoderState.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
                        }
                    }
                }
            }
            if (this.mSurfaceRequest == surfaceRequest) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListenableFuture<Encoder> getReadyToReleaseFuture() {
        return Futures.nonCancellationPropagating(this.mReadyToReleaseFuture);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListenableFuture<Void> signalTermination() {
        closeInternal();
        return Futures.nonCancellationPropagating(this.mReleasedFuture);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void terminateNow() {
        int ordinal = this.mVideoEncoderState.ordinal();
        if (ordinal == 0) {
            this.mVideoEncoderState = VideoEncoderState.RELEASED;
            return;
        }
        if (ordinal == 1 || ordinal == 2 || ordinal == 3) {
            this.mVideoEncoderState = VideoEncoderState.RELEASED;
            this.mReadyToReleaseCompleter.set(this.mVideoEncoder);
            this.mSurfaceRequest = null;
            if (this.mVideoEncoder != null) {
                Logger.d(TAG, "VideoEncoder is releasing: " + this.mVideoEncoder);
                this.mVideoEncoder.release();
                this.mVideoEncoder.getReleasedFuture().addListener(new Runnable() { // from class: androidx.camera.video.VideoEncoderSession$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoEncoderSession.this.m264lambda$terminateNow$3$androidxcameravideoVideoEncoderSession();
                    }
                }, this.mSequentialExecutor);
                this.mVideoEncoder = null;
                return;
            }
            Logger.w(TAG, "There's no VideoEncoder to release! Finish release completer.");
            this.mReleasedCompleter.set(null);
            return;
        }
        VideoEncoderState videoEncoderState = this.mVideoEncoderState;
        if (ordinal == 4) {
            Logger.d(TAG, "terminateNow in " + videoEncoderState + ", No-op");
            return;
        }
        throw new IllegalStateException("State " + videoEncoderState + " is not handled");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$terminateNow$3$androidx-camera-video-VideoEncoderSession, reason: not valid java name */
    public /* synthetic */ void m264lambda$terminateNow$3$androidxcameravideoVideoEncoderSession() {
        this.mReleasedCompleter.set(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Surface getActiveSurface() {
        if (this.mVideoEncoderState != VideoEncoderState.READY) {
            return null;
        }
        return this.mActiveSurface;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Encoder getVideoEncoder() {
        return this.mVideoEncoder;
    }

    private void closeInternal() {
        int ordinal = this.mVideoEncoderState.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            terminateNow();
            return;
        }
        if (ordinal == 2 || ordinal == 3) {
            Logger.d(TAG, "closeInternal in " + this.mVideoEncoderState + " state");
            this.mVideoEncoderState = VideoEncoderState.PENDING_RELEASE;
            return;
        }
        if (ordinal == 4) {
            Logger.d(TAG, "closeInternal in RELEASED state, No-op");
            return;
        }
        throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnSurfaceUpdateListener(Executor executor, Encoder.SurfaceInput.OnSurfaceUpdateListener onSurfaceUpdateListener) {
        this.mOnSurfaceUpdateExecutor = executor;
        this.mOnSurfaceUpdateListener = onSurfaceUpdateListener;
    }

    private void configureVideoEncoderInternal(final SurfaceRequest surfaceRequest, Timebase timebase, VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, MediaSpec mediaSpec, final CallbackToFutureAdapter.Completer<Encoder> completer) {
        DynamicRange dynamicRange = surfaceRequest.getDynamicRange();
        try {
            Encoder createEncoder = this.mVideoEncoderFactory.createEncoder(this.mExecutor, VideoConfigUtil.resolveVideoEncoderConfig(VideoConfigUtil.resolveVideoMimeInfo(mediaSpec, dynamicRange, videoValidatedEncoderProfilesProxy), timebase, mediaSpec.getVideoSpec(), surfaceRequest.getResolution(), dynamicRange, surfaceRequest.getExpectedFrameRate()));
            this.mVideoEncoder = createEncoder;
            Encoder.EncoderInput input = createEncoder.getInput();
            if (!(input instanceof Encoder.SurfaceInput)) {
                completer.setException(new AssertionError("The EncoderInput of video isn't a SurfaceInput."));
            } else {
                ((Encoder.SurfaceInput) input).setOnSurfaceUpdateListener(this.mSequentialExecutor, new Encoder.SurfaceInput.OnSurfaceUpdateListener() { // from class: androidx.camera.video.VideoEncoderSession$$ExternalSyntheticLambda0
                    @Override // androidx.camera.video.internal.encoder.Encoder.SurfaceInput.OnSurfaceUpdateListener
                    public final void onSurfaceUpdate(Surface surface) {
                        VideoEncoderSession.this.m263x39f4fe93(completer, surfaceRequest, surface);
                    }
                });
            }
        } catch (InvalidConfigException e) {
            Logger.e(TAG, "Unable to initialize video encoder.", e);
            completer.setException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$configureVideoEncoderInternal$5$androidx-camera-video-VideoEncoderSession, reason: not valid java name */
    public /* synthetic */ void m263x39f4fe93(CallbackToFutureAdapter.Completer completer, SurfaceRequest surfaceRequest, final Surface surface) {
        Executor executor;
        int ordinal = this.mVideoEncoderState.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                if (surfaceRequest.isServiced()) {
                    Logger.d(TAG, "Not provide surface, " + Objects.toString(surfaceRequest, "EMPTY") + " is already serviced.");
                    completer.set(null);
                    closeInternal();
                    return;
                }
                this.mActiveSurface = surface;
                Logger.d(TAG, "provide surface: " + surface);
                surfaceRequest.provideSurface(surface, this.mSequentialExecutor, new Consumer() { // from class: androidx.camera.video.VideoEncoderSession$$ExternalSyntheticLambda5
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        VideoEncoderSession.this.onSurfaceRequestComplete((SurfaceRequest.Result) obj);
                    }
                });
                this.mVideoEncoderState = VideoEncoderState.READY;
                completer.set(this.mVideoEncoder);
                return;
            }
            if (ordinal != 2) {
                if (ordinal == 3) {
                    if (this.mOnSurfaceUpdateListener != null && (executor = this.mOnSurfaceUpdateExecutor) != null) {
                        executor.execute(new Runnable() { // from class: androidx.camera.video.VideoEncoderSession$$ExternalSyntheticLambda6
                            @Override // java.lang.Runnable
                            public final void run() {
                                VideoEncoderSession.this.m262x54b38fd2(surface);
                            }
                        });
                    }
                    Logger.w(TAG, "Surface is updated in READY state: " + surface);
                    return;
                }
                if (ordinal != 4) {
                    throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
                }
            }
        }
        Logger.d(TAG, "Not provide surface in " + this.mVideoEncoderState);
        completer.set(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$configureVideoEncoderInternal$4$androidx-camera-video-VideoEncoderSession, reason: not valid java name */
    public /* synthetic */ void m262x54b38fd2(Surface surface) {
        this.mOnSurfaceUpdateListener.onSurfaceUpdate(surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSurfaceRequestComplete(SurfaceRequest.Result result) {
        Logger.d(TAG, "Surface can be closed: " + result.getSurface().hashCode());
        Surface surface = result.getSurface();
        if (surface == this.mActiveSurface) {
            this.mActiveSurface = null;
            this.mReadyToReleaseCompleter.set(this.mVideoEncoder);
            closeInternal();
            return;
        }
        surface.release();
    }

    public String toString() {
        return "VideoEncoderSession@" + hashCode() + " for " + Objects.toString(this.mSurfaceRequest, "SURFACE_REQUEST_NOT_CONFIGURED");
    }
}
