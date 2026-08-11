package uz.FonRo.pos.scan;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: HardwareScanner.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\b\u001eJ\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0006H\u0002J\u0014\u0010!\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b$\u0012\b\b%\u0012\u0004\b\u0003\u0010\u0002¨\u0006#"}, d2 = {"Luz/FonRo/pos/scan/HardwareScanner;", "", "<init>", "()V", "ACTIONS", "", "", "EXTRA_KEYS", "REPEAT_WINDOW_MS", "", "_codes", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "codes", "Lkotlinx/coroutines/flow/SharedFlow;", "getCodes", "()Lkotlinx/coroutines/flow/SharedFlow;", "receiver", "Luz/FonRo/pos/scan/HardwareScannerReceiver;", "lastCode", "lastAt", "emit", "", "code", "register", "context", "Landroid/content/Context;", "unregister", "codeOf", "intent", "Landroid/content/Intent;", "codeOf$app", "readExtra", "key", "clean", "raw", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class HardwareScanner {
    public static final int $stable = 0;
    private static final long REPEAT_WINDOW_MS = 350;
    private static final MutableSharedFlow<String> _codes;
    private static final SharedFlow<String> codes;
    private static long lastAt;
    private static String lastCode;
    private static HardwareScannerReceiver receiver;
    public static final HardwareScanner INSTANCE = new HardwareScanner();
    private static final List<String> ACTIONS = CollectionsKt.listOf((Object[]) new String[]{"uz.FonRo.pos.SCAN", "com.symbol.datawedge.api.RESULT_ACTION", "com.honeywell.decode.intent.action.EDIT_DATA", "android.intent.ACTION_DECODE_DATA", "nlscan.action.SCANNER_RESULT", "com.rfid.SCAN", "scan.rcv.message"});
    private static final List<String> EXTRA_KEYS = CollectionsKt.listOf((Object[]) new String[]{"com.symbol.datawedge.data_string", "com.motorolasolutions.emdk.datawedge.data_string", "data", "barcode_string", OptionalModuleUtils.BARCODE, "scannerdata", "SCAN_BARCODE1", "decode_rslt", "com.honeywell.aidc.extra.EXTRA_BARCODE_DATA", "barocode", "value"});

    private HardwareScanner() {
    }

    static {
        MutableSharedFlow<String> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(0, 8, BufferOverflow.DROP_OLDEST);
        _codes = MutableSharedFlow;
        codes = FlowKt.asSharedFlow(MutableSharedFlow);
        lastCode = "";
    }

    public final SharedFlow<String> getCodes() {
        return codes;
    }

    public final synchronized void emit(String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        String clean = clean(code);
        if (clean == null) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!Intrinsics.areEqual(clean, lastCode) || elapsedRealtime - lastAt >= REPEAT_WINDOW_MS) {
            lastCode = clean;
            lastAt = elapsedRealtime;
            _codes.tryEmit(clean);
        }
    }

    public final synchronized void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (receiver != null) {
            return;
        }
        HardwareScannerReceiver hardwareScannerReceiver = new HardwareScannerReceiver();
        IntentFilter intentFilter = new IntentFilter();
        Iterator<T> it = ACTIONS.iterator();
        while (it.hasNext()) {
            intentFilter.addAction((String) it.next());
        }
        ContextCompat.registerReceiver(context.getApplicationContext(), hardwareScannerReceiver, intentFilter, 2);
        receiver = hardwareScannerReceiver;
    }

    public final synchronized void unregister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HardwareScannerReceiver hardwareScannerReceiver = receiver;
        if (hardwareScannerReceiver == null) {
            return;
        }
        receiver = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            HardwareScanner hardwareScanner = this;
            context.getApplicationContext().unregisterReceiver(hardwareScannerReceiver);
            Result.m7870constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final String codeOf$app(Intent intent) {
        Object m7870constructorimpl;
        if (intent == null) {
            return null;
        }
        for (String str : EXTRA_KEYS) {
            try {
                Result.Companion companion = Result.INSTANCE;
                HardwareScanner hardwareScanner = this;
                m7870constructorimpl = Result.m7870constructorimpl(readExtra(intent, str));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7876isFailureimpl(m7870constructorimpl)) {
                m7870constructorimpl = null;
            }
            String str2 = (String) m7870constructorimpl;
            if (str2 != null) {
                return str2;
            }
        }
        return null;
    }

    private final String readExtra(Intent intent, String key) {
        String clean;
        String clean2 = clean(intent.getStringExtra(key));
        if (clean2 != null) {
            return clean2;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra(key);
        if (byteArrayExtra == null) {
            return null;
        }
        if ((byteArrayExtra.length == 0) || (clean = clean(new String(byteArrayExtra, Charsets.UTF_8))) == null) {
            return null;
        }
        return clean;
    }

    private final String clean(String raw) {
        if (raw != null) {
            String str = raw;
            int length = str.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = str.charAt(!z ? i : length) <= ' ';
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            String obj = str.subSequence(i, length + 1).toString();
            if (obj == null || obj.length() == 0) {
                return null;
            }
            return obj;
        }
        return null;
    }
}
