package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 A2\u00020\u0001:\u0002@AB;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bBE\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J=\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0014\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00105\u001a\u00020\rHÖ\u0081\u0004J\n\u00106\u001a\u00020\u0005HÖ\u0081\u0004J)\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0001b\u0002\b?¢\u0006\u0002\b>R8\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\t0\u001a¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R,\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u001dR8\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\"r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\t0#¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010!R8\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(&r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\t0#¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010!R8\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b()r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\t0#¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0012\u001a\u0004\b(\u0010!R\u0011\u0010*\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b+\u0010!Ê\u0001\u0002\b\u0018Ê\u0001\f\bC\u0012\b\bD\u0012\u0004\b\u0003\u0010\u0002¨\u0006B"}, d2 = {"Luz/FonRo/pos/data/model/AuditItem;", "", "productId", "", "productName", "", "systemQty", "", "actualQty", "differenceQty", "<init>", "(JLjava/lang/String;DDD)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;DDDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProductId$annotations", "()V", "getProductId", "()J", "Lkotlinx/serialization/SerialName;", "value", FirebaseAnalytics.Param.PRODUCT_ID, "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getProductName$annotations", "getProductName", "()Ljava/lang/String;", FirebaseAnalytics.Param.PRODUCT_NAME, "getSystemQty$annotations", "getSystemQty", "()D", "system_qty", "Luz/FonRo/pos/data/net/LenientDouble;", "getActualQty$annotations", "getActualQty", "actual_qty", "getDifferenceQty$annotations", "getDifferenceQty", "difference_qty", "diff", "getDiff", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class AuditItem {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double actualQty;
    private final double differenceQty;
    private final long productId;
    private final String productName;
    private final double systemQty;

    public AuditItem() {
        this(0L, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AuditItem copy$default(AuditItem auditItem, long j, String str, double d, double d2, double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = auditItem.productId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = auditItem.productName;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            d = auditItem.systemQty;
        }
        return auditItem.copy(j2, str2, d, (i & 8) != 0 ? auditItem.actualQty : d2, (i & 16) != 0 ? auditItem.differenceQty : d3);
    }

    @SerialName("actual_qty")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getActualQty$annotations() {
    }

    @SerialName("difference_qty")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getDifferenceQty$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_ID)
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getProductId$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_NAME)
    public static /* synthetic */ void getProductName$annotations() {
    }

    @SerialName("system_qty")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getSystemQty$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getProductId() {
        return this.productId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getProductName() {
        return this.productName;
    }

    /* renamed from: component3, reason: from getter */
    public final double getSystemQty() {
        return this.systemQty;
    }

    /* renamed from: component4, reason: from getter */
    public final double getActualQty() {
        return this.actualQty;
    }

    /* renamed from: component5, reason: from getter */
    public final double getDifferenceQty() {
        return this.differenceQty;
    }

    public final AuditItem copy(long productId, String productName, double systemQty, double actualQty, double differenceQty) {
        return new AuditItem(productId, productName, systemQty, actualQty, differenceQty);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuditItem)) {
            return false;
        }
        AuditItem auditItem = (AuditItem) other;
        return this.productId == auditItem.productId && Intrinsics.areEqual(this.productName, auditItem.productName) && Double.compare(this.systemQty, auditItem.systemQty) == 0 && Double.compare(this.actualQty, auditItem.actualQty) == 0 && Double.compare(this.differenceQty, auditItem.differenceQty) == 0;
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.productId) * 31;
        String str = this.productName;
        return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Double.hashCode(this.systemQty)) * 31) + Double.hashCode(this.actualQty)) * 31) + Double.hashCode(this.differenceQty);
    }

    public String toString() {
        return "AuditItem(productId=" + this.productId + ", productName=" + this.productName + ", systemQty=" + this.systemQty + ", actualQty=" + this.actualQty + ", differenceQty=" + this.differenceQty + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/AuditItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/AuditItem;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AuditItem> serializer() {
            return AuditItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AuditItem(int i, long j, String str, double d, double d2, double d3, SerializationConstructorMarker serializationConstructorMarker) {
        this.productId = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.productName = null;
        } else {
            this.productName = str;
        }
        if ((i & 4) == 0) {
            this.systemQty = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.systemQty = d;
        }
        if ((i & 8) == 0) {
            this.actualQty = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.actualQty = d2;
        }
        if ((i & 16) == 0) {
            this.differenceQty = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.differenceQty = d3;
        }
    }

    public AuditItem(long j, String str, double d, double d2, double d3) {
        this.productId = j;
        this.productName = str;
        this.systemQty = d;
        this.actualQty = d2;
        this.differenceQty = d3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(AuditItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.productId != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.productId));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.productName != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.productName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || Double.compare(self.systemQty, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 2, LenientDouble.INSTANCE, Double.valueOf(self.systemQty));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || Double.compare(self.actualQty, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 3, LenientDouble.INSTANCE, Double.valueOf(self.actualQty));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && Double.compare(self.differenceQty, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 4, LenientDouble.INSTANCE, Double.valueOf(self.differenceQty));
    }

    public /* synthetic */ AuditItem(long j, String str, double d, double d2, double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? 0.0d : d, (i & 8) != 0 ? 0.0d : d2, (i & 16) != 0 ? 0.0d : d3);
    }

    public final long getProductId() {
        return this.productId;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final double getSystemQty() {
        return this.systemQty;
    }

    public final double getActualQty() {
        return this.actualQty;
    }

    public final double getDifferenceQty() {
        return this.differenceQty;
    }

    public final double getDiff() {
        double d = this.differenceQty;
        return d == AudioStats.AUDIO_AMPLITUDE_NONE ? this.actualQty - this.systemQty : d;
    }
}
