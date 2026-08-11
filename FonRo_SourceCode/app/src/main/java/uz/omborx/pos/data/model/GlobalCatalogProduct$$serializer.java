package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/GlobalCatalogProduct.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/GlobalCatalogProduct;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class GlobalCatalogProduct$$serializer implements GeneratedSerializer<GlobalCatalogProduct> {
    public static final int $stable = 0;
    public static final GlobalCatalogProduct$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GlobalCatalogProduct$$serializer globalCatalogProduct$$serializer = new GlobalCatalogProduct$$serializer();
        INSTANCE = globalCatalogProduct$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.GlobalCatalogProduct", globalCatalogProduct$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("category_id", true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement(OptionalModuleUtils.BARCODE, true);
        pluginGeneratedSerialDescriptor.addElement("unit", true);
        pluginGeneratedSerialDescriptor.addElement("image_url", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GlobalCatalogProduct$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LenientLong.INSTANCE, LenientLong.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x006d. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final GlobalCatalogProduct deserialize(Decoder decoder) {
        String str;
        String str2;
        String str3;
        String str4;
        long j;
        long j2;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        long j3 = 0;
        if (beginStructure.decodeSequentially()) {
            long longValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, 0L)).longValue();
            long longValue2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 1, LenientLong.INSTANCE, 0L)).longValue();
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 3);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 4);
            str4 = decodeStringElement;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, null);
            str3 = decodeStringElement2;
            str2 = decodeStringElement3;
            j = longValue2;
            j2 = longValue;
            i = 63;
        } else {
            boolean z = true;
            int i2 = 0;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            long j4 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                    case 0:
                        i2 |= 1;
                        j3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, Long.valueOf(j3))).longValue();
                    case 1:
                        i2 |= 2;
                        j4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 1, LenientLong.INSTANCE, Long.valueOf(j4))).longValue();
                    case 2:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i2 |= 4;
                    case 3:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i2 |= 8;
                    case 4:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i2 |= 16;
                    case 5:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str5);
                        i2 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str5;
            str2 = str8;
            str3 = str7;
            str4 = str6;
            j = j4;
            j2 = j3;
            i = i2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new GlobalCatalogProduct(i, j2, j, str4, str3, str2, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, GlobalCatalogProduct value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        GlobalCatalogProduct.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
