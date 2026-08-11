package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
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
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientLong;
import uz.FonRo.pos.data.net.LenientString;

/* compiled from: Sales.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"uz/FonRo/pos/data/model/SaleRow.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Luz/FonRo/pos/data/model/SaleRow;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes5.dex */
public final /* synthetic */ class SaleRow$$serializer implements GeneratedSerializer<SaleRow> {
    public static final int $stable = 0;
    public static final SaleRow$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SaleRow$$serializer saleRow$$serializer = new SaleRow$$serializer();
        INSTANCE = saleRow$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("uz.FonRo.pos.data.model.SaleRow", saleRow$$serializer, 26);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("sale_id", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.TRANSACTION_ID, true);
        pluginGeneratedSerialDescriptor.addElement("sold_at", true);
        pluginGeneratedSerialDescriptor.addElement("customer_id", true);
        pluginGeneratedSerialDescriptor.addElement("customer_name", true);
        pluginGeneratedSerialDescriptor.addElement("cashier_name", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.PAYMENT_TYPE, true);
        pluginGeneratedSerialDescriptor.addElement("payment_status", true);
        pluginGeneratedSerialDescriptor.addElement("paid_amount", true);
        pluginGeneratedSerialDescriptor.addElement("received_amount", true);
        pluginGeneratedSerialDescriptor.addElement("change_amount", true);
        pluginGeneratedSerialDescriptor.addElement("cash_amount", true);
        pluginGeneratedSerialDescriptor.addElement("card_amount", true);
        pluginGeneratedSerialDescriptor.addElement("debt_amount", true);
        pluginGeneratedSerialDescriptor.addElement("discount_amount", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.PRODUCT_ID, true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.PRODUCT_NAME, true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("unit", true);
        pluginGeneratedSerialDescriptor.addElement("product_unit", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.QUANTITY, true);
        pluginGeneratedSerialDescriptor.addElement("returned_quantity", true);
        pluginGeneratedSerialDescriptor.addElement("sale_price", true);
        pluginGeneratedSerialDescriptor.addElement("total_amount", true);
        pluginGeneratedSerialDescriptor.addElement("profit", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SaleRow$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LenientLong.INSTANCE, LenientLong.INSTANCE, LenientString.INSTANCE, StringSerializer.INSTANCE, LenientLong.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LenientDouble.INSTANCE, LenientDouble.INSTANCE, LenientDouble.INSTANCE, LenientDouble.INSTANCE, LenientDouble.INSTANCE, LenientDouble.INSTANCE, LenientDouble.INSTANCE, LenientLong.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LenientDouble.INSTANCE, LenientDouble.INSTANCE, LenientDouble.INSTANCE, LenientDouble.INSTANCE, LenientDouble.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x01fe. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final SaleRow deserialize(Decoder decoder) {
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        long j;
        long j2;
        long j3;
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        String str6;
        String str7;
        String str8;
        long j4;
        double d12;
        String str9;
        String str10;
        int i2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        boolean decodeSequentially = beginStructure.decodeSequentially();
        int i3 = 7;
        char c = '\b';
        Double valueOf = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (decodeSequentially) {
            long longValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, 0L)).longValue();
            long longValue2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 1, LenientLong.INSTANCE, 0L)).longValue();
            String str11 = (String) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientString.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 3);
            long longValue3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 4, LenientLong.INSTANCE, 0L)).longValue();
            String str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, null);
            String str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 7);
            String str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, null);
            double doubleValue = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 9, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue2 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 10, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue3 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 11, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 12, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue5 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 13, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue6 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 14, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue7 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 15, LenientDouble.INSTANCE, valueOf)).doubleValue();
            long longValue4 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 16, LenientLong.INSTANCE, 0L)).longValue();
            String str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, null);
            String str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, null);
            String str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, StringSerializer.INSTANCE, null);
            String str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, StringSerializer.INSTANCE, null);
            double doubleValue8 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 21, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue9 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 22, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue10 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 23, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue11 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 24, LenientDouble.INSTANCE, valueOf)).doubleValue();
            double doubleValue12 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 25, LenientDouble.INSTANCE, valueOf)).doubleValue();
            i = RectListKt.Lower26Bits;
            str3 = str11;
            j = longValue;
            str6 = str15;
            str9 = str17;
            str10 = str18;
            str7 = decodeStringElement;
            str8 = str16;
            d11 = doubleValue12;
            d7 = doubleValue8;
            d8 = doubleValue9;
            d9 = doubleValue10;
            d10 = doubleValue11;
            j4 = longValue4;
            d5 = doubleValue6;
            j2 = longValue2;
            d12 = doubleValue5;
            d6 = doubleValue7;
            str2 = str14;
            str5 = decodeStringElement2;
            d4 = doubleValue4;
            j3 = longValue3;
            d3 = doubleValue3;
            str4 = str12;
            str = str13;
            d2 = doubleValue2;
            d = doubleValue;
        } else {
            boolean z = true;
            String str19 = null;
            String str20 = null;
            String str21 = null;
            String str22 = null;
            String str23 = null;
            String str24 = null;
            String str25 = null;
            String str26 = null;
            long j5 = 0;
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            double d13 = 0.0d;
            double d14 = 0.0d;
            double d15 = 0.0d;
            double d16 = 0.0d;
            double d17 = 0.0d;
            double d18 = 0.0d;
            double d19 = 0.0d;
            double d20 = 0.0d;
            double d21 = 0.0d;
            double d22 = 0.0d;
            double d23 = 0.0d;
            double d24 = 0.0d;
            i = 0;
            String str27 = null;
            String str28 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        Unit unit = Unit.INSTANCE;
                        z = false;
                        c = '\b';
                        i3 = 7;
                    case 0:
                        j5 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 0, LenientLong.INSTANCE, Long.valueOf(j5))).longValue();
                        i |= 1;
                        Unit unit2 = Unit.INSTANCE;
                        c = '\b';
                        i3 = 7;
                    case 1:
                        j6 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 1, LenientLong.INSTANCE, Long.valueOf(j6))).longValue();
                        i |= 2;
                        Unit unit3 = Unit.INSTANCE;
                        c = '\b';
                        i3 = 7;
                    case 2:
                        str23 = (String) beginStructure.decodeSerializableElement(serialDescriptor, 2, LenientString.INSTANCE, str23);
                        i |= 4;
                        Unit unit4 = Unit.INSTANCE;
                        c = '\b';
                        i3 = 7;
                    case 3:
                        str22 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i |= 8;
                        Unit unit42 = Unit.INSTANCE;
                        c = '\b';
                        i3 = 7;
                    case 4:
                        j7 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 4, LenientLong.INSTANCE, Long.valueOf(j7))).longValue();
                        i |= 16;
                        Unit unit32 = Unit.INSTANCE;
                        c = '\b';
                        i3 = 7;
                    case 5:
                        String str29 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str24);
                        i |= 32;
                        Unit unit5 = Unit.INSTANCE;
                        str24 = str29;
                        c = '\b';
                        i3 = 7;
                    case 6:
                        str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str27);
                        i |= 64;
                        Unit unit322 = Unit.INSTANCE;
                        c = '\b';
                        i3 = 7;
                    case 7:
                        str28 = beginStructure.decodeStringElement(serialDescriptor, i3);
                        i |= 128;
                        Unit unit6 = Unit.INSTANCE;
                        c = '\b';
                        i3 = 7;
                    case 8:
                        String str30 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str21);
                        i |= 256;
                        Unit unit7 = Unit.INSTANCE;
                        str21 = str30;
                        c = '\b';
                        i3 = 7;
                    case 9:
                        d13 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 9, LenientDouble.INSTANCE, Double.valueOf(d13))).doubleValue();
                        i |= 512;
                        Unit unit3222 = Unit.INSTANCE;
                        c = '\b';
                        i3 = 7;
                    case 10:
                        d14 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 10, LenientDouble.INSTANCE, Double.valueOf(d14))).doubleValue();
                        i |= 1024;
                        Unit unit32222 = Unit.INSTANCE;
                        c = '\b';
                        i3 = 7;
                    case 11:
                        d15 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 11, LenientDouble.INSTANCE, Double.valueOf(d15))).doubleValue();
                        i |= 2048;
                        Unit unit322222 = Unit.INSTANCE;
                        c = '\b';
                        i3 = 7;
                    case 12:
                        d16 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 12, LenientDouble.INSTANCE, Double.valueOf(d16))).doubleValue();
                        i |= 4096;
                        Unit unit3222222 = Unit.INSTANCE;
                        c = '\b';
                        i3 = 7;
                    case 13:
                        d17 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 13, LenientDouble.INSTANCE, Double.valueOf(d17))).doubleValue();
                        i |= 8192;
                        Unit unit32222222 = Unit.INSTANCE;
                        c = '\b';
                        i3 = 7;
                    case 14:
                        d18 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 14, LenientDouble.INSTANCE, Double.valueOf(d18))).doubleValue();
                        i |= 16384;
                        Unit unit322222222 = Unit.INSTANCE;
                        c = '\b';
                        i3 = 7;
                    case 15:
                        d19 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 15, LenientDouble.INSTANCE, Double.valueOf(d19))).doubleValue();
                        i2 = 32768;
                        i |= i2;
                        Unit unit3222222222 = Unit.INSTANCE;
                        c = '\b';
                        i3 = 7;
                    case 16:
                        j8 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 16, LenientLong.INSTANCE, Long.valueOf(j8))).longValue();
                        i2 = 65536;
                        i |= i2;
                        Unit unit32222222222 = Unit.INSTANCE;
                        c = '\b';
                        i3 = 7;
                    case 17:
                        String str31 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, str20);
                        i |= 131072;
                        Unit unit8 = Unit.INSTANCE;
                        str20 = str31;
                        c = '\b';
                        i3 = 7;
                    case 18:
                        String str32 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, str26);
                        i |= 262144;
                        Unit unit9 = Unit.INSTANCE;
                        str26 = str32;
                        c = '\b';
                        i3 = 7;
                    case 19:
                        str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, StringSerializer.INSTANCE, str19);
                        i |= 524288;
                        Unit unit10 = Unit.INSTANCE;
                        c = '\b';
                        i3 = 7;
                    case 20:
                        String str33 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, StringSerializer.INSTANCE, str25);
                        i |= 1048576;
                        Unit unit11 = Unit.INSTANCE;
                        str25 = str33;
                        c = '\b';
                        i3 = 7;
                    case 21:
                        double doubleValue13 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 21, LenientDouble.INSTANCE, Double.valueOf(d20))).doubleValue();
                        i |= 2097152;
                        Unit unit12 = Unit.INSTANCE;
                        d20 = doubleValue13;
                        c = '\b';
                        i3 = 7;
                    case 22:
                        double doubleValue14 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 22, LenientDouble.INSTANCE, Double.valueOf(d21))).doubleValue();
                        i |= 4194304;
                        Unit unit13 = Unit.INSTANCE;
                        d21 = doubleValue14;
                        c = '\b';
                        i3 = 7;
                    case 23:
                        double doubleValue15 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 23, LenientDouble.INSTANCE, Double.valueOf(d22))).doubleValue();
                        i |= 8388608;
                        Unit unit14 = Unit.INSTANCE;
                        d22 = doubleValue15;
                        c = '\b';
                        i3 = 7;
                    case 24:
                        double doubleValue16 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 24, LenientDouble.INSTANCE, Double.valueOf(d23))).doubleValue();
                        i |= 16777216;
                        Unit unit15 = Unit.INSTANCE;
                        d23 = doubleValue16;
                        c = '\b';
                        i3 = 7;
                    case 25:
                        double doubleValue17 = ((Number) beginStructure.decodeSerializableElement(serialDescriptor, 25, LenientDouble.INSTANCE, Double.valueOf(d24))).doubleValue();
                        i |= 33554432;
                        Unit unit16 = Unit.INSTANCE;
                        d24 = doubleValue17;
                        c = '\b';
                        i3 = 7;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str27;
            str2 = str21;
            str3 = str23;
            str4 = str24;
            str5 = str28;
            j = j5;
            j2 = j6;
            j3 = j7;
            d = d13;
            d2 = d14;
            d3 = d15;
            d4 = d16;
            d5 = d18;
            d6 = d19;
            d7 = d20;
            d8 = d21;
            d9 = d22;
            d10 = d23;
            d11 = d24;
            str6 = str20;
            str7 = str22;
            str8 = str26;
            j4 = j8;
            d12 = d17;
            str9 = str19;
            str10 = str25;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SaleRow(i, j, j2, str3, str7, j3, str4, str, str5, str2, d, d2, d3, d4, d12, d5, d6, j4, str6, str8, str9, str10, d7, d8, d9, d10, d11, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SaleRow value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SaleRow.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
