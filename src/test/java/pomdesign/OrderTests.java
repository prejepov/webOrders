package pomdesign;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AllOrdersPage;
import pages.AllProductsPage;
import pages.OrderPage;
import pages.WebOrdersLoginPage;

public class OrderTests {

	WebDriver driver;
	WebOrdersLoginPage loginPage;
	AllOrdersPage allOrdersLoginPage;
	AllProductsPage allProductsPage;
	OrderPage orderPage;
	Faker faker;

	String userName = "Tester";
	String password = "test";

	@BeforeClass
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void setUpApplication() {

		driver.get("http://secure.smartbearsoftware.com/samples/" + "TestComplete12/WebOrders/Login.aspx");

		loginPage = new WebOrdersLoginPage(driver);
		allOrdersLoginPage = new AllOrdersPage(driver);
		allProductsPage = new AllProductsPage(driver);
		orderPage = new OrderPage(driver);
		faker = new Faker();
	}
	
	@Test
	public void orderSubmit() throws InterruptedException {
		
		loginPage.login(userName, password);
		allOrdersLoginPage.orderLink.click();
		
		//select first selected option "MyMoney"
		Select select = new Select(orderPage.productDropDown);
		select.selectByValue("FamilyAlbum");
		
		//entering quantity  = "10"
		orderPage.quantity.clear();
		Thread.sleep(1000);
		orderPage.quantity.sendKeys("10");
		
		//enter price per unit = "20"
		orderPage.pricePerUnit.clear();
		orderPage.pricePerUnit.sendKeys("20");
		
		// enter customer name "Online9 Houston"
		orderPage.customerName.clear();
		orderPage.customerName.sendKeys("Online9 Houston");
		
		//enter street "Gessner Rd"
		orderPage.street.clear();
		orderPage.street.sendKeys("Gessner Rd");
		
		//enter city Houston
		orderPage.city.sendKeys("Houston");
		
		//enter zip 77064
		orderPage.zip.clear();
		orderPage.zip.sendKeys("77064");
		
		//select card type
		
//		Select selectCardType = new Select(orderPage.cardType);
//		selectCardType.deselectByVisibleText("MasterCard");
		
		orderPage.cardType.click();
		
		//enter card number
		orderPage.cardNum.sendKeys(faker.finance().creditCard().replaceAll("-", ""));
		
		//enter expDate
		orderPage.expDate.sendKeys("02/22");
		
		//click process button
		orderPage.processButton.click();
		
		//click view all orders
		allOrdersLoginPage.viewAllOrdersLink.click();
		
		String exp = orderPage.orderName.getText();
		
		String act = "Online9 Houston";
		
		assertEquals(act, exp);
	
		
		

	}

}
