package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAmazon {

	WebDriver driver;
	public LoginAmazon(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginAmazon() {
	}
	
	
	@FindBy(xpath ="//h1[contains(text(),'Fazer login')]")
	private WebElement headerLogin;
	
	
	public String pegarTextoLogin() {
		return headerLogin.getText();	
	}
	
	
	
}
