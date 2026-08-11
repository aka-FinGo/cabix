package androidx.lifecycle.compose;

import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;

/* compiled from: LocalLifecycleOwner.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001d\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"LocalLifecycleOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/lifecycle/LifecycleOwner;", "getLocalLifecycleOwner$annotations", "()V", "getLocalLifecycleOwner", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "lifecycle-runtime-compose_release"}, k = 2, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class LocalLifecycleOwnerKt {
    private static final ProvidableCompositionLocal<LifecycleOwner> LocalLifecycleOwner;

    public static /* synthetic */ void getLocalLifecycleOwner$annotations() {
    }

    public static final ProvidableCompositionLocal<LifecycleOwner> getLocalLifecycleOwner() {
        return LocalLifecycleOwner;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
    
        r1 = null;
     */
    static {
        /*
            r0 = 0
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3a
            java.lang.Class<androidx.lifecycle.LifecycleOwner> r1 = androidx.lifecycle.LifecycleOwner.class
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch: java.lang.Throwable -> L3a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r2 = "androidx.compose.ui.platform.AndroidCompositionLocals_androidKt"
            java.lang.String r3 = "getLocalLifecycleOwner"
            java.lang.Class r1 = r1.loadClass(r2)     // Catch: java.lang.Throwable -> L3a
            java.lang.reflect.Method r1 = r1.getMethod(r3, r0)     // Catch: java.lang.Throwable -> L3a
            java.lang.annotation.Annotation[] r2 = r1.getAnnotations()     // Catch: java.lang.Throwable -> L3a
            int r3 = r2.length     // Catch: java.lang.Throwable -> L3a
            r4 = 0
        L1e:
            if (r4 >= r3) goto L2b
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5 instanceof kotlin.Deprecated     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L28
        L26:
            r1 = r0
            goto L35
        L28:
            int r4 = r4 + 1
            goto L1e
        L2b:
            java.lang.Object r1 = r1.invoke(r0, r0)     // Catch: java.lang.Throwable -> L3a
            boolean r2 = r1 instanceof androidx.compose.runtime.ProvidableCompositionLocal     // Catch: java.lang.Throwable -> L3a
            if (r2 == 0) goto L26
            androidx.compose.runtime.ProvidableCompositionLocal r1 = (androidx.compose.runtime.ProvidableCompositionLocal) r1     // Catch: java.lang.Throwable -> L3a
        L35:
            java.lang.Object r1 = kotlin.Result.m7870constructorimpl(r1)     // Catch: java.lang.Throwable -> L3a
            goto L45
        L3a:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r1 = kotlin.Result.m7870constructorimpl(r1)
        L45:
            boolean r2 = kotlin.Result.m7876isFailureimpl(r1)
            if (r2 == 0) goto L4c
            goto L4d
        L4c:
            r0 = r1
        L4d:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = (androidx.compose.runtime.ProvidableCompositionLocal) r0
            if (r0 != 0) goto L5a
            androidx.lifecycle.compose.LocalLifecycleOwnerKt$$ExternalSyntheticLambda0 r0 = new androidx.lifecycle.compose.LocalLifecycleOwnerKt$$ExternalSyntheticLambda0
            r0.<init>()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.runtime.CompositionLocalKt.staticCompositionLocalOf(r0)
        L5a:
            androidx.lifecycle.compose.LocalLifecycleOwnerKt.LocalLifecycleOwner = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LocalLifecycleOwnerKt.<clinit>():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LifecycleOwner LocalLifecycleOwner$lambda$3$lambda$2() {
        throw new IllegalStateException("CompositionLocal LocalLifecycleOwner not present".toString());
    }
}
