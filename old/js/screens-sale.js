/* =====================================================
   FonRo POS — Sotuv ekrani (Kassa - Live Replica)
   ===================================================== */

const Sale = {
  searchQuery: '',
  selectedCategory: 0,

  render(view) {
    this.searchQuery = '';
    this.selectedCategory = 0;

    const html = `
      <div class="pos-layout">
        <div class="pos-catalog">
          <div class="pos-search">
            <div style="position:relative;width:100%">
              <input type="text" id="saleSearchInput" placeholder="Qidiruv: nomi, shtrix-kod, artikul..." autocomplete="off">
              <button class="search-reset-btn" onclick="document.getElementById('saleSearchInput').value=''; Sale.searchQuery=''; Sale.renderCatalog();" title="Tiklash">⟳</button>
            </div>
          </div>
          
          <div class="cat-pills" id="saleCategoryPills"></div>
          
          <div class="product-grid" id="saleProductGrid"></div>
        </div>

        <div class="pos-cart-sidebar">
          <div class="cart-header">
            <div class="cart-title-text">Chek - <span id="cartHeaderIndex">0</span></div>
            <div class="cart-header-actions">
              <span class="cart-badge-chip" id="cartItemCountChip">🛒 0</span>
              <button class="cart-action-btn" onclick="Sale.holdCart()" title="Kechiktirish">⏸ Kechiktirish</button>
              <button class="cart-action-btn close" onclick="Sale.clearCart()" title="Tozalash">✕</button>
            </div>
          </div>

          <div class="cart-items" id="cartItemsList"></div>

          <div class="cart-footer">
            <div class="cart-customer" onclick="Sale.selectCustomerModal()">
              <div style="font-size:13px;color:var(--text-secondary);display:flex;align-items:center;gap:6px">
                <span>👤</span> <b id="cartCustomerName" style="color:var(--text)">Mijoz tanlanmagan</b>
              </div>
            </div>

            <div class="cart-totals">
              <div class="cart-total-row">
                <span>Oraliq jami</span>
                <span id="cartSubtotal">0</span>
              </div>
              <div class="cart-total-row">
                <span>Chekka chegirma</span>
                <span id="cartDiscountAmount" style="color:var(--primary);cursor:pointer;font-weight:600" onclick="Sale.cartDiscountModal()">qo'shish</span>
              </div>
              <div class="cart-total-row grand">
                <span style="font-size:16px;font-weight:700;color:#FFF">Jami</span>
                <span id="cartGrandTotal" style="font-size:22px;font-weight:800;color:#FFF">0 UZS</span>
              </div>
            </div>

            <div class="cart-footer-buttons">
              <button class="btn btn-debt-dark" onclick="Sale.processCheckout('debt')">Qarzga</button>
              <button class="btn btn-primary btn-pay-blue" onclick="Sale.paymentModal('cash')">To'lov</button>
            </div>
          </div>
        </div>
      </div>
    `;

    view.innerHTML = html;

    const searchInput = document.getElementById('saleSearchInput');
    if (searchInput) {
      searchInput.addEventListener('input', (e) => {
        this.searchQuery = e.target.value.toLowerCase().trim();
        this.renderCatalog();
      });
      setTimeout(() => searchInput.focus(), 100);
    }

    this.renderCategoryPills();
    this.renderCatalog();
    this.renderCart();
  },

  renderCategoryPills() {
    const wrap = document.getElementById('saleCategoryPills');
    if (!wrap) return;

    let html = `<button class="cat-pill ${this.selectedCategory === 0 ? 'active' : ''}" onclick="Sale.selectCategory(0)">Barcha mahsulotlar</button>`;
    State.categories.forEach(cat => {
      html += `<button class="cat-pill ${this.selectedCategory === cat.id ? 'active' : ''}" onclick="Sale.selectCategory(${cat.id})">● ${esc(cat.name)}</button>`;
    });

    wrap.innerHTML = html;
  },

  selectCategory(id) {
    this.selectedCategory = id;
    this.renderCategoryPills();
    this.renderCatalog();
  },

  renderCatalog() {
    const grid = document.getElementById('saleProductGrid');
    if (!grid) return;

    const filtered = State.products.filter(p => {
      if (Number(p.is_archived || 0) === 1) return false;
      const matchCat = this.selectedCategory === 0 || p.category_id === this.selectedCategory;
      const q = this.searchQuery;
      const matchSearch = !q || p.name.toLowerCase().includes(q) || (p.barcode && String(p.barcode).includes(q));
      return matchCat && matchSearch;
    });

    if (filtered.length === 0) {
      grid.innerHTML = '<div class="empty-note" style="grid-column:1/-1;padding:60px 0;text-align:center;color:var(--text-secondary)">Mahsulotlar topilmadi</div>';
      return;
    }

    let html = '';
    filtered.forEach(p => {
      const imgUrl = productImageUrl(p);
      const isOut = (Number(p.quantity) || 0) <= 0;
      const qtyText = isOut ? 'Tugagan' : qf(p.quantity) + ' dona';

      html += `
        <div class="prod-card" onclick="Sale.addSmart(${p.id})">
          <span class="prod-star" onclick="event.stopPropagation(); this.classList.toggle('active')">☆</span>
          <span class="prod-stock-pill ${isOut ? 'out' : ''}">${qtyText}</span>
          <div class="prod-img-box">
            ${imgUrl ? `<img src="${imgUrl}" alt="${esc(p.name)}" onerror="this.style.display='none'">` : ''}
          </div>
          <div class="prod-card-body">
            <div class="prod-card-title">${esc(p.name)}</div>
            <div class="prod-card-price">${money(p.sale_price).replace(' UZS', '')}</div>
          </div>
        </div>
      `;
    });

    grid.innerHTML = html;
  },

  addSmart(productId) {
    const product = State.products.find(p => p.id === productId);
    if (!product) return;

    const weightUnits = ['kg','g','mg','lb','oz','ton','l','ml','m','cm','mm','ft','yd'];
    const isWeight = weightUnits.includes(String(product.unit || '').toLowerCase());

    if (isWeight) {
      numpad({
        title: product.name + ' miqdorini kiriting (' + unitName(product.unit) + ')',
        value: 1,
        onDone: (val) => {
          if (val > 0) this.addToCart(product, val);
        }
      });
    } else {
      const existing = State.cart.find(i => i.product.id === product.id);
      if (existing) {
        existing.qty = Num.qty(existing.qty + 1);
        this.renderCart();
      } else {
        this.addToCart(product, 1);
      }
    }
  },

  addToCart(product, qty = 1) {
    const existing = State.cart.find(i => i.product.id === product.id);
    if (existing) {
      existing.qty = Num.qty(existing.qty + qty);
    } else {
      State.cart.unshift({
        product,
        qty: Num.qty(qty),
        discount: 0,
      });
    }
    this.renderCart();
  },

  renderCart() {
    const itemsList = document.getElementById('cartItemsList');
    const countChip = document.getElementById('cartItemCountChip');
    const headerIndex = document.getElementById('cartHeaderIndex');
    const subtotalEl = document.getElementById('cartSubtotal');
    const discountEl = document.getElementById('cartDiscountAmount');
    const grandEl = document.getElementById('cartGrandTotal');
    const customerEl = document.getElementById('cartCustomerName');

    if (!itemsList) return;

    const totalCount = State.cart.reduce((sum, i) => sum + i.qty, 0);
    if (countChip) countChip.textContent = '🛒 ' + State.cart.length;
    if (headerIndex) headerIndex.textContent = State.cart.length;

    // Customer
    if (customerEl) {
      const cust = State.customers.find(c => c.id === State.cartCustomerId);
      customerEl.textContent = cust ? cust.name : 'Mijoz tanlanmagan';
    }

    if (State.cart.length === 0) {
      itemsList.innerHTML = `
        <div class="empty-cart-state">
          <div style="font-size:13px;color:var(--text-secondary);line-height:1.5">
            Chapdagi mahsulotni bosing<br>yoki shtrix-kodni skanerlang
          </div>
        </div>
      `;
      if (subtotalEl) subtotalEl.textContent = '0';
      if (discountEl) discountEl.textContent = 'qo\'shish';
      if (grandEl) grandEl.textContent = '0 UZS';
      return;
    }

    let subtotal = 0;
    let html = '';

    State.cart.forEach((item, idx) => {
      const price = Number(item.product.sale_price) || 0;
      const lineSub = price * item.qty - (Number(item.discount) || 0);
      subtotal += lineSub;

      html += `
        <div class="cart-item">
          <div class="cart-item-head">
            <span class="cart-item-name">${esc(item.product.name)}</span>
            <button class="cart-item-remove" onclick="Sale.removeFromCart(${idx})">✕</button>
          </div>
          <div class="cart-item-controls">
            <div class="qty-ctrl">
              <button class="qty-btn" onclick="Sale.changeQty(${idx}, -1)">-</button>
              <span class="qty-val" onclick="Sale.editQtyNumpad(${idx})">${qf(item.qty)}</span>
              <button class="qty-btn" onclick="Sale.changeQty(${idx}, 1)">+</button>
            </div>
            <div class="cart-item-price">${money(lineSub)}</div>
          </div>
        </div>
      `;
    });

    itemsList.innerHTML = html;

    const cartDisc = this.calcCartDiscount(subtotal);
    const grandTotal = Math.max(0, subtotal - cartDisc);

    if (subtotalEl) subtotalEl.textContent = money(subtotal).replace(' UZS', '');
    if (discountEl) discountEl.textContent = cartDisc > 0 ? money(cartDisc) : 'qo\'shish';
    if (grandEl) grandEl.textContent = money(grandTotal);
  },

  changeQty(index, delta) {
    const item = State.cart[index];
    if (!item) return;
    const newQty = Num.qty(item.qty + delta);
    if (newQty <= 0) {
      this.removeFromCart(index);
    } else {
      item.qty = newQty;
      this.renderCart();
    }
  },

  editQtyNumpad(index) {
    const item = State.cart[index];
    if (!item) return;

    numpad({
      title: item.product.name + ' miqdorini kiriting',
      value: item.qty,
      onDone: (val) => {
        if (val <= 0) {
          this.removeFromCart(index);
        } else {
          item.qty = Num.qty(val);
          this.renderCart();
        }
      }
    });
  },

  removeFromCart(index) {
    State.cart.splice(index, 1);
    this.renderCart();
  },

  clearCart() {
    if (State.cart.length === 0) return;
    confirmModal('Savatni tozalash', 'Savatdagi barcha tovarlarni o\'chirmoqchimisiz?', () => {
      State.cart = [];
      State.cartCustomerId = 0;
      State.cartDiscount = { type: 'amount', value: 0 };
      this.renderCart();
      toast('Savat tozalandi', 'ok');
    });
  },

  calcCartDiscount(subtotal) {
    const disc = State.cartDiscount;
    if (!disc || !disc.value) return 0;
    if (disc.type === 'percent') {
      return Math.round((subtotal * disc.value) / 100);
    }
    return Math.min(subtotal, disc.value);
  },

  holdCart() {
    if (State.cart.length === 0) {
      toast('Savat bo\'sh', 'warn');
      return;
    }

    try {
      const held = JSON.parse(localStorage.getItem('fonro_held_carts') || '[]');
      held.push({
        id: uid('held'),
        date: dt(new Date(), true),
        cart: [...State.cart],
        cartCustomerId: State.cartCustomerId,
        cartDiscount: { ...State.cartDiscount },
      });
      localStorage.setItem('fonro_held_carts', JSON.stringify(held));

      State.cart = [];
      State.cartCustomerId = 0;
      State.cartDiscount = { type: 'amount', value: 0 };
      this.renderCart();

      toast('Savat kechiktirildi (saqlandi)', 'ok');
    } catch(e) {
      toastErr('Savatni saqlashda xatolik');
    }
  },

  resumeHeld() {
    let held = [];
    try {
      held = JSON.parse(localStorage.getItem('fonro_held_carts') || '[]');
    } catch(e) {}

    if (held.length === 0) {
      toast('Saqlangan savatlar yo\'q', 'warn');
      return;
    }

    let rowsHtml = '';
    held.forEach((h, idx) => {
      const cust = State.customers.find(c => c.id === h.cartCustomerId);
      const total = h.cart.reduce((s, i) => s + i.product.sale_price * i.qty, 0);

      rowsHtml += `
        <div style="padding:12px;border:1px solid var(--border-color);border-radius:8px;margin-bottom:8px;display:flex;justify-content:space-between;align-items:center">
          <div>
            <div style="font-weight:600">${esc(h.date)}</div>
            <div style="font-size:12px;color:var(--text-secondary)">
              Tovarlar: ${h.cart.length} ta | Mijoz: ${cust ? esc(cust.name) : 'Mijozsiz'}
            </div>
            <div style="font-weight:600;color:var(--primary);margin-top:2px">${money(total)}</div>
          </div>
          <button class="btn btn-primary btn-sm" onclick="Sale.restoreCartItem(${idx})">Tiklash</button>
        </div>
      `;
    });

    openModal({
      title: 'Saqlangan savatlar',
      body: `<div>${rowsHtml}</div>`,
      footer: `<button class="btn btn-ghost" onclick="closeModal()">Yopish</button>`
    });
  },

  restoreCartItem(index) {
    try {
      let held = JSON.parse(localStorage.getItem('fonro_held_carts') || '[]');
      const item = held[index];
      if (item) {
        State.cart = item.cart;
        State.cartCustomerId = item.cartCustomerId;
        State.cartDiscount = item.cartDiscount;
        held.splice(index, 1);
        localStorage.setItem('fonro_held_carts', JSON.stringify(held));
        closeModal();
        this.renderCart();
        toast('Savat tiklandi', 'ok');
      }
    } catch(e) {}
  },

  selectCustomerModal() {
    let listHtml = '';
    State.customers.forEach(c => {
      const isSel = c.id === State.cartCustomerId;
      listHtml += `
        <div style="padding:10px;border-bottom:1px solid var(--border-color);display:flex;justify-content:space-between;align-items:center;cursor:pointer" onclick="Sale.pickCustomer(${c.id})">
          <div>
            <div style="font-weight:600">${esc(c.name)} ${isSel ? '✓' : ''}</div>
            <div style="font-size:12px;color:var(--text-secondary)">${esc(c.phone || '-')}</div>
          </div>
          <button class="btn btn-sm ${isSel ? 'btn-ok' : 'btn-ghost'}">${isSel ? 'Tanlangan' : 'Tanlash'}</button>
        </div>
      `;
    });

    openModal({
      title: 'Mijozni tanlash',
      body: `
        <div style="margin-bottom:12px">
          <input type="text" id="custSearchInput" class="field-input" placeholder="Mijoz qidirish..." oninput="Sale.filterCustomerList(this.value)">
        </div>
        <div id="custModalList" style="max-height:300px;overflow-y:auto">
          <div style="padding:10px;border-bottom:1px solid var(--border-color);cursor:pointer" onclick="Sale.pickCustomer(0)">
            <b>Mijozsiz (Odatiy xaridor)</b>
          </div>
          ${listHtml}
        </div>
      `,
      footer: `<button class="btn btn-ghost" onclick="closeModal()">Bekor qilish</button>`
    });
  },

  filterCustomerList(q) {
    const wrap = document.getElementById('custModalList');
    if (!wrap) return;

    q = q.toLowerCase().trim();
    const filtered = State.customers.filter(c => c.name.toLowerCase().includes(q) || (c.phone && c.phone.includes(q)));

    let listHtml = `
      <div style="padding:10px;border-bottom:1px solid var(--border-color);cursor:pointer" onclick="Sale.pickCustomer(0)">
        <b>Mijozsiz (Odatiy xaridor)</b>
      </div>
    `;

    filtered.forEach(c => {
      const isSel = c.id === State.cartCustomerId;
      listHtml += `
        <div style="padding:10px;border-bottom:1px solid var(--border-color);display:flex;justify-content:space-between;align-items:center;cursor:pointer" onclick="Sale.pickCustomer(${c.id})">
          <div>
            <div style="font-weight:600">${esc(c.name)} ${isSel ? '✓' : ''}</div>
            <div style="font-size:12px;color:var(--text-secondary)">${esc(c.phone || '-')}</div>
          </div>
          <button class="btn btn-sm ${isSel ? 'btn-ok' : 'btn-ghost'}">${isSel ? 'Tanlangan' : 'Tanlash'}</button>
        </div>
      `;
    });

    wrap.innerHTML = listHtml;
  },

  pickCustomer(id) {
    State.cartCustomerId = id;
    closeModal();
    this.renderCart();
    toast(id ? 'Mijoz biriktirildi' : 'Mijoz olib tashlandi', 'ok');
  },

  cartDiscountModal() {
    if (State.cart.length === 0) {
      toast('Savat bo\'sh', 'warn');
      return;
    }

    openModal({
      title: 'Chegirma qo\'shish',
      body: `
        <div style="display:flex;gap:8px;margin-bottom:16px">
          <button id="discTypeSum" class="btn btn-primary btn-sm" onclick="Sale.setDiscType('amount')">Summa (UZS)</button>
          <button id="discTypePct" class="btn btn-ghost btn-sm" onclick="Sale.setDiscType('percent')">Foiz (%)</button>
        </div>
        <div class="field">
          <label id="discValueLabel">Chegirma summasi (UZS)</label>
          <input type="number" id="discValueInput" class="field-input" value="${State.cartDiscount.value || 0}" min="0">
        </div>
      `,
      footer: `
        <button class="btn btn-ghost" onclick="closeModal()">Bekor qilish</button>
        <button class="btn btn-primary" onclick="Sale.applyCartDiscount()">Saqlash</button>
      `
    });
  },

  setDiscType(type) {
    State.cartDiscount.type = type;
    const btnSum = document.getElementById('discTypeSum');
    const btnPct = document.getElementById('discTypePct');
    const label = document.getElementById('discValueLabel');

    if (type === 'percent') {
      if (btnSum) btnSum.className = 'btn btn-ghost btn-sm';
      if (btnPct) btnPct.className = 'btn btn-primary btn-sm';
      if (label) label.textContent = 'Chegirma foizi (%)';
    } else {
      if (btnSum) btnSum.className = 'btn btn-primary btn-sm';
      if (btnPct) btnPct.className = 'btn btn-ghost btn-sm';
      if (label) label.textContent = 'Chegirma summasi (UZS)';
    }
  },

  applyCartDiscount() {
    const input = document.getElementById('discValueInput');
    const val = Number(input?.value || 0);

    if (val < 0) {
      toast('Chegirma manfiy bo\'lishi mumkin emas', 'err');
      return;
    }

    State.cartDiscount.value = val;
    closeModal();
    this.renderCart();
    toast('Chegirma qo\'llandi', 'ok');
  },

  paymentModal(defaultType = 'cash') {
    if (State.cart.length === 0) {
      toast('Savat bo\'sh!', 'warn');
      return;
    }

    const subtotal = State.cart.reduce((s, i) => s + (i.product.sale_price * i.qty - (i.discount || 0)), 0);
    const disc = this.calcCartDiscount(subtotal);
    const grandTotal = Math.max(0, subtotal - disc);

    let customerName = 'Mijozsiz';
    if (State.cartCustomerId) {
      const c = State.customers.find(x => x.id === State.cartCustomerId);
      if (c) customerName = c.name;
    }

    openModal({
      title: 'To\'lov qilish',
      wide: true,
      body: `
        <div style="display:grid;grid-template-columns:1fr 1fr;gap:20px">
          <div>
            <div style="font-size:13px;color:var(--text-secondary);margin-bottom:8px">To'lov usuli:</div>
            <div style="display:grid;grid-template-columns:1fr 1fr;gap:8px;margin-bottom:16px">
              <button id="payTypeCash" class="btn btn-primary" onclick="Sale.selectPayType('cash')">💵 Naqd</button>
              <button id="payTypeCard" class="btn btn-ghost" onclick="Sale.selectPayType('card')">💳 Karta</button>
              <button id="payTypeMixed" class="btn btn-ghost" onclick="Sale.selectPayType('mixed')">🔀 Aralash</button>
              <button id="payTypeDebt" class="btn btn-ghost" onclick="Sale.selectPayType('debt')">📒 Qarzga</button>
            </div>

            <div id="payCashBlock">
              <div class="field">
                <label>Qabul qilingan naqd summa</label>
                <input type="number" id="payTenderedInput" class="field-input" value="${grandTotal}" oninput="Sale.calcChange(${grandTotal})">
              </div>
              <div style="padding:12px;background:var(--panel-2);border-radius:8px;margin-top:12px">
                <div style="font-size:13px;color:var(--text-secondary)">Qaytim:</div>
                <div id="payChangeDisplay" style="font-size:24px;font-weight:700;color:var(--ok)">0 UZS</div>
              </div>
            </div>

            <div id="payMixedBlock" class="hidden">
              <div class="field">
                <label>Naqd summa</label>
                <input type="number" id="payMixedCash" class="field-input" value="${Math.round(grandTotal/2)}">
              </div>
              <div class="field">
                <label>Karta summa</label>
                <input type="number" id="payMixedCard" class="field-input" value="${Math.round(grandTotal/2)}">
              </div>
            </div>

            <div id="payDebtBlock" class="hidden">
              <div style="padding:12px;background:var(--chip-warn);border-radius:8px;color:var(--warn)">
                ⚠️ Nasiya savdosi faqat biriktirilgan mijoz uchun rasmiylashtiriladi.<br>
                Hozirgi mijoz: <b>${esc(customerName)}</b>
              </div>
            </div>

            <div style="margin-top:16px">
              <label style="display:flex;align-items:center;gap:8px;cursor:pointer">
                <input type="checkbox" id="chkPrintReceipt" checked>
                <span>Chek chop etish</span>
              </label>
            </div>
          </div>

          <div style="border-left:1px solid var(--border-color);padding-left:20px">
            <div style="font-weight:600;margin-bottom:12px">Chek ma'lumotlari</div>
            <div style="font-size:13px;line-height:1.8">
              <div>Tovarlar soni: <b>${State.cart.length} ta</b></div>
              <div>Oraliq jami: <b>${money(subtotal)}</b></div>
              <div>Chegirma: <b style="color:var(--ok)">${money(disc)}</b></div>
              <div style="font-size:18px;margin-top:12px;padding-top:12px;border-top:1px stroke var(--border-color)">
                Jami to'lov: <b style="color:var(--primary)">${money(grandTotal)}</b>
              </div>
            </div>
          </div>
        </div>
      `,
      footer: `
        <button class="btn btn-ghost" onclick="closeModal()">Bekor qilish</button>
        <button class="btn btn-primary btn-lg" onclick="Sale.confirmPayment(${grandTotal})">✓ Sotish va Tasdiqlash</button>
      `
    });

    this.selectedPayType = defaultType;
    this.selectPayType(defaultType);
  },

  selectedPayType: 'cash',

  selectPayType(type) {
    this.selectedPayType = type;
    const btnCash = document.getElementById('payTypeCash');
    const btnCard = document.getElementById('payTypeCard');
    const btnMixed = document.getElementById('payTypeMixed');
    const btnDebt = document.getElementById('payTypeDebt');

    const blockCash = document.getElementById('payCashBlock');
    const blockMixed = document.getElementById('payMixedBlock');
    const blockDebt = document.getElementById('payDebtBlock');

    [btnCash, btnCard, btnMixed, btnDebt].forEach(b => { if (b) b.className = 'btn btn-ghost'; });

    if (blockCash) blockCash.classList.add('hidden');
    if (blockMixed) blockMixed.classList.add('hidden');
    if (blockDebt) blockDebt.classList.add('hidden');

    if (type === 'cash') {
      if (btnCash) btnCash.className = 'btn btn-primary';
      if (blockCash) blockCash.classList.remove('hidden');
    } else if (type === 'card') {
      if (btnCard) btnCard.className = 'btn btn-primary';
    } else if (type === 'mixed') {
      if (btnMixed) btnMixed.className = 'btn btn-primary';
      if (blockMixed) blockMixed.classList.remove('hidden');
    } else if (type === 'debt') {
      if (btnDebt) btnDebt.className = 'btn btn-primary';
      if (blockDebt) blockDebt.classList.remove('hidden');
    }
  },

  calcChange(grandTotal) {
    const input = document.getElementById('payTenderedInput');
    const display = document.getElementById('payChangeDisplay');
    if (!input || !display) return;

    const tendered = Number(input.value || 0);
    const change = Math.max(0, tendered - grandTotal);
    display.textContent = money(change);
  },

  confirmPayment(grandTotal) {
    if (this.selectedPayType === 'debt' && !State.cartCustomerId) {
      toast('Nasiya uchun mijoz tanlanishi shart!', 'err');
      return;
    }

    const payload = {
      transaction_id: uid('tx'),
      items: State.cart.map(i => ({
        product_id: i.product.id,
        quantity: i.qty,
        discount_amount: i.discount || 0,
      })),
      payment_type: this.selectedPayType,
      customer_id: State.cartCustomerId || 0,
      discount_type: State.cartDiscount.type,
      discount_value: State.cartDiscount.value,
    };

    Api.saleComplete(payload).then(res => {
      const chkPrint = document.getElementById('chkPrintReceipt');
      if (chkPrint && chkPrint.checked) {
        printReceipt({
          transaction_id: payload.transaction_id,
          date: dt(new Date(), true),
          items: State.cart,
          subtotal: grandTotal,
          payment_type: this.selectedPayType,
        });
      }

      closeModal();
      State.cart = [];
      State.cartCustomerId = 0;
      State.cartDiscount = { type: 'amount', value: 0 };
      this.renderCart();

      toast('Sotuv muvaffaqiyatli amalga oshirildi! 🎉', 'ok');
    }).catch(err => {
      toastErr(err || 'Sotuvni yakunlashda xatolik');
    });
  }
};
