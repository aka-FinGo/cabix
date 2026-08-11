package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Money.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J)\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001b\u0002\b#¢\u0006\u0002\b\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011Ê\u0001\u0002\b'Ê\u0001\f\b(\u0012\b\b)\u0012\u0004\b\u0003\u0010\u0000¨\u0006&"}, d2 = {"Luz/FonRo/pos/data/model/DebtsResponse;", "", "kpis", "Luz/FonRo/pos/data/model/DebtKpis;", "sales", "", "Luz/FonRo/pos/data/model/DebtSale;", "<init>", "(Luz/FonRo/pos/data/model/DebtKpis;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILuz/FonRo/pos/data/model/DebtKpis;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getKpis", "()Luz/FonRo/pos/data/model/DebtKpis;", "getSales", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class DebtsResponse {
    private final DebtKpis kpis;
    private final List<DebtSale> sales;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.DebtsResponse$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = DebtsResponse._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    /* JADX WARN: Multi-variable type inference failed */
    public DebtsResponse() {
        this((DebtKpis) null, (List) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(DebtSale$$serializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DebtsResponse copy$default(DebtsResponse debtsResponse, DebtKpis debtKpis, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            debtKpis = debtsResponse.kpis;
        }
        if ((i & 2) != 0) {
            list = debtsResponse.sales;
        }
        return debtsResponse.copy(debtKpis, list);
    }

    /* renamed from: component1, reason: from getter */
    public final DebtKpis getKpis() {
        return this.kpis;
    }

    public final List<DebtSale> component2() {
        return this.sales;
    }

    public final DebtsResponse copy(DebtKpis kpis, List<DebtSale> sales) {
        Intrinsics.checkNotNullParameter(kpis, "kpis");
        Intrinsics.checkNotNullParameter(sales, "sales");
        return new DebtsResponse(kpis, sales);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DebtsResponse)) {
            return false;
        }
        DebtsResponse debtsResponse = (DebtsResponse) other;
        return Intrinsics.areEqual(this.kpis, debtsResponse.kpis) && Intrinsics.areEqual(this.sales, debtsResponse.sales);
    }

    public int hashCode() {
        return (this.kpis.hashCode() * 31) + this.sales.hashCode();
    }

    public String toString() {
        return "DebtsResponse(kpis=" + this.kpis + ", sales=" + this.sales + ")";
    }

    /* compiled from: Money.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/DebtsResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/DebtsResponse;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DebtsResponse> serializer() {
            return DebtsResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DebtsResponse(int i, DebtKpis debtKpis, List list, SerializationConstructorMarker serializationConstructorMarker) {
        this.kpis = (i & 1) == 0 ? new DebtKpis(AudioStats.AUDIO_AMPLITUDE_NONE, 1, (DefaultConstructorMarker) null) : debtKpis;
        if ((i & 2) == 0) {
            this.sales = CollectionsKt.emptyList();
        } else {
            this.sales = list;
        }
    }

    public DebtsResponse(DebtKpis kpis, List<DebtSale> sales) {
        Intrinsics.checkNotNullParameter(kpis, "kpis");
        Intrinsics.checkNotNullParameter(sales, "sales");
        this.kpis = kpis;
        this.sales = sales;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(DebtsResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.kpis, new DebtKpis(AudioStats.AUDIO_AMPLITUDE_NONE, 1, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 0, DebtKpis$$serializer.INSTANCE, self.kpis);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.sales, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.sales);
    }

    public /* synthetic */ DebtsResponse(DebtKpis debtKpis, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DebtKpis(AudioStats.AUDIO_AMPLITUDE_NONE, 1, (DefaultConstructorMarker) null) : debtKpis, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final DebtKpis getKpis() {
        return this.kpis;
    }

    public final List<DebtSale> getSales() {
        return this.sales;
    }
}
