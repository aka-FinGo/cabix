package uz.FonRo.pos.ui.sale;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Num;
import uz.FonRo.pos.core.Units;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.ui.Toaster;

/* compiled from: SaleState.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u001f\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fJ\u001e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fJ\u0016\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0019J\u000e\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u0014J$\u0010+\u001a\u00020\u00142\f\u0010,\u001a\b\u0012\u0004\u0012\u00020$0-2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\rÊ\u0001\f\b/\u0012\b\b0\u0012\u0004\b\u0003\u0010\u0002¨\u0006."}, d2 = {"Luz/FonRo/pos/ui/sale/CartStore;", "", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Luz/FonRo/pos/ui/sale/CartState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "current", "getCurrent", "()Luz/FonRo/pos/ui/sale/CartState;", "stepOf", "", "product", "Luz/FonRo/pos/data/model/Product;", "freeQty", "add", "", "qty", "(Luz/FonRo/pos/data/model/Product;Ljava/lang/Double;)V", "setQty", "productId", "", "available", "changeQty", "delta", "setLineDiscount", "value", "remove", "insert", FirebaseAnalytics.Param.INDEX, "", "line", "Luz/FonRo/pos/ui/sale/CartLine;", "setCustomer", "customerId", "setDiscount", FirebaseAnalytics.Param.DISCOUNT, "Luz/FonRo/pos/ui/sale/CartDiscount;", "clear", "restore", FirebaseAnalytics.Param.ITEMS, "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class CartStore {
    public static final int $stable = 0;
    public static final CartStore INSTANCE = new CartStore();
    private static final MutableStateFlow<CartState> _state;
    private static final StateFlow<CartState> state;

    private CartStore() {
    }

    static {
        MutableStateFlow<CartState> MutableStateFlow = StateFlowKt.MutableStateFlow(new CartState(null, 0L, null, 7, null));
        _state = MutableStateFlow;
        state = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final StateFlow<CartState> getState() {
        return state;
    }

    public final CartState getCurrent() {
        return _state.getValue();
    }

    public final double stepOf(Product product) {
        Intrinsics.checkNotNullParameter(product, "product");
        if (product.getSaleStep() > AudioStats.AUDIO_AMPLITUDE_NONE) {
            return product.getSaleStep();
        }
        return 1.0d;
    }

    public final double freeQty(Product product) {
        Intrinsics.checkNotNullParameter(product, "product");
        double qtyOf = getCurrent().qtyOf(product.getId());
        return Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, Num.INSTANCE.qty(Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, product.getQuantity()) - qtyOf));
    }

    public static /* synthetic */ void add$default(CartStore cartStore, Product product, Double d, int i, Object obj) {
        if ((i & 2) != 0) {
            d = null;
        }
        cartStore.add(product, d);
    }

    public final void add(Product product, Double qty) {
        Intrinsics.checkNotNullParameter(product, "product");
        double doubleValue = qty != null ? qty.doubleValue() : stepOf(product);
        if (doubleValue <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            return;
        }
        String name = Units.INSTANCE.name(product.getUnit());
        if (product.getSalePrice() <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            Toaster.INSTANCE.error(LangKt.tx("«%s»: не указана цена продажи — продать нельзя", product.getName()));
            return;
        }
        double freeQty = freeQty(product);
        if (freeQty <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            Toaster.INSTANCE.error(LangKt.tx("«%s»: нет на складе", product.getName()));
            return;
        }
        double min = Math.min(doubleValue, freeQty);
        if (min < doubleValue) {
            Toaster.INSTANCE.error(LangKt.tx("«%s»: добавлено %s %s — больше нет на складе", product.getName(), Fmt.INSTANCE.qf(Double.valueOf(min)), name));
        }
        List mutableList = CollectionsKt.toMutableList((Collection) getCurrent().getItems());
        Iterator it = mutableList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (((CartLine) it.next()).getProductId() == product.getId()) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            mutableList.set(i, CartLine.copy$default((CartLine) mutableList.get(i), 0L, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, Num.INSTANCE.qty(((CartLine) mutableList.get(i)).getQty() + min), AudioStats.AUDIO_AMPLITUDE_NONE, 47, null));
        } else {
            mutableList.add(new CartLine(product.getId(), product.getName(), product.getUnit(), product.getSalePrice(), Num.INSTANCE.qty(min), AudioStats.AUDIO_AMPLITUDE_NONE, 32, null));
        }
        _state.setValue(CartState.copy$default(getCurrent(), mutableList, 0L, null, 6, null));
    }

    public final void setQty(long productId, double qty, double available) {
        List mutableList = CollectionsKt.toMutableList((Collection) getCurrent().getItems());
        Iterator it = mutableList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (((CartLine) it.next()).getProductId() == productId) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        CartLine cartLine = (CartLine) mutableList.get(i);
        double qty2 = Num.INSTANCE.qty(Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, qty));
        if (qty2 > 1.0E-4d + available) {
            qty2 = Num.INSTANCE.qty(Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, available));
            Toaster.INSTANCE.error(LangKt.tx("«%s»: максимум %s %s — в минус нельзя", cartLine.getName(), Fmt.INSTANCE.qf(Double.valueOf(available)), Units.INSTANCE.name(cartLine.getUnit())));
        }
        double d = qty2;
        if (d <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            mutableList.remove(i);
        } else {
            mutableList.set(i, CartLine.copy$default(cartLine, 0L, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, d, AudioStats.AUDIO_AMPLITUDE_NONE, 47, null));
        }
        _state.setValue(CartState.copy$default(getCurrent(), mutableList, 0L, null, 6, null));
    }

    public final void changeQty(long productId, double delta, double available) {
        setQty(productId, delta + getCurrent().qtyOf(productId), available);
    }

    public final void setLineDiscount(long productId, double value) {
        List mutableList = CollectionsKt.toMutableList((Collection) getCurrent().getItems());
        Iterator it = mutableList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (((CartLine) it.next()).getProductId() == productId) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        CartLine cartLine = (CartLine) mutableList.get(i);
        mutableList.set(i, CartLine.copy$default(cartLine, 0L, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, Num.INSTANCE.money(Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, Math.min(value, cartLine.getPrice() * cartLine.getQty()))), 31, null));
        _state.setValue(CartState.copy$default(getCurrent(), mutableList, 0L, null, 6, null));
    }

    public final void remove(long productId) {
        MutableStateFlow<CartState> mutableStateFlow = _state;
        CartState current = getCurrent();
        List<CartLine> items = getCurrent().getItems();
        ArrayList arrayList = new ArrayList();
        for (Object obj : items) {
            if (((CartLine) obj).getProductId() != productId) {
                arrayList.add(obj);
            }
        }
        mutableStateFlow.setValue(CartState.copy$default(current, arrayList, 0L, null, 6, null));
    }

    public final void insert(int index, CartLine line) {
        Intrinsics.checkNotNullParameter(line, "line");
        List mutableList = CollectionsKt.toMutableList((Collection) getCurrent().getItems());
        mutableList.add(Math.min(Math.max(0, index), mutableList.size()), line);
        _state.setValue(CartState.copy$default(getCurrent(), mutableList, 0L, null, 6, null));
    }

    public final void setCustomer(long customerId) {
        _state.setValue(CartState.copy$default(getCurrent(), null, Math.max(0L, customerId), null, 5, null));
    }

    public final void setDiscount(CartDiscount discount) {
        Intrinsics.checkNotNullParameter(discount, "discount");
        _state.setValue(CartState.copy$default(getCurrent(), null, 0L, discount, 3, null));
    }

    public final void clear() {
        _state.setValue(new CartState(null, 0L, null, 7, null));
    }

    public final void restore(List<CartLine> items, long customerId, CartDiscount discount) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(discount, "discount");
        _state.setValue(new CartState(items, Math.max(0L, customerId), discount));
    }
}
