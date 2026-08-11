package com.google.firebase.installations.time;

/* loaded from: classes6.dex */
public class SystemClock implements Clock {
    private static SystemClock singleton;

    private SystemClock() {
    }

    public static SystemClock getInstance() {
        SystemClock systemClock = singleton;
        if (systemClock != null) {
            return systemClock;
        }
        SystemClock systemClock2 = new SystemClock();
        singleton = systemClock2;
        return systemClock2;
    }

    @Override // com.google.firebase.installations.time.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
