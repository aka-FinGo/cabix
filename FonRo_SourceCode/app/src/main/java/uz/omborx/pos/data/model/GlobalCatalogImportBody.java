package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import uz.FonRo.pos.core.Lang;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J#\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0006HÖ\u0081\u0004J)\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001b\u0002\b\"¢\u0006\u0002\b!R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011Ê\u0001\u0002\b&Ê\u0001\f\b'\u0012\b\b(\u0012\u0004\b\u0003\u0010\u0000¨\u0006%"}, d2 = {"Luz/FonRo/pos/data/model/GlobalCatalogImportBody;", "", "ids", "", "", "lang", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIds", "()Ljava/util/List;", "getLang", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class GlobalCatalogImportBody {
    private final List<Long> ids;
    private final String lang;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.GlobalCatalogImportBody$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = GlobalCatalogImportBody._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(LongSerializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GlobalCatalogImportBody copy$default(GlobalCatalogImportBody globalCatalogImportBody, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = globalCatalogImportBody.ids;
        }
        if ((i & 2) != 0) {
            str = globalCatalogImportBody.lang;
        }
        return globalCatalogImportBody.copy(list, str);
    }

    public final List<Long> component1() {
        return this.ids;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    public final GlobalCatalogImportBody copy(List<Long> ids, String lang) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        Intrinsics.checkNotNullParameter(lang, "lang");
        return new GlobalCatalogImportBody(ids, lang);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GlobalCatalogImportBody)) {
            return false;
        }
        GlobalCatalogImportBody globalCatalogImportBody = (GlobalCatalogImportBody) other;
        return Intrinsics.areEqual(this.ids, globalCatalogImportBody.ids) && Intrinsics.areEqual(this.lang, globalCatalogImportBody.lang);
    }

    public int hashCode() {
        return (this.ids.hashCode() * 31) + this.lang.hashCode();
    }

    public String toString() {
        return "GlobalCatalogImportBody(ids=" + this.ids + ", lang=" + this.lang + ")";
    }

    /* compiled from: Catalog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/GlobalCatalogImportBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/GlobalCatalogImportBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<GlobalCatalogImportBody> serializer() {
            return GlobalCatalogImportBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ GlobalCatalogImportBody(int i, List list, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, GlobalCatalogImportBody$$serializer.INSTANCE.getDescriptor());
        }
        this.ids = list;
        if ((i & 2) == 0) {
            this.lang = Lang.DEFAULT;
        } else {
            this.lang = str;
        }
    }

    public GlobalCatalogImportBody(List<Long> ids, String lang) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        Intrinsics.checkNotNullParameter(lang, "lang");
        this.ids = ids;
        this.lang = lang;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(GlobalCatalogImportBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, $childSerializers[0].getValue(), self.ids);
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.lang, Lang.DEFAULT)) {
            return;
        }
        output.encodeStringElement(serialDesc, 1, self.lang);
    }

    public final List<Long> getIds() {
        return this.ids;
    }

    public /* synthetic */ GlobalCatalogImportBody(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? Lang.DEFAULT : str);
    }

    public final String getLang() {
        return this.lang;
    }
}
