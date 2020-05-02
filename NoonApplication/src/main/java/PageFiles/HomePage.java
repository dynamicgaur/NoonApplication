package PageFiles;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

	public class HomePage {

		 @FindBy(xpath="//a[@id='title_home']")
		    public WebElement pageTitle;

		    @FindBy(xpath="//input[contains(@id,'searchBar')]")
		    public WebElement searchBar;

		    @FindBy(css = ".icon.icon-cart-o.cartIcon")
		    public WebElement cartIcon;

		    @FindBy(xpath="//button[contains(text(),'All Categories')]")
		    public WebElement allCategory;

		    WebDriver driver;

		public HomePage(WebDriver driver)
		{
		    this.driver=driver;
		    PageFactory.initElements(driver, this);
		}


		    public void enterSearchTerm()
		    {
		            Assert.assertTrue(searchBar.isDisplayed());
		            searchBar.sendKeys("Apple Laptop");
		            searchBar.sendKeys(Keys.ENTER);

		    }



	}

