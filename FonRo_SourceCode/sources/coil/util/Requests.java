package coil.util;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.request.DefaultRequestOptions;
import coil.request.ImageRequest;
import coil.size.DisplaySizeResolver;
import coil.size.Precision;
import coil.size.ViewSizeResolver;
import coil.target.ViewTarget;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: Requests.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a3\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\u0010\u000b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\f\u001a\u00020\r*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"DEFAULT_REQUEST_OPTIONS", "Lcoil/request/DefaultRequestOptions;", "getDEFAULT_REQUEST_OPTIONS", "()Lcoil/request/DefaultRequestOptions;", "getDrawableCompat", "Landroid/graphics/drawable/Drawable;", "Lcoil/request/ImageRequest;", "drawable", "resId", "", "default", "(Lcoil/request/ImageRequest;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "allowInexactSize", "", "getAllowInexactSize", "(Lcoil/request/ImageRequest;)Z", "coil-base_release"}, k = 2, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: coil.util.-Requests, reason: invalid class name */
/* loaded from: classes5.dex */
public final class Requests {
    private static final DefaultRequestOptions DEFAULT_REQUEST_OPTIONS = new DefaultRequestOptions(null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, 32767, null);

    /* compiled from: Requests.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* renamed from: coil.util.-Requests$WhenMappings */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Precision.values().length];
            try {
                iArr[Precision.EXACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Precision.INEXACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Precision.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DefaultRequestOptions getDEFAULT_REQUEST_OPTIONS() {
        return DEFAULT_REQUEST_OPTIONS;
    }

    public static final Drawable getDrawableCompat(ImageRequest imageRequest, Drawable drawable, Integer num, Drawable drawable2) {
        if (drawable != null) {
            return drawable;
        }
        if (num == null) {
            return drawable2;
        }
        if (num.intValue() == 0) {
            return null;
        }
        return Contexts.getDrawableCompat(imageRequest.getContext(), num.intValue());
    }

    public static final boolean getAllowInexactSize(ImageRequest imageRequest) {
        int i = WhenMappings.$EnumSwitchMapping$0[imageRequest.getPrecision().ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (imageRequest.getDefined().getSizeResolver() == null && (imageRequest.getSizeResolver() instanceof DisplaySizeResolver)) {
            return true;
        }
        return (imageRequest.getTarget() instanceof ViewTarget) && (imageRequest.getSizeResolver() instanceof ViewSizeResolver) && (((ViewTarget) imageRequest.getTarget()).getView() instanceof ImageView) && ((ViewTarget) imageRequest.getTarget()).getView() == ((ViewSizeResolver) imageRequest.getSizeResolver()).getView();
    }
}
