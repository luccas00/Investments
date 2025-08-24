import React from 'react';
import { Routes, Route, Link } from 'react-router-dom';

//import 'bootstrap/dist/css/bootstrap.min.css';

import UsuarioDetalhes from './pages/usuarios/UsuarioDetails';
import UsuarioCreate from './pages/usuarios/UsuarioCreate';

import Investimentos from './pages/investimentos/Investimentos';

import Usuarios from './pages/usuarios/Usuarios';
import About from './pages/About';


function Home() {
  return (
    <div className="text-center">
      <h1 className="display-4">Bem-vindo ao My React App</h1>
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
          href="https://github.com/luccas00/WEB_II"
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
              <a className="nav-link"
                   href="https://www.linkedin.com/in/luccas-carneiro-678689171/"
                   target="_blank"
                   rel="noopener noreferrer">
                  LinkedIn
                </a>
            <a className="nav-link"
                 href="https://github.com/luccas00"
                 target="_blank"
                 rel="noopener noreferrer">
                GitHub
              </a>
              <a className="nav-link"
                 href="https://luccas00.github.io/"
                 target="_blank"
                 rel="noopener noreferrer">
                Luccas Carneiro
              </a>
            </div>
          </div>
        </div>
      </nav>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/usuarios" element={<Usuarios />} />
        <Route path="/usuarios/:id" element={<UsuarioDetalhes />} />
        <Route path="/usuarios/new" element={<UsuarioCreate />} />
        <Route path="/investimentos" element={<Investimentos />} />
        <Route path="/about" element={<About />} />
      </Routes>
    </div>
  );
}

export default App;
