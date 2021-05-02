package br.com.augustogiacomini.leilao.acceptance.steps;

import br.com.augustogiacomini.leilao.e2e.pages.AlterarLeilaoPage;
import br.com.augustogiacomini.leilao.e2e.pages.Browser;
import br.com.augustogiacomini.leilao.e2e.pages.LeiloesPage;
import br.com.augustogiacomini.leilao.e2e.pages.LoginPage;
import br.com.augustogiacomini.leilao.e2e.pages.NovoLeilaoPage;

import static org.junit.jupiter.api.Assertions.*;

public class LeilaoSteps implements io.cucumber.java8.Pt {

    private Browser browser;

    private LoginPage loginPage;

    private LeiloesPage leiloesPage;

    private NovoLeilaoPage novoLeilaoPage;

    private AlterarLeilaoPage alterarLeilaoPage;

    public LeilaoSteps() {
        Dado("o usuário logado", () -> {
            this.browser = new Browser();
            this.browser.seed();
            this.loginPage = this.browser.getLoginPage();
            this.leiloesPage = this.loginPage.realizaLoginComoFulano();
        });

        Quando("acessa a página de novo leilão", () ->
                this.novoLeilaoPage = this.leiloesPage.visitaPaginaParaCriarUmNovoLeilao());

        Quando("preenche o formulário com dados válidos", () ->
                this.leiloesPage = this.novoLeilaoPage.preencheForm("PC Novo", "1500", "02/05/2021"));

        Então("volta para a página de leilões", () -> assertTrue(leiloesPage.estaNaPaginaDeLeiloes()));

        Então("o novo leilão aparece na tabela", () -> {
            assertTrue(this.leiloesPage.existe("PC Novo", "1500", "02/05/2021"));
            this.browser.clean();
        });
    }

}
