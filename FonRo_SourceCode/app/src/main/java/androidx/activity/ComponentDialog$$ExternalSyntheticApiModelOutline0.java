package androidx.activity;

import android.graphics.RenderNode;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.hardware.camera2.params.MultiResolutionStreamInfo;
import android.hardware.camera2.params.OutputConfiguration;
import android.util.Size;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.EditorBoundsInfo;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import android.view.inspector.InspectionCompanion;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class ComponentDialog$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ RenderNode m(String str) {
        return new RenderNode(str);
    }

    public static /* bridge */ /* synthetic */ DynamicRangeProfiles m(Object obj) {
        return (DynamicRangeProfiles) obj;
    }

    public static /* synthetic */ MultiResolutionStreamInfo m(int i, int i2, String str) {
        return new MultiResolutionStreamInfo(i, i2, str);
    }

    public static /* synthetic */ OutputConfiguration m(Size size, Class cls) {
        return new OutputConfiguration(size, cls);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ WindowInsetsAnimationControlListener m2m(Object obj) {
        return (WindowInsetsAnimationControlListener) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ WindowInsetsAnimationController m3m(Object obj) {
        return (WindowInsetsAnimationController) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ EditorBoundsInfo.Builder m4m() {
        return new EditorBoundsInfo.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ InspectionCompanion.UninitializedPropertyMapException m5m() {
        return new InspectionCompanion.UninitializedPropertyMapException();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ OnBackInvokedCallback m6m(Object obj) {
        return (OnBackInvokedCallback) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ OnBackInvokedDispatcher m7m(Object obj) {
        return (OnBackInvokedDispatcher) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m8m() {
        return SelectGesture.class;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m12m() {
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m18m$1() {
        return SelectRangeGesture.class;
    }

    /* renamed from: m$2, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m21m$2() {
        return DeleteRangeGesture.class;
    }

    /* renamed from: m$3, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m22m$3() {
        return DeleteGesture.class;
    }

    /* renamed from: m$4, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m23m$4() {
        return JoinOrSplitGesture.class;
    }

    public static /* bridge */ /* synthetic */ Class m$5() {
        return InsertGesture.class;
    }

    public static /* bridge */ /* synthetic */ Class m$6() {
        return RemoveSpaceGesture.class;
    }
}
