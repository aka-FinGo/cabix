package androidx.work.impl.utils;

import android.net.NetworkRequest;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: NetworkRequestCompat.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Landroidx/work/impl/utils/NetworkRequestCompat;", "", "wrapped", "(Ljava/lang/Object;)V", "networkRequest", "Landroid/net/NetworkRequest;", "getNetworkRequest", "()Landroid/net/NetworkRequest;", "getWrapped", "()Ljava/lang/Object;", "component1", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "", "Companion", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final /* data */ class NetworkRequestCompat {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG;
    private final Object wrapped;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NetworkRequestCompat() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.NetworkRequestCompat.<init>():void");
    }

    public static /* synthetic */ NetworkRequestCompat copy$default(NetworkRequestCompat networkRequestCompat, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = networkRequestCompat.wrapped;
        }
        return networkRequestCompat.copy(obj);
    }

    /* renamed from: component1, reason: from getter */
    public final Object getWrapped() {
        return this.wrapped;
    }

    public final NetworkRequestCompat copy(Object wrapped) {
        return new NetworkRequestCompat(wrapped);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof NetworkRequestCompat) && Intrinsics.areEqual(this.wrapped, ((NetworkRequestCompat) other).wrapped);
    }

    public int hashCode() {
        Object obj = this.wrapped;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "NetworkRequestCompat(wrapped=" + this.wrapped + ')';
    }

    public NetworkRequestCompat(Object obj) {
        this.wrapped = obj;
    }

    public /* synthetic */ NetworkRequestCompat(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj);
    }

    public final Object getWrapped() {
        return this.wrapped;
    }

    /* compiled from: NetworkRequestCompat.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/work/impl/utils/NetworkRequestCompat$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return NetworkRequestCompat.TAG;
        }
    }

    static {
        String tagWithPrefix = Logger.tagWithPrefix("NetworkRequestCompat");
        Intrinsics.checkNotNullExpressionValue(tagWithPrefix, "tagWithPrefix(\"NetworkRequestCompat\")");
        TAG = tagWithPrefix;
    }

    public final NetworkRequest getNetworkRequest() {
        return (NetworkRequest) this.wrapped;
    }
}
