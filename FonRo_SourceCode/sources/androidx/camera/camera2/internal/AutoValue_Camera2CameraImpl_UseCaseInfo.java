package androidx.camera.camera2.internal;

import android.util.Size;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoValue_Camera2CameraImpl_UseCaseInfo extends Camera2CameraImpl.UseCaseInfo {
    private final List<UseCaseConfigFactory.CaptureType> captureTypes;
    private final SessionConfig sessionConfig;
    private final StreamSpec streamSpec;
    private final Size surfaceResolution;
    private final UseCaseConfig<?> useCaseConfig;
    private final String useCaseId;
    private final Class<?> useCaseType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_Camera2CameraImpl_UseCaseInfo(String str, Class<?> cls, SessionConfig sessionConfig, UseCaseConfig<?> useCaseConfig, Size size, StreamSpec streamSpec, List<UseCaseConfigFactory.CaptureType> list) {
        if (str == null) {
            throw new NullPointerException("Null useCaseId");
        }
        this.useCaseId = str;
        if (cls == null) {
            throw new NullPointerException("Null useCaseType");
        }
        this.useCaseType = cls;
        if (sessionConfig == null) {
            throw new NullPointerException("Null sessionConfig");
        }
        this.sessionConfig = sessionConfig;
        if (useCaseConfig == null) {
            throw new NullPointerException("Null useCaseConfig");
        }
        this.useCaseConfig = useCaseConfig;
        this.surfaceResolution = size;
        this.streamSpec = streamSpec;
        this.captureTypes = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    public String getUseCaseId() {
        return this.useCaseId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    public Class<?> getUseCaseType() {
        return this.useCaseType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    public SessionConfig getSessionConfig() {
        return this.sessionConfig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    public UseCaseConfig<?> getUseCaseConfig() {
        return this.useCaseConfig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    public Size getSurfaceResolution() {
        return this.surfaceResolution;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    public StreamSpec getStreamSpec() {
        return this.streamSpec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    public List<UseCaseConfigFactory.CaptureType> getCaptureTypes() {
        return this.captureTypes;
    }

    public String toString() {
        return "UseCaseInfo{useCaseId=" + this.useCaseId + ", useCaseType=" + this.useCaseType + ", sessionConfig=" + this.sessionConfig + ", useCaseConfig=" + this.useCaseConfig + ", surfaceResolution=" + this.surfaceResolution + ", streamSpec=" + this.streamSpec + ", captureTypes=" + this.captureTypes + "}";
    }

    public boolean equals(Object obj) {
        Size size;
        StreamSpec streamSpec;
        List<UseCaseConfigFactory.CaptureType> list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof Camera2CameraImpl.UseCaseInfo) {
            Camera2CameraImpl.UseCaseInfo useCaseInfo = (Camera2CameraImpl.UseCaseInfo) obj;
            if (this.useCaseId.equals(useCaseInfo.getUseCaseId()) && this.useCaseType.equals(useCaseInfo.getUseCaseType()) && this.sessionConfig.equals(useCaseInfo.getSessionConfig()) && this.useCaseConfig.equals(useCaseInfo.getUseCaseConfig()) && ((size = this.surfaceResolution) != null ? size.equals(useCaseInfo.getSurfaceResolution()) : useCaseInfo.getSurfaceResolution() == null) && ((streamSpec = this.streamSpec) != null ? streamSpec.equals(useCaseInfo.getStreamSpec()) : useCaseInfo.getStreamSpec() == null) && ((list = this.captureTypes) != null ? list.equals(useCaseInfo.getCaptureTypes()) : useCaseInfo.getCaptureTypes() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((((this.useCaseId.hashCode() ^ 1000003) * 1000003) ^ this.useCaseType.hashCode()) * 1000003) ^ this.sessionConfig.hashCode()) * 1000003) ^ this.useCaseConfig.hashCode()) * 1000003;
        Size size = this.surfaceResolution;
        int hashCode2 = (hashCode ^ (size == null ? 0 : size.hashCode())) * 1000003;
        StreamSpec streamSpec = this.streamSpec;
        int hashCode3 = (hashCode2 ^ (streamSpec == null ? 0 : streamSpec.hashCode())) * 1000003;
        List<UseCaseConfigFactory.CaptureType> list = this.captureTypes;
        return hashCode3 ^ (list != null ? list.hashCode() : 0);
    }
}
