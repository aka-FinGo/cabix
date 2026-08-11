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
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.data.net.LenientBool;
import uz.FonRo.pos.data.net.LenientInt;
import uz.FonRo.pos.data.net.LenientLong;
import uz.FonRo.pos.data.net.PermissionMapSerializer;

/* compiled from: Auth.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/User.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/User;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class User$$serializer implements GeneratedSerializer<User> {
    public static final int $stable = 0;
    public static final User$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        User$$serializer user$$serializer = new User$$serializer();
        INSTANCE = user$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.User", user$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("role", true);
        pluginGeneratedSerialDescriptor.addElement("full_name", true);
        pluginGeneratedSerialDescriptor.addElement("email", true);
        pluginGeneratedSerialDescriptor.addElement(HintConstants.AUTOFILL_HINT_PHONE, true);
        pluginGeneratedSerialDescriptor.addElement("is_super_admin", true);
        pluginGeneratedSerialDescriptor.addElement("permissions", true);
        pluginGeneratedSerialDescriptor.addElement(Perm.SELL, true);
        pluginGeneratedSerialDescriptor.addElement("self_limits", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private User$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LenientLong.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LenientBool.INSTANCE, PermissionMapSerializer.INSTANCE, LenientInt.INSTANCE, PermissionMapSerializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00b3. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final User deserialize(Decoder decoder) {
        String str;
        Map map;
        int i;
        String str2;
        long j;
        Map map2;
        boolean z;
        String str3;
        String str4;
        int i2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i3 = 7;
        if (beginStructure.decodeSequentially()) {
            long longValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, 0L)).longValue();
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
            String str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            String str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            boolean booleanValue = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 5, LenientBool.INSTANCE, false)).booleanValue();
            Map map3 = (Map) beginStructure.decodeSerializableElement(serialDescriptor, 6, PermissionMapSerializer.INSTANCE, null);
            i2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 7, LenientInt.INSTANCE, 0)).intValue();
            map2 = map3;
            z = booleanValue;
            map = (Map) beginStructure.decodeSerializableElement(serialDescriptor, 8, PermissionMapSerializer.INSTANCE, null);
            str = str5;
            i = 511;
            str4 = decodeStringElement;
            str3 = str6;
            str2 = str7;
            j = longValue;
        } else {
            boolean z2 = true;
            int i4 = 0;
            Map map4 = null;
            Map map5 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            long j2 = 0;
            str = null;
            boolean z3 = false;
            int i5 = 0;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z2 = false;
                        i3 = 7;
                    case 0:
                        i5 |= 1;
                        j2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, Long.valueOf(j2))).longValue();
                        i3 = 7;
                    case 1:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i5 |= 2;
                        i3 = 7;
                    case 2:
                        str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str);
                        i5 |= 4;
                        i3 = 7;
                    case 3:
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str9);
                        i5 |= 8;
                        i3 = 7;
                    case 4:
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str8);
                        i5 |= 16;
                        i3 = 7;
                    case 5:
                        z3 = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 5, LenientBool.INSTANCE, Boolean.valueOf(z3))).booleanValue();
                        i5 |= 32;
                        i3 = 7;
                    case 6:
                        map4 = (Map) beginStructure.decodeSerializableElement(serialDescriptor, 6, PermissionMapSerializer.INSTANCE, map4);
                        i5 |= 64;
                    case 7:
                        i4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, i3, LenientInt.INSTANCE, Integer.valueOf(i4))).intValue();
                        i5 |= 128;
                    case 8:
                        map5 = (Map) beginStructure.decodeSerializableElement(serialDescriptor, 8, PermissionMapSerializer.INSTANCE, map5);
                        i5 |= 256;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            map = map5;
            i = i5;
            str2 = str8;
            j = j2;
            map2 = map4;
            z = z3;
            str3 = str9;
            str4 = str10;
            i2 = i4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new User(i, j, str4, str, str3, str2, z, map2, i2, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, User value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        User.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
