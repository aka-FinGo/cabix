package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.time.Clock;
import com.google.firebase.installations.time.SystemClock;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public final class Utils {
    private static final Pattern API_KEY_FORMAT;
    private static final String APP_ID_IDENTIFICATION_SUBSTRING = ":";
    public static final long AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS;
    private static Utils singleton;
    private final Clock clock;

    static {
        TimeUnit timeUnit = TimeUnit.HOURS;
        AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS = 3600L;
        API_KEY_FORMAT = Pattern.compile("\\AA[\\w-]{38}\\z");
    }

    private Utils(Clock clock) {
        this.clock = clock;
    }

    public static Utils getInstance() {
        return getInstance(SystemClock.getInstance());
    }

    public static Utils getInstance(Clock clock) {
        Utils utils = singleton;
        if (utils != null) {
            return utils;
        }
        Utils utils2 = new Utils(clock);
        singleton = utils2;
        return utils2;
    }

    public boolean isAuthTokenExpired(PersistedInstallationEntry persistedInstallationEntry) {
        return TextUtils.isEmpty(persistedInstallationEntry.getAuthToken()) || persistedInstallationEntry.getTokenCreationEpochInSecs() + persistedInstallationEntry.getExpiresInSecs() < currentTimeInSecs() + AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS;
    }

    public long currentTimeInSecs() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return currentTimeInMillis() / 1000;
    }

    public long currentTimeInMillis() {
        return this.clock.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidAppIdFormat(String str) {
        return str.contains(APP_ID_IDENTIFICATION_SUBSTRING);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidApiKeyFormat(String str) {
        return API_KEY_FORMAT.matcher(str).matches();
    }

    public long getRandomDelayForSyncPrevention() {
        return (long) (Math.random() * 1000.0d);
    }
}
