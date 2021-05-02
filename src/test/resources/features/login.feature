# language: pt

Funcionalidade: Apenas usuários cadastrados podem fazer login

  Cenário: Um usuário válido consegue fazer login
    Dado o usuário válido
    Quando realiza login
    Então é direcionado para a página de leilões

  Cenário: Um usuário inválido não consegue fazer login
    Dado o usuário inválido
    Quando tenta fazer login
    Então continua na página de login
