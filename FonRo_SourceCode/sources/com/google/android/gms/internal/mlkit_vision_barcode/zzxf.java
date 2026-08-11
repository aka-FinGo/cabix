package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes5.dex */
final class zzxf extends zzxm {
    private final int zzb;
    private final int zzc;
    private final float zzd;
    private final float zze;
    private final boolean zzf;
    private final float zzg;
    private final float zzh;
    private final long zzi;
    private final long zzj;
    private final boolean zzk;
    private final float zzl;
    private final float zzm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzxf(int i, int i2, float f, float f2, boolean z, float f3, float f4, long j, long j2, boolean z2, float f5, float f6, zzxe zzxeVar) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = f;
        this.zze = f2;
        this.zzf = z;
        this.zzg = f3;
        this.zzh = f4;
        this.zzi = j;
        this.zzj = j2;
        this.zzk = z2;
        this.zzl = f5;
        this.zzm = f6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzxm) {
            zzxm zzxmVar = (zzxm) obj;
            if (this.zzb == zzxmVar.zzh() && this.zzc == zzxmVar.zzg() && Float.floatToIntBits(this.zzd) == Float.floatToIntBits(zzxmVar.zzd()) && Float.floatToIntBits(this.zze) == Float.floatToIntBits(zzxmVar.zzc()) && this.zzf == zzxmVar.zzl() && Float.floatToIntBits(this.zzg) == Float.floatToIntBits(zzxmVar.zzb()) && Float.floatToIntBits(this.zzh) == Float.floatToIntBits(zzxmVar.zza()) && this.zzi == zzxmVar.zzj() && this.zzj == zzxmVar.zzi() && this.zzk == zzxmVar.zzk() && Float.floatToIntBits(this.zzl) == Float.floatToIntBits(zzxmVar.zze()) && Float.floatToIntBits(this.zzm) == Float.floatToIntBits(zzxmVar.zzf())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.zzm) ^ ((((((((((((((((((((((this.zzb ^ 1000003) * 1000003) ^ this.zzc) * 1000003) ^ Float.floatToIntBits(this.zzd)) * 1000003) ^ Float.floatToIntBits(this.zze)) * 1000003) ^ (true != this.zzf ? 1237 : 1231)) * 1000003) ^ Float.floatToIntBits(this.zzg)) * 1000003) ^ Float.floatToIntBits(this.zzh)) * 1000003) ^ ((int) this.zzi)) * 1000003) ^ ((int) this.zzj)) * 1000003) ^ (true == this.zzk ? 1231 : 1237)) * 1000003) ^ Float.floatToIntBits(this.zzl)) * 1000003);
    }

    public final String toString() {
        return "AutoZoomOptions{recentFramesToCheck=" + this.zzb + ", recentFramesContainingPredictedArea=" + this.zzc + ", recentFramesIou=" + this.zzd + ", maxCoverage=" + this.zze + ", useConfidenceScore=" + this.zzf + ", lowerConfidenceScore=" + this.zzg + ", higherConfidenceScore=" + this.zzh + ", zoomIntervalInMillis=" + this.zzi + ", resetIntervalInMillis=" + this.zzj + ", enableZoomThreshold=" + this.zzk + ", zoomInThreshold=" + this.zzl + ", zoomOutThreshold=" + this.zzm + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxm
    public final float zza() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxm
    public final float zzb() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxm
    public final float zzc() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxm
    public final float zzd() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxm
    public final float zze() {
        return this.zzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxm
    public final float zzf() {
        return this.zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxm
    public final int zzg() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxm
    public final int zzh() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxm
    public final long zzi() {
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxm
    public final long zzj() {
        return this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxm
    public final boolean zzk() {
        return this.zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxm
    public final boolean zzl() {
        return this.zzf;
    }
}
