package TestFiles;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;
	import PageFiles.HomePage;
	import PageFiles.LoginPage;
	import PageFiles.SearchPage;
	import TestBase.BaseMain;

	public class SearchTest extends BaseMain {

		WebDriverWait wait = new WebDriverWait(driver, 10);

	    HomePage hp;
	    LoginPage lp;
	    SearchPage sp;

	    @BeforeTest
	    public void initialise() {
	        lp = new LoginPage();
	        hp = new HomePage(this.driver);
	        sp = new SearchPage();
	    }

	    @Test(priority = 1)
	    public void verifySearchPage() {
	        //extentTest = extent.createTest("verifySearchPage");
	        extentTest=extent.startTest("verifySearchPage");
	        SoftAssert softassert = new SoftAssert();

	        lp.login();
	        hp.enterSearchTerm();
	        wait.until(ExpectedConditions.visibilityOf(sp.productList));
	        softassert.assertTrue(sp.searchResultsSeen(), "Search Results not seen");
	        softassert.assertTrue(sp.addToCart.isDisplayed());
	        softassert.assertTrue(sp.gridOption.isDisplayed());
	    }

	    @Test(priority = 2)
	    public void addItemToCart() {
	        //extentTest = extent.createTest("addItemToCart");
	        extentTest=extent.startTest("addItemToCart");
	        SoftAssert softassert = new SoftAssert();
	        lp.login();
	        hp.enterSearchTerm();
	        wait.until(ExpectedConditions.visibilityOf(sp.productList));
	        sp.clickToCart();

	    }

	}
