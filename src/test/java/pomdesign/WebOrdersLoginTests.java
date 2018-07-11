package pomdesign;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.WebOrdersLoginPage;

public class WebOrdersLoginTests {

	WebDriver driver;

	String userName = "Tester";
	String invalidUserName = "Tester1";
	String password = "test";

	@BeforeClass // runs once for all tests
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.manage().window().fullscreen();
	}

	@Test(priority = 2)
	public void positiveLoginTest() {

		driver.get("http://secure.smartbearsoftware.com/samples/" + "TestComplete12/WebOrders/Login.aspx");

		WebOrdersLoginPage loginPage = new WebOrdersLoginPage(driver);

		loginPage.userName.sendKeys("Tester");
		loginPage.password.sendKeys("test");
		loginPage.loginButton.click();

	}

	@Test(priority = 1)
	public void invalidLoginTest() {

		driver.get("http://secure.smartbearsoftware.com/samples/" + "TestComplete12/WebOrders/Login.aspx");

		WebOrdersLoginPage loginPage = new WebOrdersLoginPage(driver);

		loginPage.userName.sendKeys(invalidUserName);
		loginPage.password.sendKeys(password);
		loginPage.loginButton.click();

		String errMsg = loginPage.invalidUserNameErrMessage.getText();

		assertEquals(errMsg, "Invalid Login or Password.");

	}
	
	@AfterClass
	public void tearUp() {
		driver.quit();
	}
}