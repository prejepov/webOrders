package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOrdersLoginPage {

	public WebOrdersLoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id="ctl00_MainContent_username")
	public WebElement userName;

	@FindBy(id="ctl00_MainContent_password")
	public WebElement password;

	@FindBy(id="ctl00_MainContent_login_button")
	public WebElement loginButton;
	
	@FindBy(id="ctl00_MainContent_status")
	public WebElement invalidUserNameErrMessage;
	
	public void login(String userName, String password) {
		 
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		loginButton.click();
		
		
	}

}
