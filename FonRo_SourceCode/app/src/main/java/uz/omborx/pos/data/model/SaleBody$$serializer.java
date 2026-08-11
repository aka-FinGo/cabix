package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Sales.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/SaleBody.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/SaleBody;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class SaleBody$$serializer implements GeneratedSerializer<SaleBody> {
    public static final int $stable = 0;
    public static final SaleBody$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SaleBody$$serializer saleBody$$serializer = new SaleBody$$serializer();
        INSTANCE = saleBody$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.SaleBody", saleBody$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.TRANSACTION_ID, false);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.ITEMS, false);
        pluginGeneratedSerialDescriptor.addElement("discount_type", true);
        pluginGeneratedSerialDescriptor.addElement("discount_value", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.PAYMENT_TYPE, false);
        pluginGeneratedSerialDescriptor.addElement("customer_id", true);
        pluginGeneratedSerialDescriptor.addElement("paid_amount", true);
        pluginGeneratedSerialDescriptor.addElement("received_amount", true);
        pluginGeneratedSerialDescriptor.addElement("change_amount", true);
        pluginGeneratedSerialDescriptor.addElement("cash_amount", true);
        pluginGeneratedSerialDescriptor.addElement("card_amount", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SaleBody$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = SaleBody.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, lazyArr[1].getValue(), StringSerializer.INSTANCE, DoubleSerializer.INSTANCE, StringSerializer.INSTANCE, LongSerializer.INSTANCE, DoubleSerializer.INSTANCE, DoubleSerializer.INSTANCE, DoubleSerializer.INSTANCE, DoubleSerializer.INSTANCE, DoubleSerializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0097. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final SaleBody deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        double d;
        double d2;
        List list;
        String str;
        int i;
        String str2;
        String str3;
        double d3;
        double d4;
        long j;
        double d5;
        double d6;
        int i2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = SaleBody.$childSerializers;
        int i3 = 10;
        int i4 = 1;
        String str4 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            List list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 3);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 4);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 5);
            double decodeDoubleElement2 = beginStructure.decodeDoubleElement(serialDescriptor, 6);
            double decodeDoubleElement3 = beginStructure.decodeDoubleElement(serialDescriptor, 7);
            double decodeDoubleElement4 = beginStructure.decodeDoubleElement(serialDescriptor, 8);
            d2 = beginStructure.decodeDoubleElement(serialDescriptor, 9);
            d3 = decodeDoubleElement2;
            str3 = decodeStringElement3;
            d6 = decodeDoubleElement4;
            j = decodeLongElement;
            d5 = decodeDoubleElement3;
            d = beginStructure.decodeDoubleElement(serialDescriptor, 10);
            list = list2;
            str = decodeStringElement;
            i = 2047;
            str2 = decodeStringElement2;
            d4 = decodeDoubleElement;
        } else {
            double d7 = AudioStats.AUDIO_AMPLITUDE_NONE;
            boolean z = true;
            int i5 = 0;
            List list3 = null;
            String str5 = null;
            String str6 = null;
            double d8 = 0.0d;
            double d9 = 0.0d;
            double d10 = 0.0d;
            double d11 = 0.0d;
            long j2 = 0;
            double d12 = 0.0d;
            while (z) {
                int i6 = i4;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i4 = i6;
                    case 0:
                        i2 = i6;
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i5 |= 1;
                        i4 = i2;
                        i3 = 10;
                    case 1:
                        i2 = i6;
                        list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, i2, (DeserializationStrategy) lazyArr[i6].getValue(), list3);
                        i5 |= 2;
                        i4 = i2;
                        i3 = 10;
                    case 2:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i5 |= 4;
                        i4 = i6;
                    case 3:
                        d9 = beginStructure.decodeDoubleElement(serialDescriptor, 3);
                        i5 |= 8;
                        i4 = i6;
                    case 4:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i5 |= 16;
                        i4 = i6;
                    case 5:
                        j2 = beginStructure.decodeLongElement(serialDescriptor, 5);
                        i5 |= 32;
                        i4 = i6;
                    case 6:
                        d12 = beginStructure.decodeDoubleElement(serialDescriptor, 6);
                        i5 |= 64;
                        i4 = i6;
                    case 7:
                        d10 = beginStructure.decodeDoubleElement(serialDescriptor, 7);
                        i5 |= 128;
                        i4 = i6;
                    case 8:
                        d8 = beginStructure.decodeDoubleElement(serialDescriptor, 8);
                        i5 |= 256;
                        i4 = i6;
                    case 9:
                        d7 = beginStructure.decodeDoubleElement(serialDescriptor, 9);
                        i5 |= 512;
                        i4 = i6;
                    case 10:
                        d11 = beginStructure.decodeDoubleElement(serialDescriptor, i3);
                        i5 |= 1024;
                        i4 = i6;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            d = d11;
            d2 = d7;
            list = list3;
            str = str4;
            i = i5;
            double d13 = d12;
            str2 = str5;
            str3 = str6;
            d3 = d13;
            d4 = d9;
            j = j2;
            d5 = d10;
            d6 = d8;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SaleBody(i, str, list, str2, d4, str3, j, d3, d5, d6, d2, d, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SaleBody value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SaleBody.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
