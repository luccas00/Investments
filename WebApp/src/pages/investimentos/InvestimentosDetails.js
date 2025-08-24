import React, { useEffect, useState } from 'react';
import { useParams, Link } from 'react-router-dom';
import { API_BASE_URL } from '../Config';

export default function InvestmentDetails() {
    const { id } = useParams();
    const [investment, setInvestment] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    // Alinhado ao UsuarioDetails
    const formatType = (t) =>
        ({ ACAO: 'Ação', RENDA_FIXA: 'Renda Fixa', CRIPTO: 'Criptomoedas', FUNDO: 'Fundo de Investimento', OUTROS: 'Outros' }[t] ?? t);

    // Requisito: "R$" ao final
    const formatPrice = (v) =>
        `${Number(v ?? 0).toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 })} R$`;

    const formatDateTime = (d) => {
        if (!d) return '—';
        try {
            return new Date(d).toLocaleString('pt-BR');
        } catch {
            return String(d);
        }
    };

    useEffect(() => {
        // Endpoint de detalhe por ID
        fetch(`${API_BASE_URL}/investments/${id}`)
            .then((res) => {
                if (!res.ok) throw new Error('Erro ao buscar investimento');
                return res.json();
            })
            .then((data) => {
                // Caso a API retorne array (ex.: filtro por ID), normaliza para o primeiro item
                const item = Array.isArray(data) ? data[0] : data;
                setInvestment(item || null);
                setLoading(false);
            })
            .catch((err) => {
                setError(err.message);
                setLoading(false);
            });
    }, [id]);

    if (loading) return <p>Carregando detalhes...</p>;
    if (error) return <p>Erro: {error}</p>;
    if (!investment) return <p>Nenhum dado encontrado.</p>;

    const u = investment.user || {};

    return (
        <div>
            <h1 className="mb-4">Detalhes do Investimento</h1>

            <p><strong>ID:</strong> {investment.id}</p>
            <p><strong>Tipo:</strong> {formatType(investment.type)}</p>
            <p><strong>Status:</strong> {investment.status}</p>
            <p><strong>Ativo/Símbolo:</strong> {investment.symbol}</p>
            <p><strong>Quantidade:</strong> {investment.quantity}</p>
            <p><strong>Preço de Compra:</strong> {formatPrice(investment.purchasePrice)}</p>
            <p><strong>Data de Compra:</strong> {formatDateTime(investment.purchaseDate)}</p>

            <h3 className="mt-4">Usuário</h3>
            <p><strong>ID Usuário:</strong> {u.id || '—'}</p>
            <p><strong>Nome:</strong> {u.name || '—'}</p>
            <p><strong>Email:</strong> {u.email || '—'}</p>
            <p><strong>Telefone:</strong> {u.phone || '—'}</p>

            <Link to="/investimentos" className="btn btn-secondary mt-3">Voltar</Link>
        </div>
    );
}
