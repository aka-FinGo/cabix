package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientLong;
import uz.FonRo.pos.data.net.LenientString;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/ShopOrder.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/ShopOrder;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class ShopOrder$$serializer implements GeneratedSerializer<ShopOrder> {
    public static final int $stable = 0;
    public static final ShopOrder$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ShopOrder$$serializer shopOrder$$serializer = new ShopOrder$$serializer();
        INSTANCE = shopOrder$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.ShopOrder", shopOrder$$serializer, 19);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("order_number", true);
        pluginGeneratedSerialDescriptor.addElement("customer_name", true);
        pluginGeneratedSerialDescriptor.addElement("customer_phone", true);
        pluginGeneratedSerialDescriptor.addElement("address", true);
        pluginGeneratedSerialDescriptor.addElement(NotificationCompat.CATEGORY_STATUS, true);
        pluginGeneratedSerialDescriptor.addElement("note", true);
        pluginGeneratedSerialDescriptor.addElement("total_amount", true);
        pluginGeneratedSerialDescriptor.addElement("created_at", true);
        pluginGeneratedSerialDescriptor.addElement("customer_email", true);
        pluginGeneratedSerialDescriptor.addElement("delivery_type", true);
        pluginGeneratedSerialDescriptor.addElement("delivery_price", true);
        pluginGeneratedSerialDescriptor.addElement("confirmed_at", true);
        pluginGeneratedSerialDescriptor.addElement("completed_at", true);
        pluginGeneratedSerialDescriptor.addElement("cancelled_at", true);
        pluginGeneratedSerialDescriptor.addElement("cancel_reason", true);
        pluginGeneratedSerialDescriptor.addElement("location_lat", true);
        pluginGeneratedSerialDescriptor.addElement("location_lng", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.ITEMS, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ShopOrder$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = ShopOrder.$childSerializers;
        return new KSerializer[]{LenientLong.INSTANCE, LenientString.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LenientDouble.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LenientDouble.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), lazyArr[18].getValue()};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0172. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final ShopOrder deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        String str;
        Double d;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        List list;
        double d2;
        double d3;
        Double d4;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        long j;
        String str13;
        Double d5;
        String str14;
        Double d6;
        List list2;
        List list3;
        int i2;
        String str15;
        Double d7;
        Double d8;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = ShopOrder.$childSerializers;
        boolean decodeSequentially = beginStructure.decodeSequentially();
        Double valueOf = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (decodeSequentially) {
            long longValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, 0L)).longValue();
            String str16 = (String) beginStructure.decodeSerializableElement(serialDescriptor, 1, LenientString.INSTANCE, null);
            String str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            String str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            String str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 5);
            String str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, null);
            double doubleValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 7, LenientDouble.INSTANCE, valueOf)).doubleValue();
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 8);
            String str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, null);
            String str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, null);
            double doubleValue2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 11, LenientDouble.INSTANCE, valueOf)).doubleValue();
            String str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, null);
            String str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, null);
            String str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, null);
            String str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, null);
            Double d9 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, DoubleSerializer.INSTANCE, null);
            i = 524287;
            d4 = d9;
            d = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, DoubleSerializer.INSTANCE, null);
            str13 = str19;
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 18, (DeserializationStrategy) lazyArr[18].getValue(), null);
            str2 = str26;
            str3 = str25;
            str4 = str24;
            str5 = decodeStringElement;
            str = str23;
            str7 = decodeStringElement2;
            str6 = str20;
            d2 = doubleValue;
            str10 = str16;
            str9 = str17;
            str11 = str18;
            j = longValue;
            str12 = str22;
            d3 = doubleValue2;
            str8 = str21;
        } else {
            int i3 = 18;
            boolean z = true;
            String str27 = null;
            Double d10 = null;
            String str28 = null;
            String str29 = null;
            List list4 = null;
            String str30 = null;
            String str31 = null;
            String str32 = null;
            String str33 = null;
            String str34 = null;
            String str35 = null;
            Double d11 = null;
            String str36 = null;
            long j2 = 0;
            double d12 = 0.0d;
            double d13 = 0.0d;
            i = 0;
            String str37 = null;
            String str38 = null;
            String str39 = null;
            while (z) {
                int i4 = i3;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        str15 = str30;
                        d7 = d11;
                        z = false;
                        list4 = list4;
                        str37 = str37;
                        d11 = d7;
                        str30 = str15;
                        i3 = 18;
                    case 0:
                        d8 = d10;
                        str15 = str30;
                        d7 = d11;
                        j2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, Long.valueOf(j2))).longValue();
                        i |= 1;
                        str27 = str27;
                        list4 = list4;
                        str37 = str37;
                        d10 = d8;
                        d11 = d7;
                        str30 = str15;
                        i3 = 18;
                    case 1:
                        d8 = d10;
                        str15 = str30;
                        d7 = d11;
                        str36 = (String) beginStructure.decodeSerializableElement(serialDescriptor, 1, LenientString.INSTANCE, str36);
                        i |= 2;
                        str27 = str27;
                        list4 = list4;
                        d10 = d8;
                        d11 = d7;
                        str30 = str15;
                        i3 = 18;
                    case 2:
                        i |= 4;
                        list4 = list4;
                        i3 = 18;
                        d11 = d11;
                        str30 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str30);
                        d10 = d10;
                    case 3:
                        d5 = d10;
                        str14 = str30;
                        d6 = d11;
                        list2 = list4;
                        str31 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str31);
                        i |= 8;
                        list4 = list2;
                        d10 = d5;
                        i3 = 18;
                        d11 = d6;
                        str30 = str14;
                    case 4:
                        d5 = d10;
                        str14 = str30;
                        d6 = d11;
                        list2 = list4;
                        str37 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str37);
                        i |= 16;
                        list4 = list2;
                        d10 = d5;
                        i3 = 18;
                        d11 = d6;
                        str30 = str14;
                    case 5:
                        d5 = d10;
                        str14 = str30;
                        d6 = d11;
                        list2 = list4;
                        str38 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i |= 32;
                        list4 = list2;
                        d10 = d5;
                        i3 = 18;
                        d11 = d6;
                        str30 = str14;
                    case 6:
                        d5 = d10;
                        str14 = str30;
                        d6 = d11;
                        list2 = list4;
                        str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str27);
                        i |= 64;
                        list4 = list2;
                        d10 = d5;
                        i3 = 18;
                        d11 = d6;
                        str30 = str14;
                    case 7:
                        d5 = d10;
                        str14 = str30;
                        d6 = d11;
                        list2 = list4;
                        d12 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 7, LenientDouble.INSTANCE, Double.valueOf(d12))).doubleValue();
                        i |= 128;
                        list4 = list2;
                        d10 = d5;
                        i3 = 18;
                        d11 = d6;
                        str30 = str14;
                    case 8:
                        d5 = d10;
                        str14 = str30;
                        d6 = d11;
                        list2 = list4;
                        str39 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i |= 256;
                        list4 = list2;
                        d10 = d5;
                        i3 = 18;
                        d11 = d6;
                        str30 = str14;
                    case 9:
                        d5 = d10;
                        str14 = str30;
                        d6 = d11;
                        list2 = list4;
                        str29 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str29);
                        i |= 512;
                        list4 = list2;
                        d10 = d5;
                        i3 = 18;
                        d11 = d6;
                        str30 = str14;
                    case 10:
                        d5 = d10;
                        str14 = str30;
                        d6 = d11;
                        list2 = list4;
                        str35 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str35);
                        i |= 1024;
                        list4 = list2;
                        d10 = d5;
                        i3 = 18;
                        d11 = d6;
                        str30 = str14;
                    case 11:
                        str14 = str30;
                        d6 = d11;
                        list2 = list4;
                        d5 = d10;
                        d13 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 11, LenientDouble.INSTANCE, Double.valueOf(d13))).doubleValue();
                        i |= 2048;
                        list4 = list2;
                        d10 = d5;
                        i3 = 18;
                        d11 = d6;
                        str30 = str14;
                    case 12:
                        str14 = str30;
                        d6 = d11;
                        list3 = list4;
                        str28 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str28);
                        i |= 4096;
                        list4 = list3;
                        i3 = 18;
                        d11 = d6;
                        str30 = str14;
                    case 13:
                        str14 = str30;
                        d6 = d11;
                        list3 = list4;
                        str34 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str34);
                        i |= 8192;
                        list4 = list3;
                        i3 = 18;
                        d11 = d6;
                        str30 = str14;
                    case 14:
                        str14 = str30;
                        d6 = d11;
                        list3 = list4;
                        str33 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str33);
                        i |= 16384;
                        list4 = list3;
                        i3 = 18;
                        d11 = d6;
                        str30 = str14;
                    case 15:
                        str14 = str30;
                        d6 = d11;
                        list3 = list4;
                        str32 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str32);
                        i2 = 32768;
                        i |= i2;
                        list4 = list3;
                        i3 = 18;
                        d11 = d6;
                        str30 = str14;
                    case 16:
                        str14 = str30;
                        d6 = d11;
                        list3 = list4;
                        d10 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, DoubleSerializer.INSTANCE, d10);
                        i2 = 65536;
                        i |= i2;
                        list4 = list3;
                        i3 = 18;
                        d11 = d6;
                        str30 = str14;
                    case 17:
                        i |= 131072;
                        list4 = list4;
                        str30 = str30;
                        d11 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, DoubleSerializer.INSTANCE, d11);
                        i3 = 18;
                    case 18:
                        str14 = str30;
                        list4 = (List) beginStructure.decodeSerializableElement(serialDescriptor, i4, (DeserializationStrategy) lazyArr[i4].getValue(), list4);
                        i |= 262144;
                        i3 = i4;
                        str30 = str14;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str40 = str30;
            str = str28;
            d = d11;
            str2 = str32;
            str3 = str33;
            str4 = str34;
            str5 = str38;
            str6 = str27;
            str7 = str39;
            list = list4;
            d2 = d12;
            d3 = d13;
            d4 = d10;
            str8 = str29;
            str9 = str40;
            str10 = str36;
            str11 = str31;
            str12 = str35;
            j = j2;
            str13 = str37;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ShopOrder(i, j, str10, str9, str11, str13, str5, str6, d2, str7, str8, str12, d3, str, str4, str3, str2, d4, d, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ShopOrder value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ShopOrder.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
