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
import uz.FonRo.pos.data.net.LenientBool;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientInt;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/WriteOffDoc.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/WriteOffDoc;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class WriteOffDoc$$serializer implements GeneratedSerializer<WriteOffDoc> {
    public static final int $stable = 0;
    public static final WriteOffDoc$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        WriteOffDoc$$serializer writeOffDoc$$serializer = new WriteOffDoc$$serializer();
        INSTANCE = writeOffDoc$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.WriteOffDoc", writeOffDoc$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("client_id", true);
        pluginGeneratedSerialDescriptor.addElement("doc_number", true);
        pluginGeneratedSerialDescriptor.addElement("reason", true);
        pluginGeneratedSerialDescriptor.addElement("note", true);
        pluginGeneratedSerialDescriptor.addElement("amount", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.QUANTITY, true);
        pluginGeneratedSerialDescriptor.addElement("is_canceled", true);
        pluginGeneratedSerialDescriptor.addElement("can_cancel", true);
        pluginGeneratedSerialDescriptor.addElement("created_at", true);
        pluginGeneratedSerialDescriptor.addElement("created_by_name", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.ITEMS, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private WriteOffDoc$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = WriteOffDoc.$childSerializers;
        return new KSerializer[]{LenientLong.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LenientInt.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LenientDouble.INSTANCE, LenientDouble.INSTANCE, LenientBool.INSTANCE, LenientBool.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), lazyArr[11].getValue()};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0106. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final WriteOffDoc deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        List list;
        String str;
        long j;
        double d;
        double d2;
        String str2;
        String str3;
        boolean z;
        boolean z2;
        int i2;
        String str4;
        String str5;
        int i3;
        char c;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = WriteOffDoc.$childSerializers;
        boolean decodeSequentially = beginStructure.decodeSequentially();
        int i4 = 7;
        int i5 = 6;
        int i6 = 5;
        int i7 = 3;
        String str6 = null;
        Double valueOf = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (decodeSequentially) {
            long longValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, 0L)).longValue();
            String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            int intValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientInt.INSTANCE, 0)).intValue();
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 3);
            String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            double doubleValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 5, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 6, LenientDouble.INSTANCE, valueOf)).doubleValue();
            boolean booleanValue = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 7, LenientBool.INSTANCE, false)).booleanValue();
            boolean booleanValue2 = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 8, LenientBool.INSTANCE, false)).booleanValue();
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 9);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, null);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 11, (DeserializationStrategy) lazyArr[11].getValue(), null);
            z = booleanValue;
            z2 = booleanValue2;
            d2 = doubleValue2;
            str = str8;
            str2 = decodeStringElement2;
            i = 4095;
            j = longValue;
            d = doubleValue;
            str5 = str7;
            str4 = decodeStringElement;
            i2 = intValue;
        } else {
            int i8 = 11;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            boolean z3 = true;
            long j2 = 0;
            double d3 = 0.0d;
            double d4 = 0.0d;
            i = 0;
            boolean z4 = false;
            boolean z5 = false;
            int i9 = 0;
            List list2 = null;
            while (z3) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z3 = false;
                        i6 = 5;
                        i8 = 11;
                    case 0:
                        j2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, Long.valueOf(j2))).longValue();
                        i |= 1;
                        i7 = i7;
                        i4 = 7;
                        i5 = 6;
                        i6 = 5;
                        i8 = 11;
                    case 1:
                        i3 = i7;
                        c = 2;
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str6);
                        i |= 2;
                        i7 = i3;
                        i4 = 7;
                        i5 = 6;
                        i8 = 11;
                    case 2:
                        i3 = i7;
                        c = 2;
                        i9 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientInt.INSTANCE, Integer.valueOf(i9))).intValue();
                        i |= 4;
                        i7 = i3;
                        i4 = 7;
                        i5 = 6;
                        i8 = 11;
                    case 3:
                        int i10 = i7;
                        str9 = beginStructure.decodeStringElement(serialDescriptor, i10);
                        i |= 8;
                        i7 = i10;
                        i8 = 11;
                    case 4:
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str10);
                        i |= 16;
                        i7 = 3;
                        i8 = 11;
                    case 5:
                        d3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, i6, LenientDouble.INSTANCE, Double.valueOf(d3))).doubleValue();
                        i |= 32;
                        i7 = 3;
                        i8 = 11;
                    case 6:
                        d4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, i5, LenientDouble.INSTANCE, Double.valueOf(d4))).doubleValue();
                        i |= 64;
                        i7 = 3;
                        i8 = 11;
                    case 7:
                        z4 = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, i4, LenientBool.INSTANCE, Boolean.valueOf(z4))).booleanValue();
                        i |= 128;
                        i7 = 3;
                        i8 = 11;
                    case 8:
                        z5 = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 8, LenientBool.INSTANCE, Boolean.valueOf(z5))).booleanValue();
                        i |= 256;
                        i7 = 3;
                        i8 = 11;
                    case 9:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 9);
                        i |= 512;
                        i8 = 11;
                    case 10:
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str12);
                        i |= 1024;
                        i8 = 11;
                    case 11:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, i8, (DeserializationStrategy) lazyArr[i8].getValue(), list2);
                        i |= 2048;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            list = list2;
            str = str10;
            j = j2;
            d = d3;
            d2 = d4;
            str2 = str11;
            str3 = str12;
            z = z4;
            z2 = z5;
            i2 = i9;
            str4 = str9;
            str5 = str6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new WriteOffDoc(i, j, str5, i2, str4, str, d, d2, z, z2, str2, str3, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, WriteOffDoc value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        WriteOffDoc.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
