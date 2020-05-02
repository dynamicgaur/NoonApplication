package PageFiles;

	import org.openqa.selenium.By;
	import org.openqa.selenium.ElementNotInteractableException;
	import org.openqa.selenium.ElementNotVisibleException;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Wait;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.BeforeClass;
	import TestBase.BaseMain;

	import static TestBase.BaseMain.driver;
	import static TestBase.BaseMain.prop;

	public class LoginPage extends BaseMain{

		@FindBy(xpath="//input[@id='tf_signin_email']")
	    public WebElement loginName;

	    @FindBy(xpath="//input[contains(@type,'password')]")
	    public WebElement loginPassword;

	    @FindBy(xpath = "//button[contains(@id,'btn_signin_signin')]")
	    public WebElement loginButton;

	    @FindBy(xpath="//a[text()='Forgot your password?']")
	    public WebElement forgotPassword;

	    @FindBy(id="logo")
	    public WebElement logo;



	    HomePage hp=new HomePage(this.driver);


	public LoginPage()
	{
	    System.out.println("Loginpage constructor");
	    PageFactory.initElements(driver,this);
	}


	    public void login()
	    {
	        //Here username and password from config.properties is inputted in Username and Password fields
	        try {
	            loginName.sendKeys(prop.getProperty("username"));
	            loginPassword.sendKeys(prop.getProperty("password"));
	            Assert.assertTrue(loginButton.isDisplayed());
	            loginButton.click();
	            WebDriverWait wait=new WebDriverWait(driver,30);
	            wait.until(ExpectedConditions.visibilityOf(hp.pageTitle));

	        }catch(ElementNotVisibleException e)
	        {
	            System.out.println("Element(s) could not be found");
	            e.printStackTrace();
	        }
	    }


	}
