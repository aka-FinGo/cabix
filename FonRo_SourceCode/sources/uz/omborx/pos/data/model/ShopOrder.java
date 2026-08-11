package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
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
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientLong;
import uz.FonRo.pos.data.net.LenientString;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 \u0083\u00012\u00020\u0001:\u0004\u0082\u0001\u0083\u0001Bã\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0004\b\u001a\u0010\u001bBÙ\u0001\b\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001a\u0010 J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0005HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010f\u001a\u00020\fHÆ\u0003J\t\u0010g\u001a\u00020\u0005HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010j\u001a\u00020\fHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010WJ\u0010\u0010p\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010WJ\u000f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018HÆ\u0003Jê\u0001\u0010r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018HÆ\u0001¢\u0006\u0002\u0010sJ\u0014\u0010t\u001a\u00020u2\b\u0010v\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010w\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010x\u001a\u00020\u0005HÖ\u0081\u0004J+\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020\u00002\u0006\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\u007fH\u0001b\u0003\b\u0081\u0001¢\u0006\u0003\b\u0080\u0001R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b%\u0012\b\b&\u0012\u0004\b\t0'¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R8\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b+\u0012\b\b,\u0012\u0004\b\b(-r\f\b%\u0012\b\b&\u0012\u0004\b\t0.¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\"\u001a\u0004\b)\u0010*R,\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b+\u0012\b\b,\u0012\u0004\b\b(1¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\"\u001a\u0004\b0\u0010*R,\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b+\u0012\b\b,\u0012\u0004\b\b(4¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\"\u001a\u0004\b3\u0010*R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010*R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010*R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010*R8\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004r\f\b+\u0012\b\b,\u0012\u0004\b\b(;r\f\b%\u0012\b\b&\u0012\u0004\b\t0<¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010\"\u001a\u0004\b9\u0010:R*\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b+\u0012\b\b,\u0012\u0004\b\b(?¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010\"\u001a\u0004\b>\u0010*R,\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b+\u0012\b\b,\u0012\u0004\b\b(B¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010\"\u001a\u0004\bA\u0010*R,\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b+\u0012\b\b,\u0012\u0004\b\b(E¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010\"\u001a\u0004\bD\u0010*R8\u0010\u0010\u001a\u00020\f8\u0006X\u0087\u0004r\f\b+\u0012\b\b,\u0012\u0004\b\b(Hr\f\b%\u0012\b\b&\u0012\u0004\b\t0<¢\u0006\u000e\n\u0000\u0012\u0004\bF\u0010\"\u001a\u0004\bG\u0010:R,\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b+\u0012\b\b,\u0012\u0004\b\b(K¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010\"\u001a\u0004\bJ\u0010*R,\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b+\u0012\b\b,\u0012\u0004\b\b(N¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010\"\u001a\u0004\bM\u0010*R,\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b+\u0012\b\b,\u0012\u0004\b\b(Q¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010\"\u001a\u0004\bP\u0010*R,\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b+\u0012\b\b,\u0012\u0004\b\b(T¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010\"\u001a\u0004\bS\u0010*R.\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004r\f\b+\u0012\b\b,\u0012\u0004\b\b(Y¢\u0006\u0010\n\u0002\u0010X\u0012\u0004\bU\u0010\"\u001a\u0004\bV\u0010WR.\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004r\f\b+\u0012\b\b,\u0012\u0004\b\b(\\¢\u0006\u0010\n\u0002\u0010X\u0012\u0004\bZ\u0010\"\u001a\u0004\b[\u0010WR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^Ê\u0001\u0002\b%Ê\u0001\u000e\b\u0085\u0001\u0012\t\b\u0086\u0001\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0084\u0001"}, d2 = {"Luz/FonRo/pos/data/model/ShopOrder;", "", "id", "", "orderNumber", "", "customerName", "customerPhone", "address", NotificationCompat.CATEGORY_STATUS, "note", "totalAmount", "", "createdAt", "email", "deliveryType", "deliveryPrice", "confirmedAt", "completedAt", "cancelledAt", "cancelReason", "locationLat", "locationLng", FirebaseAnalytics.Param.ITEMS, "", "Luz/FonRo/pos/data/model/ShopOrderItem;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getOrderNumber$annotations", "getOrderNumber", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "order_number", "Luz/FonRo/pos/data/net/LenientString;", "getCustomerName$annotations", "getCustomerName", "customer_name", "getCustomerPhone$annotations", "getCustomerPhone", "customer_phone", "getAddress", "getStatus", "getNote", "getTotalAmount$annotations", "getTotalAmount", "()D", "total_amount", "Luz/FonRo/pos/data/net/LenientDouble;", "getCreatedAt$annotations", "getCreatedAt", "created_at", "getEmail$annotations", "getEmail", "customer_email", "getDeliveryType$annotations", "getDeliveryType", "delivery_type", "getDeliveryPrice$annotations", "getDeliveryPrice", "delivery_price", "getConfirmedAt$annotations", "getConfirmedAt", "confirmed_at", "getCompletedAt$annotations", "getCompletedAt", "completed_at", "getCancelledAt$annotations", "getCancelledAt", "cancelled_at", "getCancelReason$annotations", "getCancelReason", "cancel_reason", "getLocationLat$annotations", "getLocationLat", "()Ljava/lang/Double;", "Ljava/lang/Double;", "location_lat", "getLocationLng$annotations", "getLocationLng", "location_lng", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;)Luz/FonRo/pos/data/model/ShopOrder;", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ShopOrder {
    private final String address;
    private final String cancelReason;
    private final String cancelledAt;
    private final String completedAt;
    private final String confirmedAt;
    private final String createdAt;
    private final String customerName;
    private final String customerPhone;
    private final double deliveryPrice;
    private final String deliveryType;
    private final String email;
    private final long id;
    private final List<ShopOrderItem> items;
    private final Double locationLat;
    private final Double locationLng;
    private final String note;
    private final String orderNumber;
    private final String status;
    private final double totalAmount;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.ShopOrder$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ShopOrder._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public ShopOrder() {
        this(0L, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, (String) null, (String) null, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, (String) null, (String) null, (String) null, (String) null, (Double) null, (Double) null, (List) null, 524287, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(ShopOrderItem$$serializer.INSTANCE);
    }

    public static /* synthetic */ ShopOrder copy$default(ShopOrder shopOrder, long j, String str, String str2, String str3, String str4, String str5, String str6, double d, String str7, String str8, String str9, double d2, String str10, String str11, String str12, String str13, Double d3, Double d4, List list, int i, Object obj) {
        long j2;
        double d5;
        List list2;
        Double d6;
        long j3 = (i & 1) != 0 ? shopOrder.id : j;
        String str14 = (i & 2) != 0 ? shopOrder.orderNumber : str;
        String str15 = (i & 4) != 0 ? shopOrder.customerName : str2;
        String str16 = (i & 8) != 0 ? shopOrder.customerPhone : str3;
        String str17 = (i & 16) != 0 ? shopOrder.address : str4;
        String str18 = (i & 32) != 0 ? shopOrder.status : str5;
        String str19 = (i & 64) != 0 ? shopOrder.note : str6;
        double d7 = (i & 128) != 0 ? shopOrder.totalAmount : d;
        String str20 = (i & 256) != 0 ? shopOrder.createdAt : str7;
        String str21 = (i & 512) != 0 ? shopOrder.email : str8;
        String str22 = (i & 1024) != 0 ? shopOrder.deliveryType : str9;
        if ((i & 2048) != 0) {
            j2 = j3;
            d5 = shopOrder.deliveryPrice;
        } else {
            j2 = j3;
            d5 = d2;
        }
        double d8 = d5;
        String str23 = (i & 4096) != 0 ? shopOrder.confirmedAt : str10;
        String str24 = (i & 8192) != 0 ? shopOrder.completedAt : str11;
        String str25 = str23;
        String str26 = (i & 16384) != 0 ? shopOrder.cancelledAt : str12;
        String str27 = (i & 32768) != 0 ? shopOrder.cancelReason : str13;
        Double d9 = (i & 65536) != 0 ? shopOrder.locationLat : d3;
        Double d10 = (i & 131072) != 0 ? shopOrder.locationLng : d4;
        if ((i & 262144) != 0) {
            d6 = d10;
            list2 = shopOrder.items;
        } else {
            list2 = list;
            d6 = d10;
        }
        return shopOrder.copy(j2, str14, str15, str16, str17, str18, str19, d7, str20, str21, str22, d8, str25, str24, str26, str27, d9, d6, list2);
    }

    @SerialName("cancel_reason")
    public static /* synthetic */ void getCancelReason$annotations() {
    }

    @SerialName("cancelled_at")
    public static /* synthetic */ void getCancelledAt$annotations() {
    }

    @SerialName("completed_at")
    public static /* synthetic */ void getCompletedAt$annotations() {
    }

    @SerialName("confirmed_at")
    public static /* synthetic */ void getConfirmedAt$annotations() {
    }

    @SerialName("created_at")
    public static /* synthetic */ void getCreatedAt$annotations() {
    }

    @SerialName("customer_name")
    public static /* synthetic */ void getCustomerName$annotations() {
    }

    @SerialName("customer_phone")
    public static /* synthetic */ void getCustomerPhone$annotations() {
    }

    @SerialName("delivery_price")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getDeliveryPrice$annotations() {
    }

    @SerialName("delivery_type")
    public static /* synthetic */ void getDeliveryType$annotations() {
    }

    @SerialName("customer_email")
    public static /* synthetic */ void getEmail$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("location_lat")
    public static /* synthetic */ void getLocationLat$annotations() {
    }

    @SerialName("location_lng")
    public static /* synthetic */ void getLocationLng$annotations() {
    }

    @SerialName("order_number")
    @Serializable(with = LenientString.class)
    public static /* synthetic */ void getOrderNumber$annotations() {
    }

    @SerialName("total_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getTotalAmount$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component11, reason: from getter */
    public final String getDeliveryType() {
        return this.deliveryType;
    }

    /* renamed from: component12, reason: from getter */
    public final double getDeliveryPrice() {
        return this.deliveryPrice;
    }

    /* renamed from: component13, reason: from getter */
    public final String getConfirmedAt() {
        return this.confirmedAt;
    }

    /* renamed from: component14, reason: from getter */
    public final String getCompletedAt() {
        return this.completedAt;
    }

    /* renamed from: component15, reason: from getter */
    public final String getCancelledAt() {
        return this.cancelledAt;
    }

    /* renamed from: component16, reason: from getter */
    public final String getCancelReason() {
        return this.cancelReason;
    }

    /* renamed from: component17, reason: from getter */
    public final Double getLocationLat() {
        return this.locationLat;
    }

    /* renamed from: component18, reason: from getter */
    public final Double getLocationLng() {
        return this.locationLng;
    }

    public final List<ShopOrderItem> component19() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOrderNumber() {
        return this.orderNumber;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCustomerName() {
        return this.customerName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCustomerPhone() {
        return this.customerPhone;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component6, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component7, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    /* renamed from: component8, reason: from getter */
    public final double getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component9, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final ShopOrder copy(long id, String orderNumber, String customerName, String customerPhone, String address, String status, String note, double totalAmount, String createdAt, String email, String deliveryType, double deliveryPrice, String confirmedAt, String completedAt, String cancelledAt, String cancelReason, Double locationLat, Double locationLng, List<ShopOrderItem> items) {
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(items, "items");
        return new ShopOrder(id, orderNumber, customerName, customerPhone, address, status, note, totalAmount, createdAt, email, deliveryType, deliveryPrice, confirmedAt, completedAt, cancelledAt, cancelReason, locationLat, locationLng, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShopOrder)) {
            return false;
        }
        ShopOrder shopOrder = (ShopOrder) other;
        return this.id == shopOrder.id && Intrinsics.areEqual(this.orderNumber, shopOrder.orderNumber) && Intrinsics.areEqual(this.customerName, shopOrder.customerName) && Intrinsics.areEqual(this.customerPhone, shopOrder.customerPhone) && Intrinsics.areEqual(this.address, shopOrder.address) && Intrinsics.areEqual(this.status, shopOrder.status) && Intrinsics.areEqual(this.note, shopOrder.note) && Double.compare(this.totalAmount, shopOrder.totalAmount) == 0 && Intrinsics.areEqual(this.createdAt, shopOrder.createdAt) && Intrinsics.areEqual(this.email, shopOrder.email) && Intrinsics.areEqual(this.deliveryType, shopOrder.deliveryType) && Double.compare(this.deliveryPrice, shopOrder.deliveryPrice) == 0 && Intrinsics.areEqual(this.confirmedAt, shopOrder.confirmedAt) && Intrinsics.areEqual(this.completedAt, shopOrder.completedAt) && Intrinsics.areEqual(this.cancelledAt, shopOrder.cancelledAt) && Intrinsics.areEqual(this.cancelReason, shopOrder.cancelReason) && Intrinsics.areEqual((Object) this.locationLat, (Object) shopOrder.locationLat) && Intrinsics.areEqual((Object) this.locationLng, (Object) shopOrder.locationLng) && Intrinsics.areEqual(this.items, shopOrder.items);
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.id) * 31) + this.orderNumber.hashCode()) * 31;
        String str = this.customerName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.customerPhone;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.address;
        int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.status.hashCode()) * 31;
        String str4 = this.note;
        int hashCode5 = (((((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Double.hashCode(this.totalAmount)) * 31) + this.createdAt.hashCode()) * 31;
        String str5 = this.email;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.deliveryType;
        int hashCode7 = (((hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + Double.hashCode(this.deliveryPrice)) * 31;
        String str7 = this.confirmedAt;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.completedAt;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.cancelledAt;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.cancelReason;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Double d = this.locationLat;
        int hashCode12 = (hashCode11 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.locationLng;
        return ((hashCode12 + (d2 != null ? d2.hashCode() : 0)) * 31) + this.items.hashCode();
    }

    public String toString() {
        return "ShopOrder(id=" + this.id + ", orderNumber=" + this.orderNumber + ", customerName=" + this.customerName + ", customerPhone=" + this.customerPhone + ", address=" + this.address + ", status=" + this.status + ", note=" + this.note + ", totalAmount=" + this.totalAmount + ", createdAt=" + this.createdAt + ", email=" + this.email + ", deliveryType=" + this.deliveryType + ", deliveryPrice=" + this.deliveryPrice + ", confirmedAt=" + this.confirmedAt + ", completedAt=" + this.completedAt + ", cancelledAt=" + this.cancelledAt + ", cancelReason=" + this.cancelReason + ", locationLat=" + this.locationLat + ", locationLng=" + this.locationLng + ", items=" + this.items + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/ShopOrder$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/ShopOrder;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ShopOrder> serializer() {
            return ShopOrder$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ShopOrder(int i, long j, String str, String str2, String str3, String str4, String str5, String str6, double d, String str7, String str8, String str9, double d2, String str10, String str11, String str12, String str13, Double d3, Double d4, List list, SerializationConstructorMarker serializationConstructorMarker) {
        this.id = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.orderNumber = "";
        } else {
            this.orderNumber = str;
        }
        if ((i & 4) == 0) {
            this.customerName = null;
        } else {
            this.customerName = str2;
        }
        if ((i & 8) == 0) {
            this.customerPhone = null;
        } else {
            this.customerPhone = str3;
        }
        if ((i & 16) == 0) {
            this.address = null;
        } else {
            this.address = str4;
        }
        if ((i & 32) == 0) {
            this.status = "";
        } else {
            this.status = str5;
        }
        if ((i & 64) == 0) {
            this.note = null;
        } else {
            this.note = str6;
        }
        if ((i & 128) == 0) {
            this.totalAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.totalAmount = d;
        }
        if ((i & 256) == 0) {
            this.createdAt = "";
        } else {
            this.createdAt = str7;
        }
        if ((i & 512) == 0) {
            this.email = null;
        } else {
            this.email = str8;
        }
        if ((i & 1024) == 0) {
            this.deliveryType = null;
        } else {
            this.deliveryType = str9;
        }
        if ((i & 2048) == 0) {
            this.deliveryPrice = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.deliveryPrice = d2;
        }
        if ((i & 4096) == 0) {
            this.confirmedAt = null;
        } else {
            this.confirmedAt = str10;
        }
        if ((i & 8192) == 0) {
            this.completedAt = null;
        } else {
            this.completedAt = str11;
        }
        if ((i & 16384) == 0) {
            this.cancelledAt = null;
        } else {
            this.cancelledAt = str12;
        }
        if ((32768 & i) == 0) {
            this.cancelReason = null;
        } else {
            this.cancelReason = str13;
        }
        if ((65536 & i) == 0) {
            this.locationLat = null;
        } else {
            this.locationLat = d3;
        }
        if ((131072 & i) == 0) {
            this.locationLng = null;
        } else {
            this.locationLng = d4;
        }
        this.items = (i & 262144) == 0 ? CollectionsKt.emptyList() : list;
    }

    public ShopOrder(long j, String orderNumber, String str, String str2, String str3, String status, String str4, double d, String createdAt, String str5, String str6, double d2, String str7, String str8, String str9, String str10, Double d3, Double d4, List<ShopOrderItem> items) {
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(items, "items");
        this.id = j;
        this.orderNumber = orderNumber;
        this.customerName = str;
        this.customerPhone = str2;
        this.address = str3;
        this.status = status;
        this.note = str4;
        this.totalAmount = d;
        this.createdAt = createdAt;
        this.email = str5;
        this.deliveryType = str6;
        this.deliveryPrice = d2;
        this.confirmedAt = str7;
        this.completedAt = str8;
        this.cancelledAt = str9;
        this.cancelReason = str10;
        this.locationLat = d3;
        this.locationLng = d4;
        this.items = items;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ShopOrder self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.orderNumber, "")) {
            output.encodeSerializableElement(serialDesc, 1, LenientString.INSTANCE, self.orderNumber);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.customerName != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.customerName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.customerPhone != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.customerPhone);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.address != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.address);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.status, "")) {
            output.encodeStringElement(serialDesc, 5, self.status);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.note != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.note);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || Double.compare(self.totalAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 7, LenientDouble.INSTANCE, Double.valueOf(self.totalAmount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.createdAt, "")) {
            output.encodeStringElement(serialDesc, 8, self.createdAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.email != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.email);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.deliveryType != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.deliveryType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || Double.compare(self.deliveryPrice, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 11, LenientDouble.INSTANCE, Double.valueOf(self.deliveryPrice));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.confirmedAt != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.confirmedAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.completedAt != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.completedAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.cancelledAt != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.cancelledAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.cancelReason != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.cancelReason);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.locationLat != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, DoubleSerializer.INSTANCE, self.locationLat);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.locationLng != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, DoubleSerializer.INSTANCE, self.locationLng);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 18) && Intrinsics.areEqual(self.items, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 18, lazyArr[18].getValue(), self.items);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ ShopOrder(long r23, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, double r31, java.lang.String r33, java.lang.String r34, java.lang.String r35, double r36, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.Double r42, java.lang.Double r43, java.util.List r44, int r45, kotlin.jvm.internal.DefaultConstructorMarker r46) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.data.model.ShopOrder.<init>(long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double, java.lang.String, java.lang.String, java.lang.String, double, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Double, java.lang.Double, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final long getId() {
        return this.id;
    }

    public final String getOrderNumber() {
        return this.orderNumber;
    }

    public final String getCustomerName() {
        return this.customerName;
    }

    public final String getCustomerPhone() {
        return this.customerPhone;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getNote() {
        return this.note;
    }

    public final double getTotalAmount() {
        return this.totalAmount;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getDeliveryType() {
        return this.deliveryType;
    }

    public final double getDeliveryPrice() {
        return this.deliveryPrice;
    }

    public final String getConfirmedAt() {
        return this.confirmedAt;
    }

    public final String getCompletedAt() {
        return this.completedAt;
    }

    public final String getCancelledAt() {
        return this.cancelledAt;
    }

    public final String getCancelReason() {
        return this.cancelReason;
    }

    public final Double getLocationLat() {
        return this.locationLat;
    }

    public final Double getLocationLng() {
        return this.locationLng;
    }

    public final List<ShopOrderItem> getItems() {
        return this.items;
    }
}
