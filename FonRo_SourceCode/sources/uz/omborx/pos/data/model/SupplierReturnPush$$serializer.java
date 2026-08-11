package uz.FonRo.pos.data.model;

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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/SupplierReturnPush.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/SupplierReturnPush;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class SupplierReturnPush$$serializer implements GeneratedSerializer<SupplierReturnPush> {
    public static final int $stable = 0;
    public static final SupplierReturnPush$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SupplierReturnPush$$serializer supplierReturnPush$$serializer = new SupplierReturnPush$$serializer();
        INSTANCE = supplierReturnPush$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.SupplierReturnPush", supplierReturnPush$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("client_id", false);
        pluginGeneratedSerialDescriptor.addElement("server_id", true);
        pluginGeneratedSerialDescriptor.addElement("document_cancel", true);
        pluginGeneratedSerialDescriptor.addElement("supplier_id", true);
        pluginGeneratedSerialDescriptor.addElement("supplier_name", true);
        pluginGeneratedSerialDescriptor.addElement("reason", true);
        pluginGeneratedSerialDescriptor.addElement("compensation_type", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.ITEMS, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SupplierReturnPush$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = SupplierReturnPush.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), LongSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, lazyArr[7].getValue()};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x007e. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final SupplierReturnPush deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        List list;
        String str;
        int i;
        String str2;
        Long l;
        Integer num;
        String str3;
        String str4;
        long j;
        boolean z;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = SupplierReturnPush.$childSerializers;
        int i2 = 6;
        String str5 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            Long l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, null);
            Integer num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, null);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 3);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 4);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 5);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 6);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), null);
            str = decodeStringElement4;
            str4 = decodeStringElement3;
            str3 = decodeStringElement2;
            i = 255;
            num = num2;
            j = decodeLongElement;
            str2 = decodeStringElement;
            l = l2;
        } else {
            boolean z2 = true;
            int i3 = 0;
            List list2 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            long j2 = 0;
            Long l3 = null;
            Integer num3 = null;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z2 = false;
                    case 0:
                        z = true;
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i3 |= 1;
                        i2 = 6;
                    case 1:
                        z = true;
                        l3 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, l3);
                        i3 |= 2;
                        i2 = 6;
                    case 2:
                        num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num3);
                        i3 |= 4;
                    case 3:
                        j2 = beginStructure.decodeLongElement(serialDescriptor, 3);
                        i3 |= 8;
                    case 4:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i3 |= 16;
                    case 5:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i3 |= 32;
                    case 6:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, i2);
                        i3 |= 64;
                    case 7:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), list2);
                        i3 |= 128;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            list = list2;
            str = str8;
            String str9 = str5;
            i = i3;
            Long l4 = l3;
            str2 = str9;
            Integer num4 = num3;
            l = l4;
            String str10 = str6;
            num = num4;
            long j3 = j2;
            str3 = str10;
            str4 = str7;
            j = j3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SupplierReturnPush(i, str2, l, num, j, str3, str4, str, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SupplierReturnPush value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SupplierReturnPush.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
