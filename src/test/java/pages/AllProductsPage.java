package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProductsPage {
	
	public AllProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/table/tbody/tr/td[2]/div[2]/h2")
	public WebElement listOfProductsText;
	
	@FindBy(xpath = "//table[@class='ProductsTable']/tbody/tr/td[1]")
	public List<WebElement> productNames;
	
	@FindBy(xpath = "//table[@class='ProductsTable']/tbody/tr")
	public List<WebElement> productRows;

}
