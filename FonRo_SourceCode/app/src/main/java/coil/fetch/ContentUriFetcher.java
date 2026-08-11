package coil.fetch;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.ImageLoader;
import coil.decode.ContentMetadata;
import coil.decode.DataSource;
import coil.decode.ImageSources;
import coil.fetch.Fetcher;
import coil.request.Options;
import coil.size.Dimension;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileInputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;

/* compiled from: ContentUriFetcher.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\b\rJ\u0015\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\b\u000fJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcoil/fetch/ContentUriFetcher;", "Lcoil/fetch/Fetcher;", "data", "Landroid/net/Uri;", "options", "Lcoil/request/Options;", "<init>", "(Landroid/net/Uri;Lcoil/request/Options;)V", "fetch", "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isContactPhotoUri", "", "isContactPhotoUri$coil_base_release", "isMusicThumbnailUri", "isMusicThumbnailUri$coil_base_release", "newMusicThumbnailSizeOptions", "Landroid/os/Bundle;", "Factory", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class ContentUriFetcher implements Fetcher {
    private final Uri data;
    private final Options options;

    public ContentUriFetcher(Uri uri, Options options) {
        this.data = uri;
        this.options = options;
    }

    @Override // coil.fetch.Fetcher
    public Object fetch(Continuation<? super FetchResult> continuation) {
        FileInputStream openInputStream;
        AssetFileDescriptor openTypedAssetFile;
        FileInputStream createInputStream;
        ContentResolver contentResolver = this.options.getContext().getContentResolver();
        if (isContactPhotoUri$coil_base_release(this.data)) {
            AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.data, "r");
            createInputStream = openAssetFileDescriptor != null ? openAssetFileDescriptor.createInputStream() : null;
            if (createInputStream == null) {
                throw new IllegalStateException(("Unable to find a contact photo associated with '" + this.data + "'.").toString());
            }
            openInputStream = createInputStream;
        } else if (Build.VERSION.SDK_INT >= 29 && isMusicThumbnailUri$coil_base_release(this.data)) {
            openTypedAssetFile = contentResolver.openTypedAssetFile(this.data, "image/*", newMusicThumbnailSizeOptions(), null);
            createInputStream = openTypedAssetFile != null ? openTypedAssetFile.createInputStream() : null;
            if (createInputStream == null) {
                throw new IllegalStateException(("Unable to find a music thumbnail associated with '" + this.data + "'.").toString());
            }
            openInputStream = createInputStream;
        } else {
            openInputStream = contentResolver.openInputStream(this.data);
            if (openInputStream == null) {
                throw new IllegalStateException(("Unable to open '" + this.data + "'.").toString());
            }
        }
        return new SourceResult(ImageSources.create(Okio.buffer(Okio.source(openInputStream)), this.options.getContext(), new ContentMetadata(this.data)), contentResolver.getType(this.data), DataSource.DISK);
    }

    public final boolean isContactPhotoUri$coil_base_release(Uri data) {
        return Intrinsics.areEqual(data.getAuthority(), "com.android.contacts") && Intrinsics.areEqual(data.getLastPathSegment(), "display_photo");
    }

    public final boolean isMusicThumbnailUri$coil_base_release(Uri data) {
        List<String> pathSegments;
        int size;
        return Intrinsics.areEqual(data.getAuthority(), "media") && (size = (pathSegments = data.getPathSegments()).size()) >= 3 && Intrinsics.areEqual(pathSegments.get(size + (-3)), "audio") && Intrinsics.areEqual(pathSegments.get(size + (-2)), "albums");
    }

    private final Bundle newMusicThumbnailSizeOptions() {
        Dimension width = this.options.getSize().getWidth();
        Dimension.Pixels pixels = width instanceof Dimension.Pixels ? (Dimension.Pixels) width : null;
        if (pixels != null) {
            int i = pixels.px;
            Dimension height = this.options.getSize().getHeight();
            Dimension.Pixels pixels2 = height instanceof Dimension.Pixels ? (Dimension.Pixels) height : null;
            if (pixels2 != null) {
                int i2 = pixels2.px;
                Bundle bundle = new Bundle(1);
                bundle.putParcelable("android.content.extra.SIZE", new Point(i, i2));
                return bundle;
            }
        }
        return null;
    }

    /* compiled from: ContentUriFetcher.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcoil/fetch/ContentUriFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Landroid/net/Uri;", "<init>", "()V", "create", "Lcoil/fetch/Fetcher;", "data", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "isApplicable", "", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Factory implements Fetcher.Factory<Uri> {
        @Override // coil.fetch.Fetcher.Factory
        public Fetcher create(Uri data, Options options, ImageLoader imageLoader) {
            if (isApplicable(data)) {
                return new ContentUriFetcher(data, options);
            }
            return null;
        }

        private final boolean isApplicable(Uri data) {
            return Intrinsics.areEqual(data.getScheme(), FirebaseAnalytics.Param.CONTENT);
        }
    }
}
