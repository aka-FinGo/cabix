package uz.FonRo.pos.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import uz.FonRo.pos.core.Lang;

/* compiled from: AppPrefs.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u000205J\u0016\u0010@\u001a\u00020A2\u0006\u0010?\u001a\u0002052\u0006\u0010B\u001a\u00020\tJ\u0006\u0010C\u001a\u00020AR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR$\u0010\u001d\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR$\u0010!\u001a\u00020 2\u0006\u0010\b\u001a\u00020 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u00020&2\u0006\u0010\b\u001a\u00020&8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR$\u0010/\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010\f\"\u0004\b1\u0010\u000eR$\u00102\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u0010\f\"\u0004\b4\u0010\u000eR$\u00106\u001a\u0002052\u0006\u0010\b\u001a\u0002058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010;\u001a\u0002052\u0006\u0010\b\u001a\u0002058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u00108\"\u0004\b=\u0010:Ê\u0001\f\bF\u0012\b\bG\u0012\u0004\b\u0003\u0010\u0000¨\u0006E"}, d2 = {"Luz/FonRo/pos/data/prefs/AppPrefs;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "sp", "Landroid/content/SharedPreferences;", "value", "", AppPrefs.KEY_TOKEN, "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "deviceId", "getDeviceId", "", "lowStock", "getLowStock", "()I", "setLowStock", "(I)V", "receiptWidth", "getReceiptWidth", "setReceiptWidth", "printerMac", "getPrinterMac", "setPrinterMac", "printerName", "getPrinterName", "setPrinterName", "", "autoPrint", "getAutoPrint", "()Z", "setAutoPrint", "(Z)V", "", "textScale", "getTextScale", "()F", "setTextScale", "(F)V", AppPrefs.KEY_APPEARANCE, "getAppearance", "setAppearance", AppPrefs.KEY_LANG, "getLang", "setLang", "catalogLang", "getCatalogLang", "setCatalogLang", "", "supportSeen", "getSupportSeen", "()J", "setSupportSeen", "(J)V", "ordersSeen", "getOrdersSeen", "setOrdersSeen", "heldCarts", "storeId", "setHeldCarts", "", "json", "clearSession", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class AppPrefs {
    private static final String CHARS = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final String KEY_APPEARANCE = "appearance";
    private static final String KEY_AUTO_PRINT = "auto_print";
    private static final String KEY_CATALOG_LANG = "catalog_lang";
    private static final String KEY_DEVICE = "device_id";
    private static final String KEY_HELD = "held_";
    private static final String KEY_LANG = "lang";
    private static final String KEY_LOW_STOCK = "low_stock";
    private static final String KEY_ORDERS_SEEN = "orders_seen";
    private static final String KEY_PRINTER = "printer_mac";
    private static final String KEY_PRINTER_NAME = "printer_name";
    private static final String KEY_RECEIPT_WIDTH = "receipt_width";
    private static final String KEY_SUPPORT_SEEN = "support_seen";
    private static final String KEY_TEXT_SCALE = "text_scale";
    private static final String KEY_TOKEN = "token";
    public static final String NAME = "FonRo_prefs";
    private final SharedPreferences sp;
    public static final int $stable = 8;

    public AppPrefs(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sp = sharedPreferences;
    }

    public final String getToken() {
        String string = this.sp.getString(KEY_TOKEN, "");
        return string == null ? "" : string;
    }

    public final void setToken(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences.Editor edit = this.sp.edit();
        if (StringsKt.isBlank(value)) {
            edit.remove(KEY_TOKEN);
        } else {
            edit.putString(KEY_TOKEN, value);
        }
        edit.apply();
    }

    public final String getDeviceId() {
        String string = this.sp.getString(KEY_DEVICE, null);
        if (string != null) {
            return string;
        }
        String l = Long.toString(System.currentTimeMillis(), CharsKt.checkRadix(36));
        Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
        IntRange intRange = new IntRange(1, 8);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            arrayList.add(Character.valueOf(CHARS.charAt(Random.INSTANCE.nextInt(36))));
        }
        String str = "and-" + l + "-" + CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putString(KEY_DEVICE, str);
        edit.apply();
        return str;
    }

    public final int getLowStock() {
        return RangesKt.coerceAtLeast(this.sp.getInt(KEY_LOW_STOCK, 5), 1);
    }

    public final void setLowStock(int i) {
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putInt(KEY_LOW_STOCK, RangesKt.coerceAtLeast(i, 1));
        edit.apply();
    }

    public final int getReceiptWidth() {
        return this.sp.getInt(KEY_RECEIPT_WIDTH, 72);
    }

    public final void setReceiptWidth(int i) {
        SharedPreferences.Editor edit = this.sp.edit();
        if (!CollectionsKt.listOf((Object[]) new Integer[]{58, 72, 80}).contains(Integer.valueOf(i))) {
            i = 72;
        }
        edit.putInt(KEY_RECEIPT_WIDTH, i);
        edit.apply();
    }

    public final String getPrinterMac() {
        String string = this.sp.getString(KEY_PRINTER, "");
        return string == null ? "" : string;
    }

    public final void setPrinterMac(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putString(KEY_PRINTER, value);
        edit.apply();
    }

    public final String getPrinterName() {
        String string = this.sp.getString(KEY_PRINTER_NAME, "");
        return string == null ? "" : string;
    }

    public final void setPrinterName(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putString(KEY_PRINTER_NAME, value);
        edit.apply();
    }

    public final boolean getAutoPrint() {
        return this.sp.getBoolean(KEY_AUTO_PRINT, false);
    }

    public final void setAutoPrint(boolean z) {
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putBoolean(KEY_AUTO_PRINT, z);
        edit.apply();
    }

    public final float getTextScale() {
        return this.sp.getFloat(KEY_TEXT_SCALE, 1.0f);
    }

    public final void setTextScale(float f) {
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putFloat(KEY_TEXT_SCALE, f);
        edit.apply();
    }

    public final String getAppearance() {
        String string = this.sp.getString(KEY_APPEARANCE, "system");
        return string == null ? "" : string;
    }

    public final void setAppearance(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putString(KEY_APPEARANCE, value);
        edit.apply();
    }

    public final String getLang() {
        String string = this.sp.getString(KEY_LANG, Lang.DEFAULT);
        return string == null ? "" : string;
    }

    public final void setLang(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putString(KEY_LANG, value);
        edit.apply();
    }

    public final String getCatalogLang() {
        String string = this.sp.getString(KEY_CATALOG_LANG, "");
        return string == null ? "" : string;
    }

    public final void setCatalogLang(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putString(KEY_CATALOG_LANG, value);
        edit.apply();
    }

    public final long getSupportSeen() {
        return this.sp.getLong(KEY_SUPPORT_SEEN, 0L);
    }

    public final void setSupportSeen(long j) {
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putLong(KEY_SUPPORT_SEEN, j);
        edit.apply();
    }

    public final long getOrdersSeen() {
        return this.sp.getLong(KEY_ORDERS_SEEN, 0L);
    }

    public final void setOrdersSeen(long j) {
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putLong(KEY_ORDERS_SEEN, j);
        edit.apply();
    }

    public final String heldCarts(long storeId) {
        String string = this.sp.getString(KEY_HELD + storeId, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        return string == null ? "" : string;
    }

    public final void setHeldCarts(long storeId, String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putString(KEY_HELD + storeId, json);
        edit.apply();
    }

    public final void clearSession() {
        String deviceId = getDeviceId();
        String catalogLang = getCatalogLang();
        float textScale = getTextScale();
        String appearance = getAppearance();
        String lang = getLang();
        SharedPreferences.Editor edit = this.sp.edit();
        edit.clear();
        edit.putString(KEY_DEVICE, deviceId);
        if (!StringsKt.isBlank(catalogLang)) {
            edit.putString(KEY_CATALOG_LANG, catalogLang);
        }
        if (textScale != 1.0f) {
            edit.putFloat(KEY_TEXT_SCALE, textScale);
        }
        if (!StringsKt.isBlank(appearance)) {
            edit.putString(KEY_APPEARANCE, appearance);
        }
        if (!StringsKt.isBlank(lang)) {
            edit.putString(KEY_LANG, lang);
        }
        edit.apply();
    }
}
