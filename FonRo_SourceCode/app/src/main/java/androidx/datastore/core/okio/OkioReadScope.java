package androidx.datastore.core.okio;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.datastore.core.ReadScope;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okio.FileSystem;
import okio.Path;

/* compiled from: OkioStorage.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0004J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u0010\u0015\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Landroidx/datastore/core/okio/OkioReadScope;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/ReadScope;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;)V", "closed", "Landroidx/datastore/core/okio/AtomicBoolean;", "getFileSystem", "()Lokio/FileSystem;", "getPath", "()Lokio/Path;", "getSerializer", "()Landroidx/datastore/core/okio/OkioSerializer;", "checkClose", "", "close", "readData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public class OkioReadScope<T> implements ReadScope<T> {
    private final AtomicBoolean closed;
    private final FileSystem fileSystem;
    private final Path path;
    private final OkioSerializer<T> serializer;

    @Override // androidx.datastore.core.ReadScope
    public Object readData(Continuation<? super T> continuation) {
        return readData$suspendImpl(this, continuation);
    }

    public OkioReadScope(FileSystem fileSystem, Path path, OkioSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.fileSystem = fileSystem;
        this.path = path;
        this.serializer = serializer;
        this.closed = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FileSystem getFileSystem() {
        return this.fileSystem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Path getPath() {
        return this.path;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final OkioSerializer<T> getSerializer() {
        return this.serializer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:(5:11|12|13|(2:20|21)|(2:16|17)(1:19))(2:33|34))(3:35|36|37))(7:57|58|59|60|61|(1:63)|64)|(2:44|45)|39|(2:41|42)(1:43)))|83|6|7|(0)(0)|(0)|39|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0091, code lost:
    
        r8 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0097 A[Catch: FileNotFoundException -> 0x0091, TryCatch #2 {FileNotFoundException -> 0x0091, blocks: (B:41:0x0097, B:43:0x009b, B:56:0x008d, B:53:0x0088), top: B:7:0x0024, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009b A[Catch: FileNotFoundException -> 0x0091, TRY_LEAVE, TryCatch #2 {FileNotFoundException -> 0x0091, blocks: (B:41:0x0097, B:43:0x009b, B:56:0x008d, B:53:0x0088), top: B:7:0x0024, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v15, types: [androidx.datastore.core.okio.OkioReadScope] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ <T> java.lang.Object readData$suspendImpl(androidx.datastore.core.okio.OkioReadScope<T> r8, kotlin.coroutines.Continuation<? super T> r9) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioReadScope.readData$suspendImpl(androidx.datastore.core.okio.OkioReadScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkClose() {
        if (this.closed.get()) {
            throw new IllegalStateException("This scope has already been closed.".toString());
        }
    }
}
