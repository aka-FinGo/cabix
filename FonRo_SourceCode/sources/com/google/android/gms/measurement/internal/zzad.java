package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzad extends zzos {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(zzpg zzpgVar) {
        super(zzpgVar);
    }

    private final zzy zzc(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzy) this.zzc.get(num);
        }
        zzy zzyVar = new zzy(this, this.zza, null);
        this.zzc.put(num, zzyVar);
        return zzyVar;
    }

    private final boolean zzd(int i, int i2) {
        zzy zzyVar = (zzy) this.zzc.get(Integer.valueOf(i));
        if (zzyVar == null) {
            return false;
        }
        return zzyVar.zzc().get(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:(6:19|20|21|22|23|(15:(7:25|26|27|28|(1:30)(3:513|(1:515)(1:517)|516)|31|(1:34)(1:33))|(1:36)|37|38|39|40|41|42|(3:44|(1:46)|47)(4:468|(6:469|470|471|472|473|(1:476)(1:475))|(1:478)|479)|48|(5:300|(7:302|303|304|305|306|(1:452)|(3:308|(1:310)|311))(1:467)|320|(10:323|(3:327|(4:330|(5:332|333|(1:335)(1:339)|336|337)(1:340)|338|328)|341)|342|(3:346|(4:349|(3:354|355|356)|357|347)|360)|361|(3:363|(6:366|(2:368|(3:370|371|372))(1:375)|373|374|372|364)|376)|377|(3:386|(8:389|(1:391)|392|(1:394)|395|(2:397|398)(1:400)|399|387)|401)|402|321)|408)|50|51|(3:53|(4:56|(3:58|59|(8:61|62|(10:64|65|66|67|68|69|70|71|(4:73|(11:74|75|76|77|78|79|80|(3:82|83|84)(1:137)|85|86|(1:89)(1:88))|(1:91)|92)(3:143|144|(1:146))|93)(1:160)|94|(4:97|(3:115|116|117)(6:99|100|(2:101|(2:103|(1:105)(2:106|107))(2:113|114))|(1:109)|110|111)|112|95)|118|119|120)(1:161))(1:162)|121|54)|163)|(6:165|(3:167|(6:170|(7:172|173|174|175|176|(3:(9:178|179|180|181|182|(3:184|185|186)(1:248)|187|188|(1:191)(1:190))|(1:193)|194)(2:255|256)|195)(1:271)|196|(2:197|(2:199|(3:235|236|237)(8:201|(2:202|(4:204|(3:206|(1:208)(1:231)|209)(1:232)|210|(1:1)(2:214|(1:216)(2:217|218)))(2:233|234))|225|(1:227)(1:229)|228|220|221|222))(0))|238|168)|272)|273|(10:276|277|278|279|280|281|283|(3:285|286|287)(1:289)|288|274)|296|297)(2:298|299))(1:521))|41|42|(0)(0)|48|(0)|50|51|(0)|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(20:1|(2:2|(2:4|(2:6|7)(1:537))(2:538|539))|8|(3:10|11|12)|16|(6:19|20|21|22|23|(15:(7:25|26|27|28|(1:30)(3:513|(1:515)(1:517)|516)|31|(1:34)(1:33))|(1:36)|37|38|39|40|41|42|(3:44|(1:46)|47)(4:468|(6:469|470|471|472|473|(1:476)(1:475))|(1:478)|479)|48|(5:300|(7:302|303|304|305|306|(1:452)|(3:308|(1:310)|311))(1:467)|320|(10:323|(3:327|(4:330|(5:332|333|(1:335)(1:339)|336|337)(1:340)|338|328)|341)|342|(3:346|(4:349|(3:354|355|356)|357|347)|360)|361|(3:363|(6:366|(2:368|(3:370|371|372))(1:375)|373|374|372|364)|376)|377|(3:386|(8:389|(1:391)|392|(1:394)|395|(2:397|398)(1:400)|399|387)|401)|402|321)|408)|50|51|(3:53|(4:56|(3:58|59|(8:61|62|(10:64|65|66|67|68|69|70|71|(4:73|(11:74|75|76|77|78|79|80|(3:82|83|84)(1:137)|85|86|(1:89)(1:88))|(1:91)|92)(3:143|144|(1:146))|93)(1:160)|94|(4:97|(3:115|116|117)(6:99|100|(2:101|(2:103|(1:105)(2:106|107))(2:113|114))|(1:109)|110|111)|112|95)|118|119|120)(1:161))(1:162)|121|54)|163)|(6:165|(3:167|(6:170|(7:172|173|174|175|176|(3:(9:178|179|180|181|182|(3:184|185|186)(1:248)|187|188|(1:191)(1:190))|(1:193)|194)(2:255|256)|195)(1:271)|196|(2:197|(2:199|(3:235|236|237)(8:201|(2:202|(4:204|(3:206|(1:208)(1:231)|209)(1:232)|210|(1:1)(2:214|(1:216)(2:217|218)))(2:233|234))|225|(1:227)(1:229)|228|220|221|222))(0))|238|168)|272)|273|(10:276|277|278|279|280|281|283|(3:285|286|287)(1:289)|288|274)|296|297)(2:298|299))(1:521))|536|38|39|40|41|42|(0)(0)|48|(0)|50|51|(0)|(0)(0)|(4:(0)|(0)|(0)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0992, code lost:
    
        if (r12 != false) goto L511;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0874, code lost:
    
        if (r13 != null) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x084c, code lost:
    
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x084a, code lost:
    
        if (r13 != null) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x02b8, code lost:
    
        if (r6 != null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x02ba, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x02e3, code lost:
    
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r11);
        r3 = new androidx.collection.ArrayMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x02f2, code lost:
    
        if (r11.isEmpty() == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x02f4, code lost:
    
        r17 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x03ea, code lost:
    
        r0 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x02f8, code lost:
    
        r4 = r11.keySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x0304, code lost:
    
        if (r4.hasNext() == false) goto L549;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x0306, code lost:
    
        r5 = (java.lang.Integer) r4.next();
        r5.intValue();
        r6 = (com.google.android.gms.internal.measurement.zzii) r11.get(r5);
        r7 = (java.util.List) r0.get(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x031b, code lost:
    
        if (r7 == null) goto L553;
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x0321, code lost:
    
        if (r7.isEmpty() == false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x0325, code lost:
    
        r8 = r34.zzg;
        r16 = r0;
        r17 = r2;
        r0 = r8.zzp().zzq(r6.zzc(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x033b, code lost:
    
        if (r0.isEmpty() != false) goto L550;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x03d3, code lost:
    
        r0 = r16;
        r2 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x033d, code lost:
    
        r2 = (com.google.android.gms.internal.measurement.zzih) r6.zzco();
        r2.zzd();
        r2.zzc(r0);
        r0 = r8.zzp().zzq(r6.zza(), r7);
        r2.zzb();
        r2.zza(r0);
        r0 = new java.util.ArrayList();
        r8 = r6.zze().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x036c, code lost:
    
        if (r8.hasNext() == false) goto L557;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x036e, code lost:
    
        r21 = r4;
        r4 = (com.google.android.gms.internal.measurement.zzhq) r8.next();
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x0386, code lost:
    
        if (r7.contains(java.lang.Integer.valueOf(r4.zzb())) != false) goto L559;
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x0388, code lost:
    
        r0.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x038b, code lost:
    
        r4 = r21;
        r8 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x0390, code lost:
    
        r21 = r4;
        r2.zzf();
        r2.zze(r0);
        r0 = new java.util.ArrayList();
        r4 = r6.zzh().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:435:0x03a9, code lost:
    
        if (r4.hasNext() == false) goto L560;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x03ab, code lost:
    
        r6 = (com.google.android.gms.internal.measurement.zzik) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x03bd, code lost:
    
        if (r7.contains(java.lang.Integer.valueOf(r6.zzb())) != false) goto L563;
     */
    /* JADX WARN: Code restructure failed: missing block: B:439:0x03bf, code lost:
    
        r0.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:444:0x03c3, code lost:
    
        r2.zzh();
        r2.zzg(r0);
        r3.put(r5, (com.google.android.gms.internal.measurement.zzii) r2.zzbd());
     */
    /* JADX WARN: Code restructure failed: missing block: B:445:0x03e2, code lost:
    
        r0 = r16;
        r2 = r17;
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x03d9, code lost:
    
        r16 = r0;
        r17 = r2;
        r21 = r4;
        r3.put(r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:453:0x02c0, code lost:
    
        if (r6 != null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:456:0x02e0, code lost:
    
        if (r6 == null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:500:0x021b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:501:0x021c, code lost:
    
        r17 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:502:0x021e, code lost:
    
        r18 = "data";
     */
    /* JADX WARN: Code restructure failed: missing block: B:509:0x0227, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:510:0x0228, code lost:
    
        r17 = r2;
        r18 = "data";
        r19 = "audience_id";
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:511:0x0223, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:512:0x0224, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:522:0x0149, code lost:
    
        if (r5 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:523:0x014b, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:526:0x016b, code lost:
    
        if (r5 == null) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:128:0x06c9  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x077a  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0a47  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a6 A[Catch: SQLiteException -> 0x021b, all -> 0x0a4d, TRY_LEAVE, TryCatch #10 {SQLiteException -> 0x021b, blocks: (B:42:0x01a0, B:44:0x01a6, B:468:0x01b6, B:469:0x01bb, B:471:0x01c5, B:472:0x01d5, B:488:0x01e4), top: B:41:0x01a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:461:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x01b6 A[Catch: SQLiteException -> 0x021b, all -> 0x0a4d, TRY_ENTER, TryCatch #10 {SQLiteException -> 0x021b, blocks: (B:42:0x01a0, B:44:0x01a6, B:468:0x01b6, B:469:0x01bb, B:471:0x01c5, B:472:0x01d5, B:488:0x01e4), top: B:41:0x01a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:484:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:530:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x05a1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x06eb  */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.util.Map, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v42, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v49 */
    /* JADX WARN: Type inference failed for: r5v50 */
    /* JADX WARN: Type inference failed for: r5v51 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List zzb(java.lang.String r35, java.util.List r36, java.util.List r37, java.lang.Long r38, java.lang.Long r39, boolean r40) {
        /*
            Method dump skipped, instructions count: 2645
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzb(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long, boolean):java.util.List");
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean zzbc() {
        return false;
    }
}
