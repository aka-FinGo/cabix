package uz.FonRo.pos.ui.scan;

import android.media.Image;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BarcodeAnalyzer.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\u0002\b\u000eÊ\u0001\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\u0003\u0010\u0000¨\u0006\r"}, d2 = {"Luz/FonRo/pos/ui/scan/BarcodeAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "scanner", "Lcom/google/mlkit/vision/barcode/BarcodeScanner;", "onCode", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/google/mlkit/vision/barcode/BarcodeScanner;Lkotlin/jvm/functions/Function1;)V", "analyze", "imageProxy", "Landroidx/camera/core/ImageProxy;", "app", "Landroidx/camera/core/ExperimentalGetImage;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class BarcodeAnalyzer implements ImageAnalysis.Analyzer {
    public static final int $stable = 8;
    private final Function1<String, Unit> onCode;
    private final BarcodeScanner scanner;

    /* JADX WARN: Multi-variable type inference failed */
    public BarcodeAnalyzer(BarcodeScanner scanner, Function1<? super String, Unit> onCode) {
        Intrinsics.checkNotNullParameter(scanner, "scanner");
        Intrinsics.checkNotNullParameter(onCode, "onCode");
        this.scanner = scanner;
        this.onCode = onCode;
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public void analyze(final ImageProxy imageProxy) {
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        Image image = imageProxy.getImage();
        if (image == null) {
            imageProxy.close();
            return;
        }
        try {
            InputImage fromMediaImage = InputImage.fromMediaImage(image, imageProxy.getImageInfo().getRotationDegrees());
            Intrinsics.checkNotNullExpressionValue(fromMediaImage, "fromMediaImage(...)");
            Task<List<Barcode>> process = this.scanner.process(fromMediaImage);
            final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.scan.BarcodeAnalyzer$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BarcodeAnalyzer.analyze$lambda$0(BarcodeAnalyzer.this, (List) obj);
                }
            };
            Intrinsics.checkNotNull(process.addOnSuccessListener(new OnSuccessListener() { // from class: uz.FonRo.pos.ui.scan.BarcodeAnalyzer$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    Function1.this.invoke(obj);
                }
            }).addOnCompleteListener(new OnCompleteListener() { // from class: uz.FonRo.pos.ui.scan.BarcodeAnalyzer$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    BarcodeAnalyzer.analyze$lambda$2(ImageProxy.this, task);
                }
            }));
        } catch (Throwable unused) {
            imageProxy.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit analyze$lambda$0(BarcodeAnalyzer barcodeAnalyzer, List list) {
        String str;
        String obj;
        Intrinsics.checkNotNull(list);
        Iterator it = list.iterator();
        do {
            str = null;
            if (!it.hasNext()) {
                break;
            }
            String rawValue = ((Barcode) it.next()).getRawValue();
            if (rawValue != null && (obj = StringsKt.trim((CharSequence) rawValue).toString()) != null && obj.length() > 0) {
                str = obj;
            }
        } while (str == null);
        if (str != null) {
            barcodeAnalyzer.onCode.invoke(str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void analyze$lambda$2(ImageProxy imageProxy, Task it) {
        Intrinsics.checkNotNullParameter(it, "it");
        imageProxy.close();
    }
}
