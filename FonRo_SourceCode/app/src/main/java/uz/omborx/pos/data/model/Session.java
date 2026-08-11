package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Auth.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001b\u0002\b+¢\u0006\u0002\b*R,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019Ê\u0001\u0002\b/Ê\u0001\f\b0\u0012\b\b1\u0012\u0004\b\u0003\u0010\u0002¨\u0006."}, d2 = {"Luz/FonRo/pos/data/model/Session;", "", "apiToken", "", "user", "Luz/FonRo/pos/data/model/User;", "store", "Luz/FonRo/pos/data/model/Store;", "<init>", "(Ljava/lang/String;Luz/FonRo/pos/data/model/User;Luz/FonRo/pos/data/model/Store;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Luz/FonRo/pos/data/model/User;Luz/FonRo/pos/data/model/Store;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getApiToken$annotations", "()V", "getApiToken", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "api_token", "getUser", "()Luz/FonRo/pos/data/model/User;", "getStore", "()Luz/FonRo/pos/data/model/Store;", "component1", "component2", "component3", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class Session {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String apiToken;
    private final Store store;
    private final User user;

    public Session() {
        this((String) null, (User) null, (Store) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Session copy$default(Session session, String str, User user, Store store, int i, Object obj) {
        if ((i & 1) != 0) {
            str = session.apiToken;
        }
        if ((i & 2) != 0) {
            user = session.user;
        }
        if ((i & 4) != 0) {
            store = session.store;
        }
        return session.copy(str, user, store);
    }

    @SerialName("api_token")
    public static /* synthetic */ void getApiToken$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getApiToken() {
        return this.apiToken;
    }

    /* renamed from: component2, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component3, reason: from getter */
    public final Store getStore() {
        return this.store;
    }

    public final Session copy(String apiToken, User user, Store store) {
        return new Session(apiToken, user, store);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Session)) {
            return false;
        }
        Session session = (Session) other;
        return Intrinsics.areEqual(this.apiToken, session.apiToken) && Intrinsics.areEqual(this.user, session.user) && Intrinsics.areEqual(this.store, session.store);
    }

    public int hashCode() {
        String str = this.apiToken;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        User user = this.user;
        int hashCode2 = (hashCode + (user == null ? 0 : user.hashCode())) * 31;
        Store store = this.store;
        return hashCode2 + (store != null ? store.hashCode() : 0);
    }

    public String toString() {
        return "Session(apiToken=" + this.apiToken + ", user=" + this.user + ", store=" + this.store + ")";
    }

    /* compiled from: Auth.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/Session$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/Session;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Session> serializer() {
            return Session$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Session(int i, String str, User user, Store store, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.apiToken = null;
        } else {
            this.apiToken = str;
        }
        if ((i & 2) == 0) {
            this.user = null;
        } else {
            this.user = user;
        }
        if ((i & 4) == 0) {
            this.store = null;
        } else {
            this.store = store;
        }
    }

    public Session(String str, User user, Store store) {
        this.apiToken = str;
        this.user = user;
        this.store = store;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(Session self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.apiToken != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.apiToken);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.user != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, User$$serializer.INSTANCE, self.user);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.store == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, Store$$serializer.INSTANCE, self.store);
    }

    public /* synthetic */ Session(String str, User user, Store store, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : user, (i & 4) != 0 ? null : store);
    }

    public final String getApiToken() {
        return this.apiToken;
    }

    public final User getUser() {
        return this.user;
    }

    public final Store getStore() {
        return this.store;
    }
}
