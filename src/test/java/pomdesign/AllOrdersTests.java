package pomdesign;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AllOrdersPage;
import pages.WebOrdersLoginPage;

public class AllOrdersTests {

	WebDriver driver;
	WebOrdersLoginPage loginPage;
	AllOrdersPage allOrdersLoginPage;
	
	String userName = "Tester";
	String password = "test";

	@BeforeClass
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void setUpApplication() {
		
		driver.get("http://secure.smartbearsoftware.com/samples/" 
				+ "TestComplete12/WebOrders/Login.aspx");
		
		loginPage = new WebOrdersLoginPage(driver);
		
	}

	@Test(description = "Verify labels and tab links are displayed")
	public void labelsVerification() {
		
		assertEquals(driver.getTitle(),"Web Orders Login", 
				"Login page is not displayed application is down");
		
//		loginPage.userName.sendKeys(userName);
//		loginPage.password.sendKeys(password);
//		loginPage.loginButton.click();
		
		loginPage.login(userName, password);
		
		allOrdersLoginPage = new  AllOrdersPage(driver);
		
		assertTrue(allOrdersLoginPage.webOrders.isDisplayed(), "Web Orders is not displayed");
		assertTrue(allOrdersLoginPage.listOfAllOrders.isDisplayed(), "List of Orders is not displayed");
		assertEquals(allOrdersLoginPage.welcomeMsg.getText().replace(" | Logout", ""), "Welcome, " + userName + "!");
		assertTrue(allOrdersLoginPage.viewAllOrdersLink.isDisplayed(), "All Orders link is not displayed");
		assertTrue(allOrdersLoginPage.viewAllProductsLink.isDisplayed(), "All products link is not displayed" );
		assertTrue(allOrdersLoginPage.orderLink.isDisplayed(), "Orders link is not displayed");
	}
	
	@AfterMethod
	public void logout() {
		
		allOrdersLoginPage.logout();
		
		
	}
}
