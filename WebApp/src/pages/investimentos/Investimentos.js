import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { API_BASE_URL } from '../Config';

export default function Investments() {
  const [items, setItems] = useState([]);
  const [health, setHealth] = useState('N/A');
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchHealth();
    fetchInvestments();
  }, []);

  const fetchHealth = () => {
    fetch(`${API_BASE_URL}/investments/status`)
        .then(r => (r.ok ? r.text() : Promise.reject()))
        .then(txt => setHealth(txt && txt.toLowerCase().includes('running') ? 'UP' : 'DOWN'))
        .catch(() => setHealth('DOWN'));
  };

  const fetchInvestments = () => {
    setLoading(true);
    fetch(`${API_BASE_URL}/investments`)
        .then(res => {
          if (!res.ok) throw new Error(`Falha ao buscar investimentos (${res.status})`);
          return res.json();
        })
        .then(data => setItems(Array.isArray(data) ? data : (data && data.content ? data.content : [])))
        .catch(err => setError(err.message || 'Erro inesperado'))
        .finally(() => setLoading(false));
  };

  const handleDelete = (id) => {
    if (!window.confirm('Confirma a exclusão do investimento?')) return;

    fetch(`${API_BASE_URL}/investments/remove`, {
      method: 'DELETE',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ id }),
    })
        .then(res => {
          if (!res.ok) throw new Error('Erro ao deletar investimento');
          return res.text();
        })
        .then(() => setItems(prev => prev.filter(i => i.id !== id)))
        .catch(err => alert(err.message || 'Erro ao excluir'));
  };

  const fmtDate = (iso) => {
    if (!iso) return '-';
    const d = new Date(iso);
    return isNaN(d.getTime())
        ? iso
        : new Intl.DateTimeFormat('pt-BR', { dateStyle: 'short', timeStyle: 'short' }).format(d);
  };

  const fmtMoney = (n) =>
      typeof n === 'number'
          ? new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(n)
          : '-';

  if (loading) return <p>Carregando investimentos...</p>;
  if (error) return <p>Erro: {error}</p>;

  return (
      <div>
        <div className="d-flex justify-content-between align-items-center mb-3">
          <h1 className="mb-0">Investimentos</h1>
          <div className="d-flex gap-2">
          <span className={`badge ${health === 'UP' ? 'bg-success' : 'bg-danger'}`}>
            Service: {health}
          </span>
            <button className="btn btn-outline-primary" onClick={fetchInvestments}>
              Atualizar
            </button>
            <Link to="/investimentos/new" className="btn btn-success" style={{ width: '5cm' }}>
              Novo Investimento
            </Link>
          </div>
        </div>

        <table className="table table-striped table-bordered">
          <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>Usuário</th>
            <th>Email</th>
            <th>Tipo</th>
            <th>Status</th>
            <th>Ativo (Symbol)</th>
            <th>Quantidade</th>
            <th>Preço de Compra</th>
            <th>Data da Compra</th>
            <th className="text-center" style={{ width: 200 }}>Ações</th>
          </tr>
          </thead>
          <tbody>
          {items.map((inv) => (
              <tr key={inv.id}>
                <td style={{ maxWidth: 220, wordBreak: 'break-all' }}>{inv.id}</td>
                <td title={inv.user?.id}>{inv.user?.name || '-'}</td>
                <td>{inv.user?.email || '-'}</td>
                <td>{inv.type || '-'}</td>
                <td>{inv.status || '-'}</td>
                <td>{inv.symbol || '-'}</td>
                <td>{typeof inv.quantity === 'number' ? inv.quantity : '-'}</td>
                <td>{fmtMoney(inv.purchasePrice)}</td>
                <td>{fmtDate(inv.purchaseDate)}</td>
                <td className="text-center">
                  <div className="d-flex justify-content-center gap-2">
                    <Link to={`/investimentos/${inv.id}`} className="btn btn-info btn-sm">
                      Detalhes
                    </Link>
                    <button
                        onClick={() => handleDelete(inv.id)}
                        className="btn btn-danger btn-sm"
                    >
                      Excluir
                    </button>
                  </div>
                </td>
              </tr>
          ))}
          {items.length === 0 && (
              <tr>
                <td colSpan={10} className="text-center">Nenhum investimento encontrado.</td>
              </tr>
          )}
          </tbody>
        </table>
      </div>
  );
}
