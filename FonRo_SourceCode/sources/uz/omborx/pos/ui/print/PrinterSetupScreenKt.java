package uz.FonRo.pos.ui.print;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.disk.DiskLruCache;
import j$.time.LocalDateTime;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.prefs.AppPrefs;
import uz.FonRo.pos.print.BluetoothPrinter;
import uz.FonRo.pos.print.ReceiptDoc;
import uz.FonRo.pos.print.ReceiptLine;
import uz.FonRo.pos.print.ReceiptPay;
import uz.FonRo.pos.print.ReceiptTotal;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.ChipsKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: PrinterSetupScreen.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0002²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0010X\u008a\u008e\u0002"}, d2 = {"PrinterSetupScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "sampleReceipt", "Luz/FonRo/pos/print/ReceiptDoc;", "width", "", "autoPrint", "", "mac", "", "printerName", "granted", "devices", "", "Luz/FonRo/pos/print/BluetoothPrinter$Device;", "busy"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class PrinterSetupScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PrinterSetupScreen$lambda$27(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        PrinterSetupScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x05b0, code lost:
    
        if (r12.changedInstance(r10) != false) goto L118;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x067d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x071e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x06d6  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x057b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0627  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void PrinterSetupScreen(uz.FonRo.pos.FonRoApp r40, final uz.FonRo.pos.ui.nav.AppNavigator r41, androidx.compose.runtime.Composer r42, final int r43) {
        /*
            Method dump skipped, instructions count: 1849
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.print.PrinterSetupScreenKt.PrinterSetupScreen(uz.FonRo.pos.FonRoApp, uz.FonRo.pos.ui.nav.AppNavigator, androidx.compose.runtime.Composer, int):void");
    }

    private static final int PrinterSetupScreen$lambda$2(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void PrinterSetupScreen$lambda$3(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final boolean PrinterSetupScreen$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PrinterSetupScreen$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String PrinterSetupScreen$lambda$8(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String PrinterSetupScreen$lambda$11(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PrinterSetupScreen$lambda$14(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PrinterSetupScreen$lambda$15(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final List<BluetoothPrinter.Device> PrinterSetupScreen$lambda$17(MutableState<List<BluetoothPrinter.Device>> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean PrinterSetupScreen$lambda$20(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PrinterSetupScreen$lambda$21(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrinterSetupScreen$lambda$22$0(MutableState mutableState, boolean z) {
        PrinterSetupScreen$lambda$15(mutableState, z);
        if (!z) {
            Toaster.INSTANCE.error(LangKt.tx("Без доступа к Bluetooth список принтеров не открыть", new Object[0]));
        }
        return Unit.INSTANCE;
    }

    private static final void PrinterSetupScreen$openBluetoothSettings(Context context) {
        Object m7870constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            context.startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS").addFlags(268435456));
            m7870constructorimpl = Result.m7870constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7873exceptionOrNullimpl(m7870constructorimpl) != null) {
            Toaster.INSTANCE.error(LangKt.tx("Не удалось открыть настройки Bluetooth", new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrinterSetupScreen$lambda$26$0(final AppPrefs appPrefs, final MutableState mutableState, ColumnScope OxCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCard, "$this$OxCard");
        ComposerKt.sourceInformation(composer, "C113@4488L43,114@4544L10,115@4567L90,116@4670L11,120@4876L163,117@4694L359:PrinterSetupScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1229986444, i, -1, "uz.FonRo.pos.ui.print.PrinterSetupScreen.<anonymous>.<anonymous> (PrinterSetupScreen.kt:113)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Ширина ленты", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH3(), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(3.0f), composer, 6);
            TextKt.m2798Text4IGK_g(LangKt.tx("По ней считается, сколько знаков влезает в строку чека", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(11.0f), composer, 6);
            List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("58", LangKt.tx("58 мм", new Object[0])), TuplesKt.to("72", LangKt.tx("72 мм", new Object[0])), TuplesKt.to("80", LangKt.tx("80 мм", new Object[0]))});
            String valueOf = String.valueOf(PrinterSetupScreen$lambda$2(mutableState));
            ComposerKt.sourceInformationMarkerStart(composer, -900953257, "CC(remember):PrinterSetupScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(appPrefs);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.print.PrinterSetupScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PrinterSetupScreen$lambda$26$0$0$0;
                        PrinterSetupScreen$lambda$26$0$0$0 = PrinterSetupScreenKt.PrinterSetupScreen$lambda$26$0$0$0(AppPrefs.this, mutableState, (String) obj);
                        return PrinterSetupScreen$lambda$26$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.OxSegControl(listOf, valueOf, (Function1) rememberedValue, null, false, composer, 0, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrinterSetupScreen$lambda$26$0$0$0(AppPrefs appPrefs, MutableState mutableState, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Integer intOrNull = StringsKt.toIntOrNull(key);
        int intValue = intOrNull != null ? intOrNull.intValue() : 72;
        PrinterSetupScreen$lambda$3(mutableState, intValue);
        appPrefs.setReceiptWidth(intValue);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrinterSetupScreen$lambda$26$1(final AppPrefs appPrefs, final MutableState mutableState, ColumnScope OxList, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer, "C136@5381L110,140@5520L291,132@5147L678:PrinterSetupScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1541091798, i, -1, "uz.FonRo.pos.ui.print.PrinterSetupScreen.<anonymous>.<anonymous> (PrinterSetupScreen.kt:132)");
            }
            String tx = LangKt.tx("Печатать чек сразу после продажи", new Object[0]);
            String tx2 = LangKt.tx("Без лишнего тапа: чек уходит на принтер, как только продажа проведена", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, 774507288, "CC(remember):PrinterSetupScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(appPrefs);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.print.PrinterSetupScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PrinterSetupScreen$lambda$26$1$0$0;
                        PrinterSetupScreen$lambda$26$1$0$0 = PrinterSetupScreenKt.PrinterSetupScreen$lambda$26$1$0$0(AppPrefs.this, mutableState);
                        return PrinterSetupScreen$lambda$26$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9832OxRow1YH7lEI(tx, null, tx2, (Function0) rememberedValue, false, 0L, null, ComposableLambdaKt.rememberComposableLambda(-432108269, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrinterSetupScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PrinterSetupScreen$lambda$26$1$1;
                    PrinterSetupScreen$lambda$26$1$1 = PrinterSetupScreenKt.PrinterSetupScreen$lambda$26$1$1(AppPrefs.this, mutableState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PrinterSetupScreen$lambda$26$1$1;
                }
            }, composer, 54), composer, 12607488, 98);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrinterSetupScreen$lambda$26$1$0$0(AppPrefs appPrefs, MutableState mutableState) {
        PrinterSetupScreen$lambda$6(mutableState, !PrinterSetupScreen$lambda$5(mutableState));
        appPrefs.setAutoPrint(PrinterSetupScreen$lambda$5(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrinterSetupScreen$lambda$26$1$1(final AppPrefs appPrefs, final MutableState mutableState, RowScope OxRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxRow, "$this$OxRow");
        ComposerKt.sourceInformation(composer, "C143@5637L134,141@5542L251:PrinterSetupScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-432108269, i, -1, "uz.FonRo.pos.ui.print.PrinterSetupScreen.<anonymous>.<anonymous>.<anonymous> (PrinterSetupScreen.kt:141)");
            }
            boolean PrinterSetupScreen$lambda$5 = PrinterSetupScreen$lambda$5(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 1355785081, "CC(remember):PrinterSetupScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(appPrefs);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.print.PrinterSetupScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PrinterSetupScreen$lambda$26$1$1$0$0;
                        PrinterSetupScreen$lambda$26$1$1$0$0 = PrinterSetupScreenKt.PrinterSetupScreen$lambda$26$1$1$0$0(AppPrefs.this, mutableState, ((Boolean) obj).booleanValue());
                        return PrinterSetupScreen$lambda$26$1$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchKt.Switch(PrinterSetupScreen$lambda$5, (Function1) rememberedValue, null, null, false, null, null, composer, 0, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrinterSetupScreen$lambda$26$1$1$0$0(AppPrefs appPrefs, MutableState mutableState, boolean z) {
        PrinterSetupScreen$lambda$6(mutableState, z);
        appPrefs.setAutoPrint(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrinterSetupScreen$lambda$26$3(final ManagedActivityResultLauncher managedActivityResultLauncher, final MutableState mutableState, ColumnScope OxCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCard, "$this$OxCard");
        ComposerKt.sourceInformation(composer, "C167@6348L182,171@6547L11,174@6666L370,172@6575L559:PrinterSetupScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-210767053, i, -1, "uz.FonRo.pos.ui.print.PrinterSetupScreen.<anonymous>.<anonymous> (PrinterSetupScreen.kt:167)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Чтобы увидеть список принтеров, нужен доступ к устройствам поблизости.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(11.0f), composer, 6);
            String tx = LangKt.tx("Разрешить доступ", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -683663899, "CC(remember):PrinterSetupScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(managedActivityResultLauncher);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.print.PrinterSetupScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PrinterSetupScreen$lambda$26$3$0$0;
                        PrinterSetupScreen$lambda$26$3$0$0 = PrinterSetupScreenKt.PrinterSetupScreen$lambda$26$3$0$0(ManagedActivityResultLauncher.this, mutableState);
                        return PrinterSetupScreen$lambda$26$3$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, null, BtnStyle.PRIMARY, null, false, true, null, composer, 1575936, 180);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrinterSetupScreen$lambda$26$3$0$0(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState) {
        if (Build.VERSION.SDK_INT >= 31) {
            managedActivityResultLauncher.launch("android.permission.BLUETOOTH_CONNECT");
        } else {
            PrinterSetupScreen$lambda$15(mutableState, true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrinterSetupScreen$lambda$26$4(MutableState mutableState, final AppPrefs appPrefs, final MutableState mutableState2, final MutableState mutableState3, ColumnScope OxList, Composer composer, int i) {
        String str;
        boolean z;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer2, "C*199@7764L323,206@8123L341,214@8501L408,194@7496L1435:PrinterSetupScreen.kt#fixedd");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(403944393, i, -1, "uz.FonRo.pos.ui.print.PrinterSetupScreen.<anonymous>.<anonymous> (PrinterSetupScreen.kt:192)");
            }
            int i2 = 0;
            for (Object obj : PrinterSetupScreen$lambda$17(mutableState)) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final BluetoothPrinter.Device device = (BluetoothPrinter.Device) obj;
                final boolean areEqual = Intrinsics.areEqual(device.getMac(), PrinterSetupScreen$lambda$8(mutableState2));
                String name = device.getName();
                String mac = device.getMac();
                if (i2 < CollectionsKt.getLastIndex(PrinterSetupScreen$lambda$17(mutableState))) {
                    str = mac;
                    z = true;
                } else {
                    str = mac;
                    z = false;
                }
                Ox ox = Ox.INSTANCE;
                long m10220getPrimary0d7_KjU = areEqual ? ox.m10220getPrimary0d7_KjU() : ox.m10233getText0d7_KjU();
                ComposerKt.sourceInformationMarkerStart(composer2, 969429291, "CC(remember):PrinterSetupScreen.kt#9igjgp");
                boolean changedInstance = composer2.changedInstance(device) | composer2.changedInstance(appPrefs);
                Object rememberedValue = composer2.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.print.PrinterSetupScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit PrinterSetupScreen$lambda$26$4$0$0$0;
                            PrinterSetupScreen$lambda$26$4$0$0$0 = PrinterSetupScreenKt.PrinterSetupScreen$lambda$26$4$0$0$0(BluetoothPrinter.Device.this, appPrefs, mutableState2, mutableState3);
                            return PrinterSetupScreen$lambda$26$4$0$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BasicsKt.m9832OxRow1YH7lEI(name, null, str, (Function0) rememberedValue, z, m10220getPrimary0d7_KjU, ComposableLambdaKt.rememberComposableLambda(1736765416, true, new Function2() { // from class: uz.FonRo.pos.ui.print.PrinterSetupScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit PrinterSetupScreen$lambda$26$4$0$1;
                        PrinterSetupScreen$lambda$26$4$0$1 = PrinterSetupScreenKt.PrinterSetupScreen$lambda$26$4$0$1(areEqual, (Composer) obj2, ((Integer) obj3).intValue());
                        return PrinterSetupScreen$lambda$26$4$0$1;
                    }
                }, composer2, 54), ComposableLambdaKt.rememberComposableLambda(-1583536239, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrinterSetupScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit PrinterSetupScreen$lambda$26$4$0$2;
                        PrinterSetupScreen$lambda$26$4$0$2 = PrinterSetupScreenKt.PrinterSetupScreen$lambda$26$4$0$2(areEqual, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        return PrinterSetupScreen$lambda$26$4$0$2;
                    }
                }, composer2, 54), composer2, 14155776, 2);
                composer2 = composer;
                i2 = i3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrinterSetupScreen$lambda$26$4$0$0$0(BluetoothPrinter.Device device, AppPrefs appPrefs, MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(device.getMac());
        mutableState2.setValue(device.getName());
        appPrefs.setPrinterMac(device.getMac());
        appPrefs.setPrinterName(device.getName());
        Toaster.INSTANCE.ok(LangKt.tx("Принтер «%s» выбран", device.getName()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrinterSetupScreen$lambda$26$4$0$1(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C207@8153L285:PrinterSetupScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1736765416, i, -1, "uz.FonRo.pos.ui.print.PrinterSetupScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrinterSetupScreen.kt:207)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getBluetooth(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), z ? Ox.INSTANCE.m10220getPrimary0d7_KjU() : Ox.INSTANCE.m10200getDim20d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrinterSetupScreen$lambda$26$4$0$2(boolean z, RowScope OxRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxRow, "$this$OxRow");
        ComposerKt.sourceInformation(composer, "C:PrinterSetupScreen.kt#fixedd");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1583536239, i, -1, "uz.FonRo.pos.ui.print.PrinterSetupScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrinterSetupScreen.kt:215)");
            }
            if (z) {
                composer.startReplaceGroup(792767165);
                ComposerKt.sourceInformation(composer, "216@8577L276");
                IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getOk(), LangKt.tx("Выбран", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), Ox.INSTANCE.m10211getOk0d7_KjU(), composer, 384, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(793062161);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrinterSetupScreen$lambda$26$5$0$0(CoroutineScope coroutineScope, MutableState mutableState, Context context, FonRoApp FonRoApp) {
        if (!PrinterSetupScreen$lambda$20(mutableState)) {
            PrinterSetupScreen$lambda$21(mutableState, true);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PrinterSetupScreenKt$PrinterSetupScreen$2$6$1$1$1(context, FonRoApp, mutableState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrinterSetupScreen$lambda$26$5$1$0(Context context) {
        PrinterSetupScreen$openBluetoothSettings(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrinterSetupScreen$lambda$26$6$0(AppPrefs appPrefs, MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue("");
        mutableState2.setValue("");
        appPrefs.setPrinterMac("");
        appPrefs.setPrinterName("");
        Toaster.INSTANCE.ok(LangKt.tx("Принтер отключён. Чеки пойдут в системную печать.", new Object[0]));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReceiptDoc sampleReceipt(FonRoApp FonRoApp) {
        String currency = FonRoApp.getRepo().currency();
        String dt$default = Fmt.dt$default(Fmt.INSTANCE, LocalDateTime.now(Fmt.INSTANCE.getSTORE_ZONE()).toString(), false, 2, null);
        List listOf = CollectionsKt.listOf((Object[]) new ReceiptLine[]{new ReceiptLine("Пробная позиция с нарочно длинным названием", "2", 12000.0d, 24000.0d), new ReceiptLine("Вода питьевая 1,5 л", DiskLruCache.VERSION, 8000.0d, 8000.0d)});
        Fmt fmt = Fmt.INSTANCE;
        Double valueOf = Double.valueOf(32000.0d);
        return new ReceiptDoc("TEST-0001", dt$default, "Наличные", "Оплачено", true, null, "2", listOf, CollectionsKt.listOf((Object[]) new ReceiptTotal[]{new ReceiptTotal("Подытог", fmt.nf(valueOf), false, false, 12, null), new ReceiptTotal("ИТОГО", Fmt.INSTANCE.money(valueOf, currency), true, false, 8, null)}), CollectionsKt.listOf((Object[]) new ReceiptPay[]{new ReceiptPay("Получено", Fmt.INSTANCE.nf(Double.valueOf(50000.0d))), new ReceiptPay("Сдача", Fmt.INSTANCE.nf(Double.valueOf(18000.0d)))}), "TEST-0001", "Пробная печать FonRo", 32, null);
    }
}
