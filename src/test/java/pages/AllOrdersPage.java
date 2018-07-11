package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllOrdersPage {
	
	public AllOrdersPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[.='Web Orders']")
	public WebElement webOrders;
	
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/table/tbody/tr/td[2]/div[2]/h2")
	public WebElement listOfAllOrders;
	
	@FindBy(css = ".login_info")
	public WebElement welcomeMsg;
	
	@FindBy(linkText = "View all orders")
	public WebElement viewAllOrdersLink;
	
	@FindBy(linkText = "View all products")
	public WebElement viewAllProductsLink;
	
	@FindBy(linkText = "Order")
	public WebElement orderLink;
	
	@FindBy(linkText="Logout")
	public WebElement logoutLink;
	
	public void logout() {
		logoutLink.click();
	}
	
	
}
