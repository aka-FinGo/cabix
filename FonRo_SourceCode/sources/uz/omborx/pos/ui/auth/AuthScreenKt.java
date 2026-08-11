package uz.FonRo.pos.ui.auth;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.R;
import uz.FonRo.pos.core.Lang;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.OxLanguage;
import uz.FonRo.pos.data.repo.AuthRepository;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.FieldsKt;
import uz.FonRo.pos.ui.components.ModifiersKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: AuthScreen.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0004\u001a/\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0003b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\r\u001a/\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0012\u001a;\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0017H\u0003b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0018\u001a5\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u001bH\u0003b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u001c\u001a\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002¨\u0006\u0002²\u0006\n\u0010\u001f\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010$\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010'\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010(\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010)\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010+\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010,\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010-\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u00100\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u00101\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020\u0011X\u008a\u008e\u0002"}, d2 = {"AuthScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "(Luz/FonRo/pos/FonRoApp;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "Brand", "title", "", "subtitle", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "Banner", "text", "isError", "", "(Ljava/lang/String;ZLandroidx/compose/runtime/Composer;I)V", "LoginTabs", "mode", "Luz/FonRo/pos/ui/auth/LoginMode;", "onChange", "Lkotlin/Function1;", "(Luz/FonRo/pos/ui/auth/LoginMode;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LinkButton", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "formatAccessKey", "input", "view", "Luz/FonRo/pos/ui/auth/AuthView;", "busy", "error", FirebaseAnalytics.Param.SUCCESS, "email", HintConstants.AUTOFILL_HINT_PASSWORD, "accessKey", "regName", "regStore", "regPhone", "regEmail", "regPassword", "otpCode", "otpMode", "otpEmail", "otpVerifiedCode", "resetEmail", "newPass1", "newPass2", "langSheet"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class AuthScreenKt {

    /* compiled from: AuthScreen.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AuthView.values().length];
            try {
                iArr[AuthView.REGISTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AuthView.OTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AuthView.RESET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AuthView.NEWPASS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AuthView.LOGIN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AuthScreen$lambda$67(FonRoApp FonRoApp, int i, Composer composer, int i2) {
        AuthScreen(FonRoApp, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Banner$lambda$0(String str, boolean z, int i, Composer composer, int i2) {
        Banner(str, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Brand$lambda$1(String str, String str2, int i, Composer composer, int i2) {
        Brand(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LinkButton$lambda$0(String str, Function0 function0, int i, Composer composer, int i2) {
        LinkButton(str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LoginTabs$lambda$1(LoginMode loginMode, Function1 function1, int i, Composer composer, int i2) {
        LoginTabs(loginMode, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AuthScreen(FonRoApp app, Composer composer, final int i) {
        int i2;
        final FonRoApp FonRoApp;
        String tx;
        int i3;
        String tx2;
        int i4;
        String str;
        int i5;
        String str2;
        String str3;
        String str4;
        String str5;
        final MutableState mutableState;
        final MutableState mutableState2;
        final MutableState mutableState3;
        final MutableState mutableState4;
        Composer composer2;
        final MutableState mutableState5;
        final MutableState mutableState6;
        int i6;
        final MutableState mutableState7;
        final MutableState mutableState8;
        final MutableState mutableState9;
        final MutableState mutableState10;
        AuthRepository authRepository;
        CoroutineScope coroutineScope;
        final MutableState mutableState11;
        final MutableState mutableState12;
        final MutableState mutableState13;
        String str6;
        String str7;
        String str8;
        String str9;
        final MutableState mutableState14;
        final MutableState mutableState15;
        final MutableState mutableState16;
        final MutableState mutableState17;
        final MutableState mutableState18;
        final MutableState mutableState19;
        final MutableState mutableState20;
        MutableState mutableState21;
        MutableState mutableState22;
        MutableState mutableState23;
        String str10;
        String str11;
        String str12;
        MutableState mutableState24;
        int i7;
        final MutableState mutableState25;
        MutableState mutableState26;
        Composer composer3;
        final MutableState mutableState27;
        final MutableState mutableState28;
        final MutableState mutableState29;
        final MutableState mutableState30;
        Intrinsics.checkNotNullParameter(app, "app");
        Composer startRestartGroup = composer.startRestartGroup(1058764698);
        ComposerKt.sourceInformation(startRestartGroup, "C(AuthScreen)73@2987L24,78@3215L24,78@3194L45,80@3257L43,81@3317L44,82@3378L34,83@3430L31,84@3481L31,86@3531L31,87@3583L31,88@3636L31,90@3688L31,91@3740L31,92@3792L31,93@3844L31,94@3899L31,96@3951L31,97@4002L37,98@4060L31,99@4119L31,101@4174L31,102@4226L31,103@4278L31,107@4478L34,130@4991L13506:AuthScreen.kt#1spzcc");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1058764698, i2, -1, "uz.FonRo.pos.ui.auth.AuthScreen (AuthScreen.kt:72)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954203484, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final CoroutineScope coroutineScope2 = (CoroutineScope) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final AuthRepository auth = app.getAuth();
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434365486, "CC(remember):AuthScreen.kt#9igjgp");
            AuthScreenKt$AuthScreen$1$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new AuthScreenKt$AuthScreen$1$1(null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434364123, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AuthView.LOGIN, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState31 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434362202, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(LoginMode.EMAIL, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState32 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434360260, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState33 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434358599, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final MutableState mutableState34 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434356967, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final MutableState mutableState35 = (MutableState) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434355367, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            final MutableState mutableState36 = (MutableState) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434353703, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            final MutableState mutableState37 = (MutableState) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434352007, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                rememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            MutableState mutableState38 = (MutableState) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434350343, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                rememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            final MutableState mutableState39 = (MutableState) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434348679, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                rememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            MutableState mutableState40 = (MutableState) rememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434347015, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                rememberedValue13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            MutableState mutableState41 = (MutableState) rememberedValue13;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434345351, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue14 = startRestartGroup.rememberedValue();
            if (rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                rememberedValue14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue14);
            }
            MutableState mutableState42 = (MutableState) rememberedValue14;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434343591, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue15 = startRestartGroup.rememberedValue();
            if (rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                rememberedValue15 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue15);
            }
            MutableState mutableState43 = (MutableState) rememberedValue15;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434341927, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue16 = startRestartGroup.rememberedValue();
            if (rememberedValue16 == Composer.INSTANCE.getEmpty()) {
                rememberedValue16 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue16);
            }
            final MutableState mutableState44 = (MutableState) rememberedValue16;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434340289, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue17 = startRestartGroup.rememberedValue();
            if (rememberedValue17 == Composer.INSTANCE.getEmpty()) {
                rememberedValue17 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("verify", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue17);
            }
            final MutableState mutableState45 = (MutableState) rememberedValue17;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434338439, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue18 = startRestartGroup.rememberedValue();
            if (rememberedValue18 == Composer.INSTANCE.getEmpty()) {
                rememberedValue18 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue18);
            }
            final MutableState mutableState46 = (MutableState) rememberedValue18;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434336551, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue19 = startRestartGroup.rememberedValue();
            if (rememberedValue19 == Composer.INSTANCE.getEmpty()) {
                rememberedValue19 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue19);
            }
            final MutableState mutableState47 = (MutableState) rememberedValue19;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434334791, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue20 = startRestartGroup.rememberedValue();
            if (rememberedValue20 == Composer.INSTANCE.getEmpty()) {
                rememberedValue20 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue20);
            }
            MutableState mutableState48 = (MutableState) rememberedValue20;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434333127, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue21 = startRestartGroup.rememberedValue();
            if (rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                rememberedValue21 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue21);
            }
            MutableState mutableState49 = (MutableState) rememberedValue21;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434331463, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue22 = startRestartGroup.rememberedValue();
            if (rememberedValue22 == Composer.INSTANCE.getEmpty()) {
                rememberedValue22 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue22);
            }
            MutableState mutableState50 = (MutableState) rememberedValue22;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -434325060, "CC(remember):AuthScreen.kt#9igjgp");
            Object rememberedValue23 = startRestartGroup.rememberedValue();
            if (rememberedValue23 == Composer.INSTANCE.getEmpty()) {
                rememberedValue23 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue23);
            }
            MutableState mutableState51 = (MutableState) rememberedValue23;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier background$default = BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m4335linearGradientmHitzGk$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m4374boximpl(Ox.INSTANCE.m10185getBg0d7_KjU()), Color.m4374boximpl(Ox.INSTANCE.m10218getPanel20d7_KjU())}), 0L, 0L, 0, 14, (Object) null), null, 0.0f, 6, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, background$default);
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
            Updater.m3815setimpl(m3808constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 403109242, "C140@5250L21,141@5323L10,142@5385L14,137@5158L12391,386@17890L10,390@18031L20,390@18025L26,383@17762L729:AuthScreen.kt#1spzcc");
            Modifier m1049padding3ABfNKs = PaddingKt.m1049padding3ABfNKs(WindowInsetsPadding_androidKt.imePadding(WindowInsetsPaddingKt.windowInsetsPadding(WindowInsetsPaddingKt.windowInsetsPadding(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null), WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, startRestartGroup, 6)), WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, startRestartGroup, 6))), Dp.m6989constructorimpl(20.0f));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m1049padding3ABfNKs);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl2 = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl2, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -902166649, "C148@5605L11,149@5629L854,377@17528L11:AuthScreen.kt#1spzcc");
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(24.0f), startRestartGroup, 6);
            int i8 = WhenMappings.$EnumSwitchMapping$0[AuthScreen$lambda$2(mutableState31).ordinal()];
            if (i8 == 1) {
                tx = LangKt.tx("Регистрация", new Object[0]);
            } else if (i8 == 2) {
                tx = LangKt.tx("Код из письма", new Object[0]);
            } else if (i8 == 3) {
                tx = LangKt.tx("Восстановление пароля", new Object[0]);
            } else if (i8 == 4) {
                tx = LangKt.tx("Новый пароль", new Object[0]);
            } else {
                if (i8 != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                tx = "FonRo";
            }
            int i9 = WhenMappings.$EnumSwitchMapping$0[AuthScreen$lambda$2(mutableState31).ordinal()];
            if (i9 == 1) {
                i3 = 0;
                tx2 = LangKt.tx("новый магазин в FonRo", new Object[0]);
            } else if (i9 == 2) {
                i3 = 0;
                tx2 = StringsKt.isBlank(AuthScreen$lambda$47(mutableState46)) ? LangKt.tx("введите 6-значный код", new Object[0]) : LangKt.tx("мы отправили код на %s", AuthScreen$lambda$47(mutableState46));
            } else if (i9 == 3) {
                i3 = 0;
                tx2 = LangKt.tx("пришлём код на вашу почту", new Object[0]);
            } else if (i9 == 4) {
                i3 = 0;
                tx2 = LangKt.tx("придумайте новый пароль", new Object[0]);
            } else {
                if (i9 != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                i3 = 0;
                tx2 = LangKt.tx("мобильная касса магазина", new Object[0]);
            }
            Brand(tx, tx2, startRestartGroup, i3);
            if (StringsKt.isBlank(AuthScreen$lambda$11(mutableState34))) {
                startRestartGroup.startReplaceGroup(-901599164);
            } else {
                startRestartGroup.startReplaceGroup(-2107294725);
                ComposerKt.sourceInformation(startRestartGroup, "167@6521L29");
                Banner(AuthScreen$lambda$11(mutableState34), true, startRestartGroup, 48);
            }
            startRestartGroup.endReplaceGroup();
            if (StringsKt.isBlank(AuthScreen$lambda$14(mutableState35)) || AuthScreen$lambda$2(mutableState31) != AuthView.LOGIN) {
                i4 = 0;
                startRestartGroup.startReplaceGroup(-901502940);
            } else {
                startRestartGroup.startReplaceGroup(-2107291714);
                ComposerKt.sourceInformation(startRestartGroup, "168@6615L32");
                i4 = 0;
                Banner(AuthScreen$lambda$14(mutableState35), false, startRestartGroup, 48);
            }
            startRestartGroup.endReplaceGroup();
            int i10 = WhenMappings.$EnumSwitchMapping$0[AuthScreen$lambda$2(mutableState31).ordinal()];
            if (i10 == 1) {
                str = "CC(remember):AuthScreen.kt#9igjgp";
                i5 = i4;
                startRestartGroup.startReplaceGroup(-897739695);
                ComposerKt.sourceInformation(startRestartGroup, "239@10434L16,239@10396L55,240@10515L17,240@10472L61,242@10628L17,241@10554L172,245@10774L17,245@10747L80,247@10929L20,246@10848L190,252@11197L1047,250@11059L1307,273@12387L11,274@12463L24,274@12419L68");
                String tx3 = LangKt.tx("Имя и фамилия", new Object[i5]);
                String AuthScreen$lambda$26 = AuthScreen$lambda$26(mutableState39);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2107169522, str);
                Object rememberedValue24 = startRestartGroup.rememberedValue();
                if (rememberedValue24 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue24 = new Function1() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit AuthScreen$lambda$64$0$6$0;
                            AuthScreen$lambda$64$0$6$0 = AuthScreenKt.AuthScreen$lambda$64$0$6$0(MutableState.this, (String) obj);
                            return AuthScreen$lambda$64$0$6$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue24);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                str2 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                str3 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                str4 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                str5 = "C101@5232L9:Row.kt#2w3rfo";
                FieldsKt.m9846OxFieldDfSPO0(tx3, AuthScreen$lambda$26, (Function1) rememberedValue24, null, null, 0, 0, null, false, false, false, false, false, null, null, startRestartGroup, 384, 0, 32760);
                String tx4 = LangKt.tx("Название магазина", new Object[i5]);
                String AuthScreen$lambda$29 = AuthScreen$lambda$29(mutableState40);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2107166929, str);
                Object rememberedValue25 = startRestartGroup.rememberedValue();
                if (rememberedValue25 == Composer.INSTANCE.getEmpty()) {
                    mutableState = mutableState40;
                    rememberedValue25 = new Function1() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda23
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit AuthScreen$lambda$64$0$7$0;
                            AuthScreen$lambda$64$0$7$0 = AuthScreenKt.AuthScreen$lambda$64$0$7$0(MutableState.this, (String) obj);
                            return AuthScreen$lambda$64$0$7$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue25);
                } else {
                    mutableState = mutableState40;
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final MutableState mutableState52 = mutableState;
                FieldsKt.m9846OxFieldDfSPO0(tx4, AuthScreen$lambda$29, (Function1) rememberedValue25, null, null, 0, 0, null, false, false, false, false, false, null, null, startRestartGroup, 384, 0, 32760);
                String tx5 = LangKt.tx("Телефон (необязательно)", new Object[i5]);
                String AuthScreen$lambda$32 = AuthScreen$lambda$32(mutableState41);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2107163313, str);
                Object rememberedValue26 = startRestartGroup.rememberedValue();
                if (rememberedValue26 == Composer.INSTANCE.getEmpty()) {
                    mutableState2 = mutableState41;
                    rememberedValue26 = new Function1() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit AuthScreen$lambda$64$0$8$0;
                            AuthScreen$lambda$64$0$8$0 = AuthScreenKt.AuthScreen$lambda$64$0$8$0(MutableState.this, (String) obj);
                            return AuthScreen$lambda$64$0$8$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue26);
                } else {
                    mutableState2 = mutableState41;
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final MutableState mutableState53 = mutableState2;
                FieldsKt.m9846OxFieldDfSPO0(tx5, AuthScreen$lambda$32, (Function1) rememberedValue26, null, null, KeyboardType.INSTANCE.m6694getPhonePjHm6EE(), 0, null, false, false, false, false, false, null, null, startRestartGroup, 196992, 0, 32728);
                String AuthScreen$lambda$35 = AuthScreen$lambda$35(mutableState42);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2107158641, str);
                Object rememberedValue27 = startRestartGroup.rememberedValue();
                if (rememberedValue27 == Composer.INSTANCE.getEmpty()) {
                    mutableState3 = mutableState42;
                    rememberedValue27 = new Function1() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda31
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit AuthScreen$lambda$64$0$9$0;
                            AuthScreen$lambda$64$0$9$0 = AuthScreenKt.AuthScreen$lambda$64$0$9$0(MutableState.this, (String) obj);
                            return AuthScreen$lambda$64$0$9$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue27);
                } else {
                    mutableState3 = mutableState42;
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final MutableState mutableState54 = mutableState3;
                FieldsKt.m9846OxFieldDfSPO0("Email", AuthScreen$lambda$35, (Function1) rememberedValue27, null, null, KeyboardType.INSTANCE.m6690getEmailPjHm6EE(), 0, null, false, false, false, false, false, null, null, startRestartGroup, 196998, 0, 32728);
                String tx6 = LangKt.tx("Пароль (минимум 6 символов)", new Object[i5]);
                String AuthScreen$lambda$38 = AuthScreen$lambda$38(mutableState43);
                int m6636getGoeUduSuo = ImeAction.INSTANCE.m6636getGoeUduSuo();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2107153678, str);
                Object rememberedValue28 = startRestartGroup.rememberedValue();
                if (rememberedValue28 == Composer.INSTANCE.getEmpty()) {
                    mutableState4 = mutableState43;
                    rememberedValue28 = new Function1() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda32
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit AuthScreen$lambda$64$0$10$0;
                            AuthScreen$lambda$64$0$10$0 = AuthScreenKt.AuthScreen$lambda$64$0$10$0(MutableState.this, (String) obj);
                            return AuthScreen$lambda$64$0$10$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue28);
                } else {
                    mutableState4 = mutableState43;
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final MutableState mutableState55 = mutableState4;
                FieldsKt.m9846OxFieldDfSPO0(tx6, AuthScreen$lambda$38, (Function1) rememberedValue28, null, null, 0, m6636getGoeUduSuo, null, true, false, false, false, false, null, null, startRestartGroup, 102236544, 0, 32440);
                composer2 = startRestartGroup;
                String tx7 = AuthScreen$lambda$8(mutableState33) ? LangKt.tx("Отправляем код…", new Object[i5]) : LangKt.tx("Зарегистрироваться", new Object[i5]);
                BtnStyle btnStyle = BtnStyle.PRIMARY;
                BtnSize btnSize = BtnSize.LG;
                boolean z = !AuthScreen$lambda$8(mutableState33);
                ComposerKt.sourceInformationMarkerStart(composer2, -2107144075, str);
                boolean changedInstance = composer2.changedInstance(coroutineScope2) | composer2.changedInstance(auth);
                Object rememberedValue29 = composer2.rememberedValue();
                if (changedInstance || rememberedValue29 == Composer.INSTANCE.getEmpty()) {
                    Function0 function0 = new Function0() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda33
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit AuthScreen$lambda$64$0$11$0;
                            AuthScreen$lambda$64$0$11$0 = AuthScreenKt.AuthScreen$lambda$64$0$11$0(AuthRepository.this, mutableState39, mutableState52, mutableState54, mutableState55, mutableState53, mutableState45, mutableState46, mutableState44, mutableState31, mutableState34, mutableState35, coroutineScope2, mutableState33);
                            return AuthScreen$lambda$64$0$11$0;
                        }
                    };
                    mutableState5 = mutableState34;
                    mutableState6 = mutableState35;
                    composer2.updateRememberedValue(function0);
                    rememberedValue29 = function0;
                } else {
                    mutableState6 = mutableState35;
                    mutableState5 = mutableState34;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BasicsKt.OxButton(tx7, (Function0) rememberedValue29, null, btnStyle, btnSize, z, true, null, composer2, 1600512, 132);
                i6 = 6;
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
                String tx8 = LangKt.tx("← Уже есть аккаунт? Войти", new Object[i5]);
                ComposerKt.sourceInformationMarkerStart(composer2, -2107104586, str);
                Object rememberedValue30 = composer2.rememberedValue();
                if (rememberedValue30 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue30 = new Function0() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda34
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit AuthScreen$lambda$64$0$12$0;
                            AuthScreen$lambda$64$0$12$0 = AuthScreenKt.AuthScreen$lambda$64$0$12$0(MutableState.this, mutableState5, mutableState6);
                            return AuthScreen$lambda$64$0$12$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue30);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                LinkButton(tx8, (Function0) rememberedValue30, composer2, 48);
                composer2.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            } else if (i10 != 2) {
                if (i10 == 3) {
                    str = "CC(remember):AuthScreen.kt#9igjgp";
                    str6 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                    i5 = i4;
                    str7 = "C101@5232L9:Row.kt#2w3rfo";
                    str8 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                    str9 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                    startRestartGroup.startReplaceGroup(-893320118);
                    ComposerKt.sourceInformation(startRestartGroup, "325@14938L19,324@14884L180,330@15217L475,328@15085L729,342@15835L11,343@15902L24,343@15867L59");
                    String AuthScreen$lambda$53 = AuthScreen$lambda$53(mutableState48);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2107025391, str);
                    Object rememberedValue31 = startRestartGroup.rememberedValue();
                    if (rememberedValue31 == Composer.INSTANCE.getEmpty()) {
                        mutableState14 = mutableState48;
                        rememberedValue31 = new Function1() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit AuthScreen$lambda$64$0$16$0;
                                AuthScreen$lambda$64$0$16$0 = AuthScreenKt.AuthScreen$lambda$64$0$16$0(MutableState.this, (String) obj);
                                return AuthScreen$lambda$64$0$16$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue31);
                    } else {
                        mutableState14 = mutableState48;
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final MutableState mutableState56 = mutableState14;
                    FieldsKt.m9846OxFieldDfSPO0("Email", AuthScreen$lambda$53, (Function1) rememberedValue31, null, null, KeyboardType.INSTANCE.m6690getEmailPjHm6EE(), ImeAction.INSTANCE.m6636getGoeUduSuo(), null, false, false, false, false, false, null, null, startRestartGroup, 1769862, 0, 32664);
                    composer2 = startRestartGroup;
                    String tx9 = AuthScreen$lambda$8(mutableState33) ? LangKt.tx("Отправляем код…", new Object[i5]) : LangKt.tx("Получить код", new Object[i5]);
                    BtnStyle btnStyle2 = BtnStyle.PRIMARY;
                    BtnSize btnSize2 = BtnSize.LG;
                    boolean z2 = !AuthScreen$lambda$8(mutableState33);
                    ComposerKt.sourceInformationMarkerStart(composer2, -2107016007, str);
                    boolean changedInstance2 = composer2.changedInstance(coroutineScope2) | composer2.changedInstance(auth);
                    Object rememberedValue32 = composer2.rememberedValue();
                    if (changedInstance2 || rememberedValue32 == Composer.INSTANCE.getEmpty()) {
                        Function0 function02 = new Function0() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit AuthScreen$lambda$64$0$17$0;
                                AuthScreen$lambda$64$0$17$0 = AuthScreenKt.AuthScreen$lambda$64$0$17$0(AuthRepository.this, mutableState56, mutableState45, mutableState46, mutableState44, mutableState31, mutableState34, mutableState35, coroutineScope2, mutableState33);
                                return AuthScreen$lambda$64$0$17$0;
                            }
                        };
                        mutableState15 = mutableState34;
                        mutableState16 = mutableState35;
                        composer2.updateRememberedValue(function02);
                        rememberedValue32 = function02;
                    } else {
                        mutableState16 = mutableState35;
                        mutableState15 = mutableState34;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    BasicsKt.OxButton(tx9, (Function0) rememberedValue32, null, btnStyle2, btnSize2, z2, true, null, composer2, 1600512, 132);
                    i6 = 6;
                    BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
                    String tx10 = LangKt.tx("← Назад ко входу", new Object[i5]);
                    ComposerKt.sourceInformationMarkerStart(composer2, -2106994538, str);
                    Object rememberedValue33 = composer2.rememberedValue();
                    if (rememberedValue33 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue33 = new Function0() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit AuthScreen$lambda$64$0$18$0;
                                AuthScreen$lambda$64$0$18$0 = AuthScreenKt.AuthScreen$lambda$64$0$18$0(MutableState.this, mutableState15, mutableState16);
                                return AuthScreen$lambda$64$0$18$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue33);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    LinkButton(tx10, (Function0) rememberedValue33, composer2, 48);
                    composer2.endReplaceGroup();
                    Unit unit3 = Unit.INSTANCE;
                } else if (i10 == 4) {
                    str = "CC(remember):AuthScreen.kt#9igjgp";
                    i5 = i4;
                    startRestartGroup.startReplaceGroup(-892195562);
                    ComposerKt.sourceInformation(startRestartGroup, "348@16088L17,347@16004L164,352@16256L17,351@16189L173,357@16514L734,355@16383L987,372@17391L11,373@17458L24,373@17423L59");
                    String tx11 = LangKt.tx("Новый пароль (минимум 6 символов)", new Object[i5]);
                    String AuthScreen$lambda$56 = AuthScreen$lambda$56(mutableState49);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2106988593, str);
                    Object rememberedValue34 = startRestartGroup.rememberedValue();
                    if (rememberedValue34 == Composer.INSTANCE.getEmpty()) {
                        mutableState17 = mutableState49;
                        rememberedValue34 = new Function1() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit AuthScreen$lambda$64$0$19$0;
                                AuthScreen$lambda$64$0$19$0 = AuthScreenKt.AuthScreen$lambda$64$0$19$0(MutableState.this, (String) obj);
                                return AuthScreen$lambda$64$0$19$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue34);
                    } else {
                        mutableState17 = mutableState49;
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final MutableState mutableState57 = mutableState17;
                    str6 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                    str9 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                    str7 = "C101@5232L9:Row.kt#2w3rfo";
                    str8 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                    FieldsKt.m9846OxFieldDfSPO0(tx11, AuthScreen$lambda$56, (Function1) rememberedValue34, null, null, 0, 0, null, true, false, false, false, false, null, null, startRestartGroup, 100663680, 0, 32504);
                    String tx12 = LangKt.tx("Повторите пароль", new Object[i5]);
                    String AuthScreen$lambda$59 = AuthScreen$lambda$59(mutableState50);
                    int m6636getGoeUduSuo2 = ImeAction.INSTANCE.m6636getGoeUduSuo();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2106983217, str);
                    Object rememberedValue35 = startRestartGroup.rememberedValue();
                    if (rememberedValue35 == Composer.INSTANCE.getEmpty()) {
                        mutableState18 = mutableState50;
                        rememberedValue35 = new Function1() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit AuthScreen$lambda$64$0$20$0;
                                AuthScreen$lambda$64$0$20$0 = AuthScreenKt.AuthScreen$lambda$64$0$20$0(MutableState.this, (String) obj);
                                return AuthScreen$lambda$64$0$20$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue35);
                    } else {
                        mutableState18 = mutableState50;
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final MutableState mutableState58 = mutableState18;
                    FieldsKt.m9846OxFieldDfSPO0(tx12, AuthScreen$lambda$59, (Function1) rememberedValue35, null, null, 0, m6636getGoeUduSuo2, null, true, false, false, false, false, null, null, startRestartGroup, 102236544, 0, 32440);
                    composer2 = startRestartGroup;
                    String tx13 = AuthScreen$lambda$8(mutableState33) ? LangKt.tx("Сохраняем…", new Object[i5]) : LangKt.tx("Сохранить пароль", new Object[i5]);
                    BtnStyle btnStyle3 = BtnStyle.PRIMARY;
                    BtnSize btnSize3 = BtnSize.LG;
                    boolean z3 = !AuthScreen$lambda$8(mutableState33);
                    ComposerKt.sourceInformationMarkerStart(composer2, -2106974244, str);
                    boolean changedInstance3 = composer2.changedInstance(coroutineScope2) | composer2.changedInstance(auth);
                    Object rememberedValue36 = composer2.rememberedValue();
                    if (changedInstance3 || rememberedValue36 == Composer.INSTANCE.getEmpty()) {
                        Function0 function03 = new Function0() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit AuthScreen$lambda$64$0$21$0;
                                AuthScreen$lambda$64$0$21$0 = AuthScreenKt.AuthScreen$lambda$64$0$21$0(AuthRepository.this, mutableState57, mutableState58, mutableState46, mutableState47, mutableState36, mutableState37, mutableState35, mutableState31, mutableState34, coroutineScope2, mutableState33);
                                return AuthScreen$lambda$64$0$21$0;
                            }
                        };
                        mutableState19 = mutableState35;
                        mutableState20 = mutableState34;
                        composer2.updateRememberedValue(function03);
                        rememberedValue36 = function03;
                    } else {
                        mutableState19 = mutableState35;
                        mutableState20 = mutableState34;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    BasicsKt.OxButton(tx13, (Function0) rememberedValue36, null, btnStyle3, btnSize3, z3, true, null, composer2, 1600512, 132);
                    i6 = 6;
                    BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
                    String tx14 = LangKt.tx("← Назад ко входу", new Object[i5]);
                    ComposerKt.sourceInformationMarkerStart(composer2, -2106944746, str);
                    Object rememberedValue37 = composer2.rememberedValue();
                    if (rememberedValue37 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue37 = new Function0() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit AuthScreen$lambda$64$0$22$0;
                                AuthScreen$lambda$64$0$22$0 = AuthScreenKt.AuthScreen$lambda$64$0$22$0(MutableState.this, mutableState20, mutableState19);
                                return AuthScreen$lambda$64$0$22$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue37);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    LinkButton(tx14, (Function0) rememberedValue37, composer2, 48);
                    composer2.endReplaceGroup();
                    Unit unit4 = Unit.INSTANCE;
                } else {
                    if (i10 != 5) {
                        startRestartGroup.startReplaceGroup(-2107279421);
                        startRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    startRestartGroup.startReplaceGroup(-901329030);
                    ComposerKt.sourceInformation(startRestartGroup, "172@6747L25,172@6731L41,173@6793L11,198@8008L1571,196@7891L1810,225@9722L11,226@9754L244,230@10019L11,231@10051L266");
                    LoginMode AuthScreen$lambda$5 = AuthScreen$lambda$5(mutableState32);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2107287497, "CC(remember):AuthScreen.kt#9igjgp");
                    Object rememberedValue38 = startRestartGroup.rememberedValue();
                    if (rememberedValue38 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue38 = new Function1() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit AuthScreen$lambda$64$0$0$0;
                                AuthScreen$lambda$64$0$0$0 = AuthScreenKt.AuthScreen$lambda$64$0$0$0(MutableState.this, mutableState34, (LoginMode) obj);
                                return AuthScreen$lambda$64$0$0$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue38);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    LoginTabs(AuthScreen$lambda$5, (Function1) rememberedValue38, startRestartGroup, 48);
                    BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(16.0f), startRestartGroup, 6);
                    if (AuthScreen$lambda$5(mutableState32) == LoginMode.EMAIL) {
                        startRestartGroup.startReplaceGroup(-901285072);
                        ComposerKt.sourceInformation(startRestartGroup, "176@6933L14,175@6880L156,180@7122L17,179@7061L175");
                        String AuthScreen$lambda$17 = AuthScreen$lambda$17(mutableState36);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2107281556, "CC(remember):AuthScreen.kt#9igjgp");
                        Object rememberedValue39 = startRestartGroup.rememberedValue();
                        if (rememberedValue39 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue39 = new Function1() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit AuthScreen$lambda$64$0$1$0;
                                    AuthScreen$lambda$64$0$1$0 = AuthScreenKt.AuthScreen$lambda$64$0$1$0(MutableState.this, (String) obj);
                                    return AuthScreen$lambda$64$0$1$0;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue39);
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        mutableState21 = mutableState32;
                        mutableState23 = mutableState34;
                        mutableState22 = mutableState36;
                        str11 = "C101@5232L9:Row.kt#2w3rfo";
                        i7 = 1;
                        mutableState26 = mutableState38;
                        str = "CC(remember):AuthScreen.kt#9igjgp";
                        str12 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                        str10 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                        i5 = i4;
                        FieldsKt.m9846OxFieldDfSPO0("Email", AuthScreen$lambda$17, (Function1) rememberedValue39, null, null, KeyboardType.INSTANCE.m6690getEmailPjHm6EE(), 0, null, false, false, false, false, false, null, null, startRestartGroup, 196998, 0, 32728);
                        String tx15 = LangKt.tx("Пароль", new Object[i5]);
                        String AuthScreen$lambda$20 = AuthScreen$lambda$20(mutableState37);
                        int m6636getGoeUduSuo3 = ImeAction.INSTANCE.m6636getGoeUduSuo();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2107275505, str);
                        Object rememberedValue40 = startRestartGroup.rememberedValue();
                        if (rememberedValue40 == Composer.INSTANCE.getEmpty()) {
                            mutableState30 = mutableState37;
                            rememberedValue40 = new Function1() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit AuthScreen$lambda$64$0$2$0;
                                    AuthScreen$lambda$64$0$2$0 = AuthScreenKt.AuthScreen$lambda$64$0$2$0(MutableState.this, (String) obj);
                                    return AuthScreen$lambda$64$0$2$0;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue40);
                        } else {
                            mutableState30 = mutableState37;
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        mutableState24 = mutableState30;
                        FieldsKt.m9846OxFieldDfSPO0(tx15, AuthScreen$lambda$20, (Function1) rememberedValue40, null, null, 0, m6636getGoeUduSuo3, null, true, false, false, false, false, null, null, startRestartGroup, 102236544, 0, 32440);
                        composer3 = startRestartGroup;
                        composer3.endReplaceGroup();
                    } else {
                        mutableState21 = mutableState32;
                        mutableState22 = mutableState36;
                        mutableState23 = mutableState34;
                        str = "CC(remember):AuthScreen.kt#9igjgp";
                        str10 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                        i5 = i4;
                        str11 = "C101@5232L9:Row.kt#2w3rfo";
                        str12 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                        mutableState24 = mutableState37;
                        i7 = 1;
                        startRestartGroup.startReplaceGroup(-900847817);
                        ComposerKt.sourceInformation(startRestartGroup, "187@7457L35,184@7290L557");
                        String tx16 = LangKt.tx("Ключ доступа сотрудника", new Object[i5]);
                        String AuthScreen$lambda$23 = AuthScreen$lambda$23(mutableState38);
                        int m6636getGoeUduSuo4 = ImeAction.INSTANCE.m6636getGoeUduSuo();
                        String tx17 = LangKt.tx("Ключ выдаёт владелец в разделе «Сотрудники». Один ключ — одно устройство.", new Object[i5]);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2107264767, str);
                        Object rememberedValue41 = startRestartGroup.rememberedValue();
                        if (rememberedValue41 == Composer.INSTANCE.getEmpty()) {
                            mutableState25 = mutableState38;
                            rememberedValue41 = new Function1() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit AuthScreen$lambda$64$0$3$0;
                                    AuthScreen$lambda$64$0$3$0 = AuthScreenKt.AuthScreen$lambda$64$0$3$0(MutableState.this, (String) obj);
                                    return AuthScreen$lambda$64$0$3$0;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue41);
                        } else {
                            mutableState25 = mutableState38;
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        mutableState26 = mutableState25;
                        FieldsKt.m9846OxFieldDfSPO0(tx16, AuthScreen$lambda$23, (Function1) rememberedValue41, null, "OX-XXXX-XXXX-XXXX-XXXX", 0, m6636getGoeUduSuo4, null, false, false, false, true, true, null, tx17, startRestartGroup, 1597824, 432, 10152);
                        composer3 = startRestartGroup;
                        composer3.endReplaceGroup();
                    }
                    String tx18 = AuthScreen$lambda$8(mutableState33) ? LangKt.tx("Входим…", new Object[i5]) : LangKt.tx("Войти", new Object[i5]);
                    BtnStyle btnStyle4 = BtnStyle.PRIMARY;
                    BtnSize btnSize4 = BtnSize.LG;
                    boolean z4 = !AuthScreen$lambda$8(mutableState33);
                    ComposerKt.sourceInformationMarkerStart(composer3, -2107245599, str);
                    boolean changedInstance4 = composer3.changedInstance(coroutineScope2) | composer3.changedInstance(auth);
                    Object rememberedValue42 = composer3.rememberedValue();
                    if (changedInstance4 || rememberedValue42 == Composer.INSTANCE.getEmpty()) {
                        final MutableState mutableState59 = mutableState21;
                        final MutableState mutableState60 = mutableState23;
                        final MutableState mutableState61 = mutableState22;
                        final MutableState mutableState62 = mutableState26;
                        final MutableState mutableState63 = mutableState24;
                        Function0 function04 = new Function0() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit AuthScreen$lambda$64$0$4$0;
                                AuthScreen$lambda$64$0$4$0 = AuthScreenKt.AuthScreen$lambda$64$0$4$0(AuthRepository.this, mutableState59, mutableState62, mutableState61, mutableState63, mutableState45, mutableState46, mutableState44, mutableState31, mutableState60, mutableState35, coroutineScope2, mutableState33);
                                return AuthScreen$lambda$64$0$4$0;
                            }
                        };
                        mutableState27 = mutableState31;
                        mutableState28 = mutableState60;
                        mutableState29 = mutableState35;
                        composer3.updateRememberedValue(function04);
                        rememberedValue42 = function04;
                    } else {
                        mutableState27 = mutableState31;
                        mutableState29 = mutableState35;
                        mutableState28 = mutableState23;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    BasicsKt.OxButton(tx18, (Function0) rememberedValue42, null, btnStyle4, btnSize4, z4, true, null, composer3, 1600512, 132);
                    BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer3, 6);
                    Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(18.0f));
                    ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer3, 6);
                    String str13 = str10;
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, str13);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, i5);
                    CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer3, companion);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    String str14 = str12;
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, str14);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor3);
                    } else {
                        composer3.useNode();
                    }
                    Composer m3808constructorimpl3 = Updater.m3808constructorimpl(composer3);
                    Updater.m3815setimpl(m3808constructorimpl3, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    String str15 = str11;
                    ComposerKt.sourceInformationMarkerStart(composer3, -407735110, str15);
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 1578887830, "C227@9867L27,227@9837L57,228@9952L24,228@9919L57:AuthScreen.kt#1spzcc");
                    String tx19 = LangKt.tx("Регистрация", new Object[i5]);
                    ComposerKt.sourceInformationMarkerStart(composer3, -364709283, str);
                    Object rememberedValue43 = composer3.rememberedValue();
                    if (rememberedValue43 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue43 = new Function0() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit AuthScreen$lambda$64$0$5$0$0;
                                AuthScreen$lambda$64$0$5$0$0 = AuthScreenKt.AuthScreen$lambda$64$0$5$0$0(MutableState.this, mutableState28, mutableState29);
                                return AuthScreen$lambda$64$0$5$0$0;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue43);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    LinkButton(tx19, (Function0) rememberedValue43, composer3, 48);
                    String tx20 = LangKt.tx("Забыли пароль?", new Object[i5]);
                    ComposerKt.sourceInformationMarkerStart(composer3, -364706566, str);
                    Object rememberedValue44 = composer3.rememberedValue();
                    if (rememberedValue44 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue44 = new Function0() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit AuthScreen$lambda$64$0$5$1$0;
                                AuthScreen$lambda$64$0$5$1$0 = AuthScreenKt.AuthScreen$lambda$64$0$5$1$0(MutableState.this, mutableState28, mutableState29);
                                return AuthScreen$lambda$64$0$5$1$0;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue44);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    LinkButton(tx20, (Function0) rememberedValue44, composer3, 48);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(16.0f), composer3, 6);
                    Composer composer4 = composer3;
                    TextKt.m2798Text4IGK_g(LangKt.tx("Логин и пароль — те же, что в приложении FonRo.", new Object[i5]), SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, i7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), Ox.INSTANCE.m10200getDim20d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744446, null), composer4, 48, 0, 65532);
                    composer2 = composer4;
                    composer2.endReplaceGroup();
                    Unit unit5 = Unit.INSTANCE;
                    str2 = str14;
                    str3 = str13;
                    str4 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                    str5 = str15;
                    i6 = 6;
                }
                str5 = str7;
                str4 = str9;
                str2 = str8;
                str3 = str6;
            } else {
                str = "CC(remember):AuthScreen.kt#9igjgp";
                i5 = i4;
                startRestartGroup.startReplaceGroup(-895587179);
                ComposerKt.sourceInformation(startRestartGroup, "281@12704L46,278@12561L499,291@13207L734,289@13081L982,307@14084L11,308@14116L692");
                String tx21 = LangKt.tx("6-значный код", new Object[i5]);
                String AuthScreen$lambda$41 = AuthScreen$lambda$41(mutableState44);
                int m6692getNumberPasswordPjHm6EE = KeyboardType.INSTANCE.m6692getNumberPasswordPjHm6EE();
                int m6636getGoeUduSuo5 = ImeAction.INSTANCE.m6636getGoeUduSuo();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2107096852, str);
                Object rememberedValue45 = startRestartGroup.rememberedValue();
                if (rememberedValue45 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue45 = new Function1() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda35
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit AuthScreen$lambda$64$0$13$0;
                            AuthScreen$lambda$64$0$13$0 = AuthScreenKt.AuthScreen$lambda$64$0$13$0(MutableState.this, (String) obj);
                            return AuthScreen$lambda$64$0$13$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue45);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                FieldsKt.m9846OxFieldDfSPO0(tx21, AuthScreen$lambda$41, (Function1) rememberedValue45, null, "––––––", m6692getNumberPasswordPjHm6EE, m6636getGoeUduSuo5, null, false, false, false, true, true, 6, null, startRestartGroup, 1794432, 3504, 18312);
                composer2 = startRestartGroup;
                String tx22 = AuthScreen$lambda$8(mutableState33) ? LangKt.tx("Проверяем…", new Object[i5]) : LangKt.tx("Подтвердить", new Object[i5]);
                BtnStyle btnStyle5 = BtnStyle.PRIMARY;
                BtnSize btnSize5 = BtnSize.LG;
                boolean z5 = !AuthScreen$lambda$8(mutableState33);
                ComposerKt.sourceInformationMarkerStart(composer2, -2107080068, str);
                boolean changedInstance5 = composer2.changedInstance(coroutineScope2) | composer2.changedInstance(auth);
                Object rememberedValue46 = composer2.rememberedValue();
                if (changedInstance5 || rememberedValue46 == Composer.INSTANCE.getEmpty()) {
                    mutableState8 = mutableState31;
                    mutableState9 = mutableState46;
                    mutableState10 = mutableState45;
                    Function0 function05 = new Function0() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda36
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit AuthScreen$lambda$64$0$14$0;
                            AuthScreen$lambda$64$0$14$0 = AuthScreenKt.AuthScreen$lambda$64$0$14$0(AuthRepository.this, mutableState44, mutableState10, mutableState9, mutableState47, mutableState8, mutableState34, mutableState35, coroutineScope2, mutableState33);
                            return AuthScreen$lambda$64$0$14$0;
                        }
                    };
                    authRepository = auth;
                    coroutineScope = coroutineScope2;
                    composer2.updateRememberedValue(function05);
                    rememberedValue46 = function05;
                } else {
                    mutableState8 = mutableState31;
                    coroutineScope = coroutineScope2;
                    authRepository = auth;
                    mutableState9 = mutableState46;
                    mutableState10 = mutableState45;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BasicsKt.OxButton(tx22, (Function0) rememberedValue46, null, btnStyle5, btnSize5, z5, true, null, composer2, 1600512, 132);
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
                Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(18.0f));
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer2, 6);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, i5);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, companion2);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor4);
                } else {
                    composer2.useNode();
                }
                Composer m3808constructorimpl4 = Updater.m3808constructorimpl(composer2);
                Updater.m3815setimpl(m3808constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 633009182, "C309@14239L474,309@14199L514,319@14762L24,319@14738L48:AuthScreen.kt#1spzcc");
                String tx23 = LangKt.tx("Отправить код ещё раз", new Object[i5]);
                ComposerKt.sourceInformationMarkerStart(composer2, -2057789164, str);
                boolean changedInstance6 = composer2.changedInstance(coroutineScope) | composer2.changedInstance(authRepository);
                Object rememberedValue47 = composer2.rememberedValue();
                if (changedInstance6 || rememberedValue47 == Composer.INSTANCE.getEmpty()) {
                    final CoroutineScope coroutineScope3 = coroutineScope;
                    final AuthRepository authRepository2 = authRepository;
                    final MutableState mutableState64 = mutableState10;
                    final MutableState mutableState65 = mutableState9;
                    mutableState11 = mutableState8;
                    mutableState12 = mutableState35;
                    rememberedValue47 = new Function0() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit AuthScreen$lambda$64$0$15$0$0;
                            AuthScreen$lambda$64$0$15$0$0 = AuthScreenKt.AuthScreen$lambda$64$0$15$0$0(AuthRepository.this, mutableState64, mutableState65, mutableState34, coroutineScope3, mutableState33);
                            return AuthScreen$lambda$64$0$15$0$0;
                        }
                    };
                    mutableState13 = mutableState34;
                    composer2.updateRememberedValue(rememberedValue47);
                } else {
                    mutableState11 = mutableState8;
                    mutableState12 = mutableState35;
                    mutableState13 = mutableState34;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                LinkButton(tx23, (Function0) rememberedValue47, composer2, i5);
                String tx24 = LangKt.tx("Назад", new Object[i5]);
                ComposerKt.sourceInformationMarkerStart(composer2, -2057772878, str);
                Object rememberedValue48 = composer2.rememberedValue();
                if (rememberedValue48 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue48 = new Function0() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit AuthScreen$lambda$64$0$15$1$0;
                            AuthScreen$lambda$64$0$15$1$0 = AuthScreenKt.AuthScreen$lambda$64$0$15$1$0(MutableState.this, mutableState13, mutableState12);
                            return AuthScreen$lambda$64$0$15$1$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue48);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                LinkButton(tx24, (Function0) rememberedValue48, composer2, 48);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
                Unit unit6 = Unit.INSTANCE;
                str5 = "C101@5232L9:Row.kt#2w3rfo";
                str4 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                str2 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                str3 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                i6 = 6;
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(28.0f), composer2, i6);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m1049padding3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composer2, i6)), Dp.m6989constructorimpl(12.0f)), OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10217getPanel0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer2, 1260328136, str);
            Object rememberedValue49 = composer2.rememberedValue();
            if (rememberedValue49 == Composer.INSTANCE.getEmpty()) {
                mutableState7 = mutableState51;
                rememberedValue49 = new Function0() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AuthScreen$lambda$64$1$0;
                        AuthScreen$lambda$64$1$0 = AuthScreenKt.AuthScreen$lambda$64$1$0(MutableState.this);
                        return AuthScreen$lambda$64$1$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue49);
            } else {
                mutableState7 = mutableState51;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.m1084heightInVpY3zN4$default(ModifiersKt.oxTap(m558backgroundbw27NRU$default, false, (Function0) rememberedValue49, composer2, 384, 1), Dp.m6989constructorimpl(40.0f), 0.0f, 2, null), Dp.m6989constructorimpl(14.0f), 0.0f, 2, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_43 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(7.0f));
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, str4);
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m930spacedBy0680j_43, centerVertically, composer2, 54);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str3);
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, i5);
            CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer2, m1051paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str2);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor5);
            } else {
                composer2.useNode();
            }
            Composer m3808constructorimpl5 = Updater.m3808constructorimpl(composer2);
            Updater.m3815setimpl(m3808constructorimpl5, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl5.getInserting() || !Intrinsics.areEqual(m3808constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                m3808constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                m3808constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3815setimpl(m3808constructorimpl5, materializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -407735110, str5);
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 864271790, "C396@18284L32,397@18329L152:AuthScreen.kt#1spzcc");
            final MutableState mutableState66 = mutableState7;
            Composer composer5 = composer2;
            TextKt.m2798Text4IGK_g("🌐", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer5, 6, 0, 65534);
            TextKt.m2798Text4IGK_g(Lang.INSTANCE.titleOf(Lang.INSTANCE.getCode()), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getLabel(), Ox.INSTANCE.m10220getPrimary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer5, 0, 3072, 57342);
            startRestartGroup = composer5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (AuthScreen$lambda$62(mutableState66)) {
                startRestartGroup.startReplaceGroup(-564985092);
                ComposerKt.sourceInformation(startRestartGroup, "409@18806L21,409@18829L1138,409@18755L1212");
                String tx25 = LangKt.tx("Язык интерфейса", new Object[i5]);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -433866577, str);
                Object rememberedValue50 = startRestartGroup.rememberedValue();
                if (rememberedValue50 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue50 = new Function0() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit AuthScreen$lambda$65$0;
                            AuthScreen$lambda$65$0 = AuthScreenKt.AuthScreen$lambda$65$0(MutableState.this);
                            return AuthScreen$lambda$65$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue50);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                FonRoApp = app;
                SheetsKt.OxSheet(tx25, (Function0) rememberedValue50, null, false, null, ComposableLambdaKt.rememberComposableLambda(55170953, true, new Function3() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AuthScreenKt.AuthScreen$lambda$66(FonRoApp.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, startRestartGroup, 54), startRestartGroup, 196656, 28);
                startRestartGroup = startRestartGroup;
                startRestartGroup.endReplaceGroup();
            } else {
                FonRoApp = app;
                startRestartGroup.startReplaceGroup(-563804984);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            FonRoApp = app;
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthScreenKt.AuthScreen$lambda$67(FonRoApp.this, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final AuthView AuthScreen$lambda$2(MutableState<AuthView> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LoginMode AuthScreen$lambda$5(MutableState<LoginMode> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean AuthScreen$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AuthScreen$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String AuthScreen$lambda$11(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String AuthScreen$lambda$14(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuthScreen$lambda$17(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuthScreen$lambda$20(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuthScreen$lambda$23(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuthScreen$lambda$26(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuthScreen$lambda$29(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuthScreen$lambda$32(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuthScreen$lambda$35(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuthScreen$lambda$38(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuthScreen$lambda$41(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuthScreen$lambda$44(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuthScreen$lambda$47(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuthScreen$lambda$50(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuthScreen$lambda$53(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuthScreen$lambda$56(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuthScreen$lambda$59(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean AuthScreen$lambda$62(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AuthScreen$lambda$63(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AuthScreen$goto(MutableState<AuthView> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, AuthView authView) {
        mutableState.setValue(authView);
        mutableState2.setValue("");
        if (authView != AuthView.LOGIN) {
            mutableState3.setValue("");
        }
    }

    private static final void AuthScreen$run(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<String> mutableState2, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        if (AuthScreen$lambda$8(mutableState)) {
            return;
        }
        AuthScreen$lambda$9(mutableState, true);
        mutableState2.setValue("");
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AuthScreenKt$AuthScreen$run$1(function1, mutableState2, mutableState, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$0$0(MutableState mutableState, MutableState mutableState2, LoginMode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        mutableState2.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$1$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$2$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$3$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(formatAccessKey(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$4$0(AuthRepository authRepository, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, MutableState mutableState8, MutableState mutableState9, MutableState mutableState10, CoroutineScope coroutineScope, MutableState mutableState11) {
        AuthScreen$run(coroutineScope, mutableState11, mutableState9, new AuthScreenKt$AuthScreen$2$1$5$1$1(authRepository, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7, mutableState8, mutableState9, mutableState10, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$5$0$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        AuthScreen$goto(mutableState, mutableState2, mutableState3, AuthView.REGISTER);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$5$1$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        AuthScreen$goto(mutableState, mutableState2, mutableState3, AuthView.RESET);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$6$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$7$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$8$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$9$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$10$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$11$0(AuthRepository authRepository, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, MutableState mutableState8, MutableState mutableState9, MutableState mutableState10, MutableState mutableState11, CoroutineScope coroutineScope, MutableState mutableState12) {
        AuthScreen$run(coroutineScope, mutableState12, mutableState10, new AuthScreenKt$AuthScreen$2$1$12$1$1(authRepository, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7, mutableState8, mutableState9, mutableState10, mutableState11, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$12$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        AuthScreen$goto(mutableState, mutableState2, mutableState3, AuthView.LOGIN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$14$0(AuthRepository authRepository, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, CoroutineScope coroutineScope, MutableState mutableState8) {
        AuthScreen$run(coroutineScope, mutableState8, mutableState6, new AuthScreenKt$AuthScreen$2$1$15$1$1(authRepository, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$15$0$0(AuthRepository authRepository, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, CoroutineScope coroutineScope, MutableState mutableState4) {
        AuthScreen$run(coroutineScope, mutableState4, mutableState3, new AuthScreenKt$AuthScreen$2$1$16$1$1$1(authRepository, mutableState, mutableState2, mutableState3, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$15$1$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        AuthScreen$goto(mutableState, mutableState2, mutableState3, AuthView.LOGIN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$16$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$17$0(AuthRepository authRepository, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, CoroutineScope coroutineScope, MutableState mutableState8) {
        AuthScreen$run(coroutineScope, mutableState8, mutableState6, new AuthScreenKt$AuthScreen$2$1$18$1$1(authRepository, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$18$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        AuthScreen$goto(mutableState, mutableState2, mutableState3, AuthView.LOGIN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$19$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$20$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$21$0(AuthRepository authRepository, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, MutableState mutableState8, MutableState mutableState9, CoroutineScope coroutineScope, MutableState mutableState10) {
        AuthScreen$run(coroutineScope, mutableState10, mutableState9, new AuthScreenKt$AuthScreen$2$1$22$1$1(authRepository, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7, mutableState8, mutableState9, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$22$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        AuthScreen$goto(mutableState, mutableState2, mutableState3, AuthView.LOGIN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$1$0(MutableState mutableState) {
        AuthScreen$lambda$63(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$65$0(MutableState mutableState) {
        AuthScreen$lambda$63(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AuthScreen$lambda$66(final FonRoApp FonRoApp, ColumnScope OxSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSheet, "$this$OxSheet");
        ComposerKt.sourceInformation(composer, "C410@18843L160,414@19016L11,415@19047L886,415@19040L893,435@19946L11:AuthScreen.kt#1spzcc");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(55170953, i, -1, "uz.FonRo.pos.ui.auth.AuthScreen.<anonymous> (AuthScreen.kt:410)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Язык кассы на этом устройстве. На чеки и этикетки не влияет.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), composer, 6);
            BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(-1558123506, true, new Function3() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit AuthScreen$lambda$66$0;
                    AuthScreen$lambda$66$0 = AuthScreenKt.AuthScreen$lambda$66$0(FonRoApp.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return AuthScreen$lambda$66$0;
                }
            }, composer, 54), composer, 48, 1);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$66$0(final FonRoApp FonRoApp, ColumnScope OxList, Composer composer, int i) {
        String str;
        boolean z;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer2, "C*423@19465L41,424@19543L336,418@19188L713:AuthScreen.kt#1spzcc");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1558123506, i, -1, "uz.FonRo.pos.ui.auth.AuthScreen.<anonymous>.<anonymous> (AuthScreen.kt:416)");
            }
            int i2 = 0;
            for (Object obj : Lang.INSTANCE.getLANGUAGES()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final OxLanguage oxLanguage = (OxLanguage) obj;
                final boolean areEqual = Intrinsics.areEqual(Lang.INSTANCE.getCode(), oxLanguage.getCode());
                String title = oxLanguage.getTitle();
                String tx = LangKt.tx(oxLanguage.getHint(), new Object[0]);
                if (i2 < CollectionsKt.getLastIndex(Lang.INSTANCE.getLANGUAGES())) {
                    str = tx;
                    z = true;
                } else {
                    str = tx;
                    z = false;
                }
                Ox ox = Ox.INSTANCE;
                long m10220getPrimary0d7_KjU = areEqual ? ox.m10220getPrimary0d7_KjU() : ox.m10233getText0d7_KjU();
                ComposerKt.sourceInformationMarkerStart(composer2, 1659179405, "CC(remember):AuthScreen.kt#9igjgp");
                boolean changedInstance = composer2.changedInstance(FonRoApp) | composer2.changedInstance(oxLanguage);
                Object rememberedValue = composer2.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit AuthScreen$lambda$66$0$0$0$0;
                            AuthScreen$lambda$66$0$0$0$0 = AuthScreenKt.AuthScreen$lambda$66$0$0$0$0(FonRoApp.this, oxLanguage);
                            return AuthScreen$lambda$66$0$0$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BasicsKt.m9832OxRow1YH7lEI(title, null, str, (Function0) rememberedValue, z, m10220getPrimary0d7_KjU, null, ComposableLambdaKt.rememberComposableLambda(-269302373, true, new Function3() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit AuthScreen$lambda$66$0$0$1;
                        AuthScreen$lambda$66$0$0$1 = AuthScreenKt.AuthScreen$lambda$66$0$0$1(areEqual, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        return AuthScreen$lambda$66$0$0$1;
                    }
                }, composer2, 54), composer2, 12582912, 66);
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
    public static final Unit AuthScreen$lambda$66$0$0$0$0(FonRoApp FonRoApp, OxLanguage oxLanguage) {
        Lang.INSTANCE.apply(FonRoApp.getRepo().getPrefs(), oxLanguage.getCode());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$66$0$0$1(boolean z, RowScope OxRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxRow, "$this$OxRow");
        ComposerKt.sourceInformation(composer, "C:AuthScreen.kt#1spzcc");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-269302373, i, -1, "uz.FonRo.pos.ui.auth.AuthScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AuthScreen.kt:425)");
            }
            if (z) {
                composer.startReplaceGroup(211996603);
                ComposerKt.sourceInformation(composer, "426@19619L204");
                IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getOk(), LangKt.tx("Выбран", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(21.0f)), Ox.INSTANCE.m10211getOk0d7_KjU(), composer, 384, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(212222407);
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

    private static final void Brand(final String str, String str2, Composer composer, final int i) {
        int i2;
        final String str3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(2080769965);
        ComposerKt.sourceInformation(startRestartGroup, "C(Brand)P(1)442@20046L757:AuthScreen.kt#1spzcc");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changed(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            str3 = str2;
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2080769965, i3, -1, "uz.FonRo.pos.ui.auth.Brand (AuthScreen.kt:441)");
            }
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(22.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m930spacedBy0680j_4, centerHorizontally, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1053paddingqDBjuR0$default);
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
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 309982740, "C447@20241L392,458@20642L73,459@20724L73:AuthScreen.kt#1spzcc");
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(74.0f)), OxShape.INSTANCE.getCard()), Ox.INSTANCE.m10217getPanel0d7_KjU(), null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m558backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl2 = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 464283251, "C452@20425L39,451@20392L231:AuthScreen.kt#1spzcc");
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.splash_logo, startRestartGroup, 0), "FonRo", SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(58.0f)), (Alignment) null, ContentScale.INSTANCE.getFit(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, LocationRequestCompat.QUALITY_LOW_POWER);
            composer2 = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            TextStyle h2 = OxType.INSTANCE.getH2();
            long m6466getFontSizeXSAIIZE = OxType.INSTANCE.getH3().m6466getFontSizeXSAIIZE();
            TextUnitKt.m7196checkArithmeticR2X_6o(m6466getFontSizeXSAIIZE);
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(h2, 0L, TextUnitKt.pack(TextUnit.m7181getRawTypeimpl(m6466getFontSizeXSAIIZE), TextUnit.m7183getValueimpl(m6466getFontSizeXSAIIZE) * 1.3f), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), composer2, i3 & 14, 0, 65534);
            str3 = str2;
            TextKt.m2798Text4IGK_g(str3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), composer2, (i3 >> 3) & 14, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthScreenKt.Brand$lambda$1(str, str3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void Banner(final String str, final boolean z, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(2123325579);
        ComposerKt.sourceInformation(startRestartGroup, "C(Banner)P(1)465@20876L355:AuthScreen.kt#1spzcc");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changed(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2123325579, i2, -1, "uz.FonRo.pos.ui.auth.Banner (AuthScreen.kt:464)");
            }
            TextStyle body = OxType.INSTANCE.getBody();
            Ox ox = Ox.INSTANCE;
            TextStyle m6448copyp1EtxEg$default = TextStyle.m6448copyp1EtxEg$default(body, z ? ox.m10196getDanger0d7_KjU() : ox.m10211getOk0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
            Modifier clip = ClipKt.clip(PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), OxShape.INSTANCE.getTileSm());
            Ox ox2 = Ox.INSTANCE;
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, PaddingKt.m1050paddingVpY3zN4(BackgroundKt.m558backgroundbw27NRU$default(clip, z ? ox2.m10198getDangerSoft0d7_KjU() : ox2.m10212getOkSoft0d7_KjU(), null, 2, null), Dp.m6989constructorimpl(14.0f), Dp.m6989constructorimpl(11.0f)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m6448copyp1EtxEg$default, composer2, i2 & 14, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthScreenKt.Banner$lambda$0(str, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r14v2 */
    private static final void LoginTabs(final LoginMode loginMode, final Function1<? super LoginMode, Unit> function1, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-2040448070);
        ComposerKt.sourceInformation(startRestartGroup, "C(LoginTabs)479@21323L1024:AuthScreen.kt#1spzcc");
        int i2 = 2;
        int i3 = (i & 6) == 0 ? (startRestartGroup.changed(loginMode.ordinal()) ? 4 : 2) | i : i;
        int i4 = 32;
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i5 = i3;
        boolean z = 0;
        if (!startRestartGroup.shouldExecute((i5 & 19) != 18, i5 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2040448070, i5, -1, "uz.FonRo.pos.ui.auth.LoginTabs (AuthScreen.kt:478)");
            }
            float f = 0.0f;
            Modifier m1049padding3ABfNKs = PaddingKt.m1049padding3ABfNKs(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getTile()), Ox.INSTANCE.m10229getSegTrack0d7_KjU(), null, 2, null), Dp.m6989constructorimpl(4.0f));
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(6.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
            String str = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1049padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i6 = i5;
            boolean z2 = true;
            String str2 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
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
            Updater.m3815setimpl(m3808constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -880055479, "C:AuthScreen.kt#1spzcc");
            startRestartGroup.startReplaceGroup(525803418);
            ComposerKt.sourceInformation(startRestartGroup, "*495@21955L19,495@21949L25,490@21728L599");
            for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(LoginMode.EMAIL, LangKt.tx("Владелец", new Object[0])), TuplesKt.to(LoginMode.KEY, LangKt.tx("Сотрудник · ключ", new Object[0]))})) {
                final LoginMode loginMode2 = (LoginMode) pair.component1();
                String str3 = (String) pair.component2();
                boolean z3 = loginMode2 == loginMode ? z2 : z;
                RowScopeInstance rowScopeInstance2 = rowScopeInstance;
                Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), OxShape.INSTANCE.getBtnSm()), z3 ? Ox.INSTANCE.m10217getPanel0d7_KjU() : Color.INSTANCE.m4419getTransparent0d7_KjU(), null, 2, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 908652618, "CC(remember):AuthScreen.kt#9igjgp");
                boolean changed = ((i6 & 112) == i4 ? z2 : z) | startRestartGroup.changed(loginMode2.ordinal());
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit LoginTabs$lambda$0$0$0$0;
                            LoginTabs$lambda$0$0$0$0 = AuthScreenKt.LoginTabs$lambda$0$0$0$0(Function1.this, loginMode2);
                            return LoginTabs$lambda$0$0$0$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                String str4 = str;
                Modifier m1084heightInVpY3zN4$default = SizeKt.m1084heightInVpY3zN4$default(ModifiersKt.oxTap(m558backgroundbw27NRU$default, false, (Function0) rememberedValue, startRestartGroup, 0, 1), Dp.m6989constructorimpl(44.0f), f, i2, null);
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, z);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, str4);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, z);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m1084heightInVpY3zN4$default);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, str2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3808constructorimpl2 = Updater.m3808constructorimpl(startRestartGroup);
                Updater.m3815setimpl(m3808constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -122749900, "C499@22119L190:AuthScreen.kt#1spzcc");
                TextStyle label = OxType.INSTANCE.getLabel();
                Ox ox = Ox.INSTANCE;
                Composer composer2 = startRestartGroup;
                TextKt.m2798Text4IGK_g(str3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(label, z3 ? ox.m10220getPrimary0d7_KjU() : ox.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer2, 0, 3072, 57342);
                startRestartGroup = composer2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                rowScopeInstance = rowScopeInstance2;
                str = str4;
                i6 = i6;
                f = f;
                i2 = 2;
                i4 = 32;
                str2 = str2;
                z2 = z2;
                z = z;
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthScreenKt.LoginTabs$lambda$1(LoginMode.this, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginTabs$lambda$0$0$0$0(Function1 function1, LoginMode loginMode) {
        function1.invoke(loginMode);
        return Unit.INSTANCE;
    }

    private static final void LinkButton(final String str, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1997467301);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinkButton)P(1)516@22576L24,511@22427L237:AuthScreen.kt#1spzcc");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changed(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997467301, i3, -1, "uz.FonRo.pos.ui.auth.LinkButton (AuthScreen.kt:510)");
            }
            TextKt.m2798Text4IGK_g(str, PaddingKt.m1050paddingVpY3zN4(ModifiersKt.oxTap(ClipKt.clip(Modifier.INSTANCE, OxShape.INSTANCE.getBtnSm()), false, function0, startRestartGroup, (i3 << 3) & 896, 1), Dp.m6989constructorimpl(8.0f), Dp.m6989constructorimpl(10.0f)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getLabel(), Ox.INSTANCE.m10220getPrimary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, i3 & 14, 0, 65532);
            startRestartGroup = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.auth.AuthScreenKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthScreenKt.LinkButton$lambda$0(str, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String formatAccessKey(String str) {
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String str2 = upperCase;
        StringBuilder sb = new StringBuilder();
        int length = str2.length();
        for (int i = 0; i < length; i++) {
            char charAt = str2.charAt(i);
            if (Character.isLetterOrDigit(charAt)) {
                sb.append(charAt);
            }
        }
        String take = StringsKt.take(sb.toString(), 18);
        if (take.length() <= 2) {
            return take;
        }
        String substring = take.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        String substring2 = take.substring(2);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        return CollectionsKt.joinToString$default(CollectionsKt.plus((Collection) CollectionsKt.listOf(substring), (Iterable) StringsKt.chunked(substring2, 4)), "-", null, null, 0, null, null, 62, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthScreen$lambda$64$0$13$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String str = it;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        mutableState.setValue(StringsKt.take(sb.toString(), 6));
        return Unit.INSTANCE;
    }
}
