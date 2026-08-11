package uz.FonRo.pos.ui.orders;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.ui.theme.Ox;

/* compiled from: StoreLocationMap.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a}\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007b\u0010\b\u000e\u0012\f\b\u000f\u0012\b\b\fJ\u0004\b\b(\u0010b\u0002\b\u0011b\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0016H\u0002\"\u000e\u0010\u0015\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"StoreLocationMap", "", "lat", "", "lng", "radiusKm", "onPick", "Lkotlin/Function2;", "modifier", "Landroidx/compose/ui/Modifier;", "height", "Landroidx/compose/ui/unit/Dp;", "StoreLocationMap-HYR8e34", "(Ljava/lang/Double;Ljava/lang/Double;DLkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "Landroid/annotation/SuppressLint;", "value", "SetJavaScriptEnabled", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "MAP_SCHEME", "", "toHexCss", "Landroidx/compose/ui/graphics/Color;", "toHexCss-8_81llA", "(J)Ljava/lang/String;", "mapHtml", "bg", "ink", "app"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class StoreLocationMapKt {
    private static final String MAP_SCHEME = "FonRo-map";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StoreLocationMap_HYR8e34$lambda$5(Double d, Double d2, double d3, Function2 function2, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        m10080StoreLocationMapHYR8e34(d, d2, d3, function2, modifier, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0089  */
    /* renamed from: StoreLocationMap-HYR8e34, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m10080StoreLocationMapHYR8e34(final java.lang.Double r22, final java.lang.Double r23, final double r24, final kotlin.jvm.functions.Function2<? super java.lang.Double, ? super java.lang.Double, kotlin.Unit> r26, androidx.compose.ui.Modifier r27, float r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.orders.StoreLocationMapKt.m10080StoreLocationMapHYR8e34(java.lang.Double, java.lang.Double, double, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebView StoreLocationMap_HYR8e34$lambda$2$0(String str, final Function2 function2, final MapBridgeState mapBridgeState, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WebView webView = new WebView(context);
        webView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setNestedScrollingEnabled(false);
        webView.setBackgroundColor(ColorKt.m4438toArgb8_81llA(Ox.INSTANCE.m10191getChipDim0d7_KjU()));
        webView.setWebViewClient(new WebViewClient() { // from class: uz.FonRo.pos.ui.orders.StoreLocationMapKt$StoreLocationMap$1$1$1$1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri url;
                if (request == null || (url = request.getUrl()) == null || !Intrinsics.areEqual(url.getScheme(), "FonRo-map")) {
                    return false;
                }
                String queryParameter = url.getQueryParameter("lat");
                Double doubleOrNull = queryParameter != null ? StringsKt.toDoubleOrNull(queryParameter) : null;
                String queryParameter2 = url.getQueryParameter("lng");
                Double doubleOrNull2 = queryParameter2 != null ? StringsKt.toDoubleOrNull(queryParameter2) : null;
                if (doubleOrNull == null || doubleOrNull2 == null) {
                    return true;
                }
                function2.invoke(doubleOrNull, doubleOrNull2);
                return true;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                mapBridgeState.setReady(true);
                String pending = mapBridgeState.getPending();
                if (pending != null && view != null) {
                    view.evaluateJavascript(pending, null);
                }
                mapBridgeState.setPending(null);
            }
        });
        webView.loadDataWithBaseURL("https://FonRo.uz/", str, "text/html", "utf-8", null);
        return webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StoreLocationMap_HYR8e34$lambda$4$0(Double d, Double d2, double d3, MapBridgeState mapBridgeState, WebView web) {
        String str;
        String valueOf;
        Intrinsics.checkNotNullParameter(web, "web");
        String str2 = AbstractJsonLexerKt.NULL;
        if (d == null || (str = String.valueOf(d.doubleValue())) == null) {
            str = AbstractJsonLexerKt.NULL;
        }
        if (d2 != null && (valueOf = String.valueOf(d2.doubleValue())) != null) {
            str2 = valueOf;
        }
        String str3 = "oxSet(" + str + "," + str2 + "," + d3 + ")";
        if (Intrinsics.areEqual(str3, mapBridgeState.getSent())) {
            return Unit.INSTANCE;
        }
        mapBridgeState.setSent(str3);
        if (mapBridgeState.getReady()) {
            web.evaluateJavascript(str3, null);
        } else {
            mapBridgeState.setPending(str3);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StoreLocationMap_HYR8e34$lambda$3$0(WebView web) {
        Intrinsics.checkNotNullParameter(web, "web");
        web.stopLoading();
        web.loadUrl("about:blank");
        web.destroy();
        return Unit.INSTANCE;
    }

    /* renamed from: toHexCss-8_81llA, reason: not valid java name */
    private static final String m10081toHexCss8_81llA(long j) {
        String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(ColorKt.m4438toArgb8_81llA(j) & ViewCompat.MEASURED_SIZE_MASK)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private static final String mapHtml(String str, String str2) {
        return StringsKt.trimIndent("\n<!doctype html>\n<html><head>\n<meta charset=\"utf-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.9.4/leaflet.min.css\">\n<style>\n  html,body,#map{height:100%;margin:0;background:" + str + "}\n  .leaflet-control-attribution{display:none}\n  #err{display:none;height:100%;align-items:center;justify-content:center;padding:20px;\n       font:600 14px -apple-system,Roboto,sans-serif;color:" + str2 + ";text-align:center}\n</style>\n</head><body>\n<div id=\"map\"></div>\n<div id=\"err\">" + LangKt.tx("Карта недоступна без интернета", new Object[0]) + "</div>\n<script src=\"https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.9.4/leaflet.min.js\"></script>\n<script>\n(function () {\n  var map = null, marker = null, circle = null, centered = false, userPicked = false;\n\n  if (!window.L) {\n    document.getElementById('map').style.display = 'none';\n    document.getElementById('err').style.display = 'flex';\n    window.oxSet = function () {};\n    return;\n  }\n\n  // Ташкент по умолчанию: точка магазина ещё не задана, а показывать океан\n  // у берегов Африки (0,0) бессмысленно.\n  map = L.map('map', { attributionControl: false }).setView([41.3111, 69.2797], 11);\n  L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', { maxZoom: 19 }).addTo(map);\n\n  function report(lat, lng) {\n    userPicked = true;\n    location.href = 'FonRo-map://point?lat=' + lat + '&lng=' + lng;\n  }\n\n  // wrap() приводит долготу к -180…180: если карту прокрутили через край\n  // мира, Leaflet отдаёт 429 или -212, и сервер отвечает «Некорректные\n  // координаты магазина» — сохранение падало целиком.\n  map.on('click', function (e) { var p = e.latlng.wrap(); report(p.lat, p.lng); });\n\n  // Kotlin вызывает это на каждое изменение точки или радиуса.\n  window.oxSet = function (lat, lng, radiusKm) {\n    if (lat === null || lng === null) {\n      if (marker) { map.removeLayer(marker); marker = null; }\n      if (circle) { map.removeLayer(circle); circle = null; }\n      centered = false;\n      return;\n    }\n    if (marker) {\n      marker.setLatLng([lat, lng]);\n    } else {\n      marker = L.marker([lat, lng], { draggable: true }).addTo(map);\n      marker.on('dragend', function () {\n        var p = marker.getLatLng().wrap();\n        report(p.lat, p.lng);\n      });\n    }\n    // Камеру двигаем только на точку, ПРИШЕДШУЮ ИЗ НАСТРОЕК, и только раз.\n    // На тап пользователя не двигаем вовсе: карта прыгала бы из-под пальца.\n    if (!centered && !userPicked) { map.setView([lat, lng], 14); centered = true; }\n\n    if (circle) { map.removeLayer(circle); circle = null; }\n    if (radiusKm > 0) {\n      circle = L.circle([lat, lng], {\n        radius: radiusKm * 1000, color: '#0EA5E9', weight: 2,\n        fillColor: '#0EA5E9', fillOpacity: 0.12\n      }).addTo(map);\n    }\n  };\n\n  // Размер контейнера в WebView готов не сразу.\n  setTimeout(function () { map.invalidateSize(); }, 200);\n})();\n</script>\n</body></html>\n");
    }
}
