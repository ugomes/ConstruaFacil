package webTests;

import cucumber.api.PendingException;
import cucumber.api.java.pt.*;

public class pesquisarCursoCS {
    @Dado("^que acesso o site da Iterasys$")
    public void queAcessoOSiteDaIterasys() {
    }

    @Quando("^pesquiso por \"([^\"]*)\"$")
    public void pesquisoPor(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @E("^pressiono a tecla ENTER$")
    public void pressionoATeclaENTER() {
    }

    @Entao("^vejo a lista de resultados para o curso \"([^\"]*)\"$")
    public void vejoAListaDeResultadosParaOCurso(String arg0)  {

    }

    @Quando("^clico no nome do curso$")
    public void clicoNoNomeDoCurso() {
    }

    @Entao("^confirmo o nome do curso \"([^\"]*)\" e o preco \"([^\"]*)\"$")
    public void confirmoONomeDoCursoEOPreco(String arg0, String arg1)  {

        
    }
}
