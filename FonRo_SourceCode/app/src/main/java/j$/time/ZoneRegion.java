package j$.time;

import j$.time.Year;
import j$.time.zone.ZoneRules;
import j$.time.zone.ZoneRulesException;
import j$.time.zone.ZoneRulesProvider;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ZoneRegion extends ZoneId implements Serializable {
    private static final long serialVersionUID = 8386373296231747096L;
    private final String id;
    private final transient ZoneRules rules;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneRegion ofId(String str, boolean z) {
        ZoneRules zoneRules;
        Objects.requireNonNull(str, "zoneId");
        checkName(str);
        try {
            zoneRules = ZoneRulesProvider.getRules(str, true);
        } catch (ZoneRulesException e) {
            if (z) {
                throw e;
            }
            zoneRules = null;
        }
        return new ZoneRegion(str, zoneRules);
    }

    private static void checkName(String str) {
        int length = str.length();
        if (length < 2) {
            Year.AnonymousClass3.m("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
            return;
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt != '/' || i == 0) && ((charAt < '0' || charAt > '9' || i == 0) && ((charAt != '~' || i == 0) && ((charAt != '.' || i == 0) && ((charAt != '_' || i == 0) && ((charAt != '+' || i == 0) && (charAt != '-' || i == 0))))))))) {
                Year.AnonymousClass3.m("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoneRegion(String str, ZoneRules zoneRules) {
        this.id = str;
        this.rules = zoneRules;
    }

    @Override // j$.time.ZoneId
    public String getId() {
        return this.id;
    }

    @Override // j$.time.ZoneId
    public ZoneRules getRules() {
        ZoneRules zoneRules = this.rules;
        return zoneRules != null ? zoneRules : ZoneRulesProvider.getRules(this.id, false);
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.time.ZoneId
    public void write(DataOutput dataOutput) {
        dataOutput.writeByte(7);
        writeExternal(dataOutput);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) {
        dataOutput.writeUTF(this.id);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneId readExternal(DataInput dataInput) {
        return ZoneId.of(dataInput.readUTF(), false);
    }
}
