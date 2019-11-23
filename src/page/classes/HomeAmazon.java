package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeAmazon {

	WebDriver driver;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement caixaDePesquisa;
	
	@FindBy(xpath="//input[@value='Ir']")
	private WebElement lupa;
	
	@FindBy(xpath="//a[text()='Mais Vendidos']")
	private WebElement maisVendidos;
	
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
}
