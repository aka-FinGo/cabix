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
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/SupplierReturnDoc.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/SupplierReturnDoc;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class SupplierReturnDoc$$serializer implements GeneratedSerializer<SupplierReturnDoc> {
    public static final int $stable = 0;
    public static final SupplierReturnDoc$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SupplierReturnDoc$$serializer supplierReturnDoc$$serializer = new SupplierReturnDoc$$serializer();
        INSTANCE = supplierReturnDoc$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.SupplierReturnDoc", supplierReturnDoc$$serializer, 14);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("client_id", true);
        pluginGeneratedSerialDescriptor.addElement("doc_number", true);
        pluginGeneratedSerialDescriptor.addElement("supplier_id", true);
        pluginGeneratedSerialDescriptor.addElement("supplier_name", true);
        pluginGeneratedSerialDescriptor.addElement("reason", true);
        pluginGeneratedSerialDescriptor.addElement("compensation_type", true);
        pluginGeneratedSerialDescriptor.addElement("amount", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.QUANTITY, true);
        pluginGeneratedSerialDescriptor.addElement("is_canceled", true);
        pluginGeneratedSerialDescriptor.addElement("can_cancel", true);
        pluginGeneratedSerialDescriptor.addElement("created_at", true);
        pluginGeneratedSerialDescriptor.addElement("created_by_name", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.ITEMS, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SupplierReturnDoc$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = SupplierReturnDoc.$childSerializers;
        return new KSerializer[]{LenientLong.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LenientInt.INSTANCE, LenientLong.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, LenientDouble.INSTANCE, LenientDouble.INSTANCE, LenientBool.INSTANCE, LenientBool.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), lazyArr[13].getValue()};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x012b. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final SupplierReturnDoc deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        boolean z;
        String str;
        String str2;
        long j;
        String str3;
        String str4;
        int i;
        String str5;
        long j2;
        double d;
        int i2;
        boolean z2;
        double d2;
        List list;
        String str6;
        char c;
        char c2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = SupplierReturnDoc.$childSerializers;
        boolean decodeSequentially = beginStructure.decodeSequentially();
        int i3 = 7;
        int i4 = 6;
        int i5 = 5;
        char c3 = 4;
        Double valueOf = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (decodeSequentially) {
            long longValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, 0L)).longValue();
            String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            int intValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientInt.INSTANCE, 0)).intValue();
            long longValue2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 3, LenientLong.INSTANCE, 0L)).longValue();
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 6);
            double doubleValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 7, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 8, LenientDouble.INSTANCE, valueOf)).doubleValue();
            boolean booleanValue = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 9, LenientBool.INSTANCE, false)).booleanValue();
            z = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 10, LenientBool.INSTANCE, false)).booleanValue();
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 11);
            i = 16383;
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, null);
            str3 = str7;
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 13, (DeserializationStrategy) lazyArr[13].getValue(), null);
            str2 = decodeStringElement2;
            z2 = booleanValue;
            d = doubleValue2;
            j2 = longValue;
            j = longValue2;
            d2 = doubleValue;
            i2 = intValue;
            str5 = decodeStringElement;
            str4 = str8;
        } else {
            int i6 = 13;
            boolean z3 = true;
            z = false;
            int i7 = 0;
            boolean z4 = false;
            List list2 = null;
            str = null;
            String str9 = null;
            String str10 = null;
            long j3 = 0;
            long j4 = 0;
            double d3 = 0.0d;
            double d4 = 0.0d;
            int i8 = 0;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            while (z3) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z3 = false;
                        i5 = 5;
                        i6 = 13;
                    case 0:
                        j3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, Long.valueOf(j3))).longValue();
                        i7 |= 1;
                        c3 = c3;
                        i3 = 7;
                        i4 = 6;
                        i5 = 5;
                        i6 = 13;
                    case 1:
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str9);
                        i7 |= 2;
                        c3 = c3;
                        i3 = 7;
                        i4 = 6;
                        i6 = 13;
                    case 2:
                        c = c3;
                        c2 = 3;
                        i8 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientInt.INSTANCE, Integer.valueOf(i8))).intValue();
                        i7 |= 4;
                        c3 = c;
                        i3 = 7;
                        i4 = 6;
                        i6 = 13;
                    case 3:
                        c = c3;
                        c2 = 3;
                        j4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 3, LenientLong.INSTANCE, Long.valueOf(j4))).longValue();
                        i7 |= 8;
                        c3 = c;
                        i3 = 7;
                        i4 = 6;
                        i6 = 13;
                    case 4:
                        str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str);
                        i7 |= 16;
                        c3 = 4;
                        i6 = 13;
                    case 5:
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i5, StringSerializer.INSTANCE, str10);
                        i7 |= 32;
                        c3 = 4;
                        i6 = 13;
                    case 6:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, i4);
                        i7 |= 64;
                        c3 = 4;
                        i6 = 13;
                    case 7:
                        d3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, i3, LenientDouble.INSTANCE, Double.valueOf(d3))).doubleValue();
                        i7 |= 128;
                        c3 = 4;
                        i6 = 13;
                    case 8:
                        d4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 8, LenientDouble.INSTANCE, Double.valueOf(d4))).doubleValue();
                        i7 |= 256;
                        c3 = 4;
                        i6 = 13;
                    case 9:
                        z4 = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 9, LenientBool.INSTANCE, Boolean.valueOf(z4))).booleanValue();
                        i7 |= 512;
                        c3 = 4;
                        i6 = 13;
                    case 10:
                        z = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 10, LenientBool.INSTANCE, Boolean.valueOf(z))).booleanValue();
                        i7 |= 1024;
                        i6 = 13;
                    case 11:
                        str13 = beginStructure.decodeStringElement(serialDescriptor, 11);
                        i7 |= 2048;
                        i6 = 13;
                    case 12:
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str11);
                        i7 |= 4096;
                        i6 = 13;
                    case 13:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, i6, (DeserializationStrategy) lazyArr[i6].getValue(), list2);
                        i7 |= 8192;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str2 = str13;
            j = j4;
            str3 = str9;
            str4 = str10;
            i = i7;
            str5 = str12;
            j2 = j3;
            d = d4;
            i2 = i8;
            z2 = z4;
            d2 = d3;
            list = list2;
            str6 = str11;
        }
        String str14 = str;
        beginStructure.endStructure(serialDescriptor);
        return new SupplierReturnDoc(i, j2, str3, i2, j, str14, str4, str5, d2, d, z2, z, str2, str6, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SupplierReturnDoc value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SupplierReturnDoc.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
