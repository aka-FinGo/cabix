package uz.FonRo.pos.data.model;

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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Money.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/ActivityEntry.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/ActivityEntry;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class ActivityEntry$$serializer implements GeneratedSerializer<ActivityEntry> {
    public static final int $stable = 0;
    public static final ActivityEntry$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ActivityEntry$$serializer activityEntry$$serializer = new ActivityEntry$$serializer();
        INSTANCE = activityEntry$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.ActivityEntry", activityEntry$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("action", true);
        pluginGeneratedSerialDescriptor.addElement("description", true);
        pluginGeneratedSerialDescriptor.addElement("entity_type", true);
        pluginGeneratedSerialDescriptor.addElement("entity_id", true);
        pluginGeneratedSerialDescriptor.addElement("user_name", true);
        pluginGeneratedSerialDescriptor.addElement("created_at", true);
        pluginGeneratedSerialDescriptor.addElement("payload", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ActivityEntry$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LenientLong.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LenientLong.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0094. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final ActivityEntry deserialize(Decoder decoder) {
        String str;
        long j;
        String str2;
        long j2;
        JsonElement jsonElement;
        String str3;
        String str4;
        int i;
        String str5;
        char c;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 7;
        long j3 = 0;
        if (beginStructure.decodeSequentially()) {
            j = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, 0L)).longValue();
            String str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            long longValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 4, LenientLong.INSTANCE, 0L)).longValue();
            String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 6);
            jsonElement = (JsonElement) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, JsonElementSerializer.INSTANCE, null);
            str4 = decodeStringElement;
            str5 = str9;
            str3 = str8;
            i = 255;
            j2 = longValue;
            str2 = str6;
            str = str7;
        } else {
            boolean z = true;
            int i3 = 0;
            JsonElement jsonElement2 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            long j4 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                    case 0:
                        i3 |= 1;
                        j3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, Long.valueOf(j3))).longValue();
                        i2 = 7;
                    case 1:
                        c = 4;
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str13);
                        i3 |= 2;
                        i2 = 7;
                    case 2:
                        c = 4;
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str12);
                        i3 |= 4;
                        i2 = 7;
                    case 3:
                        c = 4;
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str11);
                        i3 |= 8;
                        i2 = 7;
                    case 4:
                        i3 |= 16;
                        j4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 4, LenientLong.INSTANCE, Long.valueOf(j4))).longValue();
                    case 5:
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str10);
                        i3 |= 32;
                    case 6:
                        str14 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i3 |= 64;
                    case 7:
                        jsonElement2 = (JsonElement) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, JsonElementSerializer.INSTANCE, jsonElement2);
                        i3 |= 128;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            long j5 = j4;
            str = str12;
            j = j3;
            str2 = str13;
            j2 = j5;
            jsonElement = jsonElement2;
            str3 = str11;
            str4 = str14;
            i = i3;
            str5 = str10;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ActivityEntry(i, j, str2, str, str3, j2, str5, str4, jsonElement, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ActivityEntry value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ActivityEntry.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
