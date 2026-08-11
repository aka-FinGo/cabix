package androidx.datastore.core.okio;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.StorageConnection;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okio.FileSystem;
import okio.Path;

/* compiled from: OkioStorage.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0016JX\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0001\u0010\u00182B\u0010\u0019\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001a¢\u0006\u0002\b\"H\u0096@¢\u0006\u0002\u0010#J=\u0010$\u001a\u00020\r2-\u0010\u0019\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0 \u0012\u0006\u0012\u0004\u0018\u00010!0%¢\u0006\u0002\b\"H\u0096@¢\u0006\u0002\u0010'R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/datastore/core/okio/OkioStorageConnection;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/StorageConnection;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "onClose", "Lkotlin/Function0;", "", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;Landroidx/datastore/core/InterProcessCoordinator;Lkotlin/jvm/functions/Function0;)V", "closed", "Landroidx/datastore/core/okio/AtomicBoolean;", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "transactionMutex", "Lkotlinx/coroutines/sync/Mutex;", "checkNotClosed", "close", "readScope", "R", "block", "Lkotlin/Function3;", "Landroidx/datastore/core/ReadScope;", "", "Lkotlin/ParameterName;", "name", "locked", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeScope", "Lkotlin/Function2;", "Landroidx/datastore/core/WriteScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class OkioStorageConnection<T> implements StorageConnection<T> {
    private final AtomicBoolean closed;
    private final InterProcessCoordinator coordinator;
    private final FileSystem fileSystem;
    private final Function0<Unit> onClose;
    private final Path path;
    private final OkioSerializer<T> serializer;
    private final Mutex transactionMutex;

    public OkioStorageConnection(FileSystem fileSystem, Path path, OkioSerializer<T> serializer, InterProcessCoordinator coordinator, Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.fileSystem = fileSystem;
        this.path = path;
        this.serializer = serializer;
        this.coordinator = coordinator;
        this.onClose = onClose;
        this.closed = new AtomicBoolean(false);
        this.transactionMutex = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // androidx.datastore.core.StorageConnection
    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|7|(1:(3:10|11|12)(2:41|42))(5:43|44|45|46|(1:48)(1:49))|14|15|16|(2:(1:19)|20)(2:22|23)))|54|6|7|(0)(0)|14|15|16|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007b, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r11v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6 */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <R> java.lang.Object readScope(kotlin.jvm.functions.Function3<? super androidx.datastore.core.ReadScope<T>, ? super java.lang.Boolean, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r10, kotlin.coroutines.Continuation<? super R> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.datastore.core.okio.OkioStorageConnection$readScope$1
            if (r0 == 0) goto L14
            r0 = r11
            androidx.datastore.core.okio.OkioStorageConnection$readScope$1 r0 = (androidx.datastore.core.okio.OkioStorageConnection$readScope$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            androidx.datastore.core.okio.OkioStorageConnection$readScope$1 r0 = new androidx.datastore.core.okio.OkioStorageConnection$readScope$1
            r0.<init>(r9, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            boolean r9 = r0.Z$0
            java.lang.Object r10 = r0.L$1
            androidx.datastore.core.Closeable r10 = (androidx.datastore.core.Closeable) r10
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.okio.OkioStorageConnection r0 = (androidx.datastore.core.okio.OkioStorageConnection) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L35
            goto L76
        L35:
            r11 = move-exception
            r8 = r11
            r11 = r9
            r9 = r0
            r0 = r8
            goto L8e
        L3b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L43:
            kotlin.ResultKt.throwOnFailure(r11)
            r9.checkNotClosed()
            kotlinx.coroutines.sync.Mutex r11 = r9.transactionMutex
            boolean r11 = kotlinx.coroutines.sync.Mutex.DefaultImpls.tryLock$default(r11, r4, r3, r4)
            androidx.datastore.core.okio.OkioReadScope r2 = new androidx.datastore.core.okio.OkioReadScope     // Catch: java.lang.Throwable -> L97
            okio.FileSystem r5 = r9.fileSystem     // Catch: java.lang.Throwable -> L97
            okio.Path r6 = r9.path     // Catch: java.lang.Throwable -> L97
            androidx.datastore.core.okio.OkioSerializer<T> r7 = r9.serializer     // Catch: java.lang.Throwable -> L97
            r2.<init>(r5, r6, r7)     // Catch: java.lang.Throwable -> L97
            androidx.datastore.core.Closeable r2 = (androidx.datastore.core.Closeable) r2     // Catch: java.lang.Throwable -> L97
            r5 = r2
            androidx.datastore.core.okio.OkioReadScope r5 = (androidx.datastore.core.okio.OkioReadScope) r5     // Catch: java.lang.Throwable -> L8b
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)     // Catch: java.lang.Throwable -> L8b
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L8b
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L8b
            r0.Z$0 = r11     // Catch: java.lang.Throwable -> L8b
            r0.label = r3     // Catch: java.lang.Throwable -> L8b
            java.lang.Object r10 = r10.invoke(r5, r6, r0)     // Catch: java.lang.Throwable -> L8b
            if (r10 != r1) goto L72
            return r1
        L72:
            r0 = r9
            r9 = r11
            r11 = r10
            r10 = r2
        L76:
            r10.close()     // Catch: java.lang.Throwable -> L7b
            r10 = r4
            goto L7c
        L7b:
            r10 = move-exception
        L7c:
            if (r10 != 0) goto L86
            if (r9 == 0) goto L85
            kotlinx.coroutines.sync.Mutex r9 = r0.transactionMutex
            kotlinx.coroutines.sync.Mutex.DefaultImpls.unlock$default(r9, r4, r3, r4)
        L85:
            return r11
        L86:
            throw r10     // Catch: java.lang.Throwable -> L87
        L87:
            r10 = move-exception
            r11 = r9
            r9 = r0
            goto L98
        L8b:
            r10 = move-exception
            r0 = r10
            r10 = r2
        L8e:
            r10.close()     // Catch: java.lang.Throwable -> L92
            goto L96
        L92:
            r10 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r0, r10)     // Catch: java.lang.Throwable -> L97
        L96:
            throw r0     // Catch: java.lang.Throwable -> L97
        L97:
            r10 = move-exception
        L98:
            if (r11 == 0) goto L9f
            kotlinx.coroutines.sync.Mutex r9 = r9.transactionMutex
            kotlinx.coroutines.sync.Mutex.DefaultImpls.unlock$default(r9, r4, r3, r4)
        L9f:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioStorageConnection.readScope(kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d7 A[Catch: all -> 0x00fd, IOException -> 0x0100, TRY_ENTER, TryCatch #6 {IOException -> 0x0100, blocks: (B:20:0x00d7, B:22:0x00df, B:27:0x00ee, B:36:0x00f9, B:33:0x00fc), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ee A[Catch: all -> 0x00fd, IOException -> 0x0100, TRY_ENTER, TRY_LEAVE, TryCatch #6 {IOException -> 0x0100, blocks: (B:20:0x00d7, B:22:0x00df, B:27:0x00ee, B:36:0x00f9, B:33:0x00fc), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.coroutines.Continuation, java.lang.Object, androidx.datastore.core.okio.OkioStorageConnection$writeScope$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [okio.FileSystem] */
    /* JADX WARN: Type inference failed for: r10v1, types: [okio.Path] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v1, types: [okio.FileSystem] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, kotlinx.coroutines.sync.Mutex] */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object writeScope(kotlin.jvm.functions.Function2<? super androidx.datastore.core.WriteScope<T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioStorageConnection.writeScope(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.".toString());
        }
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }
}
