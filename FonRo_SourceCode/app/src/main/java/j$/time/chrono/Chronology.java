package j$.time.chrono;

import j$.time.DateTimeException;
import j$.time.Instant;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.format.ResolverStyle;
import j$.time.temporal.ChronoField;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQueries;
import j$.time.temporal.ValueRange;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public interface Chronology extends Comparable<Chronology> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Comparable
    int compareTo(Chronology chronology);

    ChronoLocalDate date(int i, int i2, int i3);

    ChronoLocalDate date(TemporalAccessor temporalAccessor);

    ChronoLocalDate dateEpochDay(long j);

    ChronoLocalDate dateNow();

    ChronoLocalDate dateYearDay(int i, int i2);

    boolean equals(Object obj);

    Era eraOf(int i);

    List eras();

    String getCalendarType();

    String getId();

    int hashCode();

    boolean isLeapYear(long j);

    int prolepticYear(Era era, int i);

    ValueRange range(ChronoField chronoField);

    ChronoLocalDate resolveDate(Map map, ResolverStyle resolverStyle);

    String toString();

    static Chronology from(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        return (Chronology) ZoneId.AnonymousClass3.m((Chronology) temporalAccessor.query(TemporalQueries.chronology()), IsoChronology.INSTANCE);
    }

    static Chronology ofLocale(Locale locale) {
        return AbstractChronology.ofLocale(locale);
    }

    static Chronology of(String str) {
        return AbstractChronology.of(str);
    }

    default ChronoLocalDateTime localDateTime(TemporalAccessor temporalAccessor) {
        try {
            return date(temporalAccessor).atTime(LocalTime.from(temporalAccessor));
        } catch (DateTimeException e) {
            throw new DateTimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + temporalAccessor.getClass(), e);
        }
    }

    default ChronoZonedDateTime zonedDateTime(TemporalAccessor temporalAccessor) {
        try {
            ZoneId from = ZoneId.from(temporalAccessor);
            try {
                return zonedDateTime(Instant.from(temporalAccessor), from);
            } catch (DateTimeException unused) {
                return ChronoZonedDateTimeImpl.ofBest(ChronoLocalDateTimeImpl.ensureValid(this, this.localDateTime(temporalAccessor)), from, null);
            }
        } catch (DateTimeException e) {
            throw new DateTimeException("Unable to obtain ChronoZonedDateTime from TemporalAccessor: " + temporalAccessor.getClass(), e);
        }
    }

    default ChronoZonedDateTime zonedDateTime(Instant instant, ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.ofInstant(this, instant, zoneId);
    }
}
