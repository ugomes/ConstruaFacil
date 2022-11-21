
package webTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.Evidencias;
import utils.Logs;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class seleniumSimples {
    WebDriver driver;
    Evidencias evidencias;
    Logs logs;
    String dataHora = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());

    @BeforeClass
    public void antesDeTudo() throws IOException {
        logs = new Logs();
        logs.iniciarCSV(dataHora);
    }


    @BeforeMethod
    public void iniciar () {
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/107/chromedriver.exe");
        driver = new ChromeDriver();
        evidencias = new Evidencias();


    }

    @AfterTest
    public void finalizar(){
        driver.quit();

    }

    @Test
    public void consultarCurso() throws IOException {
        logs.registrarCSV("consultar Curso CTFL","Iniciou o Teste");
        driver.get("https://iterasys.com.br/pt/cursos");
        evidencias.print(driver, dataHora, "Passo 1 - Abriu o site");
        assertEquals("Todos cursos",driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h1[1]")).getText());
        evidencias.print(driver, dataHora, "Passo 2 - Verificou todos os cursos");
    }
    @Test
    public void consultarCursoCtfl() throws IOException {
        driver.get("https://iterasys.com.br/pt/cursos");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys("CTFL");
        evidencias.print (driver, dataHora, "Passo 3 - Digitou CTFL");
        logs.registrarCSV("consultar Curso CTFL","Verificou o preco");
        assertEquals(driver.findElement(By
                        .cssSelector("div.landing main.website-page:nth-child(3) section.content-list.website-component " +
                                "div.container.no-sidebar div.component-content div.list-content:nth-child(2) main.content-list-main " +
                                "a.no-link-style.content-card:nth-child(1) main:nth-child(2) div.content-card-infos div.content-card-infos-amount div.content-card-infos-amount-installments >" +
                                " p.amount"))
                .getText(),"R$ 251,92");
    }
}
