package uz.FonRo.pos.data.net;

import androidx.constraintlayout.widget.ConstraintLayout;
import coil.disk.DiskLruCache;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: Lenient.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bÊ\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Luz/FonRo/pos/data/net/LenientBool;", "Lkotlinx/serialization/KSerializer;", "", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Boolean;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes6.dex */
public final class LenientBool implements KSerializer<Boolean> {
    public static final int $stable = 0;
    public static final LenientBool INSTANCE = new LenientBool();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("LenientBool", PrimitiveKind.BOOLEAN.INSTANCE);

    private LenientBool() {
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        serialize(encoder, ((Boolean) obj).booleanValue());
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Boolean deserialize(Decoder decoder) {
        String content;
        String obj;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            return Boolean.valueOf(decoder.decodeBoolean());
        }
        JsonElement decodeJsonElement = jsonDecoder.decodeJsonElement();
        if (decodeJsonElement instanceof JsonNull) {
            return false;
        }
        JsonPrimitive jsonPrimitive = decodeJsonElement instanceof JsonPrimitive ? (JsonPrimitive) decodeJsonElement : null;
        if (jsonPrimitive != null && (content = jsonPrimitive.getContent()) != null && (obj = StringsKt.trim((CharSequence) content).toString()) != null) {
            String lowerCase = obj.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                return Boolean.valueOf(Intrinsics.areEqual(lowerCase, DiskLruCache.VERSION) || Intrinsics.areEqual(lowerCase, "true") || Intrinsics.areEqual(lowerCase, "yes") || Intrinsics.areEqual(lowerCase, DebugKt.DEBUG_PROPERTY_VALUE_ON));
            }
        }
        return false;
    }

    public void serialize(Encoder encoder, boolean value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.encodeBoolean(value);
    }
}
