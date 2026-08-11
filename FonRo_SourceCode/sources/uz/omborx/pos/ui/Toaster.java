package uz.FonRo.pos.ui;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.CoroutineLiveDataKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import uz.FonRo.pos.data.model.WriteOffReason;
import uz.FonRo.pos.data.net.ApiClient;

/* compiled from: Toaster.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fÊ\u0001\f\b\u001f\u0012\b\b \u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001e"}, d2 = {"Luz/FonRo/pos/ui/Toaster;", "", "<init>", "()V", "counter", "", "_messages", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Luz/FonRo/pos/ui/Toaster$Message;", "messages", "Lkotlinx/coroutines/flow/SharedFlow;", "getMessages", "()Lkotlinx/coroutines/flow/SharedFlow;", "show", "", "text", "", "kind", "Luz/FonRo/pos/ui/Toaster$Kind;", "durationMs", "actionLabel", "onAction", "Lkotlin/Function0;", "(Ljava/lang/String;Luz/FonRo/pos/ui/Toaster$Kind;Ljava/lang/Long;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "ok", "error", "t", "", "Kind", "Message", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class Toaster {
    public static final int $stable = 0;
    public static final Toaster INSTANCE = new Toaster();
    private static final MutableSharedFlow<Message> _messages;
    private static long counter;
    private static final SharedFlow<Message> messages;

    private Toaster() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Toaster.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/ui/Toaster$Kind;", "", "<init>", "(Ljava/lang/String;I)V", "PLAIN", "OK", "ERROR", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final class Kind {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Kind[] $VALUES;
        public static final Kind PLAIN = new Kind("PLAIN", 0);
        public static final Kind OK = new Kind("OK", 1);
        public static final Kind ERROR = new Kind("ERROR", 2);

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{PLAIN, OK, ERROR};
        }

        public static EnumEntries<Kind> getEntries() {
            return $ENTRIES;
        }

        public static Kind valueOf(String str) {
            return (Kind) Enum.valueOf(Kind.class, str);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        static {
            Kind[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Kind(String str, int i) {
        }
    }

    /* compiled from: Toaster.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020$HÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018Ê\u0001\u0002\b'¨\u0006&"}, d2 = {"Luz/FonRo/pos/ui/Toaster$Message;", "", "id", "", "text", "", "kind", "Luz/FonRo/pos/ui/Toaster$Kind;", "durationMs", "actionLabel", "onAction", "Lkotlin/Function0;", "", "<init>", "(JLjava/lang/String;Luz/FonRo/pos/ui/Toaster$Kind;JLjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getId", "()J", "getText", "()Ljava/lang/String;", "getKind", "()Luz/FonRo/pos/ui/Toaster$Kind;", "getDurationMs", "getActionLabel", "getOnAction", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "app", "Landroidx/compose/runtime/Immutable;"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final /* data */ class Message {
        public static final int $stable = 0;
        private final String actionLabel;
        private final long durationMs;
        private final long id;
        private final Kind kind;
        private final Function0<Unit> onAction;
        private final String text;

        public static /* synthetic */ Message copy$default(Message message, long j, String str, Kind kind, long j2, String str2, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                j = message.id;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                str = message.text;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                kind = message.kind;
            }
            Kind kind2 = kind;
            if ((i & 8) != 0) {
                j2 = message.durationMs;
            }
            return message.copy(j3, str3, kind2, j2, (i & 16) != 0 ? message.actionLabel : str2, (i & 32) != 0 ? message.onAction : function0);
        }

        /* renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component3, reason: from getter */
        public final Kind getKind() {
            return this.kind;
        }

        /* renamed from: component4, reason: from getter */
        public final long getDurationMs() {
            return this.durationMs;
        }

        /* renamed from: component5, reason: from getter */
        public final String getActionLabel() {
            return this.actionLabel;
        }

        public final Function0<Unit> component6() {
            return this.onAction;
        }

        public final Message copy(long id, String text, Kind kind, long durationMs, String actionLabel, Function0<Unit> onAction) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(kind, "kind");
            return new Message(id, text, kind, durationMs, actionLabel, onAction);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Message)) {
                return false;
            }
            Message message = (Message) other;
            return this.id == message.id && Intrinsics.areEqual(this.text, message.text) && this.kind == message.kind && this.durationMs == message.durationMs && Intrinsics.areEqual(this.actionLabel, message.actionLabel) && Intrinsics.areEqual(this.onAction, message.onAction);
        }

        public int hashCode() {
            int hashCode = ((((((Long.hashCode(this.id) * 31) + this.text.hashCode()) * 31) + this.kind.hashCode()) * 31) + Long.hashCode(this.durationMs)) * 31;
            String str = this.actionLabel;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Function0<Unit> function0 = this.onAction;
            return hashCode2 + (function0 != null ? function0.hashCode() : 0);
        }

        public String toString() {
            return "Message(id=" + this.id + ", text=" + this.text + ", kind=" + this.kind + ", durationMs=" + this.durationMs + ", actionLabel=" + this.actionLabel + ", onAction=" + this.onAction + ")";
        }

        public Message(long j, String text, Kind kind, long j2, String str, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(kind, "kind");
            this.id = j;
            this.text = text;
            this.kind = kind;
            this.durationMs = j2;
            this.actionLabel = str;
            this.onAction = function0;
        }

        public final long getId() {
            return this.id;
        }

        public final String getText() {
            return this.text;
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException
            */
        public /* synthetic */ Message(long r10, java.lang.String r12, uz.FonRo.pos.ui.Toaster.Kind r13, long r14, java.lang.String r16, kotlin.jvm.functions.Function0 r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
            /*
                r9 = this;
                r0 = r18 & 4
                if (r0 == 0) goto L6
                uz.FonRo.pos.ui.Toaster$Kind r13 = uz.FonRo.pos.ui.Toaster.Kind.PLAIN
            L6:
                r4 = r13
                r13 = r18 & 8
                if (r13 == 0) goto Lf
                r0 = 2400(0x960, double:1.186E-320)
                r5 = r0
                goto L10
            Lf:
                r5 = r14
            L10:
                r13 = r18 & 16
                r0 = 0
                if (r13 == 0) goto L17
                r7 = r0
                goto L19
            L17:
                r7 = r16
            L19:
                r13 = r18 & 32
                if (r13 == 0) goto L22
                r8 = r0
                r1 = r10
                r3 = r12
                r0 = r9
                goto L27
            L22:
                r8 = r17
                r0 = r9
                r1 = r10
                r3 = r12
            L27:
                r0.<init>(r1, r3, r4, r5, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.Toaster.Message.<init>(long, java.lang.String, uz.FonRo.pos.ui.Toaster$Kind, long, java.lang.String, kotlin.jvm.functions.Function0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final Kind getKind() {
            return this.kind;
        }

        public final long getDurationMs() {
            return this.durationMs;
        }

        public final String getActionLabel() {
            return this.actionLabel;
        }

        public final Function0<Unit> getOnAction() {
            return this.onAction;
        }
    }

    static {
        MutableSharedFlow<Message> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(0, 8, BufferOverflow.DROP_OLDEST);
        _messages = MutableSharedFlow;
        messages = FlowKt.asSharedFlow(MutableSharedFlow);
    }

    public final SharedFlow<Message> getMessages() {
        return messages;
    }

    public static /* synthetic */ void show$default(Toaster toaster, String str, Kind kind, Long l, String str2, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            kind = Kind.PLAIN;
        }
        toaster.show(str, kind, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : function0);
    }

    public final void show(String text, Kind kind, Long durationMs, String actionLabel, Function0<Unit> onAction) {
        long j;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (StringsKt.isBlank(text)) {
            return;
        }
        counter++;
        if (durationMs != null) {
            j = durationMs.longValue();
        } else {
            j = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
            if (onAction == null && kind != Kind.ERROR) {
                j = 2400;
            }
        }
        _messages.tryEmit(new Message(counter, text, kind, j, actionLabel, onAction));
    }

    public final void ok(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        show$default(this, text, Kind.OK, null, null, null, 28, null);
    }

    public final void error(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        show$default(this, text, Kind.ERROR, null, null, null, 28, null);
    }

    public final void error(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        show$default(this, ApiClient.INSTANCE.asApiError(t).getMessage(), Kind.ERROR, null, null, null, 28, null);
    }
}
