package coil.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import coil.size.Size;
import kotlin.Metadata;

/* compiled from: HardwareBitmaps.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcoil/util/ImmutableHardwareBitmapService;", "Lcoil/util/HardwareBitmapService;", "allowHardware", "", "<init>", "(Z)V", "allowHardwareMainThread", "size", "Lcoil/size/Size;", "allowHardwareWorkerThread", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
final class ImmutableHardwareBitmapService implements HardwareBitmapService {
    private final boolean allowHardware;

    public ImmutableHardwareBitmapService(boolean z) {
        this.allowHardware = z;
    }

    @Override // coil.util.HardwareBitmapService
    public boolean allowHardwareMainThread(Size size) {
        return this.allowHardware;
    }

    @Override // coil.util.HardwareBitmapService
    /* renamed from: allowHardwareWorkerThread, reason: from getter */
    public boolean getAllowHardware() {
        return this.allowHardware;
    }
}
