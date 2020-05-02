package PageFiles;
	
	import org.openqa.selenium.ElementNotVisibleException;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import TestBase.BaseMain;

	public class SearchPage extends BaseMain {



	       @FindBy(css=".jsx-3152181095.productContainer")
	        public WebElement productList;

	    @FindBy(css=".icon.icon-grid-o ")
	    public WebElement gridOption;

	    @FindBy(css=".jsx-4246926475.container div:nth-child(1) div:nth-child(2) button:nth-child(1)")
	    public WebElement sortBy;

	    @FindBy(css=".jsx-4246926475.container div:nth-child(2) div:nth-child(2) button:nth-child(1)")
	    public WebElement displayBy;

	    @FindBy(css=".jsx-1833788615.ctaContainer .jsx-1833788615.btnWishlist ")
	    public WebElement addToWishList;

	    @FindBy(css=".jsx-1833788615.ctaContainer .jsx-1833788615.btnATC")
	    public WebElement addToCart;

	    @FindBy(xpath="//a[@href='/cart#wishlist']")
	    public WebElement wishListIcon;


	    public SearchPage()
	    {
	        PageFactory.initElements(driver, this);
	    }


	public void clickToCart()
	{
	    addToCart.click();
	}

	public Boolean searchResultsSeen() {
	    try {

	        if (productList.isDisplayed())
	            return true;

	        else return false;

	    } catch (ElementNotVisibleException e) {
	        System.out.println("Product list not seen ");
	        e.printStackTrace();
	        return false;
	    }

	}




	}

