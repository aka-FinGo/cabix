package kotlin.ranges;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.ULongProgression;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _URanges.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0003\u001a!\u0010\u0000\u001a\u00020\u0007*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\t\u001a\u001e\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a\u001e\u0010\n\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a!\u0010\u000b\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0003\u001a!\u0010\u000b\u001a\u00020\u0007*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\t\u001a\u001e\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a\u001e\u0010\f\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a%\u0010\r\u001a\u00020\u0001*\u00020\u000eH\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011¢\u0006\u0002\u0010\u000f\u001a%\u0010\r\u001a\u00020\u0007*\u00020\u0012H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011¢\u0006\u0002\u0010\u0013\u001a)\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0014H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u0015\u001a)\u0010\r\u001a\u00020\u0007*\u00020\u00122\u0006\u0010\r\u001a\u00020\u0014H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u0016\u001a\"\u0010\u0017\u001a\u0004\u0018\u00010\u0001*\u00020\u000eH\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011\u001a\"\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0012H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011\u001a&\u0010\u0017\u001a\u0004\u0018\u00010\u0001*\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0014H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a&\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u00122\u0006\u0010\r\u001a\u00020\u0014H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a/\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0087\u008a\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011¢\u0006\u0002\b\u001b\u001a/\u0010\u0018\u001a\u00020\u0019*\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0087\u008a\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011¢\u0006\u0002\b\u001c\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b\u001f\u0010 \u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b!\u0010\"\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b#\u0010$\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0007H\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b%\u0010&\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020'H\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b(\u0010)\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u00122\u0006\u0010\u001d\u001a\u00020'H\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b*\u0010+\u001a+\u0010,\u001a\u00020\u0002*\u00020\u001e2\u0006\u0010-\u001a\u00020\u001eH\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b.\u0010/\u001a+\u0010,\u001a\u00020\u0002*\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b0\u00101\u001a+\u0010,\u001a\u00020\b*\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b2\u00103\u001a+\u0010,\u001a\u00020\u0002*\u00020'2\u0006\u0010-\u001a\u00020'H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b4\u00105\u001a\u001c\u00106\u001a\u00020\u0002*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a\u001c\u00106\u001a\u00020\b*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a$\u00107\u001a\u00020\u0002*\u00020\u00022\u0006\u00107\u001a\u000208H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a$\u00107\u001a\u00020\b*\u00020\b2\u0006\u00107\u001a\u000209H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a+\u0010:\u001a\u00020\u000e*\u00020\u001e2\u0006\u0010-\u001a\u00020\u001eH\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b;\u0010<\u001a+\u0010:\u001a\u00020\u000e*\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b=\u0010>\u001a+\u0010:\u001a\u00020\u0012*\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b?\u0010@\u001a+\u0010:\u001a\u00020\u000e*\u00020'2\u0006\u0010-\u001a\u00020'H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bA\u0010B\u001a+\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010D\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bE\u0010F\u001a+\u0010C\u001a\u00020\u0007*\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bG\u0010H\u001a+\u0010C\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010D\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bI\u0010J\u001a+\u0010C\u001a\u00020'*\u00020'2\u0006\u0010D\u001a\u00020'H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bK\u0010L\u001a+\u0010M\u001a\u00020\u0001*\u00020\u00012\u0006\u0010N\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bO\u0010F\u001a+\u0010M\u001a\u00020\u0007*\u00020\u00072\u0006\u0010N\u001a\u00020\u0007H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bP\u0010H\u001a+\u0010M\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010N\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bQ\u0010J\u001a+\u0010M\u001a\u00020'*\u00020'2\u0006\u0010N\u001a\u00020'H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bR\u0010L\u001a3\u0010S\u001a\u00020\u0001*\u00020\u00012\u0006\u0010D\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bT\u0010U\u001a3\u0010S\u001a\u00020\u0007*\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u0007H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bV\u0010W\u001a3\u0010S\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010D\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bX\u0010Y\u001a3\u0010S\u001a\u00020'*\u00020'2\u0006\u0010D\u001a\u00020'2\u0006\u0010N\u001a\u00020'H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bZ\u0010[\u001a1\u0010S\u001a\u00020\u0001*\u00020\u00012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00010]H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b^\u0010_\u001a1\u0010S\u001a\u00020\u0007*\u00020\u00072\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00070]H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b`\u0010a¨\u0006b"}, d2 = {"first", "Lkotlin/UInt;", "Lkotlin/ranges/UIntProgression;", "(Lkotlin/ranges/UIntProgression;)I", "Lkotlin/SinceKotlin;", "version", "1.7", "Lkotlin/ULong;", "Lkotlin/ranges/ULongProgression;", "(Lkotlin/ranges/ULongProgression;)J", "firstOrNull", "last", "lastOrNull", "random", "Lkotlin/ranges/UIntRange;", "(Lkotlin/ranges/UIntRange;)I", "1.5", "Lkotlin/internal/InlineOnly;", "Lkotlin/ranges/ULongRange;", "(Lkotlin/ranges/ULongRange;)J", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "contains", "", "element", "contains-biwQdVI", "contains-GYNo2lE", "value", "Lkotlin/UByte;", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "Lkotlin/UShort;", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", TypedValues.TransitionType.S_TO, "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "coerceAtLeast", "minimumValue", "coerceAtLeast-J1ME1BU", "(II)I", "coerceAtLeast-eb3DHEI", "(JJ)J", "coerceAtLeast-Kr8caGY", "(BB)B", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-Kr8caGY", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-WZ9TVnA", "(III)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-VKSA0NQ", "(SSS)S", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/ranges/URangesKt")
/* loaded from: classes6.dex */
public class URangesKt___URangesKt {
    public static final int first(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            throw new NoSuchElementException("Progression " + uIntProgression + " is empty.");
        }
        return uIntProgression.getFirst();
    }

    public static final long first(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            throw new NoSuchElementException("Progression " + uLongProgression + " is empty.");
        }
        return uLongProgression.getFirst();
    }

    public static final UInt firstOrNull(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return UInt.m7964boximpl(uIntProgression.getFirst());
    }

    public static final ULong firstOrNull(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return ULong.m8043boximpl(uLongProgression.getFirst());
    }

    public static final int last(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            throw new NoSuchElementException("Progression " + uIntProgression + " is empty.");
        }
        return uIntProgression.getLast();
    }

    public static final long last(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            throw new NoSuchElementException("Progression " + uLongProgression + " is empty.");
        }
        return uLongProgression.getLast();
    }

    public static final UInt lastOrNull(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return UInt.m7964boximpl(uIntProgression.getLast());
    }

    public static final ULong lastOrNull(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return ULong.m8043boximpl(uLongProgression.getLast());
    }

    private static final int random(UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        return URangesKt.random(uIntRange, Random.INSTANCE);
    }

    private static final long random(ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        return URangesKt.random(uLongRange, Random.INSTANCE);
    }

    public static final int random(UIntRange uIntRange, Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextUInt(random, uIntRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final long random(ULongRange uLongRange, Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextULong(random, uLongRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    private static final UInt randomOrNull(UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        return URangesKt.randomOrNull(uIntRange, Random.INSTANCE);
    }

    private static final ULong randomOrNull(ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        return URangesKt.randomOrNull(uLongRange, Random.INSTANCE);
    }

    public static final UInt randomOrNull(UIntRange uIntRange, Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (uIntRange.isEmpty()) {
            return null;
        }
        return UInt.m7964boximpl(URandomKt.nextUInt(random, uIntRange));
    }

    public static final ULong randomOrNull(ULongRange uLongRange, Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (uLongRange.isEmpty()) {
            return null;
        }
        return ULong.m8043boximpl(URandomKt.nextULong(random, uLongRange));
    }

    /* renamed from: contains-biwQdVI, reason: not valid java name */
    private static final boolean m9208containsbiwQdVI(UIntRange contains, UInt uInt) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return uInt != null && contains.m9176containsWZ4Q5Ns(uInt.getData());
    }

    /* renamed from: contains-GYNo2lE, reason: not valid java name */
    private static final boolean m9204containsGYNo2lE(ULongRange contains, ULong uLong) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return uLong != null && contains.m9185containsVKZWuLQ(uLong.getData());
    }

    /* renamed from: contains-68kG9v0, reason: not valid java name */
    public static final boolean m9203contains68kG9v0(UIntRange contains, byte b) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m9176containsWZ4Q5Ns(UInt.m7970constructorimpl(b & 255));
    }

    /* renamed from: contains-ULb-yJY, reason: not valid java name */
    public static final boolean m9206containsULbyJY(ULongRange contains, byte b) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m9185containsVKZWuLQ(ULong.m8049constructorimpl(b & 255));
    }

    /* renamed from: contains-Gab390E, reason: not valid java name */
    public static final boolean m9205containsGab390E(ULongRange contains, int i) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m9185containsVKZWuLQ(ULong.m8049constructorimpl(i & 4294967295L));
    }

    /* renamed from: contains-fz5IDCE, reason: not valid java name */
    public static final boolean m9209containsfz5IDCE(UIntRange contains, long j) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return ULong.m8049constructorimpl(j >>> 32) == 0 && contains.m9176containsWZ4Q5Ns(UInt.m7970constructorimpl((int) j));
    }

    /* renamed from: contains-ZsK3CEQ, reason: not valid java name */
    public static final boolean m9207containsZsK3CEQ(UIntRange contains, short s) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m9176containsWZ4Q5Ns(UInt.m7970constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: contains-uhHAxoY, reason: not valid java name */
    public static final boolean m9210containsuhHAxoY(ULongRange contains, short s) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m9185containsVKZWuLQ(ULong.m8049constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: downTo-Kr8caGY, reason: not valid java name */
    public static final UIntProgression m9213downToKr8caGY(byte b, byte b2) {
        return UIntProgression.INSTANCE.m9173fromClosedRangeNkh28Cs(UInt.m7970constructorimpl(b & 255), UInt.m7970constructorimpl(b2 & 255), -1);
    }

    /* renamed from: downTo-J1ME1BU, reason: not valid java name */
    public static final UIntProgression m9212downToJ1ME1BU(int i, int i2) {
        return UIntProgression.INSTANCE.m9173fromClosedRangeNkh28Cs(i, i2, -1);
    }

    /* renamed from: downTo-eb3DHEI, reason: not valid java name */
    public static final ULongProgression m9214downToeb3DHEI(long j, long j2) {
        return ULongProgression.INSTANCE.m9182fromClosedRange7ftBX0g(j, j2, -1L);
    }

    /* renamed from: downTo-5PvTz6A, reason: not valid java name */
    public static final UIntProgression m9211downTo5PvTz6A(short s, short s2) {
        return UIntProgression.INSTANCE.m9173fromClosedRangeNkh28Cs(UInt.m7970constructorimpl(s & UShort.MAX_VALUE), UInt.m7970constructorimpl(s2 & UShort.MAX_VALUE), -1);
    }

    public static final UIntProgression reversed(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        return UIntProgression.INSTANCE.m9173fromClosedRangeNkh28Cs(uIntProgression.getLast(), uIntProgression.getFirst(), -uIntProgression.getStep());
    }

    public static final ULongProgression reversed(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        return ULongProgression.INSTANCE.m9182fromClosedRange7ftBX0g(uLongProgression.getLast(), uLongProgression.getFirst(), -uLongProgression.getStep());
    }

    public static final UIntProgression step(UIntProgression uIntProgression, int i) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        UIntProgression.Companion companion = UIntProgression.INSTANCE;
        int first = uIntProgression.getFirst();
        int last = uIntProgression.getLast();
        if (uIntProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.m9173fromClosedRangeNkh28Cs(first, last, i);
    }

    public static final ULongProgression step(ULongProgression uLongProgression, long j) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        RangesKt.checkStepIsPositive(j > 0, Long.valueOf(j));
        ULongProgression.Companion companion = ULongProgression.INSTANCE;
        long first = uLongProgression.getFirst();
        long last = uLongProgression.getLast();
        if (uLongProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.m9182fromClosedRange7ftBX0g(first, last, j);
    }

    /* renamed from: until-Kr8caGY, reason: not valid java name */
    public static final UIntRange m9217untilKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b2 & 255, 0) <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange(UInt.m7970constructorimpl(b & 255), UInt.m7970constructorimpl(UInt.m7970constructorimpl(r3) - 1), null);
    }

    /* renamed from: until-J1ME1BU, reason: not valid java name */
    public static final UIntRange m9216untilJ1ME1BU(int i, int i2) {
        int compare;
        compare = Integer.compare(i2 ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
        return compare <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange(i, UInt.m7970constructorimpl(i2 - 1), null);
    }

    /* renamed from: until-eb3DHEI, reason: not valid java name */
    public static final ULongRange m9218untileb3DHEI(long j, long j2) {
        int compare;
        compare = Long.compare(j2 ^ Long.MIN_VALUE, 0 ^ Long.MIN_VALUE);
        return compare <= 0 ? ULongRange.INSTANCE.getEMPTY() : new ULongRange(j, ULong.m8049constructorimpl(j2 - ULong.m8049constructorimpl(1L)), null);
    }

    /* renamed from: until-5PvTz6A, reason: not valid java name */
    public static final UIntRange m9215until5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s2 & UShort.MAX_VALUE, 0) <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange(UInt.m7970constructorimpl(s & UShort.MAX_VALUE), UInt.m7970constructorimpl(UInt.m7970constructorimpl(r3) - 1), null);
    }

    /* renamed from: coerceAtLeast-J1ME1BU, reason: not valid java name */
    public static final int m9190coerceAtLeastJ1ME1BU(int i, int i2) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
        return compare < 0 ? i2 : i;
    }

    /* renamed from: coerceAtLeast-eb3DHEI, reason: not valid java name */
    public static final long m9192coerceAtLeasteb3DHEI(long j, long j2) {
        int compare;
        compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
        return compare < 0 ? j2 : j;
    }

    /* renamed from: coerceAtLeast-Kr8caGY, reason: not valid java name */
    public static final byte m9191coerceAtLeastKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) < 0 ? b2 : b;
    }

    /* renamed from: coerceAtLeast-5PvTz6A, reason: not valid java name */
    public static final short m9189coerceAtLeast5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) < 0 ? s2 : s;
    }

    /* renamed from: coerceAtMost-J1ME1BU, reason: not valid java name */
    public static final int m9194coerceAtMostJ1ME1BU(int i, int i2) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
        return compare > 0 ? i2 : i;
    }

    /* renamed from: coerceAtMost-eb3DHEI, reason: not valid java name */
    public static final long m9196coerceAtMosteb3DHEI(long j, long j2) {
        int compare;
        compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
        return compare > 0 ? j2 : j;
    }

    /* renamed from: coerceAtMost-Kr8caGY, reason: not valid java name */
    public static final byte m9195coerceAtMostKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) > 0 ? b2 : b;
    }

    /* renamed from: coerceAtMost-5PvTz6A, reason: not valid java name */
    public static final short m9193coerceAtMost5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) > 0 ? s2 : s;
    }

    /* renamed from: coerceIn-WZ9TVnA, reason: not valid java name */
    public static final int m9199coerceInWZ9TVnA(int i, int i2, int i3) {
        int compare;
        int compare2;
        int compare3;
        compare = Integer.compare(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE);
        if (compare > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UInt.m8016toStringimpl(i3)) + " is less than minimum " + ((Object) UInt.m8016toStringimpl(i2)) + '.');
        }
        compare2 = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
        if (compare2 < 0) {
            return i2;
        }
        compare3 = Integer.compare(i ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE);
        return compare3 > 0 ? i3 : i;
    }

    /* renamed from: coerceIn-sambcqE, reason: not valid java name */
    public static final long m9201coerceInsambcqE(long j, long j2, long j3) {
        int compare;
        int compare2;
        int compare3;
        compare = Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE);
        if (compare > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) ULong.m8095toStringimpl(j3)) + " is less than minimum " + ((Object) ULong.m8095toStringimpl(j2)) + '.');
        }
        compare2 = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
        if (compare2 < 0) {
            return j2;
        }
        compare3 = Long.compare(j ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE);
        return compare3 > 0 ? j3 : j;
    }

    /* renamed from: coerceIn-b33U2AM, reason: not valid java name */
    public static final byte m9200coerceInb33U2AM(byte b, byte b2, byte b3) {
        int i = b2 & 255;
        int i2 = b3 & 255;
        if (Intrinsics.compare(i, i2) <= 0) {
            int i3 = b & 255;
            return Intrinsics.compare(i3, i) < 0 ? b2 : Intrinsics.compare(i3, i2) > 0 ? b3 : b;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UByte.m7932toStringimpl(b3)) + " is less than minimum " + ((Object) UByte.m7932toStringimpl(b2)) + '.');
    }

    /* renamed from: coerceIn-VKSA0NQ, reason: not valid java name */
    public static final short m9198coerceInVKSA0NQ(short s, short s2, short s3) {
        int i = s2 & UShort.MAX_VALUE;
        int i2 = s3 & UShort.MAX_VALUE;
        if (Intrinsics.compare(i, i2) <= 0) {
            int i3 = 65535 & s;
            return Intrinsics.compare(i3, i) < 0 ? s2 : Intrinsics.compare(i3, i2) > 0 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UShort.m8200toStringimpl(s3)) + " is less than minimum " + ((Object) UShort.m8200toStringimpl(s2)) + '.');
    }

    /* renamed from: coerceIn-wuiCnnA, reason: not valid java name */
    public static final int m9202coerceInwuiCnnA(int i, ClosedRange<UInt> range) {
        int compare;
        int compare2;
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((UInt) RangesKt.coerceIn(UInt.m7964boximpl(i), (ClosedFloatingPointRange<UInt>) range)).getData();
        }
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        compare = Integer.compare(i ^ Integer.MIN_VALUE, range.getStart().getData() ^ Integer.MIN_VALUE);
        if (compare < 0) {
            return range.getStart().getData();
        }
        compare2 = Integer.compare(i ^ Integer.MIN_VALUE, range.getEndInclusive().getData() ^ Integer.MIN_VALUE);
        return compare2 > 0 ? range.getEndInclusive().getData() : i;
    }

    /* renamed from: coerceIn-JPwROB0, reason: not valid java name */
    public static final long m9197coerceInJPwROB0(long j, ClosedRange<ULong> range) {
        int compare;
        int compare2;
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((ULong) RangesKt.coerceIn(ULong.m8043boximpl(j), (ClosedFloatingPointRange<ULong>) range)).getData();
        }
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        compare = Long.compare(j ^ Long.MIN_VALUE, range.getStart().getData() ^ Long.MIN_VALUE);
        if (compare < 0) {
            return range.getStart().getData();
        }
        compare2 = Long.compare(j ^ Long.MIN_VALUE, range.getEndInclusive().getData() ^ Long.MIN_VALUE);
        return compare2 > 0 ? range.getEndInclusive().getData() : j;
    }
}
