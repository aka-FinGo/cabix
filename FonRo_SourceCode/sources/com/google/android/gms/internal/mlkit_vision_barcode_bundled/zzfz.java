package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes5.dex */
public final class zzfz {
    private final ArrayDeque zza = new ArrayDeque();

    private zzfz() {
    }

    public static /* bridge */ /* synthetic */ zzdf zza(zzfz zzfzVar, zzdf zzdfVar, zzdf zzdfVar2) {
        zzfzVar.zzb(zzdfVar);
        zzfzVar.zzb(zzdfVar2);
        zzdf zzdfVar3 = (zzdf) zzfzVar.zza.pop();
        while (!zzfzVar.zza.isEmpty()) {
            zzdfVar3 = new zzgd((zzdf) zzfzVar.zza.pop(), zzdfVar3);
        }
        return zzdfVar3;
    }

    private final void zzb(zzdf zzdfVar) {
        zzdf zzdfVar2;
        zzdf zzdfVar3;
        if (zzdfVar.zzh()) {
            int zzc = zzc(zzdfVar.zzd());
            ArrayDeque arrayDeque = this.zza;
            int zzc2 = zzgd.zzc(zzc + 1);
            if (arrayDeque.isEmpty() || ((zzdf) this.zza.peek()).zzd() >= zzc2) {
                this.zza.push(zzdfVar);
                return;
            }
            int zzc3 = zzgd.zzc(zzc);
            zzdf zzdfVar4 = (zzdf) this.zza.pop();
            while (true) {
                if (this.zza.isEmpty() || ((zzdf) this.zza.peek()).zzd() >= zzc3) {
                    break;
                } else {
                    zzdfVar4 = new zzgd((zzdf) this.zza.pop(), zzdfVar4);
                }
            }
            zzgd zzgdVar = new zzgd(zzdfVar4, zzdfVar);
            while (!this.zza.isEmpty()) {
                int zzc4 = zzc(zzgdVar.zzd()) + 1;
                ArrayDeque arrayDeque2 = this.zza;
                if (((zzdf) arrayDeque2.peek()).zzd() >= zzgd.zzc(zzc4)) {
                    break;
                } else {
                    zzgdVar = new zzgd((zzdf) this.zza.pop(), zzgdVar);
                }
            }
            this.zza.push(zzgdVar);
            return;
        }
        if (!(zzdfVar instanceof zzgd)) {
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(String.valueOf(zzdfVar.getClass()))));
        }
        zzgd zzgdVar2 = (zzgd) zzdfVar;
        zzdfVar2 = zzgdVar2.zzd;
        zzb(zzdfVar2);
        zzdfVar3 = zzgdVar2.zze;
        zzb(zzdfVar3);
    }

    private static final int zzc(int i) {
        int binarySearch = Arrays.binarySearch(zzgd.zza, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    public /* synthetic */ zzfz(zzfy zzfyVar) {
    }
}
