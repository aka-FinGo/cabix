package coil.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: Time.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcoil/util/Time;", "", "<init>", "()V", "provider", "Lkotlin/Function0;", "", "currentMillis", "setCurrentMillis", "", "reset", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class Time {
    public static final Time INSTANCE = new Time();
    private static Function0<Long> provider = Time$provider$1.INSTANCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final long setCurrentMillis$lambda$0(long j) {
        return j;
    }

    private Time() {
    }

    public final long currentMillis() {
        return provider.invoke().longValue();
    }

    public final void setCurrentMillis(final long currentMillis) {
        provider = new Function0() { // from class: coil.util.Time$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(Time.setCurrentMillis$lambda$0(currentMillis));
            }
        };
    }

    public final void reset() {
        provider = Time$reset$1.INSTANCE;
    }
}
