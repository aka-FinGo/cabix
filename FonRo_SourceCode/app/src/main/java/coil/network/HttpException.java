package coil.network;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import okhttp3.Response;

/* compiled from: HttpException.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00060\u0002j\u0002`\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcoil/network/HttpException;", "Lkotlin/RuntimeException;", "Ljava/lang/RuntimeException;", "response", "Lokhttp3/Response;", "<init>", "(Lokhttp3/Response;)V", "getResponse", "()Lokhttp3/Response;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes6.dex */
public final class HttpException extends RuntimeException {
    private final Response response;

    public final Response getResponse() {
        return this.response;
    }

    public HttpException(Response response) {
        super("HTTP " + response.code() + ": " + response.message());
        this.response = response;
    }
}
