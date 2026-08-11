package androidx.datastore.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: FileStorage.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0016JX\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0001\u0010\u00162B\u0010\u0017\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0018¢\u0006\u0002\b H\u0096@¢\u0006\u0002\u0010!J=\u0010\"\u001a\u00020\u000b2-\u0010\u0017\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0#¢\u0006\u0002\b H\u0096@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020\u000b*\u00020\u0004H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/datastore/core/FileStorageConnection;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/StorageConnection;", "file", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "onClose", "Lkotlin/Function0;", "", "(Ljava/io/File;Landroidx/datastore/core/Serializer;Landroidx/datastore/core/InterProcessCoordinator;Lkotlin/jvm/functions/Function0;)V", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "transactionMutex", "Lkotlinx/coroutines/sync/Mutex;", "checkNotClosed", "close", "readScope", "R", "block", "Lkotlin/Function3;", "Landroidx/datastore/core/ReadScope;", "", "Lkotlin/ParameterName;", "name", "locked", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeScope", "Lkotlin/Function2;", "Landroidx/datastore/core/WriteScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createParentDirectories", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class FileStorageConnection<T> implements StorageConnection<T> {
    private final java.util.concurrent.atomic.AtomicBoolean closed;
    private final InterProcessCoordinator coordinator;
    private final File file;
    private final Function0<Unit> onClose;
    private final Serializer<T> serializer;
    private final Mutex transactionMutex;

    public FileStorageConnection(File file, Serializer<T> serializer, InterProcessCoordinator coordinator, Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.file = file;
        this.serializer = serializer;
        this.coordinator = coordinator;
        this.onClose = onClose;
        this.closed = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.transactionMutex = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // androidx.datastore.core.StorageConnection
    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|7|(1:(3:10|11|12)(2:41|42))(5:43|44|45|46|(1:48)(1:49))|14|15|16|(2:(1:19)|20)(2:22|23)))|54|6|7|(0)(0)|14|15|16|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0079, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r10v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6 */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <R> java.lang.Object readScope(kotlin.jvm.functions.Function3<? super androidx.datastore.core.ReadScope<T>, ? super java.lang.Boolean, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r9, kotlin.coroutines.Continuation<? super R> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.FileStorageConnection$readScope$1
            if (r0 == 0) goto L14
            r0 = r10
            androidx.datastore.core.FileStorageConnection$readScope$1 r0 = (androidx.datastore.core.FileStorageConnection$readScope$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            androidx.datastore.core.FileStorageConnection$readScope$1 r0 = new androidx.datastore.core.FileStorageConnection$readScope$1
            r0.<init>(r8, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            boolean r8 = r0.Z$0
            java.lang.Object r9 = r0.L$1
            androidx.datastore.core.Closeable r9 = (androidx.datastore.core.Closeable) r9
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.FileStorageConnection r0 = (androidx.datastore.core.FileStorageConnection) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L35
            goto L74
        L35:
            r10 = move-exception
            r7 = r10
            r10 = r8
            r8 = r0
            r0 = r7
            goto L8c
        L3b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L43:
            kotlin.ResultKt.throwOnFailure(r10)
            r8.checkNotClosed()
            kotlinx.coroutines.sync.Mutex r10 = r8.transactionMutex
            boolean r10 = kotlinx.coroutines.sync.Mutex.DefaultImpls.tryLock$default(r10, r4, r3, r4)
            androidx.datastore.core.FileReadScope r2 = new androidx.datastore.core.FileReadScope     // Catch: java.lang.Throwable -> L95
            java.io.File r5 = r8.file     // Catch: java.lang.Throwable -> L95
            androidx.datastore.core.Serializer<T> r6 = r8.serializer     // Catch: java.lang.Throwable -> L95
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L95
            androidx.datastore.core.Closeable r2 = (androidx.datastore.core.Closeable) r2     // Catch: java.lang.Throwable -> L95
            r5 = r2
            androidx.datastore.core.FileReadScope r5 = (androidx.datastore.core.FileReadScope) r5     // Catch: java.lang.Throwable -> L89
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)     // Catch: java.lang.Throwable -> L89
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L89
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L89
            r0.Z$0 = r10     // Catch: java.lang.Throwable -> L89
            r0.label = r3     // Catch: java.lang.Throwable -> L89
            java.lang.Object r9 = r9.invoke(r5, r6, r0)     // Catch: java.lang.Throwable -> L89
            if (r9 != r1) goto L70
            return r1
        L70:
            r0 = r8
            r8 = r10
            r10 = r9
            r9 = r2
        L74:
            r9.close()     // Catch: java.lang.Throwable -> L79
            r9 = r4
            goto L7a
        L79:
            r9 = move-exception
        L7a:
            if (r9 != 0) goto L84
            if (r8 == 0) goto L83
            kotlinx.coroutines.sync.Mutex r8 = r0.transactionMutex
            kotlinx.coroutines.sync.Mutex.DefaultImpls.unlock$default(r8, r4, r3, r4)
        L83:
            return r10
        L84:
            throw r9     // Catch: java.lang.Throwable -> L85
        L85:
            r9 = move-exception
            r10 = r8
            r8 = r0
            goto L96
        L89:
            r9 = move-exception
            r0 = r9
            r9 = r2
        L8c:
            r9.close()     // Catch: java.lang.Throwable -> L90
            goto L94
        L90:
            r9 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r0, r9)     // Catch: java.lang.Throwable -> L95
        L94:
            throw r0     // Catch: java.lang.Throwable -> L95
        L95:
            r9 = move-exception
        L96:
            if (r10 == 0) goto L9d
            kotlinx.coroutines.sync.Mutex r8 = r8.transactionMutex
            kotlinx.coroutines.sync.Mutex.DefaultImpls.unlock$default(r8, r4, r3, r4)
        L9d:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileStorageConnection.readScope(kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(9:(2:3|(12:5|6|7|(1:(1:(8:11|12|13|14|16|17|18|(5:20|(2:25|26)|28|29|30)(1:31))(2:41|42))(1:43))(1:66)|44|45|46|47|48|49|(6:52|14|16|17|18|(0)(0))|51))|44|45|46|47|48|49|(0)|51)|7|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0077, code lost:
    
        if (r3 == r2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0108, code lost:
    
        r8 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0109, code lost:
    
        r10 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c1 A[Catch: all -> 0x0108, IOException -> 0x010b, TRY_ENTER, TryCatch #2 {all -> 0x0108, blocks: (B:20:0x00c1, B:22:0x00c7, B:25:0x00d0, B:26:0x00f0, B:28:0x00f1, B:31:0x00f9, B:40:0x0104, B:37:0x0107), top: B:7:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f9 A[Catch: all -> 0x0108, IOException -> 0x010b, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0108, blocks: (B:20:0x00c1, B:22:0x00c7, B:25:0x00d0, B:26:0x00f0, B:28:0x00f1, B:31:0x00f9, B:40:0x0104, B:37:0x0107), top: B:7:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.io.File] */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object writeScope(kotlin.jvm.functions.Function2<? super androidx.datastore.core.WriteScope<T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileStorageConnection.writeScope(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.".toString());
        }
    }

    private final void createParentDirectories(File file) {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (parentFile.isDirectory()) {
                return;
            }
            throw new IOException("Unable to create parent directories of " + file);
        }
    }
}
