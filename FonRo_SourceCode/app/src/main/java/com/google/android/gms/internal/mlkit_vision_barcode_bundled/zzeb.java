package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeb;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes5.dex */
public class zzeb<MessageType extends zzeh<MessageType, BuilderType>, BuilderType extends zzeb<MessageType, BuilderType>> extends zzcp<MessageType, BuilderType> {
    protected zzeh zza;
    private final zzeh zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzeb(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzY()) {
            this.zza = messagetype.zzK();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zzfu.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn
    public final /* bridge */ /* synthetic */ zzfm zzac() {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn
    public final boolean zzad() {
        return zzeh.zzX(this.zza, false);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcp
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzeb clone() {
        zzeb zzebVar = (zzeb) this.zzb.zzg(5, null, null);
        zzebVar.zza = zzk();
        return zzebVar;
    }

    public final zzeb zzg(zzeh zzehVar) {
        if (!this.zzb.equals(zzehVar)) {
            if (!this.zza.zzY()) {
                zzn();
            }
            zza(this.zza, zzehVar);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfl
    /* renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final MessageType zzj() {
        MessageType zzk = zzk();
        if (zzeh.zzX(zzk, true)) {
            return zzk;
        }
        throw new zzgr(zzk);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfl
    /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public MessageType zzk() {
        boolean zzY = this.zza.zzY();
        MessageType messagetype = (MessageType) this.zza;
        if (!zzY) {
            return messagetype;
        }
        messagetype.zzT();
        return (MessageType) this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzm() {
        if (this.zza.zzY()) {
            return;
        }
        zzn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzn() {
        zzeh zzK = this.zzb.zzK();
        zza(zzK, this.zza);
        this.zza = zzK;
    }
}
