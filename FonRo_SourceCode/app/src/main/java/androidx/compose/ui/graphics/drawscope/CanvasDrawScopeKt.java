package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.InlineClassHelperKt;
import androidx.compose.ui.graphics.Path;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: CanvasDrawScope.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"asDrawTransform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "ui-graphics_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class CanvasDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawTransform asDrawTransform(final DrawContext drawContext) {
        return new DrawTransform() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt$asDrawTransform$1
            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: getSize-NH-jbRc, reason: not valid java name */
            public long mo4861getSizeNHjbRc() {
                return DrawContext.this.mo4856getSizeNHjbRc();
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
            public long mo4860getCenterF1C5BW0() {
                return SizeKt.m4204getCenteruvyYCjk(mo4861getSizeNHjbRc());
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void inset(float left, float top, float right, float bottom) {
                Canvas canvas = DrawContext.this.getCanvas();
                DrawContext drawContext2 = DrawContext.this;
                long m4185constructorimpl = Size.m4185constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (mo4861getSizeNHjbRc() >> 32)) - (right + left)) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (mo4861getSizeNHjbRc() & 4294967295L)) - (bottom + top)) & 4294967295L));
                if (!(Float.intBitsToFloat((int) (m4185constructorimpl >> 32)) >= 0.0f && Float.intBitsToFloat((int) (m4185constructorimpl & 4294967295L)) >= 0.0f)) {
                    InlineClassHelperKt.throwIllegalArgumentException("Width and height must be greater than or equal to zero");
                }
                drawContext2.mo4857setSizeuvyYCjk(m4185constructorimpl);
                canvas.translate(left, top);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: clipRect-N_I0leg, reason: not valid java name */
            public void mo4859clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp) {
                DrawContext.this.getCanvas().mo4220clipRectN_I0leg(left, top, right, bottom, clipOp);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: clipPath-mtrdD-E, reason: not valid java name */
            public void mo4858clipPathmtrdDE(Path path, int clipOp) {
                DrawContext.this.getCanvas().mo4219clipPathmtrdDE(path, clipOp);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void translate(float left, float top) {
                DrawContext.this.getCanvas().translate(left, top);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: rotate-Uv8p0NA, reason: not valid java name */
            public void mo4862rotateUv8p0NA(float degrees, long pivot) {
                Canvas canvas = DrawContext.this.getCanvas();
                int i = (int) (pivot >> 32);
                int i2 = (int) (pivot & 4294967295L);
                canvas.translate(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
                canvas.rotate(degrees);
                canvas.translate(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: scale-0AR0LA0, reason: not valid java name */
            public void mo4863scale0AR0LA0(float scaleX, float scaleY, long pivot) {
                Canvas canvas = DrawContext.this.getCanvas();
                int i = (int) (pivot >> 32);
                int i2 = (int) (pivot & 4294967295L);
                canvas.translate(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
                canvas.scale(scaleX, scaleY);
                canvas.translate(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: transform-58bKbWc, reason: not valid java name */
            public void mo4864transform58bKbWc(float[] matrix) {
                DrawContext.this.getCanvas().mo4221concat58bKbWc(matrix);
            }
        };
    }
}
