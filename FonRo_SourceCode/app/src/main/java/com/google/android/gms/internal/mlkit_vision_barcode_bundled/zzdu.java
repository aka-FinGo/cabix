package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes5.dex */
final class zzdu extends zzdt {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdt
    public final void zza(Object obj) {
        ((zzed) obj).zzb.zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdt
    public final void zzb(zzhh zzhhVar, Map.Entry entry) throws IOException {
        zzee zzeeVar = (zzee) entry.getKey();
        zzhf zzhfVar = zzhf.DOUBLE;
        switch (zzeeVar.zzb) {
            case DOUBLE:
                zzhhVar.zzf(zzeeVar.zza, ((Double) entry.getValue()).doubleValue());
                return;
            case FLOAT:
                zzhhVar.zzo(zzeeVar.zza, ((Float) entry.getValue()).floatValue());
                return;
            case INT64:
                zzhhVar.zzt(zzeeVar.zza, ((Long) entry.getValue()).longValue());
                return;
            case UINT64:
                zzhhVar.zzK(zzeeVar.zza, ((Long) entry.getValue()).longValue());
                return;
            case INT32:
                zzhhVar.zzr(zzeeVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case FIXED64:
                zzhhVar.zzm(zzeeVar.zza, ((Long) entry.getValue()).longValue());
                return;
            case FIXED32:
                zzhhVar.zzk(zzeeVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case BOOL:
                zzhhVar.zzb(zzeeVar.zza, ((Boolean) entry.getValue()).booleanValue());
                return;
            case STRING:
                zzhhVar.zzG(zzeeVar.zza, (String) entry.getValue());
                return;
            case GROUP:
                zzhhVar.zzq(zzeeVar.zza, entry.getValue(), zzfu.zza().zzb(entry.getValue().getClass()));
                return;
            case MESSAGE:
                zzhhVar.zzv(zzeeVar.zza, entry.getValue(), zzfu.zza().zzb(entry.getValue().getClass()));
                return;
            case BYTES:
                zzhhVar.zzd(zzeeVar.zza, (zzdf) entry.getValue());
                return;
            case UINT32:
                zzhhVar.zzI(zzeeVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case ENUM:
                zzhhVar.zzr(zzeeVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case SFIXED32:
                zzhhVar.zzx(zzeeVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case SFIXED64:
                zzhhVar.zzz(zzeeVar.zza, ((Long) entry.getValue()).longValue());
                return;
            case SINT32:
                zzhhVar.zzB(zzeeVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case SINT64:
                zzhhVar.zzD(zzeeVar.zza, ((Long) entry.getValue()).longValue());
                return;
            default:
                return;
        }
    }
}
