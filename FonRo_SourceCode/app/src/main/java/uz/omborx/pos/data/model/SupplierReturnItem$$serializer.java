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
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/SupplierReturnItem.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/SupplierReturnItem;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class SupplierReturnItem$$serializer implements GeneratedSerializer<SupplierReturnItem> {
    public static final int $stable = 0;
    public static final SupplierReturnItem$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SupplierReturnItem$$serializer supplierReturnItem$$serializer = new SupplierReturnItem$$serializer();
        INSTANCE = supplierReturnItem$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.SupplierReturnItem", supplierReturnItem$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.PRODUCT_ID, true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.PRODUCT_NAME, true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.QUANTITY, true);
        pluginGeneratedSerialDescriptor.addElement("product_unit", true);
        pluginGeneratedSerialDescriptor.addElement("purchase_price", true);
        pluginGeneratedSerialDescriptor.addElement("amount", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SupplierReturnItem$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LenientLong.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LenientDouble.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LenientDouble.INSTANCE, LenientDouble.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x008f. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final SupplierReturnItem deserialize(Decoder decoder) {
        double d;
        double d2;
        String str;
        double d3;
        String str2;
        long j;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        boolean decodeSequentially = beginStructure.decodeSequentially();
        boolean z = true;
        long j2 = 0;
        String str3 = null;
        Double valueOf = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (decodeSequentially) {
            long longValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, 0L)).longValue();
            String str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            double doubleValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientDouble.INSTANCE, valueOf)).doubleValue();
            String str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            double doubleValue2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 4, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 5, LenientDouble.INSTANCE, valueOf)).doubleValue();
            str = str5;
            d3 = doubleValue;
            d2 = doubleValue2;
            d = doubleValue3;
            str2 = str4;
            i = 63;
            j = longValue;
        } else {
            boolean z2 = true;
            int i2 = 0;
            double d4 = 0.0d;
            double d5 = 0.0d;
            String str6 = null;
            double d6 = 0.0d;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z2 = false;
                        z = z;
                    case 0:
                        i2 |= 1;
                        z = z;
                        j2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, Long.valueOf(j2))).longValue();
                    case 1:
                        str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str3);
                        i2 |= 2;
                        z = true;
                    case 2:
                        d6 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientDouble.INSTANCE, Double.valueOf(d6))).doubleValue();
                        i2 |= 4;
                        z = true;
                    case 3:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str6);
                        i2 |= 8;
                        z = true;
                    case 4:
                        d4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 4, LenientDouble.INSTANCE, Double.valueOf(d4))).doubleValue();
                        i2 |= 16;
                        z = true;
                    case 5:
                        d5 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 5, LenientDouble.INSTANCE, Double.valueOf(d5))).doubleValue();
                        i2 |= 32;
                        z = true;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            d = d5;
            d2 = d4;
            str = str6;
            d3 = d6;
            str2 = str3;
            j = j2;
            i = i2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SupplierReturnItem(i, j, str2, d3, str, d2, d, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SupplierReturnItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SupplierReturnItem.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
