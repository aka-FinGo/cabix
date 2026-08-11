package coil.key;

import androidx.constraintlayout.widget.ConstraintLayout;
import coil.request.Options;
import java.io.File;
import kotlin.Metadata;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: FileKeyer.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcoil/key/FileKeyer;", "Lcoil/key/Keyer;", "Ljava/io/File;", "addLastModifiedToFileCacheKey", "", "<init>", "(Z)V", "key", "", "data", "options", "Lcoil/request/Options;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class FileKeyer implements Keyer<File> {
    private final boolean addLastModifiedToFileCacheKey;

    public FileKeyer(boolean z) {
        this.addLastModifiedToFileCacheKey = z;
    }

    @Override // coil.key.Keyer
    public String key(File data, Options options) {
        if (this.addLastModifiedToFileCacheKey) {
            return data.getPath() + AbstractJsonLexerKt.COLON + data.lastModified();
        }
        return data.getPath();
    }
}
