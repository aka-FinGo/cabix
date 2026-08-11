package androidx.datastore.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.datastore.core.Message;
import androidx.datastore.core.UpdatingDataContextElement;
import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: DataStoreImpl.kt */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 V*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002VWBn\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012?\b\u0002\u0010\u0005\u001a9\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00070\u0006\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u000e\u00103\u001a\u00020\rH\u0082@¢\u0006\u0002\u00104JG\u00105\u001a\u0002H6\"\u0004\b\u0001\u001062\u0006\u00107\u001a\u0002082\u001c\u00109\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H60\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0:H\u0082@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010;J\u001c\u0010<\u001a\u00020\r2\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0082@¢\u0006\u0002\u0010>J\u000e\u0010?\u001a\u00020\rH\u0082@¢\u0006\u0002\u00104J\u000e\u0010@\u001a\u00020\rH\u0082@¢\u0006\u0002\u00104J\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000B2\u0006\u0010C\u001a\u000208H\u0082@¢\u0006\u0002\u0010DJ\u000e\u0010E\u001a\u00028\u0000H\u0082@¢\u0006\u0002\u00104J\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000G2\u0006\u00107\u001a\u000208H\u0082@¢\u0006\u0002\u0010DJ\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000B2\u0006\u0010C\u001a\u000208H\u0082@¢\u0006\u0002\u0010DJI\u0010I\u001a\u00028\u000021\u0010J\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(K\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00072\u0006\u0010L\u001a\u00020MH\u0082@¢\u0006\u0002\u0010NJA\u0010O\u001a\u00028\u000021\u0010J\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(K\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007H\u0096@¢\u0006\u0002\u0010PJ \u0010Q\u001a\u00020\u00152\u0006\u0010R\u001a\u00028\u00002\u0006\u0010S\u001a\u000208H\u0080@¢\u0006\u0004\bT\u0010UR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010&\u001a\f0'R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)8@X\u0080\u0084\u0002¢\u0006\f\u001a\u0004\b,\u0010-*\u0004\b*\u0010+R\u001a\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000)0/X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000201X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Landroidx/datastore/core/DataStoreImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/DataStore;", "storage", "Landroidx/datastore/core/Storage;", "initTasksList", "", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/coroutines/Continuation;", "", "", "corruptionHandler", "Landroidx/datastore/core/CorruptionHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/datastore/core/Storage;Ljava/util/List;Landroidx/datastore/core/CorruptionHandler;Lkotlinx/coroutines/CoroutineScope;)V", "collectorCounter", "", "collectorJob", "Lkotlinx/coroutines/Job;", "collectorMutex", "Lkotlinx/coroutines/sync/Mutex;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "coordinator$delegate", "Lkotlin/Lazy;", "data", "Lkotlinx/coroutines/flow/Flow;", "getData", "()Lkotlinx/coroutines/flow/Flow;", "inMemoryCache", "Landroidx/datastore/core/DataStoreInMemoryCache;", "readAndInit", "Landroidx/datastore/core/DataStoreImpl$InitDataStore;", "storageConnection", "Landroidx/datastore/core/StorageConnection;", "getStorageConnection$datastore_core_release$delegate", "(Landroidx/datastore/core/DataStoreImpl;)Ljava/lang/Object;", "getStorageConnection$datastore_core_release", "()Landroidx/datastore/core/StorageConnection;", "storageConnectionDelegate", "Lkotlin/Lazy;", "writeActor", "Landroidx/datastore/core/SimpleActor;", "Landroidx/datastore/core/Message$Update;", "decrementCollector", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doWithWriteFileLock", "R", "hasWriteFileLock", "", "block", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleUpdate", "update", "(Landroidx/datastore/core/Message$Update;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementCollector", "readAndInitOrPropagateAndThrowFailure", "readDataAndUpdateCache", "Landroidx/datastore/core/State;", "requireLock", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readDataFromFileOrDefault", "readDataOrHandleCorruption", "Landroidx/datastore/core/Data;", "readState", "transformAndWrite", "transform", "t", "callerContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateData", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeData", "newData", "updateCache", "writeData$datastore_core_release", "(Ljava/lang/Object;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "InitDataStore", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class DataStoreImpl<T> implements DataStore<T> {
    private static final String BUG_MESSAGE = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542";
    private int collectorCounter;
    private Job collectorJob;
    private final Mutex collectorMutex;

    /* renamed from: coordinator$delegate, reason: from kotlin metadata */
    private final Lazy coordinator;
    private final CorruptionHandler<T> corruptionHandler;
    private final Flow<T> data;
    private final DataStoreInMemoryCache<T> inMemoryCache;
    private final DataStoreImpl<T>.InitDataStore readAndInit;
    private final CoroutineScope scope;
    private final Storage<T> storage;
    private final Lazy<StorageConnection<T>> storageConnectionDelegate;
    private final SimpleActor<Message.Update<T>> writeActor;

    public DataStoreImpl(Storage<T> storage, List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasksList, CorruptionHandler<T> corruptionHandler, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(initTasksList, "initTasksList");
        Intrinsics.checkNotNullParameter(corruptionHandler, "corruptionHandler");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.storage = storage;
        this.corruptionHandler = corruptionHandler;
        this.scope = scope;
        this.data = FlowKt.flow(new DataStoreImpl$data$1(this, null));
        this.collectorMutex = MutexKt.Mutex$default(false, 1, null);
        this.inMemoryCache = new DataStoreInMemoryCache<>();
        this.readAndInit = new InitDataStore(this, initTasksList);
        this.storageConnectionDelegate = LazyKt.lazy(new Function0<StorageConnection<T>>(this) { // from class: androidx.datastore.core.DataStoreImpl$storageConnectionDelegate$1
            final /* synthetic */ DataStoreImpl<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final StorageConnection<T> invoke() {
                Storage storage2;
                storage2 = ((DataStoreImpl) this.this$0).storage;
                return storage2.createConnection();
            }
        });
        this.coordinator = LazyKt.lazy(new Function0<InterProcessCoordinator>(this) { // from class: androidx.datastore.core.DataStoreImpl$coordinator$2
            final /* synthetic */ DataStoreImpl<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InterProcessCoordinator invoke() {
                return this.this$0.getStorageConnection$datastore_core_release().getCoordinator();
            }
        });
        this.writeActor = new SimpleActor<>(scope, new Function1<Throwable, Unit>(this) { // from class: androidx.datastore.core.DataStoreImpl$writeActor$1
            final /* synthetic */ DataStoreImpl<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                if (th != null) {
                    ((DataStoreImpl) this.this$0).inMemoryCache.tryUpdate(new Final(th));
                }
                lazy = ((DataStoreImpl) this.this$0).storageConnectionDelegate;
                if (lazy.isInitialized()) {
                    this.this$0.getStorageConnection$datastore_core_release().close();
                }
            }
        }, new Function2<Message.Update<T>, Throwable, Unit>() { // from class: androidx.datastore.core.DataStoreImpl$writeActor$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Throwable th) {
                invoke((Message.Update) obj, th);
                return Unit.INSTANCE;
            }

            public final void invoke(Message.Update<T> msg, Throwable th) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                CompletableDeferred<T> ack = msg.getAck();
                if (th == null) {
                    th = new CancellationException("DataStore scope was cancelled before updateData could complete");
                }
                ack.completeExceptionally(th);
            }
        }, new DataStoreImpl$writeActor$3(this, null));
    }

    public /* synthetic */ DataStoreImpl(Storage storage, List list, NoOpCorruptionHandler noOpCorruptionHandler, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storage, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? new NoOpCorruptionHandler() : noOpCorruptionHandler, (i & 8) != 0 ? CoroutineScopeKt.CoroutineScope(Actual_jvmKt.ioDispatcher().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))) : coroutineScope);
    }

    @Override // androidx.datastore.core.DataStore
    public Flow<T> getData() {
        return this.data;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056 A[Catch: all -> 0x0072, TryCatch #0 {all -> 0x0072, blocks: (B:11:0x004f, B:13:0x0056, B:14:0x006a), top: B:10:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object incrementCollector(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof androidx.datastore.core.DataStoreImpl$incrementCollector$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.datastore.core.DataStoreImpl$incrementCollector$1 r0 = (androidx.datastore.core.DataStoreImpl$incrementCollector$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.datastore.core.DataStoreImpl$incrementCollector$1 r0 = new androidx.datastore.core.DataStoreImpl$incrementCollector$1
            r0.<init>(r11, r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 != r4) goto L35
            java.lang.Object r11 = r0.L$1
            kotlinx.coroutines.sync.Mutex r11 = (kotlinx.coroutines.sync.Mutex) r11
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r11
            r11 = r0
            goto L4f
        L35:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3d:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlinx.coroutines.sync.Mutex r12 = r11.collectorMutex
            r0.L$0 = r11
            r0.L$1 = r12
            r0.label = r4
            java.lang.Object r0 = r12.lock(r3, r0)
            if (r0 != r1) goto L4f
            return r1
        L4f:
            int r0 = r11.collectorCounter     // Catch: java.lang.Throwable -> L72
            int r0 = r0 + r4
            r11.collectorCounter = r0     // Catch: java.lang.Throwable -> L72
            if (r0 != r4) goto L6a
            kotlinx.coroutines.CoroutineScope r5 = r11.scope     // Catch: java.lang.Throwable -> L72
            androidx.datastore.core.DataStoreImpl$incrementCollector$2$1 r0 = new androidx.datastore.core.DataStoreImpl$incrementCollector$2$1     // Catch: java.lang.Throwable -> L72
            r0.<init>(r11, r3)     // Catch: java.lang.Throwable -> L72
            r8 = r0
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8     // Catch: java.lang.Throwable -> L72
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            kotlinx.coroutines.Job r0 = kotlinx.coroutines.BuildersKt.launch$default(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L72
            r11.collectorJob = r0     // Catch: java.lang.Throwable -> L72
        L6a:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L72
            r12.unlock(r3)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L72:
            r0 = move-exception
            r11 = r0
            r12.unlock(r3)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.incrementCollector(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0057 A[Catch: all -> 0x0068, TryCatch #0 {all -> 0x0068, blocks: (B:11:0x004f, B:13:0x0057, B:15:0x005b, B:16:0x005e, B:17:0x0060), top: B:10:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object decrementCollector(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.DataStoreImpl$decrementCollector$1
            if (r0 == 0) goto L14
            r0 = r6
            androidx.datastore.core.DataStoreImpl$decrementCollector$1 r0 = (androidx.datastore.core.DataStoreImpl$decrementCollector$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.datastore.core.DataStoreImpl$decrementCollector$1 r0 = new androidx.datastore.core.DataStoreImpl$decrementCollector$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
            r5 = r0
            goto L4f
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = r5.collectorMutex
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r0 = r6.lock(r4, r0)
            if (r0 != r1) goto L4f
            return r1
        L4f:
            int r0 = r5.collectorCounter     // Catch: java.lang.Throwable -> L68
            int r0 = r0 + (-1)
            r5.collectorCounter = r0     // Catch: java.lang.Throwable -> L68
            if (r0 != 0) goto L60
            kotlinx.coroutines.Job r0 = r5.collectorJob     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L5e
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r0, r4, r3, r4)     // Catch: java.lang.Throwable -> L68
        L5e:
            r5.collectorJob = r4     // Catch: java.lang.Throwable -> L68
        L60:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L68
            r6.unlock(r4)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L68:
            r5 = move-exception
            r6.unlock(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.decrementCollector(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.datastore.core.DataStore
    public Object updateData(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        UpdatingDataContextElement updatingDataContextElement = (UpdatingDataContextElement) continuation.getContext().get(UpdatingDataContextElement.Companion.Key.INSTANCE);
        if (updatingDataContextElement != null) {
            updatingDataContextElement.checkNotUpdating(this);
        }
        return BuildersKt.withContext(new UpdatingDataContextElement(updatingDataContextElement, this), new DataStoreImpl$updateData$2(this, function2, null), continuation);
    }

    public final StorageConnection<T> getStorageConnection$datastore_core_release() {
        return this.storageConnectionDelegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterProcessCoordinator getCoordinator() {
        return (InterProcessCoordinator) this.coordinator.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readState(boolean z, Continuation<? super State<T>> continuation) {
        return BuildersKt.withContext(this.scope.getCoroutineContext(), new DataStoreImpl$readState$2(this, z, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(5:5|6|7|(6:(1:(1:(2:12|13))(3:15|16|17))|26|27|21|22|23)(5:28|29|30|(6:32|(1:34)|20|21|22|23)(3:35|(1:37)(1:52)|(2:39|(2:41|(1:43))(2:44|45))(2:46|(2:48|49)(2:50|51)))|25)|18))|57|6|7|(0)(0)|18|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b3, code lost:
    
        if (r8 != r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0050, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.datastore.core.DataStoreImpl, java.lang.Object, androidx.datastore.core.DataStoreImpl<T>] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v15, types: [androidx.datastore.core.DataStoreImpl] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleUpdate(androidx.datastore.core.Message.Update<T> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.handleUpdate(androidx.datastore.core.Message$Update, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
    
        if (r2.runIfNeeded(r0) != r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006b, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0054, code lost:
    
        if (r7 == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readAndInitOrPropagateAndThrowFailure(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r6, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            int r6 = r0.I$0
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L33
            goto L6c
        L33:
            r7 = move-exception
            goto L74
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            java.lang.Object r6 = r0.L$0
            androidx.datastore.core.DataStoreImpl r6 = (androidx.datastore.core.DataStoreImpl) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L57
        L45:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.datastore.core.InterProcessCoordinator r7 = r6.getCoordinator()
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.getVersion(r0)
            if (r7 != r1) goto L57
            goto L6b
        L57:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            androidx.datastore.core.DataStoreImpl<T>$InitDataStore r2 = r6.readAndInit     // Catch: java.lang.Throwable -> L6f
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L6f
            r0.I$0 = r7     // Catch: java.lang.Throwable -> L6f
            r0.label = r3     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r6 = r2.runIfNeeded(r0)     // Catch: java.lang.Throwable -> L6f
            if (r6 != r1) goto L6c
        L6b:
            return r1
        L6c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L6f:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L74:
            androidx.datastore.core.DataStoreInMemoryCache<T> r0 = r0.inMemoryCache
            androidx.datastore.core.ReadException r1 = new androidx.datastore.core.ReadException
            r1.<init>(r7, r6)
            androidx.datastore.core.State r1 = (androidx.datastore.core.State) r1
            r0.tryUpdate(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readAndInitOrPropagateAndThrowFailure(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readDataAndUpdateCache(boolean r9, kotlin.coroutines.Continuation<? super androidx.datastore.core.State<T>> r10) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readDataAndUpdateCache(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readDataFromFileOrDefault(Continuation<? super T> continuation) {
        return StorageConnectionKt.readData(getStorageConnection$datastore_core_release(), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object transformAndWrite(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        return getCoordinator().lock(new DataStoreImpl$transformAndWrite$2(this, coroutineContext, function2, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeData$datastore_core_release(T r11, boolean r12, kotlin.coroutines.Continuation<? super java.lang.Integer> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof androidx.datastore.core.DataStoreImpl$writeData$1
            if (r0 == 0) goto L14
            r0 = r13
            androidx.datastore.core.DataStoreImpl$writeData$1 r0 = (androidx.datastore.core.DataStoreImpl$writeData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            androidx.datastore.core.DataStoreImpl$writeData$1 r0 = new androidx.datastore.core.DataStoreImpl$writeData$1
            r0.<init>(r10, r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r10 = r0.L$0
            kotlin.jvm.internal.Ref$IntRef r10 = (kotlin.jvm.internal.Ref.IntRef) r10
            kotlin.ResultKt.throwOnFailure(r13)
            goto L59
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.jvm.internal.Ref$IntRef r5 = new kotlin.jvm.internal.Ref$IntRef
            r5.<init>()
            androidx.datastore.core.StorageConnection r13 = r10.getStorageConnection$datastore_core_release()
            androidx.datastore.core.DataStoreImpl$writeData$2 r4 = new androidx.datastore.core.DataStoreImpl$writeData$2
            r9 = 0
            r6 = r10
            r7 = r11
            r8 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r10 = r13.writeScope(r4, r0)
            if (r10 != r1) goto L58
            return r1
        L58:
            r10 = r5
        L59:
            int r10 = r10.element
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.writeData$datastore_core_release(java.lang.Object, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|71|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x008b, code lost:
    
        r10 = e;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0023. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a4 A[Catch: CorruptionException -> 0x008b, TryCatch #1 {CorruptionException -> 0x008b, blocks: (B:35:0x005f, B:36:0x0103, B:39:0x006a, B:40:0x00e4, B:55:0x0087, B:57:0x00a4, B:58:0x00aa, B:64:0x0093, B:67:0x00d2), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readDataOrHandleCorruption(boolean r9, kotlin.coroutines.Continuation<? super androidx.datastore.core.Data<T>> r10) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readDataOrHandleCorruption(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> Object doWithWriteFileLock(boolean z, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        if (z) {
            return function1.invoke(continuation);
        }
        return getCoordinator().lock(new DataStoreImpl$doWithWriteFileLock$3(function1, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DataStoreImpl.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001BD\u0012=\u0010\u0002\u001a9\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00040\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u000e\u001a\u00020\nH\u0094@¢\u0006\u0002\u0010\u000fRG\u0010\r\u001a;\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/datastore/core/DataStoreImpl$InitDataStore;", "Landroidx/datastore/core/RunOnce;", "initTasksList", "", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/coroutines/Continuation;", "", "", "(Landroidx/datastore/core/DataStoreImpl;Ljava/util/List;)V", "initTasks", "doRun", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public final class InitDataStore extends RunOnce {
        private List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasks;
        final /* synthetic */ DataStoreImpl<T> this$0;

        public InitDataStore(DataStoreImpl dataStoreImpl, List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasksList) {
            Intrinsics.checkNotNullParameter(initTasksList, "initTasksList");
            this.this$0 = dataStoreImpl;
            this.initTasks = CollectionsKt.toList(initTasksList);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
        
            if (r7 == r1) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007d, code lost:
        
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x007b, code lost:
        
            if (r7 == r1) goto L27;
         */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        @Override // androidx.datastore.core.RunOnce
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object doRun(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
            /*
                r6 = this;
                boolean r0 = r7 instanceof androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1
                if (r0 == 0) goto L14
                r0 = r7
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1 r0 = (androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r7 = r0.label
                int r7 = r7 - r2
                r0.label = r7
                goto L19
            L14:
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1 r0 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1
                r0.<init>(r6, r7)
            L19:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L41
                if (r2 == r4) goto L39
                if (r2 != r3) goto L31
                java.lang.Object r6 = r0.L$0
                androidx.datastore.core.DataStoreImpl$InitDataStore r6 = (androidx.datastore.core.DataStoreImpl.InitDataStore) r6
                kotlin.ResultKt.throwOnFailure(r7)
                goto L6d
            L31:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L39:
                java.lang.Object r6 = r0.L$0
                androidx.datastore.core.DataStoreImpl$InitDataStore r6 = (androidx.datastore.core.DataStoreImpl.InitDataStore) r6
                kotlin.ResultKt.throwOnFailure(r7)
                goto L7e
            L41:
                kotlin.ResultKt.throwOnFailure(r7)
                java.util.List<? extends kotlin.jvm.functions.Function2<? super androidx.datastore.core.InitializerApi<T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>> r7 = r6.initTasks
                if (r7 == 0) goto L70
                kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
                boolean r7 = r7.isEmpty()
                if (r7 == 0) goto L52
                goto L70
            L52:
                androidx.datastore.core.DataStoreImpl<T> r7 = r6.this$0
                androidx.datastore.core.InterProcessCoordinator r7 = androidx.datastore.core.DataStoreImpl.access$getCoordinator(r7)
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1 r2 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1
                androidx.datastore.core.DataStoreImpl<T> r4 = r6.this$0
                r5 = 0
                r2.<init>(r4, r6, r5)
                kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
                r0.L$0 = r6
                r0.label = r3
                java.lang.Object r7 = r7.lock(r2, r0)
                if (r7 != r1) goto L6d
                goto L7d
            L6d:
                androidx.datastore.core.Data r7 = (androidx.datastore.core.Data) r7
                goto L80
            L70:
                androidx.datastore.core.DataStoreImpl<T> r7 = r6.this$0
                r0.L$0 = r6
                r0.label = r4
                r2 = 0
                java.lang.Object r7 = androidx.datastore.core.DataStoreImpl.access$readDataOrHandleCorruption(r7, r2, r0)
                if (r7 != r1) goto L7e
            L7d:
                return r1
            L7e:
                androidx.datastore.core.Data r7 = (androidx.datastore.core.Data) r7
            L80:
                androidx.datastore.core.DataStoreImpl<T> r6 = r6.this$0
                androidx.datastore.core.DataStoreInMemoryCache r6 = androidx.datastore.core.DataStoreImpl.access$getInMemoryCache$p(r6)
                androidx.datastore.core.State r7 = (androidx.datastore.core.State) r7
                r6.tryUpdate(r7)
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.InitDataStore.doRun(kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
