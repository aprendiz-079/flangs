// ============================================
// CONFIGURAÇÃO
// ============================================
const API_BASE = '/api';

// ============================================
// FUNÇÕES AUXILIARES
// ============================================

async function apiGet(endpoint) {
    const response = await fetch(`${API_BASE}${endpoint}`);
    if (!response.ok) throw new Error(`Erro ${response.status}`);
    return response.json();
}

async function apiPost(endpoint, data = {}) {
    const response = await fetch(`${API_BASE}${endpoint}`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    });
    if (!response.ok) throw new Error(`Erro ${response.status}`);
    return response.json();
}

async function apiDelete(endpoint) {
    const response = await fetch(`${API_BASE}${endpoint}`, {
        method: 'DELETE'
    });
    if (!response.ok) throw new Error(`Erro ${response.status}`);
    return response.json();
}

function formatMoney(value) {
    const prefix = value >= 0 ? '+ ' : '- ';
    return prefix + 'R$ ' + Math.abs(value).toFixed(2);
}

function escapeHtml(text) {
    const div = document.createElement('div');
    div.textContent = text;
    return div.innerHTML;
}

function getQueryParam(param) {
    const params = new URLSearchParams(window.location.search);
    return params.get(param);
}

function showError(message) {
    alert(message);
}

// ============================================
// PÁGINA: index.html (Home)
// ============================================
async function loadOrders() {
    try {
        const orders = await apiGet('/orders');
        renderOrdersTable(orders);
    } catch (error) {
        showError('Erro ao carregar comandas');
    }
}

function renderOrdersTable(orders) {
    const tbody = document.querySelector('#orders-tbody');
    
    if (orders.length === 0) {
        tbody.innerHTML = '<tr><td colspan="7" class="empty-state">📋 Nenhuma comanda criada ainda.</td></tr>';
        return;
    }
    
    tbody.innerHTML = orders.map(order => `
        <tr>
            <td><input type="radio" name="orderId" value="${order.id}"></td>
            <td>#${order.id}</td>
            <td><strong>${escapeHtml(order.clientName)}</strong></td>
            <td style="color: #2e7d32;">R$ ${order.credit.toFixed(2)}</td>
            <td style="color: #c62828;">R$ ${order.debit.toFixed(2)}</td>
            <td style="font-weight: bold; color: ${order.balance >= 0 ? '#2e7d32' : '#c62828'};">
                ${formatMoney(order.balance)}
            </td>
            <td>
                <span class="${order.open ? 'status-open' : 'status-closed'}">
                    ${order.open ? '🟢 Aberta' : '🔴 Fechada'}
                </span>
            </td>
        </tr>
    `).join('');
}

function getSelectedOrderId() {
    const selected = document.querySelector('input[name="orderId"]:checked');
    if (!selected) {
        alert('⚠️ Selecione uma comanda!');
        return null;
    }
    return selected.value;
}

function openOrder() {
    const id = getSelectedOrderId();
    if (id) window.location.href = `order.html?id=${id}`;
}

async function closeOrderAction() {
    const id = getSelectedOrderId();
    if (id && confirm('Tem certeza que deseja FECHAR esta comanda?')) {
        await apiPost(`/orders/${id}/close`);
        loadOrders();
    }
}

async function removeOrderAction() {
    const id = getSelectedOrderId();
    if (id && confirm('⚠️ ATENÇÃO: Isso removerá a comanda e TODOS os itens permanentemente!')) {
        await apiDelete(`/orders/${id}`);
        loadOrders();
    }
}

async function createOrder(event) {
    event.preventDefault();
    const clientName = document.querySelector('#clientName').value.trim();
    
    if (!clientName) return;
    
    await apiPost('/orders', { clientName });
    document.querySelector('#clientName').value = '';
    loadOrders();
}

// ============================================
// PÁGINA: order.html (Comanda)
// ============================================
async function loadOrder() {
    const orderId = getQueryParam('id');
    if (!orderId) {
        showError('Comanda não especificada');
        return;
    }
    
    try {
        const order = await apiGet(`/orders/${orderId}`);
        window.currentOrderId = orderId;
        window.currentOrder = order;
        
        document.querySelector('#order-title').textContent = `🧾 Comanda: ${escapeHtml(order.clientName)}`;
        document.querySelector('#back-link').href = 'index.html';
        document.querySelector('#menu-link').href = `menu.html?orderId=${orderId}`;
        document.querySelector('#history-link').href = `history.html?orderId=${orderId}`;
        
        if (order.open) {
            document.querySelector('#order-status').innerHTML = '<span class="alert-open">🟢 ABERTA</span>';
            document.querySelector('#add-manual-form').style.display = 'block';
            document.querySelector('#item-actions').style.display = 'flex';
        } else {
            document.querySelector('#order-status').innerHTML = '<span class="alert-closed">🔒 FECHADA</span>';
            document.querySelector('#add-manual-form').style.display = 'none';
            document.querySelector('#item-actions').style.display = 'none';
        }
        
        renderOrderItems(order);
        renderOrderSummary(order);
        
    } catch (error) {
        showError('Comanda não encontrada');
    }
}

function renderOrderItems(order) {
    const tbody = document.querySelector('#items-tbody');
    
    if (order.items.length === 0) {
        tbody.innerHTML = '<tr><td colspan="8">📭 Nenhum item adicionado.</td></tr>';
        return;
    }
    
    tbody.innerHTML = order.items.map(item => `
        <tr>
            <td><input type="radio" name="itemCode" value="${item.code}"></td>
            <td>#${item.code}</td>
            <td>${escapeHtml(item.name)}</td>
            <td>${item.quantity}</td>
            <td>R$ ${item.unitPrice.toFixed(2)}</td>
            <td>R$ ${item.total.toFixed(2)}</td>
            <td>${item.dateTime || ''}</td>
            <td>
                <span class="${item.paid ? 'paid' : 'unpaid'}">
                    ${item.paid ? '✅ Pago' : '⏳ À pagar'}
                </span>
            </td>
        </tr>
    `).join('');
}

function renderOrderSummary(order) {
    document.querySelector('#credit-value').textContent = `R$ ${order.credit.toFixed(2)}`;
    document.querySelector('#debit-value').textContent = `R$ ${order.debit.toFixed(2)}`;
    
    const balanceEl = document.querySelector('#balance-value');
    balanceEl.textContent = formatMoney(order.balance);
    balanceEl.className = order.balance >= 0 ? 'balance-positive' : 'balance-negative';
    
    if (order.balance < 0) {
        balanceEl.textContent += ' (deve)';
    } else if (order.balance > 0) {
        balanceEl.textContent += ' (crédito)';
    }
}

function getSelectedItemCode() {
    const selected = document.querySelector('input[name="itemCode"]:checked');
    if (!selected) {
        alert('⚠️ Selecione um item!');
        return null;
    }
    return selected.value;
}

async function itemAction(action) {
    const itemCode = getSelectedItemCode();
    if (!itemCode) return;
    
    try {
        const order = await apiPost(`/orders/${window.currentOrderId}/items/${itemCode}/${action}`);
        window.currentOrder = order;
        renderOrderItems(order);
        renderOrderSummary(order);
    } catch (error) {
        showError('Erro na operação');
    }
}

function incrementItem() { itemAction('increment'); }
function decrementItem() { itemAction('decrement'); }
function markAsPaid() { itemAction('pay'); }

async function removeItem() {
    const itemCode = getSelectedItemCode();
    if (!itemCode) return;
    if (!confirm('Remover este item?')) return;
    
    try {
        const order = await apiDelete(`/orders/${window.currentOrderId}/items/${itemCode}`);
        window.currentOrder = order;
        renderOrderItems(order);
        renderOrderSummary(order);
    } catch (error) {
        showError('Erro ao remover');
    }
}

async function addManualItem(event) {
    event.preventDefault();
    
    const nameInput = document.querySelector('#manual-item-name');
    const qtyInput = document.querySelector('#manual-item-qty');
    const priceInput = document.querySelector('#manual-item-price');
    
    const name = nameInput.value.trim();
    const qty = parseInt(qtyInput.value);
    const price = parseFloat(priceInput.value);
    
    if (!name) return;
    
    try {
        // Tenta buscar pelo código no cardápio
        if (/^\d{3}$/.test(name)) {
            try {
                const menuItem = await apiGet(`/menu/code/${name}`);
                if (menuItem) {
                    const order = await apiPost(`/orders/${window.currentOrderId}/items`, {
                        name: menuItem.name,
                        quantity: qty,
                        unitPrice: menuItem.price,
                        paid: false
                    });
                    window.currentOrder = order;
                    nameInput.value = '';
                    qtyInput.value = '1';
                    priceInput.value = '';
                    renderOrderItems(order);
                    renderOrderSummary(order);
                    return;
                }
            } catch (e) {
                // Código não encontrado, continua como item manual
            }
        }
        
        // Item manual
        if (!price || price <= 0) {
            alert('Informe um valor unitário válido');
            return;
        }
        
        const order = await apiPost(`/orders/${window.currentOrderId}/items`, {
            name: name,
            quantity: qty,
            unitPrice: price,
            paid: false
        });
        
        window.currentOrder = order;
        nameInput.value = '';
        qtyInput.value = '1';
        priceInput.value = '';
        renderOrderItems(order);
        renderOrderSummary(order);
        
    } catch (error) {
        showError('Erro ao adicionar item');
    }
}

// ============================================
// PÁGINA: menu.html (Cardápio)
// ============================================
async function loadMenu() {
    const orderId = getQueryParam('orderId');
    if (!orderId) {
        showError('Comanda não especificada');
        return;
    }
    
    window.currentOrderId = orderId;
    document.querySelector('#back-link').href = `order.html?id=${orderId}`;
    
    try {
        const menu = await apiGet('/menu');
        renderMenu(menu);
    } catch (error) {
        showError('Erro ao carregar cardápio');
    }
}

function renderMenu(menu) {
    const container = document.querySelector('#menu-container');
    let html = '';
    
    const icons = {
        'Bebidas': '🍹',
        'Comestíveis': '🍽️',
        'Limpeza': '🧹'
    };
    
    for (const [category, subcategories] of Object.entries(menu)) {
        const icon = icons[category] || '📦';
        html += `<div class="category-title">${icon} ${category}</div>`;
        
        for (const [subcategory, subsubs] of Object.entries(subcategories)) {
            html += `<div class="subcategory-title">${subcategory}</div>`;
            
            for (const [subsub, items] of Object.entries(subsubs)) {
                if (subsub && subsub !== '') {
                    html += `<div class="subsub-title">${subsub}</div>`;
                }
                
                items.forEach(item => {
                    html += `
                        <div class="menu-item">
                            <span class="item-name">[${item.code}] ${escapeHtml(item.name)}</span>
                            <span class="item-price">R$ ${item.price.toFixed(2)}</span>
                            <a href="confirm.html?orderId=${window.currentOrderId}&itemId=${item.id}" class="select-btn">Selecionar</a>
                        </div>
                    `;
                });
            }
        }
    }
    
    container.innerHTML = html;
}

// ============================================
// PÁGINA: confirm.html (Confirmar Item)
// ============================================
async function loadConfirmItem() {
    const orderId = getQueryParam('orderId');
    const itemId = getQueryParam('itemId');
    
    if (!orderId || !itemId) {
        showError('Parâmetros inválidos');
        return;
    }
    
    window.currentOrderId = orderId;
    document.querySelector('#cancel-link').href = `menu.html?orderId=${orderId}`;
    
    try {
        const item = await apiGet(`/menu/${itemId}`);
        
        document.querySelector('#item-name').textContent = item.name;
        document.querySelector('#item-price').textContent = `Preço unitário: R$ ${item.price.toFixed(2)}`;
        document.querySelector('#unitPrice').value = item.price;
        window.unitPrice = item.price;
        
        updateTotal();
        
    } catch (error) {
        showError('Item não encontrado');
    }
}

function changeQty(delta) {
    const input = document.querySelector('#quantity');
    const newVal = parseInt(input.value) + delta;
    if (newVal >= 1) {
        input.value = newVal;
        updateTotal();
    }
}

function updateTotal() {
    const qty = parseInt(document.querySelector('#quantity').value);
    const total = qty * window.unitPrice;
    document.querySelector('#totalPreview').textContent = total.toFixed(2);
}

async function confirmItem(event) {
    event.preventDefault();
    
    const qty = parseInt(document.querySelector('#quantity').value);
    const price = parseFloat(document.querySelector('#unitPrice').value);
    const name = document.querySelector('#item-name').textContent;
    const paid = document.querySelector('input[name="paid"]:checked').value === 'true';
    
    try {
        await apiPost(`/orders/${window.currentOrderId}/items`, {
            name: name,
            quantity: qty,
            unitPrice: price,
            paid: paid
        });
        
        window.location.href = `order.html?id=${window.currentOrderId}`;
        
    } catch (error) {
        showError('Erro ao adicionar item');
    }
}

// ============================================
// PÁGINA: history.html (Histórico)
// ============================================
async function loadHistory() {
    const orderId = getQueryParam('orderId');
    if (!orderId) {
        showError('Comanda não especificada');
        return;
    }
    
    try {
        const order = await apiGet(`/orders/${orderId}`);
        
        document.querySelector('#history-title').textContent = `📜 Histórico: ${escapeHtml(order.clientName)}`;
        document.querySelector('#back-link').href = `order.html?id=${orderId}`;
        
        renderLogs(order.logs);
        
    } catch (error) {
        showError('Erro ao carregar histórico');
    }
}

function renderLogs(logs) {
    const container = document.querySelector('#logs-container');
    
    if (!logs || logs.length === 0) {
        container.innerHTML = '<p style="color: #e0e0e0;">Nenhuma movimentação registrada.</p>';
        return;
    }
    
    container.innerHTML = logs.map(log => `
        <div class="log-entry">
            <span class="timestamp">${log.timestamp || ''}</span>
            <span class="arrow">=></span>
            <span>${escapeHtml(log.description)}</span>
            <span>; saldo: </span>
            <span class="${log.balanceAfter >= 0 ? 'balance-positive' : 'balance-negative'}">
                ${formatMoney(log.balanceAfter)}
            </span>
        </div>
    `).join('');
}

// ============================================
// INICIALIZAÇÃO
// ============================================
document.addEventListener('DOMContentLoaded', () => {
    const page = document.body.dataset.page;
    
    switch (page) {
        case 'index':
            loadOrders();
            document.querySelector('#create-order-form').addEventListener('submit', createOrder);
            document.querySelector('#btn-open').addEventListener('click', openOrder);
            document.querySelector('#btn-close').addEventListener('click', closeOrderAction);
            document.querySelector('#btn-remove').addEventListener('click', removeOrderAction);
            break;
            
        case 'order':
            loadOrder();
            document.querySelector('#add-manual-form').addEventListener('submit', addManualItem);
            document.querySelector('#btn-increment').addEventListener('click', incrementItem);
            document.querySelector('#btn-decrement').addEventListener('click', decrementItem);
            document.querySelector('#btn-pay').addEventListener('click', markAsPaid);
            document.querySelector('#btn-remove-item').addEventListener('click', removeItem);
            break;
            
        case 'menu':
            loadMenu();
            break;
            
        case 'confirm':
            loadConfirmItem();
            document.querySelector('#confirm-form').addEventListener('submit', confirmItem);
            document.querySelector('#btn-plus').addEventListener('click', () => changeQty(1));
            document.querySelector('#btn-minus').addEventListener('click', () => changeQty(-1));
            document.querySelector('#quantity').addEventListener('input', updateTotal);
            break;
            
        case 'history':
            loadHistory();
            break;
    }
});
