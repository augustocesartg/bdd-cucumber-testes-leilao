package br.com.augustogiacomini.leilao.acceptance.steps;

import br.com.augustogiacomini.leilao.e2e.pages.Browser;
import br.com.augustogiacomini.leilao.e2e.pages.LeiloesPage;
import br.com.augustogiacomini.leilao.e2e.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private Browser browser;

    private LoginPage loginPage;

    private LeiloesPage leiloesPage;

    @Dado("o usuário válido")
    public void o_usuário_válido() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
    }

    @Quando("realiza login")
    public void realiza_login() {
        leiloesPage = this.loginPage.realizaLoginComo("fulano", "pass");
    }

    @Então("é direcionado para a página de leilões")
    public void é_direcionado_para_a_página_de_leilões() {
        assertTrue(leiloesPage.estaNaPaginaDeLeiloes());
        browser.clean();
    }


    @Dado("o usuário inválido")
    public void o_usuário_inválido() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
    }

    @Quando("tenta fazer login")
    public void tenta_fazer_login() {
        leiloesPage = this.loginPage.realizaLoginComo("invalido", "invalida");
    }

    @Então("continua na página de login")
    public void continua_na_página_de_login() {
        assertTrue(loginPage.estaNaPaginaDeLoginComErro());
        browser.clean();
    }
}
