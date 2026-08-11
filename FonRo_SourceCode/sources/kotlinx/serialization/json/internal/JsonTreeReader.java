package kotlinx.serialization.json.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: JsonTreeReader.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0002J\u001e\u0010\r\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0\u000fH\u0082@¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015H\u0082\bJ\b\u0010\u0016\u001a\u00020\u000eH\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u0006\u0010\u001a\u001a\u00020\u000eJ\b\u0010\u001b\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeReader;", "", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "lexer", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/AbstractJsonLexer;)V", "isLenient", "", "trailingCommaAllowed", "stackDepth", "", "readObject", "Lkotlinx/serialization/json/JsonElement;", "Lkotlin/DeepRecursiveScope;", "", "(Lkotlin/DeepRecursiveScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readObjectImpl", "Lkotlinx/serialization/json/JsonObject;", "reader", "Lkotlin/Function0;", "readArray", "readValue", "Lkotlinx/serialization/json/JsonPrimitive;", "isString", "read", "readDeepRecursive", "kotlinx-serialization-json"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes6.dex */
public final class JsonTreeReader {
    private final boolean isLenient;
    private final AbstractJsonLexer lexer;
    private int stackDepth;
    private final boolean trailingCommaAllowed;

    public JsonTreeReader(JsonConfiguration configuration, AbstractJsonLexer lexer) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        this.lexer = lexer;
        this.isLenient = configuration.getIsLenient();
        this.trailingCommaAllowed = configuration.getAllowTrailingComma();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x009b -> B:10:0x00a6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readObject(kotlin.DeepRecursiveScope<kotlin.Unit, kotlinx.serialization.json.JsonElement> r19, kotlin.coroutines.Continuation<? super kotlinx.serialization.json.JsonElement> r20) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonTreeReader.readObject(kotlin.DeepRecursiveScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final JsonObject readObjectImpl(Function0<? extends JsonElement> reader) {
        byte consumeNextToken = this.lexer.consumeNextToken((byte) 6);
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            if (!this.lexer.canConsumeValue()) {
                break;
            }
            boolean z = this.isLenient;
            AbstractJsonLexer abstractJsonLexer = this.lexer;
            String consumeStringLenient = z ? abstractJsonLexer.consumeStringLenient() : abstractJsonLexer.consumeString();
            this.lexer.consumeNextToken((byte) 5);
            linkedHashMap.put(consumeStringLenient, reader.invoke());
            consumeNextToken = this.lexer.consumeNextToken();
            if (consumeNextToken != 4) {
                if (consumeNextToken != 7) {
                    AbstractJsonLexer.fail$default(this.lexer, "Expected end of the object or comma", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (consumeNextToken == 6) {
            this.lexer.consumeNextToken((byte) 7);
        } else if (consumeNextToken == 4) {
            boolean z2 = this.trailingCommaAllowed;
            AbstractJsonLexer abstractJsonLexer2 = this.lexer;
            if (!z2) {
                JsonExceptionsKt.invalidTrailingComma$default(abstractJsonLexer2, null, 1, null);
                throw new KotlinNothingValueException();
            }
            abstractJsonLexer2.consumeNextToken((byte) 7);
        }
        return new JsonObject(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonElement readArray() {
        byte consumeNextToken = this.lexer.consumeNextToken();
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        ArrayList arrayList = new ArrayList();
        while (this.lexer.canConsumeValue()) {
            arrayList.add(read());
            consumeNextToken = this.lexer.consumeNextToken();
            if (consumeNextToken != 4) {
                AbstractJsonLexer abstractJsonLexer = this.lexer;
                boolean z = consumeNextToken == 9;
                int i = abstractJsonLexer.currentPosition;
                if (!z) {
                    AbstractJsonLexer.fail$default(abstractJsonLexer, "Expected end of the array or comma", i, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (consumeNextToken == 8) {
            this.lexer.consumeNextToken((byte) 9);
        } else if (consumeNextToken == 4) {
            boolean z2 = this.trailingCommaAllowed;
            AbstractJsonLexer abstractJsonLexer2 = this.lexer;
            if (!z2) {
                JsonExceptionsKt.invalidTrailingComma(abstractJsonLexer2, "array");
                throw new KotlinNothingValueException();
            }
            abstractJsonLexer2.consumeNextToken((byte) 9);
        }
        return new JsonArray(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonPrimitive readValue(boolean isString) {
        String consumeStringLenient;
        if (this.isLenient || !isString) {
            consumeStringLenient = this.lexer.consumeStringLenient();
        } else {
            consumeStringLenient = this.lexer.consumeString();
        }
        String str = consumeStringLenient;
        return (isString || !Intrinsics.areEqual(str, AbstractJsonLexerKt.NULL)) ? new JsonLiteral(str, isString, null, 4, null) : JsonNull.INSTANCE;
    }

    public final JsonElement read() {
        JsonElement readObject;
        byte peekNextToken = this.lexer.peekNextToken();
        if (peekNextToken == 1) {
            return readValue(true);
        }
        if (peekNextToken == 0) {
            return readValue(false);
        }
        if (peekNextToken == 6) {
            int i = this.stackDepth + 1;
            this.stackDepth = i;
            if (i == 200) {
                readObject = readDeepRecursive();
            } else {
                readObject = readObject();
            }
            this.stackDepth--;
            return readObject;
        }
        if (peekNextToken == 8) {
            return readArray();
        }
        AbstractJsonLexer.fail$default(this.lexer, "Cannot read Json element because of unexpected " + AbstractJsonLexerKt.tokenDescription(peekNextToken), 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final JsonElement readDeepRecursive() {
        return (JsonElement) DeepRecursiveKt.invoke(new DeepRecursiveFunction(new JsonTreeReader$readDeepRecursive$1(this, null)), Unit.INSTANCE);
    }

    private final JsonElement readObject() {
        byte consumeNextToken = this.lexer.consumeNextToken((byte) 6);
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            if (!this.lexer.canConsumeValue()) {
                break;
            }
            boolean z = this.isLenient;
            AbstractJsonLexer abstractJsonLexer = this.lexer;
            String consumeStringLenient = z ? abstractJsonLexer.consumeStringLenient() : abstractJsonLexer.consumeString();
            this.lexer.consumeNextToken((byte) 5);
            linkedHashMap.put(consumeStringLenient, read());
            consumeNextToken = this.lexer.consumeNextToken();
            if (consumeNextToken != 4) {
                if (consumeNextToken != 7) {
                    AbstractJsonLexer.fail$default(this.lexer, "Expected end of the object or comma", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (consumeNextToken == 6) {
            this.lexer.consumeNextToken((byte) 7);
        } else if (consumeNextToken == 4) {
            boolean z2 = this.trailingCommaAllowed;
            AbstractJsonLexer abstractJsonLexer2 = this.lexer;
            if (!z2) {
                JsonExceptionsKt.invalidTrailingComma$default(abstractJsonLexer2, null, 1, null);
                throw new KotlinNothingValueException();
            }
            abstractJsonLexer2.consumeNextToken((byte) 7);
        }
        return new JsonObject(linkedHashMap);
    }
}
