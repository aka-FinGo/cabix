package coil.fetch;

import android.adservices.signals.UpdateSignalsRequest;
import android.adservices.topics.EncryptedTopic;
import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.app.ApplicationExitInfo;
import android.app.NotificationChannel;
import android.content.res.loader.ResourcesLoader;
import android.graphics.drawable.ColorStateListDrawable;
import android.net.Uri;
import dalvik.system.DelegateLastClassLoader;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes5.dex */
public final /* synthetic */ class ContentUriFetcher$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ UpdateSignalsRequest.Builder m(Uri uri) {
        return new UpdateSignalsRequest.Builder(uri);
    }

    public static /* bridge */ /* synthetic */ EncryptedTopic m(Object obj) {
        return (EncryptedTopic) obj;
    }

    public static /* synthetic */ GetTopicsRequest.Builder m() {
        return new GetTopicsRequest.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ GetTopicsResponse m7662m(Object obj) {
        return (GetTopicsResponse) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Topic m7663m(Object obj) {
        return (Topic) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ TopicsManager m7665m(Object obj) {
        return (TopicsManager) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ApplicationExitInfo m7666m(Object obj) {
        return (ApplicationExitInfo) obj;
    }

    public static /* synthetic */ NotificationChannel m(String str, CharSequence charSequence, int i) {
        return new NotificationChannel(str, charSequence, i);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ ResourcesLoader m7668m() {
        return new ResourcesLoader();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ColorStateListDrawable m7669m(Object obj) {
        return (ColorStateListDrawable) obj;
    }

    public static /* synthetic */ DelegateLastClassLoader m(String str, ClassLoader classLoader) {
        return new DelegateLastClassLoader(str, classLoader);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m7672m() {
        return TopicsManager.class;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m7675m() {
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m7677m(Object obj) {
        return obj instanceof ColorStateListDrawable;
    }

    public static /* synthetic */ void m$1() {
    }

    public static /* synthetic */ void m$2() {
    }
}
