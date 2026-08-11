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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/SupplierReturnPushItem.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/SupplierReturnPushItem;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class SupplierReturnPushItem$$serializer implements GeneratedSerializer<SupplierReturnPushItem> {
    public static final int $stable = 0;
    public static final SupplierReturnPushItem$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SupplierReturnPushItem$$serializer supplierReturnPushItem$$serializer = new SupplierReturnPushItem$$serializer();
        INSTANCE = supplierReturnPushItem$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.SupplierReturnPushItem", supplierReturnPushItem$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.PRODUCT_ID, false);
        pluginGeneratedSerialDescriptor.addElement("product_server_id", false);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.PRODUCT_NAME, false);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.QUANTITY, false);
        pluginGeneratedSerialDescriptor.addElement("product_unit", false);
        pluginGeneratedSerialDescriptor.addElement("purchase_price", false);
        pluginGeneratedSerialDescriptor.addElement("amount", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SupplierReturnPushItem$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LongSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE, DoubleSerializer.INSTANCE, StringSerializer.INSTANCE, DoubleSerializer.INSTANCE, DoubleSerializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x005b. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final SupplierReturnPushItem deserialize(Decoder decoder) {
        String str;
        double d;
        int i;
        double d2;
        long j;
        String str2;
        double d3;
        long j2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 0);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 1);
            str = beginStructure.decodeStringElement(serialDescriptor, 2);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 3);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 4);
            double decodeDoubleElement2 = beginStructure.decodeDoubleElement(serialDescriptor, 5);
            d2 = beginStructure.decodeDoubleElement(serialDescriptor, 6);
            str2 = decodeStringElement;
            d3 = decodeDoubleElement;
            d = decodeDoubleElement2;
            j2 = decodeLongElement2;
            i = 127;
            j = decodeLongElement;
        } else {
            str = null;
            double d4 = AudioStats.AUDIO_AMPLITUDE_NONE;
            boolean z = true;
            long j3 = 0;
            long j4 = 0;
            double d5 = 0.0d;
            d = 0.0d;
            String str3 = null;
            i = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                    case 0:
                        j3 = beginStructure.decodeLongElement(serialDescriptor, 0);
                        i |= 1;
                    case 1:
                        j4 = beginStructure.decodeLongElement(serialDescriptor, 1);
                        i |= 2;
                    case 2:
                        str = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i |= 4;
                    case 3:
                        d5 = beginStructure.decodeDoubleElement(serialDescriptor, 3);
                        i |= 8;
                    case 4:
                        str3 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i |= 16;
                    case 5:
                        d = beginStructure.decodeDoubleElement(serialDescriptor, 5);
                        i |= 32;
                    case 6:
                        d4 = beginStructure.decodeDoubleElement(serialDescriptor, 6);
                        i |= 64;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            d2 = d4;
            j = j3;
            str2 = str3;
            d3 = d5;
            j2 = j4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SupplierReturnPushItem(i, j, j2, str, d3, str2, d, d2, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SupplierReturnPushItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SupplierReturnPushItem.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
