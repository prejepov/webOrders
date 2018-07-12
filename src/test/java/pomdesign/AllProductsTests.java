package pomdesign;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AllOrdersPage;
import pages.AllProductsPage;
import pages.WebOrdersLoginPage;

public class AllProductsTests {

	WebDriver driver;
	WebOrdersLoginPage loginPage;
	AllOrdersPage allOrdersLoginPage;
	AllProductsPage allProductsPage;

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

	}

	@Test
	public void labelsVerification() {

		loginPage.login(userName, password);
		allOrdersLoginPage.viewAllProductsLink.click();

		assertEquals(allProductsPage.listOfProductsText.getText(), "List of Products",
				"List of prduct text is " + "not displayed, the app is down");
	}

	@Test
	public void availableProductsTest() {

		loginPage.login(userName, password);
		allOrdersLoginPage.viewAllProductsLink.click();

		List<String> expProducts = Arrays.asList("MyMoney", "FamilyAlbum", "ScreenSaver");
		List<String> actProducts = new ArrayList<>();

		for (WebElement prdNames : allProductsPage.productNames) {
			actProducts.add(prdNames.getText());
		}

		assertEquals(actProducts, expProducts, "Product names do not match");

		for (WebElement prdRows : allProductsPage.productRows) {

			String[] prodData = prdRows.getText().split(" ");

			switch (prodData[0]) {
			case "MyMoney":
				assertEquals(prodData[1], "$100");
				assertEquals(prodData[2], "8%");
				break;
			case "FamilyAlbum":
				assertEquals(prodData[1], "$80");
				assertEquals(prodData[2], "15%");
				break;
			case "ScreenSaver":
				assertEquals(prodData[1], "$20");
				assertEquals(prodData[2], "10%");
				break;
			}

		}
	}

	@AfterMethod
	public void logout() {

		allOrdersLoginPage.logout();
	}
	

}
