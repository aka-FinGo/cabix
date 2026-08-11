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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/StockInPush.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/StockInPush;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class StockInPush$$serializer implements GeneratedSerializer<StockInPush> {
    public static final int $stable = 0;
    public static final StockInPush$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        StockInPush$$serializer stockInPush$$serializer = new StockInPush$$serializer();
        INSTANCE = stockInPush$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.StockInPush", stockInPush$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("client_id", false);
        pluginGeneratedSerialDescriptor.addElement("supplier_id", true);
        pluginGeneratedSerialDescriptor.addElement("invoice_number", true);
        pluginGeneratedSerialDescriptor.addElement("note", true);
        pluginGeneratedSerialDescriptor.addElement("paid_amount", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.ITEMS, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StockInPush$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = StockInPush.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, DoubleSerializer.INSTANCE, lazyArr[5].getValue()};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0060. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final StockInPush deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        List list;
        double d;
        String str;
        String str2;
        long j;
        int i;
        String str3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = StockInPush.$childSerializers;
        String str4 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 1);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 3);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 4);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), null);
            str2 = decodeStringElement3;
            str = decodeStringElement2;
            j = decodeLongElement;
            d = decodeDoubleElement;
            str3 = decodeStringElement;
            i = 63;
        } else {
            long j2 = 0;
            boolean z = true;
            int i2 = 0;
            List list2 = null;
            double d2 = 0.0d;
            String str5 = null;
            String str6 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                    case 0:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 |= 1;
                    case 1:
                        j2 = beginStructure.decodeLongElement(serialDescriptor, 1);
                        i2 |= 2;
                    case 2:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i2 |= 4;
                    case 3:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i2 |= 8;
                    case 4:
                        d2 = beginStructure.decodeDoubleElement(serialDescriptor, 4);
                        i2 |= 16;
                    case 5:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), list2);
                        i2 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            list = list2;
            d = d2;
            str = str5;
            str2 = str6;
            j = j2;
            i = i2;
            str3 = str4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new StockInPush(i, str3, j, str, str2, d, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, StockInPush value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        StockInPush.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
