package com.google.android.material.motion;

import android.os.Build;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import androidx.activity.BackEventCompat;
import java.util.Objects;

/* loaded from: classes6.dex */
public final class MaterialBackOrchestrator {
    private final BackCallbackDelegate backCallbackDelegate;
    private final MaterialBackHandler backHandler;
    private final View view;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface BackCallbackDelegate {
        void startListeningForBackCallbacks(MaterialBackHandler materialBackHandler, View view, boolean z);

        void stopListeningForBackCallbacks(View view);
    }

    public <T extends View & MaterialBackHandler> MaterialBackOrchestrator(T t) {
        this(t, t);
    }

    public MaterialBackOrchestrator(MaterialBackHandler materialBackHandler, View view) {
        this.backCallbackDelegate = createBackCallbackDelegate();
        this.backHandler = materialBackHandler;
        this.view = view;
    }

    public boolean shouldListenForBackCallbacks() {
        return this.backCallbackDelegate != null;
    }

    public void startListeningForBackCallbacksWithPriorityOverlay() {
        startListeningForBackCallbacks(true);
    }

    public void startListeningForBackCallbacks() {
        startListeningForBackCallbacks(false);
    }

    private void startListeningForBackCallbacks(boolean z) {
        BackCallbackDelegate backCallbackDelegate = this.backCallbackDelegate;
        if (backCallbackDelegate != null) {
            backCallbackDelegate.startListeningForBackCallbacks(this.backHandler, this.view, z);
        }
    }

    public void stopListeningForBackCallbacks() {
        BackCallbackDelegate backCallbackDelegate = this.backCallbackDelegate;
        if (backCallbackDelegate != null) {
            backCallbackDelegate.stopListeningForBackCallbacks(this.view);
        }
    }

    private static BackCallbackDelegate createBackCallbackDelegate() {
        if (Build.VERSION.SDK_INT >= 34) {
            return new Api34BackCallbackDelegate();
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return new Api33BackCallbackDelegate();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class Api34BackCallbackDelegate extends Api33BackCallbackDelegate {
        private Api34BackCallbackDelegate() {
            super();
        }

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.Api33BackCallbackDelegate
        OnBackInvokedCallback createOnBackInvokedCallback(final MaterialBackHandler materialBackHandler) {
            return new OnBackAnimationCallback() { // from class: com.google.android.material.motion.MaterialBackOrchestrator.Api34BackCallbackDelegate.1
                public void onBackStarted(BackEvent backEvent) {
                    if (Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                        materialBackHandler.startBackProgress(new BackEventCompat(backEvent));
                    }
                }

                public void onBackProgressed(BackEvent backEvent) {
                    if (Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                        materialBackHandler.updateBackProgress(new BackEventCompat(backEvent));
                    }
                }

                public void onBackInvoked() {
                    materialBackHandler.handleBackInvoked();
                }

                public void onBackCancelled() {
                    if (Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                        materialBackHandler.cancelBackProgress();
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class Api33BackCallbackDelegate implements BackCallbackDelegate {
        private OnBackInvokedCallback onBackInvokedCallback;

        private Api33BackCallbackDelegate() {
        }

        boolean isListeningForBackCallbacks() {
            return this.onBackInvokedCallback != null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x0005, code lost:
        
            r3 = r3.findOnBackInvokedDispatcher();
         */
        @Override // com.google.android.material.motion.MaterialBackOrchestrator.BackCallbackDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void startListeningForBackCallbacks(com.google.android.material.motion.MaterialBackHandler r2, android.view.View r3, boolean r4) {
            /*
                r1 = this;
                android.window.OnBackInvokedCallback r0 = r1.onBackInvokedCallback
                if (r0 == 0) goto L5
                goto Lb
            L5:
                android.window.OnBackInvokedDispatcher r3 = coil.fetch.ContentUriFetcher$$ExternalSyntheticApiModelOutline0.m7671m(r3)
                if (r3 != 0) goto Lc
            Lb:
                return
            Lc:
                android.window.OnBackInvokedCallback r2 = r1.createOnBackInvokedCallback(r2)
                r1.onBackInvokedCallback = r2
                if (r4 == 0) goto L18
                r1 = 1000000(0xf4240, float:1.401298E-39)
                goto L19
            L18:
                r1 = 0
            L19:
                androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0.m(r3, r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.motion.MaterialBackOrchestrator.Api33BackCallbackDelegate.startListeningForBackCallbacks(com.google.android.material.motion.MaterialBackHandler, android.view.View, boolean):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x0005, code lost:
        
            r2 = r2.findOnBackInvokedDispatcher();
         */
        @Override // com.google.android.material.motion.MaterialBackOrchestrator.BackCallbackDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void stopListeningForBackCallbacks(android.view.View r2) {
            /*
                r1 = this;
                android.window.OnBackInvokedCallback r0 = r1.onBackInvokedCallback
                if (r0 != 0) goto L5
                goto Lb
            L5:
                android.window.OnBackInvokedDispatcher r2 = coil.fetch.ContentUriFetcher$$ExternalSyntheticApiModelOutline0.m7671m(r2)
                if (r2 != 0) goto Lc
            Lb:
                return
            Lc:
                android.window.OnBackInvokedCallback r0 = r1.onBackInvokedCallback
                androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0.m(r2, r0)
                r2 = 0
                r1.onBackInvokedCallback = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.motion.MaterialBackOrchestrator.Api33BackCallbackDelegate.stopListeningForBackCallbacks(android.view.View):void");
        }

        OnBackInvokedCallback createOnBackInvokedCallback(final MaterialBackHandler materialBackHandler) {
            Objects.requireNonNull(materialBackHandler);
            return new OnBackInvokedCallback() { // from class: com.google.android.material.motion.MaterialBackOrchestrator$Api33BackCallbackDelegate$$ExternalSyntheticLambda1
                public final void onBackInvoked() {
                    MaterialBackHandler.this.handleBackInvoked();
                }
            };
        }
    }
}
