package androidx.compose.ui.text.font;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000e\u0010 \u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u0005H\u0080@¢\u0006\u0004\b#\u0010$R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006%"}, d2 = {"Landroidx/compose/ui/text/font/AsyncFontListLoader;", "Landroidx/compose/runtime/State;", "", "fontList", "", "Landroidx/compose/ui/text/font/Font;", "initialType", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "onCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "(Ljava/util/List;Ljava/lang/Object;Landroidx/compose/ui/text/font/TypefaceRequest;Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/font/PlatformFontLoader;)V", "cacheable", "", "getCacheable$ui_text_release", "()Z", "setCacheable$ui_text_release", "(Z)V", "<set-?>", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "load", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadWithTimeoutOrNull", "loadWithTimeoutOrNull$ui_text_release", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class AsyncFontListLoader implements State<Object> {
    public static final int $stable = 0;
    private final AsyncTypefaceCache asyncTypefaceCache;
    private boolean cacheable;
    private final List<Font> fontList;
    private final Function1<TypefaceResult.Immutable, Unit> onCompletion;
    private final PlatformFontLoader platformFontLoader;
    private final TypefaceRequest typefaceRequest;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableState value;

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncFontListLoader(List<? extends Font> list, Object obj, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, Function1<? super TypefaceResult.Immutable, Unit> function1, PlatformFontLoader platformFontLoader) {
        MutableState mutableStateOf$default;
        this.fontList = list;
        this.typefaceRequest = typefaceRequest;
        this.asyncTypefaceCache = asyncTypefaceCache;
        this.onCompletion = function1;
        this.platformFontLoader = platformFontLoader;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
        this.value = mutableStateOf$default;
        this.cacheable = true;
    }

    private void setValue(Object obj) {
        this.value.setValue(obj);
    }

    @Override // androidx.compose.runtime.State
    public Object getValue() {
        return this.value.getValue();
    }

    /* renamed from: getCacheable$ui_text_release, reason: from getter */
    public final boolean getCacheable() {
        return this.cacheable;
    }

    public final void setCacheable$ui_text_release(boolean z) {
        this.cacheable = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b4 A[Catch: all -> 0x0129, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0129, blocks: (B:26:0x00b4, B:35:0x00e8, B:55:0x0069), top: B:54:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e8 A[Catch: all -> 0x0129, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0129, blocks: (B:26:0x00b4, B:35:0x00e8, B:55:0x0069), top: B:54:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008b -> B:14:0x0105). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00fb -> B:13:0x0100). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object load(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncFontListLoader.load(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadWithTimeoutOrNull$ui_text_release(androidx.compose.ui.text.font.Font r6, kotlin.coroutines.Continuation<java.lang.Object> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1 r0 = (androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1 r0 = new androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$0
            r6 = r5
            androidx.compose.ui.text.font.Font r6 = (androidx.compose.ui.text.font.Font) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L50 java.util.concurrent.CancellationException -> L80
            return r7
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$2 r7 = new androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$2     // Catch: java.lang.Exception -> L50 java.util.concurrent.CancellationException -> L80
            r7.<init>(r5, r6, r4)     // Catch: java.lang.Exception -> L50 java.util.concurrent.CancellationException -> L80
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.lang.Exception -> L50 java.util.concurrent.CancellationException -> L80
            r0.L$0 = r6     // Catch: java.lang.Exception -> L50 java.util.concurrent.CancellationException -> L80
            r0.label = r3     // Catch: java.lang.Exception -> L50 java.util.concurrent.CancellationException -> L80
            r2 = 15000(0x3a98, double:7.411E-320)
            java.lang.Object r5 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r2, r7, r0)     // Catch: java.lang.Exception -> L50 java.util.concurrent.CancellationException -> L80
            if (r5 != r1) goto L4f
            return r1
        L4f:
            return r5
        L50:
            r5 = move-exception
            kotlin.coroutines.CoroutineContext r7 = r0.get$context()
            kotlinx.coroutines.CoroutineExceptionHandler$Key r1 = kotlinx.coroutines.CoroutineExceptionHandler.INSTANCE
            kotlin.coroutines.CoroutineContext$Key r1 = (kotlin.coroutines.CoroutineContext.Key) r1
            kotlin.coroutines.CoroutineContext$Element r7 = r7.get(r1)
            kotlinx.coroutines.CoroutineExceptionHandler r7 = (kotlinx.coroutines.CoroutineExceptionHandler) r7
            if (r7 == 0) goto L8b
            kotlin.coroutines.CoroutineContext r0 = r0.get$context()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unable to load font "
            r2.<init>(r3)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r1.<init>(r6, r5)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            r7.handleException(r0, r1)
            goto L8b
        L80:
            r5 = move-exception
            kotlin.coroutines.CoroutineContext r6 = r0.get$context()
            boolean r6 = kotlinx.coroutines.JobKt.isActive(r6)
            if (r6 == 0) goto L8c
        L8b:
            return r4
        L8c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncFontListLoader.loadWithTimeoutOrNull$ui_text_release(androidx.compose.ui.text.font.Font, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
