package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaProduto {
	WebDriver driver;

	public PaginaProduto(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public PaginaProduto() {	
	}
	
	@FindBy(id="productTitle")
	private WebElement tituloProduto;

	public String getTituloProduto(){
		String titulo = tituloProduto.getText();
		return titulo;
		
	
	}
}
