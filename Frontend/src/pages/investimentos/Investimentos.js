import React, { useEffect, useState } from 'react';
import { API_BASE_URL } from '../Config';

export default function Investimentos() {
  const [investimentos, setInvestimentos] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [form, setForm] = useState({
    user: '',
    type: '',
    status: '',
    symbol: '',
    quantity: '',
    purchasePrice: ''
  });

  useEffect(() => {
    fetchInvestimentos();
  }, []);

  const fetchInvestimentos = () => {
    fetch(`${API_BASE_URL}/investments`)
      .then(res => {
        if (!res.ok) throw new Error('Erro ao buscar investimentos');
        return res.json();
      })
      .then(data => {
        setInvestimentos(data);
        setLoading(false);
      })
      .catch(err => {
        setError(err.message);
        setLoading(false);
      });
  };

  const handleChange = e => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = e => {
    e.preventDefault();
    fetch(`${API_BASE_URL}/investments`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        user: form.user,
        type: form.type,
        status: form.status,
        symbol: form.symbol,
        quantity: parseFloat(form.quantity),
        purchasePrice: parseFloat(form.purchasePrice)
      })
    })
      .then(res => {
        if (!res.ok) throw new Error('Erro ao criar investimento');
        return res.json();
      })
      .then(inv => {
        setInvestimentos(prev => [...prev, inv]);
        setForm({ user: '', type: '', status: '', symbol: '', quantity: '', purchasePrice: '' });
      })
      .catch(err => alert(err.message));
  };

  const handleDelete = id => {
    if (!window.confirm('Confirma exclusão deste investimento?')) return;

    fetch(`${API_BASE_URL}/investments/remove`, {
      method: 'DELETE',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ id })
    })
      .then(res => {
        if (!res.ok) throw new Error('Erro ao excluir investimento');
        return res.text();
      })
      .then(() => {
        setInvestimentos(prev => prev.filter(inv => inv.id !== id));
      })
      .catch(err => alert(err.message));
  };

  if (loading) return <p>Carregando investimentos...</p>;
  if (error) return <p>Erro: {error}</p>;

  return (
    <div>
      <h1 className="text-center mb-4">Investimentos</h1>

      <form onSubmit={handleSubmit} className="mb-4">
        <div className="row g-2">
          <div className="col">
            <input name="user" className="form-control" placeholder="Usuário" value={form.user} onChange={handleChange} required />
          </div>
          <div className="col">
            <input name="type" className="form-control" placeholder="Tipo" value={form.type} onChange={handleChange} required />
          </div>
          <div className="col">
            <input name="status" className="form-control" placeholder="Status" value={form.status} onChange={handleChange} required />
          </div>
          <div className="col">
            <input name="symbol" className="form-control" placeholder="Símbolo" value={form.symbol} onChange={handleChange} required />
          </div>
          <div className="col">
            <input name="quantity" type="number" step="any" className="form-control" placeholder="Quantidade" value={form.quantity} onChange={handleChange} required />
          </div>
          <div className="col">
            <input name="purchasePrice" type="number" step="any" className="form-control" placeholder="Preço" value={form.purchasePrice} onChange={handleChange} required />
          </div>
          <div className="col-auto">
            <button type="submit" className="btn btn-success">Adicionar</button>
          </div>
        </div>
      </form>

      <table className="table table-striped table-bordered">
        <thead className="table-dark">
          <tr>
            <th>Símbolo</th>
            <th>Tipo</th>
            <th>Quantidade</th>
            <th>Preço Compra</th>
            <th className="text-center" style={{ width: '150px' }}>Ações</th>
          </tr>
        </thead>
        <tbody>
          {investimentos.map(inv => (
            <tr key={inv.id}>
              <td>{inv.symbol}</td>
              <td>{inv.type}</td>
              <td>{inv.quantity}</td>
              <td>{inv.purchasePrice}</td>
              <td className="text-center">
                <button onClick={() => handleDelete(inv.id)} className="btn btn-danger btn-sm">Excluir</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
