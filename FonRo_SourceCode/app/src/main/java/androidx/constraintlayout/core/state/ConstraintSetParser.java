package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.parser.CLString;
import androidx.constraintlayout.core.state.helpers.GridReference;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class ConstraintSetParser {
    private static final boolean PARSER_DEBUG = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface GeneratedValue {
        float value();
    }

    /* loaded from: classes4.dex */
    public enum MotionLayoutDebugFlags {
        NONE,
        SHOW_ALL,
        UNKNOWN
    }

    /* loaded from: classes4.dex */
    public static class DesignElement {
        String mId;
        HashMap<String, String> mParams;
        String mType;

        public String getId() {
            return this.mId;
        }

        public String getType() {
            return this.mType;
        }

        public HashMap<String, String> getParams() {
            return this.mParams;
        }

        DesignElement(String str, String str2, HashMap<String, String> hashMap) {
            this.mId = str;
            this.mType = str2;
            this.mParams = hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class LayoutVariables {
        HashMap<String, Integer> mMargins = new HashMap<>();
        HashMap<String, GeneratedValue> mGenerators = new HashMap<>();
        HashMap<String, ArrayList<String>> mArrayIds = new HashMap<>();

        void put(String str, int i) {
            this.mMargins.put(str, Integer.valueOf(i));
        }

        void put(String str, float f, float f2) {
            if (this.mGenerators.containsKey(str) && (this.mGenerators.get(str) instanceof OverrideValue)) {
                return;
            }
            this.mGenerators.put(str, new Generator(f, f2));
        }

        void put(String str, float f, float f2, float f3, String str2, String str3) {
            if (this.mGenerators.containsKey(str) && (this.mGenerators.get(str) instanceof OverrideValue)) {
                return;
            }
            FiniteGenerator finiteGenerator = new FiniteGenerator(f, f2, f3, str2, str3);
            this.mGenerators.put(str, finiteGenerator);
            this.mArrayIds.put(str, finiteGenerator.array());
        }

        public void putOverride(String str, float f) {
            this.mGenerators.put(str, new OverrideValue(f));
        }

        float get(Object obj) {
            if (obj instanceof CLString) {
                String content = ((CLString) obj).content();
                if (this.mGenerators.containsKey(content)) {
                    return this.mGenerators.get(content).value();
                }
                if (this.mMargins.containsKey(content)) {
                    return this.mMargins.get(content).floatValue();
                }
                return 0.0f;
            }
            if (obj instanceof CLNumber) {
                return ((CLNumber) obj).getFloat();
            }
            return 0.0f;
        }

        ArrayList<String> getList(String str) {
            if (this.mArrayIds.containsKey(str)) {
                return this.mArrayIds.get(str);
            }
            return null;
        }

        void put(String str, ArrayList<String> arrayList) {
            this.mArrayIds.put(str, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class Generator implements GeneratedValue {
        float mCurrent;
        float mIncrementBy;
        float mStart;
        boolean mStop = false;

        Generator(float f, float f2) {
            this.mStart = f;
            this.mIncrementBy = f2;
            this.mCurrent = f;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            if (!this.mStop) {
                this.mCurrent += this.mIncrementBy;
            }
            return this.mCurrent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class FiniteGenerator implements GeneratedValue {
        float mFrom;
        float mInitial;
        float mMax;
        String mPostfix;
        String mPrefix;
        float mStep;
        float mTo;
        boolean mStop = false;
        float mCurrent = 0.0f;

        FiniteGenerator(float f, float f2, float f3, String str, String str2) {
            this.mFrom = f;
            this.mTo = f2;
            this.mStep = f3;
            this.mPrefix = str == null ? "" : str;
            this.mPostfix = str2 == null ? "" : str2;
            this.mMax = f2;
            this.mInitial = f;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            float f = this.mCurrent;
            if (f >= this.mMax) {
                this.mStop = true;
            }
            if (this.mStop) {
                return f;
            }
            float f2 = f + this.mStep;
            this.mCurrent = f2;
            return f2;
        }

        public ArrayList<String> array() {
            ArrayList<String> arrayList = new ArrayList<>();
            int i = (int) this.mInitial;
            int i2 = (int) this.mMax;
            int i3 = i;
            while (i <= i2) {
                arrayList.add(this.mPrefix + i3 + this.mPostfix);
                i3 += (int) this.mStep;
                i++;
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class OverrideValue implements GeneratedValue {
        float mValue;

        OverrideValue(float f) {
            this.mValue = f;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            return this.mValue;
        }
    }

    public static void parseJSON(String str, Transition transition, int i) {
        CLObject objectOrNull;
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names == null) {
                return;
            }
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                String next = it.next();
                CLElement cLElement = parse.get(next);
                if ((cLElement instanceof CLObject) && (objectOrNull = ((CLObject) cLElement).getObjectOrNull("custom")) != null) {
                    Iterator<String> it2 = objectOrNull.names().iterator();
                    while (it2.hasNext()) {
                        String next2 = it2.next();
                        CLElement cLElement2 = objectOrNull.get(next2);
                        if (cLElement2 instanceof CLNumber) {
                            transition.addCustomFloat(i, next, next2, cLElement2.getFloat());
                        } else if (cLElement2 instanceof CLString) {
                            long parseColorString = parseColorString(cLElement2.content());
                            if (parseColorString != -1) {
                                transition.addCustomColor(i, next, next2, (int) parseColorString);
                            }
                        }
                    }
                }
            }
        } catch (CLParsingException e) {
            System.err.println("Error parsing JSON " + e);
        }
    }

    public static void parseMotionSceneJSON(CoreMotionScene coreMotionScene, String str) {
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names == null) {
                return;
            }
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                String next = it.next();
                CLElement cLElement = parse.get(next);
                if (cLElement instanceof CLObject) {
                    CLObject cLObject = (CLObject) cLElement;
                    int hashCode = next.hashCode();
                    if (hashCode != -2137403731) {
                        if (hashCode != -241441378) {
                            if (hashCode == 1101852654 && next.equals("ConstraintSets")) {
                                parseConstraintSets(coreMotionScene, cLObject);
                            }
                        } else if (next.equals(TypedValues.TransitionType.NAME)) {
                            parseTransitions(coreMotionScene, cLObject);
                        }
                    } else if (next.equals("Header")) {
                        parseHeader(coreMotionScene, cLObject);
                    }
                }
            }
        } catch (CLParsingException e) {
            System.err.println("Error parsing JSON " + e);
        }
    }

    static void parseConstraintSets(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLObject object = cLObject.getObject(next);
            String stringOrNull = object.getStringOrNull("Extends");
            if (stringOrNull != null && !stringOrNull.isEmpty()) {
                String constraintSet = coreMotionScene.getConstraintSet(stringOrNull);
                if (constraintSet != null) {
                    CLObject parse = CLParser.parse(constraintSet);
                    ArrayList<String> names2 = object.names();
                    if (names2 != null) {
                        Iterator<String> it2 = names2.iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            CLElement cLElement = object.get(next2);
                            if (cLElement instanceof CLObject) {
                                override(parse, next2, (CLObject) cLElement);
                            }
                        }
                        coreMotionScene.setConstraintSetContent(next, parse.toJSON());
                    }
                }
            } else {
                coreMotionScene.setConstraintSetContent(next, object.toJSON());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        switch(r5) {
            case 0: goto L37;
            case 1: goto L36;
            case 2: goto L35;
            default: goto L34;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0075, code lost:
    
        r6.remove(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0079, code lost:
    
        r6.remove("width");
        r6.remove("height");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0085, code lost:
    
        r6.remove("start");
        r6.remove("end");
        r6.remove("top");
        r6.remove("bottom");
        r6.remove("baseline");
        r6.remove("center");
        r6.remove("centerHorizontally");
        r6.remove("centerVertically");
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ae, code lost:
    
        r6.remove("visibility");
        r6.remove("alpha");
        r6.remove("pivotX");
        r6.remove("pivotY");
        r6.remove("rotationX");
        r6.remove("rotationY");
        r6.remove("rotationZ");
        r6.remove("scaleX");
        r6.remove("scaleY");
        r6.remove("translationX");
        r6.remove("translationY");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void override(androidx.constraintlayout.core.parser.CLObject r6, java.lang.String r7, androidx.constraintlayout.core.parser.CLObject r8) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            boolean r0 = r6.has(r7)
            if (r0 != 0) goto La
            r6.put(r7, r8)
            return
        La:
            androidx.constraintlayout.core.parser.CLObject r6 = r6.getObject(r7)
            java.util.ArrayList r7 = r8.names()
            java.util.Iterator r7 = r7.iterator()
        L16:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto Lea
            java.lang.Object r0 = r7.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "clear"
            boolean r2 = r0.equals(r1)
            if (r2 != 0) goto L32
            androidx.constraintlayout.core.parser.CLElement r1 = r8.get(r0)
            r6.put(r0, r1)
            goto L16
        L32:
            androidx.constraintlayout.core.parser.CLArray r0 = r8.getArray(r1)
            r1 = 0
            r2 = r1
        L38:
            int r3 = r0.size()
            if (r2 >= r3) goto L16
            java.lang.String r3 = r0.getStringOrNull(r2)
            if (r3 != 0) goto L46
            goto Le6
        L46:
            r3.hashCode()
            int r4 = r3.hashCode()
            r5 = -1
            switch(r4) {
                case -1727069561: goto L68;
                case -1606703562: goto L5d;
                case 414334925: goto L52;
                default: goto L51;
            }
        L51:
            goto L72
        L52:
            java.lang.String r4 = "dimensions"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L5b
            goto L72
        L5b:
            r5 = 2
            goto L72
        L5d:
            java.lang.String r4 = "constraints"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L66
            goto L72
        L66:
            r5 = 1
            goto L72
        L68:
            java.lang.String r4 = "transforms"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L71
            goto L72
        L71:
            r5 = r1
        L72:
            switch(r5) {
                case 0: goto Lae;
                case 1: goto L85;
                case 2: goto L79;
                default: goto L75;
            }
        L75:
            r6.remove(r3)
            goto Le6
        L79:
            java.lang.String r3 = "width"
            r6.remove(r3)
            java.lang.String r3 = "height"
            r6.remove(r3)
            goto Le6
        L85:
            java.lang.String r3 = "start"
            r6.remove(r3)
            java.lang.String r3 = "end"
            r6.remove(r3)
            java.lang.String r3 = "top"
            r6.remove(r3)
            java.lang.String r3 = "bottom"
            r6.remove(r3)
            java.lang.String r3 = "baseline"
            r6.remove(r3)
            java.lang.String r3 = "center"
            r6.remove(r3)
            java.lang.String r3 = "centerHorizontally"
            r6.remove(r3)
            java.lang.String r3 = "centerVertically"
            r6.remove(r3)
            goto Le6
        Lae:
            java.lang.String r3 = "visibility"
            r6.remove(r3)
            java.lang.String r3 = "alpha"
            r6.remove(r3)
            java.lang.String r3 = "pivotX"
            r6.remove(r3)
            java.lang.String r3 = "pivotY"
            r6.remove(r3)
            java.lang.String r3 = "rotationX"
            r6.remove(r3)
            java.lang.String r3 = "rotationY"
            r6.remove(r3)
            java.lang.String r3 = "rotationZ"
            r6.remove(r3)
            java.lang.String r3 = "scaleX"
            r6.remove(r3)
            java.lang.String r3 = "scaleY"
            r6.remove(r3)
            java.lang.String r3 = "translationX"
            r6.remove(r3)
            java.lang.String r3 = "translationY"
            r6.remove(r3)
        Le6:
            int r2 = r2 + 1
            goto L38
        Lea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.override(androidx.constraintlayout.core.parser.CLObject, java.lang.String, androidx.constraintlayout.core.parser.CLObject):void");
    }

    static void parseTransitions(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            coreMotionScene.setTransitionContent(next, cLObject.getObject(next).toJSON());
        }
    }

    static void parseHeader(CoreMotionScene coreMotionScene, CLObject cLObject) {
        String stringOrNull = cLObject.getStringOrNull("export");
        if (stringOrNull != null) {
            coreMotionScene.setDebugName(stringOrNull);
        }
    }

    public static void parseJSON(String str, State state, LayoutVariables layoutVariables) throws CLParsingException {
        try {
            populateState(CLParser.parse(str), state, layoutVariables);
        } catch (CLParsingException e) {
            System.err.println("Error parsing JSON " + e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x00c1, code lost:
    
        if (r3.equals("hChain") == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void populateState(androidx.constraintlayout.core.parser.CLObject r9, androidx.constraintlayout.core.state.State r10, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r11) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.populateState(androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables):void");
    }

    private static void parseVariables(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLElement cLElement = cLObject.get(next);
            if (cLElement instanceof CLNumber) {
                layoutVariables.put(next, cLElement.getInt());
            } else if (cLElement instanceof CLObject) {
                CLObject cLObject2 = (CLObject) cLElement;
                if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has(TypedValues.TransitionType.S_TO)) {
                    layoutVariables.put(next, layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_FROM)), layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_TO)), 1.0f, cLObject2.getStringOrNull("prefix"), cLObject2.getStringOrNull("postfix"));
                } else if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has("step")) {
                    layoutVariables.put(next, layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_FROM)), layoutVariables.get(cLObject2.get("step")));
                } else if (cLObject2.has("ids")) {
                    CLArray array = cLObject2.getArray("ids");
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (int i = 0; i < array.size(); i++) {
                        arrayList.add(array.getString(i));
                    }
                    layoutVariables.put(next, arrayList);
                } else if (cLObject2.has("tag")) {
                    layoutVariables.put(next, state.getIdsForTag(cLObject2.getString("tag")));
                }
            }
        }
    }

    public static void parseDesignElementsJSON(String str, ArrayList<DesignElement> arrayList) throws CLParsingException {
        CLObject parse = CLParser.parse(str);
        ArrayList<String> names = parse.names();
        if (names != null && names.size() > 0) {
            String str2 = names.get(0);
            CLElement cLElement = parse.get(str2);
            str2.hashCode();
            if (str2.equals("Design") && (cLElement instanceof CLObject)) {
                CLObject cLObject = (CLObject) cLElement;
                ArrayList<String> names2 = cLObject.names();
                for (int i = 0; i < names2.size(); i++) {
                    String str3 = names2.get(i);
                    CLObject cLObject2 = (CLObject) cLObject.get(str3);
                    System.out.printf("element found " + str3 + "", new Object[0]);
                    String stringOrNull = cLObject2.getStringOrNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                    if (stringOrNull != null) {
                        HashMap hashMap = new HashMap();
                        int size = cLObject2.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            CLKey cLKey = (CLKey) cLObject2.get(i);
                            String content = cLKey.content();
                            String content2 = cLKey.getValue().content();
                            if (content2 != null) {
                                hashMap.put(content, content2);
                            }
                        }
                        arrayList.add(new DesignElement(str2, stringOrNull, hashMap));
                    }
                }
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0025. Please report as an issue. */
    static void parseHelpers(State state, LayoutVariables layoutVariables, CLArray cLArray) throws CLParsingException {
        for (int i = 0; i < cLArray.size(); i++) {
            CLElement cLElement = cLArray.get(i);
            if (cLElement instanceof CLArray) {
                CLArray cLArray2 = (CLArray) cLElement;
                if (cLArray2.size() > 1) {
                    String string = cLArray2.getString(0);
                    string.hashCode();
                    char c = 65535;
                    switch (string.hashCode()) {
                        case -1785507558:
                            if (string.equals("vGuideline")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1252464839:
                            if (string.equals("hChain")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -851656725:
                            if (string.equals("vChain")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 965681512:
                            if (string.equals("hGuideline")) {
                                c = 3;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            parseGuideline(1, state, cLArray2);
                            break;
                        case 1:
                            parseChain(0, state, layoutVariables, cLArray2);
                            break;
                        case 2:
                            parseChain(1, state, layoutVariables, cLArray2);
                            break;
                        case 3:
                            parseGuideline(0, state, cLArray2);
                            break;
                    }
                }
            }
        }
    }

    static void parseGenerate(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLElement cLElement = cLObject.get(next);
            ArrayList<String> list = layoutVariables.getList(next);
            if (list != null && (cLElement instanceof CLObject)) {
                Iterator<String> it2 = list.iterator();
                while (it2.hasNext()) {
                    parseWidget(state, layoutVariables, it2.next(), (CLObject) cLElement);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void parseChain(int r6, androidx.constraintlayout.core.state.State r7, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r8, androidx.constraintlayout.core.parser.CLArray r9) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            if (r6 != 0) goto L7
            androidx.constraintlayout.core.state.helpers.HorizontalChainReference r6 = r7.horizontalChain()
            goto Lb
        L7:
            androidx.constraintlayout.core.state.helpers.VerticalChainReference r6 = r7.verticalChain()
        Lb:
            r0 = 1
            androidx.constraintlayout.core.parser.CLElement r1 = r9.get(r0)
            boolean r2 = r1 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r2 == 0) goto Laf
            androidx.constraintlayout.core.parser.CLArray r1 = (androidx.constraintlayout.core.parser.CLArray) r1
            int r2 = r1.size()
            if (r2 >= r0) goto L1e
            goto Laf
        L1e:
            r2 = 0
            r3 = r2
        L20:
            int r4 = r1.size()
            if (r3 >= r4) goto L34
            java.lang.String r4 = r1.getString(r3)
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            r6.add(r4)
            int r3 = r3 + 1
            goto L20
        L34:
            int r1 = r9.size()
            r3 = 2
            if (r1 <= r3) goto Laf
            androidx.constraintlayout.core.parser.CLElement r9 = r9.get(r3)
            boolean r1 = r9 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r1 != 0) goto L44
            goto Laf
        L44:
            androidx.constraintlayout.core.parser.CLObject r9 = (androidx.constraintlayout.core.parser.CLObject) r9
            java.util.ArrayList r1 = r9.names()
            java.util.Iterator r1 = r1.iterator()
        L4e:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto Laf
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            r3.hashCode()
            java.lang.String r4 = "style"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L69
            parseConstraint(r7, r8, r9, r6, r3)
            goto L4e
        L69:
            androidx.constraintlayout.core.parser.CLElement r3 = r9.get(r3)
            boolean r4 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r4 == 0) goto L86
            r4 = r3
            androidx.constraintlayout.core.parser.CLArray r4 = (androidx.constraintlayout.core.parser.CLArray) r4
            int r5 = r4.size()
            if (r5 <= r0) goto L86
            java.lang.String r3 = r4.getString(r2)
            float r4 = r4.getFloat(r0)
            r6.bias(r4)
            goto L8a
        L86:
            java.lang.String r3 = r3.content()
        L8a:
            r3.hashCode()
            java.lang.String r4 = "packed"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto La9
            java.lang.String r4 = "spread_inside"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto La3
            androidx.constraintlayout.core.state.State$Chain r3 = androidx.constraintlayout.core.state.State.Chain.SPREAD
            r6.style(r3)
            goto L4e
        La3:
            androidx.constraintlayout.core.state.State$Chain r3 = androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE
            r6.style(r3)
            goto L4e
        La9:
            androidx.constraintlayout.core.state.State$Chain r3 = androidx.constraintlayout.core.state.State.Chain.PACKED
            r6.style(r3)
            goto L4e
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseChain(int, androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLArray):void");
    }

    private static float toPix(State state, float f) {
        return state.getDpToPixel().toPixels(f);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:33:0x009d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0209  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void parseChainType(java.lang.String r18, androidx.constraintlayout.core.state.State r19, java.lang.String r20, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r21, androidx.constraintlayout.core.parser.CLObject r22) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseChainType(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0024. Please report as an issue. */
    private static void parseGridType(String str, State state, String str2, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        float f;
        float f2;
        float f3;
        float f4;
        GridReference grid = state.getGrid(str2, str);
        Iterator<String> it = cLObject.names().iterator();
        while (it.hasNext()) {
            String next = it.next();
            next.hashCode();
            int i = 0;
            char c = 65535;
            switch (next.hashCode()) {
                case -1439500848:
                    if (next.equals("orientation")) {
                        c = 0;
                        break;
                    }
                    break;
                case -806339567:
                    if (next.equals("padding")) {
                        c = 1;
                        break;
                    }
                    break;
                case -567445985:
                    if (next.equals("contains")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3169614:
                    if (next.equals("hGap")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3506649:
                    if (next.equals("rows")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3586688:
                    if (next.equals("vGap")) {
                        c = 5;
                        break;
                    }
                    break;
                case 97513095:
                    if (next.equals("flags")) {
                        c = 6;
                        break;
                    }
                    break;
                case 109497044:
                    if (next.equals("skips")) {
                        c = 7;
                        break;
                    }
                    break;
                case 109638249:
                    if (next.equals("spans")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 144441793:
                    if (next.equals("rowWeights")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 949721053:
                    if (next.equals("columns")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 2033353925:
                    if (next.equals("columnWeights")) {
                        c = 11;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    grid.setOrientation(cLObject.get(next).getInt());
                    break;
                case 1:
                    CLElement cLElement = cLObject.get(next);
                    if (cLElement instanceof CLArray) {
                        CLArray cLArray = (CLArray) cLElement;
                        if (cLArray.size() > 1) {
                            f = cLArray.getInt(0);
                            f4 = cLArray.getInt(1);
                            if (cLArray.size() > 2) {
                                f3 = cLArray.getInt(2);
                                try {
                                    f2 = ((CLArray) cLElement).getInt(3);
                                } catch (ArrayIndexOutOfBoundsException unused) {
                                    f2 = 0.0f;
                                }
                            } else {
                                f2 = f4;
                                f3 = f;
                            }
                            grid.setPaddingStart(Math.round(toPix(state, f)));
                            grid.setPaddingTop(Math.round(toPix(state, f4)));
                            grid.setPaddingEnd(Math.round(toPix(state, f3)));
                            grid.setPaddingBottom(Math.round(toPix(state, f2)));
                            break;
                        }
                    }
                    f = cLElement.getInt();
                    f2 = f;
                    f3 = f2;
                    f4 = f3;
                    grid.setPaddingStart(Math.round(toPix(state, f)));
                    grid.setPaddingTop(Math.round(toPix(state, f4)));
                    grid.setPaddingEnd(Math.round(toPix(state, f3)));
                    grid.setPaddingBottom(Math.round(toPix(state, f2)));
                case 2:
                    CLArray arrayOrNull = cLObject.getArrayOrNull(next);
                    if (arrayOrNull == null) {
                        break;
                    } else {
                        while (i < arrayOrNull.size()) {
                            grid.add(state.constraints(arrayOrNull.get(i).content()));
                            i++;
                        }
                        break;
                    }
                case 3:
                    grid.setHorizontalGaps(toPix(state, cLObject.get(next).getFloat()));
                    break;
                case 4:
                    int i2 = cLObject.get(next).getInt();
                    if (i2 <= 0) {
                        break;
                    } else {
                        grid.setRowsSet(i2);
                        break;
                    }
                case 5:
                    grid.setVerticalGaps(toPix(state, cLObject.get(next).getFloat()));
                    break;
                case 6:
                    String str3 = "";
                    try {
                        CLElement cLElement2 = cLObject.get(next);
                        if (cLElement2 instanceof CLNumber) {
                            i = cLElement2.getInt();
                        } else {
                            str3 = cLElement2.content();
                        }
                    } catch (Exception e) {
                        System.err.println("Error parsing grid flags " + e);
                    }
                    if (str3 != null && !str3.isEmpty()) {
                        grid.setFlags(str3);
                        break;
                    } else {
                        grid.setFlags(i);
                        break;
                    }
                case 7:
                    String content = cLObject.get(next).content();
                    if (content != null && content.contains(":")) {
                        grid.setSkips(content);
                        break;
                    }
                    break;
                case '\b':
                    String content2 = cLObject.get(next).content();
                    if (content2 != null && content2.contains(":")) {
                        grid.setSpans(content2);
                        break;
                    }
                    break;
                case '\t':
                    String content3 = cLObject.get(next).content();
                    if (content3 != null && content3.contains(",")) {
                        grid.setRowWeights(content3);
                        break;
                    }
                    break;
                case '\n':
                    int i3 = cLObject.get(next).getInt();
                    if (i3 <= 0) {
                        break;
                    } else {
                        grid.setColumnsSet(i3);
                        break;
                    }
                case 11:
                    String content4 = cLObject.get(next).content();
                    if (content4 != null && content4.contains(",")) {
                        grid.setColumnWeights(content4);
                        break;
                    }
                    break;
                default:
                    applyAttribute(state, layoutVariables, state.constraints(str2), cLObject, next);
                    break;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0358, code lost:
    
        switch(r10) {
            case 0: goto L237;
            case 1: goto L236;
            case 2: goto L235;
            default: goto L238;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0360, code lost:
    
        r4.setVerticalAlign(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0365, code lost:
    
        r4.setVerticalAlign(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x036a, code lost:
    
        r4.setVerticalAlign(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x035b, code lost:
    
        r4.setVerticalAlign(2);
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x031a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0021 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03c3 A[Catch: NumberFormatException -> 0x0021, TryCatch #1 {NumberFormatException -> 0x0021, blocks: (B:76:0x023a, B:80:0x0249, B:81:0x0250, B:84:0x0258, B:161:0x03b4, B:163:0x03c3, B:164:0x03ca, B:167:0x03d2), top: B:75:0x023a }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03d2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0021 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0429 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0021 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0249 A[Catch: NumberFormatException -> 0x0021, TryCatch #1 {NumberFormatException -> 0x0021, blocks: (B:76:0x023a, B:80:0x0249, B:81:0x0250, B:84:0x0258, B:161:0x03b4, B:163:0x03c3, B:164:0x03ca, B:167:0x03d2), top: B:75:0x023a }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0258 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0021 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void parseFlowType(java.lang.String r17, androidx.constraintlayout.core.state.State r18, java.lang.String r19, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r20, androidx.constraintlayout.core.parser.CLObject r21) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 1228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseFlowType(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    static void parseGuideline(int i, State state, CLArray cLArray) throws CLParsingException {
        CLObject cLObject;
        String stringOrNull;
        CLElement cLElement = cLArray.get(1);
        if ((cLElement instanceof CLObject) && (stringOrNull = (cLObject = (CLObject) cLElement).getStringOrNull("id")) != null) {
            parseGuidelineParams(i, state, stringOrNull, cLObject);
        }
    }

    static void parseGuidelineParams(int i, State state, String str, CLObject cLObject) throws CLParsingException {
        String next;
        char c;
        char c2;
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        ConstraintReference constraints = state.constraints(str);
        if (i == 0) {
            state.horizontalGuideline(str);
        } else {
            state.verticalGuideline(str);
        }
        boolean z = !state.isRtl() || i == 0;
        GuidelineReference guidelineReference = (GuidelineReference) constraints.getFacade();
        Iterator<String> it = names.iterator();
        float f = 0.0f;
        boolean z2 = false;
        while (true) {
            boolean z3 = true;
            while (it.hasNext()) {
                next = it.next();
                next.hashCode();
                switch (next.hashCode()) {
                    case -678927291:
                        if (next.equals("percent")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 100571:
                        if (next.equals("end")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3317767:
                        if (next.equals("left")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 108511772:
                        if (next.equals("right")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 109757538:
                        if (next.equals("start")) {
                            c = 4;
                            break;
                        }
                        break;
                }
                c = 65535;
                switch (c) {
                    case 0:
                        CLArray arrayOrNull = cLObject.getArrayOrNull(next);
                        if (arrayOrNull == null) {
                            f = cLObject.getFloat(next);
                            z2 = true;
                            z3 = true;
                            break;
                        } else {
                            if (arrayOrNull.size() > 1) {
                                String string = arrayOrNull.getString(0);
                                float f2 = arrayOrNull.getFloat(1);
                                string.hashCode();
                                switch (string.hashCode()) {
                                    case 100571:
                                        if (string.equals("end")) {
                                            c2 = 0;
                                            break;
                                        }
                                        break;
                                    case 3317767:
                                        if (string.equals("left")) {
                                            c2 = 1;
                                            break;
                                        }
                                        break;
                                    case 108511772:
                                        if (string.equals("right")) {
                                            c2 = 2;
                                            break;
                                        }
                                        break;
                                    case 109757538:
                                        if (string.equals("start")) {
                                            c2 = 3;
                                            break;
                                        }
                                        break;
                                }
                                c2 = 65535;
                                switch (c2) {
                                    case 0:
                                        z3 = !z;
                                        break;
                                    case 1:
                                        z3 = true;
                                        f = f2;
                                        z2 = true;
                                        break;
                                    case 2:
                                        z3 = false;
                                        break;
                                    case 3:
                                        z3 = z;
                                        break;
                                }
                                f = f2;
                            }
                            z2 = true;
                            break;
                        }
                    case 1:
                        f = toPix(state, cLObject.getFloat(next));
                        z3 = !z;
                        break;
                    case 3:
                        f = toPix(state, cLObject.getFloat(next));
                        z3 = false;
                        break;
                    case 4:
                        f = toPix(state, cLObject.getFloat(next));
                        z3 = z;
                        break;
                }
            }
            if (z2) {
                if (z3) {
                    guidelineReference.percent(f);
                    return;
                } else {
                    guidelineReference.percent(1.0f - f);
                    return;
                }
            }
            if (z3) {
                guidelineReference.start(Float.valueOf(f));
                return;
            } else {
                guidelineReference.end(Float.valueOf(f));
                return;
            }
            f = toPix(state, cLObject.getFloat(next));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00af, code lost:
    
        if (r2.equals("top") == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void parseBarrier(androidx.constraintlayout.core.state.State r8, java.lang.String r9, androidx.constraintlayout.core.parser.CLObject r10) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseBarrier(androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.parser.CLObject):void");
    }

    static void parseWidget(State state, LayoutVariables layoutVariables, String str, CLObject cLObject) throws CLParsingException {
        parseWidget(state, layoutVariables, state.constraints(str), cLObject);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x016d, code lost:
    
        if (r8.equals("visible") == false) goto L107;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void applyAttribute(androidx.constraintlayout.core.state.State r8, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r9, androidx.constraintlayout.core.state.ConstraintReference r10, androidx.constraintlayout.core.parser.CLObject r11, java.lang.String r12) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 914
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.applyAttribute(androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.parser.CLObject, java.lang.String):void");
    }

    static void parseWidget(State state, LayoutVariables layoutVariables, ConstraintReference constraintReference, CLObject cLObject) throws CLParsingException {
        if (constraintReference.getWidth() == null) {
            constraintReference.setWidth(Dimension.createWrap());
        }
        if (constraintReference.getHeight() == null) {
            constraintReference.setHeight(Dimension.createWrap());
        }
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            applyAttribute(state, layoutVariables, constraintReference, cLObject, it.next());
        }
    }

    static void parseCustomProperties(CLObject cLObject, ConstraintReference constraintReference, String str) throws CLParsingException {
        ArrayList<String> names;
        CLObject objectOrNull = cLObject.getObjectOrNull(str);
        if (objectOrNull == null || (names = objectOrNull.names()) == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLElement cLElement = objectOrNull.get(next);
            if (cLElement instanceof CLNumber) {
                constraintReference.addCustomFloat(next, cLElement.getFloat());
            } else if (cLElement instanceof CLString) {
                long parseColorString = parseColorString(cLElement.content());
                if (parseColorString != -1) {
                    constraintReference.addCustomColor(next, (int) parseColorString);
                }
            }
        }
    }

    private static int indexOf(String str, String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private static void parseMotionProperties(CLElement cLElement, ConstraintReference constraintReference) throws CLParsingException {
        char c;
        if (cLElement instanceof CLObject) {
            CLObject cLObject = (CLObject) cLElement;
            TypedBundle typedBundle = new TypedBundle();
            ArrayList<String> names = cLObject.names();
            if (names == null) {
                return;
            }
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                String next = it.next();
                next.hashCode();
                switch (next.hashCode()) {
                    case -1897525331:
                        if (next.equals("stagger")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1310311125:
                        if (next.equals("easing")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1285003983:
                        if (next.equals("quantize")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -791482387:
                        if (next.equals("pathArc")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -236944793:
                        if (next.equals("relativeTo")) {
                            c = 4;
                            break;
                        }
                        break;
                }
                c = 65535;
                switch (c) {
                    case 0:
                        typedBundle.add(600, cLObject.getFloat(next));
                        break;
                    case 1:
                        typedBundle.add(TypedValues.MotionType.TYPE_EASING, cLObject.getString(next));
                        break;
                    case 2:
                        CLElement cLElement2 = cLObject.get(next);
                        if (cLElement2 instanceof CLArray) {
                            CLArray cLArray = (CLArray) cLElement2;
                            int size = cLArray.size();
                            if (size <= 0) {
                                break;
                            } else {
                                typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, cLArray.getInt(0));
                                if (size <= 1) {
                                    break;
                                } else {
                                    typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE, cLArray.getString(1));
                                    if (size <= 2) {
                                        break;
                                    } else {
                                        typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, cLArray.getFloat(2));
                                        break;
                                    }
                                }
                            }
                        } else {
                            typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, cLObject.getInt(next));
                            break;
                        }
                    case 3:
                        String string = cLObject.getString(next);
                        int indexOf = indexOf(string, "none", "startVertical", "startHorizontal", "flip", "below", "above");
                        if (indexOf == -1) {
                            System.err.println(cLObject.getLine() + " pathArc = '" + string + "'");
                            break;
                        } else {
                            typedBundle.add(TypedValues.MotionType.TYPE_PATHMOTION_ARC, indexOf);
                            break;
                        }
                    case 4:
                        typedBundle.add(TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, cLObject.getString(next));
                        break;
                }
            }
            constraintReference.mMotionProperties = typedBundle;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x00d3. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    static void parseConstraint(State state, LayoutVariables layoutVariables, CLObject cLObject, ConstraintReference constraintReference, String str) throws CLParsingException {
        ConstraintReference constraints;
        char c;
        ConstraintReference constraints2;
        char c2;
        boolean z;
        char c3;
        boolean z2;
        char c4;
        boolean z3;
        char c5;
        boolean z4;
        boolean z5;
        boolean isRtl = state.isRtl();
        boolean z6 = !isRtl;
        CLArray arrayOrNull = cLObject.getArrayOrNull(str);
        ?? r16 = -1;
        r16 = -1;
        r16 = -1;
        r16 = -1;
        r16 = -1;
        if (arrayOrNull != null && arrayOrNull.size() > 1) {
            String string = arrayOrNull.getString(0);
            String stringOrNull = arrayOrNull.getStringOrNull(1);
            float pix = arrayOrNull.size() > 2 ? toPix(state, layoutVariables.get(arrayOrNull.getOrNull(2))) : 0.0f;
            float pix2 = arrayOrNull.size() > 3 ? toPix(state, layoutVariables.get(arrayOrNull.getOrNull(3))) : 0.0f;
            if (string.equals("parent")) {
                constraints2 = state.constraints(State.PARENT);
            } else {
                constraints2 = state.constraints(string);
            }
            str.hashCode();
            float f = pix;
            switch (str.hashCode()) {
                case -1720785339:
                    if (str.equals("baseline")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1498085729:
                    if (str.equals("circular")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1383228885:
                    if (str.equals("bottom")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100571:
                    if (str.equals("end")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 115029:
                    if (str.equals("top")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109757538:
                    if (str.equals("start")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    z = true;
                    c3 = 2;
                    stringOrNull.hashCode();
                    switch (stringOrNull.hashCode()) {
                        case -1720785339:
                            if (stringOrNull.equals("baseline")) {
                                z2 = false;
                                break;
                            }
                            z2 = -1;
                            break;
                        case -1383228885:
                            if (stringOrNull.equals("bottom")) {
                                z2 = true;
                                break;
                            }
                            z2 = -1;
                            break;
                        case 115029:
                            if (stringOrNull.equals("top")) {
                                z2 = 2;
                                break;
                            }
                            z2 = -1;
                            break;
                        default:
                            z2 = -1;
                            break;
                    }
                    switch (z2) {
                        case false:
                            state.baselineNeededFor(constraintReference.getKey());
                            state.baselineNeededFor(constraints2.getKey());
                            constraintReference.baselineToBaseline(constraints2);
                            break;
                        case true:
                            state.baselineNeededFor(constraintReference.getKey());
                            constraintReference.baselineToBottom(constraints2);
                            break;
                        case true:
                            state.baselineNeededFor(constraintReference.getKey());
                            constraintReference.baselineToTop(constraints2);
                            break;
                    }
                    z3 = z;
                    z4 = false;
                    break;
                case 1:
                    z = true;
                    constraintReference.circularConstraint(constraints2, layoutVariables.get(arrayOrNull.get(1)), arrayOrNull.size() > 2 ? toPix(state, layoutVariables.get(arrayOrNull.getOrNull(2))) : 0.0f);
                    c3 = 2;
                    z3 = z;
                    z4 = false;
                    break;
                case 2:
                    stringOrNull.hashCode();
                    switch (stringOrNull.hashCode()) {
                        case -1720785339:
                            if (stringOrNull.equals("baseline")) {
                                c4 = 0;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case -1383228885:
                            if (stringOrNull.equals("bottom")) {
                                c4 = 1;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case 115029:
                            if (stringOrNull.equals("top")) {
                                c4 = 2;
                                break;
                            }
                            c4 = 65535;
                            break;
                        default:
                            c4 = 65535;
                            break;
                    }
                    switch (c4) {
                        case 0:
                            state.baselineNeededFor(constraints2.getKey());
                            constraintReference.bottomToBaseline(constraints2);
                            break;
                        case 1:
                            constraintReference.bottomToBottom(constraints2);
                            break;
                        case 2:
                            constraintReference.bottomToTop(constraints2);
                            break;
                    }
                    z = true;
                    c3 = 2;
                    z3 = z;
                    z4 = false;
                    break;
                case 3:
                    z3 = isRtl;
                    z = true;
                    c3 = 2;
                    z4 = true;
                    break;
                case 4:
                    stringOrNull.hashCode();
                    switch (stringOrNull.hashCode()) {
                        case -1720785339:
                            if (stringOrNull.equals("baseline")) {
                                c5 = 0;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case -1383228885:
                            if (stringOrNull.equals("bottom")) {
                                c5 = 1;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 115029:
                            if (stringOrNull.equals("top")) {
                                c5 = 2;
                                break;
                            }
                            c5 = 65535;
                            break;
                        default:
                            c5 = 65535;
                            break;
                    }
                    switch (c5) {
                        case 0:
                            state.baselineNeededFor(constraints2.getKey());
                            constraintReference.topToBaseline(constraints2);
                            break;
                        case 1:
                            constraintReference.topToBottom(constraints2);
                            break;
                        case 2:
                            constraintReference.topToTop(constraints2);
                            break;
                    }
                    z = true;
                    c3 = 2;
                    z3 = z;
                    z4 = false;
                    break;
                case 5:
                    z3 = true;
                    z = true;
                    c3 = 2;
                    z4 = true;
                    break;
                case 6:
                    z3 = false;
                    z = true;
                    c3 = 2;
                    z4 = true;
                    break;
                case 7:
                    z3 = z6;
                    z = true;
                    c3 = 2;
                    z4 = true;
                    break;
                default:
                    z = true;
                    c3 = 2;
                    z3 = z;
                    z4 = false;
                    break;
            }
            if (z4) {
                stringOrNull.hashCode();
                switch (stringOrNull.hashCode()) {
                    case 100571:
                        if (stringOrNull.equals("end")) {
                            r16 = 0;
                            break;
                        }
                        break;
                    case 3317767:
                        if (stringOrNull.equals("left")) {
                            r16 = z;
                            break;
                        }
                        break;
                    case 108511772:
                        if (stringOrNull.equals("right")) {
                            r16 = c3;
                            break;
                        }
                        break;
                    case 109757538:
                        if (stringOrNull.equals("start")) {
                            r16 = 3;
                            break;
                        }
                        break;
                }
                switch (r16) {
                    case 0:
                        z5 = isRtl;
                        break;
                    case 1:
                    default:
                        z5 = z;
                        break;
                    case 2:
                        z5 = false;
                        break;
                    case 3:
                        z5 = z6;
                        break;
                }
                if (z3) {
                    if (z5) {
                        constraintReference.leftToLeft(constraints2);
                    } else {
                        constraintReference.leftToRight(constraints2);
                    }
                } else if (z5) {
                    constraintReference.rightToLeft(constraints2);
                } else {
                    constraintReference.rightToRight(constraints2);
                }
            }
            constraintReference.margin(Float.valueOf(f)).marginGone(Float.valueOf(pix2));
            return;
        }
        String stringOrNull2 = cLObject.getStringOrNull(str);
        if (stringOrNull2 != null) {
            if (stringOrNull2.equals("parent")) {
                constraints = state.constraints(State.PARENT);
            } else {
                constraints = state.constraints(stringOrNull2);
            }
            str.hashCode();
            switch (str.hashCode()) {
                case -1720785339:
                    if (str.equals("baseline")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1383228885:
                    if (str.equals("bottom")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 100571:
                    if (str.equals("end")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 115029:
                    if (str.equals("top")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 109757538:
                    if (str.equals("start")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    state.baselineNeededFor(constraintReference.getKey());
                    state.baselineNeededFor(constraints.getKey());
                    constraintReference.baselineToBaseline(constraints);
                    return;
                case 1:
                    constraintReference.bottomToBottom(constraints);
                    return;
                case 2:
                    if (!isRtl) {
                        constraintReference.rightToRight(constraints);
                        return;
                    } else {
                        constraintReference.leftToLeft(constraints);
                        return;
                    }
                case 3:
                    constraintReference.topToTop(constraints);
                    return;
                case 4:
                    if (!isRtl) {
                        constraintReference.leftToLeft(constraints);
                        return;
                    } else {
                        constraintReference.rightToRight(constraints);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    static Dimension parseDimensionMode(String str) {
        Dimension createFixed = Dimension.createFixed(0);
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1460244870:
                if (str.equals("preferWrap")) {
                    c = 0;
                    break;
                }
                break;
            case -995424086:
                if (str.equals("parent")) {
                    c = 1;
                    break;
                }
                break;
            case -895684237:
                if (str.equals("spread")) {
                    c = 2;
                    break;
                }
                break;
            case 3657802:
                if (str.equals("wrap")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Dimension.createSuggested(Dimension.WRAP_DIMENSION);
            case 1:
                return Dimension.createParent();
            case 2:
                return Dimension.createSuggested(Dimension.SPREAD_DIMENSION);
            case 3:
                return Dimension.createWrap();
            default:
                if (str.endsWith("%")) {
                    return Dimension.createPercent(0, Float.parseFloat(str.substring(0, str.indexOf(37))) / 100.0f).suggested(0);
                }
                return str.contains(":") ? Dimension.createRatio(str).suggested(Dimension.SPREAD_DIMENSION) : createFixed;
        }
    }

    static Dimension parseDimension(CLObject cLObject, String str, State state, CorePixelDp corePixelDp) throws CLParsingException {
        CLElement cLElement = cLObject.get(str);
        Dimension createFixed = Dimension.createFixed(0);
        if (cLElement instanceof CLString) {
            return parseDimensionMode(cLElement.content());
        }
        if (cLElement instanceof CLNumber) {
            return Dimension.createFixed(state.convertDimension(Float.valueOf(corePixelDp.toPixels(cLObject.getFloat(str)))));
        }
        if (cLElement instanceof CLObject) {
            CLObject cLObject2 = (CLObject) cLElement;
            String stringOrNull = cLObject2.getStringOrNull("value");
            if (stringOrNull != null) {
                createFixed = parseDimensionMode(stringOrNull);
            }
            CLElement orNull = cLObject2.getOrNull("min");
            if (orNull != null) {
                if (orNull instanceof CLNumber) {
                    createFixed.min(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull).getFloat()))));
                } else if (orNull instanceof CLString) {
                    createFixed.min(Dimension.WRAP_DIMENSION);
                }
            }
            CLElement orNull2 = cLObject2.getOrNull("max");
            if (orNull2 != null) {
                if (orNull2 instanceof CLNumber) {
                    createFixed.max(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull2).getFloat()))));
                    return createFixed;
                }
                if (orNull2 instanceof CLString) {
                    createFixed.max(Dimension.WRAP_DIMENSION);
                }
            }
        }
        return createFixed;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long parseColorString(String str) {
        if (!str.startsWith("#")) {
            return -1L;
        }
        String substring = str.substring(1);
        if (substring.length() == 6) {
            substring = "FF" + substring;
        }
        return Long.parseLong(substring, 16);
    }

    static String lookForType(CLObject cLObject) throws CLParsingException {
        Iterator<String> it = cLObject.names().iterator();
        while (it.hasNext()) {
            if (it.next().equals(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                return cLObject.getString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            }
        }
        return null;
    }
}
