package androidx.datastore.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataMigrationInitializer.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u0004*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0004B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/datastore/core/DataMigrationInitializer;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "Companion", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class DataMigrationInitializer<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: DataMigrationInitializer.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JV\u0010\u0003\u001a3\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00060\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\b\u0001\u0010\u00062\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000e0\r¢\u0006\u0002\u0010\u000fJ6\u0010\u0010\u001a\u00020\u000b\"\u0004\b\u0001\u0010\u00062\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000e0\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005H\u0082@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/datastore/core/DataMigrationInitializer$Companion;", "", "()V", "getInitializer", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/ParameterName;", "name", "api", "Lkotlin/coroutines/Continuation;", "", "migrations", "", "Landroidx/datastore/core/DataMigration;", "(Ljava/util/List;)Lkotlin/jvm/functions/Function2;", "runMigrations", "(Ljava/util/List;Landroidx/datastore/core/InitializerApi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> Function2<InitializerApi<T>, Continuation<? super Unit>, Object> getInitializer(List<? extends DataMigration<T>> migrations) {
            Intrinsics.checkNotNullParameter(migrations, "migrations");
            return new DataMigrationInitializer$Companion$getInitializer$1(migrations, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Throwable, T] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008e -> B:13:0x0071). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0091 -> B:13:0x0071). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final <T> java.lang.Object runMigrations(java.util.List<? extends androidx.datastore.core.DataMigration<T>> r6, androidx.datastore.core.InitializerApi<T> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
            /*
                r5 = this;
                boolean r0 = r8 instanceof androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                if (r0 == 0) goto L14
                r0 = r8
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = (androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r5 = r0.label
                int r5 = r5 - r2
                r0.label = r5
                goto L19
            L14:
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                r0.<init>(r5, r8)
            L19:
                java.lang.Object r5 = r0.result
                java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r0.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L47
                if (r1 == r3) goto L3f
                if (r1 != r2) goto L37
                java.lang.Object r6 = r0.L$1
                java.util.Iterator r6 = (java.util.Iterator) r6
                java.lang.Object r7 = r0.L$0
                kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
                kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L35
                goto L71
            L35:
                r5 = move-exception
                goto L8a
            L37:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L3f:
                java.lang.Object r6 = r0.L$0
                java.util.List r6 = (java.util.List) r6
                kotlin.ResultKt.throwOnFailure(r5)
                goto L65
            L47:
                kotlin.ResultKt.throwOnFailure(r5)
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                java.util.List r5 = (java.util.List) r5
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2 r1 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2
                r4 = 0
                r1.<init>(r6, r5, r4)
                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                r0.L$0 = r5
                r0.label = r3
                java.lang.Object r6 = r7.updateData(r1, r0)
                if (r6 != r8) goto L64
                goto L89
            L64:
                r6 = r5
            L65:
                kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
                r5.<init>()
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.Iterator r6 = r6.iterator()
                r7 = r5
            L71:
                boolean r5 = r6.hasNext()
                if (r5 == 0) goto L9c
                java.lang.Object r5 = r6.next()
                kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                r0.L$0 = r7     // Catch: java.lang.Throwable -> L35
                r0.L$1 = r6     // Catch: java.lang.Throwable -> L35
                r0.label = r2     // Catch: java.lang.Throwable -> L35
                java.lang.Object r5 = r5.invoke(r0)     // Catch: java.lang.Throwable -> L35
                if (r5 != r8) goto L71
            L89:
                return r8
            L8a:
                T r1 = r7.element
                if (r1 != 0) goto L91
                r7.element = r5
                goto L71
            L91:
                T r1 = r7.element
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                kotlin.ExceptionsKt.addSuppressed(r1, r5)
                goto L71
            L9c:
                T r5 = r7.element
                java.lang.Throwable r5 = (java.lang.Throwable) r5
                if (r5 != 0) goto La5
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            La5:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer.Companion.runMigrations(java.util.List, androidx.datastore.core.InitializerApi, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
