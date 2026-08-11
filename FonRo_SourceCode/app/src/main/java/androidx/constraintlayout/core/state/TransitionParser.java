package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLContainer;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.lang.reflect.Array;

/* loaded from: classes4.dex */
public class TransitionParser {
    @Deprecated
    public static void parse(CLObject cLObject, Transition transition, CorePixelDp corePixelDp) throws CLParsingException {
        parse(cLObject, transition);
    }

    public static void parse(CLObject cLObject, Transition transition) throws CLParsingException {
        transition.resetProperties();
        String stringOrNull = cLObject.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        TypedBundle typedBundle = new TypedBundle();
        boolean z = true;
        boolean z2 = false;
        if (stringOrNull != null) {
            stringOrNull.hashCode();
            char c = 65535;
            switch (stringOrNull.hashCode()) {
                case -1857024520:
                    if (stringOrNull.equals("startVertical")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1007052250:
                    if (stringOrNull.equals("startHorizontal")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3145837:
                    if (stringOrNull.equals("flip")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3387192:
                    if (stringOrNull.equals("none")) {
                        c = 3;
                        break;
                    }
                    break;
                case 92611485:
                    if (stringOrNull.equals("above")) {
                        c = 4;
                        break;
                    }
                    break;
                case 93621297:
                    if (stringOrNull.equals("below")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    typedBundle.add(509, 1);
                    break;
                case 1:
                    typedBundle.add(509, 2);
                    break;
                case 2:
                    typedBundle.add(509, 3);
                    break;
                case 3:
                    typedBundle.add(509, 0);
                    break;
                case 4:
                    typedBundle.add(509, 5);
                    break;
                case 5:
                    typedBundle.add(509, 4);
                    break;
            }
            z2 = true;
        }
        String stringOrNull2 = cLObject.getStringOrNull("interpolator");
        if (stringOrNull2 != null) {
            typedBundle.add(TypedValues.TransitionType.TYPE_INTERPOLATOR, stringOrNull2);
            z2 = true;
        }
        float floatOrNaN = cLObject.getFloatOrNaN(TypedValues.TransitionType.S_STAGGERED);
        if (Float.isNaN(floatOrNaN)) {
            z = z2;
        } else {
            typedBundle.add(TypedValues.TransitionType.TYPE_STAGGERED, floatOrNaN);
        }
        if (z) {
            transition.setTransitionProperties(typedBundle);
        }
        CLObject objectOrNull = cLObject.getObjectOrNull("onSwipe");
        if (objectOrNull != null) {
            parseOnSwipe(objectOrNull, transition);
        }
        parseKeyFrames(cLObject, transition);
    }

    private static void parseOnSwipe(CLContainer cLContainer, Transition transition) {
        String stringOrNull = cLContainer.getStringOrNull("anchor");
        int map = map(cLContainer.getStringOrNull("side"), Transition.OnSwipe.SIDES);
        int map2 = map(cLContainer.getStringOrNull("direction"), Transition.OnSwipe.DIRECTIONS);
        float floatOrNaN = cLContainer.getFloatOrNaN("scale");
        float floatOrNaN2 = cLContainer.getFloatOrNaN("threshold");
        float floatOrNaN3 = cLContainer.getFloatOrNaN("maxVelocity");
        float floatOrNaN4 = cLContainer.getFloatOrNaN("maxAccel");
        String stringOrNull2 = cLContainer.getStringOrNull("limitBounds");
        int map3 = map(cLContainer.getStringOrNull("mode"), Transition.OnSwipe.MODE);
        int map4 = map(cLContainer.getStringOrNull("touchUp"), Transition.OnSwipe.TOUCH_UP);
        float floatOrNaN5 = cLContainer.getFloatOrNaN("springMass");
        float floatOrNaN6 = cLContainer.getFloatOrNaN("springStiffness");
        float floatOrNaN7 = cLContainer.getFloatOrNaN("springDamping");
        float floatOrNaN8 = cLContainer.getFloatOrNaN("stopThreshold");
        int map5 = map(cLContainer.getStringOrNull("springBoundary"), Transition.OnSwipe.BOUNDARY);
        String stringOrNull3 = cLContainer.getStringOrNull("around");
        Transition.OnSwipe createOnSwipe = transition.createOnSwipe();
        createOnSwipe.setAnchorId(stringOrNull);
        createOnSwipe.setAnchorSide(map);
        createOnSwipe.setDragDirection(map2);
        createOnSwipe.setDragScale(floatOrNaN);
        createOnSwipe.setDragThreshold(floatOrNaN2);
        createOnSwipe.setMaxVelocity(floatOrNaN3);
        createOnSwipe.setMaxAcceleration(floatOrNaN4);
        createOnSwipe.setLimitBoundsTo(stringOrNull2);
        createOnSwipe.setAutoCompleteMode(map3);
        createOnSwipe.setOnTouchUp(map4);
        createOnSwipe.setSpringMass(floatOrNaN5);
        createOnSwipe.setSpringStiffness(floatOrNaN6);
        createOnSwipe.setSpringDamping(floatOrNaN7);
        createOnSwipe.setSpringStopThreshold(floatOrNaN8);
        createOnSwipe.setSpringBoundary(map5);
        createOnSwipe.setRotationCenterId(stringOrNull3);
    }

    private static int map(String str, String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                return i;
            }
        }
        return 0;
    }

    private static void map(TypedBundle typedBundle, int i, String str, String... strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (strArr[i2].equals(str)) {
                typedBundle.add(i, i2);
            }
        }
    }

    public static void parseKeyFrames(CLObject cLObject, Transition transition) throws CLParsingException {
        CLObject objectOrNull = cLObject.getObjectOrNull("KeyFrames");
        if (objectOrNull == null) {
            return;
        }
        CLArray arrayOrNull = objectOrNull.getArrayOrNull("KeyPositions");
        if (arrayOrNull != null) {
            for (int i = 0; i < arrayOrNull.size(); i++) {
                CLElement cLElement = arrayOrNull.get(i);
                if (cLElement instanceof CLObject) {
                    parseKeyPosition((CLObject) cLElement, transition);
                }
            }
        }
        CLArray arrayOrNull2 = objectOrNull.getArrayOrNull(TypedValues.AttributesType.NAME);
        if (arrayOrNull2 != null) {
            for (int i2 = 0; i2 < arrayOrNull2.size(); i2++) {
                CLElement cLElement2 = arrayOrNull2.get(i2);
                if (cLElement2 instanceof CLObject) {
                    parseKeyAttribute((CLObject) cLElement2, transition);
                }
            }
        }
        CLArray arrayOrNull3 = objectOrNull.getArrayOrNull("KeyCycles");
        if (arrayOrNull3 != null) {
            for (int i3 = 0; i3 < arrayOrNull3.size(); i3++) {
                CLElement cLElement3 = arrayOrNull3.get(i3);
                if (cLElement3 instanceof CLObject) {
                    parseKeyCycle((CLObject) cLElement3, transition);
                }
            }
        }
    }

    private static void parseKeyPosition(CLObject cLObject, Transition transition) throws CLParsingException {
        TypedBundle typedBundle = new TypedBundle();
        CLArray array = cLObject.getArray(TypedValues.AttributesType.S_TARGET);
        CLArray array2 = cLObject.getArray("frames");
        CLArray arrayOrNull = cLObject.getArrayOrNull("percentX");
        CLArray arrayOrNull2 = cLObject.getArrayOrNull("percentY");
        CLArray arrayOrNull3 = cLObject.getArrayOrNull("percentWidth");
        CLArray arrayOrNull4 = cLObject.getArrayOrNull("percentHeight");
        String stringOrNull = cLObject.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        String stringOrNull2 = cLObject.getStringOrNull("transitionEasing");
        String stringOrNull3 = cLObject.getStringOrNull("curveFit");
        String stringOrNull4 = cLObject.getStringOrNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        if (stringOrNull4 == null) {
            stringOrNull4 = "parentRelative";
        }
        if (arrayOrNull == null || array2.size() == arrayOrNull.size()) {
            if (arrayOrNull2 == null || array2.size() == arrayOrNull2.size()) {
                int i = 0;
                while (i < array.size()) {
                    String string = array.getString(i);
                    int map = map(stringOrNull4, "deltaRelative", "pathRelative", "parentRelative");
                    typedBundle.clear();
                    typedBundle.add(TypedValues.PositionType.TYPE_POSITION_TYPE, map);
                    if (stringOrNull3 != null) {
                        map(typedBundle, TypedValues.PositionType.TYPE_CURVE_FIT, stringOrNull3, "spline", "linear");
                    }
                    typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull2);
                    if (stringOrNull != null) {
                        map(typedBundle, 509, stringOrNull, "none", "startVertical", "startHorizontal", "flip", "below", "above");
                    }
                    int i2 = 0;
                    while (i2 < array2.size()) {
                        typedBundle.add(100, array2.getInt(i2));
                        set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_X, arrayOrNull, i2);
                        set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_Y, arrayOrNull2, i2);
                        set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_WIDTH, arrayOrNull3, i2);
                        set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, arrayOrNull4, i2);
                        transition.addKeyPosition(string, typedBundle);
                        i2++;
                        stringOrNull4 = stringOrNull4;
                    }
                    i++;
                    stringOrNull4 = stringOrNull4;
                }
            }
        }
    }

    private static void set(TypedBundle typedBundle, int i, CLArray cLArray, int i2) throws CLParsingException {
        if (cLArray != null) {
            typedBundle.add(i, cLArray.getFloat(i2));
        }
    }

    private static void parseKeyAttribute(CLObject cLObject, Transition transition) throws CLParsingException {
        CLArray arrayOrNull;
        CustomVariable[][] customVariableArr;
        CLObject cLObject2;
        int i;
        String[] strArr;
        CLArray arrayOrNull2 = cLObject.getArrayOrNull(TypedValues.AttributesType.S_TARGET);
        if (arrayOrNull2 == null || (arrayOrNull = cLObject.getArrayOrNull("frames")) == null) {
            return;
        }
        String stringOrNull = cLObject.getStringOrNull("transitionEasing");
        String[] strArr2 = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha"};
        int[] iArr = {311, 312, 304, 305, 306, 308, 309, 310, 303};
        boolean[] zArr = {false, false, true, true, true, false, false, false, false};
        int size = arrayOrNull.size();
        TypedBundle[] typedBundleArr = new TypedBundle[size];
        for (int i2 = 0; i2 < arrayOrNull.size(); i2++) {
            typedBundleArr[i2] = new TypedBundle();
        }
        int i3 = 0;
        for (int i4 = 9; i3 < i4; i4 = 9) {
            String str = strArr2[i3];
            int i5 = iArr[i3];
            boolean z = zArr[i3];
            CLArray arrayOrNull3 = cLObject.getArrayOrNull(str);
            if (arrayOrNull3 != null && arrayOrNull3.size() != size) {
                throw new CLParsingException("incorrect size for " + str + " array, not matching targets array!", cLObject);
            }
            if (arrayOrNull3 != null) {
                int i6 = 0;
                while (i6 < size) {
                    float f = arrayOrNull3.getFloat(i6);
                    String[] strArr3 = strArr2;
                    if (z) {
                        f = transition.mToPixel.toPixels(f);
                    }
                    typedBundleArr[i6].add(i5, f);
                    i6++;
                    strArr2 = strArr3;
                }
                strArr = strArr2;
            } else {
                strArr = strArr2;
                float floatOrNaN = cLObject.getFloatOrNaN(str);
                if (!Float.isNaN(floatOrNaN)) {
                    if (z) {
                        floatOrNaN = transition.mToPixel.toPixels(floatOrNaN);
                    }
                    for (int i7 = 0; i7 < size; i7++) {
                        typedBundleArr[i7].add(i5, floatOrNaN);
                    }
                }
            }
            i3++;
            strArr2 = strArr;
        }
        int i8 = 0;
        CLElement orNull = cLObject.getOrNull("custom");
        if (orNull == null || !(orNull instanceof CLObject)) {
            customVariableArr = null;
        } else {
            CLObject cLObject3 = (CLObject) orNull;
            int size2 = cLObject3.size();
            customVariableArr = (CustomVariable[][]) Array.newInstance((Class<?>) CustomVariable.class, arrayOrNull.size(), size2);
            int i9 = 0;
            while (i9 < size2) {
                CLKey cLKey = (CLKey) cLObject3.get(i9);
                String content = cLKey.content();
                if (cLKey.getValue() instanceof CLArray) {
                    CLArray cLArray = (CLArray) cLKey.getValue();
                    int size3 = cLArray.size();
                    if (size3 == size && size3 > 0) {
                        int i10 = i8;
                        if (cLArray.get(i10) instanceof CLNumber) {
                            int i11 = i10;
                            while (i11 < size) {
                                customVariableArr[i11][i9] = new CustomVariable(content, TypedValues.Custom.TYPE_FLOAT, cLArray.get(i11).getFloat());
                                i11++;
                                cLObject3 = cLObject3;
                            }
                        } else {
                            cLObject2 = cLObject3;
                            int i12 = 0;
                            while (i12 < size) {
                                long parseColorString = ConstraintSetParser.parseColorString(cLArray.get(i12).content());
                                if (parseColorString != -1) {
                                    i = i12;
                                    customVariableArr[i12][i9] = new CustomVariable(content, TypedValues.Custom.TYPE_COLOR, (int) parseColorString);
                                } else {
                                    i = i12;
                                }
                                i12 = i + 1;
                            }
                        }
                    }
                    cLObject2 = cLObject3;
                } else {
                    cLObject2 = cLObject3;
                    CLElement value = cLKey.getValue();
                    if (value instanceof CLNumber) {
                        float f2 = value.getFloat();
                        for (int i13 = 0; i13 < size; i13++) {
                            customVariableArr[i13][i9] = new CustomVariable(content, TypedValues.Custom.TYPE_FLOAT, f2);
                        }
                    } else {
                        long parseColorString2 = ConstraintSetParser.parseColorString(value.content());
                        if (parseColorString2 != -1) {
                            int i14 = 0;
                            while (i14 < size) {
                                customVariableArr[i14][i9] = new CustomVariable(content, TypedValues.Custom.TYPE_COLOR, (int) parseColorString2);
                                i14++;
                                size2 = size2;
                                parseColorString2 = parseColorString2;
                            }
                        }
                    }
                }
                i9++;
                size2 = size2;
                cLObject3 = cLObject2;
                i8 = 0;
            }
        }
        String stringOrNull2 = cLObject.getStringOrNull("curveFit");
        for (int i15 = 0; i15 < arrayOrNull2.size(); i15++) {
            for (int i16 = 0; i16 < size; i16++) {
                String string = arrayOrNull2.getString(i15);
                TypedBundle typedBundle = typedBundleArr[i16];
                if (stringOrNull2 != null) {
                    typedBundle.add(TypedValues.PositionType.TYPE_CURVE_FIT, map(stringOrNull2, "spline", "linear"));
                }
                typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull);
                typedBundle.add(100, arrayOrNull.getInt(i16));
                transition.addKeyAttribute(string, typedBundle, customVariableArr != null ? customVariableArr[i16] : null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0150 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void parseKeyCycle(androidx.constraintlayout.core.parser.CLObject r19, androidx.constraintlayout.core.state.Transition r20) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.TransitionParser.parseKeyCycle(androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.Transition):void");
    }
}
