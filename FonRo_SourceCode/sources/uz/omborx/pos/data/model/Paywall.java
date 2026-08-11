package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientBool;
import uz.FonRo.pos.data.net.LenientInt;

/* compiled from: Auth.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 S2\u00020\u0001:\u0002RSB\u0083\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013B\u0083\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0012\u0010\u0017J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0085\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0014\u0010E\u001a\u00020\u00032\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010G\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010H\u001a\u00020\u000bHÖ\u0081\u0004J)\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0001b\u0002\bQ¢\u0006\u0002\bPR*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\t0\u001e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR*\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\t0\u001e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001bR*\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\t0\u001e¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001bR*\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\t0&¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010%R*\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\t0&¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0019\u001a\u0004\b(\u0010%R8\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b+\u0012\b\b,\u0012\u0004\b\b(-r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\t0&¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010%R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R,\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004r\f\b+\u0012\b\b,\u0012\u0004\b\b(7¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u0019\u001a\u0004\b6\u0010/R\u0011\u00108\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b8\u0010\u001bÊ\u0001\u0002\b\u001cÊ\u0001\f\bU\u0012\b\bV\u0012\u0004\b\u0003\u0010\u0000¨\u0006T"}, d2 = {"Luz/FonRo/pos/data/model/Paywall;", "", "enabled", "", "locked", "subscribed", "limit", "", "remaining", "webSales", NotificationCompat.CATEGORY_STATUS, "", "until", "plan", "Luz/FonRo/pos/data/model/Plan;", "plans", "", "checkoutUrl", "<init>", "(ZZZIIILjava/lang/String;Ljava/lang/String;Luz/FonRo/pos/data/model/Plan;Ljava/util/List;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZZZIIILjava/lang/String;Ljava/lang/String;Luz/FonRo/pos/data/model/Plan;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEnabled$annotations", "()V", "getEnabled", "()Z", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientBool;", "getLocked$annotations", "getLocked", "getSubscribed$annotations", "getSubscribed", "getLimit$annotations", "getLimit", "()I", "Luz/FonRo/pos/data/net/LenientInt;", "getRemaining$annotations", "getRemaining", "getWebSales$annotations", "getWebSales", "Lkotlinx/serialization/SerialName;", "value", "web_sales", "getStatus", "()Ljava/lang/String;", "getUntil", "getPlan", "()Luz/FonRo/pos/data/model/Plan;", "getPlans", "()Ljava/util/List;", "getCheckoutUrl$annotations", "getCheckoutUrl", "checkout_url", "isLocked", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class Paywall {
    private final String checkoutUrl;
    private final boolean enabled;
    private final int limit;
    private final boolean locked;
    private final Plan plan;
    private final List<Plan> plans;
    private final int remaining;
    private final String status;
    private final boolean subscribed;
    private final String until;
    private final int webSales;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.Paywall$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = Paywall._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null};

    public Paywall() {
        this(false, false, false, 0, 0, 0, (String) null, (String) null, (Plan) null, (List) null, (String) null, 2047, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(Plan$$serializer.INSTANCE);
    }

    public static /* synthetic */ Paywall copy$default(Paywall paywall, boolean z, boolean z2, boolean z3, int i, int i2, int i3, String str, String str2, Plan plan, List list, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = paywall.enabled;
        }
        if ((i4 & 2) != 0) {
            z2 = paywall.locked;
        }
        if ((i4 & 4) != 0) {
            z3 = paywall.subscribed;
        }
        if ((i4 & 8) != 0) {
            i = paywall.limit;
        }
        if ((i4 & 16) != 0) {
            i2 = paywall.remaining;
        }
        if ((i4 & 32) != 0) {
            i3 = paywall.webSales;
        }
        if ((i4 & 64) != 0) {
            str = paywall.status;
        }
        if ((i4 & 128) != 0) {
            str2 = paywall.until;
        }
        if ((i4 & 256) != 0) {
            plan = paywall.plan;
        }
        if ((i4 & 512) != 0) {
            list = paywall.plans;
        }
        if ((i4 & 1024) != 0) {
            str3 = paywall.checkoutUrl;
        }
        List list2 = list;
        String str4 = str3;
        String str5 = str2;
        Plan plan2 = plan;
        int i5 = i3;
        String str6 = str;
        int i6 = i2;
        boolean z4 = z3;
        return paywall.copy(z, z2, z4, i, i6, i5, str6, str5, plan2, list2, str4);
    }

    @SerialName("checkout_url")
    public static /* synthetic */ void getCheckoutUrl$annotations() {
    }

    @Serializable(with = LenientBool.class)
    public static /* synthetic */ void getEnabled$annotations() {
    }

    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getLimit$annotations() {
    }

    @Serializable(with = LenientBool.class)
    public static /* synthetic */ void getLocked$annotations() {
    }

    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getRemaining$annotations() {
    }

    @Serializable(with = LenientBool.class)
    public static /* synthetic */ void getSubscribed$annotations() {
    }

    @SerialName("web_sales")
    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getWebSales$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<Plan> component10() {
        return this.plans;
    }

    /* renamed from: component11, reason: from getter */
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getLocked() {
        return this.locked;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSubscribed() {
        return this.subscribed;
    }

    /* renamed from: component4, reason: from getter */
    public final int getLimit() {
        return this.limit;
    }

    /* renamed from: component5, reason: from getter */
    public final int getRemaining() {
        return this.remaining;
    }

    /* renamed from: component6, reason: from getter */
    public final int getWebSales() {
        return this.webSales;
    }

    /* renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component8, reason: from getter */
    public final String getUntil() {
        return this.until;
    }

    /* renamed from: component9, reason: from getter */
    public final Plan getPlan() {
        return this.plan;
    }

    public final Paywall copy(boolean enabled, boolean locked, boolean subscribed, int limit, int remaining, int webSales, String status, String until, Plan plan, List<Plan> plans, String checkoutUrl) {
        Intrinsics.checkNotNullParameter(plans, "plans");
        return new Paywall(enabled, locked, subscribed, limit, remaining, webSales, status, until, plan, plans, checkoutUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Paywall)) {
            return false;
        }
        Paywall paywall = (Paywall) other;
        return this.enabled == paywall.enabled && this.locked == paywall.locked && this.subscribed == paywall.subscribed && this.limit == paywall.limit && this.remaining == paywall.remaining && this.webSales == paywall.webSales && Intrinsics.areEqual(this.status, paywall.status) && Intrinsics.areEqual(this.until, paywall.until) && Intrinsics.areEqual(this.plan, paywall.plan) && Intrinsics.areEqual(this.plans, paywall.plans) && Intrinsics.areEqual(this.checkoutUrl, paywall.checkoutUrl);
    }

    public int hashCode() {
        int hashCode = ((((((((((Boolean.hashCode(this.enabled) * 31) + Boolean.hashCode(this.locked)) * 31) + Boolean.hashCode(this.subscribed)) * 31) + Integer.hashCode(this.limit)) * 31) + Integer.hashCode(this.remaining)) * 31) + Integer.hashCode(this.webSales)) * 31;
        String str = this.status;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.until;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Plan plan = this.plan;
        int hashCode4 = (((hashCode3 + (plan == null ? 0 : plan.hashCode())) * 31) + this.plans.hashCode()) * 31;
        String str3 = this.checkoutUrl;
        return hashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "Paywall(enabled=" + this.enabled + ", locked=" + this.locked + ", subscribed=" + this.subscribed + ", limit=" + this.limit + ", remaining=" + this.remaining + ", webSales=" + this.webSales + ", status=" + this.status + ", until=" + this.until + ", plan=" + this.plan + ", plans=" + this.plans + ", checkoutUrl=" + this.checkoutUrl + ")";
    }

    /* compiled from: Auth.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/Paywall$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/Paywall;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Paywall> serializer() {
            return Paywall$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Paywall(int i, boolean z, boolean z2, boolean z3, int i2, int i3, int i4, String str, String str2, Plan plan, List list, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.enabled = false;
        } else {
            this.enabled = z;
        }
        if ((i & 2) == 0) {
            this.locked = false;
        } else {
            this.locked = z2;
        }
        if ((i & 4) == 0) {
            this.subscribed = false;
        } else {
            this.subscribed = z3;
        }
        if ((i & 8) == 0) {
            this.limit = 15;
        } else {
            this.limit = i2;
        }
        if ((i & 16) == 0) {
            this.remaining = 0;
        } else {
            this.remaining = i3;
        }
        if ((i & 32) == 0) {
            this.webSales = 0;
        } else {
            this.webSales = i4;
        }
        if ((i & 64) == 0) {
            this.status = null;
        } else {
            this.status = str;
        }
        if ((i & 128) == 0) {
            this.until = null;
        } else {
            this.until = str2;
        }
        if ((i & 256) == 0) {
            this.plan = null;
        } else {
            this.plan = plan;
        }
        if ((i & 512) == 0) {
            this.plans = CollectionsKt.emptyList();
        } else {
            this.plans = list;
        }
        if ((i & 1024) == 0) {
            this.checkoutUrl = null;
        } else {
            this.checkoutUrl = str3;
        }
    }

    public Paywall(boolean z, boolean z2, boolean z3, int i, int i2, int i3, String str, String str2, Plan plan, List<Plan> plans, String str3) {
        Intrinsics.checkNotNullParameter(plans, "plans");
        this.enabled = z;
        this.locked = z2;
        this.subscribed = z3;
        this.limit = i;
        this.remaining = i2;
        this.webSales = i3;
        this.status = str;
        this.until = str2;
        this.plan = plan;
        this.plans = plans;
        this.checkoutUrl = str3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(Paywall self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.enabled) {
            output.encodeSerializableElement(serialDesc, 0, LenientBool.INSTANCE, Boolean.valueOf(self.enabled));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.locked) {
            output.encodeSerializableElement(serialDesc, 1, LenientBool.INSTANCE, Boolean.valueOf(self.locked));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.subscribed) {
            output.encodeSerializableElement(serialDesc, 2, LenientBool.INSTANCE, Boolean.valueOf(self.subscribed));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.limit != 15) {
            output.encodeSerializableElement(serialDesc, 3, LenientInt.INSTANCE, Integer.valueOf(self.limit));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.remaining != 0) {
            output.encodeSerializableElement(serialDesc, 4, LenientInt.INSTANCE, Integer.valueOf(self.remaining));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.webSales != 0) {
            output.encodeSerializableElement(serialDesc, 5, LenientInt.INSTANCE, Integer.valueOf(self.webSales));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.status != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.status);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.until != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.until);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.plan != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, Plan$$serializer.INSTANCE, self.plan);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.plans, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 9, lazyArr[9].getValue(), self.plans);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 10) && self.checkoutUrl == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.checkoutUrl);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getLocked() {
        return this.locked;
    }

    public final boolean getSubscribed() {
        return this.subscribed;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final int getRemaining() {
        return this.remaining;
    }

    public final int getWebSales() {
        return this.webSales;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getUntil() {
        return this.until;
    }

    public final Plan getPlan() {
        return this.plan;
    }

    public /* synthetic */ Paywall(boolean z, boolean z2, boolean z3, int i, int i2, int i3, String str, String str2, Plan plan, List list, String str3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? false : z2, (i4 & 4) != 0 ? false : z3, (i4 & 8) != 0 ? 15 : i, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? 0 : i3, (i4 & 64) != 0 ? null : str, (i4 & 128) != 0 ? null : str2, (i4 & 256) != 0 ? null : plan, (i4 & 512) != 0 ? CollectionsKt.emptyList() : list, (i4 & 1024) != 0 ? null : str3);
    }

    public final List<Plan> getPlans() {
        return this.plans;
    }

    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    public final boolean isLocked() {
        return this.enabled && this.locked && !this.subscribed;
    }
}
