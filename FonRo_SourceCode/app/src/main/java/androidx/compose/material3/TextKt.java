package androidx.compose.material3;

import androidx.compose.material3.tokens.TypographyTokensKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.text.TextStyle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: Text.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aæ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001aÜ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aÆ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aÒ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00106\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<TextStyle>() { // from class: androidx.compose.material3.TextKt$LocalTextStyle$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextStyle invoke() {
            return TypographyTokensKt.getDefaultTextStyle();
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:103:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0382  */
    /* renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2798Text4IGK_g(final java.lang.String r67, androidx.compose.ui.Modifier r68, long r69, long r71, androidx.compose.ui.text.font.FontStyle r73, androidx.compose.ui.text.font.FontWeight r74, androidx.compose.ui.text.font.FontFamily r75, long r76, androidx.compose.ui.text.style.TextDecoration r78, androidx.compose.ui.text.style.TextAlign r79, long r80, int r82, boolean r83, int r84, int r85, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r86, androidx.compose.ui.text.TextStyle r87, androidx.compose.runtime.Composer r88, final int r89, final int r90, final int r91) {
        /*
            Method dump skipped, instructions count: 1132
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m2798Text4IGK_g(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02a6  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text-fLXpl1I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m2800TextfLXpl1I(final java.lang.String r41, androidx.compose.ui.Modifier r42, long r43, long r45, androidx.compose.ui.text.font.FontStyle r47, androidx.compose.ui.text.font.FontWeight r48, androidx.compose.ui.text.font.FontFamily r49, long r50, androidx.compose.ui.text.style.TextDecoration r52, androidx.compose.ui.text.style.TextAlign r53, long r54, int r56, boolean r57, int r58, kotlin.jvm.functions.Function1 r59, androidx.compose.ui.text.TextStyle r60, androidx.compose.runtime.Composer r61, final int r62, final int r63, final int r64) {
        /*
            Method dump skipped, instructions count: 946
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m2800TextfLXpl1I(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03ed  */
    /* renamed from: Text-IbK3jfQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2799TextIbK3jfQ(final androidx.compose.ui.text.AnnotatedString r60, androidx.compose.ui.Modifier r61, long r62, long r64, androidx.compose.ui.text.font.FontStyle r66, androidx.compose.ui.text.font.FontWeight r67, androidx.compose.ui.text.font.FontFamily r68, long r69, androidx.compose.ui.text.style.TextDecoration r71, androidx.compose.ui.text.style.TextAlign r72, long r73, int r75, boolean r76, int r77, int r78, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r79, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r80, androidx.compose.ui.text.TextStyle r81, androidx.compose.runtime.Composer r82, final int r83, final int r84, final int r85) {
        /*
            Method dump skipped, instructions count: 1188
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m2799TextIbK3jfQ(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02c6  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m2797Text4IGK_g(final androidx.compose.ui.text.AnnotatedString r44, androidx.compose.ui.Modifier r45, long r46, long r48, androidx.compose.ui.text.font.FontStyle r50, androidx.compose.ui.text.font.FontWeight r51, androidx.compose.ui.text.font.FontFamily r52, long r53, androidx.compose.ui.text.style.TextDecoration r55, androidx.compose.ui.text.style.TextAlign r56, long r57, int r59, boolean r60, int r61, java.util.Map r62, kotlin.jvm.functions.Function1 r63, androidx.compose.ui.text.TextStyle r64, androidx.compose.runtime.Composer r65, final int r66, final int r67, final int r68) {
        /*
            Method dump skipped, instructions count: 993
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m2797Text4IGK_g(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    public static final void ProvideTextStyle(final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-460300127);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProvideTextStyle)P(1)347@14710L7,348@14735L80:Text.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(textStyle) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-460300127, i2, -1, "androidx.compose.material3.ProvideTextStyle (Text.kt:346)");
            }
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(((TextStyle) consume).merge(textStyle)), function2, startRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$ProvideTextStyle$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    TextKt.ProvideTextStyle(TextStyle.this, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
