package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
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

/* compiled from: Sales.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/ReturnDoc.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/ReturnDoc;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class ReturnDoc$$serializer implements GeneratedSerializer<ReturnDoc> {
    public static final int $stable = 0;
    public static final ReturnDoc$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ReturnDoc$$serializer returnDoc$$serializer = new ReturnDoc$$serializer();
        INSTANCE = returnDoc$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.ReturnDoc", returnDoc$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.TRANSACTION_ID, true);
        pluginGeneratedSerialDescriptor.addElement("amount", true);
        pluginGeneratedSerialDescriptor.addElement("profit", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.QUANTITY, true);
        pluginGeneratedSerialDescriptor.addElement("created_at", true);
        pluginGeneratedSerialDescriptor.addElement(NotificationCompat.CATEGORY_STATUS, true);
        pluginGeneratedSerialDescriptor.addElement("reason", true);
        pluginGeneratedSerialDescriptor.addElement("lines", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ReturnDoc$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = ReturnDoc.$childSerializers;
        return new KSerializer[]{LenientLong.INSTANCE, LenientString.INSTANCE, LenientDouble.INSTANCE, LenientDouble.INSTANCE, LenientDouble.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), lazyArr[8].getValue()};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00c4. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final ReturnDoc deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        double d;
        List list;
        String str;
        long j;
        int i;
        String str2;
        String str3;
        String str4;
        double d2;
        double d3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = ReturnDoc.$childSerializers;
        boolean decodeSequentially = beginStructure.decodeSequentially();
        int i2 = 7;
        int i3 = 6;
        String str5 = null;
        Double valueOf = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (decodeSequentially) {
            long longValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, 0L)).longValue();
            String str6 = (String) beginStructure.decodeSerializableElement(serialDescriptor, 1, LenientString.INSTANCE, null);
            double doubleValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 3, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 4, LenientDouble.INSTANCE, valueOf)).doubleValue();
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 5);
            String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, null);
            String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, null);
            d2 = doubleValue;
            j = longValue;
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr[8].getValue(), null);
            str2 = str6;
            str = str8;
            str3 = str7;
            str4 = decodeStringElement;
            i = 511;
            d3 = doubleValue2;
            d = doubleValue3;
        } else {
            long j2 = 0;
            boolean z = true;
            int i4 = 0;
            List list2 = null;
            String str9 = null;
            String str10 = null;
            double d4 = 0.0d;
            double d5 = 0.0d;
            String str11 = null;
            double d6 = 0.0d;
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
                        str10 = (String) beginStructure.decodeSerializableElement(serialDescriptor, 1, LenientString.INSTANCE, str10);
                        i4 |= 2;
                        i2 = 7;
                        i3 = 6;
                    case 2:
                        d6 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientDouble.INSTANCE, Double.valueOf(d6))).doubleValue();
                        i4 |= 4;
                        i2 = 7;
                        i3 = 6;
                    case 3:
                        d4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 3, LenientDouble.INSTANCE, Double.valueOf(d4))).doubleValue();
                        i4 |= 8;
                        i2 = 7;
                    case 4:
                        d5 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 4, LenientDouble.INSTANCE, Double.valueOf(d5))).doubleValue();
                        i4 |= 16;
                        i2 = 7;
                    case 5:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i4 |= 32;
                    case 6:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i3, StringSerializer.INSTANCE, str5);
                        i4 |= 64;
                    case 7:
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str9);
                        i4 |= 128;
                    case 8:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr[8].getValue(), list2);
                        i4 |= 256;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            d = d5;
            list = list2;
            str = str9;
            j = j2;
            i = i4;
            str2 = str10;
            double d7 = d4;
            str3 = str5;
            str4 = str11;
            d2 = d6;
            d3 = d7;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ReturnDoc(i, j, str2, d2, d3, d, str4, str3, str, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ReturnDoc value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ReturnDoc.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
