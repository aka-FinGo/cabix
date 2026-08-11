package uz.FonRo.pos.data.local;

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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.local.SaleOutbox;
import uz.FonRo.pos.data.model.SaleBody;
import uz.FonRo.pos.data.model.SaleBody$$serializer;

/* compiled from: SaleOutbox.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/local/SaleOutbox.Pending.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/local/SaleOutbox$Pending;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class SaleOutbox$Pending$$serializer implements GeneratedSerializer<SaleOutbox.Pending> {
    public static final int $stable = 0;
    public static final SaleOutbox$Pending$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SaleOutbox$Pending$$serializer saleOutbox$Pending$$serializer = new SaleOutbox$Pending$$serializer();
        INSTANCE = saleOutbox$Pending$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.local.SaleOutbox.Pending", saleOutbox$Pending$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("body", false);
        pluginGeneratedSerialDescriptor.addElement("createdAt", false);
        pluginGeneratedSerialDescriptor.addElement("attempts", true);
        pluginGeneratedSerialDescriptor.addElement("lastError", true);
        pluginGeneratedSerialDescriptor.addElement("total", true);
        pluginGeneratedSerialDescriptor.addElement("itemsCount", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SaleOutbox$Pending$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{SaleBody$$serializer.INSTANCE, LongSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), DoubleSerializer.INSTANCE, IntSerializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x005e. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final SaleOutbox.Pending deserialize(Decoder decoder) {
        SaleBody saleBody;
        long j;
        int i;
        double d;
        String str;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i4 = 5;
        if (beginStructure.decodeSequentially()) {
            SaleBody saleBody2 = (SaleBody) beginStructure.decodeSerializableElement(serialDescriptor, 0, SaleBody$$serializer.INSTANCE, null);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 1);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 2);
            String str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 4);
            saleBody = saleBody2;
            i = beginStructure.decodeIntElement(serialDescriptor, 5);
            str = str2;
            i2 = decodeIntElement;
            j = decodeLongElement;
            d = decodeDoubleElement;
            i3 = 63;
        } else {
            boolean z = true;
            int i5 = 0;
            String str3 = null;
            double d2 = 0.0d;
            int i6 = 0;
            SaleBody saleBody3 = null;
            long j2 = 0;
            int i7 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i4 = 5;
                    case 0:
                        saleBody3 = (SaleBody) beginStructure.decodeSerializableElement(serialDescriptor, 0, SaleBody$$serializer.INSTANCE, saleBody3);
                        i6 |= 1;
                        i4 = 5;
                    case 1:
                        j2 = beginStructure.decodeLongElement(serialDescriptor, 1);
                        i6 |= 2;
                    case 2:
                        i7 = beginStructure.decodeIntElement(serialDescriptor, 2);
                        i6 |= 4;
                    case 3:
                        str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str3);
                        i6 |= 8;
                    case 4:
                        d2 = beginStructure.decodeDoubleElement(serialDescriptor, 4);
                        i6 |= 16;
                    case 5:
                        i5 = beginStructure.decodeIntElement(serialDescriptor, i4);
                        i6 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            long j3 = j2;
            saleBody = saleBody3;
            j = j3;
            i = i5;
            d = d2;
            str = str3;
            i2 = i7;
            i3 = i6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SaleOutbox.Pending(i3, saleBody, j, i2, str, d, i, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SaleOutbox.Pending value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SaleOutbox.Pending.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
