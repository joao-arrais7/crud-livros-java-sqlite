# CRUD de Livros em Java com SQLite

Projeto acadêmico desenvolvido para praticar **Java**, **JDBC** e **operações CRUD** com banco de dados **SQLite**.

## 🎯 Objetivo

Criar um sistema simples de cadastro de livros em Java, com:

- Criação automática da tabela `livros`
- Cadastro, listagem, atualização e exclusão de livros (CRUD)
- Acesso ao banco de dados usando JDBC
- Interface simples com `JOptionPane`

## 🧱 Tecnologias usadas

- Java
- JDBC
- SQLite
- Swing (`JOptionPane`)

## 📂 Estrutura do projeto

- `Conexao.java` – faz a conexão com o banco `biblioteca.db`
- `Livro.java` – classe de modelo (entidade Livro)
- `LivroDAO.java` – camada de acesso a dados (CRUD no banco)
- `Main.java` – menu com opções para o usuário (cadastrar, listar, atualizar, excluir)

## ▶️ Como executar

1. Clonar o repositório:
git clone https://github.com/joao-arrais7/crud-livros-java-sqlite.git


2. Abrir o projeto em uma IDE Java (IntelliJ, Eclipse ou VS Code com extensão Java).

3. Garantir que o driver JDBC do SQLite esteja configurado no projeto.

4. Executar a classe `Main`.

Na primeira execução, o arquivo `biblioteca.db` e a tabela `livros` serão criados automaticamente (se ainda não existirem).

## 🔍 Próximos passos (ideias de melhoria)

- Validações de entrada (ex: não permitir campos vazios)
- Tratamento de erros mais amigável
- Substituir `JOptionPane` por uma interface gráfica mais completa ou API REST com Spring Boot

git add README.md
git commit -m "docs: melhora README do projeto"
git push
