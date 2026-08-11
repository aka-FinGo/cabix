package kotlin.collections.unsigned;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _UArraysJvm.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000b¢\u0006\u0004\b\u0005\u0010\u0006\u001a3\u0010\u0000\u001a\u00020\f*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001a3\u0010\u0000\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000b¢\u0006\u0004\b\u0012\u0010\u0013\u001a3\u0010\u0000\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000b¢\u0006\u0004\b\u0016\u0010\u0017\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0019*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b\u001a\u0010\u001b\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0019*\u00020\rH\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b\u001c\u0010\u001d\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019*\u00020\u0011H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b\u001e\u0010\u001f\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019*\u00020\u0015H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b \u0010!\u001aC\u0010\"\u001a\u00020\u0004*\u00020\u00022\u0006\u0010#\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b&\u0010'\u001aC\u0010\"\u001a\u00020\u0004*\u00020\r2\u0006\u0010#\u001a\u00020\f2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b(\u0010)\u001aC\u0010\"\u001a\u00020\u0004*\u00020\u00112\u0006\u0010#\u001a\u00020\u00102\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b*\u0010+\u001aC\u0010\"\u001a\u00020\u0004*\u00020\u00152\u0006\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b,\u0010-\u001aw\u0010.\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b/\u00100\u001aw\u0010.\u001a\u0004\u0018\u00010\f*\u00020\rH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b@\u0010A\u001aw\u0010.\u001a\u0004\u0018\u00010\u0010*\u00020\u0011H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bB\u0010C\u001aw\u0010.\u001a\u0004\u0018\u00010\u0014*\u00020\u0015H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bD\u0010E\u001a¢\u0001\u0010F\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00022\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(M\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(N\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001a¢\u0001\u0010F\u001a\u0004\u0018\u00010\f\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\r2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(M\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(N\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a¢\u0001\u0010F\u001a\u0004\u0018\u00010\u0010\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00112\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(M\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(N\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a¢\u0001\u0010F\u001a\u0004\u0018\u00010\u0014\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00152\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(M\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(N\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u0093\u0001\u0010U\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b([\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(\\\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bY\u0010Z\u001a\u0093\u0001\u0010U\u001a\u0004\u0018\u00010\f*\u00020\r2\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\f0Wj\n\u0012\u0006\b\u0000\u0012\u00020\f`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b([\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(\\\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b]\u0010^\u001a\u0093\u0001\u0010U\u001a\u0004\u0018\u00010\u0010*\u00020\u00112\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00100Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0010`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b([\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(\\\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\b_\u0010`\u001a\u0093\u0001\u0010U\u001a\u0004\u0018\u00010\u0014*\u00020\u00152\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00140Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0014`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b([\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(\\\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\ba\u0010b\u001aw\u0010c\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(e\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(f\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bd\u00100\u001aw\u0010c\u001a\u0004\u0018\u00010\f*\u00020\rH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(e\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(f\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bg\u0010A\u001aw\u0010c\u001a\u0004\u0018\u00010\u0010*\u00020\u0011H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(e\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(f\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bh\u0010C\u001aw\u0010c\u001a\u0004\u0018\u00010\u0014*\u00020\u0015H\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(e\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(f\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bi\u0010E\u001a¢\u0001\u0010j\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00022\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(l\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(m\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bk\u0010L\u001a¢\u0001\u0010j\u001a\u0004\u0018\u00010\f\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\r2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(l\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(m\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bn\u0010P\u001a¢\u0001\u0010j\u001a\u0004\u0018\u00010\u0010\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00112\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(l\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(m\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bo\u0010R\u001a¢\u0001\u0010j\u001a\u0004\u0018\u00010\u0014\"\u000e\b\u0000\u0010G*\b\u0012\u0004\u0012\u0002HG0H*\u00020\u00152\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002HG0JH\u0087\u0088\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(l\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(m\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bp\u0010T\u001a\u0093\u0001\u0010q\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(s\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(t\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\br\u0010Z\u001a\u0093\u0001\u0010q\u001a\u0004\u0018\u00010\f*\u00020\r2\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\f0Wj\n\u0012\u0006\b\u0000\u0012\u00020\f`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(s\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(t\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bu\u0010^\u001a\u0093\u0001\u0010q\u001a\u0004\u0018\u00010\u0010*\u00020\u00112\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00100Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0010`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(s\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(t\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bv\u0010`\u001a\u0093\u0001\u0010q\u001a\u0004\u0018\u00010\u0014*\u00020\u00152\u001a\u0010V\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00140Wj\n\u0012\u0006\b\u0000\u0012\u00020\u0014`XH\u0087\u0080\u0004b*\b1\u0012\b\b2\u0012\u0004\b\b(s\u0012\u001c\b4\u0012\u0018\b\u000bB\u0014\b5\u0012\b\b6\u0012\u0004\b\b(t\u0012\u0006\b8\u0012\u0002\b\fb \b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\b\b<\u0012\u0004\b\b(=\u0012\b\b>\u0012\u0004\b\b(?b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0004\bw\u0010b\u001aT\u0010x\u001a\u00020y*\u00020\u00022\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020y0JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\f\b}\u0012\b\b~\u0012\u0004\b\b(zb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bz\u0010{\u001aT\u0010x\u001a\u00020y*\u00020\r2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020y0JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\f\b}\u0012\b\b~\u0012\u0004\b\b(zb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\bz\u0010\u007f\u001aU\u0010x\u001a\u00020y*\u00020\u00112\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020y0JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\f\b}\u0012\b\b~\u0012\u0004\b\b(zb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0005\bz\u0010\u0080\u0001\u001aU\u0010x\u001a\u00020y*\u00020\u00152\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020y0JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\f\b}\u0012\b\b~\u0012\u0004\b\b(zb\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0005\bz\u0010\u0081\u0001\u001aY\u0010x\u001a\u00030\u0082\u0001*\u00020\u00022\u0013\u0010I\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0012\u0005\u0012\u00030\u0082\u00010JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001b\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001\u001aY\u0010x\u001a\u00030\u0082\u0001*\u00020\r2\u0013\u0010I\u001a\u000f\u0012\u0004\u0012\u00020\f\u0012\u0005\u0012\u00030\u0082\u00010JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001b\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0085\u0001\u001aY\u0010x\u001a\u00030\u0082\u0001*\u00020\u00112\u0013\u0010I\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0005\u0012\u00030\u0082\u00010JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001b\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0086\u0001\u001aY\u0010x\u001a\u00030\u0082\u0001*\u00020\u00152\u0013\u0010I\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0005\u0012\u00030\u0082\u00010JH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;b\u0002\b|b\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001b\u0002\b\nb\u0002\b\u000bø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0087\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0088\u0001"}, d2 = {"elementAt", "Lkotlin/UInt;", "Lkotlin/UIntArray;", FirebaseAnalytics.Param.INDEX, "", "elementAt-qFRl0hI", "([II)I", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/ExperimentalUnsignedTypes;", "Lkotlin/internal/InlineOnly;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "elementAt-r7IrZao", "([JI)J", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "elementAt-PpDY95g", "([BI)B", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "elementAt-nggk6HY", "([SI)S", "asList", "", "asList--ajY-9A", "([I)Ljava/util/List;", "asList-QwZRm1k", "([J)Ljava/util/List;", "asList-GBYM_sE", "([B)Ljava/util/List;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "element", "fromIndex", "toIndex", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-EtDCXyQ", "([SSII)I", "max", "max--ajY-9A", "([I)Lkotlin/UInt;", "Lkotlin/Deprecated;", "message", "Use maxOrNull instead.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "this.maxOrNull()", "imports", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "1.4", "errorSince", "1.5", "hiddenSince", "1.6", "max-QwZRm1k", "([J)Lkotlin/ULong;", "max-GBYM_sE", "([B)Lkotlin/UByte;", "max-rL5Bavg", "([S)Lkotlin/UShort;", "maxBy", "R", "", "selector", "Lkotlin/Function1;", "maxBy-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Lkotlin/UInt;", "Use maxByOrNull instead.", "this.maxByOrNull(selector)", "maxBy-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Lkotlin/ULong;", "maxBy-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Lkotlin/UByte;", "maxBy-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Lkotlin/UShort;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "maxWith-YmdZ_VM", "([ILjava/util/Comparator;)Lkotlin/UInt;", "Use maxWithOrNull instead.", "this.maxWithOrNull(comparator)", "maxWith-zrEWJaI", "([JLjava/util/Comparator;)Lkotlin/ULong;", "maxWith-XMRcp5o", "([BLjava/util/Comparator;)Lkotlin/UByte;", "maxWith-eOHTfZs", "([SLjava/util/Comparator;)Lkotlin/UShort;", "min", "min--ajY-9A", "Use minOrNull instead.", "this.minOrNull()", "min-QwZRm1k", "min-GBYM_sE", "min-rL5Bavg", "minBy", "minBy-jgv0xPQ", "Use minByOrNull instead.", "this.minByOrNull(selector)", "minBy-MShoTSo", "minBy-JOV_ifY", "minBy-xTcfx_M", "minWith", "minWith-YmdZ_VM", "Use minWithOrNull instead.", "this.minWithOrNull(comparator)", "minWith-zrEWJaI", "minWith-XMRcp5o", "minWith-eOHTfZs", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Lkotlin/OverloadResolutionByLambdaReturnType;", "Lkotlin/jvm/JvmName;", "name", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, pn = "kotlin.collections", xi = 49, xs = "kotlin/collections/unsigned/UArraysKt")
/* loaded from: classes6.dex */
public class UArraysKt___UArraysJvmKt {
    /* renamed from: elementAt-qFRl0hI, reason: not valid java name */
    private static final int m8360elementAtqFRl0hI(int[] elementAt, int i) {
        Intrinsics.checkNotNullParameter(elementAt, "$this$elementAt");
        return UIntArray.m8030getpVg5ArA(elementAt, i);
    }

    /* renamed from: elementAt-r7IrZao, reason: not valid java name */
    private static final long m8361elementAtr7IrZao(long[] elementAt, int i) {
        Intrinsics.checkNotNullParameter(elementAt, "$this$elementAt");
        return ULongArray.m8109getsVKNKU(elementAt, i);
    }

    /* renamed from: elementAt-PpDY95g, reason: not valid java name */
    private static final byte m8358elementAtPpDY95g(byte[] elementAt, int i) {
        Intrinsics.checkNotNullParameter(elementAt, "$this$elementAt");
        return UByteArray.m7951getw2LRezQ(elementAt, i);
    }

    /* renamed from: elementAt-nggk6HY, reason: not valid java name */
    private static final short m8359elementAtnggk6HY(short[] elementAt, int i) {
        Intrinsics.checkNotNullParameter(elementAt, "$this$elementAt");
        return UShortArray.m8214getMh2AYeg(elementAt, i);
    }

    /* renamed from: asList--ajY-9A, reason: not valid java name */
    public static final List<UInt> m8346asListajY9A(int[] asList) {
        Intrinsics.checkNotNullParameter(asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$1(asList);
    }

    /* renamed from: asList-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m8348asListQwZRm1k(long[] asList) {
        Intrinsics.checkNotNullParameter(asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$2(asList);
    }

    /* renamed from: asList-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m8347asListGBYM_sE(byte[] asList) {
        Intrinsics.checkNotNullParameter(asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$3(asList);
    }

    /* renamed from: asList-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m8349asListrL5Bavg(short[] asList) {
        Intrinsics.checkNotNullParameter(asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$4(asList);
    }

    /* renamed from: binarySearch-2fe2U9s$default, reason: not valid java name */
    public static /* synthetic */ int m8351binarySearch2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m8031getSizeimpl(iArr);
        }
        return UArraysKt.m8350binarySearch2fe2U9s(iArr, i, i2, i3);
    }

    /* renamed from: binarySearch-2fe2U9s, reason: not valid java name */
    public static final int m8350binarySearch2fe2U9s(int[] binarySearch, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i2, i3, UIntArray.m8031getSizeimpl(binarySearch));
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(binarySearch[i5], i);
            if (uintCompare < 0) {
                i2 = i5 + 1;
            } else {
                if (uintCompare <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* renamed from: binarySearch-K6DWlUc$default, reason: not valid java name */
    public static /* synthetic */ int m8355binarySearchK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m8110getSizeimpl(jArr);
        }
        return UArraysKt.m8354binarySearchK6DWlUc(jArr, j, i, i2);
    }

    /* renamed from: binarySearch-K6DWlUc, reason: not valid java name */
    public static final int m8354binarySearchK6DWlUc(long[] binarySearch, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, ULongArray.m8110getSizeimpl(binarySearch));
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int ulongCompare = UnsignedKt.ulongCompare(binarySearch[i4], j);
            if (ulongCompare < 0) {
                i = i4 + 1;
            } else {
                if (ulongCompare <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: binarySearch-WpHrYlw$default, reason: not valid java name */
    public static /* synthetic */ int m8357binarySearchWpHrYlw$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m7952getSizeimpl(bArr);
        }
        return UArraysKt.m8356binarySearchWpHrYlw(bArr, b, i, i2);
    }

    /* renamed from: binarySearch-WpHrYlw, reason: not valid java name */
    public static final int m8356binarySearchWpHrYlw(byte[] binarySearch, byte b, int i, int i2) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, UByteArray.m7952getSizeimpl(binarySearch));
        int i3 = b & 255;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(binarySearch[i5], i3);
            if (uintCompare < 0) {
                i = i5 + 1;
            } else {
                if (uintCompare <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: binarySearch-EtDCXyQ$default, reason: not valid java name */
    public static /* synthetic */ int m8353binarySearchEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m8215getSizeimpl(sArr);
        }
        return UArraysKt.m8352binarySearchEtDCXyQ(sArr, s, i, i2);
    }

    /* renamed from: binarySearch-EtDCXyQ, reason: not valid java name */
    public static final int m8352binarySearchEtDCXyQ(short[] binarySearch, short s, int i, int i2) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, UShortArray.m8215getSizeimpl(binarySearch));
        int i3 = s & UShort.MAX_VALUE;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(binarySearch[i5], i3);
            if (uintCompare < 0) {
                i = i5 + 1;
            } else {
                if (uintCompare <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i + 1);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ UInt m8362maxajY9A(int[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        return UArraysKt.m8757maxOrNullajY9A(max);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ ULong m8364maxQwZRm1k(long[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        return UArraysKt.m8759maxOrNullQwZRm1k(max);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ UByte m8363maxGBYM_sE(byte[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        return UArraysKt.m8758maxOrNullGBYM_sE(max);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ UShort m8365maxrL5Bavg(short[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        return UArraysKt.m8760maxOrNullrL5Bavg(max);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy-jgv0xPQ, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m8368maxByjgv0xPQ(int[] maxBy, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxBy, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m8033isEmptyimpl(maxBy)) {
            return null;
        }
        int m8030getpVg5ArA = UIntArray.m8030getpVg5ArA(maxBy, 0);
        int lastIndex = ArraysKt.getLastIndex(maxBy);
        if (lastIndex == 0) {
            return UInt.m7964boximpl(m8030getpVg5ArA);
        }
        R invoke = selector.invoke(UInt.m7964boximpl(m8030getpVg5ArA));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int m8030getpVg5ArA2 = UIntArray.m8030getpVg5ArA(maxBy, i);
                R invoke2 = selector.invoke(UInt.m7964boximpl(m8030getpVg5ArA2));
                if (invoke.compareTo(invoke2) < 0) {
                    m8030getpVg5ArA = m8030getpVg5ArA2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m7964boximpl(m8030getpVg5ArA);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy-MShoTSo, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m8367maxByMShoTSo(long[] maxBy, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxBy, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m8112isEmptyimpl(maxBy)) {
            return null;
        }
        long m8109getsVKNKU = ULongArray.m8109getsVKNKU(maxBy, 0);
        int lastIndex = ArraysKt.getLastIndex(maxBy);
        if (lastIndex == 0) {
            return ULong.m8043boximpl(m8109getsVKNKU);
        }
        R invoke = selector.invoke(ULong.m8043boximpl(m8109getsVKNKU));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long m8109getsVKNKU2 = ULongArray.m8109getsVKNKU(maxBy, i);
                R invoke2 = selector.invoke(ULong.m8043boximpl(m8109getsVKNKU2));
                if (invoke.compareTo(invoke2) < 0) {
                    m8109getsVKNKU = m8109getsVKNKU2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m8043boximpl(m8109getsVKNKU);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy-JOV_ifY, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m8366maxByJOV_ifY(byte[] maxBy, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxBy, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m7954isEmptyimpl(maxBy)) {
            return null;
        }
        byte m7951getw2LRezQ = UByteArray.m7951getw2LRezQ(maxBy, 0);
        int lastIndex = ArraysKt.getLastIndex(maxBy);
        if (lastIndex == 0) {
            return UByte.m7882boximpl(m7951getw2LRezQ);
        }
        R invoke = selector.invoke(UByte.m7882boximpl(m7951getw2LRezQ));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte m7951getw2LRezQ2 = UByteArray.m7951getw2LRezQ(maxBy, i);
                R invoke2 = selector.invoke(UByte.m7882boximpl(m7951getw2LRezQ2));
                if (invoke.compareTo(invoke2) < 0) {
                    m7951getw2LRezQ = m7951getw2LRezQ2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m7882boximpl(m7951getw2LRezQ);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy-xTcfx_M, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m8369maxByxTcfx_M(short[] maxBy, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(maxBy, "$this$maxBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m8217isEmptyimpl(maxBy)) {
            return null;
        }
        short m8214getMh2AYeg = UShortArray.m8214getMh2AYeg(maxBy, 0);
        int lastIndex = ArraysKt.getLastIndex(maxBy);
        if (lastIndex == 0) {
            return UShort.m8150boximpl(m8214getMh2AYeg);
        }
        R invoke = selector.invoke(UShort.m8150boximpl(m8214getMh2AYeg));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short m8214getMh2AYeg2 = UShortArray.m8214getMh2AYeg(maxBy, i);
                R invoke2 = selector.invoke(UShort.m8150boximpl(m8214getMh2AYeg2));
                if (invoke.compareTo(invoke2) < 0) {
                    m8214getMh2AYeg = m8214getMh2AYeg2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m8150boximpl(m8214getMh2AYeg);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ UInt m8371maxWithYmdZ_VM(int[] maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m8766maxWithOrNullYmdZ_VM(maxWith, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ ULong m8373maxWithzrEWJaI(long[] maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m8768maxWithOrNullzrEWJaI(maxWith, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ UByte m8370maxWithXMRcp5o(byte[] maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m8765maxWithOrNullXMRcp5o(maxWith, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ UShort m8372maxWitheOHTfZs(short[] maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m8767maxWithOrNulleOHTfZs(maxWith, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ UInt m8374minajY9A(int[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        return UArraysKt.m8813minOrNullajY9A(min);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ ULong m8376minQwZRm1k(long[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        return UArraysKt.m8815minOrNullQwZRm1k(min);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ UByte m8375minGBYM_sE(byte[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        return UArraysKt.m8814minOrNullGBYM_sE(min);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ UShort m8377minrL5Bavg(short[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        return UArraysKt.m8816minOrNullrL5Bavg(min);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy-jgv0xPQ, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m8380minByjgv0xPQ(int[] minBy, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minBy, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m8033isEmptyimpl(minBy)) {
            return null;
        }
        int m8030getpVg5ArA = UIntArray.m8030getpVg5ArA(minBy, 0);
        int lastIndex = ArraysKt.getLastIndex(minBy);
        if (lastIndex == 0) {
            return UInt.m7964boximpl(m8030getpVg5ArA);
        }
        R invoke = selector.invoke(UInt.m7964boximpl(m8030getpVg5ArA));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int m8030getpVg5ArA2 = UIntArray.m8030getpVg5ArA(minBy, i);
                R invoke2 = selector.invoke(UInt.m7964boximpl(m8030getpVg5ArA2));
                if (invoke.compareTo(invoke2) > 0) {
                    m8030getpVg5ArA = m8030getpVg5ArA2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m7964boximpl(m8030getpVg5ArA);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy-MShoTSo, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m8379minByMShoTSo(long[] minBy, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minBy, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m8112isEmptyimpl(minBy)) {
            return null;
        }
        long m8109getsVKNKU = ULongArray.m8109getsVKNKU(minBy, 0);
        int lastIndex = ArraysKt.getLastIndex(minBy);
        if (lastIndex == 0) {
            return ULong.m8043boximpl(m8109getsVKNKU);
        }
        R invoke = selector.invoke(ULong.m8043boximpl(m8109getsVKNKU));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long m8109getsVKNKU2 = ULongArray.m8109getsVKNKU(minBy, i);
                R invoke2 = selector.invoke(ULong.m8043boximpl(m8109getsVKNKU2));
                if (invoke.compareTo(invoke2) > 0) {
                    m8109getsVKNKU = m8109getsVKNKU2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m8043boximpl(m8109getsVKNKU);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy-JOV_ifY, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m8378minByJOV_ifY(byte[] minBy, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minBy, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m7954isEmptyimpl(minBy)) {
            return null;
        }
        byte m7951getw2LRezQ = UByteArray.m7951getw2LRezQ(minBy, 0);
        int lastIndex = ArraysKt.getLastIndex(minBy);
        if (lastIndex == 0) {
            return UByte.m7882boximpl(m7951getw2LRezQ);
        }
        R invoke = selector.invoke(UByte.m7882boximpl(m7951getw2LRezQ));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte m7951getw2LRezQ2 = UByteArray.m7951getw2LRezQ(minBy, i);
                R invoke2 = selector.invoke(UByte.m7882boximpl(m7951getw2LRezQ2));
                if (invoke.compareTo(invoke2) > 0) {
                    m7951getw2LRezQ = m7951getw2LRezQ2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m7882boximpl(m7951getw2LRezQ);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy-xTcfx_M, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m8381minByxTcfx_M(short[] minBy, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(minBy, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m8217isEmptyimpl(minBy)) {
            return null;
        }
        short m8214getMh2AYeg = UShortArray.m8214getMh2AYeg(minBy, 0);
        int lastIndex = ArraysKt.getLastIndex(minBy);
        if (lastIndex == 0) {
            return UShort.m8150boximpl(m8214getMh2AYeg);
        }
        R invoke = selector.invoke(UShort.m8150boximpl(m8214getMh2AYeg));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short m8214getMh2AYeg2 = UShortArray.m8214getMh2AYeg(minBy, i);
                R invoke2 = selector.invoke(UShort.m8150boximpl(m8214getMh2AYeg2));
                if (invoke.compareTo(invoke2) > 0) {
                    m8214getMh2AYeg = m8214getMh2AYeg2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m8150boximpl(m8214getMh2AYeg);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ UInt m8383minWithYmdZ_VM(int[] minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m8822minWithOrNullYmdZ_VM(minWith, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ ULong m8385minWithzrEWJaI(long[] minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m8824minWithOrNullzrEWJaI(minWith, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ UByte m8382minWithXMRcp5o(byte[] minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m8821minWithOrNullXMRcp5o(minWith, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ UShort m8384minWitheOHTfZs(short[] minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m8823minWithOrNulleOHTfZs(minWith, comparator);
    }

    private static final BigDecimal sumOfBigDecimal(int[] sumOf, Function1<? super UInt, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m8031getSizeimpl = UIntArray.m8031getSizeimpl(sumOf);
        for (int i = 0; i < m8031getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UInt.m7964boximpl(UIntArray.m8030getpVg5ArA(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigDecimal sumOfBigDecimal(long[] sumOf, Function1<? super ULong, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m8110getSizeimpl = ULongArray.m8110getSizeimpl(sumOf);
        for (int i = 0; i < m8110getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(ULong.m8043boximpl(ULongArray.m8109getsVKNKU(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigDecimal sumOfBigDecimal(byte[] sumOf, Function1<? super UByte, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m7952getSizeimpl = UByteArray.m7952getSizeimpl(sumOf);
        for (int i = 0; i < m7952getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UByte.m7882boximpl(UByteArray.m7951getw2LRezQ(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigDecimal sumOfBigDecimal(short[] sumOf, Function1<? super UShort, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m8215getSizeimpl = UShortArray.m8215getSizeimpl(sumOf);
        for (int i = 0; i < m8215getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UShort.m8150boximpl(UShortArray.m8214getMh2AYeg(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(int[] sumOf, Function1<? super UInt, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m8031getSizeimpl = UIntArray.m8031getSizeimpl(sumOf);
        for (int i = 0; i < m8031getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UInt.m7964boximpl(UIntArray.m8030getpVg5ArA(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(long[] sumOf, Function1<? super ULong, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m8110getSizeimpl = ULongArray.m8110getSizeimpl(sumOf);
        for (int i = 0; i < m8110getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(ULong.m8043boximpl(ULongArray.m8109getsVKNKU(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(byte[] sumOf, Function1<? super UByte, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m7952getSizeimpl = UByteArray.m7952getSizeimpl(sumOf);
        for (int i = 0; i < m7952getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UByte.m7882boximpl(UByteArray.m7951getw2LRezQ(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(short[] sumOf, Function1<? super UShort, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m8215getSizeimpl = UShortArray.m8215getSizeimpl(sumOf);
        for (int i = 0; i < m8215getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UShort.m8150boximpl(UShortArray.m8214getMh2AYeg(sumOf, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }
}
