import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { API_BASE_URL } from '../Config';

const STATUS_OPTIONS = [
  { value: 'EM_ABERTO', label: 'Em Aberto' },
  { value: 'EXECUTADO', label: 'Executado' },
  { value: 'PAGO', label: 'Pago' },
  { value: 'CANCELADO', label: 'Cancelado' },
  { value: 'ESTORNADO', label: 'Estornado' },
];

const TYPE_OPTIONS = [
  { value: 'ACAO', label: 'Ação' },
  { value: 'FUNDO', label: 'FII' },
  { value: 'CRIPTO', label: 'Criptomoeda' },
  { value: 'RENDA_FIXA', label: 'Renda Fixa' },
  { value: 'OUTRO', label: 'Outro' },
];

export default function InvestmentsCreate() {
  const navigate = useNavigate();
  const [form, setForm] = useState({
    user: '',
    type: 'ACAO',
    status: 'EM_ABERTO',
    symbol: '',
    quantity: '',
    purchasePrice: ''
  });

  const handleChange = (e) =>
      setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();

    const payload = {
      user: form.user || null,
      type: form.type,
      status: form.status,
      symbol: form.symbol,
      quantity: parseFloat(form.quantity) || 0,
      purchasePrice: parseFloat(form.purchasePrice) || 0
    };

    try {
      const res = await fetch(`${API_BASE_URL}/investments`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload)
      });
      if (!res.ok) {
        const text = await res.text();
        throw new Error(text || 'Erro ao criar investimento');
      }
      await res.json();
      navigate('/investimentos');
    } catch (err) {
      alert(err.message);
    }
  };

  return (
      <div>
        <h1>Criar Investimento</h1>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label>Usuário (UUID)</label>
            <input
                name="user"
                className="form-control"
                value={form.user}
                onChange={handleChange}
                placeholder="ex: 550e8400-e29b-41d4-a716-446655440000"
                required
            />
          </div>

          <div className="mb-3">
            <label>Tipo de Investimento</label>
            <select
                name="type"
                className="form-control"
                value={form.type}
                onChange={handleChange}
                required
            >
              {TYPE_OPTIONS.map(t => (
                  <option key={t.value} value={t.value}>{t.label}</option>
              ))}
            </select>
          </div>

          <div className="mb-3">
            <label>Status</label>
            <select
                name="status"
                className="form-control"
                value={form.status}
                onChange={handleChange}
                required
            >
              {STATUS_OPTIONS.map(s => (
                  <option key={s.value} value={s.value}>{s.label}</option>
              ))}
            </select>
          </div>

          <div className="mb-3">
            <label>Símbolo</label>
            <input
                name="symbol"
                className="form-control"
                value={form.symbol}
                onChange={handleChange}
                placeholder="ex: PETR4, BTC"
                required
            />
          </div>

          <div className="mb-3">
            <label>Quantidade</label>
            <input
                name="quantity"
                type="number"
                step="0.01"
                className="form-control"
                value={form.quantity}
                onChange={handleChange}
                required
            />
          </div>

          <div className="mb-3">
            <label>Preço de Compra</label>
            <input
                name="purchasePrice"
                type="number"
                step="0.01"
                className="form-control"
                value={form.purchasePrice}
                onChange={handleChange}
                required
            />
          </div>

          <button type="submit" className="btn btn-primary">Criar</button>
          <button
              type="button"
              className="btn btn-secondary ms-2"
              onClick={() => navigate('/investimentos')}
          >
            Cancelar
          </button>
        </form>
      </div>
  );
}
