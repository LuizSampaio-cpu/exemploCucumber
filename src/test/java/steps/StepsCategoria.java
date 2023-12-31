package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;




import java.util.List;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class StepsCategoria{

	WebDriver driver = new ChromeDriver();
	String url = "https://portaldeservicos.budibase.app/embed/portaldeservicos";
	private List<WebElement> listaCategorias;
	
	

	public void before() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		Duration duration = Duration.ofSeconds(15);
		driver.manage().timeouts().implicitlyWait(duration);
	}

	@Dado("que eu estou na página inicial do portal {string}")
	public void que_eu_estou_na_página_inicial_do_portal(String url) {
		driver.get(url);
		throw new io.cucumber.java.PendingException();

	}

	@Quando("buscar por {string}")
	public void clicar_em_categoria(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
		throw new io.cucumber.java.PendingException();
		
	}

	@Então("eu devo ver uma lista de {string}")
	public void eu_devo_ver_uma_lista_de_categorias_disponíveis(String tipoLista) {
		listaCategorias = driver.findElements(By.xpath("//div[contains(text(),'Nome')]"));
		for (WebElement categoria : listaCategorias) {
            String nomeCategoria = categoria.getText();
            System.out.println("Nome da Categoria: " + nomeCategoria);
            throw new io.cucumber.java.PendingException();
		
		}
	}
}
