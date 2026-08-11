package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
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
import uz.FonRo.pos.data.net.LenientBool;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Money.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 R2\u00020\u0001:\u0002QRBo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011Bs\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0010\u0010\u0016J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010?\u001a\u00020\fHÆ\u0003J\t\u0010@\u001a\u00020\fHÆ\u0003J\t\u0010A\u001a\u00020\fHÆ\u0003J\t\u0010B\u001a\u00020\fHÆ\u0003Jq\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\fHÆ\u0001J\u0014\u0010D\u001a\u00020\f2\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010F\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010G\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0001b\u0002\bP¢\u0006\u0002\bOR*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\t0\u001d¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR*\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\t0#¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\"R*\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR,\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b&\u0012\b\b'\u0012\u0004\b\b(,¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0018\u001a\u0004\b+\u0010\u001fR8\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004r\f\b&\u0012\b\b'\u0012\u0004\b\b(/r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\t00¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0018\u001a\u0004\b\u000b\u0010.R8\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004r\f\b&\u0012\b\b'\u0012\u0004\b\b(2r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\t00¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u0018\u001a\u0004\b\r\u0010.R8\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004r\f\b&\u0012\b\b'\u0012\u0004\b\b(5r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\t00¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u0018\u001a\u0004\b4\u0010.R8\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004r\f\b&\u0012\b\b'\u0012\u0004\b\b(8r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\t00¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u0018\u001a\u0004\b7\u0010.Ê\u0001\u0002\b\u001bÊ\u0001\f\bT\u0012\b\bU\u0012\u0004\b\u0003\u0010\u0002¨\u0006S"}, d2 = {"Luz/FonRo/pos/data/model/Expense;", "", "id", "", "title", "", "amount", "", "expenseDate", "note", "createdByName", "isCanceled", "", "isCancellation", "canEdit", "canCancel", "<init>", "(JLjava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getTitle", "()Ljava/lang/String;", "getAmount$annotations", "getAmount", "()D", "Luz/FonRo/pos/data/net/LenientDouble;", "getExpenseDate$annotations", "getExpenseDate", "Lkotlinx/serialization/SerialName;", "value", "expense_date", "getNote", "getCreatedByName$annotations", "getCreatedByName", "created_by_name", "isCanceled$annotations", "()Z", "is_canceled", "Luz/FonRo/pos/data/net/LenientBool;", "isCancellation$annotations", "is_cancellation", "getCanEdit$annotations", "getCanEdit", "can_edit", "getCanCancel$annotations", "getCanCancel", "can_cancel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class Expense {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double amount;
    private final boolean canCancel;
    private final boolean canEdit;
    private final String createdByName;
    private final String expenseDate;
    private final long id;
    private final boolean isCanceled;
    private final boolean isCancellation;
    private final String note;
    private final String title;

    public Expense() {
        this(0L, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, (String) null, (String) null, (String) null, false, false, false, false, 1023, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Expense copy$default(Expense expense, long j, String str, double d, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = expense.id;
        }
        return expense.copy(j, (i & 2) != 0 ? expense.title : str, (i & 4) != 0 ? expense.amount : d, (i & 8) != 0 ? expense.expenseDate : str2, (i & 16) != 0 ? expense.note : str3, (i & 32) != 0 ? expense.createdByName : str4, (i & 64) != 0 ? expense.isCanceled : z, (i & 128) != 0 ? expense.isCancellation : z2, (i & 256) != 0 ? expense.canEdit : z3, (i & 512) != 0 ? expense.canCancel : z4);
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getAmount$annotations() {
    }

    @SerialName("can_cancel")
    @Serializable(with = LenientBool.class)
    public static /* synthetic */ void getCanCancel$annotations() {
    }

    @SerialName("can_edit")
    @Serializable(with = LenientBool.class)
    public static /* synthetic */ void getCanEdit$annotations() {
    }

    @SerialName("created_by_name")
    public static /* synthetic */ void getCreatedByName$annotations() {
    }

    @SerialName("expense_date")
    public static /* synthetic */ void getExpenseDate$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("is_canceled")
    @Serializable(with = LenientBool.class)
    public static /* synthetic */ void isCanceled$annotations() {
    }

    @SerialName("is_cancellation")
    @Serializable(with = LenientBool.class)
    public static /* synthetic */ void isCancellation$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getCanCancel() {
        return this.canCancel;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final double getAmount() {
        return this.amount;
    }

    /* renamed from: component4, reason: from getter */
    public final String getExpenseDate() {
        return this.expenseDate;
    }

    /* renamed from: component5, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCreatedByName() {
        return this.createdByName;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsCanceled() {
        return this.isCanceled;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsCancellation() {
        return this.isCancellation;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getCanEdit() {
        return this.canEdit;
    }

    public final Expense copy(long id, String title, double amount, String expenseDate, String note, String createdByName, boolean isCanceled, boolean isCancellation, boolean canEdit, boolean canCancel) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(expenseDate, "expenseDate");
        return new Expense(id, title, amount, expenseDate, note, createdByName, isCanceled, isCancellation, canEdit, canCancel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Expense)) {
            return false;
        }
        Expense expense = (Expense) other;
        return this.id == expense.id && Intrinsics.areEqual(this.title, expense.title) && Double.compare(this.amount, expense.amount) == 0 && Intrinsics.areEqual(this.expenseDate, expense.expenseDate) && Intrinsics.areEqual(this.note, expense.note) && Intrinsics.areEqual(this.createdByName, expense.createdByName) && this.isCanceled == expense.isCanceled && this.isCancellation == expense.isCancellation && this.canEdit == expense.canEdit && this.canCancel == expense.canCancel;
    }

    public int hashCode() {
        int hashCode = ((((((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Double.hashCode(this.amount)) * 31) + this.expenseDate.hashCode()) * 31;
        String str = this.note;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.createdByName;
        return ((((((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Boolean.hashCode(this.isCanceled)) * 31) + Boolean.hashCode(this.isCancellation)) * 31) + Boolean.hashCode(this.canEdit)) * 31) + Boolean.hashCode(this.canCancel);
    }

    public String toString() {
        return "Expense(id=" + this.id + ", title=" + this.title + ", amount=" + this.amount + ", expenseDate=" + this.expenseDate + ", note=" + this.note + ", createdByName=" + this.createdByName + ", isCanceled=" + this.isCanceled + ", isCancellation=" + this.isCancellation + ", canEdit=" + this.canEdit + ", canCancel=" + this.canCancel + ")";
    }

    /* compiled from: Money.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/Expense$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/Expense;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Expense> serializer() {
            return Expense$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Expense(int i, long j, String str, double d, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, SerializationConstructorMarker serializationConstructorMarker) {
        this.id = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.title = "";
        } else {
            this.title = str;
        }
        if ((i & 4) == 0) {
            this.amount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.amount = d;
        }
        if ((i & 8) == 0) {
            this.expenseDate = "";
        } else {
            this.expenseDate = str2;
        }
        if ((i & 16) == 0) {
            this.note = null;
        } else {
            this.note = str3;
        }
        if ((i & 32) == 0) {
            this.createdByName = null;
        } else {
            this.createdByName = str4;
        }
        if ((i & 64) == 0) {
            this.isCanceled = false;
        } else {
            this.isCanceled = z;
        }
        if ((i & 128) == 0) {
            this.isCancellation = false;
        } else {
            this.isCancellation = z2;
        }
        if ((i & 256) == 0) {
            this.canEdit = false;
        } else {
            this.canEdit = z3;
        }
        if ((i & 512) == 0) {
            this.canCancel = false;
        } else {
            this.canCancel = z4;
        }
    }

    public Expense(long j, String title, double d, String expenseDate, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(expenseDate, "expenseDate");
        this.id = j;
        this.title = title;
        this.amount = d;
        this.expenseDate = expenseDate;
        this.note = str;
        this.createdByName = str2;
        this.isCanceled = z;
        this.isCancellation = z2;
        this.canEdit = z3;
        this.canCancel = z4;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(Expense self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.title, "")) {
            output.encodeStringElement(serialDesc, 1, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || Double.compare(self.amount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 2, LenientDouble.INSTANCE, Double.valueOf(self.amount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.expenseDate, "")) {
            output.encodeStringElement(serialDesc, 3, self.expenseDate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.note != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.note);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.createdByName != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.createdByName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.isCanceled) {
            output.encodeSerializableElement(serialDesc, 6, LenientBool.INSTANCE, Boolean.valueOf(self.isCanceled));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.isCancellation) {
            output.encodeSerializableElement(serialDesc, 7, LenientBool.INSTANCE, Boolean.valueOf(self.isCancellation));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.canEdit) {
            output.encodeSerializableElement(serialDesc, 8, LenientBool.INSTANCE, Boolean.valueOf(self.canEdit));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.canCancel) {
            output.encodeSerializableElement(serialDesc, 9, LenientBool.INSTANCE, Boolean.valueOf(self.canCancel));
        }
    }

    public /* synthetic */ Expense(long j, String str, double d, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : d, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? false : z, (i & 128) != 0 ? false : z2, (i & 256) != 0 ? false : z3, (i & 512) != 0 ? false : z4);
    }

    public final long getId() {
        return this.id;
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

    public final String getNote() {
        return this.note;
    }

    public final String getCreatedByName() {
        return this.createdByName;
    }

    public final boolean isCanceled() {
        return this.isCanceled;
    }

    public final boolean isCancellation() {
        return this.isCancellation;
    }

    public final boolean getCanEdit() {
        return this.canEdit;
    }

    public final boolean getCanCancel() {
        return this.canCancel;
    }
}
