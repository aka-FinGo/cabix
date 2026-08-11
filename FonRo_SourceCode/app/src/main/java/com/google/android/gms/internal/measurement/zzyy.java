package com.google.android.gms.internal.measurement;

import java.util.Calendar;
import java.util.Date;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzyy extends zzabm implements zzabi {
    protected final Object[] zza;
    protected final StringBuilder zzb;
    private int zzc;

    protected zzyy(zzaaf zzaafVar, Object[] objArr, StringBuilder sb) {
        super(zzaafVar);
        this.zzc = 0;
        this.zza = objArr;
        this.zzb = sb;
    }

    public static StringBuilder zza(zzzd zzzdVar, StringBuilder sb) {
        if (zzzdVar.zzh() != null) {
            zzyy zzyyVar = new zzyy(zzzdVar.zzh(), zzzdVar.zzi(), sb);
            StringBuilder sb2 = (StringBuilder) zzyyVar.zzl();
            if (zzzdVar.zzi().length > zzyyVar.zzj()) {
                sb2.append(" [ERROR: UNUSED LOG ARGUMENTS]");
            }
            return sb2;
        }
        sb.append(zzzh.zza(zzzdVar.zzj()));
        return sb;
    }

    private static void zzm(StringBuilder sb, Object obj, String str) {
        sb.append("[INVALID: format=");
        sb.append(str);
        sb.append(", type=");
        sb.append(obj.getClass().getCanonicalName());
        sb.append(", value=");
        sb.append(zzzh.zza(obj));
        sb.append("]");
    }

    @Override // com.google.android.gms.internal.measurement.zzabm
    public final void zzb(int i, int i2, zzabh zzabhVar) {
        zzh().zzd(this.zzb, zzi(), this.zzc, i);
        zzabhVar.zze(this, this.zza);
        this.zzc = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
    
        if ((r7 instanceof java.math.BigDecimal) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003a, code lost:
    
        if ((r7 instanceof java.math.BigInteger) == false) goto L16;
     */
    @Override // com.google.android.gms.internal.measurement.zzabi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzc(java.lang.Object r7, com.google.android.gms.internal.measurement.zzyz r8, com.google.android.gms.internal.measurement.zzza r9) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzyy.zzc(java.lang.Object, com.google.android.gms.internal.measurement.zzyz, com.google.android.gms.internal.measurement.zzza):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzabi
    public final void zzd(Object obj, zzabf zzabfVar, zzza zzzaVar) {
        if ((obj instanceof Date) || (obj instanceof Calendar) || (obj instanceof Long)) {
            StringBuilder sb = new StringBuilder("%");
            zzzaVar.zzl(sb);
            sb.append(true != zzzaVar.zzk() ? 't' : 'T');
            sb.append(zzabfVar.zzb());
            this.zzb.append(String.format(zzzh.zza, sb.toString(), obj));
            return;
        }
        StringBuilder sb2 = this.zzb;
        char zzb = zzabfVar.zzb();
        StringBuilder sb3 = new StringBuilder(String.valueOf(zzb).length() + 2);
        sb3.append("%t");
        sb3.append(zzb);
        zzm(sb2, obj, sb3.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzabi
    public final void zze() {
        this.zzb.append("[ERROR: MISSING LOG ARGUMENT]");
    }

    @Override // com.google.android.gms.internal.measurement.zzabi
    public final void zzf() {
        this.zzb.append(AbstractJsonLexerKt.NULL);
    }

    @Override // com.google.android.gms.internal.measurement.zzabm
    public final /* bridge */ /* synthetic */ Object zzg() {
        zzabn zzh = zzh();
        String zzi = zzi();
        int i = this.zzc;
        int length = zzi().length();
        StringBuilder sb = this.zzb;
        zzh.zzd(sb, zzi, i, length);
        return sb;
    }
}
