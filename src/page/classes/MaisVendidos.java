package page.classes;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MaisVendidos {
	WebDriver driver;

	public MaisVendidos(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public MaisVendidos() {
		super();
	}
	
	@FindBy (xpath="//ul[@id='zg_browseRoot']/ul/li")
	private List<WebElement> qualquerDepartamento;
	
	public String getTextoDepartamento(int indice) {
		String textoDepartamento = qualquerDepartamento.get(indice).getText();
		return textoDepartamento;
	}
	
	public void clicarDepartamentos(int indice) {
	
		qualquerDepartamento.get(indice).click();
		
	}
	
	@FindBy (xpath="//span[@class='category']")
	private WebElement titulo;
	
	public String getTituloDepartamento () {
		String tituloDepartamento = titulo.getText();
		return tituloDepartamento;
	}
	
	public List<WebElement> getDepartamentos(){
		return qualquerDepartamento;
		
	}
}
