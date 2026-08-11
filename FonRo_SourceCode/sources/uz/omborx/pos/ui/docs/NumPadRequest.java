package uz.FonRo.pos.ui.docs;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: StockInScreen.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\f\b \u0012\b\b!\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001f"}, d2 = {"Luz/FonRo/pos/ui/docs/NumPadRequest;", "", "title", "", "initial", "", "allowDecimal", "", "onDone", "Lkotlin/Function1;", "", "<init>", "(Ljava/lang/String;DZLkotlin/jvm/functions/Function1;)V", "getTitle", "()Ljava/lang/String;", "getInitial", "()D", "getAllowDecimal", "()Z", "getOnDone", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "copy", "equals", WriteOffReason.OTHER, "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class NumPadRequest {
    public static final int $stable = 0;
    private final boolean allowDecimal;
    private final double initial;
    private final Function1<Double, Unit> onDone;
    private final String title;

    public static /* synthetic */ NumPadRequest copy$default(NumPadRequest numPadRequest, String str, double d, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = numPadRequest.title;
        }
        if ((i & 2) != 0) {
            d = numPadRequest.initial;
        }
        if ((i & 4) != 0) {
            z = numPadRequest.allowDecimal;
        }
        if ((i & 8) != 0) {
            function1 = numPadRequest.onDone;
        }
        return numPadRequest.copy(str, d, z, function1);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final double getInitial() {
        return this.initial;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAllowDecimal() {
        return this.allowDecimal;
    }

    public final Function1<Double, Unit> component4() {
        return this.onDone;
    }

    public final NumPadRequest copy(String title, double initial, boolean allowDecimal, Function1<? super Double, Unit> onDone) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onDone, "onDone");
        return new NumPadRequest(title, initial, allowDecimal, onDone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NumPadRequest)) {
            return false;
        }
        NumPadRequest numPadRequest = (NumPadRequest) other;
        return Intrinsics.areEqual(this.title, numPadRequest.title) && Double.compare(this.initial, numPadRequest.initial) == 0 && this.allowDecimal == numPadRequest.allowDecimal && Intrinsics.areEqual(this.onDone, numPadRequest.onDone);
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + Double.hashCode(this.initial)) * 31) + Boolean.hashCode(this.allowDecimal)) * 31) + this.onDone.hashCode();
    }

    public String toString() {
        return "NumPadRequest(title=" + this.title + ", initial=" + this.initial + ", allowDecimal=" + this.allowDecimal + ", onDone=" + this.onDone + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NumPadRequest(String title, double d, boolean z, Function1<? super Double, Unit> onDone) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onDone, "onDone");
        this.title = title;
        this.initial = d;
        this.allowDecimal = z;
        this.onDone = onDone;
    }

    public /* synthetic */ NumPadRequest(String str, double d, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, d, (i & 4) != 0 ? true : z, function1);
    }

    public final String getTitle() {
        return this.title;
    }

    public final double getInitial() {
        return this.initial;
    }

    public final boolean getAllowDecimal() {
        return this.allowDecimal;
    }

    public final Function1<Double, Unit> getOnDone() {
        return this.onDone;
    }
}
