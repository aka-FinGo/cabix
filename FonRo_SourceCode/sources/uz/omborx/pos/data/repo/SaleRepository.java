package uz.FonRo.pos.data.repo;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.JsonElement;
import uz.FonRo.pos.core.Num;
import uz.FonRo.pos.data.local.SaleOutbox;
import uz.FonRo.pos.data.model.Paywall;
import uz.FonRo.pos.data.model.SaleBody;
import uz.FonRo.pos.data.model.SaleResult;
import uz.FonRo.pos.data.model.WriteOffReason;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.net.ApiException;
import uz.FonRo.pos.data.net.ApiService;

/* compiled from: SaleRepository.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ:\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00110\u0015H\u0086@¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u001e\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tÊ\u0001\f\b#\u0012\b\b$\u0012\u0004\b\u0003\u0010\u0000¨\u0006\""}, d2 = {"Luz/FonRo/pos/data/repo/SaleRepository;", "", "repo", "Luz/FonRo/pos/data/repo/Repo;", "<init>", "(Luz/FonRo/pos/data/repo/Repo;)V", "api", "Luz/FonRo/pos/data/net/ApiService;", "getApi", "()Luz/FonRo/pos/data/net/ApiService;", "newTransactionId", "", "submit", "Luz/FonRo/pos/data/repo/SaleRepository$Outcome;", "body", "Luz/FonRo/pos/data/model/SaleBody;", "total", "", "itemsCount", "", "stockDeltas", "", "", "(Luz/FonRo/pos/data/model/SaleBody;DILjava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paywallFrom", "Luz/FonRo/pos/data/model/Paywall;", "e", "Luz/FonRo/pos/data/net/ApiException;", "outboxAdd", "", "flushOutbox", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Outcome", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class SaleRepository {
    public static final int MAX_ATTEMPTS = 5;
    private final Repo repo;
    public static final int $stable = Repo.$stable;

    public SaleRepository(Repo repo) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        this.repo = repo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApiService getApi() {
        return ApiClient.INSTANCE.api();
    }

    public final String newTransactionId() {
        IntRange intRange = new IntRange(1, 8);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            arrayList.add(Character.valueOf("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(Random.INSTANCE.nextInt(36))));
        }
        return "ANDR" + CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
    }

    /* compiled from: SaleRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Luz/FonRo/pos/data/repo/SaleRepository$Outcome;", "", "Done", "Queued", "Luz/FonRo/pos/data/repo/SaleRepository$Outcome$Done;", "Luz/FonRo/pos/data/repo/SaleRepository$Outcome$Queued;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public interface Outcome {

        /* compiled from: SaleRepository.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Luz/FonRo/pos/data/repo/SaleRepository$Outcome$Done;", "Luz/FonRo/pos/data/repo/SaleRepository$Outcome;", "result", "Luz/FonRo/pos/data/model/SaleResult;", "duplicate", "", "<init>", "(Luz/FonRo/pos/data/model/SaleResult;Z)V", "getResult", "()Luz/FonRo/pos/data/model/SaleResult;", "getDuplicate", "()Z", "component1", "component2", "copy", "equals", WriteOffReason.OTHER, "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes5.dex */
        public static final /* data */ class Done implements Outcome {
            public static final int $stable = SaleResult.$stable;
            private final boolean duplicate;
            private final SaleResult result;

            public static /* synthetic */ Done copy$default(Done done, SaleResult saleResult, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    saleResult = done.result;
                }
                if ((i & 2) != 0) {
                    z = done.duplicate;
                }
                return done.copy(saleResult, z);
            }

            /* renamed from: component1, reason: from getter */
            public final SaleResult getResult() {
                return this.result;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getDuplicate() {
                return this.duplicate;
            }

            public final Done copy(SaleResult result, boolean duplicate) {
                Intrinsics.checkNotNullParameter(result, "result");
                return new Done(result, duplicate);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Done)) {
                    return false;
                }
                Done done = (Done) other;
                return Intrinsics.areEqual(this.result, done.result) && this.duplicate == done.duplicate;
            }

            public int hashCode() {
                return (this.result.hashCode() * 31) + Boolean.hashCode(this.duplicate);
            }

            public String toString() {
                return "Done(result=" + this.result + ", duplicate=" + this.duplicate + ")";
            }

            public Done(SaleResult result, boolean z) {
                Intrinsics.checkNotNullParameter(result, "result");
                this.result = result;
                this.duplicate = z;
            }

            public final boolean getDuplicate() {
                return this.duplicate;
            }

            public final SaleResult getResult() {
                return this.result;
            }
        }

        /* compiled from: SaleRepository.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bÊ\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0014"}, d2 = {"Luz/FonRo/pos/data/repo/SaleRepository$Outcome$Queued;", "Luz/FonRo/pos/data/repo/SaleRepository$Outcome;", "transactionId", "", "reason", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTransactionId", "()Ljava/lang/String;", "getReason", "component1", "component2", "copy", "equals", "", WriteOffReason.OTHER, "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes5.dex */
        public static final /* data */ class Queued implements Outcome {
            public static final int $stable = 0;
            private final String reason;
            private final String transactionId;

            public static /* synthetic */ Queued copy$default(Queued queued, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = queued.transactionId;
                }
                if ((i & 2) != 0) {
                    str2 = queued.reason;
                }
                return queued.copy(str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getTransactionId() {
                return this.transactionId;
            }

            /* renamed from: component2, reason: from getter */
            public final String getReason() {
                return this.reason;
            }

            public final Queued copy(String transactionId, String reason) {
                Intrinsics.checkNotNullParameter(transactionId, "transactionId");
                Intrinsics.checkNotNullParameter(reason, "reason");
                return new Queued(transactionId, reason);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Queued)) {
                    return false;
                }
                Queued queued = (Queued) other;
                return Intrinsics.areEqual(this.transactionId, queued.transactionId) && Intrinsics.areEqual(this.reason, queued.reason);
            }

            public int hashCode() {
                return (this.transactionId.hashCode() * 31) + this.reason.hashCode();
            }

            public String toString() {
                return "Queued(transactionId=" + this.transactionId + ", reason=" + this.reason + ")";
            }

            public Queued(String transactionId, String reason) {
                Intrinsics.checkNotNullParameter(transactionId, "transactionId");
                Intrinsics.checkNotNullParameter(reason, "reason");
                this.transactionId = transactionId;
                this.reason = reason;
            }

            public final String getReason() {
                return this.reason;
            }

            public final String getTransactionId() {
                return this.transactionId;
            }
        }
    }

    public final Object submit(SaleBody saleBody, double d, int i, Map<Long, Double> map, Continuation<? super Outcome> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new SaleRepository$submit$2(this, saleBody, d, i, map, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Paywall paywallFrom(ApiException e) {
        Object m7870constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            SaleRepository saleRepository = this;
            JsonElement field = ApiClient.INSTANCE.field(e.getPayload(), "paywall");
            m7870constructorimpl = Result.m7870constructorimpl(field == null ? null : (Paywall) ApiClient.INSTANCE.getJson().decodeFromJsonElement(Paywall.INSTANCE.serializer(), field));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        return (Paywall) (Result.m7876isFailureimpl(m7870constructorimpl) ? null : m7870constructorimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void outboxAdd(SaleBody body, double total, int itemsCount) {
        this.repo.getOutbox().add(new SaleOutbox.Pending(body, System.currentTimeMillis(), 0, (String) null, Num.INSTANCE.money(total), itemsCount, 12, (DefaultConstructorMarker) null));
    }

    public final Object flushOutbox(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new SaleRepository$flushOutbox$2(this, null), continuation);
    }
}
