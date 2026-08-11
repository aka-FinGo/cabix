package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes5.dex */
final class zzfq implements zzge {
    private final zzfm zza;
    private final zzgs zzb;
    private final boolean zzc;
    private final zzdt zzd;

    private zzfq(zzgs zzgsVar, zzdt zzdtVar, zzfm zzfmVar) {
        this.zzb = zzgsVar;
        this.zzc = zzfmVar instanceof zzed;
        this.zzd = zzdtVar;
        this.zza = zzfmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfq zzc(zzgs zzgsVar, zzdt zzdtVar, zzfm zzfmVar) {
        return new zzfq(zzgsVar, zzdtVar, zzfmVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zza(Object obj) {
        int zzb = ((zzeh) obj).zzc.zzb();
        return this.zzc ? zzb + ((zzed) obj).zzb.zzb() : zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zzb(Object obj) {
        int hashCode = ((zzeh) obj).zzc.hashCode();
        return this.zzc ? (hashCode * 53) + ((zzed) obj).zzb.zza.hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final Object zze() {
        zzfm zzfmVar = this.zza;
        return zzfmVar instanceof zzeh ? ((zzeh) zzfmVar).zzK() : zzfmVar.zzZ().zzk();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzf(Object obj) {
        this.zzb.zza(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzg(Object obj, Object obj2) {
        zzgg.zzp(this.zzb, obj, obj2);
        if (this.zzc) {
            zzgg.zzo(this.zzd, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00be A[EDGE_INSN: B:24:0x00be->B:25:0x00be BREAK  A[LOOP:1: B:10:0x0067->B:18:0x0067], SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzh(java.lang.Object r11, byte[] r12, int r13, int r14, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfq.zzh(java.lang.Object, byte[], int, int, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu):void");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzi(Object obj, zzhh zzhhVar) throws IOException {
        Iterator zzf = ((zzed) obj).zzb.zzf();
        while (zzf.hasNext()) {
            Map.Entry entry = (Map.Entry) zzf.next();
            zzdw zzdwVar = (zzdw) entry.getKey();
            if (zzdwVar.zze() != zzhg.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzdwVar.zzg();
            zzdwVar.zzf();
            if (entry instanceof zzeu) {
                zzhhVar.zzw(zzdwVar.zza(), ((zzeu) entry).zza().zzb());
            } else {
                zzhhVar.zzw(zzdwVar.zza(), entry.getValue());
            }
        }
        ((zzeh) obj).zzc.zzk(zzhhVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzj(Object obj, Object obj2) {
        if (!((zzeh) obj).zzc.equals(((zzeh) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzed) obj).zzb.equals(((zzed) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzk(Object obj) {
        return ((zzed) obj).zzb.zzk();
    }
}
