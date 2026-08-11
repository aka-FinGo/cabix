package uz.FonRo.pos.data.net;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;

/* compiled from: Lenient.kt */
@Metadata(d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001aE\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000b\"\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"decodeEntity", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/serialization/json/JsonDecoder;", "key", "", "inner", "Lkotlinx/serialization/KSerializer;", "id", "Lkotlin/Function1;", "", "(Lkotlinx/serialization/json/JsonDecoder;Ljava/lang/String;Lkotlinx/serialization/KSerializer;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "IntSerializer", "", "getIntSerializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class LenientKt {
    private static final KSerializer<Integer> IntSerializer = BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE);

    public static final <T> T decodeEntity(JsonDecoder jsonDecoder, String key, KSerializer<T> inner, Function1<? super T, Long> id) {
        Object m7870constructorimpl;
        Intrinsics.checkNotNullParameter(jsonDecoder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(inner, "inner");
        Intrinsics.checkNotNullParameter(id, "id");
        JsonElement decodeJsonElement = jsonDecoder.decodeJsonElement();
        JsonObject jsonObject = decodeJsonElement instanceof JsonObject ? (JsonObject) decodeJsonElement : null;
        if (jsonObject == null) {
            return null;
        }
        Object obj = jsonObject.get((Object) key);
        JsonObject jsonObject2 = obj instanceof JsonObject ? (JsonObject) obj : null;
        if (jsonObject2 != null) {
            jsonObject = jsonObject2;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(jsonDecoder.getJson().decodeFromJsonElement(inner, jsonObject));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7876isFailureimpl(m7870constructorimpl)) {
            m7870constructorimpl = null;
        }
        if (m7870constructorimpl != null && id.invoke(m7870constructorimpl).longValue() > 0) {
            return (T) m7870constructorimpl;
        }
        return null;
    }

    public static final KSerializer<Integer> getIntSerializer() {
        return IntSerializer;
    }
}
