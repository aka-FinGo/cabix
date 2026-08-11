package androidx.camera.core;

import android.view.Display;

/* loaded from: classes.dex */
public final class DisplayOrientedMeteringPointFactory extends MeteringPointFactory {
    private final CameraInfo mCameraInfo;
    private final Display mDisplay;
    private final float mHeight;
    private final float mWidth;

    public DisplayOrientedMeteringPointFactory(Display display, CameraInfo cameraInfo, float f, float f2) {
        this.mWidth = f;
        this.mHeight = f2;
        this.mDisplay = display;
        this.mCameraInfo = cameraInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    @Override // androidx.camera.core.MeteringPointFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected android.graphics.PointF convertPoint(float r7, float r8) {
        /*
            r6 = this;
            float r0 = r6.mWidth
            float r1 = r6.mHeight
            androidx.camera.core.CameraInfo r2 = r6.mCameraInfo
            int r2 = r2.getLensFacing()
            if (r2 != 0) goto Le
            r2 = 1
            goto Lf
        Le:
            r2 = 0
        Lf:
            int r6 = r6.getRelativeCameraOrientation(r2)
            r3 = 270(0x10e, float:3.78E-43)
            r4 = 90
            if (r6 == r4) goto L22
            if (r6 != r3) goto L1c
            goto L22
        L1c:
            r5 = r8
            r8 = r7
            r7 = r5
            r5 = r1
            r1 = r0
            r0 = r5
        L22:
            if (r6 == r4) goto L30
            r4 = 180(0xb4, float:2.52E-43)
            if (r6 == r4) goto L2e
            if (r6 == r3) goto L2b
            goto L32
        L2b:
            float r8 = r1 - r8
            goto L32
        L2e:
            float r8 = r1 - r8
        L30:
            float r7 = r0 - r7
        L32:
            if (r2 == 0) goto L36
            float r8 = r1 - r8
        L36:
            float r8 = r8 / r1
            float r7 = r7 / r0
            android.graphics.PointF r6 = new android.graphics.PointF
            r6.<init>(r8, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.DisplayOrientedMeteringPointFactory.convertPoint(float, float):android.graphics.PointF");
    }

    private int getRelativeCameraOrientation(boolean z) {
        try {
            int sensorRotationDegrees = this.mCameraInfo.getSensorRotationDegrees(this.mDisplay.getRotation());
            return z ? (360 - sensorRotationDegrees) % 360 : sensorRotationDegrees;
        } catch (Exception unused) {
            return 0;
        }
    }
}
