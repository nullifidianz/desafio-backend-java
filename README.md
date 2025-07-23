# Desafio Técnico - Biblioteca Virtual

## Objetivo
Construir uma API RESTful para gerenciar empréstimos de livros em uma biblioteca virtual.

## Requisitos Obrigatórios
- CRUD de livros: título, autor, ISBN, ano de publicação.
- CRUD de usuários: nome, e-mail, CPF (único).
- Endpoint para registrar empréstimo de livro a um usuário.
    /post livro para user
- Endpoint para devolução de livro.
    /post remover livro 
- Validação: um usuário não pode pegar mais de 5 livros emprestados simultaneamente.
- Um livro só pode ser emprestado se estiver disponível.

## Tecnologias Esperadas
- Java 17+
- Spring Boot
- JPA + H2 ou PostgreSQL
- Maven

## Entrega
- Submeter via GitHub.
- README com instruções de build, execução e testes.

