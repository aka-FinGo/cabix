package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes5.dex */
public final class zzda extends zzde {
    private final int zzc;
    private final int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzda(byte[] bArr, int i, int i2) {
        super(bArr);
        zzo(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final byte zza(int i) {
        zzu(i, this.zzd);
        return this.zza[this.zzc + i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final byte zzb(int i) {
        return this.zza[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde
    protected final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzd() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, this.zzc + i, bArr, i2, i3);
    }
}
