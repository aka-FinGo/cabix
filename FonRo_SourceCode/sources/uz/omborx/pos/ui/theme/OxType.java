package uz.FonRo.pos.ui.theme;

import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Type.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR\u0011\u0010\u0016\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\tR\u0011\u0010\u0018\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u0011\u0010\u001a\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\tR\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\tR\u0011\u0010\u001e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR\u0011\u0010 \u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\tR\u0011\u0010\"\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\tR\u0011\u0010$\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\tR\u0011\u0010&\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\tR\u0011\u0010(\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\tR\u0011\u0010*\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\tR\u0011\u0010,\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\tR\u0011\u0010.\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\tR\u0011\u00100\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\tR\u0011\u00102\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\tR\u0011\u00104\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\tÊ\u0001\f\b7\u0012\b\b8\u0012\u0004\b\u0003\u0010\u0002¨\u00066"}, d2 = {"Luz/FonRo/pos/ui/theme/OxType;", "", "<init>", "()V", "F", "Landroidx/compose/ui/text/font/SystemFontFamily;", "Body", "Landroidx/compose/ui/text/TextStyle;", "getBody", "()Landroidx/compose/ui/text/TextStyle;", "BodyDim", "getBodyDim", "H1", "getH1", "H2", "getH2", "H3", "getH3", "SheetTitle", "getSheetTitle", "RowTitle", "getRowTitle", "RowSub", "getRowSub", "RowPrice", "getRowPrice", TextFieldImplKt.LabelId, "getLabel", "Caption", "getCaption", "Chip", "getChip", "Button", "getButton", "ButtonLg", "getButtonLg", "ButtonSm", "getButtonSm", "Amount", "getAmount", "AmountXl", "getAmountXl", "StatValue", "getStatValue", "TileValue", "getTileValue", "TileLabel", "getTileLabel", "Numpad", "getNumpad", "NumpadValue", "getNumpadValue", "TabLabel", "getTabLabel", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class OxType {
    public static final int $stable = 0;
    private static final TextStyle Amount;
    private static final TextStyle AmountXl;
    private static final TextStyle Body;
    private static final TextStyle Button;
    private static final TextStyle ButtonLg;
    private static final TextStyle ButtonSm;
    private static final TextStyle Chip;
    private static final SystemFontFamily F;
    private static final TextStyle H1;
    private static final TextStyle H2;
    private static final TextStyle H3;
    public static final OxType INSTANCE = new OxType();
    private static final TextStyle Numpad;
    private static final TextStyle NumpadValue;
    private static final TextStyle RowPrice;
    private static final TextStyle RowTitle;
    private static final TextStyle SheetTitle;
    private static final TextStyle StatValue;
    private static final TextStyle TabLabel;
    private static final TextStyle TileLabel;
    private static final TextStyle TileValue;

    private OxType() {
    }

    static {
        SystemFontFamily systemFontFamily = FontFamily.INSTANCE.getDefault();
        F = systemFontFamily;
        Body = new TextStyle(0L, TextUnitKt.getSp(14.5d), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(21), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646109, (DefaultConstructorMarker) null);
        H1 = new TextStyle(0L, TextUnitKt.getSp(26), FontWeight.INSTANCE.getExtraBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, TextUnitKt.getSp(-0.9d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(31), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null);
        H2 = new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.INSTANCE.getExtraBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, TextUnitKt.getSp(-0.3d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777049, (DefaultConstructorMarker) null);
        H3 = new TextStyle(0L, TextUnitKt.getSp(15.5d), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
        SheetTitle = new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
        RowTitle = new TextStyle(0L, TextUnitKt.getSp(14.5d), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
        RowPrice = new TextStyle(0L, TextUnitKt.getSp(14.5d), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
        Chip = new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
        Button = new TextStyle(0L, TextUnitKt.getSp(14.5d), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
        ButtonLg = new TextStyle(0L, TextUnitKt.getSp(15.5d), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
        ButtonSm = new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
        Amount = new TextStyle(0L, TextUnitKt.getSp(25), FontWeight.INSTANCE.getExtraBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
        AmountXl = new TextStyle(0L, TextUnitKt.getSp(32), FontWeight.INSTANCE.getExtraBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
        StatValue = new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.INSTANCE.getExtraBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
        TileValue = new TextStyle(0L, TextUnitKt.getSp(14.5d), FontWeight.INSTANCE.getExtraBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
        TileLabel = new TextStyle(0L, TextUnitKt.getSp(11.5d), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
        Numpad = new TextStyle(0L, TextUnitKt.getSp(22), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
        NumpadValue = new TextStyle(0L, TextUnitKt.getSp(28), FontWeight.INSTANCE.getExtraBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
        TabLabel = new TextStyle(0L, TextUnitKt.getSp(10.5d), FontWeight.INSTANCE.getExtraBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    }

    public final TextStyle getBody() {
        return Body;
    }

    public final TextStyle getBodyDim() {
        return TextStyle.m6448copyp1EtxEg$default(Body, Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
    }

    public final TextStyle getH1() {
        return H1;
    }

    public final TextStyle getH2() {
        return H2;
    }

    public final TextStyle getH3() {
        return H3;
    }

    public final TextStyle getSheetTitle() {
        return SheetTitle;
    }

    public final TextStyle getRowTitle() {
        return RowTitle;
    }

    public final TextStyle getRowSub() {
        SystemFontFamily systemFontFamily = F;
        return new TextStyle(Ox.INSTANCE.m10200getDim20d7_KjU(), TextUnitKt.getSp(12.5d), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(17), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646108, (DefaultConstructorMarker) null);
    }

    public final TextStyle getRowPrice() {
        return RowPrice;
    }

    public final TextStyle getLabel() {
        SystemFontFamily systemFontFamily = F;
        return new TextStyle(Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(13), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777176, (DefaultConstructorMarker) null);
    }

    public final TextStyle getCaption() {
        SystemFontFamily systemFontFamily = F;
        return new TextStyle(Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777180, (DefaultConstructorMarker) null);
    }

    public final TextStyle getChip() {
        return Chip;
    }

    public final TextStyle getButton() {
        return Button;
    }

    public final TextStyle getButtonLg() {
        return ButtonLg;
    }

    public final TextStyle getButtonSm() {
        return ButtonSm;
    }

    public final TextStyle getAmount() {
        return Amount;
    }

    public final TextStyle getAmountXl() {
        return AmountXl;
    }

    public final TextStyle getStatValue() {
        return StatValue;
    }

    public final TextStyle getTileValue() {
        return TileValue;
    }

    public final TextStyle getTileLabel() {
        return TileLabel;
    }

    public final TextStyle getNumpad() {
        return Numpad;
    }

    public final TextStyle getNumpadValue() {
        return NumpadValue;
    }

    public final TextStyle getTabLabel() {
        return TabLabel;
    }
}
