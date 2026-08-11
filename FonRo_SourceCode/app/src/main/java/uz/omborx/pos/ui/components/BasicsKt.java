package uz.FonRo.pos.ui.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxShape;

/* compiled from: Basics.kt */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u0010H\u0007b\u0002\b\u0010b\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¢\u0006\u0002\u0010\u0011\u001ay\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u001fH\u0007b\u0002\b\u0010b\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¢\u0006\u0004\b \u0010!\u001a\u0083\u0001\u0010\"\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u001fH\u0007b\u0002\b\u0010b\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¢\u0006\u0004\b$\u0010%\u001aG\u0010&\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u001fH\u0007b\u0002\b\u0010b\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¢\u0006\u0002\u0010'\u001a\u009e\u0001\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010+\u001a\u00020\r2\b\b\u0002\u0010,\u001a\u00020\u00192\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00102 \b\u0002\u0010-\u001a\u001a\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001d¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u001fH\u0007b\u0002\b\u0010b\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(1¢\u0006\u0004\b/\u00100\u001a5\u00102\u001a\u00020\u00012\b\b\u0002\u00103\u001a\u00020\u00192\b\b\u0002\u00104\u001a\u00020\u0017H\u0007b\u0002\b\u0010b\f\b7\u0012\b\b8\u0012\u0004\b\b(9¢\u0006\u0004\b5\u00106\u001a]\u0010:\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u001fH\u0007b\u0002\b\u0010b\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¢\u0006\u0004\b<\u0010=\u001a;\u0010>\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007b\u0002\b\u0010b\f\b7\u0012\b\b8\u0012\u0004\b\b(9¢\u0006\u0002\u0010A\u001a1\u0010B\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007b\u0002\b\u0010b\f\b7\u0012\b\b8\u0012\u0004\b\b(9¢\u0006\u0002\u0010C\u001aj\u0010D\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010F\u001a\u00020@2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u0010H\u0007b\u0002\b\u0010b\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¢\u0006\u0002\u0010G\u001ab\u0010H\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00172\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0010H\u0007b\u0002\b\u0010b\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¢\u0006\u0004\bJ\u0010K\u001a)\u0010L\u001a\u00020\u00012\u0006\u0010M\u001a\u00020\u0017H\u0007b\u0002\b\u0010b\f\b7\u0012\b\b8\u0012\u0004\b\b(9¢\u0006\u0004\bN\u0010O\u001a)\u0010P\u001a\u00020\u00012\u0006\u0010Q\u001a\u00020\u0017H\u0007b\u0002\b\u0010b\f\b7\u0012\b\b8\u0012\u0004\b\b(9¢\u0006\u0004\bR\u0010O¨\u0006S²\u0006\n\u0010T\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"OxButton", "", "text", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Luz/FonRo/pos/ui/components/BtnStyle;", "size", "Luz/FonRo/pos/ui/components/BtnSize;", "enabled", "", "block", "leading", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Luz/FonRo/pos/ui/components/BtnStyle;Luz/FonRo/pos/ui/components/BtnSize;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/runtime/ComposableInferredTarget;", "scheme", "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]", "OxCard", "padding", "Landroidx/compose/ui/unit/Dp;", "background", "Landroidx/compose/ui/graphics/Color;", "shape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "OxCard-EOp_iR4", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/foundation/shape/RoundedCornerShape;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OxSoftCard", "borderColor", "OxSoftCard-Ce4qNIY", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/foundation/shape/RoundedCornerShape;JJLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OxList", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OxRow", "title", "subtitle", "divider", "titleColor", "trailing", "Landroidx/compose/foundation/layout/RowScope;", "OxRow-1YH7lEI", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function0;ZJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]", "OxDivider", TypedValues.Custom.S_COLOR, "startPadding", "OxDivider-iPRSM58", "(JFLandroidx/compose/runtime/Composer;II)V", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "OxThumb", "Landroidx/compose/foundation/layout/BoxScope;", "OxThumb-PZ-HvWI", "(Landroidx/compose/ui/Modifier;FJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OxChip", "tone", "Luz/FonRo/pos/ui/components/ChipTone;", "(Ljava/lang/String;Luz/FonRo/pos/ui/components/ChipTone;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "OxEmptyNote", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "OxSectionHead", "count", "countTone", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Luz/FonRo/pos/ui/components/ChipTone;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OxIconButton", "badge", "OxIconButton-hGBTI10", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Ljava/lang/String;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "VGap", "height", "VGap-8Feqmps", "(FLandroidx/compose/runtime/Composer;I)V", "HGap", "width", "HGap-8Feqmps", "app", "pressed"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class BasicsKt {

    /* compiled from: Basics.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[BtnStyle.values().length];
            try {
                iArr[BtnStyle.PLAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BtnStyle.PRIMARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BtnStyle.GHOST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BtnStyle.DANGER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BtnStyle.OK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BtnStyle.CYAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BtnSize.values().length];
            try {
                iArr2[BtnSize.SM.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[BtnSize.MD.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[BtnSize.LG.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ChipTone.values().length];
            try {
                iArr3[ChipTone.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[ChipTone.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[ChipTone.BAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[ChipTone.DIM.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[ChipTone.BLUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit HGap_8Feqmps$lambda$0(float f, int i, Composer composer, int i2) {
        m9828HGap8Feqmps(f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxButton$lambda$3(String str, Function0 function0, Modifier modifier, BtnStyle btnStyle, BtnSize btnSize, boolean z, boolean z2, Function2 function2, int i, int i2, Composer composer, int i3) {
        OxButton(str, function0, modifier, btnStyle, btnSize, z, z2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxCard_EOp_iR4$lambda$0(Modifier modifier, float f, long j, RoundedCornerShape roundedCornerShape, Function0 function0, Function3 function3, int i, int i2, Composer composer, int i3) {
        m9829OxCardEOp_iR4(modifier, f, j, roundedCornerShape, function0, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxChip$lambda$0(String str, ChipTone chipTone, Modifier modifier, int i, int i2, Composer composer, int i3) {
        OxChip(str, chipTone, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxDivider_iPRSM58$lambda$0(long j, float f, int i, int i2, Composer composer, int i3) {
        m9830OxDivideriPRSM58(j, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxEmptyNote$lambda$1(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        OxEmptyNote(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxIconButton_hGBTI10$lambda$1(Function0 function0, Modifier modifier, String str, float f, Function2 function2, int i, int i2, Composer composer, int i3) {
        m9831OxIconButtonhGBTI10(function0, modifier, str, f, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxList$lambda$0(Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        OxList(modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxRow_1YH7lEI$lambda$1(String str, Modifier modifier, String str2, Function0 function0, boolean z, long j, Function2 function2, Function3 function3, int i, int i2, Composer composer, int i3) {
        m9832OxRow1YH7lEI(str, modifier, str2, function0, z, j, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxSectionHead$lambda$1(String str, Modifier modifier, String str2, String str3, ChipTone chipTone, Function2 function2, int i, int i2, Composer composer, int i3) {
        OxSectionHead(str, modifier, str2, str3, chipTone, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxSoftCard_Ce4qNIY$lambda$0(Modifier modifier, float f, RoundedCornerShape roundedCornerShape, long j, long j2, Function0 function0, Function3 function3, int i, int i2, Composer composer, int i3) {
        m9833OxSoftCardCe4qNIY(modifier, f, roundedCornerShape, j, j2, function0, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxThumb_PZ_HvWI$lambda$0(Modifier modifier, float f, long j, Function3 function3, int i, int i2, Composer composer, int i3) {
        m9834OxThumbPZHvWI(modifier, f, j, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit VGap_8Feqmps$lambda$0(float f, int i, Composer composer, int i2) {
        m9835VGap8Feqmps(f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OxButton(final java.lang.String r29, final kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.ui.Modifier r31, uz.FonRo.pos.ui.components.BtnStyle r32, uz.FonRo.pos.ui.components.BtnSize r33, boolean r34, boolean r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 1234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.BasicsKt.OxButton(java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, uz.FonRo.pos.ui.components.BtnStyle, uz.FonRo.pos.ui.components.BtnSize, boolean, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxButton$lambda$2$0(Function2 function2, TextStyle textStyle, long j, String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C109@4354L225:Basics.kt#r5y9fm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2122154313, i, -1, "uz.FonRo.pos.ui.components.OxButton.<anonymous>.<anonymous> (Basics.kt:108)");
            }
            if (function2 == null) {
                composer.startReplaceGroup(819481602);
            } else {
                composer.startReplaceGroup(719171551);
                ComposerKt.sourceInformation(composer, "108@4333L8");
                function2.invoke(composer, 0);
            }
            composer.endReplaceGroup();
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6866boximpl(TextAlign.INSTANCE.m6873getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(textStyle, j, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3120, 54782);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x008e  */
    /* renamed from: OxCard-EOp_iR4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m9829OxCardEOp_iR4(androidx.compose.ui.Modifier r24, float r25, long r26, androidx.compose.foundation.shape.RoundedCornerShape r28, kotlin.jvm.functions.Function0<kotlin.Unit> r29, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 615
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.BasicsKt.m9829OxCardEOp_iR4(androidx.compose.ui.Modifier, float, long, androidx.compose.foundation.shape.RoundedCornerShape, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* renamed from: OxSoftCard-Ce4qNIY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m9833OxSoftCardCe4qNIY(androidx.compose.ui.Modifier r21, float r22, androidx.compose.foundation.shape.RoundedCornerShape r23, long r24, long r26, kotlin.jvm.functions.Function0<kotlin.Unit> r28, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.BasicsKt.m9833OxSoftCardCe4qNIY(androidx.compose.ui.Modifier, float, androidx.compose.foundation.shape.RoundedCornerShape, long, long, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void OxList(Modifier modifier, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-299360709);
        ComposerKt.sourceInformation(startRestartGroup, "C(OxList)P(1)171@6124L213:Basics.kt#r5y9fm");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
            companion = modifier2;
        } else {
            companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-299360709, i3, -1, "uz.FonRo.pos.ui.components.OxList (Basics.kt:170)");
            }
            Modifier m569borderxT4_qwU = BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), OxShape.INSTANCE.getCard()), Ox.INSTANCE.m10217getPanel0d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getCard());
            int i5 = (i3 << 6) & 7168;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m569borderxT4_qwU);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            content.invoke(ColumnScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i5 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.components.BasicsKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicsKt.OxList$lambda$0(Modifier.this, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0572  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0517  */
    /* renamed from: OxRow-1YH7lEI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m9832OxRow1YH7lEI(final java.lang.String r65, androidx.compose.ui.Modifier r66, java.lang.String r67, kotlin.jvm.functions.Function0<kotlin.Unit> r68, boolean r69, long r70, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r72, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r73, androidx.compose.runtime.Composer r74, final int r75, final int r76) {
        /*
            Method dump skipped, instructions count: 1474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.BasicsKt.m9832OxRow1YH7lEI(java.lang.String, androidx.compose.ui.Modifier, java.lang.String, kotlin.jvm.functions.Function0, boolean, long, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x004f  */
    /* renamed from: OxDivider-iPRSM58, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m9830OxDivideriPRSM58(long r22, float r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.BasicsKt.m9830OxDivideriPRSM58(long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x014b  */
    /* renamed from: OxThumb-PZ-HvWI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m9834OxThumbPZHvWI(androidx.compose.ui.Modifier r19, float r20, long r21, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instructions count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.BasicsKt.m9834OxThumbPZHvWI(androidx.compose.ui.Modifier, float, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OxChip(final java.lang.String r58, uz.FonRo.pos.ui.components.ChipTone r59, androidx.compose.ui.Modifier r60, androidx.compose.runtime.Composer r61, final int r62, final int r63) {
        /*
            Method dump skipped, instructions count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.BasicsKt.OxChip(java.lang.String, uz.FonRo.pos.ui.components.ChipTone, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OxEmptyNote(final java.lang.String r37, androidx.compose.ui.Modifier r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.BasicsKt.OxEmptyNote(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x05c8  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OxSectionHead(final java.lang.String r71, androidx.compose.ui.Modifier r72, java.lang.String r73, java.lang.String r74, uz.FonRo.pos.ui.components.ChipTone r75, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, androidx.compose.runtime.Composer r77, final int r78, final int r79) {
        /*
            Method dump skipped, instructions count: 1495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.BasicsKt.OxSectionHead(java.lang.String, androidx.compose.ui.Modifier, java.lang.String, java.lang.String, uz.FonRo.pos.ui.components.ChipTone, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x014c  */
    /* renamed from: OxIconButton-hGBTI10, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m9831OxIconButtonhGBTI10(final kotlin.jvm.functions.Function0<kotlin.Unit> r68, androidx.compose.ui.Modifier r69, java.lang.String r70, float r71, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r72, androidx.compose.runtime.Composer r73, final int r74, final int r75) {
        /*
            Method dump skipped, instructions count: 1235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.BasicsKt.m9831OxIconButtonhGBTI10(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, java.lang.String, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxIconButton_hGBTI10$lambda$0$0$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C382@12833L9:Basics.kt#r5y9fm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1291442440, i, -1, "uz.FonRo.pos.ui.components.OxIconButton.<anonymous>.<anonymous>.<anonymous> (Basics.kt:382)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* renamed from: VGap-8Feqmps, reason: not valid java name */
    public static final void m9835VGap8Feqmps(final float f, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-730192457);
        ComposerKt.sourceInformation(startRestartGroup, "C(VGap)P(0:c#ui.unit.Dp)403@13546L31:Basics.kt#r5y9fm");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-730192457, i2, -1, "uz.FonRo.pos.ui.components.VGap (Basics.kt:403)");
            }
            SpacerKt.Spacer(SizeKt.m1082height3ABfNKs(Modifier.INSTANCE, f), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.components.BasicsKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicsKt.VGap_8Feqmps$lambda$0(f, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* renamed from: HGap-8Feqmps, reason: not valid java name */
    public static final void m9828HGap8Feqmps(final float f, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-360123607);
        ComposerKt.sourceInformation(startRestartGroup, "C(HGap)P(0:c#ui.unit.Dp)406@13613L29:Basics.kt#r5y9fm");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-360123607, i2, -1, "uz.FonRo.pos.ui.components.HGap (Basics.kt:406)");
            }
            SpacerKt.Spacer(SizeKt.m1101width3ABfNKs(Modifier.INSTANCE, f), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.components.BasicsKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicsKt.HGap_8Feqmps$lambda$0(f, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean OxButton$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
