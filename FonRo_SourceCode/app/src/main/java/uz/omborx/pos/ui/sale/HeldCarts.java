package uz.FonRo.pos.ui.sale;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import j$.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.CharsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Num;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.model.Store;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;

/* compiled from: HeldCarts.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001c\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0016J\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000bJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b \u0012\b\b!\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001f"}, d2 = {"Luz/FonRo/pos/ui/sale/HeldCarts;", "", "<init>", "()V", "MAX", "", "json", "Lkotlinx/serialization/json/Json;", "listSerializer", "Lkotlinx/serialization/KSerializer;", "", "Luz/FonRo/pos/ui/sale/HeldCart;", "storeId", "", "repo", "Luz/FonRo/pos/data/repo/Repo;", "load", "save", "", "list", "count", "hold", "", NotificationCompat.GROUP_KEY_SILENT, "drop", "id", "", "resume", "entry", "totalOf", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class HeldCarts {
    public static final int $stable = 0;
    private static final int MAX = 30;
    public static final HeldCarts INSTANCE = new HeldCarts();
    private static final Json json = JsonKt.Json$default(null, new Function1() { // from class: uz.FonRo.pos.ui.sale.HeldCarts$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return HeldCarts.json$lambda$0((JsonBuilder) obj);
        }
    }, 1, null);
    private static final KSerializer<List<HeldCart>> listSerializer = BuiltinSerializersKt.ListSerializer(HeldCart.INSTANCE.serializer());

    private HeldCarts() {
    }

    public static final Unit json$lambda$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        Json.setLenient(true);
        Json.setEncodeDefaults(true);
        return Unit.INSTANCE;
    }

    private final long storeId(Repo repo) {
        Store value = repo.getStore().getValue();
        if (value != null) {
            return value.getId();
        }
        return 0L;
    }

    public final List<HeldCart> load(Repo repo) {
        Object m7870constructorimpl;
        Intrinsics.checkNotNullParameter(repo, "repo");
        try {
            Result.Companion companion = Result.INSTANCE;
            HeldCarts heldCarts = this;
            m7870constructorimpl = Result.m7870constructorimpl((List) json.decodeFromString(listSerializer, repo.getPrefs().heldCarts(storeId(repo))));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        List emptyList = CollectionsKt.emptyList();
        if (Result.m7876isFailureimpl(m7870constructorimpl)) {
            m7870constructorimpl = emptyList;
        }
        return (List) m7870constructorimpl;
    }

    public final void save(Repo repo, List<HeldCart> list) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(list, "list");
        repo.getPrefs().setHeldCarts(storeId(repo), json.encodeToString(listSerializer, CollectionsKt.take(list, 30)));
    }

    public final int count(Repo repo) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        return load(repo).size();
    }

    public static /* synthetic */ boolean hold$default(HeldCarts heldCarts, Repo repo, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return heldCarts.hold(repo, z);
    }

    public final boolean hold(Repo repo, boolean r24) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        CartState current = CartStore.INSTANCE.getCurrent();
        if (current.getItems().isEmpty()) {
            return false;
        }
        String l = Long.toString(System.currentTimeMillis(), CharsKt.checkRadix(36));
        Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
        String num = Integer.toString(Random.INSTANCE.nextInt(0, 65536), CharsKt.checkRadix(36));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        String str = "H" + l + num;
        String localDateTime = LocalDateTime.now(Fmt.INSTANCE.getSTORE_ZONE()).toString();
        Intrinsics.checkNotNullExpressionValue(localDateTime, "toString(...)");
        long customerId = current.getCustomerId();
        CartDiscount discount = current.getDiscount();
        List<CartLine> items = current.getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
        for (CartLine cartLine : items) {
            arrayList.add(new HeldItem(cartLine.getProductId(), cartLine.getName(), cartLine.getQty(), cartLine.getDiscount()));
        }
        save(repo, CollectionsKt.plus((Collection) CollectionsKt.listOf(new HeldCart(str, localDateTime, customerId, discount, arrayList)), (Iterable) load(repo)));
        CartStore.INSTANCE.clear();
        if (r24) {
            return true;
        }
        Toaster.INSTANCE.ok(LangKt.tx("Чек отложен — касса свободна", new Object[0]));
        return true;
    }

    public final void drop(Repo repo, String id) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(id, "id");
        List<HeldCart> load = load(repo);
        ArrayList arrayList = new ArrayList();
        for (Object obj : load) {
            if (!Intrinsics.areEqual(((HeldCart) obj).getId(), id)) {
                arrayList.add(obj);
            }
        }
        save(repo, arrayList);
    }

    public final void resume(Repo repo, HeldCart entry) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(entry, "entry");
        if (!CartStore.INSTANCE.getCurrent().getItems().isEmpty()) {
            hold(repo, true);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (HeldItem heldItem : entry.getItems()) {
            Product productById = repo.productById(heldItem.getProductId());
            if (productById == null) {
                arrayList.add(heldItem.getName());
            } else {
                double qty = Num.INSTANCE.qty(Math.min(heldItem.getQty(), Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, productById.getQuantity())));
                if (qty > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    arrayList2.add(new CartLine(productById.getId(), productById.getName(), productById.getUnit(), productById.getSalePrice(), qty, Num.INSTANCE.money(Math.min(heldItem.getDiscount(), productById.getSalePrice() * qty))));
                }
            }
        }
        CartStore.INSTANCE.restore(arrayList2, entry.getCustomerId(), entry.getDiscount());
        drop(repo, entry.getId());
        if (arrayList.isEmpty()) {
            Toaster.INSTANCE.ok(LangKt.tx("Чек вернулся в кассу", new Object[0]));
            return;
        }
        Toaster.INSTANCE.error(LangKt.tx("Не вернулись: ", new Object[0]) + CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null));
    }

    public final double totalOf(Repo repo, HeldCart entry) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Num num = Num.INSTANCE;
        double d = 0.0d;
        for (HeldItem heldItem : entry.getItems()) {
            Product productById = repo.productById(heldItem.getProductId());
            d += Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, ((productById != null ? productById.getSalePrice() : 0.0d) * heldItem.getQty()) - heldItem.getDiscount());
        }
        return num.money(d);
    }
}
