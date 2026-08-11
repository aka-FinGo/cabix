package uz.FonRo.pos.ui.components;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Numpad.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* synthetic */ class NumpadKt$NumpadSheet$2$2$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    final /* synthetic */ boolean $allowDecimal;
    final /* synthetic */ MutableState<Boolean> $pristine$delegate;
    final /* synthetic */ MutableState<String> $raw$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumpadKt$NumpadSheet$2$2$1(boolean z, MutableState<Boolean> mutableState, MutableState<String> mutableState2) {
        super(1, Intrinsics.Kotlin.class, "press", "NumpadSheet$press(ZLandroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Ljava/lang/String;)V", 0);
        this.$allowDecimal = z;
        this.$pristine$delegate = mutableState;
        this.$raw$delegate = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        NumpadKt.NumpadSheet$press(this.$allowDecimal, this.$pristine$delegate, this.$raw$delegate, p0);
    }
}
