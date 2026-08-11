package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Sales.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002:;BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eB]\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u0015\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JM\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0014\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010/\u001a\u00020\u0010HÖ\u0081\u0004J\n\u00100\u001a\u00020\u0005HÖ\u0081\u0004J)\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001b\u0002\b9¢\u0006\u0002\b8R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR6\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(#¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\"R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%Ê\u0001\u0002\b=Ê\u0001\f\b>\u0012\b\b?\u0012\u0004\b\u0003\u0010\u0002¨\u0006<"}, d2 = {"Luz/FonRo/pos/data/model/ReturnBody;", "", "saleId", "", "transactionId", "", "reason", "returnQty", "", "", "lines", "", "Luz/FonRo/pos/data/model/ReturnLineBody;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSaleId$annotations", "()V", "getSaleId", "()J", "Lkotlinx/serialization/SerialName;", "value", "sale_id", "getTransactionId$annotations", "getTransactionId", "()Ljava/lang/String;", FirebaseAnalytics.Param.TRANSACTION_ID, "getReason", "getReturnQty$annotations", "getReturnQty", "()Ljava/util/Map;", "return_qty", "getLines", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ReturnBody {
    public static final int $stable = 0;
    private final List<ReturnLineBody> lines;
    private final String reason;
    private final Map<String, Double> returnQty;
    private final long saleId;
    private final String transactionId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.ReturnBody$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ReturnBody._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.ReturnBody$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = ReturnBody._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    })};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, DoubleSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(ReturnLineBody$$serializer.INSTANCE);
    }

    public static /* synthetic */ ReturnBody copy$default(ReturnBody returnBody, long j, String str, String str2, Map map, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = returnBody.saleId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = returnBody.transactionId;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = returnBody.reason;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            map = returnBody.returnQty;
        }
        Map map2 = map;
        if ((i & 16) != 0) {
            list = returnBody.lines;
        }
        return returnBody.copy(j2, str3, str4, map2, list);
    }

    @SerialName("return_qty")
    public static /* synthetic */ void getReturnQty$annotations() {
    }

    @SerialName("sale_id")
    public static /* synthetic */ void getSaleId$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.TRANSACTION_ID)
    public static /* synthetic */ void getTransactionId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getSaleId() {
        return this.saleId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    public final Map<String, Double> component4() {
        return this.returnQty;
    }

    public final List<ReturnLineBody> component5() {
        return this.lines;
    }

    public final ReturnBody copy(long saleId, String transactionId, String reason, Map<String, Double> returnQty, List<ReturnLineBody> lines) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(returnQty, "returnQty");
        Intrinsics.checkNotNullParameter(lines, "lines");
        return new ReturnBody(saleId, transactionId, reason, returnQty, lines);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReturnBody)) {
            return false;
        }
        ReturnBody returnBody = (ReturnBody) other;
        return this.saleId == returnBody.saleId && Intrinsics.areEqual(this.transactionId, returnBody.transactionId) && Intrinsics.areEqual(this.reason, returnBody.reason) && Intrinsics.areEqual(this.returnQty, returnBody.returnQty) && Intrinsics.areEqual(this.lines, returnBody.lines);
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.saleId) * 31) + this.transactionId.hashCode()) * 31) + this.reason.hashCode()) * 31) + this.returnQty.hashCode()) * 31) + this.lines.hashCode();
    }

    public String toString() {
        return "ReturnBody(saleId=" + this.saleId + ", transactionId=" + this.transactionId + ", reason=" + this.reason + ", returnQty=" + this.returnQty + ", lines=" + this.lines + ")";
    }

    /* compiled from: Sales.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/ReturnBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/ReturnBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ReturnBody> serializer() {
            return ReturnBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ReturnBody(int i, long j, String str, String str2, Map map, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (2 != (i & 2)) {
            PluginExceptionsKt.throwMissingFieldException(i, 2, ReturnBody$$serializer.INSTANCE.getDescriptor());
        }
        this.saleId = (i & 1) == 0 ? 0L : j;
        this.transactionId = str;
        if ((i & 4) == 0) {
            this.reason = "";
        } else {
            this.reason = str2;
        }
        if ((i & 8) == 0) {
            this.returnQty = MapsKt.emptyMap();
        } else {
            this.returnQty = map;
        }
        if ((i & 16) == 0) {
            this.lines = CollectionsKt.emptyList();
        } else {
            this.lines = list;
        }
    }

    public ReturnBody(long j, String transactionId, String reason, Map<String, Double> returnQty, List<ReturnLineBody> lines) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(returnQty, "returnQty");
        Intrinsics.checkNotNullParameter(lines, "lines");
        this.saleId = j;
        this.transactionId = transactionId;
        this.reason = reason;
        this.returnQty = returnQty;
        this.lines = lines;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ReturnBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.saleId != 0) {
            output.encodeLongElement(serialDesc, 0, self.saleId);
        }
        output.encodeStringElement(serialDesc, 1, self.transactionId);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.reason, "")) {
            output.encodeStringElement(serialDesc, 2, self.reason);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.returnQty, MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.returnQty);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && Intrinsics.areEqual(self.lines, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.lines);
    }

    public final long getSaleId() {
        return this.saleId;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public /* synthetic */ ReturnBody(long j, String str, String str2, Map map, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? MapsKt.emptyMap() : map, (i & 16) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getReason() {
        return this.reason;
    }

    public final Map<String, Double> getReturnQty() {
        return this.returnQty;
    }

    public final List<ReturnLineBody> getLines() {
        return this.lines;
    }
}
