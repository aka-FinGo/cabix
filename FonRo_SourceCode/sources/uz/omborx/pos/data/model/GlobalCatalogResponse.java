package uz.FonRo.pos.data.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
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
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import uz.FonRo.pos.data.local.CacheStore;
import uz.FonRo.pos.data.net.LenientInt;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 92\u00020\u0001:\u000289BK\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0004\b\f\u0010\rB[\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0003JM\u0010(\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0001J\u0014\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020\bHÖ\u0081\u0004J\n\u0010-\u001a\u00020.HÖ\u0081\u0004J)\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001b\u0002\b7¢\u0006\u0002\b6R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R*\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\t0\u001b¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R*\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\t0\u001b¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018R0\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00038\u0006X\u0087\u0004r\f\b \u0012\b\b!\u0012\u0004\b\b(\"¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u0013Ê\u0001\u0002\b\u0019Ê\u0001\f\b;\u0012\b\b<\u0012\u0004\b\u0003\u0010\u0002¨\u0006:"}, d2 = {"Luz/FonRo/pos/data/model/GlobalCatalogResponse;", "", CacheStore.CATEGORIES, "", "Luz/FonRo/pos/data/model/GlobalCatalogCategory;", CacheStore.PRODUCTS, "Luz/FonRo/pos/data/model/GlobalCatalogProduct;", "total", "", TypedValues.CycleType.S_WAVE_OFFSET, "importedIds", "", "<init>", "(Ljava/util/List;Ljava/util/List;IILjava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;IILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCategories", "()Ljava/util/List;", "getProducts", "getTotal$annotations", "()V", "getTotal", "()I", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientInt;", "getOffset$annotations", "getOffset", "getImportedIds$annotations", "getImportedIds", "Lkotlinx/serialization/SerialName;", "value", "imported_ids", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class GlobalCatalogResponse {
    public static final int $stable = 0;
    private final List<GlobalCatalogCategory> categories;
    private final List<Long> importedIds;
    private final int offset;
    private final List<GlobalCatalogProduct> products;
    private final int total;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.GlobalCatalogResponse$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = GlobalCatalogResponse._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.GlobalCatalogResponse$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = GlobalCatalogResponse._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.GlobalCatalogResponse$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = GlobalCatalogResponse._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    })};

    public GlobalCatalogResponse() {
        this((List) null, (List) null, 0, 0, (List) null, 31, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(GlobalCatalogCategory$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(GlobalCatalogProduct$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(LongSerializer.INSTANCE);
    }

    public static /* synthetic */ GlobalCatalogResponse copy$default(GlobalCatalogResponse globalCatalogResponse, List list, List list2, int i, int i2, List list3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = globalCatalogResponse.categories;
        }
        if ((i3 & 2) != 0) {
            list2 = globalCatalogResponse.products;
        }
        if ((i3 & 4) != 0) {
            i = globalCatalogResponse.total;
        }
        if ((i3 & 8) != 0) {
            i2 = globalCatalogResponse.offset;
        }
        if ((i3 & 16) != 0) {
            list3 = globalCatalogResponse.importedIds;
        }
        List list4 = list3;
        int i4 = i;
        return globalCatalogResponse.copy(list, list2, i4, i2, list4);
    }

    @SerialName("imported_ids")
    public static /* synthetic */ void getImportedIds$annotations() {
    }

    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getOffset$annotations() {
    }

    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getTotal$annotations() {
    }

    public final List<GlobalCatalogCategory> component1() {
        return this.categories;
    }

    public final List<GlobalCatalogProduct> component2() {
        return this.products;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    /* renamed from: component4, reason: from getter */
    public final int getOffset() {
        return this.offset;
    }

    public final List<Long> component5() {
        return this.importedIds;
    }

    public final GlobalCatalogResponse copy(List<GlobalCatalogCategory> categories, List<GlobalCatalogProduct> products, int total, int offset, List<Long> importedIds) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(importedIds, "importedIds");
        return new GlobalCatalogResponse(categories, products, total, offset, importedIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GlobalCatalogResponse)) {
            return false;
        }
        GlobalCatalogResponse globalCatalogResponse = (GlobalCatalogResponse) other;
        return Intrinsics.areEqual(this.categories, globalCatalogResponse.categories) && Intrinsics.areEqual(this.products, globalCatalogResponse.products) && this.total == globalCatalogResponse.total && this.offset == globalCatalogResponse.offset && Intrinsics.areEqual(this.importedIds, globalCatalogResponse.importedIds);
    }

    public int hashCode() {
        return (((((((this.categories.hashCode() * 31) + this.products.hashCode()) * 31) + Integer.hashCode(this.total)) * 31) + Integer.hashCode(this.offset)) * 31) + this.importedIds.hashCode();
    }

    public String toString() {
        return "GlobalCatalogResponse(categories=" + this.categories + ", products=" + this.products + ", total=" + this.total + ", offset=" + this.offset + ", importedIds=" + this.importedIds + ")";
    }

    /* compiled from: Catalog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/GlobalCatalogResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/GlobalCatalogResponse;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<GlobalCatalogResponse> serializer() {
            return GlobalCatalogResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ GlobalCatalogResponse(int i, List list, List list2, int i2, int i3, List list3, SerializationConstructorMarker serializationConstructorMarker) {
        this.categories = (i & 1) == 0 ? CollectionsKt.emptyList() : list;
        if ((i & 2) == 0) {
            this.products = CollectionsKt.emptyList();
        } else {
            this.products = list2;
        }
        if ((i & 4) == 0) {
            this.total = 0;
        } else {
            this.total = i2;
        }
        if ((i & 8) == 0) {
            this.offset = 0;
        } else {
            this.offset = i3;
        }
        if ((i & 16) == 0) {
            this.importedIds = CollectionsKt.emptyList();
        } else {
            this.importedIds = list3;
        }
    }

    public GlobalCatalogResponse(List<GlobalCatalogCategory> categories, List<GlobalCatalogProduct> products, int i, int i2, List<Long> importedIds) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(importedIds, "importedIds");
        this.categories = categories;
        this.products = products;
        this.total = i;
        this.offset = i2;
        this.importedIds = importedIds;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(GlobalCatalogResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.categories, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.categories);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.products, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.products);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.total != 0) {
            output.encodeSerializableElement(serialDesc, 2, LenientInt.INSTANCE, Integer.valueOf(self.total));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.offset != 0) {
            output.encodeSerializableElement(serialDesc, 3, LenientInt.INSTANCE, Integer.valueOf(self.offset));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && Intrinsics.areEqual(self.importedIds, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.importedIds);
    }

    public /* synthetic */ GlobalCatalogResponse(List list, List list2, int i, int i2, List list3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list3);
    }

    public final List<GlobalCatalogCategory> getCategories() {
        return this.categories;
    }

    public final List<GlobalCatalogProduct> getProducts() {
        return this.products;
    }

    public final int getTotal() {
        return this.total;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final List<Long> getImportedIds() {
        return this.importedIds;
    }
}
