package uz.FonRo.pos.data.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import uz.FonRo.pos.data.net.LenientInt;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000223B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J3\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010'\u001a\u00020\bHÖ\u0081\u0004J\n\u0010(\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001b\u0002\b1¢\u0006\u0002\b0R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\t0\u0015¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R8\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001dr\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\t0\u001e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0007\u0010\u001aÊ\u0001\u0002\b\u0013Ê\u0001\f\b5\u0012\b\b6\u0012\u0004\b\u0003\u0010\u0002¨\u00064"}, d2 = {"Luz/FonRo/pos/data/model/Category;", "", "id", "", "name", "", TypedValues.Custom.S_COLOR, "isArchived", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getName", "()Ljava/lang/String;", "getColor", "isArchived$annotations", "()I", "Lkotlinx/serialization/SerialName;", "value", "is_archived", "Luz/FonRo/pos/data/net/LenientInt;", "component1", "component2", "component3", "component4", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class Category {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String color;
    private final long id;
    private final int isArchived;
    private final String name;

    public Category() {
        this(0L, (String) null, (String) null, 0, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Category copy$default(Category category, long j, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = category.id;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = category.name;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = category.color;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            i = category.isArchived;
        }
        return category.copy(j2, str3, str4, i);
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("is_archived")
    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void isArchived$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* renamed from: component4, reason: from getter */
    public final int getIsArchived() {
        return this.isArchived;
    }

    public final Category copy(long id, String name, String color, int isArchived) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new Category(id, name, color, isArchived);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Category)) {
            return false;
        }
        Category category = (Category) other;
        return this.id == category.id && Intrinsics.areEqual(this.name, category.name) && Intrinsics.areEqual(this.color, category.color) && this.isArchived == category.isArchived;
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.id) * 31) + this.name.hashCode()) * 31;
        String str = this.color;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.isArchived);
    }

    public String toString() {
        return "Category(id=" + this.id + ", name=" + this.name + ", color=" + this.color + ", isArchived=" + this.isArchived + ")";
    }

    /* compiled from: Catalog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/Category$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/Category;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Category> serializer() {
            return Category$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Category(int i, long j, String str, String str2, int i2, SerializationConstructorMarker serializationConstructorMarker) {
        this.id = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.name = "";
        } else {
            this.name = str;
        }
        if ((i & 4) == 0) {
            this.color = null;
        } else {
            this.color = str2;
        }
        if ((i & 8) == 0) {
            this.isArchived = 0;
        } else {
            this.isArchived = i2;
        }
    }

    public Category(long j, String name, String str, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = j;
        this.name = name;
        this.color = str;
        this.isArchived = i;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(Category self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.name, "")) {
            output.encodeStringElement(serialDesc, 1, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.color != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.color);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.isArchived == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 3, LenientInt.INSTANCE, Integer.valueOf(self.isArchived));
    }

    public final long getId() {
        return this.id;
    }

    public /* synthetic */ Category(long j, String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? 0 : i);
    }

    public final String getName() {
        return this.name;
    }

    public final String getColor() {
        return this.color;
    }

    public final int isArchived() {
        return this.isArchived;
    }
}
