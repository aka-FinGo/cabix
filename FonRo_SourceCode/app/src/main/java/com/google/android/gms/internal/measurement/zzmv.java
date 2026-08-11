package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzmv implements Comparable {
    final long zza;
    final String zzb;
    final int zzc;
    final long zzd;
    final Object zze;
    private final RuntimeException zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmv(long j, String str, int i, long j2, Object obj) {
        Preconditions.checkArgument(((j > 0L ? 1 : (j == 0L ? 0 : -1)) == 0) == (str != null));
        this.zza = j;
        this.zzb = str;
        this.zzc = i;
        this.zzd = j2;
        this.zze = obj;
        if (i != 5) {
            this.zzf = null;
            return;
        }
        if (obj == null) {
            this.zzf = new NullPointerException("Null stringOrBytes");
            return;
        }
        if ((obj instanceof byte[]) || (obj instanceof zzacr)) {
            this.zzf = null;
            return;
        }
        String valueOf = String.valueOf(obj.getClass());
        String.valueOf(valueOf);
        this.zzf = new RuntimeException("Wrong stringOrBytes type: ".concat(String.valueOf(valueOf)));
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzmv zzmvVar = (zzmv) obj;
        long j = zzmvVar.zza;
        long j2 = this.zza;
        int compare = Long.compare(j2, j);
        if (compare != 0) {
            return compare;
        }
        if (j2 != 0) {
            return 0;
        }
        return ((String) Preconditions.checkNotNull(this.zzb)).compareTo((String) Preconditions.checkNotNull(zzmvVar.zzb));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzmv)) {
            return false;
        }
        zzmv zzmvVar = (zzmv) obj;
        return this.zza == zzmvVar.zza && Objects.equals(this.zzb, zzmvVar.zzb);
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        String zza = zza();
        String valueOf = String.valueOf(zzb());
        StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 1 + String.valueOf(valueOf).length());
        sb.append(zza);
        sb.append(":");
        sb.append(valueOf);
        return sb.toString();
    }

    public final String zza() {
        String str = this.zzb;
        return str != null ? str : Long.toString(this.zza);
    }

    public final Object zzb() {
        int i = this.zzc;
        if (i == 0) {
            return false;
        }
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return Long.valueOf(this.zzd);
        }
        if (i == 3) {
            return Double.valueOf(Double.longBitsToDouble(this.zzd));
        }
        if (i == 4) {
            Object obj = this.zze;
            Preconditions.checkNotNull(obj);
            return obj;
        }
        if (i == 5) {
            Object obj2 = this.zze;
            Preconditions.checkNotNull(obj2);
            try {
                if (!(obj2 instanceof byte[])) {
                    return ((zzacr) obj2).zzm();
                }
                return (byte[]) obj2;
            } catch (Throwable th) {
                RuntimeException runtimeException = this.zzf;
                if (runtimeException != null) {
                    th.addSuppressed(runtimeException);
                }
                throw th;
            }
        }
        throw new AssertionError("Impossible, this was validated when parsed or created");
    }
}
