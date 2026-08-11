package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* compiled from: AndroidFontLoader.android.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/font/AndroidFontLoader;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "kotlin.jvm.PlatformType", "awaitLoad", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBlocking", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class AndroidFontLoader implements PlatformFontLoader {
    public static final int $stable = 8;
    private final Object cacheKey;
    private final Context context;

    public AndroidFontLoader(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public android.graphics.Typeface loadBlocking(Font font) {
        Object m7870constructorimpl;
        android.graphics.Typeface typeface;
        android.graphics.Typeface load;
        if (font instanceof AndroidFont) {
            AndroidFont androidFont = (AndroidFont) font;
            return androidFont.getTypefaceLoader().loadBlocking(this.context, androidFont);
        }
        if (!(font instanceof ResourceFont)) {
            return null;
        }
        int loadingStrategy = font.getLoadingStrategy();
        if (FontLoadingStrategy.m6553equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m6558getBlockingPKNRLFQ())) {
            typeface = AndroidFontLoader_androidKt.load((ResourceFont) font, this.context);
        } else if (FontLoadingStrategy.m6553equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m6559getOptionalLocalPKNRLFQ())) {
            try {
                Result.Companion companion = Result.INSTANCE;
                AndroidFontLoader androidFontLoader = this;
                load = AndroidFontLoader_androidKt.load((ResourceFont) font, this.context);
                m7870constructorimpl = Result.m7870constructorimpl(load);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
            }
            typeface = (android.graphics.Typeface) (Result.m7876isFailureimpl(m7870constructorimpl) ? null : m7870constructorimpl);
        } else {
            if (FontLoadingStrategy.m6553equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m6557getAsyncPKNRLFQ())) {
                throw new UnsupportedOperationException("Unsupported Async font load path");
            }
            throw new IllegalArgumentException("Unknown loading type " + ((Object) FontLoadingStrategy.m6555toStringimpl(font.getLoadingStrategy())));
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings(typeface, ((ResourceFont) font).getVariationSettings(), this.context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
    
        if (r7 == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object awaitLoad(androidx.compose.ui.text.font.Font r6, kotlin.coroutines.Continuation<? super android.graphics.Typeface> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1 r0 = (androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1 r0 = new androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r5 = r0.L$1
            r6 = r5
            androidx.compose.ui.text.font.Font r6 = (androidx.compose.ui.text.font.Font) r6
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.text.font.AndroidFontLoader r5 = (androidx.compose.ui.text.font.AndroidFontLoader) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L71
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            kotlin.ResultKt.throwOnFailure(r7)
            return r7
        L42:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r6 instanceof androidx.compose.ui.text.font.AndroidFont
            if (r7 == 0) goto L5b
            androidx.compose.ui.text.font.AndroidFont r6 = (androidx.compose.ui.text.font.AndroidFont) r6
            androidx.compose.ui.text.font.AndroidFont$TypefaceLoader r7 = r6.getTypefaceLoader()
            android.content.Context r5 = r5.context
            r0.label = r4
            java.lang.Object r5 = r7.awaitLoad(r5, r6, r0)
            if (r5 != r1) goto L5a
            goto L70
        L5a:
            return r5
        L5b:
            boolean r7 = r6 instanceof androidx.compose.ui.text.font.ResourceFont
            if (r7 == 0) goto L80
            r7 = r6
            androidx.compose.ui.text.font.ResourceFont r7 = (androidx.compose.ui.text.font.ResourceFont) r7
            android.content.Context r2 = r5.context
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = androidx.compose.ui.text.font.AndroidFontLoader_androidKt.access$loadAsync(r7, r2, r0)
            if (r7 != r1) goto L71
        L70:
            return r1
        L71:
            android.graphics.Typeface r7 = (android.graphics.Typeface) r7
            androidx.compose.ui.text.font.ResourceFont r6 = (androidx.compose.ui.text.font.ResourceFont) r6
            androidx.compose.ui.text.font.FontVariation$Settings r6 = r6.getVariationSettings()
            android.content.Context r5 = r5.context
            android.graphics.Typeface r5 = androidx.compose.ui.text.font.PlatformTypefaces_androidKt.setFontVariationSettings(r7, r6, r5)
            return r5
        L80:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Unknown font type: "
            r7.<init>(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AndroidFontLoader.awaitLoad(androidx.compose.ui.text.font.Font, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object getCacheKey() {
        return this.cacheKey;
    }
}
