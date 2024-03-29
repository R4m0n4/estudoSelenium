package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import page.classes.HomeAmazon;
import page.classes.LoginAmazon;
import page.classes.PaginaProduto;
import page.classes.ResultadoBusca;
import page.classes.Utils;
import page.classes.MaisVendidos;


public class TestesAmazon {
	
	static WebDriver driver;
	static HomeAmazon home;
	static ResultadoBusca busca;
	static PaginaProduto produto;
	static MaisVendidos vendas;
	static SoftAssert sa;
	static LoginAmazon login;
	static Utils util;
	String root = "C:/screenshots/";
	
	@Test
	public void entrarPaginaProduto() {
		home.pesquisarProduto("Cole��o Harry Potter - 7 volumes");
		busca.clicarPrimeiroProduto();
		
		String tituloEsperado = "Cole��o Harry Potter - 7 volumes";
		String tituloEncontrado = produto.getTituloProduto();
		
		assertEquals(tituloEsperado, tituloEncontrado);
	}
	
	@Test
	public void MaisVendidos() {
		util.setDir(root+"nadaqexiste");
		home.clicarMaisVendidos();
		util.screenshot();
		String texto = vendas.getTextoDepartamento(5);
		assertEquals("Brinquedos e Jogos", texto);	
	}
	
	@Test
	public void validarDepartamentos() {
		home.clicarMaisVendidos();
		List<String> departamentos = vendas.getNomesDepartamentos();
		
		for (int i = 0; i < departamentos.size(); i++) {
			
			String departamento = departamentos.get(i);
			vendas.clickDepartamentoByTitulo(departamento);
			String titulo = vendas.getTituloDepartamento();
			sa.assertEquals(departamento, titulo);
			vendas.voltarParaHome();
			home.clicarMaisVendidos();
		}
		sa.assertAll();
	}
		
		
	@Test
	public void aplicacativosDispositivos() throws InterruptedException {
		home.irAteContasEListas();
		String textoEncontrado= home.pegarTextoAplicativosDispositivo();
		sa.assertEquals("Seus aplicativos e dispositivos", textoEncontrado);
		home.clicarAplicativosDispositivo();
		String textoLogin = login.pegarTextoLogin();
		sa.assertEquals("Fazer login", textoLogin);
		
		Thread.sleep(3000);
		sa.assertAll();
		
	}
	
	
		
	
	
	@BeforeMethod
	public void beforeMethod() {
	
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false); 
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.addArguments("--start-maximized");
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		home = new HomeAmazon(driver);
		busca = new ResultadoBusca(driver);
		produto = new PaginaProduto(driver);
		vendas = new MaisVendidos(driver);
		sa = new SoftAssert();
		login = new LoginAmazon(driver);
		util = new Utils(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http:\\www.amazon.com.br");
	}
	
@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	
	
	
}
