import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import page.classes.HomeAmazon;
import page.classes.PaginaProduto;
import page.classes.ResultadoBusca;

public class Main {

	static WebDriver driver;
	static HomeAmazon home;
	static ResultadoBusca busca;
	static PaginaProduto produto;
	          
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver");
		
		//listaVenda(driver);
		
		//printNumeros();
		
		//listarBeneficiosAmazon(driver);
		
		//produtoAmazon(driver);
		//harryPotter(driver);
		exercicio2(driver);
		
	}
	
	public static void pesquisaGoogle(WebDriver driver, String pesquisa) throws InterruptedException {
		driver.get("http://www.google.com");
		
		WebElement caixaDeTexto = driver.findElement(By.xpath("//input[@title='Pesquisar']"));
		
		caixaDeTexto.sendKeys(pesquisa);
		
		WebElement background = driver.findElement(By.id("main"));
		
		background.click();
		
		WebElement botaoPesquisar = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
		
		botaoPesquisar.click();
		
		Thread.sleep(3000);
		
		driver.close();
		
		//caixaDeTexto.sendKeys(Keys.ENTER);
	}

	@Test
	public static void produtoAmazon(WebDriver driver) {
		driver = new FirefoxDriver();
		home = new HomeAmazon(driver);
		busca = new ResultadoBusca(driver);
		produto = new PaginaProduto(driver);
		
		driver.get("http:\\www.amazon.com.br");
		home.pesquisarProduto("Coleção Harry Potter - 7 volumes");
		busca.clicarPrimeiroProduto();
		
		String tituloEsperado = "Coleção Harry Potter - 7 volumes";
		String tituloEncontrado = produto.getTituloProduto();
		
		assertEquals(tituloEsperado, tituloEncontrado);
		
		
		/*
		 * JEITO ANTIGO 
		
		driver.get("http:\\www.amazon.com.br");
		WebElement caixaDeTexto = driver.findElement(By.id("twotabsearchtextbox"));		
	    caixaDeTexto.sendKeys("Coleção Harry Potter - 7 volumes");

		WebElement botaoLupa = driver.findElement(By.xpath("//div/input[@type='submit']"));
		botaoLupa.click();
		
		WebElement link = driver.findElement(By.xpath("//span[text()='Coleção Harry Potter - 7 volumes']"));
		link.click();
		WebElement titulo = driver.findElement(By.id("productTitle"));
		
		String tituloEncontrado=titulo.getText();
				
		driver.close();
		
		System.out.println(tituloEncontrado);*/

	}
	
	public static ArrayList<Integer> listanumeros(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		lista.add(156);
		lista.add(1);
		lista.add(4);
		return lista;
		
	}
	
	public static void printNumeros() {
		ArrayList<Integer> lista= listanumeros();
		for (Integer i : lista) {
			System.out.println(i);
		}
		
		int num=lista.get(0);
		System.out.println(num);
	}
	
	public static void listarBeneficiosAmazon(WebDriver driver) {
		driver = new FirefoxDriver();
		
		driver.get("http://www.amazon.com.br");
		
		List<WebElement> beneficios = driver.findElements(By.xpath("(//ul)[1]//span[@class='a-list-item']//img"));
			
		for (WebElement imagem : beneficios) {
			System.out.println(imagem.getAttribute("alt"));
		}
		
		driver.close();
	}
	
	
	public static void listaVenda(WebDriver driver) {
		driver = new FirefoxDriver();
		
		driver.get("http://www.amazon.com.br");
		WebElement maisVendidos = driver.findElement(By.xpath("//a[@tabindex='47']"));
		maisVendidos.click();
		
		List<WebElement> departamentos= driver.findElements(By.xpath("//ul[@id='zg_browseRoot']/ul/li/a"));
		
		String titulo = departamentos.get(5).getText();
		
		departamentos.get(5).click();
		
		try {
			Thread.sleep(3000);
		} 
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		driver.close();
		System.out.println(titulo);
		
	}
	
	
	public static void harryPotter(WebDriver driver) {
		driver = new FirefoxDriver();
		home = new HomeAmazon(driver);
		busca = new ResultadoBusca(driver);
		
		driver.get("http://www.amazon.com.br");
		
		//WebElement  caixaBusca= driver.findElement(By.id("twotabsearchtextbox"));
		//caixaBusca.sendKeys("Coleção Harry Potter - 7 volumes");
		//WebElement busca= driver.findElement(By.xpath("//input[@value='Ir']"));
		//busca.click();
		//List<WebElement> titulos= driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		//for (WebElement titulo : titulos)
		//	 System.out.println(titulo.getText());
		 
		home.pesquisarProduto("Coleção Harry Potter - 7 volumes");
		busca.imprimirTitulos();
		driver.close();
	}
	
	public static void exercicio2(WebDriver driver) {
		driver = new FirefoxDriver();
		home = new HomeAmazon(driver);
		busca = new ResultadoBusca(driver);
		produto = new PaginaProduto(driver);
		
		driver.get("http:\\www.amazon.com.br");
		home.pesquisarProduto("Coleção Harry Potter - 7 volumes");
		busca.imprimirTitulos();
	}
}
