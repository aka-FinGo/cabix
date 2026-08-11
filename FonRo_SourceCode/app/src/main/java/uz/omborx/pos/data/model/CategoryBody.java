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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J0\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004J)\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001b\u0002\b)¢\u0006\u0002\b(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR.\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004r\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0005\u0010\u0012Ê\u0001\u0002\b-Ê\u0001\f\b.\u0012\b\b/\u0012\u0004\b\u0003\u0010\u0002¨\u0006,"}, d2 = {"Luz/FonRo/pos/data/model/CategoryBody;", "", "name", "", TypedValues.Custom.S_COLOR, "isArchived", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getColor", "isArchived$annotations", "()V", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lkotlinx/serialization/SerialName;", "value", "is_archived", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Luz/FonRo/pos/data/model/CategoryBody;", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class CategoryBody {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String color;
    private final Integer isArchived;
    private final String name;

    public static /* synthetic */ CategoryBody copy$default(CategoryBody categoryBody, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = categoryBody.name;
        }
        if ((i & 2) != 0) {
            str2 = categoryBody.color;
        }
        if ((i & 4) != 0) {
            num = categoryBody.isArchived;
        }
        return categoryBody.copy(str, str2, num);
    }

    @SerialName("is_archived")
    public static /* synthetic */ void isArchived$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getIsArchived() {
        return this.isArchived;
    }

    public final CategoryBody copy(String name, String color, Integer isArchived) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new CategoryBody(name, color, isArchived);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CategoryBody)) {
            return false;
        }
        CategoryBody categoryBody = (CategoryBody) other;
        return Intrinsics.areEqual(this.name, categoryBody.name) && Intrinsics.areEqual(this.color, categoryBody.color) && Intrinsics.areEqual(this.isArchived, categoryBody.isArchived);
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.color;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.isArchived;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "CategoryBody(name=" + this.name + ", color=" + this.color + ", isArchived=" + this.isArchived + ")";
    }

    /* compiled from: Catalog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/CategoryBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/CategoryBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CategoryBody> serializer() {
            return CategoryBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CategoryBody(int i, String str, String str2, Integer num, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, CategoryBody$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        if ((i & 2) == 0) {
            this.color = null;
        } else {
            this.color = str2;
        }
        if ((i & 4) == 0) {
            this.isArchived = null;
        } else {
            this.isArchived = num;
        }
    }

    public CategoryBody(String name, String str, Integer num) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.color = str;
        this.isArchived = num;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(CategoryBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.name);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.color != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.color);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.isArchived == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.isArchived);
    }

    public /* synthetic */ CategoryBody(String str, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num);
    }

    public final String getName() {
        return this.name;
    }

    public final String getColor() {
        return this.color;
    }

    public final Integer isArchived() {
        return this.isArchived;
    }
}
