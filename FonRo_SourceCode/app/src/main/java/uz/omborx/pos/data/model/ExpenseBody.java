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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Money.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tBA\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J1\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001b\u0002\b,¢\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R*\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010Ê\u0001\u0002\b0Ê\u0001\f\b1\u0012\b\b2\u0012\u0004\b\u0003\u0010\u0002¨\u0006/"}, d2 = {"Luz/FonRo/pos/data/model/ExpenseBody;", "", "title", "", "amount", "", "expenseDate", "note", "<init>", "(Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;DLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getAmount", "()D", "getExpenseDate$annotations", "()V", "getExpenseDate", "Lkotlinx/serialization/SerialName;", "value", "expense_date", "getNote", "component1", "component2", "component3", "component4", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ExpenseBody {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double amount;
    private final String expenseDate;
    private final String note;
    private final String title;

    public static /* synthetic */ ExpenseBody copy$default(ExpenseBody expenseBody, String str, double d, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = expenseBody.title;
        }
        if ((i & 2) != 0) {
            d = expenseBody.amount;
        }
        if ((i & 4) != 0) {
            str2 = expenseBody.expenseDate;
        }
        if ((i & 8) != 0) {
            str3 = expenseBody.note;
        }
        return expenseBody.copy(str, d, str2, str3);
    }

    @SerialName("expense_date")
    public static /* synthetic */ void getExpenseDate$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final double getAmount() {
        return this.amount;
    }

    /* renamed from: component3, reason: from getter */
    public final String getExpenseDate() {
        return this.expenseDate;
    }

    /* renamed from: component4, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    public final ExpenseBody copy(String title, double amount, String expenseDate, String note) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(expenseDate, "expenseDate");
        Intrinsics.checkNotNullParameter(note, "note");
        return new ExpenseBody(title, amount, expenseDate, note);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExpenseBody)) {
            return false;
        }
        ExpenseBody expenseBody = (ExpenseBody) other;
        return Intrinsics.areEqual(this.title, expenseBody.title) && Double.compare(this.amount, expenseBody.amount) == 0 && Intrinsics.areEqual(this.expenseDate, expenseBody.expenseDate) && Intrinsics.areEqual(this.note, expenseBody.note);
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + Double.hashCode(this.amount)) * 31) + this.expenseDate.hashCode()) * 31) + this.note.hashCode();
    }

    public String toString() {
        return "ExpenseBody(title=" + this.title + ", amount=" + this.amount + ", expenseDate=" + this.expenseDate + ", note=" + this.note + ")";
    }

    /* compiled from: Money.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/ExpenseBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/ExpenseBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ExpenseBody> serializer() {
            return ExpenseBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ExpenseBody(int i, String str, double d, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, ExpenseBody$$serializer.INSTANCE.getDescriptor());
        }
        this.title = str;
        this.amount = d;
        this.expenseDate = str2;
        if ((i & 8) == 0) {
            this.note = "";
        } else {
            this.note = str3;
        }
    }

    public ExpenseBody(String title, double d, String expenseDate, String note) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(expenseDate, "expenseDate");
        Intrinsics.checkNotNullParameter(note, "note");
        this.title = title;
        this.amount = d;
        this.expenseDate = expenseDate;
        this.note = note;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ExpenseBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.title);
        output.encodeDoubleElement(serialDesc, 1, self.amount);
        output.encodeStringElement(serialDesc, 2, self.expenseDate);
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && Intrinsics.areEqual(self.note, "")) {
            return;
        }
        output.encodeStringElement(serialDesc, 3, self.note);
    }

    public final String getTitle() {
        return this.title;
    }

    public final double getAmount() {
        return this.amount;
    }

    public final String getExpenseDate() {
        return this.expenseDate;
    }

    public /* synthetic */ ExpenseBody(String str, double d, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, d, str2, (i & 8) != 0 ? "" : str3);
    }

    public final String getNote() {
        return this.note;
    }
}
