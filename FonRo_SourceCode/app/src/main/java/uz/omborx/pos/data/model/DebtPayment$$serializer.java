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
import uz.FonRo.pos.data.net.LenientString;

/* compiled from: Money.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/DebtPayment.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/DebtPayment;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class DebtPayment$$serializer implements GeneratedSerializer<DebtPayment> {
    public static final int $stable = 0;
    public static final DebtPayment$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DebtPayment$$serializer debtPayment$$serializer = new DebtPayment$$serializer();
        INSTANCE = debtPayment$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.DebtPayment", debtPayment$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("sale_id", true);
        pluginGeneratedSerialDescriptor.addElement("amount", true);
        pluginGeneratedSerialDescriptor.addElement("cash_amount", true);
        pluginGeneratedSerialDescriptor.addElement("card_amount", true);
        pluginGeneratedSerialDescriptor.addElement("created_at", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.TRANSACTION_ID, true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.PAYMENT_TYPE, true);
        pluginGeneratedSerialDescriptor.addElement("paid_by_name", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DebtPayment$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LenientLong.INSTANCE, LenientDouble.INSTANCE, LenientDouble.INSTANCE, LenientDouble.INSTANCE, StringSerializer.INSTANCE, LenientString.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00a6. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final DebtPayment deserialize(Decoder decoder) {
        String str;
        String str2;
        long j;
        int i;
        String str3;
        String str4;
        double d;
        double d2;
        double d3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        boolean decodeSequentially = beginStructure.decodeSequentially();
        int i2 = 7;
        int i3 = 6;
        Double valueOf = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        String str5 = null;
        if (decodeSequentially) {
            j = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, 0L)).longValue();
            double doubleValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 1, LenientDouble.INSTANCE, valueOf)).doubleValue();
            d2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 3, LenientDouble.INSTANCE, valueOf)).doubleValue();
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 4);
            String str6 = (String) beginStructure.decodeSerializableElement(serialDescriptor, 5, LenientString.INSTANCE, null);
            String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, null);
            str4 = decodeStringElement;
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, null);
            str = str7;
            str3 = str6;
            i = 255;
            d3 = doubleValue2;
            d = doubleValue;
        } else {
            boolean z = true;
            int i4 = 0;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            double d4 = 0.0d;
            double d5 = 0.0d;
            double d6 = 0.0d;
            long j2 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 7;
                    case 0:
                        i4 |= 1;
                        j2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, Long.valueOf(j2))).longValue();
                        i2 = 7;
                        i3 = 6;
                    case 1:
                        d4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 1, LenientDouble.INSTANCE, Double.valueOf(d4))).doubleValue();
                        i4 |= 2;
                        i2 = 7;
                        i3 = 6;
                    case 2:
                        d5 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientDouble.INSTANCE, Double.valueOf(d5))).doubleValue();
                        i4 |= 4;
                        i2 = 7;
                    case 3:
                        d6 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 3, LenientDouble.INSTANCE, Double.valueOf(d6))).doubleValue();
                        i4 |= 8;
                        i2 = 7;
                    case 4:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i4 |= 16;
                    case 5:
                        str8 = (String) beginStructure.decodeSerializableElement(serialDescriptor, 5, LenientString.INSTANCE, str8);
                        i4 |= 32;
                    case 6:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i3, StringSerializer.INSTANCE, str5);
                        i4 |= 64;
                    case 7:
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str9);
                        i4 |= 128;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str5;
            str2 = str9;
            j = j2;
            i = i4;
            double d7 = d6;
            str3 = str8;
            str4 = str10;
            d = d4;
            d2 = d5;
            d3 = d7;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DebtPayment(i, j, d, d2, d3, str4, str3, str, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, DebtPayment value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DebtPayment.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
