package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientInt;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/Product.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/Product;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class Product$$serializer implements GeneratedSerializer<Product> {
    public static final int $stable = 0;
    public static final Product$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Product$$serializer product$$serializer = new Product$$serializer();
        INSTANCE = product$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.Product", product$$serializer, 16);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement(OptionalModuleUtils.BARCODE, true);
        pluginGeneratedSerialDescriptor.addElement("barcode_aliases", true);
        pluginGeneratedSerialDescriptor.addElement("sku", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.QUANTITY, true);
        pluginGeneratedSerialDescriptor.addElement("unit", true);
        pluginGeneratedSerialDescriptor.addElement("sale_price", true);
        pluginGeneratedSerialDescriptor.addElement("purchase_price", true);
        pluginGeneratedSerialDescriptor.addElement("category_id", true);
        pluginGeneratedSerialDescriptor.addElement("sale_step", true);
        pluginGeneratedSerialDescriptor.addElement("expiration_date", true);
        pluginGeneratedSerialDescriptor.addElement("image_url", true);
        pluginGeneratedSerialDescriptor.addElement("image_urls", true);
        pluginGeneratedSerialDescriptor.addElement("image_base64", true);
        pluginGeneratedSerialDescriptor.addElement("is_archived", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Product$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = Product.$childSerializers;
        return new KSerializer[]{LenientLong.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), lazyArr[3].getValue(), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LenientDouble.INSTANCE, StringSerializer.INSTANCE, LenientDouble.INSTANCE, LenientDouble.INSTANCE, LenientLong.INSTANCE, LenientDouble.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), lazyArr[13].getValue(), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LenientInt.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x014a. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final Product deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        String str;
        String str2;
        List list;
        String str3;
        double d;
        double d2;
        double d3;
        int i2;
        String str4;
        String str5;
        String str6;
        List list2;
        String str7;
        long j;
        long j2;
        double d4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = Product.$childSerializers;
        boolean decodeSequentially = beginStructure.decodeSequentially();
        char c = 7;
        Double valueOf = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (decodeSequentially) {
            long longValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, 0L)).longValue();
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
            String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            List list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), null);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            double doubleValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 5, LenientDouble.INSTANCE, valueOf)).doubleValue();
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 6);
            double doubleValue2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 7, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 8, LenientDouble.INSTANCE, valueOf)).doubleValue();
            j2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 9, LenientLong.INSTANCE, 0L)).longValue();
            double doubleValue4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 10, LenientDouble.INSTANCE, valueOf)).doubleValue();
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, null);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, null);
            List list4 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 13, (DeserializationStrategy) lazyArr[13].getValue(), null);
            i = 65535;
            str4 = str9;
            j = longValue;
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, null);
            i2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 15, LenientInt.INSTANCE, 0)).intValue();
            str2 = str8;
            list = list3;
            str5 = str11;
            str7 = str10;
            d4 = doubleValue4;
            list2 = list4;
            d = doubleValue;
            d2 = doubleValue2;
            str = decodeStringElement;
            str3 = decodeStringElement2;
            d3 = doubleValue3;
        } else {
            boolean z = true;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            List list5 = null;
            String str15 = null;
            List list6 = null;
            String str16 = null;
            long j3 = 0;
            long j4 = 0;
            double d5 = 0.0d;
            double d6 = 0.0d;
            double d7 = 0.0d;
            double d8 = 0.0d;
            int i3 = 0;
            int i4 = 3;
            String str17 = null;
            String str18 = null;
            i = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i4 = 3;
                    case 0:
                        j3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, Long.valueOf(j3))).longValue();
                        i |= 1;
                        c = 7;
                        i4 = 3;
                    case 1:
                        str13 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i |= 2;
                        c = 7;
                        i4 = 3;
                    case 2:
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str14);
                        i |= 4;
                        c = 7;
                        i4 = 3;
                    case 3:
                        list5 = (List) beginStructure.decodeSerializableElement(serialDescriptor, i4, (DeserializationStrategy) lazyArr[i4].getValue(), list5);
                        i |= 8;
                        c = 7;
                    case 4:
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str12);
                        i |= 16;
                        c = 7;
                    case 5:
                        d5 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 5, LenientDouble.INSTANCE, Double.valueOf(d5))).doubleValue();
                        i |= 32;
                        c = 7;
                    case 6:
                        str18 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i |= 64;
                        c = c;
                    case 7:
                        d6 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 7, LenientDouble.INSTANCE, Double.valueOf(d6))).doubleValue();
                        i |= 128;
                        c = 7;
                    case 8:
                        d7 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 8, LenientDouble.INSTANCE, Double.valueOf(d7))).doubleValue();
                        i |= 256;
                        c = 7;
                    case 9:
                        j4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 9, LenientLong.INSTANCE, Long.valueOf(j4))).longValue();
                        i |= 512;
                        c = 7;
                    case 10:
                        d8 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 10, LenientDouble.INSTANCE, Double.valueOf(d8))).doubleValue();
                        i |= 1024;
                        c = 7;
                    case 11:
                        str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str16);
                        i |= 2048;
                        c = 7;
                    case 12:
                        str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str17);
                        i |= 4096;
                        c = 7;
                    case 13:
                        list6 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 13, (DeserializationStrategy) lazyArr[13].getValue(), list6);
                        i |= 8192;
                        c = 7;
                    case 14:
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str15);
                        i |= 16384;
                        c = 7;
                    case 15:
                        i3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 15, LenientInt.INSTANCE, Integer.valueOf(i3))).intValue();
                        i |= 32768;
                        c = 7;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str13;
            str2 = str14;
            list = list5;
            str3 = str18;
            d = d5;
            d2 = d6;
            d3 = d7;
            i2 = i3;
            str4 = str12;
            str5 = str17;
            str6 = str15;
            list2 = list6;
            str7 = str16;
            j = j3;
            j2 = j4;
            d4 = d8;
        }
        beginStructure.endStructure(serialDescriptor);
        return new Product(i, j, str, str2, list, str4, d, str3, d2, d3, j2, d4, str7, str5, list2, str6, i2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Product value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        Product.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
