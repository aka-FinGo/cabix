package androidx.work.impl.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.NetworkRequestCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes5.dex */
public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    private final RoomDatabase __db;

    public RawWorkInfoDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(final SupportSQLiteQuery query) {
        WorkInfo.State intToState;
        BackoffPolicy intToBackoffPolicy;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        NetworkType intToNetworkType;
        NetworkRequestCompat networkRequest$work_runtime_release;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Set<Constraints.ContentUriTrigger> byteArrayToSetOfTriggers;
        int i7;
        this.__db.assertNotSuspendingTransaction();
        Cursor query2 = DBUtil.query(this.__db, query, true, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query2, "id");
            int columnIndex2 = CursorUtil.getColumnIndex(query2, "state");
            int columnIndex3 = CursorUtil.getColumnIndex(query2, "output");
            int columnIndex4 = CursorUtil.getColumnIndex(query2, "initial_delay");
            int columnIndex5 = CursorUtil.getColumnIndex(query2, "interval_duration");
            int columnIndex6 = CursorUtil.getColumnIndex(query2, "flex_duration");
            int columnIndex7 = CursorUtil.getColumnIndex(query2, "run_attempt_count");
            int columnIndex8 = CursorUtil.getColumnIndex(query2, "backoff_policy");
            int columnIndex9 = CursorUtil.getColumnIndex(query2, "backoff_delay_duration");
            int columnIndex10 = CursorUtil.getColumnIndex(query2, "last_enqueue_time");
            int columnIndex11 = CursorUtil.getColumnIndex(query2, "period_count");
            int columnIndex12 = CursorUtil.getColumnIndex(query2, "generation");
            int columnIndex13 = CursorUtil.getColumnIndex(query2, "next_schedule_time_override");
            int columnIndex14 = CursorUtil.getColumnIndex(query2, "stop_reason");
            int columnIndex15 = CursorUtil.getColumnIndex(query2, "required_network_type");
            int columnIndex16 = CursorUtil.getColumnIndex(query2, "required_network_request");
            int columnIndex17 = CursorUtil.getColumnIndex(query2, "requires_charging");
            int columnIndex18 = CursorUtil.getColumnIndex(query2, "requires_device_idle");
            int columnIndex19 = CursorUtil.getColumnIndex(query2, "requires_battery_not_low");
            int columnIndex20 = CursorUtil.getColumnIndex(query2, "requires_storage_not_low");
            int columnIndex21 = CursorUtil.getColumnIndex(query2, "trigger_content_update_delay");
            int columnIndex22 = CursorUtil.getColumnIndex(query2, "trigger_max_content_delay");
            int columnIndex23 = CursorUtil.getColumnIndex(query2, "content_uri_triggers");
            HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
            int i8 = columnIndex13;
            HashMap<String, ArrayList<Data>> hashMap2 = new HashMap<>();
            while (query2.moveToNext()) {
                int i9 = columnIndex12;
                String string = query2.getString(columnIndex);
                if (hashMap.containsKey(string)) {
                    i7 = columnIndex11;
                } else {
                    i7 = columnIndex11;
                    hashMap.put(string, new ArrayList<>());
                }
                String string2 = query2.getString(columnIndex);
                if (!hashMap2.containsKey(string2)) {
                    hashMap2.put(string2, new ArrayList<>());
                }
                columnIndex12 = i9;
                columnIndex11 = i7;
            }
            int i10 = columnIndex11;
            int i11 = columnIndex12;
            int i12 = -1;
            query2.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(hashMap);
            __fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
            ArrayList arrayList = new ArrayList(query2.getCount());
            while (query2.moveToNext()) {
                String string3 = columnIndex == i12 ? null : query2.getString(columnIndex);
                if (columnIndex2 == i12) {
                    intToState = null;
                } else {
                    int i13 = query2.getInt(columnIndex2);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    intToState = WorkTypeConverters.intToState(i13);
                }
                Data fromByteArray = columnIndex3 == i12 ? null : Data.fromByteArray(query2.getBlob(columnIndex3));
                long j = columnIndex4 == i12 ? 0L : query2.getLong(columnIndex4);
                long j2 = columnIndex5 == i12 ? 0L : query2.getLong(columnIndex5);
                long j3 = columnIndex6 == i12 ? 0L : query2.getLong(columnIndex6);
                int i14 = columnIndex7 == i12 ? 0 : query2.getInt(columnIndex7);
                if (columnIndex8 == i12) {
                    intToBackoffPolicy = null;
                } else {
                    int i15 = query2.getInt(columnIndex8);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i15);
                }
                long j4 = columnIndex9 == i12 ? 0L : query2.getLong(columnIndex9);
                long j5 = columnIndex10 == i12 ? 0L : query2.getLong(columnIndex10);
                int i16 = i10;
                if (i16 == i12) {
                    int i17 = i11;
                    i = columnIndex2;
                    i2 = i17;
                    i3 = 0;
                } else {
                    int i18 = i11;
                    i = columnIndex2;
                    i2 = i18;
                    i3 = query2.getInt(i16);
                }
                if (i2 == i12) {
                    int i19 = i8;
                    i4 = i2;
                    i5 = i19;
                    i6 = 0;
                } else {
                    int i20 = query2.getInt(i2);
                    int i21 = i8;
                    i4 = i2;
                    i5 = i21;
                    i6 = i20;
                }
                long j6 = i5 == i12 ? 0L : query2.getLong(i5);
                int i22 = i5;
                int i23 = columnIndex14;
                int i24 = i23 == i12 ? 0 : query2.getInt(i23);
                columnIndex14 = i23;
                int i25 = columnIndex15;
                if (i25 == i12) {
                    intToNetworkType = null;
                } else {
                    int i26 = query2.getInt(i25);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    intToNetworkType = WorkTypeConverters.intToNetworkType(i26);
                }
                columnIndex15 = i25;
                int i27 = columnIndex16;
                if (i27 == i12) {
                    networkRequest$work_runtime_release = null;
                } else {
                    byte[] blob = query2.getBlob(i27);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                }
                columnIndex16 = i27;
                int i28 = columnIndex17;
                if (i28 == i12) {
                    z = false;
                } else {
                    z = query2.getInt(i28) != 0;
                }
                columnIndex17 = i28;
                int i29 = columnIndex18;
                if (i29 == i12) {
                    z2 = false;
                } else {
                    z2 = query2.getInt(i29) != 0;
                }
                columnIndex18 = i29;
                int i30 = columnIndex19;
                if (i30 == i12) {
                    z3 = false;
                } else {
                    z3 = query2.getInt(i30) != 0;
                }
                columnIndex19 = i30;
                int i31 = columnIndex20;
                if (i31 == i12) {
                    z4 = false;
                } else {
                    z4 = query2.getInt(i31) != 0;
                }
                columnIndex20 = i31;
                int i32 = columnIndex21;
                long j7 = i32 == i12 ? 0L : query2.getLong(i32);
                columnIndex21 = i32;
                int i33 = columnIndex22;
                long j8 = i33 != i12 ? query2.getLong(i33) : 0L;
                columnIndex22 = i33;
                int i34 = columnIndex23;
                long j9 = j8;
                if (i34 == i12) {
                    byteArrayToSetOfTriggers = null;
                } else {
                    byte[] blob2 = query2.getBlob(i34);
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    byteArrayToSetOfTriggers = WorkTypeConverters.byteArrayToSetOfTriggers(blob2);
                }
                HashMap<String, ArrayList<String>> hashMap3 = hashMap;
                arrayList.add(new WorkSpec.WorkInfoPojo(string3, intToState, fromByteArray, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z, z2, z3, z4, j7, j9, byteArrayToSetOfTriggers), i14, intToBackoffPolicy, j4, j5, i3, i6, j6, i24, hashMap.get(query2.getString(columnIndex)), hashMap2.get(query2.getString(columnIndex))));
                columnIndex23 = i34;
                columnIndex2 = i;
                hashMap = hashMap3;
                i12 = -1;
                i11 = i4;
                i8 = i22;
                i10 = i16;
            }
            return arrayList;
        } finally {
            query2.close();
        }
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(final SupportSQLiteQuery query) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, new Callable<List<WorkSpec.WorkInfoPojo>>() { // from class: androidx.work.impl.model.RawWorkInfoDao_Impl.1
            @Override // java.util.concurrent.Callable
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                WorkInfo.State intToState;
                BackoffPolicy intToBackoffPolicy;
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                int i6;
                long j;
                int i7;
                int i8;
                int i9;
                int i10;
                int i11;
                int i12;
                int i13;
                NetworkType intToNetworkType;
                int i14;
                int i15;
                NetworkRequestCompat networkRequest$work_runtime_release;
                int i16;
                int i17;
                boolean z;
                int i18;
                int i19;
                boolean z2;
                int i20;
                int i21;
                boolean z3;
                int i22;
                int i23;
                boolean z4;
                long j2;
                int i24;
                int i25;
                Set<Constraints.ContentUriTrigger> byteArrayToSetOfTriggers;
                int i26;
                Cursor query2 = DBUtil.query(RawWorkInfoDao_Impl.this.__db, query, true, null);
                try {
                    int columnIndex = CursorUtil.getColumnIndex(query2, "id");
                    int columnIndex2 = CursorUtil.getColumnIndex(query2, "state");
                    int columnIndex3 = CursorUtil.getColumnIndex(query2, "output");
                    int columnIndex4 = CursorUtil.getColumnIndex(query2, "initial_delay");
                    int columnIndex5 = CursorUtil.getColumnIndex(query2, "interval_duration");
                    int columnIndex6 = CursorUtil.getColumnIndex(query2, "flex_duration");
                    int columnIndex7 = CursorUtil.getColumnIndex(query2, "run_attempt_count");
                    int columnIndex8 = CursorUtil.getColumnIndex(query2, "backoff_policy");
                    int columnIndex9 = CursorUtil.getColumnIndex(query2, "backoff_delay_duration");
                    int columnIndex10 = CursorUtil.getColumnIndex(query2, "last_enqueue_time");
                    int columnIndex11 = CursorUtil.getColumnIndex(query2, "period_count");
                    int columnIndex12 = CursorUtil.getColumnIndex(query2, "generation");
                    int columnIndex13 = CursorUtil.getColumnIndex(query2, "next_schedule_time_override");
                    int columnIndex14 = CursorUtil.getColumnIndex(query2, "stop_reason");
                    int columnIndex15 = CursorUtil.getColumnIndex(query2, "required_network_type");
                    int columnIndex16 = CursorUtil.getColumnIndex(query2, "required_network_request");
                    int columnIndex17 = CursorUtil.getColumnIndex(query2, "requires_charging");
                    int columnIndex18 = CursorUtil.getColumnIndex(query2, "requires_device_idle");
                    int columnIndex19 = CursorUtil.getColumnIndex(query2, "requires_battery_not_low");
                    int columnIndex20 = CursorUtil.getColumnIndex(query2, "requires_storage_not_low");
                    int columnIndex21 = CursorUtil.getColumnIndex(query2, "trigger_content_update_delay");
                    int columnIndex22 = CursorUtil.getColumnIndex(query2, "trigger_max_content_delay");
                    int columnIndex23 = CursorUtil.getColumnIndex(query2, "content_uri_triggers");
                    HashMap hashMap = new HashMap();
                    int i27 = columnIndex13;
                    HashMap hashMap2 = new HashMap();
                    while (query2.moveToNext()) {
                        int i28 = columnIndex12;
                        String string = query2.getString(columnIndex);
                        if (hashMap.containsKey(string)) {
                            i26 = columnIndex11;
                        } else {
                            i26 = columnIndex11;
                            hashMap.put(string, new ArrayList());
                        }
                        String string2 = query2.getString(columnIndex);
                        if (!hashMap2.containsKey(string2)) {
                            hashMap2.put(string2, new ArrayList());
                        }
                        columnIndex12 = i28;
                        columnIndex11 = i26;
                    }
                    int i29 = columnIndex11;
                    int i30 = columnIndex12;
                    int i31 = -1;
                    query2.moveToPosition(-1);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                    ArrayList arrayList = new ArrayList(query2.getCount());
                    while (query2.moveToNext()) {
                        String string3 = columnIndex == i31 ? null : query2.getString(columnIndex);
                        if (columnIndex2 == i31) {
                            intToState = null;
                        } else {
                            int i32 = query2.getInt(columnIndex2);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            intToState = WorkTypeConverters.intToState(i32);
                        }
                        Data fromByteArray = columnIndex3 == i31 ? null : Data.fromByteArray(query2.getBlob(columnIndex3));
                        long j3 = columnIndex4 == i31 ? 0L : query2.getLong(columnIndex4);
                        long j4 = columnIndex5 == i31 ? 0L : query2.getLong(columnIndex5);
                        long j5 = columnIndex6 == i31 ? 0L : query2.getLong(columnIndex6);
                        int i33 = columnIndex7 == i31 ? 0 : query2.getInt(columnIndex7);
                        if (columnIndex8 == i31) {
                            intToBackoffPolicy = null;
                        } else {
                            int i34 = query2.getInt(columnIndex8);
                            WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                            intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i34);
                        }
                        long j6 = columnIndex9 == i31 ? 0L : query2.getLong(columnIndex9);
                        long j7 = columnIndex10 == i31 ? 0L : query2.getLong(columnIndex10);
                        int i35 = i29;
                        if (i35 == i31) {
                            int i36 = i30;
                            i = columnIndex2;
                            i2 = i36;
                            i3 = 0;
                        } else {
                            int i37 = i30;
                            i = columnIndex2;
                            i2 = i37;
                            i3 = query2.getInt(i35);
                        }
                        if (i2 == i31) {
                            int i38 = i27;
                            i4 = i2;
                            i5 = i38;
                            i6 = 0;
                        } else {
                            int i39 = query2.getInt(i2);
                            int i40 = i27;
                            i4 = i2;
                            i5 = i40;
                            i6 = i39;
                        }
                        if (i5 == i31) {
                            int i41 = columnIndex14;
                            i7 = i5;
                            i8 = i41;
                            j = 0;
                        } else {
                            j = query2.getLong(i5);
                            int i42 = columnIndex14;
                            i7 = i5;
                            i8 = i42;
                        }
                        if (i8 == i31) {
                            int i43 = columnIndex15;
                            i9 = i8;
                            i10 = i43;
                            i11 = 0;
                        } else {
                            int i44 = query2.getInt(i8);
                            int i45 = columnIndex15;
                            i9 = i8;
                            i10 = i45;
                            i11 = i44;
                        }
                        if (i10 == i31) {
                            int i46 = columnIndex16;
                            i12 = i10;
                            i13 = i46;
                            intToNetworkType = null;
                        } else {
                            int i47 = query2.getInt(i10);
                            WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                            int i48 = columnIndex16;
                            i12 = i10;
                            i13 = i48;
                            intToNetworkType = WorkTypeConverters.intToNetworkType(i47);
                        }
                        if (i13 == i31) {
                            int i49 = columnIndex17;
                            i14 = i13;
                            i15 = i49;
                            networkRequest$work_runtime_release = null;
                        } else {
                            byte[] blob = query2.getBlob(i13);
                            WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                            int i50 = columnIndex17;
                            i14 = i13;
                            i15 = i50;
                            networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                        }
                        if (i15 == i31) {
                            int i51 = columnIndex18;
                            i16 = i15;
                            i17 = i51;
                            z = false;
                        } else {
                            boolean z5 = query2.getInt(i15) != 0;
                            int i52 = columnIndex18;
                            i16 = i15;
                            i17 = i52;
                            z = z5;
                        }
                        if (i17 == i31) {
                            int i53 = columnIndex19;
                            i18 = i17;
                            i19 = i53;
                            z2 = false;
                        } else {
                            boolean z6 = query2.getInt(i17) != 0;
                            int i54 = columnIndex19;
                            i18 = i17;
                            i19 = i54;
                            z2 = z6;
                        }
                        if (i19 == i31) {
                            int i55 = columnIndex20;
                            i20 = i19;
                            i21 = i55;
                            z3 = false;
                        } else {
                            boolean z7 = query2.getInt(i19) != 0;
                            int i56 = columnIndex20;
                            i20 = i19;
                            i21 = i56;
                            z3 = z7;
                        }
                        if (i21 == i31) {
                            int i57 = columnIndex21;
                            i22 = i21;
                            i23 = i57;
                            z4 = false;
                        } else {
                            boolean z8 = query2.getInt(i21) != 0;
                            int i58 = columnIndex21;
                            i22 = i21;
                            i23 = i58;
                            z4 = z8;
                        }
                        if (i23 == i31) {
                            int i59 = columnIndex22;
                            i24 = i23;
                            i25 = i59;
                            j2 = 0;
                        } else {
                            j2 = query2.getLong(i23);
                            int i60 = columnIndex22;
                            i24 = i23;
                            i25 = i60;
                        }
                        int i61 = columnIndex23;
                        int i62 = i25;
                        long j8 = i25 != i31 ? query2.getLong(i25) : 0L;
                        if (i61 == i31) {
                            byteArrayToSetOfTriggers = null;
                        } else {
                            byte[] blob2 = query2.getBlob(i61);
                            WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                            byteArrayToSetOfTriggers = WorkTypeConverters.byteArrayToSetOfTriggers(blob2);
                        }
                        HashMap hashMap3 = hashMap;
                        arrayList.add(new WorkSpec.WorkInfoPojo(string3, intToState, fromByteArray, j3, j4, j5, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z, z2, z3, z4, j2, j8, byteArrayToSetOfTriggers), i33, intToBackoffPolicy, j6, j7, i3, i6, j, i11, (ArrayList) hashMap.get(query2.getString(columnIndex)), (ArrayList) hashMap2.get(query2.getString(columnIndex))));
                        columnIndex23 = i61;
                        columnIndex2 = i;
                        i30 = i4;
                        i27 = i7;
                        columnIndex14 = i9;
                        columnIndex15 = i12;
                        columnIndex16 = i14;
                        columnIndex17 = i16;
                        columnIndex18 = i18;
                        columnIndex19 = i20;
                        columnIndex20 = i22;
                        columnIndex21 = i24;
                        columnIndex22 = i62;
                        i29 = i35;
                        hashMap = hashMap3;
                        i31 = -1;
                    }
                    return arrayList;
                } finally {
                    query2.close();
                }
            }
        });
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public Flow<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosFlow(final SupportSQLiteQuery query) {
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, new Callable<List<WorkSpec.WorkInfoPojo>>() { // from class: androidx.work.impl.model.RawWorkInfoDao_Impl.2
            @Override // java.util.concurrent.Callable
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                WorkInfo.State intToState;
                BackoffPolicy intToBackoffPolicy;
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                int i6;
                long j;
                int i7;
                int i8;
                int i9;
                int i10;
                int i11;
                int i12;
                int i13;
                NetworkType intToNetworkType;
                int i14;
                int i15;
                NetworkRequestCompat networkRequest$work_runtime_release;
                int i16;
                int i17;
                boolean z;
                int i18;
                int i19;
                boolean z2;
                int i20;
                int i21;
                boolean z3;
                int i22;
                int i23;
                boolean z4;
                long j2;
                int i24;
                int i25;
                Set<Constraints.ContentUriTrigger> byteArrayToSetOfTriggers;
                int i26;
                Cursor query2 = DBUtil.query(RawWorkInfoDao_Impl.this.__db, query, true, null);
                try {
                    int columnIndex = CursorUtil.getColumnIndex(query2, "id");
                    int columnIndex2 = CursorUtil.getColumnIndex(query2, "state");
                    int columnIndex3 = CursorUtil.getColumnIndex(query2, "output");
                    int columnIndex4 = CursorUtil.getColumnIndex(query2, "initial_delay");
                    int columnIndex5 = CursorUtil.getColumnIndex(query2, "interval_duration");
                    int columnIndex6 = CursorUtil.getColumnIndex(query2, "flex_duration");
                    int columnIndex7 = CursorUtil.getColumnIndex(query2, "run_attempt_count");
                    int columnIndex8 = CursorUtil.getColumnIndex(query2, "backoff_policy");
                    int columnIndex9 = CursorUtil.getColumnIndex(query2, "backoff_delay_duration");
                    int columnIndex10 = CursorUtil.getColumnIndex(query2, "last_enqueue_time");
                    int columnIndex11 = CursorUtil.getColumnIndex(query2, "period_count");
                    int columnIndex12 = CursorUtil.getColumnIndex(query2, "generation");
                    int columnIndex13 = CursorUtil.getColumnIndex(query2, "next_schedule_time_override");
                    int columnIndex14 = CursorUtil.getColumnIndex(query2, "stop_reason");
                    int columnIndex15 = CursorUtil.getColumnIndex(query2, "required_network_type");
                    int columnIndex16 = CursorUtil.getColumnIndex(query2, "required_network_request");
                    int columnIndex17 = CursorUtil.getColumnIndex(query2, "requires_charging");
                    int columnIndex18 = CursorUtil.getColumnIndex(query2, "requires_device_idle");
                    int columnIndex19 = CursorUtil.getColumnIndex(query2, "requires_battery_not_low");
                    int columnIndex20 = CursorUtil.getColumnIndex(query2, "requires_storage_not_low");
                    int columnIndex21 = CursorUtil.getColumnIndex(query2, "trigger_content_update_delay");
                    int columnIndex22 = CursorUtil.getColumnIndex(query2, "trigger_max_content_delay");
                    int columnIndex23 = CursorUtil.getColumnIndex(query2, "content_uri_triggers");
                    HashMap hashMap = new HashMap();
                    int i27 = columnIndex13;
                    HashMap hashMap2 = new HashMap();
                    while (query2.moveToNext()) {
                        int i28 = columnIndex12;
                        String string = query2.getString(columnIndex);
                        if (hashMap.containsKey(string)) {
                            i26 = columnIndex11;
                        } else {
                            i26 = columnIndex11;
                            hashMap.put(string, new ArrayList());
                        }
                        String string2 = query2.getString(columnIndex);
                        if (!hashMap2.containsKey(string2)) {
                            hashMap2.put(string2, new ArrayList());
                        }
                        columnIndex12 = i28;
                        columnIndex11 = i26;
                    }
                    int i29 = columnIndex11;
                    int i30 = columnIndex12;
                    int i31 = -1;
                    query2.moveToPosition(-1);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                    ArrayList arrayList = new ArrayList(query2.getCount());
                    while (query2.moveToNext()) {
                        String string3 = columnIndex == i31 ? null : query2.getString(columnIndex);
                        if (columnIndex2 == i31) {
                            intToState = null;
                        } else {
                            int i32 = query2.getInt(columnIndex2);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            intToState = WorkTypeConverters.intToState(i32);
                        }
                        Data fromByteArray = columnIndex3 == i31 ? null : Data.fromByteArray(query2.getBlob(columnIndex3));
                        long j3 = columnIndex4 == i31 ? 0L : query2.getLong(columnIndex4);
                        long j4 = columnIndex5 == i31 ? 0L : query2.getLong(columnIndex5);
                        long j5 = columnIndex6 == i31 ? 0L : query2.getLong(columnIndex6);
                        int i33 = columnIndex7 == i31 ? 0 : query2.getInt(columnIndex7);
                        if (columnIndex8 == i31) {
                            intToBackoffPolicy = null;
                        } else {
                            int i34 = query2.getInt(columnIndex8);
                            WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                            intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i34);
                        }
                        long j6 = columnIndex9 == i31 ? 0L : query2.getLong(columnIndex9);
                        long j7 = columnIndex10 == i31 ? 0L : query2.getLong(columnIndex10);
                        int i35 = i29;
                        if (i35 == i31) {
                            int i36 = i30;
                            i = columnIndex2;
                            i2 = i36;
                            i3 = 0;
                        } else {
                            int i37 = i30;
                            i = columnIndex2;
                            i2 = i37;
                            i3 = query2.getInt(i35);
                        }
                        if (i2 == i31) {
                            int i38 = i27;
                            i4 = i2;
                            i5 = i38;
                            i6 = 0;
                        } else {
                            int i39 = query2.getInt(i2);
                            int i40 = i27;
                            i4 = i2;
                            i5 = i40;
                            i6 = i39;
                        }
                        if (i5 == i31) {
                            int i41 = columnIndex14;
                            i7 = i5;
                            i8 = i41;
                            j = 0;
                        } else {
                            j = query2.getLong(i5);
                            int i42 = columnIndex14;
                            i7 = i5;
                            i8 = i42;
                        }
                        if (i8 == i31) {
                            int i43 = columnIndex15;
                            i9 = i8;
                            i10 = i43;
                            i11 = 0;
                        } else {
                            int i44 = query2.getInt(i8);
                            int i45 = columnIndex15;
                            i9 = i8;
                            i10 = i45;
                            i11 = i44;
                        }
                        if (i10 == i31) {
                            int i46 = columnIndex16;
                            i12 = i10;
                            i13 = i46;
                            intToNetworkType = null;
                        } else {
                            int i47 = query2.getInt(i10);
                            WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                            int i48 = columnIndex16;
                            i12 = i10;
                            i13 = i48;
                            intToNetworkType = WorkTypeConverters.intToNetworkType(i47);
                        }
                        if (i13 == i31) {
                            int i49 = columnIndex17;
                            i14 = i13;
                            i15 = i49;
                            networkRequest$work_runtime_release = null;
                        } else {
                            byte[] blob = query2.getBlob(i13);
                            WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                            int i50 = columnIndex17;
                            i14 = i13;
                            i15 = i50;
                            networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                        }
                        if (i15 == i31) {
                            int i51 = columnIndex18;
                            i16 = i15;
                            i17 = i51;
                            z = false;
                        } else {
                            boolean z5 = query2.getInt(i15) != 0;
                            int i52 = columnIndex18;
                            i16 = i15;
                            i17 = i52;
                            z = z5;
                        }
                        if (i17 == i31) {
                            int i53 = columnIndex19;
                            i18 = i17;
                            i19 = i53;
                            z2 = false;
                        } else {
                            boolean z6 = query2.getInt(i17) != 0;
                            int i54 = columnIndex19;
                            i18 = i17;
                            i19 = i54;
                            z2 = z6;
                        }
                        if (i19 == i31) {
                            int i55 = columnIndex20;
                            i20 = i19;
                            i21 = i55;
                            z3 = false;
                        } else {
                            boolean z7 = query2.getInt(i19) != 0;
                            int i56 = columnIndex20;
                            i20 = i19;
                            i21 = i56;
                            z3 = z7;
                        }
                        if (i21 == i31) {
                            int i57 = columnIndex21;
                            i22 = i21;
                            i23 = i57;
                            z4 = false;
                        } else {
                            boolean z8 = query2.getInt(i21) != 0;
                            int i58 = columnIndex21;
                            i22 = i21;
                            i23 = i58;
                            z4 = z8;
                        }
                        if (i23 == i31) {
                            int i59 = columnIndex22;
                            i24 = i23;
                            i25 = i59;
                            j2 = 0;
                        } else {
                            j2 = query2.getLong(i23);
                            int i60 = columnIndex22;
                            i24 = i23;
                            i25 = i60;
                        }
                        int i61 = columnIndex23;
                        int i62 = i25;
                        long j8 = i25 != i31 ? query2.getLong(i25) : 0L;
                        if (i61 == i31) {
                            byteArrayToSetOfTriggers = null;
                        } else {
                            byte[] blob2 = query2.getBlob(i61);
                            WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                            byteArrayToSetOfTriggers = WorkTypeConverters.byteArrayToSetOfTriggers(blob2);
                        }
                        HashMap hashMap3 = hashMap;
                        arrayList.add(new WorkSpec.WorkInfoPojo(string3, intToState, fromByteArray, j3, j4, j5, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z, z2, z3, z4, j2, j8, byteArrayToSetOfTriggers), i33, intToBackoffPolicy, j6, j7, i3, i6, j, i11, (ArrayList) hashMap.get(query2.getString(columnIndex)), (ArrayList) hashMap2.get(query2.getString(columnIndex))));
                        columnIndex23 = i61;
                        columnIndex2 = i;
                        i30 = i4;
                        i27 = i7;
                        columnIndex14 = i9;
                        columnIndex15 = i12;
                        columnIndex16 = i14;
                        columnIndex17 = i16;
                        columnIndex18 = i18;
                        columnIndex19 = i20;
                        columnIndex20 = i22;
                        columnIndex21 = i24;
                        columnIndex22 = i62;
                        i29 = i35;
                        hashMap = hashMap3;
                        i31 = -1;
                    }
                    return arrayList;
                } finally {
                    query2.close();
                }
            }
        });
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipWorkTagAsjavaLangString(final HashMap<String, ArrayList<String>> _map) {
        Set<String> keySet = _map.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (_map.size() > 999) {
            RelationUtil.recursiveFetchHashMap(_map, true, new Function1() { // from class: androidx.work.impl.model.RawWorkInfoDao_Impl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RawWorkInfoDao_Impl.this.m7603x653d68c((HashMap) obj);
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int size = keySet.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        Iterator<String> it = keySet.iterator();
        int i = 1;
        while (it.hasNext()) {
            acquire.bindString(i, it.next());
            i++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                ArrayList<String> arrayList = _map.get(query.getString(columnIndex));
                if (arrayList != null) {
                    arrayList.add(query.getString(0));
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$__fetchRelationshipWorkTagAsjavaLangString$0$androidx-work-impl-model-RawWorkInfoDao_Impl, reason: not valid java name */
    public /* synthetic */ Unit m7603x653d68c(HashMap hashMap) {
        __fetchRelationshipWorkTagAsjavaLangString(hashMap);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipWorkProgressAsandroidxWorkData(final HashMap<String, ArrayList<Data>> _map) {
        Set<String> keySet = _map.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (_map.size() > 999) {
            RelationUtil.recursiveFetchHashMap(_map, true, new Function1() { // from class: androidx.work.impl.model.RawWorkInfoDao_Impl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RawWorkInfoDao_Impl.this.m7602x83915589((HashMap) obj);
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int size = keySet.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        Iterator<String> it = keySet.iterator();
        int i = 1;
        while (it.hasNext()) {
            acquire.bindString(i, it.next());
            i++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                ArrayList<Data> arrayList = _map.get(query.getString(columnIndex));
                if (arrayList != null) {
                    arrayList.add(Data.fromByteArray(query.getBlob(0)));
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$__fetchRelationshipWorkProgressAsandroidxWorkData$1$androidx-work-impl-model-RawWorkInfoDao_Impl, reason: not valid java name */
    public /* synthetic */ Unit m7602x83915589(HashMap hashMap) {
        __fetchRelationshipWorkProgressAsandroidxWorkData(hashMap);
        return Unit.INSTANCE;
    }
}
