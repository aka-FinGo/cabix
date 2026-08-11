package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientInt;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/ShopReview.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/ShopReview;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class ShopReview$$serializer implements GeneratedSerializer<ShopReview> {
    public static final int $stable = 0;
    public static final ShopReview$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ShopReview$$serializer shopReview$$serializer = new ShopReview$$serializer();
        INSTANCE = shopReview$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.ShopReview", shopReview$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.PRODUCT_NAME, true);
        pluginGeneratedSerialDescriptor.addElement("customer_name", true);
        pluginGeneratedSerialDescriptor.addElement("rating", true);
        pluginGeneratedSerialDescriptor.addElement("text", true);
        pluginGeneratedSerialDescriptor.addElement("reply_text", true);
        pluginGeneratedSerialDescriptor.addElement("created_at", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ShopReview$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LenientLong.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, LenientInt.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x007d. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final ShopReview deserialize(Decoder decoder) {
        String str;
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        long j;
        String str6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i3 = 7;
        int i4 = 6;
        int i5 = 5;
        int i6 = 0;
        if (beginStructure.decodeSequentially()) {
            long longValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, 0L)).longValue();
            str = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 3);
            int intValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 4, LenientInt.INSTANCE, 0)).intValue();
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 5);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 6);
            str2 = beginStructure.decodeStringElement(serialDescriptor, 7);
            str3 = decodeStringElement4;
            str4 = decodeStringElement3;
            str6 = decodeStringElement2;
            i2 = intValue;
            str5 = decodeStringElement;
            j = longValue;
            i = 255;
        } else {
            str = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            boolean z = true;
            int i7 = 0;
            long j2 = 0;
            String str10 = null;
            String str11 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i5 = 5;
                    case 0:
                        j2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, Long.valueOf(j2))).longValue();
                        i6 |= 1;
                        i3 = 7;
                        i4 = 6;
                        i5 = 5;
                    case 1:
                        str = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i6 |= 2;
                    case 2:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i6 |= 4;
                    case 3:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i6 |= 8;
                    case 4:
                        i7 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 4, LenientInt.INSTANCE, Integer.valueOf(i7))).intValue();
                        i6 |= 16;
                    case 5:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, i5);
                        i6 |= 32;
                    case 6:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, i4);
                        i6 |= 64;
                    case 7:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, i3);
                        i6 |= 128;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str2 = str10;
            str3 = str11;
            i = i6;
            long j3 = j2;
            str4 = str7;
            i2 = i7;
            str5 = str9;
            j = j3;
            str6 = str8;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ShopReview(i, j, str, str5, str6, i2, str4, str3, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ShopReview value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ShopReview.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
