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
import uz.FonRo.pos.data.net.LenientInt;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\nJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004J)\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001b\u0002\b)¢\u0006\u0002\b(R8\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\t0\u0014¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR8\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\t0\u0014¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000eÊ\u0001\u0002\b\u0012Ê\u0001\f\b-\u0012\b\b.\u0012\u0004\b\u0003\u0010\u0002¨\u0006,"}, d2 = {"Luz/FonRo/pos/data/model/GlobalCatalogImportResult;", "", "addedCount", "", "skippedCount", "<init>", "(II)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAddedCount$annotations", "()V", "getAddedCount", "()I", "Lkotlinx/serialization/SerialName;", "value", "added_count", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientInt;", "getSkippedCount$annotations", "getSkippedCount", "skipped_count", "component1", "component2", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class GlobalCatalogImportResult {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int addedCount;
    private final int skippedCount;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public GlobalCatalogImportResult() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.data.model.GlobalCatalogImportResult.<init>():void");
    }

    public static /* synthetic */ GlobalCatalogImportResult copy$default(GlobalCatalogImportResult globalCatalogImportResult, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = globalCatalogImportResult.addedCount;
        }
        if ((i3 & 2) != 0) {
            i2 = globalCatalogImportResult.skippedCount;
        }
        return globalCatalogImportResult.copy(i, i2);
    }

    @SerialName("added_count")
    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getAddedCount$annotations() {
    }

    @SerialName("skipped_count")
    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getSkippedCount$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final int getAddedCount() {
        return this.addedCount;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSkippedCount() {
        return this.skippedCount;
    }

    public final GlobalCatalogImportResult copy(int addedCount, int skippedCount) {
        return new GlobalCatalogImportResult(addedCount, skippedCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GlobalCatalogImportResult)) {
            return false;
        }
        GlobalCatalogImportResult globalCatalogImportResult = (GlobalCatalogImportResult) other;
        return this.addedCount == globalCatalogImportResult.addedCount && this.skippedCount == globalCatalogImportResult.skippedCount;
    }

    public int hashCode() {
        return (Integer.hashCode(this.addedCount) * 31) + Integer.hashCode(this.skippedCount);
    }

    public String toString() {
        return "GlobalCatalogImportResult(addedCount=" + this.addedCount + ", skippedCount=" + this.skippedCount + ")";
    }

    /* compiled from: Catalog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/GlobalCatalogImportResult$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/GlobalCatalogImportResult;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<GlobalCatalogImportResult> serializer() {
            return GlobalCatalogImportResult$$serializer.INSTANCE;
        }
    }

    public GlobalCatalogImportResult(int i, int i2) {
        this.addedCount = i;
        this.skippedCount = i2;
    }

    public /* synthetic */ GlobalCatalogImportResult(int i, int i2, int i3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.addedCount = 0;
        } else {
            this.addedCount = i2;
        }
        if ((i & 2) == 0) {
            this.skippedCount = 0;
        } else {
            this.skippedCount = i3;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(GlobalCatalogImportResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.addedCount != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientInt.INSTANCE, Integer.valueOf(self.addedCount));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.skippedCount == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 1, LenientInt.INSTANCE, Integer.valueOf(self.skippedCount));
    }

    public /* synthetic */ GlobalCatalogImportResult(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getAddedCount() {
        return this.addedCount;
    }

    public final int getSkippedCount() {
        return this.skippedCount;
    }
}
