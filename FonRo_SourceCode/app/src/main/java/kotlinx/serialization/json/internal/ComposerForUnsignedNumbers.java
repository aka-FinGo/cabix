package kotlinx.serialization.json.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.ui.nav.Routes;

/* compiled from: Composers.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\fH\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/serialization/json/internal/ComposerForUnsignedNumbers;", "Lkotlinx/serialization/json/internal/Composer;", "writer", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "forceQuoting", "", "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;Z)V", Routes.PRINT, "", "v", "", "", "", "", "kotlinx-serialization-json"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes6.dex */
public final class ComposerForUnsignedNumbers extends Composer {
    private final boolean forceQuoting;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(InternalJsonWriter writer, boolean z) {
        super(writer);
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.forceQuoting = z;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(int v) {
        String m7940m;
        String m7940m2;
        boolean z = this.forceQuoting;
        int m7970constructorimpl = UInt.m7970constructorimpl(v);
        if (z) {
            m7940m2 = UByte$$ExternalSyntheticBackport0.m7940m(m7970constructorimpl, 10);
            printQuoted(m7940m2);
        } else {
            m7940m = UByte$$ExternalSyntheticBackport0.m7940m(m7970constructorimpl, 10);
            print(m7940m);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(long v) {
        String m;
        String m2;
        boolean z = this.forceQuoting;
        long m8049constructorimpl = ULong.m8049constructorimpl(v);
        if (z) {
            m2 = UByte$$ExternalSyntheticBackport0.m(m8049constructorimpl, 10);
            printQuoted(m2);
        } else {
            m = UByte$$ExternalSyntheticBackport0.m(m8049constructorimpl, 10);
            print(m);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(byte v) {
        boolean z = this.forceQuoting;
        String m7932toStringimpl = UByte.m7932toStringimpl(UByte.m7888constructorimpl(v));
        if (z) {
            printQuoted(m7932toStringimpl);
        } else {
            print(m7932toStringimpl);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(short v) {
        boolean z = this.forceQuoting;
        String m8200toStringimpl = UShort.m8200toStringimpl(UShort.m8156constructorimpl(v));
        if (z) {
            printQuoted(m8200toStringimpl);
        } else {
            print(m8200toStringimpl);
        }
    }
}
