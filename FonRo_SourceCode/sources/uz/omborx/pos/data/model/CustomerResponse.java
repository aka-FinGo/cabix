package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\t0\u0015Ê\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Luz/FonRo/pos/data/model/CustomerResponse;", "", "customer", "Luz/FonRo/pos/data/model/Customer;", "<init>", "(Luz/FonRo/pos/data/model/Customer;)V", "getCustomer", "()Luz/FonRo/pos/data/model/Customer;", "component1", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "", "Companion", "app", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/model/CustomerResponseSerializer;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable(with = CustomerResponseSerializer.class)
/* loaded from: classes5.dex */
public final /* data */ class CustomerResponse {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Customer customer;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomerResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CustomerResponse copy$default(CustomerResponse customerResponse, Customer customer, int i, Object obj) {
        if ((i & 1) != 0) {
            customer = customerResponse.customer;
        }
        return customerResponse.copy(customer);
    }

    /* renamed from: component1, reason: from getter */
    public final Customer getCustomer() {
        return this.customer;
    }

    public final CustomerResponse copy(Customer customer) {
        return new CustomerResponse(customer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CustomerResponse) && Intrinsics.areEqual(this.customer, ((CustomerResponse) other).customer);
    }

    public int hashCode() {
        Customer customer = this.customer;
        if (customer == null) {
            return 0;
        }
        return customer.hashCode();
    }

    public String toString() {
        return "CustomerResponse(customer=" + this.customer + ")";
    }

    /* compiled from: Catalog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/CustomerResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/CustomerResponse;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CustomerResponse> serializer() {
            return CustomerResponseSerializer.INSTANCE;
        }
    }

    public CustomerResponse(Customer customer) {
        this.customer = customer;
    }

    public /* synthetic */ CustomerResponse(Customer customer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : customer);
    }

    public final Customer getCustomer() {
        return this.customer;
    }
}
