package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
import uz.FonRo.pos.BuildConfig;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzrx extends zzsy {
    private final Context zza;
    private final zzsx zzb;
    private final Object zzc = new Object();

    @Nullable
    private String zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzrx(zzrw zzrwVar, byte[] bArr) {
        this.zzb = new zzsd(zzrwVar.zzc());
        this.zza = zzrwVar.zzb();
    }

    public static zzrw zza(Context context) {
        return new zzrw(context, null);
    }

    private final boolean zzh(Uri uri) {
        return (TextUtils.isEmpty(uri.getAuthority()) || this.zza.getPackageName().equals(uri.getAuthority())) ? false : true;
    }

    private static final void zzi() throws zzsg {
        throw new zzsg("Android backend cannot perform remote operations without a remote backend");
    }

    @Override // com.google.android.gms.internal.measurement.zzsy
    protected final zzsx zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final String zzc() {
        return BuildConfig.API_CLIENT;
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final InputStream zzd(Uri uri) throws IOException {
        if (!zzh(uri)) {
            return zzsl.zzb(zzsc.zza(zzf(uri)));
        }
        zzi();
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final boolean zze(Uri uri) throws IOException {
        if (!zzh(uri)) {
            return zzsc.zza(zzf(uri)).exists();
        }
        zzi();
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzsy
    protected final Uri zzf(Uri uri) throws IOException {
        if (zzh(uri)) {
            throw new zzsi("Operation across authorities is not allowed.");
        }
        File zzg = zzg(uri);
        zzsb zzsbVar = new zzsb(null);
        zzsbVar.zza(zzg);
        return zzsbVar.zzb();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x003d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:16:0x010f  */
    @Override // com.google.android.gms.internal.measurement.zzsx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.File zzg(android.net.Uri r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzrx.zzg(android.net.Uri):java.io.File");
    }
}
