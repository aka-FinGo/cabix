package j$.time;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes3.dex */
public abstract class Clock {
    public abstract ZoneId getZone();

    public abstract Instant instant();

    public abstract long millis();

    public static Clock systemUTC() {
        return SystemClock.UTC;
    }

    public static Clock systemDefaultZone() {
        return new SystemClock(ZoneId.systemDefault());
    }

    public static Clock system(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId == ZoneOffset.UTC) {
            return SystemClock.UTC;
        }
        return new SystemClock(zoneId);
    }

    protected Clock() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SystemClock extends Clock implements Serializable {
        private static final long OFFSET_SEED = (System.currentTimeMillis() / 1000) - RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        static final SystemClock UTC = new SystemClock(ZoneOffset.UTC);
        private static final long serialVersionUID = 6740630888130243051L;
        private final ZoneId zone;

        SystemClock(ZoneId zoneId) {
            this.zone = zoneId;
        }

        @Override // j$.time.Clock
        public ZoneId getZone() {
            return this.zone;
        }

        @Override // j$.time.Clock
        public long millis() {
            return System.currentTimeMillis();
        }

        @Override // j$.time.Clock
        public Instant instant() {
            return Instant.ofEpochMilli(millis());
        }

        public boolean equals(Object obj) {
            if (obj instanceof SystemClock) {
                return this.zone.equals(((SystemClock) obj).zone);
            }
            return false;
        }

        public int hashCode() {
            return this.zone.hashCode() + 1;
        }

        public String toString() {
            return "SystemClock[" + this.zone + "]";
        }

        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
        }
    }
}
