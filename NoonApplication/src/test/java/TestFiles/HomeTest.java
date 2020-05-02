package TestFiles;

	import org.testng.Assert;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;
     //import com.aventstack.extentreports.ExtentTest;
     import PageFiles.HomePage;
	import PageFiles.LoginPage;
	import TestBase.BaseMain;

	public class HomeTest extends BaseMain{
		
		HomePage hp;
	    LoginPage lp;


	    @BeforeMethod
	    public void initialise() {
	        browserInitialise();
	        lp = new LoginPage();
	        hp = new HomePage(this.driver);
	    }

	    @Test(priority = 1)
	    public void verifyHome() {
	        SoftAssert softassert = new SoftAssert();
	        //extentTest = extent.createTest("verifyHome");
	        extentTest=extent.startTest("verifyHome");
	        lp.login();
	        softassert.assertTrue(hp.pageTitle.isDisplayed());
	        softassert.assertTrue(hp.cartIcon.isDisplayed());
	        softassert.assertTrue(hp.allCategory.isDisplayed());
	        softassert.assertFalse(hp.searchBar.isDisplayed());
	        softassert.assertAll();
	    }

	    @Test(priority = 2)
	    public void search() {

	       // extentTest = extent.createTest("search");
	        extentTest=extent.startTest("search");
	    	
	        lp.login();
	        hp.enterSearchTerm();
	    }

	    //@Test(priority=3)
	    // public void selectCategoryFilter()
	  

	}

