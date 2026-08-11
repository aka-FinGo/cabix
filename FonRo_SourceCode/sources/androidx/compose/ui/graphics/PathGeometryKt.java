package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.PathSegment;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PathGeometry.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b*\u00020\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u001a\u0014\u0010\n\u001a\u00020\u0006*\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006¨\u0006\f"}, d2 = {"floatCountForType", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Landroidx/compose/ui/graphics/PathSegment$Type;", "computeDirection", "Landroidx/compose/ui/graphics/Path$Direction;", "Landroidx/compose/ui/graphics/Path;", "divide", "", "contours", "reverse", FirebaseAnalytics.Param.DESTINATION, "ui-graphics_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class PathGeometryKt {

    /* compiled from: PathGeometry.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PathSegment.Type.values().length];
            try {
                iArr[PathSegment.Type.Move.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PathSegment.Type.Line.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PathSegment.Type.Quadratic.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PathSegment.Type.Conic.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PathSegment.Type.Cubic.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PathSegment.Type.Close.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PathSegment.Type.Done.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0028. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.graphics.Path.Direction computeDirection(androidx.compose.ui.graphics.Path r32) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.PathGeometryKt.computeDirection(androidx.compose.ui.graphics.Path):androidx.compose.ui.graphics.Path$Direction");
    }

    public static /* synthetic */ List divide$default(Path path, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return divide(path, list);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0026. Please report as an issue. */
    public static final List<Path> divide(Path path, List<Path> list) {
        Path Path = AndroidPath_androidKt.Path();
        PathIterator it = path.iterator();
        float[] fArr = new float[8];
        PathSegment.Type next$default = PathIterator.next$default(it, fArr, 0, 2, null);
        Path path2 = Path;
        boolean z = true;
        boolean z2 = true;
        while (next$default != PathSegment.Type.Done) {
            switch (WhenMappings.$EnumSwitchMapping$0[next$default.ordinal()]) {
                case 1:
                    if (!z && !z2) {
                        list.add(path2);
                        path2 = AndroidPath_androidKt.Path();
                    }
                    path2.moveTo(fArr[0], fArr[1]);
                    z = false;
                    z2 = true;
                    next$default = PathIterator.next$default(it, fArr, 0, 2, null);
                    break;
                case 2:
                    path2.lineTo(fArr[2], fArr[3]);
                    z2 = false;
                    next$default = PathIterator.next$default(it, fArr, 0, 2, null);
                    break;
                case 3:
                    path2.quadraticTo(fArr[2], fArr[3], fArr[4], fArr[5]);
                    z2 = false;
                    next$default = PathIterator.next$default(it, fArr, 0, 2, null);
                    break;
                case 4:
                case 7:
                    break;
                case 5:
                    path2.cubicTo(fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7]);
                    z2 = false;
                    next$default = PathIterator.next$default(it, fArr, 0, 2, null);
                    break;
                case 6:
                    path2.close();
                    next$default = PathIterator.next$default(it, fArr, 0, 2, null);
                    break;
                default:
                    next$default = PathIterator.next$default(it, fArr, 0, 2, null);
                    break;
            }
        }
        if (!z && !z2) {
            list.add(path2);
        }
        return list;
    }

    public static /* synthetic */ Path reverse$default(Path path, Path path2, int i, Object obj) {
        if ((i & 1) != 0) {
            path2 = AndroidPath_androidKt.Path();
        }
        return reverse(path, path2);
    }

    public static final Path reverse(Path path, Path path2) {
        boolean z;
        float[] fArr;
        PathIterator it = path.iterator();
        int calculateSize = it.calculateSize(false);
        ArrayList arrayList = new ArrayList(calculateSize);
        ArrayList arrayList2 = new ArrayList(calculateSize);
        float[] fArr2 = new float[8];
        for (PathSegment.Type next$default = PathIterator.next$default(it, fArr2, 0, 2, null); next$default != PathSegment.Type.Done; next$default = PathIterator.next$default(it, fArr2, 0, 2, null)) {
            arrayList.add(next$default);
            if (next$default != PathSegment.Type.Close) {
                float[] copyOf = Arrays.copyOf(fArr2, floatCountForType(next$default));
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                arrayList2.add(copyOf);
            }
        }
        int size = arrayList2.size();
        boolean z2 = false;
        boolean z3 = true;
        for (int size2 = arrayList.size() - 1; -1 < size2; size2--) {
            if (z3) {
                size--;
                fArr = (float[]) arrayList2.get(size);
                int lastIndex = ArraysKt.getLastIndex(fArr);
                path2.moveTo(fArr[lastIndex - 1], fArr[lastIndex]);
                z = false;
            } else {
                z = z3;
                fArr = (float[]) arrayList2.get(size);
            }
            int i = size;
            int i2 = WhenMappings.$EnumSwitchMapping$0[((PathSegment.Type) arrayList.get(size2)).ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    float[] fArr3 = fArr;
                    path2.lineTo(fArr3[0], fArr3[1]);
                } else if (i2 == 3) {
                    float[] fArr4 = fArr;
                    path2.quadraticTo(fArr4[2], fArr4[3], fArr4[0], fArr4[1]);
                } else if (i2 != 5) {
                    if (i2 == 6) {
                        z2 = true;
                    }
                    size = i;
                    z3 = z;
                } else {
                    float[] fArr5 = fArr;
                    path2.cubicTo(fArr[4], fArr[5], fArr[2], fArr5[3], fArr5[0], fArr5[1]);
                }
                i--;
                size = i;
                z3 = z;
            } else {
                if (z2) {
                    path2.close();
                    z2 = false;
                }
                z3 = true;
                size = i;
            }
        }
        if (z2) {
            path2.close();
        }
        return path2;
    }

    private static final int floatCountForType(PathSegment.Type type) {
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 6;
            case 4:
            case 5:
                return 8;
            case 6:
            case 7:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
