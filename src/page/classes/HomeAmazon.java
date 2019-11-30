package page.classes;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeAmazon {

	WebDriver driver;
	
	Actions action; 
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement caixaDePesquisa;
	
	@FindBy(xpath="//input[@value='Ir']")
	private WebElement lupa;
	
	@FindBy(xpath="//a[text()='Mais Vendidos']")
	private WebElement maisVendidos;
	
	@FindBy(id="nav-link-accountList") 
	private WebElement menuContasEListas;
	
	@FindBy(xpath="//div[@id='nav-al-your-account']//a")
	private List<WebElement> contasElistas;

	
	public HomeAmazon(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomeAmazon() {
	}
	
	public void pesquisarProduto(String produto) {
		caixaDePesquisa.sendKeys(produto);
		lupa.click();
	}
	
	public void clicarMaisVendidos() {
		maisVendidos.click();
	}
	
	public void irAteContasEListas() {
		action = new Actions(driver); 
		action.moveToElement(menuContasEListas).perform();
	}
	
	public void clicarAplicativosDispositivo() {
		int indice = contasElistas.size()-1;
		contasElistas.get(indice).click();
	}
	
	public String pegarTextoAplicativosDispositivo() {
		int indice = contasElistas.size()-1;
		return contasElistas.get(indice).getText();	
		
	}
	
}
