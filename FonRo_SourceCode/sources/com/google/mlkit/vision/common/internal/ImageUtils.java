package com.google.mlkit.vision.common.internal;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:vision-common@@17.3.0 */
/* loaded from: classes5.dex */
public class ImageUtils {
    private static final GmsLogger zza = new GmsLogger("MLKitImageUtils", "");
    private static final ImageUtils zzb = new ImageUtils();

    private ImageUtils() {
    }

    public static ImageUtils getInstance() {
        return zzb;
    }

    public IObjectWrapper getImageDataWrapper(InputImage inputImage) throws MlKitException {
        int format = inputImage.getFormat();
        if (format != -1) {
            if (format != 17) {
                if (format == 35) {
                    return ObjectWrapper.wrap(inputImage.getMediaImage());
                }
                if (format != 842094169) {
                    throw new MlKitException("Unsupported image format: " + inputImage.getFormat(), 3);
                }
            }
            return ObjectWrapper.wrap((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer()));
        }
        return ObjectWrapper.wrap((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal()));
    }

    public int getMobileVisionImageFormat(InputImage inputImage) {
        return inputImage.getFormat();
    }

    public int getMobileVisionImageSize(InputImage inputImage) {
        if (inputImage.getFormat() == -1) {
            return ((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal())).getAllocationByteCount();
        }
        if (inputImage.getFormat() == 17 || inputImage.getFormat() == 842094169) {
            return ((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer())).limit();
        }
        if (inputImage.getFormat() != 35) {
            return 0;
        }
        return (((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes()))[0].getBuffer().limit() * 3) / 2;
    }

    public Matrix getUprightRotationMatrix(int i, int i2, int i3) {
        if (i3 == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((-i) / 2.0f, (-i2) / 2.0f);
        matrix.postRotate(i3 * 90);
        int i4 = i3 % 2;
        int i5 = i4 != 0 ? i2 : i;
        if (i4 == 0) {
            i = i2;
        }
        matrix.postTranslate(i5 / 2.0f, i / 2.0f);
        return matrix;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x008f A[PHI: r4
      0x008f: PHI (r4v3 android.graphics.Matrix) = (r4v0 android.graphics.Matrix), (r4v1 android.graphics.Matrix) binds: [B:10:0x008c, B:27:0x00b2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00bd A[Catch: FileNotFoundException -> 0x00d3, TryCatch #4 {FileNotFoundException -> 0x00d3, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:35:0x0070, B:41:0x005a, B:63:0x00cb, B:64:0x00d2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0091 A[Catch: FileNotFoundException -> 0x00d3, TryCatch #4 {FileNotFoundException -> 0x00d3, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:35:0x0070, B:41:0x005a, B:63:0x00cb, B:64:0x00d2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0095 A[Catch: FileNotFoundException -> 0x00d3, TryCatch #4 {FileNotFoundException -> 0x00d3, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:35:0x0070, B:41:0x005a, B:63:0x00cb, B:64:0x00d2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009c A[Catch: FileNotFoundException -> 0x00d3, TryCatch #4 {FileNotFoundException -> 0x00d3, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:35:0x0070, B:41:0x005a, B:63:0x00cb, B:64:0x00d2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a0 A[Catch: FileNotFoundException -> 0x00d3, TryCatch #4 {FileNotFoundException -> 0x00d3, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:35:0x0070, B:41:0x005a, B:63:0x00cb, B:64:0x00d2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a7 A[Catch: FileNotFoundException -> 0x00d3, TryCatch #4 {FileNotFoundException -> 0x00d3, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:35:0x0070, B:41:0x005a, B:63:0x00cb, B:64:0x00d2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ab A[Catch: FileNotFoundException -> 0x00d3, TryCatch #4 {FileNotFoundException -> 0x00d3, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:35:0x0070, B:41:0x005a, B:63:0x00cb, B:64:0x00d2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b2 A[Catch: FileNotFoundException -> 0x00d3, TryCatch #4 {FileNotFoundException -> 0x00d3, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:35:0x0070, B:41:0x005a, B:63:0x00cb, B:64:0x00d2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0070 A[Catch: FileNotFoundException -> 0x00d3, TryCatch #4 {FileNotFoundException -> 0x00d3, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:9:0x0077, B:10:0x008c, B:13:0x00bd, B:15:0x00c6, B:20:0x0091, B:22:0x0095, B:23:0x009c, B:24:0x00a0, B:25:0x00a7, B:26:0x00ab, B:27:0x00b2, B:35:0x0070, B:41:0x005a, B:63:0x00cb, B:64:0x00d2), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap zza(android.content.ContentResolver r10, android.net.Uri r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.common.internal.ImageUtils.zza(android.content.ContentResolver, android.net.Uri):android.graphics.Bitmap");
    }
}
