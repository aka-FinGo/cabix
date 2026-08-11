package com.google.android.gms.internal.measurement;

import android.os.StrictMode;
import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
final class zzvz {
    private static final zzvz zza;
    private final UUID zzb;
    private final AtomicLong zzc;

    static {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            zza = new zzvz(UUID.randomUUID(), new SecureRandom().nextLong());
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    zzvz(UUID uuid, long j) {
        this.zzb = uuid;
        this.zzc = new AtomicLong((j ^ 25214903917L) & 281474976710655L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzvz zza() {
        return zza;
    }

    final long zzb() {
        AtomicLong atomicLong;
        long j;
        do {
            atomicLong = this.zzc;
            j = atomicLong.get();
        } while (!atomicLong.compareAndSet(j, ((25214903917L * (((j * 25214903917L) + 11) & 281474976710655L)) + 11) & 281474976710655L));
        return (((int) (r5 >>> 16)) << 32) + ((int) (r3 >>> 16));
    }

    public final UUID zzc() {
        long zzb = zzb() & (-61441);
        long zzb2 = zzb() >>> 2;
        UUID uuid = this.zzb;
        return new UUID(zzb ^ uuid.getMostSignificantBits(), zzb2 ^ uuid.getLeastSignificantBits());
    }
}
