package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientLong;
import uz.FonRo.pos.data.net.LenientString;

/* compiled from: Sales.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 M2\u00020\u0001:\u0002LMBk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011Bs\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0010\u0010\u0016J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003Jm\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0001J\u0014\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010A\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010B\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0001b\u0002\bK¢\u0006\u0002\bJR*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\t0\u001d¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR8\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b!\u0012\b\b\"\u0012\u0004\b\b(#r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\t0$¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010 R*\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\t0(¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010'R*\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\t0(¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0018\u001a\u0004\b*\u0010'R*\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\t0(¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0018\u001a\u0004\b,\u0010'R*\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b!\u0012\b\b\"\u0012\u0004\b\b(/¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0018\u001a\u0004\b.\u0010 R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103Ê\u0001\u0002\b\u001bÊ\u0001\f\bO\u0012\b\bP\u0012\u0004\b\u0003\u0010\u0000¨\u0006N"}, d2 = {"Luz/FonRo/pos/data/model/ReturnDoc;", "", "id", "", "transactionId", "", "amount", "", "profit", FirebaseAnalytics.Param.QUANTITY, "createdAt", NotificationCompat.CATEGORY_STATUS, "reason", "lines", "", "Luz/FonRo/pos/data/model/ReturnLine;", "<init>", "(JLjava/lang/String;DDDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;DDDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getTransactionId$annotations", "getTransactionId", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", FirebaseAnalytics.Param.TRANSACTION_ID, "Luz/FonRo/pos/data/net/LenientString;", "getAmount$annotations", "getAmount", "()D", "Luz/FonRo/pos/data/net/LenientDouble;", "getProfit$annotations", "getProfit", "getQuantity$annotations", "getQuantity", "getCreatedAt$annotations", "getCreatedAt", "created_at", "getStatus", "getReason", "getLines", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ReturnDoc {
    private final double amount;
    private final String createdAt;
    private final long id;
    private final List<ReturnLine> lines;
    private final double profit;
    private final double quantity;
    private final String reason;
    private final String status;
    private final String transactionId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.ReturnDoc$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ReturnDoc._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public ReturnDoc() {
        this(0L, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, (String) null, (String) null, (String) null, (List) null, 511, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(ReturnLine$$serializer.INSTANCE);
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getAmount$annotations() {
    }

    @SerialName("created_at")
    public static /* synthetic */ void getCreatedAt$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getProfit$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getQuantity$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.TRANSACTION_ID)
    @Serializable(with = LenientString.class)
    public static /* synthetic */ void getTransactionId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    /* renamed from: component3, reason: from getter */
    public final double getAmount() {
        return this.amount;
    }

    /* renamed from: component4, reason: from getter */
    public final double getProfit() {
        return this.profit;
    }

    /* renamed from: component5, reason: from getter */
    public final double getQuantity() {
        return this.quantity;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component8, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    public final List<ReturnLine> component9() {
        return this.lines;
    }

    public final ReturnDoc copy(long id, String transactionId, double amount, double profit, double quantity, String createdAt, String status, String reason, List<ReturnLine> lines) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(lines, "lines");
        return new ReturnDoc(id, transactionId, amount, profit, quantity, createdAt, status, reason, lines);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReturnDoc)) {
            return false;
        }
        ReturnDoc returnDoc = (ReturnDoc) other;
        return this.id == returnDoc.id && Intrinsics.areEqual(this.transactionId, returnDoc.transactionId) && Double.compare(this.amount, returnDoc.amount) == 0 && Double.compare(this.profit, returnDoc.profit) == 0 && Double.compare(this.quantity, returnDoc.quantity) == 0 && Intrinsics.areEqual(this.createdAt, returnDoc.createdAt) && Intrinsics.areEqual(this.status, returnDoc.status) && Intrinsics.areEqual(this.reason, returnDoc.reason) && Intrinsics.areEqual(this.lines, returnDoc.lines);
    }

    public int hashCode() {
        int hashCode = ((((((((((Long.hashCode(this.id) * 31) + this.transactionId.hashCode()) * 31) + Double.hashCode(this.amount)) * 31) + Double.hashCode(this.profit)) * 31) + Double.hashCode(this.quantity)) * 31) + this.createdAt.hashCode()) * 31;
        String str = this.status;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.reason;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.lines.hashCode();
    }

    public String toString() {
        return "ReturnDoc(id=" + this.id + ", transactionId=" + this.transactionId + ", amount=" + this.amount + ", profit=" + this.profit + ", quantity=" + this.quantity + ", createdAt=" + this.createdAt + ", status=" + this.status + ", reason=" + this.reason + ", lines=" + this.lines + ")";
    }

    /* compiled from: Sales.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/ReturnDoc$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/ReturnDoc;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ReturnDoc> serializer() {
            return ReturnDoc$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ReturnDoc(int i, long j, String str, double d, double d2, double d3, String str2, String str3, String str4, List list, SerializationConstructorMarker serializationConstructorMarker) {
        this.id = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.transactionId = "";
        } else {
            this.transactionId = str;
        }
        if ((i & 4) == 0) {
            this.amount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.amount = d;
        }
        if ((i & 8) == 0) {
            this.profit = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.profit = d2;
        }
        if ((i & 16) == 0) {
            this.quantity = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.quantity = d3;
        }
        if ((i & 32) == 0) {
            this.createdAt = "";
        } else {
            this.createdAt = str2;
        }
        if ((i & 64) == 0) {
            this.status = null;
        } else {
            this.status = str3;
        }
        if ((i & 128) == 0) {
            this.reason = null;
        } else {
            this.reason = str4;
        }
        this.lines = (i & 256) == 0 ? CollectionsKt.emptyList() : list;
    }

    public ReturnDoc(long j, String transactionId, double d, double d2, double d3, String createdAt, String str, String str2, List<ReturnLine> lines) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(lines, "lines");
        this.id = j;
        this.transactionId = transactionId;
        this.amount = d;
        this.profit = d2;
        this.quantity = d3;
        this.createdAt = createdAt;
        this.status = str;
        this.reason = str2;
        this.lines = lines;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ReturnDoc self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.transactionId, "")) {
            output.encodeSerializableElement(serialDesc, 1, LenientString.INSTANCE, self.transactionId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || Double.compare(self.amount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 2, LenientDouble.INSTANCE, Double.valueOf(self.amount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || Double.compare(self.profit, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 3, LenientDouble.INSTANCE, Double.valueOf(self.profit));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || Double.compare(self.quantity, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 4, LenientDouble.INSTANCE, Double.valueOf(self.quantity));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.createdAt, "")) {
            output.encodeStringElement(serialDesc, 5, self.createdAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.status != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.status);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.reason != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.reason);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 8) && Intrinsics.areEqual(self.lines, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 8, lazyArr[8].getValue(), self.lines);
    }

    public /* synthetic */ ReturnDoc(long j, String str, double d, double d2, double d3, String str2, String str3, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? 0.0d : d, (i & 8) != 0 ? 0.0d : d2, (i & 16) == 0 ? d3 : AudioStats.AUDIO_AMPLITUDE_NONE, (i & 32) == 0 ? str2 : "", (i & 64) != 0 ? null : str3, (i & 128) == 0 ? str4 : null, (i & 256) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final long getId() {
        return this.id;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final double getAmount() {
        return this.amount;
    }

    public final double getProfit() {
        return this.profit;
    }

    public final double getQuantity() {
        return this.quantity;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getReason() {
        return this.reason;
    }

    public final List<ReturnLine> getLines() {
        return this.lines;
    }
}
