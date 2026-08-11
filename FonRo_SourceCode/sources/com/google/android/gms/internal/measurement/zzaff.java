package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes5.dex */
final class zzaff<T> implements zzafp<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzagg.zzp();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzafc zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzafz zzm;
    private final zzadg zzn;

    private zzaff(int[] iArr, Object[] objArr, int i, int i2, zzafc zzafcVar, boolean z, int[] iArr2, int i3, int i4, zzafh zzafhVar, zzaeo zzaeoVar, zzafz zzafzVar, zzadg zzadgVar, zzaex zzaexVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzafcVar instanceof zzadu;
        boolean z2 = false;
        if (zzadgVar != null && (zzafcVar instanceof zzadr)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzm = zzafzVar;
        this.zzn = zzadgVar;
        this.zzg = zzafcVar;
    }

    private final int zzA(int i) {
        return this.zzc[i + 1];
    }

    private final int zzB(int i) {
        return this.zzc[i + 2];
    }

    private static int zzC(int i) {
        return (i >>> 20) & 255;
    }

    private static boolean zzD(int i) {
        return (i & 536870912) != 0;
    }

    private static boolean zzE(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzadu) {
            return ((zzadu) obj).zzch();
        }
        return true;
    }

    private static void zzF(Object obj) {
        if (zzE(obj)) {
            return;
        }
        String valueOf = String.valueOf(obj);
        String.valueOf(valueOf);
        throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(valueOf)));
    }

    private static int zzG(Object obj, long j) {
        return ((Integer) zzagg.zzm(obj, j)).intValue();
    }

    private static long zzH(Object obj, long j) {
        return ((Long) zzagg.zzm(obj, j)).longValue();
    }

    private final boolean zzI(Object obj, Object obj2, int i) {
        return zzK(obj, i) == zzK(obj2, i);
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzK(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zzK(Object obj, int i) {
        int zzB = zzB(i);
        long j = zzB & 1048575;
        if (j != 1048575) {
            return ((1 << (zzB >>> 20)) & zzagg.zzc(obj, j)) != 0;
        }
        int zzA = zzA(i);
        long j2 = zzA & 1048575;
        switch (zzC(zzA)) {
            case 0:
                return Double.doubleToRawLongBits(zzagg.zzk(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzagg.zzi(obj, j2)) != 0;
            case 2:
                return zzagg.zze(obj, j2) != 0;
            case 3:
                return zzagg.zze(obj, j2) != 0;
            case 4:
                return zzagg.zzc(obj, j2) != 0;
            case 5:
                return zzagg.zze(obj, j2) != 0;
            case 6:
                return zzagg.zzc(obj, j2) != 0;
            case 7:
                return zzagg.zzg(obj, j2);
            case 8:
                Object zzm = zzagg.zzm(obj, j2);
                if (zzm instanceof String) {
                    return !((String) zzm).isEmpty();
                }
                if (zzm instanceof zzacr) {
                    return !zzacr.zza.equals(zzm);
                }
                return zzR();
            case 9:
                return zzagg.zzm(obj, j2) != null;
            case 10:
                return !zzacr.zza.equals(zzagg.zzm(obj, j2));
            case 11:
                return zzagg.zzc(obj, j2) != 0;
            case 12:
                return zzagg.zzc(obj, j2) != 0;
            case 13:
                return zzagg.zzc(obj, j2) != 0;
            case 14:
                return zzagg.zze(obj, j2) != 0;
            case 15:
                return zzagg.zzc(obj, j2) != 0;
            case 16:
                return zzagg.zze(obj, j2) != 0;
            case 17:
                return zzagg.zzm(obj, j2) != null;
            default:
                return zzR();
        }
    }

    private final void zzL(Object obj, int i) {
        int zzB = zzB(i);
        long j = 1048575 & zzB;
        if (j == 1048575) {
            return;
        }
        zzagg.zzd(obj, j, (1 << (zzB >>> 20)) | zzagg.zzc(obj, j));
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzagg.zzc(obj, (long) (zzB(i2) & 1048575)) == i;
    }

    private final boolean zzN(Object obj, Object obj2, int i) {
        long zzB = zzB(i) & 1048575;
        return zzagg.zzc(obj, zzB) == zzagg.zzc(obj2, zzB);
    }

    private final void zzO(Object obj, int i, int i2) {
        zzagg.zzd(obj, zzB(i2) & 1048575, i);
    }

    private final int zzP(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzQ(i, 0);
    }

    private final int zzQ(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private boolean zzR() {
        throw new IllegalArgumentException();
    }

    private static final int zzS(byte[] bArr, int i, int i2, zzagm zzagmVar, Class cls, zzacg zzacgVar) throws IOException {
        zzagm zzagmVar2 = zzagm.DOUBLE;
        switch (zzagmVar) {
            case DOUBLE:
                int i3 = i + 8;
                zzacgVar.zzc = Double.valueOf(Double.longBitsToDouble(zzach.zze(bArr, i)));
                return i3;
            case FLOAT:
                int i4 = i + 4;
                zzacgVar.zzc = Float.valueOf(Float.intBitsToFloat(zzach.zzd(bArr, i)));
                return i4;
            case INT64:
            case UINT64:
                int zzc = zzach.zzc(bArr, i, zzacgVar);
                zzacgVar.zzc = Long.valueOf(zzacgVar.zzb);
                return zzc;
            case INT32:
            case UINT32:
            case ENUM:
                int zza2 = zzach.zza(bArr, i, zzacgVar);
                zzacgVar.zzc = Integer.valueOf(zzacgVar.zza);
                return zza2;
            case FIXED64:
            case SFIXED64:
                int i5 = i + 8;
                zzacgVar.zzc = Long.valueOf(zzach.zze(bArr, i));
                return i5;
            case FIXED32:
            case SFIXED32:
                int i6 = i + 4;
                zzacgVar.zzc = Integer.valueOf(zzach.zzd(bArr, i));
                return i6;
            case BOOL:
                int zzc2 = zzach.zzc(bArr, i, zzacgVar);
                zzacgVar.zzc = Boolean.valueOf(zzacgVar.zzb != 0);
                return zzc2;
            case STRING:
                return zzach.zzf(bArr, i, zzacgVar);
            case GROUP:
            default:
                throw new RuntimeException("unsupported field type.");
            case MESSAGE:
                return zzach.zzh(zzafl.zza().zzb(cls), bArr, i, i2, zzacgVar);
            case BYTES:
                return zzach.zzg(bArr, i, zzacgVar);
            case SINT32:
                int zza3 = zzach.zza(bArr, i, zzacgVar);
                zzacgVar.zzc = Integer.valueOf(zzacv.zzR(zzacgVar.zza));
                return zza3;
            case SINT64:
                int zzc3 = zzach.zzc(bArr, i, zzacgVar);
                zzacgVar.zzc = Long.valueOf(zzacv.zzS(zzacgVar.zzb));
                return zzc3;
        }
    }

    private static final void zzT(int i, Object obj, zzago zzagoVar) throws IOException {
        if (obj instanceof String) {
            zzagoVar.zzm(i, (String) obj);
        } else {
            zzagoVar.zzn(i, (zzacr) obj);
        }
    }

    static zzaga zzh(Object obj) {
        zzadu zzaduVar = (zzadu) obj;
        zzaga zzagaVar = zzaduVar.zzc;
        if (zzagaVar != zzaga.zza()) {
            return zzagaVar;
        }
        zzaga zzb2 = zzaga.zzb();
        zzaduVar.zzc = zzb2;
        return zzb2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0263  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.measurement.zzaff zzm(java.lang.Class r31, com.google.android.gms.internal.measurement.zzaez r32, com.google.android.gms.internal.measurement.zzafh r33, com.google.android.gms.internal.measurement.zzaeo r34, com.google.android.gms.internal.measurement.zzafz r35, com.google.android.gms.internal.measurement.zzadg r36, com.google.android.gms.internal.measurement.zzaex r37) {
        /*
            Method dump skipped, instructions count: 1020
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaff.zzm(java.lang.Class, com.google.android.gms.internal.measurement.zzaez, com.google.android.gms.internal.measurement.zzafh, com.google.android.gms.internal.measurement.zzaeo, com.google.android.gms.internal.measurement.zzafz, com.google.android.gms.internal.measurement.zzadg, com.google.android.gms.internal.measurement.zzaex):com.google.android.gms.internal.measurement.zzaff");
    }

    private static Field zzn(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(name).length() + 29 + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString(), e);
        }
    }

    private final void zzo(Object obj, Object obj2, int i) {
        if (zzK(obj2, i)) {
            int zzA = zzA(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzA;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                int i2 = this.zzc[i];
                String obj3 = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 38 + obj3.length());
                sb.append("Source subfield ");
                sb.append(i2);
                sb.append(" is present but null: ");
                sb.append(obj3);
                throw new IllegalStateException(sb.toString());
            }
            zzafp zzq = zzq(i);
            if (!zzK(obj, i)) {
                if (!zzE(object)) {
                    unsafe.putObject(obj, j, object);
                } else {
                    Object zza2 = zzq.zza();
                    zzq.zzd(zza2, object);
                    unsafe.putObject(obj, j, zza2);
                }
                zzL(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzE(object2)) {
                Object zza3 = zzq.zza();
                zzq.zzd(zza3, object2);
                unsafe.putObject(obj, j, zza3);
                object2 = zza3;
            }
            zzq.zzd(object2, object);
        }
    }

    private final void zzp(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzM(obj2, i2, i)) {
            int zzA = zzA(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzA;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                int i3 = iArr[i];
                String obj3 = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 38 + obj3.length());
                sb.append("Source subfield ");
                sb.append(i3);
                sb.append(" is present but null: ");
                sb.append(obj3);
                throw new IllegalStateException(sb.toString());
            }
            zzafp zzq = zzq(i);
            if (!zzM(obj, i2, i)) {
                if (!zzE(object)) {
                    unsafe.putObject(obj, j, object);
                } else {
                    Object zza2 = zzq.zza();
                    zzq.zzd(zza2, object);
                    unsafe.putObject(obj, j, zza2);
                }
                zzO(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzE(object2)) {
                Object zza3 = zzq.zza();
                zzq.zzd(zza3, object2);
                unsafe.putObject(obj, j, zza3);
                object2 = zza3;
            }
            zzq.zzd(object2, object);
        }
    }

    private final zzafp zzq(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzafp zzafpVar = (zzafp) objArr[i3];
        if (zzafpVar != null) {
            return zzafpVar;
        }
        zzafp zzb2 = zzafl.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzb2;
        return zzb2;
    }

    private final Object zzr(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final zzadz zzs(int i) {
        int i2 = i / 3;
        return (zzadz) this.zzd[i2 + i2 + 1];
    }

    private final Object zzt(Object obj, int i) {
        zzafp zzq = zzq(i);
        int zzA = zzA(i) & 1048575;
        if (!zzK(obj, i)) {
            return zzq.zza();
        }
        Object object = zzb.getObject(obj, zzA);
        if (zzE(object)) {
            return object;
        }
        Object zza2 = zzq.zza();
        if (object != null) {
            zzq.zzd(zza2, object);
        }
        return zza2;
    }

    private final void zzu(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzA(i) & 1048575, obj2);
        zzL(obj, i);
    }

    private final Object zzv(Object obj, int i, int i2) {
        zzafp zzq = zzq(i2);
        if (!zzM(obj, i, i2)) {
            return zzq.zza();
        }
        Object object = zzb.getObject(obj, zzA(i2) & 1048575);
        if (zzE(object)) {
            return object;
        }
        Object zza2 = zzq.zza();
        if (object != null) {
            zzq.zzd(zza2, object);
        }
        return zza2;
    }

    private final void zzw(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzA(i2) & 1048575, obj2);
        zzO(obj, i, i2);
    }

    private final Object zzx(Object obj, int i, Object obj2, zzafz zzafzVar, Object obj3) {
        zzadz zzs;
        int i2 = this.zzc[i];
        Object zzm = zzagg.zzm(obj, zzA(i) & 1048575);
        if (zzm == null || (zzs = zzs(i)) == null) {
            return obj2;
        }
        zzaeu zze = ((zzaev) zzr(i)).zze();
        Iterator it = ((zzaew) zzm).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!zzs.zza(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    obj2 = zzafzVar.zzh(obj3);
                }
                int zzc = zzaev.zzc(zze, entry.getKey(), entry.getValue());
                zzacr zzacrVar = zzacr.zza;
                byte[] bArr = new byte[zzc];
                int i3 = zzada.zzb;
                zzacx zzacxVar = new zzacx(bArr, 0, zzc);
                try {
                    zzaev.zzb(zzacxVar, zze, entry.getKey(), entry.getValue());
                    zzafzVar.zzd(obj2, i2, zzaco.zza(zzacxVar, bArr));
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj2;
    }

    private static boolean zzy(Object obj, int i, zzafp zzafpVar) {
        return zzafpVar.zzl(zzagg.zzm(obj, i & 1048575));
    }

    private final void zzz(Object obj, int i, zzafo zzafoVar) throws IOException {
        long j = i & 1048575;
        if (zzD(i)) {
            zzagg.zzn(obj, j, zzafoVar.zzn());
        } else if (!this.zzi) {
            zzagg.zzn(obj, j, zzafoVar.zzq());
        } else {
            zzagg.zzn(obj, j, zzafoVar.zzm());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final Object zza() {
        return ((zzadu) this.zzg).zzck();
    }

    /* JADX WARN: Code restructure failed: missing block: B:152:0x01c2, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x001e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01c2 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzafp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzb(java.lang.Object r7, java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaff.zzb(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0021. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzafp
    public final int zzc(Object obj) {
        int i;
        long doubleToLongBits;
        int floatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int zzA = zzA(i4);
            int zzC = zzC(zzA);
            if (zzC <= 50 || zzC >= 69) {
                long j = zzA & 1048575;
                int i5 = 37;
                switch (zzC) {
                    case 0:
                        i = i3 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzagg.zzk(obj, j));
                        byte[] bArr = zzaed.zza;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    case 1:
                        i = i3 * 53;
                        floatToIntBits = Float.floatToIntBits(zzagg.zzi(obj, j));
                        i3 = i + floatToIntBits;
                        break;
                    case 2:
                        i = i3 * 53;
                        doubleToLongBits = zzagg.zze(obj, j);
                        byte[] bArr2 = zzaed.zza;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    case 3:
                        i = i3 * 53;
                        doubleToLongBits = zzagg.zze(obj, j);
                        byte[] bArr3 = zzaed.zza;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    case 4:
                        i = i3 * 53;
                        floatToIntBits = zzagg.zzc(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    case 5:
                        i = i3 * 53;
                        doubleToLongBits = zzagg.zze(obj, j);
                        byte[] bArr4 = zzaed.zza;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    case 6:
                        i = i3 * 53;
                        floatToIntBits = zzagg.zzc(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    case 7:
                        i = i3 * 53;
                        floatToIntBits = zzaed.zza(zzagg.zzg(obj, j));
                        i3 = i + floatToIntBits;
                        break;
                    case 8:
                        i = i3 * 53;
                        floatToIntBits = ((String) zzagg.zzm(obj, j)).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    case 9:
                        i2 = i3 * 53;
                        Object zzm = zzagg.zzm(obj, j);
                        if (zzm != null) {
                            i5 = zzm.hashCode();
                        }
                        i3 = i2 + i5;
                        break;
                    case 10:
                        i = i3 * 53;
                        floatToIntBits = zzagg.zzm(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    case 11:
                        i = i3 * 53;
                        floatToIntBits = zzagg.zzc(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    case 12:
                        i = i3 * 53;
                        floatToIntBits = zzagg.zzc(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    case 13:
                        i = i3 * 53;
                        floatToIntBits = zzagg.zzc(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    case 14:
                        i = i3 * 53;
                        doubleToLongBits = zzagg.zze(obj, j);
                        byte[] bArr5 = zzaed.zza;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    case 15:
                        i = i3 * 53;
                        floatToIntBits = zzagg.zzc(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    case 16:
                        i = i3 * 53;
                        doubleToLongBits = zzagg.zze(obj, j);
                        byte[] bArr6 = zzaed.zza;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    case 17:
                        i2 = i3 * 53;
                        Object zzm2 = zzagg.zzm(obj, j);
                        if (zzm2 != null) {
                            i5 = zzm2.hashCode();
                        }
                        i3 = i2 + i5;
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    case 49:
                        i = i3 * 53;
                        floatToIntBits = zzagg.zzm(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    case 50:
                        i = i3 * 53;
                        floatToIntBits = zzagg.zzm(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                }
            }
        }
        int i6 = this.zzl;
        while (true) {
            int[] iArr = this.zzj;
            if (i6 < iArr.length) {
                if (!zzM(obj, 0, iArr[i6])) {
                    i3 = (i3 * 53) + zzagg.zzm(obj, zzA(r3) & 1048575).hashCode();
                }
                i6++;
            } else {
                int hashCode = (i3 * 53) + ((zzadu) obj).zzc.hashCode();
                return this.zzh ? (hashCode * 53) + ((zzadr) obj).zzb.zza.hashCode() : hashCode;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzd(Object obj, Object obj2) {
        zzF(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i < iArr.length) {
                int zzA = zzA(i);
                int i2 = 1048575 & zzA;
                int zzC = zzC(zzA);
                int i3 = iArr[i];
                long j = i2;
                switch (zzC) {
                    case 0:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzl(obj, j, zzagg.zzk(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 1:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzj(obj, j, zzagg.zzi(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 2:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzf(obj, j, zzagg.zze(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 3:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzf(obj, j, zzagg.zze(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 4:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 5:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzf(obj, j, zzagg.zze(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 6:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 7:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzh(obj, j, zzagg.zzg(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 8:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzn(obj, j, zzagg.zzm(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 9:
                        zzo(obj, obj2, i);
                        break;
                    case 10:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzn(obj, j, zzagg.zzm(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 11:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 12:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 13:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 14:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzf(obj, j, zzagg.zze(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 15:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 16:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzf(obj, j, zzagg.zze(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 17:
                        zzo(obj, obj2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    case 49:
                        zzaef zzaefVar = (zzaef) zzagg.zzm(obj, j);
                        zzaef zzaefVar2 = (zzaef) zzagg.zzm(obj2, j);
                        int size = zzaefVar.size();
                        int size2 = zzaefVar2.size();
                        if (size > 0 && size2 > 0) {
                            if (!zzaefVar.zza()) {
                                zzaefVar = zzaefVar.zzg(size2 + size);
                            }
                            zzaefVar.addAll(zzaefVar2);
                        }
                        if (size > 0) {
                            zzaefVar2 = zzaefVar;
                        }
                        zzagg.zzn(obj, j, zzaefVar2);
                        break;
                    case 50:
                        int i4 = zzafq.zza;
                        zzagg.zzn(obj, j, zzaex.zzb(zzagg.zzm(obj, j), zzagg.zzm(obj2, j)));
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zzM(obj2, i3, i)) {
                            break;
                        } else {
                            zzagg.zzn(obj, j, zzagg.zzm(obj2, j));
                            zzO(obj, i3, i);
                            break;
                        }
                    case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                        zzp(obj, obj2, i);
                        break;
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    case 62:
                    case 63:
                    case 64:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                        if (!zzM(obj2, i3, i)) {
                            break;
                        } else {
                            zzagg.zzn(obj, j, zzagg.zzm(obj2, j));
                            zzO(obj, i3, i);
                            break;
                        }
                    case 68:
                        zzp(obj, obj2, i);
                        break;
                }
                i += 3;
            } else {
                zzafq.zzE(this.zzm, obj, obj2);
                if (this.zzh) {
                    zzafq.zzD(this.zzn, obj, obj2);
                    return;
                }
                return;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x004c. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzafp
    public final int zze(Object obj) {
        int i;
        int zzE;
        int zzE2;
        int zzF;
        int zzE3;
        int zzE4;
        int zzE5;
        int zzb2;
        int zzE6;
        int zzz;
        int zzo;
        int size;
        int zzp;
        int zzE7;
        int zzb3;
        int zzE8;
        int zzb4;
        int zzE9;
        int zzE10;
        int zzcf;
        int zzE11;
        int zzE12;
        int i2;
        int zzx;
        int zzE13;
        int zzE14;
        int i3;
        int zzE15;
        int zzE16;
        int zzE17;
        int zzb5;
        int zzE18;
        zzaff<T> zzaffVar = this;
        Object obj2 = obj;
        Unsafe unsafe = zzb;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1048575;
        while (true) {
            int[] iArr = zzaffVar.zzc;
            if (i4 < iArr.length) {
                int zzA = zzaffVar.zzA(i4);
                int zzC = zzC(zzA);
                int i8 = iArr[i4];
                int i9 = iArr[i4 + 2];
                int i10 = i9 & 1048575;
                if (zzC <= 17) {
                    if (i10 != i7) {
                        i5 = i10 == 1048575 ? 0 : unsafe.getInt(obj2, i10);
                        i7 = i10;
                    }
                    i = 1 << (i9 >>> 20);
                } else {
                    i = 0;
                }
                int i11 = zzA & 1048575;
                if (zzC >= zzadl.DOUBLE_LIST_PACKED.zza()) {
                    zzadl.SINT64_LIST_PACKED.zza();
                }
                long j = i11;
                switch (zzC) {
                    case 0:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            i6 += zzada.zzE(i8 << 3) + 8;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzE = zzada.zzE(i8 << 3);
                            zzE4 = zzE + 4;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 2:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            long j2 = unsafe.getLong(obj2, j);
                            zzE2 = zzada.zzE(i8 << 3);
                            zzF = zzada.zzF(j2);
                            zzE4 = zzE2 + zzF;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 3:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            long j3 = unsafe.getLong(obj2, j);
                            zzE2 = zzada.zzE(i8 << 3);
                            zzF = zzada.zzF(j3);
                            zzE4 = zzE2 + zzF;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 4:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            long j4 = unsafe.getInt(obj2, j);
                            zzE2 = zzada.zzE(i8 << 3);
                            zzF = zzada.zzF(j4);
                            zzE4 = zzE2 + zzF;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 5:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzE3 = zzada.zzE(i8 << 3);
                            zzE4 = zzE3 + 8;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 6:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzE = zzada.zzE(i8 << 3);
                            zzE4 = zzE + 4;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 7:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzE4 = zzada.zzE(i8 << 3) + 1;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 8:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            int i12 = i8 << 3;
                            Object object = unsafe.getObject(obj2, j);
                            if (object instanceof zzacr) {
                                zzE5 = zzada.zzE(i12);
                                zzb2 = ((zzacr) object).zzb();
                                zzE6 = zzada.zzE(zzb2);
                            } else {
                                zzE5 = zzada.zzE(i12);
                                zzb2 = zzagl.zzb((String) object);
                                zzE6 = zzada.zzE(zzb2);
                            }
                            zzE4 = zzE5 + zzE6 + zzb2;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 9:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzz = zzafq.zzz(i8, unsafe.getObject(obj2, j), zzaffVar.zzq(i4));
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzacr zzacrVar = (zzacr) unsafe.getObject(obj2, j);
                            zzE5 = zzada.zzE(i8 << 3);
                            zzb2 = zzacrVar.zzb();
                            zzE6 = zzada.zzE(zzb2);
                            zzE4 = zzE5 + zzE6 + zzb2;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 11:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            int i13 = unsafe.getInt(obj2, j);
                            zzE2 = zzada.zzE(i8 << 3);
                            zzF = zzada.zzE(i13);
                            zzE4 = zzE2 + zzF;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 12:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            long j5 = unsafe.getInt(obj2, j);
                            zzE2 = zzada.zzE(i8 << 3);
                            zzF = zzada.zzF(j5);
                            zzE4 = zzE2 + zzF;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 13:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzE = zzada.zzE(i8 << 3);
                            zzE4 = zzE + 4;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 14:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzE3 = zzada.zzE(i8 << 3);
                            zzE4 = zzE3 + 8;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 15:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            int i14 = unsafe.getInt(obj2, j);
                            zzE2 = zzada.zzE(i8 << 3);
                            zzF = zzada.zzE((i14 >> 31) ^ (i14 + i14));
                            zzE4 = zzE2 + zzF;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 16:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            long j6 = unsafe.getLong(obj2, j);
                            zzE2 = zzada.zzE(i8 << 3);
                            zzF = zzada.zzF((j6 >> 63) ^ (j6 + j6));
                            zzE4 = zzE2 + zzF;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 17:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzz = zzafq.zzA(i8, (zzafc) unsafe.getObject(obj2, j), zzaffVar.zzq(i4));
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzz = zzafq.zzy(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz;
                        break;
                    case 19:
                        zzz = zzafq.zzw(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz;
                        break;
                    case 20:
                        List list = (List) unsafe.getObject(obj2, j);
                        int i15 = zzafq.zza;
                        if (list.size() != 0) {
                            zzo = zzafq.zzo(list) + (list.size() * zzada.zzE(i8 << 3));
                            i6 += zzo;
                            break;
                        }
                        zzo = 0;
                        i6 += zzo;
                    case 21:
                        List list2 = (List) unsafe.getObject(obj2, j);
                        int i16 = zzafq.zza;
                        size = list2.size();
                        if (size != 0) {
                            zzp = zzafq.zzp(list2);
                            zzE7 = zzada.zzE(i8 << 3);
                            i2 = size * zzE7;
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        }
                        zzz = 0;
                        i6 += zzz;
                    case 22:
                        List list3 = (List) unsafe.getObject(obj2, j);
                        int i17 = zzafq.zza;
                        size = list3.size();
                        if (size != 0) {
                            zzp = zzafq.zzs(list3);
                            zzE7 = zzada.zzE(i8 << 3);
                            i2 = size * zzE7;
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        }
                        zzz = 0;
                        i6 += zzz;
                    case 23:
                        zzz = zzafq.zzy(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz;
                        break;
                    case 24:
                        zzz = zzafq.zzw(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz;
                        break;
                    case 25:
                        List list4 = (List) unsafe.getObject(obj2, j);
                        int i18 = zzafq.zza;
                        int size2 = list4.size();
                        if (size2 != 0) {
                            zzz = size2 * (zzada.zzE(i8 << 3) + 1);
                            i6 += zzz;
                            break;
                        }
                        zzz = 0;
                        i6 += zzz;
                    case 26:
                        List list5 = (List) unsafe.getObject(obj2, j);
                        int i19 = zzafq.zza;
                        int size3 = list5.size();
                        if (size3 != 0) {
                            zzo = zzada.zzE(i8 << 3) * size3;
                            if (list5 instanceof zzaen) {
                                zzaen zzaenVar = (zzaen) list5;
                                for (int i20 = 0; i20 < size3; i20++) {
                                    Object zzc = zzaenVar.zzc();
                                    if (zzc instanceof zzacr) {
                                        zzb4 = ((zzacr) zzc).zzb();
                                        zzE9 = zzada.zzE(zzb4);
                                    } else {
                                        zzb4 = zzagl.zzb((String) zzc);
                                        zzE9 = zzada.zzE(zzb4);
                                    }
                                    zzo += zzE9 + zzb4;
                                }
                            } else {
                                for (int i21 = 0; i21 < size3; i21++) {
                                    Object obj3 = list5.get(i21);
                                    if (obj3 instanceof zzacr) {
                                        zzb3 = ((zzacr) obj3).zzb();
                                        zzE8 = zzada.zzE(zzb3);
                                    } else {
                                        zzb3 = zzagl.zzb((String) obj3);
                                        zzE8 = zzada.zzE(zzb3);
                                    }
                                    zzo += zzE8 + zzb3;
                                }
                            }
                            i6 += zzo;
                            break;
                        }
                        zzo = 0;
                        i6 += zzo;
                    case 27:
                        List list6 = (List) unsafe.getObject(obj2, j);
                        zzafp zzq = zzaffVar.zzq(i4);
                        int i22 = zzafq.zza;
                        int size4 = list6.size();
                        if (size4 == 0) {
                            zzE10 = 0;
                        } else {
                            zzE10 = zzada.zzE(i8 << 3) * size4;
                            for (int i23 = 0; i23 < size4; i23++) {
                                Object obj4 = list6.get(i23);
                                if (obj4 instanceof zzaem) {
                                    zzcf = ((zzaem) obj4).zzb();
                                    zzE11 = zzada.zzE(zzcf);
                                } else {
                                    zzcf = ((zzacb) obj4).zzcf(zzq);
                                    zzE11 = zzada.zzE(zzcf);
                                }
                                zzE10 += zzE11 + zzcf;
                            }
                        }
                        i6 += zzE10;
                        break;
                    case 28:
                        List list7 = (List) unsafe.getObject(obj2, j);
                        int i24 = zzafq.zza;
                        int size5 = list7.size();
                        if (size5 == 0) {
                            zzE12 = 0;
                        } else {
                            zzE12 = size5 * zzada.zzE(i8 << 3);
                            for (int i25 = 0; i25 < list7.size(); i25++) {
                                int zzb6 = ((zzacr) list7.get(i25)).zzb();
                                zzE12 += zzada.zzE(zzb6) + zzb6;
                            }
                        }
                        i6 += zzE12;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                        List list8 = (List) unsafe.getObject(obj2, j);
                        int i26 = zzafq.zza;
                        size = list8.size();
                        if (size != 0) {
                            zzp = zzafq.zzt(list8);
                            zzE7 = zzada.zzE(i8 << 3);
                            i2 = size * zzE7;
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        }
                        zzz = 0;
                        i6 += zzz;
                    case 30:
                        List list9 = (List) unsafe.getObject(obj2, j);
                        int i27 = zzafq.zza;
                        size = list9.size();
                        if (size != 0) {
                            zzp = zzafq.zzr(list9);
                            zzE7 = zzada.zzE(i8 << 3);
                            i2 = size * zzE7;
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        }
                        zzz = 0;
                        i6 += zzz;
                    case 31:
                        zzz = zzafq.zzw(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz;
                        break;
                    case 32:
                        zzz = zzafq.zzy(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz;
                        break;
                    case 33:
                        List list10 = (List) unsafe.getObject(obj2, j);
                        int i28 = zzafq.zza;
                        size = list10.size();
                        if (size != 0) {
                            zzp = zzafq.zzu(list10);
                            zzE7 = zzada.zzE(i8 << 3);
                            i2 = size * zzE7;
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        }
                        zzz = 0;
                        i6 += zzz;
                    case 34:
                        List list11 = (List) unsafe.getObject(obj2, j);
                        int i29 = zzafq.zza;
                        size = list11.size();
                        if (size != 0) {
                            zzp = zzafq.zzq(list11);
                            zzE7 = zzada.zzE(i8 << 3);
                            i2 = size * zzE7;
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        }
                        zzz = 0;
                        i6 += zzz;
                    case 35:
                        zzx = zzafq.zzx((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        zzx = zzafq.zzv((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        zzx = zzafq.zzo((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        zzx = zzafq.zzp((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        zzx = zzafq.zzs((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        zzx = zzafq.zzx((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        zzx = zzafq.zzv((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        List list12 = (List) unsafe.getObject(obj2, j);
                        int i30 = zzafq.zza;
                        zzx = list12.size();
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        zzx = zzafq.zzt((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        zzx = zzafq.zzr((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        zzx = zzafq.zzv((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        zzx = zzafq.zzx((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        zzx = zzafq.zzu((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                        zzx = zzafq.zzq((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        List list13 = (List) unsafe.getObject(obj2, j);
                        zzafp zzq2 = zzaffVar.zzq(i4);
                        int i31 = zzafq.zza;
                        int size6 = list13.size();
                        if (size6 == 0) {
                            i3 = 0;
                        } else {
                            i3 = 0;
                            for (int i32 = 0; i32 < size6; i32++) {
                                i3 += zzafq.zzA(i8, (zzafc) list13.get(i32), zzq2);
                            }
                        }
                        i6 += i3;
                        break;
                    case 50:
                        zzaew zzaewVar = (zzaew) unsafe.getObject(obj2, j);
                        zzaev zzaevVar = (zzaev) zzaffVar.zzr(i4);
                        if (!zzaewVar.isEmpty()) {
                            zzo = 0;
                            for (Map.Entry entry : zzaewVar.entrySet()) {
                                zzo += zzaevVar.zzd(i8, entry.getKey(), entry.getValue());
                            }
                            i6 += zzo;
                            break;
                        }
                        zzo = 0;
                        i6 += zzo;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzE15 = zzada.zzE(i8 << 3);
                            zzz = zzE15 + 8;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzE16 = zzada.zzE(i8 << 3);
                            zzz = zzE16 + 4;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            long zzH = zzH(obj2, j);
                            zzp = zzada.zzE(i8 << 3);
                            i2 = zzada.zzF(zzH);
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            long zzH2 = zzH(obj2, j);
                            zzp = zzada.zzE(i8 << 3);
                            i2 = zzada.zzF(zzH2);
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            long zzG = zzG(obj2, j);
                            zzp = zzada.zzE(i8 << 3);
                            i2 = zzada.zzF(zzG);
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzE15 = zzada.zzE(i8 << 3);
                            zzz = zzE15 + 8;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzE16 = zzada.zzE(i8 << 3);
                            zzz = zzE16 + 4;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzz = zzada.zzE(i8 << 3) + 1;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            int i33 = i8 << 3;
                            Object object2 = unsafe.getObject(obj2, j);
                            if (object2 instanceof zzacr) {
                                zzE17 = zzada.zzE(i33);
                                zzb5 = ((zzacr) object2).zzb();
                                zzE18 = zzada.zzE(zzb5);
                            } else {
                                zzE17 = zzada.zzE(i33);
                                zzb5 = zzagl.zzb((String) object2);
                                zzE18 = zzada.zzE(zzb5);
                            }
                            zzz = zzE17 + zzE18 + zzb5;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzz = zzafq.zzz(i8, unsafe.getObject(obj2, j), zzaffVar.zzq(i4));
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzacr zzacrVar2 = (zzacr) unsafe.getObject(obj2, j);
                            zzE17 = zzada.zzE(i8 << 3);
                            zzb5 = zzacrVar2.zzb();
                            zzE18 = zzada.zzE(zzb5);
                            zzz = zzE17 + zzE18 + zzb5;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            int zzG2 = zzG(obj2, j);
                            zzp = zzada.zzE(i8 << 3);
                            i2 = zzada.zzE(zzG2);
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            long zzG3 = zzG(obj2, j);
                            zzp = zzada.zzE(i8 << 3);
                            i2 = zzada.zzF(zzG3);
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzE16 = zzada.zzE(i8 << 3);
                            zzz = zzE16 + 4;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzE15 = zzada.zzE(i8 << 3);
                            zzz = zzE15 + 8;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            int zzG4 = zzG(obj2, j);
                            zzp = zzada.zzE(i8 << 3);
                            i2 = zzada.zzE((zzG4 >> 31) ^ (zzG4 + zzG4));
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            long zzH3 = zzH(obj2, j);
                            zzp = zzada.zzE(i8 << 3);
                            i2 = zzada.zzF((zzH3 >> 63) ^ (zzH3 + zzH3));
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzz = zzafq.zzA(i8, (zzafc) unsafe.getObject(obj2, j), zzaffVar.zzq(i4));
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                }
                i4 += 3;
                obj2 = obj;
            } else {
                int zzi = i6 + ((zzadu) obj).zzc.zzi();
                if (!zzaffVar.zzh) {
                    return zzi;
                }
                zzafv zzafvVar = ((zzadr) obj).zzb.zza;
                int zzc2 = zzafvVar.zzc();
                int i34 = 0;
                for (int i35 = 0; i35 < zzc2; i35++) {
                    Map.Entry zzd = zzafvVar.zzd(i35);
                    i34 += zzadk.zzj((zzadj) ((zzafs) zzd).zza(), zzd.getValue());
                }
                for (Map.Entry entry2 : zzafvVar.zze()) {
                    i34 += zzadk.zzj((zzadj) entry2.getKey(), entry2.getValue());
                }
                return zzi + i34;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:249:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    @Override // com.google.android.gms.internal.measurement.zzafp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzf(java.lang.Object r19, com.google.android.gms.internal.measurement.zzago r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaff.zzf(java.lang.Object, com.google.android.gms.internal.measurement.zzago):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0093. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:37:0x055c A[LOOP:1: B:35:0x0558->B:37:0x055c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x052e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0523 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzafp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzg(java.lang.Object r12, com.google.android.gms.internal.measurement.zzafo r13, com.google.android.gms.internal.measurement.zzadf r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1536
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaff.zzg(java.lang.Object, com.google.android.gms.internal.measurement.zzafo, com.google.android.gms.internal.measurement.zzadf):void");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    final int zzi(java.lang.Object r35, byte[] r36, int r37, int r38, int r39, com.google.android.gms.internal.measurement.zzacg r40) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaff.zzi(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzacg):int");
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzj(Object obj, byte[] bArr, int i, int i2, zzacg zzacgVar) throws IOException {
        zzi(obj, bArr, i, i2, 0, zzacgVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzk(Object obj) {
        if (zzE(obj)) {
            if (obj instanceof zzadu) {
                zzadu zzaduVar = (zzadu) obj;
                zzaduVar.zzcp(Integer.MAX_VALUE);
                zzaduVar.zza = 0;
                zzaduVar.zzci();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzA = zzA(i);
                int i2 = 1048575 & zzA;
                int zzC = zzC(zzA);
                long j = i2;
                if (zzC != 9) {
                    if (zzC != 60 && zzC != 68) {
                        switch (zzC) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                            case 49:
                                ((zzaef) zzagg.zzm(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzaew) object).zzd();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzM(obj, iArr[i], i)) {
                        zzq(i).zzk(zzb.getObject(obj, j));
                    }
                }
                if (zzK(obj, i)) {
                    zzq(i).zzk(zzb.getObject(obj, j));
                }
            }
            this.zzm.zzj(obj);
            if (this.zzh) {
                this.zzn.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final boolean zzl(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i3 < this.zzk) {
            int i6 = this.zzj[i3];
            int zzA = this.zzA(i6);
            int[] iArr = this.zzc;
            int i7 = iArr[i6 + 2];
            int i8 = i7 & 1048575;
            int i9 = 1 << (i7 >>> 20);
            if (i8 != i5) {
                if (i8 != 1048575) {
                    i4 = zzb.getInt(obj, i8);
                }
                i2 = i4;
                i = i8;
            } else {
                i = i5;
                i2 = i4;
            }
            zzaff<T> zzaffVar = this;
            Object obj2 = obj;
            if ((268435456 & zzA) != 0 && !zzaffVar.zzJ(obj2, i6, i, i2, i9)) {
                return false;
            }
            int zzC = zzC(zzA);
            if (zzC != 9 && zzC != 17) {
                if (zzC != 27) {
                    if (zzC == 60 || zzC == 68) {
                        if (zzaffVar.zzM(obj2, iArr[i6], i6) && !zzy(obj2, zzA, zzaffVar.zzq(i6))) {
                            return false;
                        }
                    } else if (zzC != 49) {
                        if (zzC != 50) {
                            continue;
                        } else {
                            zzaew zzaewVar = (zzaew) zzagg.zzm(obj2, zzA & 1048575);
                            if (!zzaewVar.isEmpty() && ((zzaev) zzaffVar.zzr(i6)).zze().zzc.zza() == zzagn.MESSAGE) {
                                zzafp zzafpVar = null;
                                for (Object obj3 : zzaewVar.values()) {
                                    if (zzafpVar == null) {
                                        zzafpVar = zzafl.zza().zzb(obj3.getClass());
                                    }
                                    if (!zzafpVar.zzl(obj3)) {
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
                List list = (List) zzagg.zzm(obj2, zzA & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzafp zzq = zzaffVar.zzq(i6);
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        if (!zzq.zzl(list.get(i10))) {
                            return false;
                        }
                    }
                }
            } else if (zzaffVar.zzJ(obj2, i6, i, i2, i9) && !zzy(obj2, zzA, zzaffVar.zzq(i6))) {
                return false;
            }
            i3++;
            this = zzaffVar;
            obj = obj2;
            i5 = i;
            i4 = i2;
        }
        return !this.zzh || ((zzadr) obj).zzb.zze();
    }
}
