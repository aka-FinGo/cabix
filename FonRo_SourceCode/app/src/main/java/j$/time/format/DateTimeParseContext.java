package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.Chronology;
import j$.time.chrono.IsoChronology;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class DateTimeParseContext {
    private ArrayList chronoListeners;
    private DateTimeFormatter formatter;
    private final ArrayList parsed;
    private boolean caseSensitive = true;
    private boolean strict = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateTimeParseContext(DateTimeFormatter dateTimeFormatter) {
        ArrayList arrayList = new ArrayList();
        this.parsed = arrayList;
        this.chronoListeners = null;
        this.formatter = dateTimeFormatter;
        arrayList.add(new Parsed());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateTimeParseContext copy() {
        DateTimeParseContext dateTimeParseContext = new DateTimeParseContext(this.formatter);
        dateTimeParseContext.caseSensitive = this.caseSensitive;
        dateTimeParseContext.strict = this.strict;
        return dateTimeParseContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Locale getLocale() {
        return this.formatter.getLocale();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecimalStyle getDecimalStyle() {
        return this.formatter.getDecimalStyle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Chronology getEffectiveChronology() {
        Chronology chronology = currentParsed().chrono;
        if (chronology != null) {
            return chronology;
        }
        Chronology chronology2 = this.formatter.getChronology();
        return chronology2 == null ? IsoChronology.INSTANCE : chronology2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCaseSensitive(boolean z) {
        this.caseSensitive = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean subSequenceEquals(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3) {
        if (i + i3 > charSequence.length() || i2 + i3 > charSequence2.length()) {
            return false;
        }
        if (isCaseSensitive()) {
            for (int i4 = 0; i4 < i3; i4++) {
                if (charSequence.charAt(i + i4) != charSequence2.charAt(i2 + i4)) {
                    return false;
                }
            }
            return true;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            char charAt = charSequence.charAt(i + i5);
            char charAt2 = charSequence2.charAt(i2 + i5);
            if (charAt != charAt2 && Character.toUpperCase(charAt) != Character.toUpperCase(charAt2) && Character.toLowerCase(charAt) != Character.toLowerCase(charAt2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean charEquals(char c, char c2) {
        if (isCaseSensitive()) {
            return c == c2;
        }
        return charEqualsIgnoreCase(c, c2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean charEqualsIgnoreCase(char c, char c2) {
        return c == c2 || Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isStrict() {
        return this.strict;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStrict(boolean z) {
        this.strict = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startOptional() {
        this.parsed.add(currentParsed().copy());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void endOptional(boolean z) {
        ArrayList arrayList = this.parsed;
        if (z) {
            arrayList.remove(arrayList.size() - 2);
        } else {
            arrayList.remove(arrayList.size() - 1);
        }
    }

    private Parsed currentParsed() {
        return (Parsed) this.parsed.get(r1.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TemporalAccessor toResolved(ResolverStyle resolverStyle, Set set) {
        Parsed currentParsed = currentParsed();
        currentParsed.chrono = getEffectiveChronology();
        ZoneId zoneId = currentParsed.zone;
        if (zoneId == null) {
            zoneId = this.formatter.getZone();
        }
        currentParsed.zone = zoneId;
        return currentParsed.resolve(resolverStyle, set);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Long getParsed(TemporalField temporalField) {
        return (Long) currentParsed().fieldValues.get(temporalField);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int setParsedField(TemporalField temporalField, long j, int i, int i2) {
        Objects.requireNonNull(temporalField, "field");
        Long l = (Long) currentParsed().fieldValues.put(temporalField, Long.valueOf(j));
        return (l == null || l.longValue() == j) ? i2 : ~i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addChronoChangedListener(Consumer consumer) {
        ArrayList arrayList = this.chronoListeners;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.chronoListeners = arrayList;
        }
        arrayList.add(consumer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setParsed(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        currentParsed().zone = zoneId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setParsedLeapSecond() {
        currentParsed().leapSecond = true;
    }

    public String toString() {
        return currentParsed().toString();
    }
}
