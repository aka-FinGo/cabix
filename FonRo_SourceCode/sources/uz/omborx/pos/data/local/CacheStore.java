package uz.FonRo.pos.data.local;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;
import uz.FonRo.pos.data.net.ApiClient;

/* compiled from: CacheStore.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u00102\u0006\u0010\u0011\u001a\u0002H\f¢\u0006\u0002\u0010\u0012J)\u0010\u0013\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u0010¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0017"}, d2 = {"Luz/FonRo/pos/data/local/CacheStore;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "dir", "Ljava/io/File;", "json", "Lkotlinx/serialization/json/Json;", "save", "", ExifInterface.GPS_DIRECTION_TRUE, "name", "", "serializer", "Lkotlinx/serialization/KSerializer;", "value", "(Ljava/lang/String;Lkotlinx/serialization/KSerializer;Ljava/lang/Object;)V", "load", "(Ljava/lang/String;Lkotlinx/serialization/KSerializer;)Ljava/lang/Object;", "clear", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class CacheStore {
    public static final String CATEGORIES = "categories";
    public static final String PRODUCTS = "products";
    public static final String SESSION = "session";
    public static final String SYNC = "sync";
    private final File dir;
    private final Json json;
    public static final int $stable = 8;

    public CacheStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File file = new File(context.getFilesDir(), "cache");
        file.mkdirs();
        this.dir = file;
        this.json = ApiClient.INSTANCE.getJson();
    }

    public final <T> void save(String name, KSerializer<T> serializer, T value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        try {
            Result.Companion companion = Result.INSTANCE;
            CacheStore cacheStore = this;
            File file = new File(this.dir, name + ".json");
            File file2 = new File(this.dir, name + ".json.tmp");
            FilesKt.writeText$default(file2, this.json.encodeToString(serializer, value), null, 2, null);
            if (file.exists()) {
                file.delete();
            }
            Result.m7870constructorimpl(Boolean.valueOf(file2.renameTo(file)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final <T> T load(String name, KSerializer<T> serializer) {
        Object m7870constructorimpl;
        File file;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        try {
            Result.Companion companion = Result.INSTANCE;
            CacheStore cacheStore = this;
            file = new File(this.dir, name + ".json");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        if (!file.exists()) {
            return null;
        }
        m7870constructorimpl = Result.m7870constructorimpl(this.json.decodeFromString(serializer, FilesKt.readText$default(file, null, 1, null)));
        if (Result.m7876isFailureimpl(m7870constructorimpl)) {
            return null;
        }
        return (T) m7870constructorimpl;
    }

    public final void clear() {
        Unit unit;
        try {
            Result.Companion companion = Result.INSTANCE;
            CacheStore cacheStore = this;
            File[] listFiles = this.dir.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    file.delete();
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m7870constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
    }
}
