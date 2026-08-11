package coil.fetch;

import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.decode.DataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: FetchResult.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcoil/fetch/DrawableResult;", "Lcoil/fetch/FetchResult;", "drawable", "Landroid/graphics/drawable/Drawable;", "isSampled", "", "dataSource", "Lcoil/decode/DataSource;", "<init>", "(Landroid/graphics/drawable/Drawable;ZLcoil/decode/DataSource;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "()Z", "getDataSource", "()Lcoil/decode/DataSource;", "copy", "equals", WriteOffReason.OTHER, "", "hashCode", "", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class DrawableResult extends FetchResult {
    private final DataSource dataSource;
    private final Drawable drawable;
    private final boolean isSampled;

    public final Drawable getDrawable() {
        return this.drawable;
    }

    /* renamed from: isSampled, reason: from getter */
    public final boolean getIsSampled() {
        return this.isSampled;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public DrawableResult(Drawable drawable, boolean z, DataSource dataSource) {
        super(null);
        this.drawable = drawable;
        this.isSampled = z;
        this.dataSource = dataSource;
    }

    public static /* synthetic */ DrawableResult copy$default(DrawableResult drawableResult, Drawable drawable, boolean z, DataSource dataSource, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable = drawableResult.drawable;
        }
        if ((i & 2) != 0) {
            z = drawableResult.isSampled;
        }
        if ((i & 4) != 0) {
            dataSource = drawableResult.dataSource;
        }
        return drawableResult.copy(drawable, z, dataSource);
    }

    public final DrawableResult copy(Drawable drawable, boolean isSampled, DataSource dataSource) {
        return new DrawableResult(drawable, isSampled, dataSource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DrawableResult)) {
            return false;
        }
        DrawableResult drawableResult = (DrawableResult) other;
        return Intrinsics.areEqual(this.drawable, drawableResult.drawable) && this.isSampled == drawableResult.isSampled && this.dataSource == drawableResult.dataSource;
    }

    public int hashCode() {
        return (((this.drawable.hashCode() * 31) + Boolean.hashCode(this.isSampled)) * 31) + this.dataSource.hashCode();
    }
}
