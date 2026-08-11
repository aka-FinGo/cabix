package uz.FonRo.pos.work;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.MainActivity;
import uz.FonRo.pos.R;
import uz.FonRo.pos.ui.nav.PendingRoute;

/* compiled from: Notifier.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JX\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0007b\u0010\b\u0014\u0012\f\b\u0015\u0012\b\b\fJ\u0004\b\b(\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0005J\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001c"}, d2 = {"Luz/FonRo/pos/work/Notifier;", "", "<init>", "()V", "ID_ORDERS", "", "ID_SUPPORT", "ID_SYNC", "show", "", "context", "Landroid/content/Context;", "channelId", "", "id", "title", "text", "urgent", "", "route", "Landroid/annotation/SuppressLint;", "value", "MissingPermission", "allowed", "cancel", "openApp", "Landroid/app/PendingIntent;", "requestCode", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class Notifier {
    public static final int $stable = 0;
    public static final int ID_ORDERS = 4101;
    public static final int ID_SUPPORT = 4102;
    public static final int ID_SYNC = 4103;
    public static final Notifier INSTANCE = new Notifier();

    private Notifier() {
    }

    public static /* synthetic */ void show$default(Notifier notifier, Context context, String str, int i, String str2, String str3, boolean z, String str4, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            z = false;
        }
        notifier.show(context, str, i, str2, str3, z, (i2 & 64) != 0 ? null : str4);
    }

    public final void show(Context context, String channelId, int id, String title, String text, boolean urgent, String route) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        if (allowed(context)) {
            String str = text;
            NotificationCompat.Builder priority = new NotificationCompat.Builder(context, channelId).setSmallIcon(R.drawable.ic_stat_FonRo).setContentTitle(title).setContentText(str).setStyle(new NotificationCompat.BigTextStyle().bigText(str)).setAutoCancel(true).setContentIntent(openApp(context, id, route)).setPriority(urgent ? 1 : 0);
            Intrinsics.checkNotNullExpressionValue(priority, "setPriority(...)");
            if (urgent) {
                priority.setDefaults(-1);
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                Notifier notifier = this;
                NotificationManagerCompat.from(context).notify(id, priority.build());
                Result.m7870constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7870constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    private final boolean allowed(Context context) {
        if (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        }
        return false;
    }

    public final void cancel(Context context, int id) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            Notifier notifier = this;
            NotificationManagerCompat.from(context).cancel(id);
            Result.m7870constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final PendingIntent openApp(Context context, int requestCode, String route) {
        Intent addFlags = new Intent(context, (Class<?>) MainActivity.class).addFlags(872415232);
        Intrinsics.checkNotNullExpressionValue(addFlags, "addFlags(...)");
        if (route != null) {
            addFlags.putExtra(PendingRoute.EXTRA, route);
            addFlags.putExtra(PendingRoute.EXTRA_ID, System.currentTimeMillis());
        }
        PendingIntent activity = PendingIntent.getActivity(context, requestCode, addFlags, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }
}
