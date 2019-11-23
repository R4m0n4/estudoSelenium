package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import page.classes.HomeAmazon;
import page.classes.PaginaProduto;
import page.classes.ResultadoBusca;
import page.classes.MaisVendidos;

public class TestesAmazon {
	
	static WebDriver driver;
	static HomeAmazon home;
	static ResultadoBusca busca;
	static PaginaProduto produto;
	static MaisVendidos vendas;
	static SoftAssert sa;
	
	
	@Test
	public void entrarPaginaProduto() {
		home.pesquisarProduto("Coleção Harry Potter - 7 volumes");
		busca.clicarPrimeiroProduto();
		
		String tituloEsperado = "Coleção Harry Potter - 7 volumes";
		String tituloEncontrado = produto.getTituloProduto();
		
		assertEquals(tituloEsperado, tituloEncontrado);
	}
	
	@Test
	public void MaisVendidos() {
		home.clicarMaisVendidos();
		String texto = vendas.getTextoDepartamento(5);
		assertEquals("Brinquedos e Jogos", texto);	
	}
	
	@Test
	public void validarDepartamentos() {
		home.clicarMaisVendidos();
		List<WebElement> departamentos = vendas.getDepartamentos();
		
		/*for (int i = 0; i < departamentos.size(); i++) {
			
			String texto = vendas.getTextoDepartamento(i);
			System.out.println("Texto: " + texto);
			try {Thread.sleep(5000);}catch(Exception e){}
			vendas.clicarDepartamentos(i);
			System.out.println("Clicou no departamento");
			String titulo = vendas.getTituloDepartamento();
			System.out.println("Título: " + titulo);
			sa.assertEquals(texto,titulo);
			driver.get("http:\\www.amazon.com.br");
			home.clicarMaisVendidos();
		}*/
		for (WebElement departamento : departamentos) {
			departamento.click();
			driver.get("http:\\www.amazon.com.br");
			home.clicarMaisVendidos();
		}
		
		sa.assertAll();
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
	
		driver = new FirefoxDriver();
		home = new HomeAmazon(driver);
		busca = new ResultadoBusca(driver);
		produto = new PaginaProduto(driver);
		vendas = new MaisVendidos(driver);
		sa = new SoftAssert();
		
		driver.get("http:\\www.amazon.com.br");
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
