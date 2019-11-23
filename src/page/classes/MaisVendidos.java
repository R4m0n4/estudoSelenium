package page.classes;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
	@FindBy (xpath="//a[@aria-label='Amazon.com.br']")
	private WebElement logoAmazon;
	
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
	
	public List<String> getNomesDepartamentos(){
		List<WebElement> departamentos = getDepartamentos();
		List<String> titulos = new ArrayList<String>();
		for (WebElement dep : departamentos) {
			titulos.add(dep.getText());
		}
		return titulos;
	}
	
	public void voltarParaHome() {
		logoAmazon.click();
	}
	
	public void clickDepartamentoByTitulo(String titulo) {
		WebElement departamento = driver.findElement(By.xpath("//a[text()='" + titulo + "']"));
		departamento.click();
	}
	
}
