package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/ProductBody.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/ProductBody;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class ProductBody$$serializer implements GeneratedSerializer<ProductBody> {
    public static final int $stable = 0;
    public static final ProductBody$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ProductBody$$serializer productBody$$serializer = new ProductBody$$serializer();
        INSTANCE = productBody$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.ProductBody", productBody$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement(OptionalModuleUtils.BARCODE, true);
        pluginGeneratedSerialDescriptor.addElement("sku", true);
        pluginGeneratedSerialDescriptor.addElement("barcode_aliases", true);
        pluginGeneratedSerialDescriptor.addElement("category_id", true);
        pluginGeneratedSerialDescriptor.addElement("unit", true);
        pluginGeneratedSerialDescriptor.addElement("purchase_price", true);
        pluginGeneratedSerialDescriptor.addElement("sale_price", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.QUANTITY, true);
        pluginGeneratedSerialDescriptor.addElement("sale_step", true);
        pluginGeneratedSerialDescriptor.addElement("expiration_date", true);
        pluginGeneratedSerialDescriptor.addElement("is_archived", true);
        pluginGeneratedSerialDescriptor.addElement("image_base64_list", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ProductBody$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = ProductBody.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, lazyArr[3].getValue(), LongSerializer.INSTANCE, StringSerializer.INSTANCE, DoubleSerializer.INSTANCE, DoubleSerializer.INSTANCE, BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[12].getValue())};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00cf. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final ProductBody deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        List list;
        String str;
        Double d;
        String str2;
        Double d2;
        String str3;
        String str4;
        double d3;
        long j;
        double d4;
        List list2;
        Integer num;
        String str5;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = ProductBody.$childSerializers;
        int i2 = 10;
        int i3 = 9;
        String str6 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            str3 = beginStructure.decodeStringElement(serialDescriptor, 2);
            List list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), null);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 4);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 5);
            d4 = beginStructure.decodeDoubleElement(serialDescriptor, 6);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 7);
            Double d5 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, DoubleSerializer.INSTANCE, null);
            Double d6 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, DoubleSerializer.INSTANCE, null);
            String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, IntSerializer.INSTANCE, null);
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, (DeserializationStrategy) lazyArr[12].getValue(), null);
            str2 = str7;
            d = d6;
            d3 = decodeDoubleElement;
            d2 = d5;
            list = list3;
            j = decodeLongElement;
            str = decodeStringElement;
            str4 = decodeStringElement3;
            i = 8191;
            str5 = decodeStringElement2;
        } else {
            int i4 = 12;
            int i5 = 0;
            List list4 = null;
            String str8 = null;
            List list5 = null;
            Integer num2 = null;
            Double d7 = null;
            String str9 = null;
            boolean z = true;
            long j2 = 0;
            double d8 = 0.0d;
            double d9 = 0.0d;
            Double d10 = null;
            String str10 = null;
            String str11 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 10;
                        i4 = 12;
                    case 0:
                        i5 |= 1;
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 = 10;
                        i3 = 9;
                        i4 = 12;
                    case 1:
                        i5 |= 2;
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i2 = 10;
                        i3 = 9;
                        i4 = 12;
                    case 2:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i5 |= 4;
                        i2 = 10;
                        i3 = 9;
                        i4 = 12;
                    case 3:
                        list4 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list4);
                        i5 |= 8;
                        i2 = 10;
                        i3 = 9;
                        i4 = 12;
                    case 4:
                        j2 = beginStructure.decodeLongElement(serialDescriptor, 4);
                        i5 |= 16;
                        i2 = 10;
                        i4 = 12;
                    case 5:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i5 |= 32;
                        i2 = 10;
                        i4 = 12;
                    case 6:
                        d9 = beginStructure.decodeDoubleElement(serialDescriptor, 6);
                        i5 |= 64;
                        i2 = 10;
                        i4 = 12;
                    case 7:
                        d8 = beginStructure.decodeDoubleElement(serialDescriptor, 7);
                        i5 |= 128;
                        i4 = 12;
                    case 8:
                        d10 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, DoubleSerializer.INSTANCE, d10);
                        i5 |= 256;
                        i4 = 12;
                    case 9:
                        d7 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, i3, DoubleSerializer.INSTANCE, d7);
                        i5 |= 512;
                        i4 = 12;
                    case 10:
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str11);
                        i5 |= 1024;
                        i4 = 12;
                    case 11:
                        num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, IntSerializer.INSTANCE, num2);
                        i5 |= 2048;
                        i4 = 12;
                    case 12:
                        list5 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, i4, (DeserializationStrategy) lazyArr[i4].getValue(), list5);
                        i5 |= 4096;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            list = list4;
            str = str6;
            d = d7;
            str2 = str11;
            d2 = d10;
            str3 = str10;
            str4 = str9;
            d3 = d8;
            j = j2;
            d4 = d9;
            list2 = list5;
            num = num2;
            str5 = str8;
            i = i5;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ProductBody(i, str, str5, str3, list, j, str4, d4, d3, d2, d, str2, num, list2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ProductBody value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ProductBody.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
