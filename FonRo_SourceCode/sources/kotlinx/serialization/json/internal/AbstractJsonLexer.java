package kotlinx.serialization.json.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AbstractJsonLexer.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\f\u001a\u00020\r*\u00020\u000eH\u0084\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH&J\b\u0010\u0014\u001a\u00020\rH&J\b\u0010\u0015\u001a\u00020\u0016H&J\u0006\u0010\u0017\u001a\u00020\rJ\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000eH\u0004J\u0006\u0010\u001a\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u000eH&J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u000eH\u0004J]\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00162\b\b\u0002\u0010)\u001a\u00020\r28\b\u0002\u0010*\u001a2\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u001c0+H\u0080\bø\u0001\u0000¢\u0006\u0002\b.J\b\u0010/\u001a\u00020\u0016H\u0016J\u0010\u00100\u001a\u00020\r2\b\b\u0002\u00101\u001a\u00020\rJ\b\u00102\u001a\u00020\tH&J\u001a\u00103\u001a\u0004\u0018\u00010\u001c2\u0006\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\rH&J\u0010\u00106\u001a\u0004\u0018\u00010\u001c2\u0006\u00105\u001a\u00020\rJ\u0006\u00107\u001a\u00020\u0010J\u0018\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\tH\u0016J\u0018\u0010;\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\t2\u0006\u0010<\u001a\u00020\tH\u0016J\b\u0010=\u001a\u00020\u001cH&J\u0018\u0010>\u001a\u00020\r2\u0006\u00105\u001a\u00020\r2\u0006\u00109\u001a\u00020\u000eH\u0002J3\u0010?\u001a\u00020\u00102\u0006\u00105\u001a\u00020\r2!\u0010@\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\u00100AH\u0016JC\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\r2!\u0010@\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\u00100AH\u0002J\u0006\u0010G\u001a\u00020\u001cJ \u0010G\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\tH\u0005J\u0018\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020\t2\u0006\u0010I\u001a\u00020\tH\u0002J\u0018\u0010L\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010M\u001a\u00020\u001cH\u0002J\u0006\u0010N\u001a\u00020\u001cJ\b\u0010O\u001a\u00020\rH\u0002J\u0006\u0010P\u001a\u00020\u001cJ\u0018\u0010Q\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\tH\u0014J\u0010\u0010R\u001a\u00020\t2\u0006\u0010H\u001a\u00020\tH\u0002J\u0018\u0010S\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\tH\u0002J1\u0010T\u001a\u00020\u00102\u0006\u0010U\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\t2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0VH\u0080\bø\u0001\u0000¢\u0006\u0002\bWJ\u0018\u0010X\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010Y\u001a\u00020\u00102\u0006\u0010Z\u001a\u00020\rJ\b\u0010[\u001a\u00020\u001cH\u0016J\u000e\u0010\\\u001a\u00020\u00102\u0006\u0010]\u001a\u00020\u001cJ\"\u0010&\u001a\u00020'2\u0006\u0010*\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010^\u001a\u00020\u001cJ\u0006\u0010_\u001a\u00020`J\u0006\u0010a\u001a\u00020`J\u0006\u0010b\u001a\u00020\rJ\u0006\u0010c\u001a\u00020\rJ\u0010\u0010b\u001a\u00020\r2\u0006\u0010d\u001a\u00020\tH\u0003J\u0018\u0010e\u001a\u00020\u00102\u0006\u0010f\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\tH\u0002J\"\u0010g\u001a\u0002Hh\"\u0004\b\u0000\u0010h2\f\u0010i\u001a\b\u0012\u0004\u0012\u0002Hh0VH\u0082\b¢\u0006\u0002\u0010jR\u0012\u0010\u0004\u001a\u00020\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00060\u001ej\u0002`\u001fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006k"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "", "<init>", "()V", FirebaseAnalytics.Param.SOURCE, "", "getSource", "()Ljava/lang/CharSequence;", "currentPosition", "", "path", "Lkotlinx/serialization/json/internal/JsonPath;", "isWs", "", "", "ensureHaveChars", "", "isNotEof", "prefetchOrEof", "position", "canConsumeValue", "consumeNextToken", "", "tryConsumeComma", "isValidValueStart", "c", "expectEof", "peekedString", "", "escapedString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getEscapedString", "()Ljava/lang/StringBuilder;", "setEscapedString", "(Ljava/lang/StringBuilder;)V", "expected", "unexpectedToken", "fail", "", "expectedToken", "wasConsumed", "message", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "fail$kotlinx_serialization_json", "peekNextToken", "tryConsumeNull", "doConsume", "skipWhitespaces", "peekLeadingMatchingValue", "keyToMatch", "isLenient", "peekString", "discardPeeked", "indexOf", "char", "startPos", "substring", "endPos", "consumeKeyString", "insideString", "consumeStringChunked", "consumeChunk", "Lkotlin/Function1;", "stringChunk", "writeRange", "fromIndex", "toIndex", "currentChunkHasEscape", "consumeString", "startPosition", "current", "appendEscape", "lastPosition", "decodedString", "takePeeked", "consumeStringLenientNotNull", "wasUnquotedString", "consumeStringLenient", "appendRange", "appendEsc", "appendHex", "require", "condition", "Lkotlin/Function0;", "require$kotlinx_serialization_json", "fromHexChar", "skipElement", "allowLenientStrings", "toString", "failOnUnknownKey", "key", "hint", "consumeNumericLiteral", "", "consumeNumericLiteralFully", "consumeBoolean", "consumeBooleanLenient", "start", "consumeBooleanLiteral", "literalSuffix", "withPositionRollback", ExifInterface.GPS_DIRECTION_TRUE, "action", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-serialization-json"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes6.dex */
public abstract class AbstractJsonLexer {
    public int currentPosition;
    private String peekedString;
    public final JsonPath path = new JsonPath();
    private StringBuilder escapedString = new StringBuilder();

    public abstract boolean canConsumeValue();

    public abstract String consumeKeyString();

    public abstract byte consumeNextToken();

    public abstract void consumeNextToken(char expected);

    public void ensureHaveChars() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract CharSequence getSource();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isValidValueStart(char c) {
        return (c == ',' || c == ':' || c == ']' || c == '}') ? false : true;
    }

    protected final boolean isWs(char c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t';
    }

    public abstract String peekLeadingMatchingValue(String keyToMatch, boolean isLenient);

    public abstract int prefetchOrEof(int position);

    public abstract int skipWhitespaces();

    public final boolean isNotEof() {
        return peekNextToken() != 10;
    }

    public final boolean tryConsumeComma() {
        int skipWhitespaces = skipWhitespaces();
        CharSequence source = getSource();
        if (skipWhitespaces >= source.length() || skipWhitespaces == -1 || source.charAt(skipWhitespaces) != ',') {
            return false;
        }
        this.currentPosition++;
        return true;
    }

    public final void expectEof() {
        if (consumeNextToken() == 10) {
            return;
        }
        fail$default(this, "Expected EOF after parsing, but had " + getSource().charAt(this.currentPosition - 1) + " instead", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final StringBuilder getEscapedString() {
        return this.escapedString;
    }

    protected final void setEscapedString(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "<set-?>");
        this.escapedString = sb;
    }

    public final byte consumeNextToken(byte expected) {
        byte consumeNextToken = consumeNextToken();
        if (consumeNextToken == expected) {
            return consumeNextToken;
        }
        String str = AbstractJsonLexerKt.tokenDescription(expected);
        int i = this.currentPosition;
        int i2 = i - 1;
        fail$default(this, "Expected " + str + ", but had '" + ((i == getSource().length() || i2 < 0) ? "EOF" : String.valueOf(getSource().charAt(i2))) + "' instead", i2, null, 4, null);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void unexpectedToken(char expected) {
        int i = this.currentPosition;
        if (i > 0 && expected == '\"') {
            try {
                this.currentPosition = i - 1;
                String consumeStringLenient = consumeStringLenient();
                this.currentPosition = i;
                if (Intrinsics.areEqual(consumeStringLenient, AbstractJsonLexerKt.NULL)) {
                    fail("Expected string literal but 'null' literal was found", this.currentPosition - 1, AbstractJsonLexerKt.coerceInputValuesHint);
                    throw new KotlinNothingValueException();
                }
            } catch (Throwable th) {
                this.currentPosition = i;
                throw th;
            }
        }
        String str = AbstractJsonLexerKt.tokenDescription(AbstractJsonLexerKt.charToTokenClass(expected));
        int i2 = this.currentPosition;
        int i3 = i2 - 1;
        fail$default(this, "Expected " + str + ", but had '" + ((i2 == getSource().length() || i3 < 0) ? "EOF" : String.valueOf(getSource().charAt(i3))) + "' instead", i3, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Void fail$kotlinx_serialization_json$default(AbstractJsonLexer abstractJsonLexer, byte b, boolean z, Function2 message, int i, Object obj) {
        int i2;
        int i3;
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                message = new Function2<String, String, String>() { // from class: kotlinx.serialization.json.internal.AbstractJsonLexer$fail$1
                    @Override // kotlin.jvm.functions.Function2
                    public final String invoke(String expected, String source) {
                        Intrinsics.checkNotNullParameter(expected, "expected");
                        Intrinsics.checkNotNullParameter(source, "source");
                        return "Expected " + expected + ", but had '" + source + "' instead";
                    }
                };
            }
            Intrinsics.checkNotNullParameter(message, "message");
            String str = AbstractJsonLexerKt.tokenDescription(b);
            if (z) {
                i2 = abstractJsonLexer.currentPosition;
                i3 = i2 - 1;
            } else {
                i2 = abstractJsonLexer.currentPosition;
                i3 = i2;
            }
            fail$default(abstractJsonLexer, (String) message.invoke(str, (i2 == abstractJsonLexer.getSource().length() || i3 < 0) ? "EOF" : String.valueOf(abstractJsonLexer.getSource().charAt(i3))), i3, null, 4, null);
            throw new KotlinNothingValueException();
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
    }

    public final Void fail$kotlinx_serialization_json(byte expectedToken, boolean wasConsumed, Function2<? super String, ? super String, String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        String str = AbstractJsonLexerKt.tokenDescription(expectedToken);
        int i = this.currentPosition;
        int i2 = wasConsumed ? i - 1 : i;
        fail$default(this, message.invoke(str, (i == getSource().length() || i2 < 0) ? "EOF" : String.valueOf(getSource().charAt(i2))), i2, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public byte peekNextToken() {
        CharSequence source = getSource();
        int i = this.currentPosition;
        while (true) {
            int prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof != -1) {
                char charAt = source.charAt(prefetchOrEof);
                if (charAt != '\t' && charAt != '\n' && charAt != '\r' && charAt != ' ') {
                    this.currentPosition = prefetchOrEof;
                    return AbstractJsonLexerKt.charToTokenClass(charAt);
                }
                i = prefetchOrEof + 1;
            } else {
                this.currentPosition = prefetchOrEof;
                return (byte) 10;
            }
        }
    }

    public static /* synthetic */ boolean tryConsumeNull$default(AbstractJsonLexer abstractJsonLexer, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return abstractJsonLexer.tryConsumeNull(z);
    }

    public final boolean tryConsumeNull(boolean doConsume) {
        int prefetchOrEof = prefetchOrEof(skipWhitespaces());
        int length = getSource().length() - prefetchOrEof;
        if (length < 4 || prefetchOrEof == -1) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (AbstractJsonLexerKt.NULL.charAt(i) != getSource().charAt(prefetchOrEof + i)) {
                return false;
            }
        }
        if (length > 4 && AbstractJsonLexerKt.charToTokenClass(getSource().charAt(prefetchOrEof + 4)) == 0) {
            return false;
        }
        if (!doConsume) {
            return true;
        }
        this.currentPosition = prefetchOrEof + 4;
        return true;
    }

    public final String peekString(boolean isLenient) {
        String consumeString;
        byte peekNextToken = peekNextToken();
        if (isLenient) {
            if (peekNextToken != 1 && peekNextToken != 0) {
                return null;
            }
            consumeString = consumeStringLenient();
        } else {
            if (peekNextToken != 1) {
                return null;
            }
            consumeString = consumeString();
        }
        this.peekedString = consumeString;
        return consumeString;
    }

    public final void discardPeeked() {
        this.peekedString = null;
    }

    public int indexOf(char r7, int startPos) {
        return StringsKt.indexOf$default(getSource(), r7, startPos, false, 4, (Object) null);
    }

    public String substring(int startPos, int endPos) {
        return getSource().subSequence(startPos, endPos).toString();
    }

    private final boolean insideString(boolean isLenient, char r3) {
        return isLenient ? AbstractJsonLexerKt.charToTokenClass(r3) == 0 : r3 != '\"';
    }

    public void consumeStringChunked(boolean isLenient, Function1<? super String, Unit> consumeChunk) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(consumeChunk, "consumeChunk");
        byte peekNextToken = peekNextToken();
        if (!isLenient || peekNextToken == 0) {
            if (!isLenient) {
                consumeNextToken('\"');
            }
            int i3 = this.currentPosition;
            char charAt = getSource().charAt(i3);
            boolean z = false;
            int i4 = i3;
            while (this.insideString(isLenient, charAt)) {
                if (isLenient || charAt != '\\') {
                    int i5 = i4 + 1;
                    i = i3;
                    i2 = i5;
                } else {
                    i2 = this.prefetchOrEof(this.appendEscape(i3, i4));
                    z = true;
                    i = i2;
                }
                if (i2 >= this.getSource().length()) {
                    this.writeRange(i, i2, z, consumeChunk);
                    int prefetchOrEof = this.prefetchOrEof(i2);
                    if (prefetchOrEof == -1) {
                        fail$default(this, "EOF", prefetchOrEof, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                    z = false;
                    i3 = prefetchOrEof;
                    i4 = i3;
                } else {
                    int i6 = i;
                    i4 = i2;
                    i3 = i6;
                }
                AbstractJsonLexer abstractJsonLexer = this;
                charAt = abstractJsonLexer.getSource().charAt(i4);
                this = abstractJsonLexer;
            }
            AbstractJsonLexer abstractJsonLexer2 = this;
            abstractJsonLexer2.writeRange(i3, i4, z, consumeChunk);
            abstractJsonLexer2.currentPosition = i4;
            if (isLenient) {
                return;
            }
            abstractJsonLexer2.consumeNextToken('\"');
        }
    }

    private final void writeRange(int fromIndex, int toIndex, boolean currentChunkHasEscape, Function1<? super String, Unit> consumeChunk) {
        if (currentChunkHasEscape) {
            consumeChunk.invoke(decodedString(fromIndex, toIndex));
        } else {
            consumeChunk.invoke(substring(fromIndex, toIndex));
        }
    }

    public final String consumeString() {
        if (this.peekedString != null) {
            return takePeeked();
        }
        return consumeKeyString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String consumeString(CharSequence source, int startPosition, int current) {
        String decodedString;
        AbstractJsonLexer abstractJsonLexer;
        Intrinsics.checkNotNullParameter(source, "source");
        char charAt = source.charAt(current);
        boolean z = false;
        while (charAt != '\"') {
            if (charAt == '\\') {
                int prefetchOrEof = this.prefetchOrEof(this.appendEscape(startPosition, current));
                if (prefetchOrEof == -1) {
                    fail$default(this, "Unexpected EOF", prefetchOrEof, null, 4, null);
                    throw new KotlinNothingValueException();
                }
                abstractJsonLexer = this;
                z = true;
                startPosition = prefetchOrEof;
                current = startPosition;
            } else {
                abstractJsonLexer = this;
                current++;
                if (current >= source.length()) {
                    abstractJsonLexer.appendRange(startPosition, current);
                    int prefetchOrEof2 = abstractJsonLexer.prefetchOrEof(current);
                    if (prefetchOrEof2 == -1) {
                        fail$default(abstractJsonLexer, "Unexpected EOF", prefetchOrEof2, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                    startPosition = prefetchOrEof2;
                    current = startPosition;
                    z = true;
                } else {
                    continue;
                }
            }
            AbstractJsonLexer abstractJsonLexer2 = abstractJsonLexer;
            charAt = source.charAt(current);
            this = abstractJsonLexer2;
        }
        AbstractJsonLexer abstractJsonLexer3 = this;
        if (!z) {
            decodedString = abstractJsonLexer3.substring(startPosition, current);
        } else {
            decodedString = abstractJsonLexer3.decodedString(startPosition, current);
        }
        abstractJsonLexer3.currentPosition = current + 1;
        return decodedString;
    }

    private final int appendEscape(int lastPosition, int current) {
        appendRange(lastPosition, current);
        return appendEsc(current + 1);
    }

    private final String decodedString(int lastPosition, int currentPosition) {
        appendRange(lastPosition, currentPosition);
        String sb = this.escapedString.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        this.escapedString.setLength(0);
        return sb;
    }

    private final String takePeeked() {
        String str = this.peekedString;
        Intrinsics.checkNotNull(str);
        this.peekedString = null;
        return str;
    }

    public final String consumeStringLenientNotNull() {
        String consumeStringLenient = consumeStringLenient();
        if (!Intrinsics.areEqual(consumeStringLenient, AbstractJsonLexerKt.NULL) || !wasUnquotedString()) {
            return consumeStringLenient;
        }
        fail$default(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final boolean wasUnquotedString() {
        return getSource().charAt(this.currentPosition - 1) != '\"';
    }

    public final String consumeStringLenient() {
        String decodedString;
        if (this.peekedString != null) {
            return takePeeked();
        }
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces >= getSource().length() || skipWhitespaces == -1) {
            fail$default(this, "EOF", skipWhitespaces, null, 4, null);
            throw new KotlinNothingValueException();
        }
        byte charToTokenClass = AbstractJsonLexerKt.charToTokenClass(getSource().charAt(skipWhitespaces));
        if (charToTokenClass == 1) {
            return consumeString();
        }
        if (charToTokenClass != 0) {
            fail$default(this, "Expected beginning of the string, but got " + getSource().charAt(skipWhitespaces), 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        boolean z = false;
        while (AbstractJsonLexerKt.charToTokenClass(getSource().charAt(skipWhitespaces)) == 0) {
            skipWhitespaces++;
            if (skipWhitespaces >= getSource().length()) {
                appendRange(this.currentPosition, skipWhitespaces);
                int prefetchOrEof = prefetchOrEof(skipWhitespaces);
                if (prefetchOrEof == -1) {
                    this.currentPosition = skipWhitespaces;
                    return decodedString(0, 0);
                }
                skipWhitespaces = prefetchOrEof;
                z = true;
            }
        }
        int i = this.currentPosition;
        if (!z) {
            decodedString = substring(i, skipWhitespaces);
        } else {
            decodedString = decodedString(i, skipWhitespaces);
        }
        this.currentPosition = skipWhitespaces;
        return decodedString;
    }

    protected void appendRange(int fromIndex, int toIndex) {
        this.escapedString.append(getSource(), fromIndex, toIndex);
    }

    private final int appendEsc(int startPosition) {
        int prefetchOrEof = prefetchOrEof(startPosition);
        if (prefetchOrEof == -1) {
            fail$default(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i = prefetchOrEof + 1;
        char charAt = getSource().charAt(prefetchOrEof);
        if (charAt == 'u') {
            return appendHex(getSource(), i);
        }
        char escapeToChar = AbstractJsonLexerKt.escapeToChar(charAt);
        if (escapeToChar == 0) {
            fail$default(this, "Invalid escaped char '" + charAt + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        this.escapedString.append(escapeToChar);
        return i;
    }

    private final int appendHex(CharSequence source, int startPos) {
        int i = startPos + 4;
        if (i >= source.length()) {
            this.currentPosition = startPos;
            ensureHaveChars();
            if (this.currentPosition + 4 >= source.length()) {
                fail$default(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            return appendHex(source, this.currentPosition);
        }
        this.escapedString.append((char) ((fromHexChar(source, startPos) << 12) + (fromHexChar(source, startPos + 1) << 8) + (fromHexChar(source, startPos + 2) << 4) + fromHexChar(source, startPos + 3)));
        return i;
    }

    public static /* synthetic */ void require$kotlinx_serialization_json$default(AbstractJsonLexer abstractJsonLexer, boolean z, int i, Function0 message, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: require");
        }
        if ((i2 & 2) != 0) {
            i = abstractJsonLexer.currentPosition;
        }
        int i3 = i;
        Intrinsics.checkNotNullParameter(message, "message");
        if (z) {
            return;
        }
        fail$default(abstractJsonLexer, (String) message.invoke(), i3, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public final void require$kotlinx_serialization_json(boolean condition, int position, Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (condition) {
            return;
        }
        fail$default(this, message.invoke(), position, null, 4, null);
        throw new KotlinNothingValueException();
    }

    private final int fromHexChar(CharSequence source, int currentPosition) {
        char charAt = source.charAt(currentPosition);
        if ('0' <= charAt && charAt < ':') {
            return charAt - '0';
        }
        if ('a' <= charAt && charAt < 'g') {
            return charAt - 'W';
        }
        if ('A' <= charAt && charAt < 'G') {
            return charAt - '7';
        }
        fail$default(this, "Invalid toHexChar char '" + charAt + "' in unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final void skipElement(boolean allowLenientStrings) {
        AbstractJsonLexer abstractJsonLexer;
        ArrayList arrayList = new ArrayList();
        byte peekNextToken = peekNextToken();
        if (peekNextToken != 8 && peekNextToken != 6) {
            consumeStringLenient();
            return;
        }
        while (true) {
            byte peekNextToken2 = this.peekNextToken();
            if (peekNextToken2 != 1) {
                if (peekNextToken2 == 8 || peekNextToken2 == 6) {
                    abstractJsonLexer = this;
                    arrayList.add(Byte.valueOf(peekNextToken2));
                } else {
                    if (peekNextToken2 == 9) {
                        if (((Number) CollectionsKt.last((List) arrayList)).byteValue() != 8) {
                            throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found ] instead of } at path: " + this.path, this.getSource());
                        }
                        CollectionsKt.removeLast(arrayList);
                    } else if (peekNextToken2 == 7) {
                        if (((Number) CollectionsKt.last((List) arrayList)).byteValue() != 6) {
                            throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found } instead of ] at path: " + this.path, this.getSource());
                        }
                        CollectionsKt.removeLast(arrayList);
                    } else if (peekNextToken2 == 10) {
                        fail$default(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                    abstractJsonLexer = this;
                }
                abstractJsonLexer.consumeNextToken();
                if (arrayList.size() == 0) {
                    return;
                } else {
                    this = abstractJsonLexer;
                }
            } else if (allowLenientStrings) {
                this.consumeStringLenient();
            } else {
                this.consumeKeyString();
            }
        }
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) getSource()) + "', currentPosition=" + this.currentPosition + ')';
    }

    public final void failOnUnknownKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) substring(0, this.currentPosition), key, 0, false, 6, (Object) null);
        throw new JsonDecodingException("Encountered an unknown key '" + key + "' at offset " + lastIndexOf$default + " at path: " + this.path.getPath() + "\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder or '@JsonIgnoreUnknownKeys' annotation to ignore unknown keys.\nJSON input: " + ((Object) JsonExceptionsKt.minify(getSource(), lastIndexOf$default)));
    }

    public static /* synthetic */ Void fail$default(AbstractJsonLexer abstractJsonLexer, String str, int i, String str2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i2 & 2) != 0) {
            i = abstractJsonLexer.currentPosition;
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        return abstractJsonLexer.fail(str, i, str2);
    }

    public final Void fail(String message, int position, String hint) {
        String str;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(hint, "hint");
        if (hint.length() == 0) {
            str = "";
        } else {
            str = "\n" + hint;
        }
        throw JsonExceptionsKt.JsonDecodingException(position, message + " at path: " + this.path.getPath() + str, getSource());
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0137, code lost:
    
        if (r2 == r1) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0139, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x013c, code lost:
    
        if (r1 == r2) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x013e, code lost:
    
        if (r9 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0142, code lost:
    
        if (r1 == (r2 - 1)) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0144, code lost:
    
        if (r0 == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0146, code lost:
    
        if (r4 == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0150, code lost:
    
        if (getSource().charAt(r2) != '\"') goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0152, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0155, code lost:
    
        fail$default(r18, "Expected closing quotation mark", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0165, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0166, code lost:
    
        fail$default(r18, "EOF", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0176, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0177, code lost:
    
        r18.currentPosition = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x017b, code lost:
    
        if (r8 == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x017d, code lost:
    
        r1 = r10 * consumeNumericLiteral$calculateExponent(r12, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0187, code lost:
    
        if (r1 > 9.223372036854776E18d) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x018d, code lost:
    
        if (r1 < (-9.223372036854776E18d)) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0195, code lost:
    
        if (java.lang.Math.floor(r1) != r1) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0197, code lost:
    
        r10 = (long) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0199, code lost:
    
        fail$default(r18, "Can't convert " + r1 + " to Long", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b8, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b9, code lost:
    
        fail$default(r18, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01c9, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01ca, code lost:
    
        if (r9 == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01cc, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01d1, code lost:
    
        if (r10 == Long.MIN_VALUE) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d4, code lost:
    
        return -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d5, code lost:
    
        fail$default(r18, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01e5, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01e6, code lost:
    
        fail$default(r18, "Expected numeric literal", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01f6, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x013b, code lost:
    
        r4 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long consumeNumericLiteral() {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.AbstractJsonLexer.consumeNumericLiteral():long");
    }

    private static final double consumeNumericLiteral$calculateExponent(long j, boolean z) {
        if (!z) {
            return Math.pow(10.0d, -j);
        }
        if (!z) {
            throw new NoWhenBranchMatchedException();
        }
        return Math.pow(10.0d, j);
    }

    public final long consumeNumericLiteralFully() {
        long consumeNumericLiteral = consumeNumericLiteral();
        if (consumeNextToken() == 10) {
            return consumeNumericLiteral;
        }
        AbstractJsonLexerKt.tokenDescription((byte) 10);
        int i = this.currentPosition;
        int i2 = i - 1;
        fail$default(this, "Expected input to contain a single valid number, but got '" + ((i == getSource().length() || i2 < 0) ? "EOF" : String.valueOf(getSource().charAt(i2))) + "' after it", i2, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public final boolean consumeBoolean() {
        return consumeBoolean(skipWhitespaces());
    }

    public final boolean consumeBooleanLenient() {
        boolean z;
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces == getSource().length()) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (getSource().charAt(skipWhitespaces) == '\"') {
            skipWhitespaces++;
            z = true;
        } else {
            z = false;
        }
        boolean consumeBoolean = consumeBoolean(skipWhitespaces);
        if (!z) {
            return consumeBoolean;
        }
        if (this.currentPosition == getSource().length()) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (getSource().charAt(this.currentPosition) != '\"') {
            fail$default(this, "Expected closing quotation mark", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        this.currentPosition++;
        return consumeBoolean;
    }

    private final boolean consumeBoolean(int start) {
        int prefetchOrEof = prefetchOrEof(start);
        if (prefetchOrEof >= getSource().length() || prefetchOrEof == -1) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i = prefetchOrEof + 1;
        int charAt = getSource().charAt(prefetchOrEof) | ' ';
        if (charAt == 102) {
            consumeBooleanLiteral("alse", i);
            return false;
        }
        if (charAt == 116) {
            consumeBooleanLiteral("rue", i);
            return true;
        }
        fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final void consumeBooleanLiteral(String literalSuffix, int current) {
        if (getSource().length() - current < literalSuffix.length()) {
            fail$default(this, "Unexpected end of boolean literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int length = literalSuffix.length();
        for (int i = 0; i < length; i++) {
            if (literalSuffix.charAt(i) != (getSource().charAt(current + i) | ' ')) {
                fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
        }
        this.currentPosition = current + literalSuffix.length();
    }

    private final <T> T withPositionRollback(Function0<? extends T> action) {
        int i = this.currentPosition;
        try {
            return action.invoke();
        } finally {
            this.currentPosition = i;
        }
    }
}
