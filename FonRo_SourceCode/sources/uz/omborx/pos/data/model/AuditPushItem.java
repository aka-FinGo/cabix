package uz.FonRo.pos.data.model;

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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000256B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J1\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020\fHÖ\u0081\u0004J\n\u0010+\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001b\u0002\b4¢\u0006\u0002\b3R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019R*\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u001dR*\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(!¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u001dÊ\u0001\u0002\b8Ê\u0001\f\b9\u0012\b\b:\u0012\u0004\b\u0003\u0010\u0002¨\u00067"}, d2 = {"Luz/FonRo/pos/data/model/AuditPushItem;", "", "productId", "", "productName", "", "systemQty", "", "actualQty", "<init>", "(JLjava/lang/String;DD)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;DDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProductId$annotations", "()V", "getProductId", "()J", "Lkotlinx/serialization/SerialName;", "value", FirebaseAnalytics.Param.PRODUCT_ID, "getProductName$annotations", "getProductName", "()Ljava/lang/String;", FirebaseAnalytics.Param.PRODUCT_NAME, "getSystemQty$annotations", "getSystemQty", "()D", "system_qty", "getActualQty$annotations", "getActualQty", "actual_qty", "component1", "component2", "component3", "component4", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class AuditPushItem {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double actualQty;
    private final long productId;
    private final String productName;
    private final double systemQty;

    public static /* synthetic */ AuditPushItem copy$default(AuditPushItem auditPushItem, long j, String str, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = auditPushItem.productId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = auditPushItem.productName;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            d = auditPushItem.systemQty;
        }
        double d3 = d;
        if ((i & 8) != 0) {
            d2 = auditPushItem.actualQty;
        }
        return auditPushItem.copy(j2, str2, d3, d2);
    }

    @SerialName("actual_qty")
    public static /* synthetic */ void getActualQty$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_ID)
    public static /* synthetic */ void getProductId$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_NAME)
    public static /* synthetic */ void getProductName$annotations() {
    }

    @SerialName("system_qty")
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

    public final AuditPushItem copy(long productId, String productName, double systemQty, double actualQty) {
        Intrinsics.checkNotNullParameter(productName, "productName");
        return new AuditPushItem(productId, productName, systemQty, actualQty);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuditPushItem)) {
            return false;
        }
        AuditPushItem auditPushItem = (AuditPushItem) other;
        return this.productId == auditPushItem.productId && Intrinsics.areEqual(this.productName, auditPushItem.productName) && Double.compare(this.systemQty, auditPushItem.systemQty) == 0 && Double.compare(this.actualQty, auditPushItem.actualQty) == 0;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.productId) * 31) + this.productName.hashCode()) * 31) + Double.hashCode(this.systemQty)) * 31) + Double.hashCode(this.actualQty);
    }

    public String toString() {
        return "AuditPushItem(productId=" + this.productId + ", productName=" + this.productName + ", systemQty=" + this.systemQty + ", actualQty=" + this.actualQty + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/AuditPushItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/AuditPushItem;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AuditPushItem> serializer() {
            return AuditPushItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AuditPushItem(int i, long j, String str, double d, double d2, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, AuditPushItem$$serializer.INSTANCE.getDescriptor());
        }
        this.productId = j;
        this.productName = str;
        this.systemQty = d;
        this.actualQty = d2;
    }

    public AuditPushItem(long j, String productName, double d, double d2) {
        Intrinsics.checkNotNullParameter(productName, "productName");
        this.productId = j;
        this.productName = productName;
        this.systemQty = d;
        this.actualQty = d2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(AuditPushItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.productId);
        output.encodeStringElement(serialDesc, 1, self.productName);
        output.encodeDoubleElement(serialDesc, 2, self.systemQty);
        output.encodeDoubleElement(serialDesc, 3, self.actualQty);
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
}
