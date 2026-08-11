package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: TimeSource.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦\u0080\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0096\u0082\u0004¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0096\u0082\u0004¢\u0006\u0004\b\u000b\u0010\tJ\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010\u000e\u001a\u00020\rH\u0096\u0080\u0004Ê\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012Ê\u0001\u0010\b\u0013\u0012\f\b\u0014\u0012\b\b\fJ\u0004\b\t0\u0015¨\u0006\u000f"}, d2 = {"Lkotlin/time/TimeMark;", "", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "plus", TypedValues.TransitionType.S_DURATION, "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "minus", "minus-LRDsOJo", "hasPassedNow", "", "hasNotPassedNow", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/time/ExperimentalTime;"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes6.dex */
public interface TimeMark {
    /* renamed from: elapsedNow-UwyO8pc */
    long mo9272elapsedNowUwyO8pc();

    boolean hasNotPassedNow();

    boolean hasPassedNow();

    /* renamed from: minus-LRDsOJo */
    TimeMark mo9273minusLRDsOJo(long duration);

    /* renamed from: plus-LRDsOJo */
    TimeMark mo9275plusLRDsOJo(long duration);

    /* compiled from: TimeSource.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        /* renamed from: plus-LRDsOJo, reason: not valid java name */
        public static TimeMark m9400plusLRDsOJo(TimeMark timeMark, long j) {
            return new AdjustedTimeMark(timeMark, j, null);
        }

        /* renamed from: minus-LRDsOJo, reason: not valid java name */
        public static TimeMark m9399minusLRDsOJo(TimeMark timeMark, long j) {
            return timeMark.mo9275plusLRDsOJo(Duration.m9328unaryMinusUwyO8pc(j));
        }

        public static boolean hasPassedNow(TimeMark timeMark) {
            return !Duration.m9310isNegativeimpl(timeMark.mo9272elapsedNowUwyO8pc());
        }

        public static boolean hasNotPassedNow(TimeMark timeMark) {
            return Duration.m9310isNegativeimpl(timeMark.mo9272elapsedNowUwyO8pc());
        }
    }
}
