package uz.FonRo.pos.data.net;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElement;

/* compiled from: ApiEnvelope.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0005\u001a\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0015"}, d2 = {"Luz/FonRo/pos/data/net/ApiException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", NotificationCompat.CATEGORY_STATUS, "", "message", "", "payload", "Lkotlinx/serialization/json/JsonElement;", "offline", "", "<init>", "(ILjava/lang/String;Lkotlinx/serialization/json/JsonElement;Z)V", "getStatus", "()I", "getMessage", "()Ljava/lang/String;", "getPayload", "()Lkotlinx/serialization/json/JsonElement;", "getOffline", "()Z", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class ApiException extends Exception {
    public static final int $stable = 8;
    private final String message;
    private final boolean offline;
    private final JsonElement payload;
    private final int status;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiException(int i, String message, JsonElement jsonElement, boolean z) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
        this.status = i;
        this.message = message;
        this.payload = jsonElement;
        this.offline = z;
    }

    public /* synthetic */ ApiException(int i, String str, JsonElement jsonElement, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : jsonElement, (i2 & 8) != 0 ? false : z);
    }

    public final int getStatus() {
        return this.status;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public final JsonElement getPayload() {
        return this.payload;
    }

    public final boolean getOffline() {
        return this.offline;
    }
}
