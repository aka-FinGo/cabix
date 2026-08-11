package uz.FonRo.pos.ui.components;

import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes6.dex */
public final /* synthetic */ class NumpadKt$$ExternalSyntheticBackportWithForwarding0 {
    public static /* synthetic */ BigDecimal m(BigDecimal bigDecimal) {
        return bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
    }
}
