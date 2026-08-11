package kotlin.reflect;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.jvm.internal.KTypeParameterBase;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* compiled from: TypesJVM.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001c\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0083\u0080\u0004b\u0002\b\n\u001a(\u0010\u000f\u001a\u00020\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0083\u0080\u0004b\u0002\b\n\u001a\u0012\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0082\u0080\u0004\"5\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0084\br\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tr\u0002\b\nr\u0002\b\u000b¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"#\u0010\u0000\u001a\u00020\u0001*\u00020\u00148BX\u0083\u0084\br\u0002\b\n¢\u0006\f\u0012\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0005\u0010\u0016¨\u0006\u001a"}, d2 = {"javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/SinceKotlin;", "version", "1.4", "Lkotlin/ExperimentalStdlibApi;", "Lkotlin/internal/LowPriorityInOverloadResolution;", "computeJavaType", "forceWrapper", "", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "typeToString", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes6.dex */
public final class TypesJVMKt {

    /* compiled from: TypesJVM.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getJavaType$annotations(KType kType) {
    }

    private static /* synthetic */ void getJavaType$annotations(KTypeProjection kTypeProjection) {
    }

    public static final Type getJavaType(KType kType) {
        Type javaType;
        Intrinsics.checkNotNullParameter(kType, "<this>");
        return (!(kType instanceof KTypeBase) || (javaType = ((KTypeBase) kType).getJavaType()) == null) ? computeJavaType$default(kType, false, 1, null) : javaType;
    }

    static /* synthetic */ Type computeJavaType$default(KType kType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return computeJavaType(kType, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type computeJavaType(KType kType, boolean z) {
        KClassifier classifier = kType.getClassifier();
        TypeVariable<?> typeVariable = null;
        if (classifier instanceof KTypeParameter) {
            if (!(classifier instanceof KTypeParameterBase)) {
                return new ObsoleteFallbackTypeVariableImpl((KTypeParameter) classifier);
            }
            KTypeParameterBase kTypeParameterBase = (KTypeParameterBase) classifier;
            GenericDeclaration javaContainingDeclaration$kotlin_stdlib = kTypeParameterBase.getJavaContainingDeclaration$kotlin_stdlib();
            if (javaContainingDeclaration$kotlin_stdlib == null) {
                throw new UnsupportedOperationException("javaType is not supported for this type: " + kType);
            }
            TypeVariable<?>[] typeParameters = javaContainingDeclaration$kotlin_stdlib.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
            boolean z2 = false;
            for (TypeVariable<?> typeVariable2 : typeParameters) {
                if (Intrinsics.areEqual(typeVariable2.getName(), kTypeParameterBase.getName())) {
                    if (z2) {
                        throw new IllegalArgumentException("Array contains more than one matching element.");
                    }
                    z2 = true;
                    typeVariable = typeVariable2;
                }
            }
            if (z2) {
                Intrinsics.checkNotNullExpressionValue(typeVariable, "single(...)");
                return typeVariable;
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        if (classifier instanceof KClass) {
            KClass kClass = (KClass) classifier;
            Class javaObjectType = z ? JvmClassMappingKt.getJavaObjectType(kClass) : JvmClassMappingKt.getJavaClass(kClass);
            List<KTypeProjection> arguments = kType.getArguments();
            if (arguments.isEmpty()) {
                return javaObjectType;
            }
            if (javaObjectType.isArray()) {
                if (javaObjectType.getComponentType().isPrimitive()) {
                    return javaObjectType;
                }
                KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.singleOrNull((List) arguments);
                if (kTypeProjection == null) {
                    throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
                }
                KVariance variance = kTypeProjection.getVariance();
                KType type = kTypeProjection.getType();
                int i = variance == null ? -1 : WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
                if (i == -1 || i == 1) {
                    return javaObjectType;
                }
                if (i != 2 && i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                Intrinsics.checkNotNull(type);
                Type computeJavaType$default = computeJavaType$default(type, false, 1, null);
                return computeJavaType$default instanceof Class ? javaObjectType : new GenericArrayTypeImpl(computeJavaType$default);
            }
            return createPossiblyInnerType(javaObjectType, arguments);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
    }

    private static final Type createPossiblyInnerType(Class<?> cls, List<KTypeProjection> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            List<KTypeProjection> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(getJavaType((KTypeProjection) it.next()));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            Class<?> cls2 = declaringClass;
            List<KTypeProjection> list3 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(getJavaType((KTypeProjection) it2.next()));
            }
            return new ParameterizedTypeImpl(cls, cls2, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type createPossiblyInnerType = createPossiblyInnerType(declaringClass, list.subList(length, list.size()));
        List<KTypeProjection> subList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(subList, 10));
        Iterator<T> it3 = subList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(getJavaType((KTypeProjection) it3.next()));
        }
        return new ParameterizedTypeImpl(cls, createPossiblyInnerType, arrayList3);
    }

    private static final Type getJavaType(KTypeProjection kTypeProjection) {
        KVariance variance = kTypeProjection.getVariance();
        if (variance == null) {
            return WildcardTypeImpl.INSTANCE.getSTAR();
        }
        KType type = kTypeProjection.getType();
        Intrinsics.checkNotNull(type);
        int i = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i == 1) {
            return new WildcardTypeImpl(null, computeJavaType(type, true));
        }
        if (i == 2) {
            return computeJavaType(type, true);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return new WildcardTypeImpl(computeJavaType(type, true), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String typeToString(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                Sequence generateSequence = SequencesKt.generateSequence(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
                return ((Class) SequencesKt.last(generateSequence)).getName() + StringsKt.repeat(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, SequencesKt.count(generateSequence));
            }
            String name = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return name;
        }
        return type.toString();
    }
}
