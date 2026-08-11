package j$.time.format;

import j$.time.chrono.Chronology;
import j$.time.chrono.IsoChronology;
import j$.time.temporal.ChronoField;
import j$.time.temporal.TemporalField;
import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class DateTimeTextProvider {
    private static final ConcurrentMap CACHE = new ConcurrentHashMap(16, 0.75f, 2);
    private static final Comparator COMPARATOR = new Comparator() { // from class: j$.time.format.DateTimeTextProvider.1
        @Override // java.util.Comparator
        public int compare(Map.Entry entry, Map.Entry entry2) {
            return ((String) entry2.getKey()).length() - ((String) entry.getKey()).length();
        }
    };
    private static final DateTimeTextProvider INSTANCE = new DateTimeTextProvider();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateTimeTextProvider getInstance() {
        return INSTANCE;
    }

    public String getText(TemporalField temporalField, long j, TextStyle textStyle, Locale locale) {
        Object findStore = findStore(temporalField, locale);
        if (findStore instanceof LocaleStore) {
            return ((LocaleStore) findStore).getText(j, textStyle);
        }
        return null;
    }

    public String getText(Chronology chronology, TemporalField temporalField, long j, TextStyle textStyle, Locale locale) {
        if (chronology == IsoChronology.INSTANCE || !(temporalField instanceof ChronoField)) {
            return getText(temporalField, j, textStyle, locale);
        }
        return null;
    }

    public Iterator getTextIterator(TemporalField temporalField, TextStyle textStyle, Locale locale) {
        Object findStore = findStore(temporalField, locale);
        if (findStore instanceof LocaleStore) {
            return ((LocaleStore) findStore).getTextIterator(textStyle);
        }
        return null;
    }

    public Iterator getTextIterator(Chronology chronology, TemporalField temporalField, TextStyle textStyle, Locale locale) {
        if (chronology == IsoChronology.INSTANCE || !(temporalField instanceof ChronoField)) {
            return getTextIterator(temporalField, textStyle, locale);
        }
        return null;
    }

    private Object findStore(TemporalField temporalField, Locale locale) {
        Map.Entry createEntry = createEntry(temporalField, locale);
        ConcurrentMap concurrentMap = CACHE;
        Object obj = concurrentMap.get(createEntry);
        if (obj != null) {
            return obj;
        }
        concurrentMap.putIfAbsent(createEntry, createStore(temporalField, locale));
        return concurrentMap.get(createEntry);
    }

    private Object createStore(TemporalField temporalField, Locale locale) {
        HashMap hashMap = new HashMap();
        int i = 0;
        if (temporalField == ChronoField.ERA) {
            DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            String[] eras = dateFormatSymbols.getEras();
            while (i < eras.length) {
                if (!eras[i].isEmpty()) {
                    long j = i;
                    hashMap2.put(Long.valueOf(j), eras[i]);
                    hashMap3.put(Long.valueOf(j), firstCodePoint(eras[i]));
                }
                i++;
            }
            if (!hashMap2.isEmpty()) {
                hashMap.put(TextStyle.FULL, hashMap2);
                hashMap.put(TextStyle.SHORT, hashMap2);
                hashMap.put(TextStyle.NARROW, hashMap3);
            }
            return new LocaleStore(hashMap);
        }
        if (temporalField == ChronoField.MONTH_OF_YEAR) {
            DesugarDateTimeTextProviderHelper.populateMonthStyleMap(hashMap, DateFormatSymbols.getInstance(locale), locale);
            return new LocaleStore(hashMap);
        }
        if (temporalField == ChronoField.DAY_OF_WEEK) {
            DesugarDateTimeTextProviderHelper.populateDayOfWeekStyleMap(hashMap, DateFormatSymbols.getInstance(locale), locale);
            return new LocaleStore(hashMap);
        }
        if (temporalField == ChronoField.AMPM_OF_DAY) {
            DateFormatSymbols dateFormatSymbols2 = DateFormatSymbols.getInstance(locale);
            HashMap hashMap4 = new HashMap();
            HashMap hashMap5 = new HashMap();
            String[] amPmStrings = dateFormatSymbols2.getAmPmStrings();
            while (i < amPmStrings.length) {
                if (!amPmStrings[i].isEmpty()) {
                    long j2 = i;
                    hashMap4.put(Long.valueOf(j2), amPmStrings[i]);
                    hashMap5.put(Long.valueOf(j2), firstCodePoint(amPmStrings[i]));
                }
                i++;
            }
            if (!hashMap4.isEmpty()) {
                hashMap.put(TextStyle.FULL, hashMap4);
                hashMap.put(TextStyle.SHORT, hashMap4);
                hashMap.put(TextStyle.NARROW, hashMap5);
            }
            return new LocaleStore(hashMap);
        }
        return "";
    }

    private static String firstCodePoint(String str) {
        return str.substring(0, Character.charCount(str.codePointAt(0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map.Entry createEntry(Object obj, Object obj2) {
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class LocaleStore {
        private final Map parsable;
        private final Map valueTextMap;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LocaleStore(Map map) {
            this.valueTextMap = map;
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                    hashMap2.put((String) entry2.getValue(), DateTimeTextProvider.createEntry((String) entry2.getValue(), (Long) entry2.getKey()));
                }
                ArrayList arrayList2 = new ArrayList(hashMap2.values());
                Collections.sort(arrayList2, DateTimeTextProvider.COMPARATOR);
                hashMap.put((TextStyle) entry.getKey(), arrayList2);
                arrayList.addAll(arrayList2);
                hashMap.put(null, arrayList);
            }
            Collections.sort(arrayList, DateTimeTextProvider.COMPARATOR);
            this.parsable = hashMap;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getText(long j, TextStyle textStyle) {
            Map map = (Map) this.valueTextMap.get(textStyle);
            if (map != null) {
                return (String) map.get(Long.valueOf(j));
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Iterator getTextIterator(TextStyle textStyle) {
            List list = (List) this.parsable.get(textStyle);
            if (list != null) {
                return list.iterator();
            }
            return null;
        }
    }
}
