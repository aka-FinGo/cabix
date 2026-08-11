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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Sales.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/ReturnLine.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/ReturnLine;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class ReturnLine$$serializer implements GeneratedSerializer<ReturnLine> {
    public static final int $stable = 0;
    public static final ReturnLine$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ReturnLine$$serializer returnLine$$serializer = new ReturnLine$$serializer();
        INSTANCE = returnLine$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.ReturnLine", returnLine$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("sale_item_id", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.PRODUCT_ID, true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.QUANTITY, true);
        pluginGeneratedSerialDescriptor.addElement("amount", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ReturnLine$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LenientLong.INSTANCE, LenientLong.INSTANCE, LenientDouble.INSTANCE, LenientDouble.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ReturnLine deserialize(Decoder decoder) {
        int i;
        long j;
        long j2;
        double d;
        double d2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        boolean decodeSequentially = beginStructure.decodeSequentially();
        long j3 = 0;
        Double valueOf = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (decodeSequentially) {
            long longValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, 0L)).longValue();
            long longValue2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 1, LenientLong.INSTANCE, 0L)).longValue();
            double doubleValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientDouble.INSTANCE, valueOf)).doubleValue();
            d2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 3, LenientDouble.INSTANCE, valueOf)).doubleValue();
            d = doubleValue;
            j = longValue;
            j2 = longValue2;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            double d3 = 0.0d;
            long j4 = 0;
            double d4 = 0.0d;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    i2 |= 1;
                    j3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, Long.valueOf(j3))).longValue();
                } else if (decodeElementIndex == 1) {
                    j4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 1, LenientLong.INSTANCE, Long.valueOf(j4))).longValue();
                    i2 |= 2;
                } else if (decodeElementIndex == 2) {
                    d4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientDouble.INSTANCE, Double.valueOf(d4))).doubleValue();
                    i2 |= 4;
                } else {
                    if (decodeElementIndex != 3) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    d3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 3, LenientDouble.INSTANCE, Double.valueOf(d3))).doubleValue();
                    i2 |= 8;
                }
            }
            i = i2;
            j = j3;
            j2 = j4;
            d = d4;
            d2 = d3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ReturnLine(i, j, j2, d, d2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ReturnLine value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ReturnLine.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
