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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Money.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/DebtPayBody.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/DebtPayBody;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class DebtPayBody$$serializer implements GeneratedSerializer<DebtPayBody> {
    public static final int $stable = 0;
    public static final DebtPayBody$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DebtPayBody$$serializer debtPayBody$$serializer = new DebtPayBody$$serializer();
        INSTANCE = debtPayBody$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.DebtPayBody", debtPayBody$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("sale_id", false);
        pluginGeneratedSerialDescriptor.addElement("amount", false);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.PAYMENT_TYPE, false);
        pluginGeneratedSerialDescriptor.addElement("cash_amount", false);
        pluginGeneratedSerialDescriptor.addElement("card_amount", false);
        pluginGeneratedSerialDescriptor.addElement("note", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DebtPayBody$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LongSerializer.INSTANCE, DoubleSerializer.INSTANCE, StringSerializer.INSTANCE, DoubleSerializer.INSTANCE, DoubleSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0050. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final DebtPayBody deserialize(Decoder decoder) {
        String str;
        int i;
        double d;
        long j;
        double d2;
        double d3;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 0);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 1);
            str = beginStructure.decodeStringElement(serialDescriptor, 2);
            double decodeDoubleElement2 = beginStructure.decodeDoubleElement(serialDescriptor, 3);
            double decodeDoubleElement3 = beginStructure.decodeDoubleElement(serialDescriptor, 4);
            str2 = beginStructure.decodeStringElement(serialDescriptor, 5);
            d = decodeDoubleElement3;
            d2 = decodeDoubleElement2;
            d3 = decodeDoubleElement;
            i = 63;
            j = decodeLongElement;
        } else {
            double d4 = AudioStats.AUDIO_AMPLITUDE_NONE;
            str = null;
            boolean z = true;
            long j2 = 0;
            double d5 = 0.0d;
            double d6 = 0.0d;
            String str3 = null;
            i = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                    case 0:
                        j2 = beginStructure.decodeLongElement(serialDescriptor, 0);
                        i |= 1;
                    case 1:
                        d6 = beginStructure.decodeDoubleElement(serialDescriptor, 1);
                        i |= 2;
                    case 2:
                        str = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i |= 4;
                    case 3:
                        d5 = beginStructure.decodeDoubleElement(serialDescriptor, 3);
                        i |= 8;
                    case 4:
                        d4 = beginStructure.decodeDoubleElement(serialDescriptor, 4);
                        i |= 16;
                    case 5:
                        str3 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            d = d4;
            j = j2;
            d2 = d5;
            d3 = d6;
            str2 = str3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DebtPayBody(i, j, d3, str, d2, d, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, DebtPayBody value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DebtPayBody.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
