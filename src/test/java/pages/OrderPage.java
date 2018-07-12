package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	
	public OrderPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
	public WebElement productDropDown;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
	public WebElement quantity;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
	public WebElement pricePerUnit;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
	public WebElement customerName;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
	public WebElement street;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
	public WebElement city;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
	public WebElement zip;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
	public WebElement cardType;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
	public WebElement cardNum;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
	public WebElement expDate;
	
	@FindBy(linkText = "Process")
	public WebElement processButton;
	
	@FindBy(xpath = "//table[@class='SampleTable']/tbody/tr/td[2]")
	public WebElement orderName;

}
