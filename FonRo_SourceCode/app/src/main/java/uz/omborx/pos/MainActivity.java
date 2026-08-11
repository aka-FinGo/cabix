package uz.FonRo.pos;

import android.app.Application;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.core.TextScale;
import uz.FonRo.pos.core.TextScaleKt;
import uz.FonRo.pos.core.UpdateGateKt;
import uz.FonRo.pos.scan.HardwareScanner;
import uz.FonRo.pos.ui.AppRootKt;
import uz.FonRo.pos.ui.nav.PendingRoute;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxTheme;
import uz.FonRo.pos.ui.theme.ThemeKt;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0011"}, d2 = {"Luz/FonRo/pos/MainActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "notificationsPermission", "Landroidx/activity/result/ActivityResultLauncher;", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "applyEdgeToEdge", "onStart", "onStop", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MainActivity extends ComponentActivity {
    public static final int $stable = 8;
    private final ActivityResultLauncher<String> notificationsPermission = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: uz.FonRo.pos.MainActivity$$ExternalSyntheticLambda0
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            MainActivity.notificationsPermission$lambda$0(((Boolean) obj).booleanValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean applyEdgeToEdge$lambda$0(boolean z, Resources it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean applyEdgeToEdge$lambda$1(boolean z, Resources it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void notificationsPermission$lambda$0(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_FonRo);
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 33) {
            this.notificationsPermission.launch("android.permission.POST_NOTIFICATIONS");
        }
        PendingRoute.INSTANCE.offer(getIntent());
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type uz.FonRo.pos.FonRoApp");
        final FonRoApp FonRoApp = (FonRoApp) application;
        TextScale.INSTANCE.load(FonRoApp.getRepo().getPrefs(), getResources().getConfiguration().fontScale);
        OxTheme.INSTANCE.load(FonRoApp.getRepo().getPrefs());
        OxTheme.INSTANCE.setSystemDark((getResources().getConfiguration().uiMode & 48) == 32);
        getWindow().setBackgroundDrawable(new ColorDrawable(ColorKt.m4438toArgb8_81llA(Ox.INSTANCE.m10185getBg0d7_KjU())));
        applyEdgeToEdge();
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(551447576, true, new Function2() { // from class: uz.FonRo.pos.MainActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MainActivity.onCreate$lambda$0(MainActivity.this, FonRoApp, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$0(final MainActivity mainActivity, final FonRoApp FonRoApp, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C75@3341L1159,75@3329L1171:MainActivity.kt#296v40");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(551447576, i, -1, "uz.FonRo.pos.MainActivity.onCreate.<anonymous> (MainActivity.kt:75)");
            }
            ThemeKt.FonRoTheme(ComposableLambdaKt.rememberComposableLambda(-1451352725, true, new Function2() { // from class: uz.FonRo.pos.MainActivity$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreate$lambda$0$0;
                    onCreate$lambda$0$0 = MainActivity.onCreate$lambda$0$0(MainActivity.this, FonRoApp, (Composer) obj, ((Integer) obj2).intValue());
                    return onCreate$lambda$0$0;
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0(MainActivity mainActivity, final FonRoApp FonRoApp, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C80@3661L135,80@3635L161,91@4261L225,91@4248L238:MainActivity.kt#296v40");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1451352725, i, -1, "uz.FonRo.pos.MainActivity.onCreate.<anonymous>.<anonymous> (MainActivity.kt:79)");
            }
            Boolean valueOf = Boolean.valueOf(Ox.INSTANCE.isDark());
            ComposerKt.sourceInformationMarkerStart(composer, 1114412850, "CC(remember):MainActivity.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(mainActivity);
            MainActivity$onCreate$1$1$1$1 rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MainActivity$onCreate$1$1$1$1(mainActivity, null);
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, composer, 0);
            TextScaleKt.OxTextScaled(ComposableLambdaKt.rememberComposableLambda(-1807365592, true, new Function2() { // from class: uz.FonRo.pos.MainActivity$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreate$lambda$0$0$1;
                    onCreate$lambda$0$0$1 = MainActivity.onCreate$lambda$0$0$1(FonRoApp.this, (Composer) obj, ((Integer) obj2).intValue());
                    return onCreate$lambda$0$0$1;
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$1(FonRoApp FonRoApp, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C92@4283L12,95@4448L20:MainActivity.kt#296v40");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1807365592, i, -1, "uz.FonRo.pos.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:92)");
            }
            AppRootKt.AppRoot(FonRoApp, composer, FonRoApp.$stable);
            UpdateGateKt.UpdateRequiredGate(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        PendingRoute.INSTANCE.offer(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyEdgeToEdge() {
        final boolean isDark = Ox.INSTANCE.isDark();
        EdgeToEdge.enable(this, SystemBarStyle.INSTANCE.auto(0, 0, new Function1() { // from class: uz.FonRo.pos.MainActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(MainActivity.applyEdgeToEdge$lambda$0(isDark, (Resources) obj));
            }
        }), SystemBarStyle.INSTANCE.auto(0, 0, new Function1() { // from class: uz.FonRo.pos.MainActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(MainActivity.applyEdgeToEdge$lambda$1(isDark, (Resources) obj));
            }
        }));
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        insetsController.setAppearanceLightStatusBars(!isDark);
        insetsController.setAppearanceLightNavigationBars(!isDark);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        HardwareScanner.INSTANCE.register(this);
    }

    @Override // android.app.Activity
    protected void onStop() {
        HardwareScanner.INSTANCE.unregister(this);
        super.onStop();
    }
}
