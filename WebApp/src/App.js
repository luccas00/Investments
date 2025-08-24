import React from 'react';
import { Routes, Route, Link } from 'react-router-dom';

import Usuarios from './pages/usuarios/Usuarios';
import UsuarioDetalhes from './pages/usuarios/UsuarioDetails';
import UsuarioCreate from './pages/usuarios/UsuarioCreate';

import Investimentos from './pages/investimentos/Investimentos';
import InvestimentoDetalhes from './pages/investimentos/InvestimentosDetails'; // <-- alinhe o nome do arquivo
import InvestimentoCreate from './pages/investimentos/InvestimentosCreate';

import About from './pages/About';

function Home() {
    return (
        <div className="text-center">
            <h1 className="display-4">Welcome to my React Web App</h1>
            <p className="lead">Esta é a página inicial do seu projeto com React Router.</p>
            <p>Use a navegação acima para acessar outras páginas.</p>
            <div className="d-flex justify-content-center my-4">
                <a
                    className="btn btn-dark"
                    style={{ width: '50%' }}
                    href="https://learn.microsoft.com/en-us/azure/static-web-apps/get-started-portal?tabs=react&pivots=github"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Quickstart: Build your first static web app
                </a>
            </div>
            <div className="d-flex justify-content-center my-4">
                <a
                    className="btn btn-dark"
                    style={{ width: '50%' }}
                    href="https://github.com/luccas00/Investments"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    GitHub Repository
                </a>
            </div>
        </div>
    );
}

function App() {
    return (
        <div className="container mt-5">
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
                <div className="container-fluid">
                    <Link className="navbar-brand" to="/">My React App</Link>
                    <button
                        className="navbar-toggler"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#navbarNav"
                        aria-controls="navbarNav"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                    >
                        <span className="navbar-toggler-icon"></span>
                    </button>

                    <div className="collapse navbar-collapse" id="navbarNav">
                        <div className="navbar-nav">
                            <Link className="nav-link" to="/usuarios">Usuários</Link>
                            <Link className="nav-link" to="/investimentos">Investimentos</Link>
                            <Link className="nav-link" to="/about">Sobre</Link>
                        </div>
                    </div>
                </div>
            </nav>

            <Routes>
                <Route path="/" element={<Home />} />

                {/* Usuários */}
                <Route path="/usuarios" element={<Usuarios />} />
                <Route path="/usuarios/new" element={<UsuarioCreate />} />
                <Route path="/usuarios/:id" element={<UsuarioDetalhes />} />

                {/* Investimentos (padronizado em PT) */}
                <Route path="/investimentos" element={<Investimentos />} />
                <Route path="/investimentos/new" element={<InvestimentoCreate />} />
                <Route path="/investimentos/:id" element={<InvestimentoDetalhes />} />

                {/* Sobre */}
                <Route path="/about" element={<About />} />
            </Routes>
        </div>
    );
}

export default App;
