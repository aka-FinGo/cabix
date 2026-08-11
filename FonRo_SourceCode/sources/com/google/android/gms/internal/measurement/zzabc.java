package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzabc extends AbstractMap {
    private static final Comparator zza = new zzaaz();
    private final Object[] zzb;
    private final int[] zzc;
    private final Set zzd;
    private Integer zze;
    private String zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0145, code lost:
    
        if (r8 < 0) goto L54;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractMap, com.google.android.gms.internal.measurement.zzabc] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.measurement.zzabc] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzabc(com.google.android.gms.internal.measurement.zzabc r21, com.google.android.gms.internal.measurement.zzabc r22) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzabc.<init>(com.google.android.gms.internal.measurement.zzabc, com.google.android.gms.internal.measurement.zzabc):void");
    }

    private final int zzd(Map.Entry entry, int i, int i2, Object[] objArr, int[] iArr) {
        zzabb zzabbVar = (zzabb) entry.getValue();
        int zzc = zzabbVar.zzc() - zzabbVar.zzb();
        System.arraycopy(zzabbVar.zzb.zzb, zzabbVar.zzb(), objArr, i2, zzc);
        objArr[i] = zzf((String) entry.getKey(), i);
        int i3 = i2 + zzc;
        iArr[i + 1] = i3;
        return i3;
    }

    private static boolean zze(int i, int i2) {
        return i > 16 && i * 9 > i2 * 10;
    }

    private final Map.Entry zzf(String str, int i) {
        return new AbstractMap.SimpleImmutableEntry(str, new zzabb(this, i));
    }

    private final Map.Entry zzg(int i) {
        if (i < this.zzc[0]) {
            return (Map.Entry) this.zzb[i];
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return this.zzd;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        Integer num = this.zze;
        if (num == null) {
            num = Integer.valueOf(super.hashCode());
            this.zze = num;
        }
        return num.intValue();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        String str = this.zzf;
        if (str != null) {
            return str;
        }
        String abstractMap = super.toString();
        this.zzf = abstractMap;
        return abstractMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object[] zzb() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ int[] zzc() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabc(List list) {
        this.zzd = new zzabb(this, -1);
        this.zze = null;
        this.zzf = null;
        Iterator it = list.iterator();
        if (it.hasNext()) {
            throw null;
        }
        int size = list.size();
        Object[] objArr = new Object[size];
        Iterator it2 = list.iterator();
        if (it2.hasNext()) {
            throw null;
        }
        int[] iArr = {0};
        this.zzb = zze(size, 0) ? Arrays.copyOf(objArr, 0) : objArr;
        this.zzc = iArr;
    }
}
