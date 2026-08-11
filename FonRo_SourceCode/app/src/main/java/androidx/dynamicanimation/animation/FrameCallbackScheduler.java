package androidx.dynamicanimation.animation;

/* loaded from: classes5.dex */
public interface FrameCallbackScheduler {
    boolean isCurrentThread();

    void postFrameCallback(Runnable runnable);
}
