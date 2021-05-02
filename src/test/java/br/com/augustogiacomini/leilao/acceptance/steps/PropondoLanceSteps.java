package br.com.augustogiacomini.leilao.acceptance.steps;

import br.com.augustogiacomini.leilao.model.Lance;
import br.com.augustogiacomini.leilao.model.Leilao;
import br.com.augustogiacomini.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Então;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropondoLanceSteps {

    private Lance lance;

    private Leilao leilao;

    private ArrayList<Lance> lances;

    @Before
    public void setup() {
        this.lances = new ArrayList<>();
        this.leilao = new Leilao("Tablet XPTO");
    }

    @Dado("um lance válido")
    public void dado_um_lance_válido() {
        Usuario usuario = new Usuario("fulano");
        lance = new Lance(usuario, BigDecimal.TEN);
    }

    @Quando("propõe ao leilão")
    public void quando_propoe_o_lance() {
        leilao.propoe(lance);
    }
    @Então("o lance é aceito")
    public void então_o_lance_é_aceito() {
        assertEquals(1, leilao.getLances().size());
        assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
    }


    @Dado("um lance de {double} reais do usuário {string}")
    public void um_lance_de_reais_do_usuário_fulano(Double valor, String nomeUsuario) {
        Lance lance = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));
        lances.add(lance);
    }

    @Quando("propõe vários lances ao leilão")
    public void propõe_vários_lances_ao_leilão() {
        lances.forEach(lance -> leilao.propoe(lance));
    }

    @Então("os lances são aceitos")
    public void os_lances_são_aceitos() {
        assertEquals(this.lances.size(), leilao.getLances().size());
        assertEquals(this.lances.get(0).getValor(), leilao.getLances().get(0).getValor());
        assertEquals(this.lances.get(1).getValor(), leilao.getLances().get(1).getValor());
    }


    @Dado("um lance inválido de {double} reais do usuário {string}")
    public void um_lance_inválido_de_reais(Double valor, String nomeUsuario) {
        this.lance = new Lance(new BigDecimal(valor));
    }

    @Então("o lance não é aceito")
    public void o_lance_não_é_aceito() {
        assertEquals(0, leilao.getLances().size());
    }

    @Dado("dois lances")
    public void dois_lances(DataTable dataTable) {
        List<Map<String, String>> valores = dataTable.asMaps();

        valores.forEach(map -> {
            String valor = map.get("valor");
            String nomeUsuario = map.get("nomeUsuario");

            Lance lance = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));
            lances.add(lance);
        });
    }

    @Então("o segundo lances não é aceito")
    public void o_segundo_lances_não_é_aceito() {
        assertEquals(1, leilao.getLances().size());
        assertEquals(this.lances.get(0).getValor(), leilao.getLances().get(0).getValor());
    }

}
