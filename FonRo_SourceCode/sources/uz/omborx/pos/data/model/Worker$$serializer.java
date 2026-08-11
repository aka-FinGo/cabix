package uz.FonRo.pos.data.model;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
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
import uz.FonRo.pos.data.net.LenientBool;
import uz.FonRo.pos.data.net.LenientLong;
import uz.FonRo.pos.data.net.LenientString;
import uz.FonRo.pos.data.net.PermissionMapSerializer;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/Worker.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/Worker;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class Worker$$serializer implements GeneratedSerializer<Worker> {
    public static final int $stable = 0;
    public static final Worker$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Worker$$serializer worker$$serializer = new Worker$$serializer();
        INSTANCE = worker$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.Worker", worker$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("full_name", true);
        pluginGeneratedSerialDescriptor.addElement(HintConstants.AUTOFILL_HINT_PHONE, true);
        pluginGeneratedSerialDescriptor.addElement("role", true);
        pluginGeneratedSerialDescriptor.addElement("access_key", true);
        pluginGeneratedSerialDescriptor.addElement("is_active", true);
        pluginGeneratedSerialDescriptor.addElement("permissions", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Worker$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LenientLong.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, LenientString.INSTANCE, LenientBool.INSTANCE, PermissionMapSerializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0084. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final Worker deserialize(Decoder decoder) {
        String str;
        int i;
        long j;
        String str2;
        String str3;
        String str4;
        boolean z;
        Map map;
        char c;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 6;
        if (beginStructure.decodeSequentially()) {
            j = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, 0L)).longValue();
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
            String str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 3);
            String str6 = (String) beginStructure.decodeSerializableElement(serialDescriptor, 4, LenientString.INSTANCE, null);
            boolean booleanValue = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 5, LenientBool.INSTANCE, false)).booleanValue();
            str2 = decodeStringElement;
            map = (Map) beginStructure.decodeSerializableElement(serialDescriptor, 6, PermissionMapSerializer.INSTANCE, null);
            z = booleanValue;
            str4 = decodeStringElement2;
            str = str6;
            str3 = str5;
            i = 127;
        } else {
            boolean z2 = true;
            boolean z3 = false;
            Map map2 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            long j2 = 0;
            String str10 = null;
            int i3 = 0;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z2 = false;
                        i2 = 6;
                    case 0:
                        i3 |= 1;
                        j2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, Long.valueOf(j2))).longValue();
                        i2 = 6;
                    case 1:
                        c = 2;
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i3 |= 2;
                        i2 = 6;
                    case 2:
                        c = 2;
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str8);
                        i3 |= 4;
                        i2 = 6;
                    case 3:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i3 |= 8;
                    case 4:
                        str10 = (String) beginStructure.decodeSerializableElement(serialDescriptor, 4, LenientString.INSTANCE, str10);
                        i3 |= 16;
                    case 5:
                        z3 = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 5, LenientBool.INSTANCE, Boolean.valueOf(z3))).booleanValue();
                        i3 |= 32;
                    case 6:
                        map2 = (Map) beginStructure.decodeSerializableElement(serialDescriptor, i2, PermissionMapSerializer.INSTANCE, map2);
                        i3 |= 64;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str11 = str9;
            str = str10;
            i = i3;
            j = j2;
            str2 = str7;
            str3 = str8;
            str4 = str11;
            z = z3;
            map = map2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new Worker(i, j, str2, str3, str4, str, z, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Worker value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        Worker.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
