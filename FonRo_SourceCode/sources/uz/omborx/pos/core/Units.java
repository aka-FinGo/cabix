package uz.FonRo.pos.core;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Units.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0016\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0017\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0018\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u0019R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r0\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001b"}, d2 = {"Luz/FonRo/pos/core/Units;", "", "<init>", "()V", "NAMES", "", "", "WHOLE", "", "VOLUME", "LENGTH", "ALL", "", "Lkotlin/Pair;", "getALL", "()Ljava/util/List;", "RAW_ALL", "name", "unit", "rawName", "isWhole", "", "isMeasurable", "measureLabel", "stockUnits", "", FirebaseAnalytics.Param.QUANTITY, "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class Units {
    public static final int $stable = 0;
    public static final Units INSTANCE = new Units();
    private static final Map<String, String> NAMES = MapsKt.mapOf(TuplesKt.to("pcs", "шт"), TuplesKt.to("piece", "шт"), TuplesKt.to("pack", "уп"), TuplesKt.to("box", "кор"), TuplesKt.to("kg", "кг"), TuplesKt.to("g", "г"), TuplesKt.to("mg", "мг"), TuplesKt.to("lb", "фунт"), TuplesKt.to("oz", "унц"), TuplesKt.to("ton", "т"), TuplesKt.to("l", "л"), TuplesKt.to("ml", "мл"), TuplesKt.to("m", "м"), TuplesKt.to("cm", "см"), TuplesKt.to("mm", "мм"), TuplesKt.to("ft", "фут"), TuplesKt.to("yd", "ярд"), TuplesKt.to("mi", "миля"));
    private static final Set<String> WHOLE = SetsKt.setOf((Object[]) new String[]{"pcs", "piece", "pack", "box"});
    private static final Set<String> VOLUME = SetsKt.setOf((Object[]) new String[]{"l", "ml"});
    private static final Set<String> LENGTH = SetsKt.setOf((Object[]) new String[]{"m", "cm", "mm", "ft", "yd", "mi"});
    private static final List<Pair<String, String>> RAW_ALL = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("pcs", "шт"), TuplesKt.to("pack", "уп"), TuplesKt.to("box", "кор"), TuplesKt.to("kg", "кг"), TuplesKt.to("g", "г"), TuplesKt.to("ton", "т"), TuplesKt.to("l", "л"), TuplesKt.to("ml", "мл"), TuplesKt.to("m", "м"), TuplesKt.to("cm", "см")});

    private Units() {
    }

    public final List<Pair<String, String>> getALL() {
        List<Pair<String, String>> list = RAW_ALL;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList.add(TuplesKt.to(pair.getFirst(), LangKt.tx((String) pair.getSecond(), new Object[0])));
        }
        return arrayList;
    }

    public final String name(String unit) {
        String str;
        String tx;
        String obj;
        if (unit == null || (obj = StringsKt.trim((CharSequence) unit).toString()) == null) {
            str = null;
        } else {
            str = obj.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
        }
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            return LangKt.tx("шт", new Object[0]);
        }
        String str2 = NAMES.get(str);
        return (str2 == null || (tx = LangKt.tx(str2, new Object[0])) == null) ? str : tx;
    }

    public final String rawName(String unit) {
        String str;
        String obj;
        if (unit == null || (obj = StringsKt.trim((CharSequence) unit).toString()) == null) {
            str = null;
        } else {
            str = obj.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
        }
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            return "шт";
        }
        String str2 = NAMES.get(str);
        return str2 == null ? str : str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
    
        if (r0 == null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isWhole(java.lang.String r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L1b
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim(r1)
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L1b
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toLowerCase(r1)
            java.lang.String r1 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            if (r0 != 0) goto L1d
        L1b:
            java.lang.String r0 = "pcs"
        L1d:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 != 0) goto L27
            goto L2f
        L27:
            java.util.Set<java.lang.String> r1 = uz.FonRo.pos.core.Units.WHOLE
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L31
        L2f:
            r0 = 1
            return r0
        L31:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.core.Units.isWhole(java.lang.String):boolean");
    }

    public final boolean isMeasurable(String unit) {
        return !isWhole(unit);
    }

    public final String measureLabel(String unit) {
        String str;
        String obj;
        if (unit == null || (obj = StringsKt.trim((CharSequence) unit).toString()) == null) {
            str = null;
        } else {
            str = obj.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
        }
        if (str == null) {
            str = "";
        }
        return VOLUME.contains(str) ? LangKt.tx("Объём", new Object[0]) : LENGTH.contains(str) ? LangKt.tx("Длина", new Object[0]) : LangKt.tx("Вес", new Object[0]);
    }

    public final double stockUnits(String unit, double quantity) {
        return (!isWhole(unit) || quantity <= AudioStats.AUDIO_AMPLITUDE_NONE) ? AudioStats.AUDIO_AMPLITUDE_NONE : quantity;
    }
}
