package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004J)\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001b\u0002\b)¢\u0006\u0002\b(R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\t0\u0012¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR8\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017r\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\t0\u0012¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000fÊ\u0001\u0002\b\u0010Ê\u0001\f\b-\u0012\b\b.\u0012\u0004\b\u0003\u0010\u0002¨\u0006,"}, d2 = {"Luz/FonRo/pos/data/model/SyncSale;", "", "id", "", "customerId", "<init>", "(JJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getCustomerId$annotations", "getCustomerId", "Lkotlinx/serialization/SerialName;", "value", "customer_id", "component1", "component2", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class SyncSale {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long customerId;
    private final long id;

    public SyncSale() {
        this(0L, 0L, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SyncSale copy$default(SyncSale syncSale, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = syncSale.id;
        }
        if ((i & 2) != 0) {
            j2 = syncSale.customerId;
        }
        return syncSale.copy(j, j2);
    }

    @SerialName("customer_id")
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getCustomerId$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCustomerId() {
        return this.customerId;
    }

    public final SyncSale copy(long id, long customerId) {
        return new SyncSale(id, customerId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncSale)) {
            return false;
        }
        SyncSale syncSale = (SyncSale) other;
        return this.id == syncSale.id && this.customerId == syncSale.customerId;
    }

    public int hashCode() {
        return (Long.hashCode(this.id) * 31) + Long.hashCode(this.customerId);
    }

    public String toString() {
        return "SyncSale(id=" + this.id + ", customerId=" + this.customerId + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/SyncSale$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/SyncSale;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SyncSale> serializer() {
            return SyncSale$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SyncSale(int i, long j, long j2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.id = 0L;
        } else {
            this.id = j;
        }
        if ((i & 2) == 0) {
            this.customerId = 0L;
        } else {
            this.customerId = j2;
        }
    }

    public SyncSale(long j, long j2) {
        this.id = j;
        this.customerId = j2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(SyncSale self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.customerId == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 1, LenientLong.INSTANCE, Long.valueOf(self.customerId));
    }

    public /* synthetic */ SyncSale(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2);
    }

    public final long getId() {
        return this.id;
    }

    public final long getCustomerId() {
        return this.customerId;
    }
}
