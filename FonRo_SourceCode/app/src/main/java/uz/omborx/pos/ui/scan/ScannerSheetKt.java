package uz.FonRo.pos.ui.scan;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.rounded.FlashOffKt;
import androidx.compose.material.icons.rounded.FlashOnKt;
import androidx.compose.material3.BadgeKt;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.profileinstaller.ProfileVerifier;
import coil.compose.SingletonAsyncImageKt;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.FonRoApp$$ExternalSyntheticApiModelOutline0;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.ModifiersKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.sale.CartLine;
import uz.FonRo.pos.ui.sale.CartState;
import uz.FonRo.pos.ui.sale.CartStore;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: ScannerSheet.kt */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\u001aq\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0007b\u0010\b\u000f\u0012\f\b\u0010\u0012\b\b\fJ\u0004\b\t0\u0011b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015¢\u0006\u0002\u0010\u000e\u001a_\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r0\fH\u0003b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015¢\u0006\u0002\u0010\u001e\u001a)\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020!H\u0003b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015¢\u0006\u0002\u0010\"\u001a\u0010\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0006²\u0006\n\u0010&\u001a\u00020'X\u008a\u0084\u0002²\u0006\n\u0010(\u001a\u00020)X\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020)X\u008a\u008e\u0002²\u0006\f\u0010+\u001a\u0004\u0018\u00010,X\u008a\u008e\u0002²\u0006\n\u0010-\u001a\u00020)X\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020)X\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u00100\u001a\u000201X\u008a\u008e\u0002"}, d2 = {"TorchOnBg", "Landroidx/compose/ui/graphics/Color;", "J", "TorchOnInk", "ScannerSheet", "", "app", "Luz/FonRo/pos/FonRoApp;", "onClose", "Lkotlin/Function0;", "onCart", "onCode", "Lkotlin/Function1;", "", "(Luz/FonRo/pos/FonRoApp;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Landroidx/annotation/OptIn;", "markerClass", "Landroidx/camera/core/ExperimentalGetImage;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "ScannedProductRow", "product", "Luz/FonRo/pos/data/model/Product;", "qty", "", "onPlus", "onMinus", "money", "(Luz/FonRo/pos/data/model/Product;DLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ScanFrame", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "vibrateShort", "context", "Landroid/content/Context;", "cart", "Luz/FonRo/pos/ui/sale/CartState;", "granted", "", "cameraFailed", "camera", "Landroidx/camera/core/Camera;", "hasTorch", "torchOn", "lastCode", "lastScanTime", ""}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ScannerSheetKt {
    private static final long TorchOnBg = ColorKt.Color(4294956646L);
    private static final long TorchOnInk = ColorKt.Color(4282001920L);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ScanFrame$lambda$1(Modifier modifier, int i, int i2, Composer composer, int i3) {
        ScanFrame(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ScannedProductRow$lambda$1(Product product, double d, Function0 function0, Function0 function02, Function1 function1, int i, Composer composer, int i2) {
        ScannedProductRow(product, d, function0, function02, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewView ScannerSheet$lambda$28$0$0$0$0(PreviewView previewView, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return previewView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ScannerSheet$lambda$29(FonRoApp FonRoApp, Function0 function0, Function0 function02, Function1 function1, int i, int i2, Composer composer, int i3) {
        ScannerSheet(FonRoApp, function0, function02, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ScannerSheet(final uz.FonRo.pos.FonRoApp r35, final kotlin.jvm.functions.Function0<kotlin.Unit> r36, kotlin.jvm.functions.Function0<kotlin.Unit> r37, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 891
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.scan.ScannerSheetKt.ScannerSheet(uz.FonRo.pos.FonRoApp, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ScannerSheet$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ScannerSheet$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean ScannerSheet$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ScannerSheet$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Camera ScannerSheet$lambda$8(MutableState<Camera> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ScannerSheet$lambda$11(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ScannerSheet$lambda$12(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean ScannerSheet$lambda$14(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ScannerSheet$lambda$15(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String ScannerSheet$lambda$18(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final long ScannerSheet$lambda$21(MutableState<Long> mutableState) {
        return mutableState.getValue().longValue();
    }

    private static final void ScannerSheet$lambda$22(MutableState<Long> mutableState, long j) {
        mutableState.setValue(Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScannerSheet$lambda$23$0(Function1 function1, Context context, Repo repo, SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        long currentTimeMillis = System.currentTimeMillis();
        if (!Intrinsics.areEqual(code, ScannerSheet$lambda$18(mutableState)) || currentTimeMillis - ScannerSheet$lambda$21(mutableState2) > 2000) {
            mutableState.setValue(code);
            ScannerSheet$lambda$22(mutableState2, currentTimeMillis);
            if (function1 != null) {
                vibrateShort(context);
                function1.invoke(code);
            } else {
                Product findByBarcode = repo.findByBarcode(code);
                if (findByBarcode != null) {
                    vibrateShort(context);
                    CartStore.add$default(CartStore.INSTANCE, findByBarcode, null, 2, null);
                    if (!snapshotStateList.contains(Long.valueOf(findByBarcode.getId()))) {
                        snapshotStateList.add(0, Long.valueOf(findByBarcode.getId()));
                    } else {
                        snapshotStateList.remove(Long.valueOf(findByBarcode.getId()));
                        snapshotStateList.add(0, Long.valueOf(findByBarcode.getId()));
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScannerSheet$lambda$24$0(MutableState mutableState, boolean z) {
        ScannerSheet$lambda$3(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ScannerSheet$lambda$27$0(Context context, MutableState mutableState, final PreviewView previewView, final MutableState mutableState2, final Function1 function1, final LifecycleOwner lifecycleOwner, final MutableState mutableState3, final MutableState mutableState4, final DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        if (ScannerSheet$lambda$2(mutableState)) {
            final ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            BarcodeScannerOptions build = new BarcodeScannerOptions.Builder().setBarcodeFormats(0, new int[0]).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            final BarcodeScanner client = BarcodeScanning.getClient(build);
            Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
            final ListenableFuture<ProcessCameraProvider> companion = ProcessCameraProvider.INSTANCE.getInstance(context);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            companion.addListener(new Runnable() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    ScannerSheetKt.ScannerSheet$lambda$27$0$1(Ref.BooleanRef.this, DisposableEffect, objectRef, previewView, newSingleThreadExecutor, client, companion, mutableState2, function1, lifecycleOwner, mutableState3, mutableState4);
                }
            }, ContextCompat.getMainExecutor(context));
            return new DisposableEffectResult() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$ScannerSheet$lambda$27$0$$inlined$onDispose$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    Ref.BooleanRef.this.element = true;
                    ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) objectRef.element;
                    if (processCameraProvider != null) {
                        processCameraProvider.unbindAll();
                    }
                    try {
                        Result.Companion companion2 = Result.INSTANCE;
                        client.close();
                        Result.m7870constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion3 = Result.INSTANCE;
                        Result.m7870constructorimpl(ResultKt.createFailure(th));
                    }
                    newSingleThreadExecutor.shutdown();
                }
            };
        }
        return new DisposableEffectResult() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$ScannerSheet$lambda$27$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [T, androidx.camera.lifecycle.ProcessCameraProvider] */
    public static final void ScannerSheet$lambda$27$0$1(Ref.BooleanRef booleanRef, DisposableEffectScope disposableEffectScope, Ref.ObjectRef objectRef, PreviewView previewView, ExecutorService executorService, BarcodeScanner barcodeScanner, ListenableFuture listenableFuture, MutableState mutableState, final Function1 function1, LifecycleOwner lifecycleOwner, MutableState mutableState2, MutableState mutableState3) {
        Object m7870constructorimpl;
        Object m7870constructorimpl2;
        if (booleanRef.element) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl((ProcessCameraProvider) listenableFuture.get());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7876isFailureimpl(m7870constructorimpl)) {
            m7870constructorimpl = null;
        }
        ?? r2 = (ProcessCameraProvider) m7870constructorimpl;
        if (r2 == 0) {
            ScannerSheet$lambda$6(mutableState, true);
            return;
        }
        objectRef.element = r2;
        Preview build = new Preview.Builder().build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        build.setSurfaceProvider(previewView.getSurfaceProvider());
        ImageAnalysis build2 = new ImageAnalysis.Builder().setBackpressureStrategy(0).build();
        Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
        build2.setAnalyzer(executorService, new BarcodeAnalyzer(barcodeScanner, new Function1() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ScannerSheet$lambda$27$0$1$1;
                ScannerSheet$lambda$27$0$1$1 = ScannerSheetKt.ScannerSheet$lambda$27$0$1$1(Function1.this, (String) obj);
                return ScannerSheet$lambda$27$0$1$1;
            }
        }));
        try {
            Result.Companion companion3 = Result.INSTANCE;
            r2.unbindAll();
            CameraSelector DEFAULT_BACK_CAMERA = CameraSelector.DEFAULT_BACK_CAMERA;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_BACK_CAMERA, "DEFAULT_BACK_CAMERA");
            m7870constructorimpl2 = Result.m7870constructorimpl(r2.bindToLifecycle(lifecycleOwner, DEFAULT_BACK_CAMERA, build, build2));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            m7870constructorimpl2 = Result.m7870constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m7877isSuccessimpl(m7870constructorimpl2)) {
            Camera camera = (Camera) m7870constructorimpl2;
            mutableState2.setValue(camera);
            ScannerSheet$lambda$12(mutableState3, camera.getCameraInfo().hasFlashUnit());
        }
        if (Result.m7873exceptionOrNullimpl(m7870constructorimpl2) != null) {
            ScannerSheet$lambda$6(mutableState, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScannerSheet$lambda$27$0$1$1(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v3 */
    public static final Unit ScannerSheet$lambda$28(final PreviewView previewView, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, SnapshotStateList snapshotStateList, final Repo repo, Function0 function0, final State state, ColumnScope OxFullSheet, Composer composer, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Modifier modifier;
        String str6;
        int i2;
        boolean z;
        Object obj;
        String str7;
        String str8;
        String str9;
        String str10;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxFullSheet, "$this$OxFullSheet");
        ComposerKt.sourceInformation(composer2, "C204@8280L3935:ScannerSheet.kt#1sevdj");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1024216638, i, -1, "uz.FonRo.pos.ui.scan.ScannerSheet.<anonymous> (ScannerSheet.kt:204)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, fillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer m3808constructorimpl = Updater.m3808constructorimpl(composer2);
            Updater.m3815setimpl(m3808constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1641728285, "C205@8325L1433,232@9772L11,233@9796L110,234@9919L10,236@9943L2262:ScannerSheet.kt#1sevdj");
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1082height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6989constructorimpl(240.0f)), OxShape.INSTANCE.getCard()), Color.INSTANCE.m4410getBlack0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, m558backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer m3808constructorimpl2 = Updater.m3808constructorimpl(composer2);
            Updater.m3815setimpl(m3808constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1246595052, "C:ScannerSheet.kt#1sevdj");
            if (!ScannerSheet$lambda$2(mutableState) || ScannerSheet$lambda$5(mutableState2)) {
                str = "C:ScannerSheet.kt#1sevdj";
                composer2.startReplaceGroup(1247623321);
                ComposerKt.sourceInformation(composer2, "226@9563L163");
                Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, fillMaxSize$default2);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                Composer m3808constructorimpl3 = Updater.m3808constructorimpl(composer2);
                Updater.m3815setimpl(m3808constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1761052055, "C227@9654L50:ScannerSheet.kt#1sevdj");
                str2 = "CC(remember):ScannerSheet.kt#9igjgp";
                str3 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                str4 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
                str5 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                modifier = null;
                str6 = "C72@3468L9:Box.kt#2w3rfo";
                i2 = 0;
                TextKt.m2798Text4IGK_g(LangKt.tx("Камера недоступна", new Object[0]), (Modifier) null, Color.INSTANCE.m4421getWhite0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 384, 0, 131066);
                composer2 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1246617402);
                ComposerKt.sourceInformation(composer2, "209@8545L15,209@8523L73,210@8617L33");
                ComposerKt.sourceInformationMarkerStart(composer2, -513975475, "CC(remember):ScannerSheet.kt#9igjgp");
                boolean changedInstance = composer2.changedInstance(previewView);
                Object rememberedValue = composer2.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            PreviewView ScannerSheet$lambda$28$0$0$0$0;
                            ScannerSheet$lambda$28$0$0$0$0 = ScannerSheetKt.ScannerSheet$lambda$28$0$0$0$0(PreviewView.this, (Context) obj2);
                            return ScannerSheet$lambda$28$0$0$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                str = "C:ScannerSheet.kt#1sevdj";
                AndroidView_androidKt.AndroidView((Function1) rememberedValue, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, composer2, 48, 4);
                ScanFrame(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer2, 6, 0);
                if (ScannerSheet$lambda$11(mutableState3)) {
                    composer2.startReplaceGroup(1246793668);
                    ComposerKt.sourceInformation(composer2, "215@8972L219,215@8966L225,212@8711L784");
                    Modifier m558backgroundbw27NRU$default2 = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(PaddingKt.m1049padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd()), Dp.m6989constructorimpl(12.0f)), Dp.m6989constructorimpl(40.0f)), OxShape.INSTANCE.getPill()), ScannerSheet$lambda$14(mutableState4) ? TorchOnBg : Color.m4383copywmQWz5c$default(Color.INSTANCE.m4421getWhite0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composer2, -513961607, "CC(remember):ScannerSheet.kt#9igjgp");
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ScannerSheet$lambda$28$0$0$1$0;
                                ScannerSheet$lambda$28$0$0$1$0 = ScannerSheetKt.ScannerSheet$lambda$28$0$0$1$0(MutableState.this, mutableState5);
                                return ScannerSheet$lambda$28$0$0$1$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier oxTap = ModifiersKt.oxTap(m558backgroundbw27NRU$default2, false, (Function0) rememberedValue2, composer2, 384, 1);
                    Alignment center2 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, oxTap);
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor4);
                    } else {
                        composer2.useNode();
                    }
                    Composer m3808constructorimpl4 = Updater.m3808constructorimpl(composer2);
                    Updater.m3815setimpl(m3808constructorimpl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1623826605, "C222@9313L156:ScannerSheet.kt#1sevdj");
                    str8 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                    str9 = "CC(remember):ScannerSheet.kt#9igjgp";
                    str10 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
                    str7 = "C72@3468L9:Box.kt#2w3rfo";
                    IconKt.m2255Iconww6aTOc(ScannerSheet$lambda$14(mutableState4) ? FlashOnKt.getFlashOn(Icons.Rounded.INSTANCE) : FlashOffKt.getFlashOff(Icons.Rounded.INSTANCE), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(20.0f)), ScannerSheet$lambda$14(mutableState4) ? TorchOnInk : Color.INSTANCE.m4421getWhite0d7_KjU(), composer2, 432, 0);
                    composer2 = composer2;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceGroup();
                } else {
                    str7 = "C72@3468L9:Box.kt#2w3rfo";
                    str8 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                    str9 = "CC(remember):ScannerSheet.kt#9igjgp";
                    str10 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
                    composer2.startReplaceGroup(1247593220);
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
                str2 = str9;
                str6 = str7;
                str4 = str10;
                modifier = null;
                str3 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                str5 = str8;
                i2 = 0;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
            TextKt.m2798Text4IGK_g(LangKt.tx("Отсканированные товары", new Object[i2]), PaddingKt.m1051paddingVpY3zN4$default(Modifier.INSTANCE, OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), 0.0f, 2, modifier), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH2(), composer, 0, 0, 65532);
            Composer composer3 = composer;
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer3, 6);
            Modifier weight$default = ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, str4);
            MeasurePolicy maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), i2);
            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, str3);
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer3, i2);
            CompositionLocalMap currentCompositionLocalMap5 = composer3.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer3, weight$default);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, str5);
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor5);
            } else {
                composer3.useNode();
            }
            Composer m3808constructorimpl5 = Updater.m3808constructorimpl(composer3);
            Updater.m3815setimpl(m3808constructorimpl5, maybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl5.getInserting() || !Intrinsics.areEqual(m3808constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                m3808constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                m3808constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3815setimpl(m3808constructorimpl5, materializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, str6);
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, 788570673, str);
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = snapshotStateList.iterator();
            while (it.hasNext()) {
                long longValue = ((Number) it.next()).longValue();
                Iterator<T> it2 = ScannerSheet$lambda$0(state).getItems().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = modifier;
                        break;
                    }
                    obj = it2.next();
                    if (((CartLine) obj).getProductId() == longValue) {
                        break;
                    }
                }
                CartLine cartLine = (CartLine) obj;
                if (cartLine != null) {
                    arrayList.add(cartLine);
                }
            }
            final ArrayList arrayList2 = arrayList;
            if (arrayList2.isEmpty()) {
                composer3.startReplaceGroup(788636361);
                ComposerKt.sourceInformation(composer3, "239@10140L60");
                BasicsKt.OxEmptyNote(LangKt.tx("Список пуст. Наведите камеру на штрихкод.", new Object[i2]), modifier, composer3, i2, 2);
                composer3.endReplaceGroup();
                z = true;
            } else {
                composer3.startReplaceGroup(788769010);
                ComposerKt.sourceInformation(composer3, "244@10454L739,241@10246L947");
                z = true;
                Modifier fillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, modifier);
                PaddingValues m1046PaddingValuesa9UjIt4$default = PaddingKt.m1046PaddingValuesa9UjIt4$default(OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), 0.0f, OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), Dp.m6989constructorimpl(80.0f), 2, null);
                ComposerKt.sourceInformationMarkerStart(composer3, -1637116712, str2);
                boolean changedInstance2 = composer3.changedInstance(arrayList2) | composer3.changedInstance(repo);
                Object rememberedValue3 = composer3.rememberedValue();
                if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit ScannerSheet$lambda$28$0$1$1$0;
                            ScannerSheet$lambda$28$0$1$1$0 = ScannerSheetKt.ScannerSheet$lambda$28$0$1$1$0(arrayList2, repo, (LazyListScope) obj2);
                            return ScannerSheet$lambda$28$0$1$1$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                LazyDslKt.LazyColumn(fillMaxSize$default3, null, m1046PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) rememberedValue3, composer, 6, TypedValues.PositionType.TYPE_PERCENT_X);
                composer3 = composer;
                composer3.endReplaceGroup();
            }
            if (function0 != null && !ScannerSheet$lambda$0(state).getItems().isEmpty()) {
                composer3.startReplaceGroup(789830946);
                ComposerKt.sourceInformation(composer3, "267@11621L552,261@11298L875");
                Composer composer4 = composer3;
                FloatingActionButtonKt.m2230FloatingActionButtonXz6DiA(function0, PaddingKt.m1049padding3ABfNKs(boxScopeInstance4.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd()), Dp.m6989constructorimpl(20.0f)), OxShape.INSTANCE.getPill(), Ox.INSTANCE.m10220getPrimary0d7_KjU(), Color.INSTANCE.m4421getWhite0d7_KjU(), null, null, ComposableLambdaKt.rememberComposableLambda(2141351113, z, new Function2() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit ScannerSheet$lambda$28$0$1$2;
                        ScannerSheet$lambda$28$0$1$2 = ScannerSheetKt.ScannerSheet$lambda$28$0$1$2(State.this, (Composer) obj2, ((Integer) obj3).intValue());
                        return ScannerSheet$lambda$28$0$1$2;
                    }
                }, composer3, 54), composer4, 12607488, 96);
                composer3 = composer4;
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(790689677);
                composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScannerSheet$lambda$28$0$0$1$0(MutableState mutableState, MutableState mutableState2) {
        CameraControl cameraControl;
        boolean z = !ScannerSheet$lambda$14(mutableState);
        Camera ScannerSheet$lambda$8 = ScannerSheet$lambda$8(mutableState2);
        if (ScannerSheet$lambda$8 != null && (cameraControl = ScannerSheet$lambda$8.getCameraControl()) != null) {
            cameraControl.enableTorch(z);
        }
        ScannerSheet$lambda$15(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScannerSheet$lambda$28$0$1$1$0(final List list, final Repo repo, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object ScannerSheet$lambda$28$0$1$1$0$0;
                ScannerSheet$lambda$28$0$1$1$0$0 = ScannerSheetKt.ScannerSheet$lambda$28$0$1$1$0$0((CartLine) obj);
                return ScannerSheet$lambda$28$0$1$1$0$0;
            }
        };
        final ScannerSheetKt$ScannerSheet$lambda$28$0$1$1$0$$inlined$items$default$1 scannerSheetKt$ScannerSheet$lambda$28$0$1$1$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$ScannerSheet$lambda$28$0$1$1$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(CartLine cartLine) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((CartLine) obj);
            }
        };
        LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$ScannerSheet$lambda$28$0$1$1$0$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(list.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$ScannerSheet$lambda$28$0$1$1$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$ScannerSheet$lambda$28$0$1$1$0$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                Composer composer2;
                ComposerKt.sourceInformation(composer, "C178@8826L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                CartLine cartLine = (CartLine) list.get(i);
                composer.startReplaceGroup(1836254791);
                ComposerKt.sourceInformation(composer, "C:ScannerSheet.kt#1sevdj");
                final Product productById = repo.productById(cartLine.getProductId());
                if (productById != null) {
                    composer.startReplaceGroup(1836347046);
                    ComposerKt.sourceInformation(composer, "251@10862L26,252@10936L81,253@11063L18,248@10691L424");
                    double qty = cartLine.getQty();
                    ComposerKt.sourceInformationMarkerStart(composer, -1464777554, "CC(remember):ScannerSheet.kt#9igjgp");
                    boolean changedInstance = composer.changedInstance(productById);
                    Object rememberedValue = composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$ScannerSheet$3$1$2$1$1$2$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                CartStore.add$default(CartStore.INSTANCE, Product.this, null, 2, null);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    Function0 function0 = (Function0) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -1464775131, "CC(remember):ScannerSheet.kt#9igjgp");
                    boolean changedInstance2 = composer.changedInstance(productById);
                    Object rememberedValue2 = composer.rememberedValue();
                    if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$ScannerSheet$3$1$2$1$1$2$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                CartStore.INSTANCE.changeQty(Product.this.getId(), -CartStore.INSTANCE.stepOf(Product.this), Product.this.getQuantity());
                            }
                        };
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    Function0 function02 = (Function0) rememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -1464771130, "CC(remember):ScannerSheet.kt#9igjgp");
                    boolean changedInstance3 = composer.changedInstance(repo);
                    Object rememberedValue3 = composer.rememberedValue();
                    if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        final Repo repo2 = repo;
                        rememberedValue3 = (Function1) new Function1<Double, String>() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$ScannerSheet$3$1$2$1$1$2$3$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ String invoke(Double d) {
                                return invoke(d.doubleValue());
                            }

                            public final String invoke(double d) {
                                return Repo.this.money(Double.valueOf(d));
                            }
                        };
                        composer.updateRememberedValue(rememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer2 = composer;
                    ScannerSheetKt.ScannedProductRow(productById, qty, function0, function02, (Function1) rememberedValue3, composer2, Product.$stable);
                    composer2.endReplaceGroup();
                } else {
                    composer2 = composer;
                    composer2.startReplaceGroup(1836816014);
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ScannerSheet$lambda$28$0$1$1$0$0(CartLine it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getProductId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScannerSheet$lambda$28$0$1$2(final State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C268@11647L504:ScannerSheet.kt#1sevdj");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2141351113, i, -1, "uz.FonRo.pos.ui.scan.ScannerSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScannerSheet.kt:268)");
            }
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6989constructorimpl(16.0f), 0.0f, 2, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m1051paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m3808constructorimpl = Updater.m3808constructorimpl(composer);
            Updater.m3815setimpl(m3808constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1297229308, "C269@11837L95,269@11819L226,272@12074L51:ScannerSheet.kt#1sevdj");
            BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(1965611189, true, new Function3() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ScannerSheet$lambda$28$0$1$2$0$0;
                    ScannerSheet$lambda$28$0$1$2$0$0 = ScannerSheetKt.ScannerSheet$lambda$28$0$1$2$0$0(State.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ScannerSheet$lambda$28$0$1$2$0$0;
                }
            }, composer, 54), null, ComposableSingletons$ScannerSheetKt.INSTANCE.getLambda$538319603$app(), composer, 390, 2);
            TextKt.m2798Text4IGK_g(LangKt.tx("В корзину", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 131038);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScannerSheet$lambda$28$0$1$2$0$0(final State state, BoxScope BadgedBox, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
        ComposerKt.sourceInformation(composer, "C269@11873L57,269@11839L91:ScannerSheet.kt#1sevdj");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1965611189, i, -1, "uz.FonRo.pos.ui.scan.ScannerSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScannerSheet.kt:269)");
            }
            BadgeKt.m1893BadgeeopBjH0(null, Ox.INSTANCE.m10196getDanger0d7_KjU(), 0L, ComposableLambdaKt.rememberComposableLambda(65179362, true, new Function3() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ScannerSheet$lambda$28$0$1$2$0$0$0;
                    ScannerSheet$lambda$28$0$1$2$0$0$0 = ScannerSheetKt.ScannerSheet$lambda$28$0$1$2$0$0$0(State.this, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ScannerSheet$lambda$28$0$1$2$0$0$0;
                }
            }, composer, 54), composer, 3072, 5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScannerSheet$lambda$28$0$1$2$0$0$0(State state, RowScope Badge, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Badge, "$this$Badge");
        ComposerKt.sourceInformation(composer, "C269@11875L53:ScannerSheet.kt#1sevdj");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(65179362, i, -1, "uz.FonRo.pos.ui.scan.ScannerSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScannerSheet.kt:269)");
            }
            TextKt.m2798Text4IGK_g(String.valueOf(ScannerSheet$lambda$0(state).getItems().size()), (Modifier) null, Color.INSTANCE.m4421getWhite0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 384, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ScannedProductRow(final Product product, final double d, final Function0<Unit> function0, final Function0<Unit> function02, final Function1<? super Double, String> function1, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1158192996);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScannedProductRow)P(3,4,2,1)283@12372L1492:ScannerSheet.kt#1sevdj");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(product) : startRestartGroup.changedInstance(product) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(d) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if (startRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1158192996, i2, -1, "uz.FonRo.pos.ui.scan.ScannedProductRow (ScannerSheet.kt:282)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1099863040, "C284@12389L1449,307@13847L11:ScannerSheet.kt#1sevdj");
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(10.0f), 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m1051paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl2 = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -72396091, "C289@12624L382,289@12616L390,297@13019L221,301@13253L575:ScannerSheet.kt#1sevdj");
            BasicsKt.m9834OxThumbPZHvWI(null, 0.0f, 0L, ComposableLambdaKt.rememberComposableLambda(451684570, true, new Function3() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ScannedProductRow$lambda$0$0$0;
                    ScannedProductRow$lambda$0$0$0 = ScannerSheetKt.ScannedProductRow$lambda$0$0$0(Product.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ScannedProductRow$lambda$0$0$0;
                }
            }, startRestartGroup, 54), startRestartGroup, 3072, 7);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl3 = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl3, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1135249142, "C298@13065L91,299@13173L53:ScannerSheet.kt#1sevdj");
            TextKt.m2798Text4IGK_g(product.getName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), startRestartGroup, 0, 3120, 55294);
            TextKt.m2798Text4IGK_g(function1.invoke(Double.valueOf(product.getSalePrice())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), startRestartGroup, 0, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, centerVertically2, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl4 = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 743326703, "C302@13376L167,303@13560L71,304@13648L166:ScannerSheet.kt#1sevdj");
            Modifier oxClickable$default = ModifiersKt.oxClickable$default(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(32.0f)), OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10218getPanel20d7_KjU(), null, 2, null), false, null, 0L, function02, 7, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, oxClickable$default);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor5);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl5 = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl5, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl5.getInserting() || !Intrinsics.areEqual(m3808constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                m3808constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                m3808constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3815setimpl(m3808constructorimpl5, materializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 335646031, "C302@13513L28:ScannerSheet.kt#1sevdj");
            TextKt.m2798Text4IGK_g("−", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH3(), startRestartGroup, 6, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.qf(Double.valueOf(d)), (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getExtraBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH3(), startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65502);
            Modifier oxClickable$default2 = ModifiersKt.oxClickable$default(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(32.0f)), OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10218getPanel20d7_KjU(), null, 2, null), false, null, 0L, function0, 7, null);
            Alignment center2 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(startRestartGroup, oxClickable$default2);
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor6);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl6 = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl6, maybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl6.getInserting() || !Intrinsics.areEqual(m3808constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                m3808constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                m3808constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            }
            Updater.m3815setimpl(m3808constructorimpl6, materializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 655792774, "C304@13784L28:ScannerSheet.kt#1sevdj");
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g("+", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH3(), composer2, 6, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            BasicsKt.m9830OxDivideriPRSM58(0L, 0.0f, composer2, 0, 3);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScannerSheetKt.ScannedProductRow$lambda$1(Product.this, d, function0, function02, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScannedProductRow$lambda$0$0$0(Product product, BoxScope OxThumb, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxThumb, "$this$OxThumb");
        ComposerKt.sourceInformation(composer, "C:ScannerSheet.kt#1sevdj");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxThumb) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(451684570, i2, -1, "uz.FonRo.pos.ui.scan.ScannedProductRow.<anonymous>.<anonymous>.<anonymous> (ScannerSheet.kt:290)");
            }
            String photo = product.getPhoto();
            String str = photo;
            if (str != null && !StringsKt.isBlank(str)) {
                composer.startReplaceGroup(2599406);
                ComposerKt.sourceInformation(composer, "292@12734L122");
                SingletonAsyncImageKt.m7640AsyncImagegl8XCv8(photo, null, ClipKt.clip(OxThumb.matchParentSize(Modifier.INSTANCE), OxShape.INSTANCE.getImg()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, null, composer, 1572912, 0, 4024);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(2764512);
                ComposerKt.sourceInformation(composer, "294@12902L72");
                IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getBox(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), Ox.INSTANCE.m10200getDim20d7_KjU(), composer, 432, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void ScanFrame(final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-13015765);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScanFrame)313@13956L614,313@13939L631:ScannerSheet.kt#1sevdj");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if (!startRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-13015765, i3, -1, "uz.FonRo.pos.ui.scan.ScanFrame (ScannerSheet.kt:312)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 376754513, "CC(remember):ScannerSheet.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ScanFrame$lambda$0$0;
                        ScanFrame$lambda$0$0 = ScannerSheetKt.ScanFrame$lambda$0$0((DrawScope) obj);
                        return ScanFrame$lambda$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CanvasKt.Canvas(modifier, (Function1) rememberedValue, startRestartGroup, (i3 & 14) | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.scan.ScannerSheetKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScannerSheetKt.ScanFrame$lambda$1(Modifier.this, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScanFrame$lambda$0$0(DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        Rect rect = new Rect(Float.intBitsToFloat((int) (Canvas.mo4935getSizeNHjbRc() >> 32)) * 0.1f, Float.intBitsToFloat((int) (Canvas.mo4935getSizeNHjbRc() & 4294967295L)) * 0.34f, Float.intBitsToFloat((int) (Canvas.mo4935getSizeNHjbRc() >> 32)) * 0.9f, Float.intBitsToFloat((int) (Canvas.mo4935getSizeNHjbRc() & 4294967295L)) * 0.66f);
        float f = Canvas.mo700toPx0680j_4(Dp.m6989constructorimpl(12.0f));
        float f2 = Canvas.mo700toPx0680j_4(Dp.m6989constructorimpl(12.0f));
        long m4079constructorimpl = CornerRadius.m4079constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
        Path Path = AndroidPath_androidKt.Path();
        Path.addRect$default(Path, RectKt.m4165Recttz77jQw(Offset.INSTANCE.m4141getZeroF1C5BW0(), Canvas.mo4935getSizeNHjbRc()), null, 2, null);
        Path.addRoundRect$default(Path, RoundRectKt.m4180RoundRectsniSvfs(rect, m4079constructorimpl), null, 2, null);
        Path.mo4259setFillTypeoQ8Xj4U(PathFillType.INSTANCE.m4666getEvenOddRgk1Os());
        DrawScope.m4925drawPathLG529CI$default(Canvas, Path, Color.m4383copywmQWz5c$default(Color.INSTANCE.m4410getBlack0d7_KjU(), 0.35f, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, null, null, 0, 60, null);
        DrawScope.m4931drawRoundRectuAw5IA$default(Canvas, Color.m4383copywmQWz5c$default(Color.INSTANCE.m4421getWhite0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null), rect.m4160getTopLeftF1C5BW0(), rect.m4158getSizeNHjbRc(), m4079constructorimpl, new Stroke(Canvas.mo700toPx0680j_4(Dp.m6989constructorimpl(2.0f)), 0.0f, 0, 0, null, 30, null), 0.0f, null, 0, 224, null);
        return Unit.INSTANCE;
    }

    private static final void vibrateShort(Context context) {
        VibrationEffect createOneShot;
        Vibrator vibrator = null;
        if (Build.VERSION.SDK_INT >= 31) {
            Object systemService = context.getSystemService("vibrator_manager");
            VibratorManager m = FonRoApp$$ExternalSyntheticApiModelOutline0.m9732m(systemService) ? FonRoApp$$ExternalSyntheticApiModelOutline0.m(systemService) : null;
            if (m != null) {
                vibrator = m.getDefaultVibrator();
            }
        } else {
            Object systemService2 = context.getSystemService("vibrator");
            if (systemService2 instanceof Vibrator) {
                vibrator = (Vibrator) systemService2;
            }
        }
        if (vibrator == null || !vibrator.hasVibrator()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            createOneShot = VibrationEffect.createOneShot(40L, -1);
            vibrator.vibrate(createOneShot);
        } else {
            vibrator.vibrate(40L);
        }
    }

    private static final CartState ScannerSheet$lambda$0(State<CartState> state) {
        return state.getValue();
    }
}
