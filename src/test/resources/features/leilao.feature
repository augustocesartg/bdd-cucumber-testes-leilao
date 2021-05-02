# language: pt

@leilao
Funcionalidade: Cadastrando um leilão

  Contexto:
    Dado o usuário logado

  Cenário: Um usuário logado pode cadastrar um leilão
    Quando acessa a página de novo leilão
    E preenche o formulário com dados válidos
    Então volta para a página de leilões
    E o novo leilão aparece na tabela
