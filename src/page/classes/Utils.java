package page.classes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utils {

	WebDriver driver;
	String dir;
	
	public Utils(WebDriver driver) {
		this.driver = driver;
	}
	
	public Utils() {
	}

	public void screenshot() {
		String nomeArquivo = dataAtual() + ".png";
		File imagem = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			File diretorio = new File(dir);
			diretorio.mkdirs();
			FileHandler.copy(imagem, new File(diretorio+ "\\" + nomeArquivo));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private String dataAtual() {
		Date date = new Date();
		SimpleDateFormat dots = new SimpleDateFormat("dd.MM.yyyy-HH.mm.ss");
		return dots.format(date);
	}
	
	public void setDir(String dir) {
		this.dir = dir;
	}
}
