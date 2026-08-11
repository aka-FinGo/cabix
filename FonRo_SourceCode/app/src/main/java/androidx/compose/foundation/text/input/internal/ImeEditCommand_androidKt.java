package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldBufferKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* compiled from: ImeEditCommand.android.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u001c\u0010\f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0000\u001a\u001c\u0010\u000f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0000\u001a\f\u0010\u0010\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\u001c\u0010\u0011\u001a\u00020\u0006*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0001\u001a$\u0010\u0015\u001a\u00020\u0006*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0016H\u0001\u001a\u001c\u0010\u0017\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0000\u001a8\u0010\u0018\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u001a\b\u0002\u0010\u0019\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u001c0\u001bj\u0002`\u001d\u0018\u00010\u001aH\u0000\u001a\u001c\u0010\u001e\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0000¨\u0006\u001f"}, d2 = {"isSurrogatePair", "", "high", "", "low", "commitText", "", "Landroidx/compose/foundation/text/input/internal/ImeEditCommandScope;", "text", "", "newCursorPosition", "", "deleteSurroundingText", "lengthBeforeCursor", "lengthAfterCursor", "deleteSurroundingTextInCodePoints", "finishComposingText", "imeDelete", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "start", "end", "imeReplace", "", "setComposingRegion", "setComposingText", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "setSelection", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ImeEditCommand_androidKt {
    public static final void commitText(ImeEditCommandScope imeEditCommandScope, final String str, final int i) {
        imeEditCommandScope.edit(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$commitText$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldBuffer textFieldBuffer) {
                invoke2(textFieldBuffer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldBuffer textFieldBuffer) {
                TextRange composition = textFieldBuffer.getComposition();
                if (composition != null) {
                    ImeEditCommand_androidKt.imeReplace(textFieldBuffer, TextRange.m6435getStartimpl(composition.getPackedValue()), TextRange.m6430getEndimpl(composition.getPackedValue()), str);
                } else {
                    ImeEditCommand_androidKt.imeReplace(textFieldBuffer, TextRange.m6435getStartimpl(textFieldBuffer.getSelectionInChars()), TextRange.m6430getEndimpl(textFieldBuffer.getSelectionInChars()), str);
                }
                int m6435getStartimpl = TextRange.m6435getStartimpl(textFieldBuffer.getSelectionInChars());
                int i2 = i;
                textFieldBuffer.m1506setSelection5zctL8(TextRangeKt.TextRange(RangesKt.coerceIn(i2 > 0 ? (m6435getStartimpl + i2) - 1 : (m6435getStartimpl + i2) - str.length(), 0, textFieldBuffer.getLength())));
            }
        });
    }

    public static final void setComposingRegion(ImeEditCommandScope imeEditCommandScope, final int i, final int i2) {
        imeEditCommandScope.edit(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$setComposingRegion$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldBuffer textFieldBuffer) {
                invoke2(textFieldBuffer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldBuffer textFieldBuffer) {
                if (textFieldBuffer.hasComposition$foundation_release()) {
                    textFieldBuffer.commitComposition$foundation_release();
                }
                int coerceIn = RangesKt.coerceIn(i, 0, textFieldBuffer.getLength());
                int coerceIn2 = RangesKt.coerceIn(i2, 0, textFieldBuffer.getLength());
                if (coerceIn != coerceIn2) {
                    if (coerceIn < coerceIn2) {
                        TextFieldBuffer.setComposition$foundation_release$default(textFieldBuffer, coerceIn, coerceIn2, null, 4, null);
                    } else {
                        TextFieldBuffer.setComposition$foundation_release$default(textFieldBuffer, coerceIn2, coerceIn, null, 4, null);
                    }
                }
            }
        });
    }

    public static /* synthetic */ void setComposingText$default(ImeEditCommandScope imeEditCommandScope, String str, int i, List list, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            list = null;
        }
        setComposingText(imeEditCommandScope, str, i, list);
    }

    public static final void setComposingText(ImeEditCommandScope imeEditCommandScope, final String str, final int i, final List<AnnotatedString.Range<AnnotatedString.Annotation>> list) {
        imeEditCommandScope.edit(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$setComposingText$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldBuffer textFieldBuffer) {
                invoke2(textFieldBuffer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldBuffer textFieldBuffer) {
                TextRange composition = textFieldBuffer.getComposition();
                if (composition != null) {
                    ImeEditCommand_androidKt.imeReplace(textFieldBuffer, TextRange.m6435getStartimpl(composition.getPackedValue()), TextRange.m6430getEndimpl(composition.getPackedValue()), str);
                    if (str.length() > 0) {
                        textFieldBuffer.setComposition$foundation_release(TextRange.m6435getStartimpl(composition.getPackedValue()), TextRange.m6435getStartimpl(composition.getPackedValue()) + str.length(), list);
                    }
                } else {
                    int m6435getStartimpl = TextRange.m6435getStartimpl(textFieldBuffer.getSelectionInChars());
                    ImeEditCommand_androidKt.imeReplace(textFieldBuffer, m6435getStartimpl, TextRange.m6430getEndimpl(textFieldBuffer.getSelectionInChars()), str);
                    if (str.length() > 0) {
                        textFieldBuffer.setComposition$foundation_release(m6435getStartimpl, str.length() + m6435getStartimpl, list);
                    }
                }
                int m6435getStartimpl2 = TextRange.m6435getStartimpl(textFieldBuffer.getSelectionInChars());
                int i2 = i;
                textFieldBuffer.m1506setSelection5zctL8(TextRangeKt.TextRange(RangesKt.coerceIn(i2 > 0 ? (m6435getStartimpl2 + i2) - 1 : (m6435getStartimpl2 + i2) - str.length(), 0, textFieldBuffer.getLength())));
            }
        });
    }

    public static final void deleteSurroundingText(ImeEditCommandScope imeEditCommandScope, final int i, final int i2) {
        imeEditCommandScope.edit(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$deleteSurroundingText$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldBuffer textFieldBuffer) {
                invoke2(textFieldBuffer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldBuffer textFieldBuffer) {
                int i3 = i;
                boolean z = i3 >= 0 && i2 >= 0;
                int i4 = i2;
                if (!z) {
                    InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i3 + " and " + i4 + " respectively.");
                }
                int m6430getEndimpl = TextRange.m6430getEndimpl(textFieldBuffer.getSelectionInChars());
                int i5 = i2;
                int i6 = m6430getEndimpl + i5;
                if (((m6430getEndimpl ^ i6) & (i5 ^ i6)) < 0) {
                    i6 = textFieldBuffer.getLength();
                }
                ImeEditCommand_androidKt.imeDelete(textFieldBuffer, TextRange.m6430getEndimpl(textFieldBuffer.getSelectionInChars()), Math.min(i6, textFieldBuffer.getLength()));
                int m6435getStartimpl = TextRange.m6435getStartimpl(textFieldBuffer.getSelectionInChars());
                int i7 = i;
                int i8 = m6435getStartimpl - i7;
                if (((i7 ^ m6435getStartimpl) & (m6435getStartimpl ^ i8)) < 0) {
                    i8 = 0;
                }
                ImeEditCommand_androidKt.imeDelete(textFieldBuffer, Math.max(0, i8), TextRange.m6435getStartimpl(textFieldBuffer.getSelectionInChars()));
            }
        });
    }

    public static final void deleteSurroundingTextInCodePoints(ImeEditCommandScope imeEditCommandScope, final int i, final int i2) {
        imeEditCommandScope.edit(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$deleteSurroundingTextInCodePoints$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldBuffer textFieldBuffer) {
                invoke2(textFieldBuffer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldBuffer textFieldBuffer) {
                boolean isSurrogatePair;
                boolean isSurrogatePair2;
                int i3 = i;
                int i4 = 0;
                boolean z = i3 >= 0 && i2 >= 0;
                int i5 = i2;
                if (!z) {
                    InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i3 + " and " + i5 + " respectively.");
                }
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    if (i6 < i) {
                        int i8 = i7 + 1;
                        if (TextRange.m6435getStartimpl(textFieldBuffer.getSelectionInChars()) > i8) {
                            isSurrogatePair2 = ImeEditCommand_androidKt.isSurrogatePair(textFieldBuffer.asCharSequence().charAt((TextRange.m6435getStartimpl(textFieldBuffer.getSelectionInChars()) - i8) - 1), textFieldBuffer.asCharSequence().charAt(TextRange.m6435getStartimpl(textFieldBuffer.getSelectionInChars()) - i8));
                            i7 = isSurrogatePair2 ? i7 + 2 : i8;
                            i6++;
                        } else {
                            i7 = TextRange.m6435getStartimpl(textFieldBuffer.getSelectionInChars());
                            break;
                        }
                    } else {
                        break;
                    }
                }
                int i9 = 0;
                while (true) {
                    if (i4 >= i2) {
                        break;
                    }
                    int i10 = i9 + 1;
                    if (TextRange.m6430getEndimpl(textFieldBuffer.getSelectionInChars()) + i10 < textFieldBuffer.getLength()) {
                        isSurrogatePair = ImeEditCommand_androidKt.isSurrogatePair(textFieldBuffer.asCharSequence().charAt((TextRange.m6430getEndimpl(textFieldBuffer.getSelectionInChars()) + i10) - 1), textFieldBuffer.asCharSequence().charAt(TextRange.m6430getEndimpl(textFieldBuffer.getSelectionInChars()) + i10));
                        i9 = isSurrogatePair ? i9 + 2 : i10;
                        i4++;
                    } else {
                        i9 = textFieldBuffer.getLength() - TextRange.m6430getEndimpl(textFieldBuffer.getSelectionInChars());
                        break;
                    }
                }
                ImeEditCommand_androidKt.imeDelete(textFieldBuffer, TextRange.m6430getEndimpl(textFieldBuffer.getSelectionInChars()), TextRange.m6430getEndimpl(textFieldBuffer.getSelectionInChars()) + i9);
                ImeEditCommand_androidKt.imeDelete(textFieldBuffer, TextRange.m6435getStartimpl(textFieldBuffer.getSelectionInChars()) - i7, TextRange.m6435getStartimpl(textFieldBuffer.getSelectionInChars()));
            }
        });
    }

    public static final void finishComposingText(ImeEditCommandScope imeEditCommandScope) {
        imeEditCommandScope.edit(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$finishComposingText$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldBuffer textFieldBuffer) {
                invoke2(textFieldBuffer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldBuffer textFieldBuffer) {
                textFieldBuffer.commitComposition$foundation_release();
            }
        });
    }

    public static final void setSelection(final ImeEditCommandScope imeEditCommandScope, final int i, final int i2) {
        imeEditCommandScope.edit(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$setSelection$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldBuffer textFieldBuffer) {
                invoke2(textFieldBuffer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldBuffer textFieldBuffer) {
                long mo1541mapToTransformedGEjPoXI = ImeEditCommandScope.this.mo1541mapToTransformedGEjPoXI(TextRangeKt.TextRange(0, textFieldBuffer.getLength()));
                int i3 = i;
                int m6433getMinimpl = TextRange.m6433getMinimpl(mo1541mapToTransformedGEjPoXI);
                int m6432getMaximpl = TextRange.m6432getMaximpl(mo1541mapToTransformedGEjPoXI);
                if (i3 < m6433getMinimpl) {
                    i3 = m6433getMinimpl;
                }
                if (i3 <= m6432getMaximpl) {
                    m6432getMaximpl = i3;
                }
                int i4 = i2;
                int m6433getMinimpl2 = TextRange.m6433getMinimpl(mo1541mapToTransformedGEjPoXI);
                int m6432getMaximpl2 = TextRange.m6432getMaximpl(mo1541mapToTransformedGEjPoXI);
                if (i4 < m6433getMinimpl2) {
                    i4 = m6433getMinimpl2;
                }
                if (i4 <= m6432getMaximpl2) {
                    m6432getMaximpl2 = i4;
                }
                textFieldBuffer.m1506setSelection5zctL8(ImeEditCommandScope.this.mo1540mapFromTransformedGEjPoXI(TextRangeKt.TextRange(m6432getMaximpl, m6432getMaximpl2)));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isSurrogatePair(char c, char c2) {
        return Character.isHighSurrogate(c) && Character.isLowSurrogate(c2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
    
        if (r8 == r2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
    
        r6.commitComposition$foundation_release();
        r6.clearHighlight$foundation_release();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void imeReplace(androidx.compose.foundation.text.input.TextFieldBuffer r6, int r7, int r8, java.lang.CharSequence r9) {
        /*
            int r0 = java.lang.Math.min(r7, r8)
            int r7 = java.lang.Math.max(r7, r8)
            r8 = 0
            r1 = r0
        La:
            if (r1 >= r7) goto L25
            int r2 = r9.length()
            if (r8 >= r2) goto L25
            char r2 = r9.charAt(r8)
            java.lang.CharSequence r3 = r6.asCharSequence()
            char r3 = r3.charAt(r1)
            if (r2 != r3) goto L25
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto La
        L25:
            int r2 = r9.length()
        L29:
            if (r7 <= r1) goto L44
            if (r2 <= r8) goto L44
            int r3 = r2 + (-1)
            char r3 = r9.charAt(r3)
            java.lang.CharSequence r4 = r6.asCharSequence()
            int r5 = r7 + (-1)
            char r4 = r4.charAt(r5)
            if (r3 != r4) goto L44
            int r2 = r2 + (-1)
            int r7 = r7 + (-1)
            goto L29
        L44:
            if (r1 != r7) goto L50
            if (r8 == r2) goto L49
            goto L50
        L49:
            r6.commitComposition$foundation_release()
            r6.clearHighlight$foundation_release()
            goto L57
        L50:
            java.lang.CharSequence r8 = r9.subSequence(r8, r2)
            r6.replace(r1, r7, r8)
        L57:
            int r7 = r9.length()
            int r0 = r0 + r7
            long r7 = androidx.compose.ui.text.TextRangeKt.TextRange(r0)
            r6.m1506setSelection5zctL8(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt.imeReplace(androidx.compose.foundation.text.input.TextFieldBuffer, int, int, java.lang.CharSequence):void");
    }

    public static final void imeDelete(TextFieldBuffer textFieldBuffer, int i, int i2) {
        TextRange composition = textFieldBuffer.getComposition();
        int min = Math.min(i, i2);
        int max = Math.max(i, i2);
        TextFieldBufferKt.delete(textFieldBuffer, min, max);
        if (composition != null) {
            composition.getPackedValue();
            long m1510adjustTextRangevJH6DeI = TextFieldBufferKt.m1510adjustTextRangevJH6DeI(composition.getPackedValue(), min, max, 0);
            if (TextRange.m6429getCollapsedimpl(m1510adjustTextRangevJH6DeI)) {
                textFieldBuffer.commitComposition$foundation_release();
            } else {
                TextFieldBuffer.setComposition$foundation_release$default(textFieldBuffer, TextRange.m6433getMinimpl(m1510adjustTextRangevJH6DeI), TextRange.m6432getMaximpl(m1510adjustTextRangevJH6DeI), null, 4, null);
            }
        }
    }
}
