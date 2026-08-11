package coil.fetch;

import androidx.constraintlayout.widget.ConstraintLayout;
import coil.decode.DataSource;
import coil.decode.ImageSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: FetchResult.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcoil/fetch/SourceResult;", "Lcoil/fetch/FetchResult;", FirebaseAnalytics.Param.SOURCE, "Lcoil/decode/ImageSource;", "mimeType", "", "dataSource", "Lcoil/decode/DataSource;", "<init>", "(Lcoil/decode/ImageSource;Ljava/lang/String;Lcoil/decode/DataSource;)V", "getSource", "()Lcoil/decode/ImageSource;", "getMimeType", "()Ljava/lang/String;", "getDataSource", "()Lcoil/decode/DataSource;", "copy", "equals", "", WriteOffReason.OTHER, "", "hashCode", "", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class SourceResult extends FetchResult {
    private final DataSource dataSource;
    private final String mimeType;
    private final ImageSource source;

    public final ImageSource getSource() {
        return this.source;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public SourceResult(ImageSource imageSource, String str, DataSource dataSource) {
        super(null);
        this.source = imageSource;
        this.mimeType = str;
        this.dataSource = dataSource;
    }

    public static /* synthetic */ SourceResult copy$default(SourceResult sourceResult, ImageSource imageSource, String str, DataSource dataSource, int i, Object obj) {
        if ((i & 1) != 0) {
            imageSource = sourceResult.source;
        }
        if ((i & 2) != 0) {
            str = sourceResult.mimeType;
        }
        if ((i & 4) != 0) {
            dataSource = sourceResult.dataSource;
        }
        return sourceResult.copy(imageSource, str, dataSource);
    }

    public final SourceResult copy(ImageSource source, String mimeType, DataSource dataSource) {
        return new SourceResult(source, mimeType, dataSource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SourceResult)) {
            return false;
        }
        SourceResult sourceResult = (SourceResult) other;
        return Intrinsics.areEqual(this.source, sourceResult.source) && Intrinsics.areEqual(this.mimeType, sourceResult.mimeType) && this.dataSource == sourceResult.dataSource;
    }

    public int hashCode() {
        int hashCode = this.source.hashCode() * 31;
        String str = this.mimeType;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.dataSource.hashCode();
    }
}
