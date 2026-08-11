package androidx.datastore.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileStorage.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Landroidx/datastore/core/FileWriteScope;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/FileReadScope;", "Landroidx/datastore/core/WriteScope;", "file", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "(Ljava/io/File;Landroidx/datastore/core/Serializer;)V", "writeData", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class FileWriteScope<T> extends FileReadScope<T> implements WriteScope<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileWriteScope(File file, Serializer<T> serializer) {
        super(file, serializer);
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.datastore.core.WriteScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object writeData(T r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.datastore.core.FileWriteScope$writeData$1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.datastore.core.FileWriteScope$writeData$1 r0 = (androidx.datastore.core.FileWriteScope$writeData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.datastore.core.FileWriteScope$writeData$1 r0 = new androidx.datastore.core.FileWriteScope$writeData$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r5 = r0.L$1
            java.io.FileOutputStream r5 = (java.io.FileOutputStream) r5
            java.lang.Object r6 = r0.L$0
            java.io.Closeable r6 = (java.io.Closeable) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L32
            goto L6a
        L32:
            r5 = move-exception
            goto L7c
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.ResultKt.throwOnFailure(r7)
            r5.checkNotClosed()
            java.io.FileOutputStream r7 = new java.io.FileOutputStream
            java.io.File r2 = r5.getFile()
            r7.<init>(r2)
            java.io.Closeable r7 = (java.io.Closeable) r7
            r2 = r7
            java.io.FileOutputStream r2 = (java.io.FileOutputStream) r2     // Catch: java.lang.Throwable -> L7a
            androidx.datastore.core.Serializer r5 = r5.getSerializer()     // Catch: java.lang.Throwable -> L7a
            androidx.datastore.core.UncloseableOutputStream r4 = new androidx.datastore.core.UncloseableOutputStream     // Catch: java.lang.Throwable -> L7a
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L7a
            java.io.OutputStream r4 = (java.io.OutputStream) r4     // Catch: java.lang.Throwable -> L7a
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L7a
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L7a
            r0.label = r3     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r5 = r5.writeTo(r6, r4, r0)     // Catch: java.lang.Throwable -> L7a
            if (r5 != r1) goto L68
            return r1
        L68:
            r6 = r7
            r5 = r2
        L6a:
            java.io.FileDescriptor r5 = r5.getFD()     // Catch: java.lang.Throwable -> L32
            r5.sync()     // Catch: java.lang.Throwable -> L32
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L32
            r5 = 0
            kotlin.io.CloseableKt.closeFinally(r6, r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L7a:
            r5 = move-exception
            r6 = r7
        L7c:
            throw r5     // Catch: java.lang.Throwable -> L7d
        L7d:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileWriteScope.writeData(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
