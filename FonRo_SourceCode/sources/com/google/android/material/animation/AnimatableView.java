package com.google.android.material.animation;

/* loaded from: classes6.dex */
public interface AnimatableView {

    /* loaded from: classes6.dex */
    public interface Listener {
        void onAnimationEnd();
    }

    void startAnimation(Listener listener);

    void stopAnimation();
}
