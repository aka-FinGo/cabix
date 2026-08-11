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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientDoubleNullable;
import uz.FonRo.pos.data.net.LenientInt;

/* compiled from: Stats.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/StatsEmployee.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/StatsEmployee;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class StatsEmployee$$serializer implements GeneratedSerializer<StatsEmployee> {
    public static final int $stable = 0;
    public static final StatsEmployee$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        StatsEmployee$$serializer statsEmployee$$serializer = new StatsEmployee$$serializer();
        INSTANCE = statsEmployee$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.StatsEmployee", statsEmployee$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("role", true);
        pluginGeneratedSerialDescriptor.addElement("revenue", true);
        pluginGeneratedSerialDescriptor.addElement("cash", true);
        pluginGeneratedSerialDescriptor.addElement("card", true);
        pluginGeneratedSerialDescriptor.addElement("debt", true);
        pluginGeneratedSerialDescriptor.addElement("profit", true);
        pluginGeneratedSerialDescriptor.addElement("count", true);
        pluginGeneratedSerialDescriptor.addElement("returns_count", true);
        pluginGeneratedSerialDescriptor.addElement("returns_amount", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StatsEmployee$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LenientDouble.INSTANCE, BuiltinSerializersKt.getNullable(LenientDoubleNullable.INSTANCE), BuiltinSerializersKt.getNullable(LenientDoubleNullable.INSTANCE), LenientDouble.INSTANCE, LenientDouble.INSTANCE, LenientInt.INSTANCE, LenientInt.INSTANCE, LenientDouble.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00d1. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final StatsEmployee deserialize(Decoder decoder) {
        Double d;
        String str;
        int i;
        Double d2;
        String str2;
        int i2;
        double d3;
        double d4;
        double d5;
        double d6;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        boolean decodeSequentially = beginStructure.decodeSequentially();
        int i4 = 9;
        int i5 = 7;
        Double valueOf = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (decodeSequentially) {
            String str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            double doubleValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientDouble.INSTANCE, valueOf)).doubleValue();
            Double d7 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, LenientDoubleNullable.INSTANCE, null);
            Double d8 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LenientDoubleNullable.INSTANCE, null);
            double doubleValue2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 5, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 6, LenientDouble.INSTANCE, valueOf)).doubleValue();
            int intValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 7, LenientInt.INSTANCE, 0)).intValue();
            int intValue2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 8, LenientInt.INSTANCE, 0)).intValue();
            double doubleValue4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 9, LenientDouble.INSTANCE, valueOf)).doubleValue();
            str = str3;
            i2 = intValue;
            d2 = d7;
            i3 = intValue2;
            d = d8;
            d6 = doubleValue4;
            d3 = doubleValue;
            d4 = doubleValue2;
            i = 1023;
            d5 = doubleValue3;
        } else {
            double d9 = 0.0d;
            double d10 = 0.0d;
            double d11 = 0.0d;
            double d12 = 0.0d;
            boolean z = true;
            int i6 = 0;
            int i7 = 0;
            Double d13 = null;
            Double d14 = null;
            String str4 = null;
            int i8 = 0;
            String str5 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i5 = 7;
                    case 0:
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str4);
                        i6 |= 1;
                        i4 = 9;
                        i5 = 7;
                    case 1:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str5);
                        i6 |= 2;
                        i4 = 9;
                        i5 = 7;
                    case 2:
                        d9 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientDouble.INSTANCE, Double.valueOf(d9))).doubleValue();
                        i6 |= 4;
                        i4 = 9;
                        i5 = 7;
                    case 3:
                        d14 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, LenientDoubleNullable.INSTANCE, d14);
                        i6 |= 8;
                        i4 = 9;
                    case 4:
                        d13 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LenientDoubleNullable.INSTANCE, d13);
                        i6 |= 16;
                    case 5:
                        d10 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 5, LenientDouble.INSTANCE, Double.valueOf(d10))).doubleValue();
                        i6 |= 32;
                    case 6:
                        d11 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 6, LenientDouble.INSTANCE, Double.valueOf(d11))).doubleValue();
                        i6 |= 64;
                    case 7:
                        i7 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, i5, LenientInt.INSTANCE, Integer.valueOf(i7))).intValue();
                        i6 |= 128;
                    case 8:
                        i8 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 8, LenientInt.INSTANCE, Integer.valueOf(i8))).intValue();
                        i6 |= 256;
                    case 9:
                        d12 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, i4, LenientDouble.INSTANCE, Double.valueOf(d12))).doubleValue();
                        i6 |= 512;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str6 = str4;
            d = d13;
            str = str6;
            i = i6;
            int i9 = i8;
            d2 = d14;
            str2 = str5;
            i2 = i7;
            d3 = d9;
            d4 = d10;
            d5 = d11;
            d6 = d12;
            i3 = i9;
        }
        beginStructure.endStructure(serialDescriptor);
        return new StatsEmployee(i, str, str2, d3, d2, d, d4, d5, i2, i3, d6, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, StatsEmployee value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        StatsEmployee.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
