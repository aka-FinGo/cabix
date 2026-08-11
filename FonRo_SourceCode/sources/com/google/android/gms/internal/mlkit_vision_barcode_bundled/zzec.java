package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes5.dex */
public class zzec extends zzeb implements zzfn {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzec(zzed zzedVar) {
        super(zzedVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeb, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfl
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzed zzk() {
        if (!((zzed) this.zza).zzY()) {
            return (zzed) this.zza;
        }
        ((zzed) this.zza).zzb.zzg();
        return (zzed) super.zzk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeb
    public final void zzn() {
        super.zzn();
        if (((zzed) this.zza).zzb != zzdx.zzd()) {
            zzed zzedVar = (zzed) this.zza;
            zzedVar.zzb = zzedVar.zzb.clone();
        }
    }
}
