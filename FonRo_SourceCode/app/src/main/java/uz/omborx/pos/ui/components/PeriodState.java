package uz.FonRo.pos.ui.components;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: Chips.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000fJ\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fÊ\u0001\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001d"}, d2 = {"Luz/FonRo/pos/ui/components/PeriodState;", "", "kind", "Luz/FonRo/pos/ui/components/PeriodKind;", "month", "", "date", "<init>", "(Luz/FonRo/pos/ui/components/PeriodKind;Ljava/lang/String;Ljava/lang/String;)V", "getKind", "()Luz/FonRo/pos/ui/components/PeriodKind;", "getMonth", "()Ljava/lang/String;", "getDate", "range", "Lkotlin/Pair;", "title", "contains", "", "value", "component1", "component2", "component3", "copy", "equals", WriteOffReason.OTHER, "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class PeriodState {
    public static final int $stable = 0;
    private final String date;
    private final PeriodKind kind;
    private final String month;

    /* compiled from: Chips.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PeriodKind.values().length];
            try {
                iArr[PeriodKind.TODAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PeriodKind.DAYS_10.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PeriodKind.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PeriodKind.DATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PeriodKind.ALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PeriodState() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PeriodState copy$default(PeriodState periodState, PeriodKind periodKind, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            periodKind = periodState.kind;
        }
        if ((i & 2) != 0) {
            str = periodState.month;
        }
        if ((i & 4) != 0) {
            str2 = periodState.date;
        }
        return periodState.copy(periodKind, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final PeriodKind getKind() {
        return this.kind;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMonth() {
        return this.month;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final PeriodState copy(PeriodKind kind, String month, String date) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(date, "date");
        return new PeriodState(kind, month, date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PeriodState)) {
            return false;
        }
        PeriodState periodState = (PeriodState) other;
        return this.kind == periodState.kind && Intrinsics.areEqual(this.month, periodState.month) && Intrinsics.areEqual(this.date, periodState.date);
    }

    public int hashCode() {
        return (((this.kind.hashCode() * 31) + this.month.hashCode()) * 31) + this.date.hashCode();
    }

    public String toString() {
        return "PeriodState(kind=" + this.kind + ", month=" + this.month + ", date=" + this.date + ")";
    }

    public PeriodState(PeriodKind kind, String month, String date) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(date, "date");
        this.kind = kind;
        this.month = month;
        this.date = date;
    }

    public /* synthetic */ PeriodState(PeriodKind periodKind, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? PeriodKind.TODAY : periodKind, (i & 2) != 0 ? Fmt.INSTANCE.currentYm() : str, (i & 4) != 0 ? Fmt.INSTANCE.todayISO() : str2);
    }

    public final PeriodKind getKind() {
        return this.kind;
    }

    public final String getMonth() {
        return this.month;
    }

    public final String getDate() {
        return this.date;
    }

    public final Pair<String, String> range() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.kind.ordinal()];
        if (i == 1) {
            return TuplesKt.to(Fmt.INSTANCE.todayISO(), Fmt.INSTANCE.todayISO());
        }
        if (i == 2) {
            return TuplesKt.to(Fmt.INSTANCE.daysAgo(9L), Fmt.INSTANCE.todayISO());
        }
        if (i == 3) {
            return Fmt.INSTANCE.monthRange(this.month);
        }
        if (i == 4) {
            String str = this.date;
            return TuplesKt.to(str, str);
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return TuplesKt.to("", "");
    }

    public final String title() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.kind.ordinal()];
        if (i == 1) {
            return Fmt.INSTANCE.dt(Fmt.INSTANCE.todayISO(), false);
        }
        if (i == 2) {
            return LangKt.tx("10 дней", new Object[0]);
        }
        if (i == 3) {
            return Fmt.INSTANCE.monthTitle(this.month);
        }
        if (i == 4) {
            return Fmt.INSTANCE.dt(this.date, false);
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return LangKt.tx("Все", new Object[0]);
    }

    public final boolean contains(String value) {
        String dayOf = Fmt.INSTANCE.dayOf(value);
        int length = dayOf.length();
        PeriodKind periodKind = this.kind;
        if (length == 0) {
            return periodKind == PeriodKind.ALL;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[periodKind.ordinal()];
        if (i == 1) {
            return Intrinsics.areEqual(dayOf, Fmt.INSTANCE.todayISO());
        }
        if (i == 2) {
            return dayOf.compareTo(Fmt.INSTANCE.daysAgo(9L)) >= 0;
        }
        if (i == 3) {
            return StringsKt.startsWith$default(dayOf, this.month, false, 2, (Object) null);
        }
        if (i == 4) {
            return Intrinsics.areEqual(dayOf, this.date);
        }
        if (i == 5) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }
}
