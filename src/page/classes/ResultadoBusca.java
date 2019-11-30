package page.classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultadoBusca {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
	private List<WebElement> listaTitulos;
	
	public ResultadoBusca(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ResultadoBusca() {
	}
	
	public void imprimirTitulos() {
		for (WebElement titulo : listaTitulos)
			 System.out.println(titulo.getText());
	}
	
	public void clicarPrimeiroProduto() {
		listaTitulos.get(0).click();
	}
	
	
	
}
