import React from 'react';

export default function About() {
  return (
    <div className="container my-4">
      <header className="text-center mb-4">
        <h1>CSI607 – 25.1 – Sistemas Web II</h1>
        <h4>Atividade Prática 03 - Desafio Técnico: API de Gerenciamento de Carteira de Investimentos</h4>
        <p className="mt-2"><strong>👤 Discente</strong><br/>Luccas Vinicius P. A. Santos Carneiro</p>

        {/* Botões de Contato */}
        <div className="d-flex justify-content-center gap-3 mt-3">
          <a
            href="https://www.linkedin.com/in/luccas-carneiro-678689171/"
            target="_blank"
            rel="noopener noreferrer"
            className="btn btn-outline-primary d-flex align-items-center"
            aria-label="LinkedIn"
          >
            <i className="fab fa-linkedin me-2" /> Meu LinkedIn
          </a>
          <a
            href="https://github.com/luccas00"
            target="_blank"
            rel="noopener noreferrer"
            className="btn btn-outline-dark d-flex align-items-center"
            aria-label="GitHub"
          >
            <i className="fab fa-github me-2" /> Meu GitHub
          </a>
         <a
             href="https://luccas00.github.io/"
             target="_blank"
             rel="noopener noreferrer"
             className="btn btn-outline-dark d-flex align-items-center"
             aria-label="Website Repo"
           >
             <i className="fas fa-code me-2" /> Meu Site
           </a>
        </div>
      </header>

      <section className="mb-4">
        <h2>📄 Descrição Geral</h2>
        <p>
          Este repositório contém o Microsserviço de Investimentos (Investments), integrante de uma solução de Gestão de Carteiras e Ativos. A topologia inclui API de Investimentos, Gateway de Roteamento (edge) e Service Discovery (Eureka).
          Objetivo: orquestrar operações de carteira e gerenciar ativos para usuários finais com contratos RESTful, persistência relacional e observabilidade básica.
        </p>
        <p>
          O projeto foi desenvolvido em Java 17 com Spring Boot, seguindo boas práticas de arquitetura de
          microsserviços, padrões RESTful e persistência relacional via JPA/Hibernate, garantindo escalabilidade,
          manutenção facilitada e padronização corporativa.
        </p>
      </section>

      <section className="mb-4">
        <h2>📌 Modelo de Atividade</h2>
        <p>Entrega incremental orientada a requisitos, com versionamento e integração contínua.</p>
      </section>

      <section className="mb-4">
        <h2>⚙️ Tecnologias Utilizadas</h2>
        <ul>
          <li>Java 17</li>
          <li>Spring Boot</li>
          <li>Maven</li>
          <li>Spring Data JPA (Hibernate)</li>
          <li>API REST</li>
          <li>Banco De Dados Relacional - PostgreSQL</li>
        </ul>
      </section>

      <section className="mb-4">
        <h2>✅ Funcionalidades Implementadas</h2>
        <ul>
          <li>Gestão De Carteiras e Ativos</li>
          <li>Cadastro de Usuarios</li>
          <li>API RESTful Com Endpoints Claros E Versionados</li>
        </ul>
      </section>

      <section className="mb-4">
        <h2>🧩 Serviços</h2>
        <ul>
          <li>Investments Application</li>
          <li>React Frontend</li>
        </ul>
      </section>

      <section className="mb-4">
        <h2>🚪 Portas Padrão</h2>
        <div className="table-responsive">
          <table className="table table-striped table-bordered">
            <thead className="table-dark">
              <tr>
                <th>Serviço</th>
                <th>Porta</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Investment Application</td>
                <td>3939</td>
              </tr>
              <tr>
                <td>React Frontend</td>
                <td>9012</td>
              </tr>
              <tr>
                <td>Gateway Application</td>
                <td>9999</td>
              </tr>
              <tr>
                <td>Nameserver</td>
                <td>9761</td>
              </tr>
            </tbody>
          </table>
        </div>
      </section>

      <footer className="mt-4">
        <h2>🎓 Disciplina</h2>
        <p>CSI607 – 25.1 – Sistemas Web II</p>
      </footer>
    </div>
  );
}
