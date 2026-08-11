package coil.fetch;

import android.webkit.MimeTypeMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.ImageSources;
import coil.fetch.Fetcher;
import coil.request.Options;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.io.FilesKt;
import okio.Path;

/* compiled from: FileFetcher.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcoil/fetch/FileFetcher;", "Lcoil/fetch/Fetcher;", "data", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "fetch", "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class FileFetcher implements Fetcher {
    private final File data;

    public FileFetcher(File file) {
        this.data = file;
    }

    @Override // coil.fetch.Fetcher
    public Object fetch(Continuation<? super FetchResult> continuation) {
        return new SourceResult(ImageSources.create$default(Path.Companion.get$default(Path.INSTANCE, this.data, false, 1, (Object) null), null, null, null, 14, null), MimeTypeMap.getSingleton().getMimeTypeFromExtension(FilesKt.getExtension(this.data)), DataSource.DISK);
    }

    /* compiled from: FileFetcher.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcoil/fetch/FileFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Ljava/io/File;", "<init>", "()V", "create", "Lcoil/fetch/Fetcher;", "data", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Factory implements Fetcher.Factory<File> {
        @Override // coil.fetch.Fetcher.Factory
        public Fetcher create(File data, Options options, ImageLoader imageLoader) {
            return new FileFetcher(data);
        }
    }
}
