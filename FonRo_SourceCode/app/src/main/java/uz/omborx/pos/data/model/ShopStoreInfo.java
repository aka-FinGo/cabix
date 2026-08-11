package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientBool;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientInt;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 \u0086\u00012\u00020\u0001:\u0004\u0085\u0001\u0086\u0001BÙ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0011¢\u0006\u0004\b\u001b\u0010\u001cBÏ\u0001\b\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0013\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0011\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001b\u0010 J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0005HÆ\u0003J\t\u0010e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u000bHÆ\u0003J\t\u0010j\u001a\u00020\u000bHÆ\u0003J\t\u0010k\u001a\u00020\u000bHÆ\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010DJ\u0010\u0010m\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010DJ\u000f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011HÆ\u0003J\t\u0010o\u001a\u00020\u0013HÆ\u0003J\t\u0010p\u001a\u00020\u0013HÆ\u0003J\t\u0010q\u001a\u00020\u0013HÆ\u0003J\t\u0010r\u001a\u00020\u0013HÆ\u0003J\t\u0010s\u001a\u00020\u000bHÆ\u0003J\t\u0010t\u001a\u00020\u000bHÆ\u0003J\u000f\u0010u\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0011HÆ\u0003Jà\u0001\u0010v\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0011HÆ\u0001¢\u0006\u0002\u0010wJ\u0014\u0010x\u001a\u00020\u00032\b\u0010y\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010z\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010{\u001a\u00020\u0005HÖ\u0081\u0004J.\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\u00002\u0007\u0010\u007f\u001a\u00030\u0080\u00012\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0001b\u0003\b\u0084\u0001¢\u0006\u0003\b\u0083\u0001R8\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(&r\f\b'\u0012\b\b(\u0012\u0004\b\t0)¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\"\u001a\u0004\b\u0002\u0010#R*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\"\u001a\u0004\b+\u0010,R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R,\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(0¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\"\u001a\u0004\b/\u0010,R,\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(3¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\"\u001a\u0004\b2\u0010,R8\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(6r\f\b'\u0012\b\b(\u0012\u0004\b\t0)¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\"\u001a\u0004\b5\u0010#R8\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(:r\f\b'\u0012\b\b(\u0012\u0004\b\t0;¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\"\u001a\u0004\b8\u00109R8\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(>r\f\b'\u0012\b\b(\u0012\u0004\b\t0;¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\"\u001a\u0004\b=\u00109R8\u0010\r\u001a\u00020\u000b8\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(Ar\f\b'\u0012\b\b(\u0012\u0004\b\t0;¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010\"\u001a\u0004\b@\u00109R.\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(F¢\u0006\u0010\n\u0002\u0010E\u0012\u0004\bB\u0010\"\u001a\u0004\bC\u0010DR.\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(I¢\u0006\u0010\n\u0002\u0010E\u0012\u0004\bG\u0010\"\u001a\u0004\bH\u0010DR0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(M¢\u0006\u000e\n\u0000\u0012\u0004\bJ\u0010\"\u001a\u0004\bK\u0010LR8\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(Qr\f\b'\u0012\b\b(\u0012\u0004\b\t0R¢\u0006\u000e\n\u0000\u0012\u0004\bN\u0010\"\u001a\u0004\bO\u0010PR8\u0010\u0014\u001a\u00020\u00138\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(Ur\f\b'\u0012\b\b(\u0012\u0004\b\t0R¢\u0006\u000e\n\u0000\u0012\u0004\bS\u0010\"\u001a\u0004\bT\u0010PR8\u0010\u0015\u001a\u00020\u00138\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(Xr\f\b'\u0012\b\b(\u0012\u0004\b\t0R¢\u0006\u000e\n\u0000\u0012\u0004\bV\u0010\"\u001a\u0004\bW\u0010PR8\u0010\u0016\u001a\u00020\u00138\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b([r\f\b'\u0012\b\b(\u0012\u0004\b\t0R¢\u0006\u000e\n\u0000\u0012\u0004\bY\u0010\"\u001a\u0004\bZ\u0010PR8\u0010\u0017\u001a\u00020\u000b8\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(^r\f\b'\u0012\b\b(\u0012\u0004\b\t0;¢\u0006\u000e\n\u0000\u0012\u0004\b\\\u0010\"\u001a\u0004\b]\u00109R8\u0010\u0018\u001a\u00020\u000b8\u0006X\u0087\u0004r\f\b$\u0012\b\b%\u0012\u0004\b\b(ar\f\b'\u0012\b\b(\u0012\u0004\b\t0;¢\u0006\u000e\n\u0000\u0012\u0004\b_\u0010\"\u001a\u0004\b`\u00109R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0011¢\u0006\b\n\u0000\u001a\u0004\bb\u0010LÊ\u0001\u0002\b'Ê\u0001\u000e\b\u0088\u0001\u0012\t\b\u0089\u0001\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0087\u0001"}, d2 = {"Luz/FonRo/pos/data/model/ShopStoreInfo;", "", "isEnabled", "", "name", "", "slug", "description", FirebaseAnalytics.Param.CURRENCY, "deliveryEnabled", "deliveryPrice", "", "deliveryRadius", "deliveryMinAmount", "lat", "lng", "allowedCurrencies", "", "visitorsToday", "", "visitorsTotal", "ordersToday", "ordersTotal", "orderAmountToday", "orderAmountTotal", "days", "Luz/FonRo/pos/data/model/ShopStatDay;", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZDDDLjava/lang/Double;Ljava/lang/Double;Ljava/util/List;IIIIDDLjava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZDDDLjava/lang/Double;Ljava/lang/Double;Ljava/util/List;IIIIDDLjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "isEnabled$annotations", "()V", "()Z", "Lkotlinx/serialization/SerialName;", "value", "online_shop_enabled", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientBool;", "getName$annotations", "getName", "()Ljava/lang/String;", "getSlug", "getDescription$annotations", "getDescription", "about", "getCurrency$annotations", "getCurrency", "shop_currency", "getDeliveryEnabled$annotations", "getDeliveryEnabled", "delivery_enabled", "getDeliveryPrice$annotations", "getDeliveryPrice", "()D", "delivery_price", "Luz/FonRo/pos/data/net/LenientDouble;", "getDeliveryRadius$annotations", "getDeliveryRadius", "free_delivery_radius_km", "getDeliveryMinAmount$annotations", "getDeliveryMinAmount", "free_delivery_min_total", "getLat$annotations", "getLat", "()Ljava/lang/Double;", "Ljava/lang/Double;", "location_lat", "getLng$annotations", "getLng", "location_lng", "getAllowedCurrencies$annotations", "getAllowedCurrencies", "()Ljava/util/List;", "allowed_currencies", "getVisitorsToday$annotations", "getVisitorsToday", "()I", "visitors_today", "Luz/FonRo/pos/data/net/LenientInt;", "getVisitorsTotal$annotations", "getVisitorsTotal", "visitors_total", "getOrdersToday$annotations", "getOrdersToday", "orders_today", "getOrdersTotal$annotations", "getOrdersTotal", "orders_total", "getOrderAmountToday$annotations", "getOrderAmountToday", "order_amount_today", "getOrderAmountTotal$annotations", "getOrderAmountTotal", "order_amount_total", "getDays", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZDDDLjava/lang/Double;Ljava/lang/Double;Ljava/util/List;IIIIDDLjava/util/List;)Luz/FonRo/pos/data/model/ShopStoreInfo;", "equals", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ShopStoreInfo {
    public static final int $stable = 0;
    private final List<String> allowedCurrencies;
    private final String currency;
    private final List<ShopStatDay> days;
    private final boolean deliveryEnabled;
    private final double deliveryMinAmount;
    private final double deliveryPrice;
    private final double deliveryRadius;
    private final String description;
    private final boolean isEnabled;
    private final Double lat;
    private final Double lng;
    private final String name;
    private final double orderAmountToday;
    private final double orderAmountTotal;
    private final int ordersToday;
    private final int ordersTotal;
    private final String slug;
    private final int visitorsToday;
    private final int visitorsTotal;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.ShopStoreInfo$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ShopStoreInfo._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.ShopStoreInfo$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = ShopStoreInfo._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    })};

    public ShopStoreInfo() {
        this(false, (String) null, (String) null, (String) null, (String) null, false, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, (Double) null, (Double) null, (List) null, 0, 0, 0, 0, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, (List) null, 524287, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(ShopStatDay$$serializer.INSTANCE);
    }

    public static /* synthetic */ ShopStoreInfo copy$default(ShopStoreInfo shopStoreInfo, boolean z, String str, String str2, String str3, String str4, boolean z2, double d, double d2, double d3, Double d4, Double d5, List list, int i, int i2, int i3, int i4, double d6, double d7, List list2, int i5, Object obj) {
        List list3;
        double d8;
        boolean z3 = (i5 & 1) != 0 ? shopStoreInfo.isEnabled : z;
        String str5 = (i5 & 2) != 0 ? shopStoreInfo.name : str;
        String str6 = (i5 & 4) != 0 ? shopStoreInfo.slug : str2;
        String str7 = (i5 & 8) != 0 ? shopStoreInfo.description : str3;
        String str8 = (i5 & 16) != 0 ? shopStoreInfo.currency : str4;
        boolean z4 = (i5 & 32) != 0 ? shopStoreInfo.deliveryEnabled : z2;
        double d9 = (i5 & 64) != 0 ? shopStoreInfo.deliveryPrice : d;
        double d10 = (i5 & 128) != 0 ? shopStoreInfo.deliveryRadius : d2;
        double d11 = (i5 & 256) != 0 ? shopStoreInfo.deliveryMinAmount : d3;
        Double d12 = (i5 & 512) != 0 ? shopStoreInfo.lat : d4;
        Double d13 = (i5 & 1024) != 0 ? shopStoreInfo.lng : d5;
        boolean z5 = z3;
        List list4 = (i5 & 2048) != 0 ? shopStoreInfo.allowedCurrencies : list;
        int i6 = (i5 & 4096) != 0 ? shopStoreInfo.visitorsToday : i;
        int i7 = (i5 & 8192) != 0 ? shopStoreInfo.visitorsTotal : i2;
        int i8 = (i5 & 16384) != 0 ? shopStoreInfo.ordersToday : i3;
        int i9 = (i5 & 32768) != 0 ? shopStoreInfo.ordersTotal : i4;
        int i10 = i8;
        double d14 = (i5 & 65536) != 0 ? shopStoreInfo.orderAmountToday : d6;
        double d15 = (i5 & 131072) != 0 ? shopStoreInfo.orderAmountTotal : d7;
        if ((i5 & 262144) != 0) {
            d8 = d15;
            list3 = shopStoreInfo.days;
        } else {
            list3 = list2;
            d8 = d15;
        }
        return shopStoreInfo.copy(z5, str5, str6, str7, str8, z4, d9, d10, d11, d12, d13, list4, i6, i7, i10, i9, d14, d8, list3);
    }

    @SerialName("allowed_currencies")
    public static /* synthetic */ void getAllowedCurrencies$annotations() {
    }

    @SerialName("shop_currency")
    public static /* synthetic */ void getCurrency$annotations() {
    }

    @SerialName("delivery_enabled")
    @Serializable(with = LenientBool.class)
    public static /* synthetic */ void getDeliveryEnabled$annotations() {
    }

    @SerialName("free_delivery_min_total")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getDeliveryMinAmount$annotations() {
    }

    @SerialName("delivery_price")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getDeliveryPrice$annotations() {
    }

    @SerialName("free_delivery_radius_km")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getDeliveryRadius$annotations() {
    }

    @SerialName("about")
    public static /* synthetic */ void getDescription$annotations() {
    }

    @SerialName("location_lat")
    public static /* synthetic */ void getLat$annotations() {
    }

    @SerialName("location_lng")
    public static /* synthetic */ void getLng$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("order_amount_today")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getOrderAmountToday$annotations() {
    }

    @SerialName("order_amount_total")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getOrderAmountTotal$annotations() {
    }

    @SerialName("orders_today")
    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getOrdersToday$annotations() {
    }

    @SerialName("orders_total")
    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getOrdersTotal$annotations() {
    }

    @SerialName("visitors_today")
    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getVisitorsToday$annotations() {
    }

    @SerialName("visitors_total")
    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getVisitorsTotal$annotations() {
    }

    @SerialName("online_shop_enabled")
    @Serializable(with = LenientBool.class)
    public static /* synthetic */ void isEnabled$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    /* renamed from: component10, reason: from getter */
    public final Double getLat() {
        return this.lat;
    }

    /* renamed from: component11, reason: from getter */
    public final Double getLng() {
        return this.lng;
    }

    public final List<String> component12() {
        return this.allowedCurrencies;
    }

    /* renamed from: component13, reason: from getter */
    public final int getVisitorsToday() {
        return this.visitorsToday;
    }

    /* renamed from: component14, reason: from getter */
    public final int getVisitorsTotal() {
        return this.visitorsTotal;
    }

    /* renamed from: component15, reason: from getter */
    public final int getOrdersToday() {
        return this.ordersToday;
    }

    /* renamed from: component16, reason: from getter */
    public final int getOrdersTotal() {
        return this.ordersTotal;
    }

    /* renamed from: component17, reason: from getter */
    public final double getOrderAmountToday() {
        return this.orderAmountToday;
    }

    /* renamed from: component18, reason: from getter */
    public final double getOrderAmountTotal() {
        return this.orderAmountTotal;
    }

    public final List<ShopStatDay> component19() {
        return this.days;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getDeliveryEnabled() {
        return this.deliveryEnabled;
    }

    /* renamed from: component7, reason: from getter */
    public final double getDeliveryPrice() {
        return this.deliveryPrice;
    }

    /* renamed from: component8, reason: from getter */
    public final double getDeliveryRadius() {
        return this.deliveryRadius;
    }

    /* renamed from: component9, reason: from getter */
    public final double getDeliveryMinAmount() {
        return this.deliveryMinAmount;
    }

    public final ShopStoreInfo copy(boolean isEnabled, String name, String slug, String description, String currency, boolean deliveryEnabled, double deliveryPrice, double deliveryRadius, double deliveryMinAmount, Double lat, Double lng, List<String> allowedCurrencies, int visitorsToday, int visitorsTotal, int ordersToday, int ordersTotal, double orderAmountToday, double orderAmountTotal, List<ShopStatDay> days) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(slug, "slug");
        Intrinsics.checkNotNullParameter(allowedCurrencies, "allowedCurrencies");
        Intrinsics.checkNotNullParameter(days, "days");
        return new ShopStoreInfo(isEnabled, name, slug, description, currency, deliveryEnabled, deliveryPrice, deliveryRadius, deliveryMinAmount, lat, lng, allowedCurrencies, visitorsToday, visitorsTotal, ordersToday, ordersTotal, orderAmountToday, orderAmountTotal, days);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShopStoreInfo)) {
            return false;
        }
        ShopStoreInfo shopStoreInfo = (ShopStoreInfo) other;
        return this.isEnabled == shopStoreInfo.isEnabled && Intrinsics.areEqual(this.name, shopStoreInfo.name) && Intrinsics.areEqual(this.slug, shopStoreInfo.slug) && Intrinsics.areEqual(this.description, shopStoreInfo.description) && Intrinsics.areEqual(this.currency, shopStoreInfo.currency) && this.deliveryEnabled == shopStoreInfo.deliveryEnabled && Double.compare(this.deliveryPrice, shopStoreInfo.deliveryPrice) == 0 && Double.compare(this.deliveryRadius, shopStoreInfo.deliveryRadius) == 0 && Double.compare(this.deliveryMinAmount, shopStoreInfo.deliveryMinAmount) == 0 && Intrinsics.areEqual((Object) this.lat, (Object) shopStoreInfo.lat) && Intrinsics.areEqual((Object) this.lng, (Object) shopStoreInfo.lng) && Intrinsics.areEqual(this.allowedCurrencies, shopStoreInfo.allowedCurrencies) && this.visitorsToday == shopStoreInfo.visitorsToday && this.visitorsTotal == shopStoreInfo.visitorsTotal && this.ordersToday == shopStoreInfo.ordersToday && this.ordersTotal == shopStoreInfo.ordersTotal && Double.compare(this.orderAmountToday, shopStoreInfo.orderAmountToday) == 0 && Double.compare(this.orderAmountTotal, shopStoreInfo.orderAmountTotal) == 0 && Intrinsics.areEqual(this.days, shopStoreInfo.days);
    }

    public int hashCode() {
        int hashCode = ((((Boolean.hashCode(this.isEnabled) * 31) + this.name.hashCode()) * 31) + this.slug.hashCode()) * 31;
        String str = this.description;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.currency;
        int hashCode3 = (((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.deliveryEnabled)) * 31) + Double.hashCode(this.deliveryPrice)) * 31) + Double.hashCode(this.deliveryRadius)) * 31) + Double.hashCode(this.deliveryMinAmount)) * 31;
        Double d = this.lat;
        int hashCode4 = (hashCode3 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.lng;
        return ((((((((((((((((hashCode4 + (d2 != null ? d2.hashCode() : 0)) * 31) + this.allowedCurrencies.hashCode()) * 31) + Integer.hashCode(this.visitorsToday)) * 31) + Integer.hashCode(this.visitorsTotal)) * 31) + Integer.hashCode(this.ordersToday)) * 31) + Integer.hashCode(this.ordersTotal)) * 31) + Double.hashCode(this.orderAmountToday)) * 31) + Double.hashCode(this.orderAmountTotal)) * 31) + this.days.hashCode();
    }

    public String toString() {
        return "ShopStoreInfo(isEnabled=" + this.isEnabled + ", name=" + this.name + ", slug=" + this.slug + ", description=" + this.description + ", currency=" + this.currency + ", deliveryEnabled=" + this.deliveryEnabled + ", deliveryPrice=" + this.deliveryPrice + ", deliveryRadius=" + this.deliveryRadius + ", deliveryMinAmount=" + this.deliveryMinAmount + ", lat=" + this.lat + ", lng=" + this.lng + ", allowedCurrencies=" + this.allowedCurrencies + ", visitorsToday=" + this.visitorsToday + ", visitorsTotal=" + this.visitorsTotal + ", ordersToday=" + this.ordersToday + ", ordersTotal=" + this.ordersTotal + ", orderAmountToday=" + this.orderAmountToday + ", orderAmountTotal=" + this.orderAmountTotal + ", days=" + this.days + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/ShopStoreInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/ShopStoreInfo;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ShopStoreInfo> serializer() {
            return ShopStoreInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ShopStoreInfo(int i, boolean z, String str, String str2, String str3, String str4, boolean z2, double d, double d2, double d3, Double d4, Double d5, List list, int i2, int i3, int i4, int i5, double d6, double d7, List list2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.isEnabled = false;
        } else {
            this.isEnabled = z;
        }
        if ((i & 2) == 0) {
            this.name = "";
        } else {
            this.name = str;
        }
        if ((i & 4) == 0) {
            this.slug = "";
        } else {
            this.slug = str2;
        }
        if ((i & 8) == 0) {
            this.description = null;
        } else {
            this.description = str3;
        }
        if ((i & 16) == 0) {
            this.currency = null;
        } else {
            this.currency = str4;
        }
        if ((i & 32) == 0) {
            this.deliveryEnabled = false;
        } else {
            this.deliveryEnabled = z2;
        }
        if ((i & 64) == 0) {
            this.deliveryPrice = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.deliveryPrice = d;
        }
        if ((i & 128) == 0) {
            this.deliveryRadius = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.deliveryRadius = d2;
        }
        if ((i & 256) == 0) {
            this.deliveryMinAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.deliveryMinAmount = d3;
        }
        if ((i & 512) == 0) {
            this.lat = null;
        } else {
            this.lat = d4;
        }
        if ((i & 1024) == 0) {
            this.lng = null;
        } else {
            this.lng = d5;
        }
        this.allowedCurrencies = (i & 2048) == 0 ? CollectionsKt.emptyList() : list;
        if ((i & 4096) == 0) {
            this.visitorsToday = 0;
        } else {
            this.visitorsToday = i2;
        }
        if ((i & 8192) == 0) {
            this.visitorsTotal = 0;
        } else {
            this.visitorsTotal = i3;
        }
        if ((i & 16384) == 0) {
            this.ordersToday = 0;
        } else {
            this.ordersToday = i4;
        }
        if ((32768 & i) == 0) {
            this.ordersTotal = 0;
        } else {
            this.ordersTotal = i5;
        }
        if ((65536 & i) == 0) {
            this.orderAmountToday = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.orderAmountToday = d6;
        }
        if ((131072 & i) == 0) {
            this.orderAmountTotal = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.orderAmountTotal = d7;
        }
        this.days = (i & 262144) == 0 ? CollectionsKt.emptyList() : list2;
    }

    public ShopStoreInfo(boolean z, String name, String slug, String str, String str2, boolean z2, double d, double d2, double d3, Double d4, Double d5, List<String> allowedCurrencies, int i, int i2, int i3, int i4, double d6, double d7, List<ShopStatDay> days) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(slug, "slug");
        Intrinsics.checkNotNullParameter(allowedCurrencies, "allowedCurrencies");
        Intrinsics.checkNotNullParameter(days, "days");
        this.isEnabled = z;
        this.name = name;
        this.slug = slug;
        this.description = str;
        this.currency = str2;
        this.deliveryEnabled = z2;
        this.deliveryPrice = d;
        this.deliveryRadius = d2;
        this.deliveryMinAmount = d3;
        this.lat = d4;
        this.lng = d5;
        this.allowedCurrencies = allowedCurrencies;
        this.visitorsToday = i;
        this.visitorsTotal = i2;
        this.ordersToday = i3;
        this.ordersTotal = i4;
        this.orderAmountToday = d6;
        this.orderAmountTotal = d7;
        this.days = days;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ShopStoreInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.isEnabled) {
            output.encodeSerializableElement(serialDesc, 0, LenientBool.INSTANCE, Boolean.valueOf(self.isEnabled));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.name, "")) {
            output.encodeStringElement(serialDesc, 1, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.slug, "")) {
            output.encodeStringElement(serialDesc, 2, self.slug);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.description != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.currency != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.currency);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.deliveryEnabled) {
            output.encodeSerializableElement(serialDesc, 5, LenientBool.INSTANCE, Boolean.valueOf(self.deliveryEnabled));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || Double.compare(self.deliveryPrice, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 6, LenientDouble.INSTANCE, Double.valueOf(self.deliveryPrice));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || Double.compare(self.deliveryRadius, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 7, LenientDouble.INSTANCE, Double.valueOf(self.deliveryRadius));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || Double.compare(self.deliveryMinAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 8, LenientDouble.INSTANCE, Double.valueOf(self.deliveryMinAmount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.lat != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, DoubleSerializer.INSTANCE, self.lat);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.lng != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, DoubleSerializer.INSTANCE, self.lng);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || !Intrinsics.areEqual(self.allowedCurrencies, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 11, lazyArr[11].getValue(), self.allowedCurrencies);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.visitorsToday != 0) {
            output.encodeSerializableElement(serialDesc, 12, LenientInt.INSTANCE, Integer.valueOf(self.visitorsToday));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.visitorsTotal != 0) {
            output.encodeSerializableElement(serialDesc, 13, LenientInt.INSTANCE, Integer.valueOf(self.visitorsTotal));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.ordersToday != 0) {
            output.encodeSerializableElement(serialDesc, 14, LenientInt.INSTANCE, Integer.valueOf(self.ordersToday));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.ordersTotal != 0) {
            output.encodeSerializableElement(serialDesc, 15, LenientInt.INSTANCE, Integer.valueOf(self.ordersTotal));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || Double.compare(self.orderAmountToday, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 16, LenientDouble.INSTANCE, Double.valueOf(self.orderAmountToday));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || Double.compare(self.orderAmountTotal, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 17, LenientDouble.INSTANCE, Double.valueOf(self.orderAmountTotal));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 18) && Intrinsics.areEqual(self.days, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 18, lazyArr[18].getValue(), self.days);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ ShopStoreInfo(boolean r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, boolean r31, double r32, double r34, double r36, java.lang.Double r38, java.lang.Double r39, java.util.List r40, int r41, int r42, int r43, int r44, double r45, double r47, java.util.List r49, int r50, kotlin.jvm.internal.DefaultConstructorMarker r51) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.data.model.ShopStoreInfo.<init>(boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, double, double, double, java.lang.Double, java.lang.Double, java.util.List, int, int, int, int, double, double, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final boolean getDeliveryEnabled() {
        return this.deliveryEnabled;
    }

    public final double getDeliveryPrice() {
        return this.deliveryPrice;
    }

    public final double getDeliveryRadius() {
        return this.deliveryRadius;
    }

    public final double getDeliveryMinAmount() {
        return this.deliveryMinAmount;
    }

    public final Double getLat() {
        return this.lat;
    }

    public final Double getLng() {
        return this.lng;
    }

    public final List<String> getAllowedCurrencies() {
        return this.allowedCurrencies;
    }

    public final int getVisitorsToday() {
        return this.visitorsToday;
    }

    public final int getVisitorsTotal() {
        return this.visitorsTotal;
    }

    public final int getOrdersToday() {
        return this.ordersToday;
    }

    public final int getOrdersTotal() {
        return this.ordersTotal;
    }

    public final double getOrderAmountToday() {
        return this.orderAmountToday;
    }

    public final double getOrderAmountTotal() {
        return this.orderAmountTotal;
    }

    public final List<ShopStatDay> getDays() {
        return this.days;
    }
}
