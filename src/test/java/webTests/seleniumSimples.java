// 1 - Pacote

package webTests;
 // 2-  Bibliotecas
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

// 3 - Classes




public class seleniumSimples {
    // 3.1- Atributos

    WebDriver driver;    // declarar o objeto do selenium Driver

    // 3.2 Métodos e funções

    @Test
    public void consultarCurso(){
        System.setProperty("webdriver.chrome.driver","drivers/chrome/108/chromedriver.exe");
        // instancia o objeto driver como um controlador do Chrome
        driver = new ChromeDriver();

        // B- Realizar o teste

        driver.get("https://www.udemy.com/pt"); // Abre o site salvo
        
    }

}
