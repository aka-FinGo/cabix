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
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/DebtSale.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/DebtSale;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class DebtSale$$serializer implements GeneratedSerializer<DebtSale> {
    public static final int $stable = 0;
    public static final DebtSale$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DebtSale$$serializer debtSale$$serializer = new DebtSale$$serializer();
        INSTANCE = debtSale$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.DebtSale", debtSale$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.TRANSACTION_ID, true);
        pluginGeneratedSerialDescriptor.addElement("customer_id", true);
        pluginGeneratedSerialDescriptor.addElement("customer_name", true);
        pluginGeneratedSerialDescriptor.addElement("cashier_name", true);
        pluginGeneratedSerialDescriptor.addElement("sold_at", true);
        pluginGeneratedSerialDescriptor.addElement("total_amount", true);
        pluginGeneratedSerialDescriptor.addElement("paid_amount", true);
        pluginGeneratedSerialDescriptor.addElement("debt_amount", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.PAYMENT_TYPE, true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.ITEMS, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DebtSale$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = DebtSale.$childSerializers;
        return new KSerializer[]{LenientLong.INSTANCE, LenientString.INSTANCE, LenientLong.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, LenientDouble.INSTANCE, LenientDouble.INSTANCE, LenientDouble.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), lazyArr[10].getValue()};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00e9. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final DebtSale deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        String str;
        String str2;
        long j;
        String str3;
        List list;
        String str4;
        long j2;
        double d;
        double d2;
        double d3;
        String str5;
        char c;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = DebtSale.$childSerializers;
        boolean decodeSequentially = beginStructure.decodeSequentially();
        int i2 = 7;
        int i3 = 6;
        int i4 = 5;
        String str6 = null;
        Double valueOf = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (decodeSequentially) {
            long longValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, 0L)).longValue();
            String str7 = (String) beginStructure.decodeSerializableElement(serialDescriptor, 1, LenientString.INSTANCE, null);
            long longValue2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientLong.INSTANCE, 0L)).longValue();
            String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 5);
            double doubleValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 6, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 7, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 8, LenientDouble.INSTANCE, valueOf)).doubleValue();
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, null);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 10, (DeserializationStrategy) lazyArr[10].getValue(), null);
            str5 = str10;
            str3 = str8;
            j = longValue2;
            j2 = longValue;
            d = doubleValue;
            d3 = doubleValue3;
            str4 = str7;
            d2 = doubleValue2;
            str2 = decodeStringElement;
            str = str9;
            i = 2047;
        } else {
            int i5 = 10;
            long j3 = 0;
            long j4 = 0;
            String str11 = null;
            List list2 = null;
            String str12 = null;
            int i6 = 0;
            double d4 = 0.0d;
            double d5 = 0.0d;
            double d6 = 0.0d;
            String str13 = null;
            boolean z = true;
            String str14 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i4 = 5;
                        i5 = 10;
                    case 0:
                        j3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, Long.valueOf(j3))).longValue();
                        i6 |= 1;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        i5 = 10;
                    case 1:
                        c = 3;
                        str6 = (String) beginStructure.decodeSerializableElement(serialDescriptor, 1, LenientString.INSTANCE, str6);
                        i6 |= 2;
                        i2 = 7;
                        i3 = 6;
                        i5 = 10;
                    case 2:
                        c = 3;
                        j4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientLong.INSTANCE, Long.valueOf(j4))).longValue();
                        i6 |= 4;
                        i2 = 7;
                        i3 = 6;
                        i5 = 10;
                    case 3:
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str11);
                        i6 |= 8;
                        i5 = 10;
                    case 4:
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str13);
                        i6 |= 16;
                        i5 = 10;
                    case 5:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, i4);
                        i6 |= 32;
                        i5 = 10;
                    case 6:
                        d4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, i3, LenientDouble.INSTANCE, Double.valueOf(d4))).doubleValue();
                        i6 |= 64;
                        i5 = 10;
                    case 7:
                        d5 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, i2, LenientDouble.INSTANCE, Double.valueOf(d5))).doubleValue();
                        i6 |= 128;
                        i5 = 10;
                    case 8:
                        d6 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 8, LenientDouble.INSTANCE, Double.valueOf(d6))).doubleValue();
                        i6 |= 256;
                        i5 = 10;
                    case 9:
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str14);
                        i6 |= 512;
                        i5 = 10;
                    case 10:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, i5, (DeserializationStrategy) lazyArr[i5].getValue(), list2);
                        i6 |= 1024;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i6;
            str = str13;
            str2 = str12;
            j = j4;
            str3 = str11;
            double d7 = d5;
            list = list2;
            String str15 = str14;
            str4 = str6;
            j2 = j3;
            d = d4;
            d2 = d7;
            d3 = d6;
            str5 = str15;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DebtSale(i, j2, str4, j, str3, str, str2, d, d2, d3, str5, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, DebtSale value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DebtSale.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
