package uz.FonRo.pos.data.local;

import android.content.Context;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import uz.FonRo.pos.data.model.SaleBody;
import uz.FonRo.pos.data.model.SaleBody$$serializer;
import uz.FonRo.pos.data.model.WriteOffReason;
import uz.FonRo.pos.data.net.ApiClient;

/* compiled from: SaleOutbox.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eJ\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010\u001f\u001a\u00020\u0018J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0016\u0010!\u001a\u00020\u00182\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016Ê\u0001\f\b%\u0012\b\b&\u0012\u0004\b\u0003\u0010\u0000¨\u0006$"}, d2 = {"Luz/FonRo/pos/data/local/SaleOutbox;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "file", "Ljava/io/File;", "json", "Lkotlinx/serialization/json/Json;", "lock", "_queue", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Luz/FonRo/pos/data/local/SaleOutbox$Pending;", "queue", "Lkotlinx/coroutines/flow/StateFlow;", "getQueue", "()Lkotlinx/coroutines/flow/StateFlow;", "size", "", "getSize", "()I", "add", "", "pending", "remove", "transactionId", "", "markAttempt", "error", "clear", "read", "write", "list", "Pending", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class SaleOutbox {
    public static final int $stable = 8;
    private final MutableStateFlow<List<Pending>> _queue;
    private final File file;
    private final Json json;
    private final Object lock;
    private final StateFlow<List<Pending>> queue;

    /* compiled from: SaleOutbox.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000234BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eBO\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003JG\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010)\u001a\u00020\tHÖ\u0081\u0004J)\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001b\u0002\b2¢\u0006\u0002\b1R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018Ê\u0001\u0002\b6Ê\u0001\f\b7\u0012\b\b8\u0012\u0004\b\u0003\u0010\u0000¨\u00065"}, d2 = {"Luz/FonRo/pos/data/local/SaleOutbox$Pending;", "", "body", "Luz/FonRo/pos/data/model/SaleBody;", "createdAt", "", "attempts", "", "lastError", "", "total", "", "itemsCount", "<init>", "(Luz/FonRo/pos/data/model/SaleBody;JILjava/lang/String;DI)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILuz/FonRo/pos/data/model/SaleBody;JILjava/lang/String;DILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBody", "()Luz/FonRo/pos/data/model/SaleBody;", "getCreatedAt", "()J", "getAttempts", "()I", "getLastError", "()Ljava/lang/String;", "getTotal", "()D", "getItemsCount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @Serializable
    /* loaded from: classes5.dex */
    public static final /* data */ class Pending {
        private final int attempts;
        private final SaleBody body;
        private final long createdAt;
        private final int itemsCount;
        private final String lastError;
        private final double total;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = SaleBody.$stable;

        public static /* synthetic */ Pending copy$default(Pending pending, SaleBody saleBody, long j, int i, String str, double d, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                saleBody = pending.body;
            }
            if ((i3 & 2) != 0) {
                j = pending.createdAt;
            }
            if ((i3 & 4) != 0) {
                i = pending.attempts;
            }
            if ((i3 & 8) != 0) {
                str = pending.lastError;
            }
            if ((i3 & 16) != 0) {
                d = pending.total;
            }
            if ((i3 & 32) != 0) {
                i2 = pending.itemsCount;
            }
            int i4 = i2;
            return pending.copy(saleBody, j, i, str, d, i4);
        }

        /* renamed from: component1, reason: from getter */
        public final SaleBody getBody() {
            return this.body;
        }

        /* renamed from: component2, reason: from getter */
        public final long getCreatedAt() {
            return this.createdAt;
        }

        /* renamed from: component3, reason: from getter */
        public final int getAttempts() {
            return this.attempts;
        }

        /* renamed from: component4, reason: from getter */
        public final String getLastError() {
            return this.lastError;
        }

        /* renamed from: component5, reason: from getter */
        public final double getTotal() {
            return this.total;
        }

        /* renamed from: component6, reason: from getter */
        public final int getItemsCount() {
            return this.itemsCount;
        }

        public final Pending copy(SaleBody body, long createdAt, int attempts, String lastError, double total, int itemsCount) {
            Intrinsics.checkNotNullParameter(body, "body");
            return new Pending(body, createdAt, attempts, lastError, total, itemsCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Pending)) {
                return false;
            }
            Pending pending = (Pending) other;
            return Intrinsics.areEqual(this.body, pending.body) && this.createdAt == pending.createdAt && this.attempts == pending.attempts && Intrinsics.areEqual(this.lastError, pending.lastError) && Double.compare(this.total, pending.total) == 0 && this.itemsCount == pending.itemsCount;
        }

        public int hashCode() {
            int hashCode = ((((this.body.hashCode() * 31) + Long.hashCode(this.createdAt)) * 31) + Integer.hashCode(this.attempts)) * 31;
            String str = this.lastError;
            return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Double.hashCode(this.total)) * 31) + Integer.hashCode(this.itemsCount);
        }

        public String toString() {
            return "Pending(body=" + this.body + ", createdAt=" + this.createdAt + ", attempts=" + this.attempts + ", lastError=" + this.lastError + ", total=" + this.total + ", itemsCount=" + this.itemsCount + ")";
        }

        /* compiled from: SaleOutbox.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/local/SaleOutbox$Pending$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/local/SaleOutbox$Pending;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Pending> serializer() {
                return SaleOutbox$Pending$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Pending(int i, SaleBody saleBody, long j, int i2, String str, double d, int i3, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, SaleOutbox$Pending$$serializer.INSTANCE.getDescriptor());
            }
            this.body = saleBody;
            this.createdAt = j;
            if ((i & 4) == 0) {
                this.attempts = 0;
            } else {
                this.attempts = i2;
            }
            if ((i & 8) == 0) {
                this.lastError = null;
            } else {
                this.lastError = str;
            }
            if ((i & 16) == 0) {
                this.total = AudioStats.AUDIO_AMPLITUDE_NONE;
            } else {
                this.total = d;
            }
            if ((i & 32) == 0) {
                this.itemsCount = 0;
            } else {
                this.itemsCount = i3;
            }
        }

        public Pending(SaleBody body, long j, int i, String str, double d, int i2) {
            Intrinsics.checkNotNullParameter(body, "body");
            this.body = body;
            this.createdAt = j;
            this.attempts = i;
            this.lastError = str;
            this.total = d;
            this.itemsCount = i2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app(Pending self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, SaleBody$$serializer.INSTANCE, self.body);
            output.encodeLongElement(serialDesc, 1, self.createdAt);
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.attempts != 0) {
                output.encodeIntElement(serialDesc, 2, self.attempts);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.lastError != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.lastError);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || Double.compare(self.total, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
                output.encodeDoubleElement(serialDesc, 4, self.total);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.itemsCount == 0) {
                return;
            }
            output.encodeIntElement(serialDesc, 5, self.itemsCount);
        }

        public /* synthetic */ Pending(SaleBody saleBody, long j, int i, String str, double d, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(saleBody, j, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : d, (i3 & 32) != 0 ? 0 : i2);
        }

        public final SaleBody getBody() {
            return this.body;
        }

        public final long getCreatedAt() {
            return this.createdAt;
        }

        public final int getAttempts() {
            return this.attempts;
        }

        public final String getLastError() {
            return this.lastError;
        }

        public final double getTotal() {
            return this.total;
        }

        public final int getItemsCount() {
            return this.itemsCount;
        }
    }

    public SaleOutbox(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.file = new File(context.getFilesDir(), "sale_outbox.json");
        this.json = ApiClient.INSTANCE.getJson();
        this.lock = new Object();
        MutableStateFlow<List<Pending>> MutableStateFlow = StateFlowKt.MutableStateFlow(read());
        this._queue = MutableStateFlow;
        this.queue = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final StateFlow<List<Pending>> getQueue() {
        return this.queue;
    }

    public final int getSize() {
        return this._queue.getValue().size();
    }

    public final void add(Pending pending) {
        Intrinsics.checkNotNullParameter(pending, "pending");
        synchronized (this.lock) {
            write(CollectionsKt.plus((Collection<? extends Pending>) this._queue.getValue(), pending));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void remove(String transactionId) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        synchronized (this.lock) {
            List<Pending> value = this._queue.getValue();
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if (!Intrinsics.areEqual(((Pending) obj).getBody().getTransactionId(), transactionId)) {
                    arrayList.add(obj);
                }
            }
            write(arrayList);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void markAttempt(String transactionId, String error) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        synchronized (this.lock) {
            List<Pending> value = this._queue.getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(value, 10));
            for (Pending pending : value) {
                if (Intrinsics.areEqual(pending.getBody().getTransactionId(), transactionId)) {
                    pending = Pending.copy$default(pending, null, 0L, pending.getAttempts() + 1, error, AudioStats.AUDIO_AMPLITUDE_NONE, 0, 51, null);
                }
                arrayList.add(pending);
            }
            write(arrayList);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clear() {
        synchronized (this.lock) {
            write(CollectionsKt.emptyList());
            Unit unit = Unit.INSTANCE;
        }
    }

    private final List<Pending> read() {
        Object m7870constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            SaleOutbox saleOutbox = this;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        if (!this.file.exists()) {
            return CollectionsKt.emptyList();
        }
        m7870constructorimpl = Result.m7870constructorimpl((List) this.json.decodeFromString(BuiltinSerializersKt.ListSerializer(Pending.INSTANCE.serializer()), FilesKt.readText$default(this.file, null, 1, null)));
        List emptyList = CollectionsKt.emptyList();
        if (Result.m7876isFailureimpl(m7870constructorimpl)) {
            m7870constructorimpl = emptyList;
        }
        return (List) m7870constructorimpl;
    }

    private final void write(List<Pending> list) {
        try {
            Result.Companion companion = Result.INSTANCE;
            SaleOutbox saleOutbox = this;
            File file = new File(this.file.getParentFile(), this.file.getName() + ".tmp");
            FilesKt.writeText$default(file, this.json.encodeToString(BuiltinSerializersKt.ListSerializer(Pending.INSTANCE.serializer()), list), null, 2, null);
            if (this.file.exists()) {
                this.file.delete();
            }
            Result.m7870constructorimpl(Boolean.valueOf(file.renameTo(this.file)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        this._queue.setValue(list);
    }
}
