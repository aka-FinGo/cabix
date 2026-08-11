package kotlin.io.path;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttributeView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PathRecursiveFunctions.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012Q\b\u0002\u0010\u0003\u001aK\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u00150\bj\u0002`\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0087\u0080\bb\u0002\b\u000fb\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012b\u0002\b\u0013\u001aÌ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012Q\b\u0002\u0010\u0003\u001aK\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u00150\bj\u0002`\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\f\u001a\u00020\r2C\b\u0002\u0010\u0014\u001a=\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\u0002\b\u0017H\u0087\u0080\bb\u0002\b\u000fb\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012b\u0002\b\u0013\u001a\u0017\u0010\u0018\u001a\u00020\u0019*\u00020\u0016H\u0083\u0080\u0004b\u0002\b\u000f¢\u0006\u0002\b\u001a\u001a\u0017\u0010\u0018\u001a\u00020\u0019*\u00020\u000bH\u0083\u0080\u0004b\u0002\b\u000f¢\u0006\u0002\b\u001a\u001a \u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\u0087\u0080\u0004b\u0002\b\u000fb\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u001a\u001d\u0010\u001d\u001a\f\u0012\b\u0012\u00060\bj\u0002`\n0\u001e*\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u001f\u001a%\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0$H\u0082\u0088\u0004¢\u0006\u0002\b%\u001a'\u0010&\u001a\u0004\u0018\u0001H'\"\u0004\b\u0000\u0010'2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H'0$H\u0082\u0088\u0004¢\u0006\u0004\b(\u0010)\u001a3\u0010*\u001a\u00020\u001c*\b\u0012\u0004\u0012\u00020\u00010+2\u0006\u0010\u0006\u001a\u00020\u00012\b\u0010,\u001a\u0004\u0018\u00010\u00012\u0006\u0010!\u001a\u00020\"H\u0082\u0080\u0004¢\u0006\u0002\b-\u001a)\u0010.\u001a\u00020\u001c*\b\u0012\u0004\u0012\u00020\u00010+2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"H\u0082\u0080\u0004¢\u0006\u0002\b/\u001a7\u00100\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00010+2\u0006\u00101\u001a\u00020\u00012\u0012\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u00020403\"\u000204H\u0082\u0080\u0004¢\u0006\u0004\b5\u00106\u001a)\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u00012\b\u0010,\u001a\u0004\u0018\u00010\u00012\u0006\u0010!\u001a\u00020\"H\u0082\u0080\u0004¢\u0006\u0002\b9\u001a\u001f\u0010:\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"H\u0082\u0080\u0004¢\u0006\u0002\b<\u001a\u000e\u0010=\u001a\u00020\u001c*\u00020\u0001H\u0080\u0080\u0004\u001a\u001b\u0010>\u001a\u00020\u001c*\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b?¨\u0006@"}, d2 = {"copyToRecursively", "Ljava/nio/file/Path;", TypedValues.AttributesType.S_TARGET, "onError", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.SOURCE, "Ljava/lang/Exception;", "exception", "Lkotlin/Exception;", "Lkotlin/io/path/OnErrorResult;", "followLinks", "", "overwrite", "Lkotlin/io/path/ExperimentalPathApi;", "Lkotlin/SinceKotlin;", "version", "1.8", "Lkotlin/IgnorableReturnValue;", "copyAction", "Lkotlin/io/path/CopyActionContext;", "Lkotlin/io/path/CopyActionResult;", "Lkotlin/ExtensionFunctionType;", "toFileVisitResult", "Ljava/nio/file/FileVisitResult;", "toFileVisitResult$PathsKt__PathRecursiveFunctionsKt", "deleteRecursively", "", "deleteRecursivelyImpl", "", "deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt", "collectIfThrows", "collector", "Lkotlin/io/path/ExceptionsCollector;", "function", "Lkotlin/Function0;", "collectIfThrows$PathsKt__PathRecursiveFunctionsKt", "tryIgnoreNoSuchFileException", "R", "tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "handleEntry", "Ljava/nio/file/SecureDirectoryStream;", "parent", "handleEntry$PathsKt__PathRecursiveFunctionsKt", "enterDirectory", "enterDirectory$PathsKt__PathRecursiveFunctionsKt", "isDirectory", "entryName", "options", "", "Ljava/nio/file/LinkOption;", "isDirectory$PathsKt__PathRecursiveFunctionsKt", "(Ljava/nio/file/SecureDirectoryStream;Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "insecureHandleEntry", "entry", "insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt", "insecureEnterDirectory", "path", "insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt", "checkFileName", "checkNotSameAs", "checkNotSameAs$PathsKt__PathRecursiveFunctionsKt", "kotlin-stdlib-jdk7"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
/* loaded from: classes6.dex */
public class PathsKt__PathRecursiveFunctionsKt extends PathsKt__PathReadWriteKt {

    /* compiled from: PathRecursiveFunctions.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CopyActionResult.values().length];
            try {
                iArr[CopyActionResult.CONTINUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CopyActionResult.TERMINATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[OnErrorResult.values().length];
            try {
                iArr2[OnErrorResult.TERMINATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OnErrorResult.SKIP_SUBTREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static /* synthetic */ Path copyToRecursively$default(Path path, Path path2, Function3 function3, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = new Function3() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    OnErrorResult copyToRecursively$lambda$0$PathsKt__PathRecursiveFunctionsKt;
                    copyToRecursively$lambda$0$PathsKt__PathRecursiveFunctionsKt = PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$0$PathsKt__PathRecursiveFunctionsKt((Path) obj2, (Path) obj3, (Exception) obj4);
                    return copyToRecursively$lambda$0$PathsKt__PathRecursiveFunctionsKt;
                }
            };
        }
        return PathsKt.copyToRecursively(path, path2, (Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult>) function3, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnErrorResult copyToRecursively$lambda$0$PathsKt__PathRecursiveFunctionsKt(Path path, Path path2, Exception exception) {
        Intrinsics.checkNotNullParameter(path, "<unused var>");
        Intrinsics.checkNotNullParameter(path2, "<unused var>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        throw exception;
    }

    @IgnorableReturnValue
    public static final Path copyToRecursively(Path path, Path target, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> onError, final boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (z2) {
            return PathsKt.copyToRecursively(path, target, onError, z, (Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult>) new Function3() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    CopyActionResult copyToRecursively$lambda$1$PathsKt__PathRecursiveFunctionsKt;
                    copyToRecursively$lambda$1$PathsKt__PathRecursiveFunctionsKt = PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$1$PathsKt__PathRecursiveFunctionsKt(z, (CopyActionContext) obj, (Path) obj2, (Path) obj3);
                    return copyToRecursively$lambda$1$PathsKt__PathRecursiveFunctionsKt;
                }
            });
        }
        return PathsKt.copyToRecursively$default(path, target, onError, z, (Function3) null, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CopyActionResult copyToRecursively$lambda$1$PathsKt__PathRecursiveFunctionsKt(boolean z, CopyActionContext copyToRecursively, Path src, Path dst) {
        LinkOption linkOption;
        boolean isDirectory;
        boolean isDirectory2;
        StandardCopyOption standardCopyOption;
        Path copy;
        Intrinsics.checkNotNullParameter(copyToRecursively, "$this$copyToRecursively");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        LinkOption[] linkOptions = LinkFollowing.INSTANCE.toLinkOptions(z);
        linkOption = LinkOption.NOFOLLOW_LINKS;
        isDirectory = Files.isDirectory(dst, (LinkOption[]) Arrays.copyOf(new LinkOption[]{linkOption}, 1));
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
        isDirectory2 = Files.isDirectory(src, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        if (!isDirectory2 || !isDirectory) {
            if (isDirectory) {
                PathsKt.deleteRecursively(dst);
            }
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.addSpread(linkOptions);
            standardCopyOption = StandardCopyOption.REPLACE_EXISTING;
            spreadBuilder.add(standardCopyOption);
            CopyOption[] copyOptionArr = (CopyOption[]) spreadBuilder.toArray(new CopyOption[spreadBuilder.size()]);
            copy = Files.copy(src, dst, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
            Intrinsics.checkNotNullExpressionValue(copy, "copy(...)");
        }
        return CopyActionResult.CONTINUE;
    }

    public static /* synthetic */ Path copyToRecursively$default(Path path, Path path2, Function3 function3, final boolean z, Function3 function32, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = new Function3() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    OnErrorResult copyToRecursively$lambda$2$PathsKt__PathRecursiveFunctionsKt;
                    copyToRecursively$lambda$2$PathsKt__PathRecursiveFunctionsKt = PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$2$PathsKt__PathRecursiveFunctionsKt((Path) obj2, (Path) obj3, (Exception) obj4);
                    return copyToRecursively$lambda$2$PathsKt__PathRecursiveFunctionsKt;
                }
            };
        }
        if ((i & 8) != 0) {
            function32 = new Function3() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    CopyActionResult copyToRecursively$lambda$3$PathsKt__PathRecursiveFunctionsKt;
                    copyToRecursively$lambda$3$PathsKt__PathRecursiveFunctionsKt = PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$3$PathsKt__PathRecursiveFunctionsKt(z, (CopyActionContext) obj2, (Path) obj3, (Path) obj4);
                    return copyToRecursively$lambda$3$PathsKt__PathRecursiveFunctionsKt;
                }
            };
        }
        return PathsKt.copyToRecursively(path, path2, (Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult>) function3, z, (Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult>) function32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnErrorResult copyToRecursively$lambda$2$PathsKt__PathRecursiveFunctionsKt(Path path, Path path2, Exception exception) {
        Intrinsics.checkNotNullParameter(path, "<unused var>");
        Intrinsics.checkNotNullParameter(path2, "<unused var>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        throw exception;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CopyActionResult copyToRecursively$lambda$3$PathsKt__PathRecursiveFunctionsKt(boolean z, CopyActionContext copyActionContext, Path src, Path dst) {
        Intrinsics.checkNotNullParameter(copyActionContext, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        return copyActionContext.copyToIgnoringExistingDirectory(src, dst, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
    
        if (r7 == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0043, code lost:
    
        if (r3 == false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b1  */
    @kotlin.IgnorableReturnValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.nio.file.Path copyToRecursively(final java.nio.file.Path r9, final java.nio.file.Path r10, final kotlin.jvm.functions.Function3<? super java.nio.file.Path, ? super java.nio.file.Path, ? super java.lang.Exception, ? extends kotlin.io.path.OnErrorResult> r11, boolean r12, final kotlin.jvm.functions.Function3<? super kotlin.io.path.CopyActionContext, ? super java.nio.file.Path, ? super java.nio.file.Path, ? extends kotlin.io.path.CopyActionResult> r13) {
        /*
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            java.lang.String r1 = "target"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            java.lang.String r1 = "onError"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            java.lang.String r1 = "copyAction"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            kotlin.io.path.LinkFollowing r1 = kotlin.io.path.LinkFollowing.INSTANCE
            java.nio.file.LinkOption[] r1 = r1.toLinkOptions(r12)
            int r3 = r1.length
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r3)
            java.nio.file.LinkOption[] r1 = (java.nio.file.LinkOption[]) r1
            int r3 = r1.length
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r3)
            java.nio.file.LinkOption[] r1 = (java.nio.file.LinkOption[]) r1
            boolean r1 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m$1(r9, r1)
            if (r1 == 0) goto Le0
            r1 = 0
            java.nio.file.LinkOption[] r3 = new java.nio.file.LinkOption[r1]
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r1)
            java.nio.file.LinkOption[] r3 = (java.nio.file.LinkOption[]) r3
            boolean r3 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m$1(r9, r3)
            if (r3 == 0) goto Lc3
            if (r12 != 0) goto L45
            boolean r3 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9151m$1(r9)
            if (r3 != 0) goto Lc3
        L45:
            java.nio.file.LinkOption[] r3 = new java.nio.file.LinkOption[r1]
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r1)
            java.nio.file.LinkOption[] r3 = (java.nio.file.LinkOption[]) r3
            boolean r3 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m$1(r10, r3)
            r5 = 1
            if (r3 == 0) goto L5c
            boolean r3 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9151m$1(r10)
            if (r3 != 0) goto L5c
            r3 = r5
            goto L5d
        L5c:
            r3 = r1
        L5d:
            if (r3 == 0) goto L65
            boolean r7 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9145m(r9, r10)
            if (r7 != 0) goto Lc3
        L65:
            java.nio.file.FileSystem r7 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9122m(r9)
            java.nio.file.FileSystem r8 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9122m(r10)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
            if (r7 != 0) goto L74
            goto Lae
        L74:
            if (r3 == 0) goto L87
            java.nio.file.LinkOption[] r3 = new java.nio.file.LinkOption[r1]
            java.nio.file.Path r3 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m(r10, r3)
            java.nio.file.LinkOption[] r1 = new java.nio.file.LinkOption[r1]
            java.nio.file.Path r1 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m(r9, r1)
            boolean r1 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9152m$1(r3, r1)
            goto Lae
        L87:
            java.nio.file.Path r3 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m$1(r10)
            if (r3 == 0) goto Lae
            java.nio.file.LinkOption[] r7 = new java.nio.file.LinkOption[r1]
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r1)
            java.nio.file.LinkOption[] r7 = (java.nio.file.LinkOption[]) r7
            boolean r7 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m$1(r3, r7)
            if (r7 == 0) goto Lae
            java.nio.file.LinkOption[] r7 = new java.nio.file.LinkOption[r1]
            java.nio.file.Path r3 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m(r3, r7)
            java.nio.file.LinkOption[] r7 = new java.nio.file.LinkOption[r1]
            java.nio.file.Path r7 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m(r9, r7)
            boolean r3 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9152m$1(r3, r7)
            if (r3 == 0) goto Lae
            r1 = r5
        Lae:
            if (r1 != 0) goto Lb1
            goto Lc3
        Lb1:
            kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9142m()
            java.lang.String r0 = r9.toString()
            java.lang.String r1 = r10.toString()
            java.lang.String r2 = "Recursively copying a directory into its subdirectory is prohibited."
            java.nio.file.FileSystemException r0 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m(r0, r1, r2)
            throw r0
        Lc3:
            java.nio.file.Path r5 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m$2(r10)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda29 r3 = new kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda29
            r4 = r10
            r6 = r11
            r2 = r13
            r0 = r3
            r3 = r9
            r0.<init>()
            r4 = 1
            r5 = 0
            r1 = 0
            r2 = r12
            r3 = r0
            r0 = r9
            kotlin.io.path.PathsKt.visitFileTree$default(r0, r1, r2, r3, r4, r5)
            return r10
        Le0:
            kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9153m$2()
            java.lang.String r0 = r9.toString()
            java.lang.String r1 = r10.toString()
            java.lang.String r2 = "The source file doesn't exist."
            java.nio.file.NoSuchFileException r0 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9130m(r0, r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.copyToRecursively(java.nio.file.Path, java.nio.file.Path, kotlin.jvm.functions.Function3, boolean, kotlin.jvm.functions.Function3):java.nio.file.Path");
    }

    private static final Path copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(Path path, Path path2, Path path3, Path path4) {
        Path resolve;
        Path normalize;
        boolean startsWith;
        resolve = path2.resolve(PathsKt.relativeTo(path4, path).toString());
        normalize = resolve.normalize();
        startsWith = normalize.startsWith(path3);
        if (!startsWith) {
            throw new IllegalFileNameException(path4, resolve, "Copying files to outside the specified target directory is prohibited. The directory being recursively copied might contain an entry with an illegal name.");
        }
        Intrinsics.checkNotNull(resolve);
        return resolve;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, Path path, Path path2, Path path3, Path path4, Exception exc) {
        return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(function3.invoke(path4, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(path, path2, path3, path4), exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(ArrayList<Path> arrayList, Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path path, Path path2, Path path3, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function32, Path path4, BasicFileAttributes basicFileAttributes) {
        try {
            if (!arrayList.isEmpty()) {
                PathsKt.checkFileName(path4);
                Object last = CollectionsKt.last((List<? extends Object>) arrayList);
                Intrinsics.checkNotNullExpressionValue(last, "last(...)");
                checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(path4, PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9131m(last));
            }
            return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(function3.invoke(DefaultCopyActionContext.INSTANCE, path4, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(path, path2, path3, path4)));
        } catch (Exception e) {
            return copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(function32, path, path2, path3, path4, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyToRecursively$lambda$5$PathsKt__PathRecursiveFunctionsKt(final ArrayList arrayList, final Function3 function3, final Path path, final Path path2, final Path path3, final Function3 function32, FileVisitorBuilder visitFileTree) {
        Intrinsics.checkNotNullParameter(visitFileTree, "$this$visitFileTree");
        visitFileTree.onPreVisitDirectory(new Function2() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                FileVisitResult copyToRecursively$lambda$5$0$PathsKt__PathRecursiveFunctionsKt;
                copyToRecursively$lambda$5$0$PathsKt__PathRecursiveFunctionsKt = PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$5$0$PathsKt__PathRecursiveFunctionsKt(arrayList, function3, path, path2, path3, function32, (Path) obj, (BasicFileAttributes) obj2);
                return copyToRecursively$lambda$5$0$PathsKt__PathRecursiveFunctionsKt;
            }
        });
        visitFileTree.onVisitFile(new PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$2(arrayList, function3, path, path2, path3, function32));
        visitFileTree.onVisitFileFailed(new PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$3(function32, path, path2, path3));
        visitFileTree.onPostVisitDirectory(new Function2() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                FileVisitResult copyToRecursively$lambda$5$1$PathsKt__PathRecursiveFunctionsKt;
                copyToRecursively$lambda$5$1$PathsKt__PathRecursiveFunctionsKt = PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$5$1$PathsKt__PathRecursiveFunctionsKt(arrayList, function32, path, path2, path3, (Path) obj, (IOException) obj2);
                return copyToRecursively$lambda$5$1$PathsKt__PathRecursiveFunctionsKt;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult copyToRecursively$lambda$5$0$PathsKt__PathRecursiveFunctionsKt(ArrayList arrayList, Function3 function3, Path path, Path path2, Path path3, Function3 function32, Path directory, BasicFileAttributes attributes) {
        FileVisitResult fileVisitResult;
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        FileVisitResult copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt = copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(arrayList, function3, path, path2, path3, function32, directory, attributes);
        fileVisitResult = FileVisitResult.CONTINUE;
        if (copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt == fileVisitResult) {
            arrayList.add(directory);
        }
        return copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult copyToRecursively$lambda$5$1$PathsKt__PathRecursiveFunctionsKt(ArrayList arrayList, Function3 function3, Path path, Path path2, Path path3, Path directory, IOException iOException) {
        FileVisitResult fileVisitResult;
        Intrinsics.checkNotNullParameter(directory, "directory");
        CollectionsKt.removeLast(arrayList);
        if (iOException == null) {
            fileVisitResult = FileVisitResult.CONTINUE;
            return fileVisitResult;
        }
        return copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(function3, path, path2, path3, directory, iOException);
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(CopyActionResult copyActionResult) {
        FileVisitResult fileVisitResult;
        FileVisitResult fileVisitResult2;
        FileVisitResult fileVisitResult3;
        int i = WhenMappings.$EnumSwitchMapping$0[copyActionResult.ordinal()];
        if (i == 1) {
            fileVisitResult = FileVisitResult.CONTINUE;
            return fileVisitResult;
        }
        if (i == 2) {
            fileVisitResult2 = FileVisitResult.TERMINATE;
            return fileVisitResult2;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        fileVisitResult3 = FileVisitResult.SKIP_SUBTREE;
        return fileVisitResult3;
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(OnErrorResult onErrorResult) {
        FileVisitResult fileVisitResult;
        FileVisitResult fileVisitResult2;
        int i = WhenMappings.$EnumSwitchMapping$1[onErrorResult.ordinal()];
        if (i == 1) {
            fileVisitResult = FileVisitResult.TERMINATE;
            return fileVisitResult;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        fileVisitResult2 = FileVisitResult.SKIP_SUBTREE;
        return fileVisitResult2;
    }

    public static final void deleteRecursively(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        List<Exception> deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt = deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(path);
        if (deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt.isEmpty()) {
            return;
        }
        FileSystemException m = PathTreeWalk$$ExternalSyntheticApiModelOutline0.m("Failed to delete one or more files. See suppressed exceptions for details.");
        Iterator<T> it = deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt.iterator();
        while (it.hasNext()) {
            ExceptionsKt.addSuppressed(m, (Exception) it.next());
        }
        throw m;
    }

    private static final List<Exception> deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(Path path) {
        Path fileName;
        Path parent;
        DirectoryStream directoryStream;
        FileSystem fileSystem;
        boolean z = false;
        boolean z2 = true;
        ExceptionsCollector exceptionsCollector = new ExceptionsCollector(0, 1, null);
        fileName = path.getFileName();
        if (fileName != null) {
            parent = path.getParent();
            if (parent == null) {
                fileSystem = path.getFileSystem();
                parent = fileSystem.getPath("", new String[0]);
            }
            try {
                directoryStream = Files.newDirectoryStream(parent);
            } catch (Throwable unused) {
                directoryStream = null;
            }
            if (directoryStream != null) {
                DirectoryStream directoryStream2 = directoryStream;
                try {
                    DirectoryStream m = PathTreeWalk$$ExternalSyntheticApiModelOutline0.m((Object) directoryStream2);
                    if (PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9143m((Object) m)) {
                        exceptionsCollector.setPath(parent);
                        handleEntry$PathsKt__PathRecursiveFunctionsKt(PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9134m((Object) m), fileName, null, exceptionsCollector);
                    } else {
                        z = true;
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(directoryStream2, null);
                    z2 = z;
                } finally {
                }
            }
        }
        if (z2) {
            insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(path, null, exceptionsCollector);
        }
        return exceptionsCollector.getCollectedExceptions();
    }

    private static final void collectIfThrows$PathsKt__PathRecursiveFunctionsKt(ExceptionsCollector exceptionsCollector, Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (Exception e) {
            exceptionsCollector.collect(e);
        }
    }

    private static final <R> R tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt(Function0<? extends R> function0) {
        try {
            return function0.invoke();
        } catch (NoSuchFileException unused) {
            return null;
        }
    }

    private static final void handleEntry$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> secureDirectoryStream, Path path, Path path2, ExceptionsCollector exceptionsCollector) {
        LinkOption linkOption;
        exceptionsCollector.enterEntry(path);
        if (path2 != null) {
            try {
                Path path3 = exceptionsCollector.getPath();
                Intrinsics.checkNotNull(path3);
                PathsKt.checkFileName(path3);
                checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(path3, path2);
            } catch (Exception e) {
                exceptionsCollector.collect(e);
            }
        }
        linkOption = LinkOption.NOFOLLOW_LINKS;
        if (isDirectory$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream, path, linkOption)) {
            int totalExceptions = exceptionsCollector.getTotalExceptions();
            enterDirectory$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream, path, exceptionsCollector);
            if (totalExceptions == exceptionsCollector.getTotalExceptions()) {
                secureDirectoryStream.deleteDirectory(path);
                Unit unit = Unit.INSTANCE;
            }
            exceptionsCollector.exitEntry(path);
        }
        secureDirectoryStream.deleteFile(path);
        Unit unit2 = Unit.INSTANCE;
        exceptionsCollector.exitEntry(path);
    }

    private static final void enterDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> secureDirectoryStream, Path path, ExceptionsCollector exceptionsCollector) {
        SecureDirectoryStream secureDirectoryStream2;
        Iterator it;
        Path fileName;
        LinkOption linkOption;
        try {
            try {
                linkOption = LinkOption.NOFOLLOW_LINKS;
                secureDirectoryStream2 = secureDirectoryStream.newDirectoryStream(path, linkOption);
            } catch (Exception e) {
                exceptionsCollector.collect(e);
                return;
            }
        } catch (NoSuchFileException unused) {
            secureDirectoryStream2 = null;
        }
        if (secureDirectoryStream2 == null) {
            return;
        }
        SecureDirectoryStream secureDirectoryStream3 = secureDirectoryStream2;
        try {
            SecureDirectoryStream m9134m = PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9134m((Object) secureDirectoryStream3);
            it = m9134m.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                fileName = PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9131m(it.next()).getFileName();
                Intrinsics.checkNotNullExpressionValue(fileName, "getFileName(...)");
                handleEntry$PathsKt__PathRecursiveFunctionsKt(m9134m, fileName, exceptionsCollector.getPath(), exceptionsCollector);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(secureDirectoryStream3, null);
        } finally {
        }
    }

    private static final boolean isDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> secureDirectoryStream, Path path, LinkOption... linkOptionArr) {
        Boolean bool;
        FileAttributeView fileAttributeView;
        BasicFileAttributes readAttributes;
        boolean isDirectory;
        try {
            fileAttributeView = secureDirectoryStream.getFileAttributeView(path, PathTreeWalk$$ExternalSyntheticApiModelOutline0.m$1(), (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
            readAttributes = PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9137m((Object) fileAttributeView).readAttributes();
            isDirectory = readAttributes.isDirectory();
            bool = Boolean.valueOf(isDirectory);
        } catch (NoSuchFileException unused) {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static final void insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(Path path, Path path2, ExceptionsCollector exceptionsCollector) {
        LinkOption linkOption;
        boolean isDirectory;
        if (path2 != null) {
            try {
                PathsKt.checkFileName(path);
                checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(path, path2);
            } catch (Exception e) {
                exceptionsCollector.collect(e);
                return;
            }
        }
        linkOption = LinkOption.NOFOLLOW_LINKS;
        isDirectory = Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{linkOption}, 1));
        if (isDirectory) {
            int totalExceptions = exceptionsCollector.getTotalExceptions();
            insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(path, exceptionsCollector);
            if (totalExceptions == exceptionsCollector.getTotalExceptions()) {
                Files.deleteIfExists(path);
                return;
            }
            return;
        }
        Files.deleteIfExists(path);
    }

    private static final void insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(Path path, ExceptionsCollector exceptionsCollector) {
        DirectoryStream directoryStream;
        Iterator it;
        try {
            try {
                directoryStream = Files.newDirectoryStream(path);
            } catch (Exception e) {
                exceptionsCollector.collect(e);
                return;
            }
        } catch (NoSuchFileException unused) {
            directoryStream = null;
        }
        if (directoryStream == null) {
            return;
        }
        DirectoryStream directoryStream2 = directoryStream;
        try {
            it = PathTreeWalk$$ExternalSyntheticApiModelOutline0.m((Object) directoryStream2).iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Path m9131m = PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9131m(it.next());
                Intrinsics.checkNotNull(m9131m);
                insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(m9131m, path, exceptionsCollector);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(directoryStream2, null);
        } finally {
        }
    }

    public static final void checkFileName(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        String name = PathsKt.getName(path);
        int hashCode = name.hashCode();
        if (hashCode != 46) {
            if (hashCode != 1518) {
                if (hashCode != 45679) {
                    if (hashCode != 45724) {
                        if (hashCode != 1472) {
                            if (hashCode != 1473 || !name.equals("./")) {
                                return;
                            }
                        } else if (!name.equals("..")) {
                            return;
                        }
                    } else if (!name.equals("..\\")) {
                        return;
                    }
                } else if (!name.equals("../")) {
                    return;
                }
            } else if (!name.equals(".\\")) {
                return;
            }
        } else if (!name.equals(".")) {
            return;
        }
        throw new IllegalFileNameException(path);
    }

    private static final void checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(Path path, Path path2) {
        boolean isSymbolicLink;
        boolean isSameFile;
        isSymbolicLink = Files.isSymbolicLink(path);
        if (isSymbolicLink) {
            return;
        }
        isSameFile = Files.isSameFile(path, path2);
        if (isSameFile) {
            PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9150m$1();
            throw PathTreeWalk$$ExternalSyntheticApiModelOutline0.m9124m(path.toString());
        }
    }
}
