package uz.FonRo.pos.print;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.model.WriteOffReason;
import uz.FonRo.pos.print.BluetoothPrinter;
import uz.FonRo.pos.ui.nav.Routes;

/* compiled from: BluetoothPrinter.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001!B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0007b\u0010\b\u0010\u0012\f\b\u0011\u0012\b\b\fJ\u0004\b\b(\u0012J@\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0087@b\u0010\b\u0010\u0012\f\b\u0011\u0012\b\b\fJ\u0004\b\b(\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000Ê\u0001\f\b#\u0012\b\b$\u0012\u0004\b\u0003\u0010\u0002¨\u0006\""}, d2 = {"Luz/FonRo/pos/print/BluetoothPrinter;", "", "<init>", "()V", "SPP_UUID", "Ljava/util/UUID;", "CHUNK", "", "isSupported", "", "context", "Landroid/content/Context;", "hasPermission", "pairedDevices", "", "Luz/FonRo/pos/print/BluetoothPrinter$Device;", "Landroid/annotation/SuppressLint;", "value", "MissingPermission", Routes.PRINT, "Lkotlin/Result;", "", "mac", "", "bytes", "", "print-BWLJW6A", "(Landroid/content/Context;Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adapterOf", "Landroid/bluetooth/BluetoothAdapter;", "reason", "t", "", "Device", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class BluetoothPrinter {
    public static final int $stable = 0;
    private static final int CHUNK = 512;
    public static final BluetoothPrinter INSTANCE = new BluetoothPrinter();
    private static final UUID SPP_UUID;

    private BluetoothPrinter() {
    }

    static {
        UUID fromString = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
        Intrinsics.checkNotNullExpressionValue(fromString, "fromString(...)");
        SPP_UUID = fromString;
    }

    /* compiled from: BluetoothPrinter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bÊ\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0013"}, d2 = {"Luz/FonRo/pos/print/BluetoothPrinter$Device;", "", "name", "", "mac", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getMac", "component1", "component2", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final /* data */ class Device {
        public static final int $stable = 0;
        private final String mac;
        private final String name;

        public static /* synthetic */ Device copy$default(Device device, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = device.name;
            }
            if ((i & 2) != 0) {
                str2 = device.mac;
            }
            return device.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMac() {
            return this.mac;
        }

        public final Device copy(String name, String mac) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(mac, "mac");
            return new Device(name, mac);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Device)) {
                return false;
            }
            Device device = (Device) other;
            return Intrinsics.areEqual(this.name, device.name) && Intrinsics.areEqual(this.mac, device.mac);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.mac.hashCode();
        }

        public String toString() {
            return "Device(name=" + this.name + ", mac=" + this.mac + ")";
        }

        public Device(String name, String mac) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(mac, "mac");
            this.name = name;
            this.mac = mac;
        }

        public final String getMac() {
            return this.mac;
        }

        public final String getName() {
            return this.name;
        }
    }

    public final boolean isSupported(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return adapterOf(context) != null;
    }

    public final boolean hasPermission(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT < 31 || ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_CONNECT") == 0;
    }

    public final List<Device> pairedDevices(Context context) {
        String address;
        Intrinsics.checkNotNullParameter(context, "context");
        BluetoothAdapter adapterOf = adapterOf(context);
        if (adapterOf != null && hasPermission(context)) {
            try {
                if (!adapterOf.isEnabled()) {
                    return CollectionsKt.emptyList();
                }
                Set<BluetoothDevice> bondedDevices = adapterOf.getBondedDevices();
                if (bondedDevices == null) {
                    bondedDevices = SetsKt.emptySet();
                }
                Set<BluetoothDevice> set = bondedDevices;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
                for (BluetoothDevice bluetoothDevice : set) {
                    String name = bluetoothDevice.getName();
                    if (name != null && (address = StringsKt.trim((CharSequence) name).toString()) != null) {
                        if (address.length() <= 0) {
                            address = null;
                        }
                        if (address != null) {
                            Intrinsics.checkNotNull(address);
                            String address2 = bluetoothDevice.getAddress();
                            Intrinsics.checkNotNullExpressionValue(address2, "getAddress(...)");
                            arrayList.add(new Device(address, address2));
                        }
                    }
                    address = bluetoothDevice.getAddress();
                    Intrinsics.checkNotNull(address);
                    String address22 = bluetoothDevice.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address22, "getAddress(...)");
                    arrayList.add(new Device(address, address22));
                }
                return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: uz.FonRo.pos.print.BluetoothPrinter$pairedDevices$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        String lowerCase = ((BluetoothPrinter.Device) t).getName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = ((BluetoothPrinter.Device) t2).getName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                    }
                });
            } catch (SecurityException unused) {
                return CollectionsKt.emptyList();
            }
        }
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: print-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m9748printBWLJW6A(android.content.Context r5, java.lang.String r6, byte[] r7, kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof uz.FonRo.pos.print.BluetoothPrinter$print$1
            if (r0 == 0) goto L14
            r0 = r8
            uz.FonRo.pos.print.BluetoothPrinter$print$1 r0 = (uz.FonRo.pos.print.BluetoothPrinter$print$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r4 = r0.label
            int r4 = r4 - r2
            r0.label = r4
            goto L19
        L14:
            uz.FonRo.pos.print.BluetoothPrinter$print$1 r0 = new uz.FonRo.pos.print.BluetoothPrinter$print$1
            r0.<init>(r4, r8)
        L19:
            java.lang.Object r4 = r0.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L3e
            if (r1 != r2) goto L36
            java.lang.Object r5 = r0.L$2
            byte[] r5 = (byte[]) r5
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            android.content.Context r5 = (android.content.Context) r5
            kotlin.ResultKt.throwOnFailure(r4)
            goto L6a
        L36:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3e:
            kotlin.ResultKt.throwOnFailure(r4)
            kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            uz.FonRo.pos.print.BluetoothPrinter$print$2 r1 = new uz.FonRo.pos.print.BluetoothPrinter$print$2
            r3 = 0
            r1.<init>(r5, r6, r7, r3)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$2 = r5
            r0.label = r2
            java.lang.Object r4 = kotlinx.coroutines.BuildersKt.withContext(r4, r1, r0)
            if (r4 != r8) goto L6a
            return r8
        L6a:
            kotlin.Result r4 = (kotlin.Result) r4
            java.lang.Object r4 = r4.getValue()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.print.BluetoothPrinter.m9748printBWLJW6A(android.content.Context, java.lang.String, byte[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BluetoothAdapter adapterOf(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (!applicationContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth")) {
            return null;
        }
        Object systemService = applicationContext.getSystemService("bluetooth");
        BluetoothManager bluetoothManager = systemService instanceof BluetoothManager ? (BluetoothManager) systemService : null;
        if (bluetoothManager == null) {
            return null;
        }
        return bluetoothManager.getAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String reason(Throwable t) {
        if (t instanceof IOException) {
            return LangKt.tx("Принтер не отвечает. Проверьте, включён ли он и рядом ли.", new Object[0]);
        }
        if (t instanceof IllegalArgumentException) {
            return LangKt.tx("Принтер выбран неверно. Выберите его заново.", new Object[0]);
        }
        String message = t.getMessage();
        if (message != null) {
            if (StringsKt.isBlank(message)) {
                message = null;
            }
            if (message != null) {
                return message;
            }
        }
        return LangKt.tx("Не удалось напечатать чек", new Object[0]);
    }
}
