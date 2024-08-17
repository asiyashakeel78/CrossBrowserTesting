package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	private WebDriver driver;
	
	@FindBy(id = "username")
	private WebElement usernameField;
	
	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(id = "submit")
	private WebElement loginField;
	
	//Constructor
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Actions
	
	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clicklogin() {
		loginField.click();		
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();		
	}

}
