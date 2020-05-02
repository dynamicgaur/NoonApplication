package TestFiles;

	import org.testng.Assert;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;
	import PageFiles.HomePage;
	import PageFiles.LoginPage;
	import TestBase.BaseMain;

	public class LoginTest extends BaseMain{
		LoginPage lp;
	    HomePage hp;



	   @BeforeMethod
	    public void initialise()
	    {
	        browserInitialise();
	        lp=new LoginPage();
	        hp=new HomePage(this.driver);
	    }

	    @Test(priority=1)
	    public void loginLogo()
	    {
	       // extentTest=extent.createTest("loginlogo");
	       extentTest=extent.startTest("loginLogo");
	        Assert.assertTrue(lp.logo.isDisplayed());
	    }

	    @Test(priority=2)
	    public void verifyForgotPassword()

	    {
	       // extentTest=extent.createTest("verifyForgotPassword");
	        extentTest=extent.startTest("verifyForgotPassword");
	        Assert.assertTrue(lp.forgotPassword.isDisplayed());
	    }

	    @Test(priority=3)
	    public void loginApplication()
	    {
	        //extentTest = extent.createTest("loginApplication");
	        extentTest=extent.startTest("loginApplication");
	        lp.login();
	        Assert.assertTrue(hp.pageTitle.isDisplayed());
	    }


	}

