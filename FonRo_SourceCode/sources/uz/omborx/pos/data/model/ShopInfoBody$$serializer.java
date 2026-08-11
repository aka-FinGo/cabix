package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/ShopInfoBody.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/ShopInfoBody;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class ShopInfoBody$$serializer implements GeneratedSerializer<ShopInfoBody> {
    public static final int $stable = 0;
    public static final ShopInfoBody$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ShopInfoBody$$serializer shopInfoBody$$serializer = new ShopInfoBody$$serializer();
        INSTANCE = shopInfoBody$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.ShopInfoBody", shopInfoBody$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("about", true);
        pluginGeneratedSerialDescriptor.addElement("online_shop_enabled", true);
        pluginGeneratedSerialDescriptor.addElement("shop_currency", true);
        pluginGeneratedSerialDescriptor.addElement("delivery_enabled", true);
        pluginGeneratedSerialDescriptor.addElement("delivery_price", true);
        pluginGeneratedSerialDescriptor.addElement("free_delivery_radius_km", true);
        pluginGeneratedSerialDescriptor.addElement("free_delivery_min_total", true);
        pluginGeneratedSerialDescriptor.addElement("location_lat", true);
        pluginGeneratedSerialDescriptor.addElement("location_lng", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ShopInfoBody$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BooleanSerializer.INSTANCE, DoubleSerializer.INSTANCE, DoubleSerializer.INSTANCE, DoubleSerializer.INSTANCE, BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0087. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final ShopInfoBody deserialize(Decoder decoder) {
        int i;
        JsonElement jsonElement;
        String str;
        JsonElement jsonElement2;
        String str2;
        double d;
        double d2;
        boolean z;
        String str3;
        boolean z2;
        double d3;
        char c;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 9;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            str2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 2);
            String str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 4);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 5);
            double decodeDoubleElement2 = beginStructure.decodeDoubleElement(serialDescriptor, 6);
            double decodeDoubleElement3 = beginStructure.decodeDoubleElement(serialDescriptor, 7);
            JsonElement jsonElement3 = (JsonElement) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, JsonElementSerializer.INSTANCE, null);
            jsonElement = (JsonElement) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, JsonElementSerializer.INSTANCE, null);
            jsonElement2 = jsonElement3;
            str3 = str4;
            z2 = decodeBooleanElement;
            d = decodeDoubleElement3;
            str = decodeStringElement;
            d2 = decodeDoubleElement2;
            d3 = decodeDoubleElement;
            z = decodeBooleanElement2;
            i = 1023;
        } else {
            double d4 = AudioStats.AUDIO_AMPLITUDE_NONE;
            boolean z3 = true;
            int i3 = 0;
            boolean z4 = false;
            JsonElement jsonElement4 = null;
            JsonElement jsonElement5 = null;
            String str5 = null;
            String str6 = null;
            double d5 = 0.0d;
            double d6 = 0.0d;
            boolean z5 = false;
            String str7 = null;
            while (z3) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z3 = false;
                        i2 = 9;
                    case 0:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i3 |= 1;
                        i2 = 9;
                    case 1:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i3 |= 2;
                        i2 = 9;
                    case 2:
                        c = 3;
                        z4 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                        i3 |= 4;
                        i2 = 9;
                    case 3:
                        c = 3;
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str7);
                        i3 |= 8;
                        i2 = 9;
                    case 4:
                        z5 = beginStructure.decodeBooleanElement(serialDescriptor, 4);
                        i3 |= 16;
                    case 5:
                        d5 = beginStructure.decodeDoubleElement(serialDescriptor, 5);
                        i3 |= 32;
                    case 6:
                        d4 = beginStructure.decodeDoubleElement(serialDescriptor, 6);
                        i3 |= 64;
                    case 7:
                        d6 = beginStructure.decodeDoubleElement(serialDescriptor, 7);
                        i3 |= 128;
                    case 8:
                        jsonElement5 = (JsonElement) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, JsonElementSerializer.INSTANCE, jsonElement5);
                        i3 |= 256;
                    case 9:
                        jsonElement4 = (JsonElement) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, JsonElementSerializer.INSTANCE, jsonElement4);
                        i3 |= 512;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i3;
            double d7 = d6;
            jsonElement = jsonElement4;
            str = str5;
            jsonElement2 = jsonElement5;
            str2 = str6;
            d = d7;
            d2 = d4;
            z = z5;
            str3 = str7;
            z2 = z4;
            d3 = d5;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ShopInfoBody(i, str, str2, z2, str3, z, d3, d2, d, jsonElement2, jsonElement, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ShopInfoBody value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ShopInfoBody.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
