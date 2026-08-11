package uz.FonRo.pos.data.model;

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
import uz.FonRo.pos.data.net.LenientBool;
import uz.FonRo.pos.data.net.LenientInt;

/* compiled from: Auth.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/Paywall.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/Paywall;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class Paywall$$serializer implements GeneratedSerializer<Paywall> {
    public static final int $stable = 0;
    public static final Paywall$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Paywall$$serializer paywall$$serializer = new Paywall$$serializer();
        INSTANCE = paywall$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.Paywall", paywall$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement("enabled", true);
        pluginGeneratedSerialDescriptor.addElement("locked", true);
        pluginGeneratedSerialDescriptor.addElement("subscribed", true);
        pluginGeneratedSerialDescriptor.addElement("limit", true);
        pluginGeneratedSerialDescriptor.addElement("remaining", true);
        pluginGeneratedSerialDescriptor.addElement("web_sales", true);
        pluginGeneratedSerialDescriptor.addElement(NotificationCompat.CATEGORY_STATUS, true);
        pluginGeneratedSerialDescriptor.addElement("until", true);
        pluginGeneratedSerialDescriptor.addElement("plan", true);
        pluginGeneratedSerialDescriptor.addElement("plans", true);
        pluginGeneratedSerialDescriptor.addElement("checkout_url", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Paywall$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = Paywall.$childSerializers;
        return new KSerializer[]{LenientBool.INSTANCE, LenientBool.INSTANCE, LenientBool.INSTANCE, LenientInt.INSTANCE, LenientInt.INSTANCE, LenientInt.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(Plan$$serializer.INSTANCE), lazyArr[9].getValue(), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00e7. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final Paywall deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        boolean z;
        boolean z2;
        String str;
        List list;
        String str2;
        int i;
        boolean z3;
        Plan plan;
        int i2;
        int i3;
        int i4;
        String str3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = Paywall.$childSerializers;
        int i5 = 7;
        int i6 = 8;
        int i7 = 0;
        if (beginStructure.decodeSequentially()) {
            z = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientBool.INSTANCE, false)).booleanValue();
            boolean booleanValue = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 1, LenientBool.INSTANCE, false)).booleanValue();
            z2 = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientBool.INSTANCE, false)).booleanValue();
            int intValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 3, LenientInt.INSTANCE, 0)).intValue();
            int intValue2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 4, LenientInt.INSTANCE, 0)).intValue();
            int intValue3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 5, LenientInt.INSTANCE, 0)).intValue();
            String str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, null);
            String str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, null);
            Plan plan2 = (Plan) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, Plan$$serializer.INSTANCE, null);
            i4 = intValue;
            i2 = 2047;
            i = intValue2;
            z3 = booleanValue;
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), null);
            str3 = str5;
            str2 = str4;
            i3 = intValue3;
            plan = plan2;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, null);
        } else {
            int i8 = 10;
            String str6 = null;
            Plan plan3 = null;
            List list2 = null;
            String str7 = null;
            boolean z4 = true;
            z = false;
            z2 = false;
            int i9 = 0;
            int i10 = 0;
            boolean z5 = false;
            String str8 = null;
            int i11 = 0;
            while (z4) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z4 = false;
                        i8 = 10;
                    case 0:
                        z = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientBool.INSTANCE, Boolean.valueOf(z))).booleanValue();
                        i7 |= 1;
                        i5 = 7;
                        i6 = 8;
                        i8 = 10;
                    case 1:
                        z5 = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 1, LenientBool.INSTANCE, Boolean.valueOf(z5))).booleanValue();
                        i7 |= 2;
                        i5 = 7;
                        i6 = 8;
                        i8 = 10;
                    case 2:
                        z2 = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientBool.INSTANCE, Boolean.valueOf(z2))).booleanValue();
                        i7 |= 4;
                        i5 = 7;
                        i6 = 8;
                        i8 = 10;
                    case 3:
                        i9 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 3, LenientInt.INSTANCE, Integer.valueOf(i9))).intValue();
                        i7 |= 8;
                        i5 = 7;
                        i6 = 8;
                        i8 = 10;
                    case 4:
                        i10 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 4, LenientInt.INSTANCE, Integer.valueOf(i10))).intValue();
                        i7 |= 16;
                        i5 = 7;
                        i6 = 8;
                        i8 = 10;
                    case 5:
                        i11 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 5, LenientInt.INSTANCE, Integer.valueOf(i11))).intValue();
                        i7 |= 32;
                        i5 = 7;
                        i8 = 10;
                    case 6:
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str8);
                        i7 |= 64;
                        i5 = 7;
                        i8 = 10;
                    case 7:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i5, StringSerializer.INSTANCE, str7);
                        i7 |= 128;
                        i8 = 10;
                    case 8:
                        plan3 = (Plan) beginStructure.decodeNullableSerializableElement(serialDescriptor, i6, Plan$$serializer.INSTANCE, plan3);
                        i7 |= 256;
                        i8 = 10;
                    case 9:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), list2);
                        i7 |= 512;
                        i8 = 10;
                    case 10:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i8, StringSerializer.INSTANCE, str6);
                        i7 |= 1024;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str6;
            list = list2;
            str2 = str8;
            i = i10;
            z3 = z5;
            plan = plan3;
            i2 = i7;
            i3 = i11;
            i4 = i9;
            str3 = str7;
        }
        beginStructure.endStructure(serialDescriptor);
        return new Paywall(i2, z, z3, z2, i4, i, i3, str2, str3, plan, list, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Paywall value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        Paywall.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
